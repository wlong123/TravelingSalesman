/**
	Vector Iterator class to create an iterator for Vector
	@version 10/23/15
	@author Will Long
*/
import java.util.NoSuchElementException;
import java.util.Iterator;

public class VectorIterator<E> implements Iterator<E> 
{
	private Vector<E> vector;
	private int curr;
	
	/**
	constructor that takes in a vector
	@param v vector to be used to create an iterator
	*/
	public VectorIterator(Vector<E> v)
	{
		if((v == null) || (v.isEmpty()))
			throw new IllegalArgumentException("cannot use an empty or null vector");
		vector = v;
		curr = 0;
	}
	
	/**
	returns whether there is another value left in the iteration
	@return boolean true if there is another value left in iteration, false if not
	*/
	public boolean hasNext()
	{
		if(curr < vector.size())
			return true;
		return false;
	}
		
	/**
	gets the next value in the iteration
	@return E next value in iteration
	*/
	public E next()
	{
		if(hasNext() == false)
			throw new NoSuchElementException("no more items left in the Vector");	
		E output = vector.get(curr);
		curr++;
		return output;
	}		
}