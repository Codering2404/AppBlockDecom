package cz.mobilesoft.coreblock.util.monetization;

import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumStateChangeReactor implements KoinComponent {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f128907f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f128908g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f128909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f128910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f128911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f128912d;

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
    public PremiumStateChangeReactor() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f128909a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f128910b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f128911c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f128912d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<CustomBlockingScreenConfigDao>() { // from class: cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CustomBlockingScreenConfigDao.class), objArr6, objArr7);
            }
        });
    }

    private final CoreDataStore a() {
        return (CoreDataStore) this.f128909a.getValue();
    }

    private final CoreMultiProcessDataStore b() {
        return (CoreMultiProcessDataStore) this.f128911c.getValue();
    }

    private final CustomBlockingScreenConfigDao c() {
        return (CustomBlockingScreenConfigDao) this.f128912d.getValue();
    }

    private final DiscountDataStore d() {
        return (DiscountDataStore) this.f128910b.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onPremiumUnsubscribed$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onPremiumUnsubscribed$1 r0 = (cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onPremiumUnsubscribed$1) r0
            int r1 = r0.f128915c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f128915c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onPremiumUnsubscribed$1 r0 = new cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onPremiumUnsubscribed$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f128913a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f128915c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L4a
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            java.lang.String r5 = "PremiumStateChangeReactor"
            java.lang.String r2 = "Triggering premium expiring flow"
            android.util.Log.i(r5, r2)
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r5 = r4.a()
            cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$PremiumExpiringFlowState r2 = cz.mobilesoft.coreblock.repository.PremiumRepositoryV2.PremiumExpiringFlowState.Show
            r0.f128915c = r3
            java.lang.Object r5 = r5.O5(r2, r0)
            if (r5 != r1) goto L4a
            return r1
        L4a:
            cz.mobilesoft.coreblock.util.runnability.JobHelper.i()
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0192, code lost:
    
        if (cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDaoKt.a(r10, r3, r0) == r1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01c1, code lost:
    
        if (r10 != r1) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012d A[PHI: r8 r9
      0x012d: PHI (r8v10 cz.mobilesoft.coreblock.enums.PremiumState) = 
      (r8v2 cz.mobilesoft.coreblock.enums.PremiumState)
      (r8v7 cz.mobilesoft.coreblock.enums.PremiumState)
      (r8v7 cz.mobilesoft.coreblock.enums.PremiumState)
      (r8v12 cz.mobilesoft.coreblock.enums.PremiumState)
     binds: [B:43:0x012a, B:29:0x00ea, B:41:0x0126, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]
      0x012d: PHI (r9v9 cz.mobilesoft.coreblock.enums.PremiumState) = 
      (r9v2 cz.mobilesoft.coreblock.enums.PremiumState)
      (r9v6 cz.mobilesoft.coreblock.enums.PremiumState)
      (r9v6 cz.mobilesoft.coreblock.enums.PremiumState)
      (r9v11 cz.mobilesoft.coreblock.enums.PremiumState)
     binds: [B:43:0x012a, B:29:0x00ea, B:41:0x0126, B:16:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0144 A[PHI: r8 r9 r10
      0x0144: PHI (r8v13 cz.mobilesoft.coreblock.enums.PremiumState) = (r8v10 cz.mobilesoft.coreblock.enums.PremiumState), (r8v16 cz.mobilesoft.coreblock.enums.PremiumState) binds: [B:45:0x0140, B:15:0x005f] A[DONT_GENERATE, DONT_INLINE]
      0x0144: PHI (r9v12 cz.mobilesoft.coreblock.enums.PremiumState) = (r9v9 cz.mobilesoft.coreblock.enums.PremiumState), (r9v15 cz.mobilesoft.coreblock.enums.PremiumState) binds: [B:45:0x0140, B:15:0x005f] A[DONT_GENERATE, DONT_INLINE]
      0x0144: PHI (r10v18 java.lang.Object) = (r10v17 java.lang.Object), (r10v1 java.lang.Object) binds: [B:45:0x0140, B:15:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0198 A[PHI: r8 r9 r10
      0x0198: PHI (r8v20 cz.mobilesoft.coreblock.enums.PremiumState) = (r8v13 cz.mobilesoft.coreblock.enums.PremiumState), (r8v22 cz.mobilesoft.coreblock.enums.PremiumState) binds: [B:48:0x014a, B:61:0x0195] A[DONT_GENERATE, DONT_INLINE]
      0x0198: PHI (r9v19 cz.mobilesoft.coreblock.enums.PremiumState) = (r9v12 cz.mobilesoft.coreblock.enums.PremiumState), (r9v24 cz.mobilesoft.coreblock.enums.PremiumState) binds: [B:48:0x014a, B:61:0x0195] A[DONT_GENERATE, DONT_INLINE]
      0x0198: PHI (r10v26 java.lang.String) = (r10v19 java.lang.String), (r10v28 java.lang.String) binds: [B:48:0x014a, B:61:0x0195] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(cz.mobilesoft.coreblock.enums.PremiumState r8, cz.mobilesoft.coreblock.enums.PremiumState r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor.f(cz.mobilesoft.coreblock.enums.PremiumState, cz.mobilesoft.coreblock.enums.PremiumState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        if (r7.O0(false, r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(cz.mobilesoft.coreblock.enums.PremiumState r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onStateResolved$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onStateResolved$1 r0 = (cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onStateResolved$1) r0
            int r1 = r0.f128925d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f128925d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onStateResolved$1 r0 = new cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor$onStateResolved$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f128923b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f128925d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f128922a
            cz.mobilesoft.coreblock.enums.PremiumState r6 = (cz.mobilesoft.coreblock.enums.PremiumState) r6
            kotlin.ResultKt.b(r7)
            goto L99
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f128922a
            cz.mobilesoft.coreblock.enums.PremiumState r6 = (cz.mobilesoft.coreblock.enums.PremiumState) r6
            kotlin.ResultKt.b(r7)
            goto L5d
        L40:
            kotlin.ResultKt.b(r7)
            boolean r7 = r6 instanceof cz.mobilesoft.coreblock.enums.PremiumState.Old
            if (r7 != 0) goto L4a
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L4a:
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r7 = r5.b()
            kotlinx.coroutines.flow.Flow r7 = r7.j0()
            r0.f128922a = r6
            r0.f128925d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L5d
            goto L98
        L5d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L68
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L68:
            r7 = r6
            cz.mobilesoft.coreblock.enums.PremiumState$Old r7 = (cz.mobilesoft.coreblock.enums.PremiumState.Old) r7
            boolean r2 = r7 instanceof cz.mobilesoft.coreblock.enums.PremiumState.OldFull
            if (r2 == 0) goto L75
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r7 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r7.L2()
            goto L85
        L75:
            boolean r7 = r7 instanceof cz.mobilesoft.coreblock.enums.PremiumState.OldPartial
            if (r7 == 0) goto L9c
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r7 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r2 = r6
            cz.mobilesoft.coreblock.enums.PremiumState$OldPartial r2 = (cz.mobilesoft.coreblock.enums.PremiumState.OldPartial) r2
            java.util.List r2 = r2.o()
            r7.M2(r2)
        L85:
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r7 = r5.b()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f128922a = r6
            r0.f128925d = r3
            r6 = 0
            java.lang.Object r6 = r7.O0(r6, r0)
            if (r6 != r1) goto L99
        L98:
            return r1
        L99:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L9c:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.monetization.PremiumStateChangeReactor.g(cz.mobilesoft.coreblock.enums.PremiumState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
