package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public class MutableSnapshot extends Snapshot {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Companion f24894p = new Companion(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f24895q = 8;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int[] f24896r = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f24897g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1 f24898h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24899i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MutableScatterSet f24900j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List f24901k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private SnapshotIdSet f24902l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int[] f24903m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f24904n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f24905o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MutableSnapshot(long j3, SnapshotIdSet snapshotIdSet, Function1 function1, Function1 function12) {
        super(j3, snapshotIdSet, null);
        this.f24897g = function1;
        this.f24898h = function12;
        this.f24902l = SnapshotIdSet.f24931f.a();
        this.f24903m = f24896r;
        this.f24904n = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void C() {
        /*
            r17 = this;
            r0 = r17
            androidx.collection.MutableScatterSet r1 = r0.G()
            if (r1 == 0) goto L7f
            r0.U()
            r2 = 0
            r0.S(r2)
            long r2 = r0.i()
            java.lang.Object[] r4 = r1.f3116b
            long[] r1 = r1.f3115a
            int r5 = r1.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L7f
            r6 = 0
            r7 = r6
        L1e:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L7a
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L38:
            if (r12 >= r10) goto L78
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L74
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]
            androidx.compose.runtime.snapshots.StateObject r13 = (androidx.compose.runtime.snapshots.StateObject) r13
            androidx.compose.runtime.snapshots.StateRecord r13 = r13.p()
        L4e:
            if (r13 == 0) goto L74
            long r14 = r13.g()
            int r14 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r14 == 0) goto L68
            androidx.compose.runtime.snapshots.SnapshotIdSet r14 = r0.f24902l
            long r15 = r13.g()
            java.lang.Long r15 = java.lang.Long.valueOf(r15)
            boolean r14 = kotlin.collections.CollectionsKt.contains(r14, r15)
            if (r14 == 0) goto L6f
        L68:
            long r14 = androidx.compose.runtime.snapshots.SnapshotKt.i()
            r13.i(r14)
        L6f:
            androidx.compose.runtime.snapshots.StateRecord r13 = r13.f()
            goto L4e
        L74:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L38
        L78:
            if (r10 != r11) goto L7f
        L7a:
            if (r7 == r5) goto L7f
            int r7 = r7 + 1
            goto L1e
        L7f:
            r0.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.C():void");
    }

    private final void Q() {
        int length = this.f24903m.length;
        for (int i3 = 0; i3 < length; i3++) {
            SnapshotKt.Y(this.f24903m[i3]);
        }
    }

    private final void U() {
        if (this.f24905o) {
            PreconditionsKt.b("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void V() {
        if (!this.f24905o || ((Snapshot) this).f24919d >= 0) {
            return;
        }
        PreconditionsKt.b("Unsupported operation on a disposed or applied snapshot");
    }

    public final void D() {
        M(i());
        Unit unit = Unit.f139807a;
        if (F() || e()) {
            return;
        }
        long jI = i();
        synchronized (SnapshotKt.J()) {
            long j3 = SnapshotKt.f24948f;
            SnapshotKt.f24948f++;
            v(j3);
            SnapshotKt.f24947e = SnapshotKt.f24947e.p(i());
        }
        u(SnapshotKt.A(f(), jI + 1, i()));
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult E() {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.E():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    public final boolean F() {
        return this.f24905o;
    }

    public MutableScatterSet G() {
        return this.f24900j;
    }

    public final SnapshotIdSet H() {
        return this.f24902l;
    }

    public final int[] I() {
        return this.f24903m;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* JADX INFO: renamed from: J */
    public Function1 g() {
        return this.f24897g;
    }

    public boolean K() {
        MutableScatterSet mutableScatterSetG = G();
        return mutableScatterSetG != null && mutableScatterSetG.f();
    }

    public final SnapshotApplyResult L(long j3, MutableScatterSet mutableScatterSet, Map map, SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        Object[] objArr;
        long[] jArr;
        SnapshotIdSet snapshotIdSet3;
        Object[] objArr2;
        long[] jArr2;
        int i3;
        long j4;
        int i4;
        StateRecord stateRecordQ;
        SnapshotIdSet snapshotIdSetO = f().p(i()).o(this.f24902l);
        Object[] objArr3 = mutableScatterSet.f3116b;
        long[] jArr3 = mutableScatterSet.f3115a;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        List listPlus = null;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr3[i5];
                List arrayList2 = listPlus;
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8;
                    int i7 = 8 - ((~(i5 - length)) >>> 31);
                    int i8 = 0;
                    while (i8 < i7) {
                        if ((j5 & 255) < 128) {
                            i3 = i6;
                            StateObject stateObject = (StateObject) objArr3[(i5 << 3) + i8];
                            objArr2 = objArr3;
                            StateRecord stateRecordP = stateObject.p();
                            jArr2 = jArr3;
                            ArrayList arrayList3 = arrayList;
                            StateRecord stateRecordW = SnapshotKt.W(stateRecordP, j3, snapshotIdSet);
                            if (stateRecordW == null) {
                                j4 = j5;
                            } else {
                                j4 = j5;
                                StateRecord stateRecordW2 = SnapshotKt.W(stateRecordP, i(), snapshotIdSetO);
                                if (stateRecordW2 != null && stateRecordW2.g() != SnapshotId_jvmKt.c(1) && !Intrinsics.areEqual(stateRecordW, stateRecordW2)) {
                                    i4 = i8;
                                    snapshotIdSet3 = snapshotIdSetO;
                                    StateRecord stateRecordW3 = SnapshotKt.W(stateRecordP, i(), f());
                                    if (stateRecordW3 == null) {
                                        SnapshotKt.V();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (map == null || (stateRecordQ = (StateRecord) map.get(stateRecordW)) == null) {
                                        stateRecordQ = stateObject.q(stateRecordW2, stateRecordW, stateRecordW3);
                                    }
                                    if (stateRecordQ == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!Intrinsics.areEqual(stateRecordQ, stateRecordW3)) {
                                        if (Intrinsics.areEqual(stateRecordQ, stateRecordW)) {
                                            ArrayList arrayList4 = arrayList3 == null ? new ArrayList() : arrayList3;
                                            arrayList4.add(TuplesKt.a(stateObject, stateRecordW.e(i())));
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            List list = arrayList2;
                                            list.add(stateObject);
                                            arrayList = arrayList4;
                                            arrayList2 = list;
                                        } else {
                                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                                            arrayList.add(!Intrinsics.areEqual(stateRecordQ, stateRecordW2) ? TuplesKt.a(stateObject, stateRecordQ) : TuplesKt.a(stateObject, stateRecordW2.e(i())));
                                        }
                                    }
                                }
                                arrayList = arrayList3;
                            }
                            snapshotIdSet3 = snapshotIdSetO;
                            i4 = i8;
                            arrayList = arrayList3;
                        } else {
                            snapshotIdSet3 = snapshotIdSetO;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i3 = i6;
                            j4 = j5;
                            i4 = i8;
                        }
                        j5 = j4 >> i3;
                        i8 = i4 + 1;
                        objArr3 = objArr2;
                        i6 = i3;
                        jArr3 = jArr2;
                        snapshotIdSetO = snapshotIdSet3;
                    }
                    snapshotIdSet2 = snapshotIdSetO;
                    objArr = objArr3;
                    jArr = jArr3;
                    ArrayList arrayList5 = arrayList;
                    if (i7 != i6) {
                        listPlus = arrayList2;
                        arrayList = arrayList5;
                        break;
                    }
                    arrayList = arrayList5;
                } else {
                    snapshotIdSet2 = snapshotIdSetO;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                listPlus = arrayList2;
                if (i5 == length) {
                    break;
                }
                i5++;
                objArr3 = objArr;
                jArr3 = jArr;
                snapshotIdSetO = snapshotIdSet2;
            }
        }
        if (arrayList != null) {
            D();
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                Pair pair = (Pair) arrayList.get(i9);
                StateObject stateObject2 = (StateObject) pair.a();
                StateRecord stateRecord = (StateRecord) pair.b();
                stateRecord.i(j3);
                synchronized (SnapshotKt.J()) {
                    stateRecord.h(stateObject2.p());
                    stateObject2.n(stateRecord);
                    Unit unit = Unit.f139807a;
                }
            }
        }
        if (listPlus != null) {
            int size2 = listPlus.size();
            for (int i10 = 0; i10 < size2; i10++) {
                mutableScatterSet.z((StateObject) listPlus.get(i10));
            }
            List list2 = this.f24901k;
            if (list2 != null) {
                listPlus = CollectionsKt.plus((Collection) list2, (Iterable) listPlus);
            }
            this.f24901k = listPlus;
        }
        return SnapshotApplyResult.Success.f24922a;
    }

    public final void M(long j3) {
        synchronized (SnapshotKt.J()) {
            this.f24902l = this.f24902l.p(j3);
            Unit unit = Unit.f139807a;
        }
    }

    public final void N(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.J()) {
            this.f24902l = this.f24902l.o(snapshotIdSet);
            Unit unit = Unit.f139807a;
        }
    }

    public final void O(int i3) {
        if (i3 >= 0) {
            this.f24903m = ArraysKt.plus(this.f24903m, i3);
        }
    }

    public final void P(int[] iArr) {
        if (iArr.length == 0) {
            return;
        }
        int[] iArr2 = this.f24903m;
        if (iArr2.length != 0) {
            iArr = ArraysKt.plus(iArr2, iArr);
        }
        this.f24903m = iArr;
    }

    public final void R(boolean z2) {
        this.f24905o = z2;
    }

    public void S(MutableScatterSet mutableScatterSet) {
        this.f24900j = mutableScatterSet;
    }

    public MutableSnapshot T(Function1 function1, Function1 function12) {
        Map map;
        NestedMutableSnapshot nestedMutableSnapshot;
        B();
        V();
        PersistentList persistentList = SnapshotObserverKt.f25057a;
        Function1 function13 = function1;
        Function1 function1B = function12;
        if (persistentList != null) {
            Pair pairE = SnapshotObserverKt.e(persistentList, this, false, function13, function1B);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairE.e();
            Function1 function1A = snapshotInstanceObservers.a();
            function1B = snapshotInstanceObservers.b();
            map = (Map) pairE.f();
            function13 = function1A;
        } else {
            map = null;
        }
        M(i());
        synchronized (SnapshotKt.J()) {
            long j3 = SnapshotKt.f24948f;
            SnapshotKt.f24948f++;
            SnapshotKt.f24947e = SnapshotKt.f24947e.p(j3);
            SnapshotIdSet snapshotIdSetF = f();
            u(snapshotIdSetF.p(j3));
            nestedMutableSnapshot = new NestedMutableSnapshot(j3, SnapshotKt.A(snapshotIdSetF, i() + 1, j3), SnapshotKt.L(function13, g(), false, 4, null), SnapshotKt.M(function1B, k()), this);
        }
        if (!F() && !e()) {
            long jI = i();
            synchronized (SnapshotKt.J()) {
                long j4 = SnapshotKt.f24948f;
                SnapshotKt.f24948f++;
                v(j4);
                SnapshotKt.f24947e = SnapshotKt.f24947e.p(i());
                Unit unit = Unit.f139807a;
            }
            u(SnapshotKt.A(f(), jI + 1, i()));
        }
        if (persistentList != null) {
            SnapshotObserverKt.b(persistentList, this, nestedMutableSnapshot, map);
        }
        return nestedMutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void c() {
        SnapshotKt.f24947e = SnapshotKt.f24947e.h(i()).g(this.f24902l);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void d() {
        if (e()) {
            return;
        }
        super.d();
        n(this);
        SnapshotObserverKt.d(this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean h() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public int j() {
        return this.f24899i;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1 k() {
        return this.f24898h;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void m(Snapshot snapshot) {
        this.f24904n++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void n(Snapshot snapshot) {
        if (!(this.f24904n > 0)) {
            PreconditionsKt.a("no pending nested snapshots");
        }
        int i3 = this.f24904n - 1;
        this.f24904n = i3;
        if (i3 != 0 || this.f24905o) {
            return;
        }
        C();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void o() {
        if (this.f24905o || e()) {
            return;
        }
        D();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void p(StateObject stateObject) {
        MutableScatterSet mutableScatterSetG = G();
        if (mutableScatterSetG == null) {
            mutableScatterSetG = ScatterSetKt.a();
            S(mutableScatterSetG);
        }
        mutableScatterSetG.i(stateObject);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void r() {
        Q();
        super.r();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void w(int i3) {
        this.f24899i = i3;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot x(Function1 function1) {
        Function1 function12;
        Map map;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        B();
        V();
        long jI = i();
        MutableSnapshot mutableSnapshot = this instanceof GlobalSnapshot ? null : this;
        PersistentList persistentList = SnapshotObserverKt.f25057a;
        if (persistentList != null) {
            Pair pairE = SnapshotObserverKt.e(persistentList, mutableSnapshot, true, function1, null);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairE.e();
            Function1 function1A = snapshotInstanceObservers.a();
            snapshotInstanceObservers.b();
            function12 = function1A;
            map = (Map) pairE.f();
        } else {
            function12 = function1;
            map = null;
        }
        M(i());
        synchronized (SnapshotKt.J()) {
            long j3 = SnapshotKt.f24948f;
            SnapshotKt.f24948f++;
            SnapshotKt.f24947e = SnapshotKt.f24947e.p(j3);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(j3, SnapshotKt.A(f(), jI + 1, j3), SnapshotKt.L(function12, g(), false, 4, null), this);
        }
        if (!F() && !e()) {
            long jI2 = i();
            synchronized (SnapshotKt.J()) {
                long j4 = SnapshotKt.f24948f;
                SnapshotKt.f24948f++;
                v(j4);
                SnapshotKt.f24947e = SnapshotKt.f24947e.p(i());
                Unit unit = Unit.f139807a;
            }
            u(SnapshotKt.A(f(), jI2 + 1, i()));
        }
        if (persistentList != null) {
            SnapshotObserverKt.b(persistentList, mutableSnapshot, nestedReadonlySnapshot, map);
        }
        return nestedReadonlySnapshot;
    }
}
