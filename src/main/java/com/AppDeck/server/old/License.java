package com.AppDeck.server.old;

public class License {
    private static final String licenza = "OK6AEKNYF1LBUY8V22D64CL34RAPRST4MY40W59A1YKD9HTXC2TN6LHQJ9FVC1N88OSSYN8MQLG44VL38NDCM4V9MWAG936GZOXM5J05PTGAABXIQF57I8AZ5FA12FIGS7FLNHUDKRXXJXUR1";

    public static boolean addLicense() {
        try {
            System.setProperty("jxbrowser.license.key", License.licenza);
            return true;
        } catch (SecurityException e){
            return false;
        }
    }
}
