package com.majime.shopc.model;

import java.util.ArrayList;

public class User extends Account {
    private String name, address, gender;
    private int age, saldo;
    private ArrayList<Product> productsOnDelivery;
    private ArrayList<Product> productsOnCart;

    public User() {
        super();
        this.name = "name";
        this.address = "address";
        this.gender = "gender";
        this.age = 0;
        this.saldo = 0;
        this.productsOnDelivery = new ArrayList<>();
        this.productsOnCart = new ArrayList<>();
    }

    public User(String username, String password, String name, String address, String gender,
            int age, int saldo) {
        super(username, password);
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.saldo = saldo;
        this.productsOnDelivery = new ArrayList<>();
        this.productsOnCart = new ArrayList<>();
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Product> getProductsOnDelivery() {
        return this.productsOnDelivery;
    }

    public Product getProductOnDelivery(String nameProduct) {
        for(Product product: this.productsOnDelivery) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    public void addProductOnDelivery(Product product) {
        this.productsOnDelivery.add(product);
    }

    public void addProductOnDelivery(ArrayList<Product> products) {
        this.productsOnDelivery.addAll(products);
    }

    public boolean removeProductOnDelivery(String nameProduct) {
        int i = 0;
        for(Product product: this.productsOnDelivery) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                this.removeProductOnDelivery(i);

                return true;
            }

            i++;
        }
        return false;
    }

    public boolean removeProductOnDelivery(int index) {
        if(index < 0 || index >= this.productsOnDelivery.size()) {
            return false;
        }

        this.productsOnDelivery.remove(index);
        return true;
    }

    public boolean removeAllProductOnDelivery() {
        if(this.productsOnDelivery.size() == 0) return false;

        for(int i = this.productsOnDelivery.size(); i >= 0; i--) {
            this.removeProductOnDelivery(i);
        }

        return true;
    }

    public int amountProductOnDelivery() {
        return this.productsOnDelivery.size();
    }

    public ArrayList<Product> getProductsOnCart() {
        return this.productsOnCart;
    }

    public Product getProductOnCart(String nameProduct) {
        for(Product product: this.productsOnCart) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    public void addProductOnCart(Product product) {
        this.productsOnCart.add(product);
    }

    public void addProductOnCart(ArrayList<Product> products) {
        this.productsOnCart.addAll(products);
    }

    public boolean removeProductOnCart(String nameProduct) {
        int i = 0;
        for(Product product: this.productsOnCart) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                this.removeProductOnCart(i);

                return true;
            }

            i++;
        }
        return false;
    }

    public boolean removeProductOnCart(int index) {
        if(index < 0 || index >= this.productsOnCart.size()) {
            return false;
        }

        this.productsOnCart.remove(index);
        return true;
    }

    public boolean removeAllProductOnCart() {
        if(this.productsOnCart.size() == 0) return false;

        for(int i = this.amountOfCartProduct(); i >= 0; i--) {
            this.removeProductOnCart(i);
        }

        return true;
    }

    public int amountOfCartProduct() {
        return this.productsOnCart.size();
    }

    public int getPriceCartProduct() {
        int total = 0;

        for(Product product : this.productsOnCart) {
            total += product.getPrice();
        }

        return total;
    }

}