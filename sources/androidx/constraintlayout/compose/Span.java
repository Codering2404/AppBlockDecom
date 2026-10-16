package androidx.constraintlayout.compose;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@JvmInline
public final class Span {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30933a;

    public static boolean a(String str, Object obj) {
        return (obj instanceof Span) && Intrinsics.areEqual(str, ((Span) obj).d());
    }

    public static int b(String str) {
        return str.hashCode();
    }

    public static String c(String str) {
        return "Span(description=" + str + ')';
    }

    public final /* synthetic */ String d() {
        return this.f30933a;
    }

    public boolean equals(Object obj) {
        return a(this.f30933a, obj);
    }

    public int hashCode() {
        return b(this.f30933a);
    }

    public String toString() {
        return c(this.f30933a);
    }
}
