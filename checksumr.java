import java.util.Scanner;
public class checksumr
{
    public static void main(String args[])
    {
        int m,i,seg;
        int data[]=new int[50];
        Scanner s=new Scanner(System.in);
        System.out.print("Enter no of bits in data:");
        m=s.nextInt();
        System.out.print("\nEnter the data:");
        for(i=0;i<m;i++)
        {
            data[i]=s.nextInt();
        }
        System.out.print("\nEnter no of segments you want to divide:");
        seg=s.nextInt();
        int segsize=m/seg;
        checksum(data,segsize,seg,m);
    }
    static void checksum(int cw[],int segsize,int seg,int m)
    {
        int s1[]=new int[segsize];
        int s2[]=new int[segsize];
        int tmp[]=new int[segsize];
        int carry=0;

        create(s1,0,segsize,cw);
        create(s2,1,segsize,cw);

        for(int i=2; i <= seg ;i++)
        {
            carry=0;
            for(int j=segsize-1 ; j >=0 ; j--)
            {
                tmp[j]=s1[j]^s2[j]^carry;
                if((s1[j]==1 && s2[j]==1 && carry==1)||(s1[j]==1 && s2[j]==1)||(s1[j]==1 && s2[j]==0 && carry==1)||(s1[j]==0 && s2[j]==1 && carry==1 ))
                    carry=1;
                else
                    carry=0;
            }
            if(carry == 1 && tmp[segsize-1]==0)
                tmp[segsize-1]=tmp[segsize-1]^carry;
            else if(carry==1 && tmp[segsize-1]==1)
            {
                int flag=1;
                for(int k=segsize-1 ; k>=0;k--)
                {
                    int res;
                    res=tmp[k];
                    tmp[k]=tmp[k]^carry;
                    if(res==1)
                        carry=1;
                    else
                    {
                        flag=0;
                        if(k==0)
                        tmp[k+1]=1;
                        break;
                    }
                }
                if(flag==1)
                    tmp[segsize-1]=1;
            }
        create(s1,i,segsize,cw);
        for(int k=0;k<segsize;k++)
           s2[k]=tmp[k];
        }

        System.out.print("\nFinal sum  :");
        for(int i=0;i<segsize;i++)
        {
           System.out.print(tmp[i]);
        }

        System.out.print("\nChecksum:");
        for(int i=0;i<segsize;i++)
        {
            tmp[i]=tmp[i]^1;
            System.out.print(tmp[i]);
        }
        int flag=0;
        for(int i=0;i<segsize;i++)
        {
            if(tmp[i]==0)
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
            System.out.print("\nNo error");
            System.out.print("\nActual codeword:");
            for(int i=0;i<m-segsize;i++)
            {
                System.out.print(cw[i]);
            }
        }
        else
        {
            System.out.print("\nError present. Discard the codeword");
        }
        
       
        /*for(int j=m;j<(m+segsize);j++)
        {
            cw[j]=tmp[j-m];
        }
        System.out.print("\nActual Codeword:");
        for(int i=0;i<(m+segsize-1);i++)
        {
            System.out.print(cw[i]+"");
        }*/
    }
    static void create(int seg[],int sno,int segsize,int cw[])
    {
        for(int i=0;i<segsize;i++)
        {
            seg[i]=cw[segsize*sno+i];
        }
    }
}