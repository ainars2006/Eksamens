import javax.swing.*;
import java.util.*;

class Question {
    protected String questionText;
    protected String[] options;
    protected int correctIndex;

    public Question(String questionText, String[] options, int correctIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctIndex = correctIndex;
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }
}
class MultipleChoiceQuestion extends Question {
    public MultipleChoiceQuestion(String questionText, String[] options, int correctIndex) {
        super(questionText, options, correctIndex);
    }
}

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
            } else {
                JOptionPane.showMessageDialog(null, "Uzredzēšanos");
                System.exit(0);
            }
        }
    }

    public static void takeQuiz() {
        List<MultipleChoiceQuestion> questions = new ArrayList<>();

        questions.add(new MultipleChoiceQuestion(
                "Kas ir superklase Java valodā?",
                new String[]{"Klase, no kuras manto cita klase", "Galīgā klase (final)", "Palīgklase", "Klase bez metodēm"},
                0
        ));
        questions.add(new MultipleChoiceQuestion(
                "Kurš atslēgvārds tiek izmantots, lai mantotu no superklases Java valodā?",
                new String[]{"inherit", "implements", "extends", "super"},
                2
        ));
        questions.add(new MultipleChoiceQuestion(
                "Vai apakšklase var pārrakstīt superklases metodes?",
                new String[]{"Jā", "Nē", "Tikai ja metode ir public", "Tikai interfeisos"},
                0
        ));
        questions.add(new MultipleChoiceQuestion(
                "Kas ir metodes pārrakstīšana (overriding)?",
                new String[]{"Tādas pašas metodes nosaukuma lietošana apakšklasē", "Divu metožu rakstīšana ar vienādu nosaukumu", "Superklases metodes izsaukšana", "Privātu metožu izveide"},
                0
        ));
        questions.add(new MultipleChoiceQuestion(
                "Kāda ir 'super' atslēgvārda nozīme Java valodā?",
                new String[]{"Superklases konstruktora vai metodes izsaukšana", "Citu klašu importēšana", "Metodes izbeigšana", "Norāde tikai uz apakšklasi"},
                0
        ));
        questions.add(new MultipleChoiceQuestion(
                "Vai klase var paplašināt vairākas klases Java valodā?",
                new String[]{"Jā", "Nē", "Tikai izmantojot interfeisus", "Tikai ar abstraktajām klasēm"},
                1
        ));
        questions.add(new MultipleChoiceQuestion(
                "Kas notiek, ja apakšklase nepārraksta superklases metodi?",
                new String[]{"Kompilēšanas kļūda", "Tiek izmantota superklases metode", "Programma avarē", "Izmet izņēmumu"},
                1
        ));
        questions.add(new MultipleChoiceQuestion(
                "Vai superklases konstruktors tiek izsaukts automātiski?",
                new String[]{"Jā, ja apakšklasei ir konstruktors", "Nē", "Jā, vienmēr", "Tikai ja izmanto 'super()'"},
                2
        ));
        questions.add(new MultipleChoiceQuestion(
                "Vai apakšklase var tieši piekļūt superklases privātajiem locekļiem?",
                new String[]{"Jā", "Nē", "Tikai ja ir protected", "Tikai izmantojot getter/setter metodes"},
                1
        ));
        questions.add(new MultipleChoiceQuestion(
                "Kā var aizliegt klasi mantot (paplašināt)?",
                new String[]{"Izmantojot 'final'", "Izmantojot 'static'", "Izmantojot 'super'", "Izmantojot 'private'"},
                0
        ));

        Collections.shuffle(questions);

        int score = 0;
        List<String> results = new ArrayList<>();

        for (int i = 0; i < questions.size(); i++) {
            MultipleChoiceQuestion q = questions.get(i);
            int response = JOptionPane.showOptionDialog(
                    null,
                    q.getQuestionText(),
                    "Jautājums " + (i + 1),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    q.getOptions(),
                    q.getOptions()[0]
            );

            if (response == q.getCorrectIndex()) {
                score++;
            } else if (response >= 0) {
                results.add(q.getQuestionText() +
                        "\n   Tava atbilde: " + q.getOptions()[response] +
                        "\n   Pareizā atbilde: " + q.getOptions()[q.getCorrectIndex()] + "\n");
            }
        }

        int viewResults = JOptionPane.showOptionDialog(
                null,
                "Tests pabeigts!\nPareizo atbilžu skaits: " + score + " no " + questions.size(),
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
