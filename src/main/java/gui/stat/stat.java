package gui.stat;

public class stat {
    private int power;
    private int strength;
    private int quickness;
    private int durability;
    private int mental;
    private int sense;
    private int luck;
    private int skill;
    private int point;

    public stat(int type) {
        this.power = type;
        this.strength = type;
        this.quickness = type;
        this.durability = type;
        this.mental = type;
        this.sense = type;
        this.luck = type;
        this.skill = type;
        this.point = type;
    }

    public int getpower() { return power; }
    public int getstrength() { return strength; }
    public int getquickness() { return quickness; }
    public int getdurability() { return durability; }
    public int getmental() { return mental; }
    public int getsense() { return sense; }
    public int getluck() { return luck; }
    public int getskill() { return skill; }
    public int getpoint() { return point; }

    public void setpower(int value) { this.power = value; }
    public void setstrength(int value) { this.strength = value; }
    public void setquickness(int value) { this.quickness = value; }
    public void setdurability(int value) { this.durability = value; }
    public void setmental(int value) { this.mental = value; }
    public void setsense(int value) { this.sense = value; }
    public void setluck(int value) { this.luck = value; }
    public void setskill(int value) { this.skill = value; }
    public void setpoint(int value) { this.point = value; }

    public void addpower(int value) { this.power += value; }
    public void addstrength(int value) { this.strength += value; }
    public void addquickness(int value) { this.quickness += value; }
    public void adddurability(int value) { this.durability += value; }
    public void addmental(int value) { this.mental += value; }
    public void addsense(int value) { this.sense += value; }
    public void addluck(int value) { this.luck += value; }
    public void addskill(int value) { this.skill += value; }
    public void addpoint(int value) { this.point += value; }
}
