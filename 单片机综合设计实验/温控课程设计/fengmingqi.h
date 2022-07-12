#ifndef fengmingqi
#define fengmingqi 
#include <reg51.h>
#define uint unsigned int
#define uchar unsigned char
sbit beep = P1^4;


void DelayMS(uint x) 				 //延时函数
{
     uchar t;
     while(x--) 
	 	for(t=0;t<120;t++);
}


void playmusic()					//控制音频、节拍函数
{
	DelayMS(10);
 	beep=1;
    DelayMS(10);
	beep=0;
}



#endif
