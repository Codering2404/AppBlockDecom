package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class SleepSegmentEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepSegmentEvent> CREATOR = new zzap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f72992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f72993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f72995d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f72996f;

    public SleepSegmentEvent(long j3, long j4, int i3, int i4, int i5) {
        Preconditions.b(j3 <= j4, "endTimeMillis must be greater than or equal to startTimeMillis");
        this.f72992a = j3;
        this.f72993b = j4;
        this.f72994c = i3;
        this.f72995d = i4;
        this.f72996f = i5;
    }

    public long M() {
        return this.f72993b;
    }

    public long N() {
        return this.f72992a;
    }

    public int O() {
        return this.f72994c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SleepSegmentEvent) {
            SleepSegmentEvent sleepSegmentEvent = (SleepSegmentEvent) obj;
            if (this.f72992a == sleepSegmentEvent.N() && this.f72993b == sleepSegmentEvent.M() && this.f72994c == sleepSegmentEvent.O() && this.f72995d == sleepSegmentEvent.f72995d && this.f72996f == sleepSegmentEvent.f72996f) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.c(Long.valueOf(this.f72992a), Long.valueOf(this.f72993b), Integer.valueOf(this.f72994c));
    }

    public String toString() {
        long j3 = this.f72992a;
        int length = String.valueOf(j3).length();
        long j4 = this.f72993b;
        int length2 = String.valueOf(j4).length();
        int i3 = this.f72994c;
        StringBuilder sb = new StringBuilder(length + 24 + length2 + 9 + String.valueOf(i3).length());
        sb.append("startMillis=");
        sb.append(j3);
        sb.append(", endMillis=");
        sb.append(j4);
        sb.append(", status=");
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.z(parcel, 1, N());
        SafeParcelWriter.z(parcel, 2, M());
        SafeParcelWriter.u(parcel, 3, O());
        SafeParcelWriter.u(parcel, 4, this.f72995d);
        SafeParcelWriter.u(parcel, 5, this.f72996f);
        SafeParcelWriter.b(parcel, iA);
    }
}
