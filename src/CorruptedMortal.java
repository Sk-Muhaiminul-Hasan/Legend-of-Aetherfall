public class CorruptedMortal extends Character {

    public CorruptedMortal() {
        this.setHealth(90);
        this.setPower(90);
        this.setStdAttackDamage(18);
        this.setStdAttackPowerCost(9);
        this.setSpecialCost(20);
        this.setSpecialDamage(25);
    }

    @Override
    public String specialAttack(Character target) {
        if (this.getPower() >= this.getSpecialCost()) {
            this.setPower(this.getPower() - this.getSpecialCost());
            target.setHealth(target.getHealth() - this.getSpecialDamage());
            return this.getClass().getSimpleName() + " performs a corrupting strike, dealing " + this.getSpecialDamage() + " damage!";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power for a corrupting strike.";
        }
    }

    @Override
    public String attack(Character target) {
        if (this.getPower() >= this.getStdAttackPowerCost()) {
            this.setPower(this.getPower() - this.getStdAttackPowerCost());
            target.setHealth(target.getHealth() - this.getStdAttackDamage());
            return "";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power to attack!";
        }
    }
}
