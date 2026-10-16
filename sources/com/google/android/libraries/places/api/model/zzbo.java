package com.google.android.libraries.places.api.model;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbo extends Review {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f75280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f75281d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f75282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Double f75283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AuthorAttribution f75284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f75285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f75286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Uri f75287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LocalDate f75288l;

    zzbo(String str, String str2, String str3, String str4, String str5, Double d3, AuthorAttribution authorAttribution, String str6, String str7, Uri uri, LocalDate localDate) {
        this.f75278a = str;
        this.f75279b = str2;
        this.f75280c = str3;
        this.f75281d = str4;
        this.f75282f = str5;
        this.f75283g = d3;
        if (authorAttribution == null) {
            throw new NullPointerException("Null authorAttribution");
        }
        this.f75284h = authorAttribution;
        if (str6 == null) {
            throw new NullPointerException("Null attribution");
        }
        this.f75285i = str6;
        this.f75286j = str7;
        this.f75287k = uri;
        this.f75288l = localDate;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final String c() {
        return this.f75285i;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final AuthorAttribution d() {
        return this.f75284h;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final Uri e() {
        return this.f75287k;
    }

    public final boolean equals(Object obj) {
        String str;
        Uri uri;
        LocalDate localDate;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Review) {
            Review review = (Review) obj;
            String str2 = this.f75278a;
            if (str2 != null ? str2.equals(review.j()) : review.j() == null) {
                String str3 = this.f75279b;
                if (str3 != null ? str3.equals(review.k()) : review.k() == null) {
                    String str4 = this.f75280c;
                    if (str4 != null ? str4.equals(review.l()) : review.l() == null) {
                        String str5 = this.f75281d;
                        if (str5 != null ? str5.equals(review.f()) : review.f() == null) {
                            String str6 = this.f75282f;
                            if (str6 != null ? str6.equals(review.g()) : review.g() == null) {
                                if (this.f75283g.equals(review.i()) && this.f75284h.equals(review.d()) && this.f75285i.equals(review.c()) && ((str = this.f75286j) != null ? str.equals(review.h()) : review.h() == null) && ((uri = this.f75287k) != null ? uri.equals(review.e()) : review.e() == null) && ((localDate = this.f75288l) != null ? localDate.equals(review.m()) : review.m() == null)) {
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

    @Override // com.google.android.libraries.places.api.model.Review
    public final String f() {
        return this.f75281d;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final String g() {
        return this.f75282f;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final String h() {
        return this.f75286j;
    }

    public final int hashCode() {
        String str = this.f75278a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f75279b;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        int i3 = iHashCode ^ 1000003;
        String str3 = this.f75280c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f75281d;
        int iHashCode4 = (iHashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f75282f;
        int iHashCode5 = (((((((iHashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003) ^ this.f75283g.hashCode()) * 1000003) ^ this.f75284h.hashCode()) * 1000003) ^ this.f75285i.hashCode()) * 1000003;
        String str6 = this.f75286j;
        int iHashCode6 = (iHashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        Uri uri = this.f75287k;
        int iHashCode7 = (iHashCode6 ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        LocalDate localDate = this.f75288l;
        return iHashCode7 ^ (localDate != null ? localDate.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final Double i() {
        return this.f75283g;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final String j() {
        return this.f75278a;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final String k() {
        return this.f75279b;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final String l() {
        return this.f75280c;
    }

    @Override // com.google.android.libraries.places.api.model.Review
    public final LocalDate m() {
        return this.f75288l;
    }

    public final String toString() {
        LocalDate localDate = this.f75288l;
        Uri uri = this.f75287k;
        String string = this.f75284h.toString();
        String strValueOf = String.valueOf(uri);
        String strValueOf2 = String.valueOf(localDate);
        String str = this.f75278a;
        int length = String.valueOf(str).length();
        String str2 = this.f75279b;
        int length2 = String.valueOf(str2).length();
        String str3 = this.f75280c;
        int length3 = String.valueOf(str3).length();
        String str4 = this.f75281d;
        int length4 = String.valueOf(str4).length();
        String str5 = this.f75282f;
        int length5 = String.valueOf(str5).length();
        Double d3 = this.f75283g;
        int length6 = d3.toString().length();
        int length7 = string.length();
        String str6 = this.f75286j;
        int length8 = String.valueOf(str6).length();
        int length9 = strValueOf.length();
        int length10 = strValueOf2.length();
        int i3 = length + 45 + length2 + 19 + length3 + 15 + length4 + 27 + length5 + 9 + length6 + 20 + length7;
        String str7 = this.f75285i;
        StringBuilder sb = new StringBuilder(i3 + 14 + str7.length() + 14 + length8 + 17 + length9 + 12 + length10 + 1);
        sb.append("Review{relativePublishTimeDescription=");
        sb.append(str);
        sb.append(", text=");
        sb.append(str2);
        sb.append(", textLanguageCode=");
        sb.append(str3);
        sb.append(", originalText=");
        sb.append(str4);
        sb.append(", originalTextLanguageCode=");
        sb.append(str5);
        sb.append(", rating=");
        sb.append(d3);
        sb.append(", authorAttribution=");
        sb.append(string);
        sb.append(", attribution=");
        sb.append(str7);
        sb.append(", publishTime=");
        sb.append(str6);
        sb.append(", flagContentUri=");
        sb.append(strValueOf);
        sb.append(", visitDate=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
