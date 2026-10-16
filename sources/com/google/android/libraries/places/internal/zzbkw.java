package com.google.android.libraries.places.internal;

import com.google.common.io.BaseEncoding;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbkw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f76356a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BaseEncoding f76357b = zzbmg.f76400e;

    public static zzbmc a(String str, zzbkv zzbkvVar) {
        char cCharAt = str.charAt(0);
        int i3 = zzbmc.f76393e;
        return new zzbme(str, cCharAt == ':', zzbkvVar, null);
    }

    public static zzbmg b(byte[]... bArr) {
        return new zzbmg(bArr.length >> 1, bArr);
    }

    public static byte[][] c(zzbmg zzbmgVar) {
        return zzbmgVar.e();
    }

    public static int d(zzbmg zzbmgVar) {
        return zzbmgVar.a();
    }
}
