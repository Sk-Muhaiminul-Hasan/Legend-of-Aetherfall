



public class CorruptedMortal extends Character {

    public CorruptedMortal() {
        this.health = 90;
        this.power = 90;
        this.stdAttackDamage = 18;
        this.stdAttackPowerCost = 9;
        this.specialCost = 20;
    }

    public String corruptStrike(Character target) {
        if (this.power >= this.specialCost) {
            this.power -= this.specialCost;
            target.setHealth(target.getHealth() - 25);
            return this.getClass().getSimpleName() + " performs a corrupting strike!";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power for a corrupting strike.";
        }
    }

    public String attack(Character target) {
        if (this.power >= this.stdAttackPowerCost) {
            this.power -= this.stdAttackPowerCost;
            target.setHealth(target.getHealth() - this.stdAttackDamage);
            return this.getClass().getSimpleName() + " attacks for " + this.stdAttackDamage + " damage!";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power to attack!";
        }
    }
}
