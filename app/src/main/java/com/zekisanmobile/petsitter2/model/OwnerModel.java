package com.zekisanmobile.petsitter2.model;

import com.zekisanmobile.petsitter2.vo.Job;
import com.zekisanmobile.petsitter2.vo.Owner;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

public class OwnerModel {

    Realm realm;

    public OwnerModel(Realm realm) {
        this.realm = realm;
    }

    public Owner save(Owner owner) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(owner);
        realm.commitTransaction();

        return owner;
    }

    public Owner find(String id) {
        return realm.where(Owner.class).equalTo("id", id).findFirst();
    }

    public List<Job> getNextJobs(String id) {
        return realm.where(Job.class)
                .equalTo("owner.id", id)
                .equalTo("status", 30)
                .greaterThan("dateStart", new Date())
                .findAllSorted("dateStart", Sort.DESCENDING);
    }

    public List<Job> getFinishedJobs(String id) {
        return realm.where(Job.class)
                .equalTo("owner.id", id)
                .equalTo("status", 40)
                .findAll();
    }

    public List<Job> getNewJobs(String id){
        return realm.where(Job.class)
                .equalTo("owner.id", id)
                .equalTo("status", 10)
                .greaterThanOrEqualTo("dateStart", new Date())
                .findAll();
    }

    public List<Job> getCurrentJobs(String id){
        return realm.where(Job.class)
                .equalTo("owner.id", id)
                .equalTo("status", 30)
                .lessThanOrEqualTo("dateStart", new Date())
                .greaterThanOrEqualTo("dateFinal", new Date())
                .findAllSorted("dateStart", Sort.DESCENDING);
    }
}
