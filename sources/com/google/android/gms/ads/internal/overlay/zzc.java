package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f70074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f70075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f70076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f70077d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f70078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f70079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f70080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Intent f70081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final zzaa f70082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f70083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Bundle f70084l;

    public zzc(Intent intent, zzaa zzaaVar) {
        this(null, null, null, null, null, null, null, intent, ObjectWrapper.i5(zzaaVar).asBinder(), false, new Bundle());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f70074a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.G(parcel, 3, this.f70075b, false);
        SafeParcelWriter.G(parcel, 4, this.f70076c, false);
        SafeParcelWriter.G(parcel, 5, this.f70077d, false);
        SafeParcelWriter.G(parcel, 6, this.f70078f, false);
        SafeParcelWriter.G(parcel, 7, this.f70079g, false);
        SafeParcelWriter.G(parcel, 8, this.f70080h, false);
        SafeParcelWriter.E(parcel, 9, this.f70081i, i3, false);
        SafeParcelWriter.t(parcel, 10, ObjectWrapper.i5(this.f70082j).asBinder(), false);
        SafeParcelWriter.g(parcel, 11, this.f70083k);
        SafeParcelWriter.j(parcel, 12, this.f70084l, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent, IBinder iBinder, boolean z2, Bundle bundle) {
        this.f70074a = str;
        this.f70075b = str2;
        this.f70076c = str3;
        this.f70077d = str4;
        this.f70078f = str5;
        this.f70079g = str6;
        this.f70080h = str7;
        this.f70081i = intent;
        this.f70082j = (zzaa) ObjectWrapper.h5(IObjectWrapper.Stub.x3(iBinder));
        this.f70083k = z2;
        this.f70084l = bundle;
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, zzaa zzaaVar) {
        this(str, str2, str3, str4, str5, str6, str7, null, ObjectWrapper.i5(zzaaVar).asBinder(), false, new Bundle());
    }
}
