package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.InAppUpdatesDataStore;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao;
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
public final class GetBackupSettingsUseCase extends SuspendUseCase<Params, SettingsDTO> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f106645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f106647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106648d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106650g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f106651a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return -387752479;
        }

        public String toString() {
            return "Params";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetBackupSettingsUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106645a = LazyKt.a(lazyThreadSafetyModeB, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(NotificationDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f106646b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f106647c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockDataStore.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f106648d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<InAppUpdatesDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(InAppUpdatesDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f106649f = LazyKt.a(lazyThreadSafetyModeB5, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f106650g = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CustomBlockingScreenConfigDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CustomBlockingScreenConfigDao.class), objArr10, objArr11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[LOOP:0: B:24:0x0079->B:26:0x007f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getBlockScreenSettingsDTO$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getBlockScreenSettingsDTO$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getBlockScreenSettingsDTO$1) r0
            int r1 = r0.f106655d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106655d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getBlockScreenSettingsDTO$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getBlockScreenSettingsDTO$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f106653b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106655d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r0 = r0.f106652a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r7)
            goto L68
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L38:
            kotlin.ResultKt.b(r7)
            goto L50
        L3c:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r7 = r6.i()
            kotlinx.coroutines.flow.Flow r7 = r7.n0()
            r0.f106655d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L50
            goto L64
        L50:
            java.lang.String r7 = (java.lang.String) r7
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r2 = r6.j()
            kotlinx.coroutines.flow.Flow r2 = r2.J()
            r0.f106652a = r7
            r0.f106655d = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r0 != r1) goto L65
        L64:
            return r1
        L65:
            r5 = r0
            r0 = r7
            r7 = r5
        L68:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r2)
            r1.<init>(r2)
            java.util.Iterator r7 = r7.iterator()
        L79:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L8d
            java.lang.Object r2 = r7.next()
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r2 = (cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity) r2
            cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenConfigDTO r2 = r2.n()
            r1.add(r2)
            goto L79
        L8d:
            cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO r7 = new cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO
            r7.<init>(r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final CoreDataStore h() {
        return (CoreDataStore) this.f106646b.getValue();
    }

    private final CoreMultiProcessDataStore i() {
        return (CoreMultiProcessDataStore) this.f106649f.getValue();
    }

    private final CustomBlockingScreenConfigDao j() {
        return (CustomBlockingScreenConfigDao) this.f106650g.getValue();
    }

    private final InAppUpdatesDataStore k() {
        return (InAppUpdatesDataStore) this.f106648d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationBeforeUsageLimitReachedDTO$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationBeforeUsageLimitReachedDTO$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationBeforeUsageLimitReachedDTO$1) r0
            int r1 = r0.f106659d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106659d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationBeforeUsageLimitReachedDTO$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationBeforeUsageLimitReachedDTO$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f106657b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106659d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            int r0 = r0.f106656a
            kotlin.ResultKt.b(r7)
            goto L6a
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            kotlin.ResultKt.b(r7)
            goto L4e
        L3a:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r7 = r6.m()
            kotlinx.coroutines.flow.Flow r7 = r7.Q()
            r0.f106659d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L4e
            goto L66
        L4e:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r2 = r6.m()
            kotlinx.coroutines.flow.Flow r2 = r2.R()
            r0.f106656a = r7
            r0.f106659d = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r0 != r1) goto L67
        L66:
            return r1
        L67:
            r5 = r0
            r0 = r7
            r7 = r5
        L6a:
            cz.mobilesoft.coreblock.enums.EventShowAsType r7 = (cz.mobilesoft.coreblock.enums.EventShowAsType) r7
            int r7 = r7.getId()
            cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO r1 = new cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO
            r1.<init>(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.l(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final NotificationDataStore m() {
        return (NotificationDataStore) this.f106645a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationsDTO$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationsDTO$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationsDTO$1) r0
            int r1 = r0.f106664f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106664f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationsDTO$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getNotificationsDTO$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f106662c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106664f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L47
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.f106661b
            cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r1 = (cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO) r1
            java.lang.Object r0 = r0.f106660a
            cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO r0 = (cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO) r0
            kotlin.ResultKt.b(r8)
            goto L79
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3f:
            java.lang.Object r2 = r0.f106660a
            cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO r2 = (cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO) r2
            kotlin.ResultKt.b(r8)
            goto L67
        L47:
            kotlin.ResultKt.b(r8)
            goto L57
        L4b:
            kotlin.ResultKt.b(r8)
            r0.f106664f = r5
            java.lang.Object r8 = r7.q(r0)
            if (r8 != r1) goto L57
            goto L75
        L57:
            cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO r8 = (cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO) r8
            r0.f106660a = r8
            r0.f106664f = r4
            java.lang.Object r2 = r7.p(r0)
            if (r2 != r1) goto L64
            goto L75
        L64:
            r6 = r2
            r2 = r8
            r8 = r6
        L67:
            cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r8 = (cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO) r8
            r0.f106660a = r2
            r0.f106661b = r8
            r0.f106664f = r3
            java.lang.Object r0 = r7.r(r0)
            if (r0 != r1) goto L76
        L75:
            return r1
        L76:
            r1 = r8
            r8 = r0
            r0 = r2
        L79:
            cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO r8 = (cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO) r8
            cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationsDTO r2 = new cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationsDTO
            r2.<init>(r0, r1, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.n(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final QuickBlockDataStore o() {
        return (QuickBlockDataStore) this.f106647c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getQuickBlockNotificationsDTO$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getQuickBlockNotificationsDTO$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getQuickBlockNotificationsDTO$1) r0
            int r1 = r0.f106669f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106669f = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getQuickBlockNotificationsDTO$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getQuickBlockNotificationsDTO$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f106667c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106669f
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L41
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            boolean r1 = r0.f106666b
            boolean r0 = r0.f106665a
            kotlin.ResultKt.b(r8)
            goto L93
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3b:
            boolean r2 = r0.f106665a
            kotlin.ResultKt.b(r8)
            goto L75
        L41:
            kotlin.ResultKt.b(r8)
            goto L59
        L45:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r8 = r7.m()
            kotlinx.coroutines.flow.Flow r8 = r8.S()
            r0.f106669f = r5
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.D(r8, r0)
            if (r8 != r1) goto L59
            goto L8f
        L59:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r2 = r7.m()
            kotlinx.coroutines.flow.Flow r2 = r2.T()
            r0.f106665a = r8
            r0.f106669f = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r2 != r1) goto L72
            goto L8f
        L72:
            r6 = r2
            r2 = r8
            r8 = r6
        L75:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r4 = r7.m()
            kotlinx.coroutines.flow.Flow r4 = r4.X()
            r0.f106665a = r2
            r0.f106666b = r8
            r0.f106669f = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r4, r0)
            if (r0 != r1) goto L90
        L8f:
            return r1
        L90:
            r1 = r8
            r8 = r0
            r0 = r2
        L93:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r2 = new cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO
            r2.<init>(r0, r1, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009f A[PHI: r2 r9
      0x009f: PHI (r2v3 int) = (r2v2 int), (r2v4 int) binds: [B:22:0x009b, B:16:0x0064] A[DONT_GENERATE, DONT_INLINE]
      0x009f: PHI (r9v10 java.lang.Object) = (r9v9 java.lang.Object), (r9v1 java.lang.Object) binds: [B:22:0x009b, B:16:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd A[PHI: r2 r3 r4 r9
      0x00dd: PHI (r2v7 boolean) = (r2v5 boolean), (r2v9 boolean) binds: [B:29:0x00da, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r3v8 boolean) = (r3v5 boolean), (r3v10 boolean) binds: [B:29:0x00da, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r4v5 int) = (r4v3 int), (r4v6 int) binds: [B:29:0x00da, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r9v19 java.lang.Object) = (r9v18 java.lang.Object), (r9v1 java.lang.Object) binds: [B:29:0x00da, B:14:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getStatisticsNotificationsDTO$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getStatisticsNotificationsDTO$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getStatisticsNotificationsDTO$1) r0
            int r1 = r0.f106681d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106681d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getStatisticsNotificationsDTO$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$getStatisticsNotificationsDTO$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f106679b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106681d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            boolean r0 = r0.f106678a
            kotlin.ResultKt.b(r7)
            goto L6a
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            kotlin.ResultKt.b(r7)
            goto L4e
        L3a:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r7 = r6.m()
            kotlinx.coroutines.flow.Flow r7 = r7.Y()
            r0.f106681d = r4
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r0)
            if (r7 != r1) goto L4e
            goto L66
        L4e:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r2 = r6.m()
            kotlinx.coroutines.flow.Flow r2 = r2.b0()
            r0.f106678a = r7
            r0.f106681d = r3
            java.lang.Object r0 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r0 != r1) goto L67
        L66:
            return r1
        L67:
            r5 = r0
            r0 = r7
            r7 = r5
        L6a:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO r1 = new cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO
            r1.<init>(r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object s(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.Params r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instruction units count: 980
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase.s(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
