package androidx.compose.animation.core;

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
public final class AnimationVector1D extends AnimationVector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3854b;

    public AnimationVector1D(float f3) {
        super(null);
        this.f3853a = f3;
        this.f3854b = 1;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float a(int i3) {
        if (i3 == 0) {
            return this.f3853a;
        }
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int b() {
        return this.f3854b;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void d() {
        this.f3853a = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void e(int i3, float f3) {
        if (i3 == 0) {
            this.f3853a = f3;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AnimationVector1D) && ((AnimationVector1D) obj).f3853a == this.f3853a;
    }

    public final float f() {
        return this.f3853a;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public AnimationVector1D c() {
        return new AnimationVector1D(0.0f);
    }

    public int hashCode() {
        return Float.hashCode(this.f3853a);
    }

    public String toString() {
        return "AnimationVector1D: value = " + this.f3853a;
    }
}
