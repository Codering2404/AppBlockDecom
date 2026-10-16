package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlUtil;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public final class SingleColorLut implements ColorLut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f42598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f42599b;

    @Override // androidx.media3.effect.ColorLut
    public int h(long j3) {
        return this.f42598a.getWidth();
    }

    @Override // androidx.media3.effect.ColorLut
    public void release() throws GlUtil.GlException {
        GlUtil.D(this.f42599b);
    }

    @Override // androidx.media3.effect.ColorLut, androidx.media3.effect.GlEffect
    public BaseGlShaderProgram a(Context context, boolean z2) throws VideoFrameProcessingException {
        Assertions.h(!z2, "HDR is currently not supported.");
        try {
            this.f42599b = GlUtil.v(this.f42598a);
            return new ColorLutShaderProgram(context, this, z2);
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException("Could not store the LUT as a texture.", e3);
        }
    }

    @Override // androidx.media3.effect.ColorLut
    public int f(long j3) {
        Assertions.h(this.f42599b != -1, HcgZcEUYo.qnJcAGkmFKWX);
        return this.f42599b;
    }
}
