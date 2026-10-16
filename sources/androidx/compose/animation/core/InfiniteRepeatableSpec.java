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
public final class InfiniteRepeatableSpec<T> implements AnimationSpec<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3963d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final DurationBasedAnimationSpec f3964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RepeatMode f3965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f3966c;

    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(durationBasedAnimationSpec, repeatMode, j3);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public VectorizedAnimationSpec a(TwoWayConverter twoWayConverter) {
        return new VectorizedInfiniteRepeatableSpec(this.f3964a.a(twoWayConverter), this.f3965b, this.f3966c, null);
    }

    public boolean equals(Object obj) {
        if (obj instanceof InfiniteRepeatableSpec) {
            InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) obj;
            if (Intrinsics.areEqual(infiniteRepeatableSpec.f3964a, this.f3964a) && infiniteRepeatableSpec.f3965b == this.f3965b && StartOffset.e(infiniteRepeatableSpec.f3966c, this.f3966c)) {
                return true;
            }
        }
        return false;
    }

    public final DurationBasedAnimationSpec f() {
        return this.f3964a;
    }

    public final long g() {
        return this.f3966c;
    }

    public final RepeatMode h() {
        return this.f3965b;
    }

    public int hashCode() {
        return (((this.f3964a.hashCode() * 31) + this.f3965b.hashCode()) * 31) + StartOffset.h(this.f3966c);
    }

    private InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3) {
        this.f3964a = durationBasedAnimationSpec;
        this.f3965b = repeatMode;
        this.f3966c = j3;
    }

    public /* synthetic */ InfiniteRepeatableSpec(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(durationBasedAnimationSpec, (i3 & 2) != 0 ? RepeatMode.f4052a : repeatMode, (i3 & 4) != 0 ? StartOffset.c(0, 0, 2, null) : j3, null);
    }
}
