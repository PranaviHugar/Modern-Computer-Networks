import java.util.Scanner;
public class crcr
{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int cw[]=new int[20];
        int n,k,i;
        System.out.println("Enter no of bits in received codeword:");
        n=s.nextInt();
        System.out.println("Enter no of bits in G(x):");
        k=s.nextInt();
        System.out.println("Enter received codeword:");
        for(i=0;i<n;i++)
        {
            cw[i]=s.nextInt();
        }
        int g[]=new int[20];
        System.out.println("Enter G(X):");
        for(i=0;i<k;i++)
        {
            g[i]=s.nextInt();
        }
        crcrcode(cw,g,n,k);
    }
    static void crcrcode(int cw[],int g[],int n,int k)
    {
        int i,j,l;
        int tmp[]=new int[20];
        for(i=0;i<n;i++)
        {
            tmp[i]=cw[i];
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
            tmp[l]=cw[i+k];
        }
        int rem[]=new int[20];
        int p=1;
        System.out.print("Remainder:");
        for(i=1;i<k;i++)
        {
            System.out.print(tmp[i]);
            rem[p]=tmp[i];
            p++;
        }
        int flag=0;
        for(i=1;i<k;i++)
        {
            if(rem[i]==0)
            {
                flag=1;
            }
            else
            {
                flag=0;
            }    
        }
        if(flag==1)
        {
            System.out.println("\nNo error");
        }
        else
        {
            System.out.println("\nError");
        }
    }
}