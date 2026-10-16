package androidx.compose.material.ripple;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.DrawModifierNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public abstract class RippleNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, DrawModifierNode, LayoutAwareModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InteractionSource f15405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f15407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorProducer f15408d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function0 f15409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f15410g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StateLayer f15411h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f15412i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f15413j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f15414k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableObjectList f15415l;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.RippleNode$onAttach$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.material.ripple.RippleNode$onAttach$1", f = "Ripple.kt", l = {378}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f15417b;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = RippleNode.this.new AnonymousClass1(continuation);
            anonymousClass1.f15417b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f15416a;
            if (i3 == 0) {
                ResultKt.b(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.f15417b;
                Flow flowC = RippleNode.this.f15405a.c();
                final RippleNode rippleNode = RippleNode.this;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material.ripple.RippleNode.onAttach.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object emit(Interaction interaction, Continuation continuation) {
                        if (!(interaction instanceof PressInteraction)) {
                            rippleNode.z2(interaction, coroutineScope);
                        } else if (rippleNode.f15414k) {
                            rippleNode.x2((PressInteraction) interaction);
                        } else {
                            rippleNode.f15415l.n(interaction);
                        }
                        return Unit.f139807a;
                    }
                };
                this.f15416a = 1;
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

    public /* synthetic */ RippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z2, f3, colorProducer, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x2(PressInteraction pressInteraction) {
        if (pressInteraction instanceof PressInteraction.Press) {
            r2((PressInteraction.Press) pressInteraction, this.f15413j, this.f15412i);
        } else if (pressInteraction instanceof PressInteraction.Release) {
            y2(((PressInteraction.Release) pressInteraction).a());
        } else if (pressInteraction instanceof PressInteraction.Cancel) {
            y2(((PressInteraction.Cancel) pressInteraction).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2(Interaction interaction, CoroutineScope coroutineScope) {
        StateLayer stateLayer = this.f15411h;
        if (stateLayer == null) {
            stateLayer = new StateLayer(this.f15406b, this.f15409f);
            DrawModifierNodeKt.a(this);
            this.f15411h = stateLayer;
        }
        stateLayer.c(interaction, coroutineScope);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.i2();
        StateLayer stateLayer = this.f15411h;
        if (stateLayer != null) {
            stateLayer.b(contentDrawScope, this.f15412i, v2());
        }
        s2(contentDrawScope);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return this.f15410g;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public void m(long j3) {
        this.f15414k = true;
        Density densityK = DelegatableNodeKt.k(this);
        this.f15413j = IntSizeKt.e(j3);
        this.f15412i = Float.isNaN(this.f15407c) ? RippleAnimationKt.a(densityK, this.f15406b, this.f15413j) : densityK.M1(this.f15407c);
        MutableObjectList mutableObjectList = this.f15415l;
        Object[] objArr = mutableObjectList.f3081a;
        int i3 = mutableObjectList.f3082b;
        for (int i4 = 0; i4 < i3; i4++) {
            x2((PressInteraction) objArr[i4]);
        }
        this.f15415l.t();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    public abstract void r2(PressInteraction.Press press, long j3, float f3);

    public abstract void s2(DrawScope drawScope);

    protected final boolean t2() {
        return this.f15406b;
    }

    protected final Function0 u2() {
        return this.f15409f;
    }

    public final long v2() {
        return this.f15408d.a();
    }

    protected final long w2() {
        return this.f15413j;
    }

    public abstract void y2(PressInteraction.Press press);

    private RippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, Function0 function0) {
        this.f15405a = interactionSource;
        this.f15406b = z2;
        this.f15407c = f3;
        this.f15408d = colorProducer;
        this.f15409f = function0;
        this.f15413j = Size.f25617b.b();
        this.f15415l = new MutableObjectList(0, 1, null);
    }
}
