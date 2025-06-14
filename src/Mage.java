public class Mage extends Protagonist {
    
    public Mage() {
        this.setHealth(80);
        this.setPower(100);
        this.setStdAttackDamage(20);
        this.setStdAttackPowerCost(10);
        this.setSpecialCost(30);
        this.setSpecialDamage(40); 
    }

    @Override
    public String specialAttack(Character target) {
        if (this.getPower() >= this.getSpecialCost()) {
            this.setPower(this.getPower() - this.getSpecialCost());
            target.setHealth(target.getHealth() - this.getSpecialDamage());
            return this.getName() + " cast special spell successfully, dealing " + this.getSpecialDamage() + " damage!";
        } else {
            return this.getName() + " not enough power to cast the spell.";
        }
    }

    @Override
    public String attack(Character target) {
        if (this.getPower() >= this.getStdAttackPowerCost()) {
            this.setPower(this.getPower() - this.getStdAttackPowerCost());
            target.setHealth(target.getHealth() - this.getStdAttackDamage());
            return "";
        } else {
            return this.getName() + " does not have enough power to attack!";
        }
    }
}
