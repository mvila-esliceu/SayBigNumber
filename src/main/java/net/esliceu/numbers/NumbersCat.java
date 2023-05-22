package net.esliceu.numbers;


public class NumbersCat implements Numbers {

    static String[] unitats = {"zero", "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit", "nou"};
    static String[] decenes = {"", "deu", "vint", "trenta", "quaranta", "cinquanta", "seixanta", "setanta", "vuitanta", "noranta"};
    static String[] primeraDecena = {"deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze", "disset", "divuit", "dinou"};

    public String say(long number) {
        if (number == 0) {
            return "Zero";
        }

        String nombre = "";


        if (number < 0) {
            nombre += "Menys ";
        }

        long nombrePositiu = Math.abs(number);

        nombre += generaNombre(nombrePositiu);

        return nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
    }

    private String generaNombre(long nombre) {
        String nombreStr = "";
        if(nombre == 0) {
            return "";
        }
        /*
        if(nombre > 99) {
            int centena = (int) nombre / 100;
            nombreStr += cetenes[centena];
        } else {

         */
        if (nombre > 9) {
            int decena = (int) nombre / 10;
            nombreStr += decenes[decena];
            long unitat = nombre % 10;
            if (unitat > 0) {
                if (decena == 1) {
                    nombreStr = primeraDecena[(int) unitat];
                } else {
                    if (decena == 2) {
                        nombreStr += "-i";
                    }
                    nombreStr += "-" + generaNombre(unitat);
                }
            }
        } else {
            nombreStr += unitats[(int) nombre];
        }
        //}
        return nombreStr;
    }

    public static void main(String[] args) {
        long nombres = 99;
        long n = 0;
        /*
        while (n <= nombres) {
            System.out.println(n + " es diu: " + say(n));
            n++;
        }

        nombres = -nombres;
        while(nombres < 0) {
            System.out.println(nombres + " es diu: " + say(nombres));
            nombres++;
        }

         */
    }
}
