package store.store_api.model;

public enum Roles {
    Admin("admin"),
    Manager("manager");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}