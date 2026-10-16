package com.revenuecat.purchases.ui.revenuecatui.components.stack;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.tooling.preview.PreviewParameter;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
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
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

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
public final /* synthetic */ class StackComponentViewKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$OverlaidBadge$2", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_ContentAlpha$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_ContentAlpha$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24681 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24681(Continuation<? super C24681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24681) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24701 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24701(Continuation<? super C24701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24701(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24701) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_With_Spacing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_With_Spacing$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24721 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24721(Continuation<? super C24721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24721) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24741 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24741(Continuation<? super C24741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24741) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24761 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24761(Continuation<? super C24761> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24761(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24761) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_HorizontalChildrenFillWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_HorizontalChildrenFillWidth$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24801 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24801(Continuation<? super C24801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24801) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_VerticalChildrenFillHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt$StackComponentView_Preview_VerticalChildrenFillHeight$1", f = "StackComponentView.kt", l = {}, m = "invokeSuspend")
    static final class C24891 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C24891(Continuation<? super C24891> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24891(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C24891) create(paywallAction, continuation)).invokeSuspend(Unit.f139807a);
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[TwoDimensionalAlignment.values().length];
            try {
                iArr[TwoDimensionalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TwoDimensionalAlignment.TOP_LEADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TwoDimensionalAlignment.TOP_TRAILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM_LEADING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TwoDimensionalAlignment.BOTTOM_TRAILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[TwoDimensionalAlignment.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[TwoDimensionalAlignment.LEADING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[TwoDimensionalAlignment.TRAILING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Badge.Style.values().length];
            try {
                iArr2[Badge.Style.Overlay.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[Badge.Style.EdgeToEdge.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[Badge.Style.Nested.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[FlexDistribution.values().length];
            try {
                iArr3[FlexDistribution.SPACE_AROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[FlexDistribution.SPACE_BETWEEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[FlexDistribution.SPACE_EVENLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[FlexDistribution.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr3[FlexDistribution.END.ordinal()] = 5;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr3[FlexDistribution.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:219:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void MainStackComponent(final com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState r25, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r26, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r27, final com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r28, final float r29, androidx.compose.ui.Modifier r30, com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle r31, boolean r32, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.BoxScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 1361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.MainStackComponent(com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, float, androidx.compose.ui.Modifier, com.revenuecat.purchases.ui.revenuecatui.components.style.BadgeStyle, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shape MainStackComponent$lambda$11(State<? extends Shape> state) {
        return (Shape) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void OverlaidBadge(final androidx.compose.foundation.layout.BoxScope r16, final com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle r17, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r18, final com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r19, final com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment r20, final java.lang.Float r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.OverlaidBadge(androidx.compose.foundation.layout.BoxScope, com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment, java.lang.Float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Children_Extend_Over_Parent(Composer composer, final int i3) {
        Composer composerK = composer.k(-1849301685);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1849301685, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Children_Extend_Over_Parent (StackComponentView.kt:1189)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            Color.Companion companion = Color.f25715b;
            Modifier modifierD = BackgroundKt.d(modifierI, companion.e(), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            float f3 = 0;
            List listListOf = CollectionsKt.listOf(PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(previewChildren(composerK, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.a())), null, 2, null), Dp.g(10), Dp.g(f3), Dp.g(3), null), (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.Overlay, TwoDimensionalAlignment.TOP_TRAILING, new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null));
            Dimension.Horizontal horizontal = new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            Size size = new Size(fit, fit);
            float f4 = 16;
            StackComponentView(new StackComponentStyle(listListOf, horizontal, true, size, Dp.g(f4), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m()))))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f4)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Children_Extend_Over_Parent$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Children_Extend_Over_Parent.2
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
                    StackComponentViewKt.StackComponentView_Preview_Children_Extend_Over_Parent(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_ContentAlpha(Composer composer, final int i3) {
        Composer composerK = composer.k(-1355314342);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1355314342, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_ContentAlpha (StackComponentView.kt:1741)");
            }
            StackComponentView(PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(previewChildren(composerK, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new C24681(null), null, 0.6f, null, composerK, 24960, 40);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_ContentAlpha.2
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
                    StackComponentViewKt.StackComponentView_Preview_ContentAlpha(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children(Composer composer, final int i3) {
        Composer composerK = composer.k(-2040912590);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-2040912590, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children (StackComponentView.kt:1573)");
            }
            Color.Companion companion = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), null, 2, null);
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fill, fit), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("SPACE_AROUND", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null)}), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.SPACE_AROUND), true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), Dp.g(8), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null))), PaddingKt.a(Dp.g(0)), PaddingKt.a(Dp.g(16)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new C24701(null), null, 0.0f, null, composerK, 384, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children.2
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
                    StackComponentViewKt.StackComponentView_Preview_Distribution_SpaceAround_With_Fill_Children(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_With_Spacing(@PreviewParameter Dimension dimension, Composer composer, final int i3) {
        int i4;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerK = composer.k(-2060177158);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(dimension) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
            dimension2 = dimension;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-2060177158, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_With_Spacing (StackComponentView.kt:1624)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            Color.Companion companion = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), null, 2, null);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentStyle textComponentStylePreviewTextComponentStyle$default = PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fit, fit), null, null, null, null, null, null, 64894, null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = "null";
            }
            float f3 = 16;
            StackComponentStyle stackComponentStyle = new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{textComponentStylePreviewTextComponentStyle$default, PreviewHelpersKt.previewTextComponentStyle$default(strName, null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null)}), dimension, true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), Dp.g(f3), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null))), PaddingKt.a(Dp.g(0)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
            dimension2 = dimension;
            composer2 = composerK;
            StackComponentView(stackComponentStyle, PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C24721(null), null, 0.0f, null, composer2, 384, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_With_Spacing.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    StackComponentViewKt.StackComponentView_Preview_Distribution_With_Spacing(dimension2, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_Without_Spacing(@PreviewParameter Dimension dimension, Composer composer, final int i3) {
        int i4;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerK = composer.k(-1146712254);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(dimension) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
            dimension2 = dimension;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1146712254, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_Without_Spacing (StackComponentView.kt:1522)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            Color.Companion companion = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), null, 2, null);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentStyle textComponentStylePreviewTextComponentStyle$default = PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fit, fit), null, null, null, null, null, null, 64894, null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = "null";
            }
            float f3 = 0;
            dimension2 = dimension;
            composer2 = composerK;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{textComponentStylePreviewTextComponentStyle$default, PreviewHelpersKt.previewTextComponentStyle$default(strName, null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null)}), dimension, true, new Size(new SizeConstraint.Fixed(300, null), new SizeConstraint.Fixed(300, null)), Dp.g(f3), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(16)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C24741(null), null, 0.0f, null, composer2, 384, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing(dimension2, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size(@PreviewParameter Dimension dimension, Composer composer, final int i3) {
        int i4;
        FlexDistribution distribution;
        String strName;
        final Dimension dimension2;
        Composer composer2;
        Composer composerK = composer.k(585047730);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(dimension) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
            dimension2 = dimension;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(585047730, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size (StackComponentView.kt:1469)");
            }
            if (dimension instanceof Dimension.Horizontal) {
                distribution = ((Dimension.Horizontal) dimension).getDistribution();
            } else if (dimension instanceof Dimension.Vertical) {
                distribution = ((Dimension.Vertical) dimension).getDistribution();
            } else {
                if (!(dimension instanceof Dimension.ZLayer)) {
                    throw new NoWhenBranchMatchedException();
                }
                distribution = null;
            }
            Color.Companion companion = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), null, 2, null);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            TextComponentStyle textComponentStylePreviewTextComponentStyle$default = PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fit, fit), null, null, null, null, null, null, 64894, null);
            if (distribution == null || (strName = distribution.name()) == null) {
                strName = "null";
            }
            float f3 = 0;
            dimension2 = dimension;
            composer2 = composerK;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{textComponentStylePreviewTextComponentStyle$default, PreviewHelpersKt.previewTextComponentStyle$default(strName, null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.f())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), false, new Size(fit, fit), null, null, null, null, null, null, 64894, null)}), dimension, true, new Size(fit, fit), Dp.g(f3), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(16)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), new C24761(null), null, 0.0f, null, composer2, 384, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    StackComponentViewKt.StackComponentView_Preview_Distribution_Without_Spacing_Fit_Size(dimension2, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_EdgeToEdge_Badge(@PreviewParameter final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1687690690);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(twoDimensionalAlignment) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1687690690, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_EdgeToEdge_Badge (StackComponentView.kt:1014)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            StackComponentView(PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(previewChildren(composerK, 0), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : null, (31966 & 16) != 0 ? Dp.g(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.a())), null, 2, null), Dp.g(20), Dp.g(0), Dp.g(5), null), (31966 & 2048) != 0 ? null : previewBadge$default(Badge.Style.EdgeToEdge, twoDimensionalAlignment, new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), null, null, 24, null), (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_EdgeToEdge_Badge$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_EdgeToEdge_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_EdgeToEdge_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Horizontal(Composer composer, final int i3) {
        Composer composerK = composer.k(537558075);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(537558075, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Horizontal (StackComponentView.kt:1143)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            List<TextComponentStyle> listPreviewChildren = previewChildren(composerK, 0);
            Dimension.Horizontal horizontal = new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            Size size = new Size(fit, fit);
            float f3 = 16;
            float fG = Dp.g(f3);
            Color.Companion companion2 = Color.f25715b;
            StackComponentView(new StackComponentStyle(listPreviewChildren, horizontal, true, size, fG, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.m()))))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(30), Dp.g(0), Dp.g(5), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Horizontal$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Horizontal.2
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
                    StackComponentViewKt.StackComponentView_Preview_Horizontal(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_HorizontalChildrenFillWidth(Composer composer, final int i3) {
        Composer composerK = composer.k(94466939);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(94466939, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_HorizontalChildrenFillWidth (StackComponentView.kt:1369)");
            }
            Color.Companion companion = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), null, 2, null);
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            List listListOf = CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fill, fit), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), false, new Size(fill, fit), null, null, null, null, null, null, 64894, null)});
            Dimension.Horizontal horizontal = new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START);
            Size size = new Size(new SizeConstraint.Fixed(200, null), fit);
            float f3 = 16;
            float fG = Dp.g(f3);
            ColorStyles colorStylesM754constructorimpl = BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null));
            StackComponentView(new StackComponentStyle(listListOf, horizontal, true, size, fG, BackgroundStyles.Color.m753boximpl(colorStylesM754constructorimpl), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new C24801(null), null, 0.0f, null, composerK, 384, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_HorizontalChildrenFillWidth.2
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
                    StackComponentViewKt.StackComponentView_Preview_HorizontalChildrenFillWidth(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Nested_Badge(@PreviewParameter final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1890270268);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(twoDimensionalAlignment) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1890270268, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Nested_Badge (StackComponentView.kt:1089)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Shape.Rectangle rectangle = new Shape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d));
            List<TextComponentStyle> listPreviewChildren = previewChildren(composerK, 0);
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
            Size size = new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE);
            float fG = Dp.g(16);
            Color.Companion companion2 = Color.f25715b;
            float f3 = 20;
            float f4 = 0;
            StackComponentView(new StackComponentStyle(listPreviewChildren, vertical, true, size, fG, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), null, 2, null))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f4)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(10), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.m())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(f3), Dp.g(f4), Dp.g(5), null), previewBadge$default(Badge.Style.Nested, twoDimensionalAlignment, rectangle, null, null, 24, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Nested_Badge$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Nested_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_Nested_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Overlay_Badge(@PreviewParameter final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1927454081);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(twoDimensionalAlignment) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1927454081, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Overlay_Badge (StackComponentView.kt:954)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Shape.Rectangle rectangle = new Shape.Rectangle(new CornerRadiuses.Dp(20.0d, 20.0d, 20.0d, 20.0d));
            List<TextComponentStyle> listPreviewChildren = previewChildren(composerK, 0);
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
            Size size = new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE);
            float fG = Dp.g(16);
            Color.Companion companion2 = Color.f25715b;
            float f3 = 12;
            StackComponentView(new StackComponentStyle(listPreviewChildren, vertical, true, size, fG, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), null, 2, null))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(10), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(20), Dp.g(0), Dp.g(5), null), previewBadge$default(Badge.Style.Overlay, twoDimensionalAlignment, rectangle, null, PaddingKt.c(Dp.g(8), 0.0f, 2, null), 8, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Overlay_Badge$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Overlay_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_Overlay_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Pill_EdgeToEdge_Badge(@PreviewParameter final TwoDimensionalAlignment twoDimensionalAlignment, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1484368524);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(twoDimensionalAlignment) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1484368524, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Pill_EdgeToEdge_Badge (StackComponentView.kt:1042)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            List<TextComponentStyle> listPreviewChildren = previewChildren(composerK, 0);
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
            Size size = new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE);
            float fG = Dp.g(16);
            Color.Companion companion2 = Color.f25715b;
            BackgroundStyles.Color colorM753boximpl = BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), null, 2, null)));
            float f3 = 0;
            PaddingValues paddingValuesA = PaddingKt.a(Dp.g(f3));
            PaddingValues paddingValuesA2 = PaddingKt.a(Dp.g(f3));
            Shape.Pill pill = Shape.Pill.INSTANCE;
            StackComponentView(new StackComponentStyle(listPreviewChildren, vertical, true, size, fG, colorM753boximpl, paddingValuesA, paddingValuesA2, pill, new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(20), Dp.g(f3), Dp.g(5), null), previewBadge$default(Badge.Style.EdgeToEdge, twoDimensionalAlignment, pill, null, null, 24, null), null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Pill_EdgeToEdge_Badge$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Pill_EdgeToEdge_Badge.2
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
                    StackComponentViewKt.StackComponentView_Preview_Pill_EdgeToEdge_Badge(twoDimensionalAlignment, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll(Composer composer, final int i3) {
        Composer composerK = composer.k(-889520099);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-889520099, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll (StackComponentView.kt:1248)");
            }
            IntRange intRange = new IntRange(0, 10);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                String str = "Hello " + ((IntIterator) it).nextInt();
                ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null);
                SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
                arrayList.add(PreviewHelpersKt.previewTextComponentStyle$default(str, null, 0, null, null, null, null, colorStyles, true, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63614, null));
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Dimension.Horizontal horizontal = new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.START);
            SizeConstraint.Fit fit2 = SizeConstraint.Fit.INSTANCE;
            Size size = new Size(fit2, fit2);
            float f3 = 16;
            float fG = Dp.g(f3);
            Color.Companion companion2 = Color.f25715b;
            StackComponentView(new StackComponentStyle(arrayList, horizontal, true, size, fG, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.m()))))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(10), Dp.g(0), Dp.g(5), null), null, Orientation.f6032b, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll.2
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
                    StackComponentViewKt.StackComponentView_Preview_Scroll_HorizontalStack_HorizontalScroll(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll(Composer composer, final int i3) {
        Composer composerK = composer.k(-99980615);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-99980615, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll (StackComponentView.kt:884)");
            }
            IntRange intRange = new IntRange(0, 30);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it = intRange.iterator();
            while (it.hasNext()) {
                String str = "Hello " + ((IntIterator) it).nextInt();
                ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null);
                SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
                arrayList.add(PreviewHelpersKt.previewTextComponentStyle$default(str, null, 0, null, null, null, null, colorStyles, true, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63614, null));
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
            SizeConstraint.Fit fit2 = SizeConstraint.Fit.INSTANCE;
            Size size = new Size(fit2, fit2);
            float f3 = 16;
            float fG = Dp.g(f3);
            Color.Companion companion2 = Color.f25715b;
            StackComponentView(new StackComponentStyle(arrayList, vertical, true, size, fG, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.m()))))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(10), Dp.g(0), Dp.g(3), null), null, Orientation.f6031a, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll.2
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
                    StackComponentViewKt.StackComponentView_Preview_Scroll_VerticalStack_VerticalScroll(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_Vertical(Composer composer, final int i3) {
        Composer composerK = composer.k(1372631849);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1372631849, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_Vertical (StackComponentView.kt:837)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            List<TextComponentStyle> listPreviewChildren = previewChildren(composerK, 0);
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            Size size = new Size(fit, fit);
            float f3 = 16;
            float fG = Dp.g(f3);
            Color.Companion companion2 = Color.f25715b;
            StackComponentView(new StackComponentStyle(listPreviewChildren, vertical, true, size, fG, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.m()))))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(10), Dp.g(0), Dp.g(3), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_Vertical$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_Vertical.2
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
                    StackComponentViewKt.StackComponentView_Preview_Vertical(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_VerticalChildrenFillHeight(Composer composer, final int i3) {
        Composer composerK = composer.k(89883392);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(89883392, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_VerticalChildrenFillHeight (StackComponentView.kt:1412)");
            }
            Color.Companion companion = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.m())), null, 2, null);
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            SizeConstraint.Fill fill = SizeConstraint.Fill.INSTANCE;
            List listListOf = CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fit, fill), null, null, null, null, null, null, 64894, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), false, new Size(fit, fill), null, null, null, null, null, null, 64894, null)});
            Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START);
            Size size = new Size(fit, new SizeConstraint.Fixed(200, null));
            float f3 = 16;
            float fG = Dp.g(f3);
            ColorStyles colorStylesM754constructorimpl = BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.i())), null, 2, null));
            StackComponentView(new StackComponentStyle(listListOf, vertical, true, size, fG, BackgroundStyles.Color.m753boximpl(colorStylesM754constructorimpl), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new C24891(null), null, 0.0f, null, composerK, 384, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_VerticalChildrenFillHeight.2
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
                    StackComponentViewKt.StackComponentView_Preview_VerticalChildrenFillHeight(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_VerticalDivider(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(-843904936);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-843904936, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_VerticalDivider (StackComponentView.kt:1706)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = SizeKt.i(companion, Dp.g(100));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.f(), Alignment.f25072a.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c("There should be a divider to the right of this text.", RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerK, 6, 0, 131068);
            StackComponentView(PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(CollectionsKt.emptyList(), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : new Dimension.Horizontal(VerticalAlignment.TOP, FlexDistribution.SPACE_BETWEEN), (31966 & 4) != 0 ? true : true, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : new Size(new SizeConstraint.Fixed(1, null), SizeConstraint.Fill.INSTANCE), (31966 & 16) != 0 ? Dp.g(16) : Dp.g(0), (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.f(200, 200, 200, 0, 8, null))), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : PaddingKt.c(Dp.g(40), 0.0f, 2, null), (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_VerticalDivider$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composer2 = composerK;
            TextKt.c("There should be a divider to the left of this text.", RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 6, 0, 131068);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_VerticalDivider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    StackComponentViewKt.StackComponentView_Preview_VerticalDivider(composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_ZLayer(Composer composer, final int i3) {
        Composer composerK = composer.k(665263624);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(665263624, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_ZLayer (StackComponentView.kt:1307)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(32));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Color.Companion companion2 = Color.f25715b;
            ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.m())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())));
            SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
            float f3 = 16;
            float f4 = 5;
            StackComponentView(new StackComponentStyle(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), new Padding(0.0d, 24.0d, 0.0d, 24.0d), null, null, null, null, 61822, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), false, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63870, null)}), new Dimension.ZLayer(TwoDimensionalAlignment.BOTTOM_TRAILING), true, new Size(fit, fit), Dp.g(f3), BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.i())), ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.m()))))), PaddingKt.a(Dp.g(f3)), PaddingKt.a(Dp.g(f3)), new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)), new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.b())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion2.a())), null, 2, null), Dp.g(20), Dp.g(f4), Dp.g(f4), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_ZLayer$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_ZLayer.2
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
                    StackComponentViewKt.StackComponentView_Preview_ZLayer(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void StackWithLongEdgeToEdgeBadge(final com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState r21, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r22, final com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle r23, final boolean r24, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r25, final com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r26, final float r27, androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithLongEdgeToEdgeBadge(com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle, boolean, kotlin.jvm.functions.Function2, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.graphics.Shape StackWithLongEdgeToEdgeBadge$lambda$5(State<? extends androidx.compose.ui.graphics.Shape> state) {
        return (androidx.compose.ui.graphics.Shape) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void StackWithOverlaidBadge(final com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState r21, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r22, final com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle r23, final com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment r24, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r25, final com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r26, final float r27, androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithOverlaidBadge(com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle, com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment, kotlin.jvm.functions.Function2, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void StackWithShortEdgeToEdgeBadge(final com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState r28, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r29, final com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle r30, final com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment r31, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r32, final com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r33, final float r34, androidx.compose.ui.Modifier r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackWithShortEdgeToEdgeBadge(com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle, com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment, kotlin.jvm.functions.Function2, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getOverlaidBadgeOffsetY(int i3, TwoDimensionalAlignment twoDimensionalAlignment, float f3) {
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment.ordinal()]) {
            case 1:
            case 3:
            case 4:
                return MathKt.d(-((i3 - f3) / 2));
            case 2:
            case 5:
            case 6:
                return MathKt.d((i3 - f3) / 2);
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    static /* synthetic */ int getOverlaidBadgeOffsetY$default(int i3, TwoDimensionalAlignment twoDimensionalAlignment, float f3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            f3 = 0.0f;
        }
        return getOverlaidBadgeOffsetY(i3, twoDimensionalAlignment, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getShouldIgnoreTopWindowInsets(ComponentStyle componentStyle) {
        if (componentStyle instanceof ImageComponentStyle) {
            return ((ImageComponentStyle) componentStyle).getIgnoreTopWindowInsets();
        }
        if (componentStyle instanceof VideoComponentStyle) {
            return ((VideoComponentStyle) componentStyle).getIgnoreTopWindowInsets();
        }
        return false;
    }

    public static final boolean getUsesAllAvailableSpace(FlexDistribution flexDistribution) {
        Intrinsics.checkNotNullParameter(flexDistribution, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$2[flexDistribution.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
            case 5:
            case 6:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier headerOrInsetsTopPadding(Modifier modifier, final PaywallState.Loaded.Components components, final int i3) {
        return LayoutModifierKt.a(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.headerOrInsetsTopPadding.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m813invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m813invoke3p2s80s(MeasureScope layout, Measurable measurable, long j3) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final int headerHeightPx = components.getHeaderHeightPx() > 0 ? components.getHeaderHeightPx() : i3;
                final Placeable placeableN0 = measurable.n0(ConstraintsKt.j(j3, 0, -headerHeightPx, 1, null));
                return MeasureScope.B0(layout, placeableN0.X0(), placeableN0.O0() + headerHeightPx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.headerOrInsetsTopPadding.1.1
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

    private static final boolean isTop(TwoDimensionalAlignment twoDimensionalAlignment) {
        switch (WhenMappings.$EnumSwitchMapping$0[twoDimensionalAlignment.ordinal()]) {
            case 1:
            case 3:
            case 4:
                return true;
            case 2:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CornerSize makeAbsolute(CornerSize cornerSize, Placeable placeable, Density density) {
        return m810makeAbsolute12SF9DM(cornerSize, androidx.compose.ui.geometry.SizeKt.a(placeable.X0(), placeable.O0()), density);
    }

    /* JADX INFO: renamed from: makeAbsolute-12SF9DM, reason: not valid java name */
    private static final CornerSize m810makeAbsolute12SF9DM(CornerSize cornerSize, long j3, Density density) {
        return CornerSizeKt.a(cornerSize.a(j3, density));
    }

    private static final BadgeStyle previewBadge(Badge.Style style, TwoDimensionalAlignment twoDimensionalAlignment, com.revenuecat.purchases.paywalls.components.properties.Shape shape, PaddingValues paddingValues, PaddingValues paddingValues2) {
        SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
        List listListOf = CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle$default("Badge", null, 0, null, null, null, null, null, false, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63998, null));
        Dimension.Vertical vertical = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER);
        Size size = new Size(fit, fit);
        float fG = Dp.g(0);
        Color.Companion companion = Color.f25715b;
        return new BadgeStyle(new StackComponentStyle(listListOf, vertical, true, size, fG, BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(45.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.k(companion.f()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.k(companion.m()), 80.0f)}))), null, 2, null))), paddingValues, paddingValues2, shape, null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null), style, twoDimensionalAlignment);
    }

    static /* synthetic */ BadgeStyle previewBadge$default(Badge.Style style, TwoDimensionalAlignment twoDimensionalAlignment, com.revenuecat.purchases.paywalls.components.properties.Shape shape, PaddingValues paddingValues, PaddingValues paddingValues2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            paddingValues = PaddingKt.a(Dp.g(0));
        }
        if ((i3 & 16) != 0) {
            paddingValues2 = PaddingKt.a(Dp.g(0));
        }
        return previewBadge(style, twoDimensionalAlignment, shape, paddingValues, paddingValues2);
    }

    private static final List<TextComponentStyle> previewChildren(Composer composer, int i3) {
        composer.a0(-407337990);
        if (ComposerKt.M()) {
            ComposerKt.U(-407337990, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.previewChildren (StackComponentView.kt:1753)");
        }
        Color.Companion companion = Color.f25715b;
        ColorStyles colorStyles = new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null);
        SizeConstraint.Fit fit = SizeConstraint.Fit.INSTANCE;
        List<TextComponentStyle> listListOf = CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle$default("Hello", null, 0, null, null, null, null, colorStyles, false, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63870, null), PreviewHelpersKt.previewTextComponentStyle$default("World", null, 0, null, null, null, null, new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(companion.b())), null, 2, null), false, new Size(fit, fit), new Padding(8.0d, 8.0d, 8.0d, 8.0d), null, null, null, null, null, 63870, null)});
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return listListOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4 A[PHI: r14
      0x00a4: PHI (r14v13 int) = (r14v0 int), (r14v6 int), (r14v7 int) binds: [B:56:0x00a2, B:66:0x00bc, B:65:0x00b9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void StackComponentView(final com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle r16, final com.revenuecat.purchases.ui.revenuecatui.data.PaywallState.Loaded.Components r17, final kotlin.jvm.functions.Function2<? super com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r18, androidx.compose.ui.Modifier r19, float r20, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 647
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView(com.revenuecat.purchases.ui.revenuecatui.components.style.StackComponentStyle, com.revenuecat.purchases.ui.revenuecatui.data.PaywallState$Loaded$Components, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, float, com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void StackComponentView_Preview_HorizontalDivider(Composer composer, final int i3) {
        Composer composer2;
        Composer composerK = composer.k(1466582790);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1466582790, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentView_Preview_HorizontalDivider (StackComponentView.kt:1675)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalF = Arrangement.f6574a.f();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalF, Alignment.f25072a.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(cJfnYMIyomoWf.ekdOR, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerK, 6, 0, 131070);
            StackComponentView(PreviewHelpersKt.m698previewStackComponentStyle7SJwSw(CollectionsKt.emptyList(), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.SPACE_BETWEEN), (31966 & 4) != 0 ? true : true, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), SizeConstraint.Fit.INSTANCE) : new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(1, null)), (31966 & 16) != 0 ? Dp.g(16) : Dp.g(0), (31966 & 32) != 0 ? BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.i())), null, 2, null))) : BackgroundStyles.Color.m753boximpl(BackgroundStyles.Color.m754constructorimpl(new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(ColorKt.f(200, 200, 200, 0, 8, null))), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.a(Dp.g(0)) : null, (31966 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? PaddingKt.a(Dp.g(0)) : PaddingKt.c(0.0f, Dp.g(40), 1, null), (31966 & Function.MAX_NARGS) != 0 ? new Shape.Rectangle(new CornerRadiuses.Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(Dp.g(2), new ColorStyles(ColorStyle.Solid.m775boximpl(ColorStyle.Solid.m776constructorimpl(Color.f25715b.b())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), PreviewHelpersKt.previewEmptyState(null, composerK, 0, 1), new StackComponentViewKt$StackComponentView_Preview_HorizontalDivider$1$1(null), null, 0.0f, null, composerK, 384, 56);
            composer2 = composerK;
            TextKt.c("There should be a divider above this text.", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 6, 0, 131070);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentViewKt.StackComponentView_Preview_HorizontalDivider.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i4) {
                    StackComponentViewKt.StackComponentView_Preview_HorizontalDivider(composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
