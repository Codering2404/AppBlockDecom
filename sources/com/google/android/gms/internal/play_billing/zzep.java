package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzep extends zzes {
    private final byte[] zzb;
    private final int zzc;
    private final int zzd;

    zzep(byte[] bArr, int i3, int i4) {
        super(null);
        zzev.zzj(i3, i3 + i4, bArr.length);
        this.zzb = bArr;
        this.zzc = i3;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final byte zza(int i3) {
        int i4 = this.zzd;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return this.zzb[this.zzc + i3];
        }
        if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    final byte zzb(int i3) {
        return this.zzb[this.zzc + i3];
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    protected final int zzd(int i3, int i4, int i5) {
        return zzga.zzb(i3, this.zzb, this.zzc, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final int zze() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final zzev zzf(int i3, int i4) {
        int iZzj = zzev.zzj(i3, i4, this.zzd);
        return iZzj == 0 ? zzev.zza : new zzep(this.zzb, this.zzc + i3, iZzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    final void zzg(zzem zzemVar) throws IOException {
        ((zzez) zzemVar).zzc(this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    protected final boolean zzh(zzev zzevVar) {
        boolean z2 = zzevVar instanceof zzet;
        if (!z2 && !(zzevVar instanceof zzep)) {
            return zzevVar.zzh(this);
        }
        int i3 = this.zzd;
        if (i3 > zzevVar.zze()) {
            throw new IllegalArgumentException("Length too large: " + i3 + i3);
        }
        if (i3 > zzevVar.zze()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + i3 + ", " + zzevVar.zze());
        }
        if (z2) {
            return zzev.zzl(this.zzb, this.zzc, ((zzet) zzevVar).zzb, 0, i3);
        }
        if (zzevVar instanceof zzep) {
            zzep zzepVar = (zzep) zzevVar;
            return zzev.zzl(this.zzb, this.zzc, zzepVar.zzb, zzepVar.zzc, i3);
        }
        zzev zzevVarZzf = zzevVar.zzf(0, i3);
        int i4 = this.zzc;
        return zzevVarZzf.equals(zzf(i4, i3 + i4));
    }
}
