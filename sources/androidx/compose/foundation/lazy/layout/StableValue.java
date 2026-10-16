package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
final class StableValue<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f8288a;

    public static boolean b(Object obj, Object obj2) {
        return (obj2 instanceof StableValue) && Intrinsics.areEqual(obj, ((StableValue) obj2).e());
    }

    public static int c(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static String d(Object obj) {
        return "StableValue(value=" + obj + ')';
    }

    public final /* synthetic */ Object e() {
        return this.f8288a;
    }

    public boolean equals(Object obj) {
        return b(this.f8288a, obj);
    }

    public int hashCode() {
        return c(this.f8288a);
    }

    public String toString() {
        return d(this.f8288a);
    }

    public static Object a(Object obj) {
        return obj;
    }
}
