package cz.mobilesoft.coreblock.util.typeconverter;

import android.util.Log;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import java.util.Date;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DateZonedIsoJsonTypeAdapter extends BaseDateJsonTypeAdapter {
    @Override // cz.mobilesoft.coreblock.util.typeconverter.BaseDateJsonTypeAdapter
    protected Date g(String dateString) throws Exception {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        try {
            Long lM = DateHelperExtKt.m(dateString);
            if (lM != null) {
                long jLongValue = lM.longValue();
                Date date = new Date();
                date.setTime(jLongValue);
                return date;
            }
            throw new IllegalArgumentException("DateString in an unparsable format: " + dateString);
        } catch (Exception e3) {
            e3.printStackTrace();
            String simpleName = DateZonedIsoJsonTypeAdapter.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.e(simpleName, "----> " + dateString);
            CrashHelper.j(e3);
            throw e3;
        }
    }

    @Override // cz.mobilesoft.coreblock.util.typeconverter.CustomTypeJsonAdapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public String e(Date value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return DateHelperExtKt.o(value.getTime());
    }
}
