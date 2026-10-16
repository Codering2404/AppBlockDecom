package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class NavigationItemKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18717a = NavigationRailKt.l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18718b = NavigationRailKt.k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f18719c = Dp.g(12);

    public static final void a(final boolean z2, final Function0 function0, final Function2 function2, final TextStyle textStyle, final Shape shape, final float f3, final float f4, final float f5, final float f6, final float f7, final float f8, final NavigationItemColors navigationItemColors, final Modifier modifier, final boolean z3, final Function2 function22, final Function2 function23, final int i3, MutableInteractionSource mutableInteractionSource, Composer composer, final int i4, final int i5) {
        int i6;
        Shape shape2;
        int i7;
        boolean z4;
        MutableInteractionSource mutableInteractionSource2;
        int i8;
        MappedInteractionSource mappedInteractionSource;
        Composer composer2;
        Composer composerK = composer.k(547979956);
        if ((i4 & 6) == 0) {
            i6 = (composerK.b(z2) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.I(function0) ? 32 : 16;
        }
        int i9 = i4 & 384;
        int i10 = ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        if (i9 == 0) {
            i6 |= composerK.I(function2) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.Z(textStyle) ? 2048 : 1024;
        }
        int i11 = i4 & 24576;
        int i12 = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        if (i11 == 0) {
            shape2 = shape;
            i6 |= composerK.Z(shape2) ? 16384 : 8192;
        } else {
            shape2 = shape;
        }
        int i13 = i4 & 196608;
        int i14 = NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        if (i13 == 0) {
            i6 |= composerK.c(f3) ? 131072 : 65536;
        }
        if ((i4 & 1572864) == 0) {
            i6 |= composerK.c(f4) ? 1048576 : 524288;
        }
        if ((i4 & 12582912) == 0) {
            i6 |= composerK.c(f5) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= composerK.c(f6) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i6 |= composerK.c(f7) ? 536870912 : 268435456;
        }
        if ((i5 & 6) == 0) {
            i7 = i5 | (composerK.c(f8) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= composerK.Z(navigationItemColors) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            if (composerK.Z(modifier)) {
                i10 = 256;
            }
            i7 |= i10;
        }
        if ((i5 & 3072) == 0) {
            i7 |= composerK.b(z3) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            if (composerK.I(function22)) {
                i12 = 16384;
            }
            i7 |= i12;
        }
        if ((i5 & 196608) == 0) {
            if (composerK.I(function23)) {
                i14 = 131072;
            }
            i7 |= i14;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= composerK.e(i3) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= composerK.Z(mutableInteractionSource) ? 8388608 : 4194304;
        }
        int i15 = i7;
        if ((i6 & 306783379) == 306783378 && (4793491 & i15) == 4793490 && composerK.l()) {
            composerK.Q();
            mutableInteractionSource2 = mutableInteractionSource;
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(547979956, i6, i15, "androidx.compose.material3.NavigationItem (NavigationItem.kt:252)");
            }
            int i16 = i6;
            final ComposableLambda composableLambdaE = ComposableLambdaKt.e(-44329638, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i17) {
                    if ((i17 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-44329638, i17, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:255)");
                    }
                    long jB = navigationItemColors.b(z2, z3);
                    Modifier modifierC = function22 != null ? SemanticsModifierKt.c(Modifier.b8, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledIcon$1.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }
                    }) : Modifier.b8;
                    Function2 function24 = function2;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU = composer3.u();
                    Modifier modifierF = ComposedModifierKt.f(composer3, modifierC);
                    ComposeUiNode.Companion companion = ComposeUiNode.f8;
                    Function0 function0A = companion.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A);
                    } else {
                        composer3.v();
                    }
                    Composer composerA = Updater.a(composer3);
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    CompositionLocalKt.b(ContentColorKt.a().d(Color.n(jB)), function24, composer3, ProvidedValue.f24012i);
                    composer3.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54);
            composerK.a0(-1735402128);
            if (function23 != null) {
                composableLambdaE = ComposableLambdaKt.e(1836184859, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer3, int i17) {
                        if ((i17 & 3) == 2 && composer3.l()) {
                            composer3.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(1836184859, i17, -1, "androidx.compose.material3.NavigationItem.<anonymous> (NavigationItem.kt:264)");
                        }
                        final Function2 function24 = function23;
                        ComposableLambda composableLambdaE2 = ComposableLambdaKt.e(870803363, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(BoxScope boxScope, Composer composer4, int i18) {
                                if ((i18 & 17) == 16 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(870803363, i18, -1, "androidx.compose.material3.NavigationItem.<anonymous>.<anonymous> (NavigationItem.kt:264)");
                                }
                                function24.invoke(composer4, 0);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54);
                        final Function2 function25 = composableLambdaE;
                        BadgeKt.b(composableLambdaE2, null, ComposableLambdaKt.e(-1365557663, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$iconWithBadge$1.2
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((BoxScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(BoxScope boxScope, Composer composer4, int i18) {
                                if ((i18 & 17) == 16 && composer4.l()) {
                                    composer4.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-1365557663, i18, -1, "androidx.compose.material3.NavigationItem.<anonymous>.<anonymous> (NavigationItem.kt:264)");
                                }
                                function25.invoke(composer4, 6);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer3, 54), composer3, 390, 2);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54);
            }
            ComposableLambda composableLambda = composableLambdaE;
            composerK.U();
            composerK.a0(-1735395524);
            ComposableLambda composableLambdaE2 = null;
            if (function22 == null) {
                z4 = true;
            } else {
                z4 = true;
                composableLambdaE2 = ComposableLambdaKt.e(-254668050, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$styledLabel$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer3, int i17) {
                        if ((i17 & 3) == 2 && composer3.l()) {
                            composer3.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(-254668050, i17, -1, "androidx.compose.material3.NavigationItem.<anonymous>.<anonymous> (NavigationItem.kt:272)");
                        }
                        ProvideContentColorTextStyleKt.a(navigationItemColors.c(z2, z3), textStyle, function22, composer3, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54);
            }
            ComposableLambda composableLambda2 = composableLambdaE2;
            composerK.U();
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotIntStateKt.a(0);
                composerK.w(objG);
            }
            final MutableIntState mutableIntState = (MutableIntState) objG;
            mutableInteractionSource2 = mutableInteractionSource;
            Modifier modifierA = SizeKt.a(SelectableKt.a(modifier, z2, mutableInteractionSource2, null, z3, Role.j(Role.f28457b.h()), function0), f18717a, f18718b);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m174invokeozmzZPI(((IntSize) obj).j());
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m174invokeozmzZPI(long j3) {
                        NavigationItemKt.d(mutableIntState, IntSize.g(j3));
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierA2 = OnRemeasuredModifierKt.a(modifierA, (Function1) objG2);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), z4);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            final State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, AnimationSpecKt.n(100, 0, null, 6, null), 0.0f, null, null, composerK, 48, 28);
            composerK.a0(-1634400795);
            if (NavigationItemIconPosition.d(i3, NavigationItemIconPosition.f18713b.a())) {
                i8 = 29360128;
                long jA = OffsetKt.a((c(mutableIntState) - r8.z0(f3)) / 2, ((Density) composerK.q(CompositionLocalsKt.f())).M1(f18719c));
                Unit unit = Unit.f139807a;
                boolean zF = ((i15 & 29360128) == 8388608) | composerK.f(jA);
                Object objG3 = composerK.G();
                if (zF || objG3 == companion.a()) {
                    objG3 = new MappedInteractionSource(mutableInteractionSource2, jA, null);
                    composerK.w(objG3);
                }
                mappedInteractionSource = (MappedInteractionSource) objG3;
            } else {
                i8 = 29360128;
                mappedInteractionSource = null;
            }
            composerK.U();
            InteractionSource interactionSource = mappedInteractionSource != null ? mappedInteractionSource : mutableInteractionSource2;
            long jA2 = navigationItemColors.a();
            boolean Z = composerK.Z(stateD);
            Object objG4 = composerK.G();
            if (Z || objG4 == companion.a()) {
                objG4 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$2$3$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return (Float) stateD.getValue();
                    }
                };
                composerK.w(objG4);
            }
            int i17 = i16 << 3;
            b(interactionSource, jA2, shape2, composableLambda, i3, composableLambda2, (Function0) objG4, f4, f5, f6, f7, f8, composerK, ((i16 >> 6) & 896) | ((i15 >> 6) & 57344) | (i17 & i8) | (234881024 & i17) | (i17 & 1879048192), ((i16 >> 27) & 14) | ((i15 << 3) & 112));
            composer2 = composerK;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItem$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i18) {
                    NavigationItemKt.a(z2, function0, function2, textStyle, shape, f3, f4, f5, f6, f7, f8, navigationItemColors, modifier, z3, function22, function23, i3, mutableInteractionSource3, composer3, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v29 */
    public static final void b(final InteractionSource interactionSource, final long j3, final Shape shape, final Function2 function2, final int i3, final Function2 function22, Function0 function0, final float f3, final float f4, final float f5, final float f6, final float f7, Composer composer, final int i4, final int i5) {
        int i6;
        int i7;
        ?? r02;
        int i8;
        Object topIconOrIconOnlyMeasurePolicy;
        Composer composer2;
        final Function0 function02;
        Composer composerK = composer.k(1757687417);
        if ((i4 & 6) == 0) {
            i6 = (composerK.Z(interactionSource) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= composerK.Z(shape) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.I(function2) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i6 |= composerK.e(i3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i6 |= composerK.I(function22) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i6 |= composerK.I(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i6 |= composerK.c(f3) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i6 |= composerK.c(f4) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i6 |= composerK.c(f5) ? 536870912 : 268435456;
        }
        if ((i5 & 6) == 0) {
            i7 = i5 | (composerK.c(f6) ? 4 : 2);
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= composerK.c(f7) ? 32 : 16;
        }
        int i9 = i7;
        if ((i6 & 306783379) == 306783378 && (i9 & 19) == 18 && composerK.l()) {
            composerK.Q();
            function02 = function0;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1757687417, i6, i9, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:355)");
            }
            if (function22 == null || NavigationItemIconPosition.d(i3, NavigationItemIconPosition.f18713b.a())) {
                r02 = 0;
                i8 = i6;
                composer2 = composerK;
                topIconOrIconOnlyMeasurePolicy = new TopIconOrIconOnlyMeasurePolicy(function22 != null, function0, f3, f4, f5, f7, null);
                function02 = function0;
            } else {
                r02 = 0;
                i8 = i6;
                function02 = function0;
                topIconOrIconOnlyMeasurePolicy = new StartIconMeasurePolicy(function02, f3, f4, f6, null);
                composer2 = composerK;
            }
            Modifier.Companion companion = Modifier.b8;
            int iA = ComposablesKt.a(composer2, r02);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, topIconOrIconOnlyMeasurePolicy, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            composerK = composer2;
            BoxKt.a(IndicationKt.b(ClipKt.a(LayoutIdKt.b(companion, "indicatorRipple"), shape), interactionSource, RippleKt.d(false, 0.0f, 0L, composerK, 0, 7)), composerK, r02);
            Modifier modifierB = LayoutIdKt.b(companion, "indicator");
            ?? r10 = (i8 & 3670016) == 1048576 ? 1 : r02;
            Object objG = composerK.G();
            if (r10 != 0 || objG == Composer.f23746a.a()) {
                objG = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItemLayout$1$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.c(((Number) function02.invoke()).floatValue());
                    }
                };
                composerK.w(objG);
            }
            BoxKt.a(BackgroundKt.c(GraphicsLayerModifierKt.a(modifierB, (Function1) objG), j3, shape), composerK, r02);
            Modifier modifierB2 = LayoutIdKt.b(companion, "icon");
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), r02);
            int iA2 = ComposablesKt.a(composerK, r02);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierB2);
            Function0 function0A2 = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            function2.invoke(composerK, Integer.valueOf((i8 >> 9) & 14));
            composerK.y();
            composerK.a0(-776741606);
            if (function22 != null) {
                Modifier modifierB3 = LayoutIdKt.b(companion, "label");
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB3);
                Function0 function0A3 = companion2.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A3);
                } else {
                    composerK.v();
                }
                Composer composerA3 = Updater.a(composerK);
                Updater.e(composerA3, measurePolicyG2, companion2.e());
                Updater.e(composerA3, compositionLocalMapU3, companion2.g());
                Function2 function2B3 = companion2.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion2.f());
                function22.invoke(composerK, Integer.valueOf((i8 >> 15) & 14));
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function0 function03 = function02;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$NavigationItemLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i10) {
                    NavigationItemKt.b(interactionSource, j3, shape, function2, i3, function22, function03, f3, f4, f5, f6, f7, composer3, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5));
                }
            });
        }
    }

    private static final int c(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult j(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j3) {
        int iG = ConstraintsKt.g(j3, placeable2.X0());
        int iF = ConstraintsKt.f(j3, placeable2.O0());
        final int iX0 = (iG - placeable3.X0()) / 2;
        final int iO0 = (iF - placeable3.O0()) / 2;
        final int iX02 = (iG - placeable.X0()) / 2;
        final int iO02 = (iF - placeable.O0()) / 2;
        final int iX03 = (iG - placeable2.X0()) / 2;
        final int iO03 = (iF - placeable2.O0()) / 2;
        return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$placeIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.m(placementScope, placeable3, iX0, iO0, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable, iX02, iO02, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable2, iX03, iO03, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult k(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j3, float f3) {
        int iG = ConstraintsKt.g(j3, placeable3.X0());
        int iF = ConstraintsKt.f(j3, placeable3.O0());
        final int iX0 = (iG - placeable4.X0()) / 2;
        final int iO0 = (iF - placeable4.O0()) / 2;
        final int iO02 = (iF - placeable2.O0()) / 2;
        final int iO03 = (iF - placeable.O0()) / 2;
        final int iX02 = (iG - ((placeable2.X0() + measureScope.z0(f3)) + placeable.X0())) / 2;
        final int iX03 = placeable2.X0() + iX02 + measureScope.z0(f3);
        final int iX04 = (iG - placeable3.X0()) / 2;
        final int iO04 = (iF - placeable3.O0()) / 2;
        return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$placeLabelAndStartIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.m(placementScope, placeable4, iX0, iO0, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable, iX03, iO03, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable2, iX02, iO02, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable3, iX04, iO04, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult l(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j3, float f3, float f4, float f5) {
        int iG = ConstraintsKt.g(j3, Math.max(placeable.X0(), placeable3.X0()));
        int iF = ConstraintsKt.f(j3, MathKt.d(placeable3.O0() + measureScope.M1(f3) + placeable.O0() + (measureScope.M1(f5) * 2)));
        final int iZ0 = measureScope.z0(Dp.g(f5 + f4));
        final int iX0 = (iG - placeable2.X0()) / 2;
        final int iX02 = (iG - placeable4.X0()) / 2;
        final int iZ02 = iZ0 - measureScope.z0(f4);
        final int iX03 = (iG - placeable.X0()) / 2;
        final int iO0 = iZ0 + placeable2.O0() + measureScope.z0(Dp.g(f3 + f4));
        final int iX04 = (iG - placeable3.X0()) / 2;
        return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationItemKt$placeLabelAndTopIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.m(placementScope, placeable4, iX02, iZ02, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable, iX03, iO0, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable2, iX0, iZ0, 0.0f, 4, null);
                Placeable.PlacementScope.m(placementScope, placeable3, iX04, iZ02, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
