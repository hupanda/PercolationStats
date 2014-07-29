public class PercolationStats {
        private double mean;
        private double stddev;
        private double confidenceLo;
        private double confidenceHi;
        
        // perform T independent computational experiments on an N-by-N grid
        public PercolationStats(int N, int T)    
        {
                if (N <= 0 || T <= 0) throw new IllegalArgumentException();
                
                double sum = 0;
                double squaredSum = 0;
                java.util.Random rand = new java.util.Random();
                
                for (int i = 0; i < T; i++)
                {
                        Percolation p = new Percolation(N);
                        double n = 0;
                        int row;
                        int col;
                        while (!p.percolates())
                        {
                                do
                                {
                                        row = rand.nextInt(N) + 1;
                                        col = rand.nextInt(N) + 1;
                                }
                                while (p.isOpen(row, col));
                                
                                p.open(row, col);
                                n++;
                        }
                        
                        double result = n / N / N;
                        sum += result;
                        squaredSum += result * result; 
                        
                }
                
                //Calculate the stats
                mean = sum / T;
                stddev = Math.sqrt((squaredSum - 2 * mean * sum + T * mean * mean) / (T - 1));
                double temp = 1.96 * stddev / Math.sqrt(T);
                confidenceLo = mean - temp;
                confidenceHi = mean + temp;
        }
        
        // test client, described below
        public static void main(String[] args)
        {
                if (args.length != 2) 
                {
                        System.out.println("Incorrect number of arguments input!");
                        return;
                }
                
                try
                {
                        int N = Integer.parseInt(args[0]);
                        int T = Integer.parseInt(args[1]);
                        PercolationStats stats = new PercolationStats(N, T);
                        System.out.println("mean                    = " + stats.mean());
                        System.out.println("stddev                  = " + stats.stddev());
                        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
                }
                catch (NumberFormatException e)
                {
                        System.out.println("Incorrect format of arguments input!");
                }
                catch (IllegalArgumentException e)
                {
                        System.out.println("Illegal arguments input!");
                }
                
        }
        
        // sample mean of percolation threshold
        public double mean() 
        {
                return mean;
        }
        
        // sample standard deviation of percolation threshold
        public double stddev()                 
        {
                return stddev;
        }
        
        // returns lower bound of the 95% confidence interval
        public double confidenceLo()             
        {
                return confidenceLo;
        }
        
        // returns upper bound of the 95% confidence interval
        public double confidenceHi()             
        {
                return confidenceHi;
        }

}
