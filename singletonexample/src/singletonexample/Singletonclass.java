package singletonexample;

public class Singletonclass
{
  
  private static Singletonclass instance;
  public String string;
  private Singletonclass ()
  {

    string = "Welcome to Singleton class which creates only one object.";
  }
 
  public static Singletonclass getInstance()
  {
    if (instance == null)
    {
       instance = new Singletonclass ();
    }
    return instance;
  }
  public static void main(String args[])
  {
	  
    Singletonclass text = Singletonclass.getInstance();

    System.out.println("The String is:");
    System.out.println(text.string);
    System.out.println();
    Singletonclass text1 = Singletonclass.getInstance();
    System.out.println("The String is:");
    System.out.println(text1.string);
    System.out.println();
    System.out.println("first instance: "+text.hashCode());
    System.out.println("second instance: "+text1.hashCode());
  }
}