package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzoo> CREATOR = new zzop();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f74396a;

    zzoo(List list) {
        this.f74396a = list;
    }

    public static zzoo M(zzls... zzlsVarArr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlsVarArr[0].zza()));
        return new zzoo(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List list = this.f74396a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.w(parcel, 1, list, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
