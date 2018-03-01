import java.util.Scanner;
public class Game{   
   public static void main(String[]args){
   
      // der laves en ny Rabbit og en ny Snake med f�lgende infomationer
      Rabbit rabbit1 = new Rabbit("Jacky", "American", "Blue", "Male", 2);
      Snake snake1 = new Snake("Jonny", "Anaconda", "Black", "Male", 4);  
   
   // der laves et punkt der representere kaninen
      Point rabbit = new Point(0,0);
   // der laves et punkt der representere slangen
      Point snake = new Point(10,10);
      snake.sound = "evil";
      rabbit.sound = "nice";
      rabbit.name = "rabbit";
      snake.name = "snake";
      int turns = 0;
      
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to group 5000's Little Animal Horror Zoo");
      System.out.println("Your goal is to avoid the snake for 15 turns");
      System.out.println("To control the rabbit, choose one of the  following commands");
      menuPrompt();
      
      int choice;
      do 
      {
         choice = input.nextInt();
         switch(choice){
            
            case 1:        ///kanin op     
               rabbit.move(1,0);
               
               rabbit.getX();
               snake.getX();
               if(rabbit.x<snake.x){
               snake.move(-1,0);
               }
               else if (rabbit.x>snake.x){
               snake.move(1,0);
               }
               ++turns;
               break;
                  

            case 2:        
               rabbit.move(-1,0);
               
               rabbit.getX();
               snake.getX();
               if(rabbit.x<snake.x){
               snake.move(-1,0);
               }
               else if (rabbit.x>snake.x){
               snake.move(1,0);
               }
               ++turns;               
               break;   

            case 3:        
               rabbit.move(0,-1);
               
               rabbit.getY();
               snake.getY();
               if(rabbit.y<snake.y){
               snake.move(0,-1);
               }
               else if (rabbit.y>snake.y){
               snake.move(0,1);
               }               
               break;
                  
            case 4:        
               ///kanin h�jre                 
               rabbit.move(0,1);
               
               rabbit.getY();
               snake.getY();
               if(rabbit.y<snake.y){
               snake.move(0,-1);
               }
               else if (rabbit.y>snake.y){
               snake.move(0,1);
               }
               ++turns;        
               break;
               
            case 5:
               rabbit1.printRabbitInfo();
               break;
            case 6:
               snake1.printSnakeInfo();
               break;
            case 0:
               System.out.println("You have given up\nThank you for playing.");
               break;
               
            default : 
               System.out.println("Group 5000 those not recognize your input, try again..");
            
            
         }
               // metode til at udregne afstanden mellem rabbit(x,y) og snake (x,y)
               // http://www.mathwarehouse.com/algebra/distance_formula/index.php 
               double dist = Math.sqrt(((snake.x - rabbit.x)*(snake.x - rabbit.x))+ ((snake.y - rabbit.y)*(snake.y-rabbit.y)));
               
               if (turns==15){
                  System.out.println("Congratulations, you avoided the snake for 15 turns\nGroup 5000 salutes you");
                  choice = 0;   
                  }
               
               if (dist < 2){
                  System.out.println("\nAahhhhrrrr i'm eating you!\nThe Snake has caught the Rabbit!\nIt took: "+turns+" turns.\n Better luck next time.."); 
                  choice = 0;  
                  }else if(dist < 3){
                  System.out.println("NOOOOO, Please don't eat me");
                  } 
      }while(choice !=0); 
   }
  private static void menuPrompt()
  {
               System.out.println("\n1: Move rabbit up");
               System.out.println("2: Move rabbit down");
               System.out.println("3: Move rabbit left");
               System.out.println("4: Move rabbit right");
               System.out.println("5: Tell me about the rabbit");
               System.out.println("6: Tell me about the snake");
               System.out.println("0: Give up");
  }
}