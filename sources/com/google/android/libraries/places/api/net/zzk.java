package com.google.android.libraries.places.api.net;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzk extends FindAutocompletePredictionsRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationBias f75490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocationRestriction f75491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LatLng f75492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f75493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AutocompleteSessionToken f75494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f75495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Integer f75496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f75497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f75498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final CancellationToken f75499k;

    /* synthetic */ zzk(String str, LocationBias locationBias, LocationRestriction locationRestriction, LatLng latLng, List list, AutocompleteSessionToken autocompleteSessionToken, List list2, Integer num, String str2, boolean z2, CancellationToken cancellationToken, byte[] bArr) {
        this.f75489a = str;
        this.f75490b = locationBias;
        this.f75491c = locationRestriction;
        this.f75492d = latLng;
        this.f75493e = list;
        this.f75494f = autocompleteSessionToken;
        this.f75495g = list2;
        this.f75496h = num;
        this.f75497i = str2;
        this.f75498j = z2;
        this.f75499k = cancellationToken;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest, com.google.android.libraries.places.internal.zzmq
    public CancellationToken a() {
        return this.f75499k;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public List c() {
        return this.f75493e;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public Integer d() {
        return this.f75496h;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public LocationBias e() {
        return this.f75490b;
    }

    public final boolean equals(Object obj) {
        AutocompleteSessionToken autocompleteSessionToken;
        Integer num;
        String str;
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindAutocompletePredictionsRequest) {
            FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = (FindAutocompletePredictionsRequest) obj;
            String str2 = this.f75489a;
            if (str2 != null ? str2.equals(findAutocompletePredictionsRequest.h()) : findAutocompletePredictionsRequest.h() == null) {
                LocationBias locationBias = this.f75490b;
                if (locationBias != null ? locationBias.equals(findAutocompletePredictionsRequest.e()) : findAutocompletePredictionsRequest.e() == null) {
                    LocationRestriction locationRestriction = this.f75491c;
                    if (locationRestriction != null ? locationRestriction.equals(findAutocompletePredictionsRequest.f()) : findAutocompletePredictionsRequest.f() == null) {
                        LatLng latLng = this.f75492d;
                        if (latLng != null ? latLng.equals(findAutocompletePredictionsRequest.g()) : findAutocompletePredictionsRequest.g() == null) {
                            if (this.f75493e.equals(findAutocompletePredictionsRequest.c()) && ((autocompleteSessionToken = this.f75494f) != null ? autocompleteSessionToken.equals(findAutocompletePredictionsRequest.j()) : findAutocompletePredictionsRequest.j() == null) && this.f75495g.equals(findAutocompletePredictionsRequest.k()) && ((num = this.f75496h) != null ? num.equals(findAutocompletePredictionsRequest.d()) : findAutocompletePredictionsRequest.d() == null) && ((str = this.f75497i) != null ? str.equals(findAutocompletePredictionsRequest.i()) : findAutocompletePredictionsRequest.i() == null) && this.f75498j == findAutocompletePredictionsRequest.l() && ((cancellationToken = this.f75499k) != null ? cancellationToken.equals(findAutocompletePredictionsRequest.a()) : findAutocompletePredictionsRequest.a() == null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public LocationRestriction f() {
        return this.f75491c;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public LatLng g() {
        return this.f75492d;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public String h() {
        return this.f75489a;
    }

    public final int hashCode() {
        String str = this.f75489a;
        int iHashCode = str == null ? 0 : str.hashCode();
        LocationBias locationBias = this.f75490b;
        int iHashCode2 = locationBias == null ? 0 : locationBias.hashCode();
        int i3 = iHashCode ^ 1000003;
        LocationRestriction locationRestriction = this.f75491c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (locationRestriction == null ? 0 : locationRestriction.hashCode())) * 1000003;
        LatLng latLng = this.f75492d;
        int iHashCode4 = (((iHashCode3 ^ (latLng == null ? 0 : latLng.hashCode())) * 1000003) ^ this.f75493e.hashCode()) * 1000003;
        AutocompleteSessionToken autocompleteSessionToken = this.f75494f;
        int iHashCode5 = (((iHashCode4 ^ (autocompleteSessionToken == null ? 0 : autocompleteSessionToken.hashCode())) * 1000003) ^ this.f75495g.hashCode()) * 1000003;
        Integer num = this.f75496h;
        int iHashCode6 = (iHashCode5 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str2 = this.f75497i;
        int iHashCode7 = (((iHashCode6 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ (true != this.f75498j ? 1237 : 1231)) * 1000003;
        CancellationToken cancellationToken = this.f75499k;
        return iHashCode7 ^ (cancellationToken != null ? cancellationToken.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public String i() {
        return this.f75497i;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public AutocompleteSessionToken j() {
        return this.f75494f;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public List k() {
        return this.f75495g;
    }

    @Override // com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest
    public boolean l() {
        return this.f75498j;
    }

    public final String toString() {
        CancellationToken cancellationToken = this.f75499k;
        List list = this.f75495g;
        AutocompleteSessionToken autocompleteSessionToken = this.f75494f;
        List list2 = this.f75493e;
        LatLng latLng = this.f75492d;
        LocationRestriction locationRestriction = this.f75491c;
        String strValueOf = String.valueOf(this.f75490b);
        String strValueOf2 = String.valueOf(locationRestriction);
        String strValueOf3 = String.valueOf(latLng);
        String string = list2.toString();
        String strValueOf4 = String.valueOf(autocompleteSessionToken);
        String string2 = list.toString();
        String strValueOf5 = String.valueOf(cancellationToken);
        String str = this.f75489a;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        int length3 = strValueOf2.length();
        int length4 = strValueOf3.length();
        int length5 = string.length();
        int length6 = strValueOf4.length();
        int length7 = string2.length();
        Integer num = this.f75496h;
        int length8 = String.valueOf(num).length();
        String str2 = this.f75497i;
        int length9 = String.valueOf(str2).length();
        boolean z2 = this.f75498j;
        StringBuilder sb = new StringBuilder(length + 56 + length2 + 22 + length3 + 9 + length4 + 12 + length5 + 15 + length6 + 14 + length7 + 14 + length8 + 13 + length9 + 36 + String.valueOf(z2).length() + 20 + strValueOf5.length() + 1);
        sb.append("FindAutocompletePredictionsRequest{query=");
        sb.append(str);
        sb.append(", locationBias=");
        sb.append(strValueOf);
        sb.append(", locationRestriction=");
        sb.append(strValueOf2);
        sb.append(", origin=");
        sb.append(strValueOf3);
        sb.append(", countries=");
        sb.append(string);
        sb.append(", sessionToken=");
        sb.append(strValueOf4);
        sb.append(", typesFilter=");
        sb.append(string2);
        sb.append(", inputOffset=");
        sb.append(num);
        sb.append(", regionCode=");
        sb.append(str2);
        sb.append(", pureServiceAreaBusinessesIncluded=");
        sb.append(z2);
        sb.append(", cancellationToken=");
        sb.append(strValueOf5);
        sb.append("}");
        return sb.toString();
    }
}
