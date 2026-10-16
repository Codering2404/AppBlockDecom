package cz.mobilesoft.coreblock.scene.auto_trial.components.card;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AutoTrialCardKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f98934a = Dp.g(SensibleDefaults.X_OFFSET);

    private static final float e(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float f(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, float f3, int i3, int i4, Composer composer, int i5) {
        d(modifier, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final float h(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float i(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float j(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float k(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float l(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(State state, State state2, State state3, State state4, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.i(e(state));
        graphicsLayer.h(f(state2));
        graphicsLayer.g(graphicsLayer.getDensity() * 14.0f);
        graphicsLayer.d(h(state3) * 10.0f * graphicsLayer.getDensity());
        float fI = (i(state4) * 0.02f) + 1.0f;
        graphicsLayer.e(fI);
        graphicsLayer.k(fI);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(State state, State state2, State state3, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.i2();
        if (l(state) >= 0.0f) {
            DrawScope.L1(drawWithContent, Color.r(Color.f25715b.l(), l(state) * 0.16f, 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, 126, null);
        } else {
            DrawScope.L1(drawWithContent, Color.r(Color.f25715b.a(), 0.18f * (-l(state)), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.b() >> 32)) * 1.6f;
        float f3 = (-fIntBitsToFloat) / 2.0f;
        float fJ = f3 + (j(state2) * fIntBitsToFloat);
        Brush.Companion companion = Brush.Companion;
        Color.Companion companion2 = Color.f25715b;
        List listListOf = CollectionsKt.listOf((Object[]) new Color[]{Color.n(companion2.j()), Color.n(Color.r(companion2.l(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(companion2.j())});
        long jE = Offset.e((((long) Float.floatToRawIntBits(fJ)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        float fIntBitsToFloat2 = fJ + (Float.intBitsToFloat((int) (drawWithContent.b() >> 32)) * 0.55f);
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L));
        DrawScope.k1(drawWithContent, Brush.Companion.e(companion, listListOf, jE, Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) & 4294967295L)), 0, 8, null), 0L, 0L, 0.0f, null, null, 0, 126, null);
        float fK = f3 + (k(state3) * fIntBitsToFloat);
        List listListOf2 = CollectionsKt.listOf((Object[]) new Color[]{Color.n(companion2.j()), Color.n(Color.r(companion2.l(), 0.45f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(companion2.j())});
        long jE2 = Offset.e((((long) Float.floatToRawIntBits(fK)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
        float fIntBitsToFloat4 = fK + (Float.intBitsToFloat((int) (drawWithContent.b() >> 32)) * 0.16f);
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L));
        DrawScope.k1(drawWithContent, Brush.Companion.e(companion, listListOf2, jE2, Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat4)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat5)) & 4294967295L)), 0, 8, null), 0L, 0L, 0.0f, null, null, 0, 126, null);
        return Unit.f139807a;
    }

    private static final int o(int i3) {
        return (int) (i3 / 1.25f);
    }

    public static final float p() {
        return f98934a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(androidx.compose.ui.Modifier r28, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 729
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.auto_trial.components.card.AutoTrialCardKt.d(androidx.compose.ui.Modifier, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
