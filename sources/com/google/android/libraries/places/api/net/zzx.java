package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RoutingParameters;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzx extends SearchNearbyRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f75586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f75587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f75588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f75589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f75590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LocationRestriction f75591g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f75592h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CancellationToken f75593i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SearchNearbyRequest.RankPreference f75594j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final RoutingParameters f75595k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f75596l;

    /* synthetic */ zzx(String str, List list, List list2, List list3, List list4, Integer num, LocationRestriction locationRestriction, List list5, CancellationToken cancellationToken, SearchNearbyRequest.RankPreference rankPreference, RoutingParameters routingParameters, boolean z2, byte[] bArr) {
        this.f75585a = str;
        this.f75586b = list;
        this.f75587c = list2;
        this.f75588d = list3;
        this.f75589e = list4;
        this.f75590f = num;
        this.f75591g = locationRestriction;
        this.f75592h = list5;
        this.f75593i = cancellationToken;
        this.f75594j = rankPreference;
        this.f75595k = routingParameters;
        this.f75596l = z2;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest, com.google.android.libraries.places.internal.zzmq
    public CancellationToken a() {
        return this.f75593i;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public List c() {
        return this.f75589e;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public List d() {
        return this.f75587c;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public List e() {
        return this.f75588d;
    }

    public final boolean equals(Object obj) {
        CancellationToken cancellationToken;
        SearchNearbyRequest.RankPreference rankPreference;
        RoutingParameters routingParameters;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchNearbyRequest) {
            SearchNearbyRequest searchNearbyRequest = (SearchNearbyRequest) obj;
            String str = this.f75585a;
            if (str != null ? str.equals(searchNearbyRequest.k()) : searchNearbyRequest.k() == null) {
                List list = this.f75586b;
                if (list != null ? list.equals(searchNearbyRequest.f()) : searchNearbyRequest.f() == null) {
                    List list2 = this.f75587c;
                    if (list2 != null ? list2.equals(searchNearbyRequest.d()) : searchNearbyRequest.d() == null) {
                        List list3 = this.f75588d;
                        if (list3 != null ? list3.equals(searchNearbyRequest.e()) : searchNearbyRequest.e() == null) {
                            List list4 = this.f75589e;
                            if (list4 != null ? list4.equals(searchNearbyRequest.c()) : searchNearbyRequest.c() == null) {
                                Integer num = this.f75590f;
                                if (num != null ? num.equals(searchNearbyRequest.h()) : searchNearbyRequest.h() == null) {
                                    if (this.f75591g.equals(searchNearbyRequest.g()) && this.f75592h.equals(searchNearbyRequest.i()) && ((cancellationToken = this.f75593i) != null ? cancellationToken.equals(searchNearbyRequest.a()) : searchNearbyRequest.a() == null) && ((rankPreference = this.f75594j) != null ? rankPreference.equals(searchNearbyRequest.j()) : searchNearbyRequest.j() == null) && ((routingParameters = this.f75595k) != null ? routingParameters.equals(searchNearbyRequest.l()) : searchNearbyRequest.l() == null) && this.f75596l == searchNearbyRequest.m()) {
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

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public List f() {
        return this.f75586b;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public LocationRestriction g() {
        return this.f75591g;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public Integer h() {
        return this.f75590f;
    }

    public final int hashCode() {
        String str = this.f75585a;
        int iHashCode = str == null ? 0 : str.hashCode();
        List list = this.f75586b;
        int iHashCode2 = list == null ? 0 : list.hashCode();
        int i3 = iHashCode ^ 1000003;
        List list2 = this.f75587c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        List list3 = this.f75588d;
        int iHashCode4 = (iHashCode3 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
        List list4 = this.f75589e;
        int iHashCode5 = (iHashCode4 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
        Integer num = this.f75590f;
        int iHashCode6 = (((((iHashCode5 ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f75591g.hashCode()) * 1000003) ^ this.f75592h.hashCode()) * 1000003;
        CancellationToken cancellationToken = this.f75593i;
        int iHashCode7 = (iHashCode6 ^ (cancellationToken == null ? 0 : cancellationToken.hashCode())) * 1000003;
        SearchNearbyRequest.RankPreference rankPreference = this.f75594j;
        int iHashCode8 = (iHashCode7 ^ (rankPreference == null ? 0 : rankPreference.hashCode())) * 1000003;
        RoutingParameters routingParameters = this.f75595k;
        return ((iHashCode8 ^ (routingParameters != null ? routingParameters.hashCode() : 0)) * 1000003) ^ (true != this.f75596l ? 1237 : 1231);
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public List i() {
        return this.f75592h;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public SearchNearbyRequest.RankPreference j() {
        return this.f75594j;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public String k() {
        return this.f75585a;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public RoutingParameters l() {
        return this.f75595k;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyRequest
    public boolean m() {
        return this.f75596l;
    }

    public final String toString() {
        RoutingParameters routingParameters = this.f75595k;
        SearchNearbyRequest.RankPreference rankPreference = this.f75594j;
        CancellationToken cancellationToken = this.f75593i;
        List list = this.f75592h;
        LocationRestriction locationRestriction = this.f75591g;
        List list2 = this.f75589e;
        List list3 = this.f75588d;
        List list4 = this.f75587c;
        String strValueOf = String.valueOf(this.f75586b);
        String strValueOf2 = String.valueOf(list4);
        String strValueOf3 = String.valueOf(list3);
        String strValueOf4 = String.valueOf(list2);
        String string = locationRestriction.toString();
        String string2 = list.toString();
        String strValueOf5 = String.valueOf(cancellationToken);
        String strValueOf6 = String.valueOf(rankPreference);
        String strValueOf7 = String.valueOf(routingParameters);
        String str = this.f75585a;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        int length3 = strValueOf2.length();
        int length4 = strValueOf3.length();
        int length5 = strValueOf4.length();
        Integer num = this.f75590f;
        int length6 = String.valueOf(num).length();
        int length7 = string.length();
        int length8 = string2.length();
        int length9 = strValueOf5.length();
        int length10 = strValueOf6.length();
        int length11 = strValueOf7.length();
        boolean z2 = this.f75596l;
        StringBuilder sb = new StringBuilder(length + 47 + length2 + 16 + length3 + 23 + length4 + 23 + length5 + 17 + length6 + 22 + length7 + 14 + length8 + 20 + length9 + 17 + length10 + 20 + length11 + 27 + String.valueOf(z2).length() + 1);
        sb.append("SearchNearbyRequest{regionCode=");
        sb.append(str);
        sb.append(", includedTypes=");
        sb.append(strValueOf);
        sb.append(", excludedTypes=");
        sb.append(strValueOf2);
        sb.append(", includedPrimaryTypes=");
        sb.append(strValueOf3);
        sb.append(", excludedPrimaryTypes=");
        sb.append(strValueOf4);
        sb.append(", maxResultCount=");
        sb.append(num);
        sb.append(", locationRestriction=");
        sb.append(string);
        sb.append(", placeFields=");
        sb.append(string2);
        sb.append(", cancellationToken=");
        sb.append(strValueOf5);
        sb.append(", rankPreference=");
        sb.append(strValueOf6);
        sb.append(", routingParameters=");
        sb.append(strValueOf7);
        sb.append(", routingSummariesIncluded=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}
