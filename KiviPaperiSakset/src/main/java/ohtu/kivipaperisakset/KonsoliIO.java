
package ohtu.kivipaperisakset;

import java.util.Scanner;

class KonsoliIO implements IO {
    private static final Scanner lukija = new Scanner(System.in);
    
    @Override
    public void println(String print) {
        System.out.println(print);
    }
    @Override
    public void print(String print) {
        System.out.print(print);
    }

    @Override
    public void println() {
        System.out.println("");
    }
    
    @Override
    public String lueSyote() {
        return lukija.nextLine();
    }
    
}
