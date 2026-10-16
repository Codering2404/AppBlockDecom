package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzat();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f73010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f73011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f73012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f73013d;

    public zzas(int i3, int i4, int i5, int i6) {
        Preconditions.r(i3 >= 0 && i3 <= 23, "Start hour must be in range [0, 23].");
        Preconditions.r(i4 >= 0 && i4 <= 59, "Start minute must be in range [0, 59].");
        Preconditions.r(i5 >= 0 && i5 <= 23, "End hour must be in range [0, 23].");
        Preconditions.r(i6 >= 0 && i6 <= 59, "End minute must be in range [0, 59].");
        Preconditions.r(((i3 + i4) + i5) + i6 > 0, "Parameters can't be all 0.");
        this.f73010a = i3;
        this.f73011b = i4;
        this.f73012c = i5;
        this.f73013d = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        zzas zzasVar = (zzas) obj;
        return this.f73010a == zzasVar.f73010a && this.f73011b == zzasVar.f73011b && this.f73012c == zzasVar.f73012c && this.f73013d == zzasVar.f73013d;
    }

    public final int hashCode() {
        return Objects.c(Integer.valueOf(this.f73010a), Integer.valueOf(this.f73011b), Integer.valueOf(this.f73012c), Integer.valueOf(this.f73013d));
    }

    public final String toString() {
        int i3 = this.f73010a;
        int length = String.valueOf(i3).length();
        int i4 = this.f73011b;
        int length2 = String.valueOf(i4).length();
        int i5 = this.f73012c;
        int length3 = String.valueOf(i5).length();
        int i6 = this.f73013d;
        StringBuilder sb = new StringBuilder(length + 50 + length2 + 10 + length3 + 12 + String.valueOf(i6).length() + 1);
        sb.append("UserPreferredSleepWindow [startHour=");
        sb.append(i3);
        sb.append(", startMinute=");
        sb.append(i4);
        sb.append(", endHour=");
        sb.append(i5);
        sb.append(", endMinute=");
        sb.append(i6);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int i4 = this.f73010a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, this.f73011b);
        SafeParcelWriter.u(parcel, 3, this.f73012c);
        SafeParcelWriter.u(parcel, 4, this.f73013d);
        SafeParcelWriter.b(parcel, iA);
    }
}
