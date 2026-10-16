package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BuildCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BuildCompat f34139a = new BuildCompat();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f34140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f34141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f34142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f34143e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api30Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api30Impl f34144a = new Api30Impl();

        private Api30Impl() {
        }

        public final int a(int i3) {
            return SdkExtensions.getExtensionVersion(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention
    public @interface PrereleaseSdkCheck {
    }

    static {
        int i3 = Build.VERSION.SDK_INT;
        f34140b = i3 >= 30 ? Api30Impl.f34144a.a(30) : 0;
        f34141c = i3 >= 30 ? Api30Impl.f34144a.a(31) : 0;
        f34142d = i3 >= 30 ? Api30Impl.f34144a.a(33) : 0;
        f34143e = i3 >= 30 ? Api30Impl.f34144a.a(1000000) : 0;
    }

    private BuildCompat() {
    }

    public static final boolean a(String codename, String buildCodename) {
        Intrinsics.checkNotNullParameter(codename, "codename");
        Intrinsics.checkNotNullParameter(buildCodename, "buildCodename");
        if (Intrinsics.areEqual("REL", buildCodename)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            return true;
        }
        if (i3 < 32) {
            return false;
        }
        String CODENAME = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
        return a("Tiramisu", CODENAME);
    }

    public static final boolean c() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            return true;
        }
        if (i3 < 33) {
            return false;
        }
        String CODENAME = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
        return a("UpsideDownCake", CODENAME);
    }

    public static final boolean d() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 35) {
            return true;
        }
        if (i3 < 34) {
            return false;
        }
        String CODENAME = Build.VERSION.CODENAME;
        Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
        return a("VanillaIceCream", CODENAME);
    }
}
