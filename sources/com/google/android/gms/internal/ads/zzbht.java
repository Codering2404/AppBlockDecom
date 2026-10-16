package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbht {
    final /* synthetic */ zzbhu zza;
    private final byte[] zzb;
    private int zzc;

    /* synthetic */ zzbht(zzbhu zzbhuVar, byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(zzbhuVar);
        this.zza = zzbhuVar;
        this.zzb = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzc() {
        try {
            zzbhu zzbhuVar = this.zza;
            if (zzbhuVar.zzb) {
                zzbhuVar.zza.zzh(this.zzb);
                zzbhuVar.zza.zzi(0);
                zzbhuVar.zza.zzj(this.zzc);
                zzbhuVar.zza.zzg(null);
                zzbhuVar.zza.zzf();
            }
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.b("Clearcut log failed", e3);
        }
    }

    public final synchronized void zza() {
        this.zza.zza().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzc();
            }
        });
    }

    public final zzbht zzb(int i3) {
        this.zzc = i3;
        return this;
    }
}
