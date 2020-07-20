class Address {
    private String city;
    private String street;
    private String house;
    private int floor;

    public Address() {
    }

    public String toString() {
        return "Город: " + this.city + ", улица: " + this.street + ", дом: " + this.house + ", этаж: " + this.floor;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloor() {
        return this.floor;
    }

    public String getCity() {
        return this.city;
    }
}