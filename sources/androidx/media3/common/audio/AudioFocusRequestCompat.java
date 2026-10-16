package androidx.media3.common.audio;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioFocusRequestCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f41264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AudioManager.OnAudioFocusChangeListener f41265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f41266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AudioAttributes f41267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f41268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f41269f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f41270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AudioManager.OnAudioFocusChangeListener f41271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Handler f41272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private AudioAttributes f41273d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f41274e;

        public AudioFocusRequestCompat a() {
            AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f41271b;
            if (onAudioFocusChangeListener != null) {
                return new AudioFocusRequestCompat(this.f41270a, onAudioFocusChangeListener, (Handler) Assertions.e(this.f41272c), this.f41273d, this.f41274e);
            }
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }

        public Builder b(AudioAttributes audioAttributes) {
            Assertions.e(audioAttributes);
            this.f41273d = audioAttributes;
            return this;
        }

        public Builder c(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            Assertions.e(onAudioFocusChangeListener);
            Assertions.e(handler);
            this.f41271b = onAudioFocusChangeListener;
            this.f41272c = handler;
            return this;
        }

        public Builder d(boolean z2) {
            this.f41274e = z2;
            return this;
        }

        public Builder(int i3) {
            this.f41273d = AudioAttributes.f40518g;
            this.f41270a = i3;
        }

        private Builder(AudioFocusRequestCompat audioFocusRequestCompat) {
            this.f41270a = audioFocusRequestCompat.e();
            this.f41271b = audioFocusRequestCompat.f();
            this.f41272c = audioFocusRequestCompat.d();
            this.f41273d = audioFocusRequestCompat.b();
            this.f41274e = audioFocusRequestCompat.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class OnAudioFocusChangeListenerHandlerCompat implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f41275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AudioManager.OnAudioFocusChangeListener f41276b;

        OnAudioFocusChangeListenerHandlerCompat(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
            this.f41276b = onAudioFocusChangeListener;
            this.f41275a = Util.B(handler.getLooper(), null);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i3) {
            Util.W0(this.f41275a, new Runnable() { // from class: androidx.media3.common.audio.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f41359a.f41276b.onAudioFocusChange(i3);
                }
            });
        }
    }

    AudioFocusRequestCompat(int i3, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, AudioAttributes audioAttributes, boolean z2) {
        this.f41264a = i3;
        this.f41266c = handler;
        this.f41267d = audioAttributes;
        this.f41268e = z2;
        int i4 = Util.f41609a;
        if (i4 < 26) {
            this.f41265b = new OnAudioFocusChangeListenerHandlerCompat(onAudioFocusChangeListener, handler);
        } else {
            this.f41265b = onAudioFocusChangeListener;
        }
        if (i4 >= 26) {
            this.f41269f = new AudioFocusRequest.Builder(i3).setAudioAttributes(audioAttributes.a().f40530a).setWillPauseWhenDucked(z2).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).build();
        } else {
            this.f41269f = null;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public AudioAttributes b() {
        return this.f41267d;
    }

    AudioFocusRequest c() {
        return (AudioFocusRequest) Assertions.e(this.f41269f);
    }

    public Handler d() {
        return this.f41266c;
    }

    public int e() {
        return this.f41264a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioFocusRequestCompat)) {
            return false;
        }
        AudioFocusRequestCompat audioFocusRequestCompat = (AudioFocusRequestCompat) obj;
        return this.f41264a == audioFocusRequestCompat.f41264a && this.f41268e == audioFocusRequestCompat.f41268e && Objects.equals(this.f41265b, audioFocusRequestCompat.f41265b) && Objects.equals(this.f41266c, audioFocusRequestCompat.f41266c) && Objects.equals(this.f41267d, audioFocusRequestCompat.f41267d);
    }

    public AudioManager.OnAudioFocusChangeListener f() {
        return this.f41265b;
    }

    public boolean g() {
        return this.f41268e;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f41264a), this.f41265b, this.f41266c, this.f41267d, Boolean.valueOf(this.f41268e));
    }
}
