package com.facebook.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import com.facebook.CallbackManager;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class DialogPresenter {
    public static final DialogPresenter INSTANCE = new DialogPresenter();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ParameterProvider {
        Bundle getLegacyParameters();

        Bundle getParameters();
    }

    private DialogPresenter() {
    }

    @JvmStatic
    public static final boolean canPresentNativeDialogWithFeature(DialogFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return getProtocolVersionForNativeDialog(feature).getProtocolVersion() != -1;
    }

    @JvmStatic
    public static final boolean canPresentWebFallbackDialogWithFeature(DialogFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        return INSTANCE.getDialogWebFallbackUri(feature) != null;
    }

    private final Uri getDialogWebFallbackUri(DialogFeature dialogFeature) {
        String strName = dialogFeature.name();
        String action = dialogFeature.getAction();
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.Companion.getDialogFeatureConfig(FacebookSdk.getApplicationId(), action, strName);
        if (dialogFeatureConfig != null) {
            return dialogFeatureConfig.getFallbackUrl();
        }
        return null;
    }

    @JvmStatic
    public static final NativeProtocol.ProtocolVersionQueryResult getProtocolVersionForNativeDialog(DialogFeature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        String applicationId = FacebookSdk.getApplicationId();
        String action = feature.getAction();
        return NativeProtocol.getLatestAvailableProtocolVersionForAction(action, INSTANCE.getVersionSpecForFeature(applicationId, action, feature));
    }

    private final int[] getVersionSpecForFeature(String str, String str2, DialogFeature dialogFeature) {
        int[] versionSpec;
        FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig = FetchedAppSettings.Companion.getDialogFeatureConfig(str, str2, dialogFeature.name());
        return (dialogFeatureConfig == null || (versionSpec = dialogFeatureConfig.getVersionSpec()) == null) ? new int[]{dialogFeature.getMinVersion()} : versionSpec;
    }

    @JvmStatic
    public static final void logDialogActivity(Context context, String eventName, String outcome) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(outcome, "outcome");
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME, outcome);
        internalAppEventsLogger.logEventImplicitly(eventName, bundle);
    }

    @JvmStatic
    public static final void present(AppCall appCall, Activity activity) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @JvmStatic
    public static final void setupAppCallForCannotShowError(AppCall appCall) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        setupAppCallForValidationError(appCall, new FacebookException("Unable to show the provided content via the web or the installed version of the Facebook app. Some dialogs are only supported starting API 14."));
    }

    @JvmStatic
    public static final void setupAppCallForCustomTabDialog(AppCall appCall, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), CustomTabUtils.getDefaultRedirectURI());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, str);
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, bundle);
        intent.putExtra(CustomTabMainActivity.EXTRA_CHROME_PACKAGE, CustomTabUtils.getChromePackage());
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), str, NativeProtocol.getLatestKnownVersion(), null);
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void setupAppCallForErrorResult(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        if (facebookException == null) {
            return;
        }
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookActivity.PASS_THROUGH_CANCEL_ACTION);
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), null, NativeProtocol.getLatestKnownVersion(), NativeProtocol.createBundleForException(facebookException));
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void setupAppCallForNativeDialog(AppCall appCall, ParameterProvider parameterProvider, DialogFeature feature) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(parameterProvider, "parameterProvider");
        Intrinsics.checkNotNullParameter(feature, "feature");
        Context applicationContext = FacebookSdk.getApplicationContext();
        String action = feature.getAction();
        NativeProtocol.ProtocolVersionQueryResult protocolVersionForNativeDialog = getProtocolVersionForNativeDialog(feature);
        int protocolVersion = protocolVersionForNativeDialog.getProtocolVersion();
        if (protocolVersion == -1) {
            throw new FacebookException("Cannot present this dialog. This likely means that the Facebook app is not installed.");
        }
        Bundle parameters = NativeProtocol.isVersionCompatibleWithBucketedIntent(protocolVersion) ? parameterProvider.getParameters() : parameterProvider.getLegacyParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        Intent intentCreatePlatformActivityIntent = NativeProtocol.createPlatformActivityIntent(applicationContext, appCall.getCallId().toString(), action, protocolVersionForNativeDialog, parameters);
        if (intentCreatePlatformActivityIntent == null) {
            throw new FacebookException("Unable to create Intent; this likely means theFacebook app is not installed.");
        }
        appCall.setRequestIntent(intentCreatePlatformActivityIntent);
    }

    @JvmStatic
    public static final void setupAppCallForValidationError(AppCall appCall, FacebookException facebookException) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        setupAppCallForErrorResult(appCall, facebookException);
    }

    @JvmStatic
    public static final void setupAppCallForWebDialog(AppCall appCall, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        Bundle bundle2 = new Bundle();
        bundle2.putString("action", str);
        bundle2.putBundle(NativeProtocol.WEB_DIALOG_PARAMS, bundle);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), str, NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void setupAppCallForWebFallbackDialog(AppCall appCall, Bundle bundle, DialogFeature feature) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(feature, "feature");
        Validate.hasFacebookActivity(FacebookSdk.getApplicationContext());
        Validate.hasInternetPermissions(FacebookSdk.getApplicationContext());
        String strName = feature.name();
        Uri dialogWebFallbackUri = INSTANCE.getDialogWebFallbackUri(feature);
        if (dialogWebFallbackUri == null) {
            throw new FacebookException("Unable to fetch the Url for the DialogFeature : '" + strName + '\'');
        }
        int latestKnownVersion = NativeProtocol.getLatestKnownVersion();
        String string = appCall.getCallId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "appCall.callId.toString()");
        Bundle queryParamsForPlatformActivityIntentWebFallback = ServerProtocol.getQueryParamsForPlatformActivityIntentWebFallback(string, latestKnownVersion, bundle);
        if (queryParamsForPlatformActivityIntentWebFallback == null) {
            throw new FacebookException("Unable to fetch the app's key-hash");
        }
        Uri uriBuildUri = dialogWebFallbackUri.isRelative() ? Utility.buildUri(ServerProtocol.getDialogAuthority(), dialogWebFallbackUri.toString(), queryParamsForPlatformActivityIntentWebFallback) : Utility.buildUri(dialogWebFallbackUri.getAuthority(), dialogWebFallbackUri.getPath(), queryParamsForPlatformActivityIntentWebFallback);
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", uriBuildUri.toString());
        bundle2.putBoolean(NativeProtocol.WEB_DIALOG_IS_FALLBACK, true);
        Intent intent = new Intent();
        NativeProtocol.setupProtocolRequestIntent(intent, appCall.getCallId().toString(), feature.getAction(), NativeProtocol.getLatestKnownVersion(), bundle2);
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(FacebookDialogFragment.TAG);
        appCall.setRequestIntent(intent);
    }

    @JvmStatic
    public static final void startActivityForResultWithAndroidX(ActivityResultRegistry registry, final CallbackManager callbackManager, Intent intent, final int i3) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(intent, "intent");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ActivityResultLauncher activityResultLauncherL = registry.l("facebook-dialog-request-" + i3, new ActivityResultContract<Intent, Pair<Integer, Intent>>() { // from class: com.facebook.internal.DialogPresenter.startActivityForResultWithAndroidX.1
            @Override // androidx.activity.result.contract.ActivityResultContract
            public Intent createIntent(Context context, Intent input) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(input, "input");
                return input;
            }

            @Override // androidx.activity.result.contract.ActivityResultContract
            public Pair<Integer, Intent> parseResult(int i4, Intent intent2) {
                Pair<Integer, Intent> pairCreate = Pair.create(Integer.valueOf(i4), intent2);
                Intrinsics.checkNotNullExpressionValue(pairCreate, "create(resultCode, intent)");
                return pairCreate;
            }
        }, new ActivityResultCallback() { // from class: com.facebook.internal.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                DialogPresenter.startActivityForResultWithAndroidX$lambda$2(callbackManager, i3, objectRef, (Pair) obj);
            }
        });
        objectRef.f140144a = activityResultLauncherL;
        if (activityResultLauncherL != null) {
            activityResultLauncherL.b(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startActivityForResultWithAndroidX$lambda$2(CallbackManager callbackManager, int i3, Ref.ObjectRef launcher, Pair pair) {
        Intrinsics.checkNotNullParameter(launcher, "$launcher");
        if (callbackManager == null) {
            callbackManager = new CallbackManagerImpl();
        }
        Object obj = pair.first;
        Intrinsics.checkNotNullExpressionValue(obj, "result.first");
        callbackManager.onActivityResult(i3, ((Number) obj).intValue(), (Intent) pair.second);
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) launcher.f140144a;
        if (activityResultLauncher != null) {
            synchronized (activityResultLauncher) {
                activityResultLauncher.d();
                launcher.f140144a = null;
                Unit unit = Unit.f139807a;
            }
        }
    }

    @JvmStatic
    public static final void present(AppCall appCall, FragmentWrapper fragmentWrapper) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(fragmentWrapper, "fragmentWrapper");
        fragmentWrapper.startActivityForResult(appCall.getRequestIntent(), appCall.getRequestCode());
        appCall.setPending();
    }

    @JvmStatic
    public static final void present(AppCall appCall, ActivityResultRegistry registry, CallbackManager callbackManager) {
        Intrinsics.checkNotNullParameter(appCall, "appCall");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intent requestIntent = appCall.getRequestIntent();
        if (requestIntent == null) {
            return;
        }
        startActivityForResultWithAndroidX(registry, callbackManager, requestIntent, appCall.getRequestCode());
        appCall.setPending();
    }
}
