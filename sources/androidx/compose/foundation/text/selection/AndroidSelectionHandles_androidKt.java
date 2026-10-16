package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class AndroidSelectionHandles_androidKt {
    public static final void a(final OffsetProvider offsetProvider, final Alignment alignment, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(476043083);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(offsetProvider) : composerK.I(offsetProvider) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(alignment) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        boolean z2 = false;
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(476043083, i4, -1, "androidx.compose.foundation.text.selection.HandlePopup (AndroidSelectionHandles.android.kt:223)");
            }
            boolean z3 = (i4 & 112) == 32;
            if ((i4 & 14) == 4 || ((i4 & 8) != 0 && composerK.Z(offsetProvider))) {
                z2 = true;
            }
            boolean z4 = z3 | z2;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new HandlePositionProvider(alignment, offsetProvider);
                composerK.w(objG);
            }
            AndroidPopup_androidKt.a((HandlePositionProvider) objG, null, new PopupProperties(false, false, false, (SecureFlagPolicy) null, true, false, 15, (DefaultConstructorMarker) null), function2, composerK, ((i4 << 3) & 7168) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$HandlePopup$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    AndroidSelectionHandles_androidKt.a(offsetProvider, alignment, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final androidx.compose.foundation.text.selection.OffsetProvider r19, final boolean r20, androidx.compose.ui.text.style.ResolvedTextDirection r21, boolean r22, long r23, final float r25, final androidx.compose.ui.Modifier r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 407
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt.b(androidx.compose.foundation.text.selection.OffsetProvider, boolean, androidx.compose.ui.text.style.ResolvedTextDirection, boolean, long, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void c(final Modifier modifier, final Function0 function0, final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2111672474);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2111672474, i4, -1, "androidx.compose.foundation.text.selection.SelectionHandleIcon (AndroidSelectionHandles.android.kt:127)");
            }
            SpacerKt.a(e(SizeKt.x(modifier, SelectionHandlesKt.c(), SelectionHandlesKt.b()), function0, z2), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$SelectionHandleIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    AndroidSelectionHandles_androidKt.c(modifier, function0, z2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final ImageBitmap d(CacheDrawScope cacheDrawScope, float f3) {
        int iCeil = ((int) Math.ceil(f3)) * 2;
        HandleImageCache handleImageCache = HandleImageCache.f11228a;
        ImageBitmap imageBitmapC = handleImageCache.c();
        Canvas canvasA = handleImageCache.a();
        CanvasDrawScope canvasDrawScopeB = handleImageCache.b();
        if (imageBitmapC == null || canvasA == null || iCeil > imageBitmapC.getWidth() || iCeil > imageBitmapC.getHeight()) {
            imageBitmapC = ImageBitmapKt.b(iCeil, iCeil, ImageBitmapConfig.f25784b.a(), false, null, 24, null);
            handleImageCache.f(imageBitmapC);
            canvasA = CanvasKt.a(imageBitmapC);
            handleImageCache.d(canvasA);
        }
        ImageBitmap imageBitmap = imageBitmapC;
        Canvas canvas = canvasA;
        if (canvasDrawScopeB == null) {
            canvasDrawScopeB = new CanvasDrawScope();
            handleImageCache.e(canvasDrawScopeB);
        }
        CanvasDrawScope canvasDrawScope = canvasDrawScopeB;
        LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
        float width = imageBitmap.getWidth();
        long jD = Size.d((((long) Float.floatToRawIntBits(imageBitmap.getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32));
        CanvasDrawScope.DrawParams drawParamsO = canvasDrawScope.O();
        Density densityA = drawParamsO.a();
        LayoutDirection layoutDirectionB = drawParamsO.b();
        Canvas canvasC = drawParamsO.c();
        long jD2 = drawParamsO.d();
        CanvasDrawScope.DrawParams drawParamsO2 = canvasDrawScope.O();
        drawParamsO2.j(cacheDrawScope);
        drawParamsO2.k(layoutDirection);
        drawParamsO2.i(canvas);
        drawParamsO2.l(jD);
        canvas.t();
        DrawScope.L1(canvasDrawScope, Color.f25715b.a(), 0L, canvasDrawScope.b(), 0.0f, null, null, BlendMode.f25667b.a(), 58, null);
        DrawScope.L1(canvasDrawScope, ColorKt.d(4278190080L), Offset.f25596b.c(), Size.d((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), 0.0f, null, null, 0, 120, null);
        DrawScope.e2(canvasDrawScope, ColorKt.d(4278190080L), f3, Offset.e((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)), 0.0f, null, null, 0, 120, null);
        canvas.k();
        CanvasDrawScope.DrawParams drawParamsO3 = canvasDrawScope.O();
        drawParamsO3.j(densityA);
        drawParamsO3.k(layoutDirectionB);
        drawParamsO3.i(canvasC);
        drawParamsO3.l(jD2);
        return imageBitmap;
    }

    public static final Modifier e(Modifier modifier, final Function0 function0, final boolean z2) {
        return ComposedModifierKt.c(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-196777734);
                if (ComposerKt.M()) {
                    ComposerKt.U(-196777734, i3, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:133)");
                }
                final long jB = ((TextSelectionColors) composer.q(TextSelectionColorsKt.b())).b();
                boolean zF = composer.f(jB) | composer.Z(function0) | composer.b(z2);
                final Function0 function02 = function0;
                final boolean z3 = z2;
                Object objG = composer.G();
                if (zF || objG == Composer.f23746a.a()) {
                    objG = new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                            final ImageBitmap imageBitmapD = AndroidSelectionHandles_androidKt.d(cacheDrawScope, Float.intBitsToFloat((int) (cacheDrawScope.b() >> 32)) / 2.0f);
                            final ColorFilter colorFilterC = ColorFilter.Companion.c(ColorFilter.f25730b, jB, 0, 2, null);
                            final Function0 function03 = function02;
                            final boolean z4 = z3;
                            return cacheDrawScope.x(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1.1
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
                                    if (((Boolean) function03.invoke()).booleanValue()) {
                                        if (!z4) {
                                            DrawScope.Y0(contentDrawScope, imageBitmapD, 0L, 0.0f, null, colorFilterC, 0, 46, null);
                                            return;
                                        }
                                        ImageBitmap imageBitmap = imageBitmapD;
                                        ColorFilter colorFilter = colorFilterC;
                                        long jV1 = contentDrawScope.V1();
                                        DrawContext drawContextQ1 = contentDrawScope.Q1();
                                        long jB2 = drawContextQ1.b();
                                        drawContextQ1.g().t();
                                        try {
                                            drawContextQ1.e().i(-1.0f, 1.0f, jV1);
                                            DrawScope.Y0(contentDrawScope, imageBitmap, 0L, 0.0f, null, colorFilter, 0, 46, null);
                                        } finally {
                                            drawContextQ1.g().k();
                                            drawContextQ1.h(jB2);
                                        }
                                    }
                                }
                            });
                        }
                    };
                    composer.w(objG);
                }
                Modifier modifierC = DrawModifierKt.c(modifier2, (Function1) objG);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierC;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null);
    }
}
