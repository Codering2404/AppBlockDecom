package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
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
public final class StringAnnotation implements AnnotatedString.Annotation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f28877a;

    private /* synthetic */ StringAnnotation(String str) {
        this.f28877a = str;
    }

    public static final /* synthetic */ StringAnnotation a(String str) {
        return new StringAnnotation(str);
    }

    public static boolean c(String str, Object obj) {
        return (obj instanceof StringAnnotation) && Intrinsics.areEqual(str, ((StringAnnotation) obj).f());
    }

    public static int d(String str) {
        return str.hashCode();
    }

    public static String e(String str) {
        return "StringAnnotation(value=" + str + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f28877a, obj);
    }

    public final /* synthetic */ String f() {
        return this.f28877a;
    }

    public int hashCode() {
        return d(this.f28877a);
    }

    public String toString() {
        return e(this.f28877a);
    }

    public static String b(String str) {
        return str;
    }
}
