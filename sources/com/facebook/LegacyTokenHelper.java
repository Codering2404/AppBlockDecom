package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
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
public final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    public static final String EXPIRED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.ExpiredPermissions";
    public static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    public static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    public static final String JSON_VALUE = "value";
    public static final String JSON_VALUE_ENUM_TYPE = "enumType";
    public static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    public static final String TYPE_BOOLEAN = "bool";
    public static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    public static final String TYPE_BYTE = "byte";
    public static final String TYPE_BYTE_ARRAY = "byte[]";
    public static final String TYPE_CHAR = "char";
    public static final String TYPE_CHAR_ARRAY = "char[]";
    public static final String TYPE_DOUBLE = "double";
    public static final String TYPE_DOUBLE_ARRAY = "double[]";
    public static final String TYPE_ENUM = "enum";
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_FLOAT_ARRAY = "float[]";
    public static final String TYPE_INTEGER = "int";
    public static final String TYPE_INTEGER_ARRAY = "int[]";
    public static final String TYPE_LONG = "long";
    public static final String TYPE_LONG_ARRAY = "long[]";
    public static final String TYPE_SHORT = "short";
    public static final String TYPE_SHORT_ARRAY = "short[]";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_STRING_LIST = "stringList";
    public final SharedPreferences cache;
    public final String cacheKey;
    public static final Companion Companion = new Companion(null);
    public static final String TAG = LegacyTokenHelper.class.getSimpleName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Date getDate(Bundle bundle, String str) {
            if (bundle == null) {
                return null;
            }
            long j3 = bundle.getLong(str, Long.MIN_VALUE);
            if (j3 == Long.MIN_VALUE) {
                return null;
            }
            return new Date(j3);
        }

        private final void putDate(Bundle bundle, String str, Date date) {
            bundle.putLong(str, date.getTime());
        }

        @JvmStatic
        public final String getApplicationId(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.APPLICATION_ID_KEY);
        }

        @JvmStatic
        public final Date getExpirationDate(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        public final long getExpirationMilliseconds(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY);
        }

        @JvmStatic
        public final Date getLastRefreshDate(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        public final long getLastRefreshMilliseconds(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY);
        }

        @JvmStatic
        public final Set<String> getPermissions(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            ArrayList<String> stringArrayList = bundle.getStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY);
            if (stringArrayList == null) {
                return null;
            }
            return new HashSet(stringArrayList);
        }

        @JvmStatic
        public final AccessTokenSource getSource(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.containsKey(LegacyTokenHelper.TOKEN_SOURCE_KEY) ? (AccessTokenSource) bundle.getSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY) : bundle.getBoolean(LegacyTokenHelper.IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
        }

        @JvmStatic
        public final String getToken(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return bundle.getString(LegacyTokenHelper.TOKEN_KEY);
        }

        @JvmStatic
        public final boolean hasTokenInformation(Bundle bundle) {
            String string;
            return (bundle == null || (string = bundle.getString(LegacyTokenHelper.TOKEN_KEY)) == null || string.length() == 0 || bundle.getLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, 0L) == 0) ? false : true;
        }

        @JvmStatic
        public final void putApplicationId(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putString(LegacyTokenHelper.APPLICATION_ID_KEY, str);
        }

        @JvmStatic
        public final void putDeclinedPermissions(Bundle bundle, Collection<String> value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.DECLINED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putExpirationDate(Bundle bundle, Date value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            putDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY, value);
        }

        @JvmStatic
        public final void putExpirationMilliseconds(Bundle bundle, long j3) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.EXPIRATION_DATE_KEY, j3);
        }

        @JvmStatic
        public final void putExpiredPermissions(Bundle bundle, Collection<String> value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.EXPIRED_PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putLastRefreshDate(Bundle bundle, Date value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            putDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY, value);
        }

        @JvmStatic
        public final void putLastRefreshMilliseconds(Bundle bundle, long j3) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putLong(LegacyTokenHelper.LAST_REFRESH_DATE_KEY, j3);
        }

        @JvmStatic
        public final void putPermissions(Bundle bundle, Collection<String> value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putStringArrayList(LegacyTokenHelper.PERMISSIONS_KEY, new ArrayList<>(value));
        }

        @JvmStatic
        public final void putSource(Bundle bundle, AccessTokenSource value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putSerializable(LegacyTokenHelper.TOKEN_SOURCE_KEY, value);
        }

        @JvmStatic
        public final void putToken(Bundle bundle, String value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(value, "value");
            bundle.putString(LegacyTokenHelper.TOKEN_KEY, value);
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LegacyTokenHelper(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void deserializeKey(String str, Bundle bundle) throws JSONException {
        String str2;
        String string;
        String string2 = this.cache.getString(str, JsonUtils.EMPTY_JSON);
        if (string2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        Intrinsics.checkNotNullExpressionValue(string2, "checkNotNull(cache.getString(key, \"{}\"))");
        JSONObject jSONObject = new JSONObject(string2);
        String string3 = jSONObject.getString(JSON_VALUE_TYPE);
        if (string3 != null) {
            int i3 = 0;
            switch (string3.hashCode()) {
                case -1573317553:
                    if (string3.equals(TYPE_STRING_LIST)) {
                        JSONArray jSONArray = jSONObject.getJSONArray("value");
                        int length = jSONArray.length();
                        ArrayList<String> arrayList = new ArrayList<>(length);
                        while (i3 < length) {
                            Object obj = jSONArray.get(i3);
                            if (obj == JSONObject.NULL) {
                                str2 = null;
                            } else {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                                str2 = (String) obj;
                            }
                            arrayList.add(i3, str2);
                            i3++;
                        }
                        bundle.putStringArrayList(str, arrayList);
                        return;
                    }
                    return;
                case -1383386164:
                    if (string3.equals(TYPE_BOOLEAN_ARRAY)) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("value");
                        int length2 = jSONArray2.length();
                        boolean[] zArr = new boolean[length2];
                        while (i3 < length2) {
                            zArr[i3] = jSONArray2.getBoolean(i3);
                            i3++;
                        }
                        bundle.putBooleanArray(str, zArr);
                        return;
                    }
                    return;
                case -1374008726:
                    if (string3.equals(TYPE_BYTE_ARRAY)) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray("value");
                        int length3 = jSONArray3.length();
                        byte[] bArr = new byte[length3];
                        while (i3 < length3) {
                            bArr[i3] = (byte) jSONArray3.getInt(i3);
                            i3++;
                        }
                        bundle.putByteArray(str, bArr);
                        return;
                    }
                    return;
                case -1361632968:
                    if (string3.equals(TYPE_CHAR_ARRAY)) {
                        JSONArray jSONArray4 = jSONObject.getJSONArray("value");
                        int length4 = jSONArray4.length();
                        char[] cArr = new char[length4];
                        for (int i4 = 0; i4 < length4; i4++) {
                            String string4 = jSONArray4.getString(i4);
                            if (string4 != null && string4.length() == 1) {
                                cArr[i4] = string4.charAt(0);
                            }
                        }
                        bundle.putCharArray(str, cArr);
                        return;
                    }
                    return;
                case -1325958191:
                    if (string3.equals(TYPE_DOUBLE)) {
                        bundle.putDouble(str, jSONObject.getDouble("value"));
                        return;
                    }
                    return;
                case -1097129250:
                    if (string3.equals(TYPE_LONG_ARRAY)) {
                        JSONArray jSONArray5 = jSONObject.getJSONArray("value");
                        int length5 = jSONArray5.length();
                        long[] jArr = new long[length5];
                        while (i3 < length5) {
                            jArr[i3] = jSONArray5.getLong(i3);
                            i3++;
                        }
                        bundle.putLongArray(str, jArr);
                        return;
                    }
                    return;
                case -891985903:
                    if (string3.equals(TYPE_STRING)) {
                        bundle.putString(str, jSONObject.getString("value"));
                        return;
                    }
                    return;
                case -766441794:
                    if (string3.equals(TYPE_FLOAT_ARRAY)) {
                        JSONArray jSONArray6 = jSONObject.getJSONArray("value");
                        int length6 = jSONArray6.length();
                        float[] fArr = new float[length6];
                        while (i3 < length6) {
                            fArr[i3] = (float) jSONArray6.getDouble(i3);
                            i3++;
                        }
                        bundle.putFloatArray(str, fArr);
                        return;
                    }
                    return;
                case 104431:
                    if (string3.equals(TYPE_INTEGER)) {
                        bundle.putInt(str, jSONObject.getInt("value"));
                        return;
                    }
                    return;
                case 3029738:
                    if (string3.equals(TYPE_BOOLEAN)) {
                        bundle.putBoolean(str, jSONObject.getBoolean("value"));
                        return;
                    }
                    return;
                case 3039496:
                    if (string3.equals(TYPE_BYTE)) {
                        bundle.putByte(str, (byte) jSONObject.getInt("value"));
                        return;
                    }
                    return;
                case 3052374:
                    if (string3.equals(TYPE_CHAR) && (string = jSONObject.getString("value")) != null && string.length() == 1) {
                        bundle.putChar(str, string.charAt(0));
                        return;
                    }
                    return;
                case 3118337:
                    if (string3.equals(TYPE_ENUM)) {
                        try {
                            Class<?> cls = Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE));
                            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                            bundle.putSerializable(str, Enum.valueOf(cls, jSONObject.getString("value")));
                            return;
                        } catch (ClassNotFoundException e3) {
                            Utility.logd(TAG, "Failed to deserialize enum type", e3);
                            return;
                        } catch (IllegalArgumentException e4) {
                            Utility.logd(TAG, "Failed to deserialize enum value", e4);
                            return;
                        }
                    }
                    return;
                case 3327612:
                    if (string3.equals(TYPE_LONG)) {
                        bundle.putLong(str, jSONObject.getLong("value"));
                        return;
                    }
                    return;
                case 97526364:
                    if (string3.equals(TYPE_FLOAT)) {
                        bundle.putFloat(str, (float) jSONObject.getDouble("value"));
                        return;
                    }
                    return;
                case 100361105:
                    if (string3.equals(TYPE_INTEGER_ARRAY)) {
                        JSONArray jSONArray7 = jSONObject.getJSONArray("value");
                        int length7 = jSONArray7.length();
                        int[] iArr = new int[length7];
                        while (i3 < length7) {
                            iArr[i3] = jSONArray7.getInt(i3);
                            i3++;
                        }
                        bundle.putIntArray(str, iArr);
                        return;
                    }
                    return;
                case 109413500:
                    if (string3.equals(TYPE_SHORT)) {
                        bundle.putShort(str, (short) jSONObject.getInt("value"));
                        return;
                    }
                    return;
                case 1359468275:
                    if (string3.equals(TYPE_DOUBLE_ARRAY)) {
                        JSONArray jSONArray8 = jSONObject.getJSONArray("value");
                        int length8 = jSONArray8.length();
                        double[] dArr = new double[length8];
                        while (i3 < length8) {
                            dArr[i3] = jSONArray8.getDouble(i3);
                            i3++;
                        }
                        bundle.putDoubleArray(str, dArr);
                        return;
                    }
                    return;
                case 2067161310:
                    if (string3.equals(TYPE_SHORT_ARRAY)) {
                        JSONArray jSONArray9 = jSONObject.getJSONArray("value");
                        int length9 = jSONArray9.length();
                        short[] sArr = new short[length9];
                        while (i3 < length9) {
                            sArr[i3] = (short) jSONArray9.getInt(i3);
                            i3++;
                        }
                        bundle.putShortArray(str, sArr);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @JvmStatic
    public static final String getApplicationId(Bundle bundle) {
        return Companion.getApplicationId(bundle);
    }

    @JvmStatic
    public static final Date getExpirationDate(Bundle bundle) {
        return Companion.getExpirationDate(bundle);
    }

    @JvmStatic
    public static final long getExpirationMilliseconds(Bundle bundle) {
        return Companion.getExpirationMilliseconds(bundle);
    }

    @JvmStatic
    public static final Date getLastRefreshDate(Bundle bundle) {
        return Companion.getLastRefreshDate(bundle);
    }

    @JvmStatic
    public static final long getLastRefreshMilliseconds(Bundle bundle) {
        return Companion.getLastRefreshMilliseconds(bundle);
    }

    @JvmStatic
    public static final Set<String> getPermissions(Bundle bundle) {
        return Companion.getPermissions(bundle);
    }

    @JvmStatic
    public static final AccessTokenSource getSource(Bundle bundle) {
        return Companion.getSource(bundle);
    }

    @JvmStatic
    public static final String getToken(Bundle bundle) {
        return Companion.getToken(bundle);
    }

    @JvmStatic
    public static final boolean hasTokenInformation(Bundle bundle) {
        return Companion.hasTokenInformation(bundle);
    }

    @JvmStatic
    public static final void putApplicationId(Bundle bundle, String str) {
        Companion.putApplicationId(bundle, str);
    }

    @JvmStatic
    public static final void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        Companion.putDeclinedPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putExpirationDate(Bundle bundle, Date date) {
        Companion.putExpirationDate(bundle, date);
    }

    @JvmStatic
    public static final void putExpirationMilliseconds(Bundle bundle, long j3) {
        Companion.putExpirationMilliseconds(bundle, j3);
    }

    @JvmStatic
    public static final void putExpiredPermissions(Bundle bundle, Collection<String> collection) {
        Companion.putExpiredPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putLastRefreshDate(Bundle bundle, Date date) {
        Companion.putLastRefreshDate(bundle, date);
    }

    @JvmStatic
    public static final void putLastRefreshMilliseconds(Bundle bundle, long j3) {
        Companion.putLastRefreshMilliseconds(bundle, j3);
    }

    @JvmStatic
    public static final void putPermissions(Bundle bundle, Collection<String> collection) {
        Companion.putPermissions(bundle, collection);
    }

    @JvmStatic
    public static final void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Companion.putSource(bundle, accessTokenSource);
    }

    @JvmStatic
    public static final void putToken(Bundle bundle, String str) {
        Companion.putToken(bundle, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void serializeKey(java.lang.String r9, android.os.Bundle r10, android.content.SharedPreferences.Editor r11) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.LegacyTokenHelper.serializeKey(java.lang.String, android.os.Bundle, android.content.SharedPreferences$Editor):void");
    }

    public final void clear() {
        this.cache.edit().clear().apply();
    }

    public final Bundle load() {
        Bundle bundle = new Bundle();
        for (String key : this.cache.getAll().keySet()) {
            try {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                deserializeKey(key, bundle);
            } catch (JSONException e3) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, "Error reading cached value for key: '" + key + "' -- " + e3);
                return null;
            }
        }
        return bundle;
    }

    public final void save(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        SharedPreferences.Editor editor = this.cache.edit();
        for (String key : bundle.keySet()) {
            try {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                Intrinsics.checkNotNullExpressionValue(editor, "editor");
                serializeKey(key, bundle, editor);
            } catch (JSONException e3) {
                Logger.Companion companion = Logger.Companion;
                LoggingBehavior loggingBehavior = LoggingBehavior.CACHE;
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                companion.log(loggingBehavior, 5, TAG2, "Error processing value for key: '" + key + "' -- " + e3);
                return;
            }
        }
        editor.apply();
    }

    public LegacyTokenHelper(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        str = (str == null || str.length() == 0) ? DEFAULT_CACHE_KEY : str;
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        SharedPreferences sharedPreferences = (applicationContext != null ? applicationContext : context).getSharedPreferences(str, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "effectiveContext.getShar…ey, Context.MODE_PRIVATE)");
        this.cache = sharedPreferences;
    }

    public /* synthetic */ LegacyTokenHelper(Context context, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : str);
    }
}
