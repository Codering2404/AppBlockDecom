package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zzc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f70947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final List f70948b;

    AccountChangeEventsResponse(int i3, List list) {
        this.f70947a = i3;
        this.f70948b = (List) Preconditions.m(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f70947a);
        SafeParcelWriter.K(parcel, 2, this.f70948b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
