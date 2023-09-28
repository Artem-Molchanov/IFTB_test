package ITFB.data;
import lombok.Getter;

public class DataHelper {

    @Getter
    public static class UserInfo {
        private String name = "Ivanov Ivan";
        private String email = "ivanov@mail.ru";
        private String currentAddress = "Moscow";
        private String permanentAddress = "St. Petersburg";
    }
}
