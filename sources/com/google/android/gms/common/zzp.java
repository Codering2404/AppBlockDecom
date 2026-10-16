package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f72345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f72346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f72347d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f72348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f72349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f72350h;

    zzp(String str, boolean z2, boolean z3, IBinder iBinder, boolean z4, boolean z5, boolean z6) {
        this.f72344a = str;
        this.f72345b = z2;
        this.f72346c = z3;
        this.f72347d = (Context) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder));
        this.f72348f = z4;
        this.f72349g = z5;
        this.f72350h = z6;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f72344a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.g(parcel, 2, this.f72345b);
        SafeParcelWriter.g(parcel, 3, this.f72346c);
        SafeParcelWriter.t(parcel, 4, ObjectWrapper.i5(this.f72347d), false);
        SafeParcelWriter.g(parcel, 5, this.f72348f);
        SafeParcelWriter.g(parcel, 6, this.f72349g);
        SafeParcelWriter.g(parcel, 8, this.f72350h);
        SafeParcelWriter.b(parcel, iA);
    }
}
