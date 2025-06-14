public class Character {
    private int health;
    private int power;
    private int stdAttackDamage;
    private int stdAttackPowerCost;
    private int specialCost;
    private int specialDamage;

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

    public int getSpecialDamage() {
        return specialDamage;
    }

    protected void setHealth(int newHealth) {
        this.health = newHealth;
    }

    protected void setPower(int newPower) {
        this.power = newPower;
    }

    protected void setStdAttackDamage(int newStdAttackDamage) {
        this.stdAttackDamage = newStdAttackDamage;
    }

    protected void setStdAttackPowerCost(int newStdAttackPowerCost) {
        this.stdAttackPowerCost = newStdAttackPowerCost;
    }

    protected void setSpecialCost(int newSpecialCost) {
        this.specialCost = newSpecialCost;
    }

    public void takeDamage(int damage) {
        this.setHealth(this.getHealth() - damage);
    }
    
    public void setSpecialDamage(int newSpecialDamage) {
        this.specialDamage = newSpecialDamage;
    }
    
    public String attack(Character target) {
        if (this.power >= this.stdAttackPowerCost) {
            this.power -= this.stdAttackPowerCost;
            target.takeDamage(this.stdAttackDamage);
            return "";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power to attack!";
        }
    }

    public String specialAttack(Character target) {
        if (this.power >= this.specialCost) {
            this.power -= this.specialCost;
            return this.getClass().getSimpleName() + " performs a special attack!";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power for a special attack!";
        }
    }
}

