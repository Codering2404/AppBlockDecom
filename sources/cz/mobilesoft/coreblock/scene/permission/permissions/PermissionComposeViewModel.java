package cz.mobilesoft.coreblock.scene.permission.permissions;

import android.app.Application;
import androidx.lifecycle.ViewModelKt;
import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeCommand;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeEvent;
import cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.permissions.AdvancedProtectionHelper;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
public final class PermissionComposeViewModel extends BaseStatefulViewModel<PermissionComposeState, PermissionComposeEvent, PermissionComposeCommand> {
    private static final Companion C = new Companion(null);
    public static final int D = 8;
    private final Lazy A;
    private final Lazy B;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final CoreDataStore f112024o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final EventDataStore f112025p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final PermissionsDTO f112026q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final QuickBlockRepository f112027r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f112028s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final long f112029t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final long f112030u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final AtomicBoolean f112031v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final AtomicBoolean f112032w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final AtomicBoolean f112033x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f112034y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final boolean f112035z;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$1", f = "PermissionViewModel.kt", l = {57, 59, 61, 64, 82}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f112036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f112037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f112038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f112039d;

        AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PermissionComposeState y(PermissionComposeState permissionComposeState) {
            return PermissionComposeState.b(permissionComposeState, null, true, false, false, false, false, false, null, false, false, 1021, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final PermissionComposeState z(List list, PermissionComposeViewModel permissionComposeViewModel, boolean z2, boolean z3, PermissionComposeState permissionComposeState) {
            return PermissionComposeState.b(permissionComposeState, list, false, false, permissionComposeViewModel.f112026q.c(), permissionComposeViewModel.f112026q.i(), false, false, permissionComposeViewModel.f112026q.f(), z2, z2 || z3, 100, null);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionComposeViewModel.this.new AnonymousClass1(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:58:0x012d, code lost:
        
            if (r4.D1(true, r11) != r0) goto L60;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x008f A[PHI: r12
          0x008f: PHI (r12v15 java.lang.Object) = (r12v14 java.lang.Object), (r12v0 java.lang.Object) binds: [B:27:0x008b, B:13:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0106 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0119 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
        /* JADX WARN: Type inference failed for: r12v19 */
        /* JADX WARN: Type inference failed for: r12v20, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r12v26 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 324
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$2", f = "PermissionViewModel.kt", l = {92}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f112041a;

        /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class AnonymousClass1<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ PermissionComposeViewModel f112043a;

            AnonymousClass1(PermissionComposeViewModel permissionComposeViewModel) {
                this.f112043a = permissionComposeViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PermissionComposeState f(boolean z2, PermissionComposeState updateState) {
                Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
                return PermissionComposeState.b(updateState, null, false, z2, false, false, false, false, null, false, false, 1019, null);
            }

            public final Object b(final boolean z2, Continuation continuation) {
                this.f112043a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PermissionComposeViewModel.AnonymousClass2.AnonymousClass1.f(z2, (PermissionComposeState) obj);
                    }
                });
                return Unit.f139807a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return b(((Boolean) obj).booleanValue(), continuation);
            }
        }

        AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return PermissionComposeViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f112041a;
            if (i3 != 0) {
                if (i3 == 1) {
                    ResultKt.b(obj);
                } else {
                    throw new IllegalStateException(KLAQHFCRAUejH.hKiObXHXpWICQ);
                }
            } else {
                ResultKt.b(obj);
                Flow flowO3 = PermissionComposeViewModel.this.f112024o.o3();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(PermissionComposeViewModel.this);
                this.f112041a = 1;
                if (flowO3.collect(anonymousClass1, this) == objF) {
                    return objF;
                }
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$3", f = "PermissionViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f112044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f112045b;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = PermissionComposeViewModel.this.new AnonymousClass3(continuation);
            anonymousClass3.f112045b = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope = (CoroutineScope) this.f112045b;
            IntrinsicsKt.f();
            if (this.f112044a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Flow flowG0 = PermissionComposeViewModel.this.f112025p.G0();
            final PermissionComposeViewModel permissionComposeViewModel = PermissionComposeViewModel.this;
            FlowExtKt.l(flowG0, coroutineScope, new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.3.1
                public final Object a(long j3, Continuation continuation) {
                    permissionComposeViewModel.K1();
                    return Unit.f139807a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return a(((Number) obj2).longValue(), continuation);
                }
            });
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PermissionComposeViewModel(Application application, CoreDataStore coreDataStore, EventDataStore eventDataStore, PermissionsDTO permissionsDTO, QuickBlockRepository quickBlockRepository) {
        super(application, new PermissionComposeState(null, false, false, false, false, false, false, null, false, false, 1023, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(coreDataStore, "coreDataStore");
        Intrinsics.checkNotNullParameter(eventDataStore, "eventDataStore");
        Intrinsics.checkNotNullParameter(permissionsDTO, "permissionsDTO");
        Intrinsics.checkNotNullParameter(quickBlockRepository, "quickBlockRepository");
        this.f112024o = coreDataStore;
        this.f112025p = eventDataStore;
        this.f112026q = permissionsDTO;
        this.f112027r = quickBlockRepository;
        this.f112028s = permissionsDTO.d();
        this.f112029t = 600L;
        this.f112030u = 1000L;
        boolean z2 = false;
        this.f112031v = new AtomicBoolean(false);
        this.f112032w = new AtomicBoolean(false);
        this.f112033x = new AtomicBoolean(false);
        if (permissionsDTO.e().size() == 1 && (((PermissionDTO) CollectionsKt.first(permissionsDTO.e())).e() instanceof Permission.ACCESSIBILITY)) {
            z2 = true;
        }
        this.f112035z = z2;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.A = LazyKt.a(lazyThreadSafetyModeB, new Function0<ConsentHelper>() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ConsentHelper.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.B = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr2, objArr3);
            }
        });
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new AnonymousClass1(null), 3, null);
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.d(C0(), null, null, new AnonymousClass3(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(boolean z2) {
        if (this.f112032w.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new PermissionComposeViewModel$handleFinishFlow$1(this, z2, null), 3, null);
        }
    }

    private final void B1(PermissionDTO permissionDTO) {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new PermissionComposeViewModel$handleLocationFallback$1(this, permissionDTO, null), 3, null);
    }

    private final void C1(PermissionComposeEvent.OnPermissionClick onPermissionClick) {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new PermissionComposeViewModel$handlePermissionClick$1(this, onPermissionClick, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
    
        if (r12.y4(true, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object D1(boolean r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$logAdvancedProtectionStep1ResolvedOnce$1
            if (r0 == 0) goto L13
            r0 = r12
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$logAdvancedProtectionStep1ResolvedOnce$1 r0 = (cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$logAdvancedProtectionStep1ResolvedOnce$1) r0
            int r1 = r0.f112092d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f112092d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$logAdvancedProtectionStep1ResolvedOnce$1 r0 = new cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$logAdvancedProtectionStep1ResolvedOnce$1
            r0.<init>(r10, r12)
        L18:
            java.lang.Object r12 = r0.f112090b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f112092d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            boolean r11 = r0.f112089a
            kotlin.ResultKt.b(r12)
            goto L91
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            boolean r11 = r0.f112089a
            kotlin.ResultKt.b(r12)
            goto L79
        L3f:
            boolean r11 = r0.f112089a
            kotlin.ResultKt.b(r12)
            goto L59
        L45:
            kotlin.ResultKt.b(r12)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r12 = r10.f112024o
            kotlinx.coroutines.flow.Flow r12 = r12.b2()
            r0.f112089a = r11
            r0.f112092d = r5
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.D(r12, r0)
            if (r12 != r1) goto L59
            goto L90
        L59:
            java.lang.Number r12 = (java.lang.Number) r12
            long r6 = r12.longValue()
            r8 = 0
            int r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r12 != 0) goto L68
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        L68:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r12 = r10.f112024o
            kotlinx.coroutines.flow.Flow r12 = r12.a2()
            r0.f112089a = r11
            r0.f112092d = r4
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.D(r12, r0)
            if (r12 != r1) goto L79
            goto L90
        L79:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L84
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        L84:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r12 = r10.f112024o
            r0.f112089a = r11
            r0.f112092d = r3
            java.lang.Object r12 = r12.y4(r5, r0)
            if (r12 != r1) goto L91
        L90:
            return r1
        L91:
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r12 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r12.d0(r11)
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.D1(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeState F1(PermissionComposeState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PermissionComposeState.b(updateState, null, false, false, false, false, false, false, null, false, false, 991, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeState G1(PermissionComposeState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PermissionComposeState.b(updateState, null, false, false, false, false, false, false, null, false, false, 991, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeState H1(PermissionComposeState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PermissionComposeState.b(updateState, null, false, false, false, false, true, false, null, false, false, 991, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object I1(Continuation continuation) throws Throwable {
        PermissionComposeState permissionComposeState = (PermissionComposeState) I0();
        final boolean zA = AdvancedProtectionHelper.f128991a.a(A0());
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PermissionComposeViewModel.J1(zA, (PermissionComposeState) obj);
            }
        });
        if (!this.f112035z) {
            return Unit.f139807a;
        }
        if (!permissionComposeState.g() && zA) {
            AnswersHelper.f128199a.g0(this.f112026q.i());
        }
        if (!permissionComposeState.i() || zA) {
            return Unit.f139807a;
        }
        Object objD1 = D1(false, continuation);
        return objD1 == IntrinsicsKt.f() ? objD1 : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeState J1(boolean z2, PermissionComposeState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PermissionComposeState.b(updateState, null, false, false, false, false, false, false, null, z2, updateState.g() || z2, 255, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new PermissionComposeViewModel$refreshPermissions$1(this, null), 3, null);
    }

    private final Object L1(boolean z2, List list, Continuation continuation) {
        Object objP0 = P0(new PermissionComposeCommand.FinishFlow(!z2, list, this.f112026q.c()), continuation);
        return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0091, code lost:
    
        if (r8 == r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a2, code lost:
    
        if (r6.f112026q.i() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00be, code lost:
    
        if (r8 == r1) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00cf, code lost:
    
        if (r6.f112026q.i() == false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object M1(java.util.List r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.M1(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final /* synthetic */ PermissionComposeState Z0(PermissionComposeViewModel permissionComposeViewModel) {
        return (PermissionComposeState) permissionComposeViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (t1(r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r1(kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$areAdvancedProtectionStepsInProgress$1
            if (r0 == 0) goto L13
            r0 = r13
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$areAdvancedProtectionStepsInProgress$1 r0 = (cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$areAdvancedProtectionStepsInProgress$1) r0
            int r1 = r0.f112051d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f112051d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$areAdvancedProtectionStepsInProgress$1 r0 = new cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$areAdvancedProtectionStepsInProgress$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.f112049b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f112051d
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L39
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.b(r13)
            goto L78
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L35:
            kotlin.ResultKt.b(r13)
            goto L4b
        L39:
            kotlin.ResultKt.b(r13)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r13 = r12.f112024o
            kotlinx.coroutines.flow.Flow r13 = r13.b2()
            r0.f112051d = r5
            java.lang.Object r13 = kotlinx.coroutines.flow.FlowKt.D(r13, r0)
            if (r13 != r1) goto L4b
            goto L77
        L4b:
            java.lang.Number r13 = (java.lang.Number) r13
            long r6 = r13.longValue()
            r8 = 0
            int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r13 != 0) goto L5c
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r13
        L5c:
            long r8 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r6
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.DAYS
            r10 = 7
            long r10 = r13.toMillis(r10)
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 <= 0) goto L7d
            r0.f112048a = r6
            r0.f112051d = r4
            java.lang.Object r13 = r12.t1(r0)
            if (r13 != r1) goto L78
        L77:
            return r1
        L78:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r13
        L7d:
            java.lang.Boolean r13 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.r1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c4, code lost:
    
        if (r1 == r3) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0137, code lost:
    
        if (r5 == r3) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0139, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c4 -> B:16:0x0070). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0137 -> B:35:0x013a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s1(kotlin.coroutines.Continuation r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.s1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (r7.y4(false, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t1(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$clearAdvancedProtectionStepsProgress$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$clearAdvancedProtectionStepsProgress$1 r0 = (cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$clearAdvancedProtectionStepsProgress$1) r0
            int r1 = r0.f112069c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f112069c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$clearAdvancedProtectionStepsProgress$1 r0 = new cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel$clearAdvancedProtectionStepsProgress$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f112067a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f112069c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r7)
            goto L54
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L34:
            kotlin.ResultKt.b(r7)
            goto L48
        L38:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r6.f112024o
            r0.f112069c = r4
            r4 = 0
            java.lang.Object r7 = r7.z4(r4, r0)
            if (r7 != r1) goto L48
            goto L53
        L48:
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = r6.f112024o
            r0.f112069c = r3
            r2 = 0
            java.lang.Object r7 = r7.y4(r2, r0)
            if (r7 != r1) goto L54
        L53:
            return r1
        L54:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.t1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0108, code lost:
    
        if (L1(r5, r6, r0) == r1) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8 A[PHI: r5 r6 r7
      0x00d8: PHI (r5v7 boolean) = (r5v5 boolean), (r5v8 boolean) binds: [B:35:0x00d5, B:14:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r6v10 java.util.List) = (r6v7 java.util.List), (r6v12 java.util.List) binds: [B:35:0x00d5, B:14:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x00d8: PHI (r7v19 java.lang.Object) = (r7v18 java.lang.Object), (r7v1 java.lang.Object) binds: [B:35:0x00d5, B:14:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u1(boolean r5, java.util.List r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeViewModel.u1(boolean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionComposeState v1(PermissionComposeState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PermissionComposeState.b(updateState, null, false, false, false, false, false, true, null, false, false, 959, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object w1(Continuation continuation) {
        Object objP0 = P0(PermissionComposeCommand.NavigateBack.f111997a, continuation);
        return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
    }

    private final ConsentHelper x1() {
        return (ConsentHelper) this.A.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore y1() {
        return (DevDataStore) this.B.getValue();
    }

    private final void z1() {
        AnswersHelper.f128199a.e0();
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new PermissionComposeViewModel$handleAdvancedProtectionStepClick$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: E1, reason: merged with bridge method [inline-methods] */
    public void O0(PermissionComposeEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PermissionComposeEvent.OnPermissionClick) {
            C1((PermissionComposeEvent.OnPermissionClick) event);
            return;
        }
        if (event instanceof PermissionComposeEvent.OnLocationFallback) {
            B1(((PermissionComposeEvent.OnLocationFallback) event).a());
            return;
        }
        if (Intrinsics.areEqual(event, PermissionComposeEvent.OnResume.f112011a)) {
            K1();
            return;
        }
        if (Intrinsics.areEqual(event, PermissionComposeEvent.OnRuntimePermissionGranted.f112012a) || Intrinsics.areEqual(event, PermissionComposeEvent.OnDeviceAdminGranted.f112004a)) {
            K1();
            return;
        }
        if (Intrinsics.areEqual(event, PermissionComposeEvent.OnError.f112005a)) {
            A1(true);
            return;
        }
        if (Intrinsics.areEqual(event, PermissionComposeEvent.OnPrivacyExplanationClosed.f112010a)) {
            BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new PermissionComposeViewModel$onEvent$1(this, null), 3, null);
            return;
        }
        if (event instanceof PermissionComposeEvent.OnAccessibilityDisclaimerConfirmed) {
            PrefManager.f126839a.M2(true);
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PermissionComposeViewModel.F1((PermissionComposeState) obj);
                }
            });
            BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new PermissionComposeViewModel$onEvent$3(this, null), 3, null);
        } else if (Intrinsics.areEqual(event, PermissionComposeEvent.OnPermissionSkipped.f112009a)) {
            if (this.f112026q.c()) {
                A1(true);
            }
        } else if (Intrinsics.areEqual(event, PermissionComposeEvent.OnAccessibilityDisclaimerDismissed.f112002a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PermissionComposeViewModel.G1((PermissionComposeState) obj);
                }
            });
        } else if (Intrinsics.areEqual(event, PermissionComposeEvent.OnShowAccessibilityDisclaimer.f112013a)) {
            Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.permissions.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PermissionComposeViewModel.H1((PermissionComposeState) obj);
                }
            });
        } else {
            if (!Intrinsics.areEqual(event, PermissionComposeEvent.OnAdvancedProtectionStepClick.f112003a)) {
                throw new NoWhenBranchMatchedException();
            }
            z1();
        }
    }
}
