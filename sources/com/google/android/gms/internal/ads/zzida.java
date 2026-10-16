package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzida implements Iterable<Byte>, Serializable {
    public static final zzida zza = new zzicy(zzier.zza);
    private int zzb = 0;

    static {
        int i3 = zzicn.zza;
    }

    zzida() {
    }

    public static zzicz zzC() {
        return new zzicz(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD);
    }

    static int zzD(int i3, int i4, int i5) {
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

    static /* synthetic */ boolean zzE(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        int i6 = i3 + i5;
        zzD(i3, i6, bArr.length);
        zzD(i4, i5 + i4, bArr2.length);
        while (i3 < i6) {
            if (bArr[i3] != bArr2[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    private static zzida zzk(Iterator it, int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException(String.format(Locale.ROOT, "length (%s) must be >= 1", Integer.valueOf(i3)));
        }
        if (i3 == 1) {
            return (zzida) it.next();
        }
        int i4 = i3 >>> 1;
        zzida zzidaVarZzk = zzk(it, i4);
        zzida zzidaVarZzk2 = zzk(it, i3 - i4);
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - zzidaVarZzk.zzb() >= zzidaVarZzk2.zzb()) {
            return zzigg.zzk(zzidaVarZzk, zzidaVarZzk2);
        }
        int iZzb = zzidaVarZzk.zzb();
        int iZzb2 = zzidaVarZzk2.zzb();
        StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 31 + String.valueOf(iZzb2).length());
        sb.append("ByteString would be too long: ");
        sb.append(iZzb);
        sb.append("+");
        sb.append(iZzb2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static zzida zzt(byte[] bArr, int i3, int i4) {
        try {
            return zzu(bArr, i3, i4, false);
        } catch (zziet e3) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e3);
        }
    }

    static zzida zzu(byte[] bArr, int i3, int i4, boolean z2) throws zziet {
        if (i4 == 0) {
            return zza;
        }
        zzD(i3, i3 + i4, bArr.length);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return new zzicy(bArr2);
    }

    static zzida zzv(byte[] bArr) {
        try {
            return zzw(bArr, false);
        } catch (zziet e3) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e3);
        }
    }

    static zzida zzw(byte[] bArr, boolean z2) throws zziet {
        return bArr.length == 0 ? zza : new zzicy(bArr);
    }

    public static zzida zzx(String str) {
        return str.isEmpty() ? zza : new zzicy(str.getBytes(StandardCharsets.UTF_8));
    }

    public static zzida zzy(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zza : zzk(iterable.iterator(), size);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzida)) {
            return false;
        }
        zzida zzidaVar = (zzida) obj;
        int iZzb = zzb();
        if (iZzb != zzidaVar.zzb()) {
            return false;
        }
        if (iZzb == 0) {
            return true;
        }
        int i3 = this.zzb;
        int i4 = zzidaVar.zzb;
        if (i3 == 0 || i4 == 0 || i3 == i4) {
            return zzj(zzidaVar);
        }
        return false;
    }

    public final int hashCode() {
        int iZzl = this.zzb;
        if (iZzl == 0) {
            int iZzb = zzb();
            iZzl = zzl(iZzb, 0, iZzb);
            if (iZzl == 0) {
                iZzl = 1;
            }
            this.zzb = iZzl;
        }
        return iZzl;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zzb()), zzb() <= 50 ? zzigp.zza(zzA()) : zzigp.zza(zzd(0, 47).zzA()).concat("..."));
    }

    public final byte[] zzA() {
        int iZzb = zzb();
        if (iZzb == 0) {
            return zzier.zza;
        }
        byte[] bArr = new byte[iZzb];
        zze(bArr, 0, 0, iZzb);
        return bArr;
    }

    public final String zzB(Charset charset) {
        return zzs() ? "" : zzh(charset);
    }

    abstract byte zza(int i3);

    public abstract int zzb();

    public abstract zzida zzc(int i3, int i4);

    public abstract zzida zzd(int i3, int i4);

    protected abstract void zze(byte[] bArr, int i3, int i4, int i5);

    public abstract ByteBuffer zzf();

    abstract void zzg(zzicr zzicrVar) throws IOException;

    protected abstract String zzh(Charset charset);

    public abstract boolean zzi();

    protected abstract boolean zzj(zzida zzidaVar);

    protected abstract int zzl(int i3, int i4, int i5);

    public abstract zzide zzm();

    protected abstract int zzp();

    protected abstract boolean zzq();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
    public zzicv iterator() {
        return new zzics(this);
    }

    public final boolean zzs() {
        return zzb() == 0;
    }

    @Deprecated
    public final void zzz(byte[] bArr, int i3, int i4, int i5) {
        zzD(0, i5, zzb());
        zzD(i4, i4 + i5, bArr.length);
        if (i5 > 0) {
            zze(bArr, 0, i4, i5);
        }
    }
}
