package androidx.compose.runtime.internal;

import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.collection.MutableVector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
public final class RememberEventDispatcher implements RememberManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f24816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableVector f24817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutableVector f24818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableVector f24819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableVector f24820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MutableScatterSet f24821f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MutableScatterMap f24822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f24823h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableIntList f24824i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableIntList f24825j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList f24826k;

    public RememberEventDispatcher(Set set) {
        this.f24816a = set;
        MutableVector mutableVector = new MutableVector(new RememberObserverHolder[16], 0);
        this.f24817b = mutableVector;
        this.f24818c = mutableVector;
        this.f24819d = new MutableVector(new Object[16], 0);
        this.f24820e = new MutableVector(new Function0[16], 0);
        this.f24823h = new ArrayList();
        this.f24824i = new MutableIntList(0, 1, null);
        this.f24825j = new MutableIntList(0, 1, null);
    }

    private final void j(MutableVector mutableVector) {
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            RememberObserver rememberObserverB = ((RememberObserverHolder) objArr[i3]).b();
            this.f24816a.remove(rememberObserverB);
            rememberObserverB.c();
        }
    }

    private final void m(int i3) {
        if (this.f24823h.isEmpty()) {
            return;
        }
        int i4 = 0;
        int i5 = 0;
        List listMutableListOf = null;
        MutableIntList mutableIntList = null;
        MutableIntList mutableIntList2 = null;
        while (true) {
            MutableIntList mutableIntList3 = this.f24825j;
            if (i5 >= mutableIntList3.f2877b) {
                break;
            }
            if (i3 <= mutableIntList3.e(i5)) {
                Object objRemove = this.f24823h.remove(i5);
                int iP = this.f24825j.p(i5);
                int iP2 = this.f24824i.p(i5);
                if (listMutableListOf == null) {
                    listMutableListOf = CollectionsKt.mutableListOf(objRemove);
                    mutableIntList2 = new MutableIntList(0, 1, null);
                    mutableIntList2.l(iP);
                    mutableIntList = new MutableIntList(0, 1, null);
                    mutableIntList.l(iP2);
                } else {
                    Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                    listMutableListOf.add(objRemove);
                    mutableIntList2.l(iP);
                    mutableIntList.l(iP2);
                }
            } else {
                i5++;
            }
        }
        if (listMutableListOf != null) {
            Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
            Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
            int size = listMutableListOf.size() - 1;
            while (i4 < size) {
                int i6 = i4 + 1;
                int size2 = listMutableListOf.size();
                for (int i7 = i6; i7 < size2; i7++) {
                    int iE = mutableIntList2.e(i4);
                    int iE2 = mutableIntList2.e(i7);
                    if (iE < iE2 || (iE2 == iE && mutableIntList.e(i4) < mutableIntList.e(i7))) {
                        RememberEventDispatcherKt.d(listMutableListOf, i4, i7);
                        RememberEventDispatcherKt.c(mutableIntList, i4, i7);
                        RememberEventDispatcherKt.c(mutableIntList2, i4, i7);
                    }
                }
                i4 = i6;
            }
            MutableVector mutableVector = this.f24819d;
            mutableVector.f(mutableVector.o(), listMutableListOf);
        }
    }

    private final void n(Object obj, int i3, int i4, int i5) {
        m(i3);
        if (i5 < 0 || i5 >= i3) {
            this.f24819d.b(obj);
            return;
        }
        this.f24823h.add(obj);
        this.f24824i.l(i4);
        this.f24825j.l(i5);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void a(Function0 function0) {
        this.f24820e.b(function0);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void b(ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i3, int i4, int i5) {
        MutableScatterSet mutableScatterSetA = this.f24821f;
        if (mutableScatterSetA == null) {
            mutableScatterSetA = ScatterSetKt.a();
            this.f24821f = mutableScatterSetA;
        }
        mutableScatterSetA.y(composeNodeLifecycleCallback);
        n(composeNodeLifecycleCallback, i3, i4, i5);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void c(RecomposeScopeImpl recomposeScopeImpl) {
        PausedCompositionRemembers pausedCompositionRemembers = new PausedCompositionRemembers(this.f24816a);
        MutableScatterMap mutableScatterMapC = this.f24822g;
        if (mutableScatterMapC == null) {
            mutableScatterMapC = ScatterMapKt.c();
            this.f24822g = mutableScatterMapC;
        }
        mutableScatterMapC.x(recomposeScopeImpl, pausedCompositionRemembers);
        this.f24818c.b(new RememberObserverHolder(pausedCompositionRemembers, null));
    }

    @Override // androidx.compose.runtime.RememberManager
    public void d(RecomposeScopeImpl recomposeScopeImpl) {
        MutableVector mutableVector;
        MutableScatterMap mutableScatterMap = this.f24822g;
        if (mutableScatterMap == null || ((PausedCompositionRemembers) mutableScatterMap.e(recomposeScopeImpl)) == null) {
            return;
        }
        ArrayList arrayList = this.f24826k;
        if (arrayList != null && (mutableVector = (MutableVector) Stack.k(arrayList)) != null) {
            this.f24818c = mutableVector;
        }
        mutableScatterMap.u(recomposeScopeImpl);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void e(RememberObserverHolder rememberObserverHolder, int i3, int i4, int i5) {
        n(rememberObserverHolder, i3, i4, i5);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void f(RecomposeScopeImpl recomposeScopeImpl) {
        MutableScatterMap mutableScatterMap = this.f24822g;
        PausedCompositionRemembers pausedCompositionRemembers = mutableScatterMap != null ? (PausedCompositionRemembers) mutableScatterMap.e(recomposeScopeImpl) : null;
        if (pausedCompositionRemembers != null) {
            ArrayList arrayListC = this.f24826k;
            if (arrayListC == null) {
                arrayListC = Stack.c(null, 1, null);
                this.f24826k = arrayListC;
            }
            Stack.l(arrayListC, this.f24818c);
            this.f24818c = pausedCompositionRemembers.a();
        }
    }

    @Override // androidx.compose.runtime.RememberManager
    public void g(RememberObserverHolder rememberObserverHolder) {
        this.f24818c.b(rememberObserverHolder);
    }

    @Override // androidx.compose.runtime.RememberManager
    public void h(ComposeNodeLifecycleCallback composeNodeLifecycleCallback, int i3, int i4, int i5) {
        n(composeNodeLifecycleCallback, i3, i4, i5);
    }

    public final void i() {
        if (this.f24816a.isEmpty()) {
            return;
        }
        Object objA = Trace.f24835a.a("Compose:abandons");
        try {
            Iterator it = this.f24816a.iterator();
            while (it.hasNext()) {
                RememberObserver rememberObserver = (RememberObserver) it.next();
                it.remove();
                rememberObserver.d();
            }
            Unit unit = Unit.f139807a;
            Trace.f24835a.b(objA);
        } catch (Throwable th) {
            Trace.f24835a.b(objA);
            throw th;
        }
    }

    public final void k() {
        Object objA;
        m(Integer.MIN_VALUE);
        if (this.f24819d.o() != 0) {
            objA = Trace.f24835a.a("Compose:onForgotten");
            try {
                MutableScatterSet mutableScatterSet = this.f24821f;
                for (int iO = this.f24819d.o() - 1; -1 < iO; iO--) {
                    Object obj = this.f24819d.f24389a[iO];
                    if (obj instanceof RememberObserverHolder) {
                        RememberObserver rememberObserverB = ((RememberObserverHolder) obj).b();
                        this.f24816a.remove(rememberObserverB);
                        rememberObserverB.e();
                    }
                    if (obj instanceof ComposeNodeLifecycleCallback) {
                        if (mutableScatterSet == null || !mutableScatterSet.b(obj)) {
                            ((ComposeNodeLifecycleCallback) obj).f();
                        } else {
                            ((ComposeNodeLifecycleCallback) obj).b();
                        }
                    }
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.f24817b.o() != 0) {
            Trace trace = Trace.f24835a;
            objA = trace.a("Compose:onRemembered");
            try {
                j(this.f24817b);
                Unit unit2 = Unit.f139807a;
                trace.b(objA);
            } finally {
                Trace.f24835a.b(objA);
            }
        }
    }

    public final void l() {
        if (this.f24820e.o() != 0) {
            Object objA = Trace.f24835a.a("Compose:sideeffects");
            try {
                MutableVector mutableVector = this.f24820e;
                Object[] objArr = mutableVector.f24389a;
                int iO = mutableVector.o();
                for (int i3 = 0; i3 < iO; i3++) {
                    ((Function0) objArr[i3]).invoke();
                }
                this.f24820e.i();
                Unit unit = Unit.f139807a;
                Trace.f24835a.b(objA);
            } catch (Throwable th) {
                Trace.f24835a.b(objA);
                throw th;
            }
        }
    }
}
