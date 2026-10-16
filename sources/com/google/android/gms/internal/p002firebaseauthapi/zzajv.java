package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzajv implements Serializable, Iterable<Byte> {
    public static final zzajv zza = new zzakg(zzalh.zzb);
    private static final zzakc zzb = new zzakf();
    private int zzc = 0;

    static {
        new zzajx();
    }

    zzajv() {
    }

    static /* synthetic */ int zza(byte b3) {
        return b3 & 255;
    }

    static zzajv zzb(byte[] bArr) {
        return new zzakg(bArr);
    }

    static zzake zzc(int i3) {
        return new zzake(i3);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzb = this.zzc;
        if (iZzb == 0) {
            int iZzb2 = zzb();
            iZzb = zzb(iZzb2, 0, iZzb2);
            if (iZzb == 0) {
                iZzb = 1;
            }
            this.zzc = iZzb;
        }
        return iZzb;
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzajy(this);
    }

    public final String toString() {
        String strZza;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        Integer numValueOf = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            strZza = zzann.zza(this);
        } else {
            strZza = zzann.zza(zza(0, 47)) + "...";
        }
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", hexString, numValueOf, strZza);
    }

    public abstract byte zza(int i3);

    public abstract zzajv zza(int i3, int i4);

    abstract void zza(zzajw zzajwVar) throws IOException;

    protected abstract void zza(byte[] bArr, int i3, int i4, int i5);

    abstract byte zzb(int i3);

    public abstract int zzb();

    protected abstract int zzb(int i3, int i4, int i5);

    public abstract zzakh zzc();

    public final byte[] zzd() {
        int iZzb = zzb();
        if (iZzb == 0) {
            return zzalh.zzb;
        }
        byte[] bArr = new byte[iZzb];
        zza(bArr, 0, 0, iZzb);
        return bArr;
    }

    static int zza(int i3, int i4, int i5) {
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

    protected final int zza() {
        return this.zzc;
    }

    public static zzajv zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static zzajv zza(byte[] bArr, int i3, int i4) {
        zza(i3, i3 + i4, bArr.length);
        return new zzakg(zzb.zza(bArr, i3, i4));
    }

    public static zzajv zza(String str) {
        return new zzakg(str.getBytes(zzalh.zza));
    }
}
