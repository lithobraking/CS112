public class User implements Comparable<User>{
    private final String username;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%20s%20s", password, username);
    }

    @Override
    public int compareTo(User u) {
        if (this.password.length() == u.password.length()) {
            if (this.password.compareToIgnoreCase(u.password) == 0) {
                if (this.username.compareToIgnoreCase(u.username) == 0) {
                    return 0;
                } else if (this.username.compareToIgnoreCase(u.username) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.password.compareToIgnoreCase(u.password) > 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.password.length() > u.password.length()) {
            return 1;
        } else {
            return -1;
        }
    }
}
