import java.util.Scanner;

public class Chatbot {

    public static String getResponse(String question) {

        question = question.toLowerCase();

        if (question.contains("course") || question.contains("courses")) {
            return "Cummins College offers undergraduate and postgraduate engineering programs across multiple departments.";
        }

        if (question.contains("admission") || question.contains("admissions")) {
            return "For admission-related information, please refer to the official Cummins College admissions section.";
        }

        if (question.contains("placement") || question.contains("placements")) {
            return "Cummins College has an Industry Relations and placement-related section providing information about training, recruitment and industry interaction.";
        }

        if (question.contains("department") || question.contains("departments")) {
            return "The college has multiple engineering departments. Ask me about a specific department to learn more.";
        }

        if (question.contains("facility") || question.contains("facilities")) {
            return "The college provides facilities such as laboratories, library resources, hostels, sports facilities and other campus infrastructure.";
        }

        if (question.contains("hello") || question.contains("hi") || question.contains("hey")) {
            return "Hello! I am the CCEW College Assistant. How can I help you?";
        }

        if (question.contains("thank")) {
            return "You're welcome! Feel free to ask another question.";
        }

        return "I'm sorry, I don't have information about that yet. Please try asking about admissions, courses, departments, placements or facilities.";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("       CCEW COLLEGE ASSISTANT");
        System.out.println("====================================");
        System.out.println("Type 'exit' to close the chatbot.");
        System.out.println();

        while (true) {

            System.out.print("You: ");

            String question = scanner.nextLine();

            if (question.equalsIgnoreCase("exit")) {
                System.out.println("Bot: Goodbye!");
                break;
            }

            String response = getResponse(question);

            System.out.println("Bot: " + response);
            System.out.println();
        }

        scanner.close();
    }
}