package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.MediaBrowserCompatApi23;
import android.support.v4.media.MediaBrowserCompatApi26;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f88b = Log.isLoggable("MediaBrowserCompat", 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaBrowserImpl f89a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CallbackHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f90a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference f91b;

        CallbackHandler(MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.f90a = new WeakReference(mediaBrowserServiceCallbackImpl);
        }

        void a(Messenger messenger) {
            this.f91b = new WeakReference(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference weakReference = this.f91b;
            if (weakReference == null || weakReference.get() == null || this.f90a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.a(data);
            MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = (MediaBrowserServiceCallbackImpl) this.f90a.get();
            Messenger messenger = (Messenger) this.f91b.get();
            try {
                int i3 = message.what;
                if (i3 == 1) {
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    mediaBrowserServiceCallbackImpl.f(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle);
                    return;
                }
                if (i3 == 2) {
                    mediaBrowserServiceCallbackImpl.g(messenger);
                    return;
                }
                if (i3 == 3) {
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    Bundle bundle3 = data.getBundle("data_notify_children_changed_options");
                    MediaSessionCompat.a(bundle3);
                    mediaBrowserServiceCallbackImpl.c(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle2, bundle3);
                    return;
                }
                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
            } catch (BadParcelableException unused) {
                Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.g(messenger);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CustomActionResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f95d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Bundle f96f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final CustomActionCallback f97g;

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i3, Bundle bundle) {
            if (this.f97g == null) {
                return;
            }
            MediaSessionCompat.a(bundle);
            if (i3 == -1) {
                this.f97g.a(this.f95d, this.f96f, bundle);
                return;
            }
            if (i3 == 0) {
                this.f97g.c(this.f95d, this.f96f, bundle);
                return;
            }
            if (i3 == 1) {
                this.f97g.b(this.f95d, this.f96f, bundle);
                return;
            }
            Log.w("MediaBrowserCompat", "Unknown result code: " + i3 + " (extras=" + this.f96f + ", resultData=" + bundle + ")");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ItemReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f99d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ItemCallback f100f;

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i3, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i3 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.f100f.a(this.f99d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f100f.b((MediaItem) parcelable);
            } else {
                this.f100f.a(this.f99d);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface MediaBrowserImpl {
        void d();

        void disconnect();

        MediaSessionCompat.Token e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        MediaBrowserImplApi23(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        MediaBrowserImplApi26(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ComponentName f130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ConnectionCallback f131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Bundle f132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final CallbackHandler f133e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ArrayMap f134f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f135g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        MediaServiceConnection f136h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ServiceBinderWrapper f137i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Messenger f138j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f139k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private MediaSessionCompat.Token f140l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private Bundle f141m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Bundle f142n;

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes.dex */
        class AnonymousClass3 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ItemCallback f145a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f146b;

            @Override // java.lang.Runnable
            public void run() {
                this.f145a.a(this.f146b);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes.dex */
        class AnonymousClass4 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ItemCallback f147a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f148b;

            @Override // java.lang.Runnable
            public void run() {
                this.f147a.a(this.f148b);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes.dex */
        class AnonymousClass5 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SearchCallback f149a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f150b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f151c;

            @Override // java.lang.Runnable
            public void run() {
                this.f149a.a(this.f150b, this.f151c);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes.dex */
        class AnonymousClass6 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CustomActionCallback f152a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f153b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f154c;

            @Override // java.lang.Runnable
            public void run() {
                this.f152a.a(this.f153b, this.f154c, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes.dex */
        private class MediaServiceConnection implements ServiceConnection {
            MediaServiceConnection() {
            }

            private void b(Runnable runnable) {
                if (Thread.currentThread() == MediaBrowserImplBase.this.f133e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    MediaBrowserImplBase.this.f133e.post(runnable);
                }
            }

            boolean a(String str) {
                int i3;
                MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.f136h == this && (i3 = mediaBrowserImplBase.f135g) != 0 && i3 != 1) {
                    return true;
                }
                int i4 = mediaBrowserImplBase.f135g;
                if (i4 == 0 || i4 == 1) {
                    return false;
                }
                Log.i("MediaBrowserCompat", str + " for " + MediaBrowserImplBase.this.f130b + " with mServiceConnection=" + MediaBrowserImplBase.this.f136h + " this=" + this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName componentName, final IBinder iBinder) {
                b(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z2 = MediaBrowserCompat.f88b;
                        if (z2) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + componentName + " binder=" + iBinder);
                            MediaBrowserImplBase.this.a();
                        }
                        if (MediaServiceConnection.this.a("onServiceConnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.f137i = new ServiceBinderWrapper(iBinder, mediaBrowserImplBase.f132d);
                            MediaBrowserImplBase.this.f138j = new Messenger(MediaBrowserImplBase.this.f133e);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.f133e.a(mediaBrowserImplBase2.f138j);
                            MediaBrowserImplBase.this.f135g = 2;
                            if (z2) {
                                try {
                                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                    MediaBrowserImplBase.this.a();
                                } catch (RemoteException unused) {
                                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.f130b);
                                    if (MediaBrowserCompat.f88b) {
                                        Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                                        MediaBrowserImplBase.this.a();
                                        return;
                                    }
                                    return;
                                }
                            }
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase3.f137i.b(mediaBrowserImplBase3.f129a, mediaBrowserImplBase3.f138j);
                        }
                    }
                });
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName componentName) {
                b(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (MediaBrowserCompat.f88b) {
                            Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + componentName + " this=" + this + " mServiceConnection=" + MediaBrowserImplBase.this.f136h);
                            MediaBrowserImplBase.this.a();
                        }
                        if (MediaServiceConnection.this.a("onServiceDisconnected")) {
                            MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                            mediaBrowserImplBase.f137i = null;
                            mediaBrowserImplBase.f138j = null;
                            mediaBrowserImplBase.f133e.a(null);
                            MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                            mediaBrowserImplBase2.f135g = 4;
                            mediaBrowserImplBase2.f131c.c();
                        }
                    }
                });
            }
        }

        private static String h(int i3) {
            if (i3 == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i3 == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i3 == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i3 == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i3 == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i3;
        }

        private boolean j(Messenger messenger, String str) {
            int i3;
            if (this.f138j == messenger && (i3 = this.f135g) != 0 && i3 != 1) {
                return true;
            }
            int i4 = this.f135g;
            if (i4 == 0 || i4 == 1) {
                return false;
            }
            Log.i("MediaBrowserCompat", str + " for " + this.f130b + " with mCallbacksMessenger=" + this.f138j + " this=" + this);
            return false;
        }

        void a() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f130b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.f131c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.f132d);
            Log.d("MediaBrowserCompat", "  mState=" + h(this.f135g));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f136h);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f137i);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f138j);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.f139k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f140l);
        }

        void b() {
            MediaServiceConnection mediaServiceConnection = this.f136h;
            if (mediaServiceConnection != null) {
                this.f129a.unbindService(mediaServiceConnection);
            }
            this.f135g = 1;
            this.f136h = null;
            this.f137i = null;
            this.f138j = null;
            this.f133e.a(null);
            this.f139k = null;
            this.f140l = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void c(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (j(messenger, "onLoadChildren")) {
                boolean z2 = MediaBrowserCompat.f88b;
                if (z2) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f130b + " id=" + str);
                }
                Subscription subscription = (Subscription) this.f134f.get(str);
                if (subscription == null) {
                    if (z2) {
                        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                        return;
                    }
                    return;
                }
                SubscriptionCallback subscriptionCallbackA = subscription.a(bundle);
                if (subscriptionCallbackA != null) {
                    if (bundle == null) {
                        if (list == null) {
                            subscriptionCallbackA.c(str);
                            return;
                        }
                        this.f142n = bundle2;
                        subscriptionCallbackA.a(str, list);
                        this.f142n = null;
                        return;
                    }
                    if (list == null) {
                        subscriptionCallbackA.d(str, bundle);
                        return;
                    }
                    this.f142n = bundle2;
                    subscriptionCallbackA.b(str, list, bundle);
                    this.f142n = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void d() {
            int i3 = this.f135g;
            if (i3 == 0 || i3 == 1) {
                this.f135g = 2;
                this.f133e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean zBindService;
                        MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                        if (mediaBrowserImplBase.f135g == 0) {
                            return;
                        }
                        mediaBrowserImplBase.f135g = 2;
                        if (MediaBrowserCompat.f88b && mediaBrowserImplBase.f136h != null) {
                            throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserImplBase.this.f136h);
                        }
                        if (mediaBrowserImplBase.f137i != null) {
                            throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserImplBase.this.f137i);
                        }
                        if (mediaBrowserImplBase.f138j != null) {
                            throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserImplBase.this.f138j);
                        }
                        Intent intent = new Intent("android.media.browse.MediaBrowserService");
                        intent.setComponent(MediaBrowserImplBase.this.f130b);
                        MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.f136h = mediaBrowserImplBase2.new MediaServiceConnection();
                        try {
                            MediaBrowserImplBase mediaBrowserImplBase3 = MediaBrowserImplBase.this;
                            zBindService = mediaBrowserImplBase3.f129a.bindService(intent, mediaBrowserImplBase3.f136h, 1);
                        } catch (Exception unused) {
                            Log.e("MediaBrowserCompat", "Failed binding to service " + MediaBrowserImplBase.this.f130b);
                            zBindService = false;
                        }
                        if (!zBindService) {
                            MediaBrowserImplBase.this.b();
                            MediaBrowserImplBase.this.f131c.b();
                        }
                        if (MediaBrowserCompat.f88b) {
                            Log.d("MediaBrowserCompat", "connect...");
                            MediaBrowserImplBase.this.a();
                        }
                    }
                });
            } else {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + h(this.f135g) + ")");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.f135g = 0;
            this.f133e.post(new Runnable() { // from class: android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.2
                @Override // java.lang.Runnable
                public void run() {
                    MediaBrowserImplBase mediaBrowserImplBase = MediaBrowserImplBase.this;
                    Messenger messenger = mediaBrowserImplBase.f138j;
                    if (messenger != null) {
                        try {
                            mediaBrowserImplBase.f137i.c(messenger);
                        } catch (RemoteException unused) {
                            Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserImplBase.this.f130b);
                        }
                    }
                    MediaBrowserImplBase mediaBrowserImplBase2 = MediaBrowserImplBase.this;
                    int i3 = mediaBrowserImplBase2.f135g;
                    mediaBrowserImplBase2.b();
                    if (i3 != 0) {
                        MediaBrowserImplBase.this.f135g = i3;
                    }
                    if (MediaBrowserCompat.f88b) {
                        Log.d("MediaBrowserCompat", "disconnect...");
                        MediaBrowserImplBase.this.a();
                    }
                }
            });
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token e() {
            if (i()) {
                return this.f140l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f135g + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void g(Messenger messenger) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f130b);
            if (j(messenger, "onConnectFailed")) {
                if (this.f135g == 2) {
                    b();
                    this.f131c.b();
                    return;
                }
                Log.w("MediaBrowserCompat", "onConnect from service while mState=" + h(this.f135g) + "... ignoring");
            }
        }

        public boolean i() {
            return this.f135g == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void f(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (j(messenger, SbbqvQlxi.cjGB)) {
                if (this.f135g != 2) {
                    Log.w("MediaBrowserCompat", "onConnect from service while mState=" + h(this.f135g) + "... ignoring");
                    return;
                }
                this.f139k = str;
                this.f140l = token;
                this.f141m = bundle;
                this.f135g = 3;
                if (MediaBrowserCompat.f88b) {
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    a();
                }
                this.f131c.a();
                try {
                    for (Map.Entry entry : this.f134f.entrySet()) {
                        String str2 = (String) entry.getKey();
                        Subscription subscription = (Subscription) entry.getValue();
                        List listB = subscription.b();
                        List listC = subscription.c();
                        for (int i3 = 0; i3 < listB.size(); i3++) {
                            this.f137i.a(str2, ((SubscriptionCallback) listB.get(i3)).f170a, (Bundle) listC.get(i3), this.f138j);
                        }
                    }
                } catch (RemoteException unused) {
                    Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface MediaBrowserServiceCallbackImpl {
        void c(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void f(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void g(Messenger messenger);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SearchResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f163d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Bundle f164f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final SearchCallback f165g;

        @Override // android.support.v4.os.ResultReceiver
        protected void a(int i3, Bundle bundle) {
            ArrayList arrayList;
            MediaSessionCompat.a(bundle);
            if (i3 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f165g.a(this.f163d, this.f164f);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            } else {
                arrayList = null;
            }
            this.f165g.b(this.f163d, this.f164f, arrayList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ServiceBinderWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f167b;

        public ServiceBinderWrapper(IBinder iBinder, Bundle bundle) {
            this.f166a = new Messenger(iBinder);
            this.f167b = bundle;
        }

        private void e(int i3, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i3;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.f166a.send(messageObtain);
        }

        void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            BundleCompat.b(bundle2, "data_callback_token", iBinder);
            bundle2.putBundle("data_options", bundle);
            e(3, bundle2, messenger);
        }

        void b(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.f167b);
            e(1, bundle, messenger);
        }

        void c(Messenger messenger) throws RemoteException {
            e(2, null, messenger);
        }

        void d(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putBundle("data_root_hints", this.f167b);
            e(6, bundle, messenger);
        }

        void f(Messenger messenger) throws RemoteException {
            e(7, null, messenger);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f169b;

        public SubscriptionCallback a(Bundle bundle) {
            for (int i3 = 0; i3 < this.f169b.size(); i3++) {
                if (MediaBrowserCompatUtils.a((Bundle) this.f169b.get(i3), bundle)) {
                    return (SubscriptionCallback) this.f168a.get(i3);
                }
            }
            return null;
        }

        public List b() {
            return this.f168a;
        }

        public List c() {
            return this.f169b;
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
        this.f89a = new MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
    }

    public void a() {
        this.f89a.d();
    }

    public void b() {
        this.f89a.disconnect();
    }

    public MediaSessionCompat.Token c() {
        return this.f89a.e();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i3) {
                return new MediaItem[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaDescriptionCompat f162b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface Flags {
        }

        public MediaItem(MediaDescriptionCompat mediaDescriptionCompat, int i3) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.d())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f161a = i3;
            this.f162b = mediaDescriptionCompat;
        }

        public static MediaItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            return new MediaItem(MediaDescriptionCompat.a(MediaBrowserCompatApi21.MediaItem.a(obj)), MediaBrowserCompatApi21.MediaItem.b(obj));
        }

        public static List c(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f161a + ", mDescription=" + this.f162b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f161a);
            this.f162b.writeToParcel(parcel, i3);
        }

        MediaItem(Parcel parcel) {
            this.f161a = parcel.readInt();
            this.f162b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ConnectionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f92a = MediaBrowserCompatApi21.c(new StubApi21());

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ConnectionCallbackInternal f93b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        interface ConnectionCallbackInternal {
            void a();

            void b();

            void onConnected();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
            StubApi21() {
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void a() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f93b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.a();
                }
                ConnectionCallback.this.b();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void b() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f93b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.b();
                }
                ConnectionCallback.this.c();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal connectionCallbackInternal = ConnectionCallback.this.f93b;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                ConnectionCallback.this.a();
            }
        }

        void d(ConnectionCallbackInternal connectionCallbackInternal) {
            this.f93b = connectionCallbackInternal;
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Bundle f103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final CallbackHandler f104d = new CallbackHandler(this);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ArrayMap f105e = new ArrayMap();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected int f106f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected ServiceBinderWrapper f107g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected Messenger f108h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private MediaSessionCompat.Token f109i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Bundle f110j;

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ItemCallback f111a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f112b;

            @Override // java.lang.Runnable
            public void run() {
                this.f111a.a(this.f112b);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ItemCallback f113a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f114b;

            @Override // java.lang.Runnable
            public void run() {
                this.f113a.a(this.f114b);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass3 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ItemCallback f115a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f116b;

            @Override // java.lang.Runnable
            public void run() {
                this.f115a.a(this.f116b);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass4 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SearchCallback f117a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f118b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f119c;

            @Override // java.lang.Runnable
            public void run() {
                this.f117a.a(this.f118b, this.f119c);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass5 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SearchCallback f120a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f121b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f122c;

            @Override // java.lang.Runnable
            public void run() {
                this.f120a.a(this.f121b, this.f122c);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass6 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CustomActionCallback f123a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f124b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f125c;

            @Override // java.lang.Runnable
            public void run() {
                this.f123a.a(this.f124b, this.f125c, null);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$7, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass7 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ CustomActionCallback f126a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f127b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f128c;

            @Override // java.lang.Runnable
            public void run() {
                this.f126a.a(this.f127b, this.f128c, null);
            }
        }

        MediaBrowserImplApi21(Context context, ComponentName componentName, ConnectionCallback connectionCallback, Bundle bundle) {
            this.f101a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.f103c = bundle2;
            bundle2.putInt("extra_client_version", 1);
            connectionCallback.d(this);
            this.f102b = MediaBrowserCompatApi21.b(context, componentName, connectionCallback.f92a, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void b() {
            this.f107g = null;
            this.f108h = null;
            this.f109i = null;
            this.f104d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void c(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f108h != messenger) {
                return;
            }
            Subscription subscription = (Subscription) this.f105e.get(str);
            if (subscription == null) {
                if (MediaBrowserCompat.f88b) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                    return;
                }
                return;
            }
            SubscriptionCallback subscriptionCallbackA = subscription.a(bundle);
            if (subscriptionCallbackA != null) {
                if (bundle == null) {
                    if (list == null) {
                        subscriptionCallbackA.c(str);
                        return;
                    }
                    this.f110j = bundle2;
                    subscriptionCallbackA.a(str, list);
                    this.f110j = null;
                    return;
                }
                if (list == null) {
                    subscriptionCallbackA.d(str, bundle);
                    return;
                }
                this.f110j = bundle2;
                subscriptionCallbackA.b(str, list, bundle);
                this.f110j = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void d() {
            MediaBrowserCompatApi21.a(this.f102b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            Messenger messenger;
            ServiceBinderWrapper serviceBinderWrapper = this.f107g;
            if (serviceBinderWrapper != null && (messenger = this.f108h) != null) {
                try {
                    serviceBinderWrapper.f(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            MediaBrowserCompatApi21.d(this.f102b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public MediaSessionCompat.Token e() {
            if (this.f109i == null) {
                this.f109i = MediaSessionCompat.Token.a(MediaBrowserCompatApi21.f(this.f102b));
            }
            return this.f109i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            Bundle bundleE = MediaBrowserCompatApi21.e(this.f102b);
            if (bundleE == null) {
                return;
            }
            this.f106f = bundleE.getInt("extra_service_version", 0);
            IBinder iBinderA = BundleCompat.a(bundleE, "extra_messenger");
            if (iBinderA != null) {
                this.f107g = new ServiceBinderWrapper(iBinderA, this.f103c);
                Messenger messenger = new Messenger(this.f104d);
                this.f108h = messenger;
                this.f104d.a(messenger);
                try {
                    this.f107g.d(this.f101a, this.f108h);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                }
            }
            IMediaSession iMediaSessionX3 = IMediaSession.Stub.x3(BundleCompat.a(bundleE, "extra_session_binder"));
            if (iMediaSessionX3 != null) {
                this.f109i = MediaSessionCompat.Token.c(MediaBrowserCompatApi21.f(this.f102b), iMediaSessionX3);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void a() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void g(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void f(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class ItemCallback {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ItemCallback f98a;

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void a(Parcel parcel) {
                if (parcel == null) {
                    this.f98a.b(null);
                    return;
                }
                parcel.setDataPosition(0);
                MediaItem mediaItemCreateFromParcel = MediaItem.CREATOR.createFromParcel(parcel);
                parcel.recycle();
                this.f98a.b(mediaItemCreateFromParcel);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(String str) {
                this.f98a.a(str);
            }
        }

        public void a(String str) {
        }

        public void b(MediaItem mediaItem) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SubscriptionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final IBinder f170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WeakReference f171b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SubscriptionCallback f172a;

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void c(String str, List list) {
                WeakReference weakReference = this.f172a.f171b;
                Subscription subscription = weakReference == null ? null : (Subscription) weakReference.get();
                if (subscription == null) {
                    this.f172a.a(str, MediaItem.c(list));
                    return;
                }
                List listC = MediaItem.c(list);
                List listB = subscription.b();
                List listC2 = subscription.c();
                for (int i3 = 0; i3 < listB.size(); i3++) {
                    Bundle bundle = (Bundle) listC2.get(i3);
                    if (bundle == null) {
                        this.f172a.a(str, listC);
                    } else {
                        this.f172a.b(str, d(listC, bundle), bundle);
                    }
                }
            }

            List d(List list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i3 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i4 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i3 == -1 && i4 == -1) {
                    return list;
                }
                int i5 = i4 * i3;
                int size = i5 + i4;
                if (i3 < 0 || i4 < 1 || i5 >= list.size()) {
                    return Collections.EMPTY_LIST;
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i5, size);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(String str) {
                this.f172a.c(str);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SubscriptionCallback f173b;

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void a(String str, Bundle bundle) {
                this.f173b.d(str, bundle);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void b(String str, List list, Bundle bundle) {
                this.f173b.b(str, MediaItem.c(list), bundle);
            }
        }

        public void c(String str) {
        }

        public void a(String str, List list) {
        }

        public void d(String str, Bundle bundle) {
        }

        public void b(String str, List list, Bundle bundle) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SearchCallback {
        public void a(String str, Bundle bundle) {
        }

        public void b(String str, Bundle bundle, List list) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class CustomActionCallback {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }
}
