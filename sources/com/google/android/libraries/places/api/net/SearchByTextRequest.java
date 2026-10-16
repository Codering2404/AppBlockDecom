package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.EVSearchOptions;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RoutingParameters;
import com.google.android.libraries.places.api.model.SearchAlongRouteParameters;
import com.google.android.libraries.places.internal.zzmq;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SearchByTextRequest implements zzmq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public SearchByTextRequest a() {
            Double dValueOf = Double.valueOf(5.0d);
            Double dValueOf2 = Double.valueOf(1.0d);
            f(ImmutableList.t(c()));
            g(ImmutableList.t(d()));
            Double dB = b();
            if (dB != null) {
                Preconditions.p(dB.doubleValue() >= 1.0d && dB.doubleValue() <= 5.0d, "Min rating must not be out of range of %s to %s, but was: %s.", dValueOf2, dValueOf, dB);
            }
            List<Integer> listD = d();
            if (!listD.isEmpty()) {
                for (Integer num : listD) {
                    Preconditions.p(Range.f(0, 4).i(num), "Price level must not be out of range of %s to %s, but was: %s.", dValueOf2, dValueOf, num);
                }
            }
            return n();
        }

        public abstract Double b();

        public abstract List c();

        public abstract List d();

        public abstract Builder e(CancellationToken cancellationToken);

        public abstract Builder f(List list);

        public abstract Builder g(List list);

        public abstract Builder h(boolean z2);

        public abstract Builder i(boolean z2);

        public abstract Builder j(boolean z2);

        public abstract Builder k(boolean z2);

        public abstract Builder l(String str);

        public abstract Builder m(int i3);

        abstract SearchByTextRequest n();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum RankPreference {
        DISTANCE,
        RELEVANCE
    }

    public static Builder b(String str, List list) {
        zzs zzsVar = new zzs();
        zzsVar.o(false);
        zzsVar.f(list);
        zzsVar.g(new ArrayList());
        zzsVar.l(str);
        zzsVar.k(false);
        zzsVar.i(false);
        zzsVar.h(false);
        zzsVar.m(1);
        zzsVar.j(false);
        return zzsVar;
    }

    public abstract EVSearchOptions c();

    public abstract String d();

    public abstract LocationBias e();

    public abstract LocationRestriction f();

    public abstract Integer g();

    public abstract Double h();

    public abstract List i();

    public abstract List j();

    public abstract RankPreference k();

    public abstract String l();

    public abstract RoutingParameters m();

    public abstract SearchAlongRouteParameters n();

    public abstract String o();

    public abstract boolean p();

    public abstract boolean q();

    public abstract boolean r();

    public abstract boolean s();

    public abstract boolean t();

    public abstract String u();

    public abstract int v();

    public abstract Builder w();
}
