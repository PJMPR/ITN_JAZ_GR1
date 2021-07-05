package pl.pjatk.artdem.contract;


//Za pomocą Spring Initializr stwórz nowy projekt nazwany MovieRentalService, który będzie aplikacją webową.
//Zaprojektuj swój model filmu. Niech film posiada obowiązkowo ID, nazwę oraz kategorię. Reszta pól według uznania

public class Movie {

    private int id;
    private String title;
    private String category;
    private String year;
    private double price;
    private boolean isAvailable;

    public Movie(int id, String title, String category, String year, double price, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.year = year;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
