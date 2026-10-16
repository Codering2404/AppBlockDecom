package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserServiceCompatApi21;
import androidx.media.MediaBrowserServiceCompatApi23;
import androidx.media.MediaBrowserServiceCompatApi26;
import androidx.media.MediaSessionManager;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import androidx.media3.exoplayer.audio.wRw.CbYNFSEGaQj;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final boolean f40345g = Log.isLoggable("MBServiceCompat", 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediaBrowserServiceImpl f40346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayMap f40347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ConnectionRecord f40348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ServiceHandler f40349d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    MediaSessionCompat.Token f40350f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class BrowserRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f40362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bundle f40363b;

        public Bundle a() {
            return this.f40363b;
        }

        public String b() {
            return this.f40362a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ConnectionRecord implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f40364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f40365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f40366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaSessionManager.RemoteUserInfo f40367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f40368e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ServiceCallbacks f40369f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HashMap f40370g = new HashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public BrowserRoot f40371h;

        ConnectionRecord(String str, int i3, int i4, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.f40364a = str;
            this.f40365b = i3;
            this.f40366c = i4;
            this.f40367d = new MediaSessionManager.RemoteUserInfo(str, i3, i4);
            this.f40368e = bundle;
            this.f40369f = serviceCallbacks;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.f40349d.post(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ConnectionRecord.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = ConnectionRecord.this;
                    MediaBrowserServiceCompat.this.f40347b.remove(connectionRecord.f40369f.asBinder());
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface MediaBrowserServiceImpl {
        IBinder onBind(Intent intent);

        void onCreate();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f40374a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f40375b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Messenger f40376c;

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionCompat.Token f40378a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceImplApi21 f40379b;

            @Override // java.lang.Runnable
            public void run() {
                if (!this.f40379b.f40374a.isEmpty()) {
                    IMediaSession iMediaSessionD = this.f40378a.d();
                    if (iMediaSessionD != null) {
                        Iterator it = this.f40379b.f40374a.iterator();
                        while (it.hasNext()) {
                            BundleCompat.b((Bundle) it.next(), "extra_session_binder", iMediaSessionD.asBinder());
                        }
                    }
                    this.f40379b.f40374a.clear();
                }
                MediaBrowserServiceCompatApi21.d(this.f40379b.f40375b, this.f40378a.f());
            }
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass3 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f40382a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f40383b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceImplApi21 f40384c;

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = MediaBrowserServiceCompat.this.f40347b.keySet().iterator();
                while (it.hasNext()) {
                    this.f40384c.e((ConnectionRecord) MediaBrowserServiceCompat.this.f40347b.get((IBinder) it.next()), this.f40382a, this.f40383b);
                }
            }
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass4 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionManager.RemoteUserInfo f40385a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f40386b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f40387c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceImplApi21 f40388d;

            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < MediaBrowserServiceCompat.this.f40347b.size(); i3++) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) MediaBrowserServiceCompat.this.f40347b.j(i3);
                    if (connectionRecord.f40367d.equals(this.f40385a)) {
                        this.f40388d.e(connectionRecord, this.f40386b, this.f40387c);
                    }
                }
            }
        }

        MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot c(String str, int i3, Bundle bundle) {
            Bundle bundleA;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundleA = null;
            } else {
                bundle.remove("extra_client_version");
                this.f40376c = new Messenger(MediaBrowserServiceCompat.this.f40349d);
                bundleA = new Bundle();
                bundleA.putInt("extra_service_version", 2);
                BundleCompat.b(bundleA, "extra_messenger", this.f40376c.getBinder());
                MediaSessionCompat.Token token = MediaBrowserServiceCompat.this.f40350f;
                if (token != null) {
                    IMediaSession iMediaSessionD = token.d();
                    BundleCompat.b(bundleA, "extra_session_binder", iMediaSessionD == null ? null : iMediaSessionD.asBinder());
                } else {
                    this.f40374a.add(bundleA);
                }
            }
            MediaBrowserServiceCompat mediaBrowserServiceCompat = MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.f40348c = mediaBrowserServiceCompat.new ConnectionRecord(str, -1, i3, bundle, null);
            BrowserRoot browserRootE = MediaBrowserServiceCompat.this.e(str, i3, bundle);
            MediaBrowserServiceCompat.this.f40348c = null;
            if (browserRootE == null) {
                return null;
            }
            if (bundleA == null) {
                bundleA = browserRootE.a();
            } else if (browserRootE.a() != null) {
                bundleA.putAll(browserRootE.a());
            }
            return new MediaBrowserServiceCompatApi21.BrowserRoot(browserRootE.b(), bundleA);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void d(String str, final MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
            MediaBrowserServiceCompat.this.f(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.2
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public void d(List list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                            Parcel parcelObtain = Parcel.obtain();
                            mediaItem.writeToParcel(parcelObtain, 0);
                            arrayList.add(parcelObtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.b(arrayList);
                }
            });
        }

        void e(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = (List) connectionRecord.f40370g.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.b(bundle, (Bundle) pair.f34341b)) {
                        MediaBrowserServiceCompat.this.m(str, connectionRecord, (Bundle) pair.f34341b, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.b(this.f40375b, intent);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object objA = MediaBrowserServiceCompatApi21.a(MediaBrowserServiceCompat.this, this);
            this.f40375b = objA;
            MediaBrowserServiceCompatApi21.c(objA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void a(String str, final MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
            MediaBrowserServiceCompat.this.h(str, new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public void d(MediaBrowserCompat.MediaItem mediaItem) {
                    if (mediaItem == null) {
                        resultWrapper.b(null);
                        return;
                    }
                    Parcel parcelObtain = Parcel.obtain();
                    mediaItem.writeToParcel(parcelObtain, 0);
                    resultWrapper.b(parcelObtain);
                }
            });
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object objA = MediaBrowserServiceCompatApi23.a(MediaBrowserServiceCompat.this, this);
            this.f40375b = objA;
            MediaBrowserServiceCompatApi21.c(objA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void b(String str, final MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.g(str, new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // androidx.media.MediaBrowserServiceCompat.Result
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public void d(List list) {
                    ArrayList arrayList;
                    if (list != null) {
                        arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) it.next();
                            Parcel parcelObtain = Parcel.obtain();
                            mediaItem.writeToParcel(parcelObtain, 0);
                            arrayList.add(parcelObtain);
                        }
                    } else {
                        arrayList = null;
                    }
                    resultWrapper.b(arrayList, a());
                }
            }, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object objA = MediaBrowserServiceCompatApi26.a(MediaBrowserServiceCompat.this, this);
            this.f40375b = objA;
            MediaBrowserServiceCompatApi21.c(objA);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        MediaBrowserServiceImplApi28() {
            super();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f40396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat f40397b;

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes2.dex */
        class AnonymousClass1 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionCompat.Token f40398a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceImplBase f40399b;

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = this.f40399b.f40397b.f40347b.values().iterator();
                while (it.hasNext()) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) it.next();
                    try {
                        connectionRecord.f40369f.c(connectionRecord.f40371h.b(), this.f40398a, connectionRecord.f40371h.a());
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "Connection for " + connectionRecord.f40364a + bfIdKSjLOVjG.ZqAkFsjdRNClw);
                        it.remove();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass2 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f40400a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Bundle f40401b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceImplBase f40402c;

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = this.f40402c.f40397b.f40347b.keySet().iterator();
                while (it.hasNext()) {
                    this.f40402c.a((ConnectionRecord) this.f40402c.f40397b.f40347b.get((IBinder) it.next()), this.f40400a, this.f40401b);
                }
            }
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass3 implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionManager.RemoteUserInfo f40403a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f40404b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Bundle f40405c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ MediaBrowserServiceImplBase f40406d;

            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < this.f40406d.f40397b.f40347b.size(); i3++) {
                    ConnectionRecord connectionRecord = (ConnectionRecord) this.f40406d.f40397b.f40347b.j(i3);
                    if (connectionRecord.f40367d.equals(this.f40403a)) {
                        this.f40406d.a(connectionRecord, this.f40404b, this.f40405c);
                        return;
                    }
                }
            }
        }

        void a(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair> list = (List) connectionRecord.f40370g.get(str);
            if (list != null) {
                for (Pair pair : list) {
                    if (MediaBrowserCompatUtils.b(bundle, (Bundle) pair.f34341b)) {
                        this.f40397b.m(str, connectionRecord, (Bundle) pair.f34341b, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            if ("android.media.browse.MediaBrowserService".equals(intent.getAction())) {
                return this.f40396a.getBinder();
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.f40396a = new Messenger(this.f40397b.f40349d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ServiceBinderImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaBrowserServiceCompat f40412a;

        public void a(final String str, final IBinder iBinder, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) ServiceBinderImpl.this.f40412a.f40347b.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        ServiceBinderImpl.this.f40412a.a(str, connectionRecord, iBinder, bundle);
                        return;
                    }
                    Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str);
                }
            });
        }

        public void b(final String str, final int i3, final int i4, final Bundle bundle, final ServiceCallbacks serviceCallbacks) {
            if (this.f40412a.c(str, i4)) {
                this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.1
                    /* JADX WARN: Type inference fix 'apply assigned field type' failed
                    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
                    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                     */
                    @Override // java.lang.Runnable
                    public void run() {
                        IBinder iBinderAsBinder = serviceCallbacks.asBinder();
                        ServiceBinderImpl.this.f40412a.f40347b.remove(iBinderAsBinder);
                        ConnectionRecord connectionRecord = ServiceBinderImpl.this.f40412a.new ConnectionRecord(str, i3, i4, bundle, serviceCallbacks);
                        MediaBrowserServiceCompat mediaBrowserServiceCompat = ServiceBinderImpl.this.f40412a;
                        mediaBrowserServiceCompat.f40348c = connectionRecord;
                        BrowserRoot browserRootE = mediaBrowserServiceCompat.e(str, i4, bundle);
                        connectionRecord.f40371h = browserRootE;
                        MediaBrowserServiceCompat mediaBrowserServiceCompat2 = ServiceBinderImpl.this.f40412a;
                        mediaBrowserServiceCompat2.f40348c = null;
                        if (browserRootE != null) {
                            try {
                                mediaBrowserServiceCompat2.f40347b.put(iBinderAsBinder, connectionRecord);
                                iBinderAsBinder.linkToDeath(connectionRecord, 0);
                                if (ServiceBinderImpl.this.f40412a.f40350f != null) {
                                    serviceCallbacks.c(connectionRecord.f40371h.b(), ServiceBinderImpl.this.f40412a.f40350f, connectionRecord.f40371h.a());
                                    return;
                                }
                                return;
                            } catch (RemoteException unused) {
                                Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str);
                                ServiceBinderImpl.this.f40412a.f40347b.remove(iBinderAsBinder);
                                return;
                            }
                        }
                        Log.i("MBServiceCompat", "No root for client " + str + " from service " + getClass().getName());
                        try {
                            serviceCallbacks.b();
                        } catch (RemoteException unused2) {
                            Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i4 + " package=" + str);
        }

        public void c(final ServiceCallbacks serviceCallbacks) {
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) ServiceBinderImpl.this.f40412a.f40347b.remove(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        connectionRecord.f40369f.asBinder().unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }

        public void d(final String str, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) ServiceBinderImpl.this.f40412a.f40347b.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        ServiceBinderImpl.this.f40412a.n(str, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                }
            });
        }

        public void e(final ServiceCallbacks serviceCallbacks, final String str, final int i3, final int i4, final Bundle bundle) {
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.6
                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderAsBinder = serviceCallbacks.asBinder();
                    ServiceBinderImpl.this.f40412a.f40347b.remove(iBinderAsBinder);
                    ConnectionRecord connectionRecord = ServiceBinderImpl.this.f40412a.new ConnectionRecord(str, i3, i4, bundle, serviceCallbacks);
                    ServiceBinderImpl.this.f40412a.f40347b.put(iBinderAsBinder, connectionRecord);
                    try {
                        iBinderAsBinder.linkToDeath(connectionRecord, 0);
                    } catch (RemoteException unused) {
                        Log.w("MBServiceCompat", "IBinder is already dead.");
                    }
                }
            });
        }

        public void f(final String str, final IBinder iBinder, final ServiceCallbacks serviceCallbacks) {
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) ServiceBinderImpl.this.f40412a.f40347b.get(serviceCallbacks.asBinder());
                    if (connectionRecord == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                        return;
                    }
                    if (ServiceBinderImpl.this.f40412a.p(str, connectionRecord, iBinder)) {
                        return;
                    }
                    Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                }
            });
        }

        public void g(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.8
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) ServiceBinderImpl.this.f40412a.f40347b.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        ServiceBinderImpl.this.f40412a.o(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str);
                }
            });
        }

        public void h(final String str, final Bundle bundle, final ResultReceiver resultReceiver, final ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    ConnectionRecord connectionRecord = (ConnectionRecord) ServiceBinderImpl.this.f40412a.f40347b.get(serviceCallbacks.asBinder());
                    if (connectionRecord != null) {
                        ServiceBinderImpl.this.f40412a.l(str, bundle, connectionRecord, resultReceiver);
                        return;
                    }
                    Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str + ", extras=" + bundle);
                }
            });
        }

        public void i(final ServiceCallbacks serviceCallbacks) {
            this.f40412a.f40349d.a(new Runnable() { // from class: androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.7
                @Override // java.lang.Runnable
                public void run() {
                    IBinder iBinderAsBinder = serviceCallbacks.asBinder();
                    ConnectionRecord connectionRecord = (ConnectionRecord) ServiceBinderImpl.this.f40412a.f40347b.remove(iBinderAsBinder);
                    if (connectionRecord != null) {
                        iBinderAsBinder.unlinkToDeath(connectionRecord, 0);
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface ServiceCallbacks {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();

        void b();

        void c(String str, MediaSessionCompat.Token token, Bundle bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ServiceCallbacksCompat implements ServiceCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Messenger f40452a;

        ServiceCallbacksCompat(Messenger messenger) {
            this.f40452a = messenger;
        }

        private void d(int i3, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i3;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.f40452a.send(messageObtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void a(String str, List list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.f40452a.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void b() throws RemoteException {
            d(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", token);
            bundle2.putBundle("data_root_hints", bundle);
            d(1, bundle2);
        }
    }

    void a(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair> arrayList = (List) connectionRecord.f40370g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        for (Pair pair : arrayList) {
            if (iBinder == pair.f34340a && MediaBrowserCompatUtils.a(bundle, (Bundle) pair.f34341b)) {
                return;
            }
        }
        arrayList.add(new Pair(iBinder, bundle));
        connectionRecord.f40370g.put(str, arrayList);
        m(str, connectionRecord, bundle, null);
        this.f40348c = connectionRecord;
        j(str, bundle);
        this.f40348c = null;
    }

    List b(List list, Bundle bundle) {
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

    boolean c(String str, int i3) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i3)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void d(String str, Bundle bundle, Result result) {
        result.e(null);
    }

    public abstract BrowserRoot e(String str, int i3, Bundle bundle);

    public abstract void f(String str, Result result);

    public void g(String str, Result result, Bundle bundle) {
        result.g(1);
        f(str, result);
    }

    public void h(String str, Result result) {
        result.g(2);
        result.f(null);
    }

    public void i(String str, Bundle bundle, Result result) {
        result.g(4);
        result.f(null);
    }

    void l(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<Bundle> result = new Result<Bundle>(str) { // from class: androidx.media.MediaBrowserServiceCompat.4
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            void c(Bundle bundle2) {
                resultReceiver.c(-1, bundle2);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(Bundle bundle2) {
                resultReceiver.c(0, bundle2);
            }
        };
        this.f40348c = connectionRecord;
        d(str, bundle, result);
        this.f40348c = null;
        if (result.b()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    void m(final String str, final ConnectionRecord connectionRecord, final Bundle bundle, final Bundle bundle2) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                if (MediaBrowserServiceCompat.this.f40347b.get(connectionRecord.f40369f.asBinder()) != connectionRecord) {
                    if (MediaBrowserServiceCompat.f40345g) {
                        Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + connectionRecord.f40364a + " id=" + str);
                        return;
                    }
                    return;
                }
                if ((a() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.b(list, bundle);
                }
                try {
                    connectionRecord.f40369f.a(str, list, bundle, bundle2);
                } catch (RemoteException unused) {
                    Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str + " package=" + connectionRecord.f40364a);
                }
            }
        };
        this.f40348c = connectionRecord;
        if (bundle == null) {
            f(str, result);
        } else {
            g(str, result, bundle);
        }
        this.f40348c = null;
        if (result.b()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.f40364a + " id=" + str);
    }

    void n(String str, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(str) { // from class: androidx.media.MediaBrowserServiceCompat.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(MediaBrowserCompat.MediaItem mediaItem) {
                if ((a() & 2) != 0) {
                    resultReceiver.c(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", mediaItem);
                resultReceiver.c(0, bundle);
            }
        };
        this.f40348c = connectionRecord;
        h(str, result);
        this.f40348c = null;
        if (result.b()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    void o(String str, Bundle bundle, ConnectionRecord connectionRecord, final ResultReceiver resultReceiver) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(str) { // from class: androidx.media.MediaBrowserServiceCompat.3
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void d(List list) {
                if ((a() & 4) != 0 || list == null) {
                    resultReceiver.c(-1, null);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelableArray("search_results", (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
                resultReceiver.c(0, bundle2);
            }
        };
        this.f40348c = connectionRecord;
        i(str, bundle, result);
        this.f40348c = null;
        if (result.b()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f40346a.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        MediaBrowserServiceImplApi28 mediaBrowserServiceImplApi28 = new MediaBrowserServiceImplApi28();
        this.f40346a = mediaBrowserServiceImplApi28;
        mediaBrowserServiceImplApi28.onCreate();
    }

    boolean p(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z2 = false;
        try {
            if (iBinder != null) {
                List list = (List) connectionRecord.f40370g.get(str);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == ((Pair) it.next()).f34340a) {
                            it.remove();
                            z2 = true;
                        }
                    }
                    if (list.size() == 0) {
                        connectionRecord.f40370g.remove(str);
                    }
                }
            } else if (connectionRecord.f40370g.remove(str) != null) {
                z2 = true;
            }
            return z2;
        } finally {
            this.f40348c = connectionRecord;
            k(str);
            this.f40348c = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    private final class ServiceHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ServiceBinderImpl f40453a;

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j3) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            data.putInt("data_calling_pid", Binder.getCallingPid());
            return super.sendMessageAtTime(message, j3);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle);
                    this.f40453a.b(data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 2:
                    this.f40453a.c(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle("data_options");
                    MediaSessionCompat.a(bundle2);
                    this.f40453a.a(data.getString("data_media_item_id"), BundleCompat.a(data, "data_callback_token"), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 4:
                    this.f40453a.f(data.getString("data_media_item_id"), BundleCompat.a(data, "data_callback_token"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 5:
                    this.f40453a.d(data.getString("data_media_item_id"), (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle("data_root_hints");
                    MediaSessionCompat.a(bundle3);
                    this.f40453a.e(new ServiceCallbacksCompat(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    break;
                case 7:
                    this.f40453a.i(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle(SbbqvQlxi.KuLqvNl);
                    MediaSessionCompat.a(bundle4);
                    this.f40453a.g(data.getString("data_search_query"), bundle4, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle("data_custom_action_extras");
                    MediaSessionCompat.a(bundle5);
                    this.f40453a.h(data.getString("data_custom_action"), bundle5, (ResultReceiver) data.getParcelable("data_result_receiver"), new ServiceCallbacksCompat(message.replyTo));
                    break;
                default:
                    Log.w("MBServiceCompat", CbYNFSEGaQj.tjlHamCEQ + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Result<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f40407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f40408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f40409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f40410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f40411e;

        Result(Object obj) {
            this.f40407a = obj;
        }

        int a() {
            return this.f40411e;
        }

        boolean b() {
            return this.f40408b || this.f40409c || this.f40410d;
        }

        void c(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f40407a);
        }

        public void e(Bundle bundle) {
            if (!this.f40409c && !this.f40410d) {
                this.f40410d = true;
                c(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f40407a);
            }
        }

        public void f(Object obj) {
            if (!this.f40409c && !this.f40410d) {
                this.f40409c = true;
                d(obj);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f40407a);
            }
        }

        void g(int i3) {
            this.f40411e = i3;
        }

        void d(Object obj) {
        }
    }

    public void k(String str) {
    }

    public void j(String str, Bundle bundle) {
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
