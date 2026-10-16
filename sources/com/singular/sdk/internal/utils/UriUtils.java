package com.singular.sdk.internal.utils;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class UriUtils {
    public static boolean a(Uri uri) {
        return uri != null && uri.isHierarchical() && uri.isAbsolute();
    }
}
