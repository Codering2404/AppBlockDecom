package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzicu extends zzicx {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    zzicu(byte[] bArr, int i3, int i4) {
        super(null);
        zzida.zzD(i3, i3 + i4, bArr.length);
        this.zzb = bArr;
        this.zzc = i3;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final byte zza(int i3) {
        return this.zzb[this.zzc + i3];
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzc(int i3, int i4) {
        int iZzD = zzida.zzD(i3, i4, this.zzd);
        return iZzD == 0 ? zzida.zza : new zzicu(this.zzb, this.zzc + i3, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzd(int i3, int i4) {
        int iZzD = zzida.zzD(i3, i4, this.zzd);
        return iZzD == 0 ? zzida.zza : new zzicu(this.zzb, this.zzc + i3, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final void zze(byte[] bArr, int i3, int i4, int i5) {
        System.arraycopy(this.zzb, this.zzc + i3, bArr, i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final ByteBuffer zzf() {
        return ByteBuffer.wrap(this.zzb, this.zzc, this.zzd).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final void zzg(zzicr zzicrVar) throws IOException {
        zzicrVar.zza(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final String zzh(Charset charset) {
        return new String(this.zzb, this.zzc, this.zzd, charset);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final boolean zzi() {
        byte[] bArr = this.zzb;
        int i3 = this.zzc;
        return zzihf.zzb(bArr, i3, this.zzd + i3);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final boolean zzj(zzida zzidaVar) {
        return ((zzidaVar instanceof zzicy) || (zzidaVar instanceof zzicu)) ? zzk(zzidaVar, 0, this.zzd) : zzidaVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzicx
    final boolean zzk(zzida zzidaVar, int i3, int i4) {
        if (i4 > zzidaVar.zzb()) {
            int i5 = this.zzd;
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 18 + String.valueOf(i5).length());
            sb.append("Length too large: ");
            sb.append(i4);
            sb.append(i5);
            throw new IllegalArgumentException(sb.toString());
        }
        int i6 = i3 + i4;
        if (i6 <= zzidaVar.zzb()) {
            if (zzidaVar instanceof zzicy) {
                return zzida.zzE(this.zzb, this.zzc, ((zzicy) zzidaVar).zzn(), i3, i4);
            }
            if (zzidaVar instanceof zzicu) {
                zzicu zzicuVar = (zzicu) zzidaVar;
                return zzida.zzE(this.zzb, this.zzc, zzicuVar.zzb, zzicuVar.zzc + i3, i4);
            }
            zzida zzidaVarZzd = zzidaVar.zzd(i3, i6);
            int i7 = this.zzc;
            return zzidaVarZzd.equals(zzd(i7, i4 + i7));
        }
        int iZzb = zzidaVar.zzb();
        int length = String.valueOf(i3).length();
        StringBuilder sb2 = new StringBuilder(length + 24 + String.valueOf(i4).length() + 2 + String.valueOf(iZzb).length());
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
        return zzier.zzb(i3, this.zzb, this.zzc + i4, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzide zzm() {
        return zzide.zzI(this.zzb, this.zzc, this.zzd, true);
    }

    final /* synthetic */ byte[] zzn() {
        return this.zzb;
    }

    final /* synthetic */ int zzo() {
        return this.zzc;
    }
}
