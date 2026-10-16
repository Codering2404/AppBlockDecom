package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.compose.animation.core.h;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.RememberEventDispatcher;
import androidx.compose.runtime.internal.Trace;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner, CompositionServices, PausableComposition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CompositionContext f23804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Applier f23805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference f23806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f23807d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f23808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SlotTable f23809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableScatterMap f23810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableScatterSet f23811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableScatterSet f23812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableScatterMap f23813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ChangeList f23814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final ChangeList f23815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableScatterMap f23816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MutableScatterMap f23817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f23818p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ShouldPauseCallback f23819q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private PausedCompositionImpl f23820r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CompositionImpl f23821s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f23822t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final CompositionObserverHolder f23823u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ComposerImpl f23824v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final CoroutineContext f23825w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final boolean f23826x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f23827y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Function2 f23828z;

    public CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext) {
        this.f23804a = compositionContext;
        this.f23805b = applier;
        this.f23806c = new AtomicReference(null);
        this.f23807d = new Object();
        Set setM = new MutableScatterSet(0, 1, null).m();
        this.f23808f = setM;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.d()) {
            slotTable.l();
        }
        if (compositionContext.f()) {
            slotTable.n();
        }
        this.f23809g = slotTable;
        this.f23810h = ScopeMap.e(null, 1, null);
        this.f23811i = new MutableScatterSet(0, 1, null);
        this.f23812j = new MutableScatterSet(0, 1, null);
        this.f23813k = ScopeMap.e(null, 1, null);
        ChangeList changeList = new ChangeList();
        this.f23814l = changeList;
        ChangeList changeList2 = new ChangeList();
        this.f23815m = changeList2;
        this.f23816n = ScopeMap.e(null, 1, null);
        this.f23817o = ScopeMap.e(null, 1, null);
        this.f23823u = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, setM, changeList, changeList2, this);
        compositionContext.q(composerImpl);
        this.f23824v = composerImpl;
        this.f23825w = coroutineContext;
        this.f23826x = compositionContext instanceof Recomposer;
        this.f23828z = ComposableSingletons$CompositionKt.f23733a.a();
    }

    private final void A() {
        char c3;
        long j3;
        long j4;
        long j5;
        long[] jArr;
        long[] jArr2;
        long j6;
        int i3;
        char c4;
        long j7;
        long j8;
        int i4;
        boolean zE;
        long[] jArr3;
        int i5;
        int i6;
        MutableScatterMap mutableScatterMap = this.f23813k;
        long[] jArr4 = mutableScatterMap.f3108a;
        int length = jArr4.length - 2;
        char c5 = 7;
        long j9 = -9187201950435737472L;
        int i7 = 8;
        if (length >= 0) {
            int i8 = 0;
            long j10 = 128;
            while (true) {
                long j11 = jArr4[i8];
                j4 = 255;
                if ((((~j11) << c5) & j11 & j9) != j9) {
                    int i9 = 8 - ((~(i8 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j11 & 255) < j10) {
                            c4 = c5;
                            int i11 = (i8 << 3) + i10;
                            j7 = j9;
                            Object obj = mutableScatterMap.f3109b[i11];
                            Object obj2 = mutableScatterMap.f3110c[i11];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr = mutableScatterSet.f3116b;
                                long[] jArr5 = mutableScatterSet.f3115a;
                                int length2 = jArr5.length - 2;
                                if (length2 >= 0) {
                                    j8 = j10;
                                    int i12 = 0;
                                    int i13 = i7;
                                    while (true) {
                                        int i14 = length2;
                                        long j12 = jArr5[i12];
                                        j6 = j11;
                                        if ((((~j12) << c4) & j12 & j7) != j7) {
                                            int i15 = 8 - ((~(i12 - i14)) >>> 31);
                                            int i16 = 0;
                                            while (i16 < i15) {
                                                if ((j12 & 255) < j8) {
                                                    jArr3 = jArr4;
                                                    int i17 = (i12 << 3) + i16;
                                                    i5 = i16;
                                                    i6 = i10;
                                                    if (!ScopeMap.f(this.f23810h, (DerivedState) objArr[i17])) {
                                                        mutableScatterSet.B(i17);
                                                    }
                                                } else {
                                                    jArr3 = jArr4;
                                                    i5 = i16;
                                                    i6 = i10;
                                                }
                                                j12 >>= i13;
                                                i16 = i5 + 1;
                                                i10 = i6;
                                                jArr4 = jArr3;
                                            }
                                            jArr2 = jArr4;
                                            i3 = i10;
                                            if (i15 != i13) {
                                                break;
                                            }
                                        } else {
                                            jArr2 = jArr4;
                                            i3 = i10;
                                        }
                                        length2 = i14;
                                        if (i12 == length2) {
                                            break;
                                        }
                                        i12++;
                                        j11 = j6;
                                        i10 = i3;
                                        jArr4 = jArr2;
                                        i13 = 8;
                                    }
                                } else {
                                    jArr2 = jArr4;
                                    j6 = j11;
                                    i3 = i10;
                                    j8 = j10;
                                }
                                zE = mutableScatterSet.e();
                            } else {
                                jArr2 = jArr4;
                                j6 = j11;
                                i3 = i10;
                                j8 = j10;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
                                zE = !ScopeMap.f(this.f23810h, (DerivedState) obj2);
                            }
                            if (zE) {
                                mutableScatterMap.v(i11);
                            }
                            i4 = 8;
                        } else {
                            jArr2 = jArr4;
                            j6 = j11;
                            i3 = i10;
                            c4 = c5;
                            j7 = j9;
                            j8 = j10;
                            i4 = i7;
                        }
                        j11 = j6 >> i4;
                        i10 = i3 + 1;
                        i7 = i4;
                        c5 = c4;
                        j9 = j7;
                        j10 = j8;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    c3 = c5;
                    j3 = j9;
                    j5 = j10;
                    if (i9 != i7) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                    c3 = c5;
                    j3 = j9;
                    j5 = j10;
                }
                if (i8 == length) {
                    break;
                }
                i8++;
                c5 = c3;
                j9 = j3;
                j10 = j5;
                jArr4 = jArr;
                i7 = 8;
            }
        } else {
            c3 = 7;
            j3 = -9187201950435737472L;
            j4 = 255;
            j5 = 128;
        }
        if (!this.f23812j.f()) {
            return;
        }
        MutableScatterSet mutableScatterSet2 = this.f23812j;
        Object[] objArr2 = mutableScatterSet2.f3116b;
        long[] jArr6 = mutableScatterSet2.f3115a;
        int length3 = jArr6.length - 2;
        if (length3 < 0) {
            return;
        }
        int i18 = 0;
        while (true) {
            long j13 = jArr6[i18];
            if ((((~j13) << c3) & j13 & j3) != j3) {
                int i19 = 8 - ((~(i18 - length3)) >>> 31);
                for (int i20 = 0; i20 < i19; i20++) {
                    if ((j13 & j4) < j5) {
                        int i21 = (i18 << 3) + i20;
                        if (!((RecomposeScopeImpl) objArr2[i21]).w()) {
                            mutableScatterSet2.B(i21);
                        }
                    }
                    j13 >>= 8;
                }
                if (i19 != 8) {
                    return;
                }
            }
            if (i18 == length3) {
                return;
            } else {
                i18++;
            }
        }
    }

    private final void B(Function2 function2) {
        if (this.f23827y) {
            PreconditionsKt.b("The composition is disposed");
        }
        this.f23828z = function2;
        this.f23804a.a(this, function2);
    }

    private final void C() {
        Object andSet = this.f23806c.getAndSet(CompositionKt.f23829a);
        if (andSet != null) {
            if (Intrinsics.areEqual(andSet, CompositionKt.f23829a)) {
                ComposerKt.u("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                y((Set) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.u("corrupt pendingModifications drain: " + this.f23806c);
                throw new KotlinNothingValueException();
            }
            for (Set set : (Set[]) andSet) {
                y(set, true);
            }
        }
    }

    private final void D() {
        Object andSet = this.f23806c.getAndSet(null);
        if (Intrinsics.areEqual(andSet, CompositionKt.f23829a)) {
            return;
        }
        if (andSet instanceof Set) {
            y((Set) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set set : (Set[]) andSet) {
                y(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.u("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        ComposerKt.u("corrupt pendingModifications drain: " + this.f23806c);
        throw new KotlinNothingValueException();
    }

    private final void E() {
        Object andSet = this.f23806c.getAndSet(SetsKt.emptySet());
        if (Intrinsics.areEqual(andSet, CompositionKt.f23829a) || andSet == null) {
            return;
        }
        if (andSet instanceof Set) {
            y((Set) andSet, false);
            return;
        }
        if (!(andSet instanceof Object[])) {
            ComposerKt.u("corrupt pendingModifications drain: " + this.f23806c);
            throw new KotlinNothingValueException();
        }
        for (Set set : (Set[]) andSet) {
            y(set, false);
        }
    }

    private final boolean F() {
        return this.f23824v.J0();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac A[Catch: all -> 0x001e, EDGE_INSN: B:66:0x00ac->B:51:0x00ac BREAK  A[LOOP:0: B:33:0x0063->B:47:0x00a4], EDGE_INSN: B:67:0x00ac->B:51:0x00ac BREAK  A[LOOP:0: B:33:0x0063->B:47:0x00a4], TRY_LEAVE, TryCatch #0 {all -> 0x001e, blocks: (B:4:0x000b, B:6:0x0010, B:14:0x0023, B:16:0x0029, B:19:0x002d, B:21:0x0033, B:23:0x003e, B:25:0x0042, B:26:0x004b, B:28:0x0053, B:30:0x0057, B:33:0x0063, B:35:0x0073, B:37:0x007f, B:39:0x0089, B:43:0x0098, B:47:0x00a4, B:48:0x00a7, B:51:0x00ac), top: B:64:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.runtime.InvalidationResult J(androidx.compose.runtime.RecomposeScopeImpl r21, androidx.compose.runtime.Anchor r22, java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.J(androidx.compose.runtime.RecomposeScopeImpl, androidx.compose.runtime.Anchor, java.lang.Object):androidx.compose.runtime.InvalidationResult");
    }

    private final void K(Object obj) {
        Object objE = this.f23810h.e(obj);
        if (objE == null) {
            return;
        }
        if (!(objE instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objE;
            if (recomposeScopeImpl.v(obj) == InvalidationResult.f23914d) {
                ScopeMap.a(this.f23816n, obj, recomposeScopeImpl);
                return;
            }
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) objE;
        Object[] objArr = mutableScatterSet.f3116b;
        long[] jArr = mutableScatterSet.f3115a;
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
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i3 << 3) + i5];
                        if (recomposeScopeImpl2.v(obj) == InvalidationResult.f23914d) {
                            ScopeMap.a(this.f23816n, obj, recomposeScopeImpl2);
                        }
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

    private final CompositionObserver L() {
        CompositionObserverHolder compositionObserverHolder = this.f23823u;
        if (compositionObserverHolder.b()) {
            return compositionObserverHolder.a();
        }
        CompositionObserverHolder compositionObserverHolderJ = this.f23804a.j();
        CompositionObserver compositionObserverA = compositionObserverHolderJ != null ? compositionObserverHolderJ.a() : null;
        if (!Intrinsics.areEqual(compositionObserverA, compositionObserverHolder.a())) {
            compositionObserverHolder.c(compositionObserverA);
        }
        return compositionObserverA;
    }

    private final MutableScatterMap O() {
        MutableScatterMap mutableScatterMap = this.f23817o;
        this.f23817o = ScopeMap.e(null, 1, null);
        return mutableScatterMap;
    }

    private final boolean P(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        return p() && this.f23824v.A1(recomposeScopeImpl, obj);
    }

    private final void x(Object obj, boolean z2) {
        Object objE = this.f23810h.e(obj);
        if (objE == null) {
            return;
        }
        if (!(objE instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objE;
            if (ScopeMap.j(this.f23816n, obj, recomposeScopeImpl) || recomposeScopeImpl.v(obj) == InvalidationResult.f23911a) {
                return;
            }
            if (!recomposeScopeImpl.w() || z2) {
                this.f23811i.i(recomposeScopeImpl);
                return;
            } else {
                this.f23812j.i(recomposeScopeImpl);
                return;
            }
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) objE;
        Object[] objArr = mutableScatterSet.f3116b;
        long[] jArr = mutableScatterSet.f3115a;
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
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i3 << 3) + i5];
                        if (!ScopeMap.j(this.f23816n, obj, recomposeScopeImpl2) && recomposeScopeImpl2.v(obj) != InvalidationResult.f23911a) {
                            if (!recomposeScopeImpl2.w() || z2) {
                                this.f23811i.i(recomposeScopeImpl2);
                            } else {
                                this.f23812j.i(recomposeScopeImpl2);
                            }
                        }
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

    /* JADX WARN: Removed duplicated region for block: B:107:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0176 A[EDGE_INSN: B:70:0x0176->B:219:0x0113 BREAK  A[LOOP:13: B:60:0x0144->B:71:0x0178]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void y(java.util.Set r36, boolean r37) {
        /*
            Method dump skipped, instruction units count: 925
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.y(java.util.Set, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void z(androidx.compose.runtime.changelist.ChangeList r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.z(androidx.compose.runtime.changelist.ChangeList):void");
    }

    public final CompositionObserverHolder G() {
        return this.f23823u;
    }

    public final CoroutineContext H() {
        CoroutineContext coroutineContext = this.f23825w;
        return coroutineContext == null ? this.f23804a.k() : coroutineContext;
    }

    public final SlotTable I() {
        return this.f23809g;
    }

    public final void M(DerivedState derivedState) {
        if (ScopeMap.f(this.f23810h, derivedState)) {
            return;
        }
        ScopeMap.k(this.f23813k, derivedState);
    }

    public final void N(Object obj, RecomposeScopeImpl recomposeScopeImpl) {
        ScopeMap.j(this.f23810h, obj, recomposeScopeImpl);
    }

    public final void Q() {
        synchronized (this.f23807d) {
            E();
            MutableScatterMap mutableScatterMapO = O();
            try {
                this.f23824v.C1(mutableScatterMapO);
                Unit unit = Unit.f139807a;
            } catch (Exception e3) {
                this.f23817o = mutableScatterMapO;
                throw e3;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void a(Object obj) {
        RecomposeScopeImpl recomposeScopeImplL0;
        int i3;
        int i4;
        int i5;
        if (F() || (recomposeScopeImplL0 = this.f23824v.L0()) == null) {
            return;
        }
        int i6 = 1;
        recomposeScopeImplL0.N(true);
        if (recomposeScopeImplL0.z(obj)) {
            return;
        }
        if (obj instanceof StateObjectImpl) {
            ((StateObjectImpl) obj).r(ReaderKind.a(1));
        }
        ScopeMap.a(this.f23810h, obj, recomposeScopeImplL0);
        if (obj instanceof DerivedState) {
            DerivedState derivedState = (DerivedState) obj;
            DerivedState.Record recordU = derivedState.u();
            ScopeMap.k(this.f23813k, obj);
            ObjectIntMap objectIntMapB = recordU.b();
            Object[] objArr = objectIntMapB.f3076b;
            long[] jArr = objectIntMapB.f3075a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i7 = 0;
                while (true) {
                    long j3 = jArr[i7];
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8;
                        int i9 = 8 - ((~(i7 - length)) >>> 31);
                        int i10 = 0;
                        while (i10 < i9) {
                            if ((j3 & 255) < 128) {
                                i4 = i6;
                                StateObject stateObject = (StateObject) objArr[(i7 << 3) + i10];
                                if (stateObject instanceof StateObjectImpl) {
                                    i5 = i8;
                                    ((StateObjectImpl) stateObject).r(ReaderKind.a(i4));
                                } else {
                                    i5 = i8;
                                }
                                ScopeMap.a(this.f23813k, stateObject, obj);
                            } else {
                                i4 = i6;
                                i5 = i8;
                            }
                            j3 >>= i5;
                            i10++;
                            i6 = i4;
                            i8 = i5;
                        }
                        i3 = i6;
                        if (i9 != i8) {
                            break;
                        }
                    } else {
                        i3 = i6;
                    }
                    if (i7 == length) {
                        break;
                    }
                    i7++;
                    i6 = i3;
                }
            }
            recomposeScopeImplL0.y(derivedState, recordU.a());
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void b(RecomposeScopeImpl recomposeScopeImpl) {
        this.f23818p = true;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void c(Function2 function2) {
        MutableScatterMap mutableScatterMapO;
        try {
            synchronized (this.f23807d) {
                try {
                    C();
                    mutableScatterMapO = O();
                    CompositionObserver compositionObserverL = L();
                    if (compositionObserverL != null) {
                        Map mapB = ScopeMap.b(mutableScatterMapO);
                        Intrinsics.checkNotNull(mapB, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>>");
                        compositionObserverL.a(this, mapB);
                    }
                    this.f23824v.r0(mutableScatterMapO, function2, this.f23819q);
                    if (compositionObserverL != null) {
                        compositionObserverL.b(this);
                        Unit unit = Unit.f139807a;
                    }
                } catch (Exception e3) {
                    this.f23817o = mutableScatterMapO;
                    throw e3;
                } finally {
                }
            }
        } finally {
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void d() {
        synchronized (this.f23807d) {
            try {
                if (this.f23815m.f()) {
                    z(this.f23815m);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.f23808f.isEmpty()) {
                            new RememberEventDispatcher(this.f23808f).i();
                        }
                        throw th;
                    } catch (Exception e3) {
                        t();
                        throw e3;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        synchronized (this.f23807d) {
            try {
                boolean z2 = this.f23809g.t() > 0;
                if (z2 || !this.f23808f.isEmpty()) {
                    Trace trace = Trace.f24835a;
                    Object objA = trace.a("Compose:deactivate");
                    try {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.f23808f);
                        if (z2) {
                            this.f23805b.j();
                            SlotWriter slotWriterC = this.f23809g.C();
                            try {
                                ComposerKt.v(slotWriterC, rememberEventDispatcher);
                                Unit unit = Unit.f139807a;
                                slotWriterC.L(true);
                                this.f23805b.f();
                                rememberEventDispatcher.k();
                            } catch (Throwable th) {
                                slotWriterC.L(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.i();
                        Unit unit2 = Unit.f139807a;
                        trace.b(objA);
                    } catch (Throwable th2) {
                        Trace.f24835a.b(objA);
                        throw th2;
                    }
                }
                ScopeMap.c(this.f23810h);
                ScopeMap.c(this.f23813k);
                ScopeMap.c(this.f23817o);
                this.f23814l.b();
                this.f23815m.b();
                this.f23824v.w0();
                Unit unit3 = Unit.f139807a;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.f23807d) {
            try {
                if (this.f23824v.U0()) {
                    PreconditionsKt.b("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (!this.f23827y) {
                    this.f23827y = true;
                    this.f23828z = ComposableSingletons$CompositionKt.f23733a.b();
                    ChangeList changeListM0 = this.f23824v.M0();
                    if (changeListM0 != null) {
                        z(changeListM0);
                    }
                    boolean z2 = this.f23809g.t() > 0;
                    if (z2 || !this.f23808f.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.f23808f);
                        if (z2) {
                            this.f23805b.j();
                            SlotWriter slotWriterC = this.f23809g.C();
                            try {
                                ComposerKt.P(slotWriterC, rememberEventDispatcher);
                                Unit unit = Unit.f139807a;
                                slotWriterC.L(true);
                                this.f23805b.clear();
                                this.f23805b.f();
                                rememberEventDispatcher.k();
                            } catch (Throwable th) {
                                slotWriterC.L(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.i();
                    }
                    this.f23824v.x0();
                }
                Unit unit2 = Unit.f139807a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f23804a.v(this);
    }

    @Override // androidx.compose.runtime.Composition
    public boolean e() {
        return this.f23827y;
    }

    @Override // androidx.compose.runtime.Composition
    public void f(Function2 function2) {
        if (!(this.f23820r == null)) {
            PreconditionsKt.b("A pausable composition is in progress");
        }
        B(function2);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void g(MovableContentState movableContentState) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.f23808f);
        SlotWriter slotWriterC = movableContentState.d().C();
        try {
            ComposerKt.P(slotWriterC, rememberEventDispatcher);
            Unit unit = Unit.f139807a;
            slotWriterC.L(true);
            rememberEventDispatcher.k();
        } catch (Throwable th) {
            slotWriterC.L(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void h(List list) {
        int size = list.size();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z2 = true;
                break;
            } else if (!Intrinsics.areEqual(((MovableContentStateReference) ((Pair) list.get(i3)).e()).b(), this)) {
                break;
            } else {
                i3++;
            }
        }
        if (!z2) {
            ComposerKt.t("Check failed");
        }
        try {
            this.f23824v.R0(list);
            Unit unit = Unit.f139807a;
        } finally {
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public Object i(ControlledComposition controlledComposition, int i3, Function0 function0) {
        if (controlledComposition == null || Intrinsics.areEqual(controlledComposition, this) || i3 < 0) {
            return function0.invoke();
        }
        this.f23821s = (CompositionImpl) controlledComposition;
        this.f23822t = i3;
        try {
            return function0.invoke();
        } finally {
            this.f23821s = null;
            this.f23822t = 0;
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult j(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        CompositionImpl compositionImpl;
        if (recomposeScopeImpl.k()) {
            recomposeScopeImpl.F(true);
        }
        Anchor anchorI = recomposeScopeImpl.i();
        if (anchorI == null || !anchorI.b()) {
            return InvalidationResult.f23911a;
        }
        if (this.f23809g.D(anchorI)) {
            return !recomposeScopeImpl.j() ? InvalidationResult.f23911a : J(recomposeScopeImpl, anchorI, obj);
        }
        synchronized (this.f23807d) {
            compositionImpl = this.f23821s;
        }
        return (compositionImpl == null || !compositionImpl.P(recomposeScopeImpl, obj)) ? InvalidationResult.f23911a : InvalidationResult.f23914d;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean k() {
        boolean zB1;
        synchronized (this.f23807d) {
            try {
                C();
                try {
                    MutableScatterMap mutableScatterMapO = O();
                    try {
                        CompositionObserver compositionObserverL = L();
                        if (compositionObserverL != null) {
                            Map mapB = ScopeMap.b(mutableScatterMapO);
                            Intrinsics.checkNotNull(mapB, "null cannot be cast to non-null type kotlin.collections.Map<androidx.compose.runtime.RecomposeScope, kotlin.collections.Set<kotlin.Any>>");
                            compositionObserverL.a(this, mapB);
                        }
                        zB1 = this.f23824v.b1(mutableScatterMapO, this.f23819q);
                        if (!zB1) {
                            D();
                        }
                        if (compositionObserverL != null) {
                            compositionObserverL.b(this);
                        }
                    } catch (Exception e3) {
                        this.f23817o = mutableScatterMapO;
                        throw e3;
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zB1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean l(java.util.Set r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof androidx.compose.runtime.collection.ScatterSetWrapper
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5c
            androidx.compose.runtime.collection.ScatterSetWrapper r15 = (androidx.compose.runtime.collection.ScatterSetWrapper) r15
            androidx.collection.ScatterSet r15 = r15.a()
            java.lang.Object[] r0 = r15.f3116b
            long[] r15 = r15.f3115a
            int r3 = r15.length
            int r3 = r3 + (-2)
            if (r3 < 0) goto L7d
            r4 = r1
        L16:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r3
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r1
        L30:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            androidx.collection.MutableScatterMap r11 = r14.f23810h
            boolean r11 = androidx.compose.runtime.collection.ScopeMap.f(r11, r10)
            if (r11 != 0) goto L50
            androidx.collection.MutableScatterMap r11 = r14.f23813k
            boolean r10 = androidx.compose.runtime.collection.ScopeMap.f(r11, r10)
            if (r10 == 0) goto L51
        L50:
            return r2
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L30
        L55:
            if (r7 != r8) goto L7d
        L57:
            if (r4 == r3) goto L7d
            int r4 = r4 + 1
            goto L16
        L5c:
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.Iterator r15 = r15.iterator()
        L62:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r15.next()
            androidx.collection.MutableScatterMap r3 = r14.f23810h
            boolean r3 = androidx.compose.runtime.collection.ScopeMap.f(r3, r0)
            if (r3 != 0) goto L7c
            androidx.collection.MutableScatterMap r3 = r14.f23813k
            boolean r0 = androidx.compose.runtime.collection.ScopeMap.f(r3, r0)
            if (r0 == 0) goto L62
        L7c:
            return r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.l(java.util.Set):boolean");
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void m(Function0 function0) {
        this.f23824v.Z0(function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.ControlledComposition
    public void n(Set set) {
        Object obj;
        Object objPlus;
        do {
            obj = this.f23806c.get();
            if (obj == null ? true : Intrinsics.areEqual(obj, CompositionKt.f23829a)) {
                objPlus = set;
            } else if (obj instanceof Set) {
                objPlus = new Set[]{obj, set};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.f23806c).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                objPlus = ArraysKt.plus((Set[]) obj, set);
            }
        } while (!h.a(this.f23806c, obj, objPlus));
        if (obj == null) {
            synchronized (this.f23807d) {
                D();
                Unit unit = Unit.f139807a;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void o() {
        synchronized (this.f23807d) {
            try {
                z(this.f23814l);
                D();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.f23808f.isEmpty()) {
                            new RememberEventDispatcher(this.f23808f).i();
                        }
                        throw th;
                    } catch (Exception e3) {
                        t();
                        throw e3;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean p() {
        return this.f23824v.U0();
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void q(Function2 function2) {
        if (!(this.f23820r == null)) {
            PreconditionsKt.b("A pausable composition is in progress");
        }
        this.f23824v.y1();
        B(function2);
        this.f23824v.C0();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = r14.f23807d
            monitor-enter(r0)
            r14.K(r15)     // Catch: java.lang.Throwable -> L4f
            androidx.collection.MutableScatterMap r1 = r14.f23813k     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r15 = r1.e(r15)     // Catch: java.lang.Throwable -> L4f
            if (r15 == 0) goto L61
            boolean r1 = r15 instanceof androidx.collection.MutableScatterSet     // Catch: java.lang.Throwable -> L4f
            if (r1 == 0) goto L5c
            androidx.collection.MutableScatterSet r15 = (androidx.collection.MutableScatterSet) r15     // Catch: java.lang.Throwable -> L4f
            java.lang.Object[] r1 = r15.f3116b     // Catch: java.lang.Throwable -> L4f
            long[] r15 = r15.f3115a     // Catch: java.lang.Throwable -> L4f
            int r2 = r15.length     // Catch: java.lang.Throwable -> L4f
            int r2 = r2 + (-2)
            if (r2 < 0) goto L61
            r3 = 0
            r4 = r3
        L1f:
            r5 = r15[r4]     // Catch: java.lang.Throwable -> L4f
            long r7 = ~r5     // Catch: java.lang.Throwable -> L4f
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L57
            int r7 = r4 - r2
            int r7 = ~r7     // Catch: java.lang.Throwable -> L4f
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L39:
            if (r9 >= r7) goto L55
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L51
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]     // Catch: java.lang.Throwable -> L4f
            androidx.compose.runtime.DerivedState r10 = (androidx.compose.runtime.DerivedState) r10     // Catch: java.lang.Throwable -> L4f
            r14.K(r10)     // Catch: java.lang.Throwable -> L4f
            goto L51
        L4f:
            r15 = move-exception
            goto L65
        L51:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L39
        L55:
            if (r7 != r8) goto L61
        L57:
            if (r4 == r2) goto L61
            int r4 = r4 + 1
            goto L1f
        L5c:
            androidx.compose.runtime.DerivedState r15 = (androidx.compose.runtime.DerivedState) r15     // Catch: java.lang.Throwable -> L4f
            r14.K(r15)     // Catch: java.lang.Throwable -> L4f
        L61:
            kotlin.Unit r15 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L4f
            monitor-exit(r0)
            return
        L65:
            monitor-exit(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.CompositionImpl.r(java.lang.Object):void");
    }

    @Override // androidx.compose.runtime.Composition
    public boolean s() {
        boolean z2;
        synchronized (this.f23807d) {
            z2 = ScopeMap.h(this.f23817o) > 0;
        }
        return z2;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void t() {
        this.f23806c.set(null);
        this.f23814l.b();
        this.f23815m.b();
        if (this.f23808f.isEmpty()) {
            return;
        }
        new RememberEventDispatcher(this.f23808f).i();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void u() {
        synchronized (this.f23807d) {
            try {
                this.f23824v.o0();
                if (!this.f23808f.isEmpty()) {
                    new RememberEventDispatcher(this.f23808f).i();
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.f23808f.isEmpty()) {
                            new RememberEventDispatcher(this.f23808f).i();
                        }
                        throw th;
                    } catch (Exception e3) {
                        t();
                        throw e3;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void v() {
        synchronized (this.f23807d) {
            try {
                for (Object obj : this.f23809g.u()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i3 & 4) != 0 ? null : coroutineContext);
    }
}
