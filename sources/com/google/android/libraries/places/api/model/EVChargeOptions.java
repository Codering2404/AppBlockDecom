package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class EVChargeOptions implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract EVChargeOptions a();

        public abstract Builder b(List list);
    }

    public static EVChargeOptions e(Integer num, List list) {
        zzw zzwVar = new zzw();
        zzwVar.c(num);
        zzwVar.b(list);
        return zzwVar.a();
    }

    public abstract List c();

    public abstract Integer d();
}
