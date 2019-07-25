/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s16it06
 */
import java.util.*;
public class MinMax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String value[]=s.split(",");
        int vi[]=new int[value.length];
        for(int i=0;i<value.length;i++){
            vi[i]=Integer.parseInt(value[i]);
        }
        Arrays.sort(vi);

        System.out.println(" 1. Min-MAx \n 2. Z-Score \n 3. Decimal");
        int n=sc.nextInt();
        switch(n){
            case 1:System.out.println("Enter Value");
                    int v=sc.nextInt();
                    System.out.println("Enter Range");
                    int newMin=sc.nextInt();
                    int newMax=sc.nextInt();
                    min_max(vi[0],vi[value.length-1],newMin,newMax,v);
                    break;
            case 2:System.out.println("Enter Value");
                   int vk=sc.nextInt();
                    z_score(vi,vk);
                    break;
            case 3:decimal(vi);
                    break;
        }
    }
    public static void min_max(int min,int max,int newMin,int newMax,int v){
        float vc;
        vc=((float)(v-min)/(max-min))*(newMax-newMin)+newMin;
        System.out.println(vc);
    }
    public static void z_score(int vi[],int v) {
        float vc;
        int sum=0;
        for(int i=0;i<vi.length;i++){
            sum+=vi[i];
        }
        float abar=(float)sum/vi.length;
        System.out.println(abar+" ladl");
        float sa=0;
        float sigA;
        for(int i=0;i<vi.length;i++){
            sa+=(vi[i]-abar)*(vi[i]-abar);
        }
        sigA=(float) Math.pow(sa/vi.length, 0.5);
        vc=(v-abar)/sigA;
        System.out.println(vc);
    }
    public static void decimal(int vi[]) {
        int j=Integer.toString(vi[vi.length-1]).length();
        System.out.println("l:"+j);
        double vc[]=new double[vi.length];
        for(int i=0;i<vi.length;i++){
            vc[i]=((float)vi[i])/(Math.pow(10,j));
            System.out.println(vc[i]);
        }        
    }
}
