package androidx.media3.exoplayer.mediacodec;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface MediaCodecSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MediaCodecSelector f44322a = new MediaCodecSelector() { // from class: androidx.media3.exoplayer.mediacodec.q
        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecSelector
        public final List b(String str, boolean z2, boolean z3) {
            return MediaCodecUtil.l(str, z2, z3);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaCodecSelector f44323b = new MediaCodecSelector() { // from class: androidx.media3.exoplayer.mediacodec.r
        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecSelector
        public final List b(String str, boolean z2, boolean z3) {
            return MediaCodecUtil.q(MediaCodecSelector.f44322a.b(str, z2, z3));
        }
    };

    List b(String str, boolean z2, boolean z3);
}
