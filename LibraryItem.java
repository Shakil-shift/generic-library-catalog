public class LibraryItem<T> {
    private final String title;
    private final String author;
    private final String itemID;
    private final T extraInfo;

    public LibraryItem(String title, String author, String itemID, T extraInfo) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
        this.extraInfo = extraInfo;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getItemID() { return itemID; }
    public T getExtraInfo() { return extraInfo; }

    @Override
    public String toString() {
        return String.format("ID: %s | Title: \"%s\" | Author: %s | Info: %s",
                itemID, title, author, extraInfo);
    }
}