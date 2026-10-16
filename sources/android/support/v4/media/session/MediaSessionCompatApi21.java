package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.ResultReceiver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi21 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface Callback {
        void a();

        void b(String str, Bundle bundle, ResultReceiver resultReceiver);

        void d();

        boolean e(Intent intent);

        void g(String str, Bundle bundle);

        void h(String str, Bundle bundle);

        void k();

        void l(long j3);

        void m(Object obj);

        void n();

        void onPause();

        void onStop();

        void p(String str, Bundle bundle);

        void q();

        void r(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CallbackProxy<T extends Callback> extends MediaSession.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Callback f284a;

        @Override // android.media.session.MediaSession.Callback
        public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            MediaSessionCompat.a(bundle);
            this.f284a.b(str, bundle, resultReceiver);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onCustomAction(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f284a.h(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onFastForward() {
            this.f284a.q();
        }

        @Override // android.media.session.MediaSession.Callback
        public boolean onMediaButtonEvent(Intent intent) {
            return this.f284a.e(intent) || super.onMediaButtonEvent(intent);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPause() {
            this.f284a.onPause();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlay() {
            this.f284a.n();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromMediaId(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f284a.p(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromSearch(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f284a.g(str, bundle);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onRewind() {
            this.f284a.k();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSeekTo(long j3) {
            this.f284a.r(j3);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSetRating(Rating rating) {
            this.f284a.m(rating);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToNext() {
            this.f284a.a();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToPrevious() {
            this.f284a.d();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onSkipToQueueItem(long j3) {
            this.f284a.l(j3);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onStop() {
            this.f284a.onStop();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class QueueItem {
        public static Object a(Object obj) {
            return ((MediaSession.QueueItem) obj).getDescription();
        }

        public static long b(Object obj) {
            return ((MediaSession.QueueItem) obj).getQueueId();
        }
    }

    public static Object a(Object obj) {
        if (obj instanceof MediaSession.Token) {
            return obj;
        }
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}
