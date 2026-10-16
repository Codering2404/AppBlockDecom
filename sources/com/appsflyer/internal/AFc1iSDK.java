package com.appsflyer.internal;

import android.text.TextUtils;
import com.appsflyer.AppsFlyerLib;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class AFc1iSDK extends AFb1zSDK {
    public static final AFa1xSDK AFa1xSDK = new AFa1xSDK(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AFa1xSDK {
        private AFa1xSDK() {
        }

        static String AFKeystoreWrapper(String str, String str2, String str3) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format(AFc1oSDK.AFKeystoreWrapper, AppsFlyerLib.getInstance().getHostPrefix(), AFa1bSDK.values().getHostName()));
            sb.append(str);
            sb.append(str3);
            sb.append("?device_id=");
            sb.append(str2);
            return sb.toString();
        }

        public static String valueOf(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            return AFc1rSDK.AFInAppEventParameterName(TextUtils.join("\u2063", new String[]{str5, str3, sb.toString()}), str4);
        }

        public /* synthetic */ AFa1xSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* synthetic */ AFc1iSDK(String str, Map map, byte[] bArr, String str2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i3 & 4) != 0 ? null : bArr, (i3 & 8) != 0 ? "GET" : str2, (i3 & 16) != 0 ? false : z2);
    }

    @JvmStatic
    public static final AFc1iSDK valueOf(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        String strAFKeystoreWrapper = AFa1xSDK.AFKeystoreWrapper(str, str2, str3);
        String strValueOf = String.valueOf(System.currentTimeMillis());
        AFc1iSDK aFc1iSDK = new AFc1iSDK(strAFKeystoreWrapper, MapsKt.mapOf(TuplesKt.a("Connection", "close"), TuplesKt.a("af_request_epoch_ms", strValueOf), TuplesKt.a("af_sig", AFa1xSDK.valueOf(str, str3, str2, str4, strValueOf))), null, null, false, 28, null);
        aFc1iSDK.valueOf(ColorExtractionConstants.MAX_PIXEL_SAMPLES);
        return aFc1iSDK;
    }

    private AFc1iSDK(String str, Map<String, String> map, byte[] bArr, String str2, boolean z2) {
        super(str, bArr, str2, map, z2);
    }
}
