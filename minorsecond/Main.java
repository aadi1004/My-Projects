package minorsecond;

import java.util.Scanner;

public class Main {
	private static final int SAVE_PASSWORD_OPTION = 1;
	private static final int SAVE_NOTE_OPTION = 2;
	private static final int SHOW_PASSWORDS_OPTION = 3;
	private static final int SHOW_NOTES_OPTION = 4;
	private static final int BACK_OPTION = 5;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PasswordManager passwordManager = new PasswordManager();
		NotesManager notesManager = new NotesManager();

		boolean loggedIn = false;
		while (!loggedIn) {
			System.out.print("Enter password to log in: ");
			String password = scanner.nextLine();
			if (password.equals("password123")) {
				loggedIn = true;
			} else {
				System.out.println("Invalid password. Try again.");
			}
		}

		int choice;
		do {
			showWelcomeMenu();
			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case SAVE_PASSWORD_OPTION:
				System.out.print("Enter password to save: ");
				String password = scanner.nextLine();
				passwordManager.savePassword(password);
				System.out.println("Password saved successfully.");
				break;
			case SAVE_NOTE_OPTION:
				System.out.print("Enter note to save: ");
				String note = scanner.nextLine();
				notesManager.saveNote(note);
				System.out.println("Note saved successfully.");
				break;
			case SHOW_PASSWORDS_OPTION:
				passwordManager.showSavedPasswords();
				handlePasswordActions(passwordManager, scanner);
				break;
			case SHOW_NOTES_OPTION:
				notesManager.showSavedNotes();
				handleNoteActions(notesManager, scanner);
				break;
			case BACK_OPTION:
				System.out.println("Returning to login page...");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
				break;
			}
		} while (choice != BACK_OPTION);
	}

	private static void showWelcomeMenu() {
		System.out.println("Welcome to Note and Password Manager");
		System.out.println("1. Save a password");
		System.out.println("2. Save a note");
		System.out.println("3. Show saved passwords");
		System.out.println("4. Show saved notes");
		System.out.println("5. Back to login page");
		System.out.print("Enter your choice: ");
	}

	private static void handlePasswordActions(PasswordManager passwordManager, Scanner scanner) {
		System.out.println("1. Delete a password");
		System.out.println("2. Back to welcome page");
		System.out.print("Enter your choice: ");
		int choice = Integer.parseInt(scanner.nextLine());

		switch (choice) {
		case 1:
			System.out.print("Enter password index to delete: ");
			int index = Integer.parseInt(scanner.nextLine());
//			PasswordManager passwordManager2 = passwordManager;
			passwordManager.deletePassword(index - 1);
			break;
		case 2:
			System.out.println("Returning to welcome page...");
			break;
		default:
			System.out.println("Invalid choice. Returning to welcome page...");
			break;
		}
	}

	private static void handleNoteActions(NotesManager notesManager, Scanner scanner) {
		System.out.println("1. Delete a note");
		System.out.println("2. Back to welcome page");
		System.out.print("Enter your choice: ");
		int choice = Integer.parseInt(scanner.nextLine());

		switch (choice) {
		case 1:
			System.out.print("Enter note index to delete: ");
			int index = Integer.parseInt(scanner.nextLine());
			notesManager.deleteNote(index - 1);
			break;
		case 2:
			System.out.println("Returning to welcome page...");
			break;
		default:
			System.out.println("Invalid choice. Returning to welcome page...");
			break;
		}
	}
}
