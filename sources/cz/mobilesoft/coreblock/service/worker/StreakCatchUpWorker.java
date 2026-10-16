package cz.mobilesoft.coreblock.service.worker;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import cz.mobilesoft.coreblock.scene.streaks.StreakStore;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.TemporalAmount;
import java.util.concurrent.TimeUnit;
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
public final class StreakCatchUpWorker extends CoroutineWorker implements KoinComponent {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f123969f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f123970g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Duration f123971h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123972d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final long a(long j3) {
            ZoneId zoneIdSystemDefault = ZoneId.systemDefault();
            return Instant.ofEpochMilli(j3).atZone(zoneIdSystemDefault).toLocalDate().plusDays(1L).atStartOfDay(zoneIdSystemDefault).plus((TemporalAmount) StreakCatchUpWorker.f123971h).toInstant().toEpochMilli();
        }

        static /* synthetic */ long b(Companion companion, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j3 = TimeHelperExt.f128663a.f();
            }
            return companion.a(j3);
        }

        public final void c(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WorkManager.h(context).e("STREAK_CATCH_UP", ExistingPeriodicWorkPolicy.UPDATE, (PeriodicWorkRequest) new PeriodicWorkRequest.Builder(StreakCatchUpWorker.class, 1L, TimeUnit.DAYS).o(b(this, 0L, 1, null)).b());
        }

        private Companion() {
        }
    }

    static {
        Duration durationOfMinutes = Duration.ofMinutes(63L);
        Intrinsics.checkNotNullExpressionValue(durationOfMinutes, "ofMinutes(...)");
        f123971h = durationOfMinutes;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StreakCatchUpWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123972d = LazyKt.a(lazyThreadSafetyModeB, new Function0<StreakStore>() { // from class: cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StreakStore.class), qualifier, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StreakStore k() {
        return (StreakStore) this.f123972d.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$doWork$1 r0 = (cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$doWork$1) r0
            int r1 = r0.f123975c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f123975c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$doWork$1 r0 = new cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$doWork$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f123973a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f123975c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.CoroutineExceptionHandler r6 = cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt.b()
            cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$doWork$2 r2 = new cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.f123975c = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r2, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.lang.String r0 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.worker.StreakCatchUpWorker.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
