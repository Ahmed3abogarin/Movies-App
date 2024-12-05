package com.example.moviesapp.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreditsResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private List<Actor> cast;

    @SerializedName("crew")
    private List<Crew> crew;

    public List<Crew> getCrew() {
        return crew;
    }

    // Getters
    public List<Actor> getCast() {
        return cast;
    }


    public class Actor {
        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("character")
        private String character;

        @SerializedName("profile_path")
        private String profilePath;

        // Getters
        public String getName() {
            return name;
        }

        public String getCharacter() {
            return character;
        }

        public String getProfilePath() {
            return profilePath;
        }
    }

    public class Crew {
        @SerializedName("id")
        private int id;

        @SerializedName("name")
        private String name;

        @SerializedName("job")
        private String job;

        @SerializedName("profile_path")
        private String profilePath;

        // Getters
        public String getName() {
            return name;
        }
    }
}
