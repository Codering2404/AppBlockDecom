package com.google.android.libraries.places.internal;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzxg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Escaper f78793a = Escapers.a().b('\"', "&quot;").b('\'', "&#39;").b('&', "&amp;").b('<', "&lt;").b('>', "&gt;").c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f78794b = 0;

    static String a(String str) {
        return f78793a.a(str);
    }
}
