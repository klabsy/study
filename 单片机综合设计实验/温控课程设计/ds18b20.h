#ifndef ds18b20
#define ds18b20
#include <reg51.h>
#include<intrins.h>
#define uint unsigned int
#define uchar unsigned char

sbit DQ=P1^5;

void delay5(uchar n)					//延时5us函数
{	do									
	{
		_nop_();
		_nop_();
		_nop_();
		n--;
	 }
	 while(n);	
}

void init_ds18b20(void)		 			//对18b20初始化函数
{
	uchar x=0;
	DQ=0;
	delay5(120);
	DQ=1;
	delay5(16);
	delay5(80);
}

uchar readbyte(void)					//函数功能：读取1字节数据
{	
	uchar i=0;
	uchar date=0;
	for (i=8;i>0;i--)
	{	
		DQ=0;
		delay5(1);
		DQ=1;
		date>>=1;
		if(DQ)
		date|=0x80;
		delay5(11);
	}
	return(date);
}

void writebyte(uchar dat)				//写1B函数
{	
	uchar i;
	for(i=8;i>0;i--)
	{	
		DQ=0;
		DQ=dat&0x01;
		delay5(12);
		DQ=1;
		dat>>=1;
		delay5(5);
	}
}

#endif
