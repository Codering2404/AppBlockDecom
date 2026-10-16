package com.appsflyer.internal;

import android.app.Activity;
import android.content.Context;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface AFb1iSDK {
    public static final AFa1xSDK AFa1xSDK = AFa1xSDK.AFInAppEventParameterName;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AFa1vSDK {
        void AFInAppEventType(Activity activity);

        void AFInAppEventType(Context context);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AFa1xSDK {
        static final /* synthetic */ AFa1xSDK AFInAppEventParameterName = new AFa1xSDK();
        private static long AFKeystoreWrapper = 500;

        private AFa1xSDK() {
        }

        public static long AFKeystoreWrapper() {
            return AFKeystoreWrapper;
        }
    }

    void AFKeystoreWrapper(Context context);

    boolean AFKeystoreWrapper();

    void valueOf(Context context, AFa1vSDK aFa1vSDK);
}
