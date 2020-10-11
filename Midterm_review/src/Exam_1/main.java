package Exam_1;

class Counter
{
  private long counter;

  Counter() {
    counter =0;
  }
  
  public void add(int val) {
	  this.counter += val;
	  System.out.println(val + " elements added");
  }
  
  public void remove(int val) {
	  if (counter - val < 0) {
		  System.out.println("Not enough elements");
	  } else {
		  this.counter -= val;
		  System.out.println(val + " elements removed");
	  }
  }
  
  public void report() {
	  System.out.println("Number of elements = " + counter);
  }

  // Write your method(s) here
  public void operation(String s, int val) {
	  if (val < 0) {
		  System.out.println("Only support positive integer values");
		  return;
	  }
	  if (s.equals("add")) {
		  add(val);
	  } else if (s.equals("remove")) {
		  remove(val);
	  } else if (s.equals("report")) {
		  report();
	  } else {
		  System.out.println("Wrong operation");
	  }
  }
  
  public void operation(String s, double val) {
	  System.out.println("Only supports integer values");
  }
  
  public void operation(String s) {
	  report();
  }

}

public class main
{
  public static void main(String[] args) {
    Counter c = new Counter();
    c.operation("add", 10);     // print: "10 elements added"
    c.operation("remove", 5);   // print: "5 elements removed"
    c.operation("add", -2);     // print: "Only support positive integer values"
    c.operation("add", 3.7);    // print: "Only support integer values"
    c.operation("plus", 13);    // print: "Wrong operation"
    c.operation("remove", 10);  // print: "Not enough elements"
    c.operation("report");      // print: "Number of elements = 5"
  }
}