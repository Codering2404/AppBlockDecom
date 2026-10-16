package androidx.constraintlayout.compose;

import java.util.HashMap;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DesignElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap f30531c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DesignElement)) {
            return false;
        }
        DesignElement designElement = (DesignElement) obj;
        return Intrinsics.areEqual(this.f30529a, designElement.f30529a) && Intrinsics.areEqual(this.f30530b, designElement.f30530b) && Intrinsics.areEqual(this.f30531c, designElement.f30531c);
    }

    public int hashCode() {
        return (((this.f30529a.hashCode() * 31) + this.f30530b.hashCode()) * 31) + this.f30531c.hashCode();
    }

    public String toString() {
        return "DesignElement(id=" + this.f30529a + ", type=" + this.f30530b + ", params=" + this.f30531c + ')';
    }
}
