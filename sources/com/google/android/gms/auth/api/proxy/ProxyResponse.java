package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f71175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PendingIntent f71176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f71177c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f71178d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f71179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Bundle f71180g;

    ProxyResponse(int i3, int i4, PendingIntent pendingIntent, int i5, Bundle bundle, byte[] bArr) {
        this.f71179f = i3;
        this.f71175a = i4;
        this.f71177c = i5;
        this.f71180g = bundle;
        this.f71178d = bArr;
        this.f71176b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f71175a);
        SafeParcelWriter.E(parcel, 2, this.f71176b, i3, false);
        SafeParcelWriter.u(parcel, 3, this.f71177c);
        SafeParcelWriter.j(parcel, 4, this.f71180g, false);
        SafeParcelWriter.l(parcel, 5, this.f71178d, false);
        SafeParcelWriter.u(parcel, 1000, this.f71179f);
        SafeParcelWriter.b(parcel, iA);
    }
}
