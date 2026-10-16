package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {
    private boolean checked;
    private float initialOffset;
    private float initialSize;
    private InteractionSource interactionSource;
    private boolean isPressed;
    private Animatable<Float, AnimationVector1D> offsetAnim;
    private Animatable<Float, AnimationVector1D> sizeAnim;

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode$onAttach$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode$onAttach$1", f = "Switch.kt", l = {333}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ThumbNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                final Ref.IntRef intRef = new Ref.IntRef();
                Flow flowC = ThumbNode.this.getInteractionSource().c();
                final ThumbNode thumbNode = ThumbNode.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode.onAttach.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((Interaction) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
                        if (interaction instanceof PressInteraction.Press) {
                            intRef.f140142a++;
                        } else if (interaction instanceof PressInteraction.Release) {
                            Ref.IntRef intRef2 = intRef;
                            intRef2.f140142a--;
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            Ref.IntRef intRef3 = intRef;
                            intRef3.f140142a--;
                        }
                        boolean z2 = intRef.f140142a > 0;
                        if (thumbNode.isPressed != z2) {
                            thumbNode.isPressed = z2;
                            LayoutModifierNodeKt.b(thumbNode);
                        }
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (flowC.collect(flowCollector, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public ThumbNode(InteractionSource interactionSource, boolean z2) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        this.interactionSource = interactionSource;
        this.checked = z2;
        this.initialOffset = Float.NaN;
        this.initialSize = Float.NaN;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final InteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return super.maxIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return super.maxIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measure, Measurable measurable, long j3) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        float fM1 = measure.M1(this.isPressed ? SwitchTokens.INSTANCE.m933getPressedHandleWidthD9Ej5fM() : ((measurable.I(Constraints.l(j3)) != 0 && measurable.l0(Constraints.k(j3)) != 0) || this.checked) ? SwitchKt.ThumbDiameter : SwitchKt.UncheckedThumbDiameter);
        Animatable<Float, AnimationVector1D> animatable = this.sizeAnim;
        int iFloatValue = (int) (animatable != null ? ((Number) animatable.n()).floatValue() : fM1);
        final Placeable placeableN0 = measurable.n0(Constraints.f29963b.c(iFloatValue, iFloatValue));
        final float fM12 = measure.M1(Dp.g(Dp.g(SwitchKt.SwitchHeight - measure.G(fM1)) / 2.0f));
        float fM13 = measure.M1(Dp.g(Dp.g(SwitchKt.SwitchWidth - SwitchKt.ThumbDiameter) - SwitchKt.ThumbPadding));
        boolean z2 = this.isPressed;
        if (z2 && this.checked) {
            fM12 = fM13 - measure.M1(SwitchTokens.INSTANCE.m937getTrackOutlineWidthD9Ej5fM());
        } else if (z2 && !this.checked) {
            fM12 = measure.M1(SwitchTokens.INSTANCE.m937getTrackOutlineWidthD9Ej5fM());
        } else if (this.checked) {
            fM12 = fM13;
        }
        Animatable<Float, AnimationVector1D> animatable2 = this.sizeAnim;
        if (!Intrinsics.areEqual(animatable2 != null ? (Float) animatable2.l() : null, fM1)) {
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new ThumbNode$measure$1(this, fM1, null), 3, null);
        }
        Animatable<Float, AnimationVector1D> animatable3 = this.offsetAnim;
        if (!Intrinsics.areEqual(animatable3 != null ? (Float) animatable3.l() : null, fM12)) {
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new ThumbNode$measure$2(this, fM12, null), 3, null);
        }
        if (Float.isNaN(this.initialSize) && Float.isNaN(this.initialOffset)) {
            this.initialSize = fM1;
            this.initialOffset = fM12;
        }
        return MeasureScope.B0(measure, iFloatValue, iFloatValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ThumbNode$measure$3
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
                Placeable placeable = placeableN0;
                Animatable animatable4 = this.offsetAnim;
                Placeable.PlacementScope.m(layout, placeable, (int) (animatable4 != null ? ((Number) animatable4.n()).floatValue() : fM12), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return super.minIntrinsicHeight(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return super.minIntrinsicWidth(intrinsicMeasureScope, intrinsicMeasurable, i3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // androidx.compose.ui.node.DelegatableNode, androidx.compose.ui.node.PointerInputModifierNode
    public /* bridge */ /* synthetic */ void onDensityChange() {
        super.onDensityChange();
    }

    @Override // androidx.compose.ui.node.DelegatableNode
    public /* bridge */ /* synthetic */ void onLayoutDirectionChange() {
        super.onLayoutDirectionChange();
    }

    public final void setChecked(boolean z2) {
        this.checked = z2;
    }

    public final void setInteractionSource(InteractionSource interactionSource) {
        Intrinsics.checkNotNullParameter(interactionSource, "<set-?>");
        this.interactionSource = interactionSource;
    }

    public final void update() {
        if (this.sizeAnim == null && !Float.isNaN(this.initialSize)) {
            this.sizeAnim = AnimatableKt.b(this.initialSize, 0.0f, 2, null);
        }
        if (this.offsetAnim != null || Float.isNaN(this.initialOffset)) {
            return;
        }
        this.offsetAnim = AnimatableKt.b(this.initialOffset, 0.0f, 2, null);
    }
}
