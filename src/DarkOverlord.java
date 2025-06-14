public class DarkOverlord extends Character {
    private boolean targetWeakened = false;
    private int weakenedDuration = 0;
    private int originalDamage = 0;

    public DarkOverlord() {
        this.setHealth(200);
        this.setPower(150);
        this.setStdAttackDamage(25);
        this.setStdAttackPowerCost(17);
        this.setSpecialCost(40);
        this.setSpecialDamage(50);
    }

    @Override
    public String specialAttack(Character target) {
        if (this.getPower() >= this.getSpecialCost()) {
            this.setPower(this.getPower() - this.getSpecialCost());
            target.setHealth(target.getHealth() - this.getSpecialDamage());

            if (target instanceof Protagonist) {
                if (weakenedDuration == 0) {
                    originalDamage = target.getStdAttackDamage();
                    target.setStdAttackDamage(originalDamage / 2);
                }
                weakenedDuration = 4;
                targetWeakened = true;
            }

            return this.getClass().getSimpleName() + " unleashed darkness, dealing " + this.getSpecialDamage() + " damage and weakening the target for 3 moves!";
        } else {
            return this.getClass().getSimpleName() + " does not have enough power to unleash the darkness.";
        }
    }

    public boolean isTargetWeakened() {
        return targetWeakened && weakenedDuration > 0;
    }

    public void resetWeakened(Protagonist target) {
        weakenedDuration--;
        if (weakenedDuration <= 0) {
            targetWeakened = false;
            weakenedDuration = 0;
            if (weakenedDuration == 0) {
                target.setStdAttackDamage(originalDamage);
                //originalDamage = 0;
            }
        }
    }

    @Override
    public String attack(Character target) {
        if (this.getPower() < this.getStdAttackPowerCost()) {
            return this.getClass().getSimpleName() + " does not have enough power to attack!";
        }
        else 
        {
            
            target.setHealth(target.getHealth() - this.getStdAttackDamage());
            this.setPower(this.getPower() - this.getStdAttackPowerCost());
            return "";
    
        }
    }
}