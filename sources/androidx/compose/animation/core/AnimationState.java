package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class AnimationState<T, V extends AnimationVector> implements State<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TwoWayConverter f3847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f3848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimationVector f3849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3850d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3852g;

    public AnimationState(TwoWayConverter twoWayConverter, Object obj, AnimationVector animationVector, long j3, long j4, boolean z2) {
        AnimationVector animationVectorE;
        this.f3847a = twoWayConverter;
        this.f3848b = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f3849c = (animationVector == null || (animationVectorE = AnimationVectorsKt.e(animationVector)) == null) ? AnimationStateKt.i(twoWayConverter, obj) : animationVectorE;
        this.f3850d = j3;
        this.f3851f = j4;
        this.f3852g = z2;
    }

    public final long b() {
        return this.f3851f;
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return this.f3848b.getValue();
    }

    public final long i() {
        return this.f3850d;
    }

    public final TwoWayConverter n() {
        return this.f3847a;
    }

    public final Object p() {
        return this.f3847a.b().invoke(this.f3849c);
    }

    public final AnimationVector q() {
        return this.f3849c;
    }

    public final boolean r() {
        return this.f3852g;
    }

    public String toString() {
        return "AnimationState(value=" + getValue() + ", velocity=" + p() + ", isRunning=" + this.f3852g + ", lastFrameTimeNanos=" + this.f3850d + ", finishedTimeNanos=" + this.f3851f + ')';
    }

    public final void v(long j3) {
        this.f3851f = j3;
    }

    public final void w(long j3) {
        this.f3850d = j3;
    }

    public final void x(boolean z2) {
        this.f3852g = z2;
    }

    public void y(Object obj) {
        this.f3848b.setValue(obj);
    }

    public final void z(AnimationVector animationVector) {
        this.f3849c = animationVector;
    }

    public /* synthetic */ AnimationState(TwoWayConverter twoWayConverter, Object obj, AnimationVector animationVector, long j3, long j4, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(twoWayConverter, obj, (i3 & 4) != 0 ? null : animationVector, (i3 & 8) != 0 ? Long.MIN_VALUE : j3, (i3 & 16) != 0 ? Long.MIN_VALUE : j4, (i3 & 32) != 0 ? false : z2);
    }
}
