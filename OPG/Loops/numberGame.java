public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int tajneCislo = 42;
    int pocetPokusov = 0;
    boolean isCorrect = false;


    while (!isCorrect) {
        System.out.print("Guess the Number: ");
        int guess = input.nextInt();

        if (guess == tajneCislo) {
            System.out.println("You guessed the number! " + "in " + pocetPokusov + " tries");
            isCorrect = true;
        }
        else if (guess > tajneCislo) {
            System.out.println("The number is lower");
            pocetPokusov++;
        }
        else if (guess < tajneCislo) {
            System.out.println("The number is higher");
            pocetPokusov++;
        }
    }


}