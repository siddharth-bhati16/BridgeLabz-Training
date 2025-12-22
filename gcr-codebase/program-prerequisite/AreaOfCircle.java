import java.util.*;
public class AreaOfCircle {
    public static void main(String [] args)
	{
        Scanner take= new Scanner(System.in);
        System.out.println("Input the radius of the circle");
        int radius= take.nextInt();
        double area= ((3.14)*radius*radius);
        System.out.println(area);
    }
}