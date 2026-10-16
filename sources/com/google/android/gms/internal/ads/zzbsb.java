package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbsb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbsb> CREATOR = new zzbsc();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final int zzd;

    public zzbsb(int i3, int i4, String str, int i5) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = str;
        this.zzd = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zzb;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.zzc, false);
        SafeParcelWriter.u(parcel, 3, this.zzd);
        SafeParcelWriter.u(parcel, 1000, this.zza);
        SafeParcelWriter.b(parcel, iA);
    }
}
