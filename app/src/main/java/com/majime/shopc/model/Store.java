package com.majime.shopc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Store {

    private String name, address;
    private ArrayList<Product> products;

    public Store() {
        this.name = "ShoPC";
        this.address = "Address";
        this.products = new ArrayList<>();
    }

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.products = new ArrayList<>();
    }

    public Store(String name, String address, ArrayList<Product> products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public ArrayList<Product> getProductsBestSeller() {
        ArrayList<Product> productsBestSeller = new ArrayList<>();
        for(Product product : this.products) {
            if(product.getRating() >= 4) {
                productsBestSeller.add(product);
            }
        }

        return productsBestSeller;
    }

    public ArrayList<Product> getProductsByTitle(String title) {
        ArrayList<Product> products = new ArrayList<>();

        if(title.equals("Hardware")) {
            for(Product product : this.products) {
                if(product instanceof Hardware) {
                    products.add(product);
                }
            }
        } else {
            for(Product product : this.products) {
                if(product instanceof Software) {
                    products.add(product);
                }
            }
        }

        return products;
    }

    public Product getProduct(String nameProduct) {
        for(Product product : this.products) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addProducts(ArrayList<Product> products) {
        this.products.addAll(products);
    }

    public boolean removeProduct(String nameProduct) {
        int i = 0;
        for(Product product : this.products) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                this.removeProduct(i);

                return true;
            }

            i++;
        }
        return false;
    }

    public boolean removeProduct(int index) {
        if(index < 0 || index >= this.products.size()) {
            return false;
        }

        this.products.remove(index);
        return true;
    }

    public int amountOfProduct() {
        return this.products.size();
    }

    public int calculate(Shipping shipping, Payment payment) {
        int total = shipping.calculate(1) + payment.calculate(1);

        return total;
    }

    public int calculate(int size, Shipping shipping, Payment payment) {
        int total = shipping.calculate(size) + payment.calculate(products.size());

        return total;
    }

    public boolean buy(User user, Shipping shipping, Payment payment) {
        int totalPrice = 0;
        if(user.amountOfCartProduct() == 1)
            totalPrice = user.getPriceCartProduct() + calculate(shipping, payment);
        else totalPrice = user.getPriceCartProduct() +
                          calculate(user.amountOfCartProduct(), shipping, payment);

        if(payment instanceof Cash) {
            if(user.getSaldo() >= totalPrice) {
                // pembelian berhasil jika saldo user tersedia
                user.setSaldo(user.getSaldo() - totalPrice);
                user.addProductOnDelivery(user.getProductsOnCart());

                ArrayList<Product> productsSetArray =
                        new ArrayList<>(new HashSet<>(user.getProductsOnCart()));
                // mengurangi stok sesuai dengan barang yang dibeli user
                for(Product product : productsSetArray) {
                    int currentAmount = this.getProduct(product.getName()).getAmount();
                    int amountBuying =
                            Collections.frequency(user.getProductsOnCart(), product);
                    this.getProduct(product.getName()).setAmount(currentAmount - amountBuying);

                    if(this.getProduct(product.getName()).getAmount() == 0) {
                        this.removeProduct(product.getName());
                    }
                }

                user.removeAllProductOnCart();
                return true;
            }
        } else if(payment instanceof Debit) {
            // pembayaran lewat debit user
            user.addProductOnDelivery(user.getProductsOnCart());

            ArrayList<Product> productsSetArray =
                    new ArrayList<>(new HashSet<>(user.getProductsOnCart()));
            // mengurangi stok sesuai dengan barang yang dibeli user
            for(Product product : productsSetArray) {
                int currentAmount = this.getProduct(product.getName()).getAmount();
                int amountBuying = Collections.frequency(user.getProductsOnCart(), product);
                this.getProduct(product.getName()).setAmount(currentAmount - amountBuying);

                if(this.getProduct(product.getName()).getAmount() == 0) {
                    this.removeProduct(product.getName());
                }
            }

            user.removeAllProductOnCart();
            return true;
        }

        return false;
    }

}
