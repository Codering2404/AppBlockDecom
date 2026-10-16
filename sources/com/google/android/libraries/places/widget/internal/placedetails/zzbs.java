package com.google.android.libraries.places.widget.internal.placedetails;

import com.google.android.libraries.places.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f79278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f79279b;

    public zzbs(int i3, boolean z2) {
        this.f79278a = i3;
        this.f79279b = z2;
    }

    public final int a(int i3) {
        int i4 = this.f79278a;
        return i3 < i4 ? R.drawable.f74692h : i3 == i4 ? this.f79279b ? R.drawable.f74693i : R.drawable.f74691g : R.drawable.f74691g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbs)) {
            return false;
        }
        zzbs zzbsVar = (zzbs) obj;
        return this.f79278a == zzbsVar.f79278a && this.f79279b == zzbsVar.f79279b;
    }

    public final int hashCode() {
        return (Integer.hashCode(this.f79278a) * 31) + Boolean.hashCode(this.f79279b);
    }

    public final String toString() {
        int i3 = this.f79278a;
        int length = String.valueOf(i3).length();
        boolean z2 = this.f79279b;
        StringBuilder sb = new StringBuilder(length + 40 + String.valueOf(z2).length() + 1);
        sb.append("StarsModel(numWholeStars=");
        sb.append(i3);
        sb.append(", showHalfStar=");
        sb.append(z2);
        sb.append(")");
        return sb.toString();
    }
}
