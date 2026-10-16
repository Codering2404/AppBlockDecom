package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f69852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f69853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zze f69854d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IBinder f69855f;

    public zze(int i3, String str, String str2, zze zzeVar, IBinder iBinder) {
        this.f69851a = i3;
        this.f69852b = str;
        this.f69853c = str2;
        this.f69854d = zzeVar;
        this.f69855f = iBinder;
    }

    public final AdError M() {
        AdError adError;
        zze zzeVar = this.f69854d;
        if (zzeVar == null) {
            adError = null;
        } else {
            String str = zzeVar.f69853c;
            adError = new AdError(zzeVar.f69851a, zzeVar.f69852b, str);
        }
        return new AdError(this.f69851a, this.f69852b, this.f69853c, adError);
    }

    public final LoadAdError N() {
        AdError adError;
        zze zzeVar = this.f69854d;
        zzdx zzdvVar = null;
        if (zzeVar == null) {
            adError = null;
        } else {
            adError = new AdError(zzeVar.f69851a, zzeVar.f69852b, zzeVar.f69853c);
        }
        int i3 = this.f69851a;
        String str = this.f69852b;
        String str2 = this.f69853c;
        IBinder iBinder = this.f69855f;
        if (iBinder != null) {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdvVar = iInterfaceQueryLocalInterface instanceof zzdx ? (zzdx) iInterfaceQueryLocalInterface : new zzdv(iBinder);
        }
        return new LoadAdError(i3, str, str2, adError, ResponseInfo.e(zzdvVar));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f69851a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, this.f69852b, false);
        SafeParcelWriter.G(parcel, 3, this.f69853c, false);
        SafeParcelWriter.E(parcel, 4, this.f69854d, i3, false);
        SafeParcelWriter.t(parcel, 5, this.f69855f, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
