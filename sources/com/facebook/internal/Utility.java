package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.autofill.AutofillManager;
import android.webkit.CookieManager;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.AppLinkManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

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
public final class Utility {
    private static final String ARC_DEVICE_PATTERN = ".+_cheets|cheets_.+";
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String EXTRA_APP_EVENTS_INFO_FORMAT_VERSION = "a2";
    private static final String FACEBOOK_PROFILE_FIELDS = "id,name,first_name,middle_name,last_name";
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    private static final String HASH_ALGORITHM_SHA256 = "SHA-256";
    private static final String INSTAGRAM_PROFILE_FIELDS = "id,name,profile_picture";
    public static final String LOG_TAG = "FacebookSDK";
    private static final int REFRESH_TIME_FOR_EXTENDED_DEVICE_INFO_MILLIS = 1800000;
    private static final String URL_SCHEME = "https";
    private static final String UTF8 = "UTF-8";
    private static volatile Locale locale;
    private static volatile int numCPUCores;
    public static final Utility INSTANCE = new Utility();
    private static volatile long timestampOfLastCheck = -1;
    private static volatile long totalExternalStorageGB = -1;
    private static volatile long availableExternalStorageGB = -1;
    private static volatile String deviceTimezoneAbbreviation = "";
    private static volatile String deviceTimeZoneName = "";
    private static final String NO_CARRIER = "NoCarrier";
    private static volatile String carrierName = NO_CARRIER;
    private static volatile String versionName = "";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    private Utility() {
    }

    private final void appendAnonIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, String str, Context context) throws JSONException {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("anon_id", str);
        } else {
            if (attributionIdentifiers.isTrackingLimited()) {
                return;
            }
            jSONObject.put("anon_id", str);
        }
    }

    private final void appendAttributionIdUnderCompliance(JSONObject jSONObject, AttributionIdentifiers attributionIdentifiers, Context context) throws JSONException {
        if (Build.VERSION.SDK_INT < 31 || !isGooglePlayServicesAvailable(context)) {
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        } else {
            if (attributionIdentifiers.isTrackingLimited()) {
                return;
            }
            jSONObject.put("attribution", attributionIdentifiers.getAttributionId());
        }
    }

    @JvmStatic
    public static final <T> boolean areObjectsEqual(T t2, T t3) {
        return t2 == null ? t3 == null : Intrinsics.areEqual(t2, t3);
    }

    @JvmStatic
    public static final JSONObject awaitGetGraphMeRequestWithCache(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            return profileInformation;
        }
        GraphResponse graphResponseExecuteAndWait = INSTANCE.getGraphMeRequestWithCache(accessToken).executeAndWait();
        if (graphResponseExecuteAndWait.getError() != null) {
            return null;
        }
        return graphResponseExecuteAndWait.getJsonObject();
    }

    @JvmStatic
    public static final Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri uriBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
        return uriBuild;
    }

    private final void clearCookiesForDomain(Context context, String str) {
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        for (String str2 : (String[]) StringsKt.V0(cookie, new String[]{";"}, false, 0, 6, null).toArray(new String[0])) {
            String[] strArr = (String[]) StringsKt.V0(str2, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
            if (strArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                String str3 = strArr[0];
                int length = str3.length() - 1;
                int i3 = 0;
                boolean z2 = false;
                while (i3 <= length) {
                    boolean z3 = Intrinsics.compare((int) str3.charAt(!z2 ? i3 : length), 32) <= 0;
                    if (z2) {
                        if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z3) {
                        i3++;
                    } else {
                        z2 = true;
                    }
                }
                sb.append(str3.subSequence(i3, length + 1).toString());
                sb.append("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
                cookieManager.setCookie(str, sb.toString());
            }
        }
        cookieManager.flush();
    }

    @JvmStatic
    public static final void clearFacebookCookies(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Utility utility = INSTANCE;
            utility.clearCookiesForDomain(context, FacebookSdk.FACEBOOK_COM);
            utility.clearCookiesForDomain(context, ".facebook.com");
            utility.clearCookiesForDomain(context, "https://facebook.com");
            utility.clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @JvmStatic
    public static final String coerceValueIfNullOrEmpty(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    private final long convertBytesToGB(double d3) {
        return Math.round(d3 / 1.073741824E9d);
    }

    @JvmStatic
    public static final HashSet<String> convertJSONArrayToHashSet(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String string = jSONArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
            hashSet.add(string);
        }
        return hashSet;
    }

    @JvmStatic
    public static final List<String> convertJSONArrayToList(JSONArray jsonArray) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        try {
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String string = jsonArray.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
            }
            return arrayList;
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    @JvmStatic
    public static final Map<String, Object> convertJSONObjectToHashMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        JSONArray jSONArrayNames = jsonObject.names();
        if (jSONArrayNames != null) {
            int length = jSONArrayNames.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    String string = jSONArrayNames.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                    Object value = jsonObject.get(string);
                    if (value instanceof JSONObject) {
                        value = convertJSONObjectToHashMap((JSONObject) value);
                    }
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    map.put(string, value);
                } catch (JSONException e3) {
                    logd(LOG_TAG, "Failed to convert JSONObject to HashMap", e3);
                }
            }
        }
        return map;
    }

    @JvmStatic
    public static final Map<String, String> convertJSONObjectToStringMap(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jsonObject.keys();
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            String strOptString = jsonObject.optString(key);
            if (strOptString != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                map.put(key, strOptString);
            }
        }
        return map;
    }

    @JvmStatic
    public static final int copyAndCloseInputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            byte[] bArr = new byte[DEFAULT_STREAM_BUFFER_SIZE];
            int i3 = 0;
            while (true) {
                int i4 = bufferedInputStream.read(bArr);
                if (i4 == -1) {
                    Unit unit = Unit.f139807a;
                    CloseableKt.a(bufferedInputStream, null);
                    return i3;
                }
                outputStream.write(bArr, 0, i4);
                i3 += i4;
            }
        } finally {
        }
    }

    @JvmStatic
    public static final void disconnectQuietly(URLConnection uRLConnection) {
        if (uRLConnection == null || !(uRLConnection instanceof HttpURLConnection)) {
            return;
        }
        ((HttpURLConnection) uRLConnection).disconnect();
    }

    private final boolean externalStorageExists() {
        return Intrinsics.areEqual("mounted", Environment.getExternalStorageState());
    }

    @JvmStatic
    public static final String generateRandomString(int i3) {
        String string = new BigInteger(i3 * 5, new SecureRandom()).toString(32);
        Intrinsics.checkNotNullExpressionValue(string, "BigInteger(length * 5, r).toString(32)");
        return string;
    }

    @JvmStatic
    public static final String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        String simpleName = context.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "{\n      context.javaClass.simpleName\n    }");
        return simpleName;
    }

    @JvmStatic
    public static final String getAppName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String applicationName = FacebookSdk.getApplicationName();
            if (applicationName != null) {
                return applicationName;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i3 = applicationInfo.labelRes;
            if (i3 == 0) {
                return applicationInfo.nonLocalizedLabel.toString();
            }
            String string = context.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    @JvmStatic
    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Date getBundleLongAsDate(Bundle bundle, String str, Date dateBase) {
        long jLongValue;
        Intrinsics.checkNotNullParameter(dateBase, "dateBase");
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (obj instanceof Long) {
            jLongValue = ((Number) obj).longValue();
        } else {
            if (!(obj instanceof String)) {
                return null;
            }
            try {
                jLongValue = Long.parseLong((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return jLongValue == 0 ? new Date(Long.MAX_VALUE) : new Date(dateBase.getTime() + (jLongValue * 1000));
    }

    @JvmStatic
    public static final long getContentSize(Uri contentUri) {
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        Cursor cursorQuery = null;
        try {
            cursorQuery = FacebookSdk.getApplicationContext().getContentResolver().query(contentUri, null, null, null, null);
            if (cursorQuery == null) {
                return 0L;
            }
            int columnIndex = cursorQuery.getColumnIndex("_size");
            cursorQuery.moveToFirst();
            long j3 = cursorQuery.getLong(columnIndex);
            cursorQuery.close();
            return j3;
        } finally {
        }
    }

    @JvmStatic
    public static final Locale getCurrentLocale() {
        Locale resourceLocale = getResourceLocale();
        if (resourceLocale != null) {
            return resourceLocale;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
        return locale2;
    }

    private final String getCurrentTokenDomainWithDefault() {
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        return (currentAccessToken == null || currentAccessToken.getGraphDomain() == null) ? AccessToken.DEFAULT_GRAPH_DOMAIN : currentAccessToken.getGraphDomain();
    }

    @JvmStatic
    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.DATA_PROCESSING_OPTIONS_PREFERENCES, 0).getString(FacebookSdk.DATA_PROCESSING_OPTIONS, null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException e3) {
                    logd(LOG_TAG, "Failed to parse data processing options", e3);
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return null;
        }
    }

    @JvmStatic
    public static final String getGraphDomainFromTokenDomain(String str) {
        String facebookDomain = FacebookSdk.getFacebookDomain();
        if (str != null) {
            if (Intrinsics.areEqual(str, FacebookSdk.GAMING)) {
                return StringsKt.O(facebookDomain, FacebookSdk.FACEBOOK_COM, "fb.gg", false, 4, null);
            }
            if (Intrinsics.areEqual(str, FacebookSdk.INSTAGRAM)) {
                return StringsKt.O(facebookDomain, FacebookSdk.FACEBOOK_COM, FacebookSdk.INSTAGRAM_COM, false, 4, null);
            }
        }
        return facebookDomain;
    }

    private final GraphRequest getGraphMeRequestWithCache(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", getProfileFieldsForGraphDomain(getCurrentTokenDomainWithDefault()));
        bundle.putString("access_token", str);
        GraphRequest graphRequestNewMeRequest = GraphRequest.Companion.newMeRequest(null, null);
        graphRequestNewMeRequest.setParameters(bundle);
        graphRequestNewMeRequest.setHttpMethod(HttpMethod.GET);
        return graphRequestNewMeRequest;
    }

    @JvmStatic
    public static final void getGraphMeRequestWithCacheAsync(final String accessToken, final GraphMeRequestWithCacheCallback callback) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        JSONObject profileInformation = ProfileInformationCache.getProfileInformation(accessToken);
        if (profileInformation != null) {
            callback.onSuccess(profileInformation);
            return;
        }
        GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: com.facebook.internal.q
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                Utility.getGraphMeRequestWithCacheAsync$lambda$5(callback, accessToken, graphResponse);
            }
        };
        GraphRequest graphMeRequestWithCache = INSTANCE.getGraphMeRequestWithCache(accessToken);
        graphMeRequestWithCache.setCallback(callback2);
        graphMeRequestWithCache.executeAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGraphMeRequestWithCacheAsync$lambda$5(GraphMeRequestWithCacheCallback callback, String accessToken, GraphResponse response) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(accessToken, "$accessToken");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getError() != null) {
            callback.onFailure(response.getError().getException());
            return;
        }
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ProfileInformationCache.putProfileInformation(accessToken, jsonObject);
        callback.onSuccess(response.getJsonObject());
    }

    @JvmStatic
    public static final String getMetadataApplicationId(Context context) {
        Validate.notNull(context, "context");
        return FacebookSdk.getApplicationId();
    }

    @JvmStatic
    public static final Method getMethodQuietly(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            return clazz.getMethod(methodName, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String getProfileFieldsForGraphDomain(String str) {
        return Intrinsics.areEqual(str, FacebookSdk.INSTAGRAM) ? INSTAGRAM_PROFILE_FIELDS : FACEBOOK_PROFILE_FIELDS;
    }

    @JvmStatic
    public static final Locale getResourceLocale() {
        try {
            return FacebookSdk.getApplicationContext().getResources().getConfiguration().locale;
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Object getStringPropertyAsJSON(JSONObject jsonObject, String str, String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Object objOpt = jsonObject.opt(str);
        if (objOpt != null && (objOpt instanceof String)) {
            objOpt = new JSONTokener((String) objOpt).nextValue();
        }
        if (objOpt == null || (objOpt instanceof JSONObject) || (objOpt instanceof JSONArray)) {
            return objOpt;
        }
        if (str2 == null) {
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt(str2, objOpt);
        return jSONObject;
    }

    @JvmStatic
    public static final String getUriString(Uri uri) {
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    private final String hashBytes(MessageDigest messageDigest, byte[] bArr) {
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        Intrinsics.checkNotNullExpressionValue(digest, "digest");
        for (byte b3 : digest) {
            sb.append(Integer.toHexString((b3 >> 4) & 15));
            sb.append(Integer.toHexString(b3 & Ascii.SI));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }

    private final String hashWithAlgorithm(String str, String str2) {
        byte[] bytes = str2.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm(str, bytes);
    }

    @JvmStatic
    public static final Object invokeMethodQuietly(Object obj, Method method, Object... args) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            return method.invoke(obj, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str = String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            intent.setData(Uri.parse(str));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryInte…nager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean isAutofillAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        return autofillManager != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled();
    }

    @JvmStatic
    public static final boolean isChromeOS(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
    }

    @JvmStatic
    public static final boolean isContentUri(Uri uri) {
        return uri != null && StringsKt.F(AppLovinEventTypes.USER_VIEWED_CONTENT, uri.getScheme(), true);
    }

    @JvmStatic
    public static final boolean isCurrentAccessToken(AccessToken accessToken) {
        return accessToken != null && Intrinsics.areEqual(accessToken, AccessToken.Companion.getCurrentAccessToken());
    }

    @JvmStatic
    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray(FacebookSdk.DATA_PROCESSING_OPTIONS);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String string = jSONArray.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                    String lowerCase = string.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    if (Intrinsics.areEqual(lowerCase, "ldu")) {
                        return true;
                    }
                }
            } catch (Exception e3) {
                logd(LOG_TAG, "Failed to check data processing restriction", e3);
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utility.class);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isFileUri(Uri uri) {
        return uri != null && StringsKt.F("file", uri.getScheme(), true);
    }

    private final boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
        if (methodQuietly == null) {
            return false;
        }
        Object objInvokeMethodQuietly = invokeMethodQuietly(null, methodQuietly, context);
        return (objInvokeMethodQuietly instanceof Integer) && Intrinsics.areEqual(objInvokeMethodQuietly, (Object) 0);
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    @JvmStatic
    public static final boolean isWebUri(Uri uri) {
        if (uri != null) {
            return StringsKt.F("http", uri.getScheme(), true) || StringsKt.F("https", uri.getScheme(), true) || StringsKt.F("fbstaging", uri.getScheme(), true);
        }
        return false;
    }

    @JvmStatic
    public static final Set<String> jsonArrayToSet(JSONArray jsonArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        HashSet hashSet = new HashSet();
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String string = jsonArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
            hashSet.add(string);
        }
        return hashSet;
    }

    @JvmStatic
    public static final List<String> jsonArrayToStringList(JSONArray jsonArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        ArrayList arrayList = new ArrayList();
        int length = jsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(jsonArray.getString(i3));
        }
        return arrayList;
    }

    @JvmStatic
    public static final Map<String, String> jsonStrToMap(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String key = itKeys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String string = jSONObject.getString(key);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                map.put(key, string);
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    @JvmStatic
    public static final void logd(String str, Exception exc) {
        if (!FacebookSdk.isDebugEnabled() || str == null || exc == null) {
            return;
        }
        Log.d(str, exc.getClass().getSimpleName() + ": " + exc.getMessage());
    }

    @JvmStatic
    public static final String mapToJsonStr(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        String string = "";
        if (map.isEmpty()) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            string = jSONObject.toString();
        } catch (JSONException unused) {
        }
        Intrinsics.checkNotNullExpressionValue(string, "{\n      try {\n        va…\n        \"\"\n      }\n    }");
        return string;
    }

    @JvmStatic
    public static final String md5hash(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_MD5, key);
    }

    @JvmStatic
    public static final boolean mustFixWindowParamsForAutofill(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return isAutofillAvailable(context);
    }

    @JvmStatic
    public static final Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str == null) {
                throw new IllegalStateException("Required value was null.");
            }
            for (String str2 : (String[]) StringsKt.V0(str, new String[]{"&"}, false, 0, 6, null).toArray(new String[0])) {
                String[] strArr = (String[]) StringsKt.V0(str2, new String[]{"="}, false, 0, 6, null).toArray(new String[0]);
                try {
                    if (strArr.length == 2) {
                        bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), URLDecoder.decode(strArr[1], "UTF-8"));
                    } else if (strArr.length == 1) {
                        bundle.putString(URLDecoder.decode(strArr[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e3) {
                    logd(LOG_TAG, e3);
                }
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final void putCommaSeparatedStringList(Bundle b3, String str, List<String> list) {
        Intrinsics.checkNotNullParameter(b3, "b");
        if (list != null) {
            b3.putString(str, TextUtils.join(",", list));
        }
    }

    @JvmStatic
    public static final boolean putJSONValueInBundle(Bundle bundle, String str, Object obj) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (obj == null) {
            bundle.remove(str);
            return true;
        }
        if (obj instanceof Boolean) {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            return true;
        }
        if (obj instanceof boolean[]) {
            bundle.putBooleanArray(str, (boolean[]) obj);
            return true;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Number) obj).doubleValue());
            return true;
        }
        if (obj instanceof double[]) {
            bundle.putDoubleArray(str, (double[]) obj);
            return true;
        }
        if (obj instanceof Integer) {
            bundle.putInt(str, ((Number) obj).intValue());
            return true;
        }
        if (obj instanceof int[]) {
            bundle.putIntArray(str, (int[]) obj);
            return true;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Number) obj).longValue());
            return true;
        }
        if (obj instanceof long[]) {
            bundle.putLongArray(str, (long[]) obj);
            return true;
        }
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
            return true;
        }
        if (obj instanceof JSONArray) {
            bundle.putString(str, ((JSONArray) obj).toString());
            return true;
        }
        if (!(obj instanceof JSONObject)) {
            return false;
        }
        bundle.putString(str, ((JSONObject) obj).toString());
        return true;
    }

    @JvmStatic
    public static final void putNonEmptyString(Bundle b3, String str, String str2) {
        Intrinsics.checkNotNullParameter(b3, "b");
        if (isNullOrEmpty(str2)) {
            return;
        }
        b3.putString(str, str2);
    }

    @JvmStatic
    public static final void putUri(Bundle b3, String str, Uri uri) {
        Intrinsics.checkNotNullParameter(b3, "b");
        if (uri != null) {
            putNonEmptyString(b3, str, uri.toString());
        }
    }

    @JvmStatic
    public static final Map<String, String> readNonnullStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i3 = parcel.readInt();
        if (i3 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i4 = 0; i4 < i3; i4++) {
            String string = parcel.readString();
            String string2 = parcel.readString();
            if (string != null && string2 != null) {
                map.put(string, string2);
            }
        }
        return map;
    }

    @JvmStatic
    public static final String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new BufferedInputStream(inputStream));
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[2048];
            while (true) {
                int i3 = inputStreamReader.read(cArr);
                if (i3 == -1) {
                    String string = sb.toString();
                    CloseableKt.a(inputStreamReader, null);
                    Intrinsics.checkNotNullExpressionValue(string, "InputStreamReader(buffer…gBuilder.toString()\n    }");
                    return string;
                }
                sb.append(cArr, 0, i3);
            }
        } finally {
        }
    }

    @JvmStatic
    public static final Map<String, String> readStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i3 = parcel.readInt();
        if (i3 < 0) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i4 = 0; i4 < i3; i4++) {
            map.put(parcel.readString(), parcel.readString());
        }
        return map;
    }

    private final void refreshAvailableExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                availableExternalStorageGB = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            }
            availableExternalStorageGB = convertBytesToGB(availableExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    private final int refreshBestGuessNumberOfCPUCores() {
        if (numCPUCores > 0) {
            return numCPUCores;
        }
        try {
            File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter() { // from class: com.facebook.internal.r
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str) {
                    return Utility.refreshBestGuessNumberOfCPUCores$lambda$6(file, str);
                }
            });
            if (fileArrListFiles != null) {
                numCPUCores = fileArrListFiles.length;
            }
        } catch (Exception e3) {
            logd(LOG_TAG, "Failed to enumerate CPU cores", e3);
        }
        if (numCPUCores <= 0) {
            numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
        }
        return numCPUCores;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean refreshBestGuessNumberOfCPUCores$lambda$6(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }

    private final void refreshCarrierName(Context context) {
        if (Intrinsics.areEqual(carrierName, NO_CARRIER)) {
            try {
                Object systemService = context.getSystemService("phone");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
                String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
                carrierName = networkOperatorName;
            } catch (Exception e3) {
                logd(LOG_TAG, "Failed to refresh carrier name", e3);
            }
        }
    }

    private final void refreshPeriodicExtendedDeviceInfo(Context context) {
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            refreshTimezone();
            refreshCarrierName(context);
            refreshTotalExternalStorage();
            refreshAvailableExternalStorage();
        }
    }

    private final void refreshTimezone() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
            Intrinsics.checkNotNullExpressionValue(displayName, "tz.getDisplayName(tz.inD…(Date()), TimeZone.SHORT)");
            deviceTimezoneAbbreviation = displayName;
            String id = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id, "tz.id");
            deviceTimeZoneName = id;
        } catch (AssertionError unused) {
        } catch (Exception e3) {
            logd(LOG_TAG, "Failed to refresh timezone", e3);
        }
    }

    private final void refreshTotalExternalStorage() {
        try {
            if (externalStorageExists()) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
            }
            totalExternalStorageGB = convertBytesToGB(totalExternalStorageGB);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final String safeGetStringFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        String strOptString = jSONObject.optString(str, "");
        Intrinsics.checkNotNullExpressionValue(strOptString, "response.optString(propertyName, \"\")");
        return strOptString;
    }

    @JvmStatic
    public static final void setAppEventAttributionParameters(JSONObject params, AttributionIdentifiers attributionIdentifiers, String str, boolean z2, Context context) throws JSONException {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        FeatureManager.Feature feature = FeatureManager.Feature.ServiceUpdateCompliance;
        if (!FeatureManager.isEnabled(feature)) {
            params.put("anon_id", str);
        }
        params.put("application_tracking_enabled", !z2);
        params.put("advertiser_id_collection_enabled", FacebookSdk.getAdvertiserIDCollectionEnabled());
        if (attributionIdentifiers != null) {
            if (FeatureManager.isEnabled(feature)) {
                INSTANCE.appendAnonIdUnderCompliance(params, attributionIdentifiers, str, context);
            }
            if (attributionIdentifiers.getAttributionId() != null) {
                if (FeatureManager.isEnabled(feature)) {
                    INSTANCE.appendAttributionIdUnderCompliance(params, attributionIdentifiers, context);
                } else {
                    params.put("attribution", attributionIdentifiers.getAttributionId());
                }
            }
            if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                params.put(UserSettingsManager.ADVERTISER_ID_KEY, attributionIdentifiers.getAndroidAdvertiserId());
                params.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
            }
            if (!attributionIdentifiers.isTrackingLimited()) {
                String allHashedUserData = UserDataStore.getAllHashedUserData();
                if (allHashedUserData.length() != 0) {
                    params.put("ud", allHashedUserData);
                }
            }
            if (attributionIdentifiers.getAndroidInstallerPackage() != null) {
                params.put("installer_package", attributionIdentifiers.getAndroidInstallerPackage());
            }
        }
        AppLinkManager companion = AppLinkManager.Companion.getInstance();
        Object info = companion != null ? companion.getInfo(AppLinkManager.CAMPAIGN_IDS_KEY) : null;
        if (info != null) {
            params.put(AppLinkManager.CAMPAIGN_IDS_KEY, info);
        }
    }

    @JvmStatic
    public static final void setAppEventExtendedDeviceInfoParameters(JSONObject params, Context appContext) throws JSONException {
        Locale locale2;
        int i3;
        Display display;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(EXTRA_APP_EVENTS_INFO_FORMAT_VERSION);
        INSTANCE.refreshPeriodicExtendedDeviceInfo(appContext);
        String packageName = appContext.getPackageName();
        int i4 = 0;
        int i5 = -1;
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo == null) {
                return;
            }
            i5 = packageInfo.versionCode;
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        jSONArray.put(packageName);
        jSONArray.put(i5);
        jSONArray.put(versionName);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale2 = appContext.getResources().getConfiguration().getLocales().get(0);
        } catch (Exception unused2) {
            locale2 = Locale.getDefault();
        }
        locale = locale2;
        StringBuilder sb = new StringBuilder();
        Locale locale3 = locale;
        String language = locale3 != null ? locale3.getLanguage() : null;
        if (language == null) {
            language = "";
        }
        sb.append(language);
        sb.append('_');
        Locale locale4 = locale;
        String country = locale4 != null ? locale4.getCountry() : null;
        sb.append(country != null ? country : "");
        jSONArray.put(sb.toString());
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d3 = 0.0d;
        try {
            Object systemService = appContext.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
            DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
            display = displayManager != null ? displayManager.getDisplay(0) : null;
        } catch (Exception unused3) {
        }
        if (display != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            display.getMetrics(displayMetrics);
            int i6 = displayMetrics.widthPixels;
            try {
                i4 = displayMetrics.heightPixels;
                d3 = displayMetrics.density;
            } catch (Exception unused4) {
            }
            i3 = i4;
            i4 = i6;
        } else {
            i3 = 0;
        }
        jSONArray.put(i4);
        jSONArray.put(i3);
        jSONArray.put(new DecimalFormat("#.##").format(d3));
        jSONArray.put(INSTANCE.refreshBestGuessNumberOfCPUCores());
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        params.put(Constants.EXTINFO, jSONArray.toString());
    }

    @JvmStatic
    public static final String sha1hash(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, key);
    }

    @JvmStatic
    public static final String sha256hash(String str) {
        if (str == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, str);
    }

    @JvmStatic
    public static final boolean stringsEqualOrEmpty(String str, String str2) {
        boolean z2 = str == null || str.length() == 0;
        boolean z3 = str2 == null || str2.length() == 0;
        if (z2 && z3) {
            return true;
        }
        if (z2 || z3) {
            return false;
        }
        return Intrinsics.areEqual(str, str2);
    }

    @JvmStatic
    public static final JSONArray tryGetJSONArrayFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    @JvmStatic
    public static final JSONObject tryGetJSONObjectFromResponse(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    @JvmStatic
    public static final void writeNonnullStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    @JvmStatic
    public static final void writeStringMapToParcel(Parcel parcel, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            parcel.writeString(key);
            parcel.writeString(value);
        }
    }

    public final long getAvailableExternalStorageGB() {
        return availableExternalStorageGB;
    }

    public final String getCarrierName() {
        return carrierName;
    }

    public final String getDeviceTimeZoneName() {
        return deviceTimeZoneName;
    }

    public final Locale getLocale() {
        return locale;
    }

    public final String getVersionName() {
        return versionName;
    }

    public final void setAvailableExternalStorageGB(long j3) {
        availableExternalStorageGB = j3;
    }

    public final void setCarrierName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        carrierName = str;
    }

    public final void setDeviceTimeZoneName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        deviceTimeZoneName = str;
    }

    public final void setLocale(Locale locale2) {
        locale = locale2;
    }

    public final void setVersionName(String str) {
        versionName = str;
    }

    @JvmStatic
    public static final Method getMethodQuietly(String className, String methodName, Class<?>... parameterTypes) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            Class<?> clazz = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(clazz, "clazz");
            return getMethodQuietly(clazz, methodName, (Class<?>[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest hash = MessageDigest.getInstance(str);
            Intrinsics.checkNotNullExpressionValue(hash, "hash");
            return hashBytes(hash, bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    @JvmStatic
    public static final String sha1hash(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA1, bytes);
    }

    @JvmStatic
    public static final String sha256hash(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return INSTANCE.hashWithAlgorithm(HASH_ALGORITHM_SHA256, bArr);
    }

    @JvmStatic
    public static final void logd(String str, String str2) {
        if (!FacebookSdk.isDebugEnabled() || str == null || str2 == null) {
            return;
        }
        Log.d(str, str2);
    }

    @JvmStatic
    public static final void logd(String str, String str2, Throwable th) {
        if (!FacebookSdk.isDebugEnabled() || isNullOrEmpty(str)) {
            return;
        }
        Log.d(str, str2, th);
    }

    @JvmStatic
    public static /* synthetic */ void isAutoAppLinkSetup$annotations() {
    }
}
