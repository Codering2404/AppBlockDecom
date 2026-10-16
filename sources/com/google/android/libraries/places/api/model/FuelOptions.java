package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FuelOptions implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public FuelOptions a() {
            c(ImmutableList.t(b()));
            return d();
        }

        public abstract List b();

        public abstract Builder c(List list);

        abstract FuelOptions d();
    }

    public static FuelOptions d(List list) {
        zzad zzadVar = new zzad();
        zzadVar.c(list);
        return zzadVar.a();
    }

    public abstract List c();
}
