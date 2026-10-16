package com.google.android.gms.ads;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class VersionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f69697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f69698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f69699c;

    public VersionInfo(int i3, int i4, int i5) {
        this.f69697a = i3;
        this.f69698b = i4;
        this.f69699c = i5;
    }

    public int a() {
        return this.f69697a;
    }

    public int b() {
        return this.f69699c;
    }

    public int c() {
        return this.f69698b;
    }

    public String toString() {
        return String.format(Locale.US, "%d.%d.%d", Integer.valueOf(this.f69697a), Integer.valueOf(this.f69698b), Integer.valueOf(this.f69699c));
    }
}
