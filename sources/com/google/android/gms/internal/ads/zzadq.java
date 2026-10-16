package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadq implements zzbt {
    private final Context zza;
    private final zzbs zzb;
    private final SparseArray zzc;
    private final boolean zzd;
    private final zzaeu zze;
    private final zzdo zzf;
    private final CopyOnWriteArraySet zzg;
    private final long zzh;
    private final zzadv zzi;
    private zzfh zzj = new zzfh(10);
    private zzv zzk;
    private zzdz zzl;
    private Pair zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private long zzq;
    private int zzr;

    /* synthetic */ zzadq(zzadi zzadiVar, byte[] bArr) {
        this.zza = zzadiVar.zze();
        zzbs zzbsVarZzg = zzadiVar.zzg();
        zzbsVarZzg.getClass();
        this.zzb = zzbsVarZzg;
        this.zzc = new SparseArray();
        zzgwm.zzi();
        this.zzd = zzadiVar.zzh();
        zzdo zzdoVarZzi = zzadiVar.zzi();
        this.zzf = zzdoVarZzi;
        this.zzh = -zzadiVar.zzj();
        zzadv zzadvVarZzk = zzadiVar.zzk();
        this.zzi = zzadvVarZzk;
        this.zze = new zzacv(zzadiVar.zzf(), zzadvVarZzk, zzdoVarZzi);
        new zzadh(this);
        this.zzg = new CopyOnWriteArraySet();
        this.zzk = new zzt().zzO();
        this.zzp = -9223372036854775807L;
        this.zzq = -9223372036854775807L;
        this.zzr = -1;
        this.zzo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zzi zzC(zzi zziVar) {
        return (zziVar == null || !zziVar.zzf()) ? zzi.zza : zziVar;
    }

    final /* synthetic */ void zzA(long j3) {
        this.zzq = j3;
    }

    public final void zza(int i3) {
        this.zzr = 1;
    }

    public final zzaeu zzb(int i3) {
        SparseArray sparseArray = this.zzc;
        if (zzfl.zza(sparseArray, 0)) {
            return (zzaeu) sparseArray.get(0);
        }
        zzadk zzadkVar = new zzadk(this, this.zza, 0);
        this.zzg.add(zzadkVar);
        sparseArray.put(0, zzadkVar);
        return zzadkVar;
    }

    public final void zzc(Surface surface, zzeu zzeuVar) {
        Pair pair = this.zzm;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzeu) this.zzm.second).equals(zzeuVar)) {
            return;
        }
        this.zzm = Pair.create(surface, zzeuVar);
        zzeuVar.zza();
        zzeuVar.zzb();
    }

    public final void zzd() {
        zzeu zzeuVar = zzeu.zza;
        zzeuVar.zza();
        zzeuVar.zzb();
        this.zzm = null;
    }

    public final void zze() {
        this.zze.zza();
    }

    public final void zzf() {
        this.zze.zzb();
    }

    public final void zzg() {
        if (this.zzo == 2) {
            return;
        }
        zzdz zzdzVar = this.zzl;
        if (zzdzVar != null) {
            zzdzVar.zzl(null);
        }
        this.zzm = null;
        this.zzo = 2;
    }

    final /* synthetic */ void zzh() {
        this.zzn--;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062 A[Catch: zzdw -> 0x0031, TRY_LEAVE, TryCatch #1 {zzdw -> 0x0031, blocks: (B:7:0x0010, B:9:0x0015, B:11:0x001b, B:14:0x0023, B:18:0x0034, B:20:0x003a, B:23:0x0041, B:28:0x0062), top: B:40:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ boolean zzi(com.google.android.gms.internal.ads.zzv r11, int r12) throws com.google.android.gms.internal.ads.zzaet {
        /*
            r10 = this;
            int r12 = r10.zzo
            if (r12 != 0) goto L6
            r12 = 1
            goto L7
        L6:
            r12 = 0
        L7:
            com.google.android.gms.internal.ads.zzgtj.zzi(r12)
            com.google.android.gms.internal.ads.zzi r12 = r11.zzF
            com.google.android.gms.internal.ads.zzi r12 = zzC(r12)
            int r0 = r12.zzd     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            r1 = 7
            if (r0 != r1) goto L34
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            r2 = 34
            if (r0 >= r2) goto L21
            boolean r0 = com.google.android.gms.internal.ads.zzdx.zzd()     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            if (r0 != 0) goto L23
        L21:
            r0 = r1
            goto L34
        L23:
            com.google.android.gms.internal.ads.zzh r12 = r12.zzd()     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            r0 = 6
            r12.zzc(r0)     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            com.google.android.gms.internal.ads.zzi r12 = r12.zzg()     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
        L2f:
            r2 = r12
            goto L65
        L31:
            r0 = move-exception
            r12 = r0
            goto L93
        L34:
            boolean r1 = com.google.android.gms.internal.ads.zzdx.zzc(r0)     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            if (r1 != 0) goto L5b
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            r2 = 29
            if (r1 >= r2) goto L41
            goto L5b
        L41:
            java.lang.String r12 = "PlaybackVidGraphWrapper"
            java.lang.String r1 = "Color transfer %d is not supported. Falling back to OpenGl tone mapping."
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            java.lang.String r2 = com.google.android.gms.internal.ads.zzfl.zza     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            java.util.Locale r2 = java.util.Locale.US     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            java.lang.String r0 = java.lang.String.format(r2, r1, r0)     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            com.google.android.gms.internal.ads.zzeg.zzc(r12, r0)     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            com.google.android.gms.internal.ads.zzi r12 = com.google.android.gms.internal.ads.zzi.zza     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            goto L2f
        L5b:
            r1 = 2
            if (r0 == r1) goto L62
            r1 = 10
            if (r0 != r1) goto L2f
        L62:
            com.google.android.gms.internal.ads.zzi r12 = com.google.android.gms.internal.ads.zzi.zza     // Catch: com.google.android.gms.internal.ads.zzdw -> L31
            goto L2f
        L65:
            com.google.android.gms.internal.ads.zzdo r12 = r10.zzf
            android.os.Looper r0 = android.os.Looper.myLooper()
            r0.getClass()
            r9 = 0
            com.google.android.gms.internal.ads.zzdz r12 = r12.zzd(r0, r9)
            r10.zzl = r12
            com.google.android.gms.internal.ads.zzbs r0 = r10.zzb     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
            android.content.Context r1 = r10.zza     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
            com.google.android.gms.internal.ads.zzl r3 = com.google.android.gms.internal.ads.zzl.zzb     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
            java.util.Objects.requireNonNull(r12)     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
            com.google.android.gms.internal.ads.zzadj r5 = new com.google.android.gms.internal.ads.zzadj     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
            r5.<init>()     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
            r6 = 0
            r8 = 0
            r4 = r10
            r0.zza(r1, r2, r3, r4, r5, r6, r8)     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
            throw r9     // Catch: com.google.android.gms.internal.ads.zzbo -> L8b
        L8b:
            r0 = move-exception
            r12 = r0
            com.google.android.gms.internal.ads.zzaet r0 = new com.google.android.gms.internal.ads.zzaet
            r0.<init>(r12, r11)
            throw r0
        L93:
            com.google.android.gms.internal.ads.zzaet r0 = new com.google.android.gms.internal.ads.zzaet
            r0.<init>(r12, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadq.zzi(com.google.android.gms.internal.ads.zzv, int):boolean");
    }

    final /* synthetic */ boolean zzj(boolean z2) {
        return this.zze.zzh(false);
    }

    final /* synthetic */ void zzk() {
        this.zze.zzi();
    }

    final /* synthetic */ void zzl(long j3, long j4) throws zzaet {
        this.zze.zzv(j3, j4);
    }

    final /* synthetic */ void zzm(boolean z2) {
        if (this.zzo == 1) {
            this.zzn++;
            zzaeu zzaeuVar = this.zze;
            zzaeuVar.zzg(z2);
            while (this.zzj.zzc() > 1) {
                this.zzj.zzd();
            }
            if (this.zzj.zzc() == 1) {
                zzadp zzadpVar = (zzadp) this.zzj.zzd();
                zzadpVar.getClass();
                zzaeuVar.zzs(1, this.zzk, zzadpVar.zza, zzadpVar.zzb, zzgwm.zzi());
            }
            this.zzp = -9223372036854775807L;
            if (z2) {
                this.zzq = -9223372036854775807L;
            }
            zzdz zzdzVar = this.zzl;
            zzdzVar.getClass();
            zzdzVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzadl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzh();
                }
            });
        }
    }

    final /* synthetic */ void zzn(boolean z2) {
        this.zze.zzw(z2);
    }

    final /* synthetic */ void zzo() {
        this.zze.zzt();
    }

    final /* synthetic */ void zzp(zzadr zzadrVar) {
        this.zze.zzl(zzadrVar);
    }

    final /* synthetic */ void zzq(float f3) {
        this.zzi.zzc(f3);
        this.zze.zzm(f3);
    }

    final /* synthetic */ void zzr(int i3) {
        this.zze.zzr(i3);
    }

    final /* synthetic */ boolean zzs() {
        int i3 = this.zzr;
        return i3 != -1 && i3 == 0;
    }

    final /* synthetic */ boolean zzt() {
        return this.zzd;
    }

    final /* synthetic */ long zzu() {
        return this.zzh;
    }

    final /* synthetic */ zzadv zzv() {
        return this.zzi;
    }

    final /* synthetic */ zzfh zzw() {
        return this.zzj;
    }

    final /* synthetic */ void zzx(zzfh zzfhVar) {
        this.zzj = zzfhVar;
    }

    final /* synthetic */ long zzy() {
        return this.zzp;
    }

    final /* synthetic */ long zzz() {
        return this.zzq;
    }
}
