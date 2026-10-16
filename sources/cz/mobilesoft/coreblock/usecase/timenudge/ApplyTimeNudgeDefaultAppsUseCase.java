package cz.mobilesoft.coreblock.usecase.timenudge;

import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class ApplyTimeNudgeDefaultAppsUseCase extends SuspendUseCase<Params, Boolean> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f127569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127570b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f127571a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return 873953710;
        }

        public String toString() {
            return "Params";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ApplyTimeNudgeDefaultAppsUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127569a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f127570b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<GetTimeNudgeAppsUseCase>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetTimeNudgeAppsUseCase.class), objArr2, objArr3);
            }
        });
    }

    private final CoreMultiProcessDataStore a() {
        return (CoreMultiProcessDataStore) this.f127569a.getValue();
    }

    private final GetTimeNudgeAppsUseCase b() {
        return (GetTimeNudgeAppsUseCase) this.f127570b.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00aa, code lost:
    
        if (r2.b1(r10, r0) == r1) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase.Params r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$invoke$1
            if (r0 == 0) goto L13
            r0 = r10
            cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$invoke$1 r0 = (cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$invoke$1) r0
            int r1 = r0.f127576f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127576f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$invoke$1 r0 = new cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$invoke$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f127574c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127576f
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L51
            if (r2 == r6) goto L49
            if (r2 == r5) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r9 = r0.f127573b
            java.util.Set r9 = (java.util.Set) r9
            java.lang.Object r9 = r0.f127572a
            cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$Params r9 = (cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase.Params) r9
            kotlin.ResultKt.b(r10)
            goto Lad
        L39:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L41:
            java.lang.Object r9 = r0.f127572a
            cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$Params r9 = (cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase.Params) r9
            kotlin.ResultKt.b(r10)
            goto L87
        L49:
            java.lang.Object r9 = r0.f127572a
            cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$Params r9 = (cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase.Params) r9
            kotlin.ResultKt.b(r10)
            goto L6b
        L51:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r10 = r8.a()
            kotlinx.coroutines.flow.Flow r10 = r10.w0()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f127572a = r2
            r0.f127576f = r6
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r0)
            if (r10 != r1) goto L6b
            goto Lac
        L6b:
            if (r10 == 0) goto L72
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r9
        L72:
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase r10 = r8.b()
            cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase$Params r2 = cz.mobilesoft.coreblock.usecase.timenudge.GetTimeNudgeAppsUseCase.Params.f127634a
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f127572a = r7
            r0.f127576f = r5
            java.lang.Object r10 = r10.l(r2, r0)
            if (r10 != r1) goto L87
            goto Lac
        L87:
            java.util.Set r10 = (java.util.Set) r10
            boolean r2 = r10.isEmpty()
            if (r2 == 0) goto L94
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            return r9
        L94:
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r2 = r8.a()
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)
            r0.f127572a = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r0.f127573b = r9
            r0.f127576f = r4
            java.lang.Object r9 = r2.b1(r10, r0)
            if (r9 != r1) goto Lad
        Lac:
            return r1
        Lad:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase.c(cz.mobilesoft.coreblock.usecase.timenudge.ApplyTimeNudgeDefaultAppsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
