package Max_Price_Package;

import java.util.*;


class Product {
    public int weight;
    public int price;
    public double avg;

    public Product(int weight, int price) {
        this.weight = weight;
        this.price = price;
        this.avg = (double) this.price / this.weight;
    }
}

/**
 * 背包能装的最大价值
 */
public class Main {

    private static int Package_Max_Price(int packageSize, Product[] products) {

        Arrays.sort(products, (a, b) -> {
            return Double.compare(b.avg, a.avg);
        });

        double max_prices = 0;
        for(int offset = 0; offset < products.length; offset ++) {
            packageSize -= products[offset].weight;
            if(packageSize >= 0) {
                max_prices += products[offset].price;
            } else {
                int full_weight = products[offset].weight + packageSize;
                max_prices += full_weight * products[offset].avg;
                break;
            }
        }
        return (int)max_prices;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().trim().split(",");
        String[] line2 = scanner.nextLine().trim().split(",");
        String[] line3 = scanner.nextLine().trim().split(",");

        int product_num = Integer.parseInt(line1[0]);
        int max_weight = Integer.parseInt(line1[1]);

        Product[] products = new Product[product_num];
        for(int i = 0; i < product_num; i++) {
            products[i] = new Product(Integer.parseInt(line2[i]), Integer.parseInt(line3[i]));
        }

        int max_prices = Package_Max_Price(max_weight, products);
        System.out.println(max_prices);
    }
    
}
