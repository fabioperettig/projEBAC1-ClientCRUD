package br.com.fabioperettig.domain;

import java.util.Objects;

public class Client {

    private String name;
    private Long id;
    private Long phone;
    private String address;
    private Integer nAddress;
    private String city;
    private String state;

    //ctor
    public Client(String name, String id, String phone, String address, String nAddress, String city, String state) {
        this.name = name;
        this.id = Long.valueOf(id.trim());
        this.phone = Long.valueOf(phone.trim());
        this.address = address;
        this.nAddress = Integer.valueOf(nAddress.trim());
        this.city = city;
        this.state = state;
    }

    //getterSetter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getnAddress() {
        return nAddress;
    }
    public void setnAddress(Integer nAddress) {
        this.nAddress = nAddress;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "br.com.fabioperettig.domain.Client{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}