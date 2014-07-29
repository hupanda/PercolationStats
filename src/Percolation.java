/*
 * By convention, the indices i and j are integers between 1 and N, where (1, 1) is the upper-left site: 
 * Throw a java.lang.IndexOutOfBoundsException if either i or j is outside this range. 
 * The constructor should take time proportional to N^2; 
 * all methods should take constant time plus a constant number of calls to the union-find methods union(), find(), connected(), and count().
 */
import java.util.Arrays;

public class Percolation {
        private static int CLOSED = -1;
        private int[] matrix;
        private int dimension;
        private boolean percolates;
        
        // create N-by-N grid, with all sites blocked
        public Percolation(int N)
        {
                if (N <= 0) throw new IllegalArgumentException();
                matrix = new int[N*N];
                Arrays.fill(matrix, CLOSED);
                dimension = N;
                return;
           }
        
        // open site (row i, column j) if it is not already
        public void open(int i, int j)         
        {        
                if (i < 1 || j < 1 || i > dimension || j > dimension) throw new IndexOutOfBoundsException();
                if (isOpen(i, j)) return;
                int index = getIndex(i, j);
                matrix[index] = index;
                if (i > 2 && isOpen(i-1, j)) union(index, getIndex(i-1, j));
                if (i < dimension && isOpen(i+1, j)) union(index, getIndex(i+1, j));
                if (j > 2 && isOpen(i, j-1)) union(index, getIndex(i, j-1));
                if (j < dimension && isOpen(i, j+1)) union(index, getIndex(i, j+1));
        }
   
        // is site (row i, column j) open?
        public boolean isOpen(int i, int j)    
           {
                if (i < 1 || j < 1 || i > dimension || j > dimension) throw new IndexOutOfBoundsException();
                return !(matrix[getIndex(i, j)] == CLOSED);
           }
        
        // is site (row i, column j) full?
        public boolean isFull(int i, int j)    
        {
                if (i < 1 || j < 1 || i > dimension || j > dimension) throw new IndexOutOfBoundsException();
                return isOpen(i, j) && root(getIndex(i, j)) < dimension;
        }
    
        // does the system percolate?
        public boolean percolates()            
        {
                return percolates;
        }
        
        private void union(int p, int q)
        {
                int i = root(p);
                int j = root(q);
                int min = Math.min(i, j);
                matrix[j] = min;
                matrix[i] = min;
                if (min < dimension)
                {
                        if (isLastRow(p) || isLastRow(q)) percolates = true;
                }
        }
        
        private int root(int j)
        {
                int i = j;
                while (i != matrix[i]) i = matrix[i];
                return i;
        }
        
        private int getIndex(int i, int j)
        {
                return (i-1) * dimension + j - 1;
        }
        
        private boolean isLastRow(int i)
        {
                return i >= dimension * (dimension - 1); 
        }
        
}