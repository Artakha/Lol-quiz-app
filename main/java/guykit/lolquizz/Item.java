package guykit.lolquizz;

/**
 * Created by Guykit69 on 20/07/2017.
 */

public class Item {
    String id;
    String name;
    int gold;
    int ap;
    int ad;
    int hp;
    int mana;
    int hp5;
    int mp5;
    int armour;
    int mr;
    int crit;
    int as;
    int cdr;
    int ms;
    int leth;
    int mpenflat;
    int mpenp;
    String maps;

    public Item(String id, String name, int gold, int ap, int ad, int hp, int mana, int hp5, int mp5, int armour, int mr, int crit, int as, int cdr, int ms, int leth, int mpenflat, int mpenp, String maps){
        this.id = id;
        this.name = name;
        this.gold = gold;
        this.ap = ap;
        this.ad = ad;
        this.hp = hp;
        this.mana = mana;
        this.hp5 = hp5;
        this.mp5 = mp5;
        this.armour = armour;
        this.mr = mr;
        this.crit = crit;
        this.as = as;
        this.cdr = cdr;
        this.ms = ms;
        this.leth = leth;
        this.mpenflat = mpenflat;
        this.mpenp = mpenp;
        this.maps = maps;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
