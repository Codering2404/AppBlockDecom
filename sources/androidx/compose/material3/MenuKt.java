package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
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
import kotlin.jvm.internal.FloatCompanionObject;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MenuKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f18149c = Dp.g(12);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f18150d = Dp.g(8);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f18151e = Dp.g(112);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f18152f = Dp.g(280);

    static {
        float f3 = 48;
        f18147a = Dp.g(f3);
        f18148b = Dp.g(f3);
    }

    public static final void a(final Modifier modifier, final MutableTransitionState mutableTransitionState, final MutableState mutableState, final ScrollState scrollState, final Shape shape, final long j3, final float f3, final float f4, final BorderStroke borderStroke, final Function3 function3, Composer composer, final int i3) {
        int i4;
        boolean z2;
        Object obj;
        int i5;
        Composer composer2;
        Composer composerK = composer.k(-151448888);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(mutableTransitionState) : composerK.I(mutableTransitionState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(mutableState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(scrollState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(shape) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.f(j3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i3 & 1572864) == 0) {
            i4 |= composerK.c(f3) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i4 |= composerK.c(f4) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i4 |= composerK.Z(borderStroke) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i4 |= composerK.I(function3) ? 536870912 : 268435456;
        }
        if ((i4 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-151448888, i4, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:374)");
            }
            Transition transitionI = TransitionKt.i(mutableTransitionState, "DropDownMenu", composerK, MutableTransitionState.f4020d | 48 | ((i4 >> 3) & 14), 0);
            MenuKt$DropdownMenuContent$scale$2 menuKt$DropdownMenuContent$scale$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$scale$2
                public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer3, int i6) {
                    composer3.a0(1033023423);
                    if (ComposerKt.M()) {
                        ComposerKt.U(1033023423, i6, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:381)");
                    }
                    TweenSpec tweenSpecN = segment.d(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.n(120, 0, EasingKt.f(), 2, null) : AnimationSpecKt.n(1, 74, null, 4, null);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer3.U();
                    return tweenSpecN;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    return c((Transition.Segment) obj2, (Composer) obj3, ((Number) obj4).intValue());
                }
            };
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.f140130a;
            TwoWayConverter twoWayConverterI = VectorConvertersKt.i(floatCompanionObject);
            boolean zBooleanValue = ((Boolean) transitionI.i()).booleanValue();
            composerK.a0(2139028452);
            if (ComposerKt.M()) {
                ComposerKt.U(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            }
            float f5 = zBooleanValue ? 1.0f : 0.8f;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composerK.U();
            Float fValueOf = Float.valueOf(f5);
            boolean zBooleanValue2 = ((Boolean) transitionI.q()).booleanValue();
            composerK.a0(2139028452);
            if (ComposerKt.M()) {
                ComposerKt.U(2139028452, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
            }
            float f6 = zBooleanValue2 ? 1.0f : 0.8f;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composerK.U();
            final State stateF = TransitionKt.f(transitionI, fValueOf, Float.valueOf(f6), (FiniteAnimationSpec) menuKt$DropdownMenuContent$scale$2.invoke(transitionI.o(), composerK, 0), twoWayConverterI, "FloatAnimation", composerK, 0);
            MenuKt$DropdownMenuContent$alpha$2 menuKt$DropdownMenuContent$alpha$2 = new Function3<Transition.Segment<Boolean>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$alpha$2
                public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer3, int i6) {
                    composer3.a0(-1355418157);
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1355418157, i6, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:396)");
                    }
                    TweenSpec tweenSpecN = segment.d(Boolean.FALSE, Boolean.TRUE) ? AnimationSpecKt.n(30, 0, null, 6, null) : AnimationSpecKt.n(75, 0, null, 6, null);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                    composer3.U();
                    return tweenSpecN;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    return c((Transition.Segment) obj2, (Composer) obj3, ((Number) obj4).intValue());
                }
            };
            TwoWayConverter twoWayConverterI2 = VectorConvertersKt.i(floatCompanionObject);
            boolean zBooleanValue3 = ((Boolean) transitionI.i()).booleanValue();
            composerK.a0(-249413128);
            if (ComposerKt.M()) {
                ComposerKt.U(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            }
            float f7 = zBooleanValue3 ? 1.0f : 0.0f;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composerK.U();
            Float fValueOf2 = Float.valueOf(f7);
            boolean zBooleanValue4 = ((Boolean) transitionI.q()).booleanValue();
            composerK.a0(-249413128);
            if (ComposerKt.M()) {
                z2 = false;
                ComposerKt.U(-249413128, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
            } else {
                z2 = false;
            }
            float f8 = zBooleanValue4 ? 1.0f : 0.0f;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composerK.U();
            final State stateF2 = TransitionKt.f(transitionI, fValueOf2, Float.valueOf(f8), (FiniteAnimationSpec) menuKt$DropdownMenuContent$alpha$2.invoke(transitionI.o(), composerK, 0), twoWayConverterI2, "FloatAnimation", composerK, 0);
            final boolean zBooleanValue5 = ((Boolean) composerK.q(InspectionModeKt.a())).booleanValue();
            Modifier.Companion companion = Modifier.b8;
            boolean zB = composerK.b(zBooleanValue5) | composerK.Z(stateF) | (((i4 & 112) == 32 || ((i4 & 64) != 0 && composerK.I(mutableTransitionState))) ? true : z2) | composerK.Z(stateF2);
            if ((i4 & 896) == 256) {
                z2 = true;
            }
            boolean z3 = zB | z2;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                i5 = i4;
                obj = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((GraphicsLayerScope) obj2);
                        return Unit.f139807a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        float fB = 0.8f;
                        float fC = 1.0f;
                        graphicsLayerScope.e(!zBooleanValue5 ? MenuKt.b(stateF) : ((Boolean) mutableTransitionState.b()).booleanValue() ? 1.0f : 0.8f);
                        if (!zBooleanValue5) {
                            fB = MenuKt.b(stateF);
                        } else if (((Boolean) mutableTransitionState.b()).booleanValue()) {
                            fB = 1.0f;
                        }
                        graphicsLayerScope.k(fB);
                        if (!zBooleanValue5) {
                            fC = MenuKt.c(stateF2);
                        } else if (!((Boolean) mutableTransitionState.b()).booleanValue()) {
                            fC = 0.0f;
                        }
                        graphicsLayerScope.c(fC);
                        graphicsLayerScope.A0(((TransformOrigin) mutableState.getValue()).j());
                    }
                };
                composerK.w(obj);
            } else {
                obj = objG;
                i5 = i4;
            }
            int i6 = i5 >> 9;
            int i7 = i5 >> 6;
            SurfaceKt.a(GraphicsLayerModifierKt.a(companion, (Function1) obj), shape, j3, 0L, f3, f4, borderStroke, ComposableLambdaKt.e(1573559053, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i8) {
                    if ((i8 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1573559053, i8, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:429)");
                    }
                    Modifier modifierG = ScrollKt.g(IntrinsicKt.b(PaddingKt.k(modifier, 0.0f, MenuKt.i(), 1, null), IntrinsicSize.f6987b), scrollState, false, null, false, 14, null);
                    Function3 function32 = function3;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer3, 0);
                    int iA = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU = composer3.u();
                    Modifier modifierF = ComposedModifierKt.f(composer3, modifierG);
                    ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                    Function0 function0A = companion2.a();
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
                    Updater.e(composerA, measurePolicyA, companion2.e());
                    Updater.e(composerA, compositionLocalMapU, companion2.g());
                    Function2 function2B = companion2.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion2.f());
                    function32.invoke(ColumnScopeInstance.f6666a, composer3, 6);
                    composer3.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, (i6 & 896) | (i6 & 112) | 12582912 | (57344 & i7) | (458752 & i7) | (i7 & 3670016), 8);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuContent$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i8) {
                    MenuKt.a(modifier, mutableTransitionState, mutableState, scrollState, shape, j3, f3, f4, borderStroke, function3, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float c(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static final void d(final Function2 function2, final Function0 function0, final Modifier modifier, final Function2 function22, final Function2 function23, final boolean z2, final MenuItemColors menuItemColors, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1564716777);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function22) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function23) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.b(z2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(menuItemColors) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.Z(paddingValues) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.Z(mutableInteractionSource) ? 67108864 : 33554432;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1564716777, i4, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:451)");
            }
            Modifier modifierH = PaddingKt.h(SizeKt.z(SizeKt.h(ClickableKt.d(modifier, mutableInteractionSource, RippleKt.d(true, 0.0f, 0L, composerK, 6, 6), z2, null, null, function0, 24, null), 0.0f, 1, null), f18151e, f18148b, f18152f, 0.0f, 8, null), paddingValues);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            final RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.a(MaterialTheme.f18110a.c(composerK, 6).k(), ComposableLambdaKt.e(1065051884, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1
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
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1065051884, i5, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:473)");
                    }
                    composer2.a0(1264683960);
                    if (function22 != null) {
                        ProvidedValue providedValueD = ContentColorKt.a().d(Color.n(menuItemColors.a(z2)));
                        final Function2 function24 = function22;
                        CompositionLocalKt.b(providedValueD, ComposableLambdaKt.e(2035552199, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer3, int i6) {
                                if ((i6 & 3) == 2 && composer3.l()) {
                                    composer3.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(2035552199, i6, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:477)");
                                }
                                Modifier modifierB = SizeKt.b(Modifier.b8, ListTokens.f22906a.m(), 0.0f, 2, null);
                                Function2 function25 = function24;
                                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                                int iA2 = ComposablesKt.a(composer3, 0);
                                CompositionLocalMap compositionLocalMapU2 = composer3.u();
                                Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierB);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                                Function0 function0A2 = companion2.a();
                                if (composer3.m() == null) {
                                    ComposablesKt.c();
                                }
                                composer3.L();
                                if (composer3.i()) {
                                    composer3.P(function0A2);
                                } else {
                                    composer3.v();
                                }
                                Composer composerA2 = Updater.a(composer3);
                                Updater.e(composerA2, measurePolicyG, companion2.e());
                                Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                                Function2 function2B2 = companion2.b();
                                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                                    composerA2.w(Integer.valueOf(iA2));
                                    composerA2.p(Integer.valueOf(iA2), function2B2);
                                }
                                Updater.e(composerA2, modifierF2, companion2.f());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                function25.invoke(composer3, 0);
                                composer3.y();
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer2, 54), composer2, ProvidedValue.f24012i | 48);
                    }
                    composer2.U();
                    ProvidedValue providedValueD2 = ContentColorKt.a().d(Color.n(menuItemColors.b(z2)));
                    final RowScope rowScope = rowScopeInstance;
                    final Function2 function25 = function22;
                    final Function2 function26 = function23;
                    final Function2 function27 = function2;
                    ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1728894036, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer3, int i6) {
                            if ((i6 & 3) == 2 && composer3.l()) {
                                composer3.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-1728894036, i6, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:483)");
                            }
                            Modifier modifierM = PaddingKt.m(RowScope.c(rowScope, Modifier.b8, 1.0f, false, 2, null), function25 != null ? MenuKt.f18149c : Dp.g(0), 0.0f, function26 != null ? MenuKt.f18149c : Dp.g(0), 0.0f, 10, null);
                            Function2 function28 = function27;
                            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                            int iA2 = ComposablesKt.a(composer3, 0);
                            CompositionLocalMap compositionLocalMapU2 = composer3.u();
                            Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierM);
                            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                            Function0 function0A2 = companion2.a();
                            if (composer3.m() == null) {
                                ComposablesKt.c();
                            }
                            composer3.L();
                            if (composer3.i()) {
                                composer3.P(function0A2);
                            } else {
                                composer3.v();
                            }
                            Composer composerA2 = Updater.a(composer3);
                            Updater.e(composerA2, measurePolicyG, companion2.e());
                            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                            Function2 function2B2 = companion2.b();
                            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                                composerA2.w(Integer.valueOf(iA2));
                                composerA2.p(Integer.valueOf(iA2), function2B2);
                            }
                            Updater.e(composerA2, modifierF2, companion2.f());
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                            function28.invoke(composer3, 0);
                            composer3.y();
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer2, 54);
                    int i6 = ProvidedValue.f24012i;
                    CompositionLocalKt.b(providedValueD2, composableLambdaE, composer2, i6 | 48);
                    if (function23 != null) {
                        ProvidedValue providedValueD3 = ContentColorKt.a().d(Color.n(menuItemColors.c(z2)));
                        final Function2 function28 = function23;
                        CompositionLocalKt.b(providedValueD3, ComposableLambdaKt.e(580312062, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$1$1.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer3, int i7) {
                                if ((i7 & 3) == 2 && composer3.l()) {
                                    composer3.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(580312062, i7, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:507)");
                                }
                                Modifier modifierB = SizeKt.b(Modifier.b8, ListTokens.f22906a.u(), 0.0f, 2, null);
                                Function2 function29 = function28;
                                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                                int iA2 = ComposablesKt.a(composer3, 0);
                                CompositionLocalMap compositionLocalMapU2 = composer3.u();
                                Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierB);
                                ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
                                Function0 function0A2 = companion2.a();
                                if (composer3.m() == null) {
                                    ComposablesKt.c();
                                }
                                composer3.L();
                                if (composer3.i()) {
                                    composer3.P(function0A2);
                                } else {
                                    composer3.v();
                                }
                                Composer composerA2 = Updater.a(composer3);
                                Updater.e(composerA2, measurePolicyG, companion2.e());
                                Updater.e(composerA2, compositionLocalMapU2, companion2.g());
                                Function2 function2B2 = companion2.b();
                                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                                    composerA2.w(Integer.valueOf(iA2));
                                    composerA2.p(Integer.valueOf(iA2), function2B2);
                                }
                                Updater.e(composerA2, modifierF2, companion2.f());
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                                function29.invoke(composer3, 0);
                                composer3.y();
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }, composer2, 54), composer2, i6 | 48);
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 48);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.MenuKt$DropdownMenuItemContent$2
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
                    MenuKt.d(function2, function0, modifier, function22, function23, z2, menuItemColors, paddingValues, mutableInteractionSource, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long h(androidx.compose.ui.unit.IntRect r5, androidx.compose.ui.unit.IntRect r6) {
        /*
            int r0 = r6.g()
            int r1 = r5.h()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto Lf
        Ld:
            r0 = r3
            goto L49
        Lf:
            int r0 = r6.h()
            int r1 = r5.g()
            if (r0 > r1) goto L1b
            r0 = r2
            goto L49
        L1b:
            int r0 = r6.l()
            if (r0 != 0) goto L22
            goto Ld
        L22:
            int r0 = r5.g()
            int r1 = r6.g()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.h()
            int r4 = r6.h()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.g()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.l()
            float r1 = (float) r1
            float r0 = r0 / r1
        L49:
            int r1 = r6.j()
            int r4 = r5.d()
            if (r1 < r4) goto L55
        L53:
            r2 = r3
            goto L8f
        L55:
            int r1 = r6.d()
            int r4 = r5.j()
            if (r1 > r4) goto L60
            goto L8f
        L60:
            int r1 = r6.f()
            if (r1 != 0) goto L67
            goto L53
        L67:
            int r1 = r5.j()
            int r2 = r6.j()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.d()
            int r2 = r6.d()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.j()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.f()
            float r6 = (float) r6
            float r2 = r5 / r6
        L8f:
            long r5 = androidx.compose.ui.graphics.TransformOriginKt.a(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MenuKt.h(androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect):long");
    }

    public static final float i() {
        return f18150d;
    }

    public static final float j() {
        return f18147a;
    }
}
