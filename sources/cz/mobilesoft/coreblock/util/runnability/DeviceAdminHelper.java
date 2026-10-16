package cz.mobilesoft.coreblock.util.runnability;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.service.receiver.LockieDeviceAdminReceiver;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
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
public final class DeviceAdminHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeviceAdminHelper f129458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final MutableStateFlow f129459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f129460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CompletableJob f129461d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CoroutineScope f129462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f129463g;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final DeviceAdminHelper deviceAdminHelper = new DeviceAdminHelper();
        f129458a = deviceAdminHelper;
        f129459b = StateFlowKt.a(Boolean.FALSE);
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129460c = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = deviceAdminHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        CompletableJob completableJobB = SupervisorKt.b(null, 1, null);
        f129461d = completableJobB;
        f129462f = CoroutineScopeKt.a(Dispatchers.a().plus(completableJobB).plus(CoroutinesHelperExtKt.b()));
        f129463g = 8;
    }

    private DeviceAdminHelper() {
    }

    private final Intent c(Activity activity) {
        Intent intent = new Intent("android.app.action.ADD_DEVICE_ADMIN");
        intent.putExtra("android.app.extra.DEVICE_ADMIN", new ComponentName(activity, (Class<?>) LockieDeviceAdminReceiver.class));
        intent.putExtra("android.app.extra.ADD_EXPLANATION", R.string.Mb);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore d() {
        return (EventDataStore) f129460c.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean f(android.content.Context r3) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "device_policy"
            java.lang.Object r0 = r3.getSystemService(r0)
            boolean r1 = r0 instanceof android.app.admin.DevicePolicyManager
            r2 = 0
            if (r1 == 0) goto L13
            android.app.admin.DevicePolicyManager r0 = (android.app.admin.DevicePolicyManager) r0
            goto L14
        L13:
            r0 = r2
        L14:
            if (r0 == 0) goto L1a
            java.util.List r2 = r0.getActiveAdmins()
        L1a:
            r0 = r2
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L55
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L26
            goto L55
        L26:
            android.content.ComponentName r0 = new android.content.ComponentName
            java.lang.Class<cz.mobilesoft.coreblock.service.receiver.LockieDeviceAdminReceiver> r1 = cz.mobilesoft.coreblock.service.receiver.LockieDeviceAdminReceiver.class
            r0.<init>(r3, r1)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L3d
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L3d
            goto L55
        L3d:
            java.util.Iterator r3 = r2.iterator()
        L41:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L55
            java.lang.Object r1 = r3.next()
            android.content.ComponentName r1 = (android.content.ComponentName) r1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
            if (r1 == 0) goto L41
            r3 = 1
            goto L56
        L55:
            r3 = 0
        L56:
            cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper r0 = cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper.f129458a
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
            r0.j(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.runnability.DeviceAdminHelper.f(android.content.Context):boolean");
    }

    public static final void g(final ActivityResultLauncher launcher, final Activity activity) {
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.d(f129462f, null, null, new DeviceAdminHelper$openDeviceAdminSettings$1(null), 3, null).invokeOnCompletion(new Function1() { // from class: cz.mobilesoft.coreblock.util.runnability.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceAdminHelper.h(launcher, activity, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(ActivityResultLauncher activityResultLauncher, Activity activity, Throwable th) {
        ContextExtKt.g(activityResultLauncher, f129458a.c(activity));
        return Unit.f139807a;
    }

    public static final void i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f(context)) {
            try {
                Object systemService = context.getSystemService("device_policy");
                DevicePolicyManager devicePolicyManager = systemService instanceof DevicePolicyManager ? (DevicePolicyManager) systemService : null;
                if (devicePolicyManager != null) {
                    devicePolicyManager.removeActiveAdmin(new ComponentName(context, (Class<?>) LockieDeviceAdminReceiver.class));
                }
                f129458a.j(Boolean.FALSE);
            } catch (SecurityException unused) {
            }
        }
    }

    public final MutableStateFlow e() {
        return f129459b;
    }

    public final void j(Boolean bool) {
        boolean zF;
        if (bool != null) {
            zF = bool.booleanValue();
        } else {
            Context contextG = LockieApplication.g();
            Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
            zF = f(contextG);
        }
        CoroutinesHelperExtKt.d(new DeviceAdminHelper$updateFlow$1(zF, null));
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
