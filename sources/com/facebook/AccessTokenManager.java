package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.FlushReason;
import com.facebook.internal.Utility;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    public static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    public static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    public static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    public static AccessTokenManager instanceField;
    public final AccessTokenCache accessTokenCache;
    public AccessToken currentAccessTokenField;
    public Date lastAttemptedTokenExtendDate;
    public final LocalBroadcastManager localBroadcastManager;
    public final AtomicBoolean tokenRefreshInProgress;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            RefreshTokenInfo refreshTokenInfoForToken = getRefreshTokenInfoForToken(accessToken);
            Bundle bundle = new Bundle();
            bundle.putString("grant_type", refreshTokenInfoForToken.getGrantType());
            bundle.putString("client_id", accessToken.getApplicationId());
            bundle.putString("fields", "access_token,expires_at,expires_in,data_access_expiration_time,graph_domain");
            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, refreshTokenInfoForToken.getGraphPath(), callback);
            graphRequestNewGraphPathRequest.setParameters(bundle);
            graphRequestNewGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return graphRequestNewGraphPathRequest;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, GraphRequest.Callback callback) {
            Bundle bundle = new Bundle();
            bundle.putString("fields", "permission,status");
            GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, AccessTokenManager.ME_PERMISSIONS_GRAPH_PATH, callback);
            graphRequestNewGraphPathRequest.setParameters(bundle);
            graphRequestNewGraphPathRequest.setHttpMethod(HttpMethod.GET);
            return graphRequestNewGraphPathRequest;
        }

        private final RefreshTokenInfo getRefreshTokenInfoForToken(AccessToken accessToken) {
            String graphDomain = accessToken.getGraphDomain();
            if (graphDomain == null) {
                graphDomain = AccessToken.DEFAULT_GRAPH_DOMAIN;
            }
            return Intrinsics.areEqual(graphDomain, FacebookSdk.INSTAGRAM) ? new InstagramRefreshTokenInfo() : new FacebookRefreshTokenInfo();
        }

        @JvmStatic
        public final AccessTokenManager getInstance() {
            AccessTokenManager accessTokenManager;
            AccessTokenManager accessTokenManager2 = AccessTokenManager.instanceField;
            if (accessTokenManager2 != null) {
                return accessTokenManager2;
            }
            synchronized (this) {
                accessTokenManager = AccessTokenManager.instanceField;
                if (accessTokenManager == null) {
                    LocalBroadcastManager localBroadcastManagerB = LocalBroadcastManager.b(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(localBroadcastManagerB, "getInstance(applicationContext)");
                    AccessTokenManager accessTokenManager3 = new AccessTokenManager(localBroadcastManagerB, new AccessTokenCache());
                    AccessTokenManager.instanceField = accessTokenManager3;
                    accessTokenManager = accessTokenManager3;
                }
            }
            return accessTokenManager;
        }

        public Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FacebookRefreshTokenInfo implements RefreshTokenInfo {
        public final String graphPath = "oauth/access_token";
        public final String grantType = "fb_extend_sso_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGrantType() {
            return this.grantType;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InstagramRefreshTokenInfo implements RefreshTokenInfo {
        public final String graphPath = "refresh_access_token";
        public final String grantType = "ig_refresh_token";

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGrantType() {
            return this.grantType;
        }

        @Override // com.facebook.AccessTokenManager.RefreshTokenInfo
        public String getGraphPath() {
            return this.graphPath;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;
        public int expiresIn;
        public String graphDomain;

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final Long getDataAccessExpirationTime() {
            return this.dataAccessExpirationTime;
        }

        public final int getExpiresAt() {
            return this.expiresAt;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        public final String getGraphDomain() {
            return this.graphDomain;
        }

        public final void setAccessToken(String str) {
            this.accessToken = str;
        }

        public final void setDataAccessExpirationTime(Long l3) {
            this.dataAccessExpirationTime = l3;
        }

        public final void setExpiresAt(int i3) {
            this.expiresAt = i3;
        }

        public final void setExpiresIn(int i3) {
            this.expiresIn = i3;
        }

        public final void setGraphDomain(String str) {
            this.graphDomain = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface RefreshTokenInfo {
        String getGrantType();

        String getGraphPath();
    }

    public AccessTokenManager(LocalBroadcastManager localBroadcastManager, AccessTokenCache accessTokenCache) {
        Intrinsics.checkNotNullParameter(localBroadcastManager, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(accessTokenCache, "accessTokenCache");
        this.localBroadcastManager = localBroadcastManager;
        this.accessTokenCache = accessTokenCache;
        this.tokenRefreshInProgress = new AtomicBoolean(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
    }

    @JvmStatic
    public static final AccessTokenManager getInstance() {
        return Companion.getInstance();
    }

    public static final void refreshCurrentAccessToken$lambda$0(AccessTokenManager this$0, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
    }

    private final void refreshCurrentAccessTokenImpl(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        final AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                return;
            }
            return;
        }
        if (!this.tokenRefreshInProgress.compareAndSet(false, true)) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
                return;
            }
            return;
        }
        this.lastAttemptedTokenExtendDate = new Date();
        final HashSet hashSet = new HashSet();
        final HashSet hashSet2 = new HashSet();
        final HashSet hashSet3 = new HashSet();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RefreshResult refreshResult = new RefreshResult();
        final GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.a
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$1(atomicBoolean, hashSet, hashSet2, hashSet3, graphResponse);
            }
        };
        final GraphRequest.Callback callback2 = new GraphRequest.Callback() { // from class: com.facebook.b
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$2(refreshResult, graphResponse);
            }
        };
        final Runnable runnable = new Runnable() { // from class: com.facebook.c
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$3(refreshResult, currentAccessToken, accessTokenRefreshCallback, atomicBoolean, hashSet, hashSet2, hashSet3, this);
            }
        };
        Companion companion = Companion;
        GraphRequest graphRequestCreateGrantedPermissionsRequest = companion.createGrantedPermissionsRequest(currentAccessToken, callback);
        GraphRequest graphRequestCreateExtendAccessTokenRequest = companion.createExtendAccessTokenRequest(currentAccessToken, callback2);
        if (!Intrinsics.areEqual(currentAccessToken.getGraphDomain(), FacebookSdk.GAMING)) {
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(graphRequestCreateGrantedPermissionsRequest, graphRequestCreateExtendAccessTokenRequest);
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() { // from class: com.facebook.f
                @Override // com.facebook.GraphRequestBatch.Callback
                public final void onBatchCompleted(GraphRequestBatch graphRequestBatch2) {
                    AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$6(runnable, graphRequestBatch2);
                }
            });
            graphRequestBatch.executeAsync();
            return;
        }
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        GraphRequest.Callback callback3 = new GraphRequest.Callback() { // from class: com.facebook.d
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$4(callback, atomicInteger, runnable, graphResponse);
            }
        };
        GraphRequest.Callback callback4 = new GraphRequest.Callback() { // from class: com.facebook.e
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$5(callback2, atomicInteger, runnable, graphResponse);
            }
        };
        graphRequestCreateGrantedPermissionsRequest.setCallback(callback3);
        graphRequestCreateExtendAccessTokenRequest.setCallback(callback4);
        graphRequestCreateGrantedPermissionsRequest.executeAsync();
        graphRequestCreateExtendAccessTokenRequest.executeAsync();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void refreshCurrentAccessTokenImpl$lambda$1(java.util.concurrent.atomic.AtomicBoolean r6, java.util.Set r7, java.util.Set r8, java.util.Set r9, com.facebook.GraphResponse r10) {
        /*
            java.lang.String r0 = "$permissionsCallSucceeded"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "$permissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "$declinedPermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "$expiredPermissions"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            org.json.JSONObject r10 = r10.getJsonObject()
            if (r10 != 0) goto L21
            goto Lbf
        L21:
            java.lang.String r0 = "data"
            org.json.JSONArray r10 = r10.optJSONArray(r0)
            if (r10 != 0) goto L2b
            goto Lbf
        L2b:
            r0 = 1
            r6.set(r0)
            int r6 = r10.length()
            r0 = 0
        L34:
            if (r0 >= r6) goto Lbf
            org.json.JSONObject r1 = r10.optJSONObject(r0)
            if (r1 != 0) goto L3e
            goto Lbb
        L3e:
            java.lang.String r2 = "permission"
            java.lang.String r2 = r1.optString(r2)
            java.lang.String r3 = "status"
            java.lang.String r1 = r1.optString(r3)
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty(r2)
            if (r4 != 0) goto Lbb
            boolean r4 = com.facebook.internal.Utility.isNullOrEmpty(r1)
            if (r4 != 0) goto Lbb
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r5 = "US"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.lang.String r1 = r1.toLowerCase(r4)
            java.lang.String r4 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            int r3 = r1.hashCode()
            r4 = -1309235419(0xffffffffb1f6a725, float:-7.1785444E-9)
            if (r3 == r4) goto L99
            r4 = 280295099(0x10b4f6bb, float:7.137763E-29)
            if (r3 == r4) goto L8d
            r4 = 568196142(0x21ddfc2e, float:1.5042294E-18)
            if (r3 == r4) goto L80
            goto La1
        L80:
            java.lang.String r3 = "declined"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L89
            goto La1
        L89:
            r8.add(r2)
            goto Lbb
        L8d:
            java.lang.String r3 = "granted"
            boolean r3 = r1.equals(r3)
            if (r3 == 0) goto La1
            r7.add(r2)
            goto Lbb
        L99:
            java.lang.String r3 = "expired"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto Lb8
        La1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unexpected status: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "AccessTokenManager"
            android.util.Log.w(r2, r1)
            goto Lbb
        Lb8:
            r9.add(r2)
        Lbb:
            int r0 = r0 + 1
            goto L34
        Lbf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$1(java.util.concurrent.atomic.AtomicBoolean, java.util.Set, java.util.Set, java.util.Set, com.facebook.GraphResponse):void");
    }

    public static final void refreshCurrentAccessTokenImpl$lambda$2(RefreshResult refreshResult, GraphResponse response) {
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(response, "response");
        JSONObject jsonObject = response.getJsonObject();
        if (jsonObject == null) {
            return;
        }
        refreshResult.setAccessToken(jsonObject.optString("access_token"));
        refreshResult.setExpiresAt(jsonObject.optInt(AccessToken.EXPIRES_AT_KEY));
        refreshResult.setExpiresIn(jsonObject.optInt(AccessToken.EXPIRES_IN_KEY));
        refreshResult.setDataAccessExpirationTime(Long.valueOf(jsonObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME)));
        refreshResult.setGraphDomain(jsonObject.optString("graph_domain", null));
    }

    public static final void refreshCurrentAccessTokenImpl$lambda$3(RefreshResult refreshResult, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean permissionsCallSucceeded, Set permissions, Set declinedPermissions, Set expiredPermissions, AccessTokenManager this$0) throws Throwable {
        boolean z2;
        AccessToken accessToken2;
        Companion companion;
        Intrinsics.checkNotNullParameter(refreshResult, "$refreshResult");
        Intrinsics.checkNotNullParameter(permissionsCallSucceeded, "$permissionsCallSucceeded");
        Intrinsics.checkNotNullParameter(permissions, "$permissions");
        Intrinsics.checkNotNullParameter(declinedPermissions, "$declinedPermissions");
        Intrinsics.checkNotNullParameter(expiredPermissions, "$expiredPermissions");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String accessToken3 = refreshResult.getAccessToken();
        int expiresAt = refreshResult.getExpiresAt();
        Long dataAccessExpirationTime = refreshResult.getDataAccessExpirationTime();
        String graphDomain = refreshResult.getGraphDomain();
        try {
            Companion companion2 = Companion;
            if (companion2.getInstance().getCurrentAccessToken() != null) {
                try {
                    AccessToken currentAccessToken = companion2.getInstance().getCurrentAccessToken();
                    if ((currentAccessToken != null ? currentAccessToken.getUserId() : null) == accessToken.getUserId()) {
                        if (!permissionsCallSucceeded.get() && accessToken3 == null && expiresAt == 0) {
                            if (accessTokenRefreshCallback != null) {
                                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                            }
                            this$0.tokenRefreshInProgress.set(false);
                            return;
                        }
                        Date expires = accessToken.getExpires();
                        if (refreshResult.getExpiresAt() != 0) {
                            companion = companion2;
                            expires = new Date(((long) refreshResult.getExpiresAt()) * 1000);
                        } else {
                            companion = companion2;
                            if (refreshResult.getExpiresIn() != 0) {
                                expires = new Date((((long) refreshResult.getExpiresIn()) * 1000) + new Date().getTime());
                            }
                        }
                        Date date = expires;
                        if (accessToken3 == null) {
                            accessToken3 = accessToken.getToken();
                        }
                        String str = accessToken3;
                        String applicationId = accessToken.getApplicationId();
                        String userId = accessToken.getUserId();
                        Set permissions2 = permissionsCallSucceeded.get() ? permissions : accessToken.getPermissions();
                        Set declinedPermissions2 = permissionsCallSucceeded.get() ? declinedPermissions : accessToken.getDeclinedPermissions();
                        Set expiredPermissions2 = permissionsCallSucceeded.get() ? expiredPermissions : accessToken.getExpiredPermissions();
                        AccessTokenSource source = accessToken.getSource();
                        Date date2 = new Date();
                        Date date3 = dataAccessExpirationTime != null ? new Date(dataAccessExpirationTime.longValue() * 1000) : accessToken.getDataAccessExpirationTime();
                        if (graphDomain == null) {
                            graphDomain = accessToken.getGraphDomain();
                        }
                        accessToken2 = new AccessToken(str, applicationId, userId, permissions2, declinedPermissions2, expiredPermissions2, source, date, date2, date3, graphDomain);
                        try {
                            companion.getInstance().setCurrentAccessToken(accessToken2);
                            this$0.tokenRefreshInProgress.set(false);
                            if (accessTokenRefreshCallback != null) {
                                accessTokenRefreshCallback.OnTokenRefreshed(accessToken2);
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            z2 = false;
                            this$0.tokenRefreshInProgress.set(z2);
                            if (accessTokenRefreshCallback != null) {
                                accessTokenRefreshCallback.OnTokenRefreshed(accessToken2);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z2 = false;
                    accessToken2 = null;
                    this$0.tokenRefreshInProgress.set(z2);
                    if (accessTokenRefreshCallback != null && accessToken2 != null) {
                        accessTokenRefreshCallback.OnTokenRefreshed(accessToken2);
                    }
                    throw th;
                }
            }
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            this$0.tokenRefreshInProgress.set(false);
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
        }
    }

    public static final void refreshCurrentAccessTokenImpl$lambda$4(GraphRequest.Callback permissionsCallback, AtomicInteger completedCount, Runnable onAllCompleted, GraphResponse response) {
        Intrinsics.checkNotNullParameter(permissionsCallback, "$permissionsCallback");
        Intrinsics.checkNotNullParameter(completedCount, "$completedCount");
        Intrinsics.checkNotNullParameter(onAllCompleted, "$onAllCompleted");
        Intrinsics.checkNotNullParameter(response, "response");
        permissionsCallback.onCompleted(response);
        if (completedCount.incrementAndGet() == 2) {
            onAllCompleted.run();
        }
    }

    public static final void refreshCurrentAccessTokenImpl$lambda$5(GraphRequest.Callback extendCallback, AtomicInteger completedCount, Runnable onAllCompleted, GraphResponse response) {
        Intrinsics.checkNotNullParameter(extendCallback, "$extendCallback");
        Intrinsics.checkNotNullParameter(completedCount, "$completedCount");
        Intrinsics.checkNotNullParameter(onAllCompleted, "$onAllCompleted");
        Intrinsics.checkNotNullParameter(response, "response");
        extendCallback.onCompleted(response);
        if (completedCount.incrementAndGet() == 2) {
            onAllCompleted.run();
        }
    }

    public static final void refreshCurrentAccessTokenImpl$lambda$6(Runnable onAllCompleted, GraphRequestBatch it) {
        Intrinsics.checkNotNullParameter(onAllCompleted, "$onAllCompleted");
        Intrinsics.checkNotNullParameter(it, "it");
        onAllCompleted.run();
    }

    private final void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.d(intent);
    }

    private final void setTokenExpirationBroadcastAlarm() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken.Companion companion = AccessToken.Companion;
        AccessToken currentAccessToken = companion.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (companion.isCurrentAccessTokenActive()) {
            if ((currentAccessToken != null ? currentAccessToken.getExpires() : null) == null || alarmManager == null) {
                return;
            }
            Intent intent = new Intent(applicationContext, (Class<?>) CurrentAccessTokenExpirationBroadcastReceiver.class);
            intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
            try {
                alarmManager.set(1, currentAccessToken.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 67108864));
            } catch (Exception unused) {
            }
        }
    }

    private final boolean shouldExtendAccessToken() {
        AccessToken currentAccessToken = getCurrentAccessToken();
        if (currentAccessToken == null) {
            return false;
        }
        long time = new Date().getTime();
        return currentAccessToken.getSource().canExtendToken() && time - this.lastAttemptedTokenExtendDate.getTime() > 3600000 && time - currentAccessToken.getLastRefresh().getTime() > 86400000;
    }

    public final void currentAccessTokenChanged() {
        sendCurrentAccessTokenChangedBroadcastIntent(getCurrentAccessToken(), getCurrentAccessToken());
    }

    public final void extendAccessTokenIfNeeded() {
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken(null);
        }
    }

    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessTokenField;
    }

    public final boolean loadCurrentAccessToken() {
        AccessToken accessTokenLoad = this.accessTokenCache.load();
        if (accessTokenLoad == null) {
            return false;
        }
        setCurrentAccessToken(accessTokenLoad, false);
        return true;
    }

    public final void refreshCurrentAccessToken(final AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.g
                @Override // java.lang.Runnable
                public final void run() {
                    AccessTokenManager.refreshCurrentAccessToken$lambda$0(this.f68130a, accessTokenRefreshCallback);
                }
            });
        }
    }

    public final void setCurrentAccessToken(AccessToken accessToken) {
        setCurrentAccessToken(accessToken, true);
    }

    private final void setCurrentAccessToken(AccessToken accessToken, boolean z2) {
        AccessToken accessToken2 = this.currentAccessTokenField;
        String userId = accessToken2 != null ? accessToken2.getUserId() : null;
        String userId2 = accessToken != null ? accessToken.getUserId() : null;
        if (userId != null && !Intrinsics.areEqual(userId, userId2)) {
            AppEventQueue.flushAndWait(FlushReason.EAGER_FLUSHING_EVENT);
        }
        this.currentAccessTokenField = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0L);
        if (z2) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (Utility.areObjectsEqual(accessToken2, accessToken)) {
            return;
        }
        sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
        setTokenExpirationBroadcastAlarm();
    }
}
