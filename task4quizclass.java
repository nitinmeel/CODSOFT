import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private QuizQuestion[] questions;
    private int score;
    private int currentQuestionIndex;
    private boolean timeUp;

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
        this.score = 0;
        this.currentQuestionIndex = 0;
        this.timeUp = false;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (QuizQuestion question : questions) {
            displayQuestion(question);
            startTimer(15); // 15 seconds per question

            System.out.print("Your answer (1-4): ");
            int answer = scanner.nextInt();
            
            // Wait for the timer to finish if the user answers too quickly
            while (!timeUp) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (answer == question.getCorrectAnswerIndex() + 1) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer was: " + (question.getCorrectAnswerIndex() + 1) + "\n");
            }

            timeUp = false; // Reset timeUp for the next question
            currentQuestionIndex++;
        }
        
        displayResults();
        scanner.close();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private void startTimer(int seconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                timer.cancel();
            }
        }, seconds * 1000);
    }

    private void displayResults() {
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + " out of " + questions.length);
        for (int i = 0; i < questions.length; i++) {
            QuizQuestion question = questions[i];
            System.out.println("Q" + (i + 1) + ": " + question.getQuestion());
            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.print((j + 1) + ". " + options[j]);
                if (j == question.getCorrectAnswerIndex()) {
                    System.out.print(" (Correct)");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
