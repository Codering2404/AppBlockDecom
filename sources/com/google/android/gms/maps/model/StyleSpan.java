package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class StyleSpan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StyleSpan> CREATOR = new zzab();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StrokeStyle f73253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f73254b;

    public StyleSpan(StrokeStyle strokeStyle, double d3) {
        if (d3 <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.f73253a = strokeStyle;
        this.f73254b = d3;
    }

    public double M() {
        return this.f73254b;
    }

    public StrokeStyle N() {
        return this.f73253a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, N(), i3, false);
        SafeParcelWriter.n(parcel, 3, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
