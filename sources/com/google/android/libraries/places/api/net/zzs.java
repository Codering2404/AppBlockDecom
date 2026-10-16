package com.google.android.libraries.places.api.net;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.EVSearchOptions;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RoutingParameters;
import com.google.android.libraries.places.api.model.SearchAlongRouteParameters;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzs extends SearchByTextRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CancellationToken f75516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LocationBias f75518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LocationRestriction f75519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Integer f75520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Double f75521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f75522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f75523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f75524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SearchByTextRequest.RankPreference f75525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f75526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f75527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f75528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private EVSearchOptions f75529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private RoutingParameters f75530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private SearchAlongRouteParameters f75531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f75532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f75533r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f75534s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f75535t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f75536u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private byte f75537v;

    zzs() {
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final Double b() {
        return this.f75521f;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final List c() {
        List list = this.f75523h;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"placeFields\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final List d() {
        List list = this.f75524i;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"priceLevels\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder e(CancellationToken cancellationToken) {
        this.f75516a = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder f(List list) {
        if (list == null) {
            throw new NullPointerException("Null placeFields");
        }
        this.f75523h = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder g(List list) {
        if (list == null) {
            throw new NullPointerException("Null priceLevels");
        }
        this.f75524i = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder h(boolean z2) {
        this.f75533r = z2;
        this.f75537v = (byte) (this.f75537v | 8);
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder i(boolean z2) {
        this.f75532q = z2;
        this.f75537v = (byte) (this.f75537v | 4);
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder j(boolean z2) {
        this.f75534s = z2;
        this.f75537v = (byte) (this.f75537v | Ascii.DLE);
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder k(boolean z2) {
        this.f75527l = z2;
        this.f75537v = (byte) (this.f75537v | 2);
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder l(String str) {
        if (str == null) {
            throw new NullPointerException("Null textQuery");
        }
        this.f75528m = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    public final SearchByTextRequest.Builder m(int i3) {
        this.f75536u = i3;
        this.f75537v = (byte) (this.f75537v | 32);
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest.Builder
    final SearchByTextRequest n() {
        List list;
        List list2;
        String str;
        if (this.f75537v == 63 && (list = this.f75523h) != null && (list2 = this.f75524i) != null && (str = this.f75528m) != null) {
            return new zzt(this.f75516a, this.f75517b, this.f75518c, this.f75519d, this.f75520e, this.f75521f, this.f75522g, list, list2, this.f75525j, this.f75526k, this.f75527l, str, this.f75529n, this.f75530o, this.f75531p, this.f75532q, this.f75533r, this.f75534s, this.f75535t, this.f75536u, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f75537v & 1) == 0) {
            sb.append(" openNow");
        }
        if (this.f75523h == null) {
            sb.append(" placeFields");
        }
        if (this.f75524i == null) {
            sb.append(" priceLevels");
        }
        if ((this.f75537v & 2) == 0) {
            sb.append(" strictTypeFiltering");
        }
        if (this.f75528m == null) {
            sb.append(" textQuery");
        }
        if ((this.f75537v & 4) == 0) {
            sb.append(" routingSummariesIncluded");
        }
        if ((this.f75537v & 8) == 0) {
            sb.append(" pureServiceAreaBusinessesIncluded");
        }
        if ((this.f75537v & Ascii.DLE) == 0) {
            sb.append(" searchUriIncluded");
        }
        if ((this.f75537v & 32) == 0) {
            sb.append(" requestPageIndex");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final SearchByTextRequest.Builder o(boolean z2) {
        this.f75522g = z2;
        this.f75537v = (byte) (this.f75537v | 1);
        return this;
    }

    zzs(SearchByTextRequest searchByTextRequest) {
        this.f75516a = searchByTextRequest.a();
        this.f75517b = searchByTextRequest.d();
        this.f75518c = searchByTextRequest.e();
        this.f75519d = searchByTextRequest.f();
        this.f75520e = searchByTextRequest.g();
        this.f75521f = searchByTextRequest.h();
        this.f75522g = searchByTextRequest.p();
        this.f75523h = searchByTextRequest.i();
        this.f75524i = searchByTextRequest.j();
        this.f75525j = searchByTextRequest.k();
        this.f75526k = searchByTextRequest.l();
        this.f75527l = searchByTextRequest.t();
        this.f75528m = searchByTextRequest.o();
        this.f75529n = searchByTextRequest.c();
        this.f75530o = searchByTextRequest.m();
        this.f75531p = searchByTextRequest.n();
        this.f75532q = searchByTextRequest.r();
        this.f75533r = searchByTextRequest.q();
        this.f75534s = searchByTextRequest.s();
        this.f75535t = searchByTextRequest.u();
        this.f75536u = searchByTextRequest.v();
        this.f75537v = (byte) 63;
    }
}
