package androidx.media3.common.audio;

import androidx.media3.common.PlaybackParameters;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface AudioProcessorChain {
    long a(long j3);

    AudioProcessor[] b();

    PlaybackParameters c(PlaybackParameters playbackParameters);

    long d();

    boolean e(boolean z2);
}
