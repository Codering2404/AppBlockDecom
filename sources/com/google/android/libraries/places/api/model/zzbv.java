package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.RoutingSummary;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbv extends RoutingSummary.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f75309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f75310b;

    zzbv() {
    }

    @Override // com.google.android.libraries.places.api.model.RoutingSummary.Builder
    public final RoutingSummary a() {
        List list = this.f75309a;
        if (list != null) {
            return new zzfi(list, this.f75310b);
        }
        throw new IllegalStateException("Missing required properties: legs");
    }

    @Override // com.google.android.libraries.places.api.model.RoutingSummary.Builder
    public final List c() {
        List list = this.f75309a;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"legs\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.model.RoutingSummary.Builder
    public final RoutingSummary.Builder d(Uri uri) {
        this.f75310b = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.RoutingSummary.Builder
    public final RoutingSummary.Builder e(List list) {
        if (list == null) {
            throw new NullPointerException("Null legs");
        }
        this.f75309a = list;
        return this;
    }
}
