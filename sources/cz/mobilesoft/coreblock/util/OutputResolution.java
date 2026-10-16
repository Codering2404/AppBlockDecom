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
final class OutputResolution {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f127899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f127900b;

    public OutputResolution(int i3, int i4) {
        this.f127899a = i3;
        this.f127900b = i4;
    }

    public final int a() {
        return this.f127900b;
    }

    public final int b() {
        return this.f127899a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutputResolution)) {
            return false;
        }
        OutputResolution outputResolution = (OutputResolution) obj;
        return this.f127899a == outputResolution.f127899a && this.f127900b == outputResolution.f127900b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f127899a) * 31) + Integer.hashCode(this.f127900b);
    }

    public String toString() {
        return "OutputResolution(width=" + this.f127899a + ", height=" + this.f127900b + ")";
    }
}
