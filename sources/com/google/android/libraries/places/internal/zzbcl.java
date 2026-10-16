package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzbcl implements Iterable, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzbcl f75997b = new zzbck(zzbeb.f76092b);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f75998a = 0;

    static {
        int i3 = zzbcc.f75986a;
    }

    zzbcl() {
    }

    static zzbcl n(byte[] bArr, int i3, int i4, boolean z2) {
        o(i3, i3 + i4, bArr.length);
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return new zzbck(bArr2);
    }

    static int o(int i3, int i4, int i5) {
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

    static /* synthetic */ boolean p(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        int i6 = i3 + i5;
        o(i3, i6, bArr.length);
        o(i4, i5 + i4, bArr2.length);
        while (i3 < i6) {
            if (bArr[i3] != bArr2[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    public abstract byte a(int i3);

    abstract byte b(int i3);

    public abstract int d();

    public abstract zzbcl e(int i3, int i4);

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbcl)) {
            return false;
        }
        zzbcl zzbclVar = (zzbcl) obj;
        int iD = d();
        if (iD != zzbclVar.d()) {
            return false;
        }
        if (iD == 0) {
            return true;
        }
        int i3 = this.f75998a;
        int i4 = zzbclVar.f75998a;
        if (i3 == 0 || i4 == 0 || i3 == i4) {
            return g(zzbclVar);
        }
        return false;
    }

    abstract void f(zzbce zzbceVar);

    protected abstract boolean g(zzbcl zzbclVar);

    protected abstract int h(int i3, int i4, int i5);

    public final int hashCode() {
        int iH = this.f75998a;
        if (iH == 0) {
            int iD = d();
            iH = h(iD, 0, iD);
            if (iH == 0) {
                iH = 1;
            }
            this.f75998a = iH;
        }
        return iH;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzbcf(this);
    }

    public abstract zzbco l();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()), d() <= 50 ? zzbfu.a(this) : zzbfu.a(e(0, 47)).concat("..."));
    }
}
