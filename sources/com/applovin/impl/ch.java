package com.applovin.impl;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ch extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f58906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f58907b;

    protected ch(String str, Throwable th, boolean z2, int i3) {
        super(str, th);
        this.f58906a = z2;
        this.f58907b = i3;
    }

    public static ch a(String str, Throwable th) {
        return new ch(str, th, true, 1);
    }

    public static ch b(String str, Throwable th) {
        return new ch(str, th, true, 0);
    }

    public static ch a(String str) {
        return new ch(str, null, false, 1);
    }
}
