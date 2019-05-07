import java.util.*;
 
 
public class Blackjack{
   
public static void main (String [] args) {
    String player_name;
    String check;
    int losX, losY;
    int isEnd = 0;
    boolean flag = false; // checking are points are equal
    int draw; // checking are points are equal
   
   
    ArrayList<ArrayList<Card>> Cards = new ArrayList<ArrayList<Card>>(); //Array of cards
    ArrayList<Player> Player = new ArrayList<Player>(); //Array of players
   
    Random rand = new Random();
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the number of players: ");   
    int count = scan.nextInt();
    String[] kolory = {"heart", "diamond", "club", "spade"};
    int[] values = {2,3,4,5,6,7,8,9,10,2,3,4,11};//Points from cards, 2nd two is jack, 2nd three is queen, 2nd four is king
 
 
    //Creating players
        for(int a = 0; a < count; a++)
        {
            System.out.print("Enter the player name: ");
            player_name = scan.next();
            Player.add(new Player(player_name, true));
            isEnd++;
        }
   
            //Complete cards
            for(int x = 0; x < 13; x++)
            {
                Cards.add(new ArrayList<Card>());
                for(int y = 0; y < 4; y++)
                {
                    Cards.get(x).add(new Card(values[x], kolory[y], false));
                }  
            }
           
   
    //game 'engine'
   
    for (int presplayer = 0; presplayer < Player.size(); presplayer++)
    {
       
        if(Player.get(presplayer).getPlay() == true)
        {
            System.out.print("Player move: " + Player.get(presplayer).getName() + " ");
           
            do
            {
                losX = rand.nextInt(13);
                losY = rand.nextInt(4);
                if(Cards.get(losX).get(losY).getLos() == false)
                {
                    System.out.print((Cards.get(losX).get(losY).getValue() + " " + Cards.get(losX).get(losY).getKolor() + "\n"));
                    break;
                }
                else
                {
                    continue;
                }
            }while(true);
               
            Cards.get(losX).get(losY).setState(true);
           
            Player.get(presplayer).setPunkty(Cards.get(losX).get(losY).getValue());
            System.out.print("\n" + "Number of points: " + Player.get(presplayer).getPoints());
            if(Player.get(presplayer).getPoints() == 21)
            {
                System.out.print("You won!" + "\n");
                Player.get(presplayer).setPlay(false);
            }
            else if(Player.get(presplayer).getPoints() > 21)
            {
                System.out.print("You lost!" + "\n");
                Player.get(presplayer).setPlay(false);
            }
            else if(Player.get(presplayer).getPoints() < 21)
            {
            System.out.println("\n" + "Press 's' to stop playing: ");
            check = scan.next();
            int ascii = check.charAt(0);
           
                if(ascii == 115)
                {
                    Player.get(presplayer).setPlay(false);
                    isEnd--;
                }
            }
           
           
            if(presplayer == Player.size() - 1)
            {
                presplayer = -1;
            }
           
            if(isEnd == 0)
            {
                Collections.sort(Player);
                break;
            }
    }
}
    draw = Player.get(0).getPoints();
    for(int i = 1; i < Player.size(); i++)
    {
        if(Player.get(i).getPoints() == draw)
        {
            flag = true;
        }
        else
        {
            flag = false;
            break;
        }
    }
    if(flag == true)
    {
        System.out.print("\n" + "Draw");
    }
    else
    {
        System.out.println("\n\n" + "The winner is: " + Player.get(0).getName() + " " +  Player.get(0).getPoints());
    }
}
}