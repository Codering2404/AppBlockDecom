package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zziby implements CharSequence {
    private char[] zza;
    private String zzb;

    private zziby() {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i3) {
        return this.zza[i3];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.zza.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i3, int i4) {
        return new String(this.zza, i3, i4 - i3);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.zzb == null) {
            this.zzb = new String(this.zza);
        }
        return this.zzb;
    }

    final void zza(char[] cArr) {
        this.zza = cArr;
        this.zzb = null;
    }

    /* synthetic */ zziby(byte[] bArr) {
    }
}
