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
public final class Pair<A, B> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f139766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f139767b;

    public Pair(Object obj, Object obj2) {
        this.f139766a = obj;
        this.f139767b = obj2;
    }

    public static /* synthetic */ Pair d(Pair pair, Object obj, Object obj2, int i3, Object obj3) {
        if ((i3 & 1) != 0) {
            obj = pair.f139766a;
        }
        if ((i3 & 2) != 0) {
            obj2 = pair.f139767b;
        }
        return pair.c(obj, obj2);
    }

    public final Object a() {
        return this.f139766a;
    }

    public final Object b() {
        return this.f139767b;
    }

    public final Pair c(Object obj, Object obj2) {
        return new Pair(obj, obj2);
    }

    public final Object e() {
        return this.f139766a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Intrinsics.areEqual(this.f139766a, pair.f139766a) && Intrinsics.areEqual(this.f139767b, pair.f139767b);
    }

    public final Object f() {
        return this.f139767b;
    }

    public int hashCode() {
        Object obj = this.f139766a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f139767b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f139766a + ", " + this.f139767b + ')';
    }
}
