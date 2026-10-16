package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class AppLinkManager {
    public static final String APPLINK_DATA_KEY = "al_applink_data";
    public static final String APPLINK_INFO = "com.facebook.sdk.APPLINK_INFO";
    public static final String CAMPAIGN_IDS_KEY = "campaign_ids";
    public static final Companion Companion = new Companion(null);
    private static volatile AppLinkManager instance;
    private final Lazy preferences$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppLinkManager getInstance() {
            AppLinkManager appLinkManagerAccess$getInstance$cp = AppLinkManager.access$getInstance$cp();
            if (appLinkManagerAccess$getInstance$cp != null) {
                return appLinkManagerAccess$getInstance$cp;
            }
            synchronized (this) {
                DefaultConstructorMarker defaultConstructorMarker = null;
                if (!FacebookSdk.isInitialized()) {
                    return null;
                }
                AppLinkManager appLinkManagerAccess$getInstance$cp2 = AppLinkManager.access$getInstance$cp();
                if (appLinkManagerAccess$getInstance$cp2 == null) {
                    appLinkManagerAccess$getInstance$cp2 = new AppLinkManager(defaultConstructorMarker);
                    AppLinkManager.access$setInstance$cp(appLinkManagerAccess$getInstance$cp2);
                }
                return appLinkManagerAccess$getInstance$cp2;
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ AppLinkManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ AppLinkManager access$getInstance$cp() {
        if (CrashShieldHandler.isObjectCrashing(AppLinkManager.class)) {
            return null;
        }
        try {
            return instance;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppLinkManager.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$setInstance$cp(AppLinkManager appLinkManager) {
        if (CrashShieldHandler.isObjectCrashing(AppLinkManager.class)) {
            return;
        }
        try {
            instance = appLinkManager;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppLinkManager.class);
        }
    }

    private final SharedPreferences getPreferences() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object value = this.preferences$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-preferences>(...)");
            return (SharedPreferences) value;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getCampaignIDFromIntentExtra(Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
            if (bundleExtra == null) {
                return null;
            }
            return bundleExtra.getString(CAMPAIGN_IDS_KEY);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getCampaignIDFromUri(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(uri, "uri");
            String queryParameter = uri.getQueryParameter("al_applink_data");
            if (queryParameter == null) {
                return null;
            }
            try {
                return new JSONObject(queryParameter).getString(CAMPAIGN_IDS_KEY);
            } catch (Exception unused) {
                Log.d("AppLinkManager", "Fail to parse Applink data from Uri");
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final String getInfo(String key) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(key, "key");
            return getPreferences().getString(key, null);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final void handleURL(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Uri data = activity.getIntent().getData();
            if (data == null) {
                return;
            }
            Intent intent = activity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
            processCampaignIds(data, intent);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void processCampaignIds(Uri uri, Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String campaignIDFromUri = getCampaignIDFromUri(uri);
            if (campaignIDFromUri == null) {
                campaignIDFromUri = getCampaignIDFromIntentExtra(intent);
            }
            if (campaignIDFromUri != null) {
                getPreferences().edit().putString(CAMPAIGN_IDS_KEY, campaignIDFromUri).apply();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void setupLifecycleListener(Application application) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(application, "application");
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.appevents.internal.AppLinkManager.setupLifecycleListener.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    AppLinkManager companion = AppLinkManager.Companion.getInstance();
                    if (companion != null) {
                        companion.handleURL(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(bundle, "bundle");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    AppLinkManager companion = AppLinkManager.Companion.getInstance();
                    if (companion != null) {
                        companion.handleURL(activity);
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private AppLinkManager() {
        this.preferences$delegate = LazyKt.b(new Function0<SharedPreferences>() { // from class: com.facebook.appevents.internal.AppLinkManager$preferences$2
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return FacebookSdk.getApplicationContext().getSharedPreferences(AppLinkManager.APPLINK_INFO, 0);
            }
        });
    }
}
