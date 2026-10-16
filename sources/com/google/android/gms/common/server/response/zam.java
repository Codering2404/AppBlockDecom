package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zak();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f72238b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final FastJsonResponse.Field f72239c;

    zam(int i3, String str, FastJsonResponse.Field field) {
        this.f72237a = i3;
        this.f72238b = str;
        this.f72239c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72237a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.f72238b, false);
        SafeParcelWriter.E(parcel, 3, this.f72239c, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    zam(String str, FastJsonResponse.Field field) {
        this.f72237a = 1;
        this.f72238b = str;
        this.f72239c = field;
    }
}
