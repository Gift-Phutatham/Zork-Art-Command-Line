package io.muzoo.ssc.zork.item;

public class Vest implements Item {

    @Override
    public String getItemName() {
        return "vest";
    }

    @Override
    public int getAttackPower() {
        return 0;
    }

    @Override
    public int getDefensePower() {
        return 15;
    }

    @Override
    public int getBoostPower() {
        return 0;
    }
}
