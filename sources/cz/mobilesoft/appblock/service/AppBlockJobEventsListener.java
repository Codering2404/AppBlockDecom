package cz.mobilesoft.appblock.service;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import cz.mobilesoft.appblock.util.NotificationHelper;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.service.job.JobEventsListener;
import cz.mobilesoft.coreblock.service.job.JobPlanner;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.usecase.lockservice.LockServiceRunReason;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppBlockJobEventsListener implements JobEventsListener, KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f94026a;

    /* JADX WARN: Multi-variable type inference failed */
    public AppBlockJobEventsListener() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94026a = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.AppBlockJobEventsListener$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore n() {
        return (EventDataStore) this.f94026a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(Context context) {
        ServiceHelper serviceHelper = ServiceHelper.f95139a;
        Intrinsics.checkNotNull(context);
        return serviceHelper.d(context);
    }

    private final boolean q(Context context, Function0 function0) {
        Set setB = LockServiceReasonsHelper.b(context);
        if (setB.contains(LockServiceRunReason.BLOCKING)) {
            return true;
        }
        return !setB.isEmpty() && ((Boolean) function0.invoke()).booleanValue();
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void a(Context context) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        BeforeProfilePauseEndNotificationService.f94036i.b(context);
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (LockServiceReasonsHelper.b(applicationContext).isEmpty()) {
            return false;
        }
        ServiceHelper.f95139a.f(context);
        return true;
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void c(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (j3 != -1) {
            NotificationHelper.c(context, j3);
        }
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void d(Context context) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        BeforeProfileStartNotificationService.f94079m.b(context);
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void e(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        BeforeProfileStartNotificationService.f94079m.a(context, j3);
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public boolean g(Context context, PersistableBundleCompat bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        long jE = bundle.e("PROFILE_ID", -1L);
        long jE2 = bundle.e("WHEN", -1L);
        boolean zC = bundle.c("SHOW_ONLY_IF_NOTIFICATIONS_BLOCKED", false);
        boolean zC2 = bundle.c("SHOW_NOTIFICATION", true);
        boolean zC3 = bundle.c("IS_POMODORO", false);
        JobManager.i(LockieApplication.g()).e("PROFILE_DEACTIVATION_WITH_ID_" + jE);
        Log.d(JobPlanner.class.getSimpleName(), "from:" + jE2 + " profileId:" + jE);
        if (jE != -1) {
            NotificationHelper.d(context, jE, jE2, zC, zC2, zC3);
        }
        return false;
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void h(Context context, String tag) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Context applicationContext = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null || powerManager.isInteractive()) {
            ServiceHelper serviceHelper = ServiceHelper.f95139a;
            Intrinsics.checkNotNull(applicationContext);
            final boolean zD = serviceHelper.d(applicationContext);
            if (q(applicationContext, new Function0() { // from class: cz.mobilesoft.appblock.service.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(AppBlockJobEventsListener.p(zD));
                }
            })) {
                serviceHelper.f(context);
                if (!zD || Intrinsics.areEqual(tag, "LOCK_SERVICE_CHECK_NOW")) {
                    return;
                }
                CoroutinesHelperExtKt.d(new AppBlockJobEventsListener$onLockServiceCheck$2(this, null));
            }
        }
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void i(Context context, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        BeforeProfilePauseEndNotificationService.f94036i.a(context, j3);
    }

    @Override // cz.mobilesoft.coreblock.service.job.JobEventsListener
    public void j(Context context, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        if (q(applicationContext, new Function0() { // from class: cz.mobilesoft.appblock.service.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(AppBlockJobEventsListener.o(applicationContext));
            }
        })) {
            ServiceHelper.f95139a.f(context);
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(boolean z2) {
        return z2;
    }
}
