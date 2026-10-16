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
public final class AnimationVector4D extends AnimationVector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f3863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f3865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3866e;

    public AnimationVector4D(float f3, float f4, float f5, float f6) {
        super(null);
        this.f3862a = f3;
        this.f3863b = f4;
        this.f3864c = f5;
        this.f3865d = f6;
        this.f3866e = 4;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float a(int i3) {
        if (i3 == 0) {
            return this.f3862a;
        }
        if (i3 == 1) {
            return this.f3863b;
        }
        if (i3 == 2) {
            return this.f3864c;
        }
        if (i3 != 3) {
            return 0.0f;
        }
        return this.f3865d;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int b() {
        return this.f3866e;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void d() {
        this.f3862a = 0.0f;
        this.f3863b = 0.0f;
        this.f3864c = 0.0f;
        this.f3865d = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void e(int i3, float f3) {
        if (i3 == 0) {
            this.f3862a = f3;
            return;
        }
        if (i3 == 1) {
            this.f3863b = f3;
        } else if (i3 == 2) {
            this.f3864c = f3;
        } else {
            if (i3 != 3) {
                return;
            }
            this.f3865d = f3;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnimationVector4D)) {
            return false;
        }
        AnimationVector4D animationVector4D = (AnimationVector4D) obj;
        return animationVector4D.f3862a == this.f3862a && animationVector4D.f3863b == this.f3863b && animationVector4D.f3864c == this.f3864c && animationVector4D.f3865d == this.f3865d;
    }

    public final float f() {
        return this.f3862a;
    }

    public final float g() {
        return this.f3863b;
    }

    public final float h() {
        return this.f3864c;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.f3862a) * 31) + Float.hashCode(this.f3863b)) * 31) + Float.hashCode(this.f3864c)) * 31) + Float.hashCode(this.f3865d);
    }

    public final float i() {
        return this.f3865d;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public AnimationVector4D c() {
        return new AnimationVector4D(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector4D: v1 = " + this.f3862a + ", v2 = " + this.f3863b + ", v3 = " + this.f3864c + ", v4 = " + this.f3865d;
    }
}
