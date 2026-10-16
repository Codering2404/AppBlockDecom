package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RoutingParameters;
import com.google.android.libraries.places.internal.zzmq;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SearchNearbyRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public SearchNearbyRequest a() {
            List listG = g();
            boolean z2 = f() instanceof CircularBounds;
            List listE = e();
            List listC = c();
            List listD = d();
            List listB = b();
            Preconditions.e(z2, "LocationRestriction must be of type CircularBounds.");
            m(ImmutableList.t(listG));
            if (listE != null) {
                l(ImmutableList.t(listE));
            }
            if (listC != null) {
                j(ImmutableList.t(listC));
            }
            if (listD != null) {
                k(ImmutableList.t(listD));
            }
            if (listB != null) {
                i(ImmutableList.t(listB));
            }
            return o();
        }

        public abstract List b();

        public abstract List c();

        public abstract List d();

        public abstract List e();

        public abstract LocationRestriction f();

        public abstract List g();

        public abstract Builder h(CancellationToken cancellationToken);

        public abstract Builder i(List list);

        public abstract Builder j(List list);

        public abstract Builder k(List list);

        public abstract Builder l(List list);

        public abstract Builder m(List list);

        public abstract Builder n(boolean z2);

        abstract SearchNearbyRequest o();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum RankPreference {
        DISTANCE,
        POPULARITY
    }

    public static Builder b(LocationRestriction locationRestriction, List list) {
        zzw zzwVar = new zzw();
        zzwVar.p(locationRestriction);
        zzwVar.m(list);
        zzwVar.n(false);
        return zzwVar;
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public abstract CancellationToken a();

    public abstract List c();

    public abstract List d();

    public abstract List e();

    public abstract List f();

    public abstract LocationRestriction g();

    public abstract Integer h();

    public abstract List i();

    public abstract RankPreference j();

    public abstract String k();

    public abstract RoutingParameters l();

    public abstract boolean m();
}
