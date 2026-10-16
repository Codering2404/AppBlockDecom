package com.facebook.appevents.iap;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
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
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
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
public final class InAppPurchaseBillingClientWrapperV2V4 implements InAppPurchaseBillingClientWrapper {
    private static InAppPurchaseBillingClientWrapperV2V4 instance;
    private final Object billingClient;
    private final Class<?> billingClientClazz;
    private final Method getOriginalJsonMethod;
    private final Method getOriginalJsonPurchaseHistoryMethod;
    private final Method getOriginalJsonSkuMethod;
    private final Method getPurchaseListMethod;
    private final InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper;
    private final Class<?> purchaseClazz;
    private final Class<?> purchaseHistoryRecordClazz;
    private final Class<?> purchaseHistoryResponseListenerClazz;
    private final Class<?> purchaseResultClazz;
    private final Method queryPurchaseHistoryAsyncMethod;
    private final Method queryPurchasesMethod;
    private final Method querySkuDetailsAsyncMethod;
    private final Class<?> skuDetailsClazz;
    private final Class<?> skuDetailsResponseListenerClazz;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = InAppPurchaseBillingClientWrapperV2V4.class.getCanonicalName();
    private static final AtomicBoolean isServiceConnected = new AtomicBoolean(false);
    private static final Map<String, JSONObject> iapPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> subsPurchaseDetailsMap = new ConcurrentHashMap();
    private static final Map<String, JSONObject> skuDetailsMap = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object createBillingClient(Context context, Class<?> cls) {
            Object objInvokeMethod;
            Object objInvokeMethod2;
            Object objInvokeMethod3;
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT_BUILDER);
            Class<?> cls3 = InAppPurchaseUtils.getClass("com.android.billingclient.api.PurchasesUpdatedListener");
            if (cls2 != null && cls3 != null) {
                Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_NEW_BUILDER, Context.class);
                Method method2 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, new Class[0]);
                Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_SET_LISTENER, cls3);
                Method method4 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_BUILD, new Class[0]);
                if (method == null || method2 == null || method3 == null || method4 == null || (objInvokeMethod = InAppPurchaseUtils.invokeMethod(cls, method, null, context)) == null || (objInvokeMethod2 = InAppPurchaseUtils.invokeMethod(cls2, method3, objInvokeMethod, Proxy.newProxyInstance(cls3.getClassLoader(), new Class[]{cls3}, new PurchasesUpdatedListenerWrapper()))) == null || (objInvokeMethod3 = InAppPurchaseUtils.invokeMethod(cls2, method2, objInvokeMethod2, new Object[0])) == null) {
                    return null;
                }
                return InAppPurchaseUtils.invokeMethod(cls2, method4, objInvokeMethod3, new Object[0]);
            }
            return null;
        }

        private final InAppPurchaseBillingClientWrapperV2V4 createInstance(Context context) {
            InAppPurchaseSkuDetailsWrapper orCreateInstance = InAppPurchaseSkuDetailsWrapper.Companion.getOrCreateInstance();
            if (orCreateInstance == null) {
                return null;
            }
            Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT);
            Class<?> cls2 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE);
            Class<?> cls3 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASES_RESULT);
            Class<?> cls4 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_SKU_DETAILS);
            Class<?> cls5 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE_HISTORY_RECORD);
            Class<?> cls6 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_SKU_DETAILS_RESPONSE_LISTENER);
            Class<?> cls7 = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_PURCHASE_HISTORY_RESPONSE_LISTENER);
            if (cls == null || cls3 == null || cls2 == null || cls4 == null || cls6 == null || cls5 == null || cls7 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV2V4.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Method method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PURCHASES, String.class);
            Method method2 = InAppPurchaseUtils.getMethod(cls3, InAppPurchaseConstants.METHOD_GET_PURCHASE_LIST, new Class[0]);
            Method method3 = InAppPurchaseUtils.getMethod(cls2, InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, new Class[0]);
            Method method4 = InAppPurchaseUtils.getMethod(cls4, InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, new Class[0]);
            Method method5 = InAppPurchaseUtils.getMethod(cls5, InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, new Class[0]);
            Method method6 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_SKU_DETAILS_ASYNC, orCreateInstance.getSkuDetailsParamsClazz(), cls6);
            Method method7 = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_QUERY_PURCHASE_HISTORY_ASYNC, String.class, cls7);
            if (method == null || method2 == null || method3 == null || method4 == null || method5 == null || method6 == null || method7 == null) {
                Log.w(InAppPurchaseBillingClientWrapperV2V4.access$getTAG$cp(), "Failed to create Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            Object objCreateBillingClient = createBillingClient(context, cls);
            if (objCreateBillingClient == null) {
                Log.w(InAppPurchaseBillingClientWrapperV2V4.access$getTAG$cp(), "Failed to build a Google Play billing library wrapper for in-app purchase auto-logging");
                return null;
            }
            InAppPurchaseBillingClientWrapperV2V4.access$setInstance$cp(new InAppPurchaseBillingClientWrapperV2V4(objCreateBillingClient, cls, cls3, cls2, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, orCreateInstance, null));
            return InAppPurchaseBillingClientWrapperV2V4.access$getInstance$cp();
        }

        public final Map<String, JSONObject> getIapPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV2V4.access$getIapPurchaseDetailsMap$cp();
        }

        @JvmStatic
        public final synchronized InAppPurchaseBillingClientWrapperV2V4 getOrCreateInstance(Context context) {
            InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4Access$getInstance$cp;
            Intrinsics.checkNotNullParameter(context, "context");
            inAppPurchaseBillingClientWrapperV2V4Access$getInstance$cp = InAppPurchaseBillingClientWrapperV2V4.access$getInstance$cp();
            if (inAppPurchaseBillingClientWrapperV2V4Access$getInstance$cp == null) {
                inAppPurchaseBillingClientWrapperV2V4Access$getInstance$cp = createInstance(context);
            }
            return inAppPurchaseBillingClientWrapperV2V4Access$getInstance$cp;
        }

        public final Map<String, JSONObject> getSkuDetailsMap() {
            return InAppPurchaseBillingClientWrapperV2V4.access$getSkuDetailsMap$cp();
        }

        public final Map<String, JSONObject> getSubsPurchaseDetailsMap() {
            return InAppPurchaseBillingClientWrapperV2V4.access$getSubsPurchaseDetailsMap$cp();
        }

        public final AtomicBoolean isServiceConnected() {
            return InAppPurchaseBillingClientWrapperV2V4.access$isServiceConnected$cp();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class PurchaseHistoryResponseListenerWrapper implements InvocationHandler {
        private Runnable completionHandler;
        private InAppPurchaseUtils.IAPProductType skuType;
        final /* synthetic */ InAppPurchaseBillingClientWrapperV2V4 this$0;

        public PurchaseHistoryResponseListenerWrapper(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4, InAppPurchaseUtils.IAPProductType skuType, Runnable completionHandler) {
            Intrinsics.checkNotNullParameter(skuType, "skuType");
            Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
            this.this$0 = inAppPurchaseBillingClientWrapperV2V4;
            this.skuType = skuType;
            this.completionHandler = completionHandler;
        }

        @Override // java.lang.reflect.InvocationHandler
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                invoke(obj, method, objArr);
                return Unit.f139807a;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public void invoke(Object proxy, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(proxy, "proxy");
                Intrinsics.checkNotNullParameter(method, "method");
                if (Intrinsics.areEqual(method.getName(), InAppPurchaseConstants.METHOD_ON_PURCHASE_HISTORY_RESPONSE)) {
                    Object orNull = objArr != null ? ArraysKt.getOrNull(objArr, 1) : null;
                    if (orNull != null && (orNull instanceof List)) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = ((List) orNull).iterator();
                        while (it.hasNext()) {
                            try {
                                Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapperV2V4.access$getPurchaseHistoryRecordClazz$p(this.this$0), InAppPurchaseBillingClientWrapperV2V4.access$getGetOriginalJsonPurchaseHistoryMethod$p(this.this$0), it.next(), new Object[0]);
                                String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                                if (str != null) {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (jSONObject.has("productId")) {
                                        String skuID = jSONObject.getString("productId");
                                        Intrinsics.checkNotNullExpressionValue(skuID, "skuID");
                                        arrayList.add(skuID);
                                        if (this.skuType == InAppPurchaseUtils.IAPProductType.INAPP) {
                                            InAppPurchaseBillingClientWrapperV2V4.Companion.getIapPurchaseDetailsMap().put(skuID, jSONObject);
                                        } else {
                                            InAppPurchaseBillingClientWrapperV2V4.Companion.getSubsPurchaseDetailsMap().put(skuID, jSONObject);
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                        if (arrayList.isEmpty()) {
                            this.completionHandler.run();
                        } else {
                            InAppPurchaseBillingClientWrapperV2V4.access$querySkuDetailsAsync(this.this$0, this.skuType, arrayList, this.completionHandler);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PurchasesUpdatedListenerWrapper implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method m3, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(proxy, "proxy");
                Intrinsics.checkNotNullParameter(m3, "m");
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class SkuDetailsResponseListenerWrapper implements InvocationHandler {
        private Runnable completionHandler;
        final /* synthetic */ InAppPurchaseBillingClientWrapperV2V4 this$0;

        public SkuDetailsResponseListenerWrapper(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4, Runnable completionHandler) {
            Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
            this.this$0 = inAppPurchaseBillingClientWrapperV2V4;
            this.completionHandler = completionHandler;
        }

        @Override // java.lang.reflect.InvocationHandler
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Method method, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                invoke(obj, method, objArr);
                return Unit.f139807a;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public void invoke(Object proxy, Method m3, Object[] objArr) {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(proxy, "proxy");
                Intrinsics.checkNotNullParameter(m3, "m");
                if (Intrinsics.areEqual(m3.getName(), InAppPurchaseConstants.METHOD_ON_SKU_DETAILS_RESPONSE)) {
                    Object orNull = objArr != null ? ArraysKt.getOrNull(objArr, 1) : null;
                    if (orNull != null && (orNull instanceof List)) {
                        Iterator it = ((List) orNull).iterator();
                        while (it.hasNext()) {
                            try {
                                Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(InAppPurchaseBillingClientWrapperV2V4.access$getSkuDetailsClazz$p(this.this$0), InAppPurchaseBillingClientWrapperV2V4.access$getGetOriginalJsonSkuMethod$p(this.this$0), it.next(), new Object[0]);
                                String str = objInvokeMethod instanceof String ? (String) objInvokeMethod : null;
                                if (str != null) {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (jSONObject.has("productId")) {
                                        String skuID = jSONObject.getString("productId");
                                        Map<String, JSONObject> skuDetailsMap = InAppPurchaseBillingClientWrapperV2V4.Companion.getSkuDetailsMap();
                                        Intrinsics.checkNotNullExpressionValue(skuID, "skuID");
                                        skuDetailsMap.put(skuID, jSONObject);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                        this.completionHandler.run();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public /* synthetic */ InAppPurchaseBillingClientWrapperV2V4(Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, inAppPurchaseSkuDetailsWrapper);
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonPurchaseHistoryMethod$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapperV2V4.getOriginalJsonPurchaseHistoryMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ Method access$getGetOriginalJsonSkuMethod$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapperV2V4.getOriginalJsonSkuMethod;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getIapPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return iapPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ InAppPurchaseBillingClientWrapperV2V4 access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getPurchaseHistoryRecordClazz$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapperV2V4.purchaseHistoryRecordClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ Class access$getSkuDetailsClazz$p(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return inAppPurchaseBillingClientWrapperV2V4.skuDetailsClazz;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSkuDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return skuDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ Map access$getSubsPurchaseDetailsMap$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return subsPurchaseDetailsMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ AtomicBoolean access$isServiceConnected$cp() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return isServiceConnected;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$querySkuDetailsAsync(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4, InAppPurchaseUtils.IAPProductType iAPProductType, List list, Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return;
        }
        try {
            inAppPurchaseBillingClientWrapperV2V4.querySkuDetailsAsync(iAPProductType, list, runnable);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(InAppPurchaseBillingClientWrapperV2V4 inAppPurchaseBillingClientWrapperV2V4) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return;
        }
        try {
            instance = inAppPurchaseBillingClientWrapperV2V4;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
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
    public static final synchronized InAppPurchaseBillingClientWrapperV2V4 getOrCreateInstance(Context context) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return null;
        }
        try {
            return Companion.getOrCreateInstance(context);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchaseHistory$lambda$2(InAppPurchaseBillingClientWrapperV2V4 this$0, InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(productType, "$productType");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.queryPurchaseHistoryAsyncMethod, this$0.getBillingClient(), productType.getType(), Proxy.newProxyInstance(this$0.purchaseHistoryResponseListenerClazz.getClassLoader(), new Class[]{this$0.purchaseHistoryResponseListenerClazz}, new PurchaseHistoryResponseListenerWrapper(this$0, productType, completionHandler)));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchases$lambda$0(InAppPurchaseBillingClientWrapperV2V4 this$0, InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(productType, "$productType");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            Object objInvokeMethod = InAppPurchaseUtils.invokeMethod(this$0.purchaseResultClazz, this$0.getPurchaseListMethod, InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.queryPurchasesMethod, this$0.getBillingClient(), productType.getType()), new Object[0]);
            List list = objInvokeMethod instanceof List ? (List) objInvokeMethod : null;
            try {
                ArrayList arrayList = new ArrayList();
                if (list == null) {
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object objInvokeMethod2 = InAppPurchaseUtils.invokeMethod(this$0.purchaseClazz, this$0.getOriginalJsonMethod, it.next(), new Object[0]);
                    String str = objInvokeMethod2 instanceof String ? (String) objInvokeMethod2 : null;
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("productId")) {
                            String skuID = jSONObject.getString("productId");
                            arrayList.add(skuID);
                            if (productType == InAppPurchaseUtils.IAPProductType.INAPP) {
                                Map<String, JSONObject> map = iapPurchaseDetailsMap;
                                Intrinsics.checkNotNullExpressionValue(skuID, "skuID");
                                map.put(skuID, jSONObject);
                            } else {
                                Map<String, JSONObject> map2 = subsPurchaseDetailsMap;
                                Intrinsics.checkNotNullExpressionValue(skuID, "skuID");
                                map2.put(skuID, jSONObject);
                            }
                        }
                    }
                }
                this$0.querySkuDetailsAsync(productType, arrayList, completionHandler);
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
        }
    }

    private final void querySkuDetailsAsync(final InAppPurchaseUtils.IAPProductType iAPProductType, final List<String> list, final Runnable runnable) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            executeServiceRequest(new Runnable() { // from class: com.facebook.appevents.iap.g
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV2V4.querySkuDetailsAsync$lambda$1(this.f68050a, runnable, iAPProductType, list);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void querySkuDetailsAsync$lambda$1(InAppPurchaseBillingClientWrapperV2V4 this$0, Runnable completionHandler, InAppPurchaseUtils.IAPProductType skuType, List skuIDs) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseBillingClientWrapperV2V4.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(completionHandler, "$completionHandler");
            Intrinsics.checkNotNullParameter(skuType, "$skuType");
            Intrinsics.checkNotNullParameter(skuIDs, "$skuIDs");
            Object objNewProxyInstance = Proxy.newProxyInstance(this$0.skuDetailsResponseListenerClazz.getClassLoader(), new Class[]{this$0.skuDetailsResponseListenerClazz}, new SkuDetailsResponseListenerWrapper(this$0, completionHandler));
            InAppPurchaseUtils.invokeMethod(this$0.billingClientClazz, this$0.querySkuDetailsAsyncMethod, this$0.getBillingClient(), this$0.inAppPurchaseSkuDetailsWrapper.getSkuDetailsParams(skuType, skuIDs), objNewProxyInstance);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseBillingClientWrapperV2V4.class);
        }
    }

    private final void startConnection(Runnable runnable) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_CLIENT_STATE_LISTENER);
            if (cls == null || (method = InAppPurchaseUtils.getMethod(this.billingClientClazz, InAppPurchaseConstants.METHOD_START_CONNECTION, cls)) == null) {
                return;
            }
            InAppPurchaseUtils.invokeMethod(this.billingClientClazz, method, getBillingClient(), Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BillingClientStateListenerWrapper(runnable)));
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

    @Override // com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper
    public void queryPurchaseHistory(final InAppPurchaseUtils.IAPProductType productType, final Runnable completionHandler) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(productType, "productType");
            Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
            executeServiceRequest(new Runnable() { // from class: com.facebook.appevents.iap.f
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV2V4.queryPurchaseHistory$lambda$2(this.f68047a, productType, completionHandler);
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
            executeServiceRequest(new Runnable() { // from class: com.facebook.appevents.iap.h
                @Override // java.lang.Runnable
                public final void run() {
                    InAppPurchaseBillingClientWrapperV2V4.queryPurchases$lambda$0(this.f68054a, productType, completionHandler);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BillingClientStateListenerWrapper implements InvocationHandler {
        private final Runnable runnable;

        public BillingClientStateListenerWrapper(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method m3, Object[] objArr) {
            Object orNull;
            Method method;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return null;
            }
            try {
                Intrinsics.checkNotNullParameter(obj, qRMDmh.drxioycBsVxL);
                Intrinsics.checkNotNullParameter(m3, "m");
                if (Intrinsics.areEqual(m3.getName(), InAppPurchaseConstants.METHOD_ON_BILLING_SETUP_FINISHED)) {
                    if (objArr != null) {
                        orNull = ArraysKt.getOrNull(objArr, 0);
                    } else {
                        orNull = null;
                    }
                    Class<?> cls = InAppPurchaseUtils.getClass(InAppPurchaseConstants.CLASSNAME_BILLING_RESULT);
                    if (cls != null && (method = InAppPurchaseUtils.getMethod(cls, InAppPurchaseConstants.METHOD_GET_RESPONSE_CODE, new Class[0])) != null && Intrinsics.areEqual(InAppPurchaseUtils.invokeMethod(cls, method, orNull, new Object[0]), (Object) 0)) {
                        InAppPurchaseBillingClientWrapperV2V4.Companion.isServiceConnected().set(true);
                        Runnable runnable = this.runnable;
                        if (runnable != null) {
                            runnable.run();
                        }
                    }
                } else {
                    String name = m3.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "m.name");
                    if (StringsKt.E(name, InAppPurchaseConstants.METHOD_ON_BILLING_SERVICE_DISCONNECTED, false, 2, null)) {
                        InAppPurchaseBillingClientWrapperV2V4.Companion.isServiceConnected().set(false);
                    }
                }
                return null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
                return null;
            }
        }
    }

    private InAppPurchaseBillingClientWrapperV2V4(Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, InAppPurchaseSkuDetailsWrapper inAppPurchaseSkuDetailsWrapper) {
        this.billingClient = obj;
        this.billingClientClazz = cls;
        this.purchaseResultClazz = cls2;
        this.purchaseClazz = cls3;
        this.skuDetailsClazz = cls4;
        this.purchaseHistoryRecordClazz = cls5;
        this.skuDetailsResponseListenerClazz = cls6;
        this.purchaseHistoryResponseListenerClazz = cls7;
        this.queryPurchasesMethod = method;
        this.getPurchaseListMethod = method2;
        this.getOriginalJsonMethod = method3;
        this.getOriginalJsonSkuMethod = method4;
        this.getOriginalJsonPurchaseHistoryMethod = method5;
        this.querySkuDetailsAsyncMethod = method6;
        this.queryPurchaseHistoryAsyncMethod = method7;
        this.inAppPurchaseSkuDetailsWrapper = inAppPurchaseSkuDetailsWrapper;
    }
}
