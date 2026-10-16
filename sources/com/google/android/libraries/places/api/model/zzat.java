package com.google.android.libraries.places.api.model;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzat extends NeighborhoodSummary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentBlock f75099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentBlock f75100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f75101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f75102d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f75103f;

    zzat(ContentBlock contentBlock, ContentBlock contentBlock2, Uri uri, String str, String str2) {
        this.f75099a = contentBlock;
        this.f75100b = contentBlock2;
        this.f75101c = uri;
        this.f75102d = str;
        this.f75103f = str2;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary
    public final ContentBlock d() {
        return this.f75100b;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary
    public final String e() {
        return this.f75102d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NeighborhoodSummary) {
            NeighborhoodSummary neighborhoodSummary = (NeighborhoodSummary) obj;
            ContentBlock contentBlock = this.f75099a;
            if (contentBlock != null ? contentBlock.equals(neighborhoodSummary.h()) : neighborhoodSummary.h() == null) {
                ContentBlock contentBlock2 = this.f75100b;
                if (contentBlock2 != null ? contentBlock2.equals(neighborhoodSummary.d()) : neighborhoodSummary.d() == null) {
                    Uri uri = this.f75101c;
                    if (uri != null ? uri.equals(neighborhoodSummary.g()) : neighborhoodSummary.g() == null) {
                        String str = this.f75102d;
                        if (str != null ? str.equals(neighborhoodSummary.e()) : neighborhoodSummary.e() == null) {
                            String str2 = this.f75103f;
                            if (str2 != null ? str2.equals(neighborhoodSummary.f()) : neighborhoodSummary.f() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary
    public final String f() {
        return this.f75103f;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary
    public final Uri g() {
        return this.f75101c;
    }

    @Override // com.google.android.libraries.places.api.model.NeighborhoodSummary
    public final ContentBlock h() {
        return this.f75099a;
    }

    public final int hashCode() {
        ContentBlock contentBlock = this.f75099a;
        int iHashCode = contentBlock == null ? 0 : contentBlock.hashCode();
        ContentBlock contentBlock2 = this.f75100b;
        int iHashCode2 = contentBlock2 == null ? 0 : contentBlock2.hashCode();
        int i3 = iHashCode ^ 1000003;
        Uri uri = this.f75101c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        String str = this.f75102d;
        int iHashCode4 = (iHashCode3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f75103f;
        return iHashCode4 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        Uri uri = this.f75101c;
        ContentBlock contentBlock = this.f75100b;
        String strValueOf = String.valueOf(this.f75099a);
        String strValueOf2 = String.valueOf(contentBlock);
        String strValueOf3 = String.valueOf(uri);
        int length = strValueOf.length();
        int length2 = strValueOf2.length();
        int length3 = strValueOf3.length();
        String str = this.f75102d;
        int length4 = String.valueOf(str).length();
        String str2 = this.f75103f;
        StringBuilder sb = new StringBuilder(length + 43 + length2 + 17 + length3 + 17 + length4 + 29 + String.valueOf(str2).length() + 1);
        sb.append("NeighborhoodSummary{overview=");
        sb.append(strValueOf);
        sb.append(", description=");
        sb.append(strValueOf2);
        sb.append(", flagContentUri=");
        sb.append(strValueOf3);
        sb.append(", disclosureText=");
        sb.append(str);
        sb.append(", disclosureTextLanguageCode=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
