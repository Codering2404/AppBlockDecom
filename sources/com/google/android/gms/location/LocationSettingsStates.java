package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzaj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f72977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f72979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f72980d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f72981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f72982g;

    public LocationSettingsStates(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f72977a = z2;
        this.f72978b = z3;
        this.f72979c = z4;
        this.f72980d = z5;
        this.f72981f = z6;
        this.f72982g = z7;
    }

    public boolean M() {
        return this.f72982g;
    }

    public boolean N() {
        return this.f72979c;
    }

    public boolean O() {
        return this.f72980d;
    }

    public boolean g0() {
        return this.f72977a;
    }

    public boolean j0() {
        return this.f72981f;
    }

    public boolean w0() {
        return this.f72978b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, g0());
        SafeParcelWriter.g(parcel, 2, w0());
        SafeParcelWriter.g(parcel, 3, N());
        SafeParcelWriter.g(parcel, 4, O());
        SafeParcelWriter.g(parcel, 5, j0());
        SafeParcelWriter.g(parcel, 6, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
