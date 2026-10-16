package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusTargetModifierNode;
import androidx.compose.ui.focus.FocusTargetModifierNodeKt;
import androidx.compose.ui.focus.Focusability;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

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
public final class FocusableNode extends DelegatingNode implements SemanticsModifierNode, GlobalPositionAwareModifierNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, TraversableNode {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final TraverseKey f4920l = new TraverseKey(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4921m = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableInteractionSource f4922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f4923d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f4924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FocusInteraction.Focus f4925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private PinnableContainer.PinnedHandle f4926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private LayoutCoordinates f4927i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final FocusTargetModifierNode f4928j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Function0 f4929k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class TraverseKey {
        public /* synthetic */ TraverseKey(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private TraverseKey() {
        }
    }

    public /* synthetic */ FocusableNode(MutableInteractionSource mutableInteractionSource, int i3, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, i3, function1);
    }

    private final PinnableContainer A2() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ObserverModifierNodeKt.a(this, new Function0<Unit>() { // from class: androidx.compose.foundation.FocusableNode$retrievePinnableContainer$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m28invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m28invoke() {
                objectRef.f140144a = CompositionLocalConsumerModifierNodeKt.a(this, PinnableContainerKt.a());
            }
        });
        return (PinnableContainer) objectRef.f140144a;
    }

    private final void u2() {
        FocusInteraction.Focus focus;
        MutableInteractionSource mutableInteractionSource = this.f4922c;
        if (mutableInteractionSource != null && (focus = this.f4925g) != null) {
            mutableInteractionSource.b(new FocusInteraction.Unfocus(focus));
        }
        this.f4925g = null;
    }

    private final void v2(boolean z2) {
        MutableInteractionSource mutableInteractionSource = this.f4922c;
        if (mutableInteractionSource != null) {
            if (!z2) {
                FocusInteraction.Focus focus = this.f4925g;
                if (focus != null) {
                    w2(mutableInteractionSource, new FocusInteraction.Unfocus(focus));
                    this.f4925g = null;
                    return;
                }
                return;
            }
            FocusInteraction.Focus focus2 = this.f4925g;
            if (focus2 != null) {
                w2(mutableInteractionSource, new FocusInteraction.Unfocus(focus2));
                this.f4925g = null;
            }
            FocusInteraction.Focus focus3 = new FocusInteraction.Focus();
            w2(mutableInteractionSource, focus3);
            this.f4925g = focus3;
        }
    }

    private final void w2(final MutableInteractionSource mutableInteractionSource, final Interaction interaction) {
        if (!isAttached()) {
            mutableInteractionSource.b(interaction);
        } else {
            Job job = (Job) getCoroutineScope().getCoroutineContext().get(Job.v8);
            BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new FocusableNode$emitWithFallback$1(mutableInteractionSource, interaction, job != null ? job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.FocusableNode$emitWithFallback$handler$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Throwable th) {
                    mutableInteractionSource.b(interaction);
                }
            }) : null, null), 3, null);
        }
    }

    private final FocusedBoundsObserverNode x2() {
        if (isAttached()) {
            TraversableNode traversableNodeA = TraversableNodeKt.a(this, FocusedBoundsObserverNode.f4942c);
            if (traversableNodeA instanceof FocusedBoundsObserverNode) {
                return (FocusedBoundsObserverNode) traversableNodeA;
            }
        }
        return null;
    }

    private final void y2() {
        FocusedBoundsObserverNode focusedBoundsObserverNodeX2;
        LayoutCoordinates layoutCoordinates = this.f4927i;
        if (layoutCoordinates != null) {
            Intrinsics.checkNotNull(layoutCoordinates);
            if (!layoutCoordinates.m() || (focusedBoundsObserverNodeX2 = x2()) == null) {
                return;
            }
            focusedBoundsObserverNodeX2.m2(this.f4927i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z2(FocusState focusState, FocusState focusState2) {
        boolean zA;
        if (isAttached() && (zA = focusState2.a()) != focusState.a()) {
            Function1 function1 = this.f4923d;
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(zA));
            }
            if (zA) {
                BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new FocusableNode$onFocusStateChange$1(this, null), 3, null);
                PinnableContainer pinnableContainerA2 = A2();
                this.f4926h = pinnableContainerA2 != null ? pinnableContainerA2.a() : null;
                y2();
            } else {
                PinnableContainer.PinnedHandle pinnedHandle = this.f4926h;
                if (pinnedHandle != null) {
                    pinnedHandle.release();
                }
                this.f4926h = null;
                FocusedBoundsObserverNode focusedBoundsObserverNodeX2 = x2();
                if (focusedBoundsObserverNodeX2 != null) {
                    focusedBoundsObserverNodeX2.m2(null);
                }
            }
            SemanticsModifierNodeKt.b(this);
            v2(zA);
        }
    }

    public final void B2(MutableInteractionSource mutableInteractionSource) {
        if (Intrinsics.areEqual(this.f4922c, mutableInteractionSource)) {
            return;
        }
        u2();
        this.f4922c = mutableInteractionSource;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        this.f4927i = layoutCoordinates;
        if (this.f4928j.a0().a()) {
            if (layoutCoordinates.m()) {
                y2();
                return;
            }
            FocusedBoundsObserverNode focusedBoundsObserverNodeX2 = x2();
            if (focusedBoundsObserverNodeX2 != null) {
                focusedBoundsObserverNodeX2.m2(null);
            }
        }
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void N(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.i0(semanticsPropertyReceiver, this.f4928j.a0().a());
        if (this.f4929k == null) {
            this.f4929k = new Function0<Boolean>() { // from class: androidx.compose.foundation.FocusableNode$applySemantics$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(FocusTargetModifierNode.p0(this.f4930a.f4928j, 0, 1, null));
                }
            };
        }
        SemanticsPropertiesKt.T(semanticsPropertyReceiver, null, this.f4929k, 1, null);
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object U() {
        return f4920l;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f4924f;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        PinnableContainer.PinnedHandle pinnedHandle = this.f4926h;
        if (pinnedHandle != null) {
            pinnedHandle.release();
        }
        this.f4926h = null;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void w0() {
        PinnableContainer pinnableContainerA2 = A2();
        if (this.f4928j.a0().a()) {
            PinnableContainer.PinnedHandle pinnedHandle = this.f4926h;
            if (pinnedHandle != null) {
                pinnedHandle.release();
            }
            this.f4926h = pinnableContainerA2 != null ? pinnableContainerA2.a() : null;
        }
    }

    public /* synthetic */ FocusableNode(MutableInteractionSource mutableInteractionSource, int i3, Function1 function1, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, (i4 & 2) != 0 ? Focusability.f25566b.a() : i3, (i4 & 4) != 0 ? null : function1, null);
    }

    private FocusableNode(MutableInteractionSource mutableInteractionSource, int i3, Function1 function1) {
        this.f4922c = mutableInteractionSource;
        this.f4923d = function1;
        this.f4928j = (FocusTargetModifierNode) m2(FocusTargetModifierNodeKt.a(i3, new FocusableNode$focusTargetNode$1(this)));
    }
}
