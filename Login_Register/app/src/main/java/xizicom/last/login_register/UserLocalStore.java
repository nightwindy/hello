package xizicom.last.login_register;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Paladin on 2015/7/17.
 */
public class UserLocalStore {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDataBase;

    public UserLocalStore(Context context) {
        userLocalDataBase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor editor = userLocalDataBase.edit();
        editor.putString("username", user.name);
        editor.putString("password", user.password);
        editor.commit();
    }

    public User getLoggedInUser() {
        String name = userLocalDataBase.getString("username", "");
        String password = userLocalDataBase.getString("password", "");
        User storeUser = new User(name, password);
        return storeUser;
    }

    public void setUserLoggedIn(Boolean loggedIn) {
        SharedPreferences.Editor editor = userLocalDataBase.edit();
        editor.putBoolean("loggedIn", loggedIn);
        editor.commit();
    }

    public void clearUserData() {
        SharedPreferences.Editor editor = userLocalDataBase.edit();
        editor.clear();
        editor.commit();
    }
}
