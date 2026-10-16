package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.internal.zzmq;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class FindCurrentPlaceRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static abstract class Builder {
        public FindCurrentPlaceRequest a() {
            c(ImmutableList.t(d().c()));
            return d();
        }

        public abstract Builder b(CancellationToken cancellationToken);

        abstract Builder c(List list);

        abstract FindCurrentPlaceRequest d();
    }

    public static Builder b(List list) {
        zzm zzmVar = new zzm();
        zzmVar.c(list);
        return zzmVar;
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public abstract CancellationToken a();

    public abstract List c();
}
