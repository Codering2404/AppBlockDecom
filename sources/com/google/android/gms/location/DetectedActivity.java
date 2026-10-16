package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class DetectedActivity extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f72890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Comparator f72888c = new zzk();
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzl();

    public DetectedActivity(int i3, int i4) {
        this.f72889a = i3;
        this.f72890b = i4;
    }

    public int M() {
        return this.f72890b;
    }

    public int N() {
        int i3 = this.f72889a;
        if (i3 > 22 || i3 < 0) {
            return 4;
        }
        return i3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f72889a == detectedActivity.f72889a && this.f72890b == detectedActivity.f72890b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(Integer.valueOf(this.f72889a), Integer.valueOf(this.f72890b));
    }

    public String toString() {
        int iN = N();
        String string = iN != 0 ? iN != 1 ? iN != 2 ? iN != 3 ? iN != 4 ? iN != 5 ? iN != 7 ? iN != 8 ? iN != 16 ? iN != 17 ? Integer.toString(iN) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE";
        int i3 = this.f72890b;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 36 + String.valueOf(i3).length() + 1);
        sb.append("DetectedActivity [type=");
        sb.append(string);
        sb.append(", confidence=");
        sb.append(i3);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f72889a);
        SafeParcelWriter.u(parcel, 2, this.f72890b);
        SafeParcelWriter.b(parcel, iA);
    }
}
