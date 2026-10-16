package cz.mobilesoft.coreblock.util.superwall;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.identity.PublicIdentityKt;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import cz.mobilesoft.nativecore.NativeLib;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;

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
public final class SuperwallInitializer implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SuperwallInitializer f129740a = new SuperwallInitializer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CoroutineScope f129741b = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f129742c = 8;

    private SuperwallInitializer() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(SessionManager.SignInState signInState) {
        Superwall.Companion companion = Superwall.Companion;
        if (companion.getInitialized() && (signInState instanceof SessionManager.SignedIn)) {
            String strA = ((SessionManager.SignedIn) signInState).a();
            if (StringsKt.p0(strA)) {
                strA = null;
            }
            if (strA != null) {
                Log.d("SuperwallInitializer", "Identifying Superwall user");
                PublicIdentityKt.identify$default(companion.getInstance(), strA, null, 2, null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Context context) {
        String superwallApiKey;
        Intrinsics.checkNotNullParameter(context, "context");
        if (Superwall.Companion.getInitialized()) {
            return;
        }
        try {
            NativeLib nativeLib = (NativeLib) (this instanceof KoinScopeComponent ? ((KoinScopeComponent) this).getScope() : r0().j().d()).e(Reflection.b(NativeLib.class), null, null);
            String[] strArrK = InitHelper.f129486a.k(context);
            superwallApiKey = strArrK != null ? nativeLib.getSuperwallApiKey(strArrK) : null;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            superwallApiKey = null;
        }
        if (superwallApiKey == null || superwallApiKey.length() == 0) {
            Log.e("SuperwallInitializer", "Superwall API key not available, skipping Superwall initialization");
            return;
        }
        try {
            SuperwallPurchaseController superwallPurchaseController = (SuperwallPurchaseController) (this instanceof KoinScopeComponent ? ((KoinScopeComponent) this).getScope() : r0().j().d()).e(Reflection.b(SuperwallPurchaseController.class), null, null);
            Superwall.Companion companion = Superwall.Companion;
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
            Superwall.Companion.configure$default(companion, (Application) applicationContext, superwallApiKey, superwallPurchaseController, null, null, null, 56, null);
            companion.getInstance().setDelegate(new SuperwallDelegateImpl());
            if (BuildConfig.f95357b.booleanValue()) {
                Log.d("SuperwallInitializer", "Superwall configured");
            }
            superwallPurchaseController.j();
            String strN = ((PremiumRepositoryV2) (this instanceof KoinScopeComponent ? ((KoinScopeComponent) this).getScope() : r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), null, null)).N();
            if (strN != null) {
                PublicIdentityKt.identify$default(companion.getInstance(), strN, null, 2, null);
            }
            FlowExtKt.i(SessionManager.f127910a.l(), f129741b, new FlowCollector() { // from class: cz.mobilesoft.coreblock.util.superwall.SuperwallInitializer$initialize$2
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(SessionManager.SignInState signInState, Continuation continuation) {
                    SuperwallInitializer.f129740a.d(signInState);
                    return Unit.f139807a;
                }
            });
        } catch (Exception e4) {
            Log.e("SuperwallInitializer", "Error configuring Superwall", e4);
            CrashHelper.j(e4);
        }
    }

    public final boolean c() {
        return Superwall.Companion.getInitialized();
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
