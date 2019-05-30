import java.util.*;
import java.io.*;

class Character { 
    protected String name;
    public Character(String nm) {name = nm;}
    public void print()         {/*overide this method in child class*/}
}

class Princess extends Character{ 
    protected int age,oage;
    public Princess(String nm,int a,int y) {
        super(nm);
        age=2019-a;
        oage = y;
        age=age+oage;
    }
    @Override
     public void print(){
        System.out.printf("%-15s current age = %d\n", super.name, age);
    }
}

class Superhero extends Character{ 
    protected double gross;
    public Superhero(String nm, double s) {
        super(nm);
        gross = s;
    }
    @Override
     public void print(){
      System.out.printf("%-30s \t total gross = %.1fM$\n", super.name, gross);
    }
}
        
class RealPerson extends Character{ 
    protected int[] years;
    public RealPerson(String nm, int []y) {
        super(nm);
        years=y;
        Arrays.sort(years);
    }
    @Override
     public void print(){
      System.out.printf("%-45s \t\tmovies = ", super.name);
         for(int i=0;i<years.length;i++)
         {
         System.out.printf("%d, ",years[i] );                
         }
         System.out.printf("\n" );
      }
}        
        

public class Exercise4 {
    public static void main(String[] args) 
    {
        String infile = "Character.txt";
        Character [] CH = new Character[10];
        try
        {
            Scanner scan = new Scanner(new File(infile));
            for(int i=0;i<10;i++) 
            {
                String line = scan.nextLine();
                String [] buf = line.split(",");
                if(buf[0].equals("P")){ 
                    int age = Integer.parseInt(buf[2].trim());
                    int year = Integer.parseInt(buf[3].trim());
                    CH[i] = new Princess(buf[1],age,year);
                }
                else if(buf[0].equals("S")){
                   double sum = 0;
                   double [] g = new double[buf.length-2];
                   for(int j = 2; j < buf.length; j++)
                   { g[j-2]  = Double.parseDouble(buf[j].trim());
                     sum = sum+g[j-2];
                   }
                    CH[i] = new Superhero(buf[1],sum);
                }
                else if(buf[0].equals("R")){
                   int[] years = new int[buf.length-2];
                   for(int j = 2; j < buf.length; j++)
                   { 
                    years[j-2] = Integer.parseInt(buf[j].trim());
                   }
                   CH[i] = new RealPerson(buf[1],years);
                }
            }
            for (int i = 9; i >= 0; i--)
            {
                CH[i].print();
            }
        }catch(Exception e)
            { 
                System.err.println(e);
            }
    }
}