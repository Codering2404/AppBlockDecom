package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpl> CREATOR = new zzpm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f74477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f74478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f74479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f74480d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f74481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f74482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Double f74483h;

    zzpl(int i3, String str, long j3, Long l3, Float f3, String str2, String str3, Double d3) {
        this.f74477a = i3;
        this.f74478b = str;
        this.f74479c = j3;
        this.f74480d = l3;
        this.f74483h = i3 == 1 ? f3 != null ? Double.valueOf(f3.doubleValue()) : null : d3;
        this.f74481f = str2;
        this.f74482g = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        zzpm.a(this, parcel, i3);
    }

    public final Object zza() {
        Long l3 = this.f74480d;
        if (l3 != null) {
            return l3;
        }
        Double d3 = this.f74483h;
        if (d3 != null) {
            return d3;
        }
        String str = this.f74481f;
        if (str != null) {
            return str;
        }
        return null;
    }

    zzpl(zzpn zzpnVar) {
        this(zzpnVar.f74486c, zzpnVar.f74487d, zzpnVar.f74488e, zzpnVar.f74485b);
    }

    zzpl(String str, long j3, Object obj, String str2) {
        Preconditions.g(str);
        this.f74477a = 2;
        this.f74478b = str;
        this.f74479c = j3;
        this.f74482g = str2;
        if (obj == null) {
            this.f74480d = null;
            this.f74483h = null;
            this.f74481f = null;
            return;
        }
        if (obj instanceof Long) {
            this.f74480d = (Long) obj;
            this.f74483h = null;
            this.f74481f = null;
        } else if (obj instanceof String) {
            this.f74480d = null;
            this.f74483h = null;
            this.f74481f = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f74480d = null;
                this.f74483h = (Double) obj;
                this.f74481f = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
