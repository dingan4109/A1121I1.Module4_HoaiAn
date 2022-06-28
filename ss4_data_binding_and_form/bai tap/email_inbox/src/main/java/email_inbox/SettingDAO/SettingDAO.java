package email_inbox.SettingDAO;

import email_inbox.model.Setting;

public interface SettingDAO {
    void saveSetting(Setting setting);
    Setting getSetting(String lang);
}
