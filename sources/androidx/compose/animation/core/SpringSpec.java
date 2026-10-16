package androidx.compose.animation.core;

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
public final class SpringSpec<T> implements FiniteAnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f4142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4143c;

    public SpringSpec(float f3, float f4, Object obj) {
        this.f4141a = f3;
        this.f4142b = f4;
        this.f4143c = obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SpringSpec) {
            SpringSpec springSpec = (SpringSpec) obj;
            if (springSpec.f4141a == this.f4141a && springSpec.f4142b == this.f4142b && Intrinsics.areEqual(springSpec.f4143c, this.f4143c)) {
                return true;
            }
        }
        return false;
    }

    public final float f() {
        return this.f4141a;
    }

    public final float g() {
        return this.f4142b;
    }

    public final Object h() {
        return this.f4143c;
    }

    public int hashCode() {
        Object obj = this.f4143c;
        return ((((obj != null ? obj.hashCode() : 0) * 31) + Float.hashCode(this.f4141a)) * 31) + Float.hashCode(this.f4142b);
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public VectorizedSpringSpec a(TwoWayConverter twoWayConverter) {
        return new VectorizedSpringSpec(this.f4141a, this.f4142b, AnimationSpecKt.b(twoWayConverter, this.f4143c));
    }

    public /* synthetic */ SpringSpec(float f3, float f4, Object obj, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0f : f3, (i3 & 2) != 0 ? 1500.0f : f4, (i3 & 4) != 0 ? null : obj);
    }
}
