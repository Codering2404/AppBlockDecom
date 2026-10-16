package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzap extends LocalTime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f75086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f75087b;

    zzap(int i3, int i4) {
        this.f75086a = i3;
        this.f75087b = i4;
    }

    @Override // com.google.android.libraries.places.api.model.LocalTime
    public final int c() {
        return this.f75086a;
    }

    @Override // com.google.android.libraries.places.api.model.LocalTime
    public final int d() {
        return this.f75087b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.f75086a == localTime.c() && this.f75087b == localTime.d()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f75086a ^ 1000003) * 1000003) ^ this.f75087b;
    }

    public final String toString() {
        int i3 = this.f75086a;
        int length = String.valueOf(i3).length();
        int i4 = this.f75087b;
        StringBuilder sb = new StringBuilder(length + 26 + String.valueOf(i4).length() + 1);
        sb.append("LocalTime{hours=");
        sb.append(i3);
        sb.append(", minutes=");
        sb.append(i4);
        sb.append("}");
        return sb.toString();
    }
}
