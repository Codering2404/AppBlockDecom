package androidx.work.impl.model;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SystemIdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f54985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54986c;

    public SystemIdInfo(String workSpecId, int i3, int i4) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f54984a = workSpecId;
        this.f54985b = i3;
        this.f54986c = i4;
    }

    public final int a() {
        return this.f54985b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return Intrinsics.areEqual(this.f54984a, systemIdInfo.f54984a) && this.f54985b == systemIdInfo.f54985b && this.f54986c == systemIdInfo.f54986c;
    }

    public int hashCode() {
        return (((this.f54984a.hashCode() * 31) + Integer.hashCode(this.f54985b)) * 31) + Integer.hashCode(this.f54986c);
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.f54984a + ", generation=" + this.f54985b + ", systemId=" + this.f54986c + ')';
    }
}
