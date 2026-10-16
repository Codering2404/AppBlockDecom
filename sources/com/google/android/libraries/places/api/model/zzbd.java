package com.google.android.libraries.places.api.model;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbd extends PhotoMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f75158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f75159d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f75160f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AuthorAttributions f75161g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Uri f75162h;

    zzbd(String str, int i3, int i4, String str2, String str3, AuthorAttributions authorAttributions, Uri uri) {
        if (str == null) {
            throw new NullPointerException("Null attributions");
        }
        this.f75156a = str;
        this.f75157b = i3;
        this.f75158c = i4;
        if (str2 == null) {
            throw new NullPointerException("Null photoReference");
        }
        this.f75159d = str2;
        this.f75160f = str3;
        this.f75161g = authorAttributions;
        this.f75162h = uri;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata
    public String c() {
        return this.f75156a;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata
    public AuthorAttributions d() {
        return this.f75161g;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata
    public int e() {
        return this.f75157b;
    }

    public final boolean equals(Object obj) {
        String str;
        AuthorAttributions authorAttributions;
        Uri uri;
        if (obj == this) {
            return true;
        }
        if (obj instanceof PhotoMetadata) {
            PhotoMetadata photoMetadata = (PhotoMetadata) obj;
            if (this.f75156a.equals(photoMetadata.c()) && this.f75157b == photoMetadata.e() && this.f75158c == photoMetadata.f() && this.f75159d.equals(photoMetadata.g()) && ((str = this.f75160f) != null ? str.equals(photoMetadata.h()) : photoMetadata.h() == null) && ((authorAttributions = this.f75161g) != null ? authorAttributions.equals(photoMetadata.d()) : photoMetadata.d() == null) && ((uri = this.f75162h) != null ? uri.equals(photoMetadata.i()) : photoMetadata.i() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata
    public int f() {
        return this.f75158c;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata
    public final String g() {
        return this.f75159d;
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata
    public final String h() {
        return this.f75160f;
    }

    public final int hashCode() {
        int iHashCode = ((((((this.f75156a.hashCode() ^ 1000003) * 1000003) ^ this.f75157b) * 1000003) ^ this.f75158c) * 1000003) ^ this.f75159d.hashCode();
        String str = this.f75160f;
        int iHashCode2 = ((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        AuthorAttributions authorAttributions = this.f75161g;
        int iHashCode3 = (iHashCode2 ^ (authorAttributions == null ? 0 : authorAttributions.hashCode())) * 1000003;
        Uri uri = this.f75162h;
        return iHashCode3 ^ (uri != null ? uri.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.api.model.PhotoMetadata
    public final Uri i() {
        return this.f75162h;
    }

    public final String toString() {
        Uri uri = this.f75162h;
        String strValueOf = String.valueOf(this.f75161g);
        String strValueOf2 = String.valueOf(uri);
        int i3 = this.f75157b;
        int length = String.valueOf(i3).length();
        int i4 = this.f75158c;
        int length2 = String.valueOf(i4).length();
        String str = this.f75160f;
        int length3 = String.valueOf(str).length();
        int length4 = strValueOf.length();
        int length5 = strValueOf2.length();
        String str2 = this.f75156a;
        int length6 = str2.length() + 36 + length + 8 + length2;
        String str3 = this.f75159d;
        StringBuilder sb = new StringBuilder(length6 + 17 + str3.length() + 7 + length3 + 21 + length4 + 17 + length5 + 1);
        sb.append("PhotoMetadata{attributions=");
        sb.append(str2);
        sb.append(", height=");
        sb.append(i3);
        sb.append(", width=");
        sb.append(i4);
        sb.append(", photoReference=");
        sb.append(str3);
        sb.append(", name=");
        sb.append(str);
        sb.append(", authorAttributions=");
        sb.append(strValueOf);
        sb.append(", flagContentUri=");
        sb.append(strValueOf2);
        sb.append("}");
        return sb.toString();
    }
}
