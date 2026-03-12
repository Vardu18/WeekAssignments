//1. Username Availability Checker
import java.util.*;

public class UsernameChecker {
    static HashMap<String, Integer> users = new HashMap<>();
    static HashMap<String, Integer> attempts = new HashMap<>();

    static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    static List<String> suggest(String username) {
        List<String> list = new ArrayList<>();
        list.add(username + "1");
        list.add(username + "2");
        list.add(username + "_123");
        return list;
    }

    public static void main(String[] args) {
        users.put("john_doe", 1);

        System.out.println(checkAvailability("john_doe"));
        System.out.println(checkAvailability("jane_smith"));
        System.out.println(suggest("john_doe"));
    }
}


//2. Flash Sale Inventory Manager
import java.util.*;

public class InventoryManager {

    static HashMap<String, Integer> stock = new HashMap<>();
    static Queue<Integer> waitingList = new LinkedList<>();

    static void checkStock(String product) {
        System.out.println("Stock: " + stock.getOrDefault(product, 0));
    }

    static void purchase(String product, int userId) {
        int s = stock.getOrDefault(product, 0);

        if (s > 0) {
            stock.put(product, s - 1);
            System.out.println("Purchase success. Remaining: " + (s - 1));
        } else {
            waitingList.add(userId);
            System.out.println("Added to waiting list");
        }
    }

    public static void main(String[] args) {
        stock.put("IPHONE15", 2);

        purchase("IPHONE15", 1);
        purchase("IPHONE15", 2);
        purchase("IPHONE15", 3);
    }
}

//3. DNS Cache with TTL


class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

public class DNSCache {

    static HashMap<String, DNSEntry> cache = new HashMap<>();

    static String resolve(String domain) {

        if (cache.containsKey(domain)) {
            DNSEntry e = cache.get(domain);

            if (System.currentTimeMillis() < e.expiry) {
                return "Cache HIT: " + e.ip;
            }
        }

        String newIP = "192.168.1.1";
        cache.put(domain, new DNSEntry(newIP, 10));
        return "Cache MISS: " + newIP;
    }

    public static void main(String[] args) {
        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }
}

//4. Plagiarism Detector (Simple Version)
public class PlagiarismDetector {

    static Set<String> getWords(String text) {
        return new HashSet<>(Arrays.asList(text.split(" ")));
    }

    static double similarity(String d1, String d2) {

        Set<String> s1 = getWords(d1);
        Set<String> s2 = getWords(d2);

        int match = 0;

        for (String w : s1) {
            if (s2.contains(w))
                match++;
        }

        return (match * 100.0) / s1.size();
    }

    public static void main(String[] args) {

        String doc1 = "java is easy to learn";
        String doc2 = "java is powerful and easy";

        System.out.println("Similarity: " + similarity(doc1, doc2) + "%");
    }
}

//5.Website Analytics Dashboard
public class WebAnalytics {

    static HashMap<String, Integer> pageViews = new HashMap<>();

    static void processEvent(String url) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);
    }

    static void showTopPages() {
        for (String page : pageViews.keySet()) {
            System.out.println(page + " -> " + pageViews.get(page));
        }
    }

    public static void main(String[] args) {
        processEvent("/news");
        processEvent("/news");
        processEvent("/sports");

        showTopPages();
    }
}
