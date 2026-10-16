package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzem extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzem> CREATOR = new zzen();
    private final List zza;
    private final PendingIntent zzb;
    private final String zzc;

    zzem(List list, PendingIntent pendingIntent, String str) {
        this.zza = list == null ? zzex.zzi() : zzex.zzj(list);
        this.zzb = pendingIntent;
        this.zzc = str;
    }

    public static zzem zza(List list) {
        Preconditions.n(list, "geofence can't be null.");
        Preconditions.b(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzem(list, null, "");
    }

    public static zzem zzb(PendingIntent pendingIntent) {
        Preconditions.n(pendingIntent, "PendingIntent can not be null.");
        return new zzem(null, pendingIntent, "");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List list = this.zza;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.I(parcel, 1, list, false);
        SafeParcelWriter.E(parcel, 2, this.zzb, i3, false);
        SafeParcelWriter.G(parcel, 3, this.zzc, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
