package com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter;

public class Items {
    int pic;
    int pic2;
    int none;
    int have;
    String recipeName;

    public Items(int pic, int pic2, int yesAmt, int noAmt, String recipeName) {
        this.pic = pic;
        this.pic2 = pic2;
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

    public int getPic2() {
        return pic2;
    }

    public void setPic2(int pic2) {
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
