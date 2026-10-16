package kotlinx.coroutines.selects;

import androidx.concurrent.futures.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;

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
@Metadata
public class SelectImplementation<R> implements CancelHandler, SelectBuilder<R>, SelectInstanceInternal<R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f142583g = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f142584a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f142586c;
    private volatile /* synthetic */ Object state$volatile = SelectKt.f142606b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f142585b = new ArrayList(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f142587d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f142588f = SelectKt.f142609e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class ClauseData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f142589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function3 f142590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Function3 f142591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f142592d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f142593e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function3 f142594f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Object f142595g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f142596h = -1;

        public ClauseData(Object obj, Function3 function3, Function3 function32, Object obj2, Object obj3, Function3 function33) {
            this.f142589a = obj;
            this.f142590b = function3;
            this.f142591c = function32;
            this.f142592d = obj2;
            this.f142593e = obj3;
            this.f142594f = function33;
        }

        public final Function3 a(SelectInstance selectInstance, Object obj) {
            Function3 function3 = this.f142594f;
            if (function3 != null) {
                return (Function3) function3.invoke(selectInstance, this.f142592d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f142595g;
            SelectImplementation selectImplementation = SelectImplementation.this;
            if (obj instanceof Segment) {
                ((Segment) obj).s(this.f142596h, null, selectImplementation.getContext());
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Object c(Object obj, Continuation continuation) {
            Object obj2 = this.f142593e;
            if (this.f142592d == SelectKt.i()) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj2).invoke(continuation);
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj2).invoke(obj, continuation);
        }

        public final Object d(Object obj) {
            return this.f142591c.invoke(this.f142589a, this.f142592d, obj);
        }

        public final boolean e(SelectImplementation selectImplementation) {
            this.f142590b.invoke(this.f142589a, selectImplementation, this.f142592d);
            return selectImplementation.f142588f == SelectKt.f142609e;
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.f142584a = coroutineContext;
    }

    private final int A(Object obj, Object obj2) {
        while (true) {
            Object obj3 = f142583g.get(this);
            if (obj3 instanceof CancellableContinuation) {
                ClauseData clauseDataS = s(obj);
                if (clauseDataS == null) {
                    continue;
                } else {
                    Function3 function3A = clauseDataS.a(this, obj2);
                    if (a.a(f142583g, this, obj3, clauseDataS)) {
                        this.f142588f = obj2;
                        if (SelectKt.j((CancellableContinuation) obj3, function3A)) {
                            return 0;
                        }
                        this.f142588f = SelectKt.f142609e;
                        return 2;
                    }
                }
            } else {
                if (Intrinsics.areEqual(obj3, SelectKt.f142607c) || (obj3 instanceof ClauseData)) {
                    return 3;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.f142608d)) {
                    return 2;
                }
                if (Intrinsics.areEqual(obj3, SelectKt.f142606b)) {
                    if (a.a(f142583g, this, obj3, CollectionsKt.listOf(obj))) {
                        return 1;
                    }
                } else {
                    if (!(obj3 instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                    }
                    if (a.a(f142583g, this, obj3, CollectionsKt.plus((Collection<? extends Object>) obj3, obj))) {
                        return 1;
                    }
                }
            }
        }
    }

    private final void m(Object obj) {
        List list = this.f142585b;
        Intrinsics.checkNotNull(list);
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (((ClauseData) it.next()).f142589a == obj) {
                throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
            }
        }
    }

    private final void n(ClauseData clauseData) {
        List<ClauseData> list = this.f142585b;
        if (list == null) {
            return;
        }
        for (ClauseData clauseData2 : list) {
            if (clauseData2 != clauseData) {
                clauseData2.b();
            }
        }
        f142583g.set(this, SelectKt.f142607c);
        this.f142588f = SelectKt.f142609e;
        this.f142585b = null;
    }

    private final Object o(Continuation continuation) {
        Object obj = f142583g.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.f142588f;
        n(clauseData);
        return clauseData.c(clauseData.d(obj2), continuation);
    }

    static /* synthetic */ Object q(SelectImplementation selectImplementation, Continuation continuation) {
        return selectImplementation.u() ? selectImplementation.o(continuation) : selectImplementation.r(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.f142601d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f142601d = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f142599b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f142601d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r6)
            return r6
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.f142598a
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2
            kotlin.ResultKt.b(r6)
            goto L4b
        L3c:
            kotlin.ResultKt.b(r6)
            r0.f142598a = r5
            r0.f142601d = r4
            java.lang.Object r6 = r5.B(r0)
            if (r6 != r1) goto L4a
            goto L56
        L4a:
            r2 = r5
        L4b:
            r6 = 0
            r0.f142598a = r6
            r0.f142601d = r3
            java.lang.Object r6 = r2.o(r0)
            if (r6 != r1) goto L57
        L56:
            return r1
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final ClauseData s(Object obj) {
        List list = this.f142585b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).f142589a == obj) {
                obj2 = next;
                break;
            }
        }
        ClauseData clauseData = (ClauseData) obj2;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater t() {
        return f142583g;
    }

    private final boolean u() {
        return f142583g.get(this) instanceof ClauseData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object v(kotlinx.coroutines.selects.SelectImplementation.ClauseData r5, java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r0
            int r1 = r0.f142604c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f142604c = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f142602a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f142604c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            return r7
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            java.lang.Object r6 = r5.d(r6)
            r0.f142604c = r3
            java.lang.Object r5 = r5.c(r6, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.v(kotlinx.coroutines.selects.SelectImplementation$ClauseData, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void x(SelectImplementation selectImplementation, ClauseData clauseData, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        selectImplementation.w(clauseData, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(Object obj) {
        ClauseData clauseDataS = s(obj);
        Intrinsics.checkNotNull(clauseDataS);
        clauseDataS.f142595g = null;
        clauseDataS.f142596h = -1;
        w(clauseDataS, true);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void a(SelectClause0 selectClause0, Function1 function1) {
        x(this, new ClauseData(selectClause0.d(), selectClause0.a(), selectClause0.c(), SelectKt.i(), function1, selectClause0.b()), false, 1, null);
    }

    @Override // kotlinx.coroutines.Waiter
    public void b(Segment segment, int i3) {
        this.f142586c = segment;
        this.f142587d = i3;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void c(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f142583g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.f142607c) {
                return;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, obj, SelectKt.f142608d));
        List list = this.f142585b;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((ClauseData) it.next()).b();
        }
        this.f142588f = SelectKt.f142609e;
        this.f142585b = null;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void d(Object obj) {
        this.f142588f = obj;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void e(DisposableHandle disposableHandle) {
        this.f142586c = disposableHandle;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean f(Object obj, Object obj2) {
        return A(obj, obj2) == 0;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void g(SelectClause1 selectClause1, Function2 function2) {
        x(this, new ClauseData(selectClause1.d(), selectClause1.a(), selectClause1.c(), null, function2, selectClause1.b()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public CoroutineContext getContext() {
        return this.f142584a;
    }

    public Object p(Continuation continuation) {
        return q(this, continuation);
    }

    public final void w(ClauseData clauseData, boolean z2) {
        if (f142583g.get(this) instanceof ClauseData) {
            return;
        }
        if (!z2) {
            m(clauseData.f142589a);
        }
        if (!clauseData.e(this)) {
            f142583g.set(this, clauseData);
            return;
        }
        if (!z2) {
            List list = this.f142585b;
            Intrinsics.checkNotNull(list);
            list.add(clauseData);
        }
        clauseData.f142595g = this.f142586c;
        clauseData.f142596h = this.f142587d;
        this.f142586c = null;
        this.f142587d = -1;
    }

    public final TrySelectDetailedResult z(Object obj, Object obj2) {
        return SelectKt.a(A(obj, obj2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
    
        r0 = r0.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.f()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.c(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.f()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        return kotlin.Unit.f139807a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object B(kotlin.coroutines.Continuation r6) {
        /*
            r5 = this;
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r6)
            r2 = 1
            r0.<init>(r1, r2)
            r0.C()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = j()
        L11:
            java.lang.Object r2 = r1.get(r5)
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.selects.SelectKt.g()
            if (r2 != r3) goto L29
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = j()
            boolean r2 = androidx.concurrent.futures.a.a(r3, r5, r2, r0)
            if (r2 == 0) goto L11
            kotlinx.coroutines.CancellableContinuationKt.c(r0, r5)
            goto L62
        L29:
            boolean r3 = r2 instanceof java.util.List
            if (r3 == 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = j()
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.selects.SelectKt.g()
            boolean r3 = androidx.concurrent.futures.a.a(r3, r5, r2, r4)
            if (r3 == 0) goto L11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L41:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L11
            java.lang.Object r3 = r2.next()
            l(r5, r3)
            goto L41
        L4f:
            boolean r1 = r2 instanceof kotlinx.coroutines.selects.SelectImplementation.ClauseData
            if (r1 == 0) goto L79
            kotlin.Unit r1 = kotlin.Unit.f139807a
            kotlinx.coroutines.selects.SelectImplementation$ClauseData r2 = (kotlinx.coroutines.selects.SelectImplementation.ClauseData) r2
            java.lang.Object r3 = i(r5)
            kotlin.jvm.functions.Function3 r2 = r2.a(r5, r3)
            r0.H(r1, r2)
        L62:
            java.lang.Object r0 = r0.v()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r0 != r1) goto L6f
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r6)
        L6f:
            java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r0 != r6) goto L76
            return r0
        L76:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L79:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.String r1 = com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH.seP
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.B(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
