package cz.mobilesoft.coreblock.util;

import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesException;
import cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor;
import cz.mobilesoft.coreblock.storage.datastore.RatingDataStore;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.exception.RevenueCatException;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
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
public final class CrashHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CrashHelper f127788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f127789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Mutex f127790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f127791d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f127792f;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final CrashHelper crashHelper = new CrashHelper();
        f127788a = crashHelper;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f127789b = LazyKt.a(lazyThreadSafetyModeB, new Function0<RatingDataStore>() { // from class: cz.mobilesoft.coreblock.util.CrashHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = crashHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(RatingDataStore.class), qualifier, objArr);
            }
        });
        f127790c = MutexKt.b(false, 1, null);
        f127791d = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CrashHelper.b();
            }
        });
        f127792f = 8;
    }

    private CrashHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FirebaseCrashlytics b() {
        try {
            return FirebaseCrashlytics.c();
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private final FirebaseCrashlytics c() {
        return (FirebaseCrashlytics) f127791d.getValue();
    }

    private final String d() {
        SessionManager sessionManager = SessionManager.f127910a;
        if (sessionManager.r()) {
            Object value = sessionManager.l().getValue();
            SessionManager.SignedIn signedIn = value instanceof SessionManager.SignedIn ? (SessionManager.SignedIn) value : null;
            if (signedIn != null) {
                return signedIn.a();
            }
        }
        return null;
    }

    private final RatingDataStore e() {
        return (RatingDataStore) f127789b.getValue();
    }

    public static /* synthetic */ Object g(CrashHelper crashHelper, String str, Integer num, String str2, ErrorLogInterceptor.ApiErrorDetails apiErrorDetails, List list, List list2, Throwable th, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            apiErrorDetails = null;
        }
        if ((i3 & 64) != 0) {
            th = null;
        }
        return crashHelper.f(str, num, str2, apiErrorDetails, list, list2, th, continuation);
    }

    public static final void j(Throwable th) {
        FirebaseCrashlytics firebaseCrashlyticsC;
        if (th == null || (firebaseCrashlyticsC = f127788a.c()) == null) {
            return;
        }
        firebaseCrashlyticsC.f(th);
    }

    public static /* synthetic */ void m(CrashHelper crashHelper, PurchasesException purchasesException, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        crashHelper.l(purchasesException, str, str2);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017e A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0184 A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019a A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a5 A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b0 A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d4 A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01da A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f9 A[Catch: all -> 0x0066, Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:13:0x0061, B:49:0x016c, B:52:0x017e, B:54:0x018b, B:56:0x019a, B:58:0x01a5, B:60:0x01b0, B:61:0x01b5, B:63:0x01d4, B:68:0x01f0, B:70:0x01f9, B:71:0x0204, B:73:0x020a, B:74:0x0214, B:64:0x01da, B:65:0x01e0, B:67:0x01e6, B:53:0x0184, B:39:0x0104, B:41:0x0127, B:43:0x012d, B:45:0x0135), top: B:82:0x002b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Type inference failed for: r5v0, types: [int] */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(java.lang.String r18, java.lang.Integer r19, java.lang.String r20, cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor.ApiErrorDetails r21, java.util.List r22, java.util.List r23, java.lang.Throwable r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.CrashHelper.f(java.lang.String, java.lang.Integer, java.lang.String, cz.mobilesoft.coreblock.rest.interceptor.ErrorLogInterceptor$ApiErrorDetails, java.util.List, java.util.List, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void h(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        try {
            FirebaseCrashlytics firebaseCrashlyticsC = c();
            if (firebaseCrashlyticsC != null) {
                firebaseCrashlyticsC.e("Custom formatted error: " + message);
            }
            FirebaseCrashlytics firebaseCrashlyticsC2 = c();
            if (firebaseCrashlyticsC2 != null) {
                firebaseCrashlyticsC2.f(throwable);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void i(Throwable t2) {
        Intrinsics.checkNotNullParameter(t2, "t");
        String strD = d();
        StringBuilder sb = new StringBuilder();
        sb.append("message = " + t2.getMessage() + "\n");
        if (strD != null) {
            sb.append("\nCustomer ID = " + strD);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        h(string, t2);
    }

    public final void k(PurchasesError purchasesError, String str) {
        Intrinsics.checkNotNullParameter(purchasesError, "<this>");
        String strD = d();
        StringBuilder sb = new StringBuilder();
        sb.append("message = " + purchasesError.getMessage() + "\n");
        sb.append("underlyingErrorMessage = " + purchasesError.getUnderlyingErrorMessage() + "\n");
        sb.append("code = " + purchasesError.getCode());
        if (str != null) {
            sb.append("\nAdditional message = " + str);
        }
        if (strD != null) {
            sb.append("\nCustomer ID = " + strD);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        h(string, new RevenueCatException(purchasesError.getMessage()));
    }

    public final void l(PurchasesException purchasesException, String cause, String str) {
        Intrinsics.checkNotNullParameter(purchasesException, "<this>");
        Intrinsics.checkNotNullParameter(cause, "cause");
        String strD = d();
        StringBuilder sb = new StringBuilder();
        sb.append("Cause = " + cause + "\n");
        sb.append("message = " + purchasesException.getMessage() + "\n");
        sb.append("underlyingErrorMessage = " + purchasesException.getUnderlyingErrorMessage() + "\n");
        sb.append("code = " + purchasesException.getCode());
        if (str != null) {
            sb.append("\nAdditional message = " + str);
        }
        if (strD != null) {
            sb.append("\nCustomer ID = " + strD);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        h(string, purchasesException);
    }

    public final Object n(Continuation continuation) {
        FirebaseCrashlytics firebaseCrashlyticsC = c();
        if (firebaseCrashlyticsC == null || !firebaseCrashlyticsC.b()) {
            return Unit.f139807a;
        }
        Log.d("CrashHelper", "Crash from previous execution detected");
        Object objU0 = e().u0(System.currentTimeMillis(), continuation);
        return objU0 == IntrinsicsKt.f() ? objU0 : Unit.f139807a;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
