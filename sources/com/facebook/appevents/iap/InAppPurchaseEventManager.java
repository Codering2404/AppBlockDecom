package com.facebook.appevents.iap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    public static final InAppPurchaseEventManager INSTANCE = new InAppPurchaseEventManager();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);

    private InAppPurchaseEventManager() {
    }

    @JvmStatic
    public static final Object asInterface(Context context, IBinder iBinder) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            return INSTANCE.invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, null, new Object[]{iBinder});
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void clearSkuDetailsCache() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences = skuDetailSharedPrefs;
            long j3 = sharedPreferences.getLong(LAST_CLEARED_TIME, 0L);
            if (j3 == 0) {
                sharedPreferences.edit().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
            } else if (jCurrentTimeMillis - j3 > 604800) {
                sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, jCurrentTimeMillis).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
        }
    }

    private final ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList<String> arrayList2 = new ArrayList<>();
            SharedPreferences.Editor editorEdit = purchaseInappSharedPrefs.edit();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                String str = arrayList.get(i3);
                i3++;
                String str2 = str;
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("productId");
                    long j3 = jSONObject.getLong(Constants.GP_IAP_PURCHASE_TIME);
                    String string2 = jSONObject.getString("purchaseToken");
                    if (jCurrentTimeMillis - (j3 / 1000) <= 86400 && !Intrinsics.areEqual(purchaseInappSharedPrefs.getString(string, ""), string2)) {
                        editorEdit.putString(string, string2);
                        arrayList2.add(str2);
                    }
                } catch (JSONException unused) {
                }
            }
            editorEdit.apply();
            return arrayList2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Class<?> getClass(Context context, String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap<String, Class<?>> map = classMap;
            Class<?> cls = map.get(str);
            if (cls != null) {
                return cls;
            }
            Class<?> classFromContext$facebook_core_release = InAppPurchaseUtils.getClassFromContext$facebook_core_release(context, str);
            if (classFromContext$facebook_core_release == null) {
                return classFromContext$facebook_core_release;
            }
            map.put(str, classFromContext$facebook_core_release);
            return classFromContext$facebook_core_release;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.reflect.Method getMethod(java.lang.Class<?> r8, java.lang.String r9) {
        /*
            r7 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r7)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r0 = com.facebook.appevents.iap.InAppPurchaseEventManager.methodMap     // Catch: java.lang.Throwable -> L34
            java.lang.Object r2 = r0.get(r9)     // Catch: java.lang.Throwable -> L34
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2     // Catch: java.lang.Throwable -> L34
            if (r2 == 0) goto L13
            return r2
        L13:
            int r2 = r9.hashCode()     // Catch: java.lang.Throwable -> L34
            java.lang.Class<android.os.Bundle> r3 = android.os.Bundle.class
            java.lang.String r4 = "TYPE"
            java.lang.Class r5 = java.lang.Integer.TYPE
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            switch(r2) {
                case -1801122596: goto L68;
                case -1450694211: goto L57;
                case -1123215065: goto L47;
                case -594356707: goto L36;
                case -573310373: goto L23;
                default: goto L22;
            }
        L22:
            goto L70
        L23:
            java.lang.String r2 = "getSkuDetails"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L2c
            goto L70
        L2c:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch: java.lang.Throwable -> L34
            java.lang.Class[] r2 = new java.lang.Class[]{r5, r6, r6, r3}     // Catch: java.lang.Throwable -> L34
            goto L79
        L34:
            r8 = move-exception
            goto L95
        L36:
            java.lang.String r2 = "getPurchaseHistory"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L3f
            goto L70
        L3f:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch: java.lang.Throwable -> L34
            java.lang.Class[] r2 = new java.lang.Class[]{r5, r6, r6, r6, r3}     // Catch: java.lang.Throwable -> L34
            goto L79
        L47:
            java.lang.String r2 = "asInterface"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L50
            goto L70
        L50:
            java.lang.Class<android.os.IBinder> r2 = android.os.IBinder.class
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.Throwable -> L34
            goto L79
        L57:
            java.lang.String r2 = "isBillingSupported"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L60
            goto L70
        L60:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch: java.lang.Throwable -> L34
            java.lang.Class[] r2 = new java.lang.Class[]{r5, r6, r6}     // Catch: java.lang.Throwable -> L34
            goto L79
        L68:
            java.lang.String r2 = "getPurchases"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto L72
        L70:
            r2 = r1
            goto L79
        L72:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch: java.lang.Throwable -> L34
            java.lang.Class[] r2 = new java.lang.Class[]{r5, r6, r6, r6}     // Catch: java.lang.Throwable -> L34
        L79:
            if (r2 != 0) goto L84
            java.lang.Class[] r2 = new java.lang.Class[]{r1}     // Catch: java.lang.Throwable -> L34
            java.lang.reflect.Method r8 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r8, r9, r2)     // Catch: java.lang.Throwable -> L34
            goto L8f
        L84:
            int r3 = r2.length     // Catch: java.lang.Throwable -> L34
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)     // Catch: java.lang.Throwable -> L34
            java.lang.Class[] r2 = (java.lang.Class[]) r2     // Catch: java.lang.Throwable -> L34
            java.lang.reflect.Method r8 = com.facebook.appevents.iap.InAppPurchaseUtils.getDeclaredMethod$facebook_core_release(r8, r9, r2)     // Catch: java.lang.Throwable -> L34
        L8f:
            if (r8 == 0) goto L94
            r0.put(r9, r8)     // Catch: java.lang.Throwable -> L34
        L94:
            return r8
        L95:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getMethod(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.ArrayList<java.lang.String> getPurchaseHistory(android.content.Context r22, java.lang.Object r23, java.lang.String r24) {
        /*
            r21 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r21)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L89
            r0.<init>()     // Catch: java.lang.Throwable -> L89
            boolean r2 = r21.isBillingSupported(r22, r23, r24)     // Catch: java.lang.Throwable -> L89
            if (r2 == 0) goto La9
            r2 = 0
            r3 = r1
            r4 = r2
            r5 = r4
        L17:
            r6 = 6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L89
            java.lang.String r7 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L89
            android.os.Bundle r8 = new android.os.Bundle     // Catch: java.lang.Throwable -> L89
            r8.<init>()     // Catch: java.lang.Throwable -> L89
            r9 = r24
            java.lang.Object[] r15 = new java.lang.Object[]{r6, r7, r9, r3, r8}     // Catch: java.lang.Throwable -> L89
            java.lang.String r12 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r13 = "getPurchaseHistory"
            r10 = r21
            r11 = r22
            r14 = r23
            java.lang.Object r3 = r10.invokeMethod(r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> L89
            if (r3 == 0) goto L52
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L89
            r10 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r10
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch: java.lang.Throwable -> L89
            java.lang.String r8 = "RESPONSE_CODE"
            int r8 = r3.getInt(r8)     // Catch: java.lang.Throwable -> L89
            if (r8 != 0) goto L52
            java.lang.String r8 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r8 = r3.getStringArrayList(r8)     // Catch: java.lang.Throwable -> L89
            if (r8 != 0) goto L55
        L52:
            r16 = r1
            goto L9a
        L55:
            int r12 = r8.size()     // Catch: java.lang.Throwable -> L89
            r13 = r2
        L5a:
            if (r13 >= r12) goto L90
            java.lang.Object r14 = r8.get(r13)     // Catch: java.lang.Throwable -> L89
            int r13 = r13 + 1
            java.lang.String r14 = (java.lang.String) r14     // Catch: java.lang.Throwable -> L89
            org.json.JSONObject r15 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L89 org.json.JSONException -> L8d
            r15.<init>(r14)     // Catch: java.lang.Throwable -> L89 org.json.JSONException -> L8d
            r16 = r1
            java.lang.String r1 = "purchaseTime"
            long r17 = r15.getLong(r1)     // Catch: org.json.JSONException -> L82 java.lang.Throwable -> L85
            long r17 = r17 / r10
            long r17 = r6 - r17
            r19 = 1200(0x4b0, double:5.93E-321)
            int r1 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r1 <= 0) goto L7d
            r5 = 1
            goto L92
        L7d:
            r0.add(r14)     // Catch: org.json.JSONException -> L82 java.lang.Throwable -> L85
            int r4 = r4 + 1
        L82:
            r1 = r16
            goto L5a
        L85:
            r0 = move-exception
        L86:
            r10 = r21
            goto Laa
        L89:
            r0 = move-exception
            r16 = r1
            goto L86
        L8d:
            r16 = r1
            goto L82
        L90:
            r16 = r1
        L92:
            java.lang.String r1 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Throwable -> L85
            r3 = r1
            goto L9c
        L9a:
            r3 = r16
        L9c:
            r1 = 30
            if (r4 >= r1) goto La9
            if (r3 == 0) goto La9
            if (r5 == 0) goto La5
            goto La9
        La5:
            r1 = r16
            goto L17
        La9:
            return r0
        Laa:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r10)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchaseHistory(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    @JvmStatic
    public static final ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        InAppPurchaseEventManager inAppPurchaseEventManager;
        Class<?> cls;
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            ArrayList<String> arrayList = new ArrayList<>();
            if (obj != null && (cls = (inAppPurchaseEventManager = INSTANCE).getClass(context, IN_APP_BILLING_SERVICE)) != null && inAppPurchaseEventManager.getMethod(cls, GET_PURCHASE_HISTORY) != null) {
                return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchaseHistory(context, obj, INAPP));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r13, java.lang.Object r14, java.lang.String r15) {
        /*
            r12 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L61
            r0.<init>()     // Catch: java.lang.Throwable -> L61
            if (r14 != 0) goto L11
        Lf:
            r6 = r12
            goto L64
        L11:
            boolean r2 = r12.isBillingSupported(r13, r14, r15)     // Catch: java.lang.Throwable -> L61
            if (r2 == 0) goto Lf
            r2 = 0
            r3 = r1
        L19:
            r4 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = com.facebook.appevents.iap.InAppPurchaseEventManager.PACKAGE_NAME     // Catch: java.lang.Throwable -> L61
            java.lang.Object[] r11 = new java.lang.Object[]{r4, r5, r15, r3}     // Catch: java.lang.Throwable -> L61
            java.lang.String r8 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r9 = "getPurchases"
            r6 = r12
            r7 = r13
            r10 = r14
            java.lang.Object r13 = r6.invokeMethod(r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L53
            if (r13 == 0) goto L56
            android.os.Bundle r13 = (android.os.Bundle) r13     // Catch: java.lang.Throwable -> L53
            java.lang.String r14 = "RESPONSE_CODE"
            int r14 = r13.getInt(r14)     // Catch: java.lang.Throwable -> L53
            if (r14 != 0) goto L56
            java.lang.String r14 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r14 = r13.getStringArrayList(r14)     // Catch: java.lang.Throwable -> L53
            if (r14 == 0) goto L64
            int r3 = r14.size()     // Catch: java.lang.Throwable -> L53
            int r2 = r2 + r3
            r0.addAll(r14)     // Catch: java.lang.Throwable -> L53
            java.lang.String r14 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r13 = r13.getString(r14)     // Catch: java.lang.Throwable -> L53
            r3 = r13
            goto L57
        L53:
            r0 = move-exception
        L54:
            r13 = r0
            goto L65
        L56:
            r3 = r1
        L57:
            r13 = 30
            if (r2 >= r13) goto L64
            if (r3 != 0) goto L5e
            goto L64
        L5e:
            r13 = r7
            r14 = r10
            goto L19
        L61:
            r0 = move-exception
            r6 = r12
            goto L54
        L64:
            return r0
        L65:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.iap.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    @JvmStatic
    public static final ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, INAPP));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            InAppPurchaseEventManager inAppPurchaseEventManager = INSTANCE;
            return inAppPurchaseEventManager.filterPurchases(inAppPurchaseEventManager.getPurchases(context, obj, SUBSCRIPTION));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final Map<String, String> getSkuDetails(Context context, ArrayList<String> skuList, Object obj, boolean z2) {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(skuList, "skuList");
            Map<String, String> skuDetailsFromCache = INSTANCE.readSkuDetailsFromCache(skuList);
            ArrayList<String> arrayList = new ArrayList<>();
            int size = skuList.size();
            int i3 = 0;
            while (i3 < size) {
                String str = skuList.get(i3);
                i3++;
                String str2 = str;
                if (!skuDetailsFromCache.containsKey(str2)) {
                    arrayList.add(str2);
                }
            }
            skuDetailsFromCache.putAll(INSTANCE.getSkuDetailsFromGoogle(context, arrayList, obj, z2));
            return skuDetailsFromCache;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, InAppPurchaseEventManager.class);
            return null;
        }
    }

    private final Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Class<?> cls = getClass(context, str);
            if (cls == null || (method = getMethod(cls, str2)) == null) {
                return null;
            }
            return InAppPurchaseUtils.invokeMethod(cls, method, obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final boolean isBillingSupported(Context context, Object obj, String str) {
        if (CrashShieldHandler.isObjectCrashing(this) || obj == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            th = th;
        }
        try {
            Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
            if (objInvokeMethod != null) {
                if (((Integer) objInvokeMethod).intValue() == 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                String str = arrayList.get(i3);
                i3++;
                String sku = str;
                String string = skuDetailSharedPrefs.getString(sku, null);
                if (string != null) {
                    List listV0 = StringsKt.V0(string, new String[]{";"}, false, 2, 2, null);
                    if (jCurrentTimeMillis - Long.parseLong((String) listV0.get(0)) < 43200) {
                        Intrinsics.checkNotNullExpressionValue(sku, "sku");
                        linkedHashMap.put(sku, listV0.get(1));
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void writeSkuDetailsToCache(Map<String, String> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences.Editor editorEdit = skuDetailSharedPrefs.edit();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                editorEdit.putString(entry.getKey(), jCurrentTimeMillis + ';' + entry.getValue());
            }
            editorEdit.apply();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final boolean hasFreeTrialPeirod(String skuDetail) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(skuDetail, "skuDetail");
            try {
                String strOptString = new JSONObject(skuDetail).optString(Constants.GP_IAP_FREE_TRIAL_PERIOD);
                if (strOptString != null) {
                    if (strOptString.length() > 0) {
                        return true;
                    }
                }
            } catch (JSONException unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private final Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z2) {
        String str;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            if (obj != null && !arrayList.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
                String str2 = PACKAGE_NAME;
                if (z2) {
                    str = SUBSCRIPTION;
                } else {
                    str = INAPP;
                }
                try {
                    Object objInvokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, new Object[]{3, str2, str, bundle});
                    if (objInvokeMethod != null) {
                        Bundle bundle2 = (Bundle) objInvokeMethod;
                        if (bundle2.getInt(RESPONSE_CODE) == 0) {
                            ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                            if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                                int size = arrayList.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    String str3 = arrayList.get(i3);
                                    Intrinsics.checkNotNullExpressionValue(str3, qRMDmh.NEorZpx);
                                    String str4 = stringArrayList.get(i3);
                                    Intrinsics.checkNotNullExpressionValue(str4, "skuDetailsList[i]");
                                    linkedHashMap.put(str3, str4);
                                }
                            }
                            writeSkuDetailsToCache(linkedHashMap);
                            return linkedHashMap;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    CrashShieldHandler.handleThrowable(th, this);
                    return null;
                }
            }
            return linkedHashMap;
        } catch (Throwable th2) {
            th = th2;
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
