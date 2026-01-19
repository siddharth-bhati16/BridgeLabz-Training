package JavaGenerics;

import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    protected String roleName;

    public String getRoleName() {
        return roleName;
    }

    public abstract String evaluateSkills();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        roleName = "Software Engineer";
    }

    @Override
    public String evaluateSkills() {
        return "Evaluating DSA, System Design, and Programming Skills";
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        roleName = "Data Scientist";
    }

    @Override
    public String evaluateSkills() {
        return "Evaluating Statistics, ML Models, and Python Skills";
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        roleName = "Product Manager";
    }

    @Override
    public String evaluateSkills() {
        return "Evaluating Product Strategy, Communication, and Leadership";
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private int experience;
    private T jobRole;

    public Resume(String candidateName, int experience, T jobRole) {
        this.candidateName = candidateName;
        this.experience = experience;
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public String processResume() {
        return "Candidate: " + candidateName +
                " | Experience: " + experience + " years | Role: " +
                jobRole.getRoleName();
    }
}

class ScreeningEngine {

    public static <T extends Resume<? extends JobRole>> void screen(T resume) {
        System.out.println(resume.processResume());
        System.out.println(resume.getJobRole().evaluateSkills());
    }

    public static void runPipeline(List<? extends JobRole> roles) {
        System.out.println("\n--- Screening Pipeline Initialized ---");
        for (JobRole role : roles) {
            System.out.println(role.getRoleName() + " → " + role.evaluateSkills());
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {

        Resume<SoftwareEngineer> seResume =
                new Resume<>("Alice", 5, new SoftwareEngineer());

        Resume<DataScientist> dsResume =
                new Resume<>("Bob", 3, new DataScientist());

        Resume<ProductManager> pmResume =
                new Resume<>("Charlie", 7, new ProductManager());

        System.out.println("=== INDIVIDUAL RESUME SCREENING ===");
        ScreeningEngine.screen(seResume);
        ScreeningEngine.screen(dsResume);
        ScreeningEngine.screen(pmResume);

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        ScreeningEngine.runPipeline(jobRoles);
    }
}

