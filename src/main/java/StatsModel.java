public class StatsModel {
    private int hp;
    private int attack;
    private  int defence;
    private int special_attack;
    private int special_defence;
    private int speed;

    public StatsModel(int hp, int attack, int defence, int special_attack, int special_defence, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.special_attack = special_attack;
        this.special_defence = special_defence;
        this.speed = speed;
    }
    public StatsModel()
    {
    this.hp=0;
    this.attack=0;
    this.defence=0;
    this.special_attack=0;
    this.special_defence=0;
    this.speed=0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpecial_attack() {
        return special_attack;
    }

    public void setSpecial_attack(int special_attack) {
        this.special_attack = special_attack;
    }

    public int getSpecial_defence() {
        return special_defence;
    }

    public void setSpecial_defence(int special_defence) {
        this.special_defence = special_defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
