package androidx.media3.common.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BackgroundExecutor;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioManagerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AudioManager f41277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f41278b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioFocusGain {
    }

    public static /* synthetic */ void a(Context context, ConditionVariable conditionVariable) {
        f41277a = (AudioManager) context.getSystemService("audio");
        conditionVariable.f();
    }

    public static int b(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        return Util.f41609a >= 26 ? audioManager.abandonAudioFocusRequest(audioFocusRequestCompat.c()) : audioManager.abandonAudioFocus(audioFocusRequestCompat.f());
    }

    public static synchronized AudioManager c(Context context) {
        try {
            final Context applicationContext = context.getApplicationContext();
            if (f41278b != applicationContext) {
                f41277a = null;
            }
            AudioManager audioManager = f41277a;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                final ConditionVariable conditionVariable = new ConditionVariable();
                BackgroundExecutor.a().execute(new Runnable() { // from class: androidx.media3.common.audio.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        AudioManagerCompat.a(applicationContext, conditionVariable);
                    }
                });
                conditionVariable.c();
                return (AudioManager) Assertions.e(f41277a);
            }
            AudioManager audioManager2 = (AudioManager) applicationContext.getSystemService("audio");
            f41277a = audioManager2;
            return (AudioManager) Assertions.e(audioManager2);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static int d(AudioManager audioManager, int i3) {
        return audioManager.getStreamMaxVolume(i3);
    }

    public static int e(AudioManager audioManager, int i3) {
        if (Util.f41609a >= 28) {
            return audioManager.getStreamMinVolume(i3);
        }
        return 0;
    }

    public static int f(AudioManager audioManager, int i3) {
        try {
            return audioManager.getStreamVolume(i3);
        } catch (RuntimeException e3) {
            Log.j("AudioManagerCompat", "Could not retrieve stream volume for stream type " + i3, e3);
            return audioManager.getStreamMaxVolume(i3);
        }
    }

    public static boolean g(AudioManager audioManager, int i3) {
        return Util.f41609a >= 23 ? audioManager.isStreamMute(i3) : f(audioManager, i3) == 0;
    }

    public static int h(AudioManager audioManager, AudioFocusRequestCompat audioFocusRequestCompat) {
        return Util.f41609a >= 26 ? audioManager.requestAudioFocus(audioFocusRequestCompat.c()) : audioManager.requestAudioFocus(audioFocusRequestCompat.f(), audioFocusRequestCompat.b().b(), audioFocusRequestCompat.e());
    }
}
