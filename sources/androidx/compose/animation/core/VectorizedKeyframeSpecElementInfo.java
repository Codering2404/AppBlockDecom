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
public final class VectorizedKeyframeSpecElementInfo<V extends AnimationVector> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationVector f4333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Easing f4334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4335c;

    public /* synthetic */ VectorizedKeyframeSpecElementInfo(AnimationVector animationVector, Easing easing, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationVector, easing, i3);
    }

    public final int a() {
        return this.f4335c;
    }

    public final Easing b() {
        return this.f4334b;
    }

    public final AnimationVector c() {
        return this.f4333a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VectorizedKeyframeSpecElementInfo)) {
            return false;
        }
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) obj;
        return Intrinsics.areEqual(this.f4333a, vectorizedKeyframeSpecElementInfo.f4333a) && Intrinsics.areEqual(this.f4334b, vectorizedKeyframeSpecElementInfo.f4334b) && ArcMode.d(this.f4335c, vectorizedKeyframeSpecElementInfo.f4335c);
    }

    public int hashCode() {
        return (((this.f4333a.hashCode() * 31) + this.f4334b.hashCode()) * 31) + ArcMode.e(this.f4335c);
    }

    public String toString() {
        return "VectorizedKeyframeSpecElementInfo(vectorValue=" + this.f4333a + ", easing=" + this.f4334b + ", arcMode=" + ((Object) ArcMode.f(this.f4335c)) + ')';
    }

    private VectorizedKeyframeSpecElementInfo(AnimationVector animationVector, Easing easing, int i3) {
        this.f4333a = animationVector;
        this.f4334b = easing;
        this.f4335c = i3;
    }
}
