package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.compose.animation.core.h;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

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
public final class SnapshotStateObserver {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f24978l = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f24979a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24981c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ObserverHandle f24986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f24987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ObservedScopeMap f24988j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference f24980b = new AtomicReference(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function2 f24982d = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        {
            super(2);
        }

        public final void c(Set set, Snapshot snapshot) {
            this.f25003a.j(set);
            if (this.f25003a.n()) {
                this.f25003a.s();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((Set) obj, (Snapshot) obj2);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1 f24983e = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
        {
            super(1);
        }

        public final void c(Object obj) {
            if (this.f25004a.f24987i) {
                return;
            }
            Object obj2 = this.f25004a.f24985g;
            SnapshotStateObserver snapshotStateObserver = this.f25004a;
            synchronized (obj2) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.f24988j;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.k(obj);
                Unit unit = Unit.f139807a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c(obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableVector f24984f = new MutableVector(new ObservedScopeMap[16], 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f24985g = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f24989k = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class ObservedScopeMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function1 f24990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f24991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private MutableObjectIntMap f24992c;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f24999j;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f24993d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final MutableScatterMap f24994e = ScopeMap.e(null, 1, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MutableScatterMap f24995f = new MutableScatterMap(0, 1, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final MutableScatterSet f24996g = new MutableScatterSet(0, 1, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final MutableVector f24997h = new MutableVector(new DerivedState[16], 0);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final DerivedStateObserver f24998i = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void a(DerivedState derivedState) {
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.f25002a;
                observedScopeMap.f24999j--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void b(DerivedState derivedState) {
                this.f25002a.f24999j++;
            }
        };

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final MutableScatterMap f25000k = ScopeMap.e(null, 1, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private final HashMap f25001l = new HashMap();

        public ObservedScopeMap(Function1 function1) {
            this.f24990a = function1;
        }

        private final void d(Object obj) {
            int i3 = this.f24993d;
            MutableObjectIntMap mutableObjectIntMap = this.f24992c;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.f3075a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                long j3 = jArr[i4];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i4 - length)) >>> 31);
                    for (int i6 = 0; i6 < i5; i6++) {
                        if ((255 & j3) < 128) {
                            int i7 = (i4 << 3) + i6;
                            Object obj2 = mutableObjectIntMap.f3076b[i7];
                            boolean z2 = mutableObjectIntMap.f3077c[i7] != i3;
                            if (z2) {
                                m(obj, obj2);
                            }
                            if (z2) {
                                mutableObjectIntMap.s(i7);
                            }
                        }
                        j3 >>= 8;
                    }
                    if (i5 != 8) {
                        return;
                    }
                }
                if (i4 == length) {
                    return;
                } else {
                    i4++;
                }
            }
        }

        private final void l(Object obj, int i3, Object obj2, MutableObjectIntMap mutableObjectIntMap) {
            int i4;
            int i5;
            int i6;
            if (this.f24999j > 0) {
                return;
            }
            int iQ = mutableObjectIntMap.q(obj, i3, -1);
            int i7 = 2;
            if (!(obj instanceof DerivedState) || iQ == i3) {
                i4 = 2;
                i5 = -1;
            } else {
                DerivedState.Record recordU = ((DerivedState) obj).u();
                this.f25001l.put(obj, recordU.a());
                ObjectIntMap objectIntMapB = recordU.b();
                MutableScatterMap mutableScatterMap = this.f25000k;
                ScopeMap.k(mutableScatterMap, obj);
                Object[] objArr = objectIntMapB.f3076b;
                long[] jArr = objectIntMapB.f3075a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i8 = 0;
                    while (true) {
                        long j3 = jArr[i8];
                        if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i9 = 8 - ((~(i8 - length)) >>> 31);
                            int i10 = 0;
                            while (i10 < i9) {
                                if ((j3 & 255) < 128) {
                                    i6 = i7;
                                    StateObject stateObject = (StateObject) objArr[(i8 << 3) + i10];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ((StateObjectImpl) stateObject).r(ReaderKind.a(i6));
                                    }
                                    ScopeMap.a(mutableScatterMap, stateObject, obj);
                                } else {
                                    i6 = i7;
                                }
                                j3 >>= 8;
                                i10++;
                                i7 = i6;
                            }
                            i4 = i7;
                            if (i9 != 8) {
                                break;
                            }
                        } else {
                            i4 = i7;
                        }
                        if (i8 == length) {
                            break;
                        }
                        i8++;
                        i7 = i4;
                    }
                } else {
                    i4 = 2;
                }
                i5 = -1;
            }
            if (iQ == i5) {
                if (obj instanceof StateObjectImpl) {
                    ((StateObjectImpl) obj).r(ReaderKind.a(i4));
                }
                ScopeMap.a(this.f24994e, obj, obj2);
            }
        }

        private final void m(Object obj, Object obj2) {
            ScopeMap.j(this.f24994e, obj2, obj);
            if (!(obj2 instanceof DerivedState) || ScopeMap.f(this.f24994e, obj2)) {
                return;
            }
            ScopeMap.k(this.f25000k, obj2);
            this.f25001l.remove(obj2);
        }

        public final void c() {
            ScopeMap.c(this.f24994e);
            this.f24995f.k();
            ScopeMap.c(this.f25000k);
            this.f25001l.clear();
        }

        public final void e(Object obj) {
            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) this.f24995f.u(obj);
            if (mutableObjectIntMap == null) {
                return;
            }
            Object[] objArr = mutableObjectIntMap.f3076b;
            int[] iArr = mutableObjectIntMap.f3077c;
            long[] jArr = mutableObjectIntMap.f3075a;
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
                            int i6 = (i3 << 3) + i5;
                            Object obj2 = objArr[i6];
                            int i7 = iArr[i6];
                            m(obj, obj2);
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

        public final Function1 f() {
            return this.f24990a;
        }

        public final boolean g() {
            return this.f24995f.i();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void h() {
            /*
                r17 = this;
                r0 = r17
                androidx.collection.MutableScatterSet r1 = r0.f24996g
                kotlin.jvm.functions.Function1 r2 = r0.f24990a
                java.lang.Object[] r3 = r1.f3116b
                long[] r4 = r1.f3115a
                int r5 = r4.length
                int r5 = r5 + (-2)
                if (r5 < 0) goto L49
                r6 = 0
                r7 = r6
            L11:
                r8 = r4[r7]
                long r10 = ~r8
                r12 = 7
                long r10 = r10 << r12
                long r10 = r10 & r8
                r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r10 = r10 & r12
                int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                if (r10 == 0) goto L44
                int r10 = r7 - r5
                int r10 = ~r10
                int r10 = r10 >>> 31
                r11 = 8
                int r10 = 8 - r10
                r12 = r6
            L2b:
                if (r12 >= r10) goto L42
                r13 = 255(0xff, double:1.26E-321)
                long r13 = r13 & r8
                r15 = 128(0x80, double:6.3E-322)
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 >= 0) goto L3e
                int r13 = r7 << 3
                int r13 = r13 + r12
                r13 = r3[r13]
                r2.invoke(r13)
            L3e:
                long r8 = r8 >> r11
                int r12 = r12 + 1
                goto L2b
            L42:
                if (r10 != r11) goto L49
            L44:
                if (r7 == r5) goto L49
                int r7 = r7 + 1
                goto L11
            L49:
                r1.n()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.h():void");
        }

        public final void i(Object obj, Function1 function1, Function0 function0) {
            Object obj2 = this.f24991b;
            MutableObjectIntMap mutableObjectIntMap = this.f24992c;
            int i3 = this.f24993d;
            this.f24991b = obj;
            this.f24992c = (MutableObjectIntMap) this.f24995f.e(obj);
            if (this.f24993d == -1) {
                this.f24993d = Long.hashCode(SnapshotKt.I().i());
            }
            DerivedStateObserver derivedStateObserver = this.f24998i;
            MutableVector mutableVectorC = SnapshotStateKt.c();
            try {
                mutableVectorC.b(derivedStateObserver);
                Snapshot.f24914e.g(function1, null, function0);
                mutableVectorC.u(mutableVectorC.o() - 1);
                Object obj3 = this.f24991b;
                Intrinsics.checkNotNull(obj3);
                d(obj3);
                this.f24991b = obj2;
                this.f24992c = mutableObjectIntMap;
                this.f24993d = i3;
            } catch (Throwable th) {
                mutableVectorC.u(mutableVectorC.o() - 1);
                throw th;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x023f  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x02a2 A[PHI: r11
          0x02a2: PHI (r11v50 boolean) = (r11v49 boolean), (r11v51 boolean) binds: [B:111:0x027a, B:119:0x02a0] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:179:0x03fd A[PHI: r13
          0x03fd: PHI (r13v7 boolean) = (r13v6 boolean), (r13v8 boolean) binds: [B:170:0x03d0, B:178:0x03fb] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:217:0x04c0 A[PHI: r11
          0x04c0: PHI (r11v14 boolean) = (r11v13 boolean), (r11v15 boolean) binds: [B:208:0x0498, B:216:0x04be] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:221:0x04d0  */
        /* JADX WARN: Removed duplicated region for block: B:224:0x04da  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0146 A[PHI: r37
          0x0146: PHI (r37v5 boolean) = (r37v4 boolean), (r37v6 boolean) binds: [B:47:0x011a, B:56:0x0144] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0151  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x022f A[PHI: r11
          0x022f: PHI (r11v60 boolean) = (r11v59 boolean), (r11v61 boolean) binds: [B:87:0x0207, B:95:0x022d] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean j(java.util.Set r44) {
            /*
                Method dump skipped, instruction units count: 1365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.j(java.util.Set):boolean");
        }

        public final void k(Object obj) {
            Object obj2 = this.f24991b;
            Intrinsics.checkNotNull(obj2);
            int i3 = this.f24993d;
            MutableObjectIntMap mutableObjectIntMap = this.f24992c;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
                this.f24992c = mutableObjectIntMap;
                this.f24995f.x(obj2, mutableObjectIntMap);
                Unit unit = Unit.f139807a;
            }
            l(obj, i3, obj2, mutableObjectIntMap);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void n(kotlin.jvm.functions.Function1 r34) {
            /*
                Method dump skipped, instruction units count: 225
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.n(kotlin.jvm.functions.Function1):void");
        }

        public final void o(DerivedState derivedState) {
            long[] jArr;
            long[] jArr2;
            int i3;
            MutableObjectIntMap mutableObjectIntMap;
            MutableScatterMap mutableScatterMap = this.f24995f;
            int iHashCode = Long.hashCode(SnapshotKt.I().i());
            Object objE = this.f24994e.e(derivedState);
            if (objE == null) {
                return;
            }
            if (!(objE instanceof MutableScatterSet)) {
                MutableObjectIntMap mutableObjectIntMap2 = (MutableObjectIntMap) mutableScatterMap.e(objE);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap(0, 1, null);
                    mutableScatterMap.x(objE, mutableObjectIntMap2);
                    Unit unit = Unit.f139807a;
                }
                l(derivedState, iHashCode, objE, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) objE;
            Object[] objArr = mutableScatterSet.f3116b;
            long[] jArr3 = mutableScatterSet.f3115a;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                long j3 = jArr3[i4];
                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8;
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j3 & 255) < 128) {
                            i3 = i5;
                            Object obj = objArr[(i4 << 3) + i7];
                            MutableObjectIntMap mutableObjectIntMap3 = (MutableObjectIntMap) mutableScatterMap.e(obj);
                            jArr2 = jArr3;
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
                                mutableScatterMap.x(obj, mutableObjectIntMap);
                                Unit unit2 = Unit.f139807a;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            l(derivedState, iHashCode, obj, mutableObjectIntMap);
                        } else {
                            jArr2 = jArr3;
                            i3 = i5;
                        }
                        j3 >>= i3;
                        i7++;
                        i5 = i3;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i6 != i5) {
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i4 == length) {
                    return;
                }
                i4++;
                jArr3 = jArr;
            }
        }
    }

    public SnapshotStateObserver(Function1 function1) {
        this.f24979a = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j(Set set) {
        Object obj;
        List listPlus;
        do {
            obj = this.f24980b.get();
            if (obj == null) {
                listPlus = set;
            } else if (obj instanceof Set) {
                listPlus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    r();
                    throw new KotlinNothingValueException();
                }
                listPlus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!h.a(this.f24980b, obj, listPlus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n() {
        boolean z2;
        synchronized (this.f24985g) {
            z2 = this.f24981c;
        }
        if (z2) {
            return false;
        }
        boolean z3 = false;
        while (true) {
            Set setQ = q();
            if (setQ == null) {
                return z3;
            }
            synchronized (this.f24985g) {
                try {
                    MutableVector mutableVector = this.f24984f;
                    Object[] objArr = mutableVector.f24389a;
                    int iO = mutableVector.o();
                    for (int i3 = 0; i3 < iO; i3++) {
                        z3 = ((ObservedScopeMap) objArr[i3]).j(setQ) || z3;
                    }
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final ObservedScopeMap o(Function1 function1) {
        Object obj;
        MutableVector mutableVector = this.f24984f;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        int i3 = 0;
        while (true) {
            if (i3 >= iO) {
                obj = null;
                break;
            }
            obj = objArr[i3];
            if (((ObservedScopeMap) obj).f() == function1) {
                break;
            }
            i3++;
        }
        ObservedScopeMap observedScopeMap = (ObservedScopeMap) obj;
        if (observedScopeMap != null) {
            return observedScopeMap;
        }
        Intrinsics.checkNotNull(function1, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap2 = new ObservedScopeMap((Function1) TypeIntrinsics.f(function1, 1));
        this.f24984f.b(observedScopeMap2);
        return observedScopeMap2;
    }

    private final Set q() {
        Object obj;
        Object objSubList;
        Set set;
        do {
            obj = this.f24980b.get();
            objSubList = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    r();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    objSubList = list.get(1);
                } else if (list.size() > 2) {
                    objSubList = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!h.a(this.f24980b, obj, objSubList));
        return set;
    }

    private final Void r() {
        ComposerKt.u("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.f24979a.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m208invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m208invoke() {
                do {
                    Object obj = this.f25005a.f24985g;
                    SnapshotStateObserver snapshotStateObserver = this.f25005a;
                    synchronized (obj) {
                        try {
                            if (!snapshotStateObserver.f24981c) {
                                snapshotStateObserver.f24981c = true;
                                try {
                                    MutableVector mutableVector = snapshotStateObserver.f24984f;
                                    Object[] objArr = mutableVector.f24389a;
                                    int iO = mutableVector.o();
                                    for (int i3 = 0; i3 < iO; i3++) {
                                        ((SnapshotStateObserver.ObservedScopeMap) objArr[i3]).h();
                                    }
                                    snapshotStateObserver.f24981c = false;
                                } finally {
                                }
                            }
                            Unit unit = Unit.f139807a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } while (this.f25005a.n());
            }
        });
    }

    public final void k() {
        synchronized (this.f24985g) {
            try {
                MutableVector mutableVector = this.f24984f;
                Object[] objArr = mutableVector.f24389a;
                int iO = mutableVector.o();
                for (int i3 = 0; i3 < iO; i3++) {
                    ((ObservedScopeMap) objArr[i3]).c();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l(Object obj) {
        synchronized (this.f24985g) {
            try {
                MutableVector mutableVector = this.f24984f;
                int iO = mutableVector.o();
                int i3 = 0;
                for (int i4 = 0; i4 < iO; i4++) {
                    ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.f24389a[i4];
                    observedScopeMap.e(obj);
                    if (!observedScopeMap.g()) {
                        i3++;
                    } else if (i3 > 0) {
                        Object[] objArr = mutableVector.f24389a;
                        objArr[i4 - i3] = objArr[i4];
                    }
                }
                int i5 = iO - i3;
                ArraysKt.fill(mutableVector.f24389a, (Object) null, i5, iO);
                mutableVector.z(i5);
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(Function1 function1) {
        synchronized (this.f24985g) {
            try {
                MutableVector mutableVector = this.f24984f;
                int iO = mutableVector.o();
                int i3 = 0;
                for (int i4 = 0; i4 < iO; i4++) {
                    ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.f24389a[i4];
                    observedScopeMap.n(function1);
                    if (!observedScopeMap.g()) {
                        i3++;
                    } else if (i3 > 0) {
                        Object[] objArr = mutableVector.f24389a;
                        objArr[i4 - i3] = objArr[i4];
                    }
                }
                int i5 = iO - i3;
                ArraysKt.fill(mutableVector.f24389a, (Object) null, i5, iO);
                mutableVector.z(i5);
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p(Object obj, Function1 function1, Function0 function0) {
        ObservedScopeMap observedScopeMapO;
        synchronized (this.f24985g) {
            observedScopeMapO = o(function1);
        }
        boolean z2 = this.f24987i;
        ObservedScopeMap observedScopeMap = this.f24988j;
        long j3 = this.f24989k;
        if (j3 != -1) {
            if (!(j3 == Thread_jvmKt.a())) {
                PreconditionsKt.a("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j3 + "), currentThread={id=" + Thread_jvmKt.a() + ", name=" + Thread_jvmKt.b() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.f24987i = false;
            this.f24988j = observedScopeMapO;
            this.f24989k = Thread_jvmKt.a();
            observedScopeMapO.i(obj, this.f24983e, function0);
        } finally {
            this.f24988j = observedScopeMap;
            this.f24987i = z2;
            this.f24989k = j3;
        }
    }

    public final void t() {
        this.f24986h = Snapshot.f24914e.i(this.f24982d);
    }

    public final void u() {
        ObserverHandle observerHandle = this.f24986h;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }
}
