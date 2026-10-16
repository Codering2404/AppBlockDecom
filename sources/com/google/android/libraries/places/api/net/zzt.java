package com.google.android.libraries.places.api.net;

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
final class zzt extends SearchByTextRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CancellationToken f75538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocationBias f75540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LocationRestriction f75541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f75542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Double f75543f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f75544g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f75545h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f75546i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SearchByTextRequest.RankPreference f75547j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f75548k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f75549l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f75550m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final EVSearchOptions f75551n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final RoutingParameters f75552o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final SearchAlongRouteParameters f75553p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f75554q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f75555r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f75556s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f75557t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f75558u;

    /* synthetic */ zzt(CancellationToken cancellationToken, String str, LocationBias locationBias, LocationRestriction locationRestriction, Integer num, Double d3, boolean z2, List list, List list2, SearchByTextRequest.RankPreference rankPreference, String str2, boolean z3, String str3, EVSearchOptions eVSearchOptions, RoutingParameters routingParameters, SearchAlongRouteParameters searchAlongRouteParameters, boolean z4, boolean z5, boolean z6, String str4, int i3, byte[] bArr) {
        this.f75538a = cancellationToken;
        this.f75539b = str;
        this.f75540c = locationBias;
        this.f75541d = locationRestriction;
        this.f75542e = num;
        this.f75543f = d3;
        this.f75544g = z2;
        this.f75545h = list;
        this.f75546i = list2;
        this.f75547j = rankPreference;
        this.f75548k = str2;
        this.f75549l = z3;
        this.f75550m = str3;
        this.f75551n = eVSearchOptions;
        this.f75552o = routingParameters;
        this.f75553p = searchAlongRouteParameters;
        this.f75554q = z4;
        this.f75555r = z5;
        this.f75556s = z6;
        this.f75557t = str4;
        this.f75558u = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzmq
    public final CancellationToken a() {
        return this.f75538a;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public EVSearchOptions c() {
        return this.f75551n;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public String d() {
        return this.f75539b;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public LocationBias e() {
        return this.f75540c;
    }

    public final boolean equals(Object obj) {
        SearchByTextRequest.RankPreference rankPreference;
        String str;
        EVSearchOptions eVSearchOptions;
        RoutingParameters routingParameters;
        SearchAlongRouteParameters searchAlongRouteParameters;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchByTextRequest) {
            SearchByTextRequest searchByTextRequest = (SearchByTextRequest) obj;
            CancellationToken cancellationToken = this.f75538a;
            if (cancellationToken != null ? cancellationToken.equals(searchByTextRequest.a()) : searchByTextRequest.a() == null) {
                String str3 = this.f75539b;
                if (str3 != null ? str3.equals(searchByTextRequest.d()) : searchByTextRequest.d() == null) {
                    LocationBias locationBias = this.f75540c;
                    if (locationBias != null ? locationBias.equals(searchByTextRequest.e()) : searchByTextRequest.e() == null) {
                        LocationRestriction locationRestriction = this.f75541d;
                        if (locationRestriction != null ? locationRestriction.equals(searchByTextRequest.f()) : searchByTextRequest.f() == null) {
                            Integer num = this.f75542e;
                            if (num != null ? num.equals(searchByTextRequest.g()) : searchByTextRequest.g() == null) {
                                Double d3 = this.f75543f;
                                if (d3 != null ? d3.equals(searchByTextRequest.h()) : searchByTextRequest.h() == null) {
                                    if (this.f75544g == searchByTextRequest.p() && this.f75545h.equals(searchByTextRequest.i()) && this.f75546i.equals(searchByTextRequest.j()) && ((rankPreference = this.f75547j) != null ? rankPreference.equals(searchByTextRequest.k()) : searchByTextRequest.k() == null) && ((str = this.f75548k) != null ? str.equals(searchByTextRequest.l()) : searchByTextRequest.l() == null) && this.f75549l == searchByTextRequest.t() && this.f75550m.equals(searchByTextRequest.o()) && ((eVSearchOptions = this.f75551n) != null ? eVSearchOptions.equals(searchByTextRequest.c()) : searchByTextRequest.c() == null) && ((routingParameters = this.f75552o) != null ? routingParameters.equals(searchByTextRequest.m()) : searchByTextRequest.m() == null) && ((searchAlongRouteParameters = this.f75553p) != null ? searchAlongRouteParameters.equals(searchByTextRequest.n()) : searchByTextRequest.n() == null) && this.f75554q == searchByTextRequest.r() && this.f75555r == searchByTextRequest.q() && this.f75556s == searchByTextRequest.s() && ((str2 = this.f75557t) != null ? str2.equals(searchByTextRequest.u()) : searchByTextRequest.u() == null) && this.f75558u == searchByTextRequest.v()) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public LocationRestriction f() {
        return this.f75541d;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public Integer g() {
        return this.f75542e;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public Double h() {
        return this.f75543f;
    }

    public final int hashCode() {
        CancellationToken cancellationToken = this.f75538a;
        int iHashCode = cancellationToken == null ? 0 : cancellationToken.hashCode();
        String str = this.f75539b;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        int i3 = iHashCode ^ 1000003;
        LocationBias locationBias = this.f75540c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (locationBias == null ? 0 : locationBias.hashCode())) * 1000003;
        LocationRestriction locationRestriction = this.f75541d;
        int iHashCode4 = (iHashCode3 ^ (locationRestriction == null ? 0 : locationRestriction.hashCode())) * 1000003;
        Integer num = this.f75542e;
        int iHashCode5 = (iHashCode4 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        Double d3 = this.f75543f;
        int iHashCode6 = (((((((iHashCode5 ^ (d3 == null ? 0 : d3.hashCode())) * 1000003) ^ (true != this.f75544g ? 1237 : 1231)) * 1000003) ^ this.f75545h.hashCode()) * 1000003) ^ this.f75546i.hashCode()) * 1000003;
        SearchByTextRequest.RankPreference rankPreference = this.f75547j;
        int iHashCode7 = (iHashCode6 ^ (rankPreference == null ? 0 : rankPreference.hashCode())) * 1000003;
        String str2 = this.f75548k;
        int iHashCode8 = (((((iHashCode7 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ (true != this.f75549l ? 1237 : 1231)) * 1000003) ^ this.f75550m.hashCode()) * 1000003;
        EVSearchOptions eVSearchOptions = this.f75551n;
        int iHashCode9 = (iHashCode8 ^ (eVSearchOptions == null ? 0 : eVSearchOptions.hashCode())) * 1000003;
        RoutingParameters routingParameters = this.f75552o;
        int iHashCode10 = (iHashCode9 ^ (routingParameters == null ? 0 : routingParameters.hashCode())) * 1000003;
        SearchAlongRouteParameters searchAlongRouteParameters = this.f75553p;
        int iHashCode11 = (((((((iHashCode10 ^ (searchAlongRouteParameters == null ? 0 : searchAlongRouteParameters.hashCode())) * 1000003) ^ (true != this.f75554q ? 1237 : 1231)) * 1000003) ^ (true != this.f75555r ? 1237 : 1231)) * 1000003) ^ (true != this.f75556s ? 1237 : 1231)) * 1000003;
        String str3 = this.f75557t;
        return ((iHashCode11 ^ (str3 != null ? str3.hashCode() : 0)) * 1000003) ^ this.f75558u;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public List i() {
        return this.f75545h;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public List j() {
        return this.f75546i;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public SearchByTextRequest.RankPreference k() {
        return this.f75547j;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public String l() {
        return this.f75548k;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public RoutingParameters m() {
        return this.f75552o;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public SearchAlongRouteParameters n() {
        return this.f75553p;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public String o() {
        return this.f75550m;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public boolean p() {
        return this.f75544g;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public boolean q() {
        return this.f75555r;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public boolean r() {
        return this.f75554q;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public boolean s() {
        return this.f75556s;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public boolean t() {
        return this.f75549l;
    }

    public final String toString() {
        SearchAlongRouteParameters searchAlongRouteParameters = this.f75553p;
        RoutingParameters routingParameters = this.f75552o;
        EVSearchOptions eVSearchOptions = this.f75551n;
        SearchByTextRequest.RankPreference rankPreference = this.f75547j;
        List list = this.f75546i;
        List list2 = this.f75545h;
        LocationRestriction locationRestriction = this.f75541d;
        LocationBias locationBias = this.f75540c;
        String strValueOf = String.valueOf(this.f75538a);
        String strValueOf2 = String.valueOf(locationBias);
        String strValueOf3 = String.valueOf(locationRestriction);
        String string = list2.toString();
        String string2 = list.toString();
        String strValueOf4 = String.valueOf(rankPreference);
        String strValueOf5 = String.valueOf(eVSearchOptions);
        String strValueOf6 = String.valueOf(routingParameters);
        String strValueOf7 = String.valueOf(searchAlongRouteParameters);
        int length = strValueOf.length();
        String str = this.f75539b;
        int length2 = String.valueOf(str).length();
        int length3 = strValueOf2.length();
        int length4 = strValueOf3.length();
        Integer num = this.f75542e;
        int length5 = String.valueOf(num).length();
        Double d3 = this.f75543f;
        int length6 = String.valueOf(d3).length();
        boolean z2 = this.f75544g;
        int length7 = String.valueOf(z2).length();
        int length8 = string.length();
        int length9 = string2.length();
        int length10 = strValueOf4.length();
        String str2 = this.f75548k;
        int length11 = String.valueOf(str2).length();
        boolean z3 = this.f75549l;
        int length12 = String.valueOf(z3).length();
        int length13 = strValueOf5.length();
        int length14 = strValueOf6.length();
        String str3 = this.f75550m;
        int length15 = length + 53 + length2 + 15 + length3 + 22 + length4 + 17 + length5 + 12 + length6 + 10 + length7 + 14 + length8 + 14 + length9 + 17 + length10 + 13 + length11 + 22 + length12 + 12 + str3.length() + 18 + length13 + 20 + length14;
        boolean z4 = this.f75556s;
        boolean z5 = this.f75555r;
        boolean z6 = this.f75554q;
        int i3 = this.f75558u;
        String str4 = this.f75557t;
        int length16 = length15 + 29 + strValueOf7.length() + 27 + String.valueOf(z6).length();
        StringBuilder sb = new StringBuilder(length16 + 36 + String.valueOf(z5).length() + 20 + String.valueOf(z4).length() + 12 + String.valueOf(str4).length() + 19 + String.valueOf(i3).length() + 1);
        sb.append("SearchByTextRequest{cancellationToken=");
        sb.append(strValueOf);
        sb.append(", includedType=");
        sb.append(str);
        sb.append(", locationBias=");
        sb.append(strValueOf2);
        sb.append(", locationRestriction=");
        sb.append(strValueOf3);
        sb.append(", maxResultCount=");
        sb.append(num);
        sb.append(", minRating=");
        sb.append(d3);
        sb.append(", openNow=");
        sb.append(z2);
        sb.append(", placeFields=");
        sb.append(string);
        sb.append(", priceLevels=");
        sb.append(string2);
        sb.append(", rankPreference=");
        sb.append(strValueOf4);
        sb.append(", regionCode=");
        sb.append(str2);
        sb.append(", strictTypeFiltering=");
        sb.append(z3);
        sb.append(", textQuery=");
        sb.append(str3);
        sb.append(", evSearchOptions=");
        sb.append(strValueOf5);
        sb.append(", routingParameters=");
        sb.append(strValueOf6);
        sb.append(", searchAlongRouteParameters=");
        sb.append(strValueOf7);
        sb.append(", routingSummariesIncluded=");
        sb.append(z6);
        sb.append(", pureServiceAreaBusinessesIncluded=");
        sb.append(z5);
        sb.append(", searchUriIncluded=");
        sb.append(z4);
        sb.append(", pageToken=");
        sb.append(str4);
        sb.append(", requestPageIndex=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public final String u() {
        return this.f75557t;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public final int v() {
        return this.f75558u;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextRequest
    public final SearchByTextRequest.Builder w() {
        return new zzs(this);
    }
}
