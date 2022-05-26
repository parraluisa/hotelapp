package co.edu.javeriana.hotelapp.model.dto;

public class LogInDTO {
    String user;
    String password;

    public LogInDTO(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogInDTO)) return false;

        LogInDTO logInDTO = (LogInDTO) o;

        if (!getUser().equals(logInDTO.getUser())) return false;
        return getPassword().equals(logInDTO.getPassword());
    }

    @Override
    public int hashCode() {
        int result = getUser().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }
}
