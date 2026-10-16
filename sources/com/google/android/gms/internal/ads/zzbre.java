package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbre extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbre> CREATOR = new zzbrf();
    public final boolean zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;
    public final String[] zze;
    public final String[] zzf;
    public final boolean zzg;
    public final long zzh;

    zzbre(boolean z2, String str, int i3, byte[] bArr, String[] strArr, String[] strArr2, boolean z3, long j3) {
        this.zza = z2;
        this.zzb = str;
        this.zzc = i3;
        this.zzd = bArr;
        this.zze = strArr;
        this.zzf = strArr2;
        this.zzg = z3;
        this.zzh = j3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z2 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, z2);
        SafeParcelWriter.G(parcel, 2, this.zzb, false);
        SafeParcelWriter.u(parcel, 3, this.zzc);
        SafeParcelWriter.l(parcel, 4, this.zzd, false);
        SafeParcelWriter.H(parcel, 5, this.zze, false);
        SafeParcelWriter.H(parcel, 6, this.zzf, false);
        SafeParcelWriter.g(parcel, 7, this.zzg);
        SafeParcelWriter.z(parcel, 8, this.zzh);
        SafeParcelWriter.b(parcel, iA);
    }
}
