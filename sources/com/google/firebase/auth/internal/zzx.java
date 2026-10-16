package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzx implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzx> CREATOR = new zzw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f88008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f88009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f88010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f88011d;

    public zzx(boolean z2) {
        this.f88011d = z2;
        this.f88009b = null;
        this.f88008a = null;
        this.f88010c = null;
    }

    public final String c() {
        return this.f88008a;
    }

    public final boolean d() {
        return this.f88011d;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, c(), false);
        SafeParcelWriter.G(parcel, 2, this.f88009b, false);
        SafeParcelWriter.g(parcel, 3, d());
        SafeParcelWriter.b(parcel, iA);
    }

    public zzx(String str, String str2, boolean z2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        this.f88008a = str;
        this.f88009b = str2;
        this.f88010c = zzbh.d(str2);
        this.f88011d = z2;
    }
}
