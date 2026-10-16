package cz.mobilesoft.coreblock.scene.statistics;

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
public final class StatisticsIntervalConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f119687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f119688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f119689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f119690d;

    public final long a() {
        return this.f119687a;
    }

    public final long b() {
        return this.f119688b;
    }

    public final int c() {
        return this.f119689c;
    }

    public final int d() {
        return this.f119690d;
    }

    public final void e(long j3) {
        this.f119687a = j3;
    }

    public final void f(long j3) {
        this.f119688b = j3;
    }

    public final void g(int i3) {
        this.f119689c = i3;
    }

    public final void h(int i3) {
        this.f119690d = i3;
    }
}
