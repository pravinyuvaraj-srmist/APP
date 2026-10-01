public class AuthModel {
    private final String username = "admin";
    private String password = "admin123";

    public boolean validate(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }
    public boolean checkOldPassword(String old) { return password.equals(old); }
    public void changePassword(String newPass) { this.password = newPass; }
}
