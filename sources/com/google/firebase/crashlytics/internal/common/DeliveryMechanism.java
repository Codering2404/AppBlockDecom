package com.google.firebase.crashlytics.internal.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f88424a;

    DeliveryMechanism(int i3) {
        this.f88424a = i3;
    }

    public static DeliveryMechanism b(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int c() {
        return this.f88424a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f88424a);
    }
}
