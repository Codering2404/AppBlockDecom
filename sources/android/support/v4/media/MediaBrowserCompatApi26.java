package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompatApi26 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
        void a(String str, Bundle bundle);

        void b(String str, List list, Bundle bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(String str, List list, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((SubscriptionCallback) this.f175a).b(str, list, bundle);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((SubscriptionCallback) this.f175a).a(str, bundle);
        }
    }
}
