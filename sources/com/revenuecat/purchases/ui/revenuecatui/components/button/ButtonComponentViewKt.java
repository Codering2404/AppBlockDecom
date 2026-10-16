package com.revenuecat.purchases.ui.revenuecatui.components.button;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

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
public final /* synthetic */ class ButtonComponentViewKt {
    private static final float ALPHA_DISABLED = 0.6f;
    private static final float BRIGHTNESS_CUTOFF = 0.6f;
    private static final float COEFFICIENT_LUMINANCE_BLUE = 0.114f;
    private static final float COEFFICIENT_LUMINANCE_GREEN = 0.587f;
    private static final float COEFFICIENT_LUMINANCE_RED = 0.299f;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass3 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function2<PaywallAction, Continuation<? super Unit>, Object> $onClick;
        final /* synthetic */ PaywallState.Loaded.Components $state;
        final /* synthetic */ ButtonComponentStyle $style;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(ButtonComponentStyle buttonComponentStyle, PaywallState.Loaded.Components components, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2) {
            super(2);
            this.$style = buttonComponentStyle;
            this.$state = components;
            this.$modifier = modifier;
            this.$componentInteractionTracker = paywallComponentInteractionTracker;
            this.$onClick = function2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invoke$lambda$2(MutableState<Boolean> mutableState) {
            return ((Boolean) mutableState.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3(MutableState<Boolean> mutableState, boolean z2) {
            mutableState.setValue(Boolean.valueOf(z2));
        }

        private static final float invoke$lambda$5(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        private static final float invoke$lambda$7(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        private static final float invoke$lambda$8(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        private static final float invoke$lambda$9(State<Float> state) {
            return ((Number) state.getValue()).floatValue();
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Composer) obj, ((Number) obj2).intValue());
            return Unit.f139807a;
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x027e  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x02a4  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x02b0  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x02b4  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x02e1  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x033c  */
        /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void invoke(androidx.compose.runtime.Composer r30, int r31) {
            /*
                Method dump skipped, instruction units count: 832
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.AnonymousClass3.invoke(androidx.compose.runtime.Composer, int):void");
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Default$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Default$1", f = "ButtonComponentView.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Narrow$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Narrow$1", f = "ButtonComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24081 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24081(Continuation<? super C24081> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24081(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24081) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void ButtonComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle r13, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r14, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r15, androidx.compose.ui.Modifier r16, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.ButtonComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ButtonComponentView_Preview_Default(Composer composer, final int i3) {
        Composer composerK = composer.k(-291258808);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-291258808, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView_Preview_Default (ButtonComponentView.kt:316)");
            }
            ButtonComponentView(previewButtonComponentStyle(null, null, composerK, 0, 3), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new AnonymousClass1(null), null, null, composerK, 384, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView_Preview_Default.2
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
                    ButtonComponentViewKt.ButtonComponentView_Preview_Default(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ButtonComponentView_Preview_Narrow(Composer composer, final int i3) {
        Composer composerK = composer.k(1236087174);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1236087174, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView_Preview_Narrow (ButtonComponentView.kt:322)");
            }
            ButtonComponentView(previewButtonComponentStyle(PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Restore purchases", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.m())), null, 2, null), false, null, null, null, null, null, null, null, 65406, null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), null, composerK, 0, 2), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new C24081(null), null, null, composerK, 384, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView_Preview_Narrow.2
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
                    ButtonComponentViewKt.ButtonComponentView_Preview_Narrow(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: getBrightness-8_81llA, reason: not valid java name */
    private static final float m705getBrightness8_81llA(long j3) {
        return (Color.y(j3) * COEFFICIENT_LUMINANCE_RED) + (Color.x(j3) * COEFFICIENT_LUMINANCE_GREEN) + (Color.v(j3) * COEFFICIENT_LUMINANCE_BLUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String navigationUrlForComponentInteraction(PaywallAction paywallAction) {
        if (paywallAction instanceof PaywallAction.External.NavigateTo) {
            PaywallAction.External.NavigateTo.Destination destination = ((PaywallAction.External.NavigateTo) paywallAction).getDestination();
            if (destination instanceof PaywallAction.External.NavigateTo.Destination.Url) {
                return ((PaywallAction.External.NavigateTo.Destination.Url) destination).getUrl();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Package packageForPurchaseButtonInteraction(ButtonComponentStyle.Action action, PaywallState.Loaded.Components components) {
        Package rcPackage = action instanceof ButtonComponentStyle.Action.PurchasePackage ? ((ButtonComponentStyle.Action.PurchasePackage) action).getRcPackage() : action instanceof ButtonComponentStyle.Action.WebCheckout ? ((ButtonComponentStyle.Action.WebCheckout) action).getRcPackage() : action instanceof ButtonComponentStyle.Action.CustomWebCheckout ? ((ButtonComponentStyle.Action.CustomWebCheckout) action).getRcPackage() : null;
        if (rcPackage != null) {
            return rcPackage;
        }
        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = components.getSelectedPackageInfo();
        if (selectedPackageInfo != null) {
            return selectedPackageInfo.getRcPackage();
        }
        return null;
    }

    private static final ButtonComponentStyle previewButtonComponentStyle(StackComponentStyle stackComponentStyle, ButtonComponentStyle.Action action, Composer composer, int i3, int i4) {
        StackComponentStyle stackComponentStyle2;
        composer.a0(-1733277159);
        if ((i4 & 1) != 0) {
            Color.Companion companion = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), null, 2, null);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            float f3 = 16;
            stackComponentStyle2 = new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Restore purchases", null, 0, null, null, null, null, colorStyles, false, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), new Padding(0.0d, 24.0d, 0.0d, 24.0d), null, null, null, null, 61822, null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(fit, fit), Dp.g(f3), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.a())), null, 2, null), Dp.g(10), Dp.g(0), Dp.g(3), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
        } else {
            stackComponentStyle2 = stackComponentStyle;
        }
        ButtonComponentStyle.Action action2 = (i4 & 2) != 0 ? ButtonComponentStyle.Action.RestorePurchases.INSTANCE : action;
        if (ComposerKt.M()) {
            ComposerKt.U(-1733277159, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.previewButtonComponentStyle (ButtonComponentView.kt:375)");
        }
        ButtonComponentStyle buttonComponentStyle = new ButtonComponentStyle(stackComponentStyle2, action2, null, null, null, 28, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return buttonComponentStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long progressColorFor(BackgroundStyles backgroundStyles, Composer composer, int i3) {
        long jL;
        composer.a0(-1216934903);
        if (ComposerKt.M()) {
            ComposerKt.U(-1216934903, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.progressColorFor (ButtonComponentView.kt:256)");
        }
        composer.a0(-1003035204);
        if (backgroundStyles == null) {
            long jL2 = DarkThemeKt.a(composer, 0) ? Color.f25715b.l() : Color.f25715b.a();
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            composer.U();
            return jL2;
        }
        composer.U();
        if (backgroundStyles instanceof BackgroundStyles.Color) {
            jL = progressColorFor(ColorStyleKt.getForCurrentTheme(((BackgroundStyles.Color) backgroundStyles).m759unboximpl(), composer, 0));
        } else {
            if (!(backgroundStyles instanceof BackgroundStyles.Image) && !(backgroundStyles instanceof BackgroundStyles.Video)) {
                throw new NoWhenBranchMatchedException();
            }
            jL = Color.f25715b.l();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return jL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int progressSize(Density density, int i3, int i4, float f3, float f4, float f5, float f6) {
        float fG;
        float fG2 = density.G(Math.min((i3 - f3) - f4, (i4 - f5) - f6));
        if (Dp.f(fG2, Dp.g(32)) >= 0) {
            fG = Dp.g(16);
        } else if (Dp.f(fG2, Dp.g(24)) >= 0) {
            fG = Dp.g(fG2 - Dp.g(16));
        } else if (Dp.f(fG2, Dp.g(16)) >= 0) {
            fG = Dp.g(8);
        } else {
            float f7 = 8;
            fG = Dp.f(fG2, Dp.g(f7)) >= 0 ? Dp.g(fG2 - Dp.g(f7)) : Dp.g(0);
        }
        return density.z0(Dp.g(RangesKt.o(Dp.g(fG2 - fG), Dp.g(0), Dp.g(38))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ButtonComponentInteraction workflowInteraction(PaywallAction paywallAction) {
        if (paywallAction instanceof PaywallAction.External.WorkflowTrigger) {
            return new ButtonComponentInteraction("workflow_trigger", null, 2, null);
        }
        return null;
    }

    private static final long progressColorFor(ColorStyle colorStyle) {
        if (colorStyle instanceof ColorStyle.Solid) {
            return m705getBrightness8_81llA(((ColorStyle.Solid) colorStyle).m782unboximpl()) > 0.6f ? Color.f25715b.a() : Color.f25715b.l();
        }
        if (!(colorStyle instanceof ColorStyle.Gradient)) {
            throw new NoWhenBranchMatchedException();
        }
        List colors$revenuecatui_defaultsBc8Release = ((ColorStyle.Gradient) colorStyle).m774unboximpl().getColors$revenuecatui_defaultsBc8Release();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors$revenuecatui_defaultsBc8Release, 10));
        Iterator it = colors$revenuecatui_defaultsBc8Release.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(m705getBrightness8_81llA(((Color) it.next()).B())));
        }
        return CollectionsKt.averageOfFloat(arrayList) > 0.6000000238418579d ? Color.f25715b.a() : Color.f25715b.l();
    }
}
