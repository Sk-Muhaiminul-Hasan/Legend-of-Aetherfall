public class Archer extends Protagonist {
    

    public Archer() {
        this.health = 100;
        this.power = 100;
        this.stdAttackDamage = 15;
        this.stdAttackPowerCost = 8;
        this.specialCost = 25;
    }

    public String quickShot(Character target, int damage) {
        if (this.power >= this.specialCost) {
            this.power -= this.specialCost;
            target.setHealth(target.getHealth() - damage);
            return this.name + " shot a quick shot successfully, dealing " + damage + " damage!";
        } else {
            return this.name + " not enough power to shoot the quick shot.";
        }
    }

    public String multiShot(Character target, int damage) {
        if (this.power >= (specialCost * 2)) {
            this.power -= (specialCost * 2);
            target.setHealth(target.getHealth() - damage);
            return this.name + " performed a multi-shot successfully, dealing " + damage + " damage!";
        } else {
            return this.name + " not enough power to perform multi-shot.";
        }
    }
}
