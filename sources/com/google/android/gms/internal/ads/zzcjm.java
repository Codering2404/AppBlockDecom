package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcjm implements zzly {
    private final zzabr zza = new zzabr(true, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    zzcjm() {
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zza(zzqf zzqfVar) {
        zzo(false);
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zzb(zzlx zzlxVar, zzzn zzznVar, zzaba[] zzabaVarArr) {
        int i3;
        this.zzf = 0;
        for (zzaba zzabaVar : zzabaVarArr) {
            if (zzabaVar != null) {
                int i4 = this.zzf;
                int i5 = zzabaVar.zza().zzc;
                if (i5 == 0) {
                    i3 = 144310272;
                } else if (i5 == 1) {
                    i3 = 13107200;
                } else if (i5 != 2) {
                    i3 = 131072;
                    if (i5 != 3 && i5 != 5 && i5 != 6) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    i3 = 131072000;
                }
                this.zzf = i4 + i3;
            }
        }
        this.zza.zzf(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zzc(zzqf zzqfVar) {
        zzo(true);
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final void zzd(zzqf zzqfVar) {
        zzo(true);
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final zzabl zze(zzqf zzqfVar) {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final long zzf(zzqf zzqfVar) {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final boolean zzg(zzqf zzqfVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final boolean zzh(zzlx zzlxVar) {
        long j3 = zzlxVar.zze;
        boolean z2 = true;
        char c3 = j3 > this.zzc ? (char) 0 : j3 < this.zzb ? (char) 2 : (char) 1;
        int iZzg = this.zza.zzg();
        int i3 = this.zzf;
        if (c3 != 2 && (c3 != 1 || !this.zzg || iZzg >= i3)) {
            z2 = false;
        }
        this.zzg = z2;
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzly
    public final boolean zzi(zzlx zzlxVar) {
        long j3 = zzlxVar.zzg ? this.zze : this.zzd;
        return j3 <= 0 || zzlxVar.zze >= j3;
    }

    public final synchronized void zzk(int i3) {
        this.zzb = ((long) i3) * 1000;
    }

    public final synchronized void zzl(int i3) {
        this.zzc = ((long) i3) * 1000;
    }

    public final synchronized void zzm(int i3) {
        this.zzd = ((long) i3) * 1000;
    }

    public final synchronized void zzn(int i3) {
        this.zze = ((long) i3) * 1000;
    }

    final void zzo(boolean z2) {
        this.zzf = 0;
        this.zzg = false;
        if (z2) {
            this.zza.zze();
        }
    }
}
