package com.example.xmldb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    private int id;

    private String name;

    private String schoolEmisNumber;

    private double tenthMark;

    private double twelfthMark;

    private double cutoff;

    private String nativePlace;

    private boolean firstGraduate;

    private String email;

    public Student() {
    }

    public Student(int id, String name, String schoolEmisNumber,
                   double tenthMark, double twelfthMark,
                   double cutoff, String nativePlace,
                   boolean firstGraduate, String email) {

        this.id = id;
        this.name = name;
        this.schoolEmisNumber = schoolEmisNumber;
        this.tenthMark = tenthMark;
        this.twelfthMark = twelfthMark;
        this.cutoff = cutoff;
        this.nativePlace = nativePlace;
        this.firstGraduate = firstGraduate;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSchoolEmisNumber() {
        return schoolEmisNumber;
    }

    public double getTenthMark() {
        return tenthMark;
    }

    public double getTwelfthMark() {
        return twelfthMark;
    }

    public double getCutoff() {
        return cutoff;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public boolean isFirstGraduate() {
        return firstGraduate;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchoolEmisNumber(String schoolEmisNumber) {
        this.schoolEmisNumber = schoolEmisNumber;
    }

    public void setTenthMark(double tenthMark) {
        this.tenthMark = tenthMark;
    }

    public void setTwelfthMark(double twelfthMark) {
        this.twelfthMark = twelfthMark;
    }

    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public void setFirstGraduate(boolean firstGraduate) {
        this.firstGraduate = firstGraduate;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}