#ifndef lcd1602
#define lcd1602
#define uchar unsigned char
#define uint unsigned int

sbit lcdrs=P1^0;
sbit lcdrw=P1^1;
sbit lcden=P1^2;

void check_busy(void)				  			//检查忙标志位
{
	uchar dt;
	do
	{
		dt=0xff;
		lcden=0;
		lcdrs=0;
		lcdrw=1;
		lcden=1;
		dt=P0;
	}while(dt&0x80);
	lcden=0;
}


void delay_ms(uint temp)					  	//延时函数
{
 	uint x,y;
 	for(x=temp;x>0;x--)
  		for(y=110;y>0;y--);		
}

void write_com(uchar com)			  			//写命令 
{
 	check_busy();
 	lcdrs=0;
 	lcdrw=0;
	P0=com;
 	delay_ms(10);
 	lcden=1;
 	delay_ms(10);
 	lcden=0;
}

void write_ad_data(uchar ad,uchar dat) 			//向指定地址写要显示的字符
{
 	write_com(ad);														
 	check_busy();
 	lcdrs=1;
 	lcdrw=0;
 	P0=dat;
 	delay_ms(10);
 	lcden=1;
	delay_ms(10);
	lcden=0;
}

void write_ad_str(uchar ad,uchar *s) 			//向指定地址写要显示的多个字符
{
	while(*s)
	{
		write_ad_data(ad++,*s++);				//地址增1，指针增1
	}	
}

void init1602()									//初始化
{
 	lcden=0;
 	write_com(0x38); 							//两行显示，5*7点阵，8位数据接口
 	write_com(0x0c);							//开整体显示，光标关，无闪烁
 	write_com(0x04);						  	//写入一个字符后，整屏不移动
 	write_com(0x01);							//清屏
}

#endif