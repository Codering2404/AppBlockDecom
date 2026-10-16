package com.google.android.libraries.places.api.net;

import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzy extends SearchNearbyResponse.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f75597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f75598b;

    zzy() {
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyResponse.Builder
    public final SearchNearbyResponse a() {
        List list = this.f75597a;
        if (list != null) {
            return new zzz(list, this.f75598b, null);
        }
        throw new IllegalStateException("Missing required properties: places");
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyResponse.Builder
    public final List c() {
        List list = this.f75597a;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"places\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyResponse.Builder
    public final List d() {
        return this.f75598b;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyResponse.Builder
    public final SearchNearbyResponse.Builder e(List list) {
        if (list == null) {
            throw new NullPointerException("Null places");
        }
        this.f75597a = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchNearbyResponse.Builder
    public final SearchNearbyResponse.Builder f(List list) {
        this.f75598b = list;
        return this;
    }
}
