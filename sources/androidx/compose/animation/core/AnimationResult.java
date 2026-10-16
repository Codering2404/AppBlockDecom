package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;

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
public final class AnimationResult<T, V extends AnimationVector> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationState f3836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimationEndReason f3837b;

    public AnimationResult(AnimationState animationState, AnimationEndReason animationEndReason) {
        this.f3836a = animationState;
        this.f3837b = animationEndReason;
    }

    public final AnimationEndReason a() {
        return this.f3837b;
    }

    public final AnimationState b() {
        return this.f3836a;
    }

    public String toString() {
        return "AnimationResult(endReason=" + this.f3837b + ", endState=" + this.f3836a + ')';
    }
}
