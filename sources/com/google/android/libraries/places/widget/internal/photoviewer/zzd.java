package com.google.android.libraries.places.widget.internal.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzd implements Parcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zzc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f79098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f79099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f79100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f79101d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f79102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f79103g;

    public zzd(String photoUri, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(photoUri, "photoUri");
        this.f79098a = photoUri;
        this.f79099b = str;
        this.f79100c = str2;
        this.f79101d = str3;
        this.f79102f = str4;
        this.f79103g = str5;
    }

    public final String c() {
        return this.f79098a;
    }

    public final String d() {
        return this.f79099b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f79100c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd zzdVar = (zzd) obj;
        return Intrinsics.areEqual(this.f79098a, zzdVar.f79098a) && Intrinsics.areEqual(this.f79099b, zzdVar.f79099b) && Intrinsics.areEqual(this.f79100c, zzdVar.f79100c) && Intrinsics.areEqual(this.f79101d, zzdVar.f79101d) && Intrinsics.areEqual(this.f79102f, zzdVar.f79102f) && Intrinsics.areEqual(this.f79103g, zzdVar.f79103g);
    }

    public final String f() {
        return this.f79101d;
    }

    public final String g() {
        return this.f79102f;
    }

    public final String h() {
        return this.f79103g;
    }

    public final int hashCode() {
        int iHashCode = this.f79098a.hashCode() * 31;
        String str = this.f79099b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f79100c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f79101d;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f79102f;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f79103g;
        return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        String str = this.f79098a;
        int length = String.valueOf(str).length();
        String str2 = this.f79099b;
        int length2 = String.valueOf(str2).length();
        String str3 = this.f79100c;
        int length3 = String.valueOf(str3).length();
        String str4 = this.f79101d;
        int length4 = String.valueOf(str4).length();
        String str5 = this.f79102f;
        int length5 = String.valueOf(str5).length();
        String str6 = this.f79103g;
        StringBuilder sb = new StringBuilder(length + 43 + length2 + 17 + length3 + 18 + length4 + 15 + length5 + 17 + String.valueOf(str6).length() + 1);
        sb.append("PhotoPageData(photoUri=");
        sb.append(str);
        sb.append(", photoThumbnailUri=");
        sb.append(str2);
        sb.append(", reportPhotoUri=");
        sb.append(str3);
        sb.append(", userDisplayName=");
        sb.append(str4);
        sb.append(", userImageUri=");
        sb.append(str5);
        sb.append(", userProfileUri=");
        sb.append(str6);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f79098a);
        dest.writeString(this.f79099b);
        dest.writeString(this.f79100c);
        dest.writeString(this.f79101d);
        dest.writeString(this.f79102f);
        dest.writeString(this.f79103g);
    }
}
