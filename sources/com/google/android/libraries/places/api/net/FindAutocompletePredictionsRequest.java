package com.google.android.libraries.places.api.net;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.internal.zzmq;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FindAutocompletePredictionsRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public FindAutocompletePredictionsRequest a() {
            e(ImmutableList.t(b()));
            n(ImmutableList.t(c()));
            return o();
        }

        public abstract List b();

        public abstract List c();

        public abstract Builder d(CancellationToken cancellationToken);

        public abstract Builder e(List list);

        public abstract Builder f(Integer num);

        public abstract Builder g(LocationBias locationBias);

        public abstract Builder h(LocationRestriction locationRestriction);

        public abstract Builder i(LatLng latLng);

        public abstract Builder j(boolean z2);

        public abstract Builder k(String str);

        public abstract Builder l(String str);

        public abstract Builder m(AutocompleteSessionToken autocompleteSessionToken);

        public abstract Builder n(List list);

        abstract FindAutocompletePredictionsRequest o();
    }

    public static Builder b() {
        zzj zzjVar = new zzj();
        zzjVar.e(new ArrayList());
        zzjVar.n(new ArrayList());
        zzjVar.j(false);
        return zzjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public abstract CancellationToken a();

    public abstract List c();

    public abstract Integer d();

    public abstract LocationBias e();

    public abstract LocationRestriction f();

    public abstract LatLng g();

    public abstract String h();

    public abstract String i();

    public abstract AutocompleteSessionToken j();

    public abstract List k();

    public abstract boolean l();
}
