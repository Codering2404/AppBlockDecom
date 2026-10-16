package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzm extends FindCurrentPlaceRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f75501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CancellationToken f75502b;

    zzm() {
    }

    @Override // com.google.android.libraries.places.api.net.FindCurrentPlaceRequest.Builder
    public final FindCurrentPlaceRequest.Builder b(CancellationToken cancellationToken) {
        this.f75502b = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindCurrentPlaceRequest.Builder
    final FindCurrentPlaceRequest.Builder c(List list) {
        if (list == null) {
            throw new NullPointerException("Null placeFields");
        }
        this.f75501a = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FindCurrentPlaceRequest.Builder
    final FindCurrentPlaceRequest d() {
        List list = this.f75501a;
        if (list != null) {
            return new zzn(list, this.f75502b, null);
        }
        throw new IllegalStateException("Missing required properties: placeFields");
    }
}
