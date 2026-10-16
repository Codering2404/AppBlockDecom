package androidx.media3.exoplayer.audio;

import android.media.AudioAttributes;
import android.media.AudioTrack;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultAudioTrackProvider implements DefaultAudioSink.AudioTrackProvider {
    private AudioTrack b(AudioSink.AudioTrackConfig audioTrackConfig, AudioAttributes audioAttributes, int i3) {
        return new AudioTrack(e(audioAttributes, audioTrackConfig.f43705d), Util.O(audioTrackConfig.f43703b, audioTrackConfig.f43704c, audioTrackConfig.f43702a), audioTrackConfig.f43707f, 1, i3);
    }

    private AudioTrack c(AudioSink.AudioTrackConfig audioTrackConfig, AudioAttributes audioAttributes, int i3) {
        AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(e(audioAttributes, audioTrackConfig.f43705d)).setAudioFormat(Util.O(audioTrackConfig.f43703b, audioTrackConfig.f43704c, audioTrackConfig.f43702a)).setTransferMode(1).setBufferSizeInBytes(audioTrackConfig.f43707f).setSessionId(i3);
        if (Util.f41609a >= 29) {
            g(sessionId, audioTrackConfig.f43706e);
        }
        return d(sessionId).build();
    }

    private android.media.AudioAttributes e(AudioAttributes audioAttributes, boolean z2) {
        return z2 ? f() : audioAttributes.a().f40530a;
    }

    private android.media.AudioAttributes f() {
        return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
    }

    private void g(AudioTrack.Builder builder, boolean z2) {
        builder.setOffloadedPlayback(z2);
    }

    @Override // androidx.media3.exoplayer.audio.DefaultAudioSink.AudioTrackProvider
    public final AudioTrack a(AudioSink.AudioTrackConfig audioTrackConfig, androidx.media3.common.AudioAttributes audioAttributes, int i3) {
        return Util.f41609a >= 23 ? c(audioTrackConfig, audioAttributes, i3) : b(audioTrackConfig, audioAttributes, i3);
    }

    protected AudioTrack.Builder d(AudioTrack.Builder builder) {
        return builder;
    }
}
