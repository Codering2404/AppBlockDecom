package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzl extends zzfs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75372b;

    zzl(int i3, int i4) {
        this.f75371a = i3;
        this.f75372b = i4;
    }

    @Override // com.google.android.libraries.places.api.model.zzfs
    final int c() {
        return this.f75371a;
    }

    @Override // com.google.android.libraries.places.api.model.zzfs
    final int d() {
        return this.f75372b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfs) {
            zzfs zzfsVar = (zzfs) obj;
            if (this.f75371a == zzfsVar.c() && this.f75372b == zzfsVar.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f75371a ^ 1000003) * 1000003) ^ this.f75372b;
    }

    public final String toString() {
        int i3 = this.f75371a;
        int length = String.valueOf(i3).length();
        int i4 = this.f75372b;
        StringBuilder sb = new StringBuilder(length + 31 + String.valueOf(i4).length() + 1);
        sb.append("SubstringMatch{offset=");
        sb.append(i3);
        sb.append(", length=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }
}
