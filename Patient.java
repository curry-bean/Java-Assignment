public class Patient {
    
    private String name;
    private int age;
    private String diagnosis;

    public Patient() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    
    public static void main(String[] args) {
        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setAge(45);
        patient.setDiagnosis("Flu");
        System.out.println(patient.getName() + " " + patient.getAge() + " " + patient.getDiagnosis());
    }
}
