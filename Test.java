import java.util.*;
import java.io.*;

class FilmBase {
    protected String name;
    protected int age; // from release year to 2017
    public FilmBase(String n, int a) { name = n; age = a; }
    public void print() {  /*override this in child*/  }
    public int Rage(){return 2017-age;}
}

class Film extends FilmBase{
    protected String DIname;
    protected int dollar;
    public Film(String n, int a, String dname,int d) {super(n,a); DIname = dname; dollar=33*d;}
    @Override
    public void print(){
        System.out.printf("%-20s (%4d) director = %-20s opening gross = %4d million bahts\n", super.name, super.Rage(), DIname, dollar);
    }
}

class Animation extends FilmBase{
    protected int lengthMinutes;
    public Animation(String n, int a, int time) {super(n,a); lengthMinutes=time;}
    @Override
    public void print(){
        System.out.printf("%-20s (%4d) %d hrs, %d mins\n", super.name, super.Rage(), lengthMinutes/60, lengthMinutes%60);
    }
}


public class Test {
    public static void main(String[] args) {
        String infile = "input.txt";
        FilmBase [] FB = new FilmBase[10];
        try{
            Scanner scan  = new Scanner(new File(infile));
            for(int i=0;i<10;i++) 
            {
                String line = scan.nextLine();
                String [] buf = line.split(",");
                int age = Integer.parseInt(buf[2].trim());
                if(buf[0].equals("F")){
                    int money = Integer.parseInt( buf[4].trim());
                    FB[i] = new Film(buf[1], age, buf[3], money);
                }
                else{
                    int money = Integer.parseInt( buf[3].trim());
                    FB[i] = new Animation(buf[1], age, money);
                }
            }
        }catch(Exception e) {
            System.err.println("An error occurs. End program.");
        }
        for(int i = 9; i >= 0; i--) FB[i].print();
    }
}