package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.collection.MultiValueMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class ComposerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static CompositionTracer f23792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f23793b = new OpaqueKey("provider");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f23794c = new OpaqueKey("provider");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f23795d = new OpaqueKey("compositionLocalMap");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object f23796e = new OpaqueKey("providerValues");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f23797f = new OpaqueKey("providers");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f23798g = new OpaqueKey("reference");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Comparator f23799h = new Comparator() { // from class: androidx.compose.runtime.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ComposerKt.b((Invalidation) obj, (Invalidation) obj2);
        }
    };

    private static final int A(List list, int i3) {
        int size = list.size() - 1;
        int i4 = 0;
        while (i4 <= size) {
            int i5 = (i4 + size) >>> 1;
            int iCompare = Intrinsics.compare(((Invalidation) list.get(i5)).b(), i3);
            if (iCompare < 0) {
                i4 = i5 + 1;
            } else {
                if (iCompare <= 0) {
                    return i5;
                }
                size = i5 - 1;
            }
        }
        return -(i4 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation B(List list, int i3, int i4) {
        int iZ = z(list, i3);
        if (iZ >= list.size()) {
            return null;
        }
        Invalidation invalidation = (Invalidation) list.get(iZ);
        if (invalidation.b() < i4) {
            return invalidation;
        }
        return null;
    }

    public static final Object C() {
        return f23795d;
    }

    public static final Object D() {
        return f23793b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object E(KeyInfo keyInfo) {
        return keyInfo.d() != null ? new JoinedKey(Integer.valueOf(keyInfo.a()), keyInfo.d()) : Integer.valueOf(keyInfo.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int F(SlotWriter slotWriter) {
        return slotWriter.c0() + slotWriter.m0(slotWriter.c0());
    }

    public static final Object G() {
        return f23794c;
    }

    public static final Object H() {
        return f23797f;
    }

    public static final Object I() {
        return f23798g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(List list, int i3, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int iA = A(list, i3);
        if (iA < 0) {
            int i4 = -(iA + 1);
            if (!(obj instanceof DerivedState)) {
                obj = null;
            }
            list.add(i4, new Invalidation(recomposeScopeImpl, i3, obj));
            return;
        }
        Invalidation invalidation = (Invalidation) list.get(iA);
        if (!(obj instanceof DerivedState)) {
            invalidation.e(null);
            return;
        }
        Object objA = invalidation.a();
        if (objA == null) {
            invalidation.e(obj);
        } else if (objA instanceof MutableScatterSet) {
            ((MutableScatterSet) objA).i(obj);
        } else {
            invalidation.e(ScatterSetKt.b(objA, obj));
        }
    }

    public static final boolean K(SlotReader slotReader) {
        return slotReader.k() > slotReader.u() + 1;
    }

    public static final boolean L(SlotWriter slotWriter) {
        return slotWriter.c0() > slotWriter.e0() + 1;
    }

    public static final boolean M() {
        CompositionTracer compositionTracer = f23792a;
        return compositionTracer != null && compositionTracer.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableScatterMap N(int i3) {
        return MultiValueMap.d(new MutableScatterMap(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int O(SlotReader slotReader, int i3, int i4, int i5) {
        if (i3 != i4) {
            if (i3 == i5 || i4 == i5) {
                return i5;
            }
            if (slotReader.P(i3) == i4) {
                return i4;
            }
            if (slotReader.P(i4) != i3) {
                if (slotReader.P(i3) == slotReader.P(i4)) {
                    return slotReader.P(i3);
                }
                int iW = w(slotReader, i3, i5);
                int iW2 = w(slotReader, i4, i5);
                int i6 = iW - iW2;
                for (int i7 = 0; i7 < i6; i7++) {
                    i3 = slotReader.P(i3);
                }
                int i8 = iW2 - iW;
                for (int i9 = 0; i9 < i8; i9++) {
                    i4 = slotReader.P(i4);
                }
                while (i3 != i4) {
                    i3 = slotReader.P(i3);
                    i4 = slotReader.P(i4);
                }
                return i3;
            }
        }
        return i3;
    }

    public static final void P(SlotWriter slotWriter, RememberManager rememberManager) {
        int iG0;
        int iQ = slotWriter.Q(slotWriter.f24200b, slotWriter.j0(slotWriter.c0() + slotWriter.m0(slotWriter.c0())));
        for (int iQ2 = slotWriter.Q(slotWriter.f24200b, slotWriter.j0(slotWriter.c0())); iQ2 < iQ; iQ2++) {
            Object obj = slotWriter.f24201c[slotWriter.R(iQ2)];
            int iE = -1;
            if (obj instanceof ComposeNodeLifecycleCallback) {
                rememberManager.b((ComposeNodeLifecycleCallback) obj, slotWriter.g0() - iQ2, -1, -1);
            }
            if (obj instanceof RememberObserverHolder) {
                int iG02 = slotWriter.g0() - iQ2;
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                Anchor anchorA = rememberObserverHolder.a();
                if (anchorA == null || !anchorA.b()) {
                    iG0 = -1;
                } else {
                    iE = slotWriter.E(anchorA);
                    iG0 = slotWriter.g0() - slotWriter.e1(iE);
                }
                rememberManager.e(rememberObserverHolder, iG02, iE, iG0);
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).A();
            }
        }
        slotWriter.P0();
    }

    private static final void Q(SlotWriter slotWriter, int i3, Object obj) {
        Object objJ = slotWriter.J(i3);
        if (obj == objJ) {
            return;
        }
        t("Slot table is out of sync (expected " + obj + ", got " + objJ + ')');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation R(List list, int i3) {
        int iA = A(list, i3);
        if (iA >= 0) {
            return (Invalidation) list.remove(iA);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(List list, int i3, int i4) {
        int iZ = z(list, i3);
        while (iZ < list.size() && ((Invalidation) list.get(iZ)).b() < i4) {
            list.remove(iZ);
        }
    }

    public static final void T() {
        CompositionTracer compositionTracer = f23792a;
        if (compositionTracer != null) {
            compositionTracer.c();
        }
    }

    public static final void U(int i3, int i4, int i5, String str) {
        CompositionTracer compositionTracer = f23792a;
        if (compositionTracer != null) {
            compositionTracer.b(i3, i4, i5, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(Invalidation invalidation, Invalidation invalidation2) {
        return Intrinsics.compare(invalidation.b(), invalidation2.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(int i3) {
        return i3 != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List r(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader slotReaderB = slotTable.B();
        try {
            s(slotReaderB, arrayList, slotTable.f(anchor));
            Unit unit = Unit.f139807a;
            return arrayList;
        } finally {
            slotReaderB.d();
        }
    }

    private static final void s(SlotReader slotReader, List list, int i3) {
        if (slotReader.J(i3)) {
            list.add(slotReader.L(i3));
            return;
        }
        int iE = i3 + 1;
        int iE2 = i3 + slotReader.E(i3);
        while (iE < iE2) {
            s(slotReader, list, iE);
            iE += slotReader.E(iE);
        }
    }

    public static final void t(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final Void u(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void v(SlotWriter slotWriter, RememberManager rememberManager) {
        int iG0;
        int iQ = slotWriter.Q(slotWriter.f24200b, slotWriter.j0(slotWriter.c0() + slotWriter.m0(slotWriter.c0())));
        for (int iQ2 = slotWriter.Q(slotWriter.f24200b, slotWriter.j0(slotWriter.c0())); iQ2 < iQ; iQ2++) {
            Object obj = slotWriter.f24201c[slotWriter.R(iQ2)];
            int iE = -1;
            if (obj instanceof ComposeNodeLifecycleCallback) {
                rememberManager.h((ComposeNodeLifecycleCallback) obj, slotWriter.g0() - iQ2, -1, -1);
            } else if (obj instanceof RememberObserverHolder) {
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                if (!(rememberObserverHolder.b() instanceof ReusableRememberObserver)) {
                    Q(slotWriter, iQ2, obj);
                    int iG02 = slotWriter.g0() - iQ2;
                    Anchor anchorA = rememberObserverHolder.a();
                    if (anchorA == null || !anchorA.b()) {
                        iG0 = -1;
                    } else {
                        iE = slotWriter.E(anchorA);
                        iG0 = slotWriter.g0() - slotWriter.e1(iE);
                    }
                    rememberManager.e(rememberObserverHolder, iG02, iE, iG0);
                }
            } else if (obj instanceof RecomposeScopeImpl) {
                Q(slotWriter, iQ2, obj);
                ((RecomposeScopeImpl) obj).A();
            }
        }
    }

    private static final int w(SlotReader slotReader, int i3, int i4) {
        int i5 = 0;
        while (i3 > 0 && i3 != i4) {
            i3 = slotReader.P(i3);
            i5++;
        }
        return i5;
    }

    public static final MovableContentState x(final ControlledComposition controlledComposition, final MovableContentStateReference movableContentStateReference, SlotWriter slotWriter, Applier applier) {
        SlotTable slotTable = new SlotTable();
        if (slotWriter.b0()) {
            slotTable.n();
        }
        if (slotWriter.a0()) {
            slotTable.l();
        }
        int iC0 = slotWriter.c0();
        if (applier != null && slotWriter.G0(iC0) > 0) {
            int iE0 = slotWriter.e0();
            while (iE0 > 0 && !slotWriter.u0(iE0)) {
                iE0 = slotWriter.I0(iE0);
            }
            if (iE0 >= 0 && slotWriter.u0(iE0)) {
                Object objE0 = slotWriter.E0(iE0);
                int i3 = iE0 + 1;
                int iM0 = iE0 + slotWriter.m0(iE0);
                int iG0 = 0;
                while (i3 < iM0) {
                    int iM02 = slotWriter.m0(i3) + i3;
                    if (iM02 > iC0) {
                        break;
                    }
                    iG0 += slotWriter.u0(i3) ? 1 : slotWriter.G0(i3);
                    i3 = iM02;
                }
                int iG02 = slotWriter.u0(iC0) ? 1 : slotWriter.G0(iC0);
                applier.h(objE0);
                applier.a(iG0, iG02);
                applier.k();
            }
        }
        SlotWriter slotWriterC = slotTable.C();
        try {
            slotWriterC.H();
            slotWriterC.k1(126665345, movableContentStateReference.c());
            SlotWriter.w0(slotWriterC, 0, 1, null);
            slotWriterC.p1(movableContentStateReference.g());
            List listD0 = slotWriter.D0(movableContentStateReference.a(), 1, slotWriterC);
            slotWriterC.Y0();
            slotWriterC.T();
            slotWriterC.U();
            slotWriterC.L(true);
            MovableContentState movableContentState = new MovableContentState(slotTable);
            RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.f24021i;
            if (!companion.b(slotTable, listD0)) {
                return movableContentState;
            }
            RecomposeScopeOwner recomposeScopeOwner = new RecomposeScopeOwner() { // from class: androidx.compose.runtime.ComposerKt$extractMovableContentAtCurrent$movableContentRecomposeScopeOwner$1
                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public InvalidationResult j(RecomposeScopeImpl recomposeScopeImpl, Object obj) {
                    InvalidationResult invalidationResultJ;
                    ControlledComposition controlledComposition2 = controlledComposition;
                    RecomposeScopeOwner recomposeScopeOwner2 = controlledComposition2 instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition2 : null;
                    if (recomposeScopeOwner2 == null || (invalidationResultJ = recomposeScopeOwner2.j(recomposeScopeImpl, obj)) == null) {
                        invalidationResultJ = InvalidationResult.f23911a;
                    }
                    if (invalidationResultJ != InvalidationResult.f23911a) {
                        return invalidationResultJ;
                    }
                    MovableContentStateReference movableContentStateReference2 = movableContentStateReference;
                    movableContentStateReference2.i(CollectionsKt.plus((Collection<? extends Pair>) movableContentStateReference2.d(), TuplesKt.a(recomposeScopeImpl, obj)));
                    return InvalidationResult.f23912b;
                }

                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public void a(Object obj) {
                }

                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public void b(RecomposeScopeImpl recomposeScopeImpl) {
                }
            };
            slotWriterC = slotTable.C();
            try {
                companion.a(slotWriterC, listD0, recomposeScopeOwner);
                Unit unit = Unit.f139807a;
                slotWriterC.L(true);
                return movableContentState;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List y(List list, int i3, int i4) {
        ArrayList arrayList = new ArrayList();
        for (int iZ = z(list, i3); iZ < list.size(); iZ++) {
            Invalidation invalidation = (Invalidation) list.get(iZ);
            if (invalidation.b() >= i4) {
                break;
            }
            arrayList.add(invalidation);
        }
        return arrayList;
    }

    private static final int z(List list, int i3) {
        int iA = A(list, i3);
        return iA < 0 ? -(iA + 1) : iA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(boolean z2) {
        return z2 ? 1 : 0;
    }
}
