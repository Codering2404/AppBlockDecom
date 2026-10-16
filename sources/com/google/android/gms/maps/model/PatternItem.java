package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class PatternItem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PatternItem> CREATOR = new zzm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f73189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Float f73190b;

    public PatternItem(int i3, Float f3) {
        boolean z2 = true;
        if (i3 != 1 && (f3 == null || f3.floatValue() < 0.0f)) {
            z2 = false;
        }
        Preconditions.b(z2, "Invalid PatternItem: type=" + i3 + " length=" + f3);
        this.f73189a = i3;
        this.f73190b = f3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PatternItem)) {
            return false;
        }
        PatternItem patternItem = (PatternItem) obj;
        return this.f73189a == patternItem.f73189a && Objects.b(this.f73190b, patternItem.f73190b);
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f73189a), this.f73190b);
    }

    public String toString() {
        return "[PatternItem: type=" + this.f73189a + " length=" + this.f73190b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f73189a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, i4);
        SafeParcelWriter.s(parcel, 3, this.f73190b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
