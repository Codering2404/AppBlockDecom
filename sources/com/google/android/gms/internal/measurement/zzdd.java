package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdd> CREATOR = new zzde();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final Bundle zzd;
    public final String zze;

    public zzdd(long j3, long j4, boolean z2, Bundle bundle, String str) {
        this.zza = j3;
        this.zzb = j4;
        this.zzc = z2;
        this.zzd = bundle;
        this.zze = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        long j3 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, j3);
        SafeParcelWriter.z(parcel, 2, this.zzb);
        SafeParcelWriter.g(parcel, 3, this.zzc);
        SafeParcelWriter.j(parcel, 7, this.zzd, false);
        SafeParcelWriter.G(parcel, 8, this.zze, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
