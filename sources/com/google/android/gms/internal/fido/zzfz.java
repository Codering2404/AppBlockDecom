package com.google.android.gms.internal.fido;

import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfz extends zzfp {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    /* synthetic */ zzfz(MessageDigest messageDigest, int i3, zzfy zzfyVar) {
        this.zza = messageDigest;
        this.zzb = i3;
    }

    private final void zzd() {
        zzbm.zzf(!this.zzc, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override // com.google.android.gms.internal.fido.zzfp
    protected final void zzb(byte[] bArr, int i3, int i4) {
        zzd();
        this.zza.update(bArr, 0, i4);
    }

    @Override // com.google.android.gms.internal.fido.zzfv
    public final zzft zzc() {
        zzd();
        this.zzc = true;
        int i3 = this.zzb;
        if (i3 == this.zza.getDigestLength()) {
            byte[] bArrDigest = this.zza.digest();
            int i4 = zzft.zzb;
            return new zzfs(bArrDigest);
        }
        byte[] bArrCopyOf = Arrays.copyOf(this.zza.digest(), i3);
        int i5 = zzft.zzb;
        return new zzfs(bArrCopyOf);
    }
}
