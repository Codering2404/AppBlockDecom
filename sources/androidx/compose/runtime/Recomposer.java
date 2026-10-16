package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.Utils_androidKt;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionRegistrationObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class Recomposer extends CompositionContext {
    public static final Companion C = new Companion(null);
    public static final int D = 8;
    private static final MutableStateFlow E = StateFlowKt.a(ExtensionsKt.c());
    private static final AtomicReference F = new AtomicReference(Boolean.FALSE);
    private MutableObjectList A;
    private final RecomposerInfoImpl B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f24035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BroadcastFrameClock f24036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f24037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Job f24038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f24039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f24040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f24041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MutableScatterSet f24042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableVector f24043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List f24044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f24045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableScatterMap f24046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final NestedContentMap f24047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableScatterMap f24048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableScatterMap f24049o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private List f24050p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Set f24051q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CancellableContinuation f24052r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f24053s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f24054t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private RecomposerErrorState f24055u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f24056v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final MutableStateFlow f24057w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final SnapshotThreadLocal f24058x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final CompletableJob f24059y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final CoroutineContext f24060z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetAdd;
            do {
                persistentSet = (PersistentSet) Recomposer.E.getValue();
                persistentSetAdd = persistentSet.add((Object) recomposerInfoImpl);
                if (persistentSet == persistentSetAdd) {
                    return;
                }
            } while (!Recomposer.E.compareAndSet(persistentSet, persistentSetAdd));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(RecomposerInfoImpl recomposerInfoImpl) {
            PersistentSet persistentSet;
            PersistentSet persistentSetRemove;
            do {
                persistentSet = (PersistentSet) Recomposer.E.getValue();
                persistentSetRemove = persistentSet.remove((Object) recomposerInfoImpl);
                if (persistentSet == persistentSetRemove) {
                    return;
                }
            } while (!Recomposer.E.compareAndSet(persistentSet, persistentSetRemove));
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class HotReloadable {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class RecomposerErrorState implements RecomposerErrorInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f24061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Throwable f24062b;

        public RecomposerErrorState(boolean z2, Throwable th) {
            this.f24061a = z2;
            this.f24062b = th;
        }

        public Throwable a() {
            return this.f24062b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class RecomposerInfoImpl implements RecomposerInfo {
        public RecomposerInfoImpl() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final State f24064a = new State("ShutDown", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final State f24065b = new State("ShuttingDown", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final State f24066c = new State("Inactive", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final State f24067d = new State("InactivePendingWork", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final State f24068f = new State("Idle", 4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final State f24069g = new State("PendingWork", 5);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ State[] f24070h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f24071i;

        static {
            State[] stateArrA = a();
            f24070h = stateArrA;
            f24071i = EnumEntriesKt.a(stateArrA);
        }

        private State(String str, int i3) {
        }

        private static final /* synthetic */ State[] a() {
            return new State[]{f24064a, f24065b, f24066c, f24067d, f24068f, f24069g};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) f24070h.clone();
        }
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m205invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m205invoke() {
                CancellableContinuation cancellableContinuationM0;
                Object obj = this.f24074a.f24037c;
                Recomposer recomposer = this.f24074a;
                synchronized (obj) {
                    cancellableContinuationM0 = recomposer.m0();
                    if (((Recomposer.State) recomposer.f24057w.getValue()).compareTo(Recomposer.State.f24065b) <= 0) {
                        throw ExceptionsKt.a("Recomposer shutdown; frame clock awaiter will never resume", recomposer.f24039e);
                    }
                }
                if (cancellableContinuationM0 != null) {
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuationM0.resumeWith(Result.b(Unit.f139807a));
                }
            }
        });
        this.f24036b = broadcastFrameClock;
        this.f24037c = new Object();
        this.f24040f = new ArrayList();
        this.f24042h = new MutableScatterSet(0, 1, null);
        this.f24043i = new MutableVector(new ControlledComposition[16], 0);
        this.f24044j = new ArrayList();
        this.f24045k = new ArrayList();
        this.f24046l = MultiValueMap.e(null, 1, null);
        this.f24047m = new NestedContentMap();
        this.f24048n = ScatterMapKt.c();
        this.f24049o = MultiValueMap.e(null, 1, null);
        this.f24057w = StateFlowKt.a(State.f24066c);
        this.f24058x = new SnapshotThreadLocal();
        CompletableJob completableJobA = JobKt.a((Job) coroutineContext.get(Job.v8));
        completableJobA.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(final Throwable th) {
                CancellableContinuation cancellableContinuation;
                CancellableContinuation cancellableContinuation2;
                CancellationException cancellationExceptionA = ExceptionsKt.a("Recomposer effect job completed", th);
                Object obj = this.f24075a.f24037c;
                final Recomposer recomposer = this.f24075a;
                synchronized (obj) {
                    try {
                        Job job = recomposer.f24038d;
                        cancellableContinuation = null;
                        if (job != null) {
                            recomposer.f24057w.setValue(Recomposer.State.f24065b);
                            if (recomposer.f24054t) {
                                if (recomposer.f24052r != null) {
                                    cancellableContinuation2 = recomposer.f24052r;
                                }
                                recomposer.f24052r = null;
                                job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((Throwable) obj2);
                                        return Unit.f139807a;
                                    }

                                    public final void invoke(Throwable th2) {
                                        Object obj2 = recomposer.f24037c;
                                        Recomposer recomposer2 = recomposer;
                                        Throwable th3 = th;
                                        synchronized (obj2) {
                                            if (th3 == null) {
                                                th3 = null;
                                            } else if (th2 != null) {
                                                try {
                                                    if (th2 instanceof CancellationException) {
                                                        th2 = null;
                                                    }
                                                    if (th2 != null) {
                                                        kotlin.ExceptionsKt.a(th3, th2);
                                                    }
                                                } catch (Throwable th4) {
                                                    throw th4;
                                                }
                                            }
                                            recomposer2.f24039e = th3;
                                            recomposer2.f24057w.setValue(Recomposer.State.f24064a);
                                            Unit unit = Unit.f139807a;
                                        }
                                    }
                                });
                                cancellableContinuation = cancellableContinuation2;
                            } else {
                                job.cancel(cancellationExceptionA);
                            }
                            cancellableContinuation2 = null;
                            recomposer.f24052r = null;
                            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((Throwable) obj2);
                                    return Unit.f139807a;
                                }

                                public final void invoke(Throwable th2) {
                                    Object obj2 = recomposer.f24037c;
                                    Recomposer recomposer2 = recomposer;
                                    Throwable th3 = th;
                                    synchronized (obj2) {
                                        if (th3 == null) {
                                            th3 = null;
                                        } else if (th2 != null) {
                                            try {
                                                if (th2 instanceof CancellationException) {
                                                    th2 = null;
                                                }
                                                if (th2 != null) {
                                                    kotlin.ExceptionsKt.a(th3, th2);
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                        recomposer2.f24039e = th3;
                                        recomposer2.f24057w.setValue(Recomposer.State.f24064a);
                                        Unit unit = Unit.f139807a;
                                    }
                                }
                            });
                            cancellableContinuation = cancellableContinuation2;
                        } else {
                            recomposer.f24039e = cancellationExceptionA;
                            recomposer.f24057w.setValue(Recomposer.State.f24064a);
                            Unit unit = Unit.f139807a;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(Unit.f139807a));
                }
            }
        });
        this.f24059y = completableJobA;
        this.f24060z = coroutineContext.plus(broadcastFrameClock).plus(completableJobA);
        this.B = new RecomposerInfoImpl();
    }

    private static final void A0(List list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.f24037c) {
            try {
                Iterator it = recomposer.f24045k.iterator();
                while (it.hasNext()) {
                    MovableContentStateReference movableContentStateReference = (MovableContentStateReference) it.next();
                    if (Intrinsics.areEqual(movableContentStateReference.b(), controlledComposition)) {
                        list.add(movableContentStateReference);
                        it.remove();
                    }
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0146, code lost:
    
        r3 = r10.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x014b, code lost:
    
        if (r4 >= r3) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0157, code lost:
    
        if (((kotlin.Pair) r10.get(r4)).f() == null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0159, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015c, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x016a, code lost:
    
        if (r9 >= r4) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x016c, code lost:
    
        r11 = (kotlin.Pair) r10.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0176, code lost:
    
        if (r11.f() != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0178, code lost:
    
        r11 = (androidx.compose.runtime.MovableContentStateReference) r11.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0181, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0182, code lost:
    
        if (r11 == null) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0184, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0187, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018a, code lost:
    
        r4 = r16.f24037c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x018c, code lost:
    
        monitor-enter(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018d, code lost:
    
        kotlin.collections.CollectionsKt.addAll(r16.f24045k, r3);
        r3 = kotlin.Unit.f139807a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0196, code lost:
    
        monitor-exit(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0197, code lost:
    
        r3 = new java.util.ArrayList(r10.size());
        r4 = r10.size();
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01a5, code lost:
    
        if (r9 >= r4) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a7, code lost:
    
        r11 = r10.get(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01b2, code lost:
    
        if (((kotlin.Pair) r11).f() == null) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01b4, code lost:
    
        r3.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01b7, code lost:
    
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ba, code lost:
    
        r10 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List B0(java.util.List r17, androidx.collection.MutableScatterSet r18) {
        /*
            Method dump skipped, instruction units count: 483
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.B0(java.util.List, androidx.collection.MutableScatterSet):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition C0(final ControlledComposition controlledComposition, final MutableScatterSet mutableScatterSet) {
        Set set;
        if (controlledComposition.p() || controlledComposition.e() || ((set = this.f24051q) != null && set.contains(controlledComposition))) {
            return null;
        }
        MutableSnapshot mutableSnapshotO = Snapshot.f24914e.o(F0(controlledComposition), O0(controlledComposition, mutableScatterSet));
        try {
            Snapshot snapshotL = mutableSnapshotO.l();
            if (mutableScatterSet != null) {
                try {
                    if (mutableScatterSet.f()) {
                        controlledComposition.m(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m206invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m206invoke() {
                                MutableScatterSet mutableScatterSet2 = mutableScatterSet;
                                ControlledComposition controlledComposition2 = controlledComposition;
                                Object[] objArr = mutableScatterSet2.f3116b;
                                long[] jArr = mutableScatterSet2.f3115a;
                                int length = jArr.length - 2;
                                if (length < 0) {
                                    return;
                                }
                                int i3 = 0;
                                while (true) {
                                    long j3 = jArr[i3];
                                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i4 = 8 - ((~(i3 - length)) >>> 31);
                                        for (int i5 = 0; i5 < i4; i5++) {
                                            if ((255 & j3) < 128) {
                                                controlledComposition2.r(objArr[(i3 << 3) + i5]);
                                            }
                                            j3 >>= 8;
                                        }
                                        if (i4 != 8) {
                                            return;
                                        }
                                    }
                                    if (i3 == length) {
                                        return;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                        });
                    }
                } catch (Throwable th) {
                    mutableSnapshotO.s(snapshotL);
                    throw th;
                }
            }
            boolean zK = controlledComposition.k();
            mutableSnapshotO.s(snapshotL);
            if (zK) {
                return controlledComposition;
            }
            return null;
        } finally {
            g0(mutableSnapshotO);
        }
    }

    private final void D0(Throwable th, ControlledComposition controlledComposition, boolean z2) throws Throwable {
        if (!((Boolean) F.get()).booleanValue() || (th instanceof ComposeRuntimeError)) {
            synchronized (this.f24037c) {
                RecomposerErrorState recomposerErrorState = this.f24055u;
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.a();
                }
                this.f24055u = new RecomposerErrorState(false, th);
                Unit unit = Unit.f139807a;
            }
            throw th;
        }
        synchronized (this.f24037c) {
            try {
                Utils_androidKt.a("Error was captured in composition while live edit was enabled.", th);
                this.f24044j.clear();
                this.f24043i.i();
                this.f24042h = new MutableScatterSet(0, 1, null);
                this.f24045k.clear();
                MultiValueMap.c(this.f24046l);
                this.f24048n.k();
                this.f24055u = new RecomposerErrorState(z2, th);
                if (controlledComposition != null) {
                    I0(controlledComposition);
                }
                m0();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    static /* synthetic */ void E0(Recomposer recomposer, Throwable th, ControlledComposition controlledComposition, boolean z2, int i3, Object obj) throws Throwable {
        if ((i3 & 2) != 0) {
            controlledComposition = null;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        recomposer.D0(th, controlledComposition, z2);
    }

    private final Function1 F0(final ControlledComposition controlledComposition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            {
                super(1);
            }

            public final void c(Object obj) {
                controlledComposition.a(obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        };
    }

    private final Object G0(Function3 function3, Continuation continuation) {
        Object objG = BuildersKt.g(this.f24036b, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.a(continuation.getContext()), null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H0() {
        List listV0;
        boolean zT0;
        synchronized (this.f24037c) {
            if (this.f24042h.e()) {
                return t0();
            }
            Set setA = ScatterSetWrapperKt.a(this.f24042h);
            this.f24042h = new MutableScatterSet(0, 1, null);
            synchronized (this.f24037c) {
                listV0 = v0();
            }
            try {
                int size = listV0.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((ControlledComposition) listV0.get(i3)).n(setA);
                    if (((State) this.f24057w.getValue()).compareTo(State.f24065b) <= 0) {
                        break;
                    }
                }
                synchronized (this.f24037c) {
                    this.f24042h = new MutableScatterSet(0, 1, null);
                    Unit unit = Unit.f139807a;
                }
                synchronized (this.f24037c) {
                    if (m0() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    zT0 = t0();
                }
                return zT0;
            } catch (Throwable th) {
                synchronized (this.f24037c) {
                    this.f24042h.k(setA);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(ControlledComposition controlledComposition) {
        List arrayList = this.f24050p;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f24050p = arrayList;
        }
        if (!arrayList.contains(controlledComposition)) {
            arrayList.add(controlledComposition);
        }
        K0(controlledComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(Job job) {
        synchronized (this.f24037c) {
            Throwable th = this.f24039e;
            if (th != null) {
                throw th;
            }
            if (((State) this.f24057w.getValue()).compareTo(State.f24065b) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.f24038d != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.f24038d = job;
            m0();
        }
    }

    private final void K0(ControlledComposition controlledComposition) {
        if (this.f24040f.remove(controlledComposition)) {
            this.f24041g = null;
            MutableObjectList mutableObjectList = this.A;
            if (mutableObjectList != null) {
                Object[] objArr = mutableObjectList.f3081a;
                int i3 = mutableObjectList.f3082b;
                for (int i4 = 0; i4 < i3; i4++) {
                    ((CompositionRegistrationObserver) objArr[i4]).b(this, controlledComposition);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a2, code lost:
    
        if (r5.z(r10, r0) != r1) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a2 -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M0(androidx.compose.runtime.MonotonicFrameClock r8, androidx.compose.runtime.ProduceFrameSignal r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.compose.runtime.Recomposer$runFrameLoop$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = (androidx.compose.runtime.Recomposer$runFrameLoop$1) r0
            int r1 = r0.f24101i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f24101i = r1
            goto L18
        L13:
            androidx.compose.runtime.Recomposer$runFrameLoop$1 r0 = new androidx.compose.runtime.Recomposer$runFrameLoop$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f24099g
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f24101i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L65
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            java.lang.Object r8 = r0.f24098f
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.f24097d
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.f24096c
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.f24095b
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.f24094a
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.b(r10)
        L3f:
            r10 = r9
            r9 = r2
            r2 = r8
            r8 = r5
            r5 = r6
            goto L73
        L45:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4d:
            java.lang.Object r8 = r0.f24098f
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r9 = r0.f24097d
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.f24096c
            androidx.compose.runtime.ProduceFrameSignal r2 = (androidx.compose.runtime.ProduceFrameSignal) r2
            java.lang.Object r5 = r0.f24095b
            androidx.compose.runtime.MonotonicFrameClock r5 = (androidx.compose.runtime.MonotonicFrameClock) r5
            java.lang.Object r6 = r0.f24094a
            androidx.compose.runtime.Recomposer r6 = (androidx.compose.runtime.Recomposer) r6
            kotlin.ResultKt.b(r10)
            goto L8d
        L65:
            kotlin.ResultKt.b(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r5 = r7
        L73:
            java.lang.Object r6 = r5.f24037c
            r0.f24094a = r5
            r0.f24095b = r8
            r0.f24096c = r9
            r0.f24097d = r10
            r0.f24098f = r2
            r0.f24101i = r4
            java.lang.Object r6 = r9.c(r6, r0)
            if (r6 != r1) goto L88
            goto La4
        L88:
            r6 = r5
            r5 = r8
            r8 = r2
            r2 = r9
            r9 = r10
        L8d:
            androidx.compose.runtime.Recomposer$runFrameLoop$2 r10 = new androidx.compose.runtime.Recomposer$runFrameLoop$2
            r10.<init>()
            r0.f24094a = r6
            r0.f24095b = r5
            r0.f24096c = r2
            r0.f24097d = r9
            r0.f24098f = r8
            r0.f24101i = r3
            java.lang.Object r10 = r5.z(r10, r0)
            if (r10 != r1) goto L3f
        La4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.M0(androidx.compose.runtime.MonotonicFrameClock, androidx.compose.runtime.ProduceFrameSignal, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Function1 O0(final ControlledComposition controlledComposition, final MutableScatterSet mutableScatterSet) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                controlledComposition.r(obj);
                MutableScatterSet mutableScatterSet2 = mutableScatterSet;
                if (mutableScatterSet2 != null) {
                    mutableScatterSet2.i(obj);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        };
    }

    private final void f0(ControlledComposition controlledComposition) {
        this.f24040f.add(controlledComposition);
        this.f24041g = null;
        MutableObjectList mutableObjectList = this.A;
        if (mutableObjectList != null) {
            Object[] objArr = mutableObjectList.f3081a;
            int i3 = mutableObjectList.f3082b;
            for (int i4 = 0; i4 < i3; i4++) {
                ((CompositionRegistrationObserver) objArr[i4]).a(this, controlledComposition);
            }
        }
    }

    private final void g0(MutableSnapshot mutableSnapshot) {
        try {
            if (mutableSnapshot.E() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            mutableSnapshot.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h0(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (u0()) {
            return Unit.f139807a;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl2.C();
        synchronized (this.f24037c) {
            if (u0()) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                this.f24052r = cancellableContinuationImpl2;
                cancellableContinuationImpl = null;
            }
        }
        if (cancellableContinuationImpl != null) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationImpl.resumeWith(Result.b(Unit.f139807a));
        }
        Object objV = cancellableContinuationImpl2.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    private final void j0() {
        MutableObjectList mutableObjectList = this.A;
        if (mutableObjectList != null) {
            Object[] objArr = mutableObjectList.f3081a;
            int i3 = mutableObjectList.f3082b;
            for (int i4 = 0; i4 < i3; i4++) {
                CompositionRegistrationObserver compositionRegistrationObserver = (CompositionRegistrationObserver) objArr[i4];
                Iterator it = v0().iterator();
                while (it.hasNext()) {
                    compositionRegistrationObserver.b(this, (ControlledComposition) it.next());
                }
            }
        }
        this.f24040f.clear();
        this.f24041g = CollectionsKt.emptyList();
    }

    private static final void l0(Recomposer recomposer, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        List listF = movableContentStateReference2.f();
        if (listF != null) {
            int size = listF.size();
            for (int i3 = 0; i3 < size; i3++) {
                MovableContentStateReference movableContentStateReference3 = (MovableContentStateReference) listF.get(i3);
                recomposer.f24047m.a(movableContentStateReference3.c(), new NestedMovableContent(movableContentStateReference3, movableContentStateReference));
                l0(recomposer, movableContentStateReference, movableContentStateReference3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation m0() {
        State state;
        if (((State) this.f24057w.getValue()).compareTo(State.f24065b) <= 0) {
            j0();
            this.f24042h = new MutableScatterSet(0, 1, null);
            this.f24043i.i();
            this.f24044j.clear();
            this.f24045k.clear();
            this.f24050p = null;
            CancellableContinuation cancellableContinuation = this.f24052r;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.a(cancellableContinuation, null, 1, null);
            }
            this.f24052r = null;
            this.f24055u = null;
            return null;
        }
        if (this.f24055u != null) {
            state = State.f24066c;
        } else if (this.f24038d == null) {
            this.f24042h = new MutableScatterSet(0, 1, null);
            this.f24043i.i();
            state = r0() ? State.f24067d : State.f24066c;
        } else {
            state = (this.f24043i.o() == 0 && !this.f24042h.f() && this.f24044j.isEmpty() && this.f24045k.isEmpty() && this.f24053s <= 0 && !r0()) ? State.f24068f : State.f24069g;
        }
        this.f24057w.setValue(state);
        if (state != State.f24069g) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.f24052r;
        this.f24052r = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0() {
        int i3;
        ObjectList objectListF;
        synchronized (this.f24037c) {
            try {
                if (MultiValueMap.k(this.f24046l)) {
                    ObjectList objectListQ = MultiValueMap.q(this.f24046l);
                    MultiValueMap.c(this.f24046l);
                    this.f24047m.b();
                    MultiValueMap.c(this.f24049o);
                    MutableObjectList mutableObjectList = new MutableObjectList(objectListQ.e());
                    Object[] objArr = objectListQ.f3081a;
                    int i4 = objectListQ.f3082b;
                    for (int i5 = 0; i5 < i4; i5++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) objArr[i5];
                        mutableObjectList.n(TuplesKt.a(movableContentStateReference, this.f24048n.e(movableContentStateReference)));
                    }
                    this.f24048n.k();
                    objectListF = mutableObjectList;
                } else {
                    objectListF = ObjectListKt.f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object[] objArr2 = objectListF.f3081a;
        int i6 = objectListF.f3082b;
        for (i3 = 0; i3 < i6; i3++) {
            Pair pair = (Pair) objArr2[i3];
            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.a();
            MovableContentState movableContentState = (MovableContentState) pair.b();
            if (movableContentState != null) {
                movableContentStateReference2.b().g(movableContentState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q0() {
        boolean zR0;
        synchronized (this.f24037c) {
            zR0 = r0();
        }
        return zR0;
    }

    private final boolean r0() {
        return !this.f24056v && this.f24036b.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s0() {
        return !this.f24044j.isEmpty() || r0();
    }

    private final boolean t0() {
        return this.f24043i.o() != 0 || r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u0() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.f24037c
            monitor-enter(r0)
            androidx.collection.MutableScatterSet r1 = r2.f24042h     // Catch: java.lang.Throwable -> L1d
            boolean r1 = r1.f()     // Catch: java.lang.Throwable -> L1d
            if (r1 != 0) goto L1f
            androidx.compose.runtime.collection.MutableVector r1 = r2.f24043i     // Catch: java.lang.Throwable -> L1d
            int r1 = r1.o()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L14
            goto L1f
        L14:
            boolean r1 = r2.r0()     // Catch: java.lang.Throwable -> L1d
            if (r1 == 0) goto L1b
            goto L1f
        L1b:
            r1 = 0
            goto L20
        L1d:
            r1 = move-exception
            goto L22
        L1f:
            r1 = 1
        L20:
            monitor-exit(r0)
            return r1
        L22:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.u0():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List v0() {
        List listEmptyList = this.f24041g;
        if (listEmptyList == null) {
            List list = this.f24040f;
            listEmptyList = list.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list);
            this.f24041g = listEmptyList;
        }
        return listEmptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w0() {
        boolean z2;
        synchronized (this.f24037c) {
            z2 = this.f24054t;
        }
        if (!z2) {
            return true;
        }
        Iterator it = this.f24059y.getChildren().iterator();
        while (it.hasNext()) {
            if (((Job) it.next()).isActive()) {
                return true;
            }
        }
        return false;
    }

    private final void z0(ControlledComposition controlledComposition) {
        synchronized (this.f24037c) {
            List list = this.f24045k;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (Intrinsics.areEqual(((MovableContentStateReference) list.get(i3)).b(), controlledComposition)) {
                    Unit unit = Unit.f139807a;
                    ArrayList arrayList = new ArrayList();
                    A0(arrayList, this, controlledComposition);
                    while (!arrayList.isEmpty()) {
                        B0(arrayList, null);
                        A0(arrayList, this, controlledComposition);
                    }
                    return;
                }
            }
        }
    }

    public final void L0() {
        CancellableContinuation cancellableContinuationM0;
        synchronized (this.f24037c) {
            if (this.f24056v) {
                this.f24056v = false;
                cancellableContinuationM0 = m0();
            } else {
                cancellableContinuationM0 = null;
            }
        }
        if (cancellableContinuationM0 != null) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationM0.resumeWith(Result.b(Unit.f139807a));
        }
    }

    public final Object N0(Continuation continuation) {
        Object objG0 = G0(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return objG0 == IntrinsicsKt.f() ? objG0 : Unit.f139807a;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void a(ControlledComposition controlledComposition, Function2 function2) throws Throwable {
        Throwable th;
        boolean zP = controlledComposition.p();
        try {
            Snapshot.Companion companion = Snapshot.f24914e;
            MutableSnapshot mutableSnapshotO = companion.o(F0(controlledComposition), O0(controlledComposition, null));
            try {
                Snapshot snapshotL = mutableSnapshotO.l();
                try {
                    controlledComposition.c(function2);
                    Unit unit = Unit.f139807a;
                    mutableSnapshotO.s(snapshotL);
                    g0(mutableSnapshotO);
                    if (!zP) {
                        companion.f();
                    }
                    synchronized (this.f24037c) {
                        try {
                            if (((State) this.f24057w.getValue()).compareTo(State.f24065b) > 0) {
                                try {
                                    if (!v0().contains(controlledComposition)) {
                                        f0(controlledComposition);
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    throw th;
                                }
                            }
                            try {
                                z0(controlledComposition);
                                try {
                                    controlledComposition.o();
                                    controlledComposition.d();
                                    if (zP) {
                                        return;
                                    }
                                    companion.f();
                                } catch (Throwable th3) {
                                    E0(this, th3, null, false, 6, null);
                                }
                            } catch (Throwable th4) {
                                D0(th4, controlledComposition, true);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        mutableSnapshotO.s(snapshotL);
                        throw th6;
                    } catch (Throwable th7) {
                        th = th7;
                        Throwable th8 = th;
                        try {
                            g0(mutableSnapshotO);
                            throw th8;
                        } catch (Throwable th9) {
                            th = th9;
                            D0(th, controlledComposition, true);
                        }
                    }
                }
            } catch (Throwable th10) {
                th = th10;
            }
        } catch (Throwable th11) {
            th = th11;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void b(MovableContentStateReference movableContentStateReference) {
        synchronized (this.f24037c) {
            try {
                MultiValueMap.a(this.f24046l, movableContentStateReference.c(), movableContentStateReference);
                if (movableContentStateReference.f() != null) {
                    l0(this, movableContentStateReference, movableContentStateReference);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean d() {
        return ((Boolean) F.get()).booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean e() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean f() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int h() {
        return 1000;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext i() {
        return this.f24060z;
    }

    public final void i0() {
        synchronized (this.f24037c) {
            try {
                if (((State) this.f24057w.getValue()).compareTo(State.f24068f) >= 0) {
                    this.f24057w.setValue(State.f24065b);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Job.DefaultImpls.b(this.f24059y, null, 1, null);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext k() {
        return EmptyCoroutineContext.f139889a;
    }

    public final void k0() {
        if (this.f24059y.b()) {
            synchronized (this.f24037c) {
                this.f24054t = true;
                Unit unit = Unit.f139807a;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void l(MovableContentStateReference movableContentStateReference) {
        CancellableContinuation cancellableContinuationM0;
        synchronized (this.f24037c) {
            this.f24045k.add(movableContentStateReference);
            cancellableContinuationM0 = m0();
        }
        if (cancellableContinuationM0 != null) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationM0.resumeWith(Result.b(Unit.f139807a));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void m(ControlledComposition controlledComposition) {
        CancellableContinuation cancellableContinuationM0;
        synchronized (this.f24037c) {
            if (this.f24043i.k(controlledComposition)) {
                cancellableContinuationM0 = null;
            } else {
                this.f24043i.b(controlledComposition);
                cancellableContinuationM0 = m0();
            }
        }
        if (cancellableContinuationM0 != null) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationM0.resumeWith(Result.b(Unit.f139807a));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    @Override // androidx.compose.runtime.CompositionContext
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(androidx.compose.runtime.MovableContentStateReference r18, androidx.compose.runtime.MovableContentState r19, androidx.compose.runtime.Applier r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            java.lang.Object r3 = r1.f24037c
            monitor-enter(r3)
            androidx.collection.MutableScatterMap r4 = r1.f24048n     // Catch: java.lang.Throwable -> L63
            r4.x(r0, r2)     // Catch: java.lang.Throwable -> L63
            androidx.collection.MutableScatterMap r4 = r1.f24049o     // Catch: java.lang.Throwable -> L63
            androidx.collection.ObjectList r0 = androidx.compose.runtime.collection.MultiValueMap.h(r4, r0)     // Catch: java.lang.Throwable -> L63
            boolean r4 = r0.h()     // Catch: java.lang.Throwable -> L63
            if (r4 == 0) goto L70
            r4 = r20
            androidx.collection.ScatterMap r0 = r2.c(r4, r0)     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r2 = r0.f3109b     // Catch: java.lang.Throwable -> L63
            java.lang.Object[] r4 = r0.f3110c     // Catch: java.lang.Throwable -> L63
            long[] r0 = r0.f3108a     // Catch: java.lang.Throwable -> L63
            int r5 = r0.length     // Catch: java.lang.Throwable -> L63
            int r5 = r5 + (-2)
            if (r5 < 0) goto L70
            r6 = 0
            r7 = r6
        L2d:
            r8 = r0[r7]     // Catch: java.lang.Throwable -> L63
            long r10 = ~r8     // Catch: java.lang.Throwable -> L63
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L6b
            int r10 = r7 - r5
            int r10 = ~r10     // Catch: java.lang.Throwable -> L63
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L47:
            if (r12 >= r10) goto L69
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L65
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]     // Catch: java.lang.Throwable -> L63
            r13 = r4[r13]     // Catch: java.lang.Throwable -> L63
            androidx.compose.runtime.MovableContentState r13 = (androidx.compose.runtime.MovableContentState) r13     // Catch: java.lang.Throwable -> L63
            androidx.compose.runtime.MovableContentStateReference r14 = (androidx.compose.runtime.MovableContentStateReference) r14     // Catch: java.lang.Throwable -> L63
            androidx.collection.MutableScatterMap r15 = r1.f24048n     // Catch: java.lang.Throwable -> L63
            r15.x(r14, r13)     // Catch: java.lang.Throwable -> L63
            goto L65
        L63:
            r0 = move-exception
            goto L74
        L65:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L47
        L69:
            if (r10 != r11) goto L70
        L6b:
            if (r7 == r5) goto L70
            int r7 = r7 + 1
            goto L2d
        L70:
            kotlin.Unit r0 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L63
            monitor-exit(r3)
            return
        L74:
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.Recomposer.n(androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentState, androidx.compose.runtime.Applier):void");
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState o(MovableContentStateReference movableContentStateReference) {
        MovableContentState movableContentState;
        synchronized (this.f24037c) {
            movableContentState = (MovableContentState) this.f24048n.u(movableContentStateReference);
        }
        return movableContentState;
    }

    public final long o0() {
        return this.f24035a;
    }

    public final StateFlow p0() {
        return this.f24057w;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void r(RecomposeScopeImpl recomposeScopeImpl) {
        MutableScatterSet mutableScatterSetA = (MutableScatterSet) this.f24058x.a();
        if (mutableScatterSetA == null) {
            mutableScatterSetA = ScatterSetKt.a();
            this.f24058x.b(mutableScatterSetA);
        }
        mutableScatterSetA.i(recomposeScopeImpl);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void s(ControlledComposition controlledComposition) {
        synchronized (this.f24037c) {
            try {
                Set linkedHashSet = this.f24051q;
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                    this.f24051q = linkedHashSet;
                }
                linkedHashSet.add(controlledComposition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void v(ControlledComposition controlledComposition) {
        synchronized (this.f24037c) {
            K0(controlledComposition);
            this.f24043i.s(controlledComposition);
            this.f24044j.remove(controlledComposition);
            Unit unit = Unit.f139807a;
        }
    }

    public final Object x0(Continuation continuation) {
        Object objE = FlowKt.E(p0(), new Recomposer$join$2(null), continuation);
        return objE == IntrinsicsKt.f() ? objE : Unit.f139807a;
    }

    public final void y0() {
        synchronized (this.f24037c) {
            this.f24056v = true;
            Unit unit = Unit.f139807a;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void p(Set set) {
    }
}
