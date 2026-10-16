package cz.mobilesoft.coreblock.scene.timenudge;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
final class WedgeCorners {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f122888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f122889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f122890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f122891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f122892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f122893f;

    public WedgeCorners(float f3, float f4, float f5, float f6, float f7, boolean z2) {
        this.f122888a = f3;
        this.f122889b = f4;
        this.f122890c = f5;
        this.f122891d = f6;
        this.f122892e = f7;
        this.f122893f = z2;
    }

    public final float a() {
        return this.f122888a;
    }

    public final float b() {
        return this.f122889b;
    }

    public final float c() {
        return this.f122890c;
    }

    public final float d() {
        return this.f122891d;
    }

    public final float e() {
        return this.f122892e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WedgeCorners)) {
            return false;
        }
        WedgeCorners wedgeCorners = (WedgeCorners) obj;
        return Float.compare(this.f122888a, wedgeCorners.f122888a) == 0 && Float.compare(this.f122889b, wedgeCorners.f122889b) == 0 && Float.compare(this.f122890c, wedgeCorners.f122890c) == 0 && Float.compare(this.f122891d, wedgeCorners.f122891d) == 0 && Float.compare(this.f122892e, wedgeCorners.f122892e) == 0 && this.f122893f == wedgeCorners.f122893f;
    }

    public final boolean f() {
        return this.f122893f;
    }

    public int hashCode() {
        return (((((((((Float.hashCode(this.f122888a) * 31) + Float.hashCode(this.f122889b)) * 31) + Float.hashCode(this.f122890c)) * 31) + Float.hashCode(this.f122891d)) * 31) + Float.hashCode(this.f122892e)) * 31) + Boolean.hashCode(this.f122893f);
    }

    public String toString() {
        return "WedgeCorners(cornerPx=" + this.f122888a + ", insetRadius=" + this.f122889b + ", insetDeltaDeg=" + this.f122890c + ", apexCornerPx=" + this.f122891d + ", apexCentreDistance=" + this.f122892e + ", apexIsConvex=" + this.f122893f + ")";
    }
}
