package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Gainmap;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GainmapUtil {
    private static String a(String str, int i3) {
        if (i3 == -1) {
            return str;
        }
        return str + i3;
    }

    private static boolean b(float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        return f3 == f4 && f4 == fArr[2];
    }

    public static boolean c(Gainmap gainmap, Gainmap gainmap2) {
        return gainmap.getGamma() == gainmap2.getGamma() && gainmap.getRatioMax() == gainmap2.getRatioMax() && gainmap.getRatioMin() == gainmap2.getRatioMin() && gainmap.getEpsilonHdr() == gainmap2.getEpsilonHdr() && gainmap.getEpsilonSdr() == gainmap2.getEpsilonSdr() && gainmap.getDisplayRatioForFullHdr() == gainmap2.getDisplayRatioForFullHdr() && gainmap.getMinDisplayRatioForHdrTransition() == gainmap2.getMinDisplayRatioForHdrTransition() && gainmap.getGainmapContents() == gainmap2.getGainmapContents() && gainmap.getGainmapContents().getGenerationId() == gainmap2.getGainmapContents().getGenerationId();
    }

    private static float[] d(float[] fArr) {
        return new float[]{(float) Math.log(fArr[0]), (float) Math.log(fArr[1]), (float) Math.log(fArr[2])};
    }

    public static void e(GlProgram glProgram, Gainmap gainmap, int i3) {
        int i4 = 0;
        int i5 = gainmap.getGainmapContents().getConfig() == Bitmap.Config.ALPHA_8 ? 1 : 0;
        float[] gamma = gainmap.getGamma();
        int i6 = (gamma[0] == 1.0f && gamma[1] == 1.0f && gamma[2] == 1.0f) ? 1 : 0;
        if (b(gamma) && b(gainmap.getRatioMax()) && b(gainmap.getRatioMin())) {
            i4 = 1;
        }
        glProgram.r(a("uGainmapIsAlpha", i3), i5);
        glProgram.r(a("uNoGamma", i3), i6);
        glProgram.r(a("uSingleChannel", i3), i4);
        glProgram.p(a("uLogRatioMin", i3), d(gainmap.getRatioMin()));
        glProgram.p(a("uLogRatioMax", i3), d(gainmap.getRatioMax()));
        glProgram.p(a("uEpsilonSdr", i3), gainmap.getEpsilonSdr());
        glProgram.p(a("uEpsilonHdr", i3), gainmap.getEpsilonHdr());
        glProgram.p(a("uGainmapGamma", i3), gamma);
        glProgram.o(a("uDisplayRatioHdr", i3), gainmap.getDisplayRatioForFullHdr());
        glProgram.o(a("uDisplayRatioSdr", i3), gainmap.getMinDisplayRatioForHdrTransition());
        GlUtil.e();
    }
}
