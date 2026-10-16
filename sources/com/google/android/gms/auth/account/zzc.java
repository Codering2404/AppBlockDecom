package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc extends com.google.android.gms.internal.auth.zza implements zze {
    zzc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void H4(zzb zzbVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.auth.zzc.zzd(parcelZza, zzbVar);
        parcelZza.writeString(str);
        zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void L4(zzb zzbVar, Account account) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.auth.zzc.zzd(parcelZza, zzbVar);
        com.google.android.gms.internal.auth.zzc.zzc(parcelZza, account);
        zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.auth.account.zze
    public final void zzf(boolean z2) throws RemoteException {
        Parcel parcelZza = zza();
        int i3 = com.google.android.gms.internal.auth.zzc.zza;
        parcelZza.writeInt(z2 ? 1 : 0);
        zzc(1, parcelZza);
    }
}
