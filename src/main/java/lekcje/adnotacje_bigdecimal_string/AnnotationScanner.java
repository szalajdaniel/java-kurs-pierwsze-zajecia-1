package main.java.lekcje.adnotacje_bigdecimal_string;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// 1. Tworzymy adnotację @RequiredRole
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RequiredRole {
    String value();
}

// 2. Klasa z metodami zabezpieczonymi adnotacjami
class MockDashboard {

    @RequiredRole("USER")
    public void viewReports() {
        System.out.println("Otwieram raporty");
    }

    @RequiredRole("ADMIN")
    public void deleteUsers() {
        System.out.println("Usuwam użytkownika z systemu");
    }
}

public class AnnotationScanner {

    public static void main(String[] args) {
        String currentUserRole = "USER";
        MockDashboard dashboard = new MockDashboard();

        System.out.println("Próba wywołania metod jako: " + currentUserRole);

        Method[] methods = MockDashboard.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(RequiredRole.class)) {
                RequiredRole roleAnnotation = method.getAnnotation(RequiredRole.class);
                String requiredRole = roleAnnotation.value();

                if (requiredRole.equals(currentUserRole)) {
                    System.out.println("Dostep przyznany dla metody: " + method.getName());
                    try {
                        // Wywołanie metody dla testu
                        method.invoke(dashboard);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Odmowa dostępu dla metody: " + method.getName() +
                            " (Wymagane: " + requiredRole + ", Twoja rola: " + currentUserRole + ")");
                }
            }
        }
    }
}