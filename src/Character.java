public class Character {

    protected int health;
    protected int power;
    protected int stdAttackDamage;
    protected int stdAttackPowerCost;
    protected int specialCost;
    protected String name;

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public int getStdAttackDamage() {
        return stdAttackDamage;
    }

    public int getStdAttackPowerCost() {
        return stdAttackPowerCost;
    }

    public int getSpecialCost() {
        return specialCost;
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    public void setPower(int powerCost) {
        this.power -= powerCost;
    }

    public void setStdAttackDamage(int newStdAttackDamage) {
        this.stdAttackDamage = newStdAttackDamage;
    }

    public void setStdAttackPowerCost(int newStdAttackPowerCost) {
        this.stdAttackPowerCost = newStdAttackPowerCost;
    }

    public void setSpecialCost(int newSpecialCost) {
        this.specialCost = newSpecialCost;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String attack(Character target) {
        if (this.power >= this.stdAttackPowerCost) {
            this.power -= this.stdAttackPowerCost;
            target.setHealth(target.getHealth() - this.stdAttackDamage);
            return this.name + " attacks for " + this.stdAttackDamage + " damage!";
        } else {
            return this.name + " does not have enough power to attack!";
        }
    }
}

