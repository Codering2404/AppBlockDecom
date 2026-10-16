package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class AnimationScope<T, V extends AnimationVector> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TwoWayConverter f3838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f3839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f3840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f3841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f3842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AnimationVector f3843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f3844g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f3845h = Long.MIN_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f3846i;

    public AnimationScope(Object obj, TwoWayConverter twoWayConverter, AnimationVector animationVector, long j3, Object obj2, long j4, boolean z2, Function0 function0) {
        this.f3838a = twoWayConverter;
        this.f3839b = obj2;
        this.f3840c = j4;
        this.f3841d = function0;
        this.f3842e = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f3843f = AnimationVectorsKt.e(animationVector);
        this.f3844g = j3;
        this.f3846i = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(z2), null, 2, null);
    }

    public final void a() {
        k(false);
        this.f3841d.invoke();
    }

    public final long b() {
        return this.f3845h;
    }

    public final long c() {
        return this.f3844g;
    }

    public final long d() {
        return this.f3840c;
    }

    public final Object e() {
        return this.f3842e.getValue();
    }

    public final Object f() {
        return this.f3838a.b().invoke(this.f3843f);
    }

    public final AnimationVector g() {
        return this.f3843f;
    }

    public final boolean h() {
        return ((Boolean) this.f3846i.getValue()).booleanValue();
    }

    public final void i(long j3) {
        this.f3845h = j3;
    }

    public final void j(long j3) {
        this.f3844g = j3;
    }

    public final void k(boolean z2) {
        this.f3846i.setValue(Boolean.valueOf(z2));
    }

    public final void l(Object obj) {
        this.f3842e.setValue(obj);
    }

    public final void m(AnimationVector animationVector) {
        this.f3843f = animationVector;
    }
}
