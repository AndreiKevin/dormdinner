package com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter;

public class Items {
    String id;
    int pic;
    int none;
    int have;
    String recipeName;

    public Items(String id, int pic, Integer yesAmt, Integer noAmt, String recipeName) {
        this.id = id;
        this.pic = pic;
        this.have = yesAmt;
        this.none = noAmt;
        this.recipeName = recipeName;
    }

    public int getPic() {
        return pic;
    }

    public String getId() {
        return id;
    }

    public void setPic(int pic) {
        this.pic = pic;
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
