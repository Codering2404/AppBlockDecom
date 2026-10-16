package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2$ControllerCallback;
import android.media.MediaRouter2$RouteCallback;
import android.media.RouteDiscoveryPreference;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundThreadStateHandler;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultSuitableOutputChecker;
import androidx.media3.exoplayer.SuitableOutputChecker;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class DefaultSuitableOutputChecker implements SuitableOutputChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SuitableOutputChecker f42944a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ImplApi23 implements SuitableOutputChecker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AudioManager f42945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AudioDeviceCallback f42946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private BackgroundThreadStateHandler f42947c;

        private ImplApi23() {
        }

        public static /* synthetic */ void e(ImplApi23 implApi23, Context context) {
            AudioManager audioManager;
            Assertions.e(implApi23.f42947c);
            if (Util.I0(context) && (audioManager = (AudioManager) context.getSystemService("audio")) != null) {
                implApi23.f42945a = audioManager;
                AudioDeviceCallback audioDeviceCallback = new AudioDeviceCallback() { // from class: androidx.media3.exoplayer.DefaultSuitableOutputChecker.ImplApi23.1
                    @Override // android.media.AudioDeviceCallback
                    public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                        ImplApi23.this.f42947c.f(Boolean.valueOf(ImplApi23.this.i()));
                    }

                    @Override // android.media.AudioDeviceCallback
                    public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                        ImplApi23.this.f42947c.f(Boolean.valueOf(ImplApi23.this.i()));
                    }
                };
                implApi23.f42946b = audioDeviceCallback;
                audioManager.registerAudioDeviceCallback(audioDeviceCallback, new Handler((Looper) Assertions.e(Looper.myLooper())));
                implApi23.f42947c.f(Boolean.valueOf(implApi23.i()));
            }
        }

        public static /* synthetic */ void f(ImplApi23 implApi23) {
            AudioManager audioManager = implApi23.f42945a;
            if (audioManager != null) {
                audioManager.unregisterAudioDeviceCallback((AudioDeviceCallback) Assertions.e(implApi23.f42946b));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i() {
            for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) Assertions.i(this.f42945a)).getDevices(2)) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 5 || audioDeviceInfo.getType() == 6 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    return true;
                }
                int i3 = Util.f41609a;
                if (i3 >= 26 && audioDeviceInfo.getType() == 22) {
                    return true;
                }
                if (i3 >= 28 && audioDeviceInfo.getType() == 23) {
                    return true;
                }
                if (i3 >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
                    return true;
                }
                if (i3 >= 33 && audioDeviceInfo.getType() == 30) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.media3.exoplayer.SuitableOutputChecker
        public boolean a() {
            BackgroundThreadStateHandler backgroundThreadStateHandler = this.f42947c;
            if (backgroundThreadStateHandler == null) {
                return true;
            }
            return ((Boolean) backgroundThreadStateHandler.d()).booleanValue();
        }

        @Override // androidx.media3.exoplayer.SuitableOutputChecker
        public void b(final SuitableOutputChecker.Callback callback, final Context context, Looper looper, Looper looper2, Clock clock) {
            BackgroundThreadStateHandler backgroundThreadStateHandler = new BackgroundThreadStateHandler(Boolean.TRUE, looper2, looper, clock, new BackgroundThreadStateHandler.StateChangeListener() { // from class: androidx.media3.exoplayer.g
                @Override // androidx.media3.common.util.BackgroundThreadStateHandler.StateChangeListener
                public final void a(Object obj, Object obj2) {
                    callback.a(((Boolean) obj2).booleanValue());
                }
            });
            this.f42947c = backgroundThreadStateHandler;
            backgroundThreadStateHandler.e(new Runnable() { // from class: androidx.media3.exoplayer.h
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSuitableOutputChecker.ImplApi23.e(this.f44131a, context);
                }
            });
        }

        @Override // androidx.media3.exoplayer.SuitableOutputChecker
        public void c() {
            ((BackgroundThreadStateHandler) Assertions.e(this.f42947c)).e(new Runnable() { // from class: androidx.media3.exoplayer.f
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSuitableOutputChecker.ImplApi23.f(this.f44118a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ImplApi35 implements SuitableOutputChecker {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final RouteDiscoveryPreference f42949e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediaRouter2 f42950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private MediaRouter2$RouteCallback f42951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MediaRouter2$ControllerCallback f42952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private BackgroundThreadStateHandler f42953d;

        static {
            j.a();
            f42949e = a0.a(ImmutableList.y(), false).build();
        }

        private ImplApi35() {
        }

        public static /* synthetic */ void d(ImplApi35 implApi35) {
            i.a(Assertions.e(implApi35.f42950a)).unregisterControllerCallback(k.a(Assertions.e(implApi35.f42952c)));
            implApi35.f42952c = null;
            implApi35.f42950a.unregisterRouteCallback(m.a(Assertions.e(implApi35.f42951b)));
        }

        public static /* synthetic */ void f(ImplApi35 implApi35, Context context) {
            Assertions.e(implApi35.f42953d);
            implApi35.f42950a = MediaRouter2.getInstance(context);
            implApi35.f42951b = new MediaRouter2$RouteCallback() { // from class: androidx.media3.exoplayer.DefaultSuitableOutputChecker.ImplApi35.1
            };
            final BackgroundThreadStateHandler backgroundThreadStateHandler = implApi35.f42953d;
            Objects.requireNonNull(backgroundThreadStateHandler);
            Executor executor = new Executor() { // from class: androidx.media3.exoplayer.e0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    backgroundThreadStateHandler.e(runnable);
                }
            };
            implApi35.f42950a.registerRouteCallback(executor, implApi35.f42951b, f42949e);
            MediaRouter2$ControllerCallback mediaRouter2$ControllerCallback = new MediaRouter2$ControllerCallback() { // from class: androidx.media3.exoplayer.DefaultSuitableOutputChecker.ImplApi35.2
                public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
                    ImplApi35.this.f42953d.f(Boolean.valueOf(ImplApi35.k(ImplApi35.this.f42950a)));
                }
            };
            implApi35.f42952c = mediaRouter2$ControllerCallback;
            implApi35.f42950a.registerControllerCallback(executor, mediaRouter2$ControllerCallback);
            implApi35.f42953d.f(Boolean.valueOf(k(implApi35.f42950a)));
        }

        private static boolean j(MediaRoute2Info mediaRoute2Info, int i3, boolean z2) {
            int suitabilityStatus = mediaRoute2Info.getSuitabilityStatus();
            return suitabilityStatus == 1 ? (i3 == 1 || i3 == 2) && z2 : suitabilityStatus == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean k(MediaRouter2 mediaRouter2) {
            int transferReason = i.a(Assertions.e(mediaRouter2)).getSystemController().getRoutingSessionInfo().getTransferReason();
            boolean zWasTransferInitiatedBySelf = mediaRouter2.getSystemController().wasTransferInitiatedBySelf();
            Iterator it = mediaRouter2.getSystemController().getSelectedRoutes().iterator();
            while (it.hasNext()) {
                if (j(x.a(it.next()), transferReason, zWasTransferInitiatedBySelf)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.media3.exoplayer.SuitableOutputChecker
        public boolean a() {
            BackgroundThreadStateHandler backgroundThreadStateHandler = this.f42953d;
            if (backgroundThreadStateHandler == null) {
                return true;
            }
            return ((Boolean) backgroundThreadStateHandler.d()).booleanValue();
        }

        @Override // androidx.media3.exoplayer.SuitableOutputChecker
        public void b(final SuitableOutputChecker.Callback callback, final Context context, Looper looper, Looper looper2, Clock clock) {
            BackgroundThreadStateHandler backgroundThreadStateHandler = new BackgroundThreadStateHandler(Boolean.TRUE, looper2, looper, clock, new BackgroundThreadStateHandler.StateChangeListener() { // from class: androidx.media3.exoplayer.c0
                @Override // androidx.media3.common.util.BackgroundThreadStateHandler.StateChangeListener
                public final void a(Object obj, Object obj2) {
                    callback.a(((Boolean) obj2).booleanValue());
                }
            });
            this.f42953d = backgroundThreadStateHandler;
            backgroundThreadStateHandler.e(new Runnable() { // from class: androidx.media3.exoplayer.d0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSuitableOutputChecker.ImplApi35.f(this.f43969a, context);
                }
            });
        }

        @Override // androidx.media3.exoplayer.SuitableOutputChecker
        public void c() {
            ((BackgroundThreadStateHandler) Assertions.i(this.f42953d)).e(new Runnable() { // from class: androidx.media3.exoplayer.b0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultSuitableOutputChecker.ImplApi35.d(this.f43958a);
                }
            });
        }
    }

    public DefaultSuitableOutputChecker() {
        int i3 = Util.f41609a;
        if (i3 >= 35) {
            this.f42944a = new ImplApi35();
        } else if (i3 >= 23) {
            this.f42944a = new ImplApi23();
        } else {
            this.f42944a = null;
        }
    }

    @Override // androidx.media3.exoplayer.SuitableOutputChecker
    public boolean a() {
        SuitableOutputChecker suitableOutputChecker = this.f42944a;
        return suitableOutputChecker == null || suitableOutputChecker.a();
    }

    @Override // androidx.media3.exoplayer.SuitableOutputChecker
    public void b(SuitableOutputChecker.Callback callback, Context context, Looper looper, Looper looper2, Clock clock) {
        SuitableOutputChecker suitableOutputChecker = this.f42944a;
        if (suitableOutputChecker != null) {
            suitableOutputChecker.b(callback, context, looper, looper2, clock);
        }
    }

    @Override // androidx.media3.exoplayer.SuitableOutputChecker
    public void c() {
        SuitableOutputChecker suitableOutputChecker = this.f42944a;
        if (suitableOutputChecker != null) {
            suitableOutputChecker.c();
        }
    }
}
