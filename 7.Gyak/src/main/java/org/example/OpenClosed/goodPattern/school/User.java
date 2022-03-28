package org.example.OpenClosed.goodPattern.school;

public abstract class User {
    public void login() {
        System.out.println("login");
    }
    public void logout() {
        System.out.println("logout");
    }

    public String getDachBorad(){
        return "listCourses";
    }
}
