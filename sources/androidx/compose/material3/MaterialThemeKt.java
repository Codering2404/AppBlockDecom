package androidx.compose.material3;

import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.Color;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MaterialThemeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f18112a = CompositionLocalKt.g(new Function0<Boolean>() { // from class: androidx.compose.material3.MaterialThemeKt$LocalUsingExpressiveTheme$1
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });

    public static final void a(final ColorScheme colorScheme, final Shapes shapes, Typography typography, final Function2 function2, Composer composer, final int i3, final int i4) {
        int i5;
        final Typography typography2;
        Composer composerK = composer.k(-1399457222);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(colorScheme) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i7 = i4 & 2;
        if (i7 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(shapes) ? 32 : 16;
        }
        int i8 = i4 & 4;
        if (i8 != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.Z(typography) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 8) != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function2) ? 2048 : 1024;
        }
        if ((i5 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
            typography2 = typography;
        } else {
            if (i6 != 0) {
                colorScheme = null;
            }
            if (i7 != 0) {
                shapes = null;
            }
            final Typography typography3 = i8 == 0 ? typography : null;
            if (ComposerKt.M()) {
                ComposerKt.U(-1399457222, i5, -1, "androidx.compose.material3.MaterialExpressiveTheme (MaterialTheme.kt:133)");
            }
            ProvidableCompositionLocal providableCompositionLocal = f18112a;
            if (((Boolean) composerK.q(providableCompositionLocal)).booleanValue()) {
                composerK.a0(547059915);
                composerK.a0(1126027167);
                ColorScheme colorSchemeA = colorScheme == null ? MaterialTheme.f18110a.a(composerK, 6) : colorScheme;
                composerK.U();
                composerK.a0(1126029309);
                Typography typographyC = typography3 == null ? MaterialTheme.f18110a.c(composerK, 6) : typography3;
                composerK.U();
                composerK.a0(1126031253);
                Shapes shapesB = shapes == null ? MaterialTheme.f18110a.b(composerK, 6) : shapes;
                composerK.U();
                b(colorSchemeA, shapesB, typographyC, function2, composerK, i5 & 7168, 0);
                composerK.U();
            } else {
                composerK.a0(547327197);
                CompositionLocalKt.b(providableCompositionLocal.d(Boolean.TRUE), ComposableLambdaKt.e(2050809758, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt$MaterialExpressiveTheme$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i9) {
                        if ((i9 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(2050809758, i9, -1, "androidx.compose.material3.MaterialExpressiveTheme.<anonymous> (MaterialTheme.kt:143)");
                        }
                        ColorScheme colorSchemeF = colorScheme;
                        if (colorSchemeF == null) {
                            colorSchemeF = ColorSchemeKt.f();
                        }
                        ColorScheme colorScheme2 = colorSchemeF;
                        Shapes shapes2 = shapes;
                        Shapes shapes3 = shapes2 == null ? new Shapes(null, null, null, null, null, 31, null) : shapes2;
                        Typography typography4 = typography3;
                        MaterialThemeKt.b(colorScheme2, shapes3, typography4 == null ? new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null) : typography4, function2, composer2, 0, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            typography2 = typography3;
        }
        final ColorScheme colorScheme2 = colorScheme;
        final Shapes shapes2 = shapes;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MaterialThemeKt$MaterialExpressiveTheme$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    MaterialThemeKt.a(colorScheme2, shapes2, typography2, function2, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(androidx.compose.material3.ColorScheme r18, androidx.compose.material3.Shapes r19, androidx.compose.material3.Typography r20, final kotlin.jvm.functions.Function2 r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MaterialThemeKt.b(androidx.compose.material3.ColorScheme, androidx.compose.material3.Shapes, androidx.compose.material3.Typography, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TextSelectionColors c(ColorScheme colorScheme, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1866455512, i3, -1, "androidx.compose.material3.rememberTextSelectionColors (MaterialTheme.kt:159)");
        }
        long jJ0 = colorScheme.j0();
        boolean zF = composer.f(jJ0);
        Object objG = composer.G();
        if (zF || objG == Composer.f23746a.a()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(jJ0, Color.r(jJ0, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
            composer.w(textSelectionColors);
            objG = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textSelectionColors2;
    }
}
