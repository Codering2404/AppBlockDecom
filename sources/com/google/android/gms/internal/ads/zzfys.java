package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfys extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfys> CREATOR = new zzfyt();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;

    zzfys(int i3, int i4, int i5, String str, String str2) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = str;
        this.zzd = str2;
        this.zze = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.zzb);
        SafeParcelWriter.G(parcel, 3, this.zzc, false);
        SafeParcelWriter.G(parcel, 4, this.zzd, false);
        SafeParcelWriter.u(parcel, 5, this.zze);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzfys(int i3, zzbds zzbdsVar, String str, String str2) {
        this(1, 1, zzbdsVar.zza(), str, str2);
    }
}
