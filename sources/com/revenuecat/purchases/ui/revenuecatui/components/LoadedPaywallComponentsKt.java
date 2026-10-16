package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.composables.SimpleSheetState;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Result;
import com.sun.jna.Function;
import java.net.URL;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class LoadedPaywallComponentsKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$2", f = "LoadedPaywallComponents.kt", l = {}, m = "invokeSuspend")
    static final class C23792 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C23792(Continuation<? super C23792> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23792(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C23792) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$3", f = "LoadedPaywallComponents.kt", l = {}, m = "invokeSuspend")
    static final class C23803 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C23803(Continuation<? super C23803> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23803(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C23803) create(external, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$2", f = "LoadedPaywallComponents.kt", l = {}, m = "invokeSuspend")
    static final class C23812 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C23812(Continuation<? super C23812> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23812(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C23812) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$3", f = "LoadedPaywallComponents.kt", l = {}, m = "invokeSuspend")
    static final class C23823 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C23823(Continuation<? super C23823> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23823(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C23823) create(external, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview$1", f = "LoadedPaywallComponents.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(external, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$1", f = "LoadedPaywallComponents.kt", l = {}, m = "invokeSuspend")
    static final class C23851 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C23851(Continuation<? super C23851> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23851(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C23851) create(external, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    public static final void HeaderOverlayLayout(final PaywallState.Loaded.Components state, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(500821026);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        int i6 = i4 & 2;
        if (i6 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.Z(modifier) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= 384;
        } else if ((i3 & 384) == 0) {
            i5 |= composerK.I(content) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(500821026, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.HeaderOverlayLayout (LoadedPaywallComponents.kt:184)");
            }
            composerK.a0(40673126);
            boolean z2 = (i5 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$HeaderOverlayLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                        return super.maxIntrinsicHeight(intrinsicMeasureScope, list, i7);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                        return super.maxIntrinsicWidth(intrinsicMeasureScope, list, i7);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j3) {
                        long j4;
                        final Placeable placeableN0;
                        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        if (measurables.size() > 1) {
                            j4 = j3;
                            placeableN0 = measurables.get(1).n0(Constraints.d(j4, 0, 0, 0, 0, 11, null));
                        } else {
                            j4 = j3;
                            placeableN0 = null;
                        }
                        state.setHeaderHeightPx$revenuecatui_defaultsBc8Release(placeableN0 != null ? placeableN0.O0() : 0);
                        final Placeable placeableN02 = measurables.get(0).n0(j4);
                        long j5 = j4;
                        return MeasureScope.B0(Layout, Constraints.l(j5), Constraints.k(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$HeaderOverlayLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope layout) {
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Placeable.PlacementScope.i(layout, placeableN02, 0, 0, 0.0f, 4, null);
                                Placeable placeable = placeableN0;
                                if (placeable != null) {
                                    Placeable.PlacementScope.i(layout, placeable, 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                        return super.minIntrinsicHeight(intrinsicMeasureScope, list, i7);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i7) {
                        return super.minIntrinsicWidth(intrinsicMeasureScope, list, i7);
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            composerK.U();
            int i7 = ((i5 >> 6) & 14) | (i5 & 112);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            int i8 = ((i7 << 6) & 896) | 6;
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
            Updater.e(composerA, measurePolicy, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            content.invoke(composerK, Integer.valueOf((i8 >> 6) & 14));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.HeaderOverlayLayout.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i9) {
                    LoadedPaywallComponentsKt.HeaderOverlayLayout(state, modifier2, content, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LoadedPaywallComponents(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r16, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction.External, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r17, androidx.compose.ui.Modifier r18, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_BottomSheet_FitSize_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(561912880);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(561912880, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_BottomSheet_FitSize_Preview (LoadedPaywallComponents.kt:333)");
            }
            PaywallState.Loaded.Components componentsPreviewHelloWorldPaywallState = previewHelloWorldPaywallState(composerK, 0);
            SimpleSheetState sheet = componentsPreviewHelloWorldPaywallState.getSheet();
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            show(sheet, previewBottomSheet(new Size(fit, fit)), componentsPreviewHelloWorldPaywallState, new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.d
                @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                    Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                }
            }, new C23792(null));
            LoadedPaywallComponents(componentsPreviewHelloWorldPaywallState, new C23803(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composerK, 432, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_FitSize_Preview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_FitSize_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_BottomSheet_NullSize_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-398756048);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-398756048, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_BottomSheet_NullSize_Preview (LoadedPaywallComponents.kt:313)");
            }
            PaywallState.Loaded.Components componentsPreviewHelloWorldPaywallState = previewHelloWorldPaywallState(composerK, 0);
            show(componentsPreviewHelloWorldPaywallState.getSheet(), previewBottomSheet(null), componentsPreviewHelloWorldPaywallState, new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.b
                @Override // com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                    Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                }
            }, new C23812(null));
            LoadedPaywallComponents(componentsPreviewHelloWorldPaywallState, new C23823(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composerK, 432, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_NullSize_Preview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_NullSize_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1173704376);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1173704376, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview (LoadedPaywallComponents.kt:301)");
            }
            LoadedPaywallComponents(previewHelloWorldPaywallState(composerK, 0), new AnonymousClass1(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composerK, 432, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_Bless(Composer composer, final int i3) {
        Composer composerK = composer.k(-485118556);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-485118556, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_Bless (LoadedPaywallComponents.kt:354)");
            }
            Color.Companion companion = Color.f25715b;
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.a())), new ColorInfo.Hex(ColorKt.k(companion.l())));
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.l())), new ColorInfo.Hex(ColorKt.k(companion.a())));
            URL url = new URL("https://assets.pawwalls.com");
            List listListOf = CollectionsKt.listOf(TestData.Components.INSTANCE.getMonthlyPackageComponent());
            TwoDimensionalAlignment twoDimensionalAlignment = TwoDimensionalAlignment.CENTER;
            Dimension.ZLayer zLayer = new Dimension.ZLayer(twoDimensionalAlignment);
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            StackComponent stackComponent = new StackComponent(listListOf, (Boolean) null, zLayer, new Size(fill, fill), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(60.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.c(255, 255, 255, 255)), 40.0f), new ColorInfo.Gradient.Point(ColorKt.k(ColorKt.f(5, 124, 91, 0, 8, null)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65490, (DefaultConstructorMarker) null);
            String strM649constructorimpl = LocalizationKey.m649constructorimpl("title");
            FontWeight fontWeight = FontWeight.SEMI_BOLD;
            HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEADING;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            DefaultConstructorMarker defaultConstructorMarker = null;
            ColorScheme colorScheme3 = null;
            String str = null;
            Integer num = null;
            Padding padding = null;
            List list = null;
            String str2 = null;
            TextComponent textComponent = new TextComponent(strM649constructorimpl, colorScheme, (Boolean) null, colorScheme3, str, fontWeight, num, 28, horizontalAlignment, new Size(fill, fit), padding, new Padding(0.0d, 40.0d, 0.0d, 0.0d), list, str2, 13404, defaultConstructorMarker);
            int i4 = 13564;
            FontWeight fontWeight2 = null;
            int i5 = 0;
            Offering offering = new Offering("id", "description", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_paywall_id", SDKConstants.PARAM_UPDATE_TEMPLATE, url, new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new StackComponent[]{stackComponent, new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{textComponent, new TextComponent(LocalizationKey.m649constructorimpl("feature-1"), colorScheme, (Boolean) null, colorScheme3, str, fontWeight2, num, i5, horizontalAlignment, new Size(fill, fit), padding, new Padding(8.0d, 8.0d, 0.0d, 0.0d), list, str2, i4, defaultConstructorMarker), new TextComponent(LocalizationKey.m649constructorimpl("feature-2"), colorScheme, (Boolean) null, colorScheme3, str, fontWeight2, num, i5, horizontalAlignment, new Size(fill, fit), padding, new Padding(8.0d, 8.0d, 0.0d, 0.0d), list, str2, i4, defaultConstructorMarker), new TextComponent(LocalizationKey.m649constructorimpl("feature-3"), colorScheme, (Boolean) null, colorScheme3, str, fontWeight2, num, i5, horizontalAlignment, new Size(fill, fit), padding, new Padding(8.0d, 8.0d, 0.0d, 0.0d), list, str2, i4, defaultConstructorMarker), new TextComponent(LocalizationKey.m649constructorimpl("feature-4"), colorScheme, (Boolean) null, colorScheme3, str, fontWeight2, num, i5, horizontalAlignment, new Size(fill, fit), padding, new Padding(8.0d, 8.0d, 0.0d, 0.0d), list, str2, i4, defaultConstructorMarker), new TextComponent(LocalizationKey.m649constructorimpl("feature-5"), colorScheme, (Boolean) null, colorScheme3, str, fontWeight2, num, i5, horizontalAlignment, new Size(fill, fit), padding, new Padding(8.0d, 8.0d, 0.0d, 0.0d), list, str2, i4, defaultConstructorMarker), new TextComponent(LocalizationKey.m649constructorimpl("feature-6"), colorScheme, (Boolean) null, colorScheme3, str, fontWeight2, num, i5, horizontalAlignment, new Size(fill, fit), padding, new Padding(8.0d, 8.0d, 0.0d, 0.0d), list, str2, i4, defaultConstructorMarker), new TextComponent(LocalizationKey.m649constructorimpl("offer"), colorScheme, (Boolean) null, colorScheme3, str, fontWeight2, num, i5, horizontalAlignment, new Size(fill, fit), padding, new Padding(48.0d, 8.0d, 0.0d, 0.0d), list, str2, i4, defaultConstructorMarker), new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl(SDKConstants.PARAM_GAME_REQUESTS_CTA), new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.l())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16348, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(twoDimensionalAlignment), new Size(fit, fit), (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.k(ColorKt.f(5, 124, 91, 0, 8, null))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(8.0d, 8.0d, 32.0d, 32.0d), new Padding(8.0d, 8.0d, 0.0d, 0.0d), Shape.Pill.INSTANCE, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64594, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m649constructorimpl("terms"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, fontWeight2, num, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, defaultConstructorMarker)}), (Boolean) null, new Dimension.Vertical(horizontalAlignment, FlexDistribution.END), new Size(fill, fill), (Float) null, (ColorScheme) null, (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65394, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.BOTTOM), new Size(fill, fill), (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65490, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), (StickyFooterComponent) null, (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("title")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Unlock bless."))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-1")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("✓ Enjoy a 7 day trial"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-2")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("✓ Change currencies"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-3")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("✓ Access more trend charts"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-4")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("✓ Create custom categories"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-5")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("✓ Get a special premium icon"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("feature-6")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("✓ Receive our love and gratitude for your support"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("offer")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Try 7 days free, then $19.98/year. Cancel anytime."))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl(SDKConstants.PARAM_GAME_REQUESTS_CTA)), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Continue"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("terms")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Privacy & Terms")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerK, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            LoadedPaywallComponents(OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null), new C23851(null), SizeKt.f(Modifier.b8, 0.0f, 1, null), null, composerK, 432, 8);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview_Bless.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview_Bless(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void PaywallComponentsScaffold(final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r16, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction.External, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r17, final com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r18, androidx.compose.ui.Modifier r19, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold(com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final Object handleClick(PaywallAction paywallAction, PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Continuation<? super Unit> continuation) {
        if (paywallAction instanceof PaywallAction.External) {
            Object objInvoke = function2.invoke(paywallAction, continuation);
            return objInvoke == IntrinsicsKt.f() ? objInvoke : Unit.f139807a;
        }
        if ((paywallAction instanceof PaywallAction.Internal) && (((PaywallAction.Internal) paywallAction) instanceof PaywallAction.Internal.NavigateTo)) {
            PaywallAction.Internal.NavigateTo navigateTo = (PaywallAction.Internal.NavigateTo) paywallAction;
            if (navigateTo.getDestination() instanceof PaywallAction.Internal.NavigateTo.Destination.Sheet) {
                ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet = ((PaywallAction.Internal.NavigateTo.Destination.Sheet) navigateTo.getDestination()).getSheet();
                String name = sheet.getName();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = components.getSelectedPackageInfo();
                paywallComponentInteractionTracker.track(PaywallComponentInteractionFactoriesKt.paywallPackageSelectionSheetOpen(name, selectedPackageInfo != null ? selectedPackageInfo.getRcPackage() : null));
                show(components.getSheet(), sheet, components, paywallComponentInteractionTracker, new C23892(components, function2, paywallComponentInteractionTracker, null));
            }
        }
        return Unit.f139807a;
    }

    public static final Modifier headerTopPadding(Modifier modifier, final PaywallState.Loaded.Components state) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return LayoutModifierKt.a(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.headerTopPadding.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m696invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m696invoke3p2s80s(MeasureScope layout, Measurable measurable, long j3) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final int headerHeightPx = state.getHeaderHeightPx();
                final Placeable placeableN0 = measurable.n0(ConstraintsKt.j(j3, 0, -headerHeightPx, 1, null));
                return MeasureScope.B0(layout, placeableN0.X0(), placeableN0.O0() + headerHeightPx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.headerTopPadding.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.i(layout2, placeableN0, 0, headerHeightPx, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    private static final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet previewBottomSheet(Size size) {
        return new ButtonComponentStyle.Action.NavigateTo.Destination.Sheet("", "", PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("This is a bottom sheet.", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null), PreviewHelpersKt.previewTextComponentStyle$default("This is a bottom sheet.", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null), PreviewHelpersKt.previewTextComponentStyle$default("This is a bottom sheet.", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)}), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.l())), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : new Shape.Rectangle(new CornerRadiuses.Dp(16.0d, 16.0d, 0.0d, 0.0d)), (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), true, size);
    }

    static /* synthetic */ ButtonComponentStyle.Action.NavigateTo.Destination.Sheet previewBottomSheet$default(Size size, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            size = null;
        }
        return previewBottomSheet(size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final PaywallState.Loaded.Components previewHelloWorldPaywallState(Composer composer, int i3) {
        composer.a0(-1486758699);
        if (ComposerKt.M()) {
            ComposerKt.U(-1486758699, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewHelloWorldPaywallState (LoadedPaywallComponents.kt:534)");
        }
        URL url = new URL("https://assets.pawwalls.com");
        String strM649constructorimpl = LocalizationKey.m649constructorimpl("hello-world");
        Color.Companion companion = Color.f25715b;
        List listListOf = CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(strM649constructorimpl, new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.a())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()});
        HorizontalAlignment horizontalAlignment = HorizontalAlignment.CENTER;
        FlexDistribution flexDistribution = FlexDistribution.START;
        Offering offering = new Offering("id", "description", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_paywall_id", SDKConstants.PARAM_UPDATE_TEMPLATE, url, new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(listListOf, (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), (Size) null, (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.c())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, (Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null), new Background.Color(new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.b())), new ColorInfo.Hex(ColorKt.k(companion.i())))), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m649constructorimpl("sticky-footer"), new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.a())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) (0 == true ? 1 : 0), (String) null, (FontWeight) (0 == true ? 1 : 0), (Integer) (0 == true ? 1 : 0), 0, (HorizontalAlignment) (0 == true ? 1 : 0), (Size) (0 == true ? 1 : 0), (Padding) (0 == true ? 1 : 0), (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(horizontalAlignment, flexDistribution), (Size) null, (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.l())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, new Shape.Rectangle(new CornerRadiuses.Dp(10.0d, 10.0d, 0.0d, 0.0d)), (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.k(companion.a())), new ColorInfo.Hex(ColorKt.k(companion.m()))), 10.0d, 0.0d, -5.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 62938, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("hello-world")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Hello, world!"))), TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("sticky-footer")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("Sticky Footer")))))), LocaleId.m613constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, 960, (DefaultConstructorMarker) null)), null, 80, null);
        Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composer, 0);
        PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
        Intrinsics.checkNotNull(components);
        PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.previewHelloWorldPaywallState.1
            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
            }
        }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return componentsPaywallState$default;
    }

    public static final void show(final SimpleSheetState simpleSheetState, final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet, final PaywallState.Loaded.Components state, final PaywallComponentInteractionTracker componentInteractionTracker, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> onClick) {
        Intrinsics.checkNotNullParameter(simpleSheetState, "<this>");
        Intrinsics.checkNotNullParameter(sheet, "sheet");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(componentInteractionTracker, "componentInteractionTracker");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        simpleSheetState.show(sheet.getBackgroundBlur(), ComposableLambdaKt.c(-591146401, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer, int i3) {
                if ((i3 & 3) == 2 && composer.l()) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-591146401, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.show.<anonymous> (LoadedPaywallComponents.kt:267)");
                }
                ComponentStyle stack = sheet.getStack();
                Modifier modifierConditional = ModifierExtensionsKt.conditional(ModifierExtensionsKt.applyIfNotNull(Modifier.b8, sheet.getSize(), new Function2<Modifier, Size, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1.1
                    @Override // kotlin.jvm.functions.Function2
                    public final Modifier invoke(Modifier applyIfNotNull, Size it) {
                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                        Intrinsics.checkNotNullParameter(it, "it");
                        return com.revenuecat.purchases.ui.revenuecatui.components.modifier.SizeKt.size$default(applyIfNotNull, it, null, null, 6, null);
                    }
                }), sheet.getSize() == null, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return SizeKt.h(conditional, 0.0f, 1, null);
                    }
                });
                PaywallState.Loaded.Components components = state;
                composer.a0(1730932923);
                boolean Z = composer.Z(simpleSheetState) | composer.I(onClick);
                SimpleSheetState simpleSheetState2 = simpleSheetState;
                Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = onClick;
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new LoadedPaywallComponentsKt$show$1$3$1(simpleSheetState2, function2, null);
                    composer.w(objG);
                }
                composer.U();
                ComponentViewKt.ComponentView(stack, components, (Function2) objG, modifierConditional, componentInteractionTracker, composer, 0, 0);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m697invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m697invoke() {
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = state.getSelectedPackageInfo();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfoPeekSelectedPackageInfoAfterSheetDismiss = state.peekSelectedPackageInfoAfterSheetDismiss();
                componentInteractionTracker.track(PaywallComponentInteractionFactoriesKt.paywallPackageSelectionSheetClose(sheet.getName(), selectedPackageInfo != null ? selectedPackageInfo.getRcPackage() : null, selectedPackageInfoPeekSelectedPackageInfoAfterSheetDismiss != null ? selectedPackageInfoPeekSelectedPackageInfoAfterSheetDismiss.getRcPackage() : null));
                state.resetToDefaultPackage();
            }
        });
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$handleClick$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$handleClick$2", f = "LoadedPaywallComponents.kt", l = {248}, m = "invokeSuspend")
    static final class C23892 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
        final /* synthetic */ Function2<PaywallAction.External, Continuation<? super Unit>, Object> $externalClickHandler;
        final /* synthetic */ PaywallState.Loaded.Components $state;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C23892(PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Continuation<? super C23892> continuation) {
            super(2, continuation);
            this.$state = components;
            this.$externalClickHandler = function2;
            this.$componentInteractionTracker = paywallComponentInteractionTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C23892 c23892 = new C23892(this.$state, this.$externalClickHandler, this.$componentInteractionTracker, continuation);
            c23892.L$0 = obj;
            return c23892;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C23892) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(jlWo.eGgjg);
                }
            } else {
                ResultKt.b(obj);
                PaywallAction paywallAction = (PaywallAction) this.L$0;
                PaywallState.Loaded.Components components = this.$state;
                Function2<PaywallAction.External, Continuation<? super Unit>, Object> function2 = this.$externalClickHandler;
                PaywallComponentInteractionTracker paywallComponentInteractionTracker = this.$componentInteractionTracker;
                this.label = 1;
                if (LoadedPaywallComponentsKt.handleClick(paywallAction, components, function2, paywallComponentInteractionTracker, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
    }
}
