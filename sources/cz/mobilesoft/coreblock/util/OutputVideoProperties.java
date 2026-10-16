package cz.mobilesoft.coreblock.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
final class OutputVideoProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f127901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OutputResolution f127902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f127903c;

    public OutputVideoProperties(int i3, OutputResolution resolution, String codec) {
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        Intrinsics.checkNotNullParameter(codec, "codec");
        this.f127901a = i3;
        this.f127902b = resolution;
        this.f127903c = codec;
    }

    public final int a() {
        return this.f127901a;
    }

    public final String b() {
        return this.f127903c;
    }

    public final OutputResolution c() {
        return this.f127902b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutputVideoProperties)) {
            return false;
        }
        OutputVideoProperties outputVideoProperties = (OutputVideoProperties) obj;
        return this.f127901a == outputVideoProperties.f127901a && Intrinsics.areEqual(this.f127902b, outputVideoProperties.f127902b) && Intrinsics.areEqual(this.f127903c, outputVideoProperties.f127903c);
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f127901a) * 31) + this.f127902b.hashCode()) * 31) + this.f127903c.hashCode();
    }

    public String toString() {
        return "OutputVideoProperties(bitrate=" + this.f127901a + ", resolution=" + this.f127902b + ", codec=" + this.f127903c + ")";
    }
}
