package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class DeviceOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceOrientation> CREATOR = new zzm();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f72891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f72892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f72893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f72894d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte f72895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f72896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final float f72897h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    DeviceOrientation(float[] fArr, float f3, float f4, long j3, byte b3, float f5, float f6) {
        z0(fArr);
        zzer.zza(f3 >= 0.0f && f3 < 360.0f);
        zzer.zza(f4 >= 0.0f && f4 <= 180.0f);
        zzer.zza(f6 >= 0.0f && f6 <= 180.0f);
        zzer.zza(j3 >= 0);
        this.f72891a = fArr;
        this.f72892b = f3;
        this.f72893c = f4;
        this.f72896g = f5;
        this.f72897h = f6;
        this.f72894d = j3;
        this.f72895f = (byte) (((byte) (((byte) (b3 | Ascii.DLE)) | 4)) | 8);
    }

    private static void z0(float[] fArr) {
        zzer.zzb(fArr != null && fArr.length == 4, "Input attitude array should be of length 4.");
        zzer.zzb((Float.isNaN(fArr[0]) || Float.isNaN(fArr[1]) || Float.isNaN(fArr[2]) || Float.isNaN(fArr[3])) ? false : true, "Input attitude cannot contain NaNs.");
    }

    public float[] M() {
        return (float[]) this.f72891a.clone();
    }

    public float N() {
        return this.f72897h;
    }

    public long O() {
        return this.f72894d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceOrientation)) {
            return false;
        }
        DeviceOrientation deviceOrientation = (DeviceOrientation) obj;
        return Float.compare(this.f72892b, deviceOrientation.f72892b) == 0 && Float.compare(this.f72893c, deviceOrientation.f72893c) == 0 && (zza() == deviceOrientation.zza() && (!zza() || Float.compare(this.f72896g, deviceOrientation.f72896g) == 0)) && (w0() == deviceOrientation.w0() && (!w0() || Float.compare(N(), deviceOrientation.N()) == 0)) && this.f72894d == deviceOrientation.f72894d && Arrays.equals(this.f72891a, deviceOrientation.f72891a);
    }

    public float g0() {
        return this.f72892b;
    }

    public int hashCode() {
        return Objects.c(Float.valueOf(this.f72892b), Float.valueOf(this.f72893c), Float.valueOf(this.f72897h), Long.valueOf(this.f72894d), this.f72891a, Byte.valueOf(this.f72895f));
    }

    public float j0() {
        return this.f72893c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeviceOrientation[");
        sb.append("attitude=");
        sb.append(Arrays.toString(this.f72891a));
        sb.append(", headingDegrees=");
        sb.append(this.f72892b);
        sb.append(", headingErrorDegrees=");
        sb.append(this.f72893c);
        if (w0()) {
            sb.append(", conservativeHeadingErrorDegrees=");
            sb.append(this.f72897h);
        }
        sb.append(", elapsedRealtimeNs=");
        sb.append(this.f72894d);
        sb.append(']');
        return sb.toString();
    }

    public boolean w0() {
        return (this.f72895f & 64) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.r(parcel, 1, M(), false);
        SafeParcelWriter.q(parcel, 4, g0());
        SafeParcelWriter.q(parcel, 5, j0());
        SafeParcelWriter.z(parcel, 6, O());
        SafeParcelWriter.k(parcel, 7, this.f72895f);
        SafeParcelWriter.q(parcel, 8, this.f72896g);
        SafeParcelWriter.q(parcel, 9, N());
        SafeParcelWriter.b(parcel, iA);
    }

    public final boolean zza() {
        return (this.f72895f & 32) != 0;
    }
}
