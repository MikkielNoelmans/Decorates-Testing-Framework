package portal.web.utils;

import portal.common.JSONHelper;

public class WebConfig {
    private static final String webConfigFile = "src/main/java/heroku/web/webConfig.json";

    public static String getDefaultBrowser(){
        return JSONHelper.getJSONStringFromJSONFile(webConfigFile, "defaultBrowser");
    }

    public static String getDefaultTimeout(){
        return JSONHelper.getJSONStringFromJSONFile(webConfigFile, "defaultTimeout");
    }

    public static String getBaseUrl(){
        return JSONHelper.getJSONStringFromJSONFile(webConfigFile, "baseUrl");
    }
}
