package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzah();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f72971c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ArrayList f72972a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f72973b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f72974c = false;

        public Builder a(LocationRequest locationRequest) {
            if (locationRequest != null) {
                this.f72972a.add(locationRequest);
            }
            return this;
        }

        public LocationSettingsRequest b() {
            return new LocationSettingsRequest(this.f72972a, this.f72973b, this.f72974c);
        }
    }

    LocationSettingsRequest(List list, boolean z2, boolean z3) {
        this.f72969a = list;
        this.f72970b = z2;
        this.f72971c = z3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        List list = this.f72969a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, Collections.unmodifiableList(list), false);
        SafeParcelWriter.g(parcel, 2, this.f72970b);
        SafeParcelWriter.g(parcel, 3, this.f72971c);
        SafeParcelWriter.b(parcel, iA);
    }
}
