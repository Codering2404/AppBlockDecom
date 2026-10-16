package cz.mobilesoft.coreblock.util;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import coil.target.Yb.oUcQRqOVfOC;
import com.singular.sdk.Singular;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularDeviceAttributionHandler;
import com.singular.sdk.SingularLinkHandler;
import com.singular.sdk.SingularLinkParams;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

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
public final class DeepLinksUtils implements KoinComponent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f127819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile String f127820c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f127823g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeepLinksUtils f127818a = new DeepLinksUtils();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f127821d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f127822f = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f127824h = 8;

    private DeepLinksUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Activity activity, String str, String str2, final Function1 function1, final Function1 function12) {
        Log.d("initSingular", "key: " + StringsKt.B1(str, 3) + "..." + StringsKt.C1(str, 3) + ", secret: " + StringsKt.B1(str2, 3) + "..." + StringsKt.C1(str2, 3));
        String string = activity.getString(R.string.he);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SingularConfig singularConfigF = new SingularConfig(str, str2).c(string).e().d(1).g(activity.getIntent(), new SingularLinkHandler() { // from class: cz.mobilesoft.coreblock.util.k
            @Override // com.singular.sdk.SingularLinkHandler
            public final void a(SingularLinkParams singularLinkParams) {
                DeepLinksUtils.l(function1, singularLinkParams);
            }
        }).f(new SingularDeviceAttributionHandler() { // from class: cz.mobilesoft.coreblock.util.l
            @Override // com.singular.sdk.SingularDeviceAttributionHandler
            public final void a(Map map) {
                DeepLinksUtils.m(function12, map);
            }
        });
        Object value = SessionManager.f127910a.l().getValue();
        SessionManager.SignedIn signedIn = value instanceof SessionManager.SignedIn ? (SessionManager.SignedIn) value : null;
        if (signedIn != null) {
            singularConfigF.b(signedIn.a());
        }
        Singular.e(activity.getApplicationContext(), singularConfigF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(kotlin.jvm.functions.Function1 r5, com.singular.sdk.SingularLinkParams r6) {
        /*
            java.lang.String r0 = r6.b()
            java.lang.String r1 = "getDeeplink(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.net.Uri r0 = android.net.Uri.parse(r0)
            java.lang.String r1 = r6.c()
            r2 = 0
            java.lang.String r3 = "email"
            if (r1 == 0) goto L20
            boolean r4 = kotlin.text.StringsKt.p0(r1)
            if (r4 != 0) goto L1d
            goto L1e
        L1d:
            r1 = r2
        L1e:
            if (r1 != 0) goto L3e
        L20:
            java.util.HashMap r1 = r6.d()
            java.lang.String r4 = "_p"
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L3e
            java.util.HashMap r1 = r6.d()
            java.lang.Object r1 = r1.get(r3)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 != 0) goto L3e
            java.lang.String r1 = r0.getQueryParameter(r3)
        L3e:
            if (r1 == 0) goto L58
            boolean r4 = kotlin.text.StringsKt.p0(r1)
            if (r4 == 0) goto L47
            goto L58
        L47:
            android.net.Uri$Builder r6 = r0.buildUpon()
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r3, r1)
            android.net.Uri r6 = r6.build()
            java.lang.String r6 = r6.toString()
            goto L73
        L58:
            java.lang.String r6 = r6.b()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            boolean r1 = kotlin.text.StringsKt.p0(r6)
            if (r1 != 0) goto L66
            r2 = r6
        L66:
            if (r2 != 0) goto L72
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            goto L73
        L72:
            r6 = r2
        L73:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Final URL sent to app: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "initSingular"
            android.util.Log.d(r1, r0)
            r5.invoke(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.DeepLinksUtils.l(kotlin.jvm.functions.Function1, com.singular.sdk.SingularLinkParams):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 function1, Map map) {
        Log.d("initSingular", "Attribution info received: " + map);
        Intrinsics.checkNotNull(map);
        function1.invoke(map);
    }

    public final void j(Activity activity, Function1 onDeeplinkReceived, Function1 onAttributionReceived) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(onDeeplinkReceived, "onDeeplinkReceived");
        Intrinsics.checkNotNullParameter(onAttributionReceived, "onAttributionReceived");
        String str = f127819b;
        String str2 = f127820c;
        if (str == null || str2 == null) {
            Log.d("initSingular", "keys not ready, scheduling async retry");
            o(activity, onDeeplinkReceived, onAttributionReceived);
        } else {
            Log.d("initSingular", "keys ready, initializing immediately");
            k(activity, str, str2, onDeeplinkReceived, onAttributionReceived);
        }
    }

    public final Object n(Context context, Continuation continuation) {
        Object objG = BuildersKt.g(Dispatchers.b(), new DeepLinksUtils$preloadSingularKeys$2(context, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    private final void o(Activity activity, Function1 function1, Function1 function12) {
        synchronized (f127822f) {
            if (f127823g) {
                Log.d("initSingular", oUcQRqOVfOC.vpWIeSqIZpu);
                return;
            }
            f127823g = true;
            Unit unit = Unit.f139807a;
            Log.d("initSingular", "starting async keys preload retry");
            CoroutinesHelperExtKt.d(new DeepLinksUtils$scheduleSingularKeysRetry$2(activity, function1, function12, null));
        }
    }
}
