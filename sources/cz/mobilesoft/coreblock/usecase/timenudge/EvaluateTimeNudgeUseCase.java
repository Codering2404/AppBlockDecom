package cz.mobilesoft.coreblock.usecase.timenudge;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class EvaluateTimeNudgeUseCase extends SuspendUseCase<Params, Boolean> implements KoinComponent {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f127583h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f127584i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f127585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127588d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f127589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f127590g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f127591a;

        public Params(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.f127591a = context;
        }

        public final Context a() {
            return this.f127591a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f127591a, ((Params) obj).f127591a);
        }

        public int hashCode() {
            return this.f127591a.hashCode();
        }

        public String toString() {
            return "Params(context=" + this.f127591a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Timings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f127592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f127593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final double f127594c;

        public Timings(long j3, long j4, double d3) {
            this.f127592a = j3;
            this.f127593b = j4;
            this.f127594c = d3;
        }

        public final long a() {
            return this.f127593b;
        }

        public final double b() {
            return this.f127594c;
        }

        public final long c() {
            return this.f127592a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Timings)) {
                return false;
            }
            Timings timings = (Timings) obj;
            return this.f127592a == timings.f127592a && this.f127593b == timings.f127593b && Double.compare(this.f127594c, timings.f127594c) == 0;
        }

        public int hashCode() {
            return (((Long.hashCode(this.f127592a) * 31) + Long.hashCode(this.f127593b)) * 31) + Double.hashCode(this.f127594c);
        }

        public String toString() {
            return "Timings(windowMs=" + this.f127592a + ", cooldownMs=" + this.f127593b + ", thresholdSeconds=" + this.f127594c + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EvaluateTimeNudgeUseCase(Function0 systemTimeMillis) {
        Intrinsics.checkNotNullParameter(systemTimeMillis, "systemTimeMillis");
        this.f127585a = systemTimeMillis;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127586b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$special$$inlined$inject$default$1
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
        this.f127587c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f127588d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<GetTimeNudgeAppsUseCase>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GetTimeNudgeAppsUseCase.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127589f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PickTimeNudgeNotificationMessageUseCase>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PickTimeNudgeNotificationMessageUseCase.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f127590g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr8, objArr9);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long b() {
        return System.currentTimeMillis();
    }

    private final CoreMultiProcessDataStore d() {
        return (CoreMultiProcessDataStore) this.f127586b.getValue();
    }

    private final DevDataStore e() {
        return (DevDataStore) this.f127590g.getValue();
    }

    private final GetTimeNudgeAppsUseCase f() {
        return (GetTimeNudgeAppsUseCase) this.f127588d.getValue();
    }

    private final PickTimeNudgeNotificationMessageUseCase g() {
        return (PickTimeNudgeNotificationMessageUseCase) this.f127589f.getValue();
    }

    private final StatisticsDataStore h() {
        return (StatisticsDataStore) this.f127587c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object j(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$timings$1
            if (r0 == 0) goto L13
            r0 = r9
            cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$timings$1 r0 = (cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$timings$1) r0
            int r1 = r0.f127626c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f127626c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$timings$1 r0 = new cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$timings$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f127624a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f127626c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r9)
            goto L4d
        L29:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L31:
            kotlin.ResultKt.b(r9)
            java.lang.Boolean r9 = cz.mobilesoft.coreblock.BuildConfig.f95357b
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L63
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r9 = r8.e()
            kotlinx.coroutines.flow.Flow r9 = r9.e1()
            r0.f127626c = r3
            java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.D(r9, r0)
            if (r9 != r1) goto L4d
            return r1
        L4d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L63
            cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$Timings r0 = new cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$Timings
            r3 = 120000(0x1d4c0, double:5.9288E-319)
            r5 = 4633641066610819072(0x404e000000000000, double:60.0)
            r1 = 600000(0x927c0, double:2.964394E-318)
            r0.<init>(r1, r3, r5)
            return r0
        L63:
            cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$Timings r1 = new cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$Timings
            r4 = 3600000(0x36ee80, double:1.7786363E-317)
            r6 = 4651127699538968576(0x408c200000000000, double:900.0)
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            r1.<init>(r2, r4, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase.j(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x036c, code lost:
    
        if (r7.Z0(r0, r8) != r2) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object i(cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase.Params r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase.i(cz.mobilesoft.coreblock.usecase.timenudge.EvaluateTimeNudgeUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public /* synthetic */ EvaluateTimeNudgeUseCase(Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Function0() { // from class: cz.mobilesoft.coreblock.usecase.timenudge.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(EvaluateTimeNudgeUseCase.b());
            }
        } : function0);
    }
}
