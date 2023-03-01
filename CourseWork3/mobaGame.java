package CourseWork3;

import java.util.ArrayList;
import java.util.List;

public class mobaGame {

    public static void main(String[] args) {
        //Create the first hero.
        System.out.println("Hero1:"+"\n");
        Hero hero1 = new Hero(1000, 150, 100, "Auxiliary");
        hero1.printSkills();

        System.out.println("\n---------------------------\n");

        //Create the second hero.
        System.out.println("Hero2:"+"\n");
        Hero hero2 = new Hero(800, 350, 140, "Master");
        hero2.printSkills();
    }

    static public class Hero {
        // The hero's life value.
        private int Life;
        // The hero's movement speed.
        private int MovementSpeed;
        // The hero's attack power.
        private int AttackPower;
        // The hero's profession skills.
        private final List<skillPools> professionSkills;
        // The hero's shared skills.
        private final List<sharedSkills> sharedSkills;
        public void printSkills() {
            // Print the profession skills.
            System.out.println("The profession skills: ");
            for (skillPools skill : professionSkills) {
                for (String skillName : skill.getProfessionSkills()) {
                    System.out.println(skillName);
                }
            }
            // Print the shared skills.
            System.out.println("The shared skills: ");
            for (sharedSkills skill : sharedSkills) {
                System.out.println(skill.getSkill1());
                System.out.println(skill.getSkill2());
            }
        }

        public Hero(int Life, int MovementSpeed, int AttackPower, String professions) {
            // Initialize the hero's life, movement speed, and attack power.
            this.Life = Life;
            this.MovementSpeed = MovementSpeed;
            this.AttackPower = AttackPower;

            // Initialize the professionSkills and sharedSkills fields.
            this.professionSkills = new ArrayList<>();
            this.sharedSkills = new ArrayList<>();

            // Create a new skillPools object and add it to the professionSkills list.
            skillPools skillPools = new skillPools(professions);
            this.professionSkills.add(skillPools);

            // Create a new sharedSkills object and add it to the sharedSkills list.
            sharedSkills sharedSkills1 = new sharedSkills("Accelerate","Flash");
            this.sharedSkills.add(sharedSkills1);
        }
    }
    // All the skills are in this pool.
    static class skillPools {
        //Implementation encapsulation.
        private final List<String> professionSkills;
        public List<String> getProfessionSkills() {
            return professionSkills;
        }
        public skillPools(String professions) {
            this.professionSkills = new ArrayList<>();
            List<String> sharedSkills = new ArrayList<>();

         /* Depending on the hero's profession,
            add the appropriate skills to the professionSkills list.*/

         /* If the hero's profession is "Auxiliary",
            the hero's profession skills are "AddHealth", "RemoveCurse" and "Heal".*/
            if (professions.equals("Auxiliary")) {
                professionSkills.add("Add Health");
                professionSkills.add("Remove Curse");
                professionSkills.add("Heal");

         /* If the hero's profession is "Master",
            the hero's profession skills are "CoolingShortening","IncreaseEXP","MagicAttack".*/
            } else if (professions.equals("Master")) {
                professionSkills.add("Cooling Shortening");
                professionSkills.add("Increase EXP");
                professionSkills.add("Magic Attack");
            }
            // The professions correspond to corresponding shared skills.
            if (professions.equals("Auxiliary")) {
                sharedSkills.add("Accelerate");
            }else if (professions.equals("Master")) {
                sharedSkills.add("Flash");
            }
        }
    }
    // Store the shared skills.
    static class sharedSkills{
        public sharedSkills(String Skill1, String Skill2) {
        }
        public String getSkill1() {
            return "Accelerate";
        }
        public String getSkill2() {
            return "Flash";
        }
    }
}
