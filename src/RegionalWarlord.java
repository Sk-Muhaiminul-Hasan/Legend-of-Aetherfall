public class RegionalWarlord extends Character {
    private boolean opponentStunned = false;

    public RegionalWarlord() {
        this.health = 130;
        this.power = 110;
        this.stdAttackDamage = 20;
        this.stdAttackPowerCost = 10;
        this.specialCost = 35;
    }
    
    public String warlordStrike(Character target) {
        if (this.power >= this.specialCost) {
            this.power -= this.specialCost;
            target.setHealth(target.getHealth() - 30);
            opponentStunned = true;
            return this.getClass().getSimpleName() + " performs a powerful warlord strike, dealing 30 damage and stunning the opponent!";
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
        target.setHealth(target.getHealth() - this.stdAttackDamage);
        this.power -= this.stdAttackPowerCost;
        return this.name + " attacks for " + this.stdAttackDamage + " damage!";
    }
}
