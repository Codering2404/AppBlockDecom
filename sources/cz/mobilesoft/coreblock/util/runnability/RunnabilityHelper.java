package cz.mobilesoft.coreblock.util.runnability;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.facebook.share.HKJ.pnxuebdT;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.more.help.IgnoreBatteryOptimizationGuideActivity;
import cz.mobilesoft.coreblock.scene.permission.PermissionAutoStartHintActivity;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.AnswersSenderHelper;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelper;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.java.KoinJavaComponent;
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
public final class RunnabilityHelper implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RunnabilityHelper f129617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f129618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f129619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f129620d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CoreDataStore f129621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f129622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f129623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f129624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f129625j;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final RunnabilityHelper runnabilityHelper = new RunnabilityHelper();
        f129617a = runnabilityHelper;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f129618b = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = runnabilityHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f129619c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = runnabilityHelper;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr2, objArr3);
            }
        });
        f129620d = Build.VERSION.SDK_INT == 33;
        f129621f = (CoreDataStore) KoinJavaComponent.c(CoreDataStore.class, null, null, 6, null);
        f129622g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.runnability.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RunnabilityHelper.F());
            }
        });
        f129623h = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.runnability.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RunnabilityHelper.J());
            }
        });
        f129624i = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.util.runnability.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(RunnabilityHelper.y());
            }
        });
        f129625j = 8;
    }

    private RunnabilityHelper() {
    }

    public static final boolean C(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f129617a.n(context) != null;
    }

    public static final boolean D(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RunnabilityHelper runnabilityHelper = f129617a;
        if (runnabilityHelper.N() && !ComparableExtKt.e(runnabilityHelper.j(), Double.valueOf(11.0d))) {
            return InitHelper.q(context, new Intent("miui.intent.action.APP_PERM_EDITOR"));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F() {
        RunnabilityHelper runnabilityHelper = f129617a;
        return runnabilityHelper.E() && runnabilityHelper.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J() {
        return (f129617a.K() && f129620d) ? false : true;
    }

    public static final boolean O(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RunnabilityHelper runnabilityHelper = f129617a;
        return runnabilityHelper.P() && InitHelper.q(context, runnabilityHelper.p());
    }

    public static final boolean Q(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        RunnabilityHelper runnabilityHelper = f129617a;
        if (runnabilityHelper.B()) {
            try {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity"));
                activity.startActivity(intent);
                PermissionAutoStartHintActivity.f111786k.a(activity);
                return true;
            } catch (Exception e3) {
                CrashHelper.j(e3);
                return false;
            }
        }
        boolean zD = AutoStartPermissionHelper.d(AutoStartPermissionHelper.f129453a, activity, false, 2, null);
        if (zD || !runnabilityHelper.H()) {
            return zD;
        }
        try {
            LockieApplication.r(activity);
            PermissionAutoStartHintActivity.f111786k.a(activity);
            return true;
        } catch (Exception e4) {
            CrashHelper.j(e4);
            return false;
        }
    }

    public static final void S(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String string = activity.getString(R.string.kj, activity.getString(R.string.f95790f1));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        DialogHelper.p(activity, StringHelper.i(string, 63), new DialogHelper.OnDialogClosedListener() { // from class: cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper$openXiaomiLockApps$1
            @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
            public void a() {
                try {
                    activity.startActivity(RunnabilityHelper.f129617a.p());
                } catch (ActivityNotFoundException e3) {
                    CrashHelper.j(e3);
                }
            }

            @Override // cz.mobilesoft.coreblock.util.helperextension.DialogHelper.OnDialogClosedListener
            public void b() {
            }
        });
    }

    public static final void T(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intent intentN = f129617a.n(activity);
        if (intentN != null) {
            CoroutinesHelperExtKt.d(new RunnabilityHelper$requestIgnoreBatteryOptimizations$1$1(activity, intentN, null));
        }
    }

    public static final void U(Context context, int i3, Integer num, boolean z2, ContactReason contactReason, boolean z3, String entrances) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entrances, "entrances");
        CoroutinesHelperExtKt.d(new RunnabilityHelper$startContactSupportIntent$1(z2, context, contactReason, entrances, z3, i3, num, null));
    }

    public static /* synthetic */ void V(Context context, int i3, Integer num, boolean z2, ContactReason contactReason, boolean z3, String str, int i4, Object obj) {
        boolean z4;
        String str2;
        boolean z5;
        ContactReason contactReason2;
        int i5;
        if ((i4 & 2) != 0) {
            i3 = R.string.Qv;
        }
        if ((i4 & 4) != 0) {
            num = null;
        }
        if ((i4 & 8) != 0) {
            z2 = false;
        }
        if ((i4 & 16) != 0) {
            contactReason = null;
        }
        if ((i4 & 32) != 0) {
            z4 = false;
            z5 = z2;
            str2 = str;
            i5 = i3;
            contactReason2 = contactReason;
        } else {
            z4 = z3;
            str2 = str;
            z5 = z2;
            contactReason2 = contactReason;
            i5 = i3;
        }
        U(context, i5, num, z5, contactReason2, z4, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Context context) {
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{AnswersSenderHelper.f127775a.d() ? "GP" : "notGP", f129617a.k().J().d()}), ",", null, null, 0, null, null, 62, null);
        return "\n\nSent from " + Build.MANUFACTURER + " " + Build.DEVICE + " (" + Build.MODEL + "), Android " + Build.VERSION.RELEASE + ", " + context.getString(R.string.f95790f1) + " v " + LockieApplication.l() + "(" + strJoinToString$default + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore i() {
        return (EventDataStore) f129618b.getValue();
    }

    private final Double j() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class).invoke(cls, "ro.miui.ui.version.name");
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return Double.valueOf(Double.parseDouble(new Regex("[^.0123456789]").replace((String) objInvoke, "")));
        } catch (Exception e3) {
            CrashHelper.j(e3);
            e3.printStackTrace();
            return null;
        }
    }

    private final PremiumRepositoryV2 k() {
        return (PremiumRepositoryV2) f129619c.getValue();
    }

    private final Intent l() {
        return new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS");
    }

    private final Intent m() {
        return new Intent("android.settings.VIEW_ADVANCED_POWER_USAGE_DETAIL", Uri.parse("package:" + LockieApplication.f95360f));
    }

    private final Intent n(Context context) {
        if (K() || z()) {
            return new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS", Uri.parse("package:" + context.getPackageName()));
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return InitHelper.q(context, m()) ? m() : IgnoreBatteryOptimizationGuideActivity.f107778g.a(context);
        }
        if (InitHelper.q(context, l())) {
            return l();
        }
        return null;
    }

    public static final Intent o(Context context, int i3, String content, String subject) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{PrefManager.f126839a.k1()});
        intent.putExtra("android.intent.extra.SUBJECT", subject);
        intent.putExtra("android.intent.extra.TEXT", content);
        Intent intentCreateChooser = Intent.createChooser(intent, context.getString(i3));
        Intrinsics.checkNotNullExpressionValue(intentCreateChooser, "createChooser(...)");
        return intentCreateChooser;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent p() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.securityscan.ui.settings.SettingsActivity"));
        return intent;
    }

    public static final boolean w(Context context) {
        InitHelper initHelper;
        List listI;
        List listI2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intentM = AutoStartPermissionHelper.f129453a.m(context);
        if (intentM == null || (listI = (initHelper = InitHelper.f129486a).i(context, intentM)) == null) {
            return false;
        }
        Intent intentN = f129617a.n(context);
        if (intentN != null && (listI2 = initHelper.i(context, intentN)) != null && listI.size() == 1 && listI2.size() == 1) {
            ActivityInfo activityInfo = ((ResolveInfo) CollectionsKt.first(listI)).activityInfo;
            ActivityInfo activityInfo2 = ((ResolveInfo) CollectionsKt.first(listI2)).activityInfo;
            if (Intrinsics.areEqual(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name), new ComponentName(activityInfo2.applicationInfo.packageName, activityInfo2.name))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y() {
        return f129617a.K() && !f129620d;
    }

    public final boolean A() {
        return DeviceManufacturerInfo.f129484a.b();
    }

    public final boolean B() {
        return DeviceManufacturerInfo.f129484a.c();
    }

    public final boolean E() {
        return DeviceManufacturerInfo.f129484a.d();
    }

    public final boolean G() {
        return DeviceManufacturerInfo.f129484a.f();
    }

    public final boolean H() {
        return DeviceManufacturerInfo.f129484a.g();
    }

    public final boolean I() {
        return ((Boolean) f129623h.getValue()).booleanValue();
    }

    public final boolean K() {
        return DeviceManufacturerInfo.f129484a.j();
    }

    public final boolean L(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getBoolean(R.bool.f95445a);
    }

    public final boolean M() {
        return DeviceManufacturerInfo.f129484a.k();
    }

    public final boolean N() {
        return DeviceManufacturerInfo.f129484a.l();
    }

    public final boolean P() {
        return DeviceManufacturerInfo.f129484a.m();
    }

    public final CoreDataStore g() {
        return f129621f;
    }

    public final boolean q() {
        return M();
    }

    public final boolean r() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final boolean s() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public final boolean t() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public final boolean u() {
        return Build.VERSION.SDK_INT >= 35;
    }

    public final boolean v() {
        return Build.VERSION.SDK_INT > 36;
    }

    public final boolean x() {
        return ((Boolean) f129624i.getValue()).booleanValue();
    }

    public final boolean z() {
        return DeviceManufacturerInfo.f129484a.a();
    }

    public static final boolean R(Context context) {
        Intrinsics.checkNotNullParameter(context, pnxuebdT.MFJJbT);
        try {
            context.startActivity(new Intent("miui.intent.action.APP_PERM_EDITOR").putExtra("extra_pkgname", context.getPackageName()));
            return true;
        } catch (Exception e3) {
            CrashHelper.j(e3);
            e3.printStackTrace();
            return false;
        }
    }
}
