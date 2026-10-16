package com.squareup.okhttp;

import com.revenuecat.purchases.common.Constants;
import java.io.UnsupportedEncodingException;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Credentials {
    public static String a(String str, String str2) {
        try {
            return "Basic " + ByteString.v((str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2).getBytes("ISO-8859-1")).a();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
