package accountmanagementSystem;
import java.util.*;
class BankDetails{
	private String name;
	private String Accno;
	private String Acc_type;
	private long Balance;
	Scanner sc=new Scanner(System.in);
	public void CreateAccount() {
		System.out.println("Enter Name:");
		name=sc.nextLine();
		System.out.println("Enter Account Number:");
		Accno=sc.nextLine();
		System.out.println("Enter Account Type:");
		Acc_type=sc.nextLine();
		System.out.println("Enter Balance");
		Balance=sc.nextLong();
	}
		public void ViewAccount() {
			System.out.println("Name of Account Holder:"+name);
			System.out.println("Account No:"+Accno);
			System.out.println("Account type:"+Acc_type);
			System.out.println("Balance:"+Balance);
		}
		public void Deposit() {
			long amt;
			System.out.println("Enter the Amount you want to deposit:");
			amt=sc.nextLong();
			Balance=Balance+amt;
			System.out.println("enter the Remaining amount:"+Balance);
			}
		public void withdrawl() {
			long amt;
			System.out.println("Enter the Amount you want to withdraw:");
			amt=sc.nextLong();
			if(Balance>=amt) {
				Balance=Balance-amt;
				System.out.println("Balance after Withdraw:"+Balance);
			}
			else {
				System.out.println("Your balance is less than:"+amt +" "+"\tTransaction failed...!!");
			}
		}
		public boolean search(String Accno) {
			if(Accno.equals(Accno)) {
				ViewAccount();
				return(true);
			}
			return(false);
		}
	}

public class Main {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("How MANY NUMBER OF CUSTOMERS DO YOU WANT TO INPUT?");
	int n=sc.nextInt();
	BankDetails C[]=new BankDetails[n];
	for(int i=0;i<C.length;i++) {
		C[i]=new BankDetails();
		C[i].CreateAccount();
	}
	int ch;
	do {
		System.out.println("\n***Banking System Apllication***");
		System.out.println("Display All Account Details\n2.Search by Account number\n3.Deposit the amount\n4.Withdraw the amount\n5.Exit");
		System.out.println("Enter your Choice:");
		ch=sc.nextInt();
		switch(ch) {
		case 1:
			for(int i=0;i<C.length;i++) {
				C[i].ViewAccount();
			}
			break;
		case 2:
			System.out.println("Enter the Account number you want to search:");
			String Accno=sc.nextLine();
			boolean found=false;
			for(int i=0;i<C.length;i++) {
				found=C[i].search(Accno);
				if(found) {
					break;
				}
			}
			if(!found) {
				System.out.println("Search failed!\nAccount doesn't exist");
			}
			break;
		case 3:
			System.out.println("Enter Account Number:");
			Accno=sc.next();
			found=false;
			for(int i=0;i<C.length;i++) {
				found=C[i].search(Accno);
				if(found) {
					C[i].Deposit();
					break;
				}
			}
			if(!found) {
				System.out.println("Search failed!Account doesn't exist....!!");
			}
			break;
		case 4:
			System.out.println("Enter the Accno:");
			Accno=sc.next();
			found=false;
			for(int i=0;i<C.length;i++) {
				found=C[i].search(Accno);
				if(found) {
					C[i].withdrawl();
					break;
				}
			}
			if(!found) {
				System.out.println("Search failed! Account doesn't exist...!!!");
			}
			break;
		case 5:
			System.out.println("See You Seen....");
			break;
		}
	}
	while(ch!=5);
	}

}