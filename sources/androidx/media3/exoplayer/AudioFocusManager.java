package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.audio.AudioFocusRequestCompat;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class AudioFocusManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Supplier f42835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f42836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PlayerControl f42837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AudioAttributes f42838d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f42840f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AudioFocusRequestCompat f42842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f42843i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f42841g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f42839e = 0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PlayerControl {
        void d(float f3);

        void e(int i3);
    }

    public AudioFocusManager(final Context context, Looper looper, PlayerControl playerControl) {
        this.f42835a = Suppliers.a(new Supplier() { // from class: androidx.media3.exoplayer.e
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return AudioManagerCompat.c(context);
            }
        });
        this.f42837c = playerControl;
        this.f42836b = new Handler(looper);
    }

    private void c() {
        int i3 = this.f42839e;
        if (i3 == 1 || i3 == 0 || this.f42842h == null) {
            return;
        }
        AudioManagerCompat.b((AudioManager) this.f42835a.get(), this.f42842h);
    }

    private static int d(AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        switch (audioAttributes.f40526c) {
            case 0:
                Log.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (audioAttributes.f40524a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                Log.i("AudioFocusManager", "Unidentified audio usage: " + audioAttributes.f40526c);
                return 0;
            case 16:
                return 4;
        }
    }

    private void e(int i3) {
        PlayerControl playerControl = this.f42837c;
        if (playerControl != null) {
            playerControl.e(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        if (i3 == -3 || i3 == -2) {
            if (i3 != -2 && !o()) {
                l(4);
                return;
            } else {
                e(0);
                l(3);
                return;
            }
        }
        if (i3 == -1) {
            e(-1);
            c();
            l(1);
        } else if (i3 == 1) {
            l(2);
            e(1);
        } else {
            Log.i("AudioFocusManager", "Unknown focus change type: " + i3);
        }
    }

    private int i() {
        if (this.f42839e == 2) {
            return 1;
        }
        if (j() == 1) {
            l(2);
            return 1;
        }
        l(1);
        return -1;
    }

    private int j() {
        AudioFocusRequestCompat audioFocusRequestCompat = this.f42842h;
        if (audioFocusRequestCompat == null || this.f42843i) {
            this.f42842h = (audioFocusRequestCompat == null ? new AudioFocusRequestCompat.Builder(this.f42840f) : audioFocusRequestCompat.a()).b((AudioAttributes) Assertions.e(this.f42838d)).d(o()).c(new AudioManager.OnAudioFocusChangeListener() { // from class: androidx.media3.exoplayer.d
                @Override // android.media.AudioManager.OnAudioFocusChangeListener
                public final void onAudioFocusChange(int i3) {
                    this.f43968a.g(i3);
                }
            }, this.f42836b).a();
            this.f42843i = false;
        }
        return AudioManagerCompat.h((AudioManager) this.f42835a.get(), this.f42842h);
    }

    private void l(int i3) {
        if (this.f42839e == i3) {
            return;
        }
        this.f42839e = i3;
        float f3 = i3 == 4 ? 0.2f : 1.0f;
        if (this.f42841g == f3) {
            return;
        }
        this.f42841g = f3;
        PlayerControl playerControl = this.f42837c;
        if (playerControl != null) {
            playerControl.d(f3);
        }
    }

    private boolean m(int i3) {
        return i3 != 1 && this.f42840f == 1;
    }

    private boolean o() {
        AudioAttributes audioAttributes = this.f42838d;
        return audioAttributes != null && audioAttributes.f40524a == 1;
    }

    public float f() {
        return this.f42841g;
    }

    public void h() {
        this.f42837c = null;
        c();
        l(0);
    }

    public void k(AudioAttributes audioAttributes) {
        if (Objects.equals(this.f42838d, audioAttributes)) {
            return;
        }
        this.f42838d = audioAttributes;
        int iD = d(audioAttributes);
        this.f42840f = iD;
        boolean z2 = true;
        if (iD != 1 && iD != 0) {
            z2 = false;
        }
        Assertions.b(z2, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public int n(boolean z2, int i3) {
        if (!m(i3)) {
            c();
            l(0);
            return 1;
        }
        if (z2) {
            return i();
        }
        int i4 = this.f42839e;
        if (i4 != 1) {
            return i4 != 3 ? 1 : 0;
        }
        return -1;
    }
}
