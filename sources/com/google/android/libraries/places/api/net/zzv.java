package com.google.android.libraries.places.api.net;

import android.net.Uri;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzv extends SearchByTextResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f75567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Pagination f75568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f75569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f75570e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f75571f;

    /* synthetic */ zzv(List list, List list2, Pagination pagination, String str, int i3, Uri uri, byte[] bArr) {
        this.f75566a = list;
        this.f75567b = list2;
        this.f75568c = pagination;
        this.f75569d = str;
        this.f75570e = i3;
        this.f75571f = uri;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse
    public Pagination b() {
        return this.f75568c;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse
    public List c() {
        return this.f75566a;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse
    public List d() {
        return this.f75567b;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse
    public Uri e() {
        return this.f75571f;
    }

    public final boolean equals(Object obj) {
        List list;
        Pagination pagination;
        String str;
        Uri uri;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchByTextResponse) {
            SearchByTextResponse searchByTextResponse = (SearchByTextResponse) obj;
            if (this.f75566a.equals(searchByTextResponse.c()) && ((list = this.f75567b) != null ? list.equals(searchByTextResponse.d()) : searchByTextResponse.d() == null) && ((pagination = this.f75568c) != null ? pagination.equals(searchByTextResponse.b()) : searchByTextResponse.b() == null) && ((str = this.f75569d) != null ? str.equals(searchByTextResponse.f()) : searchByTextResponse.f() == null) && this.f75570e == searchByTextResponse.g() && ((uri = this.f75571f) != null ? uri.equals(searchByTextResponse.e()) : searchByTextResponse.e() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse
    public final String f() {
        return this.f75569d;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse
    public final int g() {
        return this.f75570e;
    }

    public final int hashCode() {
        int iHashCode = this.f75566a.hashCode() ^ 1000003;
        List list = this.f75567b;
        int iHashCode2 = ((iHashCode * 1000003) ^ (list == null ? 0 : list.hashCode())) * 1000003;
        Pagination pagination = this.f75568c;
        int iHashCode3 = (iHashCode2 ^ (pagination == null ? 0 : pagination.hashCode())) * 1000003;
        String str = this.f75569d;
        int iHashCode4 = (((iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f75570e) * 1000003;
        Uri uri = this.f75571f;
        return iHashCode4 ^ (uri != null ? uri.hashCode() : 0);
    }

    public final String toString() {
        String string = this.f75566a.toString();
        int length = string.length();
        Uri uri = this.f75571f;
        Pagination pagination = this.f75568c;
        String strValueOf = String.valueOf(this.f75567b);
        String strValueOf2 = String.valueOf(pagination);
        String strValueOf3 = String.valueOf(uri);
        int length2 = strValueOf.length();
        int length3 = strValueOf2.length();
        String str = this.f75569d;
        int length4 = String.valueOf(str).length();
        int i3 = this.f75570e;
        StringBuilder sb = new StringBuilder(length + 47 + length2 + 13 + length3 + 16 + length4 + 20 + String.valueOf(i3).length() + 12 + strValueOf3.length() + 1);
        sb.append("SearchByTextResponse{places=");
        sb.append(string);
        sb.append(", routingSummaries=");
        sb.append(strValueOf);
        sb.append(", pagination=");
        sb.append(strValueOf2);
        sb.append(", nextPageToken=");
        sb.append(str);
        sb.append(", responsePageIndex=");
        sb.append(i3);
        sb.append(", searchUri=");
        sb.append(strValueOf3);
        sb.append("}");
        return sb.toString();
    }
}
