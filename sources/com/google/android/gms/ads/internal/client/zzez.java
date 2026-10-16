package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzez extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzez> CREATOR = new zzfa();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f69931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f69932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f69933c;

    public zzez(int i3, int i4, String str) {
        this.f69931a = i3;
        this.f69932b = i4;
        this.f69933c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f69931a);
        SafeParcelWriter.u(parcel, 2, this.f69932b);
        SafeParcelWriter.G(parcel, 3, this.f69933c, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final int zza() {
        return this.f69932b;
    }

    public final String zzb() {
        return this.f69933c;
    }
}
