package cz.mobilesoft.coreblock.scene.premium.utils;

import android.content.Context;
import cz.mobilesoft.coreblock.util.monetization.OnboardingPaywallRouter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class IntroPremiumScreenHelperKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113987a;

        static {
            int[] iArr = new int[OnboardingPaywallRouter.Screen.values().length];
            try {
                iArr[OnboardingPaywallRouter.Screen.Generic.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OnboardingPaywallRouter.Screen.IntroTrialToggle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OnboardingPaywallRouter.Screen.IntroTrial.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f113987a = iArr;
        }
    }

    private static final String a(OnboardingPaywallRouter.Route route) {
        if (Intrinsics.areEqual(route, OnboardingPaywallRouter.Route.NoPaywall.f128884a)) {
            return "no paywall - premium already active";
        }
        if (Intrinsics.areEqual(route, OnboardingPaywallRouter.Route.DeeplinkOffer.f128883a)) {
            return "deeplink campaign / referral paywall";
        }
        if (!(route instanceof OnboardingPaywallRouter.Route.ShowScreen)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sb = new StringBuilder();
        OnboardingPaywallRouter.Route.ShowScreen showScreen = (OnboardingPaywallRouter.Route.ShowScreen) route;
        sb.append(showScreen.a().name());
        if (showScreen.b()) {
            sb.append(" or Superwall");
        }
        sb.append(" (");
        sb.append(showScreen.c() ? "closable" : showScreen.d() ? "skippable" : "no way out");
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x06c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x06d7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x070e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x04a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x04c7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0525 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0528  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(android.content.Context r41, java.lang.Integer r42, boolean r43, boolean r44, boolean r45, kotlin.coroutines.Continuation r46) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1912
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt.b(android.content.Context, java.lang.Integer, boolean, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object c(Context context, Integer num, boolean z2, boolean z3, boolean z4, Continuation continuation, int i3, Object obj) {
        boolean z5;
        Continuation continuation2;
        boolean z6;
        boolean z7;
        Context context2;
        if ((i3 & 1) != 0) {
            num = null;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        if ((i3 & 8) != 0) {
            z5 = false;
            z6 = z2;
            continuation2 = continuation;
            context2 = context;
            z7 = z3;
        } else {
            z5 = z4;
            continuation2 = continuation;
            z6 = z2;
            z7 = z3;
            context2 = context;
        }
        return b(context2, num, z6, z7, z5, continuation2);
    }
}
