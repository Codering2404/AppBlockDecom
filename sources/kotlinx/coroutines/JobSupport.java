package kotlinx.coroutines;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;

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
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
@Metadata
public class JobSupport implements Job, ChildJob, ParentJob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f140971a = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state$volatile");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f140972b = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final JobSupport f140973j;

        public AwaitContinuation(Continuation continuation, JobSupport jobSupport) {
            super(continuation, 1);
            this.f140973j = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String K() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable s(Job job) {
            Throwable thE;
            Object objQ0 = this.f140973j.q0();
            return (!(objQ0 instanceof Finishing) || (thE = ((Finishing) objQ0).e()) == null) ? objQ0 instanceof CompletedExceptionally ? ((CompletedExceptionally) objQ0).f140908a : job.getCancellationException() : thE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ChildCompletion extends JobNode {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final JobSupport f140974f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Finishing f140975g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ChildHandleNode f140976h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Object f140977i;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.f140974f = jobSupport;
            this.f140975g = finishing;
            this.f140976h = childHandleNode;
            this.f140977i = obj;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void v(Throwable th) {
            this.f140974f.f0(this.f140975g, this.f140976h, this.f140977i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Finishing implements Incomplete {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f140978b = AtomicIntegerFieldUpdater.newUpdater(Finishing.class, "_isCompleting$volatile");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f140979c = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_rootCause$volatile");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f140980d = AtomicReferenceFieldUpdater.newUpdater(Finishing.class, Object.class, "_exceptionsHolder$volatile");
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile;
        private volatile /* synthetic */ Object _rootCause$volatile;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NodeList f140981a;

        public Finishing(NodeList nodeList, boolean z2, Throwable th) {
            this.f140981a = nodeList;
            this._isCompleting$volatile = z2 ? 1 : 0;
            this._rootCause$volatile = th;
        }

        private final ArrayList c() {
            return new ArrayList(4);
        }

        private final Object d() {
            return f140980d.get(this);
        }

        private final void n(Object obj) {
            f140980d.set(this, obj);
        }

        @Override // kotlinx.coroutines.Incomplete
        public NodeList a() {
            return this.f140981a;
        }

        public final void b(Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                o(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                n(th);
                return;
            }
            if (objD instanceof Throwable) {
                if (th == objD) {
                    return;
                }
                ArrayList arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th);
                n(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        public final Throwable e() {
            return (Throwable) f140979c.get(this);
        }

        public final boolean i() {
            return e() != null;
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            return e() == null;
        }

        public final boolean j() {
            return f140978b.get(this) != 0;
        }

        public final boolean k() {
            return d() == JobSupportKt.f140998e;
        }

        public final List l(Throwable th) {
            ArrayList arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th != null && !Intrinsics.areEqual(th, thE)) {
                arrayListC.add(th);
            }
            n(JobSupportKt.f140998e);
            return arrayListC;
        }

        public final void m(boolean z2) {
            f140978b.set(this, z2 ? 1 : 0);
        }

        public final void o(Throwable th) {
            f140979c.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + i() + ", completing=" + j() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + a() + ']';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class SelectOnAwaitCompletionHandler extends JobNode {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final SelectInstance f140982f;

        public SelectOnAwaitCompletionHandler(SelectInstance selectInstance) {
            this.f140982f = selectInstance;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void v(Throwable th) {
            Object objQ0 = JobSupport.this.q0();
            if (!(objQ0 instanceof CompletedExceptionally)) {
                objQ0 = JobSupportKt.h(objQ0);
            }
            this.f140982f.f(JobSupport.this, objQ0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class SelectOnJoinCompletionHandler extends JobNode {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final SelectInstance f140984f;

        public SelectOnJoinCompletionHandler(SelectInstance selectInstance) {
            this.f140984f = selectInstance;
        }

        @Override // kotlinx.coroutines.JobNode
        public boolean u() {
            return false;
        }

        @Override // kotlinx.coroutines.JobNode
        public void v(Throwable th) {
            this.f140984f.f(JobSupport.this, Unit.f139807a);
        }
    }

    public JobSupport(boolean z2) {
        this._state$volatile = z2 ? JobSupportKt.f141000g : JobSupportKt.f140999f;
    }

    private final Object A0(Object obj) throws Throwable {
        Throwable thG0 = null;
        while (true) {
            Object objQ0 = q0();
            if (objQ0 instanceof Finishing) {
                synchronized (objQ0) {
                    if (((Finishing) objQ0).k()) {
                        return JobSupportKt.f140997d;
                    }
                    boolean zI = ((Finishing) objQ0).i();
                    if (obj != null || !zI) {
                        if (thG0 == null) {
                            thG0 = g0(obj);
                        }
                        ((Finishing) objQ0).b(thG0);
                    }
                    Throwable thE = zI ? null : ((Finishing) objQ0).e();
                    if (thE != null) {
                        F0(((Finishing) objQ0).a(), thE);
                    }
                    return JobSupportKt.f140994a;
                }
            }
            if (!(objQ0 instanceof Incomplete)) {
                return JobSupportKt.f140997d;
            }
            if (thG0 == null) {
                thG0 = g0(obj);
            }
            Incomplete incomplete = (Incomplete) objQ0;
            if (!incomplete.isActive()) {
                Object objY0 = Y0(objQ0, new CompletedExceptionally(thG0, false, 2, null));
                if (objY0 == JobSupportKt.f140994a) {
                    throw new IllegalStateException(("Cannot happen in " + objQ0).toString());
                }
                if (objY0 != JobSupportKt.f140996c) {
                    return objY0;
                }
            } else if (X0(incomplete, thG0)) {
                return JobSupportKt.f140994a;
            }
        }
    }

    private final ChildHandleNode E0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.p()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.l();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.k();
            if (!lockFreeLinkedListNode.p()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    private final void F0(NodeList nodeList, Throwable th) throws Throwable {
        J0(th);
        nodeList.f(4);
        Object objJ = nodeList.j();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeK = (LockFreeLinkedListNode) objJ; !Intrinsics.areEqual(lockFreeLinkedListNodeK, nodeList); lockFreeLinkedListNodeK = lockFreeLinkedListNodeK.k()) {
            if ((lockFreeLinkedListNodeK instanceof JobNode) && ((JobNode) lockFreeLinkedListNodeK).u()) {
                try {
                    ((JobNode) lockFreeLinkedListNodeK).v(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNodeK + " for " + this, th2);
                        Unit unit = Unit.f139807a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            u0(completionHandlerException);
        }
        a0(th);
    }

    private final void G0(NodeList nodeList, Throwable th) throws Throwable {
        nodeList.f(1);
        Object objJ = nodeList.j();
        Intrinsics.checkNotNull(objJ, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNodeK = (LockFreeLinkedListNode) objJ; !Intrinsics.areEqual(lockFreeLinkedListNodeK, nodeList); lockFreeLinkedListNodeK = lockFreeLinkedListNodeK.k()) {
            if (lockFreeLinkedListNodeK instanceof JobNode) {
                try {
                    ((JobNode) lockFreeLinkedListNodeK).v(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        kotlin.ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNodeK + " for " + this, th2);
                        Unit unit = Unit.f139807a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            u0(completionHandlerException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H0(Object obj, Object obj2) throws Throwable {
        if (obj2 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) obj2).f140908a;
        }
        return obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(SelectInstance selectInstance, Object obj) {
        Object objQ0;
        do {
            objQ0 = q0();
            if (!(objQ0 instanceof Incomplete)) {
                if (!(objQ0 instanceof CompletedExceptionally)) {
                    objQ0 = JobSupportKt.h(objQ0);
                }
                selectInstance.d(objQ0);
                return;
            }
        } while (R0(objQ0) < 0);
        selectInstance.e(JobKt__JobKt.o(this, false, new SelectOnAwaitCompletionHandler(selectInstance), 1, null));
    }

    private final void M0(Empty empty) {
        NodeList nodeList = new NodeList();
        Object inactiveNodeList = nodeList;
        if (!empty.isActive()) {
            inactiveNodeList = new InactiveNodeList(nodeList);
        }
        androidx.concurrent.futures.a.a(f140971a, this, empty, inactiveNodeList);
    }

    private final void N0(JobNode jobNode) {
        jobNode.e(new NodeList());
        androidx.concurrent.futures.a.a(f140971a, this, jobNode, jobNode.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(SelectInstance selectInstance, Object obj) {
        if (y0()) {
            selectInstance.e(JobKt__JobKt.o(this, false, new SelectOnJoinCompletionHandler(selectInstance), 1, null));
        } else {
            selectInstance.d(Unit.f139807a);
        }
    }

    private final void P(Throwable th, List list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                kotlin.ExceptionsKt.a(th, th2);
            }
        }
    }

    private final int R0(Object obj) {
        if (obj instanceof Empty) {
            if (((Empty) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f140971a, this, obj, JobSupportKt.f141000g)) {
                return -1;
            }
            L0();
            return 1;
        }
        if (!(obj instanceof InactiveNodeList)) {
            return 0;
        }
        if (!androidx.concurrent.futures.a.a(f140971a, this, obj, ((InactiveNodeList) obj).a())) {
            return -1;
        }
        L0();
        return 1;
    }

    private final Object U(Continuation continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.c(continuation), this);
        awaitContinuation.C();
        CancellableContinuationKt.a(awaitContinuation, JobKt__JobKt.o(this, false, new ResumeAwaitOnCompletion(awaitContinuation), 1, null));
        Object objV = awaitContinuation.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public static /* synthetic */ CancellationException U0(JobSupport jobSupport, Throwable th, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i3 & 1) != 0) {
            str = null;
        }
        return jobSupport.T0(th, str);
    }

    private final boolean W0(Incomplete incomplete, Object obj) throws Throwable {
        if (!androidx.concurrent.futures.a.a(f140971a, this, incomplete, JobSupportKt.g(obj))) {
            return false;
        }
        J0(null);
        K0(obj);
        d0(incomplete, obj);
        return true;
    }

    private final boolean X0(Incomplete incomplete, Throwable th) throws Throwable {
        NodeList nodeListO0 = o0(incomplete);
        if (nodeListO0 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f140971a, this, incomplete, new Finishing(nodeListO0, false, th))) {
            return false;
        }
        F0(nodeListO0, th);
        return true;
    }

    private final Object Y0(Object obj, Object obj2) {
        return !(obj instanceof Incomplete) ? JobSupportKt.f140994a : ((!(obj instanceof Empty) && !(obj instanceof JobNode)) || (obj instanceof ChildHandleNode) || (obj2 instanceof CompletedExceptionally)) ? Z0((Incomplete) obj, obj2) : W0((Incomplete) obj, obj2) ? obj2 : JobSupportKt.f140996c;
    }

    private final Object Z(Object obj) {
        Object objY0;
        do {
            Object objQ0 = q0();
            if (!(objQ0 instanceof Incomplete) || ((objQ0 instanceof Finishing) && ((Finishing) objQ0).j())) {
                return JobSupportKt.f140994a;
            }
            objY0 = Y0(objQ0, new CompletedExceptionally(g0(obj), false, 2, null));
        } while (objY0 == JobSupportKt.f140996c);
        return objY0;
    }

    private final Object Z0(Incomplete incomplete, Object obj) throws Throwable {
        NodeList nodeListO0 = o0(incomplete);
        if (nodeListO0 == null) {
            return JobSupportKt.f140996c;
        }
        Finishing finishing = incomplete instanceof Finishing ? (Finishing) incomplete : null;
        if (finishing == null) {
            finishing = new Finishing(nodeListO0, false, null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (finishing) {
            if (finishing.j()) {
                return JobSupportKt.f140994a;
            }
            finishing.m(true);
            if (finishing != incomplete && !androidx.concurrent.futures.a.a(f140971a, this, incomplete, finishing)) {
                return JobSupportKt.f140996c;
            }
            boolean zI = finishing.i();
            CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
            if (completedExceptionally != null) {
                finishing.b(completedExceptionally.f140908a);
            }
            Throwable thE = zI ? null : finishing.e();
            objectRef.f140144a = thE;
            Unit unit = Unit.f139807a;
            if (thE != null) {
                F0(nodeListO0, thE);
            }
            ChildHandleNode childHandleNodeE0 = E0(nodeListO0);
            if (childHandleNodeE0 != null && a1(finishing, childHandleNodeE0, obj)) {
                return JobSupportKt.f140995b;
            }
            nodeListO0.f(2);
            ChildHandleNode childHandleNodeE02 = E0(nodeListO0);
            return (childHandleNodeE02 == null || !a1(finishing, childHandleNodeE02, obj)) ? h0(finishing, obj) : JobSupportKt.f140995b;
        }
    }

    private final boolean a0(Throwable th) {
        if (x0()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        ChildHandle childHandleP0 = p0();
        return (childHandleP0 == null || childHandleP0 == NonDisposableHandle.f141004a) ? z2 : childHandleP0.b(th) || z2;
    }

    private final boolean a1(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (JobKt.n(childHandleNode.f140901f, false, new ChildCompletion(this, finishing, childHandleNode, obj)) == NonDisposableHandle.f141004a) {
            childHandleNode = E0(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    private final void d0(Incomplete incomplete, Object obj) throws Throwable {
        ChildHandle childHandleP0 = p0();
        if (childHandleP0 != null) {
            childHandleP0.dispose();
            Q0(NonDisposableHandle.f141004a);
        }
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f140908a : null;
        if (!(incomplete instanceof JobNode)) {
            NodeList nodeListA = incomplete.a();
            if (nodeListA != null) {
                G0(nodeListA, th);
                return;
            }
            return;
        }
        try {
            ((JobNode) incomplete).v(th);
        } catch (Throwable th2) {
            u0(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        ChildHandleNode childHandleNodeE0 = E0(childHandleNode);
        if (childHandleNodeE0 == null || !a1(finishing, childHandleNodeE0, obj)) {
            finishing.a().f(2);
            ChildHandleNode childHandleNodeE02 = E0(childHandleNode);
            if (childHandleNodeE02 == null || !a1(finishing, childHandleNodeE02, obj)) {
                S(h0(finishing, obj));
            }
        }
    }

    private final Throwable g0(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(b0(), null, this) : th;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).K();
    }

    private final Object h0(Finishing finishing, Object obj) throws Throwable {
        boolean zI;
        Throwable thK0;
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        Throwable th = completedExceptionally != null ? completedExceptionally.f140908a : null;
        synchronized (finishing) {
            zI = finishing.i();
            List listL = finishing.l(th);
            thK0 = k0(finishing, listL);
            if (thK0 != null) {
                P(thK0, listL);
            }
        }
        if (thK0 != null && thK0 != th) {
            obj = new CompletedExceptionally(thK0, false, 2, null);
        }
        if (thK0 != null && (a0(thK0) || t0(thK0))) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((CompletedExceptionally) obj).c();
        }
        if (!zI) {
            J0(thK0);
        }
        K0(obj);
        androidx.concurrent.futures.a.a(f140971a, this, finishing, JobSupportKt.g(obj));
        d0(finishing, obj);
        return obj;
    }

    private final Throwable j0(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f140908a;
        }
        return null;
    }

    private final Throwable k0(Finishing finishing, List list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (finishing.i()) {
                return new JobCancellationException(b0(), null, this);
            }
            return null;
        }
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = (Throwable) list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final NodeList o0(Incomplete incomplete) {
        NodeList nodeListA = incomplete.a();
        if (nodeListA != null) {
            return nodeListA;
        }
        if (incomplete instanceof Empty) {
            return new NodeList();
        }
        if (incomplete instanceof JobNode) {
            N0((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    private final boolean y0() {
        Object objQ0;
        do {
            objQ0 = q0();
            if (!(objQ0 instanceof Incomplete)) {
                return false;
            }
        } while (R0(objQ0) < 0);
        return true;
    }

    private final Object z0(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        CancellableContinuationKt.a(cancellableContinuationImpl, JobKt__JobKt.o(this, false, new ResumeOnCompletion(cancellableContinuationImpl), 1, null));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    public final boolean B0(Object obj) {
        Object objY0;
        do {
            objY0 = Y0(q0(), obj);
            if (objY0 == JobSupportKt.f140994a) {
                return false;
            }
            if (objY0 == JobSupportKt.f140995b) {
                return true;
            }
        } while (objY0 == JobSupportKt.f140996c);
        S(objY0);
        return true;
    }

    public final Object C0(Object obj) {
        Object objY0;
        do {
            objY0 = Y0(q0(), obj);
            if (objY0 == JobSupportKt.f140994a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, j0(obj));
            }
        } while (objY0 == JobSupportKt.f140996c);
        return objY0;
    }

    public String D0() {
        return DebugStringsKt.a(this);
    }

    protected void J0(Throwable th) {
    }

    @Override // kotlinx.coroutines.ParentJob
    public CancellationException K() {
        Throwable thE;
        Object objQ0 = q0();
        if (objQ0 instanceof Finishing) {
            thE = ((Finishing) objQ0).e();
        } else if (objQ0 instanceof CompletedExceptionally) {
            thE = ((CompletedExceptionally) objQ0).f140908a;
        } else {
            if (objQ0 instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objQ0).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + S0(objQ0), thE, this);
    }

    protected void K0(Object obj) {
    }

    protected void L0() {
    }

    public final void P0(JobNode jobNode) {
        Object objQ0;
        do {
            objQ0 = q0();
            if (!(objQ0 instanceof JobNode)) {
                if (!(objQ0 instanceof Incomplete) || ((Incomplete) objQ0).a() == null) {
                    return;
                }
                jobNode.q();
                return;
            }
            if (objQ0 != jobNode) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f140971a, this, objQ0, JobSupportKt.f141000g));
    }

    public final void Q0(ChildHandle childHandle) {
        f140972b.set(this, childHandle);
    }

    protected void S(Object obj) {
    }

    protected final Object T(Continuation continuation) throws Throwable {
        Object objQ0;
        do {
            objQ0 = q0();
            if (!(objQ0 instanceof Incomplete)) {
                if (objQ0 instanceof CompletedExceptionally) {
                    throw ((CompletedExceptionally) objQ0).f140908a;
                }
                return JobSupportKt.h(objQ0);
            }
        } while (R0(objQ0) < 0);
        return U(continuation);
    }

    protected final CancellationException T0(Throwable th, String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = b0();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    public final String V0() {
        return D0() + '{' + S0(q0()) + '}';
    }

    public final boolean W(Throwable th) {
        return X(th);
    }

    public final boolean X(Object obj) throws Throwable {
        Object objA0 = JobSupportKt.f140994a;
        if (n0() && (objA0 = Z(obj)) == JobSupportKt.f140995b) {
            return true;
        }
        if (objA0 == JobSupportKt.f140994a) {
            objA0 = A0(obj);
        }
        if (objA0 == JobSupportKt.f140994a || objA0 == JobSupportKt.f140995b) {
            return true;
        }
        if (objA0 == JobSupportKt.f140997d) {
            return false;
        }
        S(objA0);
        return true;
    }

    public void Y(Throwable th) throws Throwable {
        X(th);
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob childJob) {
        ChildHandleNode childHandleNode = new ChildHandleNode(childJob);
        childHandleNode.w(this);
        while (true) {
            Object objQ0 = q0();
            if (objQ0 instanceof Empty) {
                Empty empty = (Empty) objQ0;
                if (!empty.isActive()) {
                    M0(empty);
                } else if (androidx.concurrent.futures.a.a(f140971a, this, objQ0, childHandleNode)) {
                    return childHandleNode;
                }
            } else {
                if (!(objQ0 instanceof Incomplete)) {
                    Object objQ02 = q0();
                    CompletedExceptionally completedExceptionally = objQ02 instanceof CompletedExceptionally ? (CompletedExceptionally) objQ02 : null;
                    childHandleNode.v(completedExceptionally != null ? completedExceptionally.f140908a : null);
                    return NonDisposableHandle.f141004a;
                }
                NodeList nodeListA = ((Incomplete) objQ0).a();
                if (nodeListA != null) {
                    if (!nodeListA.c(childHandleNode, 7)) {
                        boolean zC = nodeListA.c(childHandleNode, 3);
                        Object objQ03 = q0();
                        if (objQ03 instanceof Finishing) {
                            thE = ((Finishing) objQ03).e();
                        } else {
                            CompletedExceptionally completedExceptionally2 = objQ03 instanceof CompletedExceptionally ? (CompletedExceptionally) objQ03 : null;
                            if (completedExceptionally2 != null) {
                                thE = completedExceptionally2.f140908a;
                            }
                        }
                        childHandleNode.v(thE);
                        if (!zC) {
                            return NonDisposableHandle.f141004a;
                        }
                    }
                    return childHandleNode;
                }
                Intrinsics.checkNotNull(objQ0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                N0((JobNode) objQ0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b0() {
        return "Job was cancelled";
    }

    public boolean c0(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return X(th) && l0();
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return Job.DefaultImpls.c(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return Job.DefaultImpls.d(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        Object objQ0 = q0();
        if (!(objQ0 instanceof Finishing)) {
            if (objQ0 instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objQ0 instanceof CompletedExceptionally) {
                return U0(this, ((CompletedExceptionally) objQ0).f140908a, null, 1, null);
            }
            return new JobCancellationException(DebugStringsKt.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((Finishing) objQ0).e();
        if (thE != null) {
            CancellationException cancellationExceptionT0 = T0(thE, DebugStringsKt.a(this) + " is cancelling");
            if (cancellationExceptionT0 != null) {
                return cancellationExceptionT0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence getChildren() {
        return SequencesKt.b(new JobSupport$children$1(this, null));
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object objQ0 = q0();
        if (objQ0 instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        return j0(objQ0);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.v8;
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        JobSupport$onJoin$1 jobSupport$onJoin$1 = JobSupport$onJoin$1.f140993a;
        Intrinsics.checkNotNull(jobSupport$onJoin$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        return new SelectClause0Impl(this, (Function3) TypeIntrinsics.f(jobSupport$onJoin$1, 3), null, 4, null);
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        ChildHandle childHandleP0 = p0();
        if (childHandleP0 != null) {
            return childHandleP0.getParent();
        }
        return null;
    }

    public final Object i0() throws Throwable {
        Object objQ0 = q0();
        if (objQ0 instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        }
        if (objQ0 instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) objQ0).f140908a;
        }
        return JobSupportKt.h(objQ0);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1 function1) {
        return w0(true, new InvokeOnCompletion(function1));
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object objQ0 = q0();
        return (objQ0 instanceof Incomplete) && ((Incomplete) objQ0).isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object objQ0 = q0();
        if (objQ0 instanceof CompletedExceptionally) {
            return true;
        }
        return (objQ0 instanceof Finishing) && ((Finishing) objQ0).i();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(q0() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation continuation) {
        if (y0()) {
            Object objZ0 = z0(continuation);
            return objZ0 == IntrinsicsKt.f() ? objZ0 : Unit.f139807a;
        }
        JobKt.k(continuation.getContext());
        return Unit.f139807a;
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void l(ParentJob parentJob) throws Throwable {
        X(parentJob);
    }

    public boolean l0() {
        return true;
    }

    protected final SelectClause1 m0() {
        JobSupport$onAwaitInternal$1 jobSupport$onAwaitInternal$1 = JobSupport$onAwaitInternal$1.f140991a;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.f(jobSupport$onAwaitInternal$1, 3);
        JobSupport$onAwaitInternal$2 jobSupport$onAwaitInternal$2 = JobSupport$onAwaitInternal$2.f140992a;
        Intrinsics.checkNotNull(jobSupport$onAwaitInternal$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.f(jobSupport$onAwaitInternal$2, 3), null, 8, null);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return Job.DefaultImpls.e(this, key);
    }

    public boolean n0() {
        return false;
    }

    public final ChildHandle p0() {
        return (ChildHandle) f140972b.get(this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return Job.DefaultImpls.f(this, coroutineContext);
    }

    public final Object q0() {
        return f140971a.get(this);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int iR0;
        do {
            iR0 = R0(q0());
            if (iR0 == 0) {
                return false;
            }
        } while (iR0 != 1);
        return true;
    }

    protected boolean t0(Throwable th) {
        return false;
    }

    public String toString() {
        return V0() + '@' + DebugStringsKt.b(this);
    }

    public void u0(Throwable th) throws Throwable {
        throw th;
    }

    protected final void v0(Job job) {
        if (job == null) {
            Q0(NonDisposableHandle.f141004a);
            return;
        }
        job.start();
        ChildHandle childHandleAttachChild = job.attachChild(this);
        Q0(childHandleAttachChild);
        if (isCompleted()) {
            childHandleAttachChild.dispose();
            Q0(NonDisposableHandle.f141004a);
        }
    }

    public final DisposableHandle w0(boolean z2, JobNode jobNode) {
        boolean z3;
        boolean zC;
        jobNode.w(this);
        while (true) {
            Object objQ0 = q0();
            z3 = true;
            if (!(objQ0 instanceof Empty)) {
                if (!(objQ0 instanceof Incomplete)) {
                    z3 = false;
                    break;
                }
                Incomplete incomplete = (Incomplete) objQ0;
                NodeList nodeListA = incomplete.a();
                if (nodeListA == null) {
                    Intrinsics.checkNotNull(objQ0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    N0((JobNode) objQ0);
                } else {
                    if (jobNode.u()) {
                        Finishing finishing = incomplete instanceof Finishing ? (Finishing) incomplete : null;
                        Throwable thE = finishing != null ? finishing.e() : null;
                        if (thE != null) {
                            if (z2) {
                                jobNode.v(thE);
                            }
                            return NonDisposableHandle.f141004a;
                        }
                        zC = nodeListA.c(jobNode, 5);
                    } else {
                        zC = nodeListA.c(jobNode, 1);
                    }
                    if (zC) {
                        break;
                    }
                }
            } else {
                Empty empty = (Empty) objQ0;
                if (!empty.isActive()) {
                    M0(empty);
                } else if (androidx.concurrent.futures.a.a(f140971a, this, objQ0, jobNode)) {
                    break;
                }
            }
        }
        if (z3) {
            return jobNode;
        }
        if (z2) {
            Object objQ02 = q0();
            CompletedExceptionally completedExceptionally = objQ02 instanceof CompletedExceptionally ? (CompletedExceptionally) objQ02 : null;
            jobNode.v(completedExceptionally != null ? completedExceptionally.f140908a : null);
        }
        return NonDisposableHandle.f141004a;
    }

    protected boolean x0() {
        return false;
    }

    private final String S0(Object obj) {
        boolean z2 = obj instanceof Finishing;
        String str = QaXmqxvjHhxVy.MYIgzEQMRvNAUQ;
        if (!z2) {
            return obj instanceof Incomplete ? ((Incomplete) obj).isActive() ? str : "New" : obj instanceof CompletedExceptionally ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
        Finishing finishing = (Finishing) obj;
        return finishing.i() ? "Cancelling" : finishing.j() ? "Completing" : str;
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable th) throws Throwable {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = U0(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(b0(), null, this);
        }
        Y(jobCancellationException);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public Job plus(Job job) {
        return Job.DefaultImpls.g(this, job);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean z2, boolean z3, Function1 function1) {
        JobNode invokeOnCompletion;
        if (z2) {
            invokeOnCompletion = new InvokeOnCancelling(function1);
        } else {
            invokeOnCompletion = new InvokeOnCompletion(function1);
        }
        return w0(z3, invokeOnCompletion);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(b0(), null, this);
        }
        Y(cancellationException);
    }
}
