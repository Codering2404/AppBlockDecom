package com.superwall.sdk.network.device;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DeviceHelperKt {
    public static final String asPadded(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        List listV0 = StringsKt.V0(str, new String[]{"-"}, false, 0, 6, null);
        String str3 = "";
        if (listV0.isEmpty()) {
            return "";
        }
        String str4 = (String) listV0.get(0);
        if (listV0.size() > 1) {
            List listV02 = StringsKt.V0((CharSequence) listV0.get(1), new String[]{"."}, false, 0, 6, null);
            str2 = "-" + listV02.get(0);
            if (listV02.size() > 1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                Locale locale = Locale.US;
                Integer numU = StringsKt.u((String) listV02.get(1));
                String str5 = String.format(locale, "%03d", Arrays.copyOf(new Object[]{Integer.valueOf(numU != null ? numU.intValue() : 0)}, 1));
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                str2 = str2 + "." + str5;
            }
        } else {
            str2 = "";
        }
        List listV03 = StringsKt.V0(str4, new String[]{"."}, false, 0, 6, null);
        if (!listV03.isEmpty()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
            Locale locale2 = Locale.US;
            Integer numU2 = StringsKt.u((String) listV03.get(0));
            String str6 = String.format(locale2, "%03d", Arrays.copyOf(new Object[]{Integer.valueOf(numU2 != null ? numU2.intValue() : 0)}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            str3 = "" + str6;
        }
        if (listV03.size() > 1) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f140150a;
            Locale locale3 = Locale.US;
            Integer numU3 = StringsKt.u((String) listV03.get(1));
            String str7 = String.format(locale3, "%03d", Arrays.copyOf(new Object[]{Integer.valueOf(numU3 != null ? numU3.intValue() : 0)}, 1));
            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
            str3 = str3 + "." + str7;
        }
        if (listV03.size() > 2) {
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.f140150a;
            Locale locale4 = Locale.US;
            Integer numU4 = StringsKt.u((String) listV03.get(2));
            String str8 = String.format(locale4, "%03d", Arrays.copyOf(new Object[]{Integer.valueOf(numU4 != null ? numU4.intValue() : 0)}, 1));
            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
            str3 = str3 + "." + str8;
        }
        return str3 + str2;
    }
}
