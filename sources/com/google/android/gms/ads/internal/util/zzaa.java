package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.internal.ads.zzbiq;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaa {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile float f70202c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile long f70203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f70204e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f70205a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f70206b = 1.0f;

    public static float e(Context context) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpE)).booleanValue()) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                return 0.0f;
            }
            return g(audioManager);
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
        long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpF)).intValue();
        if (f70202c != -1.0f && jCurrentTimeMillis - f70203d < jIntValue) {
            return f70202c;
        }
        synchronized (f70204e) {
            try {
                long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.o().currentTimeMillis();
                if (f70202c != -1.0f && jCurrentTimeMillis2 - f70203d < jIntValue) {
                    return f70202c;
                }
                AudioManager audioManager2 = (AudioManager) context.getSystemService("audio");
                if (audioManager2 == null) {
                    f70202c = 0.0f;
                    f70203d = jCurrentTimeMillis2;
                    return 0.0f;
                }
                f70202c = g(audioManager2);
                f70203d = jCurrentTimeMillis2;
                return f70202c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final synchronized boolean f() {
        return this.f70206b >= 0.0f;
    }

    private static float g(AudioManager audioManager) {
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }

    public final synchronized void a(float f3) {
        this.f70206b = f3;
    }

    public final synchronized float b() {
        if (!f()) {
            return 1.0f;
        }
        return this.f70206b;
    }

    public final synchronized void c(boolean z2) {
        this.f70205a = z2;
    }

    public final synchronized boolean d() {
        return this.f70205a;
    }
}
