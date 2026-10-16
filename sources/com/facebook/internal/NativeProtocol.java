package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginTargetApp;
import com.facebook.messenger.MessengerUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    private static final String CONTENT_SCHEME = "content://";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_AUTHENTICATION_TOKEN = "com.facebook.platform.extra.ID_TOKEN";
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    public static final String EXTRA_NONCE = "com.facebook.platform.extra.NONCE";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    public static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_REDIRECT_URI = "com.facebook.platform.extra.REDIRECT_URI";
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    public static final NativeProtocol INSTANCE;
    public static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    public static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final Integer[] KNOWN_PROTOCOL_VERSIONS;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    public static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131024 = 20131024;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140313 = 20140313;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20150401 = 20150401;
    public static final int PROTOCOL_VERSION_20150702 = 20150702;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20161017 = 20161017;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final int PROTOCOL_VERSION_20210906 = 20210906;
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_GRAPH_DOMAIN = "graph_domain";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG;
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap;
    private static final List<NativeAppInfo> effectCameraAppInfoList;
    private static final List<NativeAppInfo> facebookAppInfoList;
    private static final AtomicBoolean protocolVersionsAsyncUpdating;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class EffectTestAppInfo extends NativeAppInfo {
        /* JADX INFO: renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m367getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.arstudio.player";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m367getLoginActivity();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class InstagramAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.instagram.android";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class KatanaAppInfo extends NativeAppInfo {
        private final boolean isAndroidAPIVersionNotLessThan30() {
            return FacebookSdk.getApplicationContext().getApplicationInfo().targetSdkVersion >= 30;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public void onAvailableVersionsNullOrEmpty() {
            if (isAndroidAPIVersionNotLessThan30()) {
                Log.w(NativeProtocol.access$getTAG$p(), "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class MessengerAppInfo extends NativeAppInfo {
        /* JADX INFO: renamed from: getLoginActivity, reason: collision with other method in class */
        public Void m368getLoginActivity() {
            return null;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return MessengerUtils.PACKAGE_NAME;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public /* bridge */ /* synthetic */ String getLoginActivity() {
            return (String) m368getLoginActivity();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ProtocolVersionQueryResult {
        public static final Companion Companion = new Companion(null);
        private NativeAppInfo appInfo;
        private int protocolVersion;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int i3) {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.appInfo = nativeAppInfo;
                protocolVersionQueryResult.protocolVersion = i3;
                return protocolVersionQueryResult;
            }

            @JvmStatic
            public final ProtocolVersionQueryResult createEmpty() {
                ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult(null);
                protocolVersionQueryResult.protocolVersion = -1;
                return protocolVersionQueryResult;
            }

            private Companion() {
            }
        }

        public /* synthetic */ ProtocolVersionQueryResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static final ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int i3) {
            return Companion.create(nativeAppInfo, i3);
        }

        @JvmStatic
        public static final ProtocolVersionQueryResult createEmpty() {
            return Companion.createEmpty();
        }

        public final NativeAppInfo getAppInfo() {
            return this.appInfo;
        }

        public final int getProtocolVersion() {
            return this.protocolVersion;
        }

        private ProtocolVersionQueryResult() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class WakizashiAppInfo extends NativeAppInfo {
        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }

        @Override // com.facebook.internal.NativeProtocol.NativeAppInfo
        public String getPackage() {
            return "com.facebook.wakizashi";
        }
    }

    static {
        NativeProtocol nativeProtocol = new NativeProtocol();
        INSTANCE = nativeProtocol;
        TAG = NativeProtocol.class.getName();
        facebookAppInfoList = nativeProtocol.buildFacebookAppList();
        effectCameraAppInfoList = nativeProtocol.buildEffectCameraAppInfoList();
        actionToAppInfoMap = nativeProtocol.buildActionToAppInfoMap();
        protocolVersionsAsyncUpdating = new AtomicBoolean(false);
        KNOWN_PROTOCOL_VERSIONS = new Integer[]{Integer.valueOf(PROTOCOL_VERSION_20210906), Integer.valueOf(PROTOCOL_VERSION_20171115), Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20170411), Integer.valueOf(PROTOCOL_VERSION_20170213), Integer.valueOf(PROTOCOL_VERSION_20161017), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20150702), Integer.valueOf(PROTOCOL_VERSION_20150401), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140313), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20131024), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)};
    }

    private NativeProtocol() {
    }

    public static final /* synthetic */ TreeSet access$fetchAllAvailableProtocolVersionsForAppInfo(NativeProtocol nativeProtocol, NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return nativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MessengerAppInfo());
            List<NativeAppInfo> list = facebookAppInfoList;
            map.put(ACTION_OGACTIONPUBLISH_DIALOG, list);
            map.put(ACTION_FEED_DIALOG, list);
            map.put(ACTION_LIKE_DIALOG, list);
            map.put(ACTION_APPINVITE_DIALOG, list);
            map.put(ACTION_MESSAGE_DIALOG, arrayList);
            map.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
            map.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
            map.put(ACTION_SHARE_STORY, list);
            return map;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildEffectCameraAppInfoList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(new EffectTestAppInfo());
            arrayListArrayListOf.addAll(buildFacebookAppList());
            return arrayListArrayListOf;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final List<NativeAppInfo> buildFacebookAppList() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return CollectionsKt.arrayListOf(new KatanaAppInfo(), new WakizashiAppInfo());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final String buildIntentUriFromPackage(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return "intent://" + str;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Uri uri = Uri.parse(CONTENT_SCHEME + nativeAppInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS);
            Intrinsics.checkNotNullExpressionValue(uri, "parse(CONTENT_SCHEME + a…ATFORM_PROVIDER_VERSIONS)");
            return uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if ((r3 % 2) != 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        return java.lang.Math.min(r4, r9);
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int computeLatestAvailableVersionFromVersionSpec(java.util.TreeSet<java.lang.Integer> r8, int r9, int[] r10) {
        /*
            java.lang.Class<com.facebook.internal.NativeProtocol> r0 = com.facebook.internal.NativeProtocol.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            java.lang.String r1 = "versionSpec"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)     // Catch: java.lang.Throwable -> L41
            r1 = -1
            if (r8 != 0) goto L13
            return r1
        L13:
            int r3 = r10.length     // Catch: java.lang.Throwable -> L41
            int r3 = r3 + (-1)
            java.util.Iterator r8 = r8.descendingIterator()     // Catch: java.lang.Throwable -> L41
            r4 = r1
        L1b:
            boolean r5 = r8.hasNext()     // Catch: java.lang.Throwable -> L41
            if (r5 == 0) goto L57
            java.lang.Object r5 = r8.next()     // Catch: java.lang.Throwable -> L41
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch: java.lang.Throwable -> L41
            java.lang.String r6 = "fbAppVersion"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch: java.lang.Throwable -> L41
            int r6 = r5.intValue()     // Catch: java.lang.Throwable -> L41
            int r4 = java.lang.Math.max(r4, r6)     // Catch: java.lang.Throwable -> L41
        L34:
            if (r3 < 0) goto L43
            r6 = r10[r3]     // Catch: java.lang.Throwable -> L41
            int r7 = r5.intValue()     // Catch: java.lang.Throwable -> L41
            if (r6 <= r7) goto L43
            int r3 = r3 + (-1)
            goto L34
        L41:
            r8 = move-exception
            goto L58
        L43:
            if (r3 >= 0) goto L46
            return r1
        L46:
            r6 = r10[r3]     // Catch: java.lang.Throwable -> L41
            int r5 = r5.intValue()     // Catch: java.lang.Throwable -> L41
            if (r6 != r5) goto L1b
            int r3 = r3 % 2
            if (r3 != 0) goto L57
            int r8 = java.lang.Math.min(r4, r9)     // Catch: java.lang.Throwable -> L41
            return r8
        L57:
            return r1
        L58:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r8, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.computeLatestAvailableVersionFromVersionSpec(java.util.TreeSet, int, int[]):int");
    }

    @JvmStatic
    public static final Bundle createBundleForException(FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || facebookException == null) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
            if (!(facebookException instanceof FacebookOperationCanceledException)) {
                return bundle;
            }
            bundle.putString("error_type", ERROR_USER_CANCELED);
            return bundle;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final Intent createInstagramIntent(Context context, String applicationId, Collection<String> permissions, String e2e, boolean z2, boolean z3, DefaultAudience defaultAudience, String clientState, String authType, String str, boolean z4, boolean z5, boolean z6) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Intrinsics.checkNotNullParameter(e2e, "e2e");
            Intrinsics.checkNotNullParameter(defaultAudience, "defaultAudience");
            Intrinsics.checkNotNullParameter(clientState, "clientState");
            Intrinsics.checkNotNullParameter(authType, "authType");
            InstagramAppInfo instagramAppInfo = new InstagramAppInfo();
            return validateActivityIntent(context, INSTANCE.createNativeAppIntent(instagramAppInfo, applicationId, permissions, e2e, z3, defaultAudience, clientState, authType, false, str, z4, LoginTargetApp.INSTAGRAM, z5, z6, "", null, null, null, null), instagramAppInfo);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z2, DefaultAudience defaultAudience, String str3, String str4, boolean z3, String str5, boolean z4, LoginTargetApp loginTargetApp, boolean z5, boolean z6, String str6, String str7, String str8, String str9, String str10) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String loginActivity = nativeAppInfo.getLoginActivity();
            if (loginActivity == null) {
                return null;
            }
            Intent intentPutExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent()\n            .se…PP_ID_KEY, applicationId)");
            intentPutExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
            if (!Utility.isNullOrEmpty(collection)) {
                intentPutExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!Utility.isNullOrEmpty(str2)) {
                intentPutExtra.putExtra("e2e", str2);
            }
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_STATE, str3);
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, nativeAppInfo.getResponseType());
            intentPutExtra.putExtra("nonce", str6);
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            if (z2) {
                intentPutExtra.putExtra("default_audience", defaultAudience.getNativeProtocolAudience());
            }
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
            if (z3) {
                intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_FAIL_ON_LOGGED_OUT, true);
            }
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_MESSENGER_PAGE_ID, str5);
            intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESET_MESSENGER_STATE, z4);
            if (z5) {
                intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_FX_APP, loginTargetApp.toString());
            }
            if (z6) {
                intentPutExtra.putExtra(ServerProtocol.DIALOG_PARAM_SKIP_DEDUPE, true);
            }
            if (str9 != null && str9.length() != 0) {
                intentPutExtra.putExtra(ServerProtocol.DIALOG_HTTPS_REDIRECT_URI, str9);
                return intentPutExtra;
            }
            if (str10 != null && str10.length() != 0) {
                intentPutExtra.putExtra("intent_uri_package_target", buildIntentUriFromPackage(str10));
            }
            return intentPutExtra;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        NativeAppInfo appInfo;
        Intent intentValidateActivityIntent;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (protocolVersionQueryResult == null || (appInfo = protocolVersionQueryResult.getAppInfo()) == null || (intentValidateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(appInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), appInfo)) == null) {
                return null;
            }
            setupProtocolRequestIntent(intentValidateActivityIntent, str, str2, protocolVersionQueryResult.getProtocolVersion(), bundle);
            return intentValidateActivityIntent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final Intent createPlatformServiceIntent(Context context) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
                Intent intentValidateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
                if (intentValidateServiceIntent != null) {
                    return intentValidateServiceIntent;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final Intent createProtocolResultIntent(Intent requestIntent, Bundle bundle, FacebookException facebookException) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(requestIntent, "requestIntent");
            UUID callIdFromIntent = getCallIdFromIntent(requestIntent);
            if (callIdFromIntent == null) {
                return null;
            }
            Intent intent = new Intent();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(requestIntent));
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", callIdFromIntent.toString());
            if (facebookException != null) {
                bundle2.putBundle("error", createBundleForException(facebookException));
            }
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle != null) {
                intent.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
            }
            return intent;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final List<Intent> createProxyAuthIntents(Context context, String str, Collection<String> collection, String str2, boolean z2, boolean z3, DefaultAudience defaultAudience, String str3, String str4, boolean z4, String str5, boolean z5, boolean z6, boolean z7, String str6, String str7, String str8, String str9, String str10) {
        List<Intent> list;
        List<Intent> list2 = null;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            String applicationId = str;
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Collection<String> permissions = collection;
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            String e2e = str2;
            Intrinsics.checkNotNullParameter(e2e, "e2e");
            DefaultAudience defaultAudience2 = defaultAudience;
            Intrinsics.checkNotNullParameter(defaultAudience2, "defaultAudience");
            String clientState = str3;
            Intrinsics.checkNotNullParameter(clientState, "clientState");
            String authType = str4;
            Intrinsics.checkNotNullParameter(authType, "authType");
            List<NativeAppInfo> list3 = facebookAppInfoList;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                ArrayList arrayList2 = arrayList;
                list = list2;
                try {
                    Intent intentCreateNativeAppIntent = INSTANCE.createNativeAppIntent((NativeAppInfo) it.next(), applicationId, permissions, e2e, z3, defaultAudience2, clientState, authType, z4, str5, z5, LoginTargetApp.FACEBOOK, z6, z7, str6, str7, str8, str9, str10);
                    if (intentCreateNativeAppIntent != null) {
                        arrayList2.add(intentCreateNativeAppIntent);
                    }
                    applicationId = str;
                    permissions = collection;
                    e2e = str2;
                    defaultAudience2 = defaultAudience;
                    clientState = str3;
                    authType = str4;
                    arrayList = arrayList2;
                    list2 = list;
                } catch (Throwable th) {
                    th = th;
                    CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
                    return list;
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            list = list2;
        }
    }

    public static /* synthetic */ List createProxyAuthIntents$default(Context context, String str, Collection collection, String str2, boolean z2, boolean z3, DefaultAudience defaultAudience, String str3, String str4, boolean z4, String str5, boolean z5, boolean z6, boolean z7, String str6, String str7, String str8, String str9, String str10, int i3, Object obj) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            return createProxyAuthIntents(context, str, collection, str2, z2, z3, defaultAudience, str3, str4, z4, str5, z5, z6, z7, str6, str7, (i3 & MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? "S256" : str8, str9, str10);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008d A[Catch: all -> 0x0091, TRY_ENTER, TryCatch #1 {all -> 0x0091, blocks: (B:5:0x000c, B:39:0x0097, B:40:0x009a, B:34:0x008d), top: B:43:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0097 A[Catch: all -> 0x0091, TryCatch #1 {all -> 0x0091, blocks: (B:5:0x000c, B:39:0x0097, B:40:0x009a, B:34:0x008d), top: B:43:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006f A[EXC_TOP_SPLITTER, LOOP:0: B:47:0x006f->B:28:0x0075, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[Catch: all -> 0x0091, SYNTHETIC, TRY_LEAVE, TryCatch #1 {all -> 0x0091, blocks: (B:5:0x000c, B:39:0x0097, B:40:0x009a, B:34:0x008d), top: B:43:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.TreeSet<java.lang.Integer> fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol.NativeAppInfo r13) {
        /*
            r12 = this;
            java.lang.String r1 = "version"
            java.lang.String r2 = "Failed to query content resolver."
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r3 = 0
            if (r0 == 0) goto Lc
            return r3
        Lc:
            java.util.TreeSet r4 = new java.util.TreeSet     // Catch: java.lang.Throwable -> L91
            r4.<init>()     // Catch: java.lang.Throwable -> L91
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L91
            android.content.ContentResolver r5 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L91
            java.lang.String[] r7 = new java.lang.String[]{r1}     // Catch: java.lang.Throwable -> L91
            android.net.Uri r6 = r12.buildPlatformProviderVersionURI(r13)     // Catch: java.lang.Throwable -> L91
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()     // Catch: java.lang.Throwable -> L44
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L44
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r8.<init>()     // Catch: java.lang.Throwable -> L44
            java.lang.String r13 = r13.getPackage()     // Catch: java.lang.Throwable -> L44
            r8.append(r13)     // Catch: java.lang.Throwable -> L44
            java.lang.String r13 = ".provider.PlatformProvider"
            r8.append(r13)     // Catch: java.lang.Throwable -> L44
            java.lang.String r13 = r8.toString()     // Catch: java.lang.Throwable -> L44
            r8 = 0
            android.content.pm.ProviderInfo r13 = r0.resolveContentProvider(r13, r8)     // Catch: java.lang.Throwable -> L44 java.lang.RuntimeException -> L48
            goto L50
        L44:
            r0 = move-exception
            r13 = r0
            r0 = r3
            goto L95
        L48:
            r0 = move-exception
            r13 = r0
            java.lang.String r0 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L44
            android.util.Log.e(r0, r2, r13)     // Catch: java.lang.Throwable -> L44
            r13 = r3
        L50:
            if (r13 == 0) goto L8a
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L44 java.lang.IllegalArgumentException -> L5a java.lang.SecurityException -> L61 java.lang.NullPointerException -> L67
            goto L6d
        L5a:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L44
            android.util.Log.e(r13, r2)     // Catch: java.lang.Throwable -> L44
        L5f:
            r13 = r3
            goto L6d
        L61:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L44
            android.util.Log.e(r13, r2)     // Catch: java.lang.Throwable -> L44
            goto L5f
        L67:
            java.lang.String r13 = com.facebook.internal.NativeProtocol.TAG     // Catch: java.lang.Throwable -> L44
            android.util.Log.e(r13, r2)     // Catch: java.lang.Throwable -> L44
            goto L5f
        L6d:
            if (r13 == 0) goto L8b
        L6f:
            boolean r0 = r13.moveToNext()     // Catch: java.lang.Throwable -> L85
            if (r0 == 0) goto L8b
            int r0 = r13.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L85
            int r0 = r13.getInt(r0)     // Catch: java.lang.Throwable -> L85
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L85
            r4.add(r0)     // Catch: java.lang.Throwable -> L85
            goto L6f
        L85:
            r0 = move-exception
            r11 = r0
            r0 = r13
            r13 = r11
            goto L95
        L8a:
            r13 = r3
        L8b:
            if (r13 == 0) goto L94
            r13.close()     // Catch: java.lang.Throwable -> L91
            goto L94
        L91:
            r0 = move-exception
            r13 = r0
            goto L9b
        L94:
            return r4
        L95:
            if (r0 == 0) goto L9a
            r0.close()     // Catch: java.lang.Throwable -> L91
        L9a:
            throw r13     // Catch: java.lang.Throwable -> L91
        L9b:
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.fetchAllAvailableProtocolVersionsForAppInfo(com.facebook.internal.NativeProtocol$NativeAppInfo):java.util.TreeSet");
    }

    @JvmStatic
    public static final Bundle getBridgeArgumentsFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                return intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final UUID getCallIdFromIntent(Intent intent) {
        String stringExtra;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || intent == null) {
            return null;
        }
        try {
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
            } else {
                stringExtra = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (stringExtra != null) {
                try {
                    return UUID.fromString(stringExtra);
                } catch (IllegalArgumentException e3) {
                    Utility.logd(TAG, "Failed to parse call ID from string: " + stringExtra, e3);
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final Bundle getErrorDataFromResultIntent(Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
            if (!isErrorResult(resultIntent)) {
                return null;
            }
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(resultIntent);
            return bridgeArgumentsFromIntent != null ? bridgeArgumentsFromIntent.getBundle("error") : resultIntent.getExtras();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final FacebookException getExceptionFromErrorData(Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class) || bundle == null) {
            return null;
        }
        try {
            String string = bundle.getString("error_type");
            if (string == null) {
                string = bundle.getString(STATUS_ERROR_TYPE);
            }
            String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
            if (string2 == null) {
                string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
            }
            return (string == null || !StringsKt.F(string, ERROR_USER_CANCELED, true)) ? new FacebookException(string2) : new FacebookOperationCanceledException(string2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String action, int[] versionSpec) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(versionSpec, "versionSpec");
            List<NativeAppInfo> listEmptyList = actionToAppInfoMap.get(action);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(listEmptyList, versionSpec);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    private final ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<? extends NativeAppInfo> list, int[] iArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            updateAllAvailableProtocolVersionsAsync();
            if (list == null) {
                return ProtocolVersionQueryResult.Companion.createEmpty();
            }
            for (NativeAppInfo nativeAppInfo : list) {
                int iComputeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
                if (iComputeLatestAvailableVersionFromVersionSpec != -1) {
                    return ProtocolVersionQueryResult.Companion.create(nativeAppInfo, iComputeLatestAvailableVersionFromVersionSpec);
                }
            }
            return ProtocolVersionQueryResult.Companion.createEmpty();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final int getLatestAvailableProtocolVersionForService(int i3) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i3}).getProtocolVersion();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @JvmStatic
    public static final int getLatestKnownVersion() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            return KNOWN_PROTOCOL_VERSIONS[0].intValue();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @JvmStatic
    public static final Bundle getMethodArgumentsFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return !isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent)) ? intent.getExtras() : intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final int getProtocolVersionFromIntent(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return 0;
        }
    }

    @JvmStatic
    public static final Bundle getSuccessResultsFromIntent(Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
            int protocolVersionFromIntent = getProtocolVersionFromIntent(resultIntent);
            Bundle extras = resultIntent.getExtras();
            if (isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) && extras != null) {
                return extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
            }
            return extras;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isErrorResult(Intent resultIntent) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(resultIntent, "resultIntent");
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(resultIntent);
            return bridgeArgumentsFromIntent != null ? bridgeArgumentsFromIntent.containsKey("error") : resultIntent.hasExtra(STATUS_ERROR_TYPE);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @JvmStatic
    public static final boolean isVersionCompatibleWithBucketedIntent(int i3) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return false;
        }
        try {
            return ArraysKt.contains(KNOWN_PROTOCOL_VERSIONS, Integer.valueOf(i3)) && i3 >= 20140701;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return false;
        }
    }

    @JvmStatic
    public static final void setupProtocolRequestIntent(Intent intent, String str, String str2, int i3, Bundle bundle) {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            String applicationId = FacebookSdk.getApplicationId();
            String applicationName = FacebookSdk.getApplicationName();
            intent.putExtra(EXTRA_PROTOCOL_VERSION, i3).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
            if (!isVersionCompatibleWithBucketedIntent(i3)) {
                intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
                if (!Utility.isNullOrEmpty(applicationName)) {
                    intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
                }
                if (bundle != null) {
                    intent.putExtras(bundle);
                    return;
                }
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @JvmStatic
    public static final void updateAllAvailableProtocolVersionsAsync() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeProtocol.updateAllAvailableProtocolVersionsAsync$lambda$1();
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateAllAvailableProtocolVersionsAsync$lambda$1() {
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return;
        }
        try {
            try {
                Iterator<NativeAppInfo> it = facebookAppInfoList.iterator();
                while (it.hasNext()) {
                    it.next().fetchAvailableVersions(true);
                }
            } finally {
                protocolVersionsAsyncUpdating.set(false);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
        }
    }

    @JvmStatic
    public static final Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveInfoResolveActivity;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null || (resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
                return null;
            }
            String str = resolveInfoResolveActivity.activityInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.activityInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    @JvmStatic
    public static final Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        ResolveInfo resolveInfoResolveService;
        if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent == null || (resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
                return null;
            }
            String str = resolveInfoResolveService.serviceInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "resolveInfo.serviceInfo.packageName");
            if (FacebookSignatureValidator.validateSignature(context, str)) {
                return intent;
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, NativeProtocol.class);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        /* JADX WARN: Removed duplicated region for block: B:12:0x0012 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x0003, B:7:0x0009, B:13:0x001a, B:15:0x001e, B:17:0x0024, B:12:0x0012), top: B:22:0x0003 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final synchronized void fetchAvailableVersions(boolean r1) {
            /*
                r0 = this;
                monitor-enter(r0)
                if (r1 != 0) goto L12
                java.util.TreeSet<java.lang.Integer> r1 = r0.availableVersions     // Catch: java.lang.Throwable -> L10
                if (r1 == 0) goto L12
                if (r1 == 0) goto L12
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L10
                if (r1 != 0) goto L12
                goto L1a
            L10:
                r1 = move-exception
                goto L29
            L12:
                com.facebook.internal.NativeProtocol r1 = com.facebook.internal.NativeProtocol.INSTANCE     // Catch: java.lang.Throwable -> L10
                java.util.TreeSet r1 = com.facebook.internal.NativeProtocol.access$fetchAllAvailableProtocolVersionsForAppInfo(r1, r0)     // Catch: java.lang.Throwable -> L10
                r0.availableVersions = r1     // Catch: java.lang.Throwable -> L10
            L1a:
                java.util.TreeSet<java.lang.Integer> r1 = r0.availableVersions     // Catch: java.lang.Throwable -> L10
                if (r1 == 0) goto L24
                boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L10
                if (r1 == 0) goto L27
            L24:
                r0.onAvailableVersionsNullOrEmpty()     // Catch: java.lang.Throwable -> L10
            L27:
                monitor-exit(r0)
                return
            L29:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L10
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.NativeProtocol.NativeAppInfo.fetchAvailableVersions(boolean):void");
        }

        public final TreeSet<Integer> getAvailableVersions() {
            TreeSet<Integer> treeSet = this.availableVersions;
            if (treeSet == null || treeSet == null || treeSet.isEmpty()) {
                fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        public abstract String getLoginActivity();

        public abstract String getPackage();

        public String getResponseType() {
            return ServerProtocol.DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST;
        }

        public void onAvailableVersionsNullOrEmpty() {
        }
    }
}
