package coil.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.size.SizeResolver;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SubcomposeAsyncImageKt {
    public static final void a(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function4 function4, Function4 function42, Function4 function43, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Composer composer, final int i4, final int i5, final int i6) {
        int iB;
        int i7;
        Composer composerK = composer.k(934816934);
        Modifier modifier2 = (i6 & 8) != 0 ? Modifier.b8 : modifier;
        Function4 function44 = (i6 & 16) != 0 ? null : function4;
        Function4 function45 = (i6 & 32) != 0 ? null : function42;
        Function4 function46 = (i6 & 64) != 0 ? null : function43;
        Function1 function14 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : function1;
        Function1 function15 = (i6 & Function.MAX_NARGS) != 0 ? null : function12;
        Function1 function16 = (i6 & 512) != 0 ? null : function13;
        Alignment alignmentE = (i6 & 1024) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i6 & 2048) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i6 & 4096) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : colorFilter;
        if ((i6 & 16384) != 0) {
            iB = DrawScope.e8.b();
            i7 = i5 & (-57345);
        } else {
            iB = i3;
            i7 = i5;
        }
        final Modifier modifier3 = modifier2;
        if (ComposerKt.M()) {
            ComposerKt.U(934816934, i4, i7, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:49)");
        }
        final Function1 function17 = function14;
        Function1 function1D = UtilsKt.d(function17, function15, function16);
        final Function1 function18 = function16;
        final ContentScale contentScale2 = contentScaleE;
        final ColorFilter colorFilter3 = colorFilter2;
        int i8 = i7;
        int i9 = i8 << 18;
        int i10 = (i4 & 112) | 520 | (i4 & 7168) | (i9 & 3670016) | (i9 & 29360128) | (i9 & 234881024) | (i9 & 1879048192);
        int i11 = (i8 >> 12) & 14;
        final Function4 function47 = function46;
        final Function4 function48 = function45;
        final Function1 function19 = function15;
        final Alignment alignment2 = alignmentE;
        final float f5 = f4;
        final Function4 function49 = function44;
        final int i12 = iB;
        b(obj, str, imageLoader, modifier3, null, function1D, alignment2, contentScale2, f5, colorFilter3, i12, d(function44, function45, function46), composerK, i10, i11, 16);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i13) {
                SubcomposeAsyncImageKt.a(obj, str, imageLoader, modifier3, function49, function48, function47, function17, function19, function18, alignment2, contentScale2, f5, colorFilter3, i12, composer2, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
            }
        });
    }

    public static final void b(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, final Function3 function3, Composer composer, final int i4, final int i5, final int i6) {
        int iB;
        int i7;
        Function1 function13;
        Function1 function14;
        final Alignment alignment2;
        final Modifier modifier2;
        Composer composerK = composer.k(10937794);
        Modifier modifier3 = (i6 & 8) != 0 ? Modifier.b8 : modifier;
        Function1 function1A = (i6 & 16) != 0 ? AsyncImagePainter.f55509w.a() : function1;
        Function1 function15 = (i6 & 32) != 0 ? null : function12;
        Alignment alignmentE = (i6 & 64) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ContentScale.f27054a.e() : contentScale;
        final float f4 = (i6 & Function.MAX_NARGS) != 0 ? 1.0f : f3;
        final ColorFilter colorFilter2 = (i6 & 512) != 0 ? null : colorFilter;
        if ((i6 & 1024) != 0) {
            iB = DrawScope.e8.b();
            i7 = i5 & (-15);
        } else {
            iB = i3;
            i7 = i5;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(10937794, i4, i7, "coil.compose.SubcomposeAsyncImage (SubcomposeAsyncImage.kt:104)");
        }
        ImageRequest imageRequestG = AsyncImageKt.g(UtilsKt.e(obj, composerK, 8), contentScaleE, composerK, 8 | ((i4 >> 18) & 112));
        int i8 = i4 >> 6;
        int i9 = i4 >> 9;
        final AsyncImagePainter asyncImagePainterE = AsyncImagePainterKt.e(imageRequestG, imageLoader, function1A, function15, contentScaleE, iB, composerK, (i8 & 7168) | (i8 & 896) | 72 | (i9 & 57344) | ((i7 << 15) & 458752), 0);
        final SizeResolver sizeResolverK = imageRequestG.K();
        if (sizeResolverK instanceof ConstraintsSizeResolver) {
            function13 = function1A;
            function14 = function15;
            alignment2 = alignmentE;
            composerK.F(-247978567);
            final ContentScale contentScale2 = contentScaleE;
            final int i10 = i7;
            Modifier modifier4 = modifier3;
            BoxWithConstraintsKt.a(modifier4, alignment2, true, ComposableLambdaKt.b(composerK, -1964284792, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    invoke((BoxWithConstraintsScope) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, int i11) {
                    int i12;
                    if ((i11 & 14) == 0) {
                        i12 = (composer2.Z(boxWithConstraintsScope) ? 4 : 2) | i11;
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 91) == 18 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1964284792, i11, -1, "coil.compose.SubcomposeAsyncImage.<anonymous> (SubcomposeAsyncImage.kt:150)");
                    }
                    ((ConstraintsSizeResolver) sizeResolverK).i(boxWithConstraintsScope.c());
                    function3.invoke(new RealSubcomposeAsyncImageScope(boxWithConstraintsScope, asyncImagePainterE, str, alignment2, contentScale2, f4, colorFilter2), composer2, Integer.valueOf(i10 & 112));
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }), composerK, (i9 & 14) | 3456 | ((i4 >> 15) & 112), 0);
            modifier2 = modifier4;
            composerK.Y();
        } else {
            composerK.F(-247979203);
            composerK.F(733328855);
            MeasurePolicy measurePolicyI = BoxKt.i(alignmentE, true, composerK, (((((i9 & 14) | 384) | ((i4 >> 15) & 112)) >> 3) & 14) | 48);
            composerK.F(-1323940314);
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            LayoutDirection layoutDirection = (LayoutDirection) composerK.q(CompositionLocalsKt.m());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerK.q(CompositionLocalsKt.t());
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            function13 = function1A;
            Function0 function0A = companion.a();
            function14 = function15;
            Function3 function3C = LayoutKt.c(modifier3);
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            composerK.M();
            Composer composerA = Updater.a(composerK);
            ContentScale contentScale3 = contentScaleE;
            Updater.e(composerA, measurePolicyI, companion.e());
            Updater.e(composerA, density, companion.c());
            Updater.e(composerA, layoutDirection, companion.d());
            Updater.e(composerA, viewConfiguration, companion.h());
            composerK.d();
            function3C.invoke(SkippableUpdater.a(SkippableUpdater.b(composerK)), composerK, 0);
            composerK.F(2058660585);
            Alignment alignment3 = alignmentE;
            alignment2 = alignment3;
            contentScaleE = contentScale3;
            function3.invoke(new RealSubcomposeAsyncImageScope(BoxScopeInstance.f6642a, asyncImagePainterE, str, alignment3, contentScale3, f4, colorFilter2), composerK, Integer.valueOf(i7 & 112));
            composerK.Y();
            composerK.y();
            composerK.Y();
            composerK.Y();
            composerK.Y();
            modifier2 = modifier3;
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final ContentScale contentScale4 = contentScaleE;
        final int i11 = iB;
        final Alignment alignment4 = alignment2;
        final float f5 = f4;
        final ColorFilter colorFilter3 = colorFilter2;
        final Function1 function16 = function14;
        final Function1 function17 = function13;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$SubcomposeAsyncImage$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i12) {
                SubcomposeAsyncImageKt.b(obj, str, imageLoader, modifier2, function17, function16, alignment4, contentScale4, f5, colorFilter3, i11, function3, composer2, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(coil.compose.SubcomposeAsyncImageScope r20, androidx.compose.ui.Modifier r21, androidx.compose.ui.graphics.painter.Painter r22, java.lang.String r23, androidx.compose.ui.Alignment r24, androidx.compose.ui.layout.ContentScale r25, float r26, androidx.compose.ui.graphics.ColorFilter r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt.c(coil.compose.SubcomposeAsyncImageScope, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, java.lang.String, androidx.compose.ui.Alignment, androidx.compose.ui.layout.ContentScale, float, androidx.compose.ui.graphics.ColorFilter, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Function3 d(final Function4 function4, final Function4 function42, final Function4 function43) {
        return (function4 == null && function42 == null && function43 == null) ? ComposableSingletons$SubcomposeAsyncImageKt.f55548a.a() : ComposableLambdaKt.c(-1302781228, true, new Function3<SubcomposeAsyncImageScope, Composer, Integer, Unit>() { // from class: coil.compose.SubcomposeAsyncImageKt$contentOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
            /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void c(coil.compose.SubcomposeAsyncImageScope r12, androidx.compose.runtime.Composer r13, int r14) {
                /*
                    Method dump skipped, instruction units count: 209
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: coil.compose.SubcomposeAsyncImageKt$contentOf$1.c(coil.compose.SubcomposeAsyncImageScope, androidx.compose.runtime.Composer, int):void");
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                c((SubcomposeAsyncImageScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }
        });
    }
}
