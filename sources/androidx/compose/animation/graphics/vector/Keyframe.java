package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.Easing;
import kotlin.Metadata;
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
public final class Keyframe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f4412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Easing f4413c;

    public Keyframe(float f3, Object obj, Easing easing) {
        this.f4411a = f3;
        this.f4412b = obj;
        this.f4413c = easing;
    }

    public final float a() {
        return this.f4411a;
    }

    public final Easing b() {
        return this.f4413c;
    }

    public final Object c() {
        return this.f4412b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Keyframe)) {
            return false;
        }
        Keyframe keyframe = (Keyframe) obj;
        return Float.compare(this.f4411a, keyframe.f4411a) == 0 && Intrinsics.areEqual(this.f4412b, keyframe.f4412b) && Intrinsics.areEqual(this.f4413c, keyframe.f4413c);
    }

    public int hashCode() {
        int iHashCode = Float.hashCode(this.f4411a) * 31;
        Object obj = this.f4412b;
        return ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31) + this.f4413c.hashCode();
    }

    public String toString() {
        return "Keyframe(fraction=" + this.f4411a + ", value=" + this.f4412b + ", interpolator=" + this.f4413c + ')';
    }
}
