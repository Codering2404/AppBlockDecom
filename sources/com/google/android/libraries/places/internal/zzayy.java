package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzayy implements zzbdu {
    BUSINESS_STATUS_UNSPECIFIED(0),
    OPERATIONAL(1),
    CLOSED_TEMPORARILY(2),
    CLOSED_PERMANENTLY(3),
    FUTURE_OPENING(4),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75952a;

    zzayy(int i3) {
        this.f75952a = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f75952a);
    }

    @Override // com.google.android.libraries.places.internal.zzbdu
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.f75952a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
