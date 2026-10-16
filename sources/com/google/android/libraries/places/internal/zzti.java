package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzti extends zzut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f78586a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f78587b = 0;

    zzti() {
    }

    private final int f(zztv zztvVar) {
        for (int i3 = 0; i3 < this.f78587b; i3++) {
            if (this.f78586a[i3 + i3].equals(zztvVar)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzut
    public final int a() {
        return this.f78587b;
    }

    @Override // com.google.android.libraries.places.internal.zzut
    public final zztv b(int i3) {
        if (i3 < this.f78587b) {
            return (zztv) this.f78586a[i3 + i3];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.libraries.places.internal.zzut
    public final Object c(int i3) {
        if (i3 < this.f78587b) {
            return this.f78586a[i3 + i3 + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.libraries.places.internal.zzut
    public final Object d(zztv zztvVar) {
        int iF = f(zztvVar);
        if (iF != -1) {
            return zztvVar.e(this.f78586a[iF + iF + 1]);
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata{");
        for (int i3 = 0; i3 < this.f78587b; i3++) {
            sb.append(" '");
            sb.append(b(i3));
            sb.append("': ");
            sb.append(c(i3));
        }
        sb.append(" }");
        return sb.toString();
    }
}
