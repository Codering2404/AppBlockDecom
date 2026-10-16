package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzfv;
import com.google.android.gms.ads.internal.util.client.zzo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class VideoController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f69700a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzea f69701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private VideoLifecycleCallbacks f69702c;

    public void a(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzfv zzfvVar;
        synchronized (this.f69700a) {
            this.f69702c = videoLifecycleCallbacks;
            zzea zzeaVar = this.f69701b;
            if (zzeaVar == null) {
                return;
            }
            if (videoLifecycleCallbacks == null) {
                zzfvVar = null;
            } else {
                try {
                    zzfvVar = new zzfv(videoLifecycleCallbacks);
                } catch (RemoteException e3) {
                    zzo.d("Unable to call setVideoLifecycleCallbacks on video controller.", e3);
                }
            }
            zzeaVar.zzl(zzfvVar);
        }
    }

    public final void b(zzea zzeaVar) {
        synchronized (this.f69700a) {
            try {
                this.f69701b = zzeaVar;
                VideoLifecycleCallbacks videoLifecycleCallbacks = this.f69702c;
                if (videoLifecycleCallbacks != null) {
                    a(videoLifecycleCallbacks);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzea c() {
        zzea zzeaVar;
        synchronized (this.f69700a) {
            zzeaVar = this.f69701b;
        }
        return zzeaVar;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }

        public void onVideoMute(boolean z2) {
        }
    }
}
