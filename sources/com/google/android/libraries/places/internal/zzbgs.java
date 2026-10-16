package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzbgs implements zzbdu {
    WIDGET_TYPE_UNSPECIFIED(0),
    PLACE_DETAILS(1),
    PLACE_LIST(2),
    PLACE_AUTOCOMPLETE(3),
    ELEVATION(4),
    INTERNAL_PLACE_DETAILS(5),
    UNRECOGNIZED(-1);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f76229a;

    zzbgs(int i3) {
        this.f76229a = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f76229a);
    }

    @Override // com.google.android.libraries.places.internal.zzbdu
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.f76229a;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
