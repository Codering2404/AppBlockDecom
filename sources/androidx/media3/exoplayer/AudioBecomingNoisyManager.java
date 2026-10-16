package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioBecomingNoisyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f42828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioBecomingNoisyReceiver f42829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HandlerWrapper f42830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f42831d;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class AudioBecomingNoisyReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EventListener f42832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final HandlerWrapper f42833b;

        public AudioBecomingNoisyReceiver(HandlerWrapper handlerWrapper, EventListener eventListener) {
            this.f42833b = handlerWrapper;
            this.f42832a = eventListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (AudioBecomingNoisyManager.this.f42831d) {
                this.f42832a.z();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f42833b.j(new Runnable() { // from class: androidx.media3.exoplayer.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f43961a.b();
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EventListener {
        void z();
    }

    public AudioBecomingNoisyManager(Context context, Looper looper, Looper looper2, EventListener eventListener, Clock clock) {
        this.f42828a = context.getApplicationContext();
        this.f42830c = clock.d(looper, null);
        this.f42829b = new AudioBecomingNoisyReceiver(clock.d(looper2, null), eventListener);
    }

    public void d(boolean z2) {
        if (z2 == this.f42831d) {
            return;
        }
        if (z2) {
            this.f42830c.j(new Runnable() { // from class: androidx.media3.exoplayer.a
                @Override // java.lang.Runnable
                public final void run() {
                    AudioBecomingNoisyManager audioBecomingNoisyManager = this.f43334a;
                    audioBecomingNoisyManager.f42828a.registerReceiver(audioBecomingNoisyManager.f42829b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
                }
            });
            this.f42831d = true;
        } else {
            this.f42830c.j(new Runnable() { // from class: androidx.media3.exoplayer.b
                @Override // java.lang.Runnable
                public final void run() {
                    AudioBecomingNoisyManager audioBecomingNoisyManager = this.f43957a;
                    audioBecomingNoisyManager.f42828a.unregisterReceiver(audioBecomingNoisyManager.f42829b);
                }
            });
            this.f42831d = false;
        }
    }
}
