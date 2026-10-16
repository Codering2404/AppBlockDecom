package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotReader;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.IntRef;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class ComposerChangeListWriter {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f24315m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f24316n = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ComposerImpl f24317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ChangeList f24318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f24319c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f24323g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f24328l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IntStack f24320d = new IntStack();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f24321e = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList f24324h = Stack.c(null, 1, null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24325i = -1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24326j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24327k = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ComposerChangeListWriter(ComposerImpl composerImpl, ChangeList changeList) {
        this.f24317a = composerImpl;
        this.f24318b = changeList;
    }

    private final void C() {
        D();
    }

    private final void D() {
        int i3 = this.f24323g;
        if (i3 > 0) {
            this.f24318b.M(i3);
            this.f24323g = 0;
        }
        if (Stack.h(this.f24324h)) {
            this.f24318b.m(Stack.m(this.f24324h));
            Stack.a(this.f24324h);
        }
    }

    private final void E() {
        K(this, false, 1, null);
        M();
    }

    private final void F(boolean z2) {
        J(z2);
    }

    static /* synthetic */ void G(ComposerChangeListWriter composerChangeListWriter, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        composerChangeListWriter.F(z2);
    }

    private final void H(int i3, int i4, int i5) {
        C();
        this.f24318b.x(i3, i4, i5);
    }

    private final void I() {
        int i3 = this.f24328l;
        if (i3 > 0) {
            int i4 = this.f24325i;
            if (i4 >= 0) {
                L(i4, i3);
                this.f24325i = -1;
            } else {
                H(this.f24327k, this.f24326j, i3);
                this.f24326j = -1;
                this.f24327k = -1;
            }
            this.f24328l = 0;
        }
    }

    private final void J(boolean z2) {
        int iU = z2 ? s().u() : s().k();
        int i3 = iU - this.f24322f;
        if (!(i3 >= 0)) {
            ComposerKt.t("Tried to seek backward");
        }
        if (i3 > 0) {
            this.f24318b.g(i3);
            this.f24322f = iU;
        }
    }

    static /* synthetic */ void K(ComposerChangeListWriter composerChangeListWriter, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        composerChangeListWriter.J(z2);
    }

    private final void L(int i3, int i4) {
        C();
        this.f24318b.C(i3, i4);
    }

    private final void m(Anchor anchor) {
        G(this, false, 1, null);
        this.f24318b.r(anchor);
        this.f24319c = true;
    }

    private final void n() {
        if (this.f24319c || !this.f24321e) {
            return;
        }
        G(this, false, 1, null);
        this.f24318b.s();
        this.f24319c = true;
    }

    private final SlotReader s() {
        return this.f24317a.O0();
    }

    public final void A(int i3) {
        this.f24322f = i3;
    }

    public final void B() {
        I();
        if (Stack.h(this.f24324h)) {
            Stack.k(this.f24324h);
        } else {
            this.f24323g++;
        }
    }

    public final void M() {
        SlotReader slotReaderS;
        int iU;
        if (s().x() <= 0 || this.f24320d.f(-2) == (iU = (slotReaderS = s()).u())) {
            return;
        }
        n();
        if (iU > 0) {
            Anchor anchorA = slotReaderS.a(iU);
            this.f24320d.h(iU);
            m(anchorA);
        }
    }

    public final void N() {
        D();
        if (this.f24319c) {
            Y();
            l();
        }
    }

    public final void O(ControlledComposition controlledComposition, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference) {
        this.f24318b.y(controlledComposition, compositionContext, movableContentStateReference);
    }

    public final void P(RememberObserverHolder rememberObserverHolder) {
        this.f24318b.z(rememberObserverHolder);
    }

    public final void Q(RecomposeScopeImpl recomposeScopeImpl) {
        this.f24318b.A(recomposeScopeImpl);
    }

    public final void R() {
        E();
        this.f24318b.B();
        this.f24322f += s().p();
    }

    public final void S(int i3, int i4) {
        if (i4 > 0) {
            if (!(i3 >= 0)) {
                ComposerKt.t("Invalid remove index " + i3);
            }
            if (this.f24325i == i3) {
                this.f24328l += i4;
                return;
            }
            I();
            this.f24325i = i3;
            this.f24328l = i4;
        }
    }

    public final void T() {
        this.f24318b.D();
    }

    public final void U() {
        this.f24319c = false;
        this.f24320d.a();
        this.f24322f = 0;
    }

    public final void V(ChangeList changeList) {
        this.f24318b = changeList;
    }

    public final void W(boolean z2) {
        this.f24321e = z2;
    }

    public final void X(Function0 function0) {
        this.f24318b.E(function0);
    }

    public final void Y() {
        this.f24318b.F();
    }

    public final void Z(RecomposeScopeImpl recomposeScopeImpl) {
        this.f24318b.G(recomposeScopeImpl);
    }

    public final void a(Anchor anchor, Object obj) {
        this.f24318b.h(anchor, obj);
    }

    public final void a0(int i3) {
        if (i3 > 0) {
            E();
            this.f24318b.H(i3);
        }
    }

    public final void b(List list, IntRef intRef) {
        this.f24318b.i(list, intRef);
    }

    public final void b0(Object obj, Anchor anchor, int i3) {
        this.f24318b.I(obj, anchor, i3);
    }

    public final void c(MovableContentState movableContentState, CompositionContext compositionContext, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        this.f24318b.j(movableContentState, compositionContext, movableContentStateReference, movableContentStateReference2);
    }

    public final void c0(Object obj) {
        G(this, false, 1, null);
        this.f24318b.J(obj);
    }

    public final void d() {
        G(this, false, 1, null);
        this.f24318b.k();
    }

    public final void d0(Object obj, Function2 function2) {
        C();
        this.f24318b.K(obj, function2);
    }

    public final void e(IntRef intRef, Anchor anchor) {
        D();
        this.f24318b.l(intRef, anchor);
    }

    public final void e0(Object obj, int i3) {
        F(true);
        this.f24318b.L(obj, i3);
    }

    public final void f(Function1 function1, Composition composition) {
        this.f24318b.n(function1, composition);
    }

    public final void f0(Object obj) {
        C();
        this.f24318b.N(obj);
    }

    public final void g() {
        int iU = s().u();
        if (!(this.f24320d.f(-1) <= iU)) {
            ComposerKt.t("Missed recording an endGroup");
        }
        if (this.f24320d.f(-1) == iU) {
            G(this, false, 1, null);
            this.f24320d.g();
            this.f24318b.o();
        }
    }

    public final void h() {
        this.f24318b.p();
        this.f24322f = 0;
    }

    public final void i() {
        I();
    }

    public final void j(int i3, int i4) {
        i();
        D();
        int iN = s().J(i4) ? 1 : s().N(i4);
        if (iN > 0) {
            S(i3, iN);
        }
    }

    public final void k(RecomposeScopeImpl recomposeScopeImpl) {
        this.f24318b.q(recomposeScopeImpl);
    }

    public final void l() {
        if (this.f24319c) {
            G(this, false, 1, null);
            G(this, false, 1, null);
            this.f24318b.o();
            this.f24319c = false;
        }
    }

    public final void o() {
        D();
        if (this.f24320d.f23907b == 0) {
            return;
        }
        ComposerKt.t("Missed recording an endGroup()");
    }

    public final ChangeList p() {
        return this.f24318b;
    }

    public final boolean q() {
        return this.f24321e;
    }

    public final boolean r() {
        return s().u() - this.f24322f < 0;
    }

    public final void t(ChangeList changeList, IntRef intRef) {
        this.f24318b.t(changeList, intRef);
    }

    public final void u(Anchor anchor, SlotTable slotTable) {
        D();
        E();
        I();
        this.f24318b.u(anchor, slotTable);
    }

    public final void v(Anchor anchor, SlotTable slotTable, FixupList fixupList) {
        D();
        E();
        I();
        this.f24318b.v(anchor, slotTable, fixupList);
    }

    public final void w(int i3) {
        E();
        this.f24318b.w(i3);
    }

    public final void x(Object obj) {
        I();
        Stack.l(this.f24324h, obj);
    }

    public final void y(int i3, int i4, int i5) {
        if (i5 > 0) {
            int i6 = this.f24328l;
            if (i6 > 0 && this.f24326j == i3 - i6 && this.f24327k == i4 - i6) {
                this.f24328l = i6 + i5;
                return;
            }
            I();
            this.f24326j = i3;
            this.f24327k = i4;
            this.f24328l = i5;
        }
    }

    public final void z(int i3) {
        this.f24322f += i3 - s().k();
    }
}
