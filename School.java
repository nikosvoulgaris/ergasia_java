/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class School {
    public static void main(String[] args) {
        // Φτιάχνει πέντε μαθήματα
        Course[] courses = new Course[5];
        
        for (int i = 0; i < 5; i++) {
            courses[0] = new Course("G" , "Gymnastiki");
            courses[1] = new Course("M" , "Mathimatika");
            courses[2] = new Course("T" , "Thriskeutika");
            courses[3] = new Course("X" , "Xhmeia");
            courses[4] = new Course("A" , "Arxaia");
        }

        // Φτιάχνει πέντε τάξεις
        Class[] classes = new Class[5];
        for (int i = 0; i < 5; i++) {
            classes[i] = new Class("E" + (i + 1), "Lab " + (i + 1));
        }

        // Φτιάχνει πέντε καθηγητές
        Teacher[] teachers = new Teacher[5];
        for (int i = 0; i < 5; i++) {
            teachers[i] = new Teacher("FirstName" + (i + 1), "LastName" + (i + 1), "" + (i + 1));
            teachers[i].setCourse(courses[i]);
            courses[i].setClassObj(classes[i]);
        }

        // Φτιάχνει είκοσι μαθητές
        Student[] students = new Student[20];
        for (int i = 0; i < 20; i++) {
            students[i] = new Student("Student" + (i + 1), "LastName" + (i + 1),"" + (i + 1));
            students[i].setCourses(new Course[]{courses[i % 5]});
        }

        // Βάζει τους καθηγητές στα μαθήματα
        for (int i = 0; i < 5; i++) {
            teachers[i].setCourse(courses[i]);
            courses[i].setTeacher(teachers[i]);
        }

        // Βάζει μαθήματα, τάξεις και καθηγητές
        for (int i = 0; i < 5; i++) {  
            teachers[i].setCourse(courses[i]);
            courses[i].setClassObj(classes[i]);
            classes[i].setTeacher(teachers[i]);
        }

        // Εμφανίζει πληροφορίες
        for (Teacher teacher : teachers) {
            teacher.printInfo();
        }

        for (Course course : courses) {
            course.printInfo();
        }

        for (Class classObj : classes) {
            classObj.printInfo();
        }

        for (Student student : students) {
            student.printInfo();
        }
    }

    static class Teacher {
        private String firstName;
        private String lastName;
        private String amka;
        private Course course;

        public Teacher(String firstName, String lastName, String amka) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.amka = amka;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAmka() {
            return amka;
        }

        public void setAmka(String amka) {
            this.amka = amka;
        }

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public void printInfo() {
            System.out.println("Teacher: " + firstName + " " + lastName + ", AMKA: " + amka);
            if (course != null) {
                System.out.println("Teaching Course: " + course.getCourseCode() + ", " + course.getDescription());
            }
            System.out.println();
        }
    }

    static class Course {
        private String courseCode;
        private String description;
        private Class classObj;
        private Teacher teacher;

        public Course(String courseCode, String description) {
            this.courseCode = courseCode;
            this.description = description;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Class getClassObj() {
            return classObj;
        }

        public void setClassObj(Class classObj) {
            this.classObj = classObj;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        public void printInfo() {
            System.out.println("Course: " + courseCode + ", " + description);
            if (classObj != null) {
                System.out.println("Taught in Class: " + classObj.getClassCode() + ", " + classObj.getDescription());
            }
            if (teacher != null) {
                System.out.println("Taught by Teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
            }
            System.out.println();
        }
    }

    static class Class {
        private String classCode;
        private String description;
        private Teacher teacher;

        public Class(String classCode, String description) {
            this.classCode = classCode;
            this.description = description;
        }

        public String getClassCode() {
            return classCode;
        }

        public void setClassCode(String classCode) {
            this.classCode = classCode;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        public void printInfo() {
            System.out.println("Class: " + classCode + ", " + description);
            if (teacher != null) {
                System.out.println("Taught by Teacher: " + teacher.getFirstName() + " " + teacher.getLastName());
            }
            System.out.println();
        }
    }

    static class Student {
        private String firstName;
        private String lastName;
        private String AM;
        private Course[] courses;

        public Student(String firstName, String lastName, String AM) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.AM = AM;
            this.courses = new Course[5];
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAM() {
            return AM;
        }

        public void setAM(String AM) {
            this.AM = AM;
        }

        public Course[] getCourses() {
            return courses;
        }

        public void setCourses(Course[] courses) {
            this.courses = courses;
        }

        public void printInfo() {
            System.out.println("Student: " + firstName + " " + lastName + ", AM: " + AM);
            System.out.println("Enrolled Courses:");
            for (Course course : courses) {
                if (course != null) {
                    System.out.println("- " + course.getCourseCode() + ", " + course.getDescription());
                }
            }
            System.out.println();
        }
    }
}
