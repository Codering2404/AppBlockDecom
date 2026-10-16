package kotlin;

import java.io.Serializable;
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Triple<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f139783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f139784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f139785c;

    public Triple(Object obj, Object obj2, Object obj3) {
        this.f139783a = obj;
        this.f139784b = obj2;
        this.f139785c = obj3;
    }

    public final Object a() {
        return this.f139783a;
    }

    public final Object b() {
        return this.f139784b;
    }

    public final Object c() {
        return this.f139785c;
    }

    public final Object d() {
        return this.f139783a;
    }

    public final Object e() {
        return this.f139784b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return Intrinsics.areEqual(this.f139783a, triple.f139783a) && Intrinsics.areEqual(this.f139784b, triple.f139784b) && Intrinsics.areEqual(this.f139785c, triple.f139785c);
    }

    public final Object f() {
        return this.f139785c;
    }

    public int hashCode() {
        Object obj = this.f139783a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f139784b;
        int iHashCode2 = (iHashCode + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.f139785c;
        return iHashCode2 + (obj3 != null ? obj3.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f139783a + ", " + this.f139784b + ", " + this.f139785c + ')';
    }
}
