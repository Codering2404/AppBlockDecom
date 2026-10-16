package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.Review;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbn extends Review.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f75268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f75269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f75270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f75271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Double f75272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AuthorAttribution f75273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f75274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f75275i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Uri f75276j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private LocalDate f75277k;

    zzbn() {
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder b(Uri uri) {
        this.f75276j = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder c(String str) {
        this.f75270d = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder d(String str) {
        this.f75271e = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder e(String str) {
        this.f75275i = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder f(String str) {
        this.f75267a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder g(String str) {
        this.f75268b = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder h(String str) {
        this.f75269c = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    public final Review.Builder i(LocalDate localDate) {
        this.f75277k = localDate;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    final Review.Builder j(AuthorAttribution authorAttribution) {
        if (authorAttribution == null) {
            throw new NullPointerException("Null authorAttribution");
        }
        this.f75273g = authorAttribution;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    final Review.Builder k(String str) {
        this.f75274h = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.Review.Builder
    final Review l() {
        AuthorAttribution authorAttribution;
        String str;
        Double d3 = this.f75272f;
        if (d3 != null && (authorAttribution = this.f75273g) != null && (str = this.f75274h) != null) {
            return new zzfa(this.f75267a, this.f75268b, this.f75269c, this.f75270d, this.f75271e, d3, authorAttribution, str, this.f75275i, this.f75276j, this.f75277k);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75272f == null) {
            sb.append(" rating");
        }
        if (this.f75273g == null) {
            sb.append(" authorAttribution");
        }
        if (this.f75274h == null) {
            sb.append(" attribution");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    final Review.Builder m(Double d3) {
        if (d3 == null) {
            throw new NullPointerException("Null rating");
        }
        this.f75272f = d3;
        return this;
    }
}
