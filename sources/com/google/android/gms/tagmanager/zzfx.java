package com.google.android.gms.tagmanager;

import com.facebook.stetho.common.Utf8Charset;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfx {
    static String zza(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, Utf8Charset.NAME).replaceAll("\\+", "%20");
    }
}
