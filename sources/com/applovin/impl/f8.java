package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class f8 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59638a;

    public f8(int i3) {
        super(a(i3));
        this.f59638a = i3;
    }

    private static String a(int i3) {
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}
