package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

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
public final class RangeSliderState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f19356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClosedFloatingPointRange f19357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableFloatState f19358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableFloatState f19359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function1 f19360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f19361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableFloatState f19362h = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableFloatState f19363i = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableFloatState f19364j = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableIntState f19365k = SnapshotIntStateKt.a(0);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MutableFloatState f19366l = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableFloatState f19367m = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableState f19368n = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Function1 f19369o = new Function1<Boolean, Unit>() { // from class: androidx.compose.material3.RangeSliderState$gestureEndAction$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return Unit.f139807a;
        }

        public final void invoke(boolean z2) {
            Function0 function0M = this.f19372a.m();
            if (function0M != null) {
                function0M.invoke();
            }
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final MutableFloatState f19370p = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final MutableFloatState f19371q = PrimitiveSnapshotStateKt.a(0.0f);

    public RangeSliderState(float f3, float f4, int i3, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange) {
        this.f19355a = i3;
        this.f19356b = function0;
        this.f19357c = closedFloatingPointRange;
        this.f19358d = PrimitiveSnapshotStateKt.a(f3);
        this.f19359e = PrimitiveSnapshotStateKt.a(f4);
        this.f19361g = SliderKt.G(i3);
    }

    private final void B(float f3) {
        this.f19359e.s(f3);
    }

    private final void D(float f3) {
        this.f19358d.s(f3);
    }

    private final void F(float f3) {
        this.f19370p.s(f3);
    }

    private final void G(float f3) {
        this.f19371q.s(f3);
    }

    private final float b() {
        return this.f19359e.c();
    }

    private final float d() {
        return this.f19358d.c();
    }

    private final float j() {
        return this.f19370p.c();
    }

    private final float k() {
        return this.f19371q.c();
    }

    private final float y(float f3, float f4, float f5) {
        return SliderKt.B(((Number) this.f19357c.a()).floatValue(), ((Number) this.f19357c.e()).floatValue(), f5, f3, f4);
    }

    private final long z(float f3, float f4, long j3) {
        return SliderKt.C(f3, f4, j3, ((Number) this.f19357c.a()).floatValue(), ((Number) this.f19357c.e()).floatValue());
    }

    public final void A(float f3) {
        B(SliderKt.F(RangesKt.o(f3, c(), ((Number) this.f19357c.e()).floatValue()), this.f19361g, ((Number) this.f19357c.a()).floatValue(), ((Number) this.f19357c.e()).floatValue()));
    }

    public final void C(float f3) {
        D(SliderKt.F(RangesKt.o(f3, ((Number) this.f19357c.a()).floatValue(), a()), this.f19361g, ((Number) this.f19357c.a()).floatValue(), ((Number) this.f19357c.e()).floatValue()));
    }

    public final void E(float f3) {
        this.f19364j.s(f3);
    }

    public final void H(Function1 function1) {
        this.f19360f = function1;
    }

    public final void I(Function0 function0) {
        this.f19356b = function0;
    }

    public final void J(float f3) {
        this.f19367m.s(f3);
    }

    public final void K(float f3) {
        this.f19366l.s(f3);
    }

    public final void L(boolean z2) {
        this.f19368n.setValue(Boolean.valueOf(z2));
    }

    public final void M(float f3) {
        this.f19363i.s(f3);
    }

    public final void N(int i3) {
        this.f19365k.a(i3);
    }

    public final void O(float f3) {
        this.f19362h.s(f3);
    }

    public final void P() {
        float f3 = 2;
        float fMax = Math.max(t() - (h() / f3), 0.0f);
        float fMin = Math.min(q() / f3, fMax);
        if (k() == fMin && j() == fMax) {
            return;
        }
        G(fMin);
        F(fMax);
        K(y(k(), j(), c()));
        J(y(k(), j(), a()));
    }

    public final float a() {
        return b();
    }

    public final float c() {
        return d();
    }

    public final float e() {
        return SliderKt.v(((Number) this.f19357c.a()).floatValue(), ((Number) this.f19357c.e()).floatValue(), a());
    }

    public final float f() {
        return SliderKt.v(((Number) this.f19357c.a()).floatValue(), ((Number) this.f19357c.e()).floatValue(), c());
    }

    public final int g() {
        return (int) Math.floor(this.f19355a * (1.0f - f()));
    }

    public final float h() {
        return this.f19364j.c();
    }

    public final Function1 i() {
        return this.f19369o;
    }

    public final Function1 l() {
        return this.f19360f;
    }

    public final Function0 m() {
        return this.f19356b;
    }

    public final float n() {
        return this.f19367m.c();
    }

    public final float o() {
        return this.f19366l.c();
    }

    public final int p() {
        return (int) Math.floor(this.f19355a * e());
    }

    public final float q() {
        return this.f19363i.c();
    }

    public final int r() {
        return this.f19355a;
    }

    public final float[] s() {
        return this.f19361g;
    }

    public final int t() {
        return this.f19365k.g();
    }

    public final float u() {
        return this.f19362h.c();
    }

    public final ClosedFloatingPointRange v() {
        return this.f19357c;
    }

    public final boolean w() {
        return ((Boolean) this.f19368n.getValue()).booleanValue();
    }

    public final void x(boolean z2, float f3) {
        long jI;
        if (z2) {
            K(o() + f3);
            J(y(k(), j(), a()));
            float fN = n();
            jI = SliderKt.i(SliderKt.F(RangesKt.o(o(), k(), fN), this.f19361g, k(), j()), fN);
        } else {
            J(n() + f3);
            K(y(k(), j(), c()));
            float fO = o();
            jI = SliderKt.i(fO, SliderKt.F(RangesKt.o(n(), fO, j()), this.f19361g, k(), j()));
        }
        long jZ = z(k(), j(), jI);
        if (SliderRange.e(jZ, SliderKt.i(c(), a()))) {
            return;
        }
        Function1 function1 = this.f19360f;
        if (function1 == null) {
            C(SliderRange.g(jZ));
            A(SliderRange.f(jZ));
        } else if (function1 != null) {
            function1.invoke(SliderRange.b(jZ));
        }
    }
}
