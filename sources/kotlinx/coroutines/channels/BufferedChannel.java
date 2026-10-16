package kotlinx.coroutines.channels;

import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

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
public class BufferedChannel<E> implements Channel<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f141067d = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f141068f = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f141069g = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f141070h = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f141071i = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f141072j = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f141073k = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f141074l = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f141075m = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f141076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f141077b;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function3 f141078c;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f141079a = BufferedChannelKt.f141119p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CancellableContinuationImpl f141080b;

        public BufferedChannelIterator() {
        }

        private final Object f(ChannelSegment channelSegment, int i3, long j3, Continuation continuation) throws Throwable {
            Boolean boolA;
            Function1 function1;
            ChannelSegment channelSegmentG0;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl cancellableContinuationImplB = CancellableContinuationKt.b(IntrinsicsKt.c(continuation));
            try {
                this.f141080b = cancellableContinuationImplB;
                try {
                    Object objB1 = bufferedChannel.B1(channelSegment, i3, j3, this);
                    if (objB1 == BufferedChannelKt.f141116m) {
                        bufferedChannel.a1(this, channelSegment, i3);
                    } else {
                        Function3 function3R = null;
                        if (objB1 == BufferedChannelKt.f141118o) {
                            if (j3 < bufferedChannel.v0()) {
                                channelSegment.b();
                            }
                            ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.p0().get(bufferedChannel);
                            while (true) {
                                if (bufferedChannel.D0()) {
                                    h();
                                    break;
                                }
                                long andIncrement = BufferedChannel.q0().getAndIncrement(bufferedChannel);
                                int i4 = BufferedChannelKt.f141105b;
                                long j4 = andIncrement / ((long) i4);
                                int i5 = (int) (andIncrement % ((long) i4));
                                if (channelSegment2.f142482c != j4) {
                                    channelSegmentG0 = bufferedChannel.g0(j4, channelSegment2);
                                    if (channelSegmentG0 == null) {
                                    }
                                } else {
                                    channelSegmentG0 = channelSegment2;
                                }
                                objB1 = bufferedChannel.B1(channelSegmentG0, i5, andIncrement, this);
                                if (objB1 == BufferedChannelKt.f141116m) {
                                    bufferedChannel.a1(this, channelSegmentG0, i5);
                                    break;
                                }
                                if (objB1 == BufferedChannelKt.f141118o) {
                                    if (andIncrement < bufferedChannel.v0()) {
                                        channelSegmentG0.b();
                                    }
                                    channelSegment2 = channelSegmentG0;
                                } else {
                                    if (objB1 == BufferedChannelKt.f141117n) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    channelSegmentG0.b();
                                    this.f141079a = objB1;
                                    this.f141080b = null;
                                    boolA = Boxing.a(true);
                                    function1 = bufferedChannel.f141077b;
                                    if (function1 != null) {
                                    }
                                }
                            }
                            cancellableContinuationImplB.H(boolA, function3R);
                        } else {
                            channelSegment.b();
                            this.f141079a = objB1;
                            this.f141080b = null;
                            boolA = Boxing.a(true);
                            function1 = bufferedChannel.f141077b;
                            if (function1 != null) {
                                function3R = bufferedChannel.R(function1, objB1);
                            }
                            cancellableContinuationImplB.H(boolA, function3R);
                        }
                    }
                    Object objV = cancellableContinuationImplB.v();
                    if (objV == IntrinsicsKt.f()) {
                        DebugProbesKt.c(continuation);
                    }
                    return objV;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    cancellableContinuationImplB.M();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private final boolean g() throws Throwable {
            this.f141079a = BufferedChannelKt.z();
            Throwable thL0 = BufferedChannel.this.l0();
            if (thL0 == null) {
                return false;
            }
            throw StackTraceRecoveryKt.a(thL0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            CancellableContinuationImpl cancellableContinuationImpl = this.f141080b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.f141080b = null;
            this.f141079a = BufferedChannelKt.z();
            Throwable thL0 = BufferedChannel.this.l0();
            if (thL0 == null) {
                Result.Companion companion = Result.f139772b;
                cancellableContinuationImpl.resumeWith(Result.b(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.f139772b;
                cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(thL0)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object a(Continuation continuation) throws Throwable {
            ChannelSegment channelSegmentG0;
            boolean zG = true;
            if (this.f141079a == BufferedChannelKt.f141119p || this.f141079a == BufferedChannelKt.z()) {
                BufferedChannel bufferedChannel = BufferedChannel.this;
                ChannelSegment channelSegment = (ChannelSegment) BufferedChannel.p0().get(bufferedChannel);
                while (!bufferedChannel.D0()) {
                    long andIncrement = BufferedChannel.q0().getAndIncrement(bufferedChannel);
                    int i3 = BufferedChannelKt.f141105b;
                    long j3 = andIncrement / ((long) i3);
                    int i4 = (int) (andIncrement % ((long) i3));
                    if (channelSegment.f142482c != j3) {
                        channelSegmentG0 = bufferedChannel.g0(j3, channelSegment);
                        if (channelSegmentG0 == null) {
                            continue;
                        }
                    } else {
                        channelSegmentG0 = channelSegment;
                    }
                    Object objB1 = bufferedChannel.B1(channelSegmentG0, i4, andIncrement, null);
                    if (objB1 == BufferedChannelKt.f141116m) {
                        throw new IllegalStateException("unreachable");
                    }
                    if (objB1 == BufferedChannelKt.f141118o) {
                        if (andIncrement < bufferedChannel.v0()) {
                            channelSegmentG0.b();
                        }
                        channelSegment = channelSegmentG0;
                    } else {
                        if (objB1 == BufferedChannelKt.f141117n) {
                            return f(channelSegmentG0, i4, andIncrement, continuation);
                        }
                        channelSegmentG0.b();
                        this.f141079a = objB1;
                    }
                }
                zG = g();
            }
            return Boxing.a(zG);
        }

        @Override // kotlinx.coroutines.Waiter
        public void b(Segment segment, int i3) {
            CancellableContinuationImpl cancellableContinuationImpl = this.f141080b;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.b(segment, i3);
            }
        }

        public final boolean i(Object obj) {
            CancellableContinuationImpl cancellableContinuationImpl = this.f141080b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.f141080b = null;
            this.f141079a = obj;
            Boolean bool = Boolean.TRUE;
            BufferedChannel bufferedChannel = BufferedChannel.this;
            Function1 function1 = bufferedChannel.f141077b;
            return BufferedChannelKt.B(cancellableContinuationImpl, bool, function1 != null ? bufferedChannel.R(function1, obj) : null);
        }

        public final void j() {
            CancellableContinuationImpl cancellableContinuationImpl = this.f141080b;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.f141080b = null;
            this.f141079a = BufferedChannelKt.z();
            Throwable thL0 = BufferedChannel.this.l0();
            if (thL0 == null) {
                Result.Companion companion = Result.f139772b;
                cancellableContinuationImpl.resumeWith(Result.b(Boolean.FALSE));
            } else {
                Result.Companion companion2 = Result.f139772b;
                cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(thL0)));
            }
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object next() throws Throwable {
            Object obj = this.f141079a;
            if (obj == BufferedChannelKt.f141119p) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.f141079a = BufferedChannelKt.f141119p;
            if (obj != BufferedChannelKt.z()) {
                return obj;
            }
            throw StackTraceRecoveryKt.a(BufferedChannel.this.o0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SendBroadcast implements Waiter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ CancellableContinuationImpl f141082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CancellableContinuation f141083b;

        public SendBroadcast(CancellableContinuation cancellableContinuation) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.f141082a = (CancellableContinuationImpl) cancellableContinuation;
            this.f141083b = cancellableContinuation;
        }

        public final CancellableContinuation a() {
            return this.f141083b;
        }

        @Override // kotlinx.coroutines.Waiter
        public void b(Segment segment, int i3) {
            this.f141082a.b(segment, i3);
        }
    }

    public BufferedChannel(int i3, Function1 function1) {
        this.f141076a = i3;
        this.f141077b = function1;
        if (i3 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i3 + YgVrd.ETNp).toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.A(i3);
        this.completedExpandBuffersAndPauseFlag$volatile = j0();
        ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment;
        this.receiveSegment$volatile = channelSegment;
        if (H0()) {
            channelSegment = BufferedChannelKt.f141104a;
            Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = channelSegment;
        this.f141078c = function1 != null ? new Function3() { // from class: kotlinx.coroutines.channels.a
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return BufferedChannel.Y0(this.f141381a, (SelectInstance) obj, obj2, obj3);
            }
        } : null;
        this._closeCause$volatile = BufferedChannelKt.f141122s;
    }

    private final void A0() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f141075m;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.f141120q : BufferedChannelKt.f141121r));
        if (obj == null) {
            return;
        }
        ((Function1) obj).invoke(l0());
    }

    private final boolean A1(ChannelSegment channelSegment, int i3, long j3) {
        while (true) {
            Object objB = channelSegment.B(i3);
            if (objB instanceof Waiter) {
                if (j3 < f141068f.get(this)) {
                    if (channelSegment.v(i3, objB, new WaiterEB((Waiter) objB))) {
                        return true;
                    }
                } else if (channelSegment.v(i3, objB, BufferedChannelKt.f141110g)) {
                    if (x1(objB, channelSegment, i3)) {
                        channelSegment.F(i3, BufferedChannelKt.f141107d);
                        return true;
                    }
                    channelSegment.F(i3, BufferedChannelKt.f141113j);
                    channelSegment.C(i3, false);
                    return false;
                }
            } else {
                if (objB == BufferedChannelKt.f141113j) {
                    return false;
                }
                if (objB == null) {
                    if (channelSegment.v(i3, objB, BufferedChannelKt.f141108e)) {
                        return true;
                    }
                } else {
                    if (objB == BufferedChannelKt.f141107d || objB == BufferedChannelKt.f141111h || objB == BufferedChannelKt.f141112i || objB == BufferedChannelKt.f141114k || objB == BufferedChannelKt.z()) {
                        return true;
                    }
                    if (objB != BufferedChannelKt.f141109f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objB).toString());
                    }
                }
            }
        }
    }

    private final boolean B0(ChannelSegment channelSegment, int i3, long j3) {
        Object objB;
        do {
            objB = channelSegment.B(i3);
            if (objB != null && objB != BufferedChannelKt.f141108e) {
                if (objB == BufferedChannelKt.f141107d) {
                    return true;
                }
                if (objB == BufferedChannelKt.f141113j || objB == BufferedChannelKt.z() || objB == BufferedChannelKt.f141112i || objB == BufferedChannelKt.f141111h) {
                    return false;
                }
                if (objB == BufferedChannelKt.f141110g) {
                    return true;
                }
                return objB != BufferedChannelKt.f141109f && j3 == r0();
            }
        } while (!channelSegment.v(i3, objB, BufferedChannelKt.f141111h));
        e0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object B1(ChannelSegment channelSegment, int i3, long j3, Object obj) {
        Object objB = channelSegment.B(i3);
        if (objB == null) {
            if (j3 >= (f141067d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.f141117n;
                }
                if (channelSegment.v(i3, objB, obj)) {
                    e0();
                    return BufferedChannelKt.f141116m;
                }
            }
        } else if (objB == BufferedChannelKt.f141107d && channelSegment.v(i3, objB, BufferedChannelKt.f141112i)) {
            e0();
            return channelSegment.D(i3);
        }
        return C1(channelSegment, i3, j3, obj);
    }

    private final boolean C0(long j3, boolean z2) {
        int i3 = (int) (j3 >> 60);
        if (i3 == 0 || i3 == 1) {
            return false;
        }
        if (i3 == 2) {
            b0(j3 & 1152921504606846975L);
            return (z2 && x0()) ? false : true;
        }
        if (i3 == 3) {
            a0(j3 & 1152921504606846975L);
            return true;
        }
        throw new IllegalStateException(("unexpected close status: " + i3).toString());
    }

    private final Object C1(ChannelSegment channelSegment, int i3, long j3, Object obj) {
        while (true) {
            Object objB = channelSegment.B(i3);
            if (objB == null || objB == BufferedChannelKt.f141108e) {
                if (j3 < (f141067d.get(this) & 1152921504606846975L)) {
                    if (channelSegment.v(i3, objB, BufferedChannelKt.f141111h)) {
                        e0();
                        return BufferedChannelKt.f141118o;
                    }
                } else {
                    if (obj == null) {
                        return BufferedChannelKt.f141117n;
                    }
                    if (channelSegment.v(i3, objB, obj)) {
                        e0();
                        return BufferedChannelKt.f141116m;
                    }
                }
            } else {
                if (objB != BufferedChannelKt.f141107d) {
                    if (objB != BufferedChannelKt.f141113j && objB != BufferedChannelKt.f141111h) {
                        if (objB == BufferedChannelKt.z()) {
                            e0();
                            return BufferedChannelKt.f141118o;
                        }
                        if (objB != BufferedChannelKt.f141110g && channelSegment.v(i3, objB, BufferedChannelKt.f141109f)) {
                            boolean z2 = objB instanceof WaiterEB;
                            if (z2) {
                                objB = ((WaiterEB) objB).f141380a;
                            }
                            if (x1(objB, channelSegment, i3)) {
                                channelSegment.F(i3, BufferedChannelKt.f141112i);
                                e0();
                                return channelSegment.D(i3);
                            }
                            channelSegment.F(i3, BufferedChannelKt.f141113j);
                            channelSegment.C(i3, false);
                            if (z2) {
                                e0();
                            }
                            return BufferedChannelKt.f141118o;
                        }
                    }
                    return BufferedChannelKt.f141118o;
                }
                if (channelSegment.v(i3, objB, BufferedChannelKt.f141112i)) {
                    e0();
                    return channelSegment.D(i3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int D1(ChannelSegment channelSegment, int i3, Object obj, long j3, Object obj2, boolean z2) {
        channelSegment.G(i3, obj);
        if (z2) {
            return E1(channelSegment, i3, obj, j3, obj2, z2);
        }
        Object objB = channelSegment.B(i3);
        if (objB == null) {
            if (V(j3)) {
                if (channelSegment.v(i3, null, BufferedChannelKt.f141107d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (channelSegment.v(i3, null, obj2)) {
                    return 2;
                }
            }
        } else if (objB instanceof Waiter) {
            channelSegment.w(i3);
            if (w1(objB, obj)) {
                channelSegment.F(i3, BufferedChannelKt.f141112i);
                W0();
                return 0;
            }
            if (channelSegment.x(i3, BufferedChannelKt.f141114k) == BufferedChannelKt.f141114k) {
                return 5;
            }
            channelSegment.C(i3, true);
            return 5;
        }
        return E1(channelSegment, i3, obj, j3, obj2, z2);
    }

    private final boolean E0(long j3) {
        return C0(j3, true);
    }

    private final int E1(ChannelSegment channelSegment, int i3, Object obj, long j3, Object obj2, boolean z2) {
        while (true) {
            Object objB = channelSegment.B(i3);
            if (objB == null) {
                if (!V(j3) || z2) {
                    if (z2) {
                        if (channelSegment.v(i3, null, BufferedChannelKt.f141113j)) {
                            channelSegment.C(i3, false);
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (channelSegment.v(i3, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.v(i3, null, BufferedChannelKt.f141107d)) {
                    return 1;
                }
            } else {
                if (objB != BufferedChannelKt.f141108e) {
                    if (objB == BufferedChannelKt.f141114k) {
                        channelSegment.w(i3);
                        return 5;
                    }
                    if (objB == BufferedChannelKt.f141111h) {
                        channelSegment.w(i3);
                        return 5;
                    }
                    if (objB == BufferedChannelKt.z()) {
                        channelSegment.w(i3);
                        c0();
                        return 4;
                    }
                    channelSegment.w(i3);
                    if (objB instanceof WaiterEB) {
                        objB = ((WaiterEB) objB).f141380a;
                    }
                    if (w1(objB, obj)) {
                        channelSegment.F(i3, BufferedChannelKt.f141112i);
                        W0();
                        return 0;
                    }
                    if (channelSegment.x(i3, BufferedChannelKt.f141114k) != BufferedChannelKt.f141114k) {
                        channelSegment.C(i3, true);
                    }
                    return 5;
                }
                if (channelSegment.v(i3, objB, BufferedChannelKt.f141107d)) {
                    return 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F0(long j3) {
        return C0(j3, false);
    }

    private final void F1(long j3) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f141068f;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(this);
            if (j4 >= j3) {
                return;
            }
            long j5 = j3;
            if (f141068f.compareAndSet(this, j4, j5)) {
                return;
            } else {
                j3 = j5;
            }
        }
    }

    private final void G1(long j3) {
        long j4;
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f141067d;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            j5 = 1152921504606846975L & j4;
            if (j5 >= j3) {
                return;
            }
        } while (!f141067d.compareAndSet(this, j4, BufferedChannelKt.w(j5, (int) (j4 >> 60))));
    }

    private final boolean H0() {
        long jJ0 = j0();
        return jJ0 == 0 || jJ0 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (kotlinx.coroutines.channels.ChannelSegment) r8.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long I0(kotlinx.coroutines.channels.ChannelSegment r8) {
        /*
            r7 = this;
        L0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.f141105b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f142482c
            int r5 = kotlinx.coroutines.channels.BufferedChannelKt.f141105b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.r0()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.B(r0)
            if (r1 == 0) goto L2c
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.f141107d
            if (r1 != r2) goto L39
            return r3
        L2c:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.z()
            boolean r1 = r8.v(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.t()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r8 = r8.h()
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.I0(kotlinx.coroutines.channels.ChannelSegment):long");
    }

    private final void J0() {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f141067d;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if (((int) (j3 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, BufferedChannelKt.w(1152921504606846975L & j3, 1)));
    }

    private final void K0() {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f141067d;
        do {
            j3 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, BufferedChannelKt.w(1152921504606846975L & j3, 3)));
    }

    private final void L0() {
        long j3;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f141067d;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            int i3 = (int) (j3 >> 60);
            if (i3 == 0) {
                jW = BufferedChannelKt.w(1152921504606846975L & j3, 2);
            } else if (i3 != 1) {
                return;
            } else {
                jW = BufferedChannelKt.w(1152921504606846975L & j3, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, jW));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void M0(long r5, kotlinx.coroutines.channels.ChannelSegment r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f142482c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r7.f()
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.k()
            if (r5 == 0) goto L22
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r5 = r7.f()
            kotlinx.coroutines.channels.ChannelSegment r5 = (kotlinx.coroutines.channels.ChannelSegment) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = k0()
        L26:
            java.lang.Object r6 = r5.get(r4)
            kotlinx.coroutines.internal.Segment r6 = (kotlinx.coroutines.internal.Segment) r6
            long r0 = r6.f142482c
            long r2 = r7.f142482c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L35
            return
        L35:
            boolean r0 = r7.u()
            if (r0 != 0) goto L3c
            goto L11
        L3c:
            boolean r0 = androidx.concurrent.futures.a.a(r5, r4, r6, r7)
            if (r0 == 0) goto L4c
            boolean r5 = r6.p()
            if (r5 == 0) goto L4b
            r6.n()
        L4b:
            return
        L4c:
            boolean r6 = r7.p()
            if (r6 == 0) goto L26
            r7.n()
            goto L26
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.M0(long, kotlinx.coroutines.channels.ChannelSegment):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(Throwable th, Object obj, CoroutineContext coroutineContext) {
        Function1 function1 = this.f141077b;
        Intrinsics.checkNotNull(function1);
        Object objF = ChannelResult.f(obj);
        Intrinsics.checkNotNull(objF);
        OnUndeliveredElementKt.a(function1, objF, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O0(Throwable th, Object obj, CoroutineContext coroutineContext) {
        Function1 function1 = this.f141077b;
        Intrinsics.checkNotNull(function1);
        OnUndeliveredElementKt.a(function1, obj, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(CancellableContinuation cancellableContinuation) {
        Result.Companion companion = Result.f139772b;
        cancellableContinuation.resumeWith(Result.b(ChannelResult.b(ChannelResult.f141130b.a(l0()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function3 R(final Function1 function1, final Object obj) {
        return new Function3() { // from class: kotlinx.coroutines.channels.b
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                return BufferedChannel.T(function1, obj, (Throwable) obj2, obj3, (CoroutineContext) obj4);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(CancellableContinuation cancellableContinuation) {
        Result.Companion companion = Result.f139772b;
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(o0())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction S(Function1 function1) {
        return new BufferedChannel$bindCancellationFun$2(this);
    }

    private final void S0(SelectInstance selectInstance) {
        selectInstance.d(BufferedChannelKt.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function1 function1, Object obj, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        OnUndeliveredElementKt.a(function1, obj, coroutineContext);
        return Unit.f139807a;
    }

    private final void T0(Object obj, SelectInstance selectInstance) {
        Function1 function1 = this.f141077b;
        if (function1 != null) {
            OnUndeliveredElementKt.a(function1, obj, selectInstance.getContext());
        }
        selectInstance.d(BufferedChannelKt.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction U(Function1 function1) {
        return new BufferedChannel$bindCancellationFunResult$1(this);
    }

    private final Object U0(Object obj, Continuation continuation) {
        UndeliveredElementException undeliveredElementExceptionC;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        Function1 function1 = this.f141077b;
        if (function1 == null || (undeliveredElementExceptionC = OnUndeliveredElementKt.c(function1, obj, null, 2, null)) == null) {
            Throwable thS0 = s0();
            Result.Companion companion = Result.f139772b;
            cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(thS0)));
        } else {
            ExceptionsKt.a(undeliveredElementExceptionC, s0());
            Result.Companion companion2 = Result.f139772b;
            cancellableContinuationImpl.resumeWith(Result.b(ResultKt.a(undeliveredElementExceptionC)));
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    private final boolean V(long j3) {
        return j3 < j0() || j3 < r0() + ((long) this.f141076a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(Object obj, CancellableContinuation cancellableContinuation) {
        Function1 function1 = this.f141077b;
        if (function1 != null) {
            OnUndeliveredElementKt.a(function1, obj, cancellableContinuation.getContext());
        }
        Throwable thS0 = s0();
        Result.Companion companion = Result.f139772b;
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(thS0)));
    }

    private final void X(ChannelSegment channelSegment, long j3) {
        Object objB = InlineList.b(null, 1, null);
        loop0: while (channelSegment != null) {
            for (int i3 = BufferedChannelKt.f141105b - 1; -1 < i3; i3--) {
                if ((channelSegment.f142482c * ((long) BufferedChannelKt.f141105b)) + ((long) i3) < j3) {
                    break loop0;
                }
                while (true) {
                    Object objB2 = channelSegment.B(i3);
                    if (objB2 != null && objB2 != BufferedChannelKt.f141108e) {
                        if (!(objB2 instanceof WaiterEB)) {
                            if (!(objB2 instanceof Waiter)) {
                                break;
                            }
                            if (channelSegment.v(i3, objB2, BufferedChannelKt.z())) {
                                objB = InlineList.e(objB, objB2);
                                channelSegment.C(i3, true);
                                break;
                            }
                        } else {
                            if (channelSegment.v(i3, objB2, BufferedChannelKt.z())) {
                                objB = InlineList.e(objB, ((WaiterEB) objB2).f141380a);
                                channelSegment.C(i3, true);
                                break;
                            }
                        }
                    } else {
                        if (channelSegment.v(i3, objB2, BufferedChannelKt.z())) {
                            channelSegment.t();
                            break;
                        }
                    }
                }
            }
            channelSegment = (ChannelSegment) channelSegment.h();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                n1((Waiter) objB);
                return;
            }
            Intrinsics.checkNotNull(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                n1((Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment Y() {
        Object obj = f141073k.get(this);
        ChannelSegment channelSegment = (ChannelSegment) f141071i.get(this);
        if (channelSegment.f142482c > ((ChannelSegment) obj).f142482c) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) f141072j.get(this);
        if (channelSegment2.f142482c > ((ChannelSegment) obj).f142482c) {
            obj = channelSegment2;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.b((ConcurrentLinkedListNode) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 Y0(final BufferedChannel bufferedChannel, final SelectInstance selectInstance, Object obj, final Object obj2) {
        return new Function3() { // from class: kotlinx.coroutines.channels.c
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                return BufferedChannel.Z0(obj2, bufferedChannel, selectInstance, (Throwable) obj3, obj4, (CoroutineContext) obj5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        if (obj != BufferedChannelKt.z()) {
            OnUndeliveredElementKt.a(bufferedChannel.f141077b, obj, selectInstance.getContext());
        }
        return Unit.f139807a;
    }

    private final void a0(long j3) {
        m1(b0(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(Waiter waiter, ChannelSegment channelSegment, int i3) {
        X0();
        waiter.b(channelSegment, i3);
    }

    private final ChannelSegment b0(long j3) {
        ChannelSegment channelSegmentY = Y();
        if (G0()) {
            long jI0 = I0(channelSegmentY);
            if (jI0 != -1) {
                d0(jI0);
            }
        }
        X(channelSegmentY, j3);
        return channelSegmentY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(Waiter waiter, ChannelSegment channelSegment, int i3) {
        waiter.b(channelSegment, i3 + BufferedChannelKt.f141105b);
    }

    private final void c0() {
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c1(Object obj, Object obj2) throws Throwable {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        throw o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d1(Object obj, Object obj2) {
        return ChannelResult.b(obj2 == BufferedChannelKt.z() ? ChannelResult.f141130b.a(l0()) : ChannelResult.f141130b.c(obj2));
    }

    private final void e0() {
        if (H0()) {
            return;
        }
        ChannelSegment channelSegment = (ChannelSegment) f141073k.get(this);
        while (true) {
            long andIncrement = f141069g.getAndIncrement(this);
            int i3 = BufferedChannelKt.f141105b;
            long j3 = andIncrement / ((long) i3);
            if (v0() <= andIncrement) {
                if (channelSegment.f142482c < j3 && channelSegment.f() != null) {
                    M0(j3, channelSegment);
                }
                z0(this, 0L, 1, null);
                return;
            }
            if (channelSegment.f142482c != j3) {
                ChannelSegment channelSegmentF0 = f0(j3, channelSegment, andIncrement);
                if (channelSegmentF0 == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentF0;
                }
            }
            if (z1(channelSegment, (int) (andIncrement % ((long) i3)), andIncrement)) {
                z0(this, 0L, 1, null);
                return;
            }
            z0(this, 0L, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object e1(Object obj, Object obj2) throws Throwable {
        if (obj2 != BufferedChannelKt.z()) {
            return obj2;
        }
        if (l0() == null) {
            return null;
        }
        throw o0();
    }

    private final ChannelSegment f0(long j3, ChannelSegment channelSegment, long j4) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f141073k;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            objC = ConcurrentLinkedListKt.c(channelSegment, j3, function2);
            if (!SegmentOrClosed.e(objC)) {
                Segment segmentC = SegmentOrClosed.c(objC);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f142482c >= segmentC.f142482c) {
                        break loop0;
                    }
                    if (!segmentC.u()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, segment, segmentC)) {
                        if (segment.p()) {
                            segment.n();
                        }
                    } else if (segmentC.p()) {
                        segmentC.n();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.e(objC)) {
            c0();
            M0(j3, channelSegment);
            z0(this, 0L, 1, null);
            return null;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) SegmentOrClosed.c(objC);
        if (channelSegment2.f142482c <= j3) {
            return channelSegment2;
        }
        long j5 = channelSegment2.f142482c;
        int i3 = BufferedChannelKt.f141105b;
        if (f141069g.compareAndSet(this, j4 + 1, j5 * ((long) i3))) {
            y0((channelSegment2.f142482c * ((long) i3)) - j4);
        } else {
            z0(this, 0L, 1, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f1(Object obj, Object obj2) throws Throwable {
        if (obj2 != BufferedChannelKt.z()) {
            return this;
        }
        throw s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment g0(long j3, ChannelSegment channelSegment) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f141072j;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            objC = ConcurrentLinkedListKt.c(channelSegment, j3, function2);
            if (!SegmentOrClosed.e(objC)) {
                Segment segmentC = SegmentOrClosed.c(objC);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f142482c >= segmentC.f142482c) {
                        break loop0;
                    }
                    if (!segmentC.u()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, segment, segmentC)) {
                        if (segment.p()) {
                            segment.n();
                        }
                    } else if (segmentC.p()) {
                        segmentC.n();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.e(objC)) {
            c0();
            if (channelSegment.f142482c * ((long) BufferedChannelKt.f141105b) < v0()) {
                channelSegment.b();
            }
            return null;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) SegmentOrClosed.c(objC);
        if (!H0() && j3 <= j0() / ((long) BufferedChannelKt.f141105b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f141073k;
            while (true) {
                Segment segment2 = (Segment) atomicReferenceFieldUpdater2.get(this);
                if (segment2.f142482c >= channelSegment2.f142482c || !channelSegment2.u()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, segment2, channelSegment2)) {
                    if (segment2.p()) {
                        segment2.n();
                    }
                } else if (channelSegment2.p()) {
                    channelSegment2.n();
                }
            }
        }
        long j4 = channelSegment2.f142482c;
        if (j4 <= j3) {
            return channelSegment2;
        }
        int i3 = BufferedChannelKt.f141105b;
        F1(j4 * ((long) i3));
        if (channelSegment2.f142482c * ((long) i3) < v0()) {
            channelSegment2.b();
        }
        return null;
    }

    static /* synthetic */ Object g1(BufferedChannel bufferedChannel, Continuation continuation) throws Throwable {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) p0().get(bufferedChannel);
        while (!bufferedChannel.D0()) {
            long andIncrement = q0().getAndIncrement(bufferedChannel);
            int i3 = BufferedChannelKt.f141105b;
            long j3 = andIncrement / ((long) i3);
            int i4 = (int) (andIncrement % ((long) i3));
            if (channelSegment2.f142482c != j3) {
                ChannelSegment channelSegmentG0 = bufferedChannel.g0(j3, channelSegment2);
                if (channelSegmentG0 == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentG0;
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel bufferedChannel2 = bufferedChannel;
            Object objB1 = bufferedChannel2.B1(channelSegment, i4, andIncrement, null);
            if (objB1 == BufferedChannelKt.f141116m) {
                throw new IllegalStateException("unexpected");
            }
            if (objB1 != BufferedChannelKt.f141118o) {
                if (objB1 == BufferedChannelKt.f141117n) {
                    return bufferedChannel2.j1(channelSegment, i4, andIncrement, continuation);
                }
                channelSegment.b();
                return objB1;
            }
            if (andIncrement < bufferedChannel2.v0()) {
                channelSegment.b();
            }
            bufferedChannel = bufferedChannel2;
            channelSegment2 = channelSegment;
        }
        throw StackTraceRecoveryKt.a(bufferedChannel.o0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment h0(long j3, ChannelSegment channelSegment) {
        Object objC;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f141071i;
        Function2 function2 = (Function2) BufferedChannelKt.y();
        loop0: while (true) {
            objC = ConcurrentLinkedListKt.c(channelSegment, j3, function2);
            if (!SegmentOrClosed.e(objC)) {
                Segment segmentC = SegmentOrClosed.c(objC);
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    if (segment.f142482c >= segmentC.f142482c) {
                        break loop0;
                    }
                    if (!segmentC.u()) {
                        break;
                    }
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, segment, segmentC)) {
                        if (segment.p()) {
                            segment.n();
                        }
                    } else if (segmentC.p()) {
                        segmentC.n();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.e(objC)) {
            c0();
            if (channelSegment.f142482c * ((long) BufferedChannelKt.f141105b) < r0()) {
                channelSegment.b();
            }
            return null;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) SegmentOrClosed.c(objC);
        long j4 = channelSegment2.f142482c;
        if (j4 <= j3) {
            return channelSegment2;
        }
        int i3 = BufferedChannelKt.f141105b;
        G1(j4 * ((long) i3));
        if (channelSegment2.f142482c * ((long) i3) < r0()) {
            channelSegment2.b();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object h1(kotlinx.coroutines.channels.BufferedChannel r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            boolean r0 = r14 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L14
            r0 = r14
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.f141094c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f141094c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f141092a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f141094c
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            kotlin.ResultKt.b(r14)
            kotlinx.coroutines.channels.ChannelResult r14 = (kotlinx.coroutines.channels.ChannelResult) r14
            java.lang.Object r13 = r14.m()
            return r13
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            kotlin.ResultKt.b(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = p()
            java.lang.Object r14 = r14.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
        L46:
            boolean r1 = r13.D0()
            if (r1 == 0) goto L57
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.f141130b
            java.lang.Throwable r13 = r13.l0()
            java.lang.Object r13 = r14.a(r13)
            return r13
        L57:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = r()
            long r4 = r1.getAndIncrement(r13)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.f141105b
            long r7 = (long) r1
            long r7 = r4 / r7
            long r9 = (long) r1
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r14.f142482c
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L77
            kotlinx.coroutines.channels.ChannelSegment r1 = k(r13, r7, r14)
            if (r1 != 0) goto L75
            goto L46
        L75:
            r8 = r1
            goto L78
        L77:
            r8 = r14
        L78:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = P(r7, r8, r9, r10, r12)
            r1 = r7
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.r()
            if (r13 == r14) goto Lb6
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.h()
            if (r13 != r14) goto L9b
            long r13 = r1.v0()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L98
            r8.b()
        L98:
            r13 = r1
            r14 = r8
            goto L46
        L9b:
            kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.s()
            if (r13 != r14) goto Lac
            r6.f141094c = r2
            r2 = r8
            java.lang.Object r13 = r1.i1(r2, r3, r4, r6)
            if (r13 != r0) goto Lab
            return r0
        Lab:
            return r13
        Lac:
            r8.b()
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.f141130b
            java.lang.Object r13 = r14.c(r13)
            return r13
        Lb6:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.h1(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i1(kotlinx.coroutines.channels.ChannelSegment r11, int r12, long r13, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.i1(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final long j0() {
        return f141069g.get(this);
    }

    private final Object j1(ChannelSegment channelSegment, int i3, long j3, Continuation continuation) {
        ChannelSegment channelSegment2;
        CancellableContinuationImpl cancellableContinuationImplB = CancellableContinuationKt.b(IntrinsicsKt.c(continuation));
        try {
            Object objB1 = B1(channelSegment, i3, j3, cancellableContinuationImplB);
            if (objB1 == BufferedChannelKt.f141116m) {
                a1(cancellableContinuationImplB, channelSegment, i3);
            } else {
                KFunction kFunctionS = null;
                kFunctionS = null;
                if (objB1 == BufferedChannelKt.f141118o) {
                    if (j3 < v0()) {
                        channelSegment.b();
                    }
                    ChannelSegment channelSegment3 = (ChannelSegment) p0().get(this);
                    while (true) {
                        if (D0()) {
                            R0(cancellableContinuationImplB);
                            break;
                        }
                        long andIncrement = q0().getAndIncrement(this);
                        int i4 = BufferedChannelKt.f141105b;
                        long j4 = andIncrement / ((long) i4);
                        int i5 = (int) (andIncrement % ((long) i4));
                        if (channelSegment3.f142482c != j4) {
                            ChannelSegment channelSegmentG0 = g0(j4, channelSegment3);
                            if (channelSegmentG0 != null) {
                                channelSegment2 = channelSegmentG0;
                            }
                        } else {
                            channelSegment2 = channelSegment3;
                        }
                        objB1 = B1(channelSegment2, i5, andIncrement, cancellableContinuationImplB);
                        ChannelSegment channelSegment4 = channelSegment2;
                        if (objB1 == BufferedChannelKt.f141116m) {
                            CancellableContinuationImpl cancellableContinuationImpl = cancellableContinuationImplB != null ? cancellableContinuationImplB : null;
                            if (cancellableContinuationImpl != null) {
                                a1(cancellableContinuationImpl, channelSegment4, i5);
                            }
                        } else if (objB1 == BufferedChannelKt.f141118o) {
                            if (andIncrement < v0()) {
                                channelSegment4.b();
                            }
                            channelSegment3 = channelSegment4;
                        } else {
                            if (objB1 == BufferedChannelKt.f141117n) {
                                throw new IllegalStateException("unexpected");
                            }
                            channelSegment4.b();
                            Function1 function1 = this.f141077b;
                            if (function1 != null) {
                                kFunctionS = S(function1);
                            }
                        }
                    }
                } else {
                    channelSegment.b();
                    Function1 function12 = this.f141077b;
                    if (function12 != null) {
                        kFunctionS = S(function12);
                    }
                }
                cancellableContinuationImplB.H(objB1, (Function3) kFunctionS);
            }
            Object objV = cancellableContinuationImplB.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return objV;
        } catch (Throwable th) {
            cancellableContinuationImplB.M();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(SelectInstance selectInstance, Object obj) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) p0().get(this);
        while (!D0()) {
            long andIncrement = q0().getAndIncrement(this);
            int i3 = BufferedChannelKt.f141105b;
            long j3 = andIncrement / ((long) i3);
            int i4 = (int) (andIncrement % ((long) i3));
            if (channelSegment2.f142482c != j3) {
                ChannelSegment channelSegmentG0 = g0(j3, channelSegment2);
                if (channelSegmentG0 == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentG0;
                }
            } else {
                channelSegment = channelSegment2;
            }
            SelectInstance selectInstance2 = selectInstance;
            Object objB1 = B1(channelSegment, i4, andIncrement, selectInstance2);
            channelSegment2 = channelSegment;
            if (objB1 == BufferedChannelKt.f141116m) {
                Waiter waiter = selectInstance2 instanceof Waiter ? (Waiter) selectInstance2 : null;
                if (waiter != null) {
                    a1(waiter, channelSegment2, i4);
                    return;
                }
                return;
            }
            if (objB1 != BufferedChannelKt.f141118o) {
                if (objB1 == BufferedChannelKt.f141117n) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment2.b();
                selectInstance2.d(objB1);
                return;
            }
            if (andIncrement < v0()) {
                channelSegment2.b();
            }
            selectInstance = selectInstance2;
        }
        S0(selectInstance);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void m1(kotlinx.coroutines.channels.ChannelSegment r12) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m1(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    private final void n1(Waiter waiter) {
        p1(waiter, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable o0() {
        Throwable thL0 = l0();
        return thL0 == null ? new ClosedReceiveChannelException("Channel was closed") : thL0;
    }

    private final void o1(Waiter waiter) {
        p1(waiter, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater p0() {
        return f141072j;
    }

    private final void p1(Waiter waiter, boolean z2) {
        if (waiter instanceof SendBroadcast) {
            CancellableContinuation cancellableContinuationA = ((SendBroadcast) waiter).a();
            Result.Companion companion = Result.f139772b;
            cancellableContinuationA.resumeWith(Result.b(Boolean.FALSE));
            return;
        }
        if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.f139772b;
            continuation.resumeWith(Result.b(ResultKt.a(z2 ? o0() : s0())));
        } else if (waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl cancellableContinuationImpl = ((ReceiveCatching) waiter).f141358a;
            Result.Companion companion3 = Result.f139772b;
            cancellableContinuationImpl.resumeWith(Result.b(ChannelResult.b(ChannelResult.f141130b.a(l0()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).j();
        } else {
            if (waiter instanceof SelectInstance) {
                ((SelectInstance) waiter).f(this, BufferedChannelKt.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater q0() {
        return f141068f;
    }

    static /* synthetic */ Object q1(BufferedChannel bufferedChannel, Object obj, Continuation continuation) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) t0().get(bufferedChannel);
        while (true) {
            long andIncrement = u0().getAndIncrement(bufferedChannel);
            long j3 = andIncrement & 1152921504606846975L;
            boolean zF0 = bufferedChannel.F0(andIncrement);
            int i3 = BufferedChannelKt.f141105b;
            long j4 = j3 / ((long) i3);
            int i4 = (int) (j3 % ((long) i3));
            if (channelSegment2.f142482c != j4) {
                ChannelSegment channelSegmentH0 = bufferedChannel.h0(j4, channelSegment2);
                if (channelSegmentH0 != null) {
                    channelSegment = channelSegmentH0;
                } else if (zF0) {
                    Object objU0 = bufferedChannel.U0(obj, continuation);
                    if (objU0 == IntrinsicsKt.f()) {
                        return objU0;
                    }
                }
            } else {
                channelSegment = channelSegment2;
            }
            BufferedChannel bufferedChannel2 = bufferedChannel;
            Object obj2 = obj;
            int iD1 = bufferedChannel2.D1(channelSegment, i4, obj2, j3, null, zF0);
            if (iD1 == 0) {
                channelSegment.b();
                break;
            }
            if (iD1 == 1) {
                break;
            }
            if (iD1 != 2) {
                if (iD1 == 3) {
                    Object objT1 = bufferedChannel2.t1(channelSegment, i4, obj2, j3, continuation);
                    if (objT1 == IntrinsicsKt.f()) {
                        return objT1;
                    }
                } else if (iD1 != 4) {
                    if (iD1 == 5) {
                        channelSegment.b();
                    }
                    bufferedChannel = bufferedChannel2;
                    channelSegment2 = channelSegment;
                    obj = obj2;
                } else {
                    if (j3 < bufferedChannel2.r0()) {
                        channelSegment.b();
                    }
                    Object objU02 = bufferedChannel2.U0(obj2, continuation);
                    if (objU02 == IntrinsicsKt.f()) {
                        return objU02;
                    }
                }
            } else if (zF0) {
                channelSegment.t();
                Object objU03 = bufferedChannel2.U0(obj2, continuation);
                if (objU03 == IntrinsicsKt.f()) {
                    return objU03;
                }
            }
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0099, code lost:
    
        r13 = kotlin.Result.f139772b;
        r0.resumeWith(kotlin.Result.b(kotlin.coroutines.jvm.internal.Boxing.a(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object s1(kotlinx.coroutines.channels.BufferedChannel r13, java.lang.Object r14, kotlin.coroutines.Continuation r15) {
        /*
            kotlinx.coroutines.CancellableContinuationImpl r0 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r15)
            r2 = 1
            r0.<init>(r1, r2)
            r0.C()
            kotlin.jvm.functions.Function1 r1 = r13.f141077b
            if (r1 != 0) goto Lb9
            kotlinx.coroutines.channels.BufferedChannel$SendBroadcast r9 = new kotlinx.coroutines.channels.BufferedChannel$SendBroadcast
            r9.<init>(r0)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = u()
            java.lang.Object r1 = r1.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L20:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = x()
            long r3 = r3.getAndIncrement(r13)
            r5 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r7 = r3 & r5
            boolean r10 = z(r13, r3)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.f141105b
            long r4 = (long) r3
            long r4 = r7 / r4
            long r11 = (long) r3
            long r11 = r7 % r11
            int r3 = (int) r11
            long r11 = r1.f142482c
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            r11 = 0
            if (r6 == 0) goto L5d
            kotlinx.coroutines.channels.ChannelSegment r4 = l(r13, r4, r1)
            if (r4 != 0) goto L59
            if (r10 == 0) goto L20
        L4b:
            kotlin.Result$Companion r13 = kotlin.Result.f139772b
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r11)
            java.lang.Object r13 = kotlin.Result.b(r13)
            r0.resumeWith(r13)
            goto Lab
        L59:
            r6 = r14
            r5 = r3
            r3 = r13
            goto L5f
        L5d:
            r4 = r1
            goto L59
        L5f:
            int r13 = Q(r3, r4, r5, r6, r7, r9, r10)
            r1 = r4
            if (r13 == 0) goto La7
            if (r13 == r2) goto L99
            r14 = 2
            if (r13 == r14) goto L8f
            r14 = 3
            if (r13 == r14) goto L87
            r14 = 4
            if (r13 == r14) goto L7b
            r14 = 5
            if (r13 == r14) goto L75
            goto L78
        L75:
            r1.b()
        L78:
            r13 = r3
            r14 = r6
            goto L20
        L7b:
            long r13 = r3.r0()
            int r13 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r13 >= 0) goto L4b
            r1.b()
            goto L4b
        L87:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        L8f:
            if (r10 == 0) goto L95
            r1.t()
            goto L4b
        L95:
            H(r3, r9, r1, r5)
            goto Lab
        L99:
            kotlin.Result$Companion r13 = kotlin.Result.f139772b
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
            java.lang.Object r13 = kotlin.Result.b(r13)
            r0.resumeWith(r13)
            goto Lab
        La7:
            r1.b()
            goto L99
        Lab:
            java.lang.Object r13 = r0.v()
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r13 != r14) goto Lb8
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r15)
        Lb8:
            return r13
        Lb9:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.s1(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater t0() {
        return f141071i;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object t1(kotlinx.coroutines.channels.ChannelSegment r17, int r18, java.lang.Object r19, long r20, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instruction units count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.t1(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater u0() {
        return f141067d;
    }

    private final boolean u1(long j3) {
        if (F0(j3)) {
            return false;
        }
        return !V(j3 & 1152921504606846975L);
    }

    private final boolean w1(Object obj, Object obj2) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).f(this, obj2);
        }
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuationImpl cancellableContinuationImpl = ((ReceiveCatching) obj).f141358a;
            ChannelResult channelResultB = ChannelResult.b(ChannelResult.f141130b.c(obj2));
            Function1 function1 = this.f141077b;
            return BufferedChannelKt.B(cancellableContinuationImpl, channelResultB, (Function3) (function1 != null ? U(function1) : null));
        }
        if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).i(obj2);
        }
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1 function12 = this.f141077b;
            return BufferedChannelKt.B(cancellableContinuation, obj2, (Function3) (function12 != null ? S(function12) : null));
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final boolean x1(Object obj, ChannelSegment channelSegment, int i3) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.C((CancellableContinuation) obj, Unit.f139807a, null, 2, null);
        }
        if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultZ = ((SelectImplementation) obj).z(this, Unit.f139807a);
            if (trySelectDetailedResultZ == TrySelectDetailedResult.f142613b) {
                channelSegment.w(i3);
            }
            return trySelectDetailedResultZ == TrySelectDetailedResult.f142612a;
        }
        if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.C(((SendBroadcast) obj).a(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final void y0(long j3) {
        if ((f141070h.addAndGet(this, j3) & 4611686018427387904L) != 0) {
            while ((f141070h.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    static /* synthetic */ void z0(BufferedChannel bufferedChannel, long j3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i3 & 1) != 0) {
            j3 = 1;
        }
        bufferedChannel.y0(j3);
    }

    private final boolean z1(ChannelSegment channelSegment, int i3, long j3) {
        Object objB = channelSegment.B(i3);
        if (!(objB instanceof Waiter) || j3 < f141068f.get(this) || !channelSegment.v(i3, objB, BufferedChannelKt.f141110g)) {
            return A1(channelSegment, i3, j3);
        }
        if (x1(objB, channelSegment, i3)) {
            channelSegment.F(i3, BufferedChannelKt.f141107d);
            return true;
        }
        channelSegment.F(i3, BufferedChannelKt.f141113j);
        channelSegment.C(i3, false);
        return false;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean A() {
        return F0(f141067d.get(this));
    }

    public boolean D0() {
        return E0(f141067d.get(this));
    }

    protected boolean G0() {
        return false;
    }

    public final void H1(long j3) {
        BufferedChannel<E> bufferedChannel = this;
        if (bufferedChannel.H0()) {
            return;
        }
        while (bufferedChannel.j0() <= j3) {
            bufferedChannel = this;
        }
        int i3 = BufferedChannelKt.f141106c;
        for (int i4 = 0; i4 < i3; i4++) {
            long jJ0 = bufferedChannel.j0();
            if (jJ0 == (4611686018427387903L & f141070h.get(bufferedChannel)) && jJ0 == bufferedChannel.j0()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f141070h;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(bufferedChannel);
            if (atomicLongFieldUpdater.compareAndSet(bufferedChannel, j4, BufferedChannelKt.v(j4 & 4611686018427387903L, true))) {
                break;
            } else {
                bufferedChannel = this;
            }
        }
        while (true) {
            long jJ02 = bufferedChannel.j0();
            long j5 = f141070h.get(bufferedChannel);
            long j6 = j5 & 4611686018427387903L;
            boolean z2 = (4611686018427387904L & j5) != 0;
            if (jJ02 == j6 && jJ02 == bufferedChannel.j0()) {
                break;
            }
            if (z2) {
                bufferedChannel = this;
            } else {
                bufferedChannel = this;
                f141070h.compareAndSet(bufferedChannel, j5, BufferedChannelKt.v(j6, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f141070h;
        while (true) {
            long j7 = atomicLongFieldUpdater2.get(bufferedChannel);
            boolean zCompareAndSet = atomicLongFieldUpdater2.compareAndSet(bufferedChannel, j7, BufferedChannelKt.v(j7 & 4611686018427387903L, false));
            AtomicLongFieldUpdater atomicLongFieldUpdater3 = atomicLongFieldUpdater2;
            if (zCompareAndSet) {
                return;
            }
            atomicLongFieldUpdater2 = atomicLongFieldUpdater3;
            bufferedChannel = this;
        }
    }

    protected void P0() {
    }

    public boolean W(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return Z(th, true);
    }

    protected void W0() {
    }

    protected void X0() {
    }

    protected boolean Z(Throwable th, boolean z2) {
        if (z2) {
            J0();
        }
        boolean zA = androidx.concurrent.futures.a.a(f141074l, this, BufferedChannelKt.f141122s, th);
        if (z2) {
            K0();
        } else {
            L0();
        }
        c0();
        P0();
        if (zA) {
            A0();
        }
        return zA;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        W(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2 d() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.f141090a;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.f(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.f141091a;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.f(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    protected final void d0(long j3) {
        ChannelSegment channelSegmentG0;
        UndeliveredElementException undeliveredElementExceptionC;
        ChannelSegment channelSegment = (ChannelSegment) f141072j.get(this);
        while (true) {
            long j4 = f141068f.get(this);
            if (j3 < Math.max(((long) this.f141076a) + j4, j0())) {
                return;
            }
            if (f141068f.compareAndSet(this, j4, 1 + j4)) {
                int i3 = BufferedChannelKt.f141105b;
                long j5 = j4 / ((long) i3);
                int i4 = (int) (j4 % ((long) i3));
                if (channelSegment.f142482c != j5) {
                    channelSegmentG0 = g0(j5, channelSegment);
                    if (channelSegmentG0 == null) {
                        continue;
                    }
                } else {
                    channelSegmentG0 = channelSegment;
                }
                Object objB1 = B1(channelSegmentG0, i4, j4, null);
                if (objB1 != BufferedChannelKt.f141118o) {
                    channelSegmentG0.b();
                    Function1 function1 = this.f141077b;
                    if (function1 != null && (undeliveredElementExceptionC = OnUndeliveredElementKt.c(function1, objB1, null, 2, null)) != null) {
                        throw undeliveredElementExceptionC;
                    }
                } else if (j4 < v0()) {
                    channelSegmentG0.b();
                }
                channelSegment = channelSegmentG0;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void g(Function1 function1) {
        if (androidx.concurrent.futures.a.a(f141075m, this, null, function1)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f141075m;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != BufferedChannelKt.f141120q) {
                if (obj == BufferedChannelKt.f141121r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f141075m, this, BufferedChannelKt.f141120q, BufferedChannelKt.f141121r));
        function1.invoke(l0());
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object h(Object obj) {
        Object obj2;
        int i3;
        ChannelSegment channelSegment;
        BufferedChannel<E> bufferedChannel;
        if (u1(f141067d.get(this))) {
            return ChannelResult.f141130b.b();
        }
        Object obj3 = BufferedChannelKt.f141113j;
        ChannelSegment channelSegment2 = (ChannelSegment) t0().get(this);
        while (true) {
            long andIncrement = u0().getAndIncrement(this);
            long j3 = andIncrement & 1152921504606846975L;
            boolean zF0 = F0(andIncrement);
            int i4 = BufferedChannelKt.f141105b;
            long j4 = j3 / ((long) i4);
            int i5 = (int) (j3 % ((long) i4));
            if (channelSegment2.f142482c != j4) {
                ChannelSegment channelSegmentH0 = h0(j4, channelSegment2);
                if (channelSegmentH0 != null) {
                    i3 = i5;
                    channelSegment = channelSegmentH0;
                    bufferedChannel = this;
                    obj2 = obj;
                } else if (zF0) {
                    return ChannelResult.f141130b.a(s0());
                }
            } else {
                obj2 = obj;
                i3 = i5;
                channelSegment = channelSegment2;
                bufferedChannel = this;
            }
            int iD1 = bufferedChannel.D1(channelSegment, i3, obj2, j3, obj3, zF0);
            channelSegment2 = channelSegment;
            if (iD1 == 0) {
                channelSegment2.b();
                return ChannelResult.f141130b.c(Unit.f139807a);
            }
            if (iD1 == 1) {
                return ChannelResult.f141130b.c(Unit.f139807a);
            }
            if (iD1 == 2) {
                if (zF0) {
                    channelSegment2.t();
                    return ChannelResult.f141130b.a(s0());
                }
                Waiter waiter = obj3 instanceof Waiter ? (Waiter) obj3 : null;
                if (waiter != null) {
                    b1(waiter, channelSegment2, i3);
                }
                channelSegment2.t();
                return ChannelResult.f141130b.b();
            }
            if (iD1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iD1 == 4) {
                if (j3 < r0()) {
                    channelSegment2.b();
                }
                return ChannelResult.f141130b.a(s0());
            }
            if (iD1 == 5) {
                channelSegment2.b();
            }
            obj = obj2;
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator iterator() {
        return new BufferedChannelIterator();
    }

    protected final Throwable l0() {
        return (Throwable) f141074l.get(this);
    }

    protected void l1(SelectInstance selectInstance, Object obj) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) t0().get(this);
        while (true) {
            long andIncrement = u0().getAndIncrement(this);
            long j3 = andIncrement & 1152921504606846975L;
            boolean zF0 = F0(andIncrement);
            int i3 = BufferedChannelKt.f141105b;
            long j4 = j3 / ((long) i3);
            int i4 = (int) (j3 % ((long) i3));
            if (channelSegment2.f142482c != j4) {
                ChannelSegment channelSegmentH0 = h0(j4, channelSegment2);
                if (channelSegmentH0 != null) {
                    channelSegment = channelSegmentH0;
                } else if (zF0) {
                    T0(obj, selectInstance);
                    return;
                }
            } else {
                channelSegment = channelSegment2;
            }
            SelectInstance selectInstance2 = selectInstance;
            Object obj2 = obj;
            int iD1 = D1(channelSegment, i4, obj2, j3, selectInstance2, zF0);
            channelSegment2 = channelSegment;
            if (iD1 == 0) {
                channelSegment2.b();
                selectInstance2.d(Unit.f139807a);
                return;
            }
            if (iD1 == 1) {
                selectInstance2.d(Unit.f139807a);
                return;
            }
            if (iD1 == 2) {
                if (zF0) {
                    channelSegment2.t();
                    T0(obj2, selectInstance2);
                    return;
                } else {
                    Waiter waiter = selectInstance2 instanceof Waiter ? (Waiter) selectInstance2 : null;
                    if (waiter != null) {
                        b1(waiter, channelSegment2, i4);
                        return;
                    }
                    return;
                }
            }
            if (iD1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iD1 == 4) {
                if (j3 < r0()) {
                    channelSegment2.b();
                }
                T0(obj2, selectInstance2);
                return;
            } else {
                if (iD1 == 5) {
                    channelSegment2.b();
                }
                obj = obj2;
                selectInstance = selectInstance2;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 o() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.f141084a;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.f(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.f141085a;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.f(bufferedChannel$onReceive$2, 3), this.f141078c);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 q() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.f141086a;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.f(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.f141087a;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.f(bufferedChannel$onReceiveCatching$2, 3), this.f141078c);
    }

    public final long r0() {
        return f141068f.get(this);
    }

    public Object r1(Object obj, Continuation continuation) {
        return s1(this, obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object s() {
        ChannelSegment channelSegmentG0;
        long j3 = f141068f.get(this);
        long j4 = f141067d.get(this);
        if (E0(j4)) {
            return ChannelResult.f141130b.a(l0());
        }
        if (j3 >= (j4 & 1152921504606846975L)) {
            return ChannelResult.f141130b.b();
        }
        Object obj = BufferedChannelKt.f141114k;
        ChannelSegment channelSegment = (ChannelSegment) p0().get(this);
        while (!D0()) {
            long andIncrement = q0().getAndIncrement(this);
            int i3 = BufferedChannelKt.f141105b;
            long j5 = andIncrement / ((long) i3);
            int i4 = (int) (andIncrement % ((long) i3));
            if (channelSegment.f142482c != j5) {
                channelSegmentG0 = g0(j5, channelSegment);
                if (channelSegmentG0 == null) {
                    continue;
                }
            } else {
                channelSegmentG0 = channelSegment;
            }
            Object objB1 = B1(channelSegmentG0, i4, andIncrement, obj);
            if (objB1 == BufferedChannelKt.f141116m) {
                Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                if (waiter != null) {
                    a1(waiter, channelSegmentG0, i4);
                }
                H1(andIncrement);
                channelSegmentG0.t();
                return ChannelResult.f141130b.b();
            }
            if (objB1 != BufferedChannelKt.f141118o) {
                if (objB1 == BufferedChannelKt.f141117n) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegmentG0.b();
                return ChannelResult.f141130b.c(objB1);
            }
            if (andIncrement < v0()) {
                channelSegmentG0.b();
            }
            channelSegment = channelSegmentG0;
        }
        return ChannelResult.f141130b.a(l0());
    }

    protected final Throwable s0() {
        Throwable thL0 = l0();
        return thL0 == null ? new ClosedSendChannelException("Channel was closed") : thL0;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object t(Continuation continuation) {
        return h1(this, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x01df, code lost:
    
        r16 = r7;
        r3 = (kotlinx.coroutines.channels.ChannelSegment) r3.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e8, code lost:
    
        if (r3 != null) goto L95;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object v(Continuation continuation) {
        return g1(this, continuation);
    }

    public final long v0() {
        return f141067d.get(this) & 1152921504606846975L;
    }

    public boolean v1() {
        return u1(f141067d.get(this));
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean w(Throwable th) {
        return Z(th, false);
    }

    public final boolean x0() {
        while (true) {
            ChannelSegment channelSegmentG0 = (ChannelSegment) f141072j.get(this);
            long jR0 = r0();
            if (v0() <= jR0) {
                return false;
            }
            int i3 = BufferedChannelKt.f141105b;
            long j3 = jR0 / ((long) i3);
            if (channelSegmentG0.f142482c == j3 || (channelSegmentG0 = g0(j3, channelSegmentG0)) != null) {
                channelSegmentG0.b();
                if (B0(channelSegmentG0, (int) (jR0 % ((long) i3)), jR0)) {
                    return true;
                }
                f141068f.compareAndSet(this, jR0, 1 + jR0);
            } else if (((ChannelSegment) f141072j.get(this)).f142482c < j3) {
                return false;
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object y(Object obj, Continuation continuation) {
        return q1(this, obj, continuation);
    }

    protected final Object y1(Object obj) {
        ChannelSegment channelSegmentH0;
        int i3;
        BufferedChannel<E> bufferedChannel;
        Object obj2 = BufferedChannelKt.f141107d;
        ChannelSegment channelSegment = (ChannelSegment) t0().get(this);
        while (true) {
            long andIncrement = u0().getAndIncrement(this);
            long j3 = andIncrement & 1152921504606846975L;
            boolean zF0 = F0(andIncrement);
            int i4 = BufferedChannelKt.f141105b;
            long j4 = j3 / ((long) i4);
            int i5 = (int) (j3 % ((long) i4));
            if (channelSegment.f142482c != j4) {
                channelSegmentH0 = h0(j4, channelSegment);
                if (channelSegmentH0 != null) {
                    bufferedChannel = this;
                    i3 = i5;
                } else if (zF0) {
                    return ChannelResult.f141130b.a(s0());
                }
            } else {
                channelSegmentH0 = channelSegment;
                i3 = i5;
                bufferedChannel = this;
            }
            Object obj3 = obj;
            int iD1 = bufferedChannel.D1(channelSegmentH0, i3, obj3, j3, obj2, zF0);
            channelSegment = channelSegmentH0;
            if (iD1 == 0) {
                channelSegment.b();
                return ChannelResult.f141130b.c(Unit.f139807a);
            }
            if (iD1 == 1) {
                return ChannelResult.f141130b.c(Unit.f139807a);
            }
            if (iD1 == 2) {
                if (zF0) {
                    channelSegment.t();
                    return ChannelResult.f141130b.a(s0());
                }
                Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                if (waiter != null) {
                    b1(waiter, channelSegment, i3);
                }
                d0((channelSegment.f142482c * ((long) i4)) + ((long) i3));
                return ChannelResult.f141130b.c(Unit.f139807a);
            }
            if (iD1 == 3) {
                throw new IllegalStateException("unexpected");
            }
            if (iD1 == 4) {
                if (j3 < r0()) {
                    channelSegment.b();
                }
                return ChannelResult.f141130b.a(s0());
            }
            if (iD1 == 5) {
                channelSegment.b();
            }
            obj = obj3;
        }
    }

    public /* synthetic */ BufferedChannel(int i3, Function1 function1, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? null : function1);
    }
}
