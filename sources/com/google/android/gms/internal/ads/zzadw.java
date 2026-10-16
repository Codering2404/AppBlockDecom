package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzadw {
    public static void zza(Surface surface, float f3) {
        try {
            surface.setFrameRate(f3, f3 == 0.0f ? 0 : 1);
        } catch (IllegalStateException e3) {
            zzeg.zzf("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e3);
        }
    }
}
