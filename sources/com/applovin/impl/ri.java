package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ri {
    static int a(int i3, int i4, int i5) {
        return i3 | i4 | i5;
    }

    static int c(int i3) {
        return i3 & 32;
    }

    static int d(int i3) {
        return i3 & 7;
    }

    int a(e9 e9Var);

    int e();

    String getName();

    int m();

    static int a(int i3) {
        return a(i3, 0, 0);
    }
}
