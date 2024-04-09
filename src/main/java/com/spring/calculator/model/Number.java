package com.spring.calculator.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "skaiciai")
public class Number {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Min(value = 0, message = "Validacijos klaida: skaičius negali būti neigiamas.")
    @Column(name = "sk1")
    private int sk1;

    @Min(value = 0, message = "Validacijos klaida: skaičius negali būti neigiamas.")
    @Column(name = "sk2")
    private int sk2;

    @Column(name = "zenklas")
    private String zenklas;

    @Column(name = "rezult")
    private int rezultatas;

    public Number() {}

    public Number(int id, int sk1, int sk2, String zenklas, int rezultatas) {
        this.id = id;
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.zenklas = zenklas;
        this.rezultatas = rezultatas;
    }

    public Number(int sk1, int sk2, String zenklas, int rezultatas) {
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.zenklas = zenklas;
        this.rezultatas = rezultatas;
    }

    public int getId() {
        return id;
    }

    public int getSk1() {
        return sk1;
    }

    public void setSk1(int sk1) {
        this.sk1 = sk1;
    }

    public int getSk2() {
        return sk2;
    }

    public void setSk2(int sk2) {
        this.sk2 = sk2;
    }

    public String getZenklas() {
        return zenklas;
    }

    public void setZenklas(String zenklas) {
        this.zenklas = zenklas;
    }

    public int getRezultatas() {
        return rezultatas;
    }

    public void setRezultatas(int rezultatas) {
        this.rezultatas = rezultatas;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", sk1=" + sk1 +
                ", sk2=" + sk2 +
                ", zenklas='" + zenklas + '\'' +
                ", rezultatas=" + rezultatas +
                '}';
    }
}
