package ClassWork.February.Week2.Wednesday15.Lib;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPresenter {

    public UserPresenter (UserModel model) {
        this.email = model.getEmail();
    }
    private String email;
}
