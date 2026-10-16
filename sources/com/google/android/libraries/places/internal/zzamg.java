package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzamg implements zzbdu {
    CONTENT_UNDEFINED(0),
    PHOTO(1),
    ADDRESS(2),
    RATING(3),
    TYPE(4),
    PRICE(5),
    ACCESSIBILITY(6),
    MAPS_LINK(7),
    DIRECTIONS_LINK(8),
    OPEN_NOW_STATUS(9),
    SUMMARY(10),
    OPENING_HOURS(11),
    WEBSITE(12),
    PHONE_NUMBER(13),
    TYPE_SPECIFIC_HIGHLIGHTS(14),
    REVIEWS(15),
    PLUS_CODE(16),
    FEATURES(17),
    GENERATIVE_SUMMARY(18);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75702a;

    zzamg(int i3) {
        this.f75702a = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f75702a);
    }

    @Override // com.google.android.libraries.places.internal.zzbdu
    public final int zza() {
        return this.f75702a;
    }
}
