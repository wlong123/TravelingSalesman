/**
	Traveling Salesman Class
	@version 2/12/16
	@author Will Long
*/
public class TravelingSalesman
{
	public static void main(String [] args)
	{
		Vertex<String> NY = new Vertex<String>("New York"); //initializes the cities as vertices
		Vertex<String> Chicago = new Vertex<String>("Chicago");
		Vertex<String> LA = new Vertex<String>("LA");
		Vertex<String> Boston = new Vertex<String>("Boston");
		Vertex<String> SanFran = new Vertex<String>("San Francisco");
		
		NY.add(Chicago, 3); //manually adds in costs for going from one city to another
		NY.add(LA, 10);
		NY.add(Boston, 2);
		NY.add(SanFran, 12);
		Chicago.add(NY, 3);
		Chicago.add(LA, 7);
		Chicago.add(Boston, 4);
		Chicago.add(SanFran, 7);
		LA.add(NY, 10);
		LA.add(Chicago, 7);
		LA.add(Boston, 12);
		LA.add(SanFran, 2);
		Boston.add(NY, 2);
		Boston.add(Chicago, 4);
		Boston.add(LA, 12);
		Boston.add(SanFran, 15);
		SanFran.add(NY, 12);
		SanFran.add(Chicago, 7);
		SanFran.add(LA, 2);
		SanFran.add(Boston, 15);
		
		NY.visit();  //NY is set to the starting point
		System.out.println(NY); //prints out city once it has been visited
		Vertex<String> curr = NY;  //curr is a variable for the current city
		for(int c = 0; c < 5; c++)  //goes to all the cities once
		{
			int index = -1;  //finds a city that hasn't been visited
			int shortest = 0;
			for(int i = 0; i < 4; i++)
			{
				if(!curr.getPoint(i).visited())
				{
					shortest = curr.getCost(i);
					index = i; //assigns index and shortest to value of the first city that hasn't been visited
					i += 4;
				}
			}
			for(int i = 0; i < 4; i ++)  //finds cheapest city from list of cities that haven't been visited
			{
				if((!curr.getPoint(i).visited()) && (curr.getCost(i) < shortest))
				{
					shortest = curr.getCost(i);
					index = i;
				}
			}
			
			if(index == -1)  //goes back to NY once it has been to every city
				curr = NY;
			else
			{
				curr = curr.getPoint(index);
			}
			curr.visit();
			System.out.println(curr);
		}
	}
}