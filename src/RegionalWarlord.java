public class RegionalWarlord extends Character {
    private boolean opponentStunned = false;

    public RegionalWarlord() {
        this.setHealth(130);
        this.setPower(110);
        this.setStdAttackDamage(20);
        this.setStdAttackPowerCost(10);
        this.setSpecialCost(35);
        this.setSpecialDamage(30); 
    }
    
    @Override
    public String specialAttack(Character target) {
        if (this.getPower() >= this.getSpecialCost()) {
            this.setPower(this.getPower() - this.getSpecialCost());
            target.setHealth(target.getHealth() - this.getSpecialDamage());
            opponentStunned = true;
            return this.getClass().getSimpleName() + " performs a warlord strike, dealing " + this.getSpecialDamage() + " damage and stunning the opponent!";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power for a warlord strike.";
        }
    }

    public boolean isOpponentStunned() {
        return opponentStunned;
    }

    public void resetStun() {
        opponentStunned = false;
    }

    @Override
    public String attack(Character target) {
        if (this.getPower() < this.getStdAttackPowerCost()) {
            return this.getClass().getSimpleName() + " does not have enough power to attack!";
        } else {
            target.setHealth(target.getHealth() - this.getStdAttackDamage());
            this.setPower(this.getPower() - this.getStdAttackPowerCost());
            return "";
        }
    }
}
