package cz.mobilesoft.appblock.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.appblock.R;
import cz.mobilesoft.appblock.databinding.FragmentLockBinding;
import cz.mobilesoft.appblock.util.ServiceHelper;
import cz.mobilesoft.appblock.view.LockScreenProvider;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import cz.mobilesoft.coreblock.util.runnability.InitHelper;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OverlayService extends Service implements KoinComponent {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f94611g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f94612h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static WeakReference f94613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f94614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f94615k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f94616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WindowManager f94617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f94618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LockScreenProvider f94619d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f94620f;

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
    public OverlayService() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f94616a = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.appblock.service.OverlayService$special$$inlined$inject$default$1
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

    private final void d() {
        final ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this, R.style.AppTheme);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 1024, -3);
        layoutParams.gravity = 8388627;
        layoutParams.x = 0;
        layoutParams.y = 0;
        FrameLayout frameLayout = new FrameLayout(contextThemeWrapper) { // from class: cz.mobilesoft.appblock.service.OverlayService$addOverlayView$interceptorLayout$1
            @Override // android.view.ViewGroup, android.view.View
            public boolean dispatchKeyEvent(KeyEvent event) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.getAction() == 0 && event.getKeyCode() == 4) {
                    return true;
                }
                return super.dispatchKeyEvent(event);
            }
        };
        FragmentLockBinding fragmentLockBindingC = FragmentLockBinding.c(LayoutInflater.from(contextThemeWrapper), frameLayout, false);
        Intrinsics.checkNotNullExpressionValue(fragmentLockBindingC, "inflate(...)");
        frameLayout.addView(fragmentLockBindingC.getRoot());
        fragmentLockBindingC.getRoot().setBackgroundColor(ContextCompat.getColor(contextThemeWrapper, R.color.black_95_alpha));
        this.f94619d = new LockScreenProvider(fragmentLockBindingC, new LockScreenProvider.OnCloseSelectedListener() { // from class: cz.mobilesoft.appblock.service.e1
            @Override // cz.mobilesoft.appblock.view.LockScreenProvider.OnCloseSelectedListener
            public final void a() {
                OverlayService.e(this.f94727a);
            }
        }, true);
        try {
            WindowManager windowManager = this.f94617b;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                windowManager = null;
            }
            windowManager.addView(frameLayout, layoutParams);
            this.f94618c = frameLayout;
            f94613i = new WeakReference(frameLayout);
        } catch (IllegalStateException e3) {
            CrashHelper.j(e3);
            this.f94618c = null;
            f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(OverlayService overlayService) {
        overlayService.f(false);
    }

    private final void f(boolean z2) {
        LockScreenProvider lockScreenProvider = this.f94619d;
        if (lockScreenProvider != null && !lockScreenProvider.L0()) {
            if (!z2 && !this.f94620f) {
                TimeHelperExt timeHelperExt = TimeHelperExt.f128663a;
                if (timeHelperExt.f() - f94614j >= 2000) {
                    f94614j = timeHelperExt.f();
                    f94615k = 0;
                    ServiceHelper serviceHelper = ServiceHelper.f95139a;
                    Context applicationContext = getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    serviceHelper.b(applicationContext);
                } else if (f94615k < 3) {
                    f94614j = timeHelperExt.f();
                    f94615k++;
                    ServiceHelper serviceHelper2 = ServiceHelper.f95139a;
                    Context applicationContext2 = getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                    serviceHelper2.b(applicationContext2);
                } else {
                    f94614j = 0L;
                    f94615k = 0;
                    ServiceHelper.f95139a.e(this);
                }
            }
            Intent intent = new Intent("cz.mobilesoft.appblock.LOCK_OVERLAY_CLOSED");
            intent.setPackage(LockieApplication.f95360f);
            sendBroadcast(intent);
        }
        View view = this.f94618c;
        if (view != null) {
            WindowManager windowManager = this.f94617b;
            if (windowManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowManager");
                windowManager = null;
            }
            windowManager.removeView(view);
            this.f94618c = null;
            WeakReference weakReference = f94613i;
            if (weakReference != null) {
                weakReference.clear();
            }
        }
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore g() {
        return (EventDataStore) this.f94616a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(OverlayService overlayService, String str, UrlDto urlDto) {
        CoroutinesHelperExtKt.d(new OverlayService$onStartCommand$1$1(overlayService, str, urlDto, null));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f94617b = (WindowManager) systemService;
        WeakReference weakReference = f94613i;
        View view = weakReference != null ? (View) weakReference.get() : null;
        WeakReference weakReference2 = f94613i;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        if (view != null && view.getVisibility() == 0) {
            stopSelf();
            return;
        }
        try {
            d();
        } catch (WindowManager.BadTokenException e3) {
            CrashHelper.j(e3);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.getExtras() != null) {
            final String stringExtra = intent.getStringExtra("PACKAGE_NAME");
            String stringExtra2 = intent.getStringExtra("BLOCKING_SCREEN_CUSTOM_TITLE");
            StrictModeOption strictModeOption = (StrictModeOption) intent.getSerializableExtra("STRICT_MODE_OPTION");
            Serializable serializableExtra = intent.getSerializableExtra("PROFILE");
            ProfileWithConfiguration profileWithConfiguration = serializableExtra instanceof ProfileWithConfiguration ? (ProfileWithConfiguration) serializableExtra : null;
            if (stringExtra == null) {
                f(true);
                return 2;
            }
            final UrlDto urlDto = (UrlDto) intent.getParcelableExtra("URL");
            Long lValueOf = Long.valueOf(intent.getLongExtra("BLOCK_UNTIL", -1L));
            if (lValueOf.longValue() == -1) {
                lValueOf = null;
            }
            UsageLimit.PeriodType periodType = (UsageLimit.PeriodType) intent.getSerializableExtra("USAGE_PERIOD_TYPE");
            this.f94620f = urlDto != null;
            LockScreenProvider lockScreenProvider = this.f94619d;
            if (lockScreenProvider != null) {
                lockScreenProvider.j0(stringExtra, urlDto, lValueOf, profileWithConfiguration, periodType, stringExtra2, strictModeOption);
            }
            InitHelper.h(new InitHelper.OnInitializedListener() { // from class: cz.mobilesoft.appblock.service.d1
                @Override // cz.mobilesoft.coreblock.util.runnability.InitHelper.OnInitializedListener
                public final void onInitialized() {
                    OverlayService.h(this.f94722a, stringExtra, urlDto);
                }
            });
        }
        return 2;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
