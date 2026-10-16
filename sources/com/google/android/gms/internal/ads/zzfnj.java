package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfnj {
    private final zzfmn zza;
    private final zzfng zzb;
    private final zzfmj zzc;
    private zzfnp zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfnj(zzfmn zzfmnVar, zzfmj zzfmjVar, zzfng zzfngVar) {
        this.zza = zzfmnVar;
        this.zzc = zzfmjVar;
        this.zzb = zzfngVar;
        zzfmjVar.zza(new zzfmi() { // from class: com.google.android.gms.internal.ads.zzfni
            @Override // com.google.android.gms.internal.ads.zzfmi
            public final /* synthetic */ void zza() {
                this.zza.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0056, code lost:
    
        r3 = new com.google.android.gms.internal.ads.zzfnp(r4.zza, r4.zzb, r0);
        r4.zze = r3;
        r3.zza(new com.google.android.gms.internal.ads.zzfne(r4, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzd() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzbih r0 = com.google.android.gms.internal.ads.zzbiq.zzhk     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.internal.ads.zzbio r1 = com.google.android.gms.ads.internal.client.zzba.c()     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r0 = r1.zzd(r0)     // Catch: java.lang.Throwable -> L2c
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2c
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L2e
            com.google.android.gms.internal.ads.zzcfd r0 = com.google.android.gms.ads.internal.zzt.l()     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzo()     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.internal.ads.zzcey r0 = r0.zzi()     // Catch: java.lang.Throwable -> L2c
            boolean r0 = r0.zzi()     // Catch: java.lang.Throwable -> L2c
            if (r0 != 0) goto L2e
            java.util.ArrayDeque r0 = r4.zzd     // Catch: java.lang.Throwable -> L2c
            r0.clear()     // Catch: java.lang.Throwable -> L2c
            monitor-exit(r4)
            return
        L2c:
            r0 = move-exception
            goto L6d
        L2e:
            boolean r0 = r4.zzi()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L6b
        L34:
            java.util.ArrayDeque r0 = r4.zzd     // Catch: java.lang.Throwable -> L2c
            boolean r1 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2c
            if (r1 != 0) goto L6b
            java.lang.Object r0 = r0.pollFirst()     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.internal.ads.zzfnh r0 = (com.google.android.gms.internal.ads.zzfnh) r0     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L56
            com.google.android.gms.internal.ads.zzfmx r1 = r0.zzb()     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L34
            com.google.android.gms.internal.ads.zzfmn r1 = r4.zza     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.internal.ads.zzfmx r2 = r0.zzb()     // Catch: java.lang.Throwable -> L2c
            boolean r1 = r1.zzc(r2)     // Catch: java.lang.Throwable -> L2c
            if (r1 == 0) goto L34
        L56:
            com.google.android.gms.internal.ads.zzfmn r1 = r4.zza     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.internal.ads.zzfng r2 = r4.zzb     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.internal.ads.zzfnp r3 = new com.google.android.gms.internal.ads.zzfnp     // Catch: java.lang.Throwable -> L2c
            r3.<init>(r1, r2, r0)     // Catch: java.lang.Throwable -> L2c
            r4.zze = r3     // Catch: java.lang.Throwable -> L2c
            com.google.android.gms.internal.ads.zzfne r1 = new com.google.android.gms.internal.ads.zzfne     // Catch: java.lang.Throwable -> L2c
            r1.<init>(r4, r0)     // Catch: java.lang.Throwable -> L2c
            r3.zza(r1)     // Catch: java.lang.Throwable -> L2c
            monitor-exit(r4)
            return
        L6b:
            monitor-exit(r4)
            return
        L6d:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2c
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfnj.zzd():void");
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized void zza(zzfnh zzfnhVar) {
        this.zzd.add(zzfnhVar);
    }

    public final synchronized ListenableFuture zzb(zzfnh zzfnhVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzb(zzfnhVar);
    }

    final /* synthetic */ void zzc() {
        synchronized (this) {
            this.zzf = 1;
            zzd();
        }
    }

    final /* synthetic */ ArrayDeque zze() {
        return this.zzd;
    }

    final /* synthetic */ void zzf(zzfnp zzfnpVar) {
        this.zze = null;
    }

    final /* synthetic */ int zzg() {
        return this.zzf;
    }
}
