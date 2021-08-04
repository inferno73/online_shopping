//import java.util.ArrayList;

public class BankAccount {
	
	//treba li?
	//private static ArrayList<BankAccount> list = new ArrayList<BankAccount>();
	BankAccount() {
		
	}
	
	BankAccount(int number, double amount) {
		this.numberOfBankAccount = number;
		this.amount = amount;
	}
	
	
	private int numberOfBankAccount; //unique for each BankAccount
	private double amount;
	
	
	public void reduceAmount(double cost) {
		this.amount = this.amount - cost;
	}
	
	//in case of money return:
	public void increaseAmount(double refund) {
		this.amount = this.amount + refund;
	}
	
	public int getNumberOfBankAccount() {
		return numberOfBankAccount;
	}

	public void setNumberOfBankAccount(int numberOfBankAccount) {
		this.numberOfBankAccount = numberOfBankAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
 /*
	public static ArrayList<BankAccount> getList() {
		return list;
	}

	public static void setList(ArrayList<BankAccount> list) {
		BankAccount.list = list;
	}
*/
	
	
	
}
