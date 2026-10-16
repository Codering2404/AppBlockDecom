package cz.mobilesoft.coreblock.scene.strictmode3.approval;

import android.app.Application;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository;
import cz.mobilesoft.coreblock.repository.TokenFCMRepository;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
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
public final class ApprovalRepository implements KoinComponent {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Companion f121713k = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f121714l = 8;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f121715m = TimeUnit.HOURS.toMillis(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Application f121716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f121717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f121718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f121719d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f121720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineScope f121721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Job f121722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableSharedFlow f121723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final SharedFlow f121724j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class ApprovalCheckTrigger {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ApprovalCheckTrigger[] $VALUES;
        public static final ApprovalCheckTrigger UserRefresh = new ApprovalCheckTrigger("UserRefresh", 0);
        public static final ApprovalCheckTrigger ScreenOpened = new ApprovalCheckTrigger("ScreenOpened", 1);
        public static final ApprovalCheckTrigger Push = new ApprovalCheckTrigger("Push", 2);

        private static final /* synthetic */ ApprovalCheckTrigger[] $values() {
            return new ApprovalCheckTrigger[]{UserRefresh, ScreenOpened, Push};
        }

        static {
            ApprovalCheckTrigger[] approvalCheckTriggerArr$values = $values();
            $VALUES = approvalCheckTriggerArr$values;
            $ENTRIES = EnumEntriesKt.a(approvalCheckTriggerArr$values);
        }

        private ApprovalCheckTrigger(String str, int i3) {
        }

        public static EnumEntries<ApprovalCheckTrigger> getEntries() {
            return $ENTRIES;
        }

        public static ApprovalCheckTrigger valueOf(String str) {
            return (ApprovalCheckTrigger) Enum.valueOf(ApprovalCheckTrigger.class, str);
        }

        public static ApprovalCheckTrigger[] values() {
            return (ApprovalCheckTrigger[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return ApprovalRepository.f121715m;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ApprovalRepository(Application applicationContext, long j3) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f121716a = applicationContext;
        this.f121717b = j3;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f121718c = LazyKt.a(lazyThreadSafetyModeB, new Function0<AccountabilityPartnerRepository>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(AccountabilityPartnerRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f121719d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f121720f = LazyKt.a(lazyThreadSafetyModeB3, new Function0<TokenFCMRepository>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TokenFCMRepository.class), objArr4, objArr5);
            }
        });
        this.f121721g = CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.b()));
        MutableSharedFlow mutableSharedFlowB = SharedFlowKt.b(0, 0, null, 7, null);
        this.f121723i = mutableSharedFlowB;
        this.f121724j = FlowKt.b(mutableSharedFlowB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeDataStore A() {
        return (StrictModeDataStore) this.f121719d.getValue();
    }

    private final TokenFCMRepository B() {
        return (TokenFCMRepository) this.f121720f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object F(cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.ApprovalCheckTrigger r8, boolean r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$1) r0
            int r1 = r0.f121789h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121789h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f121787f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121789h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.f121784b
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref.BooleanRef) r8
            java.lang.Object r9 = r0.f121783a
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$ApprovalCheckTrigger r9 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.ApprovalCheckTrigger) r9
            kotlin.ResultKt.b(r10)
            goto L98
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            boolean r9 = r0.f121786d
            java.lang.Object r8 = r0.f121785c
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r8 = (cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository) r8
            java.lang.Object r2 = r0.f121784b
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r4 = r0.f121783a
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$ApprovalCheckTrigger r4 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.ApprovalCheckTrigger) r4
            kotlin.ResultKt.b(r10)
            r6 = r2
            r2 = r10
            r10 = r6
            goto L76
        L51:
            kotlin.ResultKt.b(r10)
            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef
            r10.<init>()
            r10.f140137a = r4
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r2 = r7.v()
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils r5 = cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.f129470a
            r0.f121783a = r8
            r0.f121784b = r10
            r0.f121785c = r2
            r0.f121786d = r9
            r0.f121789h = r4
            java.lang.Object r4 = r5.b(r0)
            if (r4 != r1) goto L72
            goto L96
        L72:
            r6 = r4
            r4 = r8
            r8 = r2
            r2 = r6
        L76:
            java.lang.String r2 = (java.lang.String) r2
            kotlinx.coroutines.flow.Flow r8 = r8.d(r2)
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$2 r2 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$readApprovalState$2
            r2.<init>(r10, r9, r7, r4)
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r0.f121783a = r4
            r0.f121784b = r10
            r4 = 0
            r0.f121785c = r4
            r0.f121786d = r9
            r0.f121789h = r3
            java.lang.Object r8 = r8.collect(r2, r0)
            if (r8 != r1) goto L97
        L96:
            return r1
        L97:
            r8 = r10
        L98:
            boolean r8 = r8.f140137a
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.F(cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$ApprovalCheckTrigger, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        BuildersKt__Builders_commonKt.d(this.f121721g, null, null, new ApprovalRepository$startApprovalResendEmailCountdown$1(this, null), 3, null);
    }

    private final void p(ApprovalCheckTrigger approvalCheckTrigger) {
        BuildersKt__Builders_commonKt.d(this.f121721g, null, null, new ApprovalRepository$approvalCheckForApproval$1(approvalCheckTrigger, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(long j3) {
        Job job = this.f121722h;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f121722h = FlowKt.Q(FlowKt.V(TimeHelperExt.f128663a.a(j3, 1000L), new ApprovalRepository$approvalResendEmailCountdown$1(this, null)), this.f121721g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0094, code lost:
    
        if (r8.collect(r2, r0) != r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartner$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartner$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartner$1) r0
            int r1 = r0.f121766f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121766f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartner$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartner$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f121764c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121766f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4c
            if (r2 == r5) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            kotlin.ResultKt.b(r8)
            goto L97
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            java.lang.Object r2 = r0.f121763b
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.f121762a
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r4 = (cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository) r4
            kotlin.ResultKt.b(r8)
            goto L7e
        L44:
            java.lang.Object r2 = r0.f121762a
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r2 = (cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository) r2
            kotlin.ResultKt.b(r8)
            goto L69
        L4c:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r8 = r7.v()
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r2 = r7.A()
            kotlinx.coroutines.flow.Flow r2 = r2.h0()
            r0.f121762a = r8
            r0.f121766f = r5
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r2 != r1) goto L66
            goto L96
        L66:
            r6 = r2
            r2 = r8
            r8 = r6
        L69:
            java.lang.String r8 = (java.lang.String) r8
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils r5 = cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.f129470a
            r0.f121762a = r2
            r0.f121763b = r8
            r0.f121766f = r4
            java.lang.Object r4 = r5.b(r0)
            if (r4 != r1) goto L7a
            goto L96
        L7a:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L7e:
            java.lang.String r8 = (java.lang.String) r8
            kotlinx.coroutines.flow.Flow r8 = r4.b(r2, r8)
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartner$2 r2 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartner$2
            r2.<init>(r7)
            r4 = 0
            r0.f121762a = r4
            r0.f121763b = r4
            r0.f121766f = r3
            java.lang.Object r8 = r8.collect(r2, r0)
            if (r8 != r1) goto L97
        L96:
            return r1
        L97:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        if (r8 == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(java.lang.String r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartnerSync$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartnerSync$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartnerSync$1) r0
            int r1 = r0.f121777g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121777g = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartnerSync$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$assignAccountabilityPartnerSync$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f121775d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121777g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.f121772a
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r8)
            goto L7b
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r7 = r0.f121774c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = r0.f121773b
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r2 = (cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository) r2
            java.lang.Object r4 = r0.f121772a
            java.lang.String r4 = (java.lang.String) r4
            kotlin.ResultKt.b(r8)
            goto L65
        L48:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.repository.AccountabilityPartnerRepository r2 = r6.v()
            cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils r8 = cz.mobilesoft.coreblock.util.runnability.DeviceIdUtils.f129470a
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f121772a = r5
            r0.f121773b = r2
            r0.f121774c = r7
            r0.f121777g = r4
            java.lang.Object r8 = r8.b(r0)
            if (r8 != r1) goto L64
            goto L7a
        L64:
            r4 = r7
        L65:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r0.f121772a = r4
            r4 = 0
            r0.f121773b = r4
            r0.f121774c = r4
            r0.f121777g = r3
            java.lang.Object r8 = r2.c(r7, r8, r0)
            if (r8 != r1) goto L7b
        L7a:
            return r1
        L7b:
            cz.mobilesoft.coreblock.util.DataState r8 = (cz.mobilesoft.coreblock.util.DataState) r8
            boolean r7 = r8 instanceof cz.mobilesoft.coreblock.util.DataState.Error
            if (r7 == 0) goto L8d
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Error r7 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Error
            cz.mobilesoft.coreblock.util.DataState$Error r8 = (cz.mobilesoft.coreblock.util.DataState.Error) r8
            cz.mobilesoft.coreblock.util.FailedWithError r8 = r8.d()
            r7.<init>(r8)
            return r7
        L8d:
            cz.mobilesoft.coreblock.util.DataState$Loading r7 = cz.mobilesoft.coreblock.util.DataState.Loading.f127816a
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r7)
            if (r7 == 0) goto L98
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Loading r7 = cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent.Loading.f121707a
            return r7
        L98:
            boolean r7 = r8 instanceof cz.mobilesoft.coreblock.util.DataState.Success
            if (r7 == 0) goto L9f
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$ReadyToActivate r7 = cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent.ReadyToActivate.f121708a
            return r7
        L9f:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.t(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccountabilityPartnerRepository v() {
        return (AccountabilityPartnerRepository) this.f121718c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApprovalEvent.Error z() {
        return new ApprovalEvent.Error(new FailedWithError(null, null, null, this.f121716a.getString(R.string.Cd), 7, null));
    }

    public final void C() {
        p(ApprovalCheckTrigger.Push);
    }

    public final void D(StrictModeAccessMethod strictModeAccessMethod) {
        if (strictModeAccessMethod == StrictModeAccessMethod.Approval) {
            p(ApprovalCheckTrigger.UserRefresh);
        }
    }

    public final void E(StrictModeAccessMethod strictModeAccessMethod, StrictModeState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == StrictModeState.Active && strictModeAccessMethod == StrictModeAccessMethod.Approval) {
            p(ApprovalCheckTrigger.ScreenOpened);
        }
    }

    public final void G(AccessMethodConfiguration accessMethodConfiguration, StrictModeState state) {
        Intrinsics.checkNotNullParameter(accessMethodConfiguration, "accessMethodConfiguration");
        Intrinsics.checkNotNullParameter(state, "state");
        BuildersKt__Builders_commonKt.d(this.f121721g, null, null, new ApprovalRepository$resumeApprovalResendEmailCountdownIfNeeded$1(state, accessMethodConfiguration, this, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.lang.String r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$3
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$3 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$3) r0
            int r1 = r0.f121740h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121740h = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$3 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$3
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f121738f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121740h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L51
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.f121737d
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r7 = r0.f121736c
            cz.mobilesoft.coreblock.util.DataState r7 = (cz.mobilesoft.coreblock.util.DataState) r7
            java.lang.Object r7 = r0.f121735b
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r7 = r0.f121734a
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.b(r8)
            goto L98
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            java.lang.Object r6 = r0.f121735b
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r6 = r0.f121734a
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.b(r8)
            goto L65
        L51:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.repository.TokenFCMRepository r8 = r5.B()
            r0.f121734a = r6
            r0.f121735b = r7
            r0.f121740h = r4
            java.lang.Object r8 = r8.e(r0)
            if (r8 != r1) goto L65
            goto L96
        L65:
            cz.mobilesoft.coreblock.util.DataState r8 = (cz.mobilesoft.coreblock.util.DataState) r8
            boolean r2 = r8 instanceof cz.mobilesoft.coreblock.util.DataState.Error
            if (r2 == 0) goto L7a
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Error r6 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Error
            cz.mobilesoft.coreblock.util.DataState$Error r8 = (cz.mobilesoft.coreblock.util.DataState.Error) r8
            cz.mobilesoft.coreblock.util.FailedWithError r8 = r8.d()
            r6.<init>(r8)
            r7.invoke(r6)
            goto L9b
        L7a:
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f121734a = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f121735b = r2
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f121736c = r8
            r0.f121737d = r7
            r0.f121740h = r3
            java.lang.Object r8 = r5.t(r6, r0)
            if (r8 != r1) goto L97
        L96:
            return r1
        L97:
            r6 = r7
        L98:
            r6.invoke(r8)
        L9b:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.m(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x008b, code lost:
    
        if (r2.emit(r3, r0) == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009d, code lost:
    
        if (s(r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$1) r0
            int r1 = r0.f121728d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121728d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f121726b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121728d
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L4e
            if (r2 == r6) goto L4a
            if (r2 == r5) goto L46
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r0 = r0.f121725a
            cz.mobilesoft.coreblock.util.DataState r0 = (cz.mobilesoft.coreblock.util.DataState) r0
            kotlin.ResultKt.b(r8)
            goto La0
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3e:
            java.lang.Object r0 = r0.f121725a
            cz.mobilesoft.coreblock.util.DataState r0 = (cz.mobilesoft.coreblock.util.DataState) r0
            kotlin.ResultKt.b(r8)
            goto L8e
        L46:
            kotlin.ResultKt.b(r8)
            goto L6b
        L4a:
            kotlin.ResultKt.b(r8)
            goto L5e
        L4e:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.flow.MutableSharedFlow r8 = r7.f121723i
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Loading r2 = cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent.Loading.f121707a
            r0.f121728d = r6
            java.lang.Object r8 = r8.emit(r2, r0)
            if (r8 != r1) goto L5e
            goto L9f
        L5e:
            cz.mobilesoft.coreblock.repository.TokenFCMRepository r8 = r7.B()
            r0.f121728d = r5
            java.lang.Object r8 = r8.e(r0)
            if (r8 != r1) goto L6b
            goto L9f
        L6b:
            cz.mobilesoft.coreblock.util.DataState r8 = (cz.mobilesoft.coreblock.util.DataState) r8
            boolean r2 = r8 instanceof cz.mobilesoft.coreblock.util.DataState.Error
            if (r2 == 0) goto L91
            kotlinx.coroutines.flow.MutableSharedFlow r2 = r7.f121723i
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Error r3 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent$Error
            r5 = r8
            cz.mobilesoft.coreblock.util.DataState$Error r5 = (cz.mobilesoft.coreblock.util.DataState.Error) r5
            cz.mobilesoft.coreblock.util.FailedWithError r5 = r5.d()
            r3.<init>(r5)
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f121725a = r8
            r0.f121728d = r4
            java.lang.Object r8 = r2.emit(r3, r0)
            if (r8 != r1) goto L8e
            goto L9f
        L8e:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L91:
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)
            r0.f121725a = r8
            r0.f121728d = r3
            java.lang.Object r8 = r7.s(r0)
            if (r8 != r1) goto La0
        L9f:
            return r1
        La0:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        if (r6.m((java.lang.String) r7, r2, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$2
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$2 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$2) r0
            int r1 = r0.f121733f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121733f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$2 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$activateApproval$2
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f121731c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121733f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f121729a
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            kotlin.ResultKt.b(r7)
            goto L72
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f121730b
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository r6 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository) r6
            java.lang.Object r2 = r0.f121729a
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            kotlin.ResultKt.b(r7)
            goto L5e
        L44:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore r7 = r5.A()
            kotlinx.coroutines.flow.Flow r7 = r7.h0()
            r0.f121729a = r6
            r0.f121730b = r5
            r0.f121733f = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L5c
            goto L71
        L5c:
            r2 = r6
            r6 = r5
        L5e:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r2)
            r0.f121729a = r4
            r4 = 0
            r0.f121730b = r4
            r0.f121733f = r3
            java.lang.Object r6 = r6.m(r7, r2, r0)
            if (r6 != r1) goto L72
        L71:
            return r1
        L72:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.o(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void r() {
        BuildersKt__Builders_commonKt.d(this.f121721g, null, null, new ApprovalRepository$approvalSendUnblockRequest$1(this, null), 3, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final Object u(Continuation continuation) {
        Job job = this.f121722h;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        Object objO0 = A().O0(0L, continuation);
        return objO0 == IntrinsicsKt.f() ? objO0 : Unit.f139807a;
    }

    public final Application w() {
        return this.f121716a;
    }

    public final SharedFlow x() {
        return this.f121724j;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object y(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$getApprovalLastSendEmailRequestDateTime$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$getApprovalLastSendEmailRequestDateTime$1 r0 = (cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$getApprovalLastSendEmailRequestDateTime$1) r0
            int r1 = r0.f121780c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f121780c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$getApprovalLastSendEmailRequestDateTime$1 r0 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$getApprovalLastSendEmailRequestDateTime$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f121778a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f121780c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L47
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.b()
            cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$getApprovalLastSendEmailRequestDateTime$startTime$1 r2 = new cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository$getApprovalLastSendEmailRequestDateTime$startTime$1
            r4 = 0
            r2.<init>(r6, r4)
            r0.f121780c = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r2, r0)
            if (r7 != r1) goto L47
            return r1
        L47:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            r4 = 0
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r7 == 0) goto La5
            boolean r7 = android.text.format.DateUtils.isToday(r0)
            if (r7 == 0) goto L85
            android.app.Application r7 = r6.f121716a
            int r2 = cz.mobilesoft.coreblock.R.string.SD
            java.lang.String r7 = r7.getString(r2)
            android.app.Application r2 = r6.f121716a
            r4 = 0
            java.text.DateFormat r2 = cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt.i(r2, r4, r3)
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.e(r0)
            java.lang.String r0 = r2.format(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r7 = " "
            r1.append(r7)
            r1.append(r0)
            java.lang.String r7 = r1.toString()
            return r7
        L85:
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "MMMM d, yyyy HH:mm"
            java.lang.String r2 = android.text.format.DateFormat.getBestDateTimePattern(r2, r3)
            java.util.Locale r3 = java.util.Locale.getDefault()
            r7.<init>(r2, r3)
            java.util.Date r2 = new java.util.Date
            r2.<init>(r0)
            java.lang.String r7 = r7.format(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            return r7
        La5:
            java.lang.String r7 = ""
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalRepository.y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ ApprovalRepository(Application application, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i3 & 2) != 0 ? TimeUnit.SECONDS.toMillis(5L) : j3);
    }
}
