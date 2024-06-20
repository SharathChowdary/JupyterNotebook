class Hi extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("Hii");
            try { Thread.sleep(100);} catch (Exception e){}
        }
    }
}
class Hello extends Thread{
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println("Hello");
            try { Thread.sleep(100);} catch (Exception e){}

        }
    }
}
public class Threading{
    public static void main(String[] args){
        Hi hi=new Hi();
        Hello hello=new Hello();
        hi.start();
        try { Thread.sleep(10);} catch (Exception e){}
        hello.start();

    }
}