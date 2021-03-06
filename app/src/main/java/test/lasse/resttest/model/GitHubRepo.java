package test.lasse.resttest.model;

/**
 * Created by Lasse on 06-Aug-17.
 */

public class GitHubRepo {
    private String name, description, language;

    public GitHubRepo(String name, String description, String language) {
        this.name = name;
        this.description = description;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "GitHubRepo{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}