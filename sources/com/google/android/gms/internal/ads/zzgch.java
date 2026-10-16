package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgch {
    private static zzgch zzb;
    final zzgci zza;

    private zzgch(Context context) {
        this.zza = zzgci.zza(context);
    }

    public static final zzgch zza(Context context) {
        zzgch zzgchVar;
        synchronized (zzgch.class) {
            try {
                if (zzb == null) {
                    zzb = new zzgch(context);
                }
                zzgchVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgchVar;
    }

    public final void zzb(boolean z2) throws IOException {
        synchronized (zzgch.class) {
            try {
                zzgci zzgciVar = this.zza;
                zzgciVar.zzb("paidv2_publisher_option", Boolean.valueOf(z2));
                if (!z2) {
                    zzgciVar.zzf("paidv2_creation_time");
                    zzgciVar.zzf("paidv2_id");
                    zzgciVar.zzf("vendor_scoped_gpid_v2_id");
                    zzgciVar.zzf("vendor_scoped_gpid_v2_creation_time");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc() {
        boolean zZze;
        synchronized (zzgch.class) {
            zZze = this.zza.zze("paidv2_publisher_option", true);
        }
        return zZze;
    }

    public final void zzd(boolean z2) throws IOException {
        synchronized (zzgch.class) {
            this.zza.zzb("paidv2_user_option", Boolean.valueOf(z2));
        }
    }

    public final boolean zze() {
        boolean zZze;
        synchronized (zzgch.class) {
            zZze = this.zza.zze("paidv2_user_option", true);
        }
        return zZze;
    }
}
