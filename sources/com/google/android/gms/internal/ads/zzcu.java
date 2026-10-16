package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcu implements zzco {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzcl zze;
    private zzcl zzf;
    private zzcl zzg;
    private zzcl zzh;
    private boolean zzi;
    private zzct zzj;
    private ByteBuffer zzk;
    private ByteBuffer zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;

    public zzcu() {
        zzcl zzclVar = zzcl.zza;
        this.zze = zzclVar;
        this.zzf = zzclVar;
        this.zzg = zzclVar;
        this.zzh = zzclVar;
        ByteBuffer byteBuffer = zzco.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer;
        this.zzb = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zza(long j3) {
        if (this.zzn < 1024) {
            return (long) (j3 / ((double) this.zzc));
        }
        long j4 = this.zzm;
        zzct zzctVar = this.zzj;
        zzctVar.getClass();
        long jZza = j4 - ((long) zzctVar.zza());
        int i3 = this.zzh.zzb;
        int i4 = this.zzg.zzb;
        return i3 == i4 ? zzfl.zzv(j3, this.zzn, jZza, RoundingMode.DOWN) : zzfl.zzv(j3, this.zzn * ((long) i4), jZza * ((long) i3), RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzb(zzcl zzclVar) throws zzcn {
        int i3 = zzclVar.zzd;
        if (i3 != 2 && i3 != 4) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int i4 = this.zzb;
        if (i4 == -1) {
            i4 = zzclVar.zzb;
        }
        this.zze = zzclVar;
        zzcl zzclVar2 = new zzcl(i4, zzclVar.zzc, i3);
        this.zzf = zzclVar2;
        this.zzi = true;
        return zzclVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzc() {
        if (this.zzf.zzb != -1) {
            return Math.abs(this.zzc + (-1.0f)) >= 1.0E-4f || Math.abs(this.zzd + (-1.0f)) >= 1.0E-4f || this.zzf.zzb != this.zze.zzb;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzd(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzct zzctVar = this.zzj;
            zzctVar.getClass();
            this.zzm += (long) byteBuffer.remaining();
            zzctVar.zzb(byteBuffer);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zze() {
        zzct zzctVar = this.zzj;
        if (zzctVar != null) {
            zzctVar.zzd();
        }
        this.zzo = true;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final ByteBuffer zzf() {
        int iZzf;
        zzct zzctVar = this.zzj;
        if (zzctVar != null && (iZzf = zzctVar.zzf()) > 0) {
            if (this.zzk.capacity() < iZzf) {
                this.zzk = ByteBuffer.allocateDirect(iZzf).order(ByteOrder.nativeOrder());
            } else {
                this.zzk.clear();
            }
            zzctVar.zzc(this.zzk);
            this.zzk.flip();
            this.zzn += (long) iZzf;
            this.zzl = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzl;
        this.zzl = zzco.zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzg() {
        if (!this.zzo) {
            return false;
        }
        zzct zzctVar = this.zzj;
        return zzctVar == null || zzctVar.zzf() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzi(zzcm zzcmVar) {
        if (zzc()) {
            zzcl zzclVar = this.zze;
            this.zzg = zzclVar;
            zzcl zzclVar2 = this.zzf;
            this.zzh = zzclVar2;
            if (this.zzi) {
                this.zzj = new zzct(zzclVar.zzb, zzclVar.zzc, this.zzc, this.zzd, zzclVar2.zzb, zzclVar.zzd == 4);
            } else {
                zzct zzctVar = this.zzj;
                if (zzctVar != null) {
                    zzctVar.zze();
                }
            }
        }
        this.zzl = zzco.zza;
        this.zzm = 0L;
        this.zzn = 0L;
        this.zzo = false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzj() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzcl zzclVar = zzcl.zza;
        this.zze = zzclVar;
        this.zzf = zzclVar;
        this.zzg = zzclVar;
        this.zzh = zzclVar;
        ByteBuffer byteBuffer = zzco.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzm = 0L;
        this.zzn = 0L;
        this.zzo = false;
    }

    public final void zzk(float f3) {
        zzgtj.zza(f3 > 0.0f);
        if (this.zzc != f3) {
            this.zzc = f3;
            this.zzi = true;
        }
    }

    public final void zzl(float f3) {
        zzgtj.zza(f3 > 0.0f);
        if (this.zzd != f3) {
            this.zzd = f3;
            this.zzi = true;
        }
    }

    public final long zzm(long j3) {
        if (this.zzn < 1024) {
            return (long) (((double) this.zzc) * j3);
        }
        long j4 = this.zzm;
        zzct zzctVar = this.zzj;
        zzctVar.getClass();
        long jZza = j4 - ((long) zzctVar.zza());
        int i3 = this.zzh.zzb;
        int i4 = this.zzg.zzb;
        return i3 == i4 ? zzfl.zzv(j3, jZza, this.zzn, RoundingMode.DOWN) : zzfl.zzv(j3, jZza * ((long) i3), this.zzn * ((long) i4), RoundingMode.DOWN);
    }
}
