
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s16it06
 */
public class Binning {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String value[]=s.split(", ");
        int vi[]=new int[value.length];
        for(int i=0;i<value.length;i++){
            vi[i]=Integer.parseInt(value[i]);
        }
        Arrays.sort(vi);
        System.out.println(value.length);
        int n=value.length;
        int d=sc.nextInt();
        float p=(float)n/d;
        System.out.println(p);
        if(p-(int)p>0&&p-(int)p<1){
            p=n/d+1;
            System.out.println(p);
        }
        int m=(int) p;
        System.out.println(m);
        int a[][]=new int[m][d];
        int i=0,c=0;
        for(int j=0;j<m;j++){
            if(j==m-1){
                a[j]=new int[value.length-c];
            }
            for(int k=0;k<d&&c<value.length;k++){
                a[j][k]=vi[i];
                i++;
                c++;
            }
        }
        c=0;
        int ll=0;
        int avg[]=new int[d];
        for(int j=0;j<m;j++){
            for(int k=0;k<d&&c<value.length;k++){
                System.out.print(a[j][k]+" ");
                avg[j]+=a[j][k];
                if(j!=m-1){
                ll++;}
                c++;
            }
            if(j==m-1){
                 avg[j]=Math.round((float)avg[j]/(value.length-ll));   
            }
            else{
            avg[j]=Math.round((float)avg[j]/d);
            }
            System.out.println("");
        }
        for(int k=0;k<m;k++){
            System.out.println(avg[k]);
        }
        c=0;
        for(int j=0;j<m;j++){
            for(int k=0;k<d&&c<value.length;k++){
                if((a[j][k]-a[j][0])<(a[j][a[j].length-1]-a[j][k])){
                    a[j][k]=a[j][0];
                    System.out.print(a[j][k]+" ");
                }
                else{
                    a[j][k]=a[j][a[j].length-1];
                    System.out.print(a[j][k]+" ");
                }
                c++;
            }
            System.out.println("");
        }    
    }
    
}