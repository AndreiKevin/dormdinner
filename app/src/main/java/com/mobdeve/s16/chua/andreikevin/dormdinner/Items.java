package com.mobdeve.s16.chua.andreikevin.dormdinner;

public class Items {
    String id;
    int pic;
    Boolean pic2;
    int none;
    int have;
    String recipeName;

    public Items(int pic, Boolean pic2, String recipeName) {
        this.pic = pic;
        this.pic2 = pic2;
        this.recipeName = recipeName;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getId(){ return this.id; }

    public Boolean isToggled() {
        return pic2;
    }

    public void setToggled(Boolean pic2) {
        this.pic2 = pic2;
    }

    public int getHave() {
        return this.have;
    }

    public void setHave(Integer have) {
        this.have = have;
    }

    public int getNone() {
        return this.none;
    }

    public void setNone(Integer none) {
        this.none = none;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
}