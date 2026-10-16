package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzicy extends zzicx {
    private final byte[] zzb;

    zzicy(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final byte zza(int i3) {
        return this.zzb[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzc(int i3, int i4) {
        byte[] bArr = this.zzb;
        int iZzD = zzida.zzD(i3, i4, bArr.length);
        return iZzD == 0 ? zzida.zza : new zzicu(bArr, i3, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzd(int i3, int i4) {
        byte[] bArr = this.zzb;
        int iZzD = zzida.zzD(i3, i4, bArr.length);
        return iZzD == 0 ? zzida.zza : new zzicu(bArr, i3, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final void zze(byte[] bArr, int i3, int i4, int i5) {
        System.arraycopy(this.zzb, i3, bArr, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final ByteBuffer zzf() {
        return ByteBuffer.wrap(this.zzb).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final void zzg(zzicr zzicrVar) throws IOException {
        byte[] bArr = this.zzb;
        zzicrVar.zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final String zzh(Charset charset) {
        return new String(this.zzb, charset);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final boolean zzi() {
        return zzihf.zza(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final boolean zzj(zzida zzidaVar) {
        return zzidaVar instanceof zzicy ? Arrays.equals(this.zzb, ((zzicy) zzidaVar).zzb) : zzidaVar instanceof zzicu ? zzk(zzidaVar, 0, this.zzb.length) : zzidaVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzicx
    final boolean zzk(zzida zzidaVar, int i3, int i4) {
        if (i4 > zzidaVar.zzb()) {
            byte[] bArr = this.zzb;
            int length = String.valueOf(i4).length();
            int length2 = bArr.length;
            StringBuilder sb = new StringBuilder(length + 18 + String.valueOf(length2).length());
            sb.append("Length too large: ");
            sb.append(i4);
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        int i5 = i3 + i4;
        if (i5 <= zzidaVar.zzb()) {
            if (zzidaVar instanceof zzicy) {
                return zzida.zzE(this.zzb, 0, ((zzicy) zzidaVar).zzb, i3, i4);
            }
            if (!(zzidaVar instanceof zzicu)) {
                return zzidaVar.zzd(i3, i5).equals(zzd(0, i4));
            }
            zzicu zzicuVar = (zzicu) zzidaVar;
            return zzida.zzE(this.zzb, 0, zzicuVar.zzn(), zzicuVar.zzo() + i3, i4);
        }
        int iZzb = zzidaVar.zzb();
        int length3 = String.valueOf(i3).length();
        StringBuilder sb2 = new StringBuilder(length3 + 24 + String.valueOf(i4).length() + 2 + String.valueOf(iZzb).length());
        sb2.append("Ran off end of other: ");
        sb2.append(i3);
        sb2.append(", ");
        sb2.append(i4);
        sb2.append(", ");
        sb2.append(iZzb);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final int zzl(int i3, int i4, int i5) {
        return zzier.zzb(i3, this.zzb, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzide zzm() {
        byte[] bArr = this.zzb;
        return zzide.zzI(bArr, 0, bArr.length, true);
    }

    final /* synthetic */ byte[] zzn() {
        return this.zzb;
    }
}
