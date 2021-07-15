package io.muzoo.ssc.zork.item;

public class Crossbow implements Item {

    @Override
    public String getItemName() {
        return "crossbow";
    }

    @Override
    public int getAttackPower() {
        return 20;
    }

    @Override
    public int getDefensePower() {
        return 0;
    }

    @Override
    public int getBoostPower() {
        return 0;
    }
}
