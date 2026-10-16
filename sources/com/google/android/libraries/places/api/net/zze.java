package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zze extends FetchPlaceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f75463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AutocompleteSessionToken f75464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CancellationToken f75465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f75466e;

    /* synthetic */ zze(String str, List list, AutocompleteSessionToken autocompleteSessionToken, CancellationToken cancellationToken, String str2, byte[] bArr) {
        this.f75462a = str;
        this.f75463b = list;
        this.f75464c = autocompleteSessionToken;
        this.f75465d = cancellationToken;
        this.f75466e = str2;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest, com.google.android.libraries.places.internal.zzmq
    public final CancellationToken a() {
        return this.f75465d;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest
    public final List c() {
        return this.f75463b;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest
    public final String d() {
        return this.f75462a;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest
    public final String e() {
        return this.f75466e;
    }

    public final boolean equals(Object obj) {
        AutocompleteSessionToken autocompleteSessionToken;
        CancellationToken cancellationToken;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPlaceRequest) {
            FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) obj;
            if (this.f75462a.equals(fetchPlaceRequest.d()) && this.f75463b.equals(fetchPlaceRequest.c()) && ((autocompleteSessionToken = this.f75464c) != null ? autocompleteSessionToken.equals(fetchPlaceRequest.f()) : fetchPlaceRequest.f() == null) && ((cancellationToken = this.f75465d) != null ? cancellationToken.equals(fetchPlaceRequest.a()) : fetchPlaceRequest.a() == null) && ((str = this.f75466e) != null ? str.equals(fetchPlaceRequest.e()) : fetchPlaceRequest.e() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest
    public final AutocompleteSessionToken f() {
        return this.f75464c;
    }

    public final int hashCode() {
        int iHashCode = ((this.f75462a.hashCode() ^ 1000003) * 1000003) ^ this.f75463b.hashCode();
        AutocompleteSessionToken autocompleteSessionToken = this.f75464c;
        int iHashCode2 = ((iHashCode * 1000003) ^ (autocompleteSessionToken == null ? 0 : autocompleteSessionToken.hashCode())) * 1000003;
        CancellationToken cancellationToken = this.f75465d;
        int iHashCode3 = (iHashCode2 ^ (cancellationToken == null ? 0 : cancellationToken.hashCode())) * 1000003;
        String str = this.f75466e;
        return iHashCode3 ^ (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        String string = this.f75463b.toString();
        int length = string.length();
        CancellationToken cancellationToken = this.f75465d;
        String strValueOf = String.valueOf(this.f75464c);
        String strValueOf2 = String.valueOf(cancellationToken);
        int length2 = strValueOf.length();
        int length3 = strValueOf2.length();
        String str = this.f75466e;
        int length4 = String.valueOf(str).length();
        String str2 = this.f75462a;
        StringBuilder sb = new StringBuilder(str2.length() + 40 + length + 15 + length2 + 20 + length3 + 13 + length4 + 1);
        sb.append("FetchPlaceRequest{placeId=");
        sb.append(str2);
        sb.append(", placeFields=");
        sb.append(string);
        sb.append(", sessionToken=");
        sb.append(strValueOf);
        sb.append(", cancellationToken=");
        sb.append(strValueOf2);
        sb.append(", regionCode=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
