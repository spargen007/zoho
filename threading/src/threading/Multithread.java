package threading;

public class Multithread{
 int count = 1;
	
	static int n;
	class Thread1 extends Thread{
	public void run() {
		
		printEvennumber();
	}
	}
	public void printEvennumber()
	{
		
		synchronized (this)
	{
			
			while (count < n) {

				while (count % 2 == 1) {

					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.print(count + " ");
				
				count++;

			notify();
			}
		}
	}
	class Thread2 extends Thread{
	public void run() {
		
		printOddnumber();
	}
	}
	public void printOddnumber()
	{
		
		synchronized (this)
		{
		
			while (count < n) {

			
				while (count % 2 == 0) {

				
					try {
						wait();
					}
					catch (
						InterruptedException e) {
						e.printStackTrace();
					}
				}

	
				System.out.print(count + " ");

				count++;

				notify();
			}
		}
	}

		public static void main(String[] args)
		{
		
			n = 10;
			Multithread m =new Multithread();
			Thread1 t1=m.new Thread1();
			Thread2 t2=m.new Thread2();
//			Thread t1 = new Thread(new Runnable() {
//				public void run()
//				{
//					mt.printEvennumber();
//				}
//			});
//
//	
//			Thread t2 = new Thread(new Runnable() {
//				public void run()
//				{
//					mt.printOddnumber();
//				}
//			});

			t1.start();
		
			t2.start();
		}
		
	}



