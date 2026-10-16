package com.google.android.libraries.places.api.net;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzj extends FindAutocompletePredictionsRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LocationBias f75478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LocationRestriction f75479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LatLng f75480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f75481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AutocompleteSessionToken f75482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f75483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f75484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f75485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f75486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CancellationToken f75487k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte f75488l;

    zzj() {
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final List b() {
        List list = this.f75481e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"countries\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final List c() {
        List list = this.f75483g;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"typesFilter\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder d(CancellationToken cancellationToken) {
        this.f75487k = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder e(List list) {
        if (list == null) {
            throw new NullPointerException("Null countries");
        }
        this.f75481e = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder f(Integer num) {
        this.f75484h = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder g(LocationBias locationBias) {
        this.f75478b = locationBias;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder h(LocationRestriction locationRestriction) {
        this.f75479c = locationRestriction;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder i(LatLng latLng) {
        this.f75480d = latLng;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder j(boolean z2) {
        this.f75486j = z2;
        this.f75488l = (byte) 1;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder k(String str) {
        this.f75477a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder l(String str) {
        this.f75485i = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder m(AutocompleteSessionToken autocompleteSessionToken) {
        this.f75482f = autocompleteSessionToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    public final FindAutocompletePredictionsRequest.Builder n(List list) {
        if (list == null) {
            throw new NullPointerException("Null typesFilter");
        }
        this.f75483g = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest.Builder
    final FindAutocompletePredictionsRequest o() {
        List list;
        List list2;
        if (this.f75488l == 1 && (list = this.f75481e) != null && (list2 = this.f75483g) != null) {
            return new zzk(this.f75477a, this.f75478b, this.f75479c, this.f75480d, list, this.f75482f, list2, this.f75484h, this.f75485i, this.f75486j, this.f75487k, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75481e == null) {
            sb.append(" countries");
        }
        if (this.f75483g == null) {
            sb.append(" typesFilter");
        }
        if (this.f75488l == 0) {
            sb.append(" pureServiceAreaBusinessesIncluded");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
