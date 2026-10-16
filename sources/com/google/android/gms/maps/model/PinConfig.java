package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class PinConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PinConfig> CREATOR = new zzo();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f73191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f73192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Glyph f73193c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Glyph extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Glyph> CREATOR = new zzf();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f73194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private BitmapDescriptor f73195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f73196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f73197d;

        Glyph(String str, IBinder iBinder, int i3, int i4) {
            this.f73196c = -5041134;
            this.f73197d = -16777216;
            this.f73194a = str;
            this.f73195b = iBinder == null ? null : new BitmapDescriptor(IObjectWrapper.Stub.x3(iBinder));
            this.f73196c = i3;
            this.f73197d = i4;
        }

        public int M() {
            return this.f73196c;
        }

        public String N() {
            return this.f73194a;
        }

        public int O() {
            return this.f73197d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Glyph)) {
                return false;
            }
            Glyph glyph = (Glyph) obj;
            if (this.f73196c != glyph.f73196c || !zzn.a(this.f73194a, glyph.f73194a) || this.f73197d != glyph.f73197d) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor = this.f73195b;
            if ((bitmapDescriptor == null && glyph.f73195b != null) || (bitmapDescriptor != null && glyph.f73195b == null)) {
                return false;
            }
            BitmapDescriptor bitmapDescriptor2 = glyph.f73195b;
            if (bitmapDescriptor == null || bitmapDescriptor2 == null) {
                return true;
            }
            return zzn.a(ObjectWrapper.h5(bitmapDescriptor.a()), ObjectWrapper.h5(bitmapDescriptor2.a()));
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.f73194a, this.f73195b, Integer.valueOf(this.f73196c)});
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.G(parcel, 2, N(), false);
            BitmapDescriptor bitmapDescriptor = this.f73195b;
            SafeParcelWriter.t(parcel, 3, bitmapDescriptor == null ? null : bitmapDescriptor.a().asBinder(), false);
            SafeParcelWriter.u(parcel, 4, M());
            SafeParcelWriter.u(parcel, 5, O());
            SafeParcelWriter.b(parcel, iA);
        }
    }

    PinConfig(int i3, int i4, Glyph glyph) {
        this.f73191a = i3;
        this.f73192b = i4;
        this.f73193c = glyph;
    }

    public int M() {
        return this.f73191a;
    }

    public int N() {
        return this.f73192b;
    }

    public Glyph O() {
        return this.f73193c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, M());
        SafeParcelWriter.u(parcel, 3, N());
        SafeParcelWriter.E(parcel, 4, O(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
