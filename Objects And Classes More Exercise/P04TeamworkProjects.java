package ObjectsAndClassesMoreEx;

import java.util.*;

public class P04TeamworkProjects {
    static class Team {
        private String teamName;
        private String creator;
        private List<String> members = new ArrayList<>();

        public Team() {

        }

        public Team(String teamName, String creator) {
            this.teamName = teamName;
            this.creator = creator;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        public String printList() {
            Collections.sort(members);
            return String.join(System.lineSeparator() + " -- ", members);
        }

        @Override
        public String toString() {

            return String.format("%s%n" +
                    " - %s%n" +
                    " -- %s", teamName, creator, printList());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Team> teamsByUsers = new TreeMap<>();
        TreeMap<String, Team> teamsByName = new TreeMap<>();
        Team team = new Team();
        for (int i = 0; i < rows; i++) {
            String[] inputLine = scanner.nextLine().split("-");
            String teamName = inputLine[1];
            String creator = inputLine[0];
            Team result = teamsByUsers.get(creator);
            Team resultForTeams = teamsByName.get(teamName);
            if (result == null && resultForTeams == null) {
                team = new Team(teamName, creator);
                teamsByUsers.put(creator, team);
                teamsByName.put(teamName, team);
                System.out.printf("Team %s has been created by %s!%n", teamName, creator);
            } else {
                if (resultForTeams != null) {
                    System.out.printf("Team %s was already created!%n", teamName);
                } else {
                    System.out.printf("%s cannot create another team!%n", creator);
                }
            }
        }

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("end of assignment")) {
            String user = commandLine.split("->")[0];
            String teamName = commandLine.split("->")[1];

            Team resultForTeams = teamsByName.get(teamName);
            if (resultForTeams == null) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else {
                Team resultForUsers = teamsByUsers.get(user);
                if (resultForUsers == null) {
                    List<String> users = resultForTeams.getMembers();
                    users.add(user);
                    resultForTeams.setMembers(users);
                    teamsByUsers.put(user, team);
                } else {
                    System.out.printf("Member %s cannot join team %s!%n", user, teamName);
                }
            }

            commandLine = scanner.nextLine();

        }
        Map<String, Integer> membersCountByTeams = new TreeMap<>();
        List<String> teamsToDisband = new ArrayList<>();
        for (Map.Entry<String, Team> entry : teamsByName.entrySet()) {
            int listSize = entry.getValue().getMembers().size();
            if (listSize == 0) {
                teamsToDisband.add(entry.getValue().getTeamName());
            } else {
                membersCountByTeams.put(entry.getKey(), entry.getValue().getMembers().size());
            }
        }


        for (String item : teamsToDisband) {
            teamsByName.remove(item);
        }

        LinkedHashMap<String, Integer> reversedMembersCountByTeams = new LinkedHashMap<>();

        membersCountByTeams.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(e -> reversedMembersCountByTeams.put(e.getKey(), e.getValue()));

        for (Map.Entry<String, Integer> entry : reversedMembersCountByTeams.entrySet()) {
            String nameTeam = entry.getKey();
            for (Map.Entry<String, Team> teamEntry : teamsByName.entrySet()) {
                if (nameTeam.equals(teamEntry.getKey())) {
                    System.out.println(teamEntry.getValue().toString());
                }
            }

        }

        Collections.sort(teamsToDisband);
        System.out.println("Teams to disband:");
        if (!teamsToDisband.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), teamsToDisband));
        }
    }
}
