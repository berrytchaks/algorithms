package concurrency;

/**
 * 
 * @author berrytchaks
 * 
 * Producer Consumer problem with n producers and n consumers
 *
 */
public class ProducerConsumer {

    static Monitor monitor;
    int n;
	int maxSize;

    public ProducerConsumer(int maxSize)
    {
    	n=0;
        this.maxSize = maxSize;
//        monitor = new Monitor(maxSize);
        monitor = new Monitor();
        new Producer().start();
        new Producer().start();
        new Consumer().start();
        new Consumer().start();
    }

    class Producer extends Thread{

        @Override
        public void run() {
            while(true)
            {
                try {
                    monitor.insert();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                finally{
//                	try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//                }
            }
        }
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            while(true)
            {
                try {
                    monitor.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     class Monitor {
         public Monitor(){}

        synchronized void insert() throws InterruptedException 
        {
            while(n==maxSize){
            	System.out.println("Buffer full producers sleep");
                wait();
            }
            n++;
            System.out.println("Producer: "+n);
            if(n==1){
            	System.out.println("An item present Awake consumers");
                notifyAll();
            }
        }

        synchronized void remove() throws InterruptedException 
        {
        	while(n==0){
        		System.out.println("Buffer empty consumers sleep");
        		wait();
        	}
        	n--;
            System.out.println("Consumer: "+n);
            if(n==maxSize-1){
            	System.out.println("Cell empty Awake producers");
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer(10);

    }
}