package com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter;

public class Items {
    int pic;
    int none;
    int have;
    String recipeName;

    public Items(int pic, Integer yesAmt, Integer noAmt, String recipeName) {
        this.pic = pic;
        this.have = yesAmt;
        this.none = noAmt;
        this.recipeName = recipeName;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getHave() {
        return have;
    }

    public void setHave(Integer have) {
        this.have = have;
    }

    public int getNone() {
        return none;
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
