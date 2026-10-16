package com.google.android.libraries.places.api.net;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzz extends SearchNearbyResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f75599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f75600b;

    /* synthetic */ zzz(List list, List list2, byte[] bArr) {
        this.f75599a = list;
        this.f75600b = list2;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyResponse
    public final List b() {
        return this.f75599a;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyResponse
    public final List c() {
        return this.f75600b;
    }

    public final boolean equals(Object obj) {
        List list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof SearchNearbyResponse) {
            SearchNearbyResponse searchNearbyResponse = (SearchNearbyResponse) obj;
            if (this.f75599a.equals(searchNearbyResponse.b()) && ((list = this.f75600b) != null ? list.equals(searchNearbyResponse.c()) : searchNearbyResponse.c() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f75599a.hashCode() ^ 1000003;
        List list = this.f75600b;
        return (iHashCode * 1000003) ^ (list == null ? 0 : list.hashCode());
    }

    public final String toString() {
        String string = this.f75599a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f75600b);
        StringBuilder sb = new StringBuilder(length + 47 + strValueOf.length() + 1);
        sb.append("SearchNearbyResponse{places=");
        sb.append(string);
        sb.append(", routingSummaries=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
