package cz.mobilesoft.coreblock.util.runnability;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import com.evernote.android.job.JobManager;
import com.facebook.internal.NativeProtocol;
import com.jakewharton.threetenabp.AndroidThreeTen;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.model.RemoteConfig;
import cz.mobilesoft.coreblock.service.job.JobPlanner;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.FlavoredInitHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.nativecore.NativeLib;
import cz.mobilesoft.statistics.api.Statistics;
import cz.mobilesoft.statistics.di.AppModuleKt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.Koin;
import org.koin.core.KoinApplication;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.context.DefaultContextExtKt;

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
public final class InitHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InitHelper f129486a = new InitHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final InitHelper$ioScope$1 f129487b = new InitHelper$ioScope$1();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f129488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final MutableStateFlow f129489d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final StateFlow f129490f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set f129491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f129492h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OnInitializedListener {
        void onInitialized();
    }

    static {
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(null);
        f129489d = mutableStateFlowA;
        f129490f = FlowKt.c(mutableStateFlowA);
        f129491g = new LinkedHashSet();
        f129492h = 8;
    }

    private InitHelper() {
    }

    public static final void h(OnInitializedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!f129488c) {
            Log.d("InitHelper", "Adding listener of " + listener.getClass().getSimpleName());
            f129491g.add(listener);
            return;
        }
        Log.d("InitHelper", "Trying to add listener of " + listener.getClass().getSimpleName() + ", already initialized, firing");
        listener.onInitialized();
    }

    public static final void l() {
        if (BuildConfig.f95356a.booleanValue()) {
            return;
        }
        try {
            RemoteConfig.B(RemoteConfig.f97054c, false, 1, null);
        } catch (IllegalStateException unused) {
        }
    }

    public static final void m(LockieApplication application, final Context context) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(context, "context");
        String strH = application.h();
        boolean zO = application.o();
        AndroidThreeTen.b(context);
        AndroidThreeTen.a(application);
        Log.d("InitHelper", "Starting application initialization for process " + strH);
        DefaultContextExtKt.a(new Function1() { // from class: cz.mobilesoft.coreblock.util.runnability.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InitHelper.n(context, (KoinApplication) obj);
            }
        });
        if (!BuildConfig.f95356a.booleanValue() || !zO) {
            FlavoredInitHelper.f127873a.a(application, strH);
        }
        JobManager.i(application).c(JobPlanner.b());
        Statistics.W(new Function1() { // from class: cz.mobilesoft.coreblock.util.runnability.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return InitHelper.o((Throwable) obj);
            }
        });
        InitHelper$ioScope$1 initHelper$ioScope$1 = f129487b;
        BuildersKt__Builders_commonKt.d(initHelper$ioScope$1, null, null, new InitHelper$initApplication$3(null), 3, null);
        if (!zO) {
            BuildersKt__Builders_commonKt.d(initHelper$ioScope$1, null, null, new InitHelper$initApplication$5(context, null), 3, null);
            return;
        }
        StringHelper stringHelper = StringHelper.f128649a;
        Intrinsics.checkNotNull(strH);
        WebView.setDataDirectorySuffix(stringHelper.k(strH));
        Log.d("InitHelper", "Finished application initialization for process " + strH);
        BuildersKt__Builders_commonKt.d(initHelper$ioScope$1, null, null, new InitHelper$initApplication$4(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Context context, KoinApplication startKoin) {
        Intrinsics.checkNotNullParameter(startKoin, "$this$startKoin");
        KoinExtKt.a(startKoin, context);
        startKoin.e(CollectionsKt.plus((Collection) AppModuleKt.i(), (Iterable) cz.mobilesoft.coreblock.di.AppModuleKt.s3()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Throwable th) {
        CrashHelper.j(th);
        return Unit.f139807a;
    }

    public static final boolean p(PackageManager packageManager, String str) {
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        if (str == null) {
            return false;
        }
        try {
            packageManager.getPackageInfo(str, 1);
            return true;
        } catch (Exception e3) {
            if (e3 instanceof PackageManager.NameNotFoundException) {
                return false;
            }
            CrashHelper.j(e3);
            return false;
        }
    }

    public static final boolean q(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List listI = f129486a.i(context, intent);
        return !(listI == null || listI.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(Continuation continuation) {
        Object objG = BuildersKt.g(Dispatchers.c(), new InitHelper$onInitialized$2(null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    public static final void t(OnInitializedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        try {
            Log.d("InitHelper", "Removing listener of " + listener.getClass().getSimpleName());
            f129491g.remove(listener);
        } catch (Exception e3) {
            try {
                CrashHelper.j(e3);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(java.lang.String r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.util.runnability.InitHelper$safeInitStep$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.util.runnability.InitHelper$safeInitStep$1 r0 = (cz.mobilesoft.coreblock.util.runnability.InitHelper$safeInitStep$1) r0
            int r1 = r0.f129553f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f129553f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.runnability.InitHelper$safeInitStep$1 r0 = new cz.mobilesoft.coreblock.util.runnability.InitHelper$safeInitStep$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f129551c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f129553f
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.f129550b
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.Object r5 = r0.f129549a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Exception -> L31 java.util.concurrent.CancellationException -> L33
            goto L6a
        L31:
            r6 = move-exception
            goto L51
        L33:
            r5 = move-exception
            goto L6d
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.b(r7)
            r0.f129549a = r5     // Catch: java.lang.Exception -> L31 java.util.concurrent.CancellationException -> L33
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)     // Catch: java.lang.Exception -> L31 java.util.concurrent.CancellationException -> L33
            r0.f129550b = r7     // Catch: java.lang.Exception -> L31 java.util.concurrent.CancellationException -> L33
            r0.f129553f = r3     // Catch: java.lang.Exception -> L31 java.util.concurrent.CancellationException -> L33
            java.lang.Object r5 = r6.invoke(r0)     // Catch: java.lang.Exception -> L31 java.util.concurrent.CancellationException -> L33
            if (r5 != r1) goto L6a
            return r1
        L51:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Init step failed: "
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            java.lang.String r7 = "InitHelper"
            android.util.Log.e(r7, r5, r6)
            cz.mobilesoft.coreblock.util.CrashHelper.j(r6)
        L6a:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L6d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.InitHelper.u(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List i(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
            return packageManager.queryIntentActivities(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        } catch (Exception e3) {
            CrashHelper.j(e3);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String j(Context context) {
        String[] strArrK;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            strArrK = k(context);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        String aPIKey = strArrK != null ? ((NativeLib) (this instanceof KoinScopeComponent ? ((KoinScopeComponent) this).getScope() : r0().j().d()).e(Reflection.b(NativeLib.class), null, null)).getAPIKey(strArrK) : null;
        if (aPIKey == null) {
            CoroutinesHelperExtKt.d(new InitHelper$getServerAPIKey$1(null));
        }
        return aPIKey;
    }

    public final String[] k(Context context) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        Signature[] signingCertificateHistory;
        Intrinsics.checkNotNullParameter(context, "context");
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 134217728);
        Intrinsics.checkNotNullExpressionValue(packageInfo, "getPackageInfo(...)");
        SigningInfo signingInfo = packageInfo.signingInfo;
        if (signingInfo == null || (signingCertificateHistory = signingInfo.getSigningCertificateHistory()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(signingCertificateHistory.length);
        for (Signature signature : signingCertificateHistory) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(signature.toByteArray());
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 0);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            arrayList.add(StringsKt.t1(strEncodeToString).toString());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final StateFlow r() {
        return f129490f;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
