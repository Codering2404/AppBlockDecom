package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    final int zza;
    final zzh zzb;
    final com.google.android.gms.location.zzt zzc;
    final zzr zzd;

    zzj(int i3, zzh zzhVar, IBinder iBinder, IBinder iBinder2) {
        this.zza = i3;
        this.zzb = zzhVar;
        zzr zzpVar = null;
        this.zzc = iBinder == null ? null : com.google.android.gms.location.zzs.zzb(iBinder);
        if (iBinder2 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzpVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzp(iBinder2);
        }
        this.zzd = zzpVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.zza);
        SafeParcelWriter.E(parcel, 2, this.zzb, i3, false);
        com.google.android.gms.location.zzt zztVar = this.zzc;
        SafeParcelWriter.t(parcel, 3, zztVar == null ? null : zztVar.asBinder(), false);
        zzr zzrVar = this.zzd;
        SafeParcelWriter.t(parcel, 4, zzrVar != null ? zzrVar.asBinder() : null, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
