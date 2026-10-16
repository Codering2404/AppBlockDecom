package androidx.compose.material.pullrefresh;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

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
public final class PullRefreshState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f15290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final State f15291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final State f15292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f15293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableFloatState f15294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableFloatState f15295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableFloatState f15296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableFloatState f15297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutatorMutex f15298i;

    private final Job e(float f3) {
        return BuildersKt__Builders_commonKt.d(this.f15290a, null, null, new PullRefreshState$animateIndicatorTo$1(this, f3, null), 3, null);
    }

    private final float f() {
        if (g() <= l()) {
            return g();
        }
        float fAbs = Math.abs(j()) - 1.0f;
        if (fAbs < 0.0f) {
            fAbs = 0.0f;
        }
        if (fAbs > 2.0f) {
            fAbs = 2.0f;
        }
        return l() + (l() * (fAbs - (((float) Math.pow(fAbs, 2)) / 4)));
    }

    private final float g() {
        return ((Number) this.f15292c.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float h() {
        return this.f15295f.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float m() {
        return this.f15294e.c();
    }

    private final boolean n() {
        return ((Boolean) this.f15293d.getValue()).booleanValue();
    }

    private final float o() {
        return this.f15297h.c();
    }

    private final float p() {
        return this.f15296g.c();
    }

    private final void s(float f3) {
        this.f15295f.s(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(float f3) {
        this.f15294e.s(f3);
    }

    private final void x(boolean z2) {
        this.f15293d.setValue(Boolean.valueOf(z2));
    }

    private final void y(float f3) {
        this.f15297h.s(f3);
    }

    private final void z(float f3) {
        this.f15296g.s(f3);
    }

    public final float i() {
        return m();
    }

    public final float j() {
        return g() / l();
    }

    public final boolean k() {
        return n();
    }

    public final float l() {
        return p();
    }

    public final float q(float f3) {
        if (n()) {
            return 0.0f;
        }
        float fE = RangesKt.e(h() + f3, 0.0f);
        float fH = fE - h();
        s(fE);
        w(f());
        return fH;
    }

    public final float r(float f3) {
        if (k()) {
            return 0.0f;
        }
        if (g() > l()) {
            ((Function0) this.f15291b.getValue()).invoke();
        }
        e(0.0f);
        if (h() == 0.0f || f3 < 0.0f) {
            f3 = 0.0f;
        }
        s(0.0f);
        return f3;
    }

    public final void t(boolean z2) {
        if (n() != z2) {
            x(z2);
            s(0.0f);
            e(z2 ? o() : 0.0f);
        }
    }

    public final void u(float f3) {
        if (o() == f3) {
            return;
        }
        y(f3);
        if (k()) {
            e(f3);
        }
    }

    public final void v(float f3) {
        z(f3);
    }
}
