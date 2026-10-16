package com.facebook.stetho.common;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Utf8Charset {
    public static final String NAME = "UTF-8";
    public static final Charset INSTANCE = Charset.forName(NAME);

    public static String decodeUTF8(byte[] bArr) {
        return new String(bArr, INSTANCE);
    }

    public static byte[] encodeUTF8(String str) {
        try {
            return str.getBytes(NAME);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }
}
