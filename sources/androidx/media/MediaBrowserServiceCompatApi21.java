package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class MediaBrowserServiceCompatApi21 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BrowserRoot {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f40454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f40455b;

        BrowserRoot(String str, Bundle bundle) {
            this.f40454a = str;
            this.f40455b = bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaBrowserServiceAdaptor extends MediaBrowserService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ServiceCompatProxy f40456a;

        MediaBrowserServiceAdaptor(Context context, ServiceCompatProxy serviceCompatProxy) {
            attachBaseContext(context);
            this.f40456a = serviceCompatProxy;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String str, int i3, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            BrowserRoot browserRootC = this.f40456a.c(str, i3, bundle == null ? null : new Bundle(bundle));
            if (browserRootC == null) {
                return null;
            }
            return new MediaBrowserService.BrowserRoot(browserRootC.f40454a, browserRootC.f40455b);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String str, MediaBrowserService.Result result) {
            this.f40456a.d(str, new ResultWrapper(result));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ResultWrapper<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MediaBrowserService.Result f40457a;

        ResultWrapper(MediaBrowserService.Result result) {
            this.f40457a = result;
        }

        List a(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Parcel parcel = (Parcel) it.next();
                parcel.setDataPosition(0);
                arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void b(Object obj) {
            if (obj instanceof List) {
                this.f40457a.sendResult(a((List) obj));
                return;
            }
            if (!(obj instanceof Parcel)) {
                this.f40457a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) obj;
            parcel.setDataPosition(0);
            this.f40457a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ServiceCompatProxy {
        BrowserRoot c(String str, int i3, Bundle bundle);

        void d(String str, ResultWrapper resultWrapper);
    }

    public static Object a(Context context, ServiceCompatProxy serviceCompatProxy) {
        return new MediaBrowserServiceAdaptor(context, serviceCompatProxy);
    }

    public static IBinder b(Object obj, Intent intent) {
        return ((MediaBrowserService) obj).onBind(intent);
    }

    public static void c(Object obj) {
        ((MediaBrowserService) obj).onCreate();
    }

    public static void d(Object obj, Object obj2) {
        ((MediaBrowserService) obj).setSessionToken((MediaSession.Token) obj2);
    }
}
