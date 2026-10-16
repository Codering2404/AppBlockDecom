package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.BaseDao;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class UsageLimitDao implements BaseDao<UsageLimit>, KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f125227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f125228b;

    /* JADX WARN: Multi-variable type inference failed */
    public UsageLimitDao() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f125227a = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao$special$$inlined$inject$default$1
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
        this.f125228b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr2, objArr3);
            }
        });
    }

    static /* synthetic */ Object Q(UsageLimitDao usageLimitDao, Collection collection, Collection collection2, UrlDto urlDto, Continuation continuation) {
        if (collection.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        if (urlDto == null || collection2 == null) {
            return collection2 != null ? usageLimitDao.O(collection, collection2, continuation) : usageLimitDao.N(collection, continuation);
        }
        return usageLimitDao.R(collection, collection2, urlDto.getUrl(), urlDto.getDomain(), StringsKt.K0(urlDto.getDomain(), "www."), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0196 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object U(cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao r19, java.util.List r20, long r21, java.util.Collection r23, cz.mobilesoft.coreblock.dto.UrlDto r24, kotlin.coroutines.Continuation r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao.U(cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao, java.util.List, long, java.util.Collection, cz.mobilesoft.coreblock.dto.UrlDto, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fb, code lost:
    
        if (r14.r(r5, r3) == r4) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object Z(cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao r17, int r18, int r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao.Z(cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0178, code lost:
    
        if (r14.n(r17, r3) == r4) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object b0(cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao r36, long r37, long r39, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.PeriodType r41, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit.LimitType r42, kotlin.coroutines.Continuation r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao.b0(cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao, long, long, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$PeriodType, cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit$LimitType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Object J(long j3, UsageLimit.PeriodType periodType, UsageLimit.LimitType limitType, Continuation continuation);

    public abstract Object K(Collection collection, Continuation continuation);

    public abstract Object L(Collection collection, UsageLimit.LimitType limitType, Continuation continuation);

    public abstract Object M(long j3, UsageLimit.LimitType limitType, Continuation continuation);

    public abstract Object N(Collection collection, Continuation continuation);

    public abstract Object O(Collection collection, Collection collection2, Continuation continuation);

    public Object P(Collection collection, Collection collection2, UrlDto urlDto, Continuation continuation) {
        return Q(this, collection, collection2, urlDto, continuation);
    }

    public abstract Object R(Collection collection, Collection collection2, String str, String str2, String str3, Continuation continuation);

    public abstract Object S(long j3, UsageLimit.PeriodType periodType, Continuation continuation);

    public Object T(List list, long j3, Collection collection, UrlDto urlDto, Continuation continuation) {
        return U(this, list, j3, collection, urlDto, continuation);
    }

    public final CoreMultiProcessDataStore V() {
        return (CoreMultiProcessDataStore) this.f125227a.getValue();
    }

    public final EventDataStore W() {
        return (EventDataStore) this.f125228b.getValue();
    }

    public abstract Object X(long j3, UsageLimit.LimitType limitType, Continuation continuation);

    public Object Y(int i3, int i4, Continuation continuation) {
        return Z(this, i3, i4, continuation);
    }

    public Object a0(long j3, long j4, UsageLimit.PeriodType periodType, UsageLimit.LimitType limitType, Continuation continuation) {
        return b0(this, j3, j4, periodType, limitType, continuation);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
