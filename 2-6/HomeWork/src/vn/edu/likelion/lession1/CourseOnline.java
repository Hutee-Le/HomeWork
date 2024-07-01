package vn.edu.likelion.lession1;

public class CourseOnline extends Course {
    private String platform;
    private int duration;

    public CourseOnline(){
        super();
        this.platform = "";
        this.duration = 0;
    }

    public CourseOnline(int courseId, String courseName, String mentorName, int credit, String platform, int duration) {
        super(courseId, courseName, mentorName, credit);
        this.platform = platform;
        this.duration = duration;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void displayDetailCourse() {
        super.displayDetailCourse();
        System.out.println("Platform: " + platform);
        System.out.println("Duration: " + duration);
    }
}
