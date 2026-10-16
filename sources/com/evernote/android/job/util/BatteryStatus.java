package com.evernote.android.job.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class BatteryStatus {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BatteryStatus f67958c = new BatteryStatus(false, 1.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f67959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f67960b;

    BatteryStatus(boolean z2, float f3) {
        this.f67959a = z2;
        this.f67960b = f3;
    }

    public boolean a() {
        return this.f67960b < 0.15f && !this.f67959a;
    }

    public boolean b() {
        return this.f67959a;
    }
}
