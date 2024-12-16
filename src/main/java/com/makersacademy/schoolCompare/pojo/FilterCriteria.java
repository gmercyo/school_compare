package com.makersacademy.schoolcompare.pojo;

public class FilterCriteria {
    private String ages;
    private String gender;
    private Integer rating;
    private String affiliation;

    public FilterCriteria(String ages, String gender, Integer rating, String affiliation) {
        this.ages = ages;
        this.gender = gender;
        this.rating = rating;
        this.affiliation = affiliation;
    }

    public FilterCriteria() {}

    public String getAges() { return ages; }
    public String getGender() { return gender; }
    public Integer getRating() { return rating; }
    public String getAffiliation() { return affiliation; }

    public void setAges(String ages) { this.ages = ages; }
    public void setGender(String gender) { this.gender = gender; }
    public void setRating(Integer rating) { this.rating = rating; }
    public void setAffiliation(String affiliation) { this.affiliation = affiliation; }
}
