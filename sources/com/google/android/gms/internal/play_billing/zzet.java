package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzet extends zzes {
    private final byte[] zzb;

    zzet(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final byte zza(int i3) {
        return this.zzb[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    final byte zzb(int i3) {
        return this.zzb[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    protected final int zzd(int i3, int i4, int i5) {
        return zzga.zzb(i3, this.zzb, 0, i5);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final int zze() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    public final zzev zzf(int i3, int i4) {
        byte[] bArr = this.zzb;
        int iZzj = zzev.zzj(0, i4, bArr.length);
        return iZzj == 0 ? zzev.zza : new zzep(bArr, 0, iZzj);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    final void zzg(zzem zzemVar) throws IOException {
        byte[] bArr = this.zzb;
        ((zzez) zzemVar).zzc(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.play_billing.zzev
    protected final boolean zzh(zzev zzevVar) {
        boolean z2 = zzevVar instanceof zzet;
        if (z2) {
            return Arrays.equals(this.zzb, ((zzet) zzevVar).zzb);
        }
        boolean z3 = zzevVar instanceof zzep;
        if (!z3) {
            return zzevVar.zzh(this);
        }
        byte[] bArr = this.zzb;
        int iZze = zzevVar.zze();
        int length = bArr.length;
        if (length > iZze) {
            throw new IllegalArgumentException("Length too large: " + length + length);
        }
        if (length <= zzevVar.zze()) {
            if (z2) {
                return zzev.zzl(bArr, 0, ((zzet) zzevVar).zzb, 0, length);
            }
            if (!z3) {
                return zzevVar.zzf(0, length).equals(zzf(0, length));
            }
            zzep zzepVar = (zzep) zzevVar;
            return zzev.zzl(bArr, 0, zzepVar.zzb, zzepVar.zzc, length);
        }
        throw new IllegalArgumentException("Ran off end of other: 0, " + length + ", " + zzevVar.zze());
    }
}
