package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzoq> CREATOR = new zzor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f74397a;

    zzoq(List list) {
        this.f74397a = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List list = this.f74397a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.K(parcel, 1, list, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
