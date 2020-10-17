import java.util.*;
class Account
{
	protected String name,acc_type;
	protected int acc_num,acc_bal;
}
class Open_Account extends Account
{
	public void insert()
	{
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		System.out.print("Enter Your Name:");
		name=sc.nextLine();
		System.out.print("Enter Account Type:");
		acc_type=sc.next();
		acc_num=r.nextInt(1000);
		acc_bal=0;
	}
	public void display_details()
	{
		System.out.println("\nAccount Holder Name:"+name);
		System.out.println("Account Number:"+acc_num);
		System.out.println("Account Balance:"+acc_bal);
		System.out.println("Account Type:"+acc_type);
		System.out.println();
	}
	int withdraw(int withd)
	{
		acc_bal=acc_bal-withd;
		return acc_bal;
	}
}
public class Bank_Management_System
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Open_Account o[]=new Open_Account[100];
		String name,acc_type;
		int bal,check_bal,temp,withd,choice,i=0,count=0;
		do
		{
			System.out.print("1.Create Account\n2.Deposit Money\n3.Withdraw Money\n4.Check Balance\n5.Display Details\n6.Exit\nEnter Your Choice:");
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:	o[i]=new Open_Account();
						o[i].insert();
						System.out.println("\nYour Account Details:");
						o[i].display_details();
						i++;
						count++;
						break;
				case 2:System.out.print("Enter Account Number:");
						temp=sc.nextInt();
						for(i=0;i<count;i++)
						{
							if(temp==o[i].acc_num)
							{
								System.out.print("Enter Amount Of Money:");
								bal=sc.nextInt();
								o[i].acc_bal=bal;
								System.out.println("\nMoney Deposited");
								System.out.println();
							}
						}
						if(i>count)
							System.out.println("Wrong Account Number");
						break;
				case 3:System.out.print("Enter Account Number:");
						temp=sc.nextInt();
						for(i=0;i<count;i++)
						{
							if(temp==o[i].acc_num)
							{
								if(o[i].acc_bal==0)
								{	
									System.out.println("\nYour Account Is Empty");
									System.out.println();
								}
								else
								{
									System.out.print("Enter Amount Of Money:");
									withd=sc.nextInt();
									if(withd>o[i].acc_bal)
									{
										System.out.print("Insufficient Balance\nEnter Valid Amount:");
										withd=sc.nextInt();
									}
									check_bal=o[i].withdraw(withd);
									System.out.println("\nYour Current Balance:"+check_bal);
									System.out.println();
								}
							}
						}
						if(i>count)
							System.out.println("Wrong Account Number");
						break;
				case 4:System.out.print("Enter Account Number:");
						temp=sc.nextInt();
						for(i=0;i<count;i++)
						{
							if(temp==o[i].acc_num)
							{
								System.out.println("\nYour Current Balance:"+o[i].acc_bal);
								System.out.println();
							}
							if(i>choice)
								System.out.println("Wrong Account Number");
						}
						break;
				case 5:System.out.print("Enter Account Number:");
						temp=sc.nextInt();
						for(i=0;i<count;i++)					
						{
							if(temp==o[i].acc_num)
							{
								o[i].display_details();
							}
							if(i>choice)
								System.out.println("Wrong Account Number");
						}
						break;
				case 6:break;
				default:System.out.println("Invalid Choice");
						break;
			}

		}while(choice!=6);
	}
}
