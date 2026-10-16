package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class SliderState implements DraggableState {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f20184q = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f20185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f20186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClosedFloatingPointRange f20187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableFloatState f20188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Function1 f20189e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float[] f20190f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableIntState f20191g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20192h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableFloatState f20193i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableFloatState f20194j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableState f20195k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Function0 f20196l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableFloatState f20197m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableFloatState f20198n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final DragScope f20199o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutatorMutex f20200p;

    public SliderState(float f3, int i3, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
        this.f20185a = i3;
        this.f20186b = function0;
        this.f20187c = closedFloatingPointRange;
        this.f20188d = PrimitiveSnapshotStateKt.a(f3);
        this.f20190f = SliderKt.G(i3);
        this.f20191g = SnapshotIntStateKt.a(0);
        this.f20193i = PrimitiveSnapshotStateKt.a(0.0f);
        this.f20194j = PrimitiveSnapshotStateKt.a(0.0f);
        this.f20195k = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        this.f20196l = new Function0<Unit>() { // from class: androidx.compose.material3.SliderState$gestureEndAction$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m183invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m183invoke() {
                Function0 function0J;
                if (this.f20206a.u() || (function0J = this.f20206a.j()) == null) {
                    return;
                }
                function0J.invoke();
            }
        };
        this.f20197m = PrimitiveSnapshotStateKt.a(x(0.0f, 0.0f, f3));
        this.f20198n = PrimitiveSnapshotStateKt.a(0.0f);
        this.f20199o = new DragScope() { // from class: androidx.compose.material3.SliderState$dragScope$1
            @Override // androidx.compose.foundation.gestures.DragScope
            public void a(float f4) {
                this.f20205a.b(f4);
            }
        };
        this.f20200p = new MutatorMutex();
    }

    private final void C(float f3) {
        this.f20198n.s(f3);
    }

    private final void D(float f3) {
        this.f20197m.s(f3);
    }

    private final void G(int i3) {
        this.f20191g.a(i3);
    }

    private final void J(float f3) {
        this.f20188d.s(f3);
    }

    private final float k() {
        return this.f20198n.c();
    }

    private final float l() {
        return this.f20197m.c();
    }

    private final int p() {
        return this.f20191g.g();
    }

    private final float t() {
        return this.f20188d.c();
    }

    private final float x(float f3, float f4, float f5) {
        return SliderKt.B(((Number) this.f20187c.a()).floatValue(), ((Number) this.f20187c.e()).floatValue(), f5, f3, f4);
    }

    private final float y(float f3, float f4, float f5) {
        return SliderKt.B(f3, f4, f5, ((Number) this.f20187c.a()).floatValue(), ((Number) this.f20187c.e()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(boolean z2) {
        this.f20195k.setValue(Boolean.valueOf(z2));
    }

    public final void A(Function1 function1) {
        this.f20189e = function1;
    }

    public final void B(Function0 function0) {
        this.f20186b = function0;
    }

    public final void E(boolean z2) {
        this.f20192h = z2;
    }

    public final void F(float f3) {
        this.f20194j.s(f3);
    }

    public final void H(float f3) {
        this.f20193i.s(f3);
    }

    public final void I(float f3) {
        J(SliderKt.F(RangesKt.o(f3, ((Number) this.f20187c.a()).floatValue(), ((Number) this.f20187c.e()).floatValue()), this.f20190f, ((Number) this.f20187c.a()).floatValue(), ((Number) this.f20187c.e()).floatValue()));
    }

    public final void K(float f3, int i3) {
        H(f3);
        G(i3);
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public Object a(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new SliderState$drag$2(this, mutatePriority, function2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void b(float f3) {
        float f4 = 2;
        float fMax = Math.max(p() - (n() / f4), 0.0f);
        float fMin = Math.min(n() / f4, fMax);
        D(l() + f3 + k());
        C(0.0f);
        float fY = y(fMin, fMax, SliderKt.F(l(), this.f20190f, fMin, fMax));
        if (fY == r()) {
            return;
        }
        Function1 function1 = this.f20189e;
        if (function1 == null) {
            I(fY);
        } else if (function1 != null) {
            function1.invoke(Float.valueOf(fY));
        }
    }

    public final float g() {
        return SliderKt.v(((Number) this.f20187c.a()).floatValue(), ((Number) this.f20187c.e()).floatValue(), RangesKt.o(r(), ((Number) this.f20187c.a()).floatValue(), ((Number) this.f20187c.e()).floatValue()));
    }

    public final Function0 h() {
        return this.f20196l;
    }

    public final Function1 i() {
        return this.f20189e;
    }

    public final Function0 j() {
        return this.f20186b;
    }

    public final int m() {
        return this.f20185a;
    }

    public final float n() {
        return this.f20194j.c();
    }

    public final float[] o() {
        return this.f20190f;
    }

    public final float q() {
        return this.f20193i.c();
    }

    public final float r() {
        return t();
    }

    public final ClosedFloatingPointRange s() {
        return this.f20187c;
    }

    public final boolean u() {
        return ((Boolean) this.f20195k.getValue()).booleanValue();
    }

    public final boolean v() {
        return this.f20192h;
    }

    public final void w(long j3) {
        C((this.f20192h ? p() - Offset.m(j3) : Offset.m(j3)) - l());
    }

    public /* synthetic */ SliderState(float f3, int i3, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0.0f : f3, (i4 & 2) != 0 ? 0 : i3, (i4 & 4) != 0 ? null : function0, (i4 & 8) != 0 ? RangesKt.b(0.0f, 1.0f) : closedFloatingPointRange);
    }
}
