package com.vinayak.blooddonner.Response;

import com.google.gson.annotations.SerializedName;
import com.vinayak.blooddonner.Module.Donner_Module;

import java.util.List;

public class FetchDonner {

        @SerializedName("user")
        List<Donner_Module> userList;
        String error;

        public FetchDonner(List<Donner_Module> userList, String error) {
            this.userList = userList;
            this.error = error;
        }

        public List<Donner_Module> getUserList() {
            return userList;
        }

        public void setUserList(List<Donner_Module> userList) {
            this.userList = userList;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

