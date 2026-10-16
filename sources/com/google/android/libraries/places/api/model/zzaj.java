package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.libraries.places.api.model.GoogleMapsLinks;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzaj extends GoogleMapsLinks.Builder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Uri f75064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Uri f75065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f75066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f75067d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Uri f75068e;

    zzaj() {
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks.Builder
    public final GoogleMapsLinks a() {
        return new zzdu(this.f75064a, this.f75065b, this.f75066c, this.f75067d, this.f75068e);
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks.Builder
    public final GoogleMapsLinks.Builder b(Uri uri) {
        this.f75064a = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks.Builder
    public final GoogleMapsLinks.Builder c(Uri uri) {
        this.f75068e = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks.Builder
    public final GoogleMapsLinks.Builder d(Uri uri) {
        this.f75065b = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks.Builder
    public final GoogleMapsLinks.Builder e(Uri uri) {
        this.f75067d = uri;
        return this;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks.Builder
    public final GoogleMapsLinks.Builder f(Uri uri) {
        this.f75066c = uri;
        return this;
    }
}
