package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfw> CREATOR = new zzfx();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f69956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f69957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f69958c;

    public zzfw(VideoOptions videoOptions) {
        this(videoOptions.c(), videoOptions.b(), videoOptions.a());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z2 = this.f69956a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 2, z2);
        SafeParcelWriter.g(parcel, 3, this.f69957b);
        SafeParcelWriter.g(parcel, 4, this.f69958c);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzfw(boolean z2, boolean z3, boolean z4) {
        this.f69956a = z2;
        this.f69957b = z3;
        this.f69958c = z4;
    }
}
