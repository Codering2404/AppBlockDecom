package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.IsOpenRequest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzp extends IsOpenRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Place f75506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f75508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CancellationToken f75509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte f75510e;

    zzp() {
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenRequest.Builder
    public final IsOpenRequest.Builder b(CancellationToken cancellationToken) {
        this.f75509d = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenRequest.Builder
    public final IsOpenRequest.Builder c(long j3) {
        this.f75508c = j3;
        this.f75510e = (byte) 1;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenRequest.Builder
    final IsOpenRequest d() {
        if (this.f75510e == 1) {
            return new zzq(this.f75506a, this.f75507b, this.f75508c, this.f75509d, null);
        }
        throw new IllegalStateException("Missing required properties: utcTimeMillis");
    }

    public final IsOpenRequest.Builder e(Place place) {
        this.f75506a = place;
        return this;
    }

    public final IsOpenRequest.Builder f(String str) {
        this.f75507b = str;
        return this;
    }
}
