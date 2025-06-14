public class Protagonist extends Character {
    private String name;

    public Protagonist() {
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public String attack(Character target) {
        if (this.getPower() >= this.getStdAttackPowerCost()) {
            this.setPower(this.getStdAttackPowerCost());
            target.setHealth(target.getHealth() - this.getStdAttackDamage());
            return "";
        } else {
            return this.name + " does not have enough power to attack!";
        }
    }

    @Override
    public String specialAttack(Character target) {
        if (this.getPower() >= this.getSpecialCost()) {
            this.setPower(this.getSpecialCost());
            return this.name + " performs a special attack!";
        } else {
            return this.name + " not enough power for a special attack!";
        }
    }
}
