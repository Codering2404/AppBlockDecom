package com.google.android.libraries.places.api.net;

import android.net.Uri;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzu extends SearchByTextResponse.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f75559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f75560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Pagination f75561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f75562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f75563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Uri f75564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte f75565g;

    zzu() {
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final SearchByTextResponse a() {
        List list;
        if (this.f75565g == 1 && (list = this.f75559a) != null) {
            return new zzv(list, this.f75560b, this.f75561c, this.f75562d, this.f75563e, this.f75564f, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f75559a == null) {
            sb.append(" places");
        }
        if (this.f75565g == 0) {
            sb.append(" responsePageIndex");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final List c() {
        List list = this.f75559a;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"places\" has not been set");
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final List d() {
        return this.f75560b;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final SearchByTextResponse.Builder e(Pagination pagination) {
        this.f75561c = pagination;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final SearchByTextResponse.Builder f(List list) {
        if (list == null) {
            throw new NullPointerException("Null places");
        }
        this.f75559a = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final SearchByTextResponse.Builder g(List list) {
        this.f75560b = list;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final SearchByTextResponse.Builder h(Uri uri) {
        this.f75564f = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final SearchByTextResponse.Builder i(String str) {
        this.f75562d = str;
        return this;
    }

    @Override // com.google.android.libraries.places.api.net.SearchByTextResponse.Builder
    public final SearchByTextResponse.Builder j(int i3) {
        this.f75563e = i3;
        this.f75565g = (byte) 1;
        return this;
    }
}
