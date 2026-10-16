package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzvn {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(android.media.MediaCodecInfo.VideoCapabilities r2, int r3, int r4, double r5) {
        /*
            java.util.List r2 = androidx.media3.exoplayer.mediacodec.k.a(r2)
            r0 = 0
            if (r2 == 0) goto L4f
            boolean r1 = r2.isEmpty()
            if (r1 == 0) goto Le
            goto L4f
        Le:
            int r5 = (int) r5
            android.media.MediaCodecInfo$VideoCapabilities$PerformancePoint r3 = androidx.media3.exoplayer.mediacodec.n.a(r3, r4, r5)
            int r2 = zzc(r2, r3)
            r3 = 1
            if (r2 != r3) goto L4e
            java.lang.Boolean r4 = com.google.android.gms.internal.ads.zzvo.zzb()
            if (r4 != 0) goto L4e
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 37
            if (r4 < r5) goto L28
        L26:
            r3 = r0
            goto L3c
        L28:
            int r5 = zzb(r3)
            r6 = 35
            if (r4 < r6) goto L33
            if (r5 != r3) goto L26
            goto L3c
        L33:
            int r4 = zzb(r0)
            r6 = 2
            if (r4 != r6) goto L3c
            if (r5 != r3) goto L26
        L3c:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            com.google.android.gms.internal.ads.zzvo.zzc(r3)
            java.lang.Boolean r3 = com.google.android.gms.internal.ads.zzvo.zzb()
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L4e
            return r0
        L4e:
            return r2
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.zza(android.media.MediaCodecInfo$VideoCapabilities, int, int, double):int");
    }

    private static int zzb(boolean z2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List supportedPerformancePoints;
        try {
            zzt zztVar = new zzt();
            zztVar.zzo("video/avc");
            zzv zzvVarZzO = zztVar.zzO();
            if (zzvVarZzO.zzp != null) {
                List listZzc = zzwf.zzc(zzvv.zzb, zzvVarZzO, z2, false);
                for (int i3 = 0; i3 < listZzc.size(); i3++) {
                    if (((zzvm) listZzc.get(i3)).zzd != null && (videoCapabilities = ((zzvm) listZzc.get(i3)).zzd.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        androidx.media3.exoplayer.mediacodec.o.a();
                        return zzc(supportedPerformancePoints, androidx.media3.exoplayer.mediacodec.n.a(1280, 720, 60));
                    }
                }
            }
        } catch (zzvx unused) {
        }
        return 0;
    }

    private static int zzc(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (androidx.media3.exoplayer.mediacodec.l.a(list.get(i3)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
