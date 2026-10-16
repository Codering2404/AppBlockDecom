package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class ActivityTransition extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new zze();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72861b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    ActivityTransition(int i3, int i4) {
        this.f72860a = i3;
        this.f72861b = i4;
    }

    public static void O(int i3) {
        boolean z2 = false;
        if (i3 >= 0 && i3 <= 1) {
            z2 = true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 30);
        sb.append("Transition type ");
        sb.append(i3);
        sb.append(" is not valid.");
        Preconditions.b(z2, sb.toString());
    }

    public int M() {
        return this.f72860a;
    }

    public int N() {
        return this.f72861b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f72860a == activityTransition.f72860a && this.f72861b == activityTransition.f72861b;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f72860a), Integer.valueOf(this.f72861b));
    }

    public String toString() {
        int i3 = this.f72860a;
        int length = String.valueOf(i3).length();
        int i4 = this.f72861b;
        StringBuilder sb = new StringBuilder(length + 52 + String.valueOf(i4).length() + 1);
        sb.append("ActivityTransition [mActivityType=");
        sb.append(i3);
        sb.append(", mTransitionType=");
        sb.append(i4);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, M());
        SafeParcelWriter.u(parcel, 2, N());
        SafeParcelWriter.b(parcel, iA);
    }
}
