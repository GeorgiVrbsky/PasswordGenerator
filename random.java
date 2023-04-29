import java.security.SecureRandom;
public class random {

    public String Password_Generator(int n, boolean Upper, boolean Lower, boolean Numbers, boolean Characters){

        SecureRandom random = new SecureRandom();

        String[] final_password = new String[n];

        final String upper_Case = "ADBCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lower_Case = "abcdefghijklmnopqrstuvwxyz";
        final String numbers = "0123456789";
        final String characters = "!@#$%^&*()_+{}[]|',./<>?";

        int k =0;


       while(k!=n){
            int random_picker = random.nextInt(4);


            switch (random_picker){
                case 0:
                {
                    if(Upper==true) {
                        char upper_Case_Random = upper_Case.charAt(random.nextInt(upper_Case.length()));
                        final_password[k] = String.valueOf(upper_Case_Random);
                        k++;
                    }
                    break;
                }
                case 1:
                {
                    if(Lower==true) {
                        char lower_Case_Random = lower_Case.charAt(random.nextInt(lower_Case.length()));
                        final_password[k] = String.valueOf(lower_Case_Random);
                        k++;
                    }
                    break;
                }
                case 2:
                {
                    if(Numbers==true) {
                        char numbers_Random = numbers.charAt(random.nextInt(numbers.length()));
                        final_password[k] = String.valueOf(numbers_Random);
                        k++;
                    }
                    break;
                }
                case 3:
                {
                    if(Characters==true) {
                        char characters_Random = characters.charAt(random.nextInt(characters.length()));
                        final_password[k] = String.valueOf(characters_Random);
                        k++;
                    }
                    break;
                }
            }
        }

        return String.join("", final_password);
    }
}
