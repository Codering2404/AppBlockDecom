package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class StrokeStyle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StrokeStyle> CREATOR = new zzaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f73243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f73244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f73245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f73246d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final StampStyle f73247f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f73248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f73249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f73250c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f73251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private StampStyle f73252e;

        public Builder(StrokeStyle strokeStyle) {
            this.f73248a = strokeStyle.O();
            Pair pairG0 = strokeStyle.g0();
            this.f73249b = ((Integer) pairG0.first).intValue();
            this.f73250c = ((Integer) pairG0.second).intValue();
            this.f73251d = strokeStyle.N();
            this.f73252e = strokeStyle.M();
        }

        public StrokeStyle a() {
            return new StrokeStyle(this.f73248a, this.f73249b, this.f73250c, this.f73251d, this.f73252e);
        }

        public final Builder b(boolean z2) {
            this.f73251d = z2;
            return this;
        }

        public final Builder c(float f3) {
            this.f73248a = f3;
            return this;
        }
    }

    StrokeStyle(float f3, int i3, int i4, boolean z2, StampStyle stampStyle) {
        this.f73243a = f3;
        this.f73244b = i3;
        this.f73245c = i4;
        this.f73246d = z2;
        this.f73247f = stampStyle;
    }

    public StampStyle M() {
        return this.f73247f;
    }

    public boolean N() {
        return this.f73246d;
    }

    public final float O() {
        return this.f73243a;
    }

    public final Pair g0() {
        return new Pair(Integer.valueOf(this.f73244b), Integer.valueOf(this.f73245c));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.q(parcel, 2, this.f73243a);
        SafeParcelWriter.u(parcel, 3, this.f73244b);
        SafeParcelWriter.u(parcel, 4, this.f73245c);
        SafeParcelWriter.g(parcel, 5, N());
        SafeParcelWriter.E(parcel, 6, M(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
