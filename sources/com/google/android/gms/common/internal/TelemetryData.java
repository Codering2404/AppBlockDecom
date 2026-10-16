package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new zaab();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f72024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f72025b;

    public TelemetryData(int i3, List list) {
        this.f72024a = i3;
        this.f72025b = list;
    }

    public final int M() {
        return this.f72024a;
    }

    public final List N() {
        return this.f72025b;
    }

    public final void O(MethodInvocation methodInvocation) {
        if (this.f72025b == null) {
            this.f72025b = new ArrayList();
        }
        this.f72025b.add(methodInvocation);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f72024a);
        SafeParcelWriter.K(parcel, 2, this.f72025b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
