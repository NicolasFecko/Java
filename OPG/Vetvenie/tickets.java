public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("""
           Choose from tickets:
           1. Základný | €0.50
           2. Nezakladny | € 1.20
           3. Prešov | €2.50
           
           Your Choice: 
            """);

    int choice = input.nextInt();
    switch (choice) {
        case 1: System.out.println("You chose Základný ticket\n gimme €0.50");
        break;
        case 2: System.out.println("You chose Nezákladný ticket\n gimme €1.20");
        break;
        case 3: System.out.println("You chose Prešov ticket\n gimme €2.50");
        break;

        default:
        System.out.println("Invalid choice");
    }

    System.out.print("Enter money: ");
    float money = input.nextFloat();


    if (choice == 1) {
        if (money < 0.5) {
            System.out.println("not enough money");
        }
        System.out.println("Thank you for taking the bus");
        float refund = (float) (money - 0.5);
        System.out.println("Here's your money back: €" + refund);
    }
    else if (choice == 2) {
        if (money < 1.2) {
            System.out.println("not enough money");
        }
        System.out.println("Thank you for taking the bus");
        float refund = (float) (money - 1.2);
        System.out.println("Here's your money back: €" + refund);
    }
    else if (choice == 3) {
        if (money < 2.5) {
            System.out.println("not enough money");
        }
        System.out.println("Thank you for taking the bus");
        float refund = (float) (money - 2.5);
        System.out.println("Here's your money back: €" + refund);
    }

    else{
        System.out.println("Invalid choice");
    }
}