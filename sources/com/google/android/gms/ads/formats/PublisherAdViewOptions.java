package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcl;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f69734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcl f69735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IBinder f69736c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static final class Builder {
    }

    PublisherAdViewOptions(boolean z2, IBinder iBinder, IBinder iBinder2) {
        this.f69734a = z2;
        this.f69735b = iBinder != null ? zzck.zzd(iBinder) : null;
        this.f69736c = iBinder2;
    }

    public final zzcl M() {
        return this.f69735b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.f69734a);
        zzcl zzclVar = this.f69735b;
        SafeParcelWriter.t(parcel, 2, zzclVar == null ? null : zzclVar.asBinder(), false);
        SafeParcelWriter.t(parcel, 3, this.f69736c, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final boolean zza() {
        return this.f69734a;
    }
}
