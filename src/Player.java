public class Player implements Comparable {
 
    private String name;
    private int points;
    private boolean play;
   
    public void setName(String name)
    {
        this.name = name;
    }
   
    public void setPunkty(int point)
    {
        this.points += point;
    }
   
    public void setPlay(boolean a)
    {
        this.play = a;
    }
   
    public boolean getPlay()
    {
        return this.play;
    }
   
    public String getName()
    {
        return this.name;
    }
   
    public int getPoints()
    {
        return this.points;
    }
   
    Player(String player_name, boolean state)
    {
        this.name = player_name;
        this.play = state;
    }
   
    Player()
    {
       
    }
 
    @Override
    public int compareTo(Object argument) {
        int comparepkt = ((Player)argument).getPoints();
        return comparepkt-this.points;
    }
   
   
   
}