package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.internal.zzmq;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FetchPlaceRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public FetchPlaceRequest a() {
            d(ImmutableList.t(e().c()));
            return e();
        }

        public abstract Builder b(CancellationToken cancellationToken);

        public abstract Builder c(AutocompleteSessionToken autocompleteSessionToken);

        abstract Builder d(List list);

        abstract FetchPlaceRequest e();
    }

    public static Builder b(String str, List list) {
        zzd zzdVar = new zzd();
        zzdVar.f(str);
        zzdVar.d(list);
        return zzdVar;
    }

    public static FetchPlaceRequest g(String str, List list) {
        return b(str, list).a();
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public abstract CancellationToken a();

    public abstract List c();

    public abstract String d();

    public abstract String e();

    public abstract AutocompleteSessionToken f();
}
