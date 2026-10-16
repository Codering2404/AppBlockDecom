package com.google.android.libraries.places.api.model;

import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SpecialDay implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract SpecialDay a();

        public abstract Builder b(boolean z2);
    }

    public static Builder a(LocalDate localDate) {
        zzby zzbyVar = new zzby();
        zzbyVar.c(localDate);
        zzbyVar.b(false);
        return zzbyVar;
    }

    public abstract LocalDate c();

    public abstract boolean d();
}
