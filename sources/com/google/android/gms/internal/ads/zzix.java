package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzix implements zzna, zznc {
    private final int zzb;
    private zznd zzd;
    private int zze;
    private zzqf zzf;
    private zzdo zzg;
    private int zzh;
    private zzzc zzi;
    private zzv[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzxk zzq;
    private zznb zzr;
    private final Object zza = new Object();
    private final zzlw zzc = new zzlw();
    private long zzm = Long.MIN_VALUE;
    private zzbf zzp = zzbf.zza;

    public zzix(int i3) {
        this.zzb = i3;
    }

    private final void zzae(long j3, boolean z2, boolean z3) throws zzjk {
        this.zzn = false;
        this.zzl = j3;
        this.zzm = j3;
        if (!z3) {
            z3 = zzR(j3) != 0;
        }
        zzA(j3, z2, z3);
    }

    protected void zzA(long j3, boolean z2, boolean z3) throws zzjk {
        throw null;
    }

    protected void zzD() {
        throw null;
    }

    protected final long zzH() {
        return this.zzl;
    }

    protected final zzlw zzI() {
        zzlw zzlwVar = this.zzc;
        zzlwVar.zza = null;
        zzlwVar.zzb = null;
        return zzlwVar;
    }

    protected final zzv[] zzJ() {
        zzv[] zzvVarArr = this.zzj;
        zzvVarArr.getClass();
        return zzvVarArr;
    }

    protected final zznd zzK() {
        zznd zzndVar = this.zzd;
        zzndVar.getClass();
        return zzndVar;
    }

    protected final zzqf zzL() {
        zzqf zzqfVar = this.zzf;
        zzqfVar.getClass();
        return zzqfVar;
    }

    protected final zzdo zzM() {
        zzdo zzdoVar = this.zzg;
        zzdoVar.getClass();
        return zzdoVar;
    }

    protected final zzbf zzN() {
        return this.zzp;
    }

    protected final zzxk zzO() {
        return this.zzq;
    }

    protected final zzjk zzP(Throwable th, zzv zzvVar, boolean z2, int i3) {
        int iZzad = 4;
        if (zzvVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzad = zzad(zzvVar) & 7;
            } catch (zzjk unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzjk.zzb(th, zzU(), this.zze, zzvVar, iZzad, this.zzq, z2, i3);
    }

    protected final int zzQ(zzlw zzlwVar, zziv zzivVar, int i3) {
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        int iZzd = zzzcVar.zzd(zzlwVar, zzivVar, i3);
        if (iZzd == -4) {
            if (zzivVar.zzb()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j3 = zzivVar.zze + this.zzk;
            zzivVar.zze = j3;
            this.zzm = Math.max(this.zzm, j3);
            return iZzd;
        }
        if (iZzd == -5) {
            zzv zzvVar = zzlwVar.zzb;
            zzvVar.getClass();
            long j4 = zzvVar.zzu;
            if (j4 != Long.MAX_VALUE) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzt(j4 + this.zzk);
                zzlwVar.zzb = zztVarZza.zzO();
                return -5;
            }
        }
        return iZzd;
    }

    protected final int zzR(long j3) {
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        return zzzcVar.zze(j3 - this.zzk);
    }

    protected final boolean zzS() {
        if (zzcW()) {
            return this.zzn;
        }
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        return zzzcVar.zzb();
    }

    protected final void zzT() {
        zznb zznbVar;
        synchronized (this.zza) {
            zznbVar = this.zzr;
        }
        if (zznbVar != null) {
            zznbVar.zza(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zznc
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzc(int i3, zzqf zzqfVar, zzdo zzdoVar) {
        this.zze = i3;
        this.zzf = zzqfVar;
        this.zzg = zzdoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzcT() throws zzjk {
        zzgtj.zzi(this.zzh == 1);
        this.zzh = 2;
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzcU(zzv[] zzvVarArr, zzzc zzzcVar, long j3, long j4, zzxk zzxkVar) throws zzjk {
        zzgtj.zzi(!this.zzn);
        this.zzi = zzzcVar;
        this.zzq = zzxkVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j3;
        }
        this.zzj = zzvVarArr;
        this.zzk = j4;
        zzz(zzvVarArr, j3, j4, zzxkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final zzzc zzcV() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzcW() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public zzmb zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final int zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzf(zznd zzndVar, zzv[] zzvVarArr, zzzc zzzcVar, long j3, boolean z2, boolean z3, long j4, long j5, zzxk zzxkVar) throws zzjk {
        zzgtj.zzi(this.zzh == 0);
        this.zzd = zzndVar;
        this.zzq = zzxkVar;
        this.zzh = 1;
        zzy(z2, z3);
        zzcU(zzvVarArr, zzzcVar, j4, j5, zzxkVar);
        zzae(j4, z2, true);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final long zzk() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzl() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzm() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzn() throws IOException {
        zzzc zzzcVar = this.zzi;
        zzzcVar.getClass();
        zzzcVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzo(zzbf zzbfVar) {
        if (Objects.equals(this.zzp, zzbfVar)) {
            return;
        }
        this.zzp = zzbfVar;
        zzG(zzbfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzp(long j3, boolean z2) throws zzjk {
        zzae(j3, false, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzq() {
        zzgtj.zzi(this.zzh == 2);
        this.zzh = 1;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzr() {
        zzgtj.zzi(this.zzh == 1);
        zzlw zzlwVar = this.zzc;
        zzlwVar.zza = null;
        zzlwVar.zzb = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzD();
        this.zzq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzs() {
        zzgtj.zzi(this.zzh == 0);
        zzlw zzlwVar = this.zzc;
        zzlwVar.zza = null;
        zzlwVar.zzb = null;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzt() {
        zzgtj.zzi(this.zzh == 0);
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public int zzu() throws zzjk {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzv(zznb zznbVar) {
        synchronized (this.zza) {
            this.zzr = zznbVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzw() {
        synchronized (this.zza) {
            this.zzr = null;
        }
    }

    protected void zzB() throws zzjk {
    }

    protected void zzC() {
    }

    protected void zzE() {
    }

    protected void zzF() {
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final zznc zzb() {
        return this;
    }

    protected void zzG(zzbf zzbfVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmv
    public void zzx(int i3, Object obj) throws zzjk {
    }

    protected void zzy(boolean z2, boolean z3) throws zzjk {
    }

    protected void zzz(zzv[] zzvVarArr, long j3, long j4, zzxk zzxkVar) throws zzjk {
    }
}
