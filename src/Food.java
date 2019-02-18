

public class Food {
    private String shop ,name ,maker, group , composition, price;

    public Food(){
    }

    public static Food initialize(){
        return new Food();
    }

    public Food setShop(String shop) {
        this.shop = shop;
        return this;
    }

    public Food setName(String name) {
        this.name = name;
        return this;
    }

    public Food setMaker(String maker) {
        this.maker = maker;
        return this;
    }

    public Food setGroup(String group) {
        this.group = group;
        return this;
    }

    public Food setComposition(String composition) {
        this.composition = composition;
        return this;
    }

    public Food setPrice(String price) {
        this.price = price;
        return this;
    }

    public void print(){
        System.out.println("В магазине " + shop + " продается " + name + " от производителя " + maker + " принадлежащий к группе товаров " +
                group + " состоящий из " + composition + " по цене " + price + "\n");
    }
}
