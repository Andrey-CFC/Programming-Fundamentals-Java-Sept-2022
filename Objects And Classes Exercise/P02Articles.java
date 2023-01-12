package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Articles {
    static class Articles {
        private String title;
        private String content;
        private String author;

        public Articles(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }

        public String getAuthor() {
            return this.author;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String initialInput = scanner.nextLine();
        String[] articlesArr = initialInput.split(", ");
        Articles currentArticle = new Articles(articlesArr[0], articlesArr[1], articlesArr[2]);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();
            String[] commandArr = command.split(": ");
            if (commandArr[0].equals("Edit")) {
                String newContent = commandArr[1];
                currentArticle.setContent(newContent);
            } else if (commandArr[0].equals("ChangeAuthor")) {
                String newAuthor = commandArr[1];
                currentArticle.setAuthor(newAuthor);
            } else if (commandArr[0].equals("Rename")){
                String newName = commandArr[1];
                currentArticle.setTitle(newName);
            }
        }
        System.out.printf("%s - %s: %s",currentArticle.getTitle(),currentArticle.getContent(),currentArticle.getAuthor());
    }
}
