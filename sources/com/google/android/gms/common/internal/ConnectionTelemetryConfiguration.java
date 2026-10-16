package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RootTelemetryConfiguration f71967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f71969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f71970d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f71971f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f71972g;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z2, boolean z3, int[] iArr, int i3, int[] iArr2) {
        this.f71967a = rootTelemetryConfiguration;
        this.f71968b = z2;
        this.f71969c = z3;
        this.f71970d = iArr;
        this.f71971f = i3;
        this.f71972g = iArr2;
    }

    public int M() {
        return this.f71971f;
    }

    public int[] N() {
        return this.f71970d;
    }

    public int[] O() {
        return this.f71972g;
    }

    public boolean g0() {
        return this.f71968b;
    }

    public boolean j0() {
        return this.f71969c;
    }

    public final RootTelemetryConfiguration w0() {
        return this.f71967a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, this.f71967a, i3, false);
        SafeParcelWriter.g(parcel, 2, g0());
        SafeParcelWriter.g(parcel, 3, j0());
        SafeParcelWriter.v(parcel, 4, N(), false);
        SafeParcelWriter.u(parcel, 5, M());
        SafeParcelWriter.v(parcel, 6, O(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
