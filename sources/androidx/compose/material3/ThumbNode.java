package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.ui.Modifier;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ThumbNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InteractionSource f21132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f21133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f21134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animatable f21135d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animatable f21136f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f21137g = Float.NaN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f21138h = Float.NaN;

    /* JADX INFO: renamed from: androidx.compose.material3.ThumbNode$onAttach$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material3.ThumbNode$onAttach$1", f = "Switch.kt", l = {220}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f21148a;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return ThumbNode.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f21148a;
            if (i3 == 0) {
                ResultKt.b(obj);
                final Ref.IntRef intRef = new Ref.IntRef();
                Flow flowC = ThumbNode.this.getInteractionSource().c();
                final ThumbNode thumbNode = ThumbNode.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material3.ThumbNode.onAttach.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Interaction interaction, Continuation continuation) {
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
                        if (thumbNode.f21134c != z2) {
                            thumbNode.f21134c = z2;
                            LayoutModifierNodeKt.b(thumbNode);
                        }
                        return Unit.f139807a;
                    }
                };
                this.f21148a = 1;
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
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public ThumbNode(InteractionSource interactionSource, boolean z2) {
        this.f21132a = interactionSource;
        this.f21133b = z2;
    }

    public final boolean getChecked() {
        return this.f21133b;
    }

    public final InteractionSource getInteractionSource() {
        return this.f21132a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        float fM1 = measureScope.M1(this.f21134c ? SwitchTokens.f23467a.n() : ((measurable.I(Constraints.l(j3)) != 0 && measurable.l0(Constraints.k(j3)) != 0) || this.f21133b) ? SwitchKt.i() : SwitchKt.j());
        Animatable animatable = this.f21136f;
        int iFloatValue = (int) (animatable != null ? ((Number) animatable.n()).floatValue() : fM1);
        final Placeable placeableN0 = measurable.n0(Constraints.f29963b.c(iFloatValue, iFloatValue));
        final float fM12 = measureScope.M1(Dp.g(Dp.g(SwitchKt.f20452d - measureScope.G(fM1)) / 2.0f));
        float fM13 = measureScope.M1(Dp.g(Dp.g(SwitchKt.f20451c - SwitchKt.i()) - SwitchKt.f20453e));
        boolean z2 = this.f21134c;
        if (z2 && this.f21133b) {
            fM12 = fM13 - measureScope.M1(SwitchTokens.f23467a.u());
        } else if (z2 && !this.f21133b) {
            fM12 = measureScope.M1(SwitchTokens.f23467a.u());
        } else if (this.f21133b) {
            fM12 = fM13;
        }
        Animatable animatable2 = this.f21136f;
        if (!Intrinsics.areEqual(animatable2 != null ? (Float) animatable2.l() : null, fM1)) {
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new ThumbNode$measure$1(this, fM1, null), 3, null);
        }
        Animatable animatable3 = this.f21135d;
        if (!Intrinsics.areEqual(animatable3 != null ? (Float) animatable3.l() : null, fM12)) {
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new ThumbNode$measure$2(this, fM12, null), 3, null);
        }
        if (Float.isNaN(this.f21138h) && Float.isNaN(this.f21137g)) {
            this.f21138h = fM1;
            this.f21137g = fM12;
        }
        return MeasureScope.B0(measureScope, iFloatValue, iFloatValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ThumbNode$measure$3
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
                Placeable placeable = placeableN0;
                Animatable animatable4 = this.f21135d;
                Placeable.PlacementScope.m(placementScope, placeable, (int) (animatable4 != null ? ((Number) animatable4.n()).floatValue() : fM12), 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void setChecked(boolean z2) {
        this.f21133b = z2;
    }

    public final void setInteractionSource(InteractionSource interactionSource) {
        this.f21132a = interactionSource;
    }

    public final void update() {
        if (this.f21136f == null && !Float.isNaN(this.f21138h)) {
            this.f21136f = AnimatableKt.b(this.f21138h, 0.0f, 2, null);
        }
        if (this.f21135d != null || Float.isNaN(this.f21137g)) {
            return;
        }
        this.f21135d = AnimatableKt.b(this.f21137g, 0.0f, 2, null);
    }
}
