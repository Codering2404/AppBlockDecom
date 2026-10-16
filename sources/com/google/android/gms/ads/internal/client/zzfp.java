package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfp> CREATOR = new zzfq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f69947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zzm f69949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f69950d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f69951f;

    public zzfp(String str, int i3, zzm zzmVar, int i4, boolean z2) {
        this.f69947a = str;
        this.f69948b = i3;
        this.f69949c = zzmVar;
        this.f69950d = i4;
        this.f69951f = z2;
    }

    public final zzfp M(int i3) {
        if (i3 <= 0) {
            i3 = this.f69950d;
        }
        zzm zzmVar = this.f69949c;
        int i4 = this.f69948b;
        return new zzfp(this.f69947a, i4, zzmVar, i3, this.f69951f);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfp) {
            zzfp zzfpVar = (zzfp) obj;
            if (this.f69947a.equals(zzfpVar.f69947a) && this.f69948b == zzfpVar.f69948b && this.f69949c.M(zzfpVar.f69949c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f69947a, Integer.valueOf(this.f69948b), this.f69949c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.f69947a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.u(parcel, 2, this.f69948b);
        SafeParcelWriter.E(parcel, 3, this.f69949c, i3, false);
        SafeParcelWriter.u(parcel, 4, this.f69950d);
        SafeParcelWriter.g(parcel, 5, this.f69951f);
        SafeParcelWriter.b(parcel, iA);
    }
}
