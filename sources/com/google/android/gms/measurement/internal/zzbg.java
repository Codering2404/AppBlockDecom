package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbh();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f73484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzbe f73485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f73486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f73487d;

    zzbg(zzbg zzbgVar, long j3) {
        Preconditions.m(zzbgVar);
        this.f73484a = zzbgVar.f73484a;
        this.f73485b = zzbgVar.f73485b;
        this.f73486c = zzbgVar.f73486c;
        this.f73487d = j3;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f73485b);
        String str = this.f73486c;
        int length = String.valueOf(str).length();
        String str2 = this.f73484a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(strValueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        zzbh.a(this, parcel, i3);
    }

    public zzbg(String str, zzbe zzbeVar, String str2, long j3) {
        this.f73484a = str;
        this.f73485b = zzbeVar;
        this.f73486c = str2;
        this.f73487d = j3;
    }
}
