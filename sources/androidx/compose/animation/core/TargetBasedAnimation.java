package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class TargetBasedAnimation<T, V extends AnimationVector> implements Animation<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VectorizedAnimationSpec f4180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TwoWayConverter f4181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f4182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object f4183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AnimationVector f4184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AnimationVector f4185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AnimationVector f4186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f4187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AnimationVector f4188i;

    public TargetBasedAnimation(VectorizedAnimationSpec vectorizedAnimationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector) {
        AnimationVector animationVectorE;
        this.f4180a = vectorizedAnimationSpec;
        this.f4181b = twoWayConverter;
        this.f4182c = obj2;
        this.f4183d = obj;
        this.f4184e = (AnimationVector) e().a().invoke(obj);
        this.f4185f = (AnimationVector) e().a().invoke(obj2);
        this.f4186g = (animationVector == null || (animationVectorE = AnimationVectorsKt.e(animationVector)) == null) ? AnimationVectorsKt.g((AnimationVector) e().a().invoke(obj)) : animationVectorE;
        this.f4187h = -1L;
    }

    private final AnimationVector h() {
        AnimationVector animationVector = this.f4188i;
        if (animationVector != null) {
            return animationVector;
        }
        AnimationVector animationVectorD = this.f4180a.d(this.f4184e, this.f4185f, this.f4186g);
        this.f4188i = animationVectorD;
        return animationVectorD;
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean a() {
        return this.f4180a.a();
    }

    @Override // androidx.compose.animation.core.Animation
    public AnimationVector b(long j3) {
        return !c(j3) ? this.f4180a.f(j3, this.f4184e, this.f4185f, this.f4186g) : h();
    }

    @Override // androidx.compose.animation.core.Animation
    public long d() {
        if (this.f4187h < 0) {
            this.f4187h = this.f4180a.b(this.f4184e, this.f4185f, this.f4186g);
        }
        return this.f4187h;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter e() {
        return this.f4181b;
    }

    @Override // androidx.compose.animation.core.Animation
    public Object f(long j3) {
        if (c(j3)) {
            return g();
        }
        AnimationVector animationVectorG = this.f4180a.g(j3, this.f4184e, this.f4185f, this.f4186g);
        int iB = animationVectorG.b();
        for (int i3 = 0; i3 < iB; i3++) {
            if (Float.isNaN(animationVectorG.a(i3))) {
                PreconditionsKt.b("AnimationVector cannot contain a NaN. " + animationVectorG + ". Animation: " + this + ", playTimeNanos: " + j3);
            }
        }
        return e().b().invoke(animationVectorG);
    }

    @Override // androidx.compose.animation.core.Animation
    public Object g() {
        return this.f4182c;
    }

    public final Object i() {
        return this.f4183d;
    }

    public final void j(Object obj) {
        if (Intrinsics.areEqual(obj, this.f4183d)) {
            return;
        }
        this.f4183d = obj;
        this.f4184e = (AnimationVector) e().a().invoke(obj);
        this.f4188i = null;
        this.f4187h = -1L;
    }

    public final void k(Object obj) {
        if (Intrinsics.areEqual(this.f4182c, obj)) {
            return;
        }
        this.f4182c = obj;
        this.f4185f = (AnimationVector) e().a().invoke(obj);
        this.f4188i = null;
        this.f4187h = -1L;
    }

    public String toString() {
        return "TargetBasedAnimation: " + i() + " -> " + g() + ",initial velocity: " + this.f4186g + ", duration: " + AnimationKt.c(this) + " ms,animationSpec: " + this.f4180a;
    }

    public /* synthetic */ TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec, twoWayConverter, obj, obj2, (i3 & 16) != 0 ? null : animationVector);
    }

    public TargetBasedAnimation(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, AnimationVector animationVector) {
        this(animationSpec.a(twoWayConverter), twoWayConverter, obj, obj2, animationVector);
    }
}
