package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcjg extends zzcja implements zzin {
    private static final AtomicInteger zzo = new AtomicInteger(0);
    private String zzd;
    private final zzchm zze;
    private boolean zzf;
    private final zzcjf zzg;
    private final zzcij zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcjg(zzchn zzchnVar, zzchm zzchmVar) {
        super(zzchnVar);
        this.zze = zzchmVar;
        this.zzg = new zzcjf();
        this.zzh = new zzcij();
        this.zzk = new Object();
        this.zzl = (String) zzgth.zzd(zzchnVar != null ? zzchnVar.zzn() : null).zza("");
        this.zzm = zzchnVar != null ? zzchnVar.zzp() : 0;
        zzo.incrementAndGet();
    }

    public static int zzr() {
        return zzo.get();
    }

    protected static final String zzv(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.r(str)));
    }

    private final void zzx() {
        int iZza = (int) this.zzg.zza();
        int iZza2 = (int) this.zzh.zza(this.zzi);
        int iPosition = this.zzi.position();
        int iRound = Math.round(iZza2 * (iPosition / iZza));
        int iZzP = zzche.zzP();
        int iZzQ = zzche.zzQ();
        String str = this.zzd;
        zzn(str, zzv(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzP, iZzQ);
    }

    @Override // com.google.android.gms.internal.ads.zzcja, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzo.decrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzb(zzhp zzhpVar, zzht zzhtVar, boolean z2) {
        if (zzhpVar instanceof zzia) {
            this.zzg.zzb((zzia) zzhpVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fa, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    @Override // com.google.android.gms.internal.ads.zzcja
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zze(java.lang.String r28) {
        /*
            Method dump skipped, instruction units count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjg.zze(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
        this.zzf = true;
    }

    public final String zzs() {
        return this.zzd;
    }

    public final boolean zzt() {
        return this.zzn;
    }

    public final ByteBuffer zzu() {
        synchronized (this.zzk) {
            try {
                ByteBuffer byteBuffer = this.zzi;
                if (byteBuffer != null && !this.zzj) {
                    byteBuffer.flip();
                    this.zzj = true;
                }
                this.zzf = true;
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zza(zzhp zzhpVar, zzht zzhtVar, boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzd(zzhp zzhpVar, zzht zzhtVar, boolean z2) {
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzc(zzhp zzhpVar, zzht zzhtVar, boolean z2, int i3) {
    }
}
