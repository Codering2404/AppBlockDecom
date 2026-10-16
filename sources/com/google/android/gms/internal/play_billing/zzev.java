package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzev implements Iterable, Serializable {
    public static final zzev zza = new zzet(zzga.zzb);
    private int zzb = 0;

    static {
        int i3 = zzei.zza;
    }

    zzev() {
    }

    static int zzj(int i3, int i4, int i5) {
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

    public static zzev zzk(byte[] bArr, int i3, int i4) {
        try {
            zzj(i3, i3 + i4, bArr.length);
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i3, bArr2, 0, i4);
            return new zzet(bArr2);
        } catch (zzgc e3) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e3);
        }
    }

    static /* bridge */ /* synthetic */ boolean zzl(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        int i6 = i3 + i5;
        zzj(i3, i6, bArr.length);
        zzj(i4, i5 + i4, bArr2.length);
        while (i3 < i6) {
            if (bArr[i3] != bArr2[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzev)) {
            return false;
        }
        zzev zzevVar = (zzev) obj;
        int iZze = zze();
        if (iZze != zzevVar.zze()) {
            return false;
        }
        if (iZze == 0) {
            return true;
        }
        int i3 = this.zzb;
        int i4 = zzevVar.zzb;
        if (i3 == 0 || i4 == 0 || i3 == i4) {
            return zzh(zzevVar);
        }
        return false;
    }

    public final int hashCode() {
        int iZzd = this.zzb;
        if (iZzd == 0) {
            int iZze = zze();
            iZzd = zzd(iZze, 0, iZze);
            if (iZzd == 0) {
                iZzd = 1;
            }
            this.zzb = iZzd;
        }
        return iZzd;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzen(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zze()), zze() <= 50 ? zzhz.zza(this) : zzhz.zza(zzf(0, 47)).concat("..."));
    }

    public abstract byte zza(int i3);

    abstract byte zzb(int i3);

    protected abstract int zzd(int i3, int i4, int i5);

    public abstract int zze();

    public abstract zzev zzf(int i3, int i4);

    abstract void zzg(zzem zzemVar) throws IOException;

    protected abstract boolean zzh(zzev zzevVar);
}
