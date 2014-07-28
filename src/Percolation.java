/*
 * By convention, the indices i and j are integers between 1 and N, where (1, 1) is the upper-left site: 
 * Throw a java.lang.IndexOutOfBoundsException if either i or j is outside this range. 
 * The constructor should take time proportional to N^2; 
 * all methods should take constant time plus a constant number of calls to the union-find methods union(), find(), connected(), and count().
 */
public class Percolation 
{
	
	// create N-by-N grid, with all sites blocked
	public Percolation(int N)
	{
		return;
   	}
	// open site (row i, column j) if it is not already
	public void open(int i, int j)         
	{
		return;
	}
   
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j)    
   	{
	   	return true;
   	}
	
	// is site (row i, column j) full?
	public boolean isFull(int i, int j)    
	{
		return true;
	}
   
	// does the system percolate?
	public boolean percolates()            
	{
		return true;
	}
	
}