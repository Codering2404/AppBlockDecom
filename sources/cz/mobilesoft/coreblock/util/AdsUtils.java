package cz.mobilesoft.coreblock.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import androidx.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ads.BaseAdsUtils;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AdsUtils extends BaseAdsUtils<Integer> implements KoinComponent {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AdsUtils f127678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final CoroutineScope f127679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f127680k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f127681l;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final AdsUtils adsUtils = new AdsUtils();
        f127678i = adsUtils;
        final Qualifier qualifier = null;
        f127679j = CoroutineScopeKt.a(Dispatchers.b().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Object[] objArr = 0 == true ? 1 : 0;
        f127680k = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.util.AdsUtils$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = adsUtils;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        f127681l = 8;
    }

    private AdsUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Activity activity, BaseAdsUtils.ConsentFormCallback consentFormCallback, FormError formError) {
        String str = "onConsentFormLoadFailure, error " + formError.getErrorCode() + ": " + formError.getMessage();
        String simpleName = AdsUtils.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.e(simpleName, str);
        int consentStatus = f127678i.D(activity).getConsentStatus();
        FacebookSdk.setAdvertiserIDCollectionEnabled(consentStatus == 1);
        consentFormCallback.l(Integer.valueOf(consentStatus), false);
    }

    public static final AdSize B(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        AdSize adSizeA = AdSize.a(context, (int) (displayMetrics.widthPixels / displayMetrics.density));
        Intrinsics.checkNotNullExpressionValue(adSizeA, "getCurrentOrientationAnc…AdaptiveBannerAdSize(...)");
        return adSizeA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RequestConfiguration C() {
        RequestConfiguration requestConfigurationA = new RequestConfiguration.Builder().b(f()).a();
        Intrinsics.checkNotNullExpressionValue(requestConfigurationA, "build(...)");
        return requestConfigurationA;
    }

    private final ConsentInformation D(Context context) {
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(context);
        Intrinsics.checkNotNullExpressionValue(consentInformation, "getConsentInformation(...)");
        return consentInformation;
    }

    private final ConsentRequestParameters E() {
        ConsentRequestParameters consentRequestParametersBuild = new ConsentRequestParameters.Builder().setTagForUnderAgeOfConsent(false).build();
        Intrinsics.checkNotNullExpressionValue(consentRequestParametersBuild, "build(...)");
        return consentRequestParametersBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreDataStore F() {
        return (CoreDataStore) f127680k.getValue();
    }

    public static final AdRequest r(Boolean bool) {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            Bundle bundle = new Bundle();
            bundle.putString("npa", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            builder.c(AdMobAdapter.class, bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString("applovin.sdk.npa", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            builder.c(AppLovinMediationAdapter.class, bundle2);
        }
        AdRequest adRequestM = builder.m();
        Intrinsics.checkNotNullExpressionValue(adRequestM, "build(...)");
        return adRequestM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(ConsentInformation consentInformation, Activity activity, Function1 function1) {
        BuildersKt__Builders_commonKt.d(f127679j, null, null, new AdsUtils$checkAdConsent$1$1(consentInformation, activity, function1, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 function1, FormError formError) {
        FacebookSdk.setAdvertiserIDCollectionEnabled(false);
        function1.invoke(0);
        String str = "onConsentInfoUpdateFailure, error " + formError.getErrorCode() + ": " + formError.getMessage();
        String simpleName = AdsUtils.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        Log.d(simpleName, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Context context) {
        SharedPreferences sharedPreferencesB = PreferenceManager.b(context);
        List list = CollectionsKt.toList(sharedPreferencesB.getAll().keySet());
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            String str = (String) obj;
            Intrinsics.checkNotNull(str);
            if (StringsKt.S(str, "IABTCF", true)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Intrinsics.checkNotNull(sharedPreferencesB);
        SharedPreferences.Editor editorEdit = sharedPreferencesB.edit();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            editorEdit.remove((String) obj2);
        }
        editorEdit.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(final Activity activity, final BaseAdsUtils.ConsentFormCallback consentFormCallback, ConsentForm consentForm) {
        consentForm.show(activity, new ConsentForm.OnConsentFormDismissedListener() { // from class: cz.mobilesoft.coreblock.util.e
            @Override // com.google.android.ump.ConsentForm.OnConsentFormDismissedListener
            public final void onConsentFormDismissed(FormError formError) {
                AdsUtils.z(activity, consentFormCallback, formError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Activity activity, BaseAdsUtils.ConsentFormCallback consentFormCallback, FormError formError) {
        CoroutinesHelperExtKt.d(new AdsUtils$displayConsentForm$1$1$1$1(null));
        int consentStatus = f127678i.D(activity).getConsentStatus();
        if (formError != null) {
            String str = "onConsentFormDismissed, consent status is code " + consentStatus + ", error " + formError.getErrorCode() + ": " + formError.getMessage();
            String simpleName = AdsUtils.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            Log.e(simpleName, str);
        } else {
            String simpleName2 = AdsUtils.class.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName2, "getSimpleName(...)");
            Log.d(simpleName2, "onConsentFormDismissed, consent status is code " + consentStatus);
        }
        FacebookSdk.setAdvertiserIDCollectionEnabled(consentStatus == 3);
        consentFormCallback.l(Integer.valueOf(consentStatus), false);
    }

    public void G(Context context, Function0 callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            BuildersKt__Builders_commonKt.d(f127679j, null, null, new AdsUtils$initAds$1(context, callback, null), 3, null);
        } catch (SecurityException e3) {
            e3.printStackTrace();
            CrashHelper.j(e3);
        }
    }

    public Boolean H(Integer num) {
        return null;
    }

    @Override // cz.mobilesoft.coreblock.util.ads.BaseAdsUtils
    public String e() {
        return "B3EEABB8EE11C2BE770B684D95219ECB";
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final void s(final Activity activity, final Function1 callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final ConsentInformation consentInformationD = D(activity);
        consentInformationD.requestConsentInfoUpdate(activity, E(), new ConsentInformation.OnConsentInfoUpdateSuccessListener() { // from class: cz.mobilesoft.coreblock.util.a
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateSuccessListener
            public final void onConsentInfoUpdateSuccess() {
                AdsUtils.t(consentInformationD, activity, callback);
            }
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() { // from class: cz.mobilesoft.coreblock.util.b
            @Override // com.google.android.ump.ConsentInformation.OnConsentInfoUpdateFailureListener
            public final void onConsentInfoUpdateFailure(FormError formError) {
                AdsUtils.u(callback, formError);
            }
        });
    }

    public void v(Context context, BaseAdsUtils.ConsentLocationCheckCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Boolean boolF1 = PrefManager.f126839a.F1();
        if (boolF1 != null) {
            callback.b(boolF1.booleanValue());
        } else {
            callback.a();
        }
    }

    public void x(final Activity activity, final BaseAdsUtils.ConsentFormCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (activity != null) {
            UserMessagingPlatform.loadConsentForm(activity, new UserMessagingPlatform.OnConsentFormLoadSuccessListener() { // from class: cz.mobilesoft.coreblock.util.c
                @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadSuccessListener
                public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
                    AdsUtils.y(activity, callback, consentForm);
                }
            }, new UserMessagingPlatform.OnConsentFormLoadFailureListener() { // from class: cz.mobilesoft.coreblock.util.d
                @Override // com.google.android.ump.UserMessagingPlatform.OnConsentFormLoadFailureListener
                public final void onConsentFormLoadFailure(FormError formError) {
                    AdsUtils.A(activity, callback, formError);
                }
            });
        }
    }
}
