package com.google.android.gms.internal.consent_sdk;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpm implements Iterable, Serializable {
    public static final zzpm zzb = new zzpk(zzqs.zzb);
    private int zza = 0;

    static {
        int i3 = zzpc.zza;
    }

    zzpm() {
    }

    static int zzi(int i3, int i4, int i5) {
        if (((i5 - 47) | 47) >= 0) {
            return 47;
        }
        throw new IndexOutOfBoundsException("End index: 47 >= " + i5);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzpm)) {
            return false;
        }
        zzpm zzpmVar = (zzpm) obj;
        int iZzd = zzd();
        if (iZzd != zzpmVar.zzd()) {
            return false;
        }
        if (iZzd == 0) {
            return true;
        }
        int i3 = this.zza;
        int i4 = zzpmVar.zza;
        if (i3 == 0 || i4 == 0 || i3 == i4) {
            return zzh(zzpmVar);
        }
        return false;
    }

    public final int hashCode() {
        int iZze = this.zza;
        if (iZze == 0) {
            int iZzd = zzd();
            iZze = zze(iZzd, 0, iZzd);
            if (iZze == 0) {
                iZze = 1;
            }
            this.zza = iZze;
        }
        return iZze;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzpf(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzd()), zzd() <= 50 ? zzsk.zza(this) : zzsk.zza(zzf(0, 47)).concat("..."));
    }

    public abstract byte zza(int i3);

    abstract byte zzb(int i3);

    public abstract int zzd();

    protected abstract int zze(int i3, int i4, int i5);

    public abstract zzpm zzf(int i3, int i4);

    abstract void zzg(zzpe zzpeVar) throws IOException;

    protected abstract boolean zzh(zzpm zzpmVar);
}
