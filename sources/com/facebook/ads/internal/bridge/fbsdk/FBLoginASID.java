package com.facebook.ads.internal.bridge.fbsdk;

import com.facebook.AccessToken;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FBLoginASID {
    public static String getFBLoginASID() {
        try {
            AccessToken.Companion companion = AccessToken.Companion;
            Object objInvoke = AccessToken.class.getDeclaredMethod("getCurrentAccessToken", null).invoke(null, null);
            if (objInvoke != null) {
                return (String) AccessToken.class.getDeclaredMethod("getUserId", null).invoke(objInvoke, null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
