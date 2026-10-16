package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.NeighborhoodSummary;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzas extends NeighborhoodSummary.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ContentBlock f75094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ContentBlock f75095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f75096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f75097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f75098e;

    zzas() {
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary.Builder
    public final NeighborhoodSummary a() {
        return new zzee(this.f75094a, this.f75095b, this.f75096c, this.f75097d, this.f75098e);
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary.Builder
    public final NeighborhoodSummary.Builder b(ContentBlock contentBlock) {
        this.f75095b = contentBlock;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary.Builder
    public final NeighborhoodSummary.Builder c(String str) {
        this.f75097d = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary.Builder
    public final NeighborhoodSummary.Builder d(String str) {
        this.f75098e = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary.Builder
    public final NeighborhoodSummary.Builder e(Uri uri) {
        this.f75096c = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary.Builder
    public final NeighborhoodSummary.Builder f(ContentBlock contentBlock) {
        this.f75094a = contentBlock;
        return this;
    }
}
