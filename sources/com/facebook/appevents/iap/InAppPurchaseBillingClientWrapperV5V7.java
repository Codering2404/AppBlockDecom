package com.facebook.appevents.iap;

import android.content.Context;
import android.util.Log;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONObject;

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
public final class InAppPurchaseBillingClientWrapperV5V7 implements InAppPurchaseBillingClientWrapper {
    private static InAppPurchaseBillingClientWrapperV5V7 instance;
    private final Object billingClient;
    private final Class<?> billingClientClazz;
    private final Method billingClientStartConnectionMethod;
    private final Class<?> billingClientStateListenerClazz;
    private final Class<?> billingResultClazz;
    private final Method billingResultGetResponseCodeMethod;
    private final Class<?> productDetailsClazz;
    private final Class<?> productDetailsResponseListenerClazz;
    private final Method productDetailsToStringMethod;
    private final Class<?> purchaseClazz;
    private final Method purchaseGetOriginalJsonMethod;
    private final Class<?> purchaseHistoryRecordClazz;
    private final Method purchaseHistoryRecordGetOriginalJsonMethod;
    private final Class<?> purchaseHistoryResponseListenerClazz;
    private final Class<?> purchasesResponseListenerClazz;
    private final Method queryProductDetailsAsyncMethod;
    private final Method queryProductDetailsParamsBuilderBuildMethod;
    private final Class<?> queryProductDetailsParamsBuilderClazz;
    private final Method queryProductDetailsParamsBuilderSetProductListMethod;
    private final Class<?> queryProductDetailsParamsClazz;
    private final Method queryProductDetailsParamsNewBuilderMethod;
    private final Method queryProductDetailsParamsProductBuilderBuildMethod;
    private final Class<?> queryProductDetailsParamsProductBuilderClazz;
    private final Method queryProductDetailsParamsProductBuilderSetProductIdMethod;
    private final Method queryProductDetailsParamsProductBuilderSetProductTypeMethod;
    private final Class<?> queryProductDetailsParamsProductClazz;
    private final Method queryProductDetailsParamsProductNewBuilderMethod;
    private final Method queryPurchaseHistoryAsyncMethod;
    private final Method queryPurchaseHistoryParamsBuilderBuildMethod;
    private final Class<?> queryPurchaseHistoryParamsBuilderClazz;
    private final Method queryPurchaseHistoryParamsBuilderSetProductTypeMethod;
    private final Class<?> queryPurchaseHistoryParamsClazz;
    private final Method queryPurchaseHistoryParamsNewBuilderMethod;
    private final Method queryPurchasesAsyncMethod;
    private final Method queryPurchasesParamsBuilderBuildMethod;
    private final Class<?> queryPurchasesParamsBuilderClazz;
    private final Method queryPurchasesParamsBuilderSetProductTypeMethod;
    private final Class<?> queryPurchasesParamsClazz;
    private final Method queryPurchasesParamsNewBuilderMethod;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = InAppPurchaseBillingClientWrapperV5V7.class.getCanonicalName();
    private static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    private static final Map<String, JSONObject> iapPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> subsPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> productDetailsMap = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion implements InvocationHandler {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> cls, Class<?> cls2, Class<?> cls3) {
            Object objInvokeMethod;
            Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_NEW_BUILDER, Context.class);
            Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_SET_LISTENER, cls3);
            Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            if (method4 == null || method2 == null || method == null || method3 == null || (objInvokeMethod = InAppPurchaseUtils.invokeMethod(cls2, method2, InAppPurchaseUtils.invokeMethod(cls, method, null, context), Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, this))) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(cls2, method4, InAppPurchaseUtils.invokeMethod(cls2, method3, objInvokeMethod, new Object[0]), new Object[0]);
        }

        public final Map<String, JSONObject> getIapPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getIapPurchaseDetailsMap$cp();
        }

        @JvmStatic
        public final synchronized InAppPurchaseBillingClientWrapperV5V7 getOrCreateInstance(Context context) {
            InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp;
            Intrinsics.checkNotNullParameter(context, "context");
            inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp = InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
            if (inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp == null) {
                inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp = createInstance(context);
            }
            return inAppPurchaseBillingClientWrapperV5V7Access$getInstance$cp;
        }

        public final Map<String, JSONObject> getProductDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getProductDetailsMap$cp();
        }

        public final Map<String, JSONObject> getSubsPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV5V7.access$getSubsPurchaseDetailsMap$cp();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m3, Object[] objArr) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(m3, "m");
            return null;
        }

        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapperV5V7.access$isServiceConnected$cp();
        }

        private Companion() {
        }

        private final InAppPurchaseBillingClientWrapperV5V7 createInstance(Context context) {
            Class<?> cls = InAppPurchaseUtils.getClass(wgbAZXYjrv.wYuWZ);
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE);
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PRODUCT_DETAILS);
            Class<?> cls4 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE_HISTORY_RECORD);
            Class<?> cls5 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS_PRODUCT);
            Class<?> cls6 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_RESULT);
            Class<?> cls7 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS);
            Class<?> cls8 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASE_HISTORY_PARAMS);
            Class<?> cls9 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASES_PARAMS);
            Class<?> cls10 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS_BUILDER);
            Class<?> cls11 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASE_HISTORY_PARAMS_BUILDER);
            Class<?> cls12 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PURCHASES_PARAMS_BUILDER);
            Class<?> cls13 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_QUERY_PRODUCT_DETAILS_PARAMS_PRODUCT_BUILDER);
            Class<?> cls14 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT_BUILDER);
            Class<?> cls15 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesUpdatedListener");
            Class<?> cls16 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
            Class<?> cls17 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PRODUCT_DETAILS_RESPONSE_LISTENER);
            Class<?> cls18 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASES_RESPONSE_LISTENER);
            Class<?> cls19 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
            if (cls == null || cls2 == null || cls3 == null || cls4 == null || cls5 == null || cls6 == null || cls7 == null || cls8 == null || cls9 == null || cls10 == null || cls11 == null || cls12 == null || cls13 == null || cls14 == null || cls15 == null || cls16 == null || cls17 == null || cls18 == null || cls19 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PURCHASES_ASYNC, cls9, cls18);
            Method method2 = InAppPurchaseUtils.getMethod(cls9, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(cls12, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(cls12, InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, String.class);
            Method method5 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, new Class[0]);
            Method method6 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PURCHASE_HISTORY_ASYNC, cls8, cls19);
            Method method7 = InAppPurchaseUtils.getMethod(cls8, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method8 = InAppPurchaseUtils.getMethod(cls11, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method9 = InAppPurchaseUtils.getMethod(cls11, InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, String.class);
            Method method10 = InAppPurchaseUtils.getMethod(cls4, InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, new Class[0]);
            Method method11 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PRODUCT_DETAILS_ASYNC, cls7, cls17);
            Method method12 = InAppPurchaseUtils.getMethod(cls7, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method13 = InAppPurchaseUtils.getMethod(cls10, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method14 = InAppPurchaseUtils.getMethod(cls10, InAppPurchaseConstants.METHOD_SET_PRODUCT_LIST, List.class);
            Method method15 = InAppPurchaseUtils.getMethod(cls5, InAppPurchaseConstants.METHOD_NEW_BUILDER, new Class[0]);
            Method method16 = InAppPurchaseUtils.getMethod(cls13, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
            Method method17 = InAppPurchaseUtils.getMethod(cls13, InAppPurchaseConstants.METHOD_SET_PRODUCT_ID, String.class);
            Method method18 = InAppPurchaseUtils.getMethod(cls13, InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, String.class);
            Method method19 = InAppPurchaseUtils.getMethod(cls3, InAppPurchaseConstants.METHOD_TO_STRING, new Class[0]);
            Method method20 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_START_CONNECTION, cls16);
            Method method21 = InAppPurchaseUtils.getMethod(cls6, InAppPurchaseConstants.METHOD_GET_RESPONSE_CODE, new Class[0]);
            if (method == null || method2 == null || method3 == null || method4 == null || method5 == null || method6 == null || method7 == null || method8 == null || method9 == null || method10 == null || method11 == null || method12 == null || method13 == null || method14 == null || method15 == null || method16 == null || method17 == null || method18 == null || method19 == null || method20 == null || method21 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Object objCreateBillingClient = createBillingClient(context, cls, cls14, cls15);
            if (objCreateBillingClient == null) {
                Log.w(InAppPurchaseBillingClientWrapperV5V7.access$getTAG$cp(), "Failed to build a Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            InAppPurchaseBillingClientWrapperV5V7.access$setInstance$cp(new InAppPurchaseBillingClientWrapperV5V7(objCreateBillingClient, cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12, cls13, cls16, cls17, cls18, cls19, method, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20, method21, null));
            return InAppPurchaseBillingClientWrapperV5V7.access$getInstance$cp();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class ListenerWrapper implements InvocationHandler {
        private Object[] wrapperArgs;

        public ListenerWrapper(Object[] objArr) {
            this.wrapperArgs = objArr;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m3, Object[] objArr) {
            Intrinsics.checkNotNullParameter(proxy, "proxy");
            Intrinsics.checkNotNullParameter(m3, "m");
            String name = m3.getName();
            if (name == null) {
                return null;
            }
            switch (name.hashCode()) {
                case -1642587947:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_PURCHASE_HISTORY_RESPONSE)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onPurchaseHistoryResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, objArr);
                        break;
                    }
                    break;
                case -1599362358:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_QUERY_PURCHASES_RESPONSE)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onQueryPurchasesResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, objArr);
                        break;
                    }
                    break;
                case -79406125:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onBillingSetupFinished(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, objArr);
                        break;
                    }
                    break;
                case 1227540564:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onBillingServiceDisconnected(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, objArr);
                        break;
                    }
                    break;
                case 1940131955:
                    if (name.equals(InAppPurchaseConstants.METHOD_ON_PRODUCT_DETAILS_RESPONSE)) {
                        InAppPurchaseBillingClientWrapperV5V7.access$onProductDetailsResponse(InAppPurchaseBillingClientWrapperV5V7.this, this.wrapperArgs, objArr);
                        break;
                    }
                    break;
            }
            return null;
        }
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapperV5V7(Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Class cls8, Class cls9, Class cls10, Class cls11, Class cls12, Class cls13, Class cls14, Class cls15, Class cls16, Class cls17, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20, Method method21, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, cls8, cls9, cls10, cls11, cls12, cls13, cls14, cls15, cls16, cls17, method, method2, method3, method4, method5, method6, method7, method8, method9, method10, method11, method12, method13, method14, method15, method16, method17, method18, method19, method20, method21);
    }

    public static final /* synthetic */ Map access$getIapPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return iapPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapperV5V7 access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getProductDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return productDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSubsPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return subsPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$isServiceConnected$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return isServiceConnected;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$onBillingServiceDisconnected(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onBillingServiceDisconnected(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onBillingSetupFinished(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onBillingSetupFinished(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onProductDetailsResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onProductDetailsResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onPurchaseHistoryResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onPurchaseHistoryResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$onQueryPurchasesResponse(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7, Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV5V7.onQueryPurchasesResponse(objArr, objArr2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseBillingClientWrapperV5V7 inAppPurchaseBillingClientWrapperV5V7) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            instance = inAppPurchaseBillingClientWrapperV5V7;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    private final void executeServiceRequest(Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (isServiceConnected.get()) {
                runnable.run();
            } else {
                startConnection(runnable);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final synchronized InAppPurchaseBillingClientWrapperV5V7 getOrCreateInstance(Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return null;
        }
        try {
            return Companion.getOrCreateInstance(context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
            return null;
        }
    }

    private final Object getQueryProductDetailsParams(InAppPurchaseUtils.IAPProductType iAPProductType, List<String> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductTypeMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductBuilderClazz, this.queryProductDetailsParamsProductBuilderSetProductIdMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsProductClazz, this.queryProductDetailsParamsProductNewBuilderMethod, null, new Object[0]), str), iAPProductType.getType()), new Object[0]);
                if (objInvokeMethod != null) {
                    arrayList.add(objInvokeMethod);
                }
            }
            return InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsBuilderClazz, this.queryProductDetailsParamsBuilderSetProductListMethod, InAppPurchaseUtils.invokeMethod(this.queryProductDetailsParamsClazz, this.queryProductDetailsParamsNewBuilderMethod, null, new Object[0]), arrayList), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object getQueryPurchaseHistoryParams(InAppPurchaseUtils.IAPProductType iAPProductType) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsBuilderClazz, this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchaseHistoryParamsClazz, this.queryPurchaseHistoryParamsNewBuilderMethod, null, new Object[0]), iAPProductType.getType()), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Object getQueryPurchasesParams(InAppPurchaseUtils.IAPProductType iAPProductType) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsClazz, this.queryPurchasesParamsNewBuilderMethod, null, new Object[0]);
            if (objInvokeMethod == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsBuilderClazz, this.queryPurchasesParamsBuilderBuildMethod, InAppPurchaseUtils.invokeMethod(this.queryPurchasesParamsBuilderClazz, this.queryPurchasesParamsBuilderSetProductTypeMethod, objInvokeMethod, iAPProductType.getType()), new Object[0]);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void onBillingServiceDisconnected(Object[] objArr, Object[] objArr2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            isServiceConnected.set(false);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void onBillingSetupFinished(Object[] objArr, Object[] objArr2) {
        Runnable runnable;
        if (CrashShieldHandler.isObjectCrashing(this) || objArr2 == null) {
            return;
        }
        try {
            if (objArr2.length == 0) {
                return;
            }
            if (Intrinsics.areEqual(InAppPurchaseUtils.invokeMethod(this.billingResultClazz, this.billingResultGetResponseCodeMethod, objArr2[0], new Object[0]), (Object) 0)) {
                isServiceConnected.set(true);
                if (objArr != null && objArr.length != 0) {
                    Object obj = objArr[0];
                    if (!(obj instanceof Runnable) || (runnable = (Runnable) obj) == null) {
                        return;
                    }
                    runnable.run();
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void onProductDetailsResponse(Object[] objArr, Object[] objArr2) {
        Object orNull;
        String originalJson;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (objArr != null) {
            try {
                orNull = ArraysKt.getOrNull(objArr, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        } else {
            orNull = null;
        }
        Object orNull2 = objArr2 != null ? ArraysKt.getOrNull(objArr2, 1) : null;
        if (orNull2 != null && (orNull2 instanceof List)) {
            Iterator it = ((List) orNull2).iterator();
            while (it.hasNext()) {
                try {
                    Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.productDetailsClazz, this.productDetailsToStringMethod, it.next(), new Object[0]);
                    String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                    if (str != null && (originalJson = getOriginalJson(str)) != null) {
                        JSONObject jSONObject = new JSONObject(originalJson);
                        if (jSONObject.has("productId")) {
                            String productId = jSONObject.getString("productId");
                            Map<String, JSONObject> map = productDetailsMap;
                            Intrinsics.checkNotNullExpressionValue(productId, "productId");
                            map.put(productId, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            if (orNull == null || !(orNull instanceof Runnable)) {
                return;
            }
            ((Runnable) orNull).run();
        }
    }

    private final void onPurchaseHistoryResponse(Object[] objArr, Object[] objArr2) {
        Object orNull;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (objArr != null) {
            try {
                orNull = ArraysKt.getOrNull(objArr, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        } else {
            orNull = null;
        }
        if (orNull != null && (orNull instanceof InAppPurchaseUtils.IAPProductType)) {
            Object orNull2 = ArraysKt.getOrNull(objArr, 1);
            if (orNull2 instanceof Runnable) {
                Object orNull3 = objArr2 != null ? ArraysKt.getOrNull(objArr2, 1) : null;
                if (orNull3 != null && (orNull3 instanceof List)) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((List) orNull3).iterator();
                    while (it.hasNext()) {
                        try {
                            Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseHistoryRecordClazz, this.purchaseHistoryRecordGetOriginalJsonMethod, it.next(), new Object[0]);
                            String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                            if (str != null) {
                                JSONObject jSONObject = new JSONObject(str);
                                if (jSONObject.has("productId")) {
                                    String productId = jSONObject.getString("productId");
                                    if (!productDetailsMap.containsKey(productId)) {
                                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                        arrayList.add(productId);
                                    }
                                    if (orNull == InAppPurchaseUtils.IAPProductType.INAPP) {
                                        Map<String, JSONObject> map = iapPurchaseDetailsMap;
                                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                        map.put(productId, jSONObject);
                                    } else {
                                        Map<String, JSONObject> map2 = subsPurchaseDetailsMap;
                                        Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                        map2.put(productId, jSONObject);
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ((Runnable) orNull2).run();
                    } else {
                        queryProductDetailsAsync((InAppPurchaseUtils.IAPProductType) orNull, arrayList, (Runnable) orNull2);
                    }
                }
            }
        }
    }

    private final void onQueryPurchasesResponse(Object[] objArr, Object[] objArr2) {
        Object orNull;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        if (objArr != null) {
            try {
                orNull = ArraysKt.getOrNull(objArr, 0);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return;
            }
        } else {
            orNull = null;
        }
        if (orNull != null && (orNull instanceof InAppPurchaseUtils.IAPProductType)) {
            Object orNull2 = ArraysKt.getOrNull(objArr, 1);
            if (orNull2 instanceof Runnable) {
                Object orNull3 = objArr2 != null ? ArraysKt.getOrNull(objArr2, 1) : null;
                if (orNull3 != null && (orNull3 instanceof List)) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((List) orNull3).iterator();
                    while (it.hasNext()) {
                        Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this.purchaseClazz, this.purchaseGetOriginalJsonMethod, it.next(), new Object[0]);
                        String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                        if (str != null) {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("productId")) {
                                String productId = jSONObject.getString("productId");
                                if (!productDetailsMap.containsKey(productId)) {
                                    Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                    arrayList.add(productId);
                                }
                                if (orNull == InAppPurchaseUtils.IAPProductType.INAPP) {
                                    Map<String, JSONObject> map = iapPurchaseDetailsMap;
                                    Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                    map.put(productId, jSONObject);
                                } else {
                                    Map<String, JSONObject> map2 = subsPurchaseDetailsMap;
                                    Intrinsics.checkNotNullExpressionValue(productId, "productId");
                                    map2.put(productId, jSONObject);
                                }
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ((Runnable) orNull2).run();
                    } else {
                        queryProductDetailsAsync((InAppPurchaseUtils.IAPProductType) orNull, arrayList, (Runnable) orNull2);
                    }
                }
            }
        }
    }

    private final void queryProductDetailsAsync(final InAppPurchaseUtils.IAPProductType iAPProductType, final List<String> list, final Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            executeServiceRequest(new Runnable() { // from class: com.facebook.appevents.iap.k
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV5V7.queryProductDetailsAsync$lambda$2(this.f68063a, runnable, iAPProductType, list);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductDetailsAsync$lambda$2(InAppPurchaseBillingClientWrapperV5V7 this$0, Runnable completionHandler, InAppPurchaseUtils.IAPProductType productType, List productIds) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            Intrinsics.checkNotNullParameter(productType, "$productType");
            Intrinsics.checkNotNullParameter(productIds, "$productIds");
            Object objNewProxyInstance = Proxy.newProxyInstance(this$0.productDetailsResponseListenerClazz.getClassLoader(), new Class[]{this$0.productDetailsResponseListenerClazz}, this$0.new ListenerWrapper(new Object[]{completionHandler}));
            Object queryProductDetailsParams = this$0.getQueryProductDetailsParams(productType, productIds);
            if (queryProductDetailsParams != null) {
                InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.queryProductDetailsAsyncMethod, this$0.getBillingClient(), queryProductDetailsParams, objNewProxyInstance);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchaseHistory$lambda$1(InAppPurchaseBillingClientWrapperV5V7 this$0, InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(productType, "$productType");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.queryPurchaseHistoryAsyncMethod, this$0.getBillingClient(), this$0.getQueryPurchaseHistoryParams(productType), Proxy.newProxyInstance(this$0.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this$0.purchaseHistoryResponseListenerClazz}, this$0.new ListenerWrapper(new Object[]{productType, completionHandler})));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchases$lambda$0(InAppPurchaseBillingClientWrapperV5V7 this$0, InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV5V7.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(productType, "$productType");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.queryPurchasesAsyncMethod, this$0.getBillingClient(), this$0.getQueryPurchasesParams(productType), Proxy.newProxyInstance(this$0.purchasesResponseListenerClazz.getClassLoader(), new Class[]{this$0.purchasesResponseListenerClazz}, this$0.new ListenerWrapper(new Object[]{productType, completionHandler})));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV5V7.class);
        }
    }

    private final void startConnection(Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, this.billingClientStartConnectionMethod, getBillingClient(), Proxy.newProxyInstance(this.billingClientStateListenerClazz.getClassLoader(), new Class[]{this.billingClientStateListenerClazz}, new ListenerWrapper(new Object[]{runnable})));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public Object getBillingClient() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return this.billingClient;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getOriginalJson(String productDetailsString) {
        List listB;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(productDetailsString, "productDetailsString");
            MatchResult matchResultE = Regex.e(new Regex("jsonString='(.*?)'"), productDetailsString, 0, 2, null);
            if (matchResultE == null || (listB = matchResultE.b()) == null) {
                return null;
            }
            return (String) CollectionsKt.getOrNull(listB, 1);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchaseHistory(final InAppPurchaseUtils.IAPProductType productType, final Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
            executeServiceRequest(new Runnable() { // from class: com.facebook.appevents.iap.j
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV5V7.queryPurchaseHistory$lambda$1(this.f68060a, productType, completionHandler);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchases(final InAppPurchaseUtils.IAPProductType productType, final Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
            executeServiceRequest(new Runnable() { // from class: com.facebook.appevents.iap.i
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV5V7.queryPurchases$lambda$0(this.f68057a, productType, completionHandler);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private InAppPurchaseBillingClientWrapperV5V7(Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Class<?> cls8, Class<?> cls9, Class<?> cls10, Class<?> cls11, Class<?> cls12, Class<?> cls13, Class<?> cls14, Class<?> cls15, Class<?> cls16, Class<?> cls17, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, Method method8, Method method9, Method method10, Method method11, Method method12, Method method13, Method method14, Method method15, Method method16, Method method17, Method method18, Method method19, Method method20, Method method21) {
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseClazz = cls2;
        this.productDetailsClazz = cls3;
        this.purchaseHistoryRecordClazz = cls4;
        this.queryProductDetailsParamsProductClazz = cls5;
        this.billingResultClazz = cls6;
        this.queryProductDetailsParamsClazz = cls7;
        this.queryPurchaseHistoryParamsClazz = cls8;
        this.queryPurchasesParamsClazz = cls9;
        this.queryProductDetailsParamsBuilderClazz = cls10;
        this.queryPurchaseHistoryParamsBuilderClazz = cls11;
        this.queryPurchasesParamsBuilderClazz = cls12;
        this.queryProductDetailsParamsProductBuilderClazz = cls13;
        this.billingClientStateListenerClazz = cls14;
        this.productDetailsResponseListenerClazz = cls15;
        this.purchasesResponseListenerClazz = cls16;
        this.purchaseHistoryResponseListenerClazz = cls17;
        this.queryPurchasesAsyncMethod = method;
        this.queryPurchasesParamsNewBuilderMethod = method2;
        this.queryPurchasesParamsBuilderBuildMethod = method3;
        this.queryPurchasesParamsBuilderSetProductTypeMethod = method4;
        this.purchaseGetOriginalJsonMethod = method5;
        this.queryPurchaseHistoryAsyncMethod = method6;
        this.queryPurchaseHistoryParamsNewBuilderMethod = method7;
        this.queryPurchaseHistoryParamsBuilderBuildMethod = method8;
        this.queryPurchaseHistoryParamsBuilderSetProductTypeMethod = method9;
        this.purchaseHistoryRecordGetOriginalJsonMethod = method10;
        this.queryProductDetailsAsyncMethod = method11;
        this.queryProductDetailsParamsNewBuilderMethod = method12;
        this.queryProductDetailsParamsBuilderBuildMethod = method13;
        this.queryProductDetailsParamsBuilderSetProductListMethod = method14;
        this.queryProductDetailsParamsProductNewBuilderMethod = method15;
        this.queryProductDetailsParamsProductBuilderBuildMethod = method16;
        this.queryProductDetailsParamsProductBuilderSetProductIdMethod = method17;
        this.queryProductDetailsParamsProductBuilderSetProductTypeMethod = method18;
        this.productDetailsToStringMethod = method19;
        this.billingClientStartConnectionMethod = method20;
        this.billingResultGetResponseCodeMethod = method21;
    }
}
