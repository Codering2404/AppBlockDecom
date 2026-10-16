package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfgm extends com.google.android.gms.ads.internal.client.zzbt implements com.google.android.gms.ads.internal.overlay.zzr, zzbgd {
    protected zzcvf zza;
    private final zzcnj zzb;
    private final Context zzc;
    private final String zze;
    private final zzfgg zzf;
    private final zzfge zzg;
    private final VersionInfoParcel zzh;
    private final zzdzl zzi;
    private zzcus zzk;
    private AtomicBoolean zzd = new AtomicBoolean();
    private long zzj = -1;

    public zzfgm(zzcnj zzcnjVar, Context context, String str, zzfgg zzfggVar, zzfge zzfgeVar, VersionInfoParcel versionInfoParcel, zzdzl zzdzlVar) {
        this.zzb = zzcnjVar;
        this.zzc = context;
        this.zze = str;
        this.zzf = zzfggVar;
        this.zzg = zzfgeVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzdzlVar;
        zzfgeVar.zzq(this);
    }

    private final synchronized void zzW(int i3) {
        try {
            if (this.zzd.compareAndSet(false, true)) {
                this.zzg.zzu();
                zzcus zzcusVar = this.zzk;
                if (zzcusVar != null) {
                    com.google.android.gms.ads.internal.zzt.k().zzc(zzcusVar);
                }
                if (this.zza != null) {
                    long jA = -1;
                    if (this.zzj != -1) {
                        jA = com.google.android.gms.ads.internal.zzt.o().a() - this.zzj;
                    }
                    this.zza.zze(jA, i3);
                }
                zzc();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzA() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized boolean zzB() {
        return this.zzf.zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzea zzF() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzG(com.google.android.gms.ads.internal.client.zzfw zzfwVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzI(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzf.zzd(zzxVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzJ(zzbgm zzbgmVar) {
        this.zzg.zzo(zzbgmVar);
    }

    public final void zzL(zzfsy zzfsyVar) {
        this.zzg.zzs(zzfsyVar);
    }

    final /* synthetic */ void zzM() {
        zzW(5);
    }

    final /* synthetic */ void zzN() {
        this.zzb.zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzM();
            }
        });
    }

    final /* synthetic */ zzfge zzO() {
        return this.zzg;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final long zzU() {
        return 0L;
    }

    final /* synthetic */ zzdzl zzV() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzY(com.google.android.gms.ads.internal.client.zzcp zzcpVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zza() {
        zzW(3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final IObjectWrapper zzb() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzc() {
        Preconditions.f("destroy must be called on the main UI thread.");
        zzcvf zzcvfVar = this.zza;
        if (zzcvfVar != null) {
            zzcvfVar.zzd();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdU(int i3) {
        if (i3 == 0) {
            throw null;
        }
        int i4 = i3 - 1;
        if (i4 == 0) {
            zzW(2);
            return;
        }
        if (i4 == 1) {
            zzW(4);
        } else if (i4 != 2) {
            zzW(6);
        } else {
            zzW(3);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdv() {
        zzcvf zzcvfVar = this.zza;
        if (zzcvfVar != null) {
            zzcvfVar.zze(com.google.android.gms.ads.internal.zzt.o().a() - this.zzj, 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.google.android.gms.ads.internal.client.zzbu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean zze(com.google.android.gms.ads.internal.client.zzm r6) throws android.os.RemoteException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r6.N()     // Catch: java.lang.Throwable -> L2d
            r1 = 0
            if (r0 == 0) goto L9
            goto L4c
        L9:
            com.google.android.gms.internal.ads.zzbka r0 = com.google.android.gms.internal.ads.zzbko.zzd     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r0.zze()     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzmD     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbio r2 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r2.zzd(r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2b
            r0 = 1
            goto L2f
        L2b:
            r0 = r1
            goto L2f
        L2d:
            r6 = move-exception
            goto L92
        L2f:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zzh     // Catch: java.lang.Throwable -> L2d
            int r2 = r2.f70151c     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbih r3 = com.google.android.gms.internal.ads.zzbiq.zzmE     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbio r4 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r3 = r4.zzd(r3)     // Catch: java.lang.Throwable -> L2d
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2d
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2d
            if (r2 < r3) goto L47
            if (r0 != 0) goto L4c
        L47:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.f(r0)     // Catch: java.lang.Throwable -> L2d
        L4c:
            com.google.android.gms.ads.internal.zzt.g()     // Catch: java.lang.Throwable -> L2d
            android.content.Context r0 = r5.zzc     // Catch: java.lang.Throwable -> L2d
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.k(r0)     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L6f
            com.google.android.gms.ads.internal.client.zzc r0 = r6.f69982t     // Catch: java.lang.Throwable -> L2d
            if (r0 != 0) goto L6f
            int r6 = com.google.android.gms.ads.internal.util.zze.f70328b     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzo.c(r6)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfge r6 = r5.zzg     // Catch: java.lang.Throwable -> L2d
            r0 = 4
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfma.zzd(r0, r2, r2)     // Catch: java.lang.Throwable -> L2d
            r6.zzdJ(r0)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r5)
            return r1
        L6f:
            boolean r0 = r5.zzB()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L77
            monitor-exit(r5)
            return r1
        L77:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean     // Catch: java.lang.Throwable -> L2d
            r0.<init>()     // Catch: java.lang.Throwable -> L2d
            r5.zzd = r0     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfgi r0 = new com.google.android.gms.internal.ads.zzfgi     // Catch: java.lang.Throwable -> L2d
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfgg r1 = r5.zzf     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = r5.zze     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfgj r3 = new com.google.android.gms.internal.ads.zzfgj     // Catch: java.lang.Throwable -> L2d
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L2d
            boolean r6 = r1.zza(r6, r2, r0, r3)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r5)
            return r6
        L92:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2d
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgm.zze(com.google.android.gms.ads.internal.client.zzm):boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzf() {
        Preconditions.f("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzg() {
        Preconditions.f("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzh() {
        if (this.zza != null) {
            this.zzj = com.google.android.gms.ads.internal.zzt.o().a();
            int iZzc = this.zza.zzc();
            if (iZzc > 0) {
                zzcus zzcusVar = new zzcus(this.zzb.zzc(), com.google.android.gms.ads.internal.zzt.o());
                this.zzk = zzcusVar;
                zzcusVar.zzb(iZzc, new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgk
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzN();
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final Bundle zzk() {
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzl() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzm() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzr zzn() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzo(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Preconditions.f("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzr() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzs() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized com.google.android.gms.ads.internal.client.zzdx zzt() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized String zzu() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzcl zzv() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final com.google.android.gms.ads.internal.client.zzbh zzw() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzx(zzbjl zzbjlVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final synchronized void zzz(boolean z2) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdT() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdp() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdq() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdx() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdy() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdz() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzC(zzcbv zzcbvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzD(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzE(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzH(com.google.android.gms.ads.internal.client.zzee zzeeVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzK(boolean z2) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzP(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzR(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzS(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzT(long j3) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzdS(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzi(com.google.android.gms.ads.internal.client.zzcl zzclVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzj(com.google.android.gms.ads.internal.client.zzby zzbyVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzp(zzbzk zzbzkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzy(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzQ(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbu
    public final void zzq(zzbzn zzbznVar, String str) {
    }
}
