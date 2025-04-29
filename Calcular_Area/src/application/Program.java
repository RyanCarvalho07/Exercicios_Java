package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities_enum.Color;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Shape> lista = new ArrayList<>();
		
		System.out.print("Enter the number of shapes: ");
		int numShape = sc.nextInt();
		
		for(int i=1; i<=numShape; i++) {
			System.out.println("Shape #" + i + " data: ");
			System.out.print("Rectangle or circle (r/c)? ");
			char recOrCir = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			sc.nextLine();
			Color color = Color.valueOf(sc.next());
			
			if(recOrCir == 'r') {
				System.out.print("Width: ");
				double whidth = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
			lista.add(new Rectangle( color, whidth, height));
			}
			if(recOrCir == 'c') {
				System.out.print("Radius: ");
			    double radius = sc.nextDouble();
			    lista.add(new Circle(color, radius));
			}
		}
		
		
		System.out.println();
		System.out.println("SHAPE AREAS: ");
	    for(Shape s : lista) {
	    	System.out.println(String.format("%.2f", s.area()));
	    }
		
		sc.close();
		

}
}
