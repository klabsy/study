#include <reg51.h>
#include <lcd1602.h>
#include <at24c02.h>
#include <temperature.h>
#include <motor.h>
#define uint unsigned int
#define uchar unsigned char

void main()
{
	init_show();							//开机动画显示
	init_fuction();							//界面显示

	upper=read24c02(0);						//读取24C02数据,读取的是上限值
	lower=read24c02(1);						//读取24C02数据,读取的是下限值

	show_h(upper);							//将数据显示出来,显示的是上限值
	show_l(lower);							//将数据显示出来,显示的是下限值

	while(1)								/* 细化check函数，分成判断读取电机档位，按键扫描 */ 
	{
		motor_init();		    			//启动电机判断程序,开中断，启动中断			    
	}
}

void fun() interrupt 1{
	TR0=0;									//定时器关闭
	TH_TL();								//高八位低八位

	m_gear=read_gear();					    //读取当前档位，判断温度是否超过上下限
	check_button();						    //判断有没有按钮的操作，设置温度的上下限

	TR0=1; 								    //定时器开启
}