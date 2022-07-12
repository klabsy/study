#ifndef at24c02
#define at24c02
#include <intrins.h>
#define uchar unsigned char
#define uint unsigned int
uchar flag=0;						//标志,为1时改变上限值，为2时改变下限值
uchar a1,a2,a3,a0;
char upper;	
char lower;
sbit scl=P1^6;
sbit sda=P1^7;
sbit but1=P3^7;
sbit but2=P3^6;
sbit but3=P3^5;
sbit but4=P3^4;
sbit int_0=P3^2;

void init_delay(uint j) 				//开机动画时延
{
	uchar i=250;
	for(;j>0;j--)
	{
		while(--i);
		i=249;
		while(--i);
		i=250;
	}
}

void delay5us()					//延时5us
{
	_nop_();
	_nop_();
	_nop_();
	_nop_();
	_nop_();
}

void delay(uint z)			   //延时10us
{	
	uchar x,y;
	for(x=z;x>0;x--)
	{
		for(y=110;y>0;y--);
	}
}

void delay02s()					//按钮绑定，用于判断哪个按钮被按下
 {
	uchar i,j,k;
	for(i=20;i>0;i--)
		for(j=20;j>0;j--)
			for(k=100;k>0;k--)
			{
				if(!but1)
				{
					a0=1;
				}
				if(!but2)
				{
					 a1=1;
				}
				if(!but3)
				{
					 a2=1;
				}
				if(!but4)
				{
					 a3=1;
				}
			}
}


/* 开机显示动画 */
void init_show()								//开机动画
{					
	uchar i=0;									//计数，用于LCD屏幕后移
	init1602();
	write_ad_str(0x80,"Welcome to AAUCS");
	write_ad_str(0x80+0x40,"N0.02");
	delay(1000);
	while(i<16)
	{
		write_com(0x1c); 						//整个屏幕左移
		init_delay(100); 						//延时，滚动没那么快
		i++;
	}
}
/* 初始功能模块格式显示 */
void init_fuction()								//初始化，基本思想先固定光标位置，
{												//后写字符，write_ad_data()函数
	init1602();									//实现光标移动和写字符两种功能
	write_ad_data(0x80+0x40,'T');				//显示T
	write_ad_data(0x80+0x41,':');				//显示：
	write_ad_data(0x80+0x45,'.');				//显示. 
	write_ad_data(0x80+0x47,0xdf);				//显示空 
	write_ad_data(0x80+0x48,'C');				//显示C 
	write_ad_data(0x80+0x4a,'F');				//显示F
	write_ad_data(0x80+0x4b,'A');				//显示A 
	write_ad_data(0x80+0x4c,'N');				//显示N 
	write_ad_data(0x80+0x4d,':');				//显示：
	write_ad_data(0x80,'H');					//显示H 
	write_ad_data(0x81,':');					//显示：
	write_ad_data(0x85,0xdf);					//显示空 
	write_ad_data(0x86,0x43);					//显示空
	write_ad_data(0x89,'L');					//显示L 
	write_ad_data(0x8a,':');					//显示： 
	write_ad_data(0x8e,0xdf);					//显示空
	write_ad_data(0x8f,0x43);					//显示空
}

void start()					//起始信号
{
	sda=1;
	delay5us();
	scl=1;
	delay5us();
	sda=0;
	delay5us();
	scl=0;						//拉低scl,占用scl准备发送数据
	delay5us();
}

void stop()						//终止信号
{ 
	sda=0;
	delay5us();
	scl=1;
	delay5us();
	sda=1;
}

bit recack()					//接收应答
{
	uchar upper = 0;
	while(sda)
	{
		if(++upper>200)		 	//等待超过200,视为无应答,发送停止信号
		{		
			scl=0;
			stop();
			return 0;
		}
	}										
		scl = 0;				//应答正常,拉低scl形成第9个时钟脉冲
		return 1;
}

void sendbyte(uchar dat)		//向iic发送一字节数据
{	 
	uchar i;
	for(i=0;i<8;i++)
	{
		if(dat&0x80)
		{		
			sda=1;
		}
		else
		{
			sda=0;
		}
		dat=dat<<1;
		scl=1;					//拉高scl,让从机接收sda
		delay5us();
		scl=0;					//占用scl,让sda允许改变
		delay5us();
	}
	scl=1;						//释放SCL和SDA
	delay5us();
	sda=1;
	delay5us();
}

char rcvbyte()					//从iic接收一字节数据
{
	uchar i;
	char dat;
	
	scl=0;						//在改变sda前先确保scl为低电平
	delay5us();
	sda=1;						//主机释放sda,以便从机可以改变sda
	delay5us();
	
	for(i=0;i<8;i++)
	{
		scl=1;					//拉高scl,接收从机发来的sda
		delay5us();
		dat<<=1;
		dat|=sda;
		scl=0;
		delay5us();				//拉低scl,让从机可以改变sda的电平
	}
	return dat;
}
/* 指定位置读取24c02的值 */
char read24c02(uchar add)   		//指定地址读操作
{
	char dat;
	start();
	sendbyte(0xa0);					//写入设备地址 最后一位为0代表主机要写入数据到从机
	recack();
	sendbyte(add);					//写入要读数据的地址
	recack();
	start();				
	sendbyte(0xa1);					//写入设备地址 最后一位为1代表主机要读从机数据
	recack();				   	
	dat=rcvbyte();					//保存读出的数据
	stop();							//结束读数据
	return dat;
}
/* 将dat值写入24c02 */
void write24c02(uchar add,char dat)		//指定地址写操作
{
	start();
	sendbyte(0xa0);					//写入设备地址
	recack();
	sendbyte(add);					//写入存放数据的地址
	recack();
	sendbyte(dat);					//写入数据
	recack();
	stop();					   		//结束写数据
}
/* 上限温度值显示 */
void show_h(char dat)									//基本思想：根据dat的数值判断光标位置以及写入何种数值
{
	if(dat>=100)													//是大于等于一百，需要3位数
	{
		write_ad_data(0x82,0x30+dat/100);				//取百位
		write_ad_data(0x83,0x30+dat/10%10);				//取十位
		write_ad_data(0x84,0x30+dat%10);				//取个位
	}
	if(dat>10&&dat<100)									//两位数字
	{
		write_ad_data(0x82,0xfe);						//补空位
		write_ad_data(0x83,0x30+dat/10);				//取十位
		write_ad_data(0x84,0x30+dat%10);				//取个位		
	}
	if(dat>=0&&dat<10)									//一位数字
	{
		write_ad_data(0x82,0xfe);						//补空位
		write_ad_data(0x83,0xfe);						//补空位
		write_ad_data(0x84,0x30+dat);					//只有一位数字，直接显示
	}									  	
	if(dat<0&&dat>-10)									//小于0.但是需要两位
	{	
		write_ad_data(0x82,'-');						//补负号
		write_ad_data(0x83,0xfe);						//补空位
		write_ad_data(0x84,0x30+(~dat+1));				//取反加1获得源码	
	}
	if(dat<=-10)		//小于0，总共需要三位
	{
		write_ad_data(0x82,'-');//补负号
		write_ad_data(0x83,0x30+(~dat+1)/10);			//取十位
		write_ad_data(0x84,0x30+(~dat+1)%10);			//取个位
	}	  
}
/* 下限温度值显示 */
void show_l(char dat)									//与上同理
{
	if(dat>=100)										//是大于等于一百
	{
		write_ad_data(0x8b,0x30+dat/100);
		write_ad_data(0x8c,0x30+dat/10%10);
		write_ad_data(0x8d,0x30+dat%10);
	}
	if(dat>10&&dat<100)
	{
		write_ad_data(0x8b,0xfe);
		write_ad_data(0x8c,0x30+dat/10);
		write_ad_data(0x8d,0x30+dat%10);		
	}
	if(dat>=0&&dat<10)
	{
		write_ad_data(0x8b,0xfe);
		write_ad_data(0x8c,0xfe);
		write_ad_data(0x8d,0x30+dat);
	}
	if(dat<0&&dat>-10)
	{	
		write_ad_data(0x8b,'-');
		write_ad_data(0x8c,0xfe);
		write_ad_data(0x8d,0x30+(~dat+1));	
	}
	if(dat<=-10)
	{
		write_ad_data(0x8b,'-');
		write_ad_data(0x8c,0x30+(~dat+1)/10);
		write_ad_data(0x8d,0x30+(~dat+1)%10);		
	}	  
}	

/* 检测是否有按键按下 */								   	
void check_button()					   					//扫描按键
{	
	a0=0;												//按钮变量初始化  ,设置
	a1=0;												//加
	a2=0;												//减
	a3=0;									   			//确认
			
	if(!but1||a0)										//或关系，准确判断按钮是否被按下
	{						
		delay(1);
		
		if(!but1||a0)									//软件消抖
		{
			if(flag==0)
			{
				flag=1;									//按下一次，flag置1
			}
			else if(flag==1)
			{
				flag=2;					
			
			}
			else if(flag==2)
			{
										
				flag=1;									//用于实现按钮1的循环
			}
		}
	}
	if(!but2||a1)										//判断按钮2是否被按下
	{
		delay(1);
		if(!but2||a1){
			if(flag==1)
			{
				if(upper<128)							//最大可加到128
				{
					upper++;
				}
				show_h(upper);							//显示
			}
			if(flag==2)
			{
				if(lower<upper)							//上下限可以相等
				{
					lower++;
				}	  
				show_l(lower);
			}			
		}
	}
	if(!but3||a2)
	{
		delay(1);
		if(!but3||a2)
		{
			if(flag==1)
			{
				if(upper>lower)							//如果比下限大，就可减
				{
					upper--;
				}
				show_h(upper);
			}
			if(flag==2)
			{
				if(lower>-55)							//上下限可以相等
				{
					lower--;
				}	  
				show_l(lower);
			}
		}
	}
	if(!but4||a3)
	{
		delay(1);
		if(!but4||a3)
		{	 
			write24c02(0X00,upper);					   //将此时的修改上限值写入24c02
			delay(15);	
			write24c02(0X01,lower);					   //将此时的修改下限值写入24c02
			flag=0;
		}
	}
	 /* 根据flag值确定是设置上限还是设置下限闪烁 */
	if(flag==1)											//设置上限，falg的值由button1确定，上限闪
	{
		delay02s();
		write_ad_data(0x82,0x11);						//写三位空
		write_ad_data(0x83,0x11);	
		write_ad_data(0x84,0x11);	
		delay02s();
		show_h(upper);									
	}
	if(flag==2)											//设置下限，下限闪
	{
	 	delay02s();
		write_ad_data(0x8b,0x11);						//写三位空
		write_ad_data(0x8c,0x11);	
		write_ad_data(0x8d,0x11);	
		delay02s();
		show_l(lower);
	}
}


#endif
