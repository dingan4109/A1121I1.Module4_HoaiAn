package email_inbox.SettingDAO;

import email_inbox.model.Setting;

import java.util.ArrayList;
import java.util.List;

public class SettingDAOImpl implements SettingDAO {
    static List<Setting> settingList = new ArrayList<>();
    @Override
    public void saveSetting(Setting setting) {
        settingList.add(setting);
    }

    @Override
    public Setting getSetting(String lang) {
       for(Setting setting : settingList) {
           if(setting.getLanguage().equals(lang)) {
               return setting;
           }
       } return null;
    }
}
