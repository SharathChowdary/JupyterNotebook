public class Sample {
    public static void main(String[] args){
        Bank b1=new Bank();
        b1.deposit(500);
        b1.getAmount();
        b1.withdraw(500);
    }
}
class Bank{
    static int acc_no=100001;
    int amount=1000;
    Bank(){
        System.out.println("Thanks for opening account in our Bank\nYour Account no : "+acc_no);
        System.out.println("1000 has been added to your bank as a reward");
        acc_no++;
    }
    void getAmount(){
        System.out.println("Your account Balance : "+amount);
    }
    void deposit(int x){
        if(x<=0){
            System.out.println("Please deposit atleast one rupee");
        }
        else {
            amount+=x;
            System.out.println("After Depositing amount, your balance : "+amount);
        }
    }
    void withdraw(int x){
        if(amount==1000 || x>amount-1000){
            System.out.println("You can't withdraw that amount");
        }
        else {
            amount-=x;
            System.out.println(x+" withdrawn successfully");
            System.out.println("Avalilable Balance : "+amount);
        }
    }
}