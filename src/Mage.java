
public class Mage extends Protagonist {
    
    public Mage() {
        this.health = 80;
        this.power = 100;
        this.stdAttackDamage = 20;
        this.stdAttackPowerCost = 10;
        this.specialCost = 30;
    }

    public String castSpell(Character target) {
        if (this.power >= this.specialCost) {
            this.power -= this.specialCost;
            target.setHealth(target.getHealth() - 40); // Special spell deals 40 damage
            return this.name + " cast special spell successfully, dealing 40 damage!";
        } else {
            return this.name + " not enough power to cast the spell.";
        }
    }
}
