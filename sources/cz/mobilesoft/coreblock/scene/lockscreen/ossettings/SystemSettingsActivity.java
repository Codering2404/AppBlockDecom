package cz.mobilesoft.coreblock.scene.lockscreen.ossettings;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import cz.mobilesoft.coreblock.dto.events.PackageAdditionalBlockingDTO;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SystemSettingsActivity extends AppCompatActivity implements KoinComponent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f105722p = new Companion(null);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f105723q = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f105724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineScope f105725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f105726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f105727d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f105728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f105729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f105730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List f105731i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f105732j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f105733k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f105734l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f105735m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f105736n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f105737o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, Intent settingsIntent, String[] strArr) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(settingsIntent, "settingsIntent");
            Intent intent = new Intent(context, (Class<?>) SystemSettingsActivity.class);
            intent.setFlags(276856832);
            intent.putExtra("INTENT", settingsIntent);
            intent.putExtra("ALLOWED_ACTIVITIES", strArr);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity$onCreate$1", f = "SystemSettingsActivity.kt", l = {95}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105738a;

        AnonymousClass1(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return SystemSettingsActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f105738a;
            if (i3 == 0) {
                ResultKt.b(obj);
                EventDataStore eventDataStoreK0 = SystemSettingsActivity.this.k0();
                this.f105738a = 1;
                if (eventDataStoreK0.p2(true, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity$onDestroy$1", f = "SystemSettingsActivity.kt", l = {238, 239}, m = "invokeSuspend", v = 1)
    static final class C29571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105743a;

        C29571(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SystemSettingsActivity.this.new C29571(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            if (r5.q2("", r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r4.f105743a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r5)
                goto L42
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.b(r5)
                goto L31
            L1e:
                kotlin.ResultKt.b(r5)
                cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity r5 = cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.this
                cz.mobilesoft.coreblock.storage.datastore.EventDataStore r5 = cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.b0(r5)
                r4.f105743a = r3
                r1 = 0
                java.lang.Object r5 = r5.p2(r1, r4)
                if (r5 != r0) goto L31
                goto L41
            L31:
                cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity r5 = cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.this
                cz.mobilesoft.coreblock.storage.datastore.EventDataStore r5 = cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.b0(r5)
                r4.f105743a = r2
                java.lang.String r1 = ""
                java.lang.Object r5 = r5.q2(r1, r4)
                if (r5 != r0) goto L42
            L41:
                return r0
            L42:
                kotlin.Unit r5 = kotlin.Unit.f139807a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.C29571.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((C29571) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemSettingsActivity() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f105724a = LazyKt.a(lazyThreadSafetyModeB, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity$special$$inlined$inject$default$1
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
        this.f105725b = CoroutineScopeKt.a(Dispatchers.a().plus(SupervisorKt.b(null, 1, null)).plus(CoroutinesHelperExtKt.b()));
        this.f105726c = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SystemSettingsActivity.y0(this.f105762a);
            }
        });
        this.f105727d = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SystemSettingsActivity.g0(this.f105763a);
            }
        });
        this.f105728f = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(SystemSettingsActivity.z0());
            }
        });
        this.f105729g = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SystemSettingsActivity.h0(this.f105764a);
            }
        });
        this.f105730h = CollectionsKt.mutableListOf("com.android.settings.intelligence.search.SearchActivity");
        this.f105733k = "";
    }

    private final void A0() {
        BuildersKt__Builders_commonKt.d(this.f105725b, null, null, new SystemSettingsActivity$startCheckingActivity$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivityManager g0(SystemSettingsActivity systemSettingsActivity) {
        Object systemService = systemSettingsActivity.getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        return (ActivityManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set h0(SystemSettingsActivity systemSettingsActivity) {
        Set mutableSet;
        String[] stringArrayExtra = systemSettingsActivity.getIntent().getStringArrayExtra("ALLOWED_ACTIVITIES");
        if (stringArrayExtra != null) {
            if (stringArrayExtra.length == 0) {
                stringArrayExtra = null;
            }
            if (stringArrayExtra != null && (mutableSet = ArraysKt.toMutableSet(stringArrayExtra)) != null) {
                return mutableSet;
            }
        }
        return CollectionsKt.toMutableSet(DefaultAllowedSettings.f105719a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityManager i0() {
        return (ActivityManager) this.f105727d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set j0() {
        return (Set) this.f105729g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore k0() {
        return (EventDataStore) this.f105724a.getValue();
    }

    private final Intent p0() {
        return (Intent) this.f105726c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q0() {
        return ((Boolean) this.f105728f.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(SystemSettingsActivity systemSettingsActivity, Throwable th) {
        JobKt__JobKt.e(systemSettingsActivity.f105725b.getCoroutineContext(), null, 1, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Intent y0(SystemSettingsActivity systemSettingsActivity) {
        return (Intent) systemSettingsActivity.getIntent().getParcelableExtra("INTENT");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z0() {
        RunnabilityHelper runnabilityHelper = RunnabilityHelper.f129617a;
        if (runnabilityHelper.K()) {
            return true;
        }
        return runnabilityHelper.G() && Build.VERSION.SDK_INT <= 28;
    }

    public final String l0() {
        return this.f105737o;
    }

    public final long m0() {
        return this.f105732j;
    }

    public final String n0() {
        return this.f105733k;
    }

    public final String o0() {
        return this.f105734l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        CoroutinesHelperExtKt.d(new AnonymousClass1(null));
        super.onCreate(bundle);
        setContentView(new FrameLayout(this));
        FlowExtKt.l(k0().j1(), this.f105725b, new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.onCreate.2
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, Continuation continuation) {
                SystemSettingsActivity systemSettingsActivity = SystemSettingsActivity.this;
                if (str.length() == 0) {
                    str = null;
                }
                systemSettingsActivity.u0(str);
                return Unit.f139807a;
            }
        });
        FlowExtKt.l(k0().Z0(), this.f105725b, new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.onCreate.3
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(PackageAdditionalBlockingDTO packageAdditionalBlockingDTO, Continuation continuation) {
                try {
                    SystemSettingsActivity.this.finishAndRemoveTask();
                } catch (Exception unused) {
                }
                return Unit.f139807a;
            }
        });
        FlowExtKt.l(k0().i1(), this.f105725b, new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsActivity.onCreate.4
            public final Object a(boolean z2, Continuation continuation) {
                if (!z2) {
                    SystemSettingsActivity.this.finishAndRemoveTask();
                }
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        });
        Intent intentP0 = p0();
        if (intentP0 == null) {
            finishAndRemoveTask();
            return;
        }
        try {
            startActivity(intentP0);
            A0();
        } catch (Exception e3) {
            e3.printStackTrace();
            CrashHelper.j(e3);
            finishAndRemoveTask();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f105736n = true;
        BuildersKt__Builders_commonKt.d(this.f105725b, null, null, new C29571(null), 3, null).invokeOnCompletion(new Function1() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ossettings.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SystemSettingsActivity.t0(this.f105761a, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.f105735m) {
            finishAndRemoveTask();
        } else {
            this.f105735m = true;
        }
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final boolean s0() {
        return this.f105736n;
    }

    public final void u0(String str) {
        this.f105737o = str;
    }

    public final void v0(long j3) {
        this.f105732j = j3;
    }

    public final void w0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f105733k = str;
    }

    public final void x0(String str) {
        this.f105734l = str;
    }
}
