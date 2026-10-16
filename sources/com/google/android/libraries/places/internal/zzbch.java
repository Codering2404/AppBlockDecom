package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbch extends zzbcj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f75993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f75994d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f75995f;

    zzbch(byte[] bArr, int i3, int i4) {
        super(null);
        zzbcl.o(i3, i3 + i4, bArr.length);
        this.f75993c = bArr;
        this.f75994d = i3;
        this.f75995f = i4;
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final byte a(int i3) {
        int i4 = this.f75995f;
        if (((i4 - (i3 + 1)) | i3) >= 0) {
            return this.f75993c[this.f75994d + i3];
        }
        if (i3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i3);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 18 + String.valueOf(i4).length());
        sb2.append("Index > length: ");
        sb2.append(i3);
        sb2.append(", ");
        sb2.append(i4);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    final byte b(int i3) {
        return this.f75993c[this.f75994d + i3];
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final int d() {
        return this.f75995f;
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final zzbcl e(int i3, int i4) {
        int iO = zzbcl.o(i3, i4, this.f75995f);
        return iO == 0 ? zzbcl.f75997b : new zzbch(this.f75993c, this.f75994d + i3, iO);
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    final void f(zzbce zzbceVar) {
        zzbceVar.a(this.f75993c, this.f75994d, this.f75995f);
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    protected final boolean g(zzbcl zzbclVar) {
        boolean z2 = zzbclVar instanceof zzbck;
        if (!z2 && !(zzbclVar instanceof zzbch)) {
            return zzbclVar.g(this);
        }
        int i3 = this.f75995f;
        if (i3 > zzbclVar.d()) {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 18 + String.valueOf(i3).length());
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i3 <= zzbclVar.d()) {
            if (z2) {
                return zzbcl.p(this.f75993c, this.f75994d, ((zzbck) zzbclVar).q(), 0, i3);
            }
            if (zzbclVar instanceof zzbch) {
                zzbch zzbchVar = (zzbch) zzbclVar;
                return zzbcl.p(this.f75993c, this.f75994d, zzbchVar.f75993c, zzbchVar.f75994d, i3);
            }
            zzbcl zzbclVarE = zzbclVar.e(0, i3);
            int i4 = this.f75994d;
            return zzbclVarE.equals(e(i4, i3 + i4));
        }
        int iD = zzbclVar.d();
        StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 27 + String.valueOf(iD).length());
        sb2.append("Ran off end of other: 0, ");
        sb2.append(i3);
        sb2.append(", ");
        sb2.append(iD);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    protected final int h(int i3, int i4, int i5) {
        return zzbeb.b(i3, this.f75993c, this.f75994d, i5);
    }

    @Override // com.google.android.libraries.places.internal.zzbcl
    public final zzbco l() {
        throw null;
    }

    final /* synthetic */ byte[] q() {
        return this.f75993c;
    }

    final /* synthetic */ int s() {
        return this.f75994d;
    }
}
