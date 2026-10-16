package androidx.compose.ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusEnterExitScope;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionManager;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f30141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f30142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f30143c = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onEnter$1
        {
            super(1);
        }

        public final void c(FocusEnterExitScope focusEnterExitScope) {
            View viewG = FocusGroupNode_androidKt.g(this.f30145a);
            if (viewG.isFocused() || viewG.hasFocus()) {
                return;
            }
            if (FocusInteropUtils_androidKt.b(viewG, FocusInteropUtils_androidKt.c(focusEnterExitScope.b()), FocusGroupNode_androidKt.f(DelegatableNodeKt.p(this.f30145a).getFocusOwner(), DelegatableNode_androidKt.a(this.f30145a), viewG))) {
                return;
            }
            focusEnterExitScope.a();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((FocusEnterExitScope) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f30144d = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onExit$1
        {
            super(1);
        }

        public final void c(FocusEnterExitScope focusEnterExitScope) {
            View viewFindNextFocusFromRect;
            View viewG = FocusGroupNode_androidKt.g(this.f30146a);
            if (ComposeUiFlags.f25105e) {
                if (viewG.hasFocus() || viewG.isFocused()) {
                    viewG.clearFocus();
                    return;
                }
                return;
            }
            if (viewG.hasFocus()) {
                FocusOwner focusOwner = DelegatableNodeKt.p(this.f30146a).getFocusOwner();
                View viewA = DelegatableNode_androidKt.a(this.f30146a);
                if (!(viewG instanceof ViewGroup)) {
                    if (!viewA.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus");
                    }
                    return;
                }
                Rect rectF = FocusGroupNode_androidKt.f(focusOwner, viewA, viewG);
                Integer numC = FocusInteropUtils_androidKt.c(focusEnterExitScope.b());
                int iIntValue = numC != null ? numC.intValue() : 130;
                FocusFinder focusFinder = FocusFinder.getInstance();
                FocusGroupPropertiesNode focusGroupPropertiesNode = this.f30146a;
                if (focusGroupPropertiesNode.n2() != null) {
                    Intrinsics.checkNotNull(viewA, "null cannot be cast to non-null type android.view.ViewGroup");
                    viewFindNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) viewA, focusGroupPropertiesNode.n2(), iIntValue);
                } else {
                    Intrinsics.checkNotNull(viewA, "null cannot be cast to non-null type android.view.ViewGroup");
                    viewFindNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) viewA, rectF, iIntValue);
                }
                if (viewFindNextFocusFromRect == null || !FocusGroupNode_androidKt.d(viewG, viewFindNextFocusFromRect)) {
                    if (!viewA.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus");
                    }
                } else {
                    viewFindNextFocusFromRect.requestFocus(iIntValue, rectF);
                    focusEnterExitScope.a();
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((FocusEnterExitScope) obj);
            return Unit.f139807a;
        }
    };

    private final FocusTargetNode m2() {
        int iA = NodeKind.a(1024);
        if (!getNode().isAttached()) {
            InlineClassHelperKt.c("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = getNode();
        if ((node.getAggregateChildKindSet$ui_release() & iA) != 0) {
            boolean z2 = false;
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & iA) != 0) {
                    Modifier.Node nodeH = child$ui_release;
                    MutableVector mutableVector = null;
                    while (nodeH != null) {
                        if (nodeH instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) nodeH;
                            if (z2) {
                                return focusTargetNode;
                            }
                            z2 = true;
                        } else if ((nodeH.getKindSet$ui_release() & iA) != 0 && (nodeH instanceof DelegatingNode)) {
                            int i3 = 0;
                            for (Modifier.Node nodeN2 = ((DelegatingNode) nodeH).n2(); nodeN2 != null; nodeN2 = nodeN2.getChild$ui_release()) {
                                if ((nodeN2.getKindSet$ui_release() & iA) != 0) {
                                    i3++;
                                    if (i3 == 1) {
                                        nodeH = nodeN2;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (nodeH != null) {
                                            mutableVector.b(nodeH);
                                            nodeH = null;
                                        }
                                        mutableVector.b(nodeN2);
                                    }
                                }
                            }
                            if (i3 == 1) {
                            }
                        }
                        nodeH = DelegatableNodeKt.h(mutableVector);
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper");
    }

    @Override // androidx.compose.ui.focus.FocusPropertiesModifierNode
    public void i1(FocusProperties focusProperties) {
        focusProperties.t(false);
        focusProperties.u(this.f30143c);
        focusProperties.z(this.f30144d);
    }

    public final View n2() {
        return this.f30141a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        ViewTreeObserver viewTreeObserver = DelegatableNode_androidKt.a(this).getViewTreeObserver();
        this.f30142b = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        ViewTreeObserver viewTreeObserver = this.f30142b;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.f30142b = null;
        DelegatableNode_androidKt.a(this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.f30141a = null;
        super.onDetach();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View view, View view2) {
        if (DelegatableNodeKt.o(this).A0() == null) {
            return;
        }
        View viewG = FocusGroupNode_androidKt.g(this);
        FocusOwner focusOwner = DelegatableNodeKt.p(this).getFocusOwner();
        Owner ownerP = DelegatableNodeKt.p(this);
        boolean z2 = (view == null || Intrinsics.areEqual(view, ownerP) || !FocusGroupNode_androidKt.d(viewG, view)) ? false : true;
        boolean z3 = (view2 == null || Intrinsics.areEqual(view2, ownerP) || !FocusGroupNode_androidKt.d(viewG, view2)) ? false : true;
        if (z2 && z3) {
            this.f30141a = view2;
            return;
        }
        if (!z3) {
            if (!z2) {
                this.f30141a = null;
                return;
            }
            this.f30141a = null;
            if (m2().a0().a()) {
                focusOwner.o(false, true, false, FocusDirection.f25444b.c());
                return;
            }
            return;
        }
        this.f30141a = view2;
        FocusTargetNode focusTargetNodeM2 = m2();
        if (focusTargetNodeM2.a0().b()) {
            return;
        }
        if (ComposeUiFlags.f25107g) {
            FocusTransactionsKt.j(focusTargetNodeM2);
            return;
        }
        FocusTransactionManager focusTransactionManagerD = focusOwner.d();
        try {
            if (focusTransactionManagerD.i()) {
                focusTransactionManagerD.f();
            }
            focusTransactionManagerD.e();
            FocusTransactionsKt.j(focusTargetNodeM2);
            focusTransactionManagerD.g();
        } catch (Throwable th) {
            focusTransactionManagerD.g();
            throw th;
        }
    }
}
