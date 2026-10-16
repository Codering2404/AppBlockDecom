package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class DeviceOrientationRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientationRequest> CREATOR = new zzn();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f72898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72899b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f72900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f72901b = false;

        public Builder(long j3) {
            b(j3);
        }

        public DeviceOrientationRequest a() {
            return new DeviceOrientationRequest(this.f72900a, this.f72901b);
        }

        public Builder b(long j3) {
            boolean z2 = false;
            if (j3 >= 0 && j3 < Long.MAX_VALUE) {
                z2 = true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 102);
            sb.append("Invalid interval: ");
            sb.append(j3);
            sb.append(" should be greater than or equal to 0. Note: Long.MAX_VALUE is not a valid interval.");
            zzer.zzb(z2, sb.toString());
            this.f72900a = j3;
            return this;
        }
    }

    DeviceOrientationRequest(long j3, boolean z2) {
        this.f72898a = j3;
        this.f72899b = z2;
    }

    public long M() {
        return this.f72898a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOrientationRequest)) {
            return false;
        }
        DeviceOrientationRequest deviceOrientationRequest = (DeviceOrientationRequest) obj;
        return this.f72898a == deviceOrientationRequest.f72898a && this.f72899b == deviceOrientationRequest.f72899b;
    }

    public int hashCode() {
        return Objects.c(Long.valueOf(this.f72898a), Boolean.valueOf(this.f72899b));
    }

    public String toString() {
        long j3 = this.f72898a;
        int length = String.valueOf(j3).length();
        String str = true != this.f72899b ? "" : ", withVelocity";
        StringBuilder sb = new StringBuilder(length + 46 + str.length() + 1);
        sb.append("DeviceOrientationRequest[samplingPeriodMicros=");
        sb.append(j3);
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 2, M());
        SafeParcelWriter.g(parcel, 6, this.f72899b);
        SafeParcelWriter.b(parcel, iA);
    }
}
