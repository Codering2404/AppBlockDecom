package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.EvChargeAmenitySummary;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzab extends EvChargeAmenitySummary.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ContentBlock f75032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ContentBlock f75033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentBlock f75034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ContentBlock f75035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Uri f75036e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f75037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f75038g;

    zzab() {
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary.Builder
    public final EvChargeAmenitySummary a() {
        ContentBlock contentBlock = this.f75032a;
        if (contentBlock != null) {
            return new zzdm(contentBlock, this.f75033b, this.f75034c, this.f75035d, this.f75036e, this.f75037f, this.f75038g);
        }
        throw new IllegalStateException("Missing required properties: overview");
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary.Builder
    public final EvChargeAmenitySummary.Builder b(ContentBlock contentBlock) {
        this.f75033b = contentBlock;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary.Builder
    public final EvChargeAmenitySummary.Builder c(String str) {
        this.f75037f = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary.Builder
    public final EvChargeAmenitySummary.Builder d(String str) {
        this.f75038g = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary.Builder
    public final EvChargeAmenitySummary.Builder e(Uri uri) {
        this.f75036e = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary.Builder
    public final EvChargeAmenitySummary.Builder f(ContentBlock contentBlock) {
        this.f75034c = contentBlock;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary.Builder
    public final EvChargeAmenitySummary.Builder g(ContentBlock contentBlock) {
        this.f75035d = contentBlock;
        return this;
    }

    final EvChargeAmenitySummary.Builder h(ContentBlock contentBlock) {
        if (contentBlock == null) {
            throw new NullPointerException("Null overview");
        }
        this.f75032a = contentBlock;
        return this;
    }
}
