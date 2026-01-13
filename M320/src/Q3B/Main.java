package Q3B;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FriendGraph fg = new FriendGraph();

        fg.addFriendship("Mert", "Euron");
        fg.addFriendship("Mert", "Eric");
        fg.addFriendship("Eric", "Benji");
        fg.addFriendship("Benji", "Euron");
        fg.addFriendship("Euron", "Eric");

        fg.setHasCar("Benji", true);
        Set<String> mertCircle = fg.getFriendCircle("Mert");
        System.out.println("Freundeskreis von Mert: " + mertCircle);
        String carOwner = fg.findNearestPersonWithCar("Mert");

        if (carOwner != null) {
            System.out.println("Nächste Person mit Auto: " + carOwner);
        } else {
            System.out.println("Niemand im Freundeskreis hat ein Auto :(");
        }
    }
}
