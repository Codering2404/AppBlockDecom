package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.maps.zzao;
import com.google.android.gms.internal.maps.zzap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzah();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzap f73259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TileProvider f73260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f73261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f73262d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f73263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f73264g;

    public TileOverlayOptions() {
        this.f73261c = true;
        this.f73263f = true;
        this.f73264g = 0.0f;
    }

    public TileOverlayOptions J2(float f3) {
        this.f73262d = f3;
        return this;
    }

    public TileOverlayOptions M(boolean z2) {
        this.f73263f = z2;
        return this;
    }

    public boolean N() {
        return this.f73263f;
    }

    public float O() {
        return this.f73264g;
    }

    public float g0() {
        return this.f73262d;
    }

    public TileOverlayOptions h1(boolean z2) {
        this.f73261c = z2;
        return this;
    }

    public boolean j0() {
        return this.f73261c;
    }

    public TileOverlayOptions w0(TileProvider tileProvider) {
        this.f73260b = (TileProvider) Preconditions.n(tileProvider, "tileProvider must not be null.");
        this.f73259a = new zzag(this, tileProvider);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        zzap zzapVar = this.f73259a;
        SafeParcelWriter.t(parcel, 2, zzapVar == null ? null : zzapVar.asBinder(), false);
        SafeParcelWriter.g(parcel, 3, j0());
        SafeParcelWriter.q(parcel, 4, g0());
        SafeParcelWriter.g(parcel, 5, N());
        SafeParcelWriter.q(parcel, 6, O());
        SafeParcelWriter.b(parcel, iA);
    }

    public TileOverlayOptions z0(float f3) {
        boolean z2 = false;
        if (f3 >= 0.0f && f3 <= 1.0f) {
            z2 = true;
        }
        Preconditions.b(z2, "Transparency must be in the range [0..1]");
        this.f73264g = f3;
        return this;
    }

    TileOverlayOptions(IBinder iBinder, boolean z2, float f3, boolean z3, float f4) {
        this.f73261c = true;
        this.f73263f = true;
        this.f73264g = 0.0f;
        zzap zzapVarZzc = zzao.zzc(iBinder);
        this.f73259a = zzapVarZzc;
        this.f73260b = zzapVarZzc == null ? null : new zzaf(this);
        this.f73261c = z2;
        this.f73262d = f3;
        this.f73263f = z3;
        this.f73264g = f4;
    }
}
