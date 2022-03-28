package org.example.OpenClosed.badPattern;

public class User {
    private String role;

    public User(String role){
        this.role = role;
    }

    public void login() {
        System.out.println("login");
    }
    public void logout() {
        System.out.println("logout");
    }

    public String getDachBorad(){
        String dashboardContent;
        if("student".equals(this.role)){
            dashboardContent = "courseSubscriber, takeExam, listCourses";
        }else{
            dashboardContent = "coursePublisher, createExam, listCourses";
        }

        return dashboardContent;
    }
}
