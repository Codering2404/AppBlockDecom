package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadg extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzadf zzd;
    private boolean zze;

    /* synthetic */ zzadg(zzadf zzadfVar, SurfaceTexture surfaceTexture, boolean z2, byte[] bArr) {
        super(surfaceTexture);
        this.zzd = zzadfVar;
        this.zza = z2;
    }

    public static synchronized boolean zza(Context context) {
        if (!zzc) {
            try {
            } catch (zzdw e3) {
                zzeg.zze("PlaceholderSurface", "Failed to determine secure mode due to GL error: ".concat(String.valueOf(e3.getMessage())));
            }
            int i3 = zzdx.zza(context) ? zzdx.zzb() ? 1 : 2 : 0;
            zzb = i3;
            zzc = true;
        }
        return zzb != 0;
    }

    public static zzadg zzb(Context context, boolean z2) {
        boolean z3 = true;
        if (z2 && !zza(context)) {
            z3 = false;
        }
        zzgtj.zzi(z3);
        return new zzadf().zza(z2 ? zzb : 0);
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        zzadf zzadfVar = this.zzd;
        synchronized (zzadfVar) {
            try {
                if (!this.zze) {
                    zzadfVar.zzb();
                    this.zze = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
