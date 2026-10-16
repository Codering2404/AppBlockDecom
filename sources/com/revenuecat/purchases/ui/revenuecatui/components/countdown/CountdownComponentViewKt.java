package com.revenuecat.purchases.ui.revenuecatui.components.countdown;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CountdownComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
public final /* synthetic */ class CountdownComponentViewKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt$CountdownComponentView_Preview_Running$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt$CountdownComponentView_Preview_Running$1", f = "CountdownComponentView.kt", l = {}, m = "invokeSuspend")
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt$CountdownComponentView_Preview_TimesUp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt$CountdownComponentView_Preview_TimesUp$1", f = "CountdownComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24161 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24161(Continuation<? super C24161> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24161(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24161) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CountdownComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.CountdownComponentStyle r13, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r14, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r15, androidx.compose.ui.Modifier r16, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt.CountdownComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.CountdownComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CountdownComponentView_Preview_Running(Composer composer, final int i3) {
        Composer composerK = composer.k(964712165);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(964712165, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentView_Preview_Running (CountdownComponentView.kt:48)");
            }
            Date date = new Date(System.currentTimeMillis() + ((long) 172800000));
            CountdownComponentView(new CountdownComponentStyle(date, CountdownComponent.CountFrom.DAYS, PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("{{ count_days_without_zero }}d {{ count_hours_without_zero }}h {{ count_minutes_without_zero }}m {{ count_seconds_without_zero }}s", new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), 24, null, null, null, null, null, false, null, null, null, null, date, null, null, 57336, null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? date : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), null, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new AnonymousClass1(null), null, null, composerK, 384, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt.CountdownComponentView_Preview_Running.2
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
                    CountdownComponentViewKt.CountdownComponentView_Preview_Running(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CountdownComponentView_Preview_TimesUp(Composer composer, final int i3) {
        Composer composerK = composer.k(-1982632477);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1982632477, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentView_Preview_TimesUp (CountdownComponentView.kt:76)");
            }
            Date date = new Date(System.currentTimeMillis() - ((long) 172800000));
            Color.Companion companion = Color.f25715b;
            CountdownComponentView(new CountdownComponentStyle(date, CountdownComponent.CountFrom.DAYS, PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("{{ count_days_without_zero }}d {{ count_hours_without_zero }}h {{ count_minutes_without_zero }}m {{ count_seconds_without_zero }}s", new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.a())), null, 2, null), 24, null, null, null, null, null, false, null, null, null, null, date, null, null, 57336, null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? date : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Offer expired!", new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.a())), null, 2, null), 24, null, null, null, null, null, false, null, null, null, null, null, null, null, 65528, null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new C24161(null), null, null, composerK, 384, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.countdown.CountdownComponentViewKt.CountdownComponentView_Preview_TimesUp.2
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
                    CountdownComponentViewKt.CountdownComponentView_Preview_TimesUp(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
