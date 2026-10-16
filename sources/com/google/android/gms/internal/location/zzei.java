package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzei> CREATOR = new zzej();
    private final int zza;
    private final zzeg zzb;
    private final com.google.android.gms.location.zzz zzc;
    private final com.google.android.gms.location.zzw zzd;
    private final PendingIntent zze;
    private final zzr zzf;
    private final String zzg;

    zzei(int i3, zzeg zzegVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        this.zza = i3;
        this.zzb = zzegVar;
        zzr zzpVar = null;
        this.zzc = iBinder != null ? com.google.android.gms.location.zzy.zzb(iBinder) : null;
        this.zze = pendingIntent;
        this.zzd = iBinder2 != null ? com.google.android.gms.location.zzv.zzb(iBinder2) : null;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzpVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzp(iBinder3);
        }
        this.zzf = zzpVar;
        this.zzg = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.E(parcel, 2, this.zzb, i3, false);
        com.google.android.gms.location.zzz zzzVar = this.zzc;
        SafeParcelWriter.t(parcel, 3, zzzVar == null ? null : zzzVar.asBinder(), false);
        SafeParcelWriter.E(parcel, 4, this.zze, i3, false);
        com.google.android.gms.location.zzw zzwVar = this.zzd;
        SafeParcelWriter.t(parcel, 5, zzwVar == null ? null : zzwVar.asBinder(), false);
        zzr zzrVar = this.zzf;
        SafeParcelWriter.t(parcel, 6, zzrVar != null ? zzrVar.asBinder() : null, false);
        SafeParcelWriter.G(parcel, 8, this.zzg, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
