package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbzt> CREATOR = new zzbzu();
    public final View zza;
    public final Map zzb;

    public zzbzt(IBinder iBinder, IBinder iBinder2) {
        this.zza = (View) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder));
        this.zzb = (Map) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder2));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        View view = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.t(parcel, 1, ObjectWrapper.i5(view).asBinder(), false);
        SafeParcelWriter.t(parcel, 2, ObjectWrapper.i5(this.zzb).asBinder(), false);
        SafeParcelWriter.b(parcel, iA);
    }
}
