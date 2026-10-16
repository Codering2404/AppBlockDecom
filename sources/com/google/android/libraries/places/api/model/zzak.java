package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzak extends GoogleMapsLinks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f75069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f75070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f75071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Uri f75072d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f75073f;

    zzak(Uri uri, Uri uri2, Uri uri3, Uri uri4, Uri uri5) {
        this.f75069a = uri;
        this.f75070b = uri2;
        this.f75071c = uri3;
        this.f75072d = uri4;
        this.f75073f = uri5;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks
    public final Uri d() {
        return this.f75069a;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks
    public final Uri e() {
        return this.f75073f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleMapsLinks) {
            GoogleMapsLinks googleMapsLinks = (GoogleMapsLinks) obj;
            Uri uri = this.f75069a;
            if (uri != null ? uri.equals(googleMapsLinks.d()) : googleMapsLinks.d() == null) {
                Uri uri2 = this.f75070b;
                if (uri2 != null ? uri2.equals(googleMapsLinks.f()) : googleMapsLinks.f() == null) {
                    Uri uri3 = this.f75071c;
                    if (uri3 != null ? uri3.equals(googleMapsLinks.h()) : googleMapsLinks.h() == null) {
                        Uri uri4 = this.f75072d;
                        if (uri4 != null ? uri4.equals(googleMapsLinks.g()) : googleMapsLinks.g() == null) {
                            Uri uri5 = this.f75073f;
                            if (uri5 != null ? uri5.equals(googleMapsLinks.e()) : googleMapsLinks.e() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks
    public final Uri f() {
        return this.f75070b;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks
    public final Uri g() {
        return this.f75072d;
    }

    @Override // com.google.android.libraries.places.api.model.GoogleMapsLinks
    public final Uri h() {
        return this.f75071c;
    }

    public final int hashCode() {
        Uri uri = this.f75069a;
        int iHashCode = uri == null ? 0 : uri.hashCode();
        Uri uri2 = this.f75070b;
        int iHashCode2 = uri2 == null ? 0 : uri2.hashCode();
        int i3 = iHashCode ^ 1000003;
        Uri uri3 = this.f75071c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (uri3 == null ? 0 : uri3.hashCode())) * 1000003;
        Uri uri4 = this.f75072d;
        int iHashCode4 = (iHashCode3 ^ (uri4 == null ? 0 : uri4.hashCode())) * 1000003;
        Uri uri5 = this.f75073f;
        return iHashCode4 ^ (uri5 != null ? uri5.hashCode() : 0);
    }

    public final String toString() {
        Uri uri = this.f75073f;
        Uri uri2 = this.f75072d;
        Uri uri3 = this.f75071c;
        Uri uri4 = this.f75070b;
        String strValueOf = String.valueOf(this.f75069a);
        String strValueOf2 = String.valueOf(uri4);
        String strValueOf3 = String.valueOf(uri3);
        String strValueOf4 = String.valueOf(uri2);
        String strValueOf5 = String.valueOf(uri);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int length3 = strValueOf3.length();
        StringBuilder sb = new StringBuilder(length + 41 + length2 + 18 + length3 + 13 + strValueOf4.length() + 12 + strValueOf5.length() + 1);
        sb.append(cJfnYMIyomoWf.HrsbamsVm);
        sb.append(strValueOf);
        sb.append(", placeUri=");
        sb.append(strValueOf2);
        sb.append(", writeAReviewUri=");
        sb.append(strValueOf3);
        sb.append(", reviewsUri=");
        sb.append(strValueOf4);
        sb.append(", photosUri=");
        sb.append(strValueOf5);
        sb.append("}");
        return sb.toString();
    }
}
