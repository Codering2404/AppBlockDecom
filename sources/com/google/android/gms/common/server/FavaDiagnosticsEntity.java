package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f72191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f72192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f72193c;

    public FavaDiagnosticsEntity(int i3, String str, int i4) {
        this.f72191a = i3;
        this.f72192b = str;
        this.f72193c = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f72191a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.f72192b, false);
        SafeParcelWriter.u(parcel, 3, this.f72193c);
        SafeParcelWriter.b(parcel, iA);
    }
}
