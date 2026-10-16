package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbq extends ReviewSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f75297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f75298d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f75299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Uri f75300g;

    zzbq(String str, String str2, Uri uri, String str3, String str4, Uri uri2) {
        this.f75295a = str;
        this.f75296b = str2;
        this.f75297c = uri;
        this.f75298d = str3;
        this.f75299f = str4;
        this.f75300g = uri2;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary
    public final String d() {
        return this.f75298d;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary
    public final String e() {
        return this.f75299f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReviewSummary) {
            ReviewSummary reviewSummary = (ReviewSummary) obj;
            String str = this.f75295a;
            if (str != null ? str.equals(reviewSummary.h()) : reviewSummary.h() == null) {
                String str2 = this.f75296b;
                if (str2 != null ? str2.equals(reviewSummary.i()) : reviewSummary.i() == null) {
                    Uri uri = this.f75297c;
                    if (uri != null ? uri.equals(reviewSummary.f()) : reviewSummary.f() == null) {
                        String str3 = this.f75298d;
                        if (str3 != null ? str3.equals(reviewSummary.d()) : reviewSummary.d() == null) {
                            String str4 = this.f75299f;
                            if (str4 != null ? str4.equals(reviewSummary.e()) : reviewSummary.e() == null) {
                                Uri uri2 = this.f75300g;
                                if (uri2 != null ? uri2.equals(reviewSummary.g()) : reviewSummary.g() == null) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary
    public final Uri f() {
        return this.f75297c;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary
    public final Uri g() {
        return this.f75300g;
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary
    public final String h() {
        return this.f75295a;
    }

    public final int hashCode() {
        String str = this.f75295a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f75296b;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        int i3 = iHashCode ^ 1000003;
        Uri uri = this.f75297c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        String str3 = this.f75298d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f75299f;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        Uri uri2 = this.f75300g;
        return iHashCode5 ^ (uri2 != null ? uri2.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.api.model.ReviewSummary
    public final String i() {
        return this.f75296b;
    }

    public final String toString() {
        Uri uri = this.f75300g;
        String strValueOf = String.valueOf(this.f75297c);
        String strValueOf2 = String.valueOf(uri);
        String str = this.f75295a;
        int length = String.valueOf(str).length();
        String str2 = this.f75296b;
        int length2 = String.valueOf(str2).length();
        int length3 = strValueOf.length();
        String str3 = this.f75298d;
        int length4 = String.valueOf(str3).length();
        String str4 = this.f75299f;
        StringBuilder sb = new StringBuilder(length + 38 + length2 + 17 + length3 + 17 + length4 + 29 + String.valueOf(str4).length() + 13 + strValueOf2.length() + 1);
        sb.append(SbbqvQlxi.jdN);
        sb.append(str);
        sb.append(", textLanguageCode=");
        sb.append(str2);
        sb.append(", flagContentUri=");
        sb.append(strValueOf);
        sb.append(", disclosureText=");
        sb.append(str3);
        sb.append(", disclosureTextLanguageCode=");
        sb.append(str4);
        sb.append(", reviewsUri=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
