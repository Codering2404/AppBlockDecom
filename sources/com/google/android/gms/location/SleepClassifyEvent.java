package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class SleepClassifyEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepClassifyEvent> CREATOR = new zzao();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f72984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f72985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f72986d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f72987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f72988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f72989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f72990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f72991j;

    public SleepClassifyEvent(int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2, int i10) {
        this.f72983a = i3;
        this.f72984b = i4;
        this.f72985c = i5;
        this.f72986d = i6;
        this.f72987f = i7;
        this.f72988g = i8;
        this.f72989h = i9;
        this.f72990i = z2;
        this.f72991j = i10;
    }

    public int M() {
        return this.f72984b;
    }

    public int N() {
        return this.f72986d;
    }

    public int O() {
        return this.f72985c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepClassifyEvent)) {
            return false;
        }
        SleepClassifyEvent sleepClassifyEvent = (SleepClassifyEvent) obj;
        return this.f72983a == sleepClassifyEvent.f72983a && this.f72984b == sleepClassifyEvent.f72984b;
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f72983a), Integer.valueOf(this.f72984b));
    }

    public String toString() {
        int i3 = this.f72983a;
        int length = String.valueOf(i3).length();
        int i4 = this.f72984b;
        int length2 = String.valueOf(i4).length();
        int i5 = this.f72985c;
        int length3 = String.valueOf(i5).length();
        int i6 = this.f72986d;
        StringBuilder sb = new StringBuilder(length + 6 + length2 + 8 + length3 + 7 + String.valueOf(i6).length());
        sb.append(i3);
        sb.append(" Conf:");
        sb.append(i4);
        sb.append(" Motion:");
        sb.append(i5);
        sb.append(" Light:");
        sb.append(i6);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        Preconditions.m(parcel);
        int i4 = this.f72983a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.u(parcel, 2, M());
        SafeParcelWriter.u(parcel, 3, O());
        SafeParcelWriter.u(parcel, 4, N());
        SafeParcelWriter.u(parcel, 5, this.f72987f);
        SafeParcelWriter.u(parcel, 6, this.f72988g);
        SafeParcelWriter.u(parcel, 7, this.f72989h);
        SafeParcelWriter.g(parcel, 8, this.f72990i);
        SafeParcelWriter.u(parcel, 9, this.f72991j);
        SafeParcelWriter.b(parcel, iA);
    }
}
