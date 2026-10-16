package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RoutingParameters;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzw extends SearchNearbyRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f75573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f75574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List f75575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f75576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f75577f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LocationRestriction f75578g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f75579h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CancellationToken f75580i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SearchNearbyRequest.RankPreference f75581j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RoutingParameters f75582k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f75583l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte f75584m;

    zzw() {
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final List b() {
        return this.f75576e;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final List c() {
        return this.f75574c;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final List d() {
        return this.f75575d;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final List e() {
        return this.f75573b;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final LocationRestriction f() {
        LocationRestriction locationRestriction = this.f75578g;
        if (locationRestriction != null) {
            return locationRestriction;
        }
        throw new IllegalStateException("Property \"locationRestriction\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final List g() {
        List list = this.f75579h;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"placeFields\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final SearchNearbyRequest.Builder h(CancellationToken cancellationToken) {
        this.f75580i = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final SearchNearbyRequest.Builder i(List list) {
        this.f75576e = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final SearchNearbyRequest.Builder j(List list) {
        this.f75574c = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final SearchNearbyRequest.Builder k(List list) {
        this.f75575d = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final SearchNearbyRequest.Builder l(List list) {
        this.f75573b = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final SearchNearbyRequest.Builder m(List list) {
        if (list == null) {
            throw new NullPointerException("Null placeFields");
        }
        this.f75579h = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    public final SearchNearbyRequest.Builder n(boolean z2) {
        this.f75583l = z2;
        this.f75584m = (byte) 1;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest.Builder
    final SearchNearbyRequest o() {
        LocationRestriction locationRestriction;
        List list;
        if (this.f75584m == 1 && (locationRestriction = this.f75578g) != null && (list = this.f75579h) != null) {
            return new zzx(this.f75572a, this.f75573b, this.f75574c, this.f75575d, this.f75576e, this.f75577f, locationRestriction, list, this.f75580i, this.f75581j, this.f75582k, this.f75583l, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75578g == null) {
            sb.append(" locationRestriction");
        }
        if (this.f75579h == null) {
            sb.append(" placeFields");
        }
        if (this.f75584m == 0) {
            sb.append(" routingSummariesIncluded");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final SearchNearbyRequest.Builder p(LocationRestriction locationRestriction) {
        if (locationRestriction == null) {
            throw new NullPointerException("Null locationRestriction");
        }
        this.f75578g = locationRestriction;
        return this;
    }
}
