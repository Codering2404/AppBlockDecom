package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import cz.mobilesoft.coreblock.scene.more.backup.dto.HistoryDTO;
import cz.mobilesoft.coreblock.storage.room.dao.core.PomodoroHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.QuickBlockTimerHistoryDao;
import cz.mobilesoft.coreblock.storage.room.dao.core.SchedulePauseHistoryDao;
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
public final class GetBackupHistoryUseCase extends SuspendUseCase<Params, HistoryDTO> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f106566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f106568c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f106569a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return 327472880;
        }

        public String toString() {
            return "Params";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetBackupHistoryUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106566a = LazyKt.a(lazyThreadSafetyModeB, new Function0<SchedulePauseHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SchedulePauseHistoryDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f106567b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<QuickBlockTimerHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockTimerHistoryDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f106568c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<PomodoroHistoryDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PomodoroHistoryDao.class), objArr4, objArr5);
            }
        });
    }

    private final PomodoroHistoryDao a() {
        return (PomodoroHistoryDao) this.f106568c.getValue();
    }

    private final QuickBlockTimerHistoryDao b() {
        return (QuickBlockTimerHistoryDao) this.f106567b.getValue();
    }

    private final SchedulePauseHistoryDao c() {
        return (SchedulePauseHistoryDao) this.f106566a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5 A[LOOP:1: B:30:0x00bf->B:32:0x00c5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010c A[LOOP:0: B:38:0x0106->B:40:0x010c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0140 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase.Params r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase.d(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupHistoryUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
