package com.ericlam.mc.hnmclobby.config;

import com.hypernite.mc.hnmc.core.config.yaml.MessageConfiguration;
import com.hypernite.mc.hnmc.core.config.yaml.Resource;

@Resource(locate = "Messages.yml")
public class MessagesConfig extends MessageConfiguration {

    public String getTurnOn(String section) {
        return get(section + ".Turn-On");
    }

    public String getTurnOff(String section) {
        return get(section + ".Turn-Off");
    }

    public String getBeTurnOn(String section) {
        return get(section + ".Be-Turn-On");
    }

    public String getBeTurnOff(String section) {
        return get(section + ".Be-Turn-Off");
    }

    public String getShow(String section) {
        return get(section + ".show");
    }

    public String getHide(String section) {
        return get(section + ".hide");
    }

    public String getBeHide(String section) {
        return get(section + ".be-hide");
    }

    public String getBeShow(String section) {
        return get(section + ".be-show");
    }

    public String getStacker(String path) {
        return get("Stacker." + path);
    }

    public String getSpawn(String path) {
        return get("spawn." + path);
    }

    public String getGUI(String path) {
        return getPure("GUI." + path);
    }
}
