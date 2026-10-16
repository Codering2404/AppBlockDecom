package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzle implements Iterable, Serializable {
    public static final zzle zzb = new zzlc(zznl.zzb);
    private int zza = 0;

    static {
        int i3 = zzks.zza;
    }

    zzle() {
    }

    static int zzi(int i3, int i4, int i5) {
        int i6 = i4 - i3;
        if ((i3 | i4 | i6 | (i5 - i4)) >= 0) {
            return i6;
        }
        if (i3 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i3 + " < 0");
        }
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i3 + ", " + i4);
        }
        throw new IndexOutOfBoundsException("End index: " + i4 + " >= " + i5);
    }

    public static zzle zzk(byte[] bArr, int i3, int i4) {
        zzi(i3, i3 + i4, bArr.length);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return new zzlc(bArr2);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzf = this.zza;
        if (iZzf == 0) {
            int iZzd = zzd();
            iZzf = zzf(iZzd, 0, iZzd);
            if (iZzf == 0) {
                iZzf = 1;
            }
            this.zza = iZzf;
        }
        return iZzf;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzkx(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzpg.zza(this) : zzpg.zza(zzg(0, 47)).concat("..."));
    }

    public abstract byte zza(int i3);

    abstract byte zzb(int i3);

    public abstract int zzd();

    protected abstract void zze(byte[] bArr, int i3, int i4, int i5);

    protected abstract int zzf(int i3, int i4, int i5);

    public abstract zzle zzg(int i3, int i4);

    abstract void zzh(zzkw zzkwVar) throws IOException;

    protected final int zzj() {
        return this.zza;
    }

    public final byte[] zzl() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zznl.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }
}
