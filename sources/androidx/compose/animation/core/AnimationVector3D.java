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
public final class AnimationVector3D extends AnimationVector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f3859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f3861d;

    public AnimationVector3D(float f3, float f4, float f5) {
        super(null);
        this.f3858a = f3;
        this.f3859b = f4;
        this.f3860c = f5;
        this.f3861d = 3;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float a(int i3) {
        if (i3 == 0) {
            return this.f3858a;
        }
        if (i3 == 1) {
            return this.f3859b;
        }
        if (i3 != 2) {
            return 0.0f;
        }
        return this.f3860c;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int b() {
        return this.f3861d;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void d() {
        this.f3858a = 0.0f;
        this.f3859b = 0.0f;
        this.f3860c = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void e(int i3, float f3) {
        if (i3 == 0) {
            this.f3858a = f3;
        } else if (i3 == 1) {
            this.f3859b = f3;
        } else {
            if (i3 != 2) {
                return;
            }
            this.f3860c = f3;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnimationVector3D)) {
            return false;
        }
        AnimationVector3D animationVector3D = (AnimationVector3D) obj;
        return animationVector3D.f3858a == this.f3858a && animationVector3D.f3859b == this.f3859b && animationVector3D.f3860c == this.f3860c;
    }

    public final float f() {
        return this.f3858a;
    }

    public final float g() {
        return this.f3859b;
    }

    public final float h() {
        return this.f3860c;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f3858a) * 31) + Float.hashCode(this.f3859b)) * 31) + Float.hashCode(this.f3860c);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public AnimationVector3D c() {
        return new AnimationVector3D(0.0f, 0.0f, 0.0f);
    }

    public String toString() {
        return "AnimationVector3D: v1 = " + this.f3858a + ", v2 = " + this.f3859b + ", v3 = " + this.f3860c;
    }
}
