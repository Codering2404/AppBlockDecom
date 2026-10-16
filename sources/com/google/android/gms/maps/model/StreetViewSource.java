package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class StreetViewSource extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewSource> CREATOR = new zzy();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StreetViewSource f73240b = new StreetViewSource(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StreetViewSource f73241c = new StreetViewSource(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f73242a;

    public StreetViewSource(int i3) {
        this.f73242a = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StreetViewSource) && this.f73242a == ((StreetViewSource) obj).f73242a;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f73242a));
    }

    public String toString() {
        int i3 = this.f73242a;
        return String.format("StreetViewSource:%s", i3 != 0 ? i3 != 1 ? String.format("UNKNOWN(%s)", Integer.valueOf(i3)) : "OUTDOOR" : "DEFAULT");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f73242a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, i4);
        SafeParcelWriter.b(parcel, iA);
    }
}
