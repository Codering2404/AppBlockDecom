package coil.util;

import coil.decode.ExifOrientationPolicy;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ImageLoaderOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f56232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f56233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f56234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f56235d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ExifOrientationPolicy f56236e;

    public ImageLoaderOptions(boolean z2, boolean z3, boolean z4, int i3, ExifOrientationPolicy exifOrientationPolicy) {
        this.f56232a = z2;
        this.f56233b = z3;
        this.f56234c = z4;
        this.f56235d = i3;
        this.f56236e = exifOrientationPolicy;
    }

    public final boolean a() {
        return this.f56232a;
    }

    public final ExifOrientationPolicy b() {
        return this.f56236e;
    }

    public final int c() {
        return this.f56235d;
    }

    public final boolean d() {
        return this.f56233b;
    }

    public final boolean e() {
        return this.f56234c;
    }

    public /* synthetic */ ImageLoaderOptions(boolean z2, boolean z3, boolean z4, int i3, ExifOrientationPolicy exifOrientationPolicy, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? true : z2, (i4 & 2) != 0 ? true : z3, (i4 & 4) != 0 ? true : z4, (i4 & 8) != 0 ? 4 : i3, (i4 & 16) != 0 ? ExifOrientationPolicy.RESPECT_PERFORMANCE : exifOrientationPolicy);
    }
}
