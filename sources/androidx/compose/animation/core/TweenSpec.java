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
public final class TweenSpec<T> implements DurationBasedAnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Easing f4284c;

    public TweenSpec(int i3, int i4, Easing easing) {
        this.f4282a = i3;
        this.f4283b = i4;
        this.f4284c = easing;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TweenSpec) {
            TweenSpec tweenSpec = (TweenSpec) obj;
            if (tweenSpec.f4282a == this.f4282a && tweenSpec.f4283b == this.f4283b && Intrinsics.areEqual(tweenSpec.f4284c, this.f4284c)) {
                return true;
            }
        }
        return false;
    }

    public final int f() {
        return this.f4283b;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec, androidx.compose.animation.core.AnimationSpec
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public VectorizedTweenSpec a(TwoWayConverter twoWayConverter) {
        return new VectorizedTweenSpec(this.f4282a, this.f4283b, this.f4284c);
    }

    public int hashCode() {
        return (((this.f4282a * 31) + this.f4284c.hashCode()) * 31) + this.f4283b;
    }

    public /* synthetic */ TweenSpec(int i3, int i4, Easing easing, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 300 : i3, (i5 & 2) != 0 ? 0 : i4, (i5 & 4) != 0 ? EasingKt.d() : easing);
    }
}
