package android.support.v4.media.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaControllerImpl f206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaSessionCompat.Token f207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet f208c = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class MediaControllerExtraData extends ComponentActivity.ExtraData {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface MediaControllerImpl {
        boolean a(KeyEvent keyEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaControllerImplApi21 implements MediaControllerImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Object f215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f216b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f217c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private HashMap f218d = new HashMap();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final MediaSessionCompat.Token f219e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private WeakReference f220a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f220a = new WeakReference(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f220a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f216b) {
                    mediaControllerImplApi21.f219e.g(IMediaSession.Stub.x3(BundleCompat.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.f219e.h(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerImplApi21.b();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback callback) {
                super(callback);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void f(List list) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void h() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void j1(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void k2(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void n(Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void y(CharSequence charSequence) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) throws RemoteException {
            this.f219e = token;
            Object objB = MediaControllerCompatApi21.b(context, token.f());
            this.f215a = objB;
            if (objB == null) {
                throw new RemoteException();
            }
            if (token.d() == null) {
                c();
            }
        }

        private void c() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean a(KeyEvent keyEvent) {
            return MediaControllerCompatApi21.a(this.f215a, keyEvent);
        }

        void b() {
            if (this.f219e.d() == null) {
                return;
            }
            for (Callback callback : this.f217c) {
                ExtraCallback extraCallback = new ExtraCallback(callback);
                this.f218d.put(callback, extraCallback);
                callback.f210b = extraCallback;
                try {
                    this.f219e.d().p2(extraCallback);
                    callback.m(13, null, null);
                } catch (RemoteException e3) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e3);
                }
            }
            this.f217c.clear();
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaControllerCompatApi21.c(this.f215a, str, bundle, resultReceiver);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaControllerImplBase implements MediaControllerImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IMediaSession f221a;

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean a(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f221a.b1(keyEvent);
                return false;
            } catch (RemoteException e3) {
                Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e3);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class PlaybackInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f225d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f226e;

        PlaybackInfo(int i3, int i4, int i5, int i6, int i7) {
            this.f222a = i3;
            this.f223b = i4;
            this.f224c = i5;
            this.f225d = i6;
            this.f226e = i7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class TransportControls {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransportControlsApi21 extends TransportControls {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransportControlsApi23 extends TransportControlsApi21 {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransportControlsApi24 extends TransportControlsApi23 {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TransportControlsBase extends TransportControls {
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.f207b = token;
        this.f206a = new MediaControllerImplApi24(context, token);
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f206a.a(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MessageHandler f209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        IMediaControllerCallback f210b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class MessageHandler extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            boolean f211a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Callback f212b;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f211a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            this.f212b.j((String) message.obj, data);
                            break;
                        case 2:
                            this.f212b.e((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            this.f212b.d((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            this.f212b.a((PlaybackInfo) message.obj);
                            break;
                        case 5:
                            this.f212b.f((List) message.obj);
                            break;
                        case 6:
                            this.f212b.g((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            this.f212b.c(bundle);
                            break;
                        case 8:
                            this.f212b.i();
                            break;
                        case 9:
                            this.f212b.h(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            this.f212b.b(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            this.f212b.l(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            this.f212b.k();
                            break;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class StubApi21 implements MediaControllerCompatApi21.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference f213a;

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void a(Object obj) {
                Callback callback = (Callback) this.f213a.get();
                if (callback != null) {
                    callback.d(MediaMetadataCompat.c(obj));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void b(Object obj) {
                Callback callback = (Callback) this.f213a.get();
                if (callback == null || callback.f210b != null) {
                    return;
                }
                callback.e(PlaybackStateCompat.a(obj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void c(String str, Bundle bundle) {
                Callback callback = (Callback) this.f213a.get();
                if (callback != null) {
                    callback.j(str, bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void d(int i3, int i4, int i5, int i6, int i7) {
                Callback callback = (Callback) this.f213a.get();
                if (callback != null) {
                    callback.a(new PlaybackInfo(i3, i4, i5, i6, i7));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void f(List list) {
                Callback callback = (Callback) this.f213a.get();
                if (callback != null) {
                    callback.f(MediaSessionCompat.QueueItem.c(list));
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void h() {
                Callback callback = (Callback) this.f213a.get();
                if (callback != null) {
                    callback.i();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void n(Bundle bundle) {
                Callback callback = (Callback) this.f213a.get();
                if (callback != null) {
                    callback.c(bundle);
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void y(CharSequence charSequence) {
                Callback callback = (Callback) this.f213a.get();
                if (callback != null) {
                    callback.g(charSequence);
                }
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            m(8, null, null);
        }

        void m(int i3, Object obj, Bundle bundle) {
            MessageHandler messageHandler = this.f209a;
            if (messageHandler != null) {
                Message messageObtainMessage = messageHandler.obtainMessage(i3, obj);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        }

        public void i() {
        }

        public void k() {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class StubCompat extends IMediaControllerCallback.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference f214a;

            StubCompat(Callback callback) {
                this.f214a = new WeakReference(callback);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void F1(int i3) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(12, Integer.valueOf(i3), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void f(List list) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void f5(PlaybackStateCompat playbackStateCompat) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void h() {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(8, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void j1(MediaMetadataCompat mediaMetadataCompat) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void k2(ParcelableVolumeInfo parcelableVolumeInfo) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(4, parcelableVolumeInfo != null ? new PlaybackInfo(parcelableVolumeInfo.f285a, parcelableVolumeInfo.f286b, parcelableVolumeInfo.f287c, parcelableVolumeInfo.f288d, parcelableVolumeInfo.f289f) : null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void m3(boolean z2) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(11, Boolean.valueOf(z2), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void n(Bundle bundle) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(7, bundle, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void n0() {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String str, Bundle bundle) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void y(CharSequence charSequence) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(6, charSequence, null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void z(int i3) {
                Callback callback = (Callback) this.f214a.get();
                if (callback != null) {
                    callback.m(9, Integer.valueOf(i3), null);
                }
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void H3(boolean z2) {
            }
        }

        public void a(PlaybackInfo playbackInfo) {
        }

        public void b(boolean z2) {
        }

        public void c(Bundle bundle) {
        }

        public void d(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void e(PlaybackStateCompat playbackStateCompat) {
        }

        public void f(List list) {
        }

        public void g(CharSequence charSequence) {
        }

        public void h(int i3) {
        }

        public void l(int i3) {
        }

        public void j(String str, Bundle bundle) {
        }
    }
}
