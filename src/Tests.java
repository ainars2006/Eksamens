import javax.swing.*;
import java.util.*;

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
    	        } else if (choice == 1) {
    	            JOptionPane.showMessageDialog(null, "Uzredzēšanos");
    	            System.exit(0);
    	        } else if (choice == JOptionPane.CLOSED_OPTION) {
    	            System.exit(0);
    	        }
    	    }
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
    	    int[] correctAnswers = {
    	        0, 2, 0, 0, 0,
    	        1, 1, 2, 1, 0
    	    };
    	    Integer[] indices = new Integer[questions.length];
    	    for (int i = 0; i < indices.length; i++) indices[i] = i;
    	    Collections.shuffle(Arrays.asList(indices));

    	    int score = 0;
    	    List<String> results = new ArrayList<>();

    	    for (int i = 0; i < indices.length; i++) {
    	        int q = indices[i];
    	        int response = JOptionPane.showOptionDialog(
    	                null,
    	                questions[q],
    	                "Jautājums " + (i + 1),
    	                JOptionPane.DEFAULT_OPTION,
    	                JOptionPane.QUESTION_MESSAGE,
    	                null,
    	                options[q],
    	                options[q][0]
    	        );
    	        if (response == correctAnswers[q]) {
    	            score++;
    	        } else if (response >= 0) {
    	            results.add(questions[q] +
    	                        "\n   Tava atbilde: " + options[q][response] +
    	                        "\n   Pareizā atbilde: " + options[q][correctAnswers[q]] + "\n");
    	        }
    	    }
    	    int viewResults = JOptionPane.showOptionDialog(
    	            null,
    	            "Tests pabeigts!\nPareizo atbilžu skaits: " + score + " no " + questions.length,
    	            "Rezultāts",
    	            JOptionPane.YES_NO_OPTION,
    	            JOptionPane.INFORMATION_MESSAGE,
    	            null,
    	            new String[]{"Rezultātu saraksts", "Aizvērt"},
    	            "Rezultātu saraksts"
    	    );
    	    if (viewResults == JOptionPane.YES_OPTION && !results.isEmpty()) {
    	        JTextArea textArea = new JTextArea();
    	        textArea.setText(String.join("\n", results));
    	        textArea.setEditable(false);
    	        JScrollPane scrollPane = new JScrollPane(textArea);
    	        scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));

    	        JOptionPane.showMessageDialog(null, scrollPane, "Nepareizās atbildes", JOptionPane.INFORMATION_MESSAGE);
    	    } else if (results.isEmpty() && viewResults == JOptionPane.YES_OPTION) {
    	        JOptionPane.showMessageDialog(null, "🎉 Visi jautājumi atbildēti pareizi!", "Rezultāts", JOptionPane.INFORMATION_MESSAGE);
    	    }
    	}
}
