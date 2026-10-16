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
public final class RepeatableSpec<T> implements FiniteAnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DurationBasedAnimationSpec f4057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RepeatMode f4058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4059d;

    public /* synthetic */ RepeatableSpec(int i3, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, durationBasedAnimationSpec, repeatMode, j3);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RepeatableSpec) {
            RepeatableSpec repeatableSpec = (RepeatableSpec) obj;
            if (repeatableSpec.f4056a == this.f4056a && Intrinsics.areEqual(repeatableSpec.f4057b, this.f4057b) && repeatableSpec.f4058c == this.f4058c && StartOffset.e(repeatableSpec.f4059d, this.f4059d)) {
                return true;
            }
        }
        return false;
    }

    public final long f() {
        return this.f4059d;
    }

    public int hashCode() {
        return (((((this.f4056a * 31) + this.f4057b.hashCode()) * 31) + this.f4058c.hashCode()) * 31) + StartOffset.h(this.f4059d);
    }

    private RepeatableSpec(int i3, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3) {
        this.f4056a = i3;
        this.f4057b = durationBasedAnimationSpec;
        this.f4058c = repeatMode;
        this.f4059d = j3;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public VectorizedFiniteAnimationSpec a(TwoWayConverter twoWayConverter) {
        return new VectorizedRepeatableSpec(this.f4056a, this.f4057b.a(twoWayConverter), this.f4058c, this.f4059d, null);
    }
}
