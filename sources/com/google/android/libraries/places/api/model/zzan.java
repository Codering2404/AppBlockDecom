package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzan extends LocalDate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f75082c;

    zzan(int i3, int i4, int i5) {
        this.f75080a = i3;
        this.f75081b = i4;
        this.f75082c = i5;
    }

    @Override // com.google.android.libraries.places.api.model.LocalDate
    public final int c() {
        return this.f75082c;
    }

    @Override // com.google.android.libraries.places.api.model.LocalDate
    public final int d() {
        return this.f75081b;
    }

    @Override // com.google.android.libraries.places.api.model.LocalDate
    public final int e() {
        return this.f75080a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LocalDate) {
            LocalDate localDate = (LocalDate) obj;
            if (this.f75080a == localDate.e() && this.f75081b == localDate.d() && this.f75082c == localDate.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f75080a ^ 1000003) * 1000003) ^ this.f75081b) * 1000003) ^ this.f75082c;
    }
}
