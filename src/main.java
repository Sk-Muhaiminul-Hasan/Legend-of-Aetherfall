import java.util.Scanner;

public class main {
    public static void displayStats(Protagonist player, Character enemy) {
        System.out.println("\n------Game Stats------");
        System.out.println(player.getName() + " Health: " + player.getHealth() + ", Power: " + player.getPower());
        System.out.println(enemy.getClass().getSimpleName() + " Health: " + enemy.getHealth() + ", Power: " + enemy.getPower());
    }
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Protagonist player = null;
        Character enemy = null;

        // Character Selection
        System.out.println("Choose your character: 1. Mage 2. Archer 3. Warrior");
        System.out.print("> ");
        int playerChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (playerChoice) {
            case 1:
                System.out.println("You have chosen Mage.");
                System.out.println("Enter your mage name:");
                System.out.print("> ");
                String playerName = scanner.nextLine();
                player = new Mage();
                player.setName(playerName);
                break;
            case 2:
                System.out.println("You have chosen Archer.");
                System.out.println("Enter your archer name:");
                System.out.print("> ");
                playerName = scanner.nextLine();
                player = new Archer();
                player.setName(playerName);
                break;
            case 3:
                System.out.println("You have chosen Warrior.");
                System.out.println("Enter your warrior name:");
                System.out.print("> ");
                playerName = scanner.nextLine();
                player = new Warrior();
                player.setName(playerName);
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                return;
        }

        // Enemy Selection
        System.out.println("Choose your enemy:");
        System.out.println("1. DarkOverlord");
        System.out.println("2. Regional Warlord");
        System.out.println("3. Corrupted Mortal");
        System.out.print("> ");
        int enemyChoice = scanner.nextInt();
        scanner.nextLine(); 

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
                System.out.println("Invalid choice. Select 1, 2, or 3.");
                return;
        }

        System.out.println(player.getName() + " the " + player.getClass().getSimpleName() + " enters the world of Aetherfall!");
        System.out.println(enemy.getClass().getSimpleName() + " has appeared!");
        System.out.println("Battle Start!");

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            
            if (enemy instanceof DarkOverlord && ((DarkOverlord) enemy).isTargetWeakened()) {
                ((DarkOverlord) enemy).resetWeakened(player);
            }

            if( player instanceof Warrior && ((Warrior) player).warriorsShield(enemy)) {
                System.out.println("\n" + player.getName() + " has activated Warriors Shield!");
                System.out.println(player.getName() + " will take no damage from normal attack!");
                enemy.setStdAttackDamage(0);
            }
            System.out.println("\nChoose your action: Attack or Special Attack");
            System.out.print(">");
            String playerAction = scanner.nextLine().toLowerCase();

            // Player's turn
            if (playerAction.equals("attack")) {
                System.out.println("\n" + player.getName() + " used Attack on " + enemy.getClass().getSimpleName());
                System.out.println(player.getName() + " caused " + player.getStdAttackDamage() + " damage");
                String playerAttackResult = player.attack(enemy);
                if (playerAttackResult.contains("not have enough power")) {
                    System.out.println(playerAttackResult);
                    continue;
                }
                
                
                
                displayStats(player, enemy);
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

                    displayStats(player, enemy);
                }
            } else if (playerAction.equals("special attack") || playerAction.equals("special")) {
                // Player's special attack
                if (player instanceof Archer) {
                    ((Archer) player).giveChoice();
                    String archerChoice = scanner.nextLine().toLowerCase();
                    ((Archer) player).getChoice(archerChoice);
                }
                
                System.out.println("\n" + player.getName() + " used Special Attack on " + enemy.getClass().getSimpleName());
                String playerSpecialResult = player.specialAttack(enemy);
                if (playerSpecialResult.contains("not have enough power")) {
                    System.out.println(playerSpecialResult);
                    continue;
                }
                System.out.println(playerSpecialResult);
                
                displayStats(player, enemy);
                
                // Enemy's turn
                if (enemy.getHealth() > 0) {
                    System.out.println("\n" + enemy.getClass().getSimpleName() + " used Special Attack on " + player.getName());
                    String enemySpecialResult = enemy.specialAttack(player);
                    if (enemySpecialResult.contains("not have enough power")) {
                        System.out.println(enemySpecialResult);
                        
                    } else {
                        System.out.println(enemySpecialResult);
                        displayStats(player, enemy);
                    }
                    
                    // RegionalWarlord gets a follow-up attack
                    if (enemy instanceof RegionalWarlord && player.getHealth() > 0 && enemy.getPower() >= enemy.getStdAttackPowerCost()) {
                        System.out.println("\n" + enemy.getClass().getSimpleName() + " used Attack on " + player.getName());
                        System.out.println(enemy.getClass().getSimpleName() + " caused " + enemy.getStdAttackDamage() + " damage");
                        System.out.println(enemy.attack(player));
                    }
                    
                    displayStats(player, enemy);
                }
            } else {
                System.out.println("Invalid action. Please choose 'Attack' or 'Special Attack'.");
                continue;
            }

            // Skip player's turn if stunned
            if (enemy instanceof RegionalWarlord && ((RegionalWarlord) enemy).isOpponentStunned()) {
                System.out.println("\n" + player.getName() + " is stunned and cannot move!");
                ((RegionalWarlord) enemy).resetStun();
                
               displayStats(player, enemy);
            }
        }

        // Battle result
        if (player.getHealth() <= 0) {
            System.out.println("\n--------Results--------");
            System.out.println(player.getName() + " has been defeated by " + enemy.getClass().getSimpleName() + "!");
        } else {
            System.out.println("\n--------Results--------");
            System.out.println(enemy.getClass().getSimpleName() + " has been defeated by " + player.getName() + "!");
        }

        scanner.close();
    }
}
