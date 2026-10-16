package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class AnimationData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f5537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f5538c;

    public /* synthetic */ AnimationData(float f3, long j3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, j3, f4);
    }

    public final float a() {
        return this.f5538c;
    }

    public final long b() {
        return this.f5537b;
    }

    public final float c() {
        return this.f5536a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnimationData)) {
            return false;
        }
        AnimationData animationData = (AnimationData) obj;
        return Float.compare(this.f5536a, animationData.f5536a) == 0 && Offset.j(this.f5537b, animationData.f5537b) && Float.compare(this.f5538c, animationData.f5538c) == 0;
    }

    public int hashCode() {
        return (((Float.hashCode(this.f5536a) * 31) + Offset.o(this.f5537b)) * 31) + Float.hashCode(this.f5538c);
    }

    public String toString() {
        return "AnimationData(zoom=" + this.f5536a + ", offset=" + ((Object) Offset.s(this.f5537b)) + ", degrees=" + this.f5538c + ')';
    }

    private AnimationData(float f3, long j3, float f4) {
        this.f5536a = f3;
        this.f5537b = j3;
        this.f5538c = f4;
    }
}
