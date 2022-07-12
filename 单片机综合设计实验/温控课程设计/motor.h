#ifndef xiaofengshan
#define xiaofengshan 
#define uint unsigned int
#define uchar unsigned char
#define f1(a) (65536-a)/256
#define f2(a) (65536-a)%256	
unsigned char m_gear=0;						//用来读取档位0,1,2,3  
uint i;										//用来调节占空比													 
sbit p=P2^7;								//电机输入高电平和低电平

void TH_TL(){
	TH0=f1(200);								//每次计时0.2ms
	TL0=f2(200);								
	i++;
}

											//开机时风扇不动

//此处基本思想：把每个档位都单独写开，每次判断档位，一旦读出的档位值不对，立刻停止

//一档
void speed_one()									
{
	while(1)
	{	if(m_gear!=1)
		{	
			TR0=1;							//定时器启动
			break;
		}
		if(i>5&&i<=10)						//占空比为一半
			p=0;
		if(i>10)
		{
			p=1;
			i=1;
		}
	}	
}
				
void speed_two()
{
	while(1)
	{
		if(m_gear!=2)
		{	
			TR0=0;			   				//定时器关闭
			break;							//结束循环
		}	
		if(i>8&&i<=10)						//占空比为百分之八十
			p=0;
		if(i>10)
		{	
			p=1;
			i=1;
		}
	}
}
void speed_three()						     //占空比为百分百
{	
	while(1)
	{
		if(m_gear!=3)
		{	
			TR0=0; 							//定时器关闭
			break;							//结束循环
		}
	}
}
void speed_zero()
{
	p=0;
	while(1)
	{
		if(m_gear!=0)
		{	
			TR0=0;						   //定时器关闭
			break;						   //结束循环
		}
	}	
}

void set_speed(int setspeed){
	 setspeed=m_gear;
	if(m_gear==0)
	{	
		speed_zero();
	}
	else if(m_gear==1)
	{
		speed_one();
	}
	else if(m_gear==2) 
	{
		speed_two();
	} 
	else if(m_gear==3)
	{	
		speed_three();
	} 
}

void motor_init(){      							
	EA=1;									//开中断
	ET0=1;
	TMOD=0X01;								//设置定时器
	p=1;
	TR0=1;									//定时器启动
	i=1;
	TH0=f1(200);							//高八位，每次计时0.2ms
	TL0=f2(200);							//低八位
	set_speed(m_gear);					//设置电机速度
}

#endif
