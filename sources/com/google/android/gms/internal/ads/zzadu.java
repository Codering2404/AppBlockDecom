package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadu {
    private final zzadt zza;
    private final zzaeb zzb;
    private boolean zzc;
    private long zzf;
    private boolean zzi;
    private boolean zzl;
    private boolean zzm;
    private int zzd = 0;
    private long zze = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private float zzj = 1.0f;
    private zzdo zzk = zzdo.zza;

    public zzadu(Context context, zzadt zzadtVar, long j3) {
        this.zza = zzadtVar;
        this.zzb = new zzaeb(context);
    }

    private final void zzo(int i3) {
        this.zzd = Math.min(this.zzd, i3);
    }

    public final void zza(int i3) {
        if (i3 == 0) {
            this.zzd = 1;
        } else if (i3 != 1) {
            zzo(2);
        } else {
            this.zzd = 0;
        }
        this.zzb.zzd();
    }

    public final void zzb() {
        this.zzc = true;
        this.zzf = zzfl.zzs(this.zzk.zzb());
        this.zzb.zzb();
    }

    public final void zzc() {
        this.zzc = false;
        this.zzh = -9223372036854775807L;
        this.zzb.zzh();
    }

    public final void zzd(Surface surface) {
        this.zzl = surface != null;
        this.zzm = false;
        this.zzb.zzc(surface);
        zzo(1);
    }

    public final void zze(float f3) {
        this.zzb.zzf(f3);
    }

    public final boolean zzf() {
        int i3 = this.zzd;
        this.zzd = 3;
        this.zzf = zzfl.zzs(this.zzk.zzb());
        return i3 != 3;
    }

    public final void zzg(zzdo zzdoVar) {
        this.zzk = zzdoVar;
    }

    public final void zzh() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final boolean zzi(boolean z2) {
        if (z2 && (this.zzd == 3 || (this.zzm && !this.zzl))) {
            this.zzh = -9223372036854775807L;
            return true;
        }
        if (this.zzh == -9223372036854775807L) {
            return false;
        }
        if (this.zzk.zzb() < this.zzh) {
            return true;
        }
        this.zzh = -9223372036854775807L;
        return false;
    }

    public final void zzj(boolean z2) {
        this.zzi = z2;
        this.zzh = -9223372036854775807L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bd, code lost:
    
        if (r17 > 100000) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ca, code lost:
    
        if (r24 >= r28) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d1, code lost:
    
        if (r21.zzc != false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzk(long r22, long r24, long r26, long r28, boolean r30, boolean r31, com.google.android.gms.internal.ads.zzads r32) throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadu.zzk(long, long, long, long, boolean, boolean, com.google.android.gms.internal.ads.zzads):int");
    }

    public final void zzl() {
        this.zzb.zzd();
        this.zzg = -9223372036854775807L;
        this.zze = -9223372036854775807L;
        zzo(1);
        this.zzh = -9223372036854775807L;
        this.zzm = false;
    }

    public final void zzm(int i3) {
        this.zzb.zza(i3);
    }

    public final void zzn(float f3) {
        zzgtj.zza(f3 > 0.0f);
        if (f3 == this.zzj) {
            return;
        }
        this.zzj = f3;
        this.zzb.zze(f3);
    }
}
