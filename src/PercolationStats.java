//The constructor should throw a java.lang.IllegalArgumentException if either N ² 0 or T ² 0.

public class PercolationStats 
{
	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T)    
	{
		if(N <= 0 || T <=0) throw new java.lang.IllegalArgumentException();
	}
	
	// test client, described below
	public static void main(String[] args)
	{
		if(args.length != 2) 
		{
			System.out.println("Incorrect number of arguments input!");
			return;
		}
		
		try
		{
			int N = Integer.parseInt(args[0]);
			int T = Integer.parseInt(args[1]);
			PercolationStats stats = new PercolationStats(N, T);
			System.out.println(stats.mean());
			System.out.println(stats.stddev());
			System.out.println(stats.confidenceLo() + ", " + stats.confidenceHi());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Incorrect format of arguments input!");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Illegal arguments input!");
		}
		catch(Exception e)
		{
			System.out.println("Error occurs!");
		}
		
	}
	
	// sample mean of percolation threshold
	public double mean()             
	{
		return 0;
	}
	
	// sample standard deviation of percolation threshold
	public double stddev()                 
	{
		return 0;
	}
	
	// returns lower bound of the 95% confidence interval
	public double confidenceLo()             
	{
		return 0;
	}
	
	// returns upper bound of the 95% confidence interval
	public double confidenceHi()             
	{
		return 0;
	}

}
