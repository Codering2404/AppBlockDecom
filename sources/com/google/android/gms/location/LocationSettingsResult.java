package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationSettingsResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzai();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Status f72975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LocationSettingsStates f72976b;

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f72975a = status;
        this.f72976b = locationSettingsStates;
    }

    public LocationSettingsStates M() {
        return this.f72976b;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f72975a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 1, getStatus(), i3, false);
        SafeParcelWriter.E(parcel, 2, M(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
