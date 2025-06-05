import javax.swing.*;

public class Tests {

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Pildīt testu", "Aizvērt"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Izvēlies:",
                    "Tests",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (choice == 0) {
                takeQuiz();
            } else if (choice == 1 || choice == JOptionPane.CLOSED_OPTION) {
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "Uzredzēšanos");
        System.exit(0);
    }

    public static void takeQuiz() {
    	String[] questions = {
    		    "Kas ir superklase Java valodā?",
    		    "Kurš atslēgvārds tiek izmantots, lai mantotu no superklases Java valodā?",
    		    "Vai apakšklase var pārrakstīt superklases metodes?",
    		    "Kas ir metodes pārrakstīšana (overriding)?",
    		    "Kāda ir 'super' atslēgvārda nozīme Java valodā?",
    		    "Vai klase var paplašināt vairākas klases Java valodā?",
    		    "Kas notiek, ja apakšklase nepārraksta superklases metodi?",
    		    "Vai superklases konstruktors tiek izsaukts automātiski?",
    		    "Vai apakšklase var tieši piekļūt superklases privātajiem locekļiem?",
    		    "Kā var aizliegt klasi mantot (paplašināt)?"
    		};
    	String[][] options = {
    		    {"Klase, no kuras manto cita klase", "Galīgā klase (final)", "Palīgklase", "Klase bez metodēm"},
    		    {"inherit", "implements", "extends", "super"},
    		    {"Jā", "Nē", "Tikai ja metode ir public", "Tikai interfeisos"},
    		    {"Tādas pašas metodes nosaukuma lietošana apakšklasē", "Divu metožu rakstīšana ar vienādu nosaukumu", "Superklases metodes izsaukšana", "Privātu metožu izveide"},
    		    {"Superklases konstruktora vai metodes izsaukšana", "Citu klašu importēšana", "Metodes izbeigšana", "Norāde tikai uz apakšklasi"},
    		    {"Jā", "Nē", "Tikai izmantojot interfeisus", "Tikai ar abstraktajām klasēm"},
    		    {"Kompilēšanas kļūda", "Tiek izmantota superklases metode", "Programma avarē", "Izmet izņēmumu"},
    		    {"Jā, ja apakšklasei ir konstruktors", "Nē", "Jā, vienmēr", "Tikai ja izmanto 'super()'"},
    		    {"Jā", "Nē", "Tikai ja ir protected", "Tikai izmantojot getter/setter metodes"},
    		    {"Izmantojot 'final'", "Izmantojot 'static'", "Izmantojot 'super'", "Izmantojot 'private'"}
    		};
    }
}
