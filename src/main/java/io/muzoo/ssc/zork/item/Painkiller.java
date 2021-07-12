package io.muzoo.ssc.zork.item;

public class Painkiller implements Item {

    @Override
    public String getItemName() {
        return "Painkiller";
    }

    @Override
    public int getAttackPower() {
        return 0;
    }

    @Override
    public int getDefensePower() {
        return 0;
    }

    @Override
    public int getBoostPower() {
        return 15;
    }
}
