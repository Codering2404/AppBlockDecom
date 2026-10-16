package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class SleepSegmentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new zzaq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f72997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72998b;

    public SleepSegmentRequest(List list, int i3) {
        this.f72997a = list;
        this.f72998b = i3;
    }

    public int M() {
        return this.f72998b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        return Objects.b(this.f72997a, sleepSegmentRequest.f72997a) && this.f72998b == sleepSegmentRequest.f72998b;
    }

    public int hashCode() {
        return Objects.c(this.f72997a, Integer.valueOf(this.f72998b));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        List list = this.f72997a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, list, false);
        SafeParcelWriter.u(parcel, 2, M());
        SafeParcelWriter.b(parcel, iA);
    }
}
