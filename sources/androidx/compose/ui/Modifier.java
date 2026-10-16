package androidx.compose.ui;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

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
public interface Modifier {
    public static final Companion b8 = Companion.f25125a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Element extends Modifier {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
        }

        @Override // androidx.compose.ui.Modifier
        default boolean all(Function1 function1) {
            return ((Boolean) function1.invoke(this)).booleanValue();
        }

        @Override // androidx.compose.ui.Modifier
        default boolean any(Function1 function1) {
            return ((Boolean) function1.invoke(this)).booleanValue();
        }

        @Override // androidx.compose.ui.Modifier
        default Object foldIn(Object obj, Function2 function2) {
            return function2.invoke(obj, this);
        }

        default Object foldOut(Object obj, Function2 function2) {
            return function2.invoke(this, obj);
        }
    }

    boolean all(Function1 function1);

    boolean any(Function1 function1);

    Object foldIn(Object obj, Function2 function2);

    default Modifier then(Modifier modifier) {
        return modifier == b8 ? this : new CombinedModifier(this, modifier);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Node implements DelegatableNode {
        public static final int $stable = 8;
        private Node child;
        private NodeCoordinator coordinator;
        private Function0<Unit> detachedListener;
        private boolean insertedNodeAwaitingAttachForInvalidation;
        private boolean isAttached;
        private int kindSet;
        private boolean onAttachRunExpected;
        private boolean onDetachRunExpected;
        private ObserverNodeOwnerScope ownerScope;
        private Node parent;
        private CoroutineScope scope;
        private boolean updatedNodeAwaitingAttachForInvalidation;
        private Node node = this;
        private int aggregateChildKindSet = -1;

        public final int getAggregateChildKindSet$ui_release() {
            return this.aggregateChildKindSet;
        }

        public final Node getChild$ui_release() {
            return this.child;
        }

        public final NodeCoordinator getCoordinator$ui_release() {
            return this.coordinator;
        }

        public final CoroutineScope getCoroutineScope() {
            CoroutineScope coroutineScope = this.scope;
            if (coroutineScope != null) {
                return coroutineScope;
            }
            CoroutineScope coroutineScopeA = CoroutineScopeKt.a(DelegatableNodeKt.p(this).getCoroutineContext().plus(JobKt.a((Job) DelegatableNodeKt.p(this).getCoroutineContext().get(Job.v8))));
            this.scope = coroutineScopeA;
            return coroutineScopeA;
        }

        public final Function0<Unit> getDetachedListener$ui_release() {
            return this.detachedListener;
        }

        public final boolean getInsertedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.insertedNodeAwaitingAttachForInvalidation;
        }

        public final int getKindSet$ui_release() {
            return this.kindSet;
        }

        @Override // androidx.compose.ui.node.DelegatableNode
        public final Node getNode() {
            return this.node;
        }

        public final ObserverNodeOwnerScope getOwnerScope$ui_release() {
            return this.ownerScope;
        }

        public final Node getParent$ui_release() {
            return this.parent;
        }

        public boolean getShouldAutoInvalidate() {
            return true;
        }

        public final boolean getUpdatedNodeAwaitingAttachForInvalidation$ui_release() {
            return this.updatedNodeAwaitingAttachForInvalidation;
        }

        public final boolean isAttached() {
            return this.isAttached;
        }

        /* JADX INFO: renamed from: isKind-H91voCI$ui_release, reason: not valid java name */
        public final boolean m209isKindH91voCI$ui_release(int i3) {
            return (i3 & getKindSet$ui_release()) != 0;
        }

        public void markAsAttached$ui_release() {
            if (this.isAttached) {
                InlineClassHelperKt.c("node attached multiple times");
            }
            if (!(this.coordinator != null)) {
                InlineClassHelperKt.c("attach invoked on a node without a coordinator");
            }
            this.isAttached = true;
            this.onAttachRunExpected = true;
        }

        public void markAsDetached$ui_release() {
            if (!this.isAttached) {
                InlineClassHelperKt.c("Cannot detach a node that is not attached");
            }
            if (this.onAttachRunExpected) {
                InlineClassHelperKt.c("Must run runAttachLifecycle() before markAsDetached()");
            }
            if (this.onDetachRunExpected) {
                InlineClassHelperKt.c("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.isAttached = false;
            CoroutineScope coroutineScope = this.scope;
            if (coroutineScope != null) {
                CoroutineScopeKt.d(coroutineScope, new ModifierNodeDetachedCancellationException());
                this.scope = null;
            }
        }

        public void reset$ui_release() {
            if (!this.isAttached) {
                InlineClassHelperKt.c("reset() called on an unattached node");
            }
            onReset();
        }

        public void runAttachLifecycle$ui_release() {
            if (!this.isAttached) {
                InlineClassHelperKt.c("Must run markAsAttached() prior to runAttachLifecycle");
            }
            if (!this.onAttachRunExpected) {
                InlineClassHelperKt.c("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.onAttachRunExpected = false;
            onAttach();
            this.onDetachRunExpected = true;
        }

        public void runDetachLifecycle$ui_release() {
            if (!this.isAttached) {
                InlineClassHelperKt.c("node detached multiple times");
            }
            if (!(this.coordinator != null)) {
                InlineClassHelperKt.c("detach invoked on a node without a coordinator");
            }
            if (!this.onDetachRunExpected) {
                InlineClassHelperKt.c("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.onDetachRunExpected = false;
            Function0<Unit> function0 = this.detachedListener;
            if (function0 != null) {
                function0.invoke();
            }
            onDetach();
        }

        public final void setAggregateChildKindSet$ui_release(int i3) {
            this.aggregateChildKindSet = i3;
        }

        public void setAsDelegateTo$ui_release(Node node) {
            this.node = node;
        }

        public final void setChild$ui_release(Node node) {
            this.child = node;
        }

        public final void setDetachedListener$ui_release(Function0<Unit> function0) {
            this.detachedListener = function0;
        }

        public final void setInsertedNodeAwaitingAttachForInvalidation$ui_release(boolean z2) {
            this.insertedNodeAwaitingAttachForInvalidation = z2;
        }

        public final void setKindSet$ui_release(int i3) {
            this.kindSet = i3;
        }

        public final void setOwnerScope$ui_release(ObserverNodeOwnerScope observerNodeOwnerScope) {
            this.ownerScope = observerNodeOwnerScope;
        }

        public final void setParent$ui_release(Node node) {
            this.parent = node;
        }

        public final void setUpdatedNodeAwaitingAttachForInvalidation$ui_release(boolean z2) {
            this.updatedNodeAwaitingAttachForInvalidation = z2;
        }

        public final void sideEffect(Function0<Unit> function0) {
            DelegatableNodeKt.p(this).D(function0);
        }

        public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }

        public static /* synthetic */ void getNode$annotations() {
        }

        public static /* synthetic */ void getShouldAutoInvalidate$annotations() {
        }

        public void onAttach() {
        }

        public void onDetach() {
        }

        public void onReset() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion implements Modifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f25125a = new Companion();

        private Companion() {
        }

        @Override // androidx.compose.ui.Modifier
        public boolean all(Function1 function1) {
            return true;
        }

        @Override // androidx.compose.ui.Modifier
        public boolean any(Function1 function1) {
            return false;
        }

        public String toString() {
            return "Modifier";
        }

        @Override // androidx.compose.ui.Modifier
        public Modifier then(Modifier modifier) {
            return modifier;
        }

        @Override // androidx.compose.ui.Modifier
        public Object foldIn(Object obj, Function2 function2) {
            return obj;
        }
    }
}
