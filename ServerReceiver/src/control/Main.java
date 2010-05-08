package control;

import model.Server;

class Point  {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void change(Point p) {
        p = new Point(p.x,p.y);
        p.x = p.x + 2;
        p.y = p.y + 2;
    }

    public void print() {
        System.out.println("("+x+","+y+")");
    }
}





/**
 *
 * @author riza
 */
public class Main {
    public static void main(String [] args) {
        String[] tStrings = { "aku", "anak", "sehat", ",tubuhku" , "kuat" } ;
        String tAll = "";
        for(int i = 0; i < tStrings.length; ++i) {
            tAll = tStrings[i] + " ";
        }
        System.out.println(tAll);



        //while(true) {
            try {
                Server tServer = new Server(true);
                tServer.start();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("\n Restarting Server");
            }
        //}
    }
}
