import java.util.*;

// ================= PRODUCT =================
class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private double discountPercentage;

    public Product(int id, String name, String category, double price, double discountPercentage) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.discountPercentage = discountPercentage;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public double getDiscountPercentage() { return discountPercentage; }

    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountedPrice() {
        return price - (price * discountPercentage / 100);
    }

    public void display() {
        System.out.println(
            id + " | " + name + " | " + category +
            " | Price: ₹" + price +
            " | Discount: " + discountPercentage + "%" +
            " | Final: ₹" + getDiscountedPrice()
        );
    }
}

// ================= CART ITEM =================
class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double actualTotal() {
        return product.getPrice() * quantity;
    }

    public double discountedTotal() {
        return product.getDiscountedPrice() * quantity;
    }

    public double discountAmount() {
        return actualTotal() - discountedTotal();
    }
}

// ================= CART =================
class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product p, int qty) {
        for (CartItem item : items) {
            if (item.product.getId() == p.getId()) {
                item.quantity += qty;
                return;
            }
        }
        items.add(new CartItem(p, qty));
    }

    public void removeProduct(int id) {
        boolean removed = items.removeIf(i -> i.product.getId() == id);
        System.out.println(removed ? "✅ Product removed" : "❌ Product not found in cart");
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("🛒 Cart is empty");
            return;
        }
        System.out.println("\n🛒 CART ITEMS");
        for (CartItem item : items) {
            System.out.println(
                item.product.getName() + " x " + item.quantity +
                " | Actual: ₹" + item.actualTotal() +
                " | Discounted: ₹" + item.discountedTotal()
            );
        }
    }

    public double getActualTotal() {
        double sum = 0;
        for (CartItem i : items) sum += i.actualTotal();
        return sum;
    }

    public double getDiscountTotal() {
        double sum = 0;
        for (CartItem i : items) sum += i.discountAmount();
        return sum;
    }

    public double getFinalTotal() {
        return getActualTotal() - getDiscountTotal();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

// ================= SHOP =================
class Shop {
    private List<Product> products = new ArrayList<>();

    public Shop() {
        products.add(new Product(1, "Laptop", "Electronics", 60000, 10));
        products.add(new Product(2, "Headphones", "Electronics", 2000, 5));
        products.add(new Product(3, "Shoes", "Fashion", 3000, 15));
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("✅ Product added");
    }

    public void removeProduct(int id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        System.out.println(removed ? "✅ Product removed" : "❌ Product not found");
    }

    public void updateProduct(int id, Scanner sc) {
        Product p = searchById(id);
        if (p == null) {
            System.out.println("❌ Product not found");
            return;
        }

        System.out.println("\n1. Rename");
        System.out.println("2. Change Category");
        System.out.println("3. Change Price");
        System.out.println("4. Change Discount");
        System.out.print("Choice: ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1 -> { System.out.print("New Name: "); p.setName(sc.nextLine()); }
            case 2 -> { System.out.print("New Category: "); p.setCategory(sc.nextLine()); }
            case 3 -> { System.out.print("New Price: "); p.setPrice(sc.nextDouble()); }
            case 4 -> { System.out.print("New Discount %: "); p.setDiscountPercentage(sc.nextDouble()); }
            default -> System.out.println("Invalid choice");
        }
        System.out.println("✅ Product updated");
    }

    public void showAllProducts() {
        System.out.println("\n📦 PRODUCT LIST");
        for (Product p : products) p.display();
    }

    public Product searchById(int id) {
        for (Product p : products)
            if (p.getId() == id) return p;
        return null;
    }
}

// ================= ADMIN AUTH =================
class AdminAuth {
    private static final String USER = "admin";
    private static final String PASS = "admin123";

    public static boolean login(Scanner sc) {
        System.out.print("Enter Admin Username: ");
        String u = sc.next();
        System.out.print("Enter Admin Password: ");
        String p = sc.next();
        return u.equals(USER) && p.equals(PASS);
    }
}

// ================= MAIN =================
public class OnlineShoppingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop();
        Cart cart = new Cart();

        while (true) {
            System.out.println("\n======= ONLINE SHOPPING SYSTEM =======");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Select Role: ");
            int role = sc.nextInt();

            // ---------- ADMIN ----------
            if (role == 1 && AdminAuth.login(sc)) {
                while (true) {
                    System.out.println("\n----- ADMIN MENU -----");
                    System.out.println("1. Add Product");
                    System.out.println("2. Update Product");
                    System.out.println("3. Remove Product");
                    System.out.println("4. View Products");
                    System.out.println("5. Back");
                    System.out.print("Choice: ");
                    int ch = sc.nextInt();

                    if (ch == 1) {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Category: ");
                        String cat = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Discount %: ");
                        double dis = sc.nextDouble();
                        shop.addProduct(new Product(id, name, cat, price, dis));
                    }
                    else if (ch == 2) {
                        System.out.print("Product ID: ");
                        shop.updateProduct(sc.nextInt(), sc);
                    }
                    else if (ch == 3) {
                        System.out.print("Product ID: ");
                        shop.removeProduct(sc.nextInt());
                    }
                    else if (ch == 4) shop.showAllProducts();
                    else if (ch == 5) break;
                }
            }

            // ---------- CUSTOMER ----------
            else if (role == 2) {
                while (true) {
                    System.out.println("\n----- CUSTOMER MENU -----");
                    System.out.println("1. View Products");
                    System.out.println("2. Add to Cart");
                    System.out.println("3. Remove from Cart");
                    System.out.println("4. View Cart");
                    System.out.println("5. Checkout");
                    System.out.println("6. Back");
                    System.out.print("Choice: ");
                    int ch = sc.nextInt();

                    if (ch == 1) shop.showAllProducts();
                    else if (ch == 2) {
                        System.out.print("Product ID: ");
                        int id = sc.nextInt();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt();
                        Product p = shop.searchById(id);
                        if (p != null) cart.addProduct(p, qty);
                        else System.out.println("❌ Product not found");
                    }
                    else if (ch == 3) {
                        System.out.print("Product ID: ");
                        cart.removeProduct(sc.nextInt());
                    }
                    else if (ch == 4) cart.displayCart();
                    else if (ch == 5) {
                        if (cart.isEmpty()) System.out.println("🛒 Cart empty");
                        else {
                            cart.displayCart();
                            System.out.println("Actual Amount: ₹" + cart.getActualTotal());
                            System.out.println("Discount: ₹" + cart.getDiscountTotal());
                            System.out.println("Total Payable: ₹" + cart.getFinalTotal());
                            cart = new Cart();
                        }
                    }
                    else if (ch == 6) break;
                }
            }

            else if (role == 3) {
                System.out.println("👋 Thank you!");
                break;
            }
        }
    }
}
