/**
	vertex class
	@version 2/12/16
	@author Will Long
*/
public class Vertex<E>
{
	/**value contained in the vertex*/
	private E value;
	
	/**stores whether the city has been visited or not*/
	public boolean visited;
	
	/**list of the vertices this vertex can go to*/
	private Vector<Vertex<E>> otherPoints;
	
	/**list of the costs of going to the other vertices*/
	private Vector<Integer> costs;
	
	/**
	constructor for vertex that takes in a generic
	@param e item that is going to be assigned to value	
	*/
	public Vertex(E e)
	{
		value = e;
		visited = false;
		otherPoints = new Vector<Vertex<E>>(4); //4 is the number of other cities in traveling salesman
		costs = new Vector<Integer>(4); 
	}
	
	/**
	adds an inputted Vertex and int to the lists otherPoints and costs respectively
	@param point vertex that is going to be added to otherPoints
	@param cost int that is going to be added to costs
	*/
	public void add(Vertex<E> point, Integer cost)
	{
		otherPoints.add(point);
		costs.add(cost);
	}
	
	/**
	accessor for the class field visited
	@return boolean returns whether this vertex has been visited or not
	*/
	public boolean visited()
	{
		return visited;
	}
	
	/**
	sets the class field visited to true
	*/
	public void visit()
	{
		visited = true;
	}
	
	/**
	returns an item in the vector costs at an inputted index
	@param i index from which the item is going to be returned
	@return Integer returns a cost
	*/
	public Integer getCost(int i)
	{
		return costs.get(i);
	}
	
	/**
	returns an item from the vector getPoint at an inputted index
	@param i index from which the item is going to be returned
	@return Vertex<E> returns an item from the vector otherPoints
	*/
	public Vertex<E> getPoint(int i)
	{
		return otherPoints.get(i);
	}
	
	/**
	returns a string representation of the vertex
	@return String returns a string representation of the vertex
	*/
	public String toString()
	{
		String s = "";
		s += value;
		return s;
	}
}