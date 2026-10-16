package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzok implements Parcelable {
    public static final Parcelable.Creator<zzok> CREATOR = new zzoj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f78330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f78331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f78332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f78333d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f78334f;

    public zzok(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f78330a = z2;
        this.f78331b = z3;
        this.f78332c = z4;
        this.f78333d = z5;
        this.f78334f = z6;
    }

    public final boolean c() {
        return this.f78330a;
    }

    public final boolean d() {
        return this.f78331b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean e() {
        return this.f78332c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzok)) {
            return false;
        }
        zzok zzokVar = (zzok) obj;
        return this.f78330a == zzokVar.f78330a && this.f78331b == zzokVar.f78331b && this.f78332c == zzokVar.f78332c && this.f78333d == zzokVar.f78333d && this.f78334f == zzokVar.f78334f;
    }

    public final boolean f() {
        return this.f78333d;
    }

    public final boolean g() {
        return this.f78334f;
    }

    public final int hashCode() {
        return (((((((Boolean.hashCode(this.f78330a) * 31) + Boolean.hashCode(this.f78331b)) * 31) + Boolean.hashCode(this.f78332c)) * 31) + Boolean.hashCode(this.f78333d)) * 31) + Boolean.hashCode(this.f78334f);
    }

    public final String toString() {
        boolean z2 = this.f78330a;
        int length = String.valueOf(z2).length();
        boolean z3 = this.f78331b;
        int length2 = String.valueOf(z3).length();
        boolean z4 = this.f78332c;
        int length3 = String.valueOf(z4).length();
        boolean z5 = this.f78333d;
        int length4 = String.valueOf(z5).length();
        boolean z6 = this.f78334f;
        StringBuilder sb = new StringBuilder(length + 80 + length2 + 29 + length3 + 23 + length4 + 29 + String.valueOf(z6).length() + 1);
        sb.append("AutocompleteThemeCustomization(isCustomColorApplied=");
        sb.append(z2);
        sb.append(", isCustomTypographyApplied=");
        sb.append(z3);
        sb.append(", isCustomMeasurementApplied=");
        sb.append(z4);
        sb.append(", isCustomShapeApplied=");
        sb.append(z5);
        sb.append(", isCustomAttributionApplied=");
        sb.append(z6);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.f78330a ? 1 : 0);
        dest.writeInt(this.f78331b ? 1 : 0);
        dest.writeInt(this.f78332c ? 1 : 0);
        dest.writeInt(this.f78333d ? 1 : 0);
        dest.writeInt(this.f78334f ? 1 : 0);
    }

    public zzok() {
        this(false, false, false, false, false);
    }
}
