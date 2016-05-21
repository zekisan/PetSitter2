package com.zekisanmobile.petsitter2.model;

import com.zekisanmobile.petsitter2.vo.Job;
import com.zekisanmobile.petsitter2.vo.Sitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.Sort;

public class SitterModel {

    Realm realm;

    public SitterModel(Realm realm) {
        this.realm = realm;
    }

    public Sitter save(Sitter sitter) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(sitter);
        realm.commitTransaction();

        return sitter;
    }

    public Sitter find(String id) {
        return realm.where(Sitter.class).equalTo("id", id).findFirst();
    }

    public List<Job> getNextJobs(String id) {
        return realm.where(Job.class)
                .equalTo("sitter.id", id)
                .equalTo("status", 30)
                .greaterThan("dateStart", new Date())
                .findAllSorted("dateStart", Sort.DESCENDING);
    }

    public List<Job> getFinishedJobs(String id) {
        return realm.where(Job.class)
                .equalTo("sitter.id", id)
                .equalTo("status", 40)
                .findAll();
    }

    public List<Job> getNewJobs(String id){
        return realm.where(Job.class)
                .equalTo("sitter.id", id)
                .equalTo("status", 10)
                .greaterThanOrEqualTo("dateStart", new Date())
                .findAll();
    }

    public List<Job> getCurrentJobs(String id){
        return realm.where(Job.class)
                .equalTo("sitter.id", id)
                .equalTo("status", 30)
                .lessThanOrEqualTo("dateStart", new Date())
                .greaterThanOrEqualTo("dateFinal", new Date())
                .findAllSorted("dateStart", Sort.DESCENDING);
    }

    public List<Job> getJobsWithRates(String sitter_id) {
        List<Job> jobs = getFinishedJobs(sitter_id);
        if (jobs != null) {
            for (Job job : jobs) {
                if (job.getRate() == null) jobs.remove(job);
            }
            return jobs;
        }
        return new ArrayList<Job>();
    }
}
