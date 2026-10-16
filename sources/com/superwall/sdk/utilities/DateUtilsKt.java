package com.superwall.sdk.utilities;

import java.text.SimpleDateFormat;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DateUtilsKt {
    private static final SimpleDateFormat DateFormatterUtil = dateFormat$default(null, 1, null);

    public static final SimpleDateFormat dateFormat(String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new SimpleDateFormat(format, Locale.US);
    }

    public static /* synthetic */ SimpleDateFormat dateFormat$default(String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = DateUtils.INSTANCE.getISO_MILLIS();
        }
        return dateFormat(str);
    }

    public static final SimpleDateFormat getDateFormatterUtil() {
        return DateFormatterUtil;
    }

    public static final SimpleDateFormat localizedDateFormat(String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return new SimpleDateFormat(format, Locale.getDefault());
    }

    public static /* synthetic */ SimpleDateFormat localizedDateFormat$default(String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = DateUtils.INSTANCE.getMMM_dd_yyyy();
        }
        return localizedDateFormat(str);
    }
}
