//6. API Rate Limiter
import java.util.*;

public class RateLimiter {

    static HashMap<String, Integer> requests = new HashMap<>();
    static int LIMIT = 5;

    static void check(String client) {

        int count = requests.getOrDefault(client, 0);

        if (count < LIMIT) {
            requests.put(client, count + 1);
            System.out.println("Allowed");
        } else {
            System.out.println("Rate limit exceeded");
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 7; i++)
            check("client1");
    }
}

//7. Search Autocomplete
import java.util.*;

public class AutoComplete {

    static HashMap<String, Integer> queries = new HashMap<>();

    static void addQuery(String q) {
        queries.put(q, queries.getOrDefault(q, 0) + 1);
    }

    static void search(String prefix) {

        for (String q : queries.keySet()) {
            if (q.startsWith(prefix))
                System.out.println(q + " (" + queries.get(q) + ")");
        }
    }

    public static void main(String[] args) {

        addQuery("java tutorial");
        addQuery("java download");
        addQuery("javascript guide");

        search("jav");
    }
}

//8. Parking Lot (Linear Probing)
public class ParkingLot {

    static String[] table = new String[10];

    static int hash(String plate) {
        return plate.hashCode() % table.length;
    }

    static void park(String plate) {

        int index = Math.abs(hash(plate));

        while (table[index] != null) {
            index = (index + 1) % table.length;
        }

        table[index] = plate;
        System.out.println("Parked at " + index);
    }

    public static void main(String[] args) {

        park("ABC123");
        park("XYZ999");
    }
}





//9. Two Sum Transactions

public class TwoSum {

    static void findPair(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            int comp = target - num;

            if (map.containsKey(comp)) {
                System.out.println(comp + " + " + num);
                return;
            }

            map.put(num, 1);
        }
    }

    public static void main(String[] args) {

        int[] arr = {500, 300, 200};

        findPair(arr, 500);
    }
}

//10. Multi-Level Cache System


public class MultiLevelCache {

    static HashMap<String, String> L1 = new HashMap<>();
    static HashMap<String, String> L2 = new HashMap<>();

    static String getVideo(String id) {

        if (L1.containsKey(id))
            return "L1 HIT";

        if (L2.containsKey(id)) {
            L1.put(id, L2.get(id));
            return "L2 HIT -> moved to L1";
        }

        L2.put(id, "videoData");
        return "Loaded from DB";
    }

    public static void main(String[] args) {

        System.out.println(getVideo("vid1"));
        System.out.println(getVideo("vid1"));
    }
}
