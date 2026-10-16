package cz.mobilesoft.coreblock.util.runnability;

import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DeviceManufacturerInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeviceManufacturerInfo f129484a = new DeviceManufacturerInfo();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f129485b;

    static {
        String lowerCase;
        String str = Build.MANUFACTURER;
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        f129485b = lowerCase;
    }

    private DeviceManufacturerInfo() {
    }

    public final boolean a() {
        return StringsKt.a0(f129485b, "google", false, 2, null);
    }

    public final boolean b() {
        return StringsKt.a0(f129485b, "honor", false, 2, null);
    }

    public final boolean c() {
        String str = f129485b;
        return StringsKt.a0(str, "huawei", false, 2, null) || StringsKt.a0(str, "honor", false, 2, null);
    }

    public final boolean d() {
        return StringsKt.a0(f129485b, "motorola", false, 2, null);
    }

    public final boolean e() {
        return d() && Build.VERSION.SDK_INT >= 30;
    }

    public final boolean f() {
        return StringsKt.a0(f129485b, "oneplus", false, 2, null);
    }

    public final boolean g() {
        return StringsKt.a0(f129485b, "oppo", false, 2, null);
    }

    public final boolean h() {
        return StringsKt.a0(f129485b, "poco", false, 2, null);
    }

    public final boolean i() {
        return StringsKt.a0(f129485b, "redmi", false, 2, null);
    }

    public final boolean j() {
        return StringsKt.a0(f129485b, "samsung", false, 2, null);
    }

    public final boolean k() {
        String lowerCase;
        if (StringsKt.a0(f129485b, "vivo", false, 2, null)) {
            return true;
        }
        String str = Build.BRAND;
        if (str != null) {
            lowerCase = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        return StringsKt.a0(lowerCase, "vivo", false, 2, null);
    }

    public final boolean l() {
        return StringsKt.a0(f129485b, "xiaomi", false, 2, null);
    }

    public final boolean m() {
        return l() || h() || i();
    }
}
