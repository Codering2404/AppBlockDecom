package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f73386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f73387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zzpl f73388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f73389d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f73390f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f73391g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final zzbg f73392h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f73393i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zzbg f73394j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f73395k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final zzbg f73396l;

    zzah(zzah zzahVar) {
        Preconditions.m(zzahVar);
        this.f73386a = zzahVar.f73386a;
        this.f73387b = zzahVar.f73387b;
        this.f73388c = zzahVar.f73388c;
        this.f73389d = zzahVar.f73389d;
        this.f73390f = zzahVar.f73390f;
        this.f73391g = zzahVar.f73391g;
        this.f73392h = zzahVar.f73392h;
        this.f73393i = zzahVar.f73393i;
        this.f73394j = zzahVar.f73394j;
        this.f73395k = zzahVar.f73395k;
        this.f73396l = zzahVar.f73396l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, this.f73386a, false);
        SafeParcelWriter.G(parcel, 3, this.f73387b, false);
        SafeParcelWriter.E(parcel, 4, this.f73388c, i3, false);
        SafeParcelWriter.z(parcel, 5, this.f73389d);
        SafeParcelWriter.g(parcel, 6, this.f73390f);
        SafeParcelWriter.G(parcel, 7, this.f73391g, false);
        SafeParcelWriter.E(parcel, 8, this.f73392h, i3, false);
        SafeParcelWriter.z(parcel, 9, this.f73393i);
        SafeParcelWriter.E(parcel, 10, this.f73394j, i3, false);
        SafeParcelWriter.z(parcel, 11, this.f73395k);
        SafeParcelWriter.E(parcel, 12, this.f73396l, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    zzah(String str, String str2, zzpl zzplVar, long j3, boolean z2, String str3, zzbg zzbgVar, long j4, zzbg zzbgVar2, long j5, zzbg zzbgVar3) {
        this.f73386a = str;
        this.f73387b = str2;
        this.f73388c = zzplVar;
        this.f73389d = j3;
        this.f73390f = z2;
        this.f73391g = str3;
        this.f73392h = zzbgVar;
        this.f73393i = j4;
        this.f73394j = zzbgVar2;
        this.f73395k = j5;
        this.f73396l = zzbgVar3;
    }
}
