package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsDTO;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
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
public final class GetBackupStatisticsUseCase extends SuspendUseCase<Params, StatisticsDTO> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f106715a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Params f106716a = new Params();

        private Params() {
        }

        public boolean equals(Object obj) {
            return this == obj || (obj instanceof Params);
        }

        public int hashCode() {
            return 2131781281;
        }

        public String toString() {
            return "Params";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetBackupStatisticsUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106715a = LazyKt.a(lazyThreadSafetyModeB, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), qualifier, objArr);
            }
        });
    }

    private final IgnoredStatisticsItemDao b() {
        return (IgnoredStatisticsItemDao) this.f106715a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$getUserSelectedApps$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$getUserSelectedApps$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$getUserSelectedApps$1) r0
            int r1 = r0.f106719c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106719c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$getUserSelectedApps$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$getUserSelectedApps$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f106717a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106719c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r5 = r4.b()
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r2 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            r0.f106719c = r3
            java.lang.Object r5 = r5.c0(r2, r3, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L4c
            r5 = 0
        L4c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase.Params r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$invoke$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$invoke$1 r0 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$invoke$1) r0
            int r1 = r0.f106723d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f106723d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$invoke$1 r0 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$invoke$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f106721b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f106723d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f106720a
            cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$Params r5 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase.Params) r5
            kotlin.ResultKt.b(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r0.f106720a = r5
            r0.f106723d = r3
            java.lang.Object r6 = r4.c(r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L83
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r5 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r0)
            r5.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
        L5c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L7d
            java.lang.Object r0 = r6.next()
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r0 = (cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem) r0
            cz.mobilesoft.coreblock.scene.more.backup.dto.IgnoreItemDTO r1 = new cz.mobilesoft.coreblock.scene.more.backup.dto.IgnoreItemDTO
            java.lang.String r2 = r0.c()
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r0 = r0.d()
            int r0 = r0.getTypeId()
            r1.<init>(r2, r0)
            r5.add(r1)
            goto L5c
        L7d:
            cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsDTO r6 = new cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsDTO
            r6.<init>(r5)
            return r6
        L83:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase.d(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupStatisticsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
