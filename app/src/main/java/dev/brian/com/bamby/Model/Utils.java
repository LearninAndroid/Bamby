package dev.brian.com.bamby.Model;

import io.realm.Realm;
import io.realm.RealmQuery;

public class Utils {
    Realm realm;
    public boolean checkIfUserExists(final String username){
        boolean success = true;
     //   realm = Realm.getDefaultInstance();
        RealmQuery<User> realmQuery = realm.where(User.class);
        realmQuery.equalTo("username",username);
        if(realmQuery.count()>0){
            success = true;
        }else{
            success = false;
        }
        return success;
    }
    public Utils(){
        realm = Realm.getDefaultInstance();
    }
}
