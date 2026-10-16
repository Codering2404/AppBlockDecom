package coil.compose;

import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import coil.ImageLoader;
import coil.request.ImageRequest;
import coil.size.Dimension;
import coil.size.Dimensions;
import coil.size.Size;
import coil.size.SizeResolver;
import coil.size.SizeResolvers;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AsyncImageKt {
    public static final void a(final Object obj, final String str, final ImageLoader imageLoader, Modifier modifier, Function1 function1, Function1 function12, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Composer composer, final int i4, final int i5, final int i6) {
        final int iB;
        int i7;
        Composer composerK = composer.k(-2030202961);
        final Modifier modifier2 = (i6 & 8) != 0 ? Modifier.b8 : modifier;
        final Function1 function1A = (i6 & 16) != 0 ? AsyncImagePainter.f55509w.a() : function1;
        final Function1 function13 = (i6 & 32) != 0 ? null : function12;
        final Alignment alignmentE = (i6 & 64) != 0 ? Alignment.f25072a.e() : alignment;
        final ContentScale contentScaleE = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? ContentScale.f27054a.e() : contentScale;
        final float f4 = (i6 & Function.MAX_NARGS) != 0 ? 1.0f : f3;
        final ColorFilter colorFilter2 = (i6 & 512) != 0 ? null : colorFilter;
        if ((i6 & 1024) != 0) {
            i7 = i5 & (-15);
            iB = DrawScope.e8.b();
        } else {
            iB = i3;
            i7 = i5;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-2030202961, i4, i7, "coil.compose.AsyncImage (AsyncImage.kt:118)");
        }
        ImageRequest imageRequestG = g(UtilsKt.e(obj, composerK, 8), contentScaleE, composerK, 8 | ((i4 >> 18) & 112));
        int i8 = i4 >> 6;
        int i9 = i4 >> 9;
        int i10 = i9 & 57344;
        Function1 function14 = function1A;
        Function1 function15 = function13;
        ContentScale contentScale2 = contentScaleE;
        int i11 = iB;
        AsyncImagePainter asyncImagePainterE = AsyncImagePainterKt.e(imageRequestG, imageLoader, function14, function15, contentScale2, i11, composerK, ((i7 << 15) & 458752) | (i8 & 7168) | (i8 & 896) | 72 | i10, 0);
        SizeResolver sizeResolverK = imageRequestG.K();
        c(sizeResolverK instanceof ConstraintsSizeResolver ? modifier2.then((Modifier) sizeResolverK) : modifier2, asyncImagePainterE, str, alignmentE, contentScaleE, f4, colorFilter2, composerK, (i9 & 7168) | ((i4 << 3) & 896) | i10 | (i9 & 458752) | (3670016 & i9));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.AsyncImageKt$AsyncImage$1
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
                AsyncImageKt.a(obj, str, imageLoader, modifier2, function1A, function13, alignmentE, contentScaleE, f4, colorFilter2, iB, composer2, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
            }
        });
    }

    public static final void b(Object obj, String str, ImageLoader imageLoader, Modifier modifier, Painter painter, Painter painter2, Painter painter3, Function1 function1, Function1 function12, Function1 function13, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter, int i3, Composer composer, int i4, int i5, int i6) {
        composer.F(-245964807);
        Modifier modifier2 = (i6 & 8) != 0 ? Modifier.b8 : modifier;
        Painter painter4 = (i6 & 16) != 0 ? null : painter;
        Painter painter5 = (i6 & 32) != 0 ? null : painter2;
        Painter painter6 = (i6 & 64) != 0 ? painter5 : painter3;
        Function1 function14 = (i6 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : function1;
        Function1 function15 = (i6 & Function.MAX_NARGS) != 0 ? null : function12;
        Function1 function16 = (i6 & 512) != 0 ? null : function13;
        Alignment alignmentE = (i6 & 1024) != 0 ? Alignment.f25072a.e() : alignment;
        ContentScale contentScaleE = (i6 & 2048) != 0 ? ContentScale.f27054a.e() : contentScale;
        float f4 = (i6 & 4096) != 0 ? 1.0f : f3;
        ColorFilter colorFilter2 = (i6 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : colorFilter;
        int iB = (i6 & 16384) != 0 ? DrawScope.e8.b() : i3;
        if (ComposerKt.M()) {
            ComposerKt.U(-245964807, i4, i5, "coil.compose.AsyncImage (AsyncImage.kt:64)");
        }
        int i7 = i5 << 18;
        a(obj, str, imageLoader, modifier2, UtilsKt.h(painter4, painter5, painter6), UtilsKt.d(function14, function15, function16), alignmentE, contentScaleE, f4, colorFilter2, iB, composer, (i4 & 7168) | (i4 & 112) | 520 | (3670016 & i7) | (29360128 & i7) | (234881024 & i7) | (i7 & 1879048192), (i5 >> 12) & 14, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
    }

    public static final void c(final Modifier modifier, final Painter painter, final String str, final Alignment alignment, final ContentScale contentScale, final float f3, final ColorFilter colorFilter, Composer composer, int i3) {
        final int i4;
        Composer composerK = composer.k(10290533);
        if (ComposerKt.M()) {
            i4 = i3;
            ComposerKt.U(10290533, i4, -1, "coil.compose.Content (AsyncImage.kt:156)");
        } else {
            i4 = i3;
        }
        Modifier modifierThen = ClipKt.b(e(modifier, str)).then(new ContentPainterModifier(painter, alignment, contentScale, f3, colorFilter));
        AsyncImageKt$Content$1 asyncImageKt$Content$1 = new MeasurePolicy() { // from class: coil.compose.AsyncImageKt$Content$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
                return MeasureScope.B0(measureScope, Constraints.n(j3), Constraints.m(j3), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.AsyncImageKt$Content$1$measure$1
                    public final void invoke(Placeable.PlacementScope placementScope) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.f139807a;
                    }
                }, 4, null);
            }
        };
        composerK.F(544976794);
        Density density = (Density) composerK.q(CompositionLocalsKt.f());
        LayoutDirection layoutDirection = (LayoutDirection) composerK.q(CompositionLocalsKt.m());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerK.q(CompositionLocalsKt.t());
        Modifier modifierG = ComposedModifierKt.g(composerK, modifierThen);
        ComposeUiNode.Companion companion = ComposeUiNode.f8;
        final Function0 function0A = companion.a();
        composerK.F(1405779621);
        if (composerK.m() == null) {
            ComposablesKt.c();
        }
        composerK.L();
        if (composerK.i()) {
            composerK.P(new Function0<ComposeUiNode>() { // from class: coil.compose.AsyncImageKt$Content$$inlined$Layout$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return function0A.invoke();
                }
            });
        } else {
            composerK.v();
        }
        Composer composerA = Updater.a(composerK);
        Updater.e(composerA, asyncImageKt$Content$1, companion.e());
        Updater.e(composerA, density, companion.c());
        Updater.e(composerA, layoutDirection, companion.d());
        Updater.e(composerA, viewConfiguration, companion.h());
        Updater.e(composerA, modifierG, companion.f());
        composerK.y();
        composerK.Y();
        composerK.Y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN == null) {
            return;
        }
        scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: coil.compose.AsyncImageKt$Content$2
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
                AsyncImageKt.c(modifier, painter, str, alignment, contentScale, f3, colorFilter, composer2, RecomposeScopeImplKt.a(i4 | 1));
            }
        });
    }

    private static final Modifier e(Modifier modifier, final String str) {
        return str != null ? SemanticsModifierKt.f(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: coil.compose.AsyncImageKt$contentDescription$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.f139807a;
            }

            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.d0(semanticsPropertyReceiver, str);
                SemanticsPropertiesKt.r0(semanticsPropertyReceiver, Role.f28457b.e());
            }
        }, 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Size f(long j3) {
        if (Constraints.p(j3)) {
            return null;
        }
        return new Size(Constraints.h(j3) ? Dimensions.a(Constraints.l(j3)) : Dimension.Undefined.f56164a, Constraints.g(j3) ? Dimensions.a(Constraints.k(j3)) : Dimension.Undefined.f56164a);
    }

    public static final ImageRequest g(ImageRequest imageRequest, ContentScale contentScale, Composer composer, int i3) {
        SizeResolver sizeResolverA;
        composer.F(402368983);
        if (ComposerKt.M()) {
            ComposerKt.U(402368983, i3, -1, "coil.compose.updateRequest (AsyncImage.kt:183)");
        }
        if (imageRequest.q().m() == null) {
            if (Intrinsics.areEqual(contentScale, ContentScale.f27054a.g())) {
                sizeResolverA = SizeResolvers.a(Size.f56177d);
            } else {
                composer.F(-492369756);
                Object objG = composer.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new ConstraintsSizeResolver();
                    composer.w(objG);
                }
                composer.Y();
                sizeResolverA = (SizeResolver) objG;
            }
            imageRequest = ImageRequest.R(imageRequest, null, 1, null).s(sizeResolverA).a();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return imageRequest;
    }
}
