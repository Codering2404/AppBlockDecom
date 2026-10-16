package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.AutocompletePrediction;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzi extends AutocompletePrediction.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f75350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Integer f75351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f75352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f75353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f75354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f75355f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f75356g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f75357h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f75358i;

    zzi() {
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder b(Integer num) {
        this.f75351b = num;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder c(String str) {
        if (str == null) {
            throw new NullPointerException("Null fullText");
        }
        this.f75353d = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder d(String str) {
        if (str == null) {
            throw new NullPointerException("Null primaryText");
        }
        this.f75354e = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder e(String str) {
        if (str == null) {
            throw new NullPointerException("Null secondaryText");
        }
        this.f75355f = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder f(List list) {
        if (list == null) {
            throw new NullPointerException("Null types");
        }
        this.f75352c = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    final AutocompletePrediction.Builder g(String str) {
        if (str == null) {
            throw new NullPointerException("Null placeId");
        }
        this.f75350a = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder h(List list) {
        if (list == null) {
            throw new NullPointerException("Null fullTextMatchedSubstrings");
        }
        this.f75356g = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder i(List list) {
        if (list == null) {
            throw new NullPointerException("Null primaryTextMatchedSubstrings");
        }
        this.f75357h = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    public final AutocompletePrediction.Builder j(List list) {
        if (list == null) {
            throw new NullPointerException("Null secondaryTextMatchedSubstrings");
        }
        this.f75358i = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.AutocompletePrediction.Builder
    final AutocompletePrediction k() {
        List list;
        String str;
        String str2;
        String str3;
        List list2;
        List list3;
        List list4;
        String str4 = this.f75350a;
        if (str4 != null && (list = this.f75352c) != null && (str = this.f75353d) != null && (str2 = this.f75354e) != null && (str3 = this.f75355f) != null && (list2 = this.f75356g) != null && (list3 = this.f75357h) != null && (list4 = this.f75358i) != null) {
            return new zzcq(str4, this.f75351b, list, str, str2, str3, list2, list3, list4);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75350a == null) {
            sb.append(" placeId");
        }
        if (this.f75352c == null) {
            sb.append(" types");
        }
        if (this.f75353d == null) {
            sb.append(" fullText");
        }
        if (this.f75354e == null) {
            sb.append(" primaryText");
        }
        if (this.f75355f == null) {
            sb.append(" secondaryText");
        }
        if (this.f75356g == null) {
            sb.append(" fullTextMatchedSubstrings");
        }
        if (this.f75357h == null) {
            sb.append(" primaryTextMatchedSubstrings");
        }
        if (this.f75358i == null) {
            sb.append(" secondaryTextMatchedSubstrings");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
