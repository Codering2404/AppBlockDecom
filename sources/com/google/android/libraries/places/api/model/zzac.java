package com.google.android.libraries.places.api.model;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzac extends EvChargeAmenitySummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentBlock f75039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentBlock f75040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ContentBlock f75041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ContentBlock f75042d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f75043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f75044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f75045h;

    zzac(ContentBlock contentBlock, ContentBlock contentBlock2, ContentBlock contentBlock3, ContentBlock contentBlock4, Uri uri, String str, String str2) {
        if (contentBlock == null) {
            throw new NullPointerException("Null overview");
        }
        this.f75039a = contentBlock;
        this.f75040b = contentBlock2;
        this.f75041c = contentBlock3;
        this.f75042d = contentBlock4;
        this.f75043f = uri;
        this.f75044g = str;
        this.f75045h = str2;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary
    public final ContentBlock c() {
        return this.f75040b;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary
    public final String d() {
        return this.f75044g;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary
    public final String e() {
        return this.f75045h;
    }

    public final boolean equals(Object obj) {
        ContentBlock contentBlock;
        ContentBlock contentBlock2;
        ContentBlock contentBlock3;
        Uri uri;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof EvChargeAmenitySummary) {
            EvChargeAmenitySummary evChargeAmenitySummary = (EvChargeAmenitySummary) obj;
            if (this.f75039a.equals(evChargeAmenitySummary.g()) && ((contentBlock = this.f75040b) != null ? contentBlock.equals(evChargeAmenitySummary.c()) : evChargeAmenitySummary.c() == null) && ((contentBlock2 = this.f75041c) != null ? contentBlock2.equals(evChargeAmenitySummary.h()) : evChargeAmenitySummary.h() == null) && ((contentBlock3 = this.f75042d) != null ? contentBlock3.equals(evChargeAmenitySummary.i()) : evChargeAmenitySummary.i() == null) && ((uri = this.f75043f) != null ? uri.equals(evChargeAmenitySummary.f()) : evChargeAmenitySummary.f() == null) && ((str = this.f75044g) != null ? str.equals(evChargeAmenitySummary.d()) : evChargeAmenitySummary.d() == null) && ((str2 = this.f75045h) != null ? str2.equals(evChargeAmenitySummary.e()) : evChargeAmenitySummary.e() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary
    public final Uri f() {
        return this.f75043f;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary
    public final ContentBlock g() {
        return this.f75039a;
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary
    public final ContentBlock h() {
        return this.f75041c;
    }

    public final int hashCode() {
        int iHashCode = this.f75039a.hashCode() ^ 1000003;
        ContentBlock contentBlock = this.f75040b;
        int iHashCode2 = ((iHashCode * 1000003) ^ (contentBlock == null ? 0 : contentBlock.hashCode())) * 1000003;
        ContentBlock contentBlock2 = this.f75041c;
        int iHashCode3 = (iHashCode2 ^ (contentBlock2 == null ? 0 : contentBlock2.hashCode())) * 1000003;
        ContentBlock contentBlock3 = this.f75042d;
        int iHashCode4 = (iHashCode3 ^ (contentBlock3 == null ? 0 : contentBlock3.hashCode())) * 1000003;
        Uri uri = this.f75043f;
        int iHashCode5 = (iHashCode4 ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        String str = this.f75044g;
        int iHashCode6 = (iHashCode5 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f75045h;
        return iHashCode6 ^ (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.api.model.EvChargeAmenitySummary
    public final ContentBlock i() {
        return this.f75042d;
    }

    public final String toString() {
        String string = this.f75039a.toString();
        int length = string.length();
        Uri uri = this.f75043f;
        ContentBlock contentBlock = this.f75042d;
        ContentBlock contentBlock2 = this.f75041c;
        String strValueOf = String.valueOf(this.f75040b);
        String strValueOf2 = String.valueOf(contentBlock2);
        String strValueOf3 = String.valueOf(contentBlock);
        String strValueOf4 = String.valueOf(uri);
        int length2 = strValueOf.length();
        int length3 = strValueOf2.length();
        int length4 = strValueOf3.length();
        int length5 = strValueOf4.length();
        String str = this.f75044g;
        int length6 = String.valueOf(str).length();
        String str2 = this.f75045h;
        StringBuilder sb = new StringBuilder(length + 41 + length2 + 13 + length3 + 8 + length4 + 17 + length5 + 17 + length6 + 29 + String.valueOf(str2).length() + 1);
        sb.append("EvChargeAmenitySummary{overview=");
        sb.append(string);
        sb.append(", coffee=");
        sb.append(strValueOf);
        sb.append(", restaurant=");
        sb.append(strValueOf2);
        sb.append(", store=");
        sb.append(strValueOf3);
        sb.append(", flagContentUri=");
        sb.append(strValueOf4);
        sb.append(", disclosureText=");
        sb.append(str);
        sb.append(", disclosureTextLanguageCode=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
