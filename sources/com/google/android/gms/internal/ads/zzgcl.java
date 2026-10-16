package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgcl extends zzgcj {
    private static zzgcl zzd;

    private zzgcl(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzgcl zzh(Context context) {
        zzgcl zzgclVar;
        synchronized (zzgcl.class) {
            try {
                if (zzd == null) {
                    zzd = new zzgcl(context);
                }
                zzgclVar = zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgclVar;
    }

    public final zzgcg zzi(long j3, boolean z2) throws IOException {
        synchronized (zzgcl.class) {
            try {
                if (this.zzc.zzc()) {
                    return zza(null, null, j3, z2);
                }
                return new zzgcg();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzgcl.class) {
            try {
                if (zzg(false)) {
                    zzc(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
