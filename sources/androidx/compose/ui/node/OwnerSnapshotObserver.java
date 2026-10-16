package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class OwnerSnapshotObserver {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f27614i = SnapshotStateObserver.f24978l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SnapshotStateObserver f27615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f27616b = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookaheadMeasure$1
        public final void c(LayoutNode layoutNode) {
            if (layoutNode.a1()) {
                LayoutNode.C1(layoutNode, false, false, false, 7, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LayoutNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f27617c = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingMeasure$1
        public final void c(LayoutNode layoutNode) {
            if (layoutNode.a1()) {
                LayoutNode.G1(layoutNode, false, false, false, 7, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LayoutNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1 f27618d = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingSemantics$1
        public final void c(LayoutNode layoutNode) {
            if (layoutNode.a1()) {
                layoutNode.S0();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LayoutNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Function1 f27619e = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1
        public final void c(LayoutNode layoutNode) {
            if (layoutNode.a1()) {
                LayoutNode.E1(layoutNode, false, 1, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LayoutNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Function1 f27620f = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifier$1
        public final void c(LayoutNode layoutNode) {
            if (layoutNode.a1()) {
                LayoutNode.E1(layoutNode, false, 1, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LayoutNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f27621g = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayoutModifierInLookahead$1
        public final void c(LayoutNode layoutNode) {
            if (layoutNode.a1()) {
                LayoutNode.A1(layoutNode, false, 1, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LayoutNode) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1 f27622h = new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLookahead$1
        public final void c(LayoutNode layoutNode) {
            if (layoutNode.a1()) {
                LayoutNode.A1(layoutNode, false, 1, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((LayoutNode) obj);
            return Unit.f139807a;
        }
    };

    public OwnerSnapshotObserver(Function1 function1) {
        this.f27615a = new SnapshotStateObserver(function1);
    }

    public static /* synthetic */ void d(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        ownerSnapshotObserver.c(layoutNode, z2, function0);
    }

    public static /* synthetic */ void f(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        ownerSnapshotObserver.e(layoutNode, z2, function0);
    }

    public static /* synthetic */ void h(OwnerSnapshotObserver ownerSnapshotObserver, LayoutNode layoutNode, boolean z2, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        ownerSnapshotObserver.g(layoutNode, z2, function0);
    }

    public final void a(Object obj) {
        this.f27615a.l(obj);
    }

    public final void b() {
        this.f27615a.m(new Function1<Object, Boolean>() { // from class: androidx.compose.ui.node.OwnerSnapshotObserver$clearInvalidObservations$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.node.OwnerScope");
                return Boolean.valueOf(!((OwnerScope) obj).a1());
            }
        });
    }

    public final void c(LayoutNode layoutNode, boolean z2, Function0 function0) {
        if (!z2 || layoutNode.l0() == null) {
            i(layoutNode, this.f27620f, function0);
        } else {
            i(layoutNode, this.f27621g, function0);
        }
    }

    public final void e(LayoutNode layoutNode, boolean z2, Function0 function0) {
        if (!z2 || layoutNode.l0() == null) {
            i(layoutNode, this.f27619e, function0);
        } else {
            i(layoutNode, this.f27622h, function0);
        }
    }

    public final void g(LayoutNode layoutNode, boolean z2, Function0 function0) {
        if (!z2 || layoutNode.l0() == null) {
            i(layoutNode, this.f27617c, function0);
        } else {
            i(layoutNode, this.f27616b, function0);
        }
    }

    public final void i(OwnerScope ownerScope, Function1 function1, Function0 function0) {
        this.f27615a.p(ownerScope, function1, function0);
    }

    public final void j(LayoutNode layoutNode, Function0 function0) {
        i(layoutNode, this.f27618d, function0);
    }

    public final void k() {
        this.f27615a.t();
    }

    public final void l() {
        this.f27615a.u();
        this.f27615a.k();
    }
}
