package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzag();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f72019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f72020d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f72021f;

    public RootTelemetryConfiguration(int i3, boolean z2, boolean z3, int i4, int i5) {
        this.f72017a = i3;
        this.f72018b = z2;
        this.f72019c = z3;
        this.f72020d = i4;
        this.f72021f = i5;
    }

    public int M() {
        return this.f72020d;
    }

    public int N() {
        return this.f72021f;
    }

    public boolean O() {
        return this.f72018b;
    }

    public int d1() {
        return this.f72017a;
    }

    public boolean g0() {
        return this.f72019c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, d1());
        SafeParcelWriter.g(parcel, 2, O());
        SafeParcelWriter.g(parcel, 3, g0());
        SafeParcelWriter.u(parcel, 4, M());
        SafeParcelWriter.u(parcel, 5, N());
        SafeParcelWriter.b(parcel, iA);
    }
}
