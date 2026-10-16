package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class StampStyle extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StampStyle> CREATOR = new zzt();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final BitmapDescriptor f73226a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class Builder<T extends Builder<T>> {
    }

    StampStyle(IBinder iBinder) {
        this.f73226a = new BitmapDescriptor(IObjectWrapper.Stub.x3(iBinder));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        BitmapDescriptor bitmapDescriptor = this.f73226a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.t(parcel, 2, bitmapDescriptor.a().asBinder(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
