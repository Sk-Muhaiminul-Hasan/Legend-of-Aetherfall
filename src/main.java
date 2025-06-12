import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Protagonist player = null;
        Character enemy = null;

        // Character Selection
        System.out.println("Choose your character: 1. Mage 2. Archer 3. Warrior");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("You have chosen Mage.");
                System.out.println("Enter your mage name:");
                String mageName = scanner.nextLine();
                player = new Mage();
                player.setName(mageName);
                break;
            case 2:
                System.out.println("You have chosen Archer.");
                System.out.println("Enter your archer name:");
                String archerName = scanner.nextLine();
                player = new Archer();
                player.setName(archerName);
                break;
            case 3:
                System.out.println("You have chosen Warrior.");
                System.out.println("Enter your warrior name:");
                String warriorName = scanner.nextLine();
                player = new Warrior();
                player.setName(warriorName);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                return;
        }

        // Enemy Selection
        System.out.println("Choose your enemy:");
        System.out.println("1. DarkOverlord");
        System.out.println("2. RegionalWarlord");
        System.out.println("3. CorruptedMortal");
        int enemyChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (enemyChoice) {
            case 1:
                enemy = new DarkOverlord();
                break;
            case 2:
                enemy = new RegionalWarlord();
                break;
            case 3:
                enemy = new CorruptedMortal();
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                return;
        }

        System.out.println(player.getName() + " the " + player.getClass().getSimpleName() + " enters the world of Aetherfall!");
        System.out.println(enemy.getClass().getSimpleName() + " has appeared!");
        System.out.println("Battle Start!");

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("\nChoose your action: Attack or Special Attack");
            System.out.print(">");
            String actionChoice = scanner.nextLine().toLowerCase();

            // Player's turn
            if (actionChoice.equals("attack")) {
                int playerDamage = player.getStdAttackDamage();
                if (enemy instanceof DarkOverlord && ((DarkOverlord) enemy).isTargetWeakened()) {
                    playerDamage = playerDamage / 2;
                    ((DarkOverlord) enemy).resetWeakened();
                }
                
                System.out.println("\n" + player.getName() + " used Attack on " + enemy.getClass().getSimpleName());
                System.out.println(player.getName() + " caused " + playerDamage + " damage");
                String attackResult = player.attack(enemy);
                if (attackResult.contains("not have enough power")) {
                    System.out.println(attackResult);
                    continue;
                }
                System.out.println(attackResult);
                
                // Display stats after player's attack
                System.out.println("\n------Game Stats------");
                System.out.println(player.getName() + " Health: " + player.getHealth() + ", Power: " + player.getPower());
                System.out.println(enemy.getClass().getSimpleName() + " Health: " + enemy.getHealth() + ", Power: " + enemy.getPower());

                // Enemy's turn
                if (enemy.getHealth() > 0) {
                    System.out.println("\n" + enemy.getClass().getSimpleName() + " used Attack on " + player.getName());
                    System.out.println(enemy.getClass().getSimpleName() + " caused " + enemy.getStdAttackDamage() + " damage");
                    String enemyAttackResult = enemy.attack(player);
                    if (enemyAttackResult.contains("not have enough power")) {
                        System.out.println(enemyAttackResult);
                    } else {
                        System.out.println(enemyAttackResult);
                    }
                    
                    // Display stats after enemy's attack
                    System.out.println("\n------Game Stats------");
                    System.out.println(player.getName() + " Health: " + player.getHealth() + ", Power: " + player.getPower());
                    System.out.println(enemy.getClass().getSimpleName() + " Health: " + enemy.getHealth() + ", Power: " + enemy.getPower());
                }
            } else if (actionChoice.equals("special attack")) {
                // Player's special attack
                if (player instanceof Mage) {
                    System.out.println("\n" + player.getName() + " used Special Attack on " + enemy.getClass().getSimpleName());
                    System.out.println(((Mage) player).castSpell(enemy));
                } else if (player instanceof Archer) {
                    System.out.println("\nChoose your special ability:");
                    System.out.println("1. Quick Shot (25 power, 30 damage)");
                    System.out.println("2. Multi Shot (50 power, 60 damage)");
                    String archerChoice = scanner.nextLine().toLowerCase();
                    
                    if (archerChoice.equals("1") || archerChoice.equals("quick shot")) {
                        int damage = 30;
                        if (enemy instanceof DarkOverlord && ((DarkOverlord) enemy).isTargetWeakened()) {
                            damage = damage / 2;
                            ((DarkOverlord) enemy).resetWeakened();
                        }
                        System.out.println("\n" + player.getName() + " used Quick Shot on " + enemy.getClass().getSimpleName());
                        System.out.println(((Archer) player).quickShot(enemy, damage));
                    } else if (archerChoice.equals("2") || archerChoice.equals("multi shot")) {
                        int damage = 60;
                        if (enemy instanceof DarkOverlord && ((DarkOverlord) enemy).isTargetWeakened()) {
                            damage = damage / 2;
                            ((DarkOverlord) enemy).resetWeakened();
                        }
                        System.out.println("\n" + player.getName() + " used Multi Shot on " + enemy.getClass().getSimpleName());
                        System.out.println(((Archer) player).multiShot(enemy, damage));
                    } else {
                        System.out.println("Invalid choice. Please choose 1 or 2.");
                        continue;
                    }
                } else if (player instanceof Warrior) {
                    int damage = 35;
                    if (enemy instanceof DarkOverlord && ((DarkOverlord) enemy).isTargetWeakened()) {
                        damage = damage / 2;
                        ((DarkOverlord) enemy).resetWeakened();
                    }
                    System.out.println("\n" + player.getName() + " used Special Attack on " + enemy.getClass().getSimpleName());
                    System.out.println(((Warrior) player).mightyStrike(enemy, damage));
                }
                
                // Display stats after player's special attack
                System.out.println("\n------Game Stats------");
                System.out.println(player.getName() + " Health: " + player.getHealth() + ", Power: " + player.getPower());
                System.out.println(enemy.getClass().getSimpleName() + " Health: " + enemy.getHealth() + ", Power: " + enemy.getPower());
                
                // Enemy's turn
                if (enemy.getHealth() > 0) {
                    if (enemy instanceof DarkOverlord) {
                        System.out.println("\n" + enemy.getClass().getSimpleName() + " used Special Attack on " + player.getName());
                        System.out.println(((DarkOverlord) enemy).summonDarkness(player));
                    } else if (enemy instanceof RegionalWarlord) {
                        System.out.println("\n" + enemy.getClass().getSimpleName() + " used Special Attack on " + player.getName());
                        System.out.println(((RegionalWarlord) enemy).warlordStrike(player));
                        // RegionalWarlord gets a follow-up attack
                        if (player.getHealth() > 0) {
                            System.out.println("\n" + enemy.getClass().getSimpleName() + " used Attack on " + player.getName());
                            System.out.println(enemy.getClass().getSimpleName() + " caused " + enemy.getStdAttackDamage() + " damage");
                            System.out.println(enemy.attack(player));
                        }
                    } else if (enemy instanceof CorruptedMortal) {
                        System.out.println("\n" + enemy.getClass().getSimpleName() + " used Special Attack on " + player.getName());
                        System.out.println(((CorruptedMortal) enemy).corruptStrike(player));
                    }
                    
                    // Display stats after enemy's special attack
                    System.out.println("\n------Game Stats------");
                    System.out.println(player.getName() + " Health: " + player.getHealth() + ", Power: " + player.getPower());
                    System.out.println(enemy.getClass().getSimpleName() + " Health: " + enemy.getHealth() + ", Power: " + enemy.getPower());
                }
            } else {
                System.out.println("Invalid action. Please choose 'Attack' or 'Special Attack'.");
                continue;
            }

            // Skip player's turn if stunned
            if (enemy instanceof RegionalWarlord && ((RegionalWarlord) enemy).isOpponentStunned()) {
                System.out.println("\n" + player.getName() + " is stunned and cannot move!");
                ((RegionalWarlord) enemy).resetStun();
                
                // Display stats after stun
                System.out.println("\n------Game Stats------");
                System.out.println(player.getName() + " Health: " + player.getHealth() + ", Power: " + player.getPower());
                System.out.println(enemy.getClass().getSimpleName() + " Health: " + enemy.getHealth() + ", Power: " + enemy.getPower());
            }
        }

        // Battle result
        if (player.getHealth() <= 0) {
            System.out.println("\nBattle Over!");
            System.out.println(player.getName() + " has been defeated by " + enemy.getClass().getSimpleName() + "!");
        } else {
            System.out.println("\nBattle Over!");
            System.out.println(enemy.getClass().getSimpleName() + " has been defeated by " + player.getName() + "!");
        }

        scanner.close();
    }
}
