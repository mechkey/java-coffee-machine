package machine;

import java.util.Scanner;  // Import the Scanner class

public class CoffeeMachine {
    public static int money = 550;
    public static int water = 400;
    public static int milk = 540;
    public static int coffee = 120;
    public static int cups = 9;
    public static int price = 0;
    public static int reqWater = 0;
    public static int reqMilk = 0;
    public static int reqCoffee = 0; 
    public static boolean enoughStock = true; 
    public static boolean on = true; 
        
    public static void printStock() {
     	String stockTemplate = "The coffee machine has:\n%s of water\n%s of milk\n%s of coffee beans\n%s of disposable cups\n$%s of money";  
     	System.out.println(String.format(stockTemplate, water, milk, coffee, cups, money));
    }
    
    public static boolean checkStock(int reqWater, int reqMilk, int reqCoffee) {
        if (water < reqWater) {
            System.out.println("Sorry, not enough water!");
            enoughStock = false;
        } else if (milk < reqMilk) {
            System.out.println("Sorry, not enough milk!");
            enoughStock = false;
        } else if (coffee < reqCoffee) {
            System.out.println("Sorry, not enough coffee!");
            enoughStock = false;
        } else if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            enoughStock = false;
        } else {
            enoughStock = true;
        }
        return enoughStock;

    }

    public static void makeCoffee () {
        water -= reqWater;
        milk -= reqMilk;
        coffee -= reqCoffee;
        cups--;
        money += price;
        System.out.println("I have enough resources, making you a coffee!");
    }
    
    public static void main(String[] args) {
        //method for printing current stock levels, required before and after each operation
        enoughStock = true;
        on = true;
        while(on) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");    
            Scanner sc = new Scanner(System.in);  // Create a Scanner object       
            String init = sc.nextLine();      
            switch (init) {
                case "buy" :
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String coffeetyp = sc.nextLine();
                    switch (coffeetyp) {
                        case "1" :
                            //espresso : 250 ml of water and 16 g of coffee beans. It costs $4.
                            price = 4;
                            reqWater = 250;
                            reqCoffee = 16;
                            reqMilk = 0;
                        
                            checkStock(reqWater, reqMilk, reqCoffee);
                            if (enoughStock) {
                                makeCoffee();
                            }
                            break;
                            
                        case "2" :
                            //latte : 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
                            price = 7;
                            reqWater = 350;
                            reqMilk = 75;
                            reqCoffee = 20;
         
                            checkStock(reqWater, reqMilk, reqCoffee);
                            if (enoughStock) {
                                makeCoffee();
                            }
                            break;
                            
                        case "3" :
                            //cappuccino : 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
                            price = 6;
                            reqWater = 200;
                            reqMilk = 100;
                            reqCoffee = 12;
                            
                            checkStock(reqWater, reqMilk, reqCoffee);
                            if (enoughStock) {
                                makeCoffee();
                            }
                            break;
                    }            
                    break;
                    
                case "fill" : 
                    System.out.println("Write how many ml of water do you want to add:");
                    water += sc.nextInt();
                    System.out.println("Write how many ml of milk do you want to add:");
                    milk += sc.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    coffee += sc.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    cups += sc.nextInt();
                    break;
                    
                case "take" :
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                    
                case "remaining" :
                    printStock();
                    break;
                
                case "exit" :
                    on = false;
                    break;
            }
        }
    }  
}
