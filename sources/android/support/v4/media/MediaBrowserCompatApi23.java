package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompatApi23 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ItemCallback {
        void a(Parcel parcel);

        void onError(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ItemCallbackProxy<T extends ItemCallback> extends MediaBrowser.ItemCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final ItemCallback f176a;

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onError(String str) {
            this.f176a.onError(str);
        }

        @Override // android.media.browse.MediaBrowser.ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
            if (mediaItem == null) {
                this.f176a.a(null);
                return;
            }
            Parcel parcelObtain = Parcel.obtain();
            mediaItem.writeToParcel(parcelObtain, 0);
            this.f176a.a(parcelObtain);
        }
    }
}
