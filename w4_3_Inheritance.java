// ----- (3) add prefix final
// ----- (5) add extends Baby
class Man3 
{
    protected  String  name;
    protected  String  surname;
    protected  int     age;

    // Constructor
    //public Man3()                             { }
    public Man3(String n, String s, int a)	{ name = n; surname = s; age = a; }

    public void    setName(String n)    { name = n; }
    public void    setAge(int a)	{ age = a; }
    public String  getName()		{ return name; }
    public String  getSurname()		{ return surname; }
    public int     getAge()		{ return age; }

    // ----- (4) add prefix final
    public void speak()	
    { 
	System.out.printf("My name is %s %s \n", getName(), getSurname()); 
    }
};

//////////////////////////////////////////////////////////////////////////////////////////
class Woman3 extends Man3
{
    protected  boolean single;
    protected  String  maiden;
    protected  Man3    husband;

    // Constructor
    public Woman3(String n, String s, int a)	
    { 
	super(n, s, a);

        // ----- (1) comment the call to super(...) and uncomment the following
	//name = n; surname = s; age = a; 

	single = true;
    }

    public void marriedTo(Man3 m)
    {
        // deep copy
	//husband = new Man3( m.getName(), m.getSurname(), m.getAge() );
        
        // shallow copy
        husband = m;
        
	maiden  = surname;
	surname = husband.getSurname();
	single  = false;
    }

    // ------ (2) method overriding - change prefix from public to protected
    public void speak()			
    { 
	if (single == true)
            super.speak();
	else 
        {
            System.out.printf("My name is %s %s %s \n", getName(), maiden, surname); 
            System.out.print("   Husband >> ");
            husband.speak();
        }
    }	
};

//////////////////////////////////////////////////////////////////////////////////////////
class Baby
{
    protected String nickname;
    
    private Baby(String n)                { nickname = n; }
    public static Baby createBaby(String n)        
    { 
        Baby bb = new Baby(n);
        return bb;
    }
    public void cry()
    {
        System.out.printf("Baby %s cries \n", nickname);
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
class w4_3_Inheritance
{
    public static void main(String[] args) 
    {
	// ----- (1) constructor chain
	Man3   John = new Man3("John", "Smith", 20);
	Woman3 Mary = new Woman3("Mary", "Lee", 20);
	John.speak();
	Mary.speak();


	// ----- (2) method overriding
	System.out.println("\n\n--- Test overriding ---");
	Mary.marriedTo(John); Mary.speak(); 
        //John.setName("Jack"); System.out.println(); Mary.speak();

        
        // ----- (5) class with private constructor
        System.out.println("\n\n--- Test private constructor ---");
        /*
        Baby Apple = new Baby("Apple");
        //Baby Apple = Baby.createBaby("Apple");
        Apple.cry();
        */

        
	// ----- (6) polymorphism
	System.out.println("\n\n--- Test polymorphism ---");
	/*
	Man3[] M = new Man3[4];
	M[0] = John;
	M[1] = Mary;
	M[2] = new Man3("Bruce", "Willis", 50);
        M[3] = new Woman3("Sandra", "Bullock", 40);
        
	for (int i=0; i < M.length; i++)  
            M[i].speak();
	*/
		
	System.out.println();
    }
}
