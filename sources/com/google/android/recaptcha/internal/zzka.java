package com.google.android.recaptcha.internal;

import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzka extends zzjr {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    /* synthetic */ zzka(MessageDigest messageDigest, int i3, zzkb zzkbVar) {
        this.zza = messageDigest;
        this.zzb = i3;
    }

    private final void zzc() {
        zzjf.zze(!this.zzc, "Cannot re-use a Hasher after calling hash() on it");
    }

    @Override // com.google.android.recaptcha.internal.zzjr
    protected final void zza(byte[] bArr, int i3, int i4) {
        zzc();
        this.zza.update(bArr, 0, i4);
    }

    @Override // com.google.android.recaptcha.internal.zzjx
    public final zzjv zzb() {
        zzc();
        this.zzc = true;
        int i3 = this.zzb;
        if (i3 == this.zza.getDigestLength()) {
            byte[] bArrDigest = this.zza.digest();
            int i4 = zzjv.zzb;
            return new zzju(bArrDigest);
        }
        byte[] bArrCopyOf = Arrays.copyOf(this.zza.digest(), i3);
        int i5 = zzjv.zzb;
        return new zzju(bArrCopyOf);
    }
}
