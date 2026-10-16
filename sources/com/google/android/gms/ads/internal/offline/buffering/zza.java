package com.google.android.gms.ads.internal.offline.buffering;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f70038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f70039c;

    public zza(String str, String str2, String str3) {
        this.f70037a = str;
        this.f70038b = str2;
        this.f70039c = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f70037a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.G(parcel, 2, this.f70038b, false);
        SafeParcelWriter.G(parcel, 3, this.f70039c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
