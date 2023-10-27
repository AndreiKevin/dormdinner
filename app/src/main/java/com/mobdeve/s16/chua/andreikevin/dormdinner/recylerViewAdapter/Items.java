package com.mobdeve.s16.chua.andreikevin.dormdinner.recylerViewAdapter;

public class Items {
    int pic;
    Boolean isToggled;
    int none;
    int have;
    String recipeName;

    public Items(int pic, Boolean isToggled, int yesAmt, int noAmt, String recipeName) {
        this.pic = pic;
        this.isToggled = isToggled;
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

    public boolean isToggled() {
        return isToggled;
    }

    public void setToggled(boolean pic2) {
        this.isToggled = pic2;
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
