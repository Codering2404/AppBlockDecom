package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.TransformOrigin;
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
public final class Scale {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f3592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f3593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FiniteAnimationSpec f3594c;

    public /* synthetic */ Scale(float f3, long j3, FiniteAnimationSpec finiteAnimationSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, j3, finiteAnimationSpec);
    }

    public final FiniteAnimationSpec a() {
        return this.f3594c;
    }

    public final float b() {
        return this.f3592a;
    }

    public final long c() {
        return this.f3593b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scale)) {
            return false;
        }
        Scale scale = (Scale) obj;
        return Float.compare(this.f3592a, scale.f3592a) == 0 && TransformOrigin.e(this.f3593b, scale.f3593b) && Intrinsics.areEqual(this.f3594c, scale.f3594c);
    }

    public int hashCode() {
        return (((Float.hashCode(this.f3592a) * 31) + TransformOrigin.h(this.f3593b)) * 31) + this.f3594c.hashCode();
    }

    public String toString() {
        return "Scale(scale=" + this.f3592a + ", transformOrigin=" + ((Object) TransformOrigin.i(this.f3593b)) + ", animationSpec=" + this.f3594c + ')';
    }

    private Scale(float f3, long j3, FiniteAnimationSpec finiteAnimationSpec) {
        this.f3592a = f3;
        this.f3593b = j3;
        this.f3594c = finiteAnimationSpec;
    }
}
