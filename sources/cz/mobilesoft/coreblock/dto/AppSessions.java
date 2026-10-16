package cz.mobilesoft.coreblock.dto;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppSessions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f96888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f96889b;

    public AppSessions(String name, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f96888a = name;
        this.f96889b = i3;
    }

    public final String a() {
        return this.f96888a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSessions)) {
            return false;
        }
        AppSessions appSessions = (AppSessions) obj;
        return Intrinsics.areEqual(this.f96888a, appSessions.f96888a) && this.f96889b == appSessions.f96889b;
    }

    public int hashCode() {
        return (this.f96888a.hashCode() * 31) + Integer.hashCode(this.f96889b);
    }

    public String toString() {
        return "AppSessions(name=" + this.f96888a + ", sessions=" + this.f96889b + ")";
    }
}
