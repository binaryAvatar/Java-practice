import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        boolean restart = true;

        while(restart){
//        Je demande le numéro pour faire la conversion:

        System.out.println("Choisissez un numéro.");
        String toConvert = keyboard.next();
        System.out.println("Vous avez choisi "+ toConvert+". Précisez dans dans quel base il est actuellement.");
        int oldBase = keyboard.nextInt();

       /* Si la base est 10, je demande vers quelle base il faut transformer.
        Si autre base que 10, la seule possibilité de conversion est vers le décimal:*/

        if (oldBase == 10) {
        System.out.println("Dans quelle base souhaitez-vous le passer?");
        int newBase = keyboard.nextInt();
            System.out.println("Vous souhaitez passer " + toConvert + " de la base " + oldBase + " vers la base "+ newBase +".");
            System.out.println("Le résultat de la conversion vers la base " + newBase + " est:" + convertFromDecimal(toConvert, newBase));
                    } else {
            System.out.println("Vous souhaitez passer de la base " + oldBase + " vers la base 10.");
            System.out.println("Le résultat de la conversion vers la base 10 est:" + convertToDecimal(toConvert, oldBase));
        }

//        Je demande à l'utilisateur s'il veut introduire d'autres numéros ou s'il veut arrêter:

            System.out.println("Voulez-vous essayer de nouveau? Répondez y/n");
             String answer = keyboard.next();

            if(answer.equals("n")){
                restart = false;
                keyboard.close();
            }
        }
     }

/*     J'applique les algorithmes vus cette semaine au cours:

     Pour aller du décimal vers la base demandé par l'utilisateur:*/

        public static String convertFromDecimal(String a, int b){
            int q = Integer.parseInt(a);
            StringBuilder toRevert= new StringBuilder();
            StringBuilder result= new StringBuilder();

            while(q>0){
                String r = String.valueOf(q%b);
                q/=b;
                toRevert.append(r);
                }

            for (int i = toRevert.length()-1; i >=0 ; i--) {
                result.append(toRevert.charAt(i));
            }
            return result.toString();
            }
//        La conversion dans l'autre sens, vers le décimal àpd'une base donnée par l'utilisateur:

    public static int convertToDecimal(String a, int b){
        int x= Integer.parseInt(String.valueOf(a.charAt(0)));

        for (int i = 1; i < a.length(); i++) {
            int y= Integer.parseInt(String.valueOf(a.charAt(i)));
               x = x * b + y;
        }
        return x;
    }
}