package androidx.compose.ui.text.font;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
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
public final class DeviceFontFamilyName {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29149a;

    public static String a(String str) {
        if (!(str.length() > 0)) {
            InlineClassHelperKt.a("name may not be empty");
        }
        return str;
    }

    public static boolean b(String str, Object obj) {
        return (obj instanceof DeviceFontFamilyName) && Intrinsics.areEqual(str, ((DeviceFontFamilyName) obj).f());
    }

    public static final boolean c(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    public static int d(String str) {
        return str.hashCode();
    }

    public static String e(String str) {
        return "DeviceFontFamilyName(name=" + str + ')';
    }

    public boolean equals(Object obj) {
        return b(this.f29149a, obj);
    }

    public final /* synthetic */ String f() {
        return this.f29149a;
    }

    public int hashCode() {
        return d(this.f29149a);
    }

    public String toString() {
        return e(this.f29149a);
    }
}
