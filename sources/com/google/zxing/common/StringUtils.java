package com.google.zxing.common;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class StringUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f91819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f91820b;

    static {
        String strName = Charset.defaultCharset().name();
        f91819a = strName;
        f91820b = "SJIS".equalsIgnoreCase(strName) || "EUC_JP".equalsIgnoreCase(strName);
    }
}
