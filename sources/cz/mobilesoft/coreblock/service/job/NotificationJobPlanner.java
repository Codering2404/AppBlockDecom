package cz.mobilesoft.coreblock.service.job;

import android.content.Context;
import cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StatisticsDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NotificationJobPlanner implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationJobPlanner f123365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f123366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f123367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f123368d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f123369f;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final NotificationJobPlanner notificationJobPlanner = new NotificationJobPlanner();
        f123365a = notificationJobPlanner;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f123366b = LazyKt.a(lazyThreadSafetyModeB, new Function0<StatisticsDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.NotificationJobPlanner$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = notificationJobPlanner;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StatisticsDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f123367c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<NotificationDataStore>() { // from class: cz.mobilesoft.coreblock.service.job.NotificationJobPlanner$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = notificationJobPlanner;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(NotificationDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f123368d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<IgnoredStatisticsItemDao>() { // from class: cz.mobilesoft.coreblock.service.job.NotificationJobPlanner$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = notificationJobPlanner;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IgnoredStatisticsItemDao.class), objArr4, objArr5);
            }
        });
        f123369f = 8;
    }

    private NotificationJobPlanner() {
    }

    private final IgnoredStatisticsItemDao a() {
        return (IgnoredStatisticsItemDao) f123368d.getValue();
    }

    private final NotificationDataStore b() {
        return (NotificationDataStore) f123367c.getValue();
    }

    private final StatisticsDataStore c() {
        return (StatisticsDataStore) f123366b.getValue();
    }

    public static /* synthetic */ Object e(NotificationJobPlanner notificationJobPlanner, Context context, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return notificationJobPlanner.d(context, z2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0444 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(android.content.Context r41, boolean r42, kotlin.coroutines.Continuation r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1114
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.job.NotificationJobPlanner.d(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
