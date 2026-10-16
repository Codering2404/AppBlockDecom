package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Looper;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundThreadStateHandler;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.StreamVolumeManager;
import com.google.common.base.Function;
import com.pairip.VMRunner;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class StreamVolumeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f43310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Listener f43311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BackgroundThreadStateHandler f43312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AudioManager f43313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private VolumeChangeReceiver f43314e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43315f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Listener {
        void E(int i3, boolean z2);

        void j(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StreamVolumeState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43317b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f43318c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f43319d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f43320e;

        public StreamVolumeState(int i3, int i4, boolean z2, int i5, int i6) {
            this.f43316a = i3;
            this.f43317b = i4;
            this.f43318c = z2;
            this.f43319d = i5;
            this.f43320e = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        public static /* synthetic */ void a(VolumeChangeReceiver volumeChangeReceiver) {
            if (StreamVolumeManager.this.f43314e == null) {
                return;
            }
            StreamVolumeManager.this.f43312c.f(StreamVolumeManager.this.h(((StreamVolumeState) StreamVolumeManager.this.f43312c.d()).f43316a));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VMRunner.invoke("2cf8WeOE918tC49D", new Object[]{this, context, intent});
        }
    }

    public StreamVolumeManager(Context context, Listener listener, final int i3, Looper looper, Looper looper2, Clock clock) {
        this.f43310a = context.getApplicationContext();
        this.f43311b = listener;
        BackgroundThreadStateHandler backgroundThreadStateHandler = new BackgroundThreadStateHandler(new StreamVolumeState(i3, 0, false, 0, 0), looper, looper2, clock, new BackgroundThreadStateHandler.StateChangeListener() { // from class: androidx.media3.exoplayer.q2
            @Override // androidx.media3.common.util.BackgroundThreadStateHandler.StateChangeListener
            public final void a(Object obj, Object obj2) {
                this.f44517a.m((StreamVolumeManager.StreamVolumeState) obj, (StreamVolumeManager.StreamVolumeState) obj2);
            }
        });
        this.f43312c = backgroundThreadStateHandler;
        backgroundThreadStateHandler.e(new Runnable() { // from class: androidx.media3.exoplayer.r2
            @Override // java.lang.Runnable
            public final void run() {
                StreamVolumeManager.d(this.f44520a, i3);
            }
        });
    }

    public static /* synthetic */ StreamVolumeState b(StreamVolumeManager streamVolumeManager, StreamVolumeState streamVolumeState) {
        VolumeChangeReceiver volumeChangeReceiver = streamVolumeManager.f43314e;
        if (volumeChangeReceiver != null) {
            try {
                streamVolumeManager.f43310a.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e3) {
                Log.j("StreamVolumeManager", "Error unregistering stream volume receiver", e3);
            }
            streamVolumeManager.f43314e = null;
        }
        return streamVolumeState;
    }

    public static /* synthetic */ void d(StreamVolumeManager streamVolumeManager, int i3) {
        streamVolumeManager.f43313d = (AudioManager) Assertions.i((AudioManager) streamVolumeManager.f43310a.getSystemService("audio"));
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            streamVolumeManager.f43310a.registerReceiver(volumeChangeReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            streamVolumeManager.f43314e = volumeChangeReceiver;
        } catch (RuntimeException e3) {
            Log.j("StreamVolumeManager", "Error registering stream volume receiver", e3);
        }
        streamVolumeManager.f43312c.f(streamVolumeManager.h(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StreamVolumeState h(int i3) {
        Assertions.e(this.f43313d);
        return new StreamVolumeState(i3, AudioManagerCompat.f(this.f43313d, i3), AudioManagerCompat.g(this.f43313d, i3), AudioManagerCompat.e(this.f43313d, i3), AudioManagerCompat.d(this.f43313d, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(StreamVolumeState streamVolumeState, StreamVolumeState streamVolumeState2) {
        boolean z2 = streamVolumeState.f43318c;
        if (!z2 && streamVolumeState2.f43318c) {
            this.f43315f = streamVolumeState.f43317b;
        }
        int i3 = streamVolumeState.f43317b;
        int i4 = streamVolumeState2.f43317b;
        if (i3 != i4 || z2 != streamVolumeState2.f43318c) {
            this.f43311b.E(i4, streamVolumeState2.f43318c);
        }
        int i5 = streamVolumeState.f43316a;
        int i6 = streamVolumeState2.f43316a;
        if (i5 == i6 && streamVolumeState.f43319d == streamVolumeState2.f43319d && streamVolumeState.f43320e == streamVolumeState2.f43320e) {
            return;
        }
        this.f43311b.j(i6);
    }

    public int i() {
        return ((StreamVolumeState) this.f43312c.d()).f43320e;
    }

    public int j() {
        return ((StreamVolumeState) this.f43312c.d()).f43319d;
    }

    public int k() {
        return ((StreamVolumeState) this.f43312c.d()).f43317b;
    }

    public boolean l() {
        return ((StreamVolumeState) this.f43312c.d()).f43318c;
    }

    public void n() {
        this.f43312c.g(new Function() { // from class: androidx.media3.exoplayer.o2
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.a((StreamVolumeManager.StreamVolumeState) obj);
            }
        }, new Function() { // from class: androidx.media3.exoplayer.p2
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return StreamVolumeManager.b(this.f44514a, (StreamVolumeManager.StreamVolumeState) obj);
            }
        });
    }

    public static /* synthetic */ StreamVolumeState a(StreamVolumeState streamVolumeState) {
        return streamVolumeState;
    }
}
