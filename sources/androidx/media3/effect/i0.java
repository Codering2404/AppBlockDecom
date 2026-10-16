package androidx.media3.effect;

import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.effect.GlShaderProgram;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class i0 implements GlShaderProgram.ErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoFrameProcessor.Listener f42733a;

    @Override // androidx.media3.effect.GlShaderProgram.ErrorListener
    public final void a(VideoFrameProcessingException videoFrameProcessingException) {
        this.f42733a.a(videoFrameProcessingException);
    }
}
