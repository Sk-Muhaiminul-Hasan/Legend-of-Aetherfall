public class Warrior extends Protagonist {

    public Warrior() {
        this.setHealth(120);
        this.setPower(100);
        this.setStdAttackDamage(12);
        this.setStdAttackPowerCost(5);
        this.setSpecialCost(35);
        this.setSpecialDamage(35);
    }

    @Override
    public String specialAttack(Character target) {
        if (this.getPower() >= this.getSpecialCost()) {
            this.setPower(this.getPower() - this.getSpecialCost());
            target.setHealth(target.getHealth() - this.getSpecialDamage());
            return this.getName() + " used mighty strike successfully, dealing " + this.getSpecialDamage() + " damage!";
        } else {
            return this.getName() + " not enough power to use the mighty strike.";
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

    public boolean warriorsShield(Character target) {
        return this.getHealth() > target.getHealth();
    }

    
}
