package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzct {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final zzcr zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private double zzq;

    public zzct(int i3, int i4, float f3, float f4, int i5, boolean z2) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = f3;
        this.zzd = f4;
        this.zze = i3 / i5;
        this.zzf = i3 / RCHTTPStatusCodes.BAD_REQUEST;
        int i6 = i3 / 65;
        this.zzg = i6;
        this.zzh = i6 + i6;
        this.zzi = z2 ? new zzcq(this) : new zzcs(this);
    }

    private final void zzo(int i3, int i4) {
        zzcr zzcrVar = this.zzi;
        zzcrVar.zzk(i4);
        Object objZzr = zzcrVar.zzr();
        Object objZzq = zzcrVar.zzq();
        int i5 = this.zzk;
        int i6 = this.zzb;
        System.arraycopy(objZzr, i3 * i6, objZzq, i5 * i6, i4 * i6);
        this.zzk += i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x017e A[EDGE_INSN: B:101:0x017e->B:59:0x017e BREAK  A[LOOP:3: B:13:0x0035->B:92:0x024c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x024c A[LOOP:3: B:13:0x0035->B:92:0x024c, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzp() {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzct.zzp():void");
    }

    public final int zza() {
        return this.zzj * this.zzb * this.zzi.zza();
    }

    public final void zzb(ByteBuffer byteBuffer) {
        zzcr zzcrVar = this.zzi;
        int iRemaining = byteBuffer.remaining();
        int iZza = iRemaining / (this.zzb * zzcrVar.zza());
        zzcrVar.zzj(iZza);
        zzcrVar.zzn(byteBuffer, iRemaining);
        this.zzj += iZza;
        zzp();
    }

    public final void zzc(ByteBuffer byteBuffer) {
        zzgtj.zzi(this.zzk >= 0);
        int i3 = this.zzb;
        int iRemaining = byteBuffer.remaining();
        zzcr zzcrVar = this.zzi;
        int iMin = Math.min(iRemaining / (zzcrVar.zza() * i3), this.zzk);
        zzcrVar.zzo(byteBuffer, iMin);
        this.zzk -= iMin;
        System.arraycopy(zzcrVar.zzq(), iMin * i3, zzcrVar.zzq(), 0, this.zzk * i3);
    }

    public final void zzd() {
        int i3 = this.zzj;
        int i4 = this.zzo;
        int i5 = this.zzk;
        float f3 = this.zzc;
        float f4 = this.zzd;
        int i6 = i5 + ((int) ((((((((double) (i3 - i4)) / ((double) (f3 / f4))) + ((double) i4)) + this.zzq) + ((double) this.zzl)) / ((double) (this.zze * f4))) + 0.5d));
        this.zzq = 0.0d;
        int i7 = this.zzh;
        int i8 = i7 + i7;
        zzcr zzcrVar = this.zzi;
        zzcrVar.zzj(i3 + i8);
        zzcrVar.zzm(i3 * this.zzb, i8);
        this.zzj += i8;
        zzp();
        if (this.zzk > i6) {
            this.zzk = Math.max(i6, 0);
        }
        this.zzj = 0;
        this.zzo = 0;
        this.zzl = 0;
    }

    public final void zze() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 0;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0.0d;
        this.zzi.zzg();
    }

    public final int zzf() {
        zzgtj.zzi(this.zzk >= 0);
        return this.zzk * this.zzb * this.zzi.zza();
    }

    final /* synthetic */ int zzg() {
        return this.zzb;
    }

    final /* synthetic */ int zzh() {
        return this.zzh;
    }

    final /* synthetic */ int zzi() {
        return this.zzj;
    }

    final /* synthetic */ int zzj() {
        return this.zzk;
    }

    final /* synthetic */ int zzk() {
        return this.zzl;
    }

    final /* synthetic */ int zzl() {
        return this.zzm;
    }

    final /* synthetic */ int zzm() {
        return this.zzn;
    }

    final /* synthetic */ int zzn() {
        return this.zzp;
    }
}
