public class QuizApp {
    public static void main(String[] args) {
        QuizQuestion[] questions = new QuizQuestion[] {
            new QuizQuestion("What is the capital of France?", new String[] {"Berlin", "Paris", "Rome", "Madrid"}, 1),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[] {"Earth", "Venus", "Mars", "Jupiter"}, 2),
            new QuizQuestion("What is the largest ocean on Earth?", new String[] {"Atlantic", "Indian", "Arctic", "Pacific"}, 3),
            new QuizQuestion("Who wrote 'Hamlet'?", new String[] {"Charles Dickens", "J.K. Rowling", "Mark Twain", "William Shakespeare"}, 3)
        };

        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}

