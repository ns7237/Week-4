import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getRoleName();
    public abstract boolean isEligible();
}

class SoftwareEngineer extends JobRole {
    private int yearsOfExperience;
    private boolean knowsJava;

    public SoftwareEngineer(String name, int yearsOfExperience, boolean knowsJava) {
        super(name);
        this.yearsOfExperience = yearsOfExperience;
        this.knowsJava = knowsJava;
    }

    public String getRoleName() {
        return "Software Engineer";
    }

    public boolean isEligible() {
        return yearsOfExperience >= 2 && knowsJava;
    }
}

class DataScientist extends JobRole {
    private int projectsCompleted;
    private boolean knowsPython;

    public DataScientist(String name, int projectsCompleted, boolean knowsPython) {
        super(name);
        this.projectsCompleted = projectsCompleted;
        this.knowsPython = knowsPython;
    }

    public String getRoleName() {
        return "Data Scientist";
    }

    public boolean isEligible() {
        return projectsCompleted >= 3 && knowsPython;
    }
}

class ProductManager extends JobRole {
    private boolean hasMBADegree;
    private int yearsLeadingTeams;

    public ProductManager(String name, boolean hasMBADegree, int yearsLeadingTeams) {
        super(name);
        this.hasMBADegree = hasMBADegree;
        this.yearsLeadingTeams = yearsLeadingTeams;
    }

    public String getRoleName() {
        return "Product Manager";
    }

    public boolean isEligible() {
        return hasMBADegree && yearsLeadingTeams >= 2;
    }
}

class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public void processResume() {
        System.out.println("Candidate: " + jobRole.getCandidateName() + ", Role: " + jobRole.getRoleName() + ", Eligible: " + jobRole.isEligible());
    }

    public T getJobRole() {
        return jobRole;
    }
}

class ResumeUtils {
    public static void screenAllResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening " + role.getCandidateName() + " for " + role.getRoleName() + ": Eligible = " + role.isEligible());
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume1 = new Resume<>(new SoftwareEngineer("Alice", 3, true));
        Resume<DataScientist> resume2 = new Resume<>(new DataScientist("Bob", 4, true));
        Resume<ProductManager> resume3 = new Resume<>(new ProductManager("Charlie", true, 3));

        resume1.processResume();
        resume2.processResume();
        resume3.processResume();

        List<JobRole> allCandidates = new ArrayList<>();
        allCandidates.add(resume1.getJobRole());
        allCandidates.add(resume2.getJobRole());
        allCandidates.add(resume3.getJobRole());

        System.out.println("\nScreening Pipeline:");
        ResumeUtils.screenAllResumes(allCandidates);
    }
}
