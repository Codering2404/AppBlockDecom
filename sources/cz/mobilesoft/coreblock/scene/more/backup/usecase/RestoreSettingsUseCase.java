package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import androidx.legacy.content.Werj.QgXempTBEfV;
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
public final class RestoreSettingsUseCase extends SuspendUseCase<Params, Integer> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f106842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f106844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106845d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106847g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SettingsDTO f106848a;

        public Params(SettingsDTO settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.f106848a = settings;
        }

        public final SettingsDTO a() {
            return this.f106848a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f106848a, ((Params) obj).f106848a);
        }

        public int hashCode() {
            return this.f106848a.hashCode();
        }

        public String toString() {
            return QgXempTBEfV.oDCvK + this.f106848a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RestoreSettingsUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106842a = LazyKt.a(lazyThreadSafetyModeB, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$special$$inlined$inject$default$1
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
        this.f106843b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$special$$inlined$inject$default$2
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
        this.f106844c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<QuickBlockDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$special$$inlined$inject$default$3
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
        this.f106845d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<InAppUpdatesDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$special$$inlined$inject$default$4
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
        this.f106846f = LazyKt.a(lazyThreadSafetyModeB5, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$special$$inlined$inject$default$5
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
        this.f106847g = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CustomBlockingScreenConfigDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$special$$inlined$inject$default$6
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

    private final CoreDataStore g() {
        return (CoreDataStore) this.f106843b.getValue();
    }

    private final CoreMultiProcessDataStore h() {
        return (CoreMultiProcessDataStore) this.f106846f.getValue();
    }

    private final CustomBlockingScreenConfigDao i() {
        return (CustomBlockingScreenConfigDao) this.f106847g.getValue();
    }

    private final InAppUpdatesDataStore j() {
        return (InAppUpdatesDataStore) this.f106845d.getValue();
    }

    private final NotificationDataStore k() {
        return (NotificationDataStore) this.f106842a.getValue();
    }

    private final QuickBlockDataStore l() {
        return (QuickBlockDataStore) this.f106844c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
    
        if (r8.M(r4, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreCustomBlockScreens$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreCustomBlockScreens$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreCustomBlockScreens$1) r0
            int r1 = r0.f106858d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106858d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreCustomBlockScreens$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreCustomBlockScreens$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f106856b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106858d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.f106855a
            cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO) r7
            kotlin.ResultKt.b(r8)
            goto Lb1
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.f106855a
            cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO) r7
            kotlin.ResultKt.b(r8)
            goto L6e
        L41:
            kotlin.ResultKt.b(r8)
            if (r7 == 0) goto Lb4
            java.util.List r8 = r7.a()
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto Lb4
            java.lang.String r8 = r7.b()
            int r8 = r8.length()
            if (r8 != 0) goto L5b
            goto Lb4
        L5b:
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r8 = r6.h()
            java.lang.String r2 = r7.b()
            r0.f106855a = r7
            r0.f106858d = r4
            java.lang.Object r8 = r8.S0(r2, r0)
            if (r8 != r1) goto L6e
            goto Lb0
        L6e:
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r8 = r6.i()
            r8.b()
            cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao r8 = r6.i()
            java.util.List r2 = r7.a()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
            r4.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L8e:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto La2
            java.lang.Object r5 = r2.next()
            cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenConfigDTO r5 = (cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenConfigDTO) r5
            cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity r5 = r5.a()
            r4.add(r5)
            goto L8e
        La2:
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f106855a = r7
            r0.f106858d = r3
            java.lang.Object r7 = r8.M(r4, r0)
            if (r7 != r1) goto Lb1
        Lb0:
            return r1
        Lb1:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        Lb4:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.n(cz.mobilesoft.coreblock.scene.more.backup.dto.BlockScreenSettingsDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        if (r7.p0(r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotificationBeforeUsageLimitReached$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotificationBeforeUsageLimitReached$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotificationBeforeUsageLimitReached$1) r0
            int r1 = r0.f106862d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106862d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotificationBeforeUsageLimitReached$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotificationBeforeUsageLimitReached$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f106860b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106862d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f106859a
            cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO r6 = (cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO) r6
            kotlin.ResultKt.b(r7)
            goto L73
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f106859a
            cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO r6 = (cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO) r6
            kotlin.ResultKt.b(r7)
            goto L56
        L40:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r7 = r5.k()
            int r2 = r6.b()
            r0.f106859a = r6
            r0.f106862d = r4
            java.lang.Object r7 = r7.o0(r2, r0)
            if (r7 != r1) goto L56
            goto L72
        L56:
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r7 = r5.k()
            cz.mobilesoft.coreblock.enums.EventShowAsType$Companion r2 = cz.mobilesoft.coreblock.enums.EventShowAsType.Companion
            int r4 = r6.a()
            cz.mobilesoft.coreblock.enums.EventShowAsType r2 = r2.b(r4)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f106859a = r6
            r0.f106862d = r3
            java.lang.Object r6 = r7.p0(r2, r0)
            if (r6 != r1) goto L73
        L72:
            return r1
        L73:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.o(cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationBeforeUsageLimitReachedDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
    
        if (s(r8, r0) != r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotifications$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotifications$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotifications$1) r0
            int r1 = r0.f106866d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106866d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotifications$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreNotifications$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f106864b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106866d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.f106863a
            cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO) r7
            kotlin.ResultKt.b(r8)
            goto L8b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.f106863a
            cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO) r7
            kotlin.ResultKt.b(r8)
            goto L74
        L43:
            java.lang.Object r7 = r0.f106863a
            cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO) r7
            kotlin.ResultKt.b(r8)
            goto L61
        L4b:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationsDTO r8 = r7.i()
            cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO r8 = r8.b()
            r0.f106863a = r7
            r0.f106866d = r5
            java.lang.Object r8 = r6.r(r8, r0)
            if (r8 != r1) goto L61
            goto L8a
        L61:
            cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationsDTO r8 = r7.i()
            cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r8 = r8.a()
            r0.f106863a = r7
            r0.f106866d = r4
            java.lang.Object r8 = r6.q(r8, r0)
            if (r8 != r1) goto L74
            goto L8a
        L74:
            cz.mobilesoft.coreblock.scene.more.backup.dto.NotificationsDTO r8 = r7.i()
            cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO r8 = r8.c()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f106863a = r7
            r0.f106866d = r3
            java.lang.Object r7 = r6.s(r8, r0)
            if (r7 != r1) goto L8b
        L8a:
            return r1
        L8b:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.p(cz.mobilesoft.coreblock.scene.more.backup.dto.SettingsDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
    
        if (r8.u0(r2, r0) != r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object q(cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreQuickBlockNotifications$1
            if (r0 == 0) goto L13
            r0 = r8
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreQuickBlockNotifications$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreQuickBlockNotifications$1) r0
            int r1 = r0.f106870d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106870d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreQuickBlockNotifications$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreQuickBlockNotifications$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f106868b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106870d
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L4b
            if (r2 == r5) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.f106867a
            cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO) r7
            kotlin.ResultKt.b(r8)
            goto L8b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.f106867a
            cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO) r7
            kotlin.ResultKt.b(r8)
            goto L74
        L43:
            java.lang.Object r7 = r0.f106867a
            cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO) r7
            kotlin.ResultKt.b(r8)
            goto L61
        L4b:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r8 = r6.k()
            boolean r2 = r7.a()
            r0.f106867a = r7
            r0.f106870d = r5
            java.lang.Object r8 = r8.h0(r2, r0)
            if (r8 != r1) goto L61
            goto L8a
        L61:
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r8 = r6.k()
            boolean r2 = r7.c()
            r0.f106867a = r7
            r0.f106870d = r4
            java.lang.Object r8 = r8.q0(r2, r0)
            if (r8 != r1) goto L74
            goto L8a
        L74:
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r8 = r6.k()
            boolean r2 = r7.b()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r0.f106867a = r7
            r0.f106870d = r3
            java.lang.Object r7 = r8.u0(r2, r0)
            if (r7 != r1) goto L8b
        L8a:
            return r1
        L8b:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.q(cz.mobilesoft.coreblock.scene.more.backup.dto.QuickBlockNotificationsDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d6, code lost:
    
        if (o(r6, r0) != r1) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089 A[PHI: r5
      0x0089: PHI (r5v4 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO) = 
      (r5v1 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
      (r5v6 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
     binds: [B:22:0x0086, B:16:0x004e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[PHI: r5
      0x009d: PHI (r5v7 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO) = 
      (r5v4 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
      (r5v9 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
     binds: [B:25:0x009a, B:15:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1 A[PHI: r5
      0x00b1: PHI (r5v10 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO) = 
      (r5v7 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
      (r5v12 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
     binds: [B:28:0x00ae, B:14:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5 A[PHI: r5
      0x00c5: PHI (r5v13 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO) = 
      (r5v10 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
      (r5v18 cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO)
     binds: [B:31:0x00c2, B:13:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object r(cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.r(cz.mobilesoft.coreblock.scene.more.backup.dto.ScheduleNotificationsDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        if (r7.y0(r2, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreStatisticsNotifications$1
            if (r0 == 0) goto L13
            r0 = r7
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreStatisticsNotifications$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreStatisticsNotifications$1) r0
            int r1 = r0.f106878d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106878d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreStatisticsNotifications$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$restoreStatisticsNotifications$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f106876b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106878d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.f106875a
            cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO r6 = (cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO) r6
            kotlin.ResultKt.b(r7)
            goto L6d
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            java.lang.Object r6 = r0.f106875a
            cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO r6 = (cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO) r6
            kotlin.ResultKt.b(r7)
            goto L56
        L40:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r7 = r5.k()
            boolean r2 = r6.a()
            r0.f106875a = r6
            r0.f106878d = r4
            java.lang.Object r7 = r7.x0(r2, r0)
            if (r7 != r1) goto L56
            goto L6c
        L56:
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r7 = r5.k()
            boolean r2 = r6.b()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r0.f106875a = r6
            r0.f106878d = r3
            java.lang.Object r6 = r7.y0(r2, r0)
            if (r6 != r1) goto L6d
        L6c:
            return r1
        L6d:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.s(cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsNotificationsDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba A[PHI: r6
      0x00ba: PHI (r6v4 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v1 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v6 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:27:0x00b6, B:21:0x007d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0 A[PHI: r6
      0x00e0: PHI (r6v7 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v4 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v9 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:30:0x00dc, B:20:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f9 A[PHI: r6
      0x00f9: PHI (r6v10 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v7 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v12 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:33:0x00f5, B:19:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0112 A[PHI: r6
      0x0112: PHI (r6v13 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v10 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v15 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:36:0x010e, B:18:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012b A[PHI: r6
      0x012b: PHI (r6v16 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v13 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v18 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:39:0x0127, B:17:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0144 A[PHI: r6
      0x0144: PHI (r6v19 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v16 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v21 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:42:0x0140, B:16:0x0051] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0163 A[PHI: r6
      0x0163: PHI (r6v22 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v19 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v24 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:45:0x0160, B:15:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0178 A[PHI: r6
      0x0178: PHI (r6v25 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params) = 
      (r6v22 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
      (r6v27 cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params)
     binds: [B:48:0x0175, B:14:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object m(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.Params r6, kotlin.coroutines.Continuation r7) {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase.m(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
