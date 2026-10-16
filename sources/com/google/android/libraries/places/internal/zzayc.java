package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzayc implements zzbdu {
    FUEL_TYPE_UNSPECIFIED(0),
    DIESEL(1),
    DIESEL_PLUS(19),
    REGULAR_UNLEADED(2),
    MIDGRADE(3),
    PREMIUM(4),
    SP91(5),
    SP91_E10(6),
    SP92(7),
    SP95(8),
    SP95_E10(9),
    SP98(10),
    SP99(11),
    SP100(12),
    LPG(13),
    E80(14),
    E85(15),
    E100(20),
    METHANE(16),
    BIO_DIESEL(17),
    TRUCK_DIESEL(18),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75944a;

    zzayc(int i3) {
        this.f75944a = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f75944a);
    }

    @Override // com.google.android.libraries.places.internal.zzbdu
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.f75944a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
