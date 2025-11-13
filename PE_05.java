import java.util.Scanner;

public class PE_05 {

    // Punt d'entrada 
    public static void main(String[] args) {
        PE_05 restaurant = new PE_05();
        restaurant.principal();
    }

    
    public void principal() {
        System.out.println("Benvolgut a Comandes March: ");
        int num = mainmenu();

        if (num == 1) {
            create();
        } else if (num == 2) {
            // pendent: update()
        }
        //Opcions 3 i 4.
    }

    // Metode Main menu
    public int mainmenu() {
        Scanner askoption = new Scanner(System.in);

        System.out.println("1) Create a new order:");
        System.out.println("2) Update the last order:");
        System.out.println("3) Show the latest order:");
        System.out.println("4) Exit");
        System.out.println("------------------------------");
        System.out.print("Choose an option (1,2,3 or 4): ");

        int num = askoption.nextInt();
        return num;
    }

    // Metode crear comanda
    public void create() {
        Scanner input = new Scanner(System.in);
        boolean addmore = true;
        String order = "";
        double total = 0;

        System.out.println("Creating a new order ..");

        do {
            System.out.print("Enter product name: ");
            String product = input.nextLine();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            System.out.print("Enter unit price: ");
            double price = input.nextDouble();
            input.nextLine(); // neteja buffer

            double subtotal = quantity * price;
            total += subtotal;

            // Alineació amb el producte.
            String productAlign = padRight(product, 15);

            // Taula resum
            String line =  productAlign + padQuantity(quantity) + padPrice(price) + padSubtotal(subtotal) + "\n";

            order += line;

            // Continuar afegint si/no.
            System.out.print("Add more? (yes/no): ");
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                addmore = false;
            }

        } while (addmore);

        // Resum de la comanda
        System.out.println();
        System.out.println("Producte    Quantitat   Preu unit.   Subtotal");
        System.out.println("-----------------------------------------------");
        System.out.print(order);
        System.out.println("-----------------------------------------------");
        System.out.println("Total: " + total + " EUR");
    }
 
    // Metode String per els espais a comanda (Producte).
    public String padRight(String p, int max) {
        String temporal = p;
        for (int i = p.length(); i < max; i++) {
            temporal = temporal + " ";
        }
        return temporal;
    }

    // Crida a padRight per reutilitzar el metode i no copiar codi.
    // Metode int per els espais a comanda (Quantitat).
    public String padQuantity(int q) {
    String text = String.valueOf(q); 
    return padRight(text, 12);
}


    // Metode double per els espais a comanda (Preu/unitat)
    public String padPrice(double price) {
    String text = price + " EUR";
    return padRight(text, 12);
}


    // Metode double per els espais a comanda (Subtotal)
    public String padSubtotal(double subtotal) {
    String text = subtotal + " EUR";
    return padRight(text, 12);
}




    //  Mètode: actualitzar
    public void update() {
        Scanner updatemenu = new Scanner(System.in);
        
    }
}
