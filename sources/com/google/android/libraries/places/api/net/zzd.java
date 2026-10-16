package com.google.android.libraries.places.api.net;

import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzd extends FetchPlaceRequest.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f75458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AutocompleteSessionToken f75459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CancellationToken f75460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f75461e;

    zzd() {
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest.Builder
    public final FetchPlaceRequest.Builder b(CancellationToken cancellationToken) {
        this.f75460d = cancellationToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest.Builder
    public final FetchPlaceRequest.Builder c(AutocompleteSessionToken autocompleteSessionToken) {
        this.f75459c = autocompleteSessionToken;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest.Builder
    final FetchPlaceRequest.Builder d(List list) {
        if (list == null) {
            throw new NullPointerException("Null placeFields");
        }
        this.f75458b = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.FetchPlaceRequest.Builder
    final FetchPlaceRequest e() {
        List list;
        String str = this.f75457a;
        if (str != null && (list = this.f75458b) != null) {
            return new zze(str, list, this.f75459c, this.f75460d, this.f75461e, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75457a == null) {
            sb.append(" placeId");
        }
        if (this.f75458b == null) {
            sb.append(" placeFields");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    final FetchPlaceRequest.Builder f(String str) {
        if (str == null) {
            throw new NullPointerException("Null placeId");
        }
        this.f75457a = str;
        return this;
    }
}
