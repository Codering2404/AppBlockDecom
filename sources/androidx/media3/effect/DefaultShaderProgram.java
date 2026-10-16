package androidx.media3.effect;

import android.content.Context;
import android.graphics.Gainmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
final class DefaultShaderProgram extends BaseGlShaderProgram implements ExternalShaderProgram, RepeatingGainmapShaderProgram {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final ImmutableList f42285x = ImmutableList.C(new float[]{-1.0f, -1.0f, 0.0f, 1.0f}, new float[]{-1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, 1.0f, 0.0f, 1.0f}, new float[]{1.0f, -1.0f, 0.0f, 1.0f});

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final float[] f42286y = {1.0f, 1.0f, 1.0f, 0.0f, -0.1646f, 1.8814f, 1.4746f, -0.5714f, 0.0f};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final float[] f42287z = {1.1689f, 1.1689f, 1.1689f, 0.0f, -0.1881f, 2.1502f, 1.6853f, -0.653f, 0.0f};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final GlProgram f42288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ImmutableList f42289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ImmutableList f42290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f42291k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final float[][] f42292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final float[][] f42293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float[] f42294n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final float[] f42295o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final float[] f42296p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f42297q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private ImmutableList f42298r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Gainmap f42299s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f42300t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f42301u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f42302v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f42303w;

    private DefaultShaderProgram(GlProgram glProgram, ImmutableList immutableList, ImmutableList immutableList2, int i3, boolean z2) {
        super(z2, 1);
        this.f42288h = glProgram;
        this.f42301u = i3;
        this.f42289i = immutableList;
        this.f42290j = immutableList2;
        this.f42291k = z2;
        int[] iArr = {immutableList.size(), 16};
        Class cls = Float.TYPE;
        this.f42292l = (float[][]) Array.newInstance((Class<?>) cls, iArr);
        this.f42293m = (float[][]) Array.newInstance((Class<?>) cls, immutableList2.size(), 16);
        this.f42294n = GlUtil.h();
        this.f42295o = GlUtil.h();
        this.f42296p = new float[16];
        this.f42298r = f42285x;
        this.f42300t = -1;
        int iMax = 9729;
        for (int i4 = 0; i4 < immutableList.size(); i4++) {
            iMax = Math.max(iMax, ((GlMatrixTransformation) immutableList.get(i4)).d());
        }
        this.f42297q = iMax;
    }

    private boolean A(long j3) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, this.f42290j.size(), 16);
        for (int i3 = 0; i3 < this.f42290j.size(); i3++) {
            fArr[i3] = ((RgbMatrix) this.f42290j.get(i3)).g(j3, this.f42291k);
        }
        if (!C(this.f42293m, fArr)) {
            return false;
        }
        GlUtil.Y(this.f42295o);
        for (int i4 = 0; i4 < this.f42290j.size(); i4++) {
            Matrix.multiplyMM(this.f42296p, 0, ((RgbMatrix) this.f42290j.get(i4)).g(j3, this.f42291k), 0, this.f42295o, 0);
            float[] fArr2 = this.f42296p;
            System.arraycopy(fArr2, 0, this.f42295o, 0, fArr2.length);
        }
        return true;
    }

    private boolean B(long j3) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, this.f42289i.size(), 16);
        for (int i3 = 0; i3 < this.f42289i.size(); i3++) {
            fArr[i3] = ((GlMatrixTransformation) this.f42289i.get(i3)).b(j3);
        }
        if (!C(this.f42292l, fArr)) {
            return false;
        }
        GlUtil.Y(this.f42294n);
        this.f42298r = f42285x;
        for (float[] fArr2 : this.f42292l) {
            Matrix.multiplyMM(this.f42296p, 0, fArr2, 0, this.f42294n, 0);
            float[] fArr3 = this.f42296p;
            System.arraycopy(fArr3, 0, this.f42294n, 0, fArr3.length);
            ImmutableList immutableListA = MatrixUtils.a(MatrixUtils.g(fArr2, this.f42298r));
            this.f42298r = immutableListA;
            if (immutableListA.size() < 3) {
                return true;
            }
        }
        Matrix.invertM(this.f42296p, 0, this.f42294n, 0);
        this.f42298r = MatrixUtils.g(this.f42296p, this.f42298r);
        return true;
    }

    private static boolean C(float[][] fArr, float[][] fArr2) {
        boolean z2 = false;
        for (int i3 = 0; i3 < fArr.length; i3++) {
            float[] fArr3 = fArr[i3];
            float[] fArr4 = fArr2[i3];
            if (!Arrays.equals(fArr3, fArr4)) {
                Assertions.h(fArr4.length == 16, "A 4x4 transformation matrix must have 16 elements");
                System.arraycopy(fArr4, 0, fArr3, 0, fArr4.length);
                z2 = true;
            }
        }
        return z2;
    }

    public static /* synthetic */ android.graphics.Matrix s(long j3) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.setScale(1.0f, -1.0f);
        return matrix;
    }

    public static DefaultShaderProgram u(Context context, List list, List list2, ColorInfo colorInfo, int i3) throws VideoFrameProcessingException {
        boolean zL = ColorInfo.l(colorInfo);
        boolean z2 = i3 == 2;
        GlProgram glProgramV = v(context, zL ? "shaders/vertex_shader_transformation_es3.glsl" : "shaders/vertex_shader_transformation_es2.glsl", zL ? "shaders/fragment_shader_oetf_es3.glsl" : z2 ? "shaders/fragment_shader_transformation_sdr_oetf_es2.glsl" : list2.isEmpty() ? "shaders/fragment_shader_copy_es2.glsl" : "shaders/fragment_shader_transformation_es2.glsl");
        int i4 = colorInfo.f40556c;
        if (zL) {
            Assertions.a(i4 == 7 || i4 == 6);
            glProgramV.r("uOutputColorTransfer", i4);
        } else if (z2) {
            Assertions.a(i4 == 3 || i4 == 10);
            glProgramV.r("uOutputColorTransfer", i4);
        }
        return new DefaultShaderProgram(glProgramV, ImmutableList.t(list), ImmutableList.t(list2), colorInfo.f40556c, zL);
    }

    private static GlProgram v(Context context, String str, String str2) throws VideoFrameProcessingException {
        try {
            GlProgram glProgram = new GlProgram(context, str, str2);
            glProgram.p("uTexTransformationMatrix", GlUtil.h());
            return glProgram;
        } catch (GlUtil.GlException | IOException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    public static DefaultShaderProgram w(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, int i3, boolean z2) throws VideoFrameProcessingException {
        boolean zL = ColorInfo.l(colorInfo);
        GlProgram glProgramV = v(context, zL ? "shaders/vertex_shader_transformation_es3.glsl" : "shaders/vertex_shader_transformation_es2.glsl", zL ? "shaders/fragment_shader_transformation_external_yuv_es3.glsl" : "shaders/fragment_shader_transformation_sdr_external_es2.glsl");
        if (zL) {
            if (!GlUtil.U()) {
                throw new VideoFrameProcessingException("The EXT_YUV_target extension is required for HDR editing input.");
            }
            glProgramV.p("uYuvToRgbColorTransform", colorInfo.f40555b == 1 ? f42286y : f42287z);
            glProgramV.r("uInputColorTransfer", colorInfo.f40556c);
            glProgramV.r("uApplyHdrToSdrToneMapping", colorInfo2.f40554a == 6 ? 0 : 1);
        }
        glProgramV.n(z2);
        return y(glProgramV, colorInfo, colorInfo2, i3, ImmutableList.y());
    }

    public static DefaultShaderProgram x(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, int i3, int i4) throws VideoFrameProcessingException {
        int i5;
        Assertions.g(colorInfo.f40556c != 2 || i4 == 2);
        boolean zL = ColorInfo.l(colorInfo);
        boolean z2 = i4 == 2 && colorInfo2.f40554a == 6;
        GlProgram glProgramV = v(context, (zL || z2) ? "shaders/vertex_shader_transformation_es3.glsl" : "shaders/vertex_shader_transformation_es2.glsl", z2 ? "shaders/fragment_shader_transformation_ultra_hdr_es3.glsl" : zL ? "shaders/fragment_shader_transformation_hdr_internal_es3.glsl" : "shaders/fragment_shader_transformation_sdr_internal_es2.glsl");
        if (!z2) {
            Assertions.a(zL || (i5 = colorInfo.f40556c) == 2 || i5 == 3);
            glProgramV.r("uInputColorTransfer", colorInfo.f40556c);
        }
        if (zL) {
            glProgramV.r("uApplyHdrToSdrToneMapping", colorInfo2.f40554a == 6 ? 0 : 1);
        }
        ImmutableList immutableListY = ImmutableList.y();
        if (i4 == 2) {
            immutableListY = ImmutableList.z(new MatrixTransformation() { // from class: androidx.media3.effect.s
                @Override // androidx.media3.effect.MatrixTransformation
                public final android.graphics.Matrix j(long j3) {
                    return DefaultShaderProgram.s(j3);
                }
            });
        }
        return y(glProgramV, colorInfo, colorInfo2, i3, immutableListY);
    }

    private static DefaultShaderProgram y(GlProgram glProgram, ColorInfo colorInfo, ColorInfo colorInfo2, int i3, ImmutableList immutableList) {
        boolean zL = ColorInfo.l(colorInfo);
        int i4 = colorInfo.f40554a;
        boolean z2 = (i4 == 1 || i4 == 2) && colorInfo2.f40554a == 6;
        int i5 = colorInfo2.f40556c;
        if (zL) {
            if (i5 == 3) {
                i5 = 10;
            }
            Assertions.a(i5 == 1 || i5 == 10 || i5 == 6 || i5 == 7);
            glProgram.r("uOutputColorTransfer", i5);
        } else if (z2) {
            Assertions.a(i5 == 1 || i5 == 6 || i5 == 7);
            glProgram.r("uOutputColorTransfer", i5);
        } else {
            glProgram.r("uSdrWorkingColorSpace", i3);
            Assertions.a(i5 == 3 || i5 == 1);
            glProgram.r("uOutputColorTransfer", i5);
        }
        return new DefaultShaderProgram(glProgram, immutableList, ImmutableList.y(), colorInfo2.f40556c, zL || z2);
    }

    private void z() {
        if (this.f42299s == null) {
            return;
        }
        if (Util.f41609a < 34) {
            throw new IllegalStateException("Gainmaps not supported under API 34.");
        }
        this.f42288h.s("uGainmapTexSampler", this.f42300t, 1);
        GainmapUtil.e(this.f42288h, this.f42299s, -1);
    }

    @Override // androidx.media3.effect.RepeatingFrameShaderProgram
    public void a() {
        Assertions.g(this.f42175a.a() == 1);
        this.f42302v = true;
        this.f42303w = false;
    }

    @Override // androidx.media3.effect.GainmapShaderProgram
    public void h(Gainmap gainmap) throws GlUtil.GlException {
        if (this.f42291k) {
            Gainmap gainmap2 = this.f42299s;
            if (gainmap2 == null || !GainmapUtil.c(gainmap2, gainmap)) {
                this.f42303w = false;
                this.f42299s = gainmap;
                int i3 = this.f42300t;
                if (i3 == -1) {
                    this.f42300t = GlUtil.v(gainmap.getGainmapContents());
                } else {
                    GlUtil.X(i3, gainmap.getGainmapContents());
                }
            }
        }
    }

    @Override // androidx.media3.effect.ExternalShaderProgram
    public void i(float[] fArr) {
        this.f42288h.p("uTexTransformationMatrix", fArr);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public Size j(int i3, int i4) {
        return MatrixUtils.c(i3, i4, this.f42289i);
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public void n(int i3, long j3) throws VideoFrameProcessingException {
        boolean z2 = A(j3) || B(j3);
        if (this.f42298r.size() < 3) {
            return;
        }
        if (this.f42302v && !z2 && this.f42303w) {
            return;
        }
        try {
            this.f42288h.u();
            z();
            this.f42288h.t("uTexSampler", i3, 0, this.f42297q);
            this.f42288h.p("uTransformationMatrix", this.f42294n);
            this.f42288h.q("uRgbMatrix", this.f42295o);
            this.f42288h.m("aFramePosition", GlUtil.x(this.f42298r), 4);
            this.f42288h.e();
            GLES20.glDrawArrays(6, 0, this.f42298r.size());
            GlUtil.e();
            this.f42303w = true;
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3, j3);
        }
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram
    public boolean r() {
        return (this.f42303w && this.f42302v) ? false : true;
    }

    @Override // androidx.media3.effect.BaseGlShaderProgram, androidx.media3.effect.GlShaderProgram
    public void release() throws VideoFrameProcessingException {
        super.release();
        try {
            this.f42288h.f();
            int i3 = this.f42300t;
            if (i3 != -1) {
                GlUtil.D(i3);
            }
        } catch (GlUtil.GlException e3) {
            throw new VideoFrameProcessingException(e3);
        }
    }

    public static DefaultShaderProgram t(Context context, List list, List list2, boolean z2) {
        String str;
        if (list2.isEmpty()) {
            str = "shaders/fragment_shader_copy_es2.glsl";
        } else {
            str = "shaders/fragment_shader_transformation_es2.glsl";
        }
        return new DefaultShaderProgram(v(context, KqqtdetwHMIO.VRkxztpvZcdp, str), ImmutableList.t(list), ImmutableList.t(list2), 1, z2);
    }
}
