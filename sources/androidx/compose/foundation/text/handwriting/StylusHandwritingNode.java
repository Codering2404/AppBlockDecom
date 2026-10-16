package androidx.compose.foundation.text.handwriting;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusRequesterModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class StylusHandwritingNode extends DelegatingNode implements PointerInputModifierNode, FocusEventModifierNode, FocusRequesterModifierNode {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function0 f10111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f10112d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SuspendingPointerInputModifierNode f10113f = (SuspendingPointerInputModifierNode) m2(SuspendingPointerInputFilterKt.a(new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1

        /* JADX INFO: renamed from: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1$1", f = "StylusHandwriting.kt", l = {105, 133, 171}, m = "invokeSuspend")
        static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f10115a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f10116b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f10117c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private /* synthetic */ Object f10118d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ StylusHandwritingNode f10119f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(StylusHandwritingNode stylusHandwritingNode, Continuation continuation) {
                super(2, continuation);
                this.f10119f = stylusHandwritingNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10119f, continuation);
                anonymousClass1.f10118d = obj;
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation) {
                return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.f139807a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x0059, code lost:
            
                if (r8 == r1) goto L74;
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00f4, code lost:
            
                if (r9 != r1) goto L42;
             */
            /* JADX WARN: Code restructure failed: missing block: B:73:0x01a6, code lost:
            
                if (r5 != r1) goto L75;
             */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x01a8, code lost:
            
                return r1;
             */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f4 -> B:42:0x00f8). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x01a6 -> B:75:0x01a9). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 495
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.handwriting.StylusHandwritingNode$suspendingPointerInputModifierNode$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
            Object objE = ForEachGestureKt.e(pointerInputScope, new AnonymousClass1(this.f10114a, null), continuation);
            return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
        }
    }));

    public StylusHandwritingNode(Function0 function0) {
        this.f10111c = function0;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void O(FocusState focusState) {
        this.f10112d = focusState.a();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public long V0() {
        return StylusHandwritingKt.a().a(DelegatableNodeKt.k(this));
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void g0(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j3) {
        this.f10113f.g0(pointerEvent, pointerEventPass, j3);
    }

    public final Function0 t2() {
        return this.f10111c;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void u1() {
        this.f10113f.u1();
    }

    public final void u2(Function0 function0) {
        this.f10111c = function0;
    }
}
