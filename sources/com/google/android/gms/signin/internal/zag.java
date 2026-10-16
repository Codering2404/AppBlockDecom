package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zah();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f74570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f74571b;

    public zag(List list, String str) {
        this.f74570a = list;
        this.f74571b = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f74571b != null ? Status.f71537g : Status.f71541k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List list = this.f74570a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.I(parcel, 1, list, false);
        SafeParcelWriter.G(parcel, 2, this.f74571b, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
