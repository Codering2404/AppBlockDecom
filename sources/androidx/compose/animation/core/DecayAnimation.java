package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
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
public final class DecayAnimation<T, V extends AnimationVector> implements Animation<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VectorizedDecayAnimationSpec f3903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TwoWayConverter f3904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f3905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AnimationVector f3906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AnimationVector f3907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AnimationVector f3908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f3909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f3910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f3911i;

    public DecayAnimation(VectorizedDecayAnimationSpec vectorizedDecayAnimationSpec, TwoWayConverter twoWayConverter, Object obj, AnimationVector animationVector) {
        this.f3903a = vectorizedDecayAnimationSpec;
        this.f3904b = twoWayConverter;
        this.f3905c = obj;
        AnimationVector animationVector2 = (AnimationVector) e().a().invoke(obj);
        this.f3906d = animationVector2;
        this.f3907e = AnimationVectorsKt.e(animationVector);
        this.f3909g = e().b().invoke(vectorizedDecayAnimationSpec.d(animationVector2, animationVector));
        this.f3910h = vectorizedDecayAnimationSpec.c(animationVector2, animationVector);
        AnimationVector animationVectorE = AnimationVectorsKt.e(vectorizedDecayAnimationSpec.b(d(), animationVector2, animationVector));
        this.f3908f = animationVectorE;
        int iB = animationVectorE.b();
        for (int i3 = 0; i3 < iB; i3++) {
            AnimationVector animationVector3 = this.f3908f;
            animationVector3.e(i3, RangesKt.o(animationVector3.a(i3), -this.f3903a.a(), this.f3903a.a()));
        }
    }

    @Override // androidx.compose.animation.core.Animation
    public boolean a() {
        return this.f3911i;
    }

    @Override // androidx.compose.animation.core.Animation
    public AnimationVector b(long j3) {
        return !c(j3) ? this.f3903a.b(j3, this.f3906d, this.f3907e) : this.f3908f;
    }

    @Override // androidx.compose.animation.core.Animation
    public long d() {
        return this.f3910h;
    }

    @Override // androidx.compose.animation.core.Animation
    public TwoWayConverter e() {
        return this.f3904b;
    }

    @Override // androidx.compose.animation.core.Animation
    public Object f(long j3) {
        return !c(j3) ? e().b().invoke(this.f3903a.e(j3, this.f3906d, this.f3907e)) : g();
    }

    @Override // androidx.compose.animation.core.Animation
    public Object g() {
        return this.f3909g;
    }

    public DecayAnimation(DecayAnimationSpec decayAnimationSpec, TwoWayConverter twoWayConverter, Object obj, AnimationVector animationVector) {
        this(decayAnimationSpec.a(twoWayConverter), twoWayConverter, obj, animationVector);
    }
}
