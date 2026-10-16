package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.WeakReference;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SnapshotKt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f24944b = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static SnapshotIdSet f24947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f24948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SnapshotDoubleIndexHeap f24949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SnapshotWeakSet f24950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static List f24951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static List f24952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final GlobalSnapshot f24953k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Snapshot f24954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static AtomicInt f24955m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1 f24943a = new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((SnapshotIdSet) obj);
            return Unit.f139807a;
        }

        public final void c(SnapshotIdSet snapshotIdSet) {
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SnapshotThreadLocal f24945c = new SnapshotThreadLocal();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f24946d = new Object();

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.f24931f;
        f24947e = companion.a();
        f24948f = SnapshotId_jvmKt.c(1) + 1;
        f24949g = new SnapshotDoubleIndexHeap();
        f24950h = new SnapshotWeakSet();
        f24951i = CollectionsKt.emptyList();
        f24952j = CollectionsKt.emptyList();
        long j3 = f24948f;
        f24948f = 1 + j3;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(j3, companion.a());
        f24947e = f24947e.p(globalSnapshot.i());
        f24953k = globalSnapshot;
        f24954l = globalSnapshot;
        f24955m = new AtomicInt(0);
    }

    public static final SnapshotIdSet A(SnapshotIdSet snapshotIdSet, long j3, long j4) {
        while (j3 < j4) {
            snapshotIdSet = snapshotIdSet.p(j3);
            j3++;
        }
        return snapshotIdSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object B(kotlin.jvm.functions.Function1 r15) {
        /*
            androidx.compose.runtime.snapshots.GlobalSnapshot r0 = androidx.compose.runtime.snapshots.SnapshotKt.f24953k
            java.lang.Object r1 = J()
            monitor-enter(r1)
            androidx.collection.MutableScatterSet r2 = r0.G()     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L17
            androidx.compose.runtime.internal.AtomicInt r3 = androidx.compose.runtime.snapshots.SnapshotKt.f24955m     // Catch: java.lang.Throwable -> L14
            r4 = 1
            r3.a(r4)     // Catch: java.lang.Throwable -> L14
            goto L17
        L14:
            r15 = move-exception
            goto La1
        L17:
            java.lang.Object r15 = a0(r0, r15)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r1)
            r1 = 0
            if (r2 == 0) goto L4a
            r3 = -1
            java.util.List r4 = androidx.compose.runtime.snapshots.SnapshotKt.f24951i     // Catch: java.lang.Throwable -> L3c
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5     // Catch: java.lang.Throwable -> L3c
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L3c
            r6 = r1
        L2a:
            if (r6 >= r5) goto L3e
            java.lang.Object r7 = r4.get(r6)     // Catch: java.lang.Throwable -> L3c
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch: java.lang.Throwable -> L3c
            java.util.Set r8 = androidx.compose.runtime.collection.ScatterSetWrapperKt.a(r2)     // Catch: java.lang.Throwable -> L3c
            r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L3c
            int r6 = r6 + 1
            goto L2a
        L3c:
            r15 = move-exception
            goto L44
        L3e:
            androidx.compose.runtime.internal.AtomicInt r0 = androidx.compose.runtime.snapshots.SnapshotKt.f24955m
            r0.a(r3)
            goto L4a
        L44:
            androidx.compose.runtime.internal.AtomicInt r0 = androidx.compose.runtime.snapshots.SnapshotKt.f24955m
            r0.a(r3)
            throw r15
        L4a:
            java.lang.Object r0 = J()
            monitor-enter(r0)
            D()     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L9d
            java.lang.Object[] r3 = r2.f3116b     // Catch: java.lang.Throwable -> L8e
            long[] r2 = r2.f3115a     // Catch: java.lang.Throwable -> L8e
            int r4 = r2.length     // Catch: java.lang.Throwable -> L8e
            int r4 = r4 + (-2)
            if (r4 < 0) goto L9b
            r5 = r1
        L5e:
            r6 = r2[r5]     // Catch: java.lang.Throwable -> L8e
            long r8 = ~r6     // Catch: java.lang.Throwable -> L8e
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L96
            int r8 = r5 - r4
            int r8 = ~r8     // Catch: java.lang.Throwable -> L8e
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r1
        L78:
            if (r10 >= r8) goto L94
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L90
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r3[r11]     // Catch: java.lang.Throwable -> L8e
            androidx.compose.runtime.snapshots.StateObject r11 = (androidx.compose.runtime.snapshots.StateObject) r11     // Catch: java.lang.Throwable -> L8e
            U(r11)     // Catch: java.lang.Throwable -> L8e
            goto L90
        L8e:
            r15 = move-exception
            goto L9f
        L90:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L78
        L94:
            if (r8 != r9) goto L9b
        L96:
            if (r5 == r4) goto L9b
            int r5 = r5 + 1
            goto L5e
        L9b:
            kotlin.Unit r1 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L8e
        L9d:
            monitor-exit(r0)
            return r15
        L9f:
            monitor-exit(r0)
            throw r15
        La1:
            monitor-exit(r1)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotKt.B(kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C() {
        B(f24943a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D() {
        SnapshotWeakSet snapshotWeakSet = f24950h;
        int iE = snapshotWeakSet.e();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= iE) {
                break;
            }
            WeakReference weakReference = snapshotWeakSet.f()[i3];
            Object obj = weakReference != null ? weakReference.get() : null;
            if (obj != null && T((StateObject) obj)) {
                if (i4 != i3) {
                    snapshotWeakSet.f()[i4] = weakReference;
                    snapshotWeakSet.d()[i4] = snapshotWeakSet.d()[i3];
                }
                i4++;
            }
            i3++;
        }
        for (int i5 = i4; i5 < iE; i5++) {
            snapshotWeakSet.f()[i5] = null;
            snapshotWeakSet.d()[i5] = 0;
        }
        if (i4 != iE) {
            snapshotWeakSet.g(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot E(Snapshot snapshot, Function1 function1, boolean z2) {
        boolean z3 = snapshot instanceof MutableSnapshot;
        if (z3 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z3 ? (MutableSnapshot) snapshot : null, function1, null, false, z2);
        }
        return new TransparentObserverSnapshot(snapshot, function1, false, z2);
    }

    static /* synthetic */ Snapshot F(Snapshot snapshot, Function1 function1, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return E(snapshot, function1, z2);
    }

    public static final StateRecord G(StateRecord stateRecord) {
        StateRecord stateRecordW;
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotC = companion.c();
        StateRecord stateRecordW2 = W(stateRecord, snapshotC.i(), snapshotC.f());
        if (stateRecordW2 != null) {
            return stateRecordW2;
        }
        synchronized (J()) {
            Snapshot snapshotC2 = companion.c();
            stateRecordW = W(stateRecord, snapshotC2.i(), snapshotC2.f());
        }
        if (stateRecordW != null) {
            return stateRecordW;
        }
        V();
        throw new KotlinNothingValueException();
    }

    public static final StateRecord H(StateRecord stateRecord, Snapshot snapshot) {
        StateRecord stateRecordW;
        StateRecord stateRecordW2 = W(stateRecord, snapshot.i(), snapshot.f());
        if (stateRecordW2 != null) {
            return stateRecordW2;
        }
        synchronized (J()) {
            stateRecordW = W(stateRecord, snapshot.i(), snapshot.f());
        }
        if (stateRecordW != null) {
            return stateRecordW;
        }
        V();
        throw new KotlinNothingValueException();
    }

    public static final Snapshot I() {
        Snapshot snapshot = (Snapshot) f24945c.a();
        return snapshot == null ? f24953k : snapshot;
    }

    public static final Object J() {
        return f24946d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 K(final Function1 function1, final Function1 function12, boolean z2) {
        if (!z2) {
            function12 = null;
        }
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                function1.invoke(obj);
                function12.invoke(obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        };
    }

    static /* synthetic */ Function1 L(Function1 function1, Function1 function12, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        return K(function1, function12, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 M(final Function1 function1, final Function1 function12) {
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(Object obj) {
                function1.invoke(obj);
                function12.invoke(obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(obj);
                return Unit.f139807a;
            }
        };
    }

    public static final StateRecord N(StateRecord stateRecord, StateObject stateObject) {
        StateRecord stateRecordD0 = d0(stateObject);
        if (stateRecordD0 != null) {
            stateRecordD0.i(Long.MAX_VALUE);
            return stateRecordD0;
        }
        StateRecord stateRecordE = stateRecord.e(Long.MAX_VALUE);
        stateRecordE.h(stateObject.p());
        Intrinsics.checkNotNull(stateRecordE, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        stateObject.n(stateRecordE);
        Intrinsics.checkNotNull(stateRecordE, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return stateRecordE;
    }

    public static final StateRecord O(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord stateRecordP;
        synchronized (J()) {
            stateRecordP = P(stateRecord, stateObject, snapshot);
        }
        return stateRecordP;
    }

    private static final StateRecord P(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord stateRecordN = N(stateRecord, stateObject);
        stateRecordN.c(stateRecord);
        stateRecordN.i(snapshot.i());
        return stateRecordN;
    }

    public static final void Q(Snapshot snapshot, StateObject stateObject) {
        snapshot.w(snapshot.j() + 1);
        Function1 function1K = snapshot.k();
        if (function1K != null) {
            function1K.invoke(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map R(long j3, MutableSnapshot mutableSnapshot, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        Map map;
        SnapshotIdSet snapshotIdSet2;
        long[] jArr2;
        Map map2;
        SnapshotIdSet snapshotIdSet3;
        int i3;
        long j4 = j3;
        MutableScatterSet mutableScatterSetG = mutableSnapshot.G();
        Map map3 = null;
        if (mutableScatterSetG == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetO = mutableSnapshot.f().p(mutableSnapshot.i()).o(mutableSnapshot.H());
        Object[] objArr = mutableScatterSetG.f3116b;
        long[] jArr3 = mutableScatterSetG.f3115a;
        int length = jArr3.length - 2;
        if (length < 0) {
            return null;
        }
        HashMap map4 = null;
        int i4 = 0;
        while (true) {
            long j5 = jArr3[i4];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i5 = 8;
                int i6 = 8 - ((~(i4 - length)) >>> 31);
                int i7 = 0;
                while (i7 < i6) {
                    if ((255 & j5) < 128) {
                        StateObject stateObject = (StateObject) objArr[(i4 << 3) + i7];
                        map2 = map3;
                        StateRecord stateRecordP = stateObject.p();
                        i3 = i5;
                        StateRecord stateRecordW = W(stateRecordP, j4, snapshotIdSet);
                        if (stateRecordW == null) {
                            jArr2 = jArr3;
                        } else {
                            jArr2 = jArr3;
                            StateRecord stateRecordW2 = W(stateRecordP, j4, snapshotIdSetO);
                            if (stateRecordW2 != null && !Intrinsics.areEqual(stateRecordW, stateRecordW2)) {
                                snapshotIdSet3 = snapshotIdSetO;
                                StateRecord stateRecordW3 = W(stateRecordP, mutableSnapshot.i(), mutableSnapshot.f());
                                if (stateRecordW3 == null) {
                                    V();
                                    throw new KotlinNothingValueException();
                                }
                                StateRecord stateRecordQ = stateObject.q(stateRecordW2, stateRecordW, stateRecordW3);
                                if (stateRecordQ == null) {
                                    return map2;
                                }
                                if (map4 == null) {
                                    map4 = new HashMap();
                                }
                                map4.put(stateRecordW, stateRecordQ);
                                map4 = map4;
                            }
                        }
                        snapshotIdSet3 = snapshotIdSetO;
                    } else {
                        jArr2 = jArr3;
                        map2 = map3;
                        snapshotIdSet3 = snapshotIdSetO;
                        i3 = i5;
                    }
                    j5 >>= i3;
                    i7++;
                    j4 = j3;
                    map3 = map2;
                    i5 = i3;
                    jArr3 = jArr2;
                    snapshotIdSetO = snapshotIdSet3;
                }
                jArr = jArr3;
                map = map3;
                snapshotIdSet2 = snapshotIdSetO;
                if (i6 != i5) {
                    return map4;
                }
            } else {
                jArr = jArr3;
                map = map3;
                snapshotIdSet2 = snapshotIdSetO;
            }
            if (i4 == length) {
                return map4;
            }
            i4++;
            j4 = j3;
            map3 = map;
            jArr3 = jArr;
            snapshotIdSetO = snapshotIdSet2;
        }
    }

    public static final StateRecord S(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot, StateRecord stateRecord2) {
        StateRecord stateRecordN;
        if (snapshot.h()) {
            snapshot.p(stateObject);
        }
        long jI = snapshot.i();
        if (stateRecord2.g() == jI) {
            return stateRecord2;
        }
        synchronized (J()) {
            stateRecordN = N(stateRecord, stateObject);
        }
        stateRecordN.i(jI);
        if (stateRecord2.g() != SnapshotId_jvmKt.c(1)) {
            snapshot.p(stateObject);
        }
        return stateRecordN;
    }

    private static final boolean T(StateObject stateObject) {
        StateRecord stateRecord;
        long jE = f24949g.e(f24948f);
        StateRecord stateRecord2 = null;
        StateRecord stateRecordP = null;
        int i3 = 0;
        for (StateRecord stateRecordP2 = stateObject.p(); stateRecordP2 != null; stateRecordP2 = stateRecordP2.f()) {
            long jG = stateRecordP2.g();
            if (jG != f24944b) {
                if (jG >= jE) {
                    i3++;
                } else if (stateRecord2 == null) {
                    i3++;
                    stateRecord2 = stateRecordP2;
                } else {
                    if (stateRecordP2.g() < stateRecord2.g()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = stateRecordP2;
                    } else {
                        stateRecord = stateRecordP2;
                    }
                    if (stateRecordP == null) {
                        stateRecordP = stateObject.p();
                        StateRecord stateRecord3 = stateRecordP;
                        while (true) {
                            if (stateRecordP == null) {
                                stateRecordP = stateRecord3;
                                break;
                            }
                            if (stateRecordP.g() >= jE) {
                                break;
                            }
                            if (stateRecord3.g() < stateRecordP.g()) {
                                stateRecord3 = stateRecordP;
                            }
                            stateRecordP = stateRecordP.f();
                        }
                    }
                    stateRecord2.i(f24944b);
                    stateRecord2.c(stateRecordP);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i3 > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(StateObject stateObject) {
        if (T(stateObject)) {
            f24950h.a(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void V() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateRecord W(StateRecord stateRecord, long j3, SnapshotIdSet snapshotIdSet) {
        StateRecord stateRecord2 = null;
        while (stateRecord != null) {
            if (f0(stateRecord, j3, snapshotIdSet) && (stateRecord2 == null || stateRecord2.g() < stateRecord.g())) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.f();
        }
        if (stateRecord2 != null) {
            return stateRecord2;
        }
        return null;
    }

    public static final StateRecord X(StateRecord stateRecord, StateObject stateObject) {
        StateRecord stateRecordW;
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotC = companion.c();
        Function1 function1G = snapshotC.g();
        if (function1G != null) {
            function1G.invoke(stateObject);
        }
        StateRecord stateRecordW2 = W(stateRecord, snapshotC.i(), snapshotC.f());
        if (stateRecordW2 != null) {
            return stateRecordW2;
        }
        synchronized (J()) {
            Snapshot snapshotC2 = companion.c();
            StateRecord stateRecordP = stateObject.p();
            Intrinsics.checkNotNull(stateRecordP, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            stateRecordW = W(stateRecordP, snapshotC2.i(), snapshotC2.f());
            if (stateRecordW == null) {
                V();
                throw new KotlinNothingValueException();
            }
        }
        return stateRecordW;
    }

    public static final void Y(int i3) {
        f24949g.f(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void Z() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object a0(GlobalSnapshot globalSnapshot, Function1 function1) {
        long jI = globalSnapshot.i();
        Object objInvoke = function1.invoke(f24947e.h(jI));
        long j3 = f24948f;
        f24948f = 1 + j3;
        f24947e = f24947e.h(jI);
        globalSnapshot.v(j3);
        globalSnapshot.u(f24947e);
        globalSnapshot.w(0);
        globalSnapshot.S(null);
        globalSnapshot.q();
        f24947e = f24947e.p(j3);
        return objInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot b0(final Function1 function1) {
        return (Snapshot) B(new Function1<SnapshotIdSet, Snapshot>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Snapshot invoke(SnapshotIdSet snapshotIdSet) {
                Snapshot snapshot = (Snapshot) function1.invoke(snapshotIdSet);
                synchronized (SnapshotKt.J()) {
                    SnapshotKt.f24947e = SnapshotKt.f24947e.p(snapshot.i());
                    Unit unit = Unit.f139807a;
                }
                return snapshot;
            }
        });
    }

    public static final int c0(long j3, SnapshotIdSet snapshotIdSet) {
        int iA;
        long jN = snapshotIdSet.n(j3);
        synchronized (J()) {
            iA = f24949g.a(jN);
        }
        return iA;
    }

    private static final StateRecord d0(StateObject stateObject) {
        long jE = f24949g.e(f24948f) - 1;
        SnapshotIdSet snapshotIdSetA = SnapshotIdSet.f24931f.a();
        StateRecord stateRecord = null;
        for (StateRecord stateRecordP = stateObject.p(); stateRecordP != null; stateRecordP = stateRecordP.f()) {
            if (stateRecordP.g() != f24944b) {
                if (f0(stateRecordP, jE, snapshotIdSetA)) {
                    if (stateRecord == null) {
                        stateRecord = stateRecordP;
                    } else if (stateRecordP.g() >= stateRecord.g()) {
                        return stateRecord;
                    }
                }
            }
            return stateRecordP;
        }
        return null;
    }

    private static final boolean e0(long j3, long j4, SnapshotIdSet snapshotIdSet) {
        return (j4 == f24944b || j4 > j3 || snapshotIdSet.l(j4)) ? false : true;
    }

    private static final boolean f0(StateRecord stateRecord, long j3, SnapshotIdSet snapshotIdSet) {
        return e0(j3, stateRecord.g(), snapshotIdSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(Snapshot snapshot) {
        long jE;
        if (f24947e.l(snapshot.i())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Snapshot is not open: snapshotId=");
        sb.append(snapshot.i());
        sb.append(", disposed=");
        sb.append(snapshot.e());
        sb.append(", applied=");
        MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
        sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.F()) : "read-only");
        sb.append(", lowestPin=");
        synchronized (J()) {
            jE = f24949g.e(-1L);
        }
        sb.append(jE);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final StateRecord h0(StateRecord stateRecord, StateObject stateObject, Snapshot snapshot) {
        StateRecord stateRecordW;
        if (snapshot.h()) {
            snapshot.p(stateObject);
        }
        long jI = snapshot.i();
        StateRecord stateRecordW2 = W(stateRecord, jI, snapshot.f());
        if (stateRecordW2 == null) {
            V();
            throw new KotlinNothingValueException();
        }
        if (stateRecordW2.g() == snapshot.i()) {
            return stateRecordW2;
        }
        synchronized (J()) {
            stateRecordW = W(stateObject.p(), jI, snapshot.f());
            if (stateRecordW == null) {
                V();
                throw new KotlinNothingValueException();
            }
            if (stateRecordW.g() != jI) {
                stateRecordW = P(stateRecordW, stateObject, snapshot);
            }
        }
        Intrinsics.checkNotNull(stateRecordW, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (stateRecordW2.g() != SnapshotId_jvmKt.c(1)) {
            snapshot.p(stateObject);
        }
        return stateRecordW;
    }
}
