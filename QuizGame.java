import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> options;
     String correctAnswer;

    public Question(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    public void display() {
        System.out.println(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((char)('A' + i) + ". " + options.get(i));
        }
    }
}

class QuizGame {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", List.of("Paris", "London", "Berlin", "Madrid"), "A"));
        questions.add(new Question("Which planet is known as the Red Planet?", List.of("Earth", "Mars", "Venus", "Jupiter"), "B"));
        questions.add(new Question("What is the largest mammal on Earth?", List.of("Elephant", "Blue Whale", "Giraffe", "Gorilla"), "B"));

        Collections.shuffle(questions);  // Shuffle the questions.

        int score = 0;
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            question.display();
            System.out.print("Enter the letter of your answer (A, B, C, or D): ");
            String userAnswer = scanner.nextLine().toUpperCase();

            if (question.isCorrect(userAnswer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + question.correctAnswer + ".\n");
            }
        }

        System.out.println("Quiz completed. You got " + score + " out of " + questions.size() + " questions correct.");
    }
}
