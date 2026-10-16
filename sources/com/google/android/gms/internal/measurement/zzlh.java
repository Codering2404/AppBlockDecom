package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzlh implements Iterable, Serializable {
    public static final zzlh zzb = new zzlg(zzmp.zzb);
    private int zza = 0;

    static {
        int i3 = zzkv.zza;
    }

    zzlh() {
    }

    public static zzlh zzh(byte[] bArr, int i3, int i4) {
        zzj(i3, i3 + i4, bArr.length);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return new zzlg(bArr2);
    }

    static int zzj(int i3, int i4, int i5) {
        int i6 = i4 - i3;
        if ((i3 | i4 | i6 | (i5 - i4)) >= 0) {
            return i6;
        }
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i3);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i4 < i3) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 44 + String.valueOf(i4).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(i4);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i4).length() + 15 + String.valueOf(i5).length());
        sb3.append("End index: ");
        sb3.append(i4);
        sb3.append(" >= ");
        sb3.append(i5);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzg = this.zza;
        if (iZzg == 0) {
            int iZzc = zzc();
            iZzg = zzg(iZzc, 0, iZzc);
            if (iZzg == 0) {
                iZzg = 1;
            }
            this.zza = iZzg;
        }
        return iZzg;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzla(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzc()), zzc() <= 50 ? zzog.zza(this) : zzog.zza(zze(0, 47)).concat("..."));
    }

    public abstract byte zza(int i3);

    abstract byte zzb(int i3);

    public abstract int zzc();

    public abstract zzlh zze(int i3, int i4);

    abstract void zzf(zzkz zzkzVar) throws IOException;

    protected abstract int zzg(int i3, int i4, int i5);

    protected final int zzi() {
        return this.zza;
    }
}
