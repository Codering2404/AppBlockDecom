package cz.mobilesoft.coreblock.util;

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
final class VideoProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f128113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f128114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f128115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f128116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f128117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f128118f;

    public VideoProperties(int i3, int i4, long j3, float f3, boolean z2, boolean z3) {
        this.f128113a = i3;
        this.f128114b = i4;
        this.f128115c = j3;
        this.f128116d = f3;
        this.f128117e = z2;
        this.f128118f = z3;
    }

    public final long a() {
        return this.f128115c;
    }

    public final float b() {
        return this.f128116d;
    }

    public final boolean c() {
        return this.f128118f;
    }

    public final boolean d() {
        return this.f128117e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoProperties)) {
            return false;
        }
        VideoProperties videoProperties = (VideoProperties) obj;
        return this.f128113a == videoProperties.f128113a && this.f128114b == videoProperties.f128114b && this.f128115c == videoProperties.f128115c && Float.compare(this.f128116d, videoProperties.f128116d) == 0 && this.f128117e == videoProperties.f128117e && this.f128118f == videoProperties.f128118f;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f128113a) * 31) + Integer.hashCode(this.f128114b)) * 31) + Long.hashCode(this.f128115c)) * 31) + Float.hashCode(this.f128116d)) * 31) + Boolean.hashCode(this.f128117e)) * 31) + Boolean.hashCode(this.f128118f);
    }

    public String toString() {
        return "VideoProperties(width=" + this.f128113a + ", height=" + this.f128114b + ", duration=" + this.f128115c + ", frameRate=" + this.f128116d + ", isLandscape=" + this.f128117e + ", hasAudio=" + this.f128118f + ")";
    }
}
