public class Archer extends Protagonist {
    private boolean isMultiShot = false;

    public Archer() {
        this.setHealth(100);
        this.setPower(100);
        this.setStdAttackDamage(15);
        this.setStdAttackPowerCost(8);
        this.setSpecialCost(25);
        this.setSpecialDamage(30);
    }
    public void giveChoice() {
                    
                    System.out.println("\nChoose your special ability:");
                    System.out.println("1. Quick Shot (25 power, 30 damage)");
                    System.out.println("2. Multi Shot (50 power, 60 damage)");
                    System.out.print(">");
    
                }

    public void getChoice(String archerChoice) {
        
                    
                    
                    if (archerChoice.equals("1") || archerChoice.equals("quick shot")) {
                        this.setMultiShot(false);
                    } else if (archerChoice.equals("2") || archerChoice.equals("multi shot")) {
                        this.setMultiShot(true);
                    } else {
                        System.out.println("Invalid choice. Please choose 1 or 2.");
                    }
    }
    public void setMultiShot(boolean multiShot) {
        this.isMultiShot = multiShot;
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

    @Override
    public String specialAttack(Character target) {
        if (isMultiShot) {
            if (this.getPower() >= (this.getSpecialCost() * 2)) {
                this.setPower(this.getPower() - (this.getSpecialCost() * 2));
                target.setHealth(target.getHealth() - this.getSpecialDamage() * 2);
                return this.getName() + " performed a multi-shot successfully, dealing " + this.getSpecialDamage() * 2 + " damage!";
            } else {
                return this.getName() + " not enough power to perform multi-shot.";
            }
        } else {
            if (this.getPower() >= this.getSpecialCost()) {
                this.setPower(this.getPower() - this.getSpecialCost());
                target.setHealth(target.getHealth() - this.getSpecialDamage());
                return this.getName() + " shot a quick shot successfully, dealing " + this.getSpecialDamage() + " damage!";
            } else {
                return this.getName() + " not enough power to shoot the quick shot.";
            }
        }
    }
}
