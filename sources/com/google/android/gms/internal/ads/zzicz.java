package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzicz extends OutputStream {
    private static final byte[] zza = new byte[0];
    private int zzd;
    private int zzf;
    private final int zzb = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
    private final ArrayList zzc = new ArrayList();
    private byte[] zze = new byte[ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD];

    zzicz(int i3) {
    }

    private final void zzc(int i3) {
        this.zzc.add(new zzicy(this.zze));
        int length = this.zzd + this.zze.length;
        this.zzd = length;
        this.zze = new byte[Math.max(this.zzb, Math.max(i3, length >>> 1))];
        this.zzf = 0;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzb()));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i3) {
        try {
            if (this.zzf == this.zze.length) {
                zzc(1);
            }
            byte[] bArr = this.zze;
            int i4 = this.zzf;
            this.zzf = i4 + 1;
            bArr[i4] = (byte) i3;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzida zza() {
        try {
            int i3 = this.zzf;
            byte[] bArr = this.zze;
            if (i3 >= bArr.length) {
                this.zzc.add(new zzicy(this.zze));
                this.zze = zza;
            } else if (i3 > 0) {
                this.zzc.add(new zzicy(Arrays.copyOf(bArr, i3)));
            }
            this.zzd += this.zzf;
            this.zzf = 0;
        } catch (Throwable th) {
            throw th;
        }
        return zzida.zzy(this.zzc);
    }

    public final synchronized int zzb() {
        return this.zzd + this.zzf;
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = this.zze;
        int length = bArr2.length;
        int i5 = this.zzf;
        int i6 = length - i5;
        if (i4 <= i6) {
            System.arraycopy(bArr, i3, bArr2, i5, i4);
            this.zzf += i4;
            return;
        }
        System.arraycopy(bArr, i3, bArr2, i5, i6);
        int i7 = i4 - i6;
        zzc(i7);
        System.arraycopy(bArr, i3 + i6, this.zze, 0, i7);
        this.zzf = i7;
    }
}
