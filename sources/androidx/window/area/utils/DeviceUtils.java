package androidx.window.area.utils;

import android.util.DisplayMetrics;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class DeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeviceUtils f54104a = new DeviceUtils();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List f54105b;

    static {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        displayMetrics.widthPixels = 1080;
        displayMetrics.heightPixels = 2092;
        displayMetrics.density = 2.625f;
        displayMetrics.densityDpi = 420;
        Unit unit = Unit.f139807a;
        f54105b = CollectionsKt.listOf(new DeviceMetrics("google", "pixel fold", displayMetrics));
    }

    private DeviceUtils() {
    }

    public final DisplayMetrics a(String manufacturer, String model) {
        Object next;
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Iterator it = f54105b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            DeviceMetrics deviceMetrics = (DeviceMetrics) next;
            String strA = deviceMetrics.a();
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = manufacturer.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (Intrinsics.areEqual(strA, lowerCase)) {
                String strB = deviceMetrics.b();
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase2 = model.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(strB, lowerCase2)) {
                    break;
                }
            }
        }
        DeviceMetrics deviceMetrics2 = (DeviceMetrics) next;
        if (deviceMetrics2 != null) {
            return deviceMetrics2.c();
        }
        return null;
    }
}
