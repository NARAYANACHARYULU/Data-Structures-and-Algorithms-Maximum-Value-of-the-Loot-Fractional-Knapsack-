import java.text.DecimalFormat;
import java.util.Scanner;

public class FractionalKnapsack {
    private static String getOptimalValue(int capacity, int[] values, int[] weights) {
        int n=values.length;
        double temp1=0;
        int  temp2=0;
        int  temp3=0;
        double value1 = 0;
        double value2=0;
        double value=0;
        int j=0;
        int c=0;
        double[] fraction=new double[n];
      
        for(int i=0;i<n;i++)
        {
        	fraction[i]+=((double)values[i]/(double)weights[i]);
        }
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
        for(int i=0;i<n-1;i++)
        {
        	if(fraction[i]<fraction[i+1])
        	{
        		temp1=fraction[i];
        		temp2=weights[i];
        		temp3=values[i];
        		fraction[i]=fraction[i+1];
        		weights[i]=weights[i+1];
        		values[i]=values[i+1];
        		fraction[i+1]=temp1;
        		weights[i+1]=temp2;
        		values[i+1]=temp3;
        		sorted = false;
        	}
        		
        	}
        }
        for(int i=0;i<n;i++)
        {
        	if(capacity>0 && capacity>=weights[i])
        	{
        			capacity-=weights[i];
        			value1+=values[i];
        			j=i+1;
        			c=capacity;
        	}
        	if(n>1 && capacity>0 && capacity<weights[j])
        	{
        		value2+=(((double)values[j]/(double)weights[j])*(double)capacity);
        		capacity-=c;
        	}
        }
        for(int i=0;i<n;i++)
        {
        	if(capacity>0 && capacity<weights[i])
        	{
        		value2+=(((double)values[i]/(double)weights[i])*(double)capacity);
        	}
        }
        value=value1+value2;
        DecimalFormat df=new DecimalFormat("0.0000");
        
        return df.format(value);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}