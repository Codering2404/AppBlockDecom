package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi24 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Callback extends MediaSessionCompatApi23.Callback {
        void c(String str, Bundle bundle);

        void f();

        void i(String str, Bundle bundle);

        void o(Uri uri, Bundle bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.f284a).f();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((Callback) this.f284a).c(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((Callback) this.f284a).i(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri uri, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            ((Callback) this.f284a).o(uri, bundle);
        }
    }

    public static String a(Object obj) {
        MediaSession mediaSession = (MediaSession) obj;
        try {
            return (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            Log.e("MediaSessionCompatApi24", "Cannot execute MediaSession.getCallingPackage()", e3);
            return null;
        }
    }
}
