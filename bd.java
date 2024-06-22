import java.util.Scanner;

public class bd 
{
    public static void main(String args[])
    {
        int dividlen,divislen;
        int dividend[]=new int[30];
        int divisor[]=new int[30];
        Scanner s=new Scanner(System.in);
        System.out.println("\nEnter length of dividend:");
        dividlen=s.nextInt();
        System.out.println("\nEnter length of divisor:");
        divislen=s.nextInt();
        System.out.println("\nEnter dividend:");
        for(int i=0;i<dividlen;i++)
        {
            dividend[i]=s.nextInt();
        }

        System.out.println("\nEnter divisor:");
        for(int i=0;i<divislen;i++)
        {
            divisor[i]=s.nextInt();
        }
        binarydiv(dividend,divisor,dividlen,divislen);
    }
    static void binarydiv(int dividend[],int divisor[],int dividlen,int divislen)
    {
        int i,j,k;
        int tmp[]=new int[20];
        for(i=0;i<divislen;i++)
        {
            tmp[i]=dividend[i];
        }
        for(i=0;i<dividlen;i++)
        {
            if(tmp[0]==1)
            {
                for(j=0;j<divislen;j++)
                {
                    if(tmp[j]==divisor[j])
                    {
                        tmp[j]=0;
                    }
                    else
                    {
                        tmp[j]=1;
                    }
                }
            }
            if((i+divislen)==dividlen)
            {
                break;
            }
            for(k=0;k<(divislen-1);k++)
            {
                tmp[k]=tmp[k+1];
            }
            tmp[k]=dividend[i+divislen];
        }
        System.out.println("\nRemainder is:");
        for(j=1;j<divislen;j++)
        {
            System.out.println(tmp[j]);
        }
    }
}