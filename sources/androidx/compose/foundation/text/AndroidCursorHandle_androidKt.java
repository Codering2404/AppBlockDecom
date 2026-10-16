package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

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
public final class AndroidCursorHandle_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f9030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f9031b;

    static {
        float fG = Dp.g(25);
        f9030a = fG;
        f9031b = Dp.g(Dp.g(fG * 2.0f) / 2.4142137f);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.foundation.text.selection.OffsetProvider r8, final androidx.compose.ui.Modifier r9, final long r10, androidx.compose.runtime.Composer r12, final int r13, final int r14) {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.AndroidCursorHandle_androidKt.a(androidx.compose.foundation.text.selection.OffsetProvider, androidx.compose.ui.Modifier, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(694251107);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(694251107, i5, -1, "androidx.compose.foundation.text.DefaultCursorHandle (AndroidCursorHandle.android.kt:82)");
            }
            SpacerKt.a(d(SizeKt.x(modifier, f9031b, f9030a)), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$DefaultCursorHandle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    AndroidCursorHandle_androidKt.b(modifier, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    private static final Modifier d(Modifier modifier) {
        return ComposedModifierKt.c(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1
            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-2126899193);
                if (ComposerKt.M()) {
                    ComposerKt.U(-2126899193, i3, -1, "androidx.compose.foundation.text.drawCursorHandle.<anonymous> (AndroidCursorHandle.android.kt:87)");
                }
                final long jB = ((TextSelectionColors) composer.q(TextSelectionColorsKt.b())).b();
                Modifier.Companion companion = Modifier.b8;
                boolean zF = composer.f(jB);
                Object objG = composer.G();
                if (zF || objG == Composer.f23746a.a()) {
                    objG = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final float fIntBitsToFloat = Float.intBitsToFloat((int) (cacheDrawScope.b() >> 32)) / 2.0f;
                            final ImageBitmap imageBitmapD = AndroidSelectionHandles_androidKt.d(cacheDrawScope, fIntBitsToFloat);
                            final ColorFilter colorFilterC = ColorFilter.Companion.c(ColorFilter.f25730b, jB, 0, 2, null);
                            return cacheDrawScope.x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.AndroidCursorHandle_androidKt$drawCursorHandle$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((ContentDrawScope) obj);
                                    return Unit.f139807a;
                                }

                                public final void invoke(ContentDrawScope contentDrawScope) {
                                    contentDrawScope.i2();
                                    float f3 = fIntBitsToFloat;
                                    ImageBitmap imageBitmap = imageBitmapD;
                                    ColorFilter colorFilter = colorFilterC;
                                    DrawContext drawContextQ1 = contentDrawScope.Q1();
                                    long jB2 = drawContextQ1.b();
                                    drawContextQ1.g().t();
                                    try {
                                        DrawTransform drawTransformE = drawContextQ1.e();
                                        DrawTransform.f(drawTransformE, f3, 0.0f, 2, null);
                                        drawTransformE.j(45.0f, Offset.f25596b.c());
                                        DrawScope.Y0(contentDrawScope, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
                                    } finally {
                                        drawContextQ1.g().k();
                                        drawContextQ1.h(jB2);
                                    }
                                }
                            });
                        }
                    };
                    composer.w(objG);
                }
                Modifier modifierThen = modifier2.then(DrawModifierKt.c(companion, (Function1) objG));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierThen;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null);
    }
}
