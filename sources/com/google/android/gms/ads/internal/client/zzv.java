package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f70025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zze f70026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f70027d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f70028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f70029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f70030h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f70031i;

    public zzv(String str, long j3, zze zzeVar, Bundle bundle, String str2, String str3, String str4, String str5) {
        this.f70024a = str;
        this.f70025b = j3;
        this.f70026c = zzeVar;
        this.f70027d = bundle;
        this.f70028f = str2;
        this.f70029g = str3;
        this.f70030h = str4;
        this.f70031i = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f70024a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.z(parcel, 2, this.f70025b);
        SafeParcelWriter.E(parcel, 3, this.f70026c, i3, false);
        SafeParcelWriter.j(parcel, 4, this.f70027d, false);
        SafeParcelWriter.G(parcel, 5, this.f70028f, false);
        SafeParcelWriter.G(parcel, 6, this.f70029g, false);
        SafeParcelWriter.G(parcel, 7, this.f70030h, false);
        SafeParcelWriter.G(parcel, 8, this.f70031i, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
