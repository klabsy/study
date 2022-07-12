#ifndef temperature
#define temperature 
#include <ds18b20.h>
#define uint unsigned int
#define uchar unsigned char
sbit beep = P1^4;								//蜂鸣器接口
sbit relay=P2^3;
uchar flagg,gear;								//flagg标志位，标志温度是正数还是负数，gear用于获取档位
char top;											//高温
char low;											//低温


float readtemp(void)						//读取温度函数
{	
	uchar a,b;
	uint t;
	float tt=0;
	init_ds18b20();
	writebyte(0xCC);					
	writebyte(0x44);						//启动温度转换
	init_ds18b20();
	writebyte(0xCC);
	writebyte(0xBE);						//读取暂存器中的温度数据
	a=readbyte();
	b=readbyte();
	t=b;
	t<<=8;
	t=t|a;
	if(t>=0xfc90)			   				//-55℃输出为0xfc90,要取它的补码
	{
		flagg=1;								//置标记位为1，标记为负数
		tt=(~t+1)*0.0625+0.5;			    //变成10进制
		return(tt);
	}
	else
	{
		flagg=0;
		tt=t*0.0625;
		return(tt);
	}	
}

void display(float s)						//显示温度
{
	uint t=s*10;							//乘10，此处方便获取小数
	uint t1,t2,t3,t4;
	if(flagg==1)							//负数
	{
		if(t==0)
		{
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0xfe);
			write_ad_data(0x80+0x44,0x30);
			write_ad_data(0x80+0x46,0x30);
		}
		if(t<100&&t>0)
		{
			t1=t/10;
			t2=t%10;
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0x2d);
			write_ad_data(0x80+0x44,0x30+t1);
			write_ad_data(0x80+0x46,0x30+t2);
		}
		if(t>=100)
		{
			t1=t/100;						//获得十位上的数
			t2=t/10%10;						//获得个位上的数
			t3=t%10;
			write_ad_data(0x80+0x42,0x2d);
			write_ad_data(0x80+0x43,0x30+t1);
			write_ad_data(0x80+0x44,0x30+t2);
			write_ad_data(0x80+0x46,0x30+t3);
		}	
	}
	if(flagg==0)							//正数
	{
		if(t<100)
		{
			t1=t/10;
			t2=t%10;
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0xfe);
			write_ad_data(0x80+0x44,0x30+t1);
			write_ad_data(0x80+0x46,0x30+t2);
		}
		if(t>=100&&t<1000)
		{
			t1=t/100;						//获得十位上的数
			t2=t/10%10;						//获得个位上的数
			t3=t%10;						//获得小数
			write_ad_data(0x80+0x42,0xfe);
			write_ad_data(0x80+0x43,0x30+t1);
			write_ad_data(0x80+0x44,0x30+t2);
			write_ad_data(0x80+0x46,0x30+t3);
		}
		if(t>=1000&&t<=1280)
		{
			t1=t/1000;						//获得百位上的数
			t2=t/100%10;					//获得十位上的数
			t3=t%100/10;					//获得个位上的数
			t4=t%100%10;					//获得小数
			write_ad_data(0x80+0x42,0x30+t1);
			write_ad_data(0x80+0x43,0x30+t2);
			write_ad_data(0x80+0x44,0x30+t3);
			write_ad_data(0x80+0x46,0x30+t4);
		}
	}
}


/*  获取当前档位 */
uchar read_gear()
{
	float temp=readtemp();					//变量记录从18B20读出的温度
	display(temp);							//显示读取的温度
	top=read24c02(0);						//读上限下限
	low=read24c02(1);
	if(temp<=top) 							//小于等于温度上限
	{
		gear=0;								//档位置0，风扇不动
		if(temp<low)						//小于下限
		{
			relay=0;						//吸合继电器
			beep=0;							//响
		}
		else								//正常范围
		{
			relay=1;						//打开继电器
			beep=1;							//不响
		}
	}
	else									//大于温度上限
	{
		beep=0;								//响
		if(temp<=top+2)						//一档
		{
			gear=1;
		}
		else if(temp<=top+4)				//三档
		{
			gear=2;
		}
		else								//三档
		{
			gear=3;
		}
	}
	write_ad_data(0x80+0x4e,0x30+gear);	   //显示当前档位
	return gear;								//返回档位数值，供风扇使用
}

#endif
