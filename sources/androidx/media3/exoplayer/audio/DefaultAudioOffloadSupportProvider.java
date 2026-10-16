package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.audio.AudioManagerCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioOffloadSupport;
import androidx.media3.exoplayer.audio.DefaultAudioSink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAudioOffloadSupportProvider implements DefaultAudioSink.AudioOffloadSupportProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f43767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f43768b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api29 {
        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z2) {
            return !AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes) ? AudioOffloadSupport.f43693d : new AudioOffloadSupport.Builder().e(true).g(z2).d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api31 {
        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z2) {
            int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            if (playbackOffloadSupport == 0) {
                return AudioOffloadSupport.f43693d;
            }
            return new AudioOffloadSupport.Builder().e(true).f(Util.f41609a > 32 && playbackOffloadSupport == 2).g(z2).d();
        }
    }

    public DefaultAudioOffloadSupportProvider(Context context) {
        this.f43767a = context;
    }

    private boolean b(Context context) {
        Boolean bool = this.f43768b;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context != null) {
            String parameters = AudioManagerCompat.c(context).getParameters("offloadVariableRateSupported");
            this.f43768b = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
        } else {
            this.f43768b = Boolean.FALSE;
        }
        return this.f43768b.booleanValue();
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.AudioOffloadSupportProvider
    public AudioOffloadSupport a(Format format, androidx.media3.common.AudioAttributes audioAttributes) {
        Assertions.e(format);
        Assertions.e(audioAttributes);
        int i3 = Util.f41609a;
        if (i3 < 29 || format.F == -1) {
            return AudioOffloadSupport.f43693d;
        }
        boolean zB = b(this.f43767a);
        int iE = MimeTypes.e((String) Assertions.e(format.f40632o), format.f40628k);
        if (iE == 0 || i3 < Util.N(iE)) {
            return AudioOffloadSupport.f43693d;
        }
        int iP = Util.P(format.E);
        if (iP == 0) {
            return AudioOffloadSupport.f43693d;
        }
        try {
            AudioFormat audioFormatO = Util.O(format.F, iP, iE);
            return i3 >= 31 ? Api31.a(audioFormatO, audioAttributes.a().f40530a, zB) : Api29.a(audioFormatO, audioAttributes.a().f40530a, zB);
        } catch (IllegalArgumentException unused) {
            return AudioOffloadSupport.f43693d;
        }
    }
}
