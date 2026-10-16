package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzmq;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class IsOpenRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public IsOpenRequest a() {
            IsOpenRequest isOpenRequestD = d();
            Place placeF = isOpenRequestD.f();
            if (placeF != null) {
                Preconditions.e(placeF.G() != null, "Place must have a valid place id.");
            }
            return isOpenRequestD;
        }

        public abstract Builder b(CancellationToken cancellationToken);

        public abstract Builder c(long j3);

        abstract IsOpenRequest d();
    }

    public static Builder b(Place place) {
        zzp zzpVar = new zzp();
        zzpVar.e(place);
        zzpVar.c(System.currentTimeMillis());
        return zzpVar;
    }

    public static Builder c(Place place, long j3) {
        zzp zzpVar = new zzp();
        zzpVar.e(place);
        zzpVar.c(j3);
        return zzpVar;
    }

    public static Builder d(String str) {
        zzp zzpVar = new zzp();
        zzpVar.f(str);
        zzpVar.c(System.currentTimeMillis());
        return zzpVar;
    }

    public static Builder e(String str, long j3) {
        zzp zzpVar = new zzp();
        zzpVar.f(str);
        zzpVar.c(j3);
        return zzpVar;
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public abstract CancellationToken a();

    public abstract Place f();

    public abstract String g();

    public abstract long h();
}
