package com.google.android.libraries.places.api.model;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzai extends GenerativeSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f75061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f75062d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f75063f;

    zzai(String str, String str2, Uri uri, String str3, String str4) {
        this.f75059a = str;
        this.f75060b = str2;
        this.f75061c = uri;
        this.f75062d = str3;
        this.f75063f = str4;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary
    public final String d() {
        return this.f75062d;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary
    public final String e() {
        return this.f75063f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GenerativeSummary) {
            GenerativeSummary generativeSummary = (GenerativeSummary) obj;
            String str = this.f75059a;
            if (str != null ? str.equals(generativeSummary.g()) : generativeSummary.g() == null) {
                String str2 = this.f75060b;
                if (str2 != null ? str2.equals(generativeSummary.h()) : generativeSummary.h() == null) {
                    Uri uri = this.f75061c;
                    if (uri != null ? uri.equals(generativeSummary.f()) : generativeSummary.f() == null) {
                        String str3 = this.f75062d;
                        if (str3 != null ? str3.equals(generativeSummary.d()) : generativeSummary.d() == null) {
                            String str4 = this.f75063f;
                            if (str4 != null ? str4.equals(generativeSummary.e()) : generativeSummary.e() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary
    public final Uri f() {
        return this.f75061c;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary
    public final String g() {
        return this.f75059a;
    }

    @Override // com.google.android.libraries.places.api.model.GenerativeSummary
    public final String h() {
        return this.f75060b;
    }

    public final int hashCode() {
        String str = this.f75059a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f75060b;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        int i3 = iHashCode ^ 1000003;
        Uri uri = this.f75061c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        String str3 = this.f75062d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f75063f;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f75061c);
        String str = this.f75059a;
        int length = String.valueOf(str).length();
        String str2 = this.f75060b;
        int length2 = String.valueOf(str2).length();
        int length3 = strValueOf.length();
        String str3 = this.f75062d;
        int length4 = String.valueOf(str3).length();
        String str4 = this.f75063f;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 17 + length3 + 17 + length4 + 29 + String.valueOf(str4).length() + 1);
        sb.append("GenerativeSummary{overview=");
        sb.append(str);
        sb.append(", overviewLanguageCode=");
        sb.append(str2);
        sb.append(", flagContentUri=");
        sb.append(strValueOf);
        sb.append(", disclosureText=");
        sb.append(str3);
        sb.append(", disclosureTextLanguageCode=");
        sb.append(str4);
        sb.append("}");
        return sb.toString();
    }
}
