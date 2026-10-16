package androidx.compose.ui.autofill;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

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
final class AndroidContentDataType implements ContentDataType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25211b;

    private /* synthetic */ AndroidContentDataType(int i3) {
        this.f25211b = i3;
    }

    public static final /* synthetic */ AndroidContentDataType a(int i3) {
        return new AndroidContentDataType(i3);
    }

    public static boolean c(int i3, Object obj) {
        return (obj instanceof AndroidContentDataType) && i3 == ((AndroidContentDataType) obj).f();
    }

    public static int d(int i3) {
        return Integer.hashCode(i3);
    }

    public static String e(int i3) {
        return "AndroidContentDataType(androidAutofillType=" + i3 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f25211b, obj);
    }

    public final /* synthetic */ int f() {
        return this.f25211b;
    }

    public int hashCode() {
        return d(this.f25211b);
    }

    public String toString() {
        return e(this.f25211b);
    }

    public static int b(int i3) {
        return i3;
    }
}
