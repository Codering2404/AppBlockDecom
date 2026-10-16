package androidx.media3.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Gainmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
final class OverlayShaderProgram extends BaseGlShaderProgram {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlProgram f42514h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SamplerOverlayMatrixProvider f42515i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImmutableList f42516j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f42517k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final SparseArray f42518l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SparseIntArray f42519m;

    public OverlayShaderProgram(Context context, boolean z2, ImmutableList immutableList) throws VideoFrameProcessingException {
        super(z2, 1);
        if (z2) {
            this.f42517k = u(immutableList);
        } else {
            this.f42517k = null;
            Assertions.b(immutableList.size() <= 15, "OverlayShaderProgram does not support more than 15 SDR overlays in the same instance.");
        }
        this.f42516j = immutableList;
        this.f42515i = new SamplerOverlayMatrixProvider();
        this.f42518l = new SparseArray();
        this.f42519m = new SparseIntArray();
        try {
            GlProgram glProgram = new GlProgram(t(immutableList.size()), s(context, immutableList.size(), this.f42517k));
            this.f42514h = glProgram;
            glProgram.m("aFramePosition", GlUtil.O(), 4);
        } catch (GlUtil.GlException | IOException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    private static String t(int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("#version 100\n");
        sb.append("attribute vec4 aFramePosition;\n");
        sb.append("varying vec2 vVideoTexSamplingCoord0;\n");
        for (int i4 = 1; i4 <= i3; i4++) {
            sb.append(Util.J("uniform mat4 uTransformationMatrix%s;\n", Integer.valueOf(i4)));
            sb.append(Util.J("uniform mat4 uVertexTransformationMatrix%s;\n", Integer.valueOf(i4)));
            sb.append(Util.J("varying vec2 vOverlayTexSamplingCoord%s;\n", Integer.valueOf(i4)));
        }
        sb.append("vec2 getTexSamplingCoord(vec2 ndcPosition){\n");
        sb.append("  return vec2(ndcPosition.x * 0.5 + 0.5, ndcPosition.y * 0.5 + 0.5);\n");
        sb.append("}\n");
        sb.append("void main() {\n");
        sb.append("  gl_Position = aFramePosition;\n");
        sb.append("  vVideoTexSamplingCoord0 = getTexSamplingCoord(aFramePosition.xy);\n");
        for (int i5 = 1; i5 <= i3; i5++) {
            sb.append(v("      vec4 aOverlayPosition% =\n  uVertexTransformationMatrix% * uTransformationMatrix% * aFramePosition;\nvOverlayTexSamplingCoord% = getTexSamplingCoord(aOverlayPosition%.xy);", i5));
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int[] u(ImmutableList immutableList) {
        int[] iArr = new int[immutableList.size()];
        int i3 = 15;
        for (int i4 = 0; i4 < immutableList.size(); i4++) {
            TextureOverlay textureOverlay = (TextureOverlay) immutableList.get(i4);
            if (textureOverlay instanceof TextOverlay) {
                iArr[i4] = 2;
                i3--;
            } else {
                if (!(textureOverlay instanceof BitmapOverlay)) {
                    throw new IllegalArgumentException(textureOverlay + " is not supported on HDR content.");
                }
                Assertions.g(Util.f41609a >= 34);
                iArr[i4] = 1;
                i3 -= 2;
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Too many HDR overlays in the same OverlayShaderProgram instance.");
            }
        }
        return iArr;
    }

    private static String v(String str, int i3) {
        return str.replace("%", Integer.toString(i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size j(int i3, int i4) {
        Size size = new Size(i3, i4);
        this.f42515i.a(size);
        UnmodifiableIterator it = this.f42516j.iterator();
        while (it.hasNext()) {
            ((TextureOverlay) it.next()).a(size);
        }
        return size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void n(int i3, long j3) throws VideoFrameProcessingException {
        try {
            this.f42514h.u();
            for (int i4 = 1; i4 <= this.f42516j.size(); i4++) {
                int i5 = i4 - 1;
                TextureOverlay textureOverlay = (TextureOverlay) this.f42516j.get(i5);
                int[] iArr = this.f42517k;
                if (iArr != null) {
                    int i6 = iArr[i5];
                    if (i6 == 1) {
                        Assertions.a(textureOverlay instanceof BitmapOverlay);
                        Bitmap bitmapG = ((BitmapOverlay) textureOverlay).g(j3);
                        Assertions.a(bitmapG.hasGainmap());
                        Gainmap gainmapA = f.a(Assertions.e(bitmapG.getGainmap()));
                        Gainmap gainmapA2 = f.a(this.f42518l.get(i4));
                        if (gainmapA2 == null || !GainmapUtil.c(gainmapA2, gainmapA)) {
                            this.f42518l.put(i4, gainmapA);
                            if (this.f42519m.get(i4, -1) == -1) {
                                this.f42519m.put(i4, GlUtil.v(gainmapA.getGainmapContents()));
                            } else {
                                GlUtil.X(this.f42519m.get(i4), gainmapA.getGainmapContents());
                            }
                            this.f42514h.s("uGainmapTexSampler" + i4, this.f42519m.get(i4), this.f42516j.size() + i4);
                            GainmapUtil.e(this.f42514h, f.a(this.f42518l.get(i4)), i4);
                        }
                    } else if (i6 == 2) {
                        float[] fArrH = GlUtil.h();
                        float fA = textureOverlay.b(j3).a();
                        Matrix.scaleM(fArrH, 0, fA, fA, fA);
                        this.f42514h.p(Util.J("uLuminanceMatrix%d", Integer.valueOf(i4)), fArrH);
                    }
                }
                this.f42514h.s(Util.J("uOverlayTexSampler%d", Integer.valueOf(i4)), textureOverlay.c(j3), i4);
                this.f42514h.p(Util.J("uVertexTransformationMatrix%d", Integer.valueOf(i4)), textureOverlay.e(j3));
                OverlaySettings overlaySettingsB = textureOverlay.b(j3);
                this.f42514h.p(Util.J("uTransformationMatrix%d", Integer.valueOf(i4)), this.f42515i.b(textureOverlay.d(j3), overlaySettingsB));
                this.f42514h.o(Util.J("uOverlayAlphaScale%d", Integer.valueOf(i4)), overlaySettingsB.b());
            }
            this.f42514h.s("uVideoTexSampler0", i3, 0);
            this.f42514h.e();
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.e();
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3, j3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        int i3;
        super.release();
        try {
            this.f42514h.f();
            for (int i4 = 0; i4 < this.f42516j.size(); i4++) {
                ((TextureOverlay) this.f42516j.get(i4)).f();
                int[] iArr = this.f42517k;
                if (iArr != null && iArr[i4] == 1 && (i3 = this.f42519m.get(i4, -1)) != -1) {
                    GlUtil.D(i3);
                }
            }
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String s(android.content.Context r6, int r7, int[] r8) {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.effect.OverlayShaderProgram.s(android.content.Context, int, int[]):java.lang.String");
    }
}
