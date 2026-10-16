package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompatApi21;
import android.support.v4.media.session.MediaSessionCompatApi23;
import android.support.v4.media.session.MediaSessionCompatApi24;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends Callback {
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends Callback {
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends Callback {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface MediaSessionImpl {
        void a(MediaSessionManager.RemoteUserInfo remoteUserInfo);

        PlaybackStateCompat p();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaSessionImplApi18 extends MediaSessionImplBase {

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements RemoteControlClient.OnPlaybackPositionUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionImplApi18 f235a;

            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public void onPlaybackPositionUpdate(long j3) {
                this.f235a.c(18, -1, -1, Long.valueOf(j3), null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements RemoteControlClient.OnMetadataUpdateListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionImplApi19 f236a;

            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public void onMetadataUpdate(int i3, Object obj) {
                if (i3 == 268435457 && (obj instanceof Rating)) {
                    this.f236a.c(19, -1, -1, RatingCompat.a(obj), null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnActiveChangeListener {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() { // from class: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i3) {
                return new ResultReceiverWrapper[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ResultReceiver f280a;

        ResultReceiverWrapper(Parcel parcel) {
            this.f280a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            this.f280a.writeToParcel(parcel, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() { // from class: android.support.v4.media.session.MediaSessionCompat.Token.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i3) {
                return new Token[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IMediaSession f282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bundle f283c;

        Token(Object obj) {
            this(obj, null, null);
        }

        public static Token a(Object obj) {
            return c(obj, null);
        }

        public static Token c(Object obj, IMediaSession iMediaSession) {
            if (obj != null) {
                return new Token(MediaSessionCompatApi21.a(obj), iMediaSession);
            }
            return null;
        }

        public IMediaSession d() {
            return this.f282b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Bundle e() {
            return this.f283c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f281a;
            if (obj2 == null) {
                return token.f281a == null;
            }
            Object obj3 = token.f281a;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public Object f() {
            return this.f281a;
        }

        public void g(IMediaSession iMediaSession) {
            this.f282b = iMediaSession;
        }

        public void h(Bundle bundle) {
            this.f283c = bundle;
        }

        public int hashCode() {
            Object obj = this.f281a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeParcelable((Parcelable) this.f281a, i3);
        }

        Token(Object obj, IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            this.f281a = obj;
            this.f282b = iMediaSession;
            this.f283c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    static PlaybackStateCompat b(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long jD = -1;
        if (playbackStateCompat.f() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.g() != 3 && playbackStateCompat.g() != 4 && playbackStateCompat.g() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.d() <= 0) {
            return playbackStateCompat;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jE = ((long) (playbackStateCompat.e() * (jElapsedRealtime - r0))) + playbackStateCompat.f();
        if (mediaMetadataCompat != null && mediaMetadataCompat.a("android.media.metadata.DURATION")) {
            jD = mediaMetadataCompat.d("android.media.metadata.DURATION");
        }
        return new PlaybackStateCompat.Builder(playbackStateCompat).b(playbackStateCompat.g(), (jD < 0 || jE <= jD) ? jE < 0 ? 0L : jE : jD, playbackStateCompat.e(), jElapsedRealtime).a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() { // from class: android.support.v4.media.session.MediaSessionCompat.QueueItem.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i3) {
                return new QueueItem[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaDescriptionCompat f277a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f278b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f279c;

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j3) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j3 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f277a = mediaDescriptionCompat;
            this.f278b = j3;
            this.f279c = obj;
        }

        public static QueueItem a(Object obj) {
            if (obj != null) {
                return new QueueItem(obj, MediaDescriptionCompat.a(MediaSessionCompatApi21.QueueItem.a(obj)), MediaSessionCompatApi21.QueueItem.b(obj));
            }
            return null;
        }

        public static List c(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        public MediaDescriptionCompat d() {
            return this.f277a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f277a + ", Id=" + this.f278b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            this.f277a.writeToParcel(parcel, i3);
            parcel.writeLong(this.f278b);
        }

        QueueItem(Parcel parcel) {
            this.f277a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f278b = parcel.readLong();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference f228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CallbackHandler f229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f230c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class CallbackHandler extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Callback f231a;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    this.f231a.a((MediaSessionManager.RemoteUserInfo) message.obj);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class StubApi21 implements MediaSessionCompatApi21.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Callback f232a;

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void a() {
                this.f232a.y();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void b(String str, Bundle bundle, ResultReceiver resultReceiver) {
                try {
                    QueueItem queueItem = null;
                    IBinder iBinderAsBinder = null;
                    queueItem = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        MediaSessionImplApi21 mediaSessionImplApi21 = (MediaSessionImplApi21) this.f232a.f228a.get();
                        if (mediaSessionImplApi21 != null) {
                            Bundle bundle2 = new Bundle();
                            Token tokenC = mediaSessionImplApi21.c();
                            IMediaSession iMediaSessionD = tokenC.d();
                            if (iMediaSessionD != null) {
                                iBinderAsBinder = iMediaSessionD.asBinder();
                            }
                            BundleCompat.b(bundle2, "android.support.v4.media.session.EXTRA_BINDER", iBinderAsBinder);
                            bundle2.putBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE", tokenC.e());
                            resultReceiver.send(0, bundle2);
                            return;
                        }
                        return;
                    }
                    if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        this.f232a.b((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                        return;
                    }
                    if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        this.f232a.c((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                        return;
                    }
                    if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        this.f232a.q((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                        return;
                    }
                    if (!str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        this.f232a.d(str, bundle, resultReceiver);
                        return;
                    }
                    MediaSessionImplApi21 mediaSessionImplApi212 = (MediaSessionImplApi21) this.f232a.f228a.get();
                    if (mediaSessionImplApi212 == null || mediaSessionImplApi212.f242f == null) {
                        return;
                    }
                    int i3 = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                    if (i3 >= 0 && i3 < mediaSessionImplApi212.f242f.size()) {
                        queueItem = (QueueItem) mediaSessionImplApi212.f242f.get(i3);
                    }
                    if (queueItem != null) {
                        this.f232a.q(queueItem.d());
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void d() {
                this.f232a.z();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean e(Intent intent) {
                return this.f232a.g(intent);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void g(String str, Bundle bundle) {
                this.f232a.k(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void h(String str, Bundle bundle) {
                Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                MediaSessionCompat.a(bundle2);
                if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                    this.f232a.l((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                    return;
                }
                if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                    this.f232a.m();
                    return;
                }
                if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    this.f232a.n(bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID"), bundle2);
                    return;
                }
                if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    this.f232a.o(bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY"), bundle2);
                    return;
                }
                if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    this.f232a.p((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                    return;
                }
                if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                    this.f232a.t(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    return;
                }
                if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                    this.f232a.w(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                    this.f232a.x(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                } else if (!str.equals("android.support.v4.media.session.action.SET_RATING")) {
                    this.f232a.e(str, bundle);
                } else {
                    this.f232a.v((RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), bundle2);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void k() {
                this.f232a.r();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void l(long j3) {
                this.f232a.A(j3);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void m(Object obj) {
                this.f232a.u(RatingCompat.a(obj));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void n() {
                this.f232a.i();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                this.f232a.h();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                this.f232a.B();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void p(String str, Bundle bundle) {
                this.f232a.j(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void q() {
                this.f232a.f();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void r(long j3) {
                this.f232a.s(j3);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Callback f233b;

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void j(Uri uri, Bundle bundle) {
                this.f233b.l(uri, bundle);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ Callback f234c;

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void c(String str, Bundle bundle) {
                this.f234c.n(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void f() {
                this.f234c.m();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void i(String str, Bundle bundle) {
                this.f234c.o(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void o(Uri uri, Bundle bundle) {
                this.f234c.p(uri, bundle);
            }
        }

        void a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            if (this.f230c) {
                this.f230c = false;
                this.f229b.removeMessages(1);
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f228a.get();
                if (mediaSessionImpl == null) {
                    return;
                }
                PlaybackStateCompat playbackStateCompatP = mediaSessionImpl.p();
                long jC = playbackStateCompatP == null ? 0L : playbackStateCompatP.c();
                boolean z2 = playbackStateCompatP != null && playbackStateCompatP.g() == 3;
                boolean z3 = (516 & jC) != 0;
                boolean z4 = (jC & 514) != 0;
                mediaSessionImpl.a(remoteUserInfo);
                if (z2 && z4) {
                    h();
                } else if (!z2 && z3) {
                    i();
                }
                mediaSessionImpl.a(null);
            }
        }

        public boolean g(Intent intent) {
            return false;
        }

        public void B() {
        }

        public void f() {
        }

        public void h() {
        }

        public void i() {
        }

        public void m() {
        }

        public void r() {
        }

        public void y() {
        }

        public void z() {
        }

        public void A(long j3) {
        }

        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void q(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void s(long j3) {
        }

        public void t(boolean z2) {
        }

        public void u(RatingCompat ratingCompat) {
        }

        public void w(int i3) {
        }

        public void x(int i3) {
        }

        public void c(MediaDescriptionCompat mediaDescriptionCompat, int i3) {
        }

        public void e(String str, Bundle bundle) {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l(Uri uri, Bundle bundle) {
        }

        public void n(String str, Bundle bundle) {
        }

        public void o(String str, Bundle bundle) {
        }

        public void p(Uri uri, Bundle bundle) {
        }

        public void v(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaSessionImplApi21 implements MediaSessionImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Token f238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f239c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final RemoteCallbackList f240d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        PlaybackStateCompat f241e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        List f242f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        MediaMetadataCompat f243g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f244h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f245i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f246j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f247k;

        public String b() {
            return MediaSessionCompatApi24.a(this.f237a);
        }

        public Token c() {
            return this.f238b;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat p() {
            return this.f241e;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class ExtraSession extends IMediaSession.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionImplApi21 f248a;

            @Override // android.support.v4.media.session.IMediaSession
            public void A0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long C() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void C0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean C1() {
                return this.f248a.f245i;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int D() {
                return this.f248a.f246j;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void D2(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean F2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void G2(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void H(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void H0(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void K1(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void K2(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean M() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo M4() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void O(Uri uri, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void O3(int i3, int i4, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void S1(long j3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void X3(boolean z2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence Y2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent Z() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void a2(int i3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean b1(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String c() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String c2() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void e() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int f0() {
                return this.f248a.f244h;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void f1(RatingCompat ratingCompat, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void f3(IMediaControllerCallback iMediaControllerCallback) {
                this.f248a.f240d.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void i1(MediaDescriptionCompat mediaDescriptionCompat, int i3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void j3() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat o() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat p() {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.f248a;
                return MediaSessionCompat.b(mediaSessionImplApi21.f241e, mediaSessionImplApi21.f243g);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void p2(IMediaControllerCallback iMediaControllerCallback) {
                MediaSessionImplApi21 mediaSessionImplApi21 = this.f248a;
                if (mediaSessionImplApi21.f239c) {
                    return;
                }
                String strB = mediaSessionImplApi21.b();
                if (strB == null) {
                    strB = "android.media.session.MediaController";
                }
                this.f248a.f240d.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo(strB, Binder.getCallingPid(), Binder.getCallingUid()));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void q() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void r() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void r2(RatingCompat ratingCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void t2(int i3, int i4, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List u4() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void v(long j3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int v1() {
                return this.f248a.f247k;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void x0(String str, Bundle bundle) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void x1(int i3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void y4(int i3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void T1(boolean z2) {
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaSessionImplBase implements MediaSessionImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AudioManager f251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object f252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final RemoteCallbackList f253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MessageHandler f254f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f255g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile Callback f256h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private MediaSessionManager.RemoteUserInfo f257i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f258j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        MediaMetadataCompat f259k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        PlaybackStateCompat f260l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        PendingIntent f261m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        List f262n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        CharSequence f263o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f264p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f265q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f266r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f267s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Bundle f268t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int f269u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        int f270v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        VolumeProviderCompat f271w;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends VolumeProviderCompat.Callback {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class Command {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f272a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Bundle f273b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ResultReceiver f274c;

            public Command(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f272a = str;
                this.f273b = bundle;
                this.f274c = resultReceiver;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class MessageHandler extends Handler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionImplBase f276a;

            private void a(KeyEvent keyEvent, Callback callback) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                PlaybackStateCompat playbackStateCompat = this.f276a.f260l;
                long jC = playbackStateCompat == null ? 0L : playbackStateCompat.c();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79) {
                    if (keyCode == 126) {
                        if ((jC & 4) != 0) {
                            callback.i();
                            return;
                        }
                        return;
                    }
                    if (keyCode == 127) {
                        if ((jC & 2) != 0) {
                            callback.h();
                            return;
                        }
                        return;
                    }
                    switch (keyCode) {
                        case 86:
                            if ((jC & 1) != 0) {
                                callback.B();
                            }
                            break;
                        case 87:
                            if ((jC & 32) != 0) {
                                callback.y();
                            }
                            break;
                        case 88:
                            if ((jC & 16) != 0) {
                                callback.z();
                            }
                            break;
                        case 89:
                            if ((jC & 8) != 0) {
                                callback.r();
                            }
                            break;
                        case 90:
                            if ((jC & 64) != 0) {
                                callback.f();
                            }
                            break;
                    }
                    return;
                }
                Log.w("MediaSessionCompat", "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Callback callback = this.f276a.f256h;
                if (callback == null) {
                    return;
                }
                Bundle data = message.getData();
                MediaSessionCompat.a(data);
                this.f276a.a(new MediaSessionManager.RemoteUserInfo(data.getString("data_calling_pkg"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                Bundle bundle = data.getBundle("data_extras");
                MediaSessionCompat.a(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            Command command = (Command) message.obj;
                            callback.d(command.f272a, command.f273b, command.f274c);
                            break;
                        case 2:
                            this.f276a.b(message.arg1, 0);
                            break;
                        case 3:
                            callback.m();
                            break;
                        case 4:
                            callback.n((String) message.obj, bundle);
                            break;
                        case 5:
                            callback.o((String) message.obj, bundle);
                            break;
                        case 6:
                            callback.p((Uri) message.obj, bundle);
                            break;
                        case 7:
                            callback.i();
                            break;
                        case 8:
                            callback.j((String) message.obj, bundle);
                            break;
                        case 9:
                            callback.k((String) message.obj, bundle);
                            break;
                        case 10:
                            callback.l((Uri) message.obj, bundle);
                            break;
                        case 11:
                            callback.A(((Long) message.obj).longValue());
                            break;
                        case 12:
                            callback.h();
                            break;
                        case 13:
                            callback.B();
                            break;
                        case 14:
                            callback.y();
                            break;
                        case 15:
                            callback.z();
                            break;
                        case 16:
                            callback.f();
                            break;
                        case 17:
                            callback.r();
                            break;
                        case 18:
                            callback.s(((Long) message.obj).longValue());
                            break;
                        case 19:
                            callback.u((RatingCompat) message.obj);
                            break;
                        case 20:
                            callback.e((String) message.obj, bundle);
                            break;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.g(intent)) {
                                a(keyEvent, callback);
                            }
                            break;
                        case 22:
                            this.f276a.d(message.arg1, 0);
                            break;
                        case 23:
                            callback.w(message.arg1);
                            break;
                        case 25:
                            callback.b((MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            callback.c((MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            callback.q((MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            List list = this.f276a.f262n;
                            if (list != null) {
                                int i3 = message.arg1;
                                QueueItem queueItem = (i3 < 0 || i3 >= list.size()) ? null : (QueueItem) this.f276a.f262n.get(message.arg1);
                                if (queueItem != null) {
                                    callback.q(queueItem.d());
                                }
                            }
                            break;
                        case 29:
                            callback.t(((Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            callback.x(message.arg1);
                            break;
                        case 31:
                            callback.v((RatingCompat) message.obj, bundle);
                            break;
                    }
                } finally {
                    this.f276a.a(null);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.f252d) {
                this.f257i = remoteUserInfo;
            }
        }

        void b(int i3, int i4) {
            if (this.f269u != 2) {
                this.f251c.adjustStreamVolume(this.f270v, i3, i4);
                return;
            }
            VolumeProviderCompat volumeProviderCompat = this.f271w;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.d(i3);
            }
        }

        void c(int i3, int i4, int i5, Object obj, Bundle bundle) {
            synchronized (this.f252d) {
                try {
                    MessageHandler messageHandler = this.f254f;
                    if (messageHandler != null) {
                        Message messageObtainMessage = messageHandler.obtainMessage(i3, i4, i5, obj);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("data_calling_pkg", "android.media.session.MediaController");
                        bundle2.putInt("data_calling_pid", Binder.getCallingPid());
                        bundle2.putInt("data_calling_uid", Binder.getCallingUid());
                        if (bundle != null) {
                            bundle2.putBundle("data_extras", bundle);
                        }
                        messageObtainMessage.setData(bundle2);
                        messageObtainMessage.sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void d(int i3, int i4) {
            if (this.f269u != 2) {
                this.f251c.setStreamVolume(this.f270v, i3, i4);
                return;
            }
            VolumeProviderCompat volumeProviderCompat = this.f271w;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.e(i3);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat p() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.f252d) {
                playbackStateCompat = this.f260l;
            }
            return playbackStateCompat;
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class MediaSessionStub extends IMediaSession.Stub {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ MediaSessionImplBase f275a;

            @Override // android.support.v4.media.session.IMediaSession
            public void A0(String str, Bundle bundle) {
                l5(8, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long C() {
                long j3;
                synchronized (this.f275a.f252d) {
                    j3 = this.f275a.f258j;
                }
                return j3;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void C0(String str, Bundle bundle) {
                l5(9, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean C1() {
                return this.f275a.f265q;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int D() {
                return this.f275a.f266r;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void D2(MediaDescriptionCompat mediaDescriptionCompat) {
                j5(27, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean F2() {
                return (this.f275a.f258j & 2) != 0;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void G2(MediaDescriptionCompat mediaDescriptionCompat) {
                j5(25, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void H(String str, Bundle bundle) {
                l5(20, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void H0(Uri uri, Bundle bundle) {
                l5(10, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void K1(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                j5(1, new Command(str, bundle, resultReceiverWrapper.f280a));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void K2(String str, Bundle bundle) {
                l5(5, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean M() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo M4() {
                int i3;
                int i4;
                int iC;
                int streamMaxVolume;
                int streamVolume;
                int i5;
                int i6;
                synchronized (this.f275a.f252d) {
                    try {
                        MediaSessionImplBase mediaSessionImplBase = this.f275a;
                        i3 = mediaSessionImplBase.f269u;
                        i4 = mediaSessionImplBase.f270v;
                        VolumeProviderCompat volumeProviderCompat = mediaSessionImplBase.f271w;
                        iC = 2;
                        if (i3 == 2) {
                            iC = volumeProviderCompat.c();
                            streamMaxVolume = volumeProviderCompat.b();
                            streamVolume = volumeProviderCompat.a();
                        } else {
                            streamMaxVolume = mediaSessionImplBase.f251c.getStreamMaxVolume(i4);
                            streamVolume = this.f275a.f251c.getStreamVolume(i4);
                        }
                        i5 = streamMaxVolume;
                        i6 = streamVolume;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return new ParcelableVolumeInfo(i3, i4, iC, i5, i6);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void O(Uri uri, Bundle bundle) {
                l5(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void O3(int i3, int i4, String str) {
                this.f275a.b(i3, i4);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void S1(long j3) {
                j5(11, Long.valueOf(j3));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void X3(boolean z2) {
                j5(29, Boolean.valueOf(z2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence Y2() {
                return this.f275a.f263o;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent Z() {
                PendingIntent pendingIntent;
                synchronized (this.f275a.f252d) {
                    pendingIntent = this.f275a.f261m;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void a2(int i3) {
                i5(30, i3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean b1(KeyEvent keyEvent) {
                boolean z2 = (this.f275a.f258j & 1) != 0;
                if (z2) {
                    j5(21, keyEvent);
                }
                return z2;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String c() {
                return this.f275a.f250b;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String c2() {
                return this.f275a.f249a;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void e() {
                h5(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int f0() {
                return this.f275a.f264p;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void f1(RatingCompat ratingCompat, Bundle bundle) {
                l5(31, ratingCompat, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void f3(IMediaControllerCallback iMediaControllerCallback) {
                this.f275a.f253e.unregister(iMediaControllerCallback);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (this.f275a.f252d) {
                    bundle = this.f275a.f268t;
                }
                return bundle;
            }

            void h5(int i3) {
                this.f275a.c(i3, 0, 0, null, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void i1(MediaDescriptionCompat mediaDescriptionCompat, int i3) {
                k5(26, mediaDescriptionCompat, i3);
            }

            void i5(int i3, int i4) {
                this.f275a.c(i3, i4, 0, null, null);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void j3() {
                h5(16);
            }

            void j5(int i3, Object obj) {
                this.f275a.c(i3, 0, 0, obj, null);
            }

            void k5(int i3, Object obj, int i4) {
                this.f275a.c(i3, i4, 0, obj, null);
            }

            void l5(int i3, Object obj, Bundle bundle) {
                this.f275a.c(i3, 0, 0, obj, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() {
                h5(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat o() {
                return this.f275a.f259k;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat p() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (this.f275a.f252d) {
                    MediaSessionImplBase mediaSessionImplBase = this.f275a;
                    playbackStateCompat = mediaSessionImplBase.f260l;
                    mediaMetadataCompat = mediaSessionImplBase.f259k;
                }
                return MediaSessionCompat.b(playbackStateCompat, mediaMetadataCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void p2(IMediaControllerCallback iMediaControllerCallback) {
                if (this.f275a.f255g) {
                    try {
                        iMediaControllerCallback.h();
                    } catch (Exception unused) {
                    }
                } else {
                    this.f275a.f253e.register(iMediaControllerCallback, new MediaSessionManager.RemoteUserInfo("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() {
                h5(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() {
                h5(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void q() {
                h5(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void r() {
                h5(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void r2(RatingCompat ratingCompat) {
                j5(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() {
                h5(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void t2(int i3, int i4, String str) {
                this.f275a.d(i3, i4);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List u4() {
                List list;
                synchronized (this.f275a.f252d) {
                    list = this.f275a.f262n;
                }
                return list;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void v(long j3) {
                j5(18, Long.valueOf(j3));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int v1() {
                return this.f275a.f267s;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void x0(String str, Bundle bundle) {
                l5(4, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void x1(int i3) {
                i5(28, i3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void y4(int i3) {
                i5(23, i3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void T1(boolean z2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }
    }
}
