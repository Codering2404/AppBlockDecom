package com.facebook.appevents.iap;

import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
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
public final class InAppPurchaseSkuDetailsWrapper {
    private static final String CLASSNAME_SKU_DETAILS_PARAMS = "com.android.billingclient.api.SkuDetailsParams";
    private static final String CLASSNAME_SKU_DETAILS_PARAMS_BUILDER = "com.android.billingclient.api.SkuDetailsParams$Builder";
    public static final Companion Companion = new Companion(null);
    private static final String METHOD_BUILD = "build";
    private static final String METHOD_NEW_BUILDER = "newBuilder";
    private static final String METHOD_SET_SKU_LIST = "setSkusList";
    private static final String METHOD_SET_TYPE = "setType";
    private static InAppPurchaseSkuDetailsWrapper instance;
    private final Method buildMethod;
    private final Class<?> builderClazz;
    private final Method newBuilderMethod;
    private final Method setSkusListMethod;
    private final Method setTypeMethod;
    private final Class<?> skuDetailsParamsClazz;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final InAppPurchaseSkuDetailsWrapper createInstance() {
            Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS);
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseSkuDetailsWrapper.CLASSNAME_SKU_DETAILS_PARAMS_BUILDER);
            if (cls == null || cls2 == null) {
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, "newBuilder", new Class[0]);
            Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseSkuDetailsWrapper.METHOD_SET_TYPE, String.class);
            Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseSkuDetailsWrapper.METHOD_SET_SKU_LIST, List.class);
            Method method4 = InAppPurchaseUtils.getMethod(cls2, "build", new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null) {
                return null;
            }
            InAppPurchaseSkuDetailsWrapper.access$setInstance$cp(new InAppPurchaseSkuDetailsWrapper(cls, cls2, method, method2, method3, method4));
            return InAppPurchaseSkuDetailsWrapper.access$getInstance$cp();
        }

        @JvmStatic
        public final synchronized InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
            InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapperAccess$getInstance$cp;
            inAppPurchaseSkuDetailsWrapperAccess$getInstance$cp = InAppPurchaseSkuDetailsWrapper.access$getInstance$cp();
            if (inAppPurchaseSkuDetailsWrapperAccess$getInstance$cp == null) {
                inAppPurchaseSkuDetailsWrapperAccess$getInstance$cp = createInstance();
            }
            return inAppPurchaseSkuDetailsWrapperAccess$getInstance$cp;
        }

        private Companion() {
        }
    }

    public InAppPurchaseSkuDetailsWrapper(Class<?> skuDetailsParamsClazz, Class<?> builderClazz, Method newBuilderMethod, Method setTypeMethod, Method setSkusListMethod, Method buildMethod) {
        Intrinsics.checkNotNullParameter(skuDetailsParamsClazz, "skuDetailsParamsClazz");
        Intrinsics.checkNotNullParameter(builderClazz, "builderClazz");
        Intrinsics.checkNotNullParameter(newBuilderMethod, "newBuilderMethod");
        Intrinsics.checkNotNullParameter(setTypeMethod, "setTypeMethod");
        Intrinsics.checkNotNullParameter(setSkusListMethod, "setSkusListMethod");
        Intrinsics.checkNotNullParameter(buildMethod, "buildMethod");
        this.skuDetailsParamsClazz = skuDetailsParamsClazz;
        this.builderClazz = builderClazz;
        this.newBuilderMethod = newBuilderMethod;
        this.setTypeMethod = setTypeMethod;
        this.setSkusListMethod = setSkusListMethod;
        this.buildMethod = buildMethod;
    }

    public static final /* synthetic */ InAppPurchaseSkuDetailsWrapper access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseSkuDetailsWrapper.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
            return;
        }
        try {
            instance = inAppPurchaseSkuDetailsWrapper;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseSkuDetailsWrapper.class);
        }
    }

    @JvmStatic
    public static final synchronized InAppPurchaseSkuDetailsWrapper getOrCreateInstance() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseSkuDetailsWrapper.class)) {
            return null;
        }
        try {
            return Companion.getOrCreateInstance();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseSkuDetailsWrapper.class);
            return null;
        }
    }

    public final Object getSkuDetailsParams(InAppPurchaseUtils.IAPProductType productType, List<String> list) {
        Object objInvokeMethod;
        Object objInvokeMethod2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Object objInvokeMethod3 = InAppPurchaseUtils.invokeMethod(this.skuDetailsParamsClazz, this.newBuilderMethod, null, new Object[0]);
            if (objInvokeMethod3 == null || (objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setTypeMethod, objInvokeMethod3, productType.getType())) == null || (objInvokeMethod2 = InAppPurchaseUtils.invokeMethod(this.builderClazz, this.setSkusListMethod, objInvokeMethod, list)) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(this.builderClazz, this.buildMethod, objInvokeMethod2, new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final Class<?> getSkuDetailsParamsClazz() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.skuDetailsParamsClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
