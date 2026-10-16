package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidStringDelegate_androidKt;
import kotlin.Metadata;

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
public final class StringKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PlatformStringDelegate f28878a = AndroidStringDelegate_androidKt.a();

    public static final String a(String str, Locale locale) {
        return f28878a.d(str, locale.b());
    }

    public static final String b(String str, LocaleList localeList) {
        return a(str, localeList.isEmpty() ? Locale.f29469b.a() : localeList.d(0));
    }

    public static final String c(String str, Locale locale) {
        return f28878a.a(str, locale.b());
    }

    public static final String d(String str, LocaleList localeList) {
        return c(str, localeList.isEmpty() ? Locale.f29469b.a() : localeList.d(0));
    }

    public static final String e(String str, Locale locale) {
        return f28878a.b(str, locale.b());
    }

    public static final String f(String str, LocaleList localeList) {
        return e(str, localeList.isEmpty() ? Locale.f29469b.a() : localeList.d(0));
    }

    public static final String g(String str, Locale locale) {
        return f28878a.c(str, locale.b());
    }

    public static final String h(String str, LocaleList localeList) {
        return g(str, localeList.isEmpty() ? Locale.f29469b.a() : localeList.d(0));
    }
}
