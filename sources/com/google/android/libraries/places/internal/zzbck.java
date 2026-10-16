package com.google.android.libraries.places.internal;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbck extends zzbcj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f75996c;

    zzbck(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.f75996c = bArr;
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final byte a(int i3) {
        return this.f75996c[i3];
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    final byte b(int i3) {
        return this.f75996c[i3];
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final int d() {
        return this.f75996c.length;
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final zzbcl e(int i3, int i4) {
        byte[] bArr = this.f75996c;
        int iO = zzbcl.o(0, i4, bArr.length);
        return iO == 0 ? zzbcl.f75997b : new zzbch(bArr, 0, iO);
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    final void f(zzbce zzbceVar) {
        byte[] bArr = this.f75996c;
        zzbceVar.a(bArr, 0, bArr.length);
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    protected final boolean g(zzbcl zzbclVar) {
        if (zzbclVar instanceof zzbck) {
            return Arrays.equals(this.f75996c, ((zzbck) zzbclVar).f75996c);
        }
        if (!(zzbclVar instanceof zzbch)) {
            return zzbclVar.g(this);
        }
        byte[] bArr = this.f75996c;
        int iD = zzbclVar.d();
        int length = bArr.length;
        if (length > iD) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 18 + String.valueOf(length).length());
            sb.append("Length too large: ");
            sb.append(length);
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length <= zzbclVar.d()) {
            zzbch zzbchVar = (zzbch) zzbclVar;
            return zzbcl.p(bArr, 0, zzbchVar.q(), zzbchVar.s(), length);
        }
        int iD2 = zzbclVar.d();
        StringBuilder sb2 = new StringBuilder(String.valueOf(length).length() + 27 + String.valueOf(iD2).length());
        sb2.append("Ran off end of other: 0, ");
        sb2.append(length);
        sb2.append(", ");
        sb2.append(iD2);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    protected final int h(int i3, int i4, int i5) {
        return zzbeb.b(i3, this.f75996c, 0, i5);
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final zzbco l() {
        byte[] bArr = this.f75996c;
        return zzbco.f(bArr, 0, bArr.length, true);
    }

    final /* synthetic */ byte[] q() {
        return this.f75996c;
    }
}
