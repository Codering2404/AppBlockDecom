package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.changelist.FixupList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.internal.Utils_jvmKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
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
public final class ComposerImpl implements Composer {
    private int B;
    private int C;
    private boolean D;
    private final ComposerImpl$derivedStateObserver$1 E;
    private final ArrayList F;
    private boolean G;
    private boolean H;
    private SlotReader I;
    private SlotTable J;
    private SlotWriter K;
    private boolean L;
    private PersistentCompositionLocalMap M;
    private ChangeList N;
    private final ComposerChangeListWriter O;
    private Anchor P;
    private FixupList Q;
    private ShouldPauseCallback R;
    private boolean S;
    private int T;
    private CompositionData U;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Applier f23749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CompositionContext f23750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SlotTable f23751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set f23752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ChangeList f23753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ChangeList f23754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ControlledComposition f23755h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Pending f23757j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f23758k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f23759l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f23760m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f23762o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private MutableIntIntMap f23763p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f23764q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f23765r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f23766s;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private MutableIntObjectMap f23770w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f23771x;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f23773z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ArrayList f23756i = Stack.c(null, 1, null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final IntStack f23761n = new IntStack();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final List f23767t = new ArrayList();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final IntStack f23768u = new IntStack();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private PersistentCompositionLocalMap f23769v = PersistentCompositionLocalMapKt.a();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final IntStack f23772y = new IntStack();
    private int A = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class CompositionContextImpl extends CompositionContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f23775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f23776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f23777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final CompositionObserverHolder f23778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Set f23779e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Set f23780f = new LinkedHashSet();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final MutableState f23781g = SnapshotStateKt.i(PersistentCompositionLocalMapKt.a(), SnapshotStateKt.o());

        public CompositionContextImpl(int i3, boolean z2, boolean z3, CompositionObserverHolder compositionObserverHolder) {
            this.f23775a = i3;
            this.f23776b = z2;
            this.f23777c = z3;
            this.f23778d = compositionObserverHolder;
        }

        private final PersistentCompositionLocalMap y() {
            return (PersistentCompositionLocalMap) this.f23781g.getValue();
        }

        private final void z(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            this.f23781g.setValue(persistentCompositionLocalMap);
        }

        public final void A(PersistentCompositionLocalMap persistentCompositionLocalMap) {
            z(persistentCompositionLocalMap);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void a(ControlledComposition controlledComposition, Function2 function2) {
            ComposerImpl.this.f23750c.a(controlledComposition, function2);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void b(MovableContentStateReference movableContentStateReference) {
            ComposerImpl.this.f23750c.b(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void c() {
            ComposerImpl composerImpl = ComposerImpl.this;
            composerImpl.B--;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean d() {
            return ComposerImpl.this.f23750c.d();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean e() {
            return this.f23776b;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean f() {
            return this.f23777c;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public PersistentCompositionLocalMap g() {
            return y();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public int h() {
            return this.f23775a;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext i() {
            return ComposerImpl.this.f23750c.i();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CompositionObserverHolder j() {
            return this.f23778d;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext k() {
            return CompositionKt.d(ComposerImpl.this.K0());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void l(MovableContentStateReference movableContentStateReference) {
            ComposerImpl.this.f23750c.l(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void m(ControlledComposition controlledComposition) {
            ComposerImpl.this.f23750c.m(ComposerImpl.this.K0());
            ComposerImpl.this.f23750c.m(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void n(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState, Applier applier) {
            ComposerImpl.this.f23750c.n(movableContentStateReference, movableContentState, applier);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public MovableContentState o(MovableContentStateReference movableContentStateReference) {
            return ComposerImpl.this.f23750c.o(movableContentStateReference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void p(Set set) {
            Set hashSet = this.f23779e;
            if (hashSet == null) {
                hashSet = new HashSet();
                this.f23779e = hashSet;
            }
            hashSet.add(set);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void q(Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.q((ComposerImpl) composer);
            this.f23780f.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void r(RecomposeScopeImpl recomposeScopeImpl) {
            ComposerImpl.this.f23750c.r(recomposeScopeImpl);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void s(ControlledComposition controlledComposition) {
            ComposerImpl.this.f23750c.s(controlledComposition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void t() {
            ComposerImpl.this.B++;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void u(Composer composer) {
            Set<Set> set = this.f23779e;
            if (set != null) {
                for (Set set2 : set) {
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    set2.remove(((ComposerImpl) composer).f23751d);
                }
            }
            TypeIntrinsics.a(this.f23780f).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void v(ControlledComposition controlledComposition) {
            ComposerImpl.this.f23750c.v(controlledComposition);
        }

        public final void w() {
            if (this.f23780f.isEmpty()) {
                return;
            }
            Set set = this.f23779e;
            if (set != null) {
                for (ComposerImpl composerImpl : this.f23780f) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((Set) it.next()).remove(composerImpl.f23751d);
                    }
                }
            }
            this.f23780f.clear();
        }

        public final Set x() {
            return this.f23780f;
        }
    }

    /* JADX WARN: Type inference failed for: r5v11, types: [androidx.compose.runtime.ComposerImpl$derivedStateObserver$1] */
    public ComposerImpl(Applier applier, CompositionContext compositionContext, SlotTable slotTable, Set set, ChangeList changeList, ChangeList changeList2, ControlledComposition controlledComposition) {
        this.f23749b = applier;
        this.f23750c = compositionContext;
        this.f23751d = slotTable;
        this.f23752e = set;
        this.f23753f = changeList;
        this.f23754g = changeList2;
        this.f23755h = controlledComposition;
        this.D = compositionContext.f() || compositionContext.d();
        this.E = new DerivedStateObserver() { // from class: androidx.compose.runtime.ComposerImpl$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void a(DerivedState derivedState) {
                ComposerImpl composerImpl = this.f23783a;
                composerImpl.B--;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void b(DerivedState derivedState) {
                this.f23783a.B++;
            }
        };
        this.F = Stack.c(null, 1, null);
        SlotReader slotReaderB = slotTable.B();
        slotReaderB.d();
        this.I = slotReaderB;
        SlotTable slotTable2 = new SlotTable();
        if (compositionContext.f()) {
            slotTable2.n();
        }
        if (compositionContext.d()) {
            slotTable2.l();
        }
        this.J = slotTable2;
        SlotWriter slotWriterC = slotTable2.C();
        slotWriterC.L(true);
        this.K = slotWriterC;
        this.O = new ComposerChangeListWriter(this, this.f23753f);
        SlotReader slotReaderB2 = this.J.B();
        try {
            Anchor anchorA = slotReaderB2.a(0);
            slotReaderB2.d();
            this.P = anchorA;
            this.Q = new FixupList();
        } catch (Throwable th) {
            slotReaderB2.d();
            throw th;
        }
    }

    private final void A0(boolean z2) {
        int iHashCode;
        int iW;
        List list;
        List list2;
        int iHashCode2;
        int iE = this.f23761n.e() - 1;
        if (i()) {
            int iE0 = this.K.e0();
            int iK0 = this.K.k0(iE0);
            Object objL0 = this.K.l0(iE0);
            Object objI0 = this.K.i0(iE0);
            if (objL0 != null) {
                iHashCode2 = Integer.hashCode(objL0 instanceof Enum ? ((Enum) objL0).ordinal() : objL0.hashCode()) ^ Integer.rotateRight(V(), 3);
            } else if (objI0 == null || iK0 != 207 || Intrinsics.areEqual(objI0, Composer.f23746a.a())) {
                iHashCode2 = Integer.rotateRight(iE ^ V(), 3) ^ Integer.hashCode(iK0);
            } else {
                this.T = Integer.rotateRight(Integer.rotateRight(iE ^ V(), 3) ^ Integer.hashCode(objI0.hashCode()), 3);
            }
            this.T = Integer.rotateRight(iHashCode2, 3);
        } else {
            int iU = this.I.u();
            int iC = this.I.C(iU);
            Object objD = this.I.D(iU);
            Object objZ = this.I.z(iU);
            if (objD != null) {
                iHashCode = Integer.hashCode(objD instanceof Enum ? ((Enum) objD).ordinal() : objD.hashCode()) ^ Integer.rotateRight(V(), 3);
            } else if (objZ == null || iC != 207 || Intrinsics.areEqual(objZ, Composer.f23746a.a())) {
                iHashCode = Integer.rotateRight(iE ^ V(), 3) ^ Integer.hashCode(iC);
            } else {
                this.T = Integer.rotateRight(Integer.rotateRight(iE ^ V(), 3) ^ Integer.hashCode(objZ.hashCode()), 3);
            }
            this.T = Integer.rotateRight(iHashCode, 3);
        }
        int i3 = this.f23759l;
        Pending pending = this.f23757j;
        if (pending != null && pending.b().size() > 0) {
            List listB = pending.b();
            List listF = pending.f();
            Set setE = ListUtilsKt.e(listF);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size = listF.size();
            int size2 = listB.size();
            int i4 = 0;
            int i5 = 0;
            int iO = 0;
            while (i4 < size2) {
                KeyInfo keyInfo = (KeyInfo) listB.get(i4);
                if (setE.contains(keyInfo)) {
                    list = listB;
                    if (!linkedHashSet.contains(keyInfo)) {
                        if (i5 < size) {
                            KeyInfo keyInfo2 = (KeyInfo) listF.get(i5);
                            if (keyInfo2 != keyInfo) {
                                int iG = pending.g(keyInfo2);
                                linkedHashSet.add(keyInfo2);
                                if (iG != iO) {
                                    int iO2 = pending.o(keyInfo2);
                                    list2 = listF;
                                    this.O.y(pending.e() + iG, iO + pending.e(), iO2);
                                    pending.j(iG, iO, iO2);
                                } else {
                                    list2 = listF;
                                }
                            } else {
                                list2 = listF;
                                i4++;
                            }
                            i5++;
                            iO += pending.o(keyInfo2);
                            listB = list;
                            listF = list2;
                        }
                    }
                    listB = list;
                } else {
                    this.O.S(pending.g(keyInfo) + pending.e(), keyInfo.c());
                    pending.n(keyInfo.b(), 0);
                    this.O.z(keyInfo.b());
                    this.I.Q(keyInfo.b());
                    f1();
                    this.I.S();
                    list = listB;
                    ComposerKt.S(this.f23767t, keyInfo.b(), keyInfo.b() + this.I.E(keyInfo.b()));
                }
                i4++;
                listB = list;
            }
            this.O.i();
            if (listB.size() > 0) {
                this.O.z(this.I.m());
                this.I.T();
            }
        }
        boolean zI = i();
        if (!zI && (iW = this.I.w()) > 0) {
            this.O.a0(iW);
        }
        int i6 = this.f23758k;
        while (!this.I.H()) {
            int iK = this.I.k();
            f1();
            this.O.S(i6, this.I.S());
            ComposerKt.S(this.f23767t, iK, this.I.k());
        }
        if (zI) {
            if (z2) {
                this.Q.d();
                i3 = 1;
            }
            this.I.f();
            int iE02 = this.K.e0();
            this.K.T();
            if (!this.I.t()) {
                int iS0 = S0(iE02);
                this.K.U();
                this.K.L(true);
                g1(this.P);
                this.S = false;
                if (!this.f23751d.isEmpty()) {
                    D1(iS0, 0);
                    E1(iS0, i3);
                }
            }
        } else {
            if (z2) {
                this.O.B();
            }
            this.O.g();
            int iU2 = this.I.u();
            if (i3 != I1(iU2)) {
                E1(iU2, i3);
            }
            if (z2) {
                i3 = 1;
            }
            this.I.g();
            this.O.i();
        }
        G0(i3, zI);
    }

    private final void B0() {
        A0(false);
    }

    private final void D0() {
        B0();
        this.f23750c.c();
        B0();
        this.O.l();
        H0();
        this.I.d();
        this.f23765r = false;
        this.f23771x = ComposerKt.p(this.f23772y.g());
    }

    private final void D1(int i3, int i4) {
        if (I1(i3) != i4) {
            if (i3 < 0) {
                MutableIntIntMap mutableIntIntMap = this.f23763p;
                if (mutableIntIntMap == null) {
                    mutableIntIntMap = new MutableIntIntMap(0, 1, null);
                    this.f23763p = mutableIntIntMap;
                }
                mutableIntIntMap.q(i3, i4);
                return;
            }
            int[] iArr = this.f23762o;
            if (iArr == null) {
                int[] iArr2 = new int[this.I.x()];
                ArraysKt.fill$default(iArr2, -1, 0, 0, 6, (Object) null);
                this.f23762o = iArr2;
                iArr = iArr2;
            }
            iArr[i3] = i4;
        }
    }

    private final void E0() {
        if (this.K.Z()) {
            SlotWriter slotWriterC = this.J.C();
            this.K = slotWriterC;
            slotWriterC.Z0();
            this.L = false;
            this.M = null;
        }
    }

    private final void E1(int i3, int i4) {
        int iI1 = I1(i3);
        if (iI1 != i4) {
            int i5 = i4 - iI1;
            int iE = Stack.e(this.f23756i) - 1;
            while (i3 != -1) {
                int iI12 = I1(i3) + i5;
                D1(i3, iI12);
                int i6 = iE;
                while (true) {
                    if (-1 < i6) {
                        Pending pending = (Pending) Stack.j(this.f23756i, i6);
                        if (pending != null && pending.n(i3, iI12)) {
                            iE = i6 - 1;
                            break;
                        }
                        i6--;
                    } else {
                        break;
                    }
                }
                if (i3 < 0) {
                    i3 = this.I.u();
                } else if (this.I.J(i3)) {
                    return;
                } else {
                    i3 = this.I.P(i3);
                }
            }
        }
    }

    private final void F0(boolean z2, Pending pending) {
        Stack.l(this.f23756i, this.f23757j);
        this.f23757j = pending;
        this.f23761n.h(this.f23759l);
        this.f23761n.h(this.f23760m);
        this.f23761n.h(this.f23758k);
        if (z2) {
            this.f23758k = 0;
        }
        this.f23759l = 0;
        this.f23760m = 0;
    }

    private final PersistentCompositionLocalMap F1(PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentCompositionLocalMap.Builder builder = persistentCompositionLocalMap.builder();
        builder.putAll(persistentCompositionLocalMap2);
        PersistentCompositionLocalMap persistentCompositionLocalMapBuild = builder.build();
        w1(204, ComposerKt.H());
        G1(persistentCompositionLocalMapBuild);
        G1(persistentCompositionLocalMap2);
        B0();
        return persistentCompositionLocalMapBuild;
    }

    private final void G0(int i3, boolean z2) {
        Pending pending = (Pending) Stack.k(this.f23756i);
        if (pending != null && !z2) {
            pending.l(pending.a() + 1);
        }
        this.f23757j = pending;
        this.f23758k = this.f23761n.g() + i3;
        this.f23760m = this.f23761n.g();
        this.f23759l = this.f23761n.g() + i3;
    }

    private final void G1(Object obj) {
        V0();
        H1(obj);
    }

    private final void H0() {
        this.O.o();
        if (!Stack.g(this.f23756i)) {
            ComposerKt.t("Start/end imbalance");
        }
        p0();
    }

    private final void I0() {
        SlotTable slotTable = new SlotTable();
        if (this.D) {
            slotTable.n();
        }
        if (this.f23750c.d()) {
            slotTable.l();
        }
        this.J = slotTable;
        SlotWriter slotWriterC = slotTable.C();
        slotWriterC.L(true);
        this.K = slotWriterC;
    }

    private final int I1(int i3) {
        int i4;
        if (i3 >= 0) {
            int[] iArr = this.f23762o;
            return (iArr == null || (i4 = iArr[i3]) < 0) ? this.I.N(i3) : i4;
        }
        MutableIntIntMap mutableIntIntMap = this.f23763p;
        if (mutableIntIntMap == null || !mutableIntIntMap.a(i3)) {
            return 0;
        }
        return mutableIntIntMap.c(i3);
    }

    private final void J1() {
        if (!this.f23766s) {
            ComposerKt.t("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.f23766s = false;
    }

    private final void K1() {
        if (this.f23766s) {
            ComposerKt.t("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    private final Object N0(SlotReader slotReader) {
        return slotReader.L(slotReader.u());
    }

    private final int P0(SlotReader slotReader, int i3) {
        Object objZ;
        if (!slotReader.G(i3)) {
            int iC = slotReader.C(i3);
            return (iC != 207 || (objZ = slotReader.z(i3)) == null || Intrinsics.areEqual(objZ, Composer.f23746a.a())) ? iC : objZ.hashCode();
        }
        Object objD = slotReader.D(i3);
        if (objD == null) {
            return 0;
        }
        if (objD instanceof Enum) {
            return ((Enum) objD).ordinal();
        }
        if (objD instanceof MovableContent) {
            return 126665345;
        }
        return objD.hashCode();
    }

    private final void Q0(List list) throws Throwable {
        ComposerChangeListWriter composerChangeListWriter;
        ChangeList changeList;
        ComposerChangeListWriter composerChangeListWriter2;
        ChangeList changeList2;
        SlotTable slotTableH;
        Anchor anchorA;
        SlotReader slotReader;
        MutableIntObjectMap mutableIntObjectMap;
        ComposerChangeListWriter composerChangeListWriter3;
        ChangeList changeList3;
        int i3;
        int i4;
        SlotTable slotTableD;
        List list2 = list;
        ComposerChangeListWriter composerChangeListWriter4 = this.O;
        ChangeList changeList4 = this.f23754g;
        ChangeList changeListP = composerChangeListWriter4.p();
        try {
            composerChangeListWriter4.V(changeList4);
            this.O.T();
            int size = list2.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                try {
                    Pair pair = (Pair) list2.get(i6);
                    final MovableContentStateReference movableContentStateReference = (MovableContentStateReference) pair.a();
                    MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) pair.b();
                    Anchor anchorA2 = movableContentStateReference.a();
                    int iF = movableContentStateReference.h().f(anchorA2);
                    IntRef intRef = new IntRef(i5, 1, null);
                    this.O.e(intRef, anchorA2);
                    if (movableContentStateReference2 == null) {
                        if (Intrinsics.areEqual(movableContentStateReference.h(), this.J)) {
                            t0();
                        }
                        final SlotReader slotReaderB = movableContentStateReference.h().B();
                        try {
                            slotReaderB.Q(iF);
                            this.O.A(iF);
                            final ChangeList changeList5 = new ChangeList();
                            d1(this, null, null, null, null, new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m203invoke();
                                    return Unit.f139807a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m203invoke() {
                                    ComposerChangeListWriter composerChangeListWriter5 = this.f23784a.O;
                                    ChangeList changeList6 = changeList5;
                                    ComposerImpl composerImpl = this.f23784a;
                                    SlotReader slotReader2 = slotReaderB;
                                    MovableContentStateReference movableContentStateReference3 = movableContentStateReference;
                                    ChangeList changeListP2 = composerChangeListWriter5.p();
                                    try {
                                        composerChangeListWriter5.V(changeList6);
                                        SlotReader slotReaderO0 = composerImpl.O0();
                                        int[] iArr = composerImpl.f23762o;
                                        MutableIntObjectMap mutableIntObjectMap2 = composerImpl.f23770w;
                                        composerImpl.f23762o = null;
                                        composerImpl.f23770w = null;
                                        try {
                                            composerImpl.q1(slotReader2);
                                            ComposerChangeListWriter composerChangeListWriter6 = composerImpl.O;
                                            boolean zQ = composerChangeListWriter6.q();
                                            try {
                                                composerChangeListWriter6.W(false);
                                                composerImpl.T0(movableContentStateReference3.c(), movableContentStateReference3.e(), movableContentStateReference3.g(), true);
                                                composerChangeListWriter6.W(zQ);
                                                Unit unit = Unit.f139807a;
                                            } catch (Throwable th) {
                                                composerChangeListWriter6.W(zQ);
                                                throw th;
                                            }
                                        } finally {
                                            composerImpl.q1(slotReaderO0);
                                            composerImpl.f23762o = iArr;
                                            composerImpl.f23770w = mutableIntObjectMap2;
                                        }
                                    } finally {
                                        composerChangeListWriter5.V(changeListP2);
                                    }
                                }
                            }, 15, null);
                            this.O.t(changeList5, intRef);
                            Unit unit = Unit.f139807a;
                            slotReaderB.d();
                            composerChangeListWriter2 = composerChangeListWriter4;
                            changeList2 = changeListP;
                            i3 = size;
                            i4 = i6;
                        } finally {
                        }
                    } else {
                        MovableContentState movableContentStateO = this.f23750c.o(movableContentStateReference2);
                        if (movableContentStateO == null || (slotTableH = movableContentStateO.d()) == null) {
                            slotTableH = movableContentStateReference2.h();
                        }
                        if (movableContentStateO == null || (slotTableD = movableContentStateO.d()) == null || (anchorA = slotTableD.e(0)) == null) {
                            anchorA = movableContentStateReference2.a();
                        }
                        List listR = ComposerKt.r(slotTableH, anchorA);
                        if (!listR.isEmpty()) {
                            this.O.b(listR, intRef);
                            if (Intrinsics.areEqual(movableContentStateReference.h(), this.f23751d)) {
                                int iF2 = this.f23751d.f(anchorA2);
                                D1(iF2, I1(iF2) + listR.size());
                            }
                        }
                        this.O.c(movableContentStateO, this.f23750c, movableContentStateReference2, movableContentStateReference);
                        SlotReader slotReaderB2 = slotTableH.B();
                        try {
                            SlotReader slotReaderO0 = O0();
                            int[] iArr = this.f23762o;
                            MutableIntObjectMap mutableIntObjectMap2 = this.f23770w;
                            this.f23762o = null;
                            this.f23770w = null;
                            try {
                                q1(slotReaderB2);
                                int iF3 = slotTableH.f(anchorA);
                                slotReaderB2.Q(iF3);
                                this.O.A(iF3);
                                ChangeList changeList6 = new ChangeList();
                                ComposerChangeListWriter composerChangeListWriter5 = this.O;
                                ChangeList changeListP2 = composerChangeListWriter5.p();
                                try {
                                    composerChangeListWriter5.V(changeList6);
                                    slotReader = slotReaderB2;
                                    try {
                                        ComposerChangeListWriter composerChangeListWriter6 = this.O;
                                        i3 = size;
                                        boolean zQ = composerChangeListWriter6.q();
                                        try {
                                            composerChangeListWriter6.W(false);
                                            try {
                                                i4 = i6;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                                composerChangeListWriter2 = composerChangeListWriter4;
                                                composerChangeListWriter3 = composerChangeListWriter5;
                                                changeList2 = changeListP;
                                                changeList3 = changeListP2;
                                                try {
                                                    c1(movableContentStateReference2.b(), movableContentStateReference.b(), Integer.valueOf(slotReader.k()), movableContentStateReference2.d(), new Function0<Unit>() { // from class: androidx.compose.runtime.ComposerImpl$insertMovableContentGuarded$1$1$2$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public /* bridge */ /* synthetic */ Object invoke() {
                                                            m204invoke();
                                                            return Unit.f139807a;
                                                        }

                                                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                                        public final void m204invoke() {
                                                            this.f23788a.T0(movableContentStateReference.c(), movableContentStateReference.e(), movableContentStateReference.g(), true);
                                                        }
                                                    });
                                                    try {
                                                        composerChangeListWriter6.W(zQ);
                                                        try {
                                                            composerChangeListWriter3.V(changeList3);
                                                            this.O.t(changeList6, intRef);
                                                            Unit unit2 = Unit.f139807a;
                                                            try {
                                                                q1(slotReaderO0);
                                                                this.f23762o = iArr;
                                                                this.f23770w = mutableIntObjectMap;
                                                                try {
                                                                    slotReader.d();
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    composerChangeListWriter = composerChangeListWriter2;
                                                                    changeList = changeList2;
                                                                    composerChangeListWriter.V(changeList);
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                slotReader.d();
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            q1(slotReaderO0);
                                                            this.f23762o = iArr;
                                                            this.f23770w = mutableIntObjectMap;
                                                            throw th;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        composerChangeListWriter3.V(changeList3);
                                                        throw th;
                                                    }
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    composerChangeListWriter6.W(zQ);
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                mutableIntObjectMap = mutableIntObjectMap2;
                                                changeList3 = changeListP2;
                                                composerChangeListWriter3 = composerChangeListWriter5;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            mutableIntObjectMap = mutableIntObjectMap2;
                                            composerChangeListWriter3 = composerChangeListWriter5;
                                            changeList3 = changeListP2;
                                        }
                                    } catch (Throwable th8) {
                                        th = th8;
                                        mutableIntObjectMap = mutableIntObjectMap2;
                                        composerChangeListWriter3 = composerChangeListWriter5;
                                        changeList3 = changeListP2;
                                        composerChangeListWriter3.V(changeList3);
                                        throw th;
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    mutableIntObjectMap = mutableIntObjectMap2;
                                    slotReader = slotReaderB2;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                mutableIntObjectMap = mutableIntObjectMap2;
                                slotReader = slotReaderB2;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            slotReader = slotReaderB2;
                        }
                    }
                    this.O.Y();
                    i6 = i4 + 1;
                    list2 = list;
                    size = i3;
                    composerChangeListWriter4 = composerChangeListWriter2;
                    changeListP = changeList2;
                    i5 = 0;
                } catch (Throwable th12) {
                    th = th12;
                    composerChangeListWriter2 = composerChangeListWriter4;
                    changeList2 = changeListP;
                }
            }
            ComposerChangeListWriter composerChangeListWriter7 = composerChangeListWriter4;
            ChangeList changeList7 = changeListP;
            this.O.h();
            this.O.A(0);
            composerChangeListWriter7.V(changeList7);
        } catch (Throwable th13) {
            th = th13;
            composerChangeListWriter = composerChangeListWriter4;
            changeList = changeListP;
        }
    }

    private final int S0(int i3) {
        return (-2) - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T0(final MovableContent movableContent, PersistentCompositionLocalMap persistentCompositionLocalMap, final Object obj, boolean z2) {
        K(126665345, movableContent);
        G1(obj);
        int iV = V();
        try {
            this.T = 126665345;
            boolean z3 = false;
            if (i()) {
                SlotWriter.w0(this.K, 0, 1, null);
            }
            if (!i() && !Intrinsics.areEqual(this.I.l(), persistentCompositionLocalMap)) {
                z3 = true;
            }
            if (z3) {
                h1(persistentCompositionLocalMap);
            }
            u1(202, ComposerKt.C(), GroupKind.f23894b.a(), persistentCompositionLocalMap);
            this.M = null;
            if (!i() || z2) {
                boolean z4 = this.f23771x;
                this.f23771x = z3;
                Utils_jvmKt.b(this, ComposableLambdaKt.c(316014703, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.runtime.ComposerImpl$invokeMovableContentLambda$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer, int i3) {
                        if (!composer.r((i3 & 3) != 2, i3 & 1)) {
                            composer.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(316014703, i3, -1, "androidx.compose.runtime.ComposerImpl.invokeMovableContentLambda.<anonymous> (Composer.kt:3386)");
                        }
                        movableContent.a().invoke(obj, composer, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }));
                this.f23771x = z4;
            } else {
                this.L = true;
                SlotWriter slotWriter = this.K;
                this.f23750c.l(new MovableContentStateReference(movableContent, obj, K0(), this.J, slotWriter.D(slotWriter.I0(slotWriter.e0())), CollectionsKt.emptyList(), u0(), null));
            }
            B0();
            this.M = null;
            this.T = iV;
            X();
        } catch (Throwable th) {
            B0();
            this.M = null;
            this.T = iV;
            X();
            throw th;
        }
    }

    private final Object X0(SlotReader slotReader, int i3) {
        return slotReader.L(i3);
    }

    private final int Y0(int i3, int i4, int i5, int i6) {
        int iP = this.I.P(i4);
        while (iP != i5 && !this.I.J(iP)) {
            iP = this.I.P(iP);
        }
        if (this.I.J(iP)) {
            i6 = 0;
        }
        if (iP == i4) {
            return i6;
        }
        int iI1 = (I1(iP) - this.I.N(i4)) + i6;
        loop1: while (i6 < iI1 && iP != i3) {
            iP++;
            while (iP < i3) {
                int iE = this.I.E(iP) + iP;
                if (i3 >= iE) {
                    i6 += this.I.J(iP) ? 1 : I1(iP);
                    iP = iE;
                }
            }
            break loop1;
        }
        return i6;
    }

    private final int a1(int i3) {
        int iP = this.I.P(i3) + 1;
        int i4 = 0;
        while (iP < i3) {
            if (!this.I.G(iP)) {
                i4++;
            }
            iP += this.I.E(iP);
        }
        return i4;
    }

    private final void c0() {
        p0();
        Stack.a(this.f23756i);
        this.f23761n.a();
        this.f23768u.a();
        this.f23772y.a();
        this.f23770w = null;
        this.Q.b();
        this.T = 0;
        this.B = 0;
        this.f23766s = false;
        this.S = false;
        this.f23773z = false;
        this.G = false;
        this.f23765r = false;
        this.A = -1;
        if (!this.I.i()) {
            this.I.d();
        }
        if (this.K.Z()) {
            return;
        }
        I0();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[Catch: all -> 0x0029, TRY_LEAVE, TryCatch #0 {all -> 0x0029, blocks: (B:3:0x0005, B:5:0x0013, B:7:0x0025, B:11:0x002f, B:10:0x002b, B:14:0x0036, B:16:0x003c, B:18:0x0042), top: B:23:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object c1(androidx.compose.runtime.ControlledComposition r7, androidx.compose.runtime.ControlledComposition r8, java.lang.Integer r9, java.util.List r10, kotlin.jvm.functions.Function0 r11) {
        /*
            r6 = this;
            boolean r0 = r6.G
            int r1 = r6.f23758k
            r2 = 1
            r6.G = r2     // Catch: java.lang.Throwable -> L29
            r2 = 0
            r6.f23758k = r2     // Catch: java.lang.Throwable -> L29
            r3 = r10
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L29
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L29
        L11:
            if (r2 >= r3) goto L32
            java.lang.Object r4 = r10.get(r2)     // Catch: java.lang.Throwable -> L29
            kotlin.Pair r4 = (kotlin.Pair) r4     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r4.a()     // Catch: java.lang.Throwable -> L29
            androidx.compose.runtime.RecomposeScopeImpl r5 = (androidx.compose.runtime.RecomposeScopeImpl) r5     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r4.b()     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L2b
            r6.A1(r5, r4)     // Catch: java.lang.Throwable -> L29
            goto L2f
        L29:
            r7 = move-exception
            goto L4b
        L2b:
            r4 = 0
            r6.A1(r5, r4)     // Catch: java.lang.Throwable -> L29
        L2f:
            int r2 = r2 + 1
            goto L11
        L32:
            if (r7 == 0) goto L42
            if (r9 == 0) goto L3b
            int r9 = r9.intValue()     // Catch: java.lang.Throwable -> L29
            goto L3c
        L3b:
            r9 = -1
        L3c:
            java.lang.Object r7 = r7.i(r8, r9, r11)     // Catch: java.lang.Throwable -> L29
            if (r7 != 0) goto L46
        L42:
            java.lang.Object r7 = r11.invoke()     // Catch: java.lang.Throwable -> L29
        L46:
            r6.G = r0
            r6.f23758k = r1
            return r7
        L4b:
            r6.G = r0
            r6.f23758k = r1
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.c1(androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.ControlledComposition, java.lang.Integer, java.util.List, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    static /* synthetic */ Object d1(ComposerImpl composerImpl, ControlledComposition controlledComposition, ControlledComposition controlledComposition2, Integer num, List list, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            controlledComposition = null;
        }
        if ((i3 & 2) != 0) {
            controlledComposition2 = null;
        }
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = CollectionsKt.emptyList();
        }
        return composerImpl.c1(controlledComposition, controlledComposition2, num, list, function0);
    }

    private final void e1() {
        boolean z2 = this.G;
        this.G = true;
        int iU = this.I.u();
        int iE = this.I.E(iU) + iU;
        int i3 = this.f23758k;
        int iV = V();
        int i4 = this.f23759l;
        int i5 = this.f23760m;
        Invalidation invalidationB = ComposerKt.B(this.f23767t, this.I.k(), iE);
        int i6 = iU;
        boolean z3 = false;
        while (invalidationB != null) {
            int iB = invalidationB.b();
            ComposerKt.R(this.f23767t, iB);
            if (invalidationB.d()) {
                this.I.Q(iB);
                int iK = this.I.k();
                i1(i6, iK, iU);
                this.f23758k = Y0(iB, iK, iU, i3);
                this.f23760m = a1(iK);
                this.T = s0(this.I.P(iK), iU, iV);
                this.M = null;
                boolean z4 = !this.f23773z && invalidationB.c().r();
                if (z4) {
                    this.f23773z = true;
                }
                invalidationB.c().g(this);
                if (z4) {
                    this.f23773z = false;
                }
                this.M = null;
                this.I.R(iU);
                i6 = iK;
                z3 = true;
            } else {
                Stack.l(this.F, invalidationB.c());
                invalidationB.c().B();
                Stack.k(this.F);
            }
            invalidationB = ComposerKt.B(this.f23767t, this.I.k(), iE);
        }
        if (z3) {
            i1(i6, iU, iU);
            this.I.T();
            int iI1 = I1(iU);
            this.f23758k = i3 + iI1;
            this.f23759l = i4 + iI1;
            this.f23760m = i5;
        } else {
            t1();
        }
        this.T = iV;
        this.G = z2;
    }

    private final void f1() {
        l1(this.I.k());
        this.O.R();
    }

    private final void g1(Anchor anchor) {
        if (this.Q.g()) {
            this.O.u(anchor, this.J);
        } else {
            this.O.v(anchor, this.J, this.Q);
            this.Q = new FixupList();
        }
    }

    private final void h1(PersistentCompositionLocalMap persistentCompositionLocalMap) {
        MutableIntObjectMap mutableIntObjectMap = this.f23770w;
        if (mutableIntObjectMap == null) {
            mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
            this.f23770w = mutableIntObjectMap;
        }
        mutableIntObjectMap.r(this.I.k(), persistentCompositionLocalMap);
    }

    private final void i1(int i3, int i4, int i5) {
        SlotReader slotReader = this.I;
        int iO = ComposerKt.O(slotReader, i3, i4, i5);
        while (i3 > 0 && i3 != iO) {
            if (slotReader.J(i3)) {
                this.O.B();
            }
            i3 = slotReader.P(i3);
        }
        z0(i4, iO);
    }

    private final Anchor j1() {
        int i3;
        int i4;
        if (i()) {
            if (!ComposerKt.L(this.K)) {
                return null;
            }
            int iC0 = this.K.c0() - 1;
            int iI0 = this.K.I0(iC0);
            while (true) {
                int i5 = iI0;
                i4 = iC0;
                iC0 = i5;
                if (iC0 == this.K.e0() || iC0 < 0) {
                    break;
                }
                iI0 = this.K.I0(iC0);
            }
            return this.K.D(i4);
        }
        if (!ComposerKt.K(this.I)) {
            return null;
        }
        int iK = this.I.k() - 1;
        int iP = this.I.P(iK);
        while (true) {
            int i6 = iP;
            i3 = iK;
            iK = i6;
            if (iK == this.I.u() || iK < 0) {
                break;
            }
            iP = this.I.P(iK);
        }
        return this.I.a(i3);
    }

    private final void k1() {
        if (this.f23751d.o()) {
            ControlledComposition controlledCompositionK0 = K0();
            Intrinsics.checkNotNull(controlledCompositionK0, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            ((CompositionImpl) controlledCompositionK0).Q();
            ChangeList changeList = new ChangeList();
            this.N = changeList;
            SlotReader slotReaderB = this.f23751d.B();
            try {
                this.I = slotReaderB;
                ComposerChangeListWriter composerChangeListWriter = this.O;
                ChangeList changeListP = composerChangeListWriter.p();
                try {
                    composerChangeListWriter.V(changeList);
                    l1(0);
                    this.O.N();
                    composerChangeListWriter.V(changeListP);
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    composerChangeListWriter.V(changeListP);
                    throw th;
                }
            } finally {
                slotReaderB.d();
            }
        }
    }

    private final void l1(int i3) {
        boolean zJ = this.I.J(i3);
        if (zJ) {
            this.O.i();
            this.O.x(this.I.L(i3));
        }
        p1(this, i3, i3, zJ, 0);
        this.O.i();
        if (zJ) {
            this.O.B();
        }
    }

    private static final MovableContentStateReference m1(ComposerImpl composerImpl, int i3, List list) {
        Object objD = composerImpl.I.D(i3);
        Intrinsics.checkNotNull(objD, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        MovableContent movableContent = (MovableContent) objD;
        Object objB = composerImpl.I.B(i3, 0);
        Anchor anchorA = composerImpl.I.a(i3);
        List listY = ComposerKt.y(composerImpl.f23767t, i3, composerImpl.I.E(i3) + i3);
        ArrayList arrayList = new ArrayList(listY.size());
        int size = listY.size();
        for (int i4 = 0; i4 < size; i4++) {
            Invalidation invalidation = (Invalidation) listY.get(i4);
            arrayList.add(TuplesKt.a(invalidation.c(), invalidation.a()));
        }
        return new MovableContentStateReference(movableContent, objB, composerImpl.K0(), composerImpl.f23751d, anchorA, arrayList, composerImpl.v0(i3), list);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void n0() {
        /*
            r4 = this;
            boolean r0 = r4.i()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl"
            if (r0 == 0) goto L24
            androidx.compose.runtime.RecomposeScopeImpl r0 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.ControlledComposition r2 = r4.K0()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.CompositionImpl r2 = (androidx.compose.runtime.CompositionImpl) r2
            r0.<init>(r2)
            java.util.ArrayList r1 = r4.F
            androidx.compose.runtime.Stack.l(r1, r0)
            r4.H1(r0)
            int r1 = r4.C
            r0.O(r1)
            return
        L24:
            java.util.List r0 = r4.f23767t
            androidx.compose.runtime.SlotReader r2 = r4.I
            int r2 = r2.u()
            androidx.compose.runtime.Invalidation r0 = androidx.compose.runtime.ComposerKt.n(r0, r2)
            androidx.compose.runtime.SlotReader r2 = r4.I
            java.lang.Object r2 = r2.K()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.f23746a
            java.lang.Object r3 = r3.a()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r3 == 0) goto L54
            androidx.compose.runtime.RecomposeScopeImpl r2 = new androidx.compose.runtime.RecomposeScopeImpl
            androidx.compose.runtime.ControlledComposition r3 = r4.K0()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r1)
            androidx.compose.runtime.CompositionImpl r3 = (androidx.compose.runtime.CompositionImpl) r3
            r2.<init>(r3)
            r4.H1(r2)
            goto L5b
        L54:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r1)
            androidx.compose.runtime.RecomposeScopeImpl r2 = (androidx.compose.runtime.RecomposeScopeImpl) r2
        L5b:
            r1 = 1
            r3 = 0
            if (r0 != 0) goto L6d
            boolean r0 = r2.m()
            if (r0 == 0) goto L68
            r2.G(r3)
        L68:
            if (r0 == 0) goto L6b
            goto L6d
        L6b:
            r0 = r3
            goto L6e
        L6d:
            r0 = r1
        L6e:
            r2.I(r0)
            java.util.ArrayList r0 = r4.F
            androidx.compose.runtime.Stack.l(r0, r2)
            int r0 = r4.C
            r2.O(r0)
            boolean r0 = r2.n()
            if (r0 == 0) goto L8c
            r2.H(r3)
            r2.K(r1)
            androidx.compose.runtime.changelist.ComposerChangeListWriter r0 = r4.O
            r0.Z(r2)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.n0():void");
    }

    private static final MovableContentStateReference n1(ComposerImpl composerImpl, int i3) {
        int iC = composerImpl.I.C(i3);
        Object objD = composerImpl.I.D(i3);
        ArrayList arrayList = null;
        if (iC != 126665345 || !(objD instanceof MovableContent)) {
            return null;
        }
        if (composerImpl.I.e(i3)) {
            ArrayList arrayList2 = new ArrayList();
            o1(composerImpl, arrayList2, i3);
            if (!arrayList2.isEmpty()) {
                arrayList = arrayList2;
            }
        }
        return m1(composerImpl, i3, arrayList);
    }

    private static final void o1(ComposerImpl composerImpl, List list, int i3) {
        int iE = composerImpl.I.E(i3) + i3;
        int iE2 = i3 + 1;
        while (iE2 < iE) {
            if (composerImpl.I.F(iE2)) {
                MovableContentStateReference movableContentStateReferenceN1 = n1(composerImpl, iE2);
                if (movableContentStateReferenceN1 != null) {
                    list.add(movableContentStateReferenceN1);
                }
            } else if (composerImpl.I.e(iE2)) {
                o1(composerImpl, list, iE2);
            }
            iE2 += composerImpl.I.E(iE2);
        }
    }

    private final void p0() {
        this.f23757j = null;
        this.f23758k = 0;
        this.f23759l = 0;
        this.T = 0;
        this.f23766s = false;
        this.O.U();
        Stack.a(this.F);
        q0();
    }

    private static final int p1(ComposerImpl composerImpl, int i3, int i4, boolean z2, int i5) {
        SlotReader slotReader = composerImpl.I;
        if (!slotReader.F(i4)) {
            if (!slotReader.e(i4)) {
                if (slotReader.J(i4)) {
                    return 1;
                }
                return slotReader.N(i4);
            }
            int iE = slotReader.E(i4) + i4;
            int iP1 = 0;
            for (int iE2 = i4 + 1; iE2 < iE; iE2 += slotReader.E(iE2)) {
                boolean zJ = slotReader.J(iE2);
                if (zJ) {
                    composerImpl.O.i();
                    composerImpl.O.x(slotReader.L(iE2));
                }
                iP1 += p1(composerImpl, i3, iE2, zJ || z2, zJ ? 0 : i5 + iP1);
                if (zJ) {
                    composerImpl.O.i();
                    composerImpl.O.B();
                }
            }
            if (slotReader.J(i4)) {
                return 1;
            }
            return iP1;
        }
        int iC = slotReader.C(i4);
        Object objD = slotReader.D(i4);
        if (iC == 126665345 && (objD instanceof MovableContent)) {
            MovableContentStateReference movableContentStateReferenceN1 = n1(composerImpl, i4);
            if (movableContentStateReferenceN1 != null) {
                composerImpl.f23750c.b(movableContentStateReferenceN1);
                composerImpl.O.M();
                composerImpl.O.O(composerImpl.K0(), composerImpl.f23750c, movableContentStateReferenceN1);
            }
            if (!z2 || i4 == i3) {
                return slotReader.N(i4);
            }
            composerImpl.O.j(i5, i4);
            return 0;
        }
        if (iC != 206 || !Intrinsics.areEqual(objD, ComposerKt.I())) {
            if (slotReader.J(i4)) {
                return 1;
            }
            return slotReader.N(i4);
        }
        Object objB = slotReader.B(i4, 0);
        CompositionContextHolder compositionContextHolder = objB instanceof CompositionContextHolder ? (CompositionContextHolder) objB : null;
        if (compositionContextHolder != null) {
            for (ComposerImpl composerImpl2 : compositionContextHolder.a().x()) {
                composerImpl2.k1();
                composerImpl.f23750c.s(composerImpl2.K0());
            }
        }
        return slotReader.N(i4);
    }

    private final void q0() {
        this.f23762o = null;
        this.f23763p = null;
    }

    private final int s0(int i3, int i4, int i5) {
        int iRotateLeft;
        int i6 = 3;
        int iRotateLeft2 = 0;
        int i7 = 0;
        while (i3 >= 0) {
            if (i3 == i4) {
                iRotateLeft = Integer.rotateLeft(i5, i7);
            } else {
                int iP0 = P0(this.I, i3);
                if (iP0 == 126665345) {
                    iRotateLeft = Integer.rotateLeft(iP0, i7);
                } else {
                    iRotateLeft2 = (iRotateLeft2 ^ Integer.rotateLeft(iP0, i6)) ^ Integer.rotateLeft(this.I.G(i3) ? 0 : a1(i3), i7);
                    i6 = (i6 + 6) % 32;
                    i7 = (i7 + 6) % 32;
                    i3 = this.I.P(i3);
                }
            }
            return iRotateLeft ^ iRotateLeft2;
        }
        return iRotateLeft2;
    }

    private final void s1() {
        this.f23759l += this.I.S();
    }

    private final void t0() {
        if (!this.K.Z()) {
            ComposerKt.t("Check failed");
        }
        I0();
    }

    private final void t1() {
        this.f23759l = this.I.v();
        this.I.T();
    }

    private final PersistentCompositionLocalMap u0() {
        PersistentCompositionLocalMap persistentCompositionLocalMap = this.M;
        return persistentCompositionLocalMap != null ? persistentCompositionLocalMap : v0(this.I.u());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void u1(int r11, java.lang.Object r12, int r13, java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.u1(int, java.lang.Object, int, java.lang.Object):void");
    }

    private final PersistentCompositionLocalMap v0(int i3) {
        PersistentCompositionLocalMap persistentCompositionLocalMap;
        if (i() && this.L) {
            int iE0 = this.K.e0();
            while (iE0 > 0) {
                if (this.K.k0(iE0) == 202 && Intrinsics.areEqual(this.K.l0(iE0), ComposerKt.C())) {
                    Object objI0 = this.K.i0(iE0);
                    Intrinsics.checkNotNull(objI0, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objI0;
                    this.M = persistentCompositionLocalMap2;
                    return persistentCompositionLocalMap2;
                }
                iE0 = this.K.I0(iE0);
            }
        }
        if (this.I.x() > 0) {
            while (i3 > 0) {
                if (this.I.C(i3) == 202 && Intrinsics.areEqual(this.I.D(i3), ComposerKt.C())) {
                    MutableIntObjectMap mutableIntObjectMap = this.f23770w;
                    if (mutableIntObjectMap == null || (persistentCompositionLocalMap = (PersistentCompositionLocalMap) mutableIntObjectMap.b(i3)) == null) {
                        Object objZ = this.I.z(i3);
                        Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                        persistentCompositionLocalMap = (PersistentCompositionLocalMap) objZ;
                    }
                    this.M = persistentCompositionLocalMap;
                    return persistentCompositionLocalMap;
                }
                i3 = this.I.P(i3);
            }
        }
        PersistentCompositionLocalMap persistentCompositionLocalMap3 = this.f23769v;
        this.M = persistentCompositionLocalMap3;
        return persistentCompositionLocalMap3;
    }

    private final void v1(int i3) {
        u1(i3, null, GroupKind.f23894b.a(), null);
    }

    private final void w1(int i3, Object obj) {
        u1(i3, obj, GroupKind.f23894b.a(), null);
    }

    private final void x1(boolean z2, Object obj) {
        if (z2) {
            this.I.V();
            return;
        }
        if (obj != null && this.I.l() != obj) {
            this.O.c0(obj);
        }
        this.I.U();
    }

    private final void y0(MutableScatterMap mutableScatterMap, Function2 function2) {
        if (this.G) {
            ComposerKt.t("Reentrant composition is not supported");
        }
        Trace trace = Trace.f24835a;
        Object objA = trace.a("Compose:recompose");
        try {
            this.C = Long.hashCode(SnapshotKt.I().i());
            this.f23770w = null;
            C1(mutableScatterMap);
            this.f23758k = 0;
            this.G = true;
            try {
                z1();
                Object objV0 = V0();
                if (objV0 != function2 && function2 != null) {
                    H1(function2);
                }
                ComposerImpl$derivedStateObserver$1 composerImpl$derivedStateObserver$1 = this.E;
                MutableVector mutableVectorC = SnapshotStateKt.c();
                try {
                    mutableVectorC.b(composerImpl$derivedStateObserver$1);
                    if (function2 != null) {
                        w1(200, ComposerKt.D());
                        Utils_jvmKt.b(this, function2);
                        B0();
                    } else if ((!this.f23765r && !this.f23771x) || objV0 == null || Intrinsics.areEqual(objV0, Composer.f23746a.a())) {
                        r1();
                    } else {
                        w1(200, ComposerKt.D());
                        Utils_jvmKt.b(this, (Function2) TypeIntrinsics.f(objV0, 2));
                        B0();
                    }
                    mutableVectorC.u(mutableVectorC.o() - 1);
                    D0();
                    this.G = false;
                    this.f23767t.clear();
                    t0();
                    Unit unit = Unit.f139807a;
                    trace.b(objA);
                } catch (Throwable th) {
                    mutableVectorC.u(mutableVectorC.o() - 1);
                    throw th;
                }
            } catch (Throwable th2) {
                this.G = false;
                this.f23767t.clear();
                c0();
                t0();
                throw th2;
            }
        } catch (Throwable th3) {
            Trace.f24835a.b(objA);
            throw th3;
        }
    }

    private final void z0(int i3, int i4) {
        if (i3 <= 0 || i3 == i4) {
            return;
        }
        z0(this.I.P(i3), i4);
        if (this.I.J(i3)) {
            this.O.x(X0(this.I, i3));
        }
    }

    private final void z1() {
        this.f23760m = 0;
        this.I = this.f23751d.B();
        v1(100);
        this.f23750c.t();
        this.f23769v = this.f23750c.g();
        this.f23772y.h(ComposerKt.q(this.f23771x));
        this.f23771x = Z(this.f23769v);
        this.M = null;
        if (!this.f23764q) {
            this.f23764q = this.f23750c.e();
        }
        if (!this.D) {
            this.D = this.f23750c.f();
        }
        Set set = (Set) CompositionLocalMapKt.b(this.f23769v, InspectionTablesKt.a());
        if (set != null) {
            set.add(H());
            this.f23750c.p(set);
        }
        v1(this.f23750c.h());
    }

    @Override // androidx.compose.runtime.Composer
    public void A(MovableContent movableContent, Object obj) {
        Intrinsics.checkNotNull(movableContent, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        T0(movableContent, u0(), obj, false);
    }

    public final boolean A1(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        Anchor anchorI = recomposeScopeImpl.i();
        if (anchorI == null) {
            return false;
        }
        int iD = anchorI.d(this.I.y());
        if (!this.G || iD < this.I.k()) {
            return false;
        }
        ComposerKt.J(this.f23767t, iD, recomposeScopeImpl, obj);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public void B(Function0 function0) {
        this.O.X(function0);
    }

    public final void B1(Object obj) {
        if (obj instanceof RememberObserver) {
            RememberObserverHolder rememberObserverHolder = new RememberObserverHolder((RememberObserver) obj, j1());
            if (i()) {
                this.O.P(rememberObserverHolder);
            }
            this.f23752e.add(obj);
            obj = rememberObserverHolder;
        }
        H1(obj);
    }

    @Override // androidx.compose.runtime.Composer
    public void C() {
        this.f23764q = true;
        this.D = true;
        this.f23751d.n();
        this.J.n();
        this.K.y1();
    }

    public final void C0() {
        if (!(!this.G && this.A == 100)) {
            PreconditionsKt.a("Cannot disable reuse from root if it was caused by other groups");
        }
        this.A = -1;
        this.f23773z = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void C1(androidx.collection.MutableScatterMap r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.Object[] r2 = r1.f3109b
            java.lang.Object[] r3 = r1.f3110c
            long[] r1 = r1.f3108a
            int r4 = r1.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L67
            r6 = 0
        L10:
            r7 = r1[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L62
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L2a:
            if (r11 >= r9) goto L60
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L5c
            int r12 = r6 << 3
            int r12 = r12 + r11
            r13 = r2[r12]
            r12 = r3[r12]
            java.lang.String r14 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r14)
            androidx.compose.runtime.RecomposeScopeImpl r13 = (androidx.compose.runtime.RecomposeScopeImpl) r13
            androidx.compose.runtime.Anchor r14 = r13.i()
            if (r14 == 0) goto L5c
            int r14 = r14.a()
            java.util.List r15 = r0.f23767t
            androidx.compose.runtime.ScopeInvalidated r5 = androidx.compose.runtime.ScopeInvalidated.f24165a
            if (r12 != r5) goto L54
            r12 = 0
        L54:
            androidx.compose.runtime.Invalidation r5 = new androidx.compose.runtime.Invalidation
            r5.<init>(r13, r14, r12)
            r15.add(r5)
        L5c:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L2a
        L60:
            if (r9 != r10) goto L67
        L62:
            if (r6 == r4) goto L67
            int r6 = r6 + 1
            goto L10
        L67:
            java.util.List r1 = r0.f23767t
            java.util.Comparator r2 = androidx.compose.runtime.ComposerKt.h()
            kotlin.collections.CollectionsKt.sortWith(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.C1(androidx.collection.MutableScatterMap):void");
    }

    @Override // androidx.compose.runtime.Composer
    public RecomposeScope D() {
        return L0();
    }

    @Override // androidx.compose.runtime.Composer
    public void E() {
        if (this.f23773z && this.I.u() == this.A) {
            this.A = -1;
            this.f23773z = false;
        }
        A0(false);
    }

    @Override // androidx.compose.runtime.Composer
    public void F(int i3) {
        u1(i3, null, GroupKind.f23894b.a(), null);
    }

    @Override // androidx.compose.runtime.Composer
    public Object G() {
        return W0();
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData H() {
        CompositionData compositionData = this.U;
        if (compositionData != null) {
            return compositionData;
        }
        CompositionDataImpl compositionDataImpl = new CompositionDataImpl(K0());
        this.U = compositionDataImpl;
        return compositionDataImpl;
    }

    public final void H1(Object obj) {
        if (i()) {
            this.K.p1(obj);
            return;
        }
        if (!this.I.r()) {
            ComposerChangeListWriter composerChangeListWriter = this.O;
            SlotReader slotReader = this.I;
            composerChangeListWriter.a(slotReader.a(slotReader.u()), obj);
            return;
        }
        int iQ = this.I.q() - 1;
        if (!this.O.r()) {
            this.O.e0(obj, iQ);
            return;
        }
        ComposerChangeListWriter composerChangeListWriter2 = this.O;
        SlotReader slotReader2 = this.I;
        composerChangeListWriter2.b0(obj, slotReader2.a(slotReader2.u()), iQ);
    }

    @Override // androidx.compose.runtime.Composer
    public boolean I(Object obj) {
        if (V0() == obj) {
            return false;
        }
        H1(obj);
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public void J() {
        u1(-127, null, GroupKind.f23894b.a(), null);
    }

    public final boolean J0() {
        return this.B > 0;
    }

    @Override // androidx.compose.runtime.Composer
    public void K(int i3, Object obj) {
        u1(i3, obj, GroupKind.f23894b.a(), null);
    }

    public ControlledComposition K0() {
        return this.f23755h;
    }

    @Override // androidx.compose.runtime.Composer
    public void L() {
        u1(125, null, GroupKind.f23894b.c(), null);
        this.f23766s = true;
    }

    public final RecomposeScopeImpl L0() {
        ArrayList arrayList = this.F;
        if (this.B == 0 && Stack.h(arrayList)) {
            return (RecomposeScopeImpl) Stack.i(arrayList);
        }
        return null;
    }

    @Override // androidx.compose.runtime.Composer
    public void M() {
        this.f23773z = false;
    }

    public final ChangeList M0() {
        return this.N;
    }

    @Override // androidx.compose.runtime.Composer
    public void N(ProvidedValue providedValue) {
        ValueHolder valueHolder;
        PersistentCompositionLocalMap persistentCompositionLocalMapU0 = u0();
        w1(RCHTTPStatusCodes.CREATED, ComposerKt.G());
        Object objG = G();
        if (Intrinsics.areEqual(objG, Composer.f23746a.a())) {
            valueHolder = null;
        } else {
            Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            valueHolder = (ValueHolder) objG;
        }
        CompositionLocal compositionLocalB = providedValue.b();
        Intrinsics.checkNotNull(compositionLocalB, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(providedValue, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        ValueHolder valueHolderB = compositionLocalB.b(providedValue, valueHolder);
        boolean zAreEqual = Intrinsics.areEqual(valueHolderB, valueHolder);
        if (!zAreEqual) {
            w(valueHolderB);
        }
        boolean z2 = true;
        boolean z3 = false;
        if (i()) {
            if (providedValue.a() || !CompositionLocalMapKt.a(persistentCompositionLocalMapU0, compositionLocalB)) {
                persistentCompositionLocalMapU0 = persistentCompositionLocalMapU0.V(compositionLocalB, valueHolderB);
            }
            this.L = true;
        } else {
            SlotReader slotReader = this.I;
            Object objZ = slotReader.z(slotReader.k());
            Intrinsics.checkNotNull(objZ, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objZ;
            if (!(l() && zAreEqual) && (providedValue.a() || !CompositionLocalMapKt.a(persistentCompositionLocalMapU0, compositionLocalB))) {
                persistentCompositionLocalMapU0 = persistentCompositionLocalMapU0.V(compositionLocalB, valueHolderB);
            } else if ((zAreEqual && !this.f23771x) || !this.f23771x) {
                persistentCompositionLocalMapU0 = persistentCompositionLocalMap;
            }
            if (!this.f23773z && persistentCompositionLocalMap == persistentCompositionLocalMapU0) {
                z2 = false;
            }
            z3 = z2;
        }
        if (z3 && !i()) {
            h1(persistentCompositionLocalMapU0);
        }
        this.f23772y.h(ComposerKt.q(this.f23771x));
        this.f23771x = z3;
        this.M = persistentCompositionLocalMapU0;
        u1(202, ComposerKt.C(), GroupKind.f23894b.a(), persistentCompositionLocalMapU0);
    }

    @Override // androidx.compose.runtime.Composer
    public void O(int i3, Object obj) {
        if (!i() && this.I.n() == i3 && !Intrinsics.areEqual(this.I.l(), obj) && this.A < 0) {
            this.A = this.I.k();
            this.f23773z = true;
        }
        u1(i3, null, GroupKind.f23894b.a(), obj);
    }

    public final SlotReader O0() {
        return this.I;
    }

    @Override // androidx.compose.runtime.Composer
    public void P(Function0 function0) {
        J1();
        if (!i()) {
            ComposerKt.t("createNode() can only be called when inserting");
        }
        int iC = this.f23761n.c();
        SlotWriter slotWriter = this.K;
        Anchor anchorD = slotWriter.D(slotWriter.e0());
        this.f23759l++;
        this.Q.c(function0, iC, anchorD);
    }

    @Override // androidx.compose.runtime.Composer
    public void Q() {
        if (!(this.f23759l == 0)) {
            ComposerKt.t("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (i()) {
            return;
        }
        RecomposeScopeImpl recomposeScopeImplL0 = L0();
        if (recomposeScopeImplL0 != null) {
            recomposeScopeImplL0.C();
        }
        if (this.f23767t.isEmpty()) {
            t1();
        } else {
            e1();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void R() {
        B0();
        B0();
        this.f23771x = ComposerKt.p(this.f23772y.g());
        this.M = null;
    }

    public void R0(List list) {
        try {
            Q0(list);
            p0();
        } catch (Throwable th) {
            c0();
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public boolean S() {
        RecomposeScopeImpl recomposeScopeImplL0;
        return !l() || this.f23771x || ((recomposeScopeImplL0 = L0()) != null && recomposeScopeImplL0.l());
    }

    @Override // androidx.compose.runtime.Composer
    public void T(RecomposeScope recomposeScope) {
        RecomposeScopeImpl recomposeScopeImpl = recomposeScope instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) recomposeScope : null;
        if (recomposeScopeImpl == null) {
            return;
        }
        recomposeScopeImpl.N(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void U() {
        B0();
    }

    public final boolean U0() {
        return this.G;
    }

    @Override // androidx.compose.runtime.Composer
    public int V() {
        return this.T;
    }

    public final Object V0() {
        if (i()) {
            K1();
            return Composer.f23746a.a();
        }
        Object objK = this.I.K();
        return (!this.f23773z || (objK instanceof ReusableRememberObserver)) ? objK : Composer.f23746a.a();
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionContext W() {
        w1(206, ComposerKt.I());
        if (i()) {
            SlotWriter.w0(this.K, 0, 1, null);
        }
        Object objV0 = V0();
        CompositionContextHolder compositionContextHolder = objV0 instanceof CompositionContextHolder ? (CompositionContextHolder) objV0 : null;
        if (compositionContextHolder == null) {
            int iV = V();
            boolean z2 = this.f23764q;
            boolean z3 = this.D;
            ControlledComposition controlledCompositionK0 = K0();
            CompositionImpl compositionImpl = controlledCompositionK0 instanceof CompositionImpl ? (CompositionImpl) controlledCompositionK0 : null;
            compositionContextHolder = new CompositionContextHolder(new CompositionContextImpl(iV, z2, z3, compositionImpl != null ? compositionImpl.G() : null));
            H1(compositionContextHolder);
        }
        compositionContextHolder.a().A(u0());
        B0();
        return compositionContextHolder.a();
    }

    public final Object W0() {
        if (i()) {
            K1();
            return Composer.f23746a.a();
        }
        Object objK = this.I.K();
        return (!this.f23773z || (objK instanceof ReusableRememberObserver)) ? objK instanceof RememberObserverHolder ? ((RememberObserverHolder) objK).b() : objK : Composer.f23746a.a();
    }

    @Override // androidx.compose.runtime.Composer
    public void X() {
        B0();
    }

    @Override // androidx.compose.runtime.Composer
    public void Y() {
        B0();
    }

    @Override // androidx.compose.runtime.Composer
    public boolean Z(Object obj) {
        if (Intrinsics.areEqual(V0(), obj)) {
            return false;
        }
        H1(obj);
        return true;
    }

    public final void Z0(Function0 function0) {
        if (this.G) {
            ComposerKt.t("Preparing a composition while composing is not supported");
        }
        this.G = true;
        try {
            function0.invoke();
        } finally {
            this.G = false;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public int a() {
        return i() ? -this.K.e0() : this.I.u();
    }

    @Override // androidx.compose.runtime.Composer
    public void a0(int i3) {
        if (this.f23757j != null) {
            u1(i3, null, GroupKind.f23894b.a(), null);
            return;
        }
        K1();
        this.T = this.f23760m ^ Integer.rotateLeft(Integer.rotateLeft(V(), 3) ^ i3, 3);
        this.f23760m++;
        SlotReader slotReader = this.I;
        if (i()) {
            slotReader.c();
            this.K.k1(i3, Composer.f23746a.a());
            F0(false, null);
            return;
        }
        if (slotReader.n() == i3 && !slotReader.s()) {
            slotReader.U();
            F0(false, null);
            return;
        }
        if (!slotReader.H()) {
            int i4 = this.f23758k;
            int iK = slotReader.k();
            f1();
            this.O.S(i4, slotReader.S());
            ComposerKt.S(this.f23767t, iK, slotReader.k());
        }
        slotReader.c();
        this.S = true;
        this.M = null;
        E0();
        SlotWriter slotWriter = this.K;
        slotWriter.H();
        int iC0 = slotWriter.c0();
        slotWriter.k1(i3, Composer.f23746a.a());
        this.P = slotWriter.D(iC0);
        F0(false, null);
    }

    @Override // androidx.compose.runtime.Composer
    public boolean b(boolean z2) {
        Object objV0 = V0();
        if ((objV0 instanceof Boolean) && z2 == ((Boolean) objV0).booleanValue()) {
            return false;
        }
        H1(Boolean.valueOf(z2));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public void b0(ProvidedValue[] providedValueArr) {
        PersistentCompositionLocalMap persistentCompositionLocalMapF1;
        PersistentCompositionLocalMap persistentCompositionLocalMapU0 = u0();
        w1(RCHTTPStatusCodes.CREATED, ComposerKt.G());
        boolean z2 = true;
        boolean z3 = false;
        if (i()) {
            persistentCompositionLocalMapF1 = F1(persistentCompositionLocalMapU0, CompositionLocalMapKt.d(providedValueArr, persistentCompositionLocalMapU0, null, 4, null));
            this.L = true;
        } else {
            Object objA = this.I.A(0);
            Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) objA;
            Object objA2 = this.I.A(1);
            Intrinsics.checkNotNull(objA2, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) objA2;
            PersistentCompositionLocalMap persistentCompositionLocalMapC = CompositionLocalMapKt.c(providedValueArr, persistentCompositionLocalMapU0, persistentCompositionLocalMap2);
            if (l() && !this.f23773z && Intrinsics.areEqual(persistentCompositionLocalMap2, persistentCompositionLocalMapC)) {
                s1();
                persistentCompositionLocalMapF1 = persistentCompositionLocalMap;
            } else {
                persistentCompositionLocalMapF1 = F1(persistentCompositionLocalMapU0, persistentCompositionLocalMapC);
                if (!this.f23773z && Intrinsics.areEqual(persistentCompositionLocalMapF1, persistentCompositionLocalMap)) {
                    z2 = false;
                }
                z3 = z2;
            }
        }
        if (z3 && !i()) {
            h1(persistentCompositionLocalMapF1);
        }
        this.f23772y.h(ComposerKt.q(this.f23771x));
        this.f23771x = z3;
        this.M = persistentCompositionLocalMapF1;
        u1(202, ComposerKt.C(), GroupKind.f23894b.a(), persistentCompositionLocalMapF1);
    }

    public final boolean b1(MutableScatterMap mutableScatterMap, ShouldPauseCallback shouldPauseCallback) {
        if (!this.f23753f.e()) {
            ComposerKt.t("Expected applyChanges() to have been called");
        }
        if (ScopeMap.h(mutableScatterMap) <= 0 && this.f23767t.isEmpty() && !this.f23765r) {
            return false;
        }
        this.R = shouldPauseCallback;
        try {
            y0(mutableScatterMap, null);
            this.R = null;
            return this.f23753f.f();
        } catch (Throwable th) {
            this.R = null;
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public boolean c(float f3) {
        Object objV0 = V0();
        if ((objV0 instanceof Float) && f3 == ((Number) objV0).floatValue()) {
            return false;
        }
        H1(Float.valueOf(f3));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public void d() {
        this.f23773z = this.A >= 0;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean e(int i3) {
        Object objV0 = V0();
        if ((objV0 instanceof Integer) && i3 == ((Number) objV0).intValue()) {
            return false;
        }
        H1(Integer.valueOf(i3));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean f(long j3) {
        Object objV0 = V0();
        if ((objV0 instanceof Long) && j3 == ((Number) objV0).longValue()) {
            return false;
        }
        H1(Long.valueOf(j3));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean g(char c3) {
        Object objV0 = V0();
        if ((objV0 instanceof Character) && c3 == ((Character) objV0).charValue()) {
            return false;
        }
        H1(Character.valueOf(c3));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean h(double d3) {
        Object objV0 = V0();
        if ((objV0 instanceof Double) && d3 == ((Number) objV0).doubleValue()) {
            return false;
        }
        H1(Double.valueOf(d3));
        return true;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean i() {
        return this.S;
    }

    @Override // androidx.compose.runtime.Composer
    public void j(boolean z2) {
        if (!(this.f23759l == 0)) {
            ComposerKt.t("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (i()) {
            return;
        }
        if (!z2) {
            t1();
            return;
        }
        int iK = this.I.k();
        int iJ = this.I.j();
        this.O.d();
        ComposerKt.S(this.f23767t, iK, iJ);
        this.I.T();
    }

    @Override // androidx.compose.runtime.Composer
    public Composer k(int i3) {
        a0(i3);
        n0();
        return this;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean l() {
        RecomposeScopeImpl recomposeScopeImplL0;
        return (i() || this.f23773z || this.f23771x || (recomposeScopeImplL0 = L0()) == null || recomposeScopeImplL0.o() || this.f23765r) ? false : true;
    }

    @Override // androidx.compose.runtime.Composer
    public Applier m() {
        return this.f23749b;
    }

    @Override // androidx.compose.runtime.Composer
    public ScopeUpdateScope n() {
        Anchor anchorA;
        RecomposeScopeImpl recomposeScopeImpl = null;
        RecomposeScopeImpl recomposeScopeImpl2 = Stack.h(this.F) ? (RecomposeScopeImpl) Stack.k(this.F) : null;
        if (recomposeScopeImpl2 != null) {
            recomposeScopeImpl2.I(false);
            Function1 function1H = recomposeScopeImpl2.h(this.C);
            if (function1H != null) {
                this.O.f(function1H, K0());
            }
            if (recomposeScopeImpl2.q()) {
                recomposeScopeImpl2.K(false);
                this.O.k(recomposeScopeImpl2);
            }
        }
        if (recomposeScopeImpl2 != null && !recomposeScopeImpl2.s() && (recomposeScopeImpl2.t() || this.f23764q)) {
            if (recomposeScopeImpl2.i() == null) {
                if (i()) {
                    SlotWriter slotWriter = this.K;
                    anchorA = slotWriter.D(slotWriter.e0());
                } else {
                    SlotReader slotReader = this.I;
                    anchorA = slotReader.a(slotReader.u());
                }
                recomposeScopeImpl2.D(anchorA);
            }
            recomposeScopeImpl2.F(false);
            recomposeScopeImpl = recomposeScopeImpl2;
        }
        A0(false);
        return recomposeScopeImpl;
    }

    @Override // androidx.compose.runtime.Composer
    public void o() {
        u1(125, null, GroupKind.f23894b.b(), null);
        this.f23766s = true;
    }

    public final void o0() {
        this.f23770w = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void p(Object obj, Function2 function2) {
        if (i()) {
            this.Q.h(obj, function2);
        } else {
            this.O.d0(obj, function2);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Object q(CompositionLocal compositionLocal) {
        return CompositionLocalMapKt.b(u0(), compositionLocal);
    }

    public final void q1(SlotReader slotReader) {
        this.I = slotReader;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean r(boolean z2, int i3) {
        RecomposeScopeImpl recomposeScopeImplL0;
        if ((i3 & 1) != 0 || (!i() && !this.f23773z)) {
            return z2 || !l();
        }
        ShouldPauseCallback shouldPauseCallback = this.R;
        if (shouldPauseCallback == null || (recomposeScopeImplL0 = L0()) == null || !shouldPauseCallback.a()) {
            return true;
        }
        recomposeScopeImplL0.N(true);
        recomposeScopeImplL0.L(this.f23773z);
        recomposeScopeImplL0.H(true);
        this.O.Q(recomposeScopeImplL0);
        this.f23750c.r(recomposeScopeImplL0);
        return false;
    }

    public final void r0(MutableScatterMap mutableScatterMap, Function2 function2, ShouldPauseCallback shouldPauseCallback) {
        if (!this.f23753f.e()) {
            ComposerKt.t("Expected applyChanges() to have been called");
        }
        this.R = shouldPauseCallback;
        try {
            y0(mutableScatterMap, function2);
        } finally {
            this.R = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r1() {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerImpl.r1():void");
    }

    @Override // androidx.compose.runtime.Composer
    public void s(int i3) {
        if (i3 < 0) {
            int i4 = -i3;
            SlotWriter slotWriter = this.K;
            while (true) {
                int iE0 = slotWriter.e0();
                if (iE0 <= i4) {
                    return;
                } else {
                    A0(slotWriter.u0(iE0));
                }
            }
        } else {
            if (i()) {
                SlotWriter slotWriter2 = this.K;
                while (i()) {
                    A0(slotWriter2.u0(slotWriter2.e0()));
                }
            }
            SlotReader slotReader = this.I;
            while (true) {
                int iU = slotReader.u();
                if (iU <= i3) {
                    return;
                } else {
                    A0(slotReader.J(iU));
                }
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext t() {
        return this.f23750c.i();
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionLocalMap u() {
        return u0();
    }

    @Override // androidx.compose.runtime.Composer
    public void v() {
        J1();
        if (i()) {
            ComposerKt.t("useNode() called while inserting");
        }
        Object objN0 = N0(this.I);
        this.O.x(objN0);
        if (this.f23773z && (objN0 instanceof ComposeNodeLifecycleCallback)) {
            this.O.f0(objN0);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void w(Object obj) {
        B1(obj);
    }

    public final void w0() {
        Stack.a(this.F);
        this.f23767t.clear();
        this.f23753f.b();
        this.f23770w = null;
    }

    @Override // androidx.compose.runtime.Composer
    public void x() {
        B0();
        B0();
        this.f23771x = ComposerKt.p(this.f23772y.g());
        this.M = null;
    }

    public final void x0() {
        Trace trace = Trace.f24835a;
        Object objA = trace.a("Compose:Composer.dispose");
        try {
            this.f23750c.u(this);
            w0();
            m().clear();
            this.H = true;
            Unit unit = Unit.f139807a;
            trace.b(objA);
        } catch (Throwable th) {
            Trace.f24835a.b(objA);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void y() {
        A0(true);
    }

    public final void y1() {
        this.A = 100;
        this.f23773z = true;
    }

    @Override // androidx.compose.runtime.Composer
    public void z() {
        B0();
        RecomposeScopeImpl recomposeScopeImplL0 = L0();
        if (recomposeScopeImplL0 == null || !recomposeScopeImplL0.t()) {
            return;
        }
        recomposeScopeImplL0.E(true);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CompositionContextHolder implements ReusableRememberObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CompositionContextImpl f23774a;

        public CompositionContextHolder(CompositionContextImpl compositionContextImpl) {
            this.f23774a = compositionContextImpl;
        }

        public final CompositionContextImpl a() {
            return this.f23774a;
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void d() {
            this.f23774a.w();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void e() {
            this.f23774a.w();
        }

        @Override // androidx.compose.runtime.RememberObserver
        public void c() {
        }
    }
}
