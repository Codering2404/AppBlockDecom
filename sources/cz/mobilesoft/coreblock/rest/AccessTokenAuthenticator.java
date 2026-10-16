package cz.mobilesoft.coreblock.rest;

import android.util.Log;
import cz.mobilesoft.coreblock.rest.request.TokenRefreshRequest;
import cz.mobilesoft.coreblock.rest.response.TokenResponse;
import cz.mobilesoft.coreblock.storage.datastore.SessionDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.flowproperty.BlockingFlowProperty;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.Route;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;
import retrofit2.Response;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AccessTokenAuthenticator implements Authenticator, KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f98442b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f98443c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f98444a;

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
    public AccessTokenAuthenticator() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f98444a = LazyKt.a(lazyThreadSafetyModeB, new Function0<SessionDataStore>() { // from class: cz.mobilesoft.coreblock.rest.AccessTokenAuthenticator$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SessionDataStore.class), qualifier, objArr);
            }
        });
    }

    private final void b() {
        CoroutinesHelperExtKt.d(new AccessTokenAuthenticator$forceLogout$1(null));
    }

    private final SessionDataStore c() {
        return (SessionDataStore) this.f98444a.getValue();
    }

    private final String d() {
        try {
            Response responseD = RestClient.f98457a.I().e(new TokenRefreshRequest((String) new BlockingFlowProperty(c().M()).b())).d();
            Log.d("Authenticator", "refreshToken authenticator isSuccessful: " + responseD.e());
            if (!responseD.e()) {
                ResponseBody responseBodyD = responseD.d();
                Log.e("Authenticator", "refreshToken authenticator success onResponse errorBody: " + (responseBodyD != null ? responseBodyD.l() : null));
                if (responseD.b() == 401) {
                    b();
                }
                return null;
            }
            Object objA = responseD.a();
            Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type cz.mobilesoft.coreblock.rest.response.TokenResponse");
            TokenResponse tokenResponse = (TokenResponse) objA;
            String token = tokenResponse.getToken();
            SessionManager.f127910a.C(tokenResponse.getToken(), tokenResponse.getRefreshToken());
            Log.d("Authenticator", "refreshToken authenticator success onResponse: " + tokenResponse);
            return token;
        } catch (Exception e3) {
            Log.e("Authenticator", "refreshToken authenticator onResponse: " + e3);
            return null;
        }
    }

    @Override // okhttp3.Authenticator
    public Request a(Route route, okhttp3.Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Log.d("Authenticator", "start");
        SessionManager sessionManager = SessionManager.f127910a;
        String strN = sessionManager.n();
        if (strN == null) {
            return null;
        }
        Log.d("Authenticator", "start with token currentToken: " + strN);
        synchronized (this) {
            String strD = d();
            Log.d("Authenticator", "synchronized newToken: " + strD);
            if (strD == null) {
                return null;
            }
            if (response.N().d("Authorization") == null) {
                Unit unit = Unit.f139807a;
                return null;
            }
            Log.d("Authenticator", "header not null");
            if (Intrinsics.areEqual(strD, strN)) {
                String strG = sessionManager.g();
                if (strG == null) {
                    return null;
                }
                return response.N().i().i("Authorization").a("Authorization", strG).b();
            }
            Log.d("Authenticator", "header is refreshed newToken: \"" + strD + "\"");
            return response.N().i().i("Authorization").a("Authorization", "Bearer " + strD).b();
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
