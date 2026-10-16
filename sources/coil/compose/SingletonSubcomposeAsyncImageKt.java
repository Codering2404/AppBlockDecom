package coil.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.ContentScale;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class SingletonSubcomposeAsyncImageKt {
    public static final void a(final Object obj, final String str, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, final Function3 function3, Composer composer, int i4, final int i5, final int i6) {
        final int i7;
        Function1 function1A;
        int i8;
        int iB;
        Composer composerK = composer.k(1571662781);
        Modifier modifier2 = (i6 & 4) != 0 ? Modifier.b8 : modifier;
        if ((i6 & 8) != 0) {
            i7 = i4;
            i8 = i7 & (-7169);
            function1A = AsyncImagePainter.f55509w.a();
        } else {
            i7 = i4;
            function1A = function1;
            i8 = i7;
        }
        Function1 function13 = (i6 & 16) != 0 ? null : function12;
        Alignment alignmentE = (i6 & 32) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i6 & 64) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i6 & Function.MAX_NARGS) != 0 ? null : colorFilter;
        if ((i6 & 512) != 0) {
            i8 &= -1879048193;
            iB = DrawScope.e8.b();
        } else {
            iB = i3;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1571662781, i8, i5, "coil.compose.SubcomposeAsyncImage (SingletonSubcomposeAsyncImage.kt:100)");
        }
        int i9 = i8 << 3;
        SubcomposeAsyncImageKt.b(obj, str, ImageLoaderProvidableCompositionLocal.d(LocalImageLoaderKt.a(), composerK, 6), modifier2, function1A, function13, alignmentE, contentScaleE, f4, colorFilter2, iB, function3, composerK, (i8 & 112) | 520 | (i9 & 7168) | (57344 & i9) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9) | (i9 & 1879048192), ((i8 >> 27) & 14) | ((i5 << 3) & 112), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        final Function1 function14 = function1A;
        final Function1 function15 = function13;
        final Alignment alignment2 = alignmentE;
        final ContentScale contentScale2 = contentScaleE;
        final float f5 = f4;
        final ColorFilter colorFilter3 = colorFilter2;
        final int i10 = iB;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i11) {
                SingletonSubcomposeAsyncImageKt.a(obj, str, modifier3, function14, function15, alignment2, contentScale2, f5, colorFilter3, i10, function3, composer2, RecomposeScopeImplKt.a(i7 | 1), RecomposeScopeImplKt.a(i5), i6);
            }
        });
    }

    public static final void b(final Object obj, final String str, Modifier modifier, Function4 function4, Function4 function42, Function4 function43, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Composer composer, final int i4, int i5, final int i6) {
        int i7;
        int iB;
        int i8;
        Composer composerK = composer.k(1047090393);
        Modifier modifier2 = (i6 & 4) != 0 ? Modifier.b8 : modifier;
        Function4 function44 = (i6 & 8) != 0 ? null : function4;
        Function4 function45 = (i6 & 16) != 0 ? null : function42;
        Function4 function46 = (i6 & 32) != 0 ? null : function43;
        Function1 function14 = (i6 & 64) != 0 ? null : function1;
        Function1 function15 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : function12;
        Function1 function16 = (i6 & Function.MAX_NARGS) != 0 ? null : function13;
        Alignment alignmentE = (i6 & 512) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i6 & 1024) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i6 & 2048) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i6 & 4096) != 0 ? null : colorFilter;
        if ((i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            i7 = i5;
            i8 = i7 & (-7169);
            iB = DrawScope.e8.b();
        } else {
            i7 = i5;
            iB = i3;
            i8 = i7;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1047090393, i4, i8, "coil.compose.SubcomposeAsyncImage (SingletonSubcomposeAsyncImage.kt:43)");
        }
        int i9 = i4 << 3;
        int i10 = (i4 & 112) | 520 | (i9 & 7168) | (i9 & 57344) | (458752 & i9) | (3670016 & i9) | (29360128 & i9) | (234881024 & i9) | (i9 & 1879048192);
        int i11 = i8 << 3;
        SubcomposeAsyncImageKt.a(obj, str, ImageLoaderProvidableCompositionLocal.d(LocalImageLoaderKt.a(), composerK, 6), modifier2, function44, function45, function46, function14, function15, function16, alignmentE, contentScaleE, f4, colorFilter2, iB, composerK, i10, ((i4 >> 27) & 14) | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (i11 & 57344), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        final int i12 = i7;
        final Modifier modifier3 = modifier2;
        final Function4 function47 = function44;
        final Function4 function48 = function45;
        final Function4 function49 = function46;
        final Function1 function17 = function14;
        final Function1 function18 = function15;
        final Function1 function19 = function16;
        final Alignment alignment2 = alignmentE;
        final ContentScale contentScale2 = contentScaleE;
        final float f5 = f4;
        final ColorFilter colorFilter3 = colorFilter2;
        final int i13 = iB;
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.SingletonSubcomposeAsyncImageKt$SubcomposeAsyncImage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i14) {
                SingletonSubcomposeAsyncImageKt.b(obj, str, modifier3, function47, function48, function49, function17, function18, function19, alignment2, contentScale2, f5, colorFilter3, i13, composer2, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i12), i6);
            }
        });
    }
}
