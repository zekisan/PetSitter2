package com.zekisanmobile.petsitter2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Owner extends RealmObject {

    @PrimaryKey
    @JsonProperty("app_id")
    private String id;

    String name;

    String address;

    String district;

    float latitude;

    float longitude;

    @JsonProperty("photo")
    private PhotoUrl photoUrl;

    @JsonProperty("profile_photos")
    RealmList<PhotoUrl> profilePhotos;

    RealmList<Pet> pets;

    public RealmList<Pet> getPets() {
        return pets;
    }

    public void setPets(RealmList<Pet> pets) {
        this.pets = pets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public PhotoUrl getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(PhotoUrl photoUrl) {
        this.photoUrl = photoUrl;
    }

    public RealmList<PhotoUrl> getProfilePhotos() {
        return profilePhotos;
    }

    public void setProfilePhotos(RealmList<PhotoUrl> profilePhotos) {
        this.profilePhotos = profilePhotos;
    }
}
