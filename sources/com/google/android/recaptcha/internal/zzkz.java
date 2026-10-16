package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzkz extends zzlc {
    private final int zzc;

    zzkz(byte[] bArr, int i3, int i4) {
        super(bArr);
        zzle.zzi(0, i4, bArr.length);
        this.zzc = i4;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final byte zza(int i3) {
        int i4 = this.zzc;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return ((zzlc) this).zza[i3];
        }
        if (i3 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i3);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i3 + ", " + i4);
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    final byte zzb(int i3) {
        return ((zzlc) this).zza[i3];
    }

    @Override // com.google.android.recaptcha.internal.zzlc
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.recaptcha.internal.zzlc, com.google.android.recaptcha.internal.zzle
    protected final void zze(byte[] bArr, int i3, int i4, int i5) {
        System.arraycopy(((zzlc) this).zza, 0, bArr, 0, i5);
    }
}
