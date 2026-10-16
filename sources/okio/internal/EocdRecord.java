package okio.internal;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class EocdRecord {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f145165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f145166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f145167c;

    public EocdRecord(long j3, long j4, int i3) {
        this.f145165a = j3;
        this.f145166b = j4;
        this.f145167c = i3;
    }

    public final long a() {
        return this.f145166b;
    }

    public final int b() {
        return this.f145167c;
    }

    public final long c() {
        return this.f145165a;
    }
}
