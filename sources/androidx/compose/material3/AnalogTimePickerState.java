package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.TimePickerSelectionMode;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

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
public final class AnalogTimePickerState implements TimePickerState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimePickerState f15545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f15546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f15547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animatable f15548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutatorMutex f15549e = new MutatorMutex();

    public AnalogTimePickerState(TimePickerState timePickerState) {
        this.f15545a = timePickerState;
        this.f15546b = ((timePickerState.h() % 12) * 0.5235988f) - 1.5707964f;
        this.f15547c = (timePickerState.f() * 0.10471976f) - 1.5707964f;
        this.f15548d = AnimatableKt.b(this.f15546b, 0.0f, 2, null);
    }

    public static /* synthetic */ Object C(AnalogTimePickerState analogTimePickerState, float f3, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return analogTimePickerState.B(f3, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int D(float f3) {
        return ((int) ((((double) f3) + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int E(float f3) {
        return ((int) ((((double) f3) + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    private final void F() {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            this.f15545a.e(f());
            Unit unit = Unit.f139807a;
        } finally {
            companion.m(snapshotD, snapshotE, function1G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float t(float f3) {
        float fFloatValue = ((Number) this.f15548d.n()).floatValue() - f3;
        while (fFloatValue > 3.1415927f) {
            fFloatValue -= 6.2831855f;
        }
        while (fFloatValue <= -3.1415927f) {
            fFloatValue += 6.2831855f;
        }
        return ((Number) this.f15548d.n()).floatValue() - fFloatValue;
    }

    private final boolean x() {
        int iC = c();
        TimePickerSelectionMode.Companion companion = TimePickerSelectionMode.f21378b;
        if (TimePickerSelectionMode.f(iC, companion.a()) && y(((Number) this.f15548d.l()).floatValue()) == y(this.f15546b)) {
            return false;
        }
        return (TimePickerSelectionMode.f(c(), companion.b()) && y(((Number) this.f15548d.l()).floatValue()) == y(this.f15547c)) ? false : true;
    }

    private final float y(float f3) {
        double d3 = ((double) f3) % 6.283185307179586d;
        if (d3 < 0.0d) {
            d3 += 6.283185307179586d;
        }
        return (float) d3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float z(float f3) {
        float f4 = f3 + 1.5707964f;
        return f4 < 0.0f ? f4 + 6.2831855f : f4;
    }

    public final Object A(Continuation continuation) {
        Object objD = this.f15549e.d(MutatePriority.f5073c, new AnalogTimePickerState$onGestureEnd$2(this, t(TimePickerSelectionMode.f(c(), TimePickerSelectionMode.f21378b.a()) ? this.f15546b : this.f15547c), null), continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    public final Object B(float f3, boolean z2, Continuation continuation) {
        Object objD = this.f15549e.d(MutatePriority.f5072b, new AnalogTimePickerState$rotateTo$2(this, f3, z2, null), continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void a(boolean z2) {
        this.f15545a.a(z2);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void b(int i3) {
        this.f15545a.b(i3);
    }

    @Override // androidx.compose.material3.TimePickerState
    public int c() {
        return this.f15545a.c();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void d(int i3) {
        this.f15546b = ((i3 % 12) * 0.5235988f) - 1.5707964f;
        this.f15545a.d(i3);
        if (TimePickerSelectionMode.f(c(), TimePickerSelectionMode.f21378b.a())) {
            this.f15548d = AnimatableKt.b(this.f15546b, 0.0f, 2, null);
        }
    }

    @Override // androidx.compose.material3.TimePickerState
    public void e(int i3) {
        this.f15547c = (i3 * 0.10471976f) - 1.5707964f;
        this.f15545a.e(i3);
        if (TimePickerSelectionMode.f(c(), TimePickerSelectionMode.f21378b.b())) {
            this.f15548d = AnimatableKt.b(this.f15547c, 0.0f, 2, null);
        }
        F();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int f() {
        return this.f15545a.f();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean g() {
        return this.f15545a.g();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int h() {
        return this.f15545a.h();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean i() {
        return this.f15545a.i();
    }

    public final Object s(Continuation continuation) {
        if (!x()) {
            return Unit.f139807a;
        }
        Object objD = this.f15549e.d(MutatePriority.f5073c, new AnalogTimePickerState$animateToCurrent$2(this, TimePickerSelectionMode.f(c(), TimePickerSelectionMode.f21378b.a()) ? t(this.f15546b) : t(this.f15547c), null), continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    public final IntList u() {
        return TimePickerSelectionMode.f(c(), TimePickerSelectionMode.f21378b.b()) ? TimePickerKt.f21176j : TimePickerKt.f21177k;
    }

    public final float v() {
        return ((Number) this.f15548d.n()).floatValue();
    }

    public final TimePickerState w() {
        return this.f15545a;
    }
}
