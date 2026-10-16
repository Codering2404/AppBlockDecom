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
public final class FloatTweenSpec implements FloatAnimationSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Easing f3957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f3958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f3959e;

    public FloatTweenSpec(int i3, int i4, Easing easing) {
        this.f3955a = i3;
        this.f3956b = i4;
        this.f3957c = easing;
        this.f3958d = ((long) i3) * 1000000;
        this.f3959e = ((long) i4) * 1000000;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float c(long j3, float f3, float f4, float f5) {
        long j4 = j3 - this.f3959e;
        long j5 = this.f3958d;
        if (j4 < 0) {
            j4 = 0;
        }
        if (j4 > j5) {
            j4 = j5;
        }
        float fA = this.f3957c.a(this.f3955a == 0 ? 1.0f : j4 / j5);
        return (f3 * (1 - fA)) + (f4 * fA);
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public float d(long j3, float f3, float f4, float f5) {
        long j4 = j3 - this.f3959e;
        long j5 = this.f3958d;
        if (j4 < 0) {
            j4 = 0;
        }
        long j6 = j4 > j5 ? j5 : j4;
        if (j6 == 0) {
            return f5;
        }
        return (c(j6, f3, f4, f5) - c(j6 - 1000000, f3, f4, f5)) * 1000.0f;
    }

    @Override // androidx.compose.animation.core.FloatAnimationSpec
    public long e(float f3, float f4, float f5) {
        return this.f3959e + this.f3958d;
    }
}
