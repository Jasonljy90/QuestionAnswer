package Jason.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		Scanner inputReader = new Scanner(System.in);
		String q = "";
		String a = "";
		game(q, a);
		System.out.println("Do you wish to continue? y/n");
		String userInput = inputReader.nextLine();
		while(userInput.equals("y")){
			game(q, a);
		}
		System.out.println("Good Bye");
	}

	private static void game(String q, String a){
		boolean c = true;
		int score = 0;
		int tries = 3;
		List<String> questions = new ArrayList<String>();
		questions.add("What day is today?");
		questions.add("How are you today?");
		questions.add("Do you have a pet?");
		List<String> answers = new ArrayList<String>();
		answers.add("Friday");
		answers.add("Great");
		answers.add("Yes");

		if(!q.isEmpty() && !a.isEmpty()){
			questions.add(q);
			answers.add(a);
		}

		Scanner inputReader = new Scanner(System.in);

		while(!questions.isEmpty()){
			Random rand = new Random();
			int rand1 = rand.nextInt(questions.size());
			System.out.println(questions.get(rand1));
			String userInput = inputReader.nextLine();

			if(userInput.equals(answers.get(rand1)) && tries > 0){
				score += tries;
				questions.remove(rand1);
				answers.remove(rand1);
				System.out.println("Your score is " + score);
			} else{
				System.out.println("Wrong answer");
				tries--;
			}
		}
		if (score == 9){
			System.out.println("Do you wish to add a question? y/n");
			String userInput = inputReader.nextLine();
			if(userInput.equals("y")){
				System.out.println("Please enter your question");
				String questionInput = inputReader.nextLine();
				System.out.println("Please enter your answer");
				String answerInput = inputReader.nextLine();
				game(questionInput, answerInput);
			} else{
				System.out.println("Good Bye");
			}
		}
	}
}