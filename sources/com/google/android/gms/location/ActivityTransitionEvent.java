package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f72864c;

    public ActivityTransitionEvent(int i3, int i4, long j3) {
        ActivityTransition.O(i4);
        this.f72862a = i3;
        this.f72863b = i4;
        this.f72864c = j3;
    }

    public int M() {
        return this.f72862a;
    }

    public long N() {
        return this.f72864c;
    }

    public int O() {
        return this.f72863b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f72862a == activityTransitionEvent.f72862a && this.f72863b == activityTransitionEvent.f72863b && this.f72864c == activityTransitionEvent.f72864c;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f72862a), Integer.valueOf(this.f72863b), Long.valueOf(this.f72864c));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i3 = this.f72862a;
        StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 13);
        sb2.append("ActivityType ");
        sb2.append(i3);
        sb.append(sb2.toString());
        sb.append(" ");
        int i4 = this.f72863b;
        StringBuilder sb3 = new StringBuilder(String.valueOf(i4).length() + 15);
        sb3.append("TransitionType ");
        sb3.append(i4);
        sb.append(sb3.toString());
        sb.append(" ");
        long j3 = this.f72864c;
        StringBuilder sb4 = new StringBuilder(String.valueOf(j3).length() + 21);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j3);
        sb.append(sb4.toString());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, M());
        SafeParcelWriter.u(parcel, 2, O());
        SafeParcelWriter.z(parcel, 3, N());
        SafeParcelWriter.b(parcel, iA);
    }
}
