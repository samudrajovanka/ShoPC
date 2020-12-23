package com.majime.shopc.model;

import java.util.ArrayList;

public class User extends Account {
    private String name, address, gender;
    private int age, saldo;
    private ArrayList<Product> waitingListProducts;
    private ArrayList<Product> waitingCartProducts;

    public User() {
        super();
        this.name = "name";
        this.address = "address";
        this.gender = "gender";
        this.age = 0;
        this.saldo = 0;
        this.waitingListProducts = new ArrayList<Product>();
        this.waitingCartProducts = new ArrayList<Product>();
    }

    public User(String username, String password, String name, String address, String gender,
            int age, int saldo) {
        super(username, password);
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.saldo = saldo;
        this.waitingListProducts = new ArrayList<Product>();
        this.waitingCartProducts = new ArrayList<Product>();
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

    public ArrayList<Product> getWaitingListProducts() {
        return this.waitingListProducts;
    }

    public Product getWaitingListProduct(String nameProduct) {
        for(Product product: this.waitingListProducts) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    public void addWaitingListProduct(Product product) {
        this.waitingListProducts.add(product);
    }

    public void addWaitingListProduct(ArrayList<Product> products) {
        this.waitingListProducts.addAll(products);
    }

    public boolean removeWaitingListProduct(String nameProduct) {
        int i = 0;
        for(Product product: this.waitingListProducts) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                this.removeWaitingListProduct(i);

                return true;
            }

            i++;
        }
        return false;
    }

    public boolean removeWaitingListProduct(int index) {
        if(index < 0 || index >= this.waitingListProducts.size()) {
            return false;
        }

        this.waitingListProducts.remove(index);
        return true;
    }

    public boolean removeAllWaitingListProducts() {
        if(this.waitingListProducts.size() == 0) return false;

        for(int i = this.waitingListProducts.size(); i <= 0; i--) {
            this.removeWaitingListProduct(i);
        }

        return true;
    }

    public int amountOfWaitingProduct() {
        return this.waitingListProducts.size();
    }

    public ArrayList<Product> getWaitingCartProducts() {
        return this.waitingCartProducts;
    }

    public Product getWaitingCartProduct(String nameProduct) {
        for(Product product: this.waitingCartProducts) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    public void addWaitingCartProduct(Product product) {
        this.waitingCartProducts.add(product);
    }

    public void addWaitingCartProduct(ArrayList<Product> products) {
        this.waitingCartProducts.addAll(products);
    }

    public boolean removeWaitingCartProduct(String nameProduct) {
        int i = 0;
        for(Product product: this.waitingCartProducts) {
            if(product.getName().equalsIgnoreCase(nameProduct)) {
                this.removeWaitingCartProduct(i);

                return true;
            }

            i++;
        }
        return false;
    }

    public boolean removeWaitingCartProduct(int index) {
        if(index < 0 || index >= this.waitingCartProducts.size()) {
            return false;
        }

        this.waitingCartProducts.remove(index);
        return true;
    }

    public boolean removeAllWaitingCartProducts() {
        if(this.waitingCartProducts.size() == 0) return false;

        for(int i = this.amountOfCartProduct(); i >= 0; i--) {
            this.removeWaitingCartProduct(i);
        }

        return true;
    }

    public int amountOfCartProduct() {
        return this.waitingCartProducts.size();
    }

    public int getPriceCartProduct() {
        int total = 0;

        for(Product product : this.waitingCartProducts) {
            total += product.getPrice();
        }

        return total;
    }

}