public class DarkOverlord extends Character {
    private boolean targetWeakened = false;

    public DarkOverlord() {
        this.health = 200;
        this.power = 150;
        this.stdAttackDamage = 25;
        this.stdAttackPowerCost = 17;
        this.specialCost = 40;
    }

    public String summonDarkness(Character target) {
        if (this.power >= this.specialCost) {
            this.power -= this.specialCost;
            target.setHealth(target.getHealth() - 50);
            targetWeakened = true;
            return this.getClass().getSimpleName() + " unleashed darkness, dealing 50 damage and weakening the target!";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power to unleash the darkness.";
        }
    }

    public boolean isTargetWeakened() {
        return targetWeakened;
    }

    public void resetWeakened() {
        targetWeakened = false;
    }

    @Override
    public String attack(Character target) {
        target.setHealth(target.getHealth() - this.stdAttackDamage);
        this.power -= this.stdAttackPowerCost;
        return this.getClass().getSimpleName() + " attacks for " + this.stdAttackDamage + " damage!";
    }
} 
