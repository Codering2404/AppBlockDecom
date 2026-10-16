package cz.mobilesoft.coreblock.scene.permission.permissions.success;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SuccessScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112247a;

        static {
            int[] iArr = new int[CheckMarkState.values().length];
            try {
                iArr[CheckMarkState.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CheckMarkState.Visible.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f112247a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(androidx.compose.ui.Modifier r26, long r27, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.success.SuccessScreenKt.e(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec f(Transition.Segment animateFloat, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(animateFloat, "$this$animateFloat");
        composer.a0(-1424870263);
        if (ComposerKt.M()) {
            ComposerKt.U(-1424870263, i3, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.success.CircledCheckmark.<anonymous> (SuccessScreen.kt:85)");
        }
        TweenSpec tweenSpecN = AnimationSpecKt.n(500, 0, EasingKt.d(), 2, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return tweenSpecN;
    }

    private static final float g(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(float f3, long j3, Path path, Path path2, PathMeasure pathMeasure, State state, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float f4 = 2;
        DrawScope.e2(Canvas, j3, (Size.h(Canvas.b()) / f4) - (f3 / f4), 0L, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
        if (g(state) > 0.0f) {
            path.reset();
            path2.reset();
            path.a(Float.intBitsToFloat((int) (Canvas.b() >> 32)) * 0.28f, Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * 0.5f);
            path.c(Float.intBitsToFloat((int) (Canvas.b() >> 32)) * 0.45f, Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * 0.7f);
            path.c(Float.intBitsToFloat((int) (Canvas.b() >> 32)) * 0.75f, Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * 0.32f);
            pathMeasure.b(path, false);
            pathMeasure.a(0.0f, pathMeasure.getLength() * g(state), path2, true);
            DrawScope.u0(Canvas, path2, j3, 0.0f, new Stroke(f3, 0.0f, StrokeCap.f25935b.b(), StrokeJoin.f25940b.c(), null, 18, null), null, 0, 52, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Modifier modifier, long j3, float f3, int i3, int i4, Composer composer, int i5) {
        e(modifier, j3, f3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void j(Modifier modifier, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(1910503442);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1910503442, i5, -1, "cz.mobilesoft.coreblock.scene.permission.permissions.success.SuccessScreen (SuccessScreen.kt:39)");
            }
            modifier3 = modifier4;
            ComposeBackgroundKt.m(BackgroundKt.d(modifier4, ComposeColorsKt.j(composerK, 0).e(), null, 2, null), false, false, false, null, 0L, null, ComposableSingletons$SuccessScreenKt.f112244a.c(), composerK, 12582912, 126);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.success.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SuccessScreenKt.k(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        j(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
