package cz.mobilesoft.coreblock.storage.room.dto.blocking;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.util.CrashHelper;
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
public final class BrowserConfigJsonKt {
    public static final BrowserViewId a(BrowserConfigJson browserConfigJson, BrowserViewId.ViewType viewType) {
        String strG;
        Intrinsics.checkNotNullParameter(browserConfigJson, "<this>");
        Intrinsics.checkNotNullParameter(viewType, "viewType");
        String strE = browserConfigJson.e();
        if (strE == null || StringsKt.p0(strE) || (strG = browserConfigJson.g()) == null || StringsKt.p0(strG)) {
            CrashHelper.j(new IllegalArgumentException("Invalid BrowserConfigJson: packageName='" + browserConfigJson.e() + "', viewId='" + browserConfigJson.g() + "'"));
            return null;
        }
        String strE2 = browserConfigJson.e();
        String strG2 = browserConfigJson.g();
        Boolean boolA = browserConfigJson.a();
        boolean zBooleanValue = boolA != null ? boolA.booleanValue() : true;
        Boolean boolF = browserConfigJson.f();
        boolean zBooleanValue2 = boolF != null ? boolF.booleanValue() : true;
        BrowserViewId.DetectionMethod.Companion companion = BrowserViewId.DetectionMethod.Companion;
        String strC = browserConfigJson.c();
        if (strC == null) {
            strC = "";
        }
        BrowserViewId.DetectionMethod detectionMethodB = companion.b(strC);
        BrowserViewId.ExtractionMethod.Companion companion2 = BrowserViewId.ExtractionMethod.Companion;
        String strD = browserConfigJson.d();
        return new BrowserViewId(0L, strE2, strG2, viewType, zBooleanValue, zBooleanValue2, detectionMethodB, companion2.b(strD != null ? strD : ""), browserConfigJson.b(), 1, null);
    }
}
