package cz.mobilesoft.coreblock.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.revenuecat.purchases.Purchases;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase;
import cz.mobilesoft.coreblock.util.DeeplinkResult;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DeeplinkRouter implements KoinComponent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f127850c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f127851d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127853b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeeplinkRouter() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127852a = LazyKt.a(lazyThreadSafetyModeB, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.util.DeeplinkRouter$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f127853b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CheckGuestPassEligibilityUseCase>() { // from class: cz.mobilesoft.coreblock.util.DeeplinkRouter$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CheckGuestPassEligibilityUseCase.class), objArr2, objArr3);
            }
        });
    }

    private final boolean b(Context context, DeeplinkResult deeplinkResult, CoroutineScope coroutineScope) {
        if (deeplinkResult instanceof DeeplinkResult.Unhandled) {
            Log.w("DeeplinkRouter", "Unhandled deeplink result");
            return false;
        }
        if (deeplinkResult instanceof DeeplinkResult.Welcome) {
            Purchases purchasesL = d().L();
            if (purchasesL != null) {
                purchasesL.setMediaSource("welcome_mail");
            }
            AnswersHelper.f128199a.q8();
            return true;
        }
        if (deeplinkResult instanceof DeeplinkResult.Login) {
            AnswersHelper.f128199a.J2();
            context.startActivity(SessionManager.f127910a.r() ? AccountDetailActivity.f101090f.a(context) : SignInActivity.f110366h.a(context, new SignInConfig(SignInEntryPoint.DEEPLINK, null, false, false, true, false, false, false, false, false, null, 1966, null)));
            return true;
        }
        if (deeplinkResult instanceof DeeplinkResult.Email) {
            String strA = ((DeeplinkResult.Email) deeplinkResult).a();
            if (strA != null) {
                AnswersHelper.f128199a.J1(strA);
            }
            return true;
        }
        if (deeplinkResult instanceof DeeplinkResult.Campaign) {
            AnswersHelper.f128199a.Z3();
            if (d().J().g()) {
                g(context);
            } else {
                context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.Campaign(((DeeplinkResult.Campaign) deeplinkResult).a(), CampaignSource.DeepLink, "unknown"), SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, false, false, false, null, 240, null));
            }
            return true;
        }
        if (deeplinkResult instanceof DeeplinkResult.Referral) {
            h(context);
            return true;
        }
        if (deeplinkResult instanceof DeeplinkResult.Premium) {
            g(context);
            return true;
        }
        if (deeplinkResult instanceof DeeplinkResult.GuestPass) {
            f(context, coroutineScope);
            return true;
        }
        if ((deeplinkResult instanceof DeeplinkResult.SoftPaywall) || (deeplinkResult instanceof DeeplinkResult.Meta) || (deeplinkResult instanceof DeeplinkResult.FinishRegistration)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CheckGuestPassEligibilityUseCase c() {
        return (CheckGuestPassEligibilityUseCase) this.f127853b.getValue();
    }

    private final PremiumRepositoryV2 d() {
        return (PremiumRepositoryV2) this.f127852a.getValue();
    }

    private final void f(Context context, CoroutineScope coroutineScope) {
        BuildersKt__Builders_commonKt.d(coroutineScope, Dispatchers.b(), null, new DeeplinkRouter$handleGuestPass$1(this, context, null), 2, null);
    }

    private final void g(Context context) {
        Context context2;
        Intent intentC;
        AnswersHelper.f128199a.Z3();
        if (d().J().g()) {
            Paywall paywall = Paywall.f113165a;
            String string = context.getString(R.string.vk);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            intentC = Paywall.c(paywall, context, new PaywallTarget.MySubscription(string), SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "premium", false, false, false, null, 240, null);
            context2 = context;
        } else {
            context2 = context;
            intentC = Paywall.c(Paywall.f113165a, context2, PaywallTarget.Generic.INSTANCE, SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, false, false, false, null, 240, null);
        }
        context2.startActivity(intentC);
    }

    private final boolean h(Context context) {
        AnswersHelper.f128199a.Z3();
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.Discount(RevenueCatPlacement.ReferralReceived, DiscountSource.REFERRAL_RECEIVER, false, null), "blocking_tab", null, false, false, false, null, 248, null));
        return true;
    }

    private final DeeplinkResult k(Uri uri) {
        Uri uri2;
        try {
            String path = uri.getPath();
            String lastPathSegment = (path == null || (uri2 = Uri.parse(path)) == null) ? null : uri2.getLastPathSegment();
            Log.d("DeeplinkRouter", "Opening dashboard for " + lastPathSegment);
            return new DeeplinkResult.Email(lastPathSegment);
        } catch (Exception e3) {
            Log.e("DeeplinkRouter", "Error handling email deeplink", e3);
            CrashHelper.j(e3);
            return DeeplinkResult.Unhandled.f127848a;
        }
    }

    private final DeeplinkResult l(Uri uri) {
        String queryParameter = uri.getQueryParameter(AuthenticationTokenClaims.JSON_KEY_EMAIL);
        return (queryParameter == null || StringsKt.p0(queryParameter)) ? DeeplinkResult.Unhandled.f127848a : new DeeplinkResult.FinishRegistration(queryParameter);
    }

    private final DeeplinkResult m(Uri uri, List list) {
        if (list.contains("referral")) {
            return DeeplinkResult.Referral.f127846a;
        }
        String queryParameter = uri.getQueryParameter("campaign");
        Long lW = queryParameter != null ? StringsKt.w(queryParameter) : null;
        return lW != null ? new DeeplinkResult.Campaign(lW.longValue()) : DeeplinkResult.Premium.f127845a;
    }

    private final DeeplinkResult n(List list, Uri uri) {
        if (list.contains("guest-pass")) {
            return DeeplinkResult.GuestPass.f127842a;
        }
        if (list.contains("referral")) {
            return DeeplinkResult.Referral.f127846a;
        }
        if (list.contains("soft-paywall")) {
            return DeeplinkResult.SoftPaywall.f127847a;
        }
        if (list.contains("meta")) {
            return DeeplinkResult.Meta.f127844a;
        }
        List list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (StringsKt.F((String) it.next(), "finish-registration", true)) {
                    return l(uri);
                }
            }
        }
        if (list.size() == 1) {
            return DeeplinkResult.Premium.f127845a;
        }
        int iIndexOf = list.indexOf("campaign");
        String str = (String) CollectionsKt.getOrNull(list, iIndexOf + 1);
        Long lW = str != null ? StringsKt.w(str) : null;
        return (iIndexOf < 0 || lW == null) ? DeeplinkResult.Unhandled.f127848a : new DeeplinkResult.Campaign(lW.longValue());
    }

    public final Intent e(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        DeeplinkResult deeplinkResultI = i(uri);
        if (deeplinkResultI instanceof DeeplinkResult.Referral) {
            return Paywall.c(Paywall.f113165a, context, new PaywallTarget.Discount(RevenueCatPlacement.ReferralReceived, DiscountSource.REFERRAL_RECEIVER, false, null), "blocking_tab", null, false, false, false, null, 248, null);
        }
        if (deeplinkResultI instanceof DeeplinkResult.Campaign) {
            return Paywall.c(Paywall.f113165a, context, new PaywallTarget.Campaign(((DeeplinkResult.Campaign) deeplinkResultI).a(), CampaignSource.DeepLink, "unknown"), SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, false, false, false, null, 240, null);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        if (r1.equals("promo") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007c, code lost:
    
        if (r1.equals("premium") == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00bc, code lost:
    
        return n(r0, r5);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final cz.mobilesoft.coreblock.util.DeeplinkResult i(android.net.Uri r5) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.DeeplinkRouter.i(android.net.Uri):cz.mobilesoft.coreblock.util.DeeplinkResult");
    }

    public final DeeplinkResult j(String deeplink) {
        Object objB;
        Intrinsics.checkNotNullParameter(deeplink, "deeplink");
        if (deeplink.length() == 0) {
            return DeeplinkResult.Unhandled.f127848a;
        }
        try {
            Result.Companion companion = Result.f139772b;
            objB = Result.b(i(Uri.parse(deeplink)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f139772b;
            objB = Result.b(ResultKt.a(th));
        }
        DeeplinkResult.Unhandled unhandled = DeeplinkResult.Unhandled.f127848a;
        if (Result.g(objB)) {
            objB = unhandled;
        }
        return (DeeplinkResult) objB;
    }

    public final boolean o(Context context, Uri uri, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Log.d("DeeplinkRouter", "Routing deeplink: " + uri);
        return b(context, i(uri), coroutineScope);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
