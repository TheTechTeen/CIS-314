public class Random 
{
    public int x;
    
    public Random(int x)
    {
        this.x = x;
    }

    public static void main(String[] args) 
    {
        Random myRand = new Random(5);
        System.out.println(myRand.x);
    }
}
