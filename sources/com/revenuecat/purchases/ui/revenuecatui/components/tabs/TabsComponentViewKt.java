package com.revenuecat.purchases.ui.revenuecatui.components.tabs;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.ui.revenuecatui.components.PresentedPartial;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlButtonComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyMapKt;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final /* synthetic */ class TabsComponentViewKt {
    private static final int DURATION_MS_CROSS_FADE = 220;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView_Preview$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView_Preview$1", f = "TabsComponentView.kt", l = {}, m = "invokeSuspend")
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

    /* JADX WARN: Removed duplicated region for block: B:112:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TabsComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle r16, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r17, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r18, androidx.compose.ui.Modifier r19, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.TabsComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabsComponentView_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(1844948686);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1844948686, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentView_Preview (TabsComponentView.kt:116)");
            }
            PresentedOverride presentedOverride = new PresentedOverride(CollectionsKt.listOf(ComponentOverride.Condition.Selected.INSTANCE), (PresentedPartial) com.revenuecat.purchases.ui.revenuecatui.helpers.ResultKt.getOrThrow(LocalizedTextPartial.Companion.invoke(new PartialTextComponent((Boolean) null, (String) null, (ColorScheme) null, (ColorScheme) null, (String) null, FontWeight.EXTRA_BOLD, (Integer) null, (Integer) null, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, 4063, (DefaultConstructorMarker) null), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocaleId.m612boximpl(LocaleId.m613constructorimpl("en_US")), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.a(LocalizationKey.m648boximpl(LocalizationKey.m649constructorimpl("dummy")), LocalizationData.Text.m630boximpl(LocalizationData.Text.m631constructorimpl("dummy"))), new Pair[0])), new Pair[0]), MapsKt.emptyMap(), MapsKt.emptyMap())));
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            float f3 = 8;
            StackComponentStyle stackComponentStyleM845previewStackComponentStylegNPyAyM$default = m845previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf((Object[]) new TabControlButtonComponentStyle[]{new TabControlButtonComponentStyle(0, "t0", m845previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Tab 1", null, 0, null, null, null, null, null, false, new Size(fit, fit), null, null, 0, null, null, CollectionsKt.listOf(presentedOverride), 28158, null)), null, false, new Size(fit, fit), 0.0f, null, null, null, null, null, null, null, 4086, null), null, null, null, null, 0, 248, null), new TabControlButtonComponentStyle(1, "t1", m845previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Tab 2", null, 0, null, null, null, null, null, false, new Size(fit, fit), null, null, 1, null, null, CollectionsKt.listOf(presentedOverride), 28158, null)), null, false, new Size(fit, fit), 0.0f, null, null, null, null, null, null, null, 4086, null), null, null, null, null, 0, 248, null), new TabControlButtonComponentStyle(2, "t2", m845previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Tab 3", null, 0, null, null, null, null, null, false, new Size(fit, fit), null, null, 2, null, null, CollectionsKt.listOf(presentedOverride), 28158, null)), null, false, new Size(fit, fit), 0.0f, null, null, null, null, null, null, null, 4086, null), null, null, null, null, 0, 248, null)}), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.CENTER), false, new Size(fit, fit), Dp.g(f3), null, null, null, null, null, null, null, 4068, null);
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            Size size = new Size(fill, fill);
            float f4 = 16;
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(f4));
            PaddingValues paddingValuesA2 = PaddingKt.a(Dp.g(f4));
            Color.Companion companion = Color.f25715b;
            TabsComponentView(new TabsComponentStyle(true, size, paddingValuesA, paddingValuesA2, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.g())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.d()))))), new Shape.Rectangle(new CornerRadiuses.Dp(16.0d)), new BorderStyles(Dp.g(f3), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b()))), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i()))), Dp.g(6), Dp.g(0), Dp.g(10), null), new TabControlStyle.Buttons(m845previewStackComponentStylegNPyAyM$default(CollectionsKt.emptyList(), null, false, null, 0.0f, null, null, null, null, null, null, null, 4094, null)), NonEmptyListKt.nonEmptyListOf(new TabsComponentStyle.Tab(m845previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM845previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle$default("Tab 1 content", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), null, false, null, 0.0f, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b()))))), null, null, null, null, null, null, 4062, null)), new TabsComponentStyle.Tab(m845previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM845previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle$default("Tab 2 content", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), null, false, null, 0.0f, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f()))))), null, null, null, null, null, null, 4062, null)), new TabsComponentStyle.Tab(m845previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM845previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle$default("Tab 3 content", null, 0, null, null, null, null, null, false, null, null, null, null, null, null, null, 65534, null)), null, false, null, 0.0f, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i()))))), null, null, null, null, null, null, 4062, null))), CollectionsKt.emptyList()), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new AnonymousClass1(null), null, null, composerK, 384, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView_Preview.2
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
                    TabsComponentViewKt.TabsComponentView_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-gNPyAyM, reason: not valid java name */
    private static final StackComponentStyle m844previewStackComponentStylegNPyAyM(List<? extends ComponentStyle> list, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, Integer num) {
        return new StackComponentStyle(list, dimension, z2, size, f3, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, null, null, null, null, num, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-gNPyAyM$default, reason: not valid java name */
    static /* synthetic */ StackComponentStyle m845previewStackComponentStylegNPyAyM$default(List list, Dimension dimension, boolean z2, Size size, float f3, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, Integer num, int i3, Object obj) {
        Size size2;
        if ((i3 & 2) != 0) {
            dimension = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER);
        }
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        if ((i3 & 8) != 0) {
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            size2 = new Size(fill, fill);
        } else {
            size2 = size;
        }
        return m844previewStackComponentStylegNPyAyM(list, dimension, z2, size2, (i3 & 16) != 0 ? Dp.g(0) : f3, (i3 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.j())), null, 2, null))) : backgroundStyles, (i3 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues2, (i3 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(0.0d)) : shape, (i3 & 512) != 0 ? null : borderStyles, (i3 & 1024) != 0 ? null : shadowStyles, (i3 & 2048) != 0 ? null : num);
    }
}
