import java.util.Scanner;
public class crcs1
{
    public static void main(String args[])
    {
        int m,k;
        int data[]=new int[30];
        int g[]=new int[30];
        Scanner s=new Scanner(System.in);
        System.out.println("\nEnter no of bits in data:");
        m=s.nextInt();
        System.out.println("\nEnter no of bits in G(x):");
        k=s.nextInt();
        System.out.println("\nEnter data:");
        for(int i=0;i<m;i++)
        {
            data[i]=s.nextInt();
        }

        System.out.println("\nEnter G(x):");
        for(int i=0;i<k;i++)
        {
            g[i]=s.nextInt();
        }
        System.out.print("\nData entered is:");
        for(int i=0;i<m;i++)
        {
            System.out.print(data[i]);
        }
        System.out.print("\nG(x) entered is:");
        for(int i=0;i<k;i++)
        {
            System.out.print(g[i]);
        }
        crcscode(data,g,m,k);
    }
    static void crcscode(int data[],int g[],int m,int k)
    {
        int i,j,l;
        for(i=m;i<=m+(k-1);i++)
        {
            data[i]=0;
        }
        int n=m+(k-1);
        System.out.print("\nUpdated data is:");
        for(i=0;i<n;i++)
        {
            System.out.print(data[i]+"");
        }
        int tmp[]=new int[20];
        for(i=0;i<n;i++)
        {
            tmp[i]=data[i];
        }
        for(i=0;i<n;i++)
        {
            if(tmp[0]==1)
            {
                for(j=0;j<k;j++)
                {
                    if(tmp[j]==g[j])
                    {
                        tmp[j]=0;
                    }
                    else
                    {
                        tmp[j]=1;
                    }
                }
            }
            if((i+k)==n)
            {
                break;
            }
            for(l=0;l<(k-1);l++)
            {
                tmp[l]=tmp[l+1];
            }
            tmp[l]=data[i+k];
        }
        System.out.print("\nCRC code is:");
        for(i=1;i<k;i++)
        {
            System.out.print(tmp[i]);
        }
        j=1;
        for(i=m;i<(m+k);i++)
        {
            data[i]=tmp[j];
            j++;
        }
        System.out.print("\nCodeword:");
        for(i=0;i<(m+k-1);i++)
        {
            System.out.print(data[i]+" ");
        }
    }
}