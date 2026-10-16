package com.applovin.impl;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.HKJ.pnxuebdT;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class tn {
    public static Boolean a(int i3, String str) {
        if (!a(str)) {
            return null;
        }
        String[] strArrSplit = str.split("~", -1);
        List listAsList = Arrays.asList(strArrSplit[1].split("\\."));
        String strValueOf = String.valueOf(i3);
        boolean zContains = listAsList.contains(strValueOf);
        if (strArrSplit[0].equals(pnxuebdT.BvyAnLoOXViVlI)) {
            return Boolean.valueOf(zContains);
        }
        if (zContains) {
            return Boolean.TRUE;
        }
        if (Arrays.asList(strArrSplit[2].split("\\.")).contains(strValueOf)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : str.split("\\.")) {
            if (!c(str2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z\\d_-]*$");
    }

    public static boolean a(String str, int i3) {
        return str != null && i3 >= 0 && str.length() > i3 && str.charAt(i3) == '1';
    }

    public static boolean a(String str) {
        if (str != null && str.length() >= 2) {
            String[] strArrSplit = str.split("~", -1);
            if (strArrSplit.length == 2 && AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(strArrSplit[0])) {
                return Pattern.matches("(\\d+(\\.\\d+)*)?", strArrSplit[1]);
            }
            if (strArrSplit.length == 3 && "2".equals(strArrSplit[0]) && Pattern.matches("(\\d+(\\.\\d+)*)?", strArrSplit[1]) && strArrSplit[2].length() >= 3 && strArrSplit[2].startsWith("dv.") && Pattern.matches("(\\d+(\\.\\d+)*)?", strArrSplit[2].substring(3))) {
                return true;
            }
        }
        return false;
    }
}
