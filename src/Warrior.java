public class Warrior extends Protagonist {

    public Warrior() {
        this.health = 120;
        this.power = 100;
        this.stdAttackDamage = 12;
        this.stdAttackPowerCost = 5;
        this.specialCost = 35;
    }

    public String mightyStrike(Character target, int damage) {

        if (this.power >= this.specialCost) {
            this.power -= this.specialCost;
            target.setHealth(target.getHealth() - damage);
            return this.name + " used mighty strike successfully!";
        } else {
            return this.name + " not enough power to use the mighty strike.";
        }
    }
}
