package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzek extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator<zzek> CREATOR = new zzel();
    private final String zza;
    private final long zzb;
    private final short zzc;
    private final double zzd;
    private final double zze;
    private final float zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;

    public zzek(String str, int i3, short s2, double d3, double d4, float f3, long j3, int i4, int i5) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: ".concat(String.valueOf(str)));
        }
        if (f3 <= 0.0f) {
            StringBuilder sb = new StringBuilder(String.valueOf(f3).length() + 16);
            sb.append("invalid radius: ");
            sb.append(f3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (d3 > 90.0d || d3 < -90.0d) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(d3).length() + 18);
            sb2.append("invalid latitude: ");
            sb2.append(d3);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (d4 > 180.0d || d4 < -180.0d) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(d4).length() + 19);
            sb3.append("invalid longitude: ");
            sb3.append(d4);
            throw new IllegalArgumentException(sb3.toString());
        }
        int i6 = i3 & 7;
        if (i6 == 0) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(i3).length() + 35);
            sb4.append("No supported transition specified: ");
            sb4.append(i3);
            throw new IllegalArgumentException(sb4.toString());
        }
        this.zzc = s2;
        this.zza = str;
        this.zzd = d3;
        this.zze = d4;
        this.zzf = f3;
        this.zzb = j3;
        this.zzg = i6;
        this.zzh = i4;
        this.zzi = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzek) {
            zzek zzekVar = (zzek) obj;
            if (this.zzf == zzekVar.zzf && this.zzd == zzekVar.zzd && this.zze == zzekVar.zze && this.zzc == zzekVar.zzc && this.zzg == zzekVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final long getExpirationTime() {
        return this.zzb;
    }

    public final double getLatitude() {
        return this.zzd;
    }

    public final int getLoiteringDelay() {
        return this.zzi;
    }

    public final double getLongitude() {
        return this.zze;
    }

    public final int getNotificationResponsiveness() {
        return this.zzh;
    }

    public final float getRadius() {
        return this.zzf;
    }

    @Override // com.google.android.gms.location.Geofence
    public final String getRequestId() {
        return this.zza;
    }

    public final int getTransitionTypes() {
        return this.zzg;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zzd);
        long j3 = jDoubleToLongBits ^ (jDoubleToLongBits >>> 32);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zze);
        return ((((((((((int) j3) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzf)) * 31) + this.zzc) * 31) + this.zzg;
    }

    public final String toString() {
        short s2 = this.zzc;
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", s2 != -1 ? s2 != 1 ? "UNKNOWN" : "CIRCLE" : "INVALID", this.zza.replaceAll("\\p{C}", "?"), Integer.valueOf(this.zzg), Double.valueOf(this.zzd), Double.valueOf(this.zze), Float.valueOf(this.zzf), Integer.valueOf(this.zzh / 1000), Integer.valueOf(this.zzi), Long.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 1, str, false);
        SafeParcelWriter.z(parcel, 2, this.zzb);
        SafeParcelWriter.F(parcel, 3, this.zzc);
        SafeParcelWriter.n(parcel, 4, this.zzd);
        SafeParcelWriter.n(parcel, 5, this.zze);
        SafeParcelWriter.q(parcel, 6, this.zzf);
        SafeParcelWriter.u(parcel, 7, this.zzg);
        SafeParcelWriter.u(parcel, 8, this.zzh);
        SafeParcelWriter.u(parcel, 9, this.zzi);
        SafeParcelWriter.b(parcel, iA);
    }
}
