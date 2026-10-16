package com.applovin.impl;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class i5 extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f60348a;

    public i5(int i3) {
        this.f60348a = i3;
    }

    public static boolean a(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof i5) && ((i5) cause).f60348a == 2008) {
                return true;
            }
        }
        return false;
    }

    public i5(String str, int i3) {
        super(str);
        this.f60348a = i3;
    }

    public i5(String str, Throwable th, int i3) {
        super(str, th);
        this.f60348a = i3;
    }

    public i5(Throwable th, int i3) {
        super(th);
        this.f60348a = i3;
    }
}
