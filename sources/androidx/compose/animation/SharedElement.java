package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
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
public final class SharedElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f3615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedTransitionScopeImpl f3616b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SharedElementInternalState f3620f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f3617c = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f3618d = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f3619e = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SnapshotStateList f3621g = SnapshotStateKt.f();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function1 f3622h = new Function1<SharedElement, Unit>() { // from class: androidx.compose.animation.SharedElement$updateMatch$1
        {
            super(1);
        }

        public final void c(SharedElement sharedElement) {
            this.f3625a.s();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((SharedElement) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function0 f3623i = new Function0<Unit>() { // from class: androidx.compose.animation.SharedElement$observingVisibilityChange$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m18invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m18invoke() {
            this.f3624a.k();
        }
    };

    public SharedElement(Object obj, SharedTransitionScopeImpl sharedTransitionScopeImpl) {
        this.f3615a = obj;
        this.f3616b = sharedTransitionScopeImpl;
    }

    private final Rect j() {
        return (Rect) this.f3617c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean k() {
        SnapshotStateList snapshotStateList = this.f3621g;
        int size = snapshotStateList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((SharedElementInternalState) snapshotStateList.get(i3)).g().f()) {
                return true;
            }
        }
        return false;
    }

    private final void q(boolean z2) {
        this.f3618d.setValue(Boolean.valueOf(z2));
    }

    private final void r(Rect rect) {
        this.f3617c.setValue(rect);
    }

    public final void b(SharedElementInternalState sharedElementInternalState) {
        this.f3621g.add(sharedElementInternalState);
        this.f3616b.k(this, this.f3622h, this.f3623i);
    }

    public final Rect c() {
        return (Rect) this.f3619e.getValue();
    }

    public final boolean d() {
        return ((Boolean) this.f3618d.getValue()).booleanValue();
    }

    public final Object e() {
        return this.f3615a;
    }

    public final SharedTransitionScopeImpl f() {
        return this.f3616b;
    }

    public final SnapshotStateList g() {
        return this.f3621g;
    }

    public final Rect h() {
        SharedElementInternalState sharedElementInternalState = this.f3620f;
        r(sharedElementInternalState != null ? RectKt.c(sharedElementInternalState.f(), sharedElementInternalState.j()) : null);
        return j();
    }

    public final SharedElementInternalState i() {
        return this.f3620f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l() {
        SnapshotStateList snapshotStateList = this.f3621g;
        int size = snapshotStateList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (!((SharedElementInternalState) snapshotStateList.get(i3)).g().i()) {
                i3++;
            } else if (d()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(SharedElementInternalState sharedElementInternalState, long j3, long j4) {
        if (sharedElementInternalState.g().f()) {
            this.f3620f = sharedElementInternalState;
            Rect rectJ = j();
            Offset offsetD = rectJ != null ? Offset.d(rectJ.t()) : null;
            if (offsetD == null ? false : Offset.j(offsetD.u(), j4)) {
                Rect rectJ2 = j();
                Size sizeC = rectJ2 != null ? Size.c(rectJ2.q()) : null;
                if (sizeC == null ? false : Size.f(sizeC.m(), j3)) {
                    return;
                }
            }
            Rect rectC = RectKt.c(j4, j3);
            r(rectC);
            SnapshotStateList snapshotStateList = this.f3621g;
            int size = snapshotStateList.size();
            for (int i3 = 0; i3 < size; i3++) {
                BoundsAnimation boundsAnimationG = ((SharedElementInternalState) snapshotStateList.get(i3)).g();
                Rect rectC2 = c();
                Intrinsics.checkNotNull(rectC2);
                boundsAnimationG.a(rectC2, rectC);
            }
        }
    }

    public final void n() {
        q(this.f3621g.size() > 1 && k());
        r(null);
    }

    public final void o(SharedElementInternalState sharedElementInternalState) {
        this.f3621g.remove(sharedElementInternalState);
        if (!this.f3621g.isEmpty()) {
            this.f3616b.k(this, this.f3622h, this.f3623i);
        } else {
            s();
            this.f3616b.f(this);
        }
    }

    public final void p(Rect rect) {
        this.f3619e.setValue(rect);
    }

    public final void s() {
        boolean zK = k();
        if (this.f3621g.size() > 1 && zK) {
            q(true);
        } else if (!this.f3616b.p() || !zK) {
            q(false);
        }
        if (this.f3621g.isEmpty()) {
            return;
        }
        this.f3616b.k(this, this.f3622h, this.f3623i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        SnapshotStateList snapshotStateList = this.f3621g;
        int size = snapshotStateList.size() - 1;
        SharedElementInternalState sharedElementInternalState = null;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                SharedElementInternalState sharedElementInternalState2 = (SharedElementInternalState) snapshotStateList.get(size);
                if (sharedElementInternalState2.g().f()) {
                    sharedElementInternalState = sharedElementInternalState2;
                }
                if (i3 < 0) {
                    break;
                } else {
                    size = i3;
                }
            }
        }
        if (Intrinsics.areEqual(sharedElementInternalState, this.f3620f)) {
            return;
        }
        this.f3620f = sharedElementInternalState;
        r(null);
    }
}
