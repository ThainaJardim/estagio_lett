package scraper;

public class Product {

    private String pageProduct;
    private String available;
    private String tagName ;
    private String tagPrice;
    private String tagImage;

    //str.substring(indexStart[, indexEnd])




    public Product() {

    }


    public String getPageProduct() {
        return pageProduct;
    }

    public String setPageProduct(String pageProduct) {
        this.pageProduct = pageProduct;
        return pageProduct;
    }

    public String getAvailable() {
        return available;
    }

    public String setAvailable(String available) {
        this.available = available;
        return available;
    }

    public String getTagName() {
        return tagName;
    }

    public String setTagName(String tagName) {
        this.tagName = tagName;
        return tagName;
    }

    public String getTagPrice() {
        return tagPrice;
    }

    public String setTagPrice(String tagPrice) {
        this.tagPrice = tagPrice;
        return tagPrice;
    }

    public String getTagImage() {
        return tagImage;
    }

    public String setTagImage(String tagImage) {
        this.tagImage = tagImage;
        return tagImage;
    }
}
