package com.zekisanmobile.petsitter2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Sitter extends RealmObject {

    @PrimaryKey
    long id;

    String name;

    String address;

    String district;

    @JsonProperty("about_me")
    String aboutMe;

    @JsonProperty("value_hour")
    float valueHour;

    float latitude;

    float longitude;

    String phone;

    RealmList<Animal> animals;

    @JsonProperty("photo")
    private PhotoUrl photoUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public float getValueHour() {
        return valueHour;
    }

    public void setValueHour(float valueHour) {
        this.valueHour = valueHour;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RealmList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(RealmList<Animal> animals) {
        this.animals = animals;
    }

    public PhotoUrl getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(PhotoUrl photoUrl) {
        this.photoUrl = photoUrl;
    }
}
