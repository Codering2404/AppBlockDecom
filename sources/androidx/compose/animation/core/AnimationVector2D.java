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
public final class AnimationVector2D extends AnimationVector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f3856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3857c;

    public AnimationVector2D(float f3, float f4) {
        super(null);
        this.f3855a = f3;
        this.f3856b = f4;
        this.f3857c = 2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float a(int i3) {
        if (i3 == 0) {
            return this.f3855a;
        }
        if (i3 != 1) {
            return 0.0f;
        }
        return this.f3856b;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int b() {
        return this.f3857c;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void d() {
        this.f3855a = 0.0f;
        this.f3856b = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void e(int i3, float f3) {
        if (i3 == 0) {
            this.f3855a = f3;
        } else {
            if (i3 != 1) {
                return;
            }
            this.f3856b = f3;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnimationVector2D)) {
            return false;
        }
        AnimationVector2D animationVector2D = (AnimationVector2D) obj;
        return animationVector2D.f3855a == this.f3855a && animationVector2D.f3856b == this.f3856b;
    }

    public final float f() {
        return this.f3855a;
    }

    public final float g() {
        return this.f3856b;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public AnimationVector2D c() {
        return new AnimationVector2D(0.0f, 0.0f);
    }

    public int hashCode() {
        return (Float.hashCode(this.f3855a) * 31) + Float.hashCode(this.f3856b);
    }

    public String toString() {
        return "AnimationVector2D: v1 = " + this.f3855a + ", v2 = " + this.f3856b;
    }
}
