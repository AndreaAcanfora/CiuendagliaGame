package CiuendagliaGame;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Player> Users;
    public static Player UserIn;

    public static void sortArray() {
        int i, N;
        N = Main.Users.size();
        boolean s;
        do {
            s = false;
            for (i = 0; i < N - 1; i++) {
                if (Main.Users.get(i).getPoints() < Main.Users.get(i + 1).getPoints()) {
                    Main.scambio(Main.Users.get(i), Main.Users.get(i + 1));
                    s = true;

                }
            }

        } while (s);
    }

    public static void scambio(Player a, Player b) {
        Player app = new Player(a.getNickName(), a.getPoints(), a.getID(), a.getSeconds());
        a.setNickName(b.getNickName());
        a.setID(b.getID());
        a.setPoints(b.getPoints());
        a.setSeconds(b.getSeconds());
        b.setNickName(app.getNickName());
        b.setID(app.getID());
        b.setPoints(app.getPoints());
        b.setSeconds(app.getSeconds());
    }

    public static void saveUsers() throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserScores.stv"));
        out.writeObject(Main.Users);
        out.close();

    }

    public static void loadUsers() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserScores.stv"));
        Main.Users = (ArrayList<Player>) in.readObject();
        in.close();
    }

    public static void main(String[] args) throws IOException {
        try {
            Main.loadUsers();
        } catch (Exception ex) {
            System.out.println("File of Users not found, Creating a new one");
            Main.Users = new ArrayList<>();
        } finally {
            Main.UserIn = new Player(null, 0, Main.Users.size() + 1, 0);
            GUI f = new GUI();
            Thread tf = new Thread(f);
            tf.start();
        }

    }

}
