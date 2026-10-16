package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsDTO;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class RestoreStatisticsUseCase extends SuspendUseCase<Params, Unit> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f106897a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StatisticsDTO f106898a;

        public Params(StatisticsDTO statistics) {
            Intrinsics.checkNotNullParameter(statistics, "statistics");
            this.f106898a = statistics;
        }

        public final StatisticsDTO a() {
            return this.f106898a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && Intrinsics.areEqual(this.f106898a, ((Params) obj).f106898a);
        }

        public int hashCode() {
            return this.f106898a.hashCode();
        }

        public String toString() {
            return "Params(statistics=" + this.f106898a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RestoreStatisticsUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106897a = LazyKt.a(lazyThreadSafetyModeB, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$special$$inlined$inject$default$1
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

    private final IgnoredStatisticsItemDao a() {
        return (IgnoredStatisticsItemDao) this.f106897a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase.Params r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            r18 = this;
            r0 = r20
            boolean r1 = r0 instanceof cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$invoke$1
            if (r1 == 0) goto L17
            r1 = r0
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$invoke$1 r1 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$invoke$1) r1
            int r2 = r1.f106902d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.f106902d = r2
            r2 = r18
            goto L1e
        L17:
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$invoke$1 r1 = new cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$invoke$1
            r2 = r18
            r1.<init>(r2, r0)
        L1e:
            java.lang.Object r0 = r1.f106900b
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r1.f106902d
            r5 = 1
            if (r4 == 0) goto L3b
            if (r4 != r5) goto L33
            java.lang.Object r1 = r1.f106899a
            cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$Params r1 = (cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase.Params) r1
            kotlin.ResultKt.b(r0)
            goto L97
        L33:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3b:
            kotlin.ResultKt.b(r0)
            cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao r0 = r2.a()
            cz.mobilesoft.coreblock.scene.more.backup.dto.StatisticsDTO r4 = r19.a()
            java.util.List r4 = r4.a()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r7)
            r6.<init>(r7)
            java.util.Iterator r4 = r4.iterator()
        L5b:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L88
            java.lang.Object r7 = r4.next()
            cz.mobilesoft.coreblock.scene.more.backup.dto.IgnoreItemDTO r7 = (cz.mobilesoft.coreblock.scene.more.backup.dto.IgnoreItemDTO) r7
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem r8 = new cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem
            java.lang.String r11 = r7.a()
            cz.mobilesoft.coreblock.dto.UsageAccess$Type$Companion r9 = cz.mobilesoft.coreblock.dto.UsageAccess.Type.Companion
            int r7 = r7.b()
            cz.mobilesoft.coreblock.dto.UsageAccess$Type r12 = r9.b(r7)
            cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem$ItemSourceType r13 = cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem.ItemSourceType.CUSTOM
            r16 = 1
            r17 = 0
            r9 = 0
            r14 = 1
            r15 = 1
            r8.<init>(r9, r11, r12, r13, r14, r15, r16, r17)
            r6.add(r8)
            goto L5b
        L88:
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.a(r19)
            r1.f106899a = r4
            r1.f106902d = r5
            java.lang.Object r0 = r0.h0(r6, r1)
            if (r0 != r3) goto L97
            return r3
        L97:
            kotlin.Unit r0 = kotlin.Unit.f139807a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase.b(cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreStatisticsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
