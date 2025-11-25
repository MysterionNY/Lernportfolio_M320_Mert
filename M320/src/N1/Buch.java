package N1;

public class Buch {
    private String title;
    private String author;
    private int year;
    private boolean lend;

    public Buch(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.lend = false;
    }

    public boolean lending() {
        if (!lend) {
            lend = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean zurueckgeben() {
        if (lend) {
            lend = false;
            return true;
        } else {
            return false;
        }
    }

    public void show() {
        String status = lend ? "ausgeliehen" : "verfügbar";
        System.out.println("titel " + title + " | autor: " + author +
                " | jahr: " + year + " | Status: " + status);
    }

    public String getTitle() {
        return title;
    }

    public boolean isLend() {
        return lend;
    }
}