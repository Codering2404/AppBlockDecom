package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzee extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzee> CREATOR = new zzef();
    private final int zza;
    private final IBinder zzb;
    private final IBinder zzc;
    private final PendingIntent zzd;
    private final String zze;

    zzee(int i3, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str) {
        this.zza = i3;
        this.zzb = iBinder;
        this.zzc = iBinder2;
        this.zzd = pendingIntent;
        this.zze = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.os.IBinder, com.google.android.gms.location.zzz] */
    public static zzee zza(IInterface iInterface, com.google.android.gms.location.zzz zzzVar, String str) {
        if (iInterface == null) {
            iInterface = null;
        }
        return new zzee(1, iInterface, zzzVar, null, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.os.IBinder, com.google.android.gms.location.zzw] */
    public static zzee zzb(IInterface iInterface, com.google.android.gms.location.zzw zzwVar, String str) {
        if (iInterface == null) {
            iInterface = null;
        }
        return new zzee(2, iInterface, zzwVar, null, str);
    }

    public static zzee zzc(PendingIntent pendingIntent) {
        return new zzee(3, null, null, pendingIntent, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzee zzd(zzz zzzVar) {
        return new zzee(4, null, zzzVar, null, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i4 = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.t(parcel, 2, this.zzb, false);
        SafeParcelWriter.t(parcel, 3, this.zzc, false);
        SafeParcelWriter.E(parcel, 4, this.zzd, i3, false);
        SafeParcelWriter.G(parcel, 6, this.zze, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
