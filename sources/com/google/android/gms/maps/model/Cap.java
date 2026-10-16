package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class Cap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Cap> CREATOR = new zzb();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f73129d = "Cap";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f73130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BitmapDescriptor f73131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Float f73132c;

    protected Cap(int i3) {
        this(i3, (BitmapDescriptor) null, (Float) null);
    }

    final Cap M() {
        int i3 = this.f73130a;
        if (i3 == 0) {
            return new ButtCap();
        }
        if (i3 == 1) {
            return new SquareCap();
        }
        if (i3 == 2) {
            return new RoundCap();
        }
        if (i3 == 3) {
            Preconditions.r(this.f73131b != null, "bitmapDescriptor must not be null");
            Preconditions.r(this.f73132c != null, "bitmapRefWidth must not be null");
            return new CustomCap(this.f73131b, this.f73132c.floatValue());
        }
        Log.w(f73129d, "Unknown Cap type: " + i3);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return this.f73130a == cap.f73130a && Objects.b(this.f73131b, cap.f73131b) && Objects.b(this.f73132c, cap.f73132c);
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.f73130a), this.f73131b, this.f73132c);
    }

    public String toString() {
        return "[Cap: type=" + this.f73130a + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.f73130a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, i4);
        BitmapDescriptor bitmapDescriptor = this.f73131b;
        SafeParcelWriter.t(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.a().asBinder(), false);
        SafeParcelWriter.s(parcel, 4, this.f73132c, false);
        SafeParcelWriter.b(parcel, iA);
    }

    Cap(int i3, IBinder iBinder, Float f3) {
        this(i3, iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.x3(iBinder)), f3);
    }

    private Cap(int i3, BitmapDescriptor bitmapDescriptor, Float f3) {
        boolean z2 = f3 != null && f3.floatValue() > 0.0f;
        if (i3 == 3) {
            z = bitmapDescriptor != null && z2;
            i3 = 3;
        }
        Preconditions.b(z, String.format("Invalid Cap: type=%s bitmapDescriptor=%s bitmapRefWidth=%s", Integer.valueOf(i3), bitmapDescriptor, f3));
        this.f73130a = i3;
        this.f73131b = bitmapDescriptor;
        this.f73132c = f3;
    }

    protected Cap(BitmapDescriptor bitmapDescriptor, float f3) {
        this(3, bitmapDescriptor, Float.valueOf(f3));
    }
}
