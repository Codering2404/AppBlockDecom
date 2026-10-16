package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzud extends zzcp {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzfl.zzb;
    private int zzi;
    private long zzj;

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zza(long j3) {
        return Math.max(0L, j3 - zzfl.zzt(this.zze + this.zzd, this.zzb.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzd(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i3 = iLimit - iPosition;
        if (i3 == 0) {
            return;
        }
        int iMin = Math.min(i3, this.zzg);
        this.zzj += (long) (iMin / this.zzb.zze);
        this.zzg -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.zzg <= 0) {
            int i4 = i3 - iMin;
            int length = (this.zzi + i4) - this.zzh.length;
            ByteBuffer byteBufferZzk = zzk(length);
            int i5 = this.zzi;
            String str = zzfl.zza;
            int iMax = Math.max(0, Math.min(length, i5));
            byteBufferZzk.put(this.zzh, 0, iMax);
            int iMax2 = Math.max(0, Math.min(length - iMax, i4));
            byteBuffer.limit(byteBuffer.position() + iMax2);
            byteBufferZzk.put(byteBuffer);
            byteBuffer.limit(iLimit);
            int i6 = i4 - iMax2;
            int i7 = this.zzi - iMax;
            this.zzi = i7;
            byte[] bArr = this.zzh;
            System.arraycopy(bArr, iMax, bArr, 0, i7);
            byteBuffer.get(this.zzh, this.zzi, i6);
            this.zzi += i6;
            byteBufferZzk.flip();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzco
    public final ByteBuffer zzf() {
        int i3;
        if (super.zzg() && (i3 = this.zzi) > 0) {
            zzk(i3).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzco
    public final boolean zzg() {
        return super.zzg() && this.zzi == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl zzm(zzcl zzclVar) throws zzcn {
        if (!zzfl.zzD(zzclVar.zzd)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        this.zzf = true;
        return (this.zzd == 0 && this.zze == 0) ? zzcl.zza : zzclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final void zzn() {
        if (this.zzf) {
            int i3 = this.zzi;
            if (i3 > 0) {
                this.zzj += (long) (i3 / this.zzb.zze);
            }
            this.zzi = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final void zzo(zzcm zzcmVar) {
        if (this.zzf) {
            this.zzf = false;
            int i3 = this.zze;
            int i4 = this.zzb.zze;
            this.zzh = new byte[i3 * i4];
            this.zzg = this.zzd * i4;
        }
        this.zzi = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final void zzp() {
        this.zzh = zzfl.zzb;
    }

    public final void zzq(int i3, int i4) {
        this.zzd = i3;
        this.zze = i4;
    }

    public final void zzr() {
        this.zzj = 0L;
    }

    public final long zzs() {
        return this.zzj;
    }
}
