package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;
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
public final class InternalAppEventsLogger {
    public static final Companion Companion = new Companion(null);
    private final AppEventsLoggerImpl loggerImpl;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ InternalAppEventsLogger createInstance$default(Companion companion, Context context, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = null;
            }
            return companion.createInstance(context, str);
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(Context context) {
            return createInstance$default(this, context, null, 2, null);
        }

        @JvmStatic
        public final Executor getAnalyticsExecutor() {
            return AppEventsLoggerImpl.Companion.getAnalyticsExecutor();
        }

        @JvmStatic
        public final AppEventsLogger.FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @JvmStatic
        public final String getPushNotificationsRegistrationId() {
            return AppEventsLoggerImpl.Companion.getPushNotificationsRegistrationId();
        }

        @JvmStatic
        public final void setInternalUserData(Map<String, String> ud) {
            Intrinsics.checkNotNullParameter(ud, "ud");
            UserDataStore.setInternalUd(ud);
        }

        @JvmStatic
        public final void setUserData(Bundle bundle) {
            UserDataStore.setUserDataAndHash(bundle);
        }

        private Companion() {
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(Context context, String str) {
            return new InternalAppEventsLogger(context, str);
        }

        @JvmStatic
        public final InternalAppEventsLogger createInstance(String activityName, String str, AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            return new InternalAppEventsLogger(activityName, str, accessToken);
        }
    }

    public InternalAppEventsLogger(AppEventsLoggerImpl loggerImpl) {
        Intrinsics.checkNotNullParameter(loggerImpl, "loggerImpl");
        this.loggerImpl = loggerImpl;
    }

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(Context context) {
        return Companion.createInstance(context);
    }

    @JvmStatic
    public static final Executor getAnalyticsExecutor() {
        return Companion.getAnalyticsExecutor();
    }

    @JvmStatic
    public static final AppEventsLogger.FlushBehavior getFlushBehavior() {
        return Companion.getFlushBehavior();
    }

    @JvmStatic
    public static final String getPushNotificationsRegistrationId() {
        return Companion.getPushNotificationsRegistrationId();
    }

    public static /* synthetic */ void logEventImplicitly$default(InternalAppEventsLogger internalAppEventsLogger, String str, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            operationalData = null;
        }
        internalAppEventsLogger.logEventImplicitly(str, bigDecimal, currency, bundle, operationalData);
    }

    public static /* synthetic */ void logPurchaseImplicitly$default(InternalAppEventsLogger internalAppEventsLogger, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            operationalData = null;
        }
        internalAppEventsLogger.logPurchaseImplicitly(bigDecimal, currency, bundle, operationalData);
    }

    @JvmStatic
    public static final void setInternalUserData(Map<String, String> map) {
        Companion.setInternalUserData(map);
    }

    @JvmStatic
    public static final void setUserData(Bundle bundle) {
        Companion.setUserData(bundle);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    public final void logChangedSettingsEvent(Bundle parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        if (((parameters.getInt("previous") & 2) != 0) || FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly("fb_sdk_settings_changed", null, parameters);
        }
    }

    public final void logEvent(String str, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, bundle);
        }
    }

    public final void logEventFromSE(String str, String str2) {
        this.loggerImpl.logEventFromSE(str, str2);
    }

    public final void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, bigDecimal, currency, bundle, operationalData);
        }
    }

    public final void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle, OperationalData operationalData) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logPurchaseImplicitly(bigDecimal, currency, bundle, operationalData);
        }
    }

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(Context context, String str) {
        return Companion.createInstance(context, str);
    }

    public InternalAppEventsLogger(Context context) {
        this(new AppEventsLoggerImpl(context, (String) null, (AccessToken) null));
    }

    @JvmStatic
    public static final InternalAppEventsLogger createInstance(String str, String str2, AccessToken accessToken) {
        return Companion.createInstance(str, str2, accessToken);
    }

    public final void logEvent(String str, double d3, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEvent(str, d3, bundle);
        }
    }

    public final void logEventImplicitly(String str) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, null, null);
        }
    }

    public InternalAppEventsLogger(Context context, String str) {
        this(new AppEventsLoggerImpl(context, str, (AccessToken) null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InternalAppEventsLogger(String activityName, String str, AccessToken accessToken) {
        this(new AppEventsLoggerImpl(activityName, str, accessToken));
        Intrinsics.checkNotNullParameter(activityName, "activityName");
    }

    public final void logEventImplicitly(String str, Double d3, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, d3, bundle);
        }
    }

    public final void logEventImplicitly(String str, Bundle bundle) {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            this.loggerImpl.logEventImplicitly(str, null, bundle);
        }
    }
}
