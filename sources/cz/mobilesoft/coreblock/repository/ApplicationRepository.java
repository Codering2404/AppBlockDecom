package cz.mobilesoft.coreblock.repository;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ApplicationRepository implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ApplicationRepository f97454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CoroutineScope f97455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f97456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Lazy f97457d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Lazy f97458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Lazy f97459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Lazy f97460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Lazy f97461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Lazy f97462j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Lazy f97463k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Lazy f97464l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Lazy f97465m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f97466n;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        final ApplicationRepository applicationRepository = new ApplicationRepository();
        f97454a = applicationRepository;
        f97455b = CoroutinesHelperExtKt.a(Dispatchers.b());
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        f97456c = LazyKt.a(lazyThreadSafetyModeB, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        f97457d = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ApplicationDao>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        f97458f = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        f97459g = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        f97460h = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        f97461i = LazyKt.a(lazyThreadSafetyModeB6, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        f97462j = LazyKt.a(lazyThreadSafetyModeB7, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        f97463k = LazyKt.a(lazyThreadSafetyModeB8, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr14, objArr15);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB9 = koinPlatformTools.b();
        final Object[] objArr16 = 0 == true ? 1 : 0;
        final Object[] objArr17 = 0 == true ? 1 : 0;
        f97464l = LazyKt.a(lazyThreadSafetyModeB9, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr16, objArr17);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB10 = koinPlatformTools.b();
        final Object[] objArr18 = 0 == true ? 1 : 0;
        final Object[] objArr19 = 0 == true ? 1 : 0;
        f97465m = LazyKt.a(lazyThreadSafetyModeB10, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.repository.ApplicationRepository$special$$inlined$inject$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = applicationRepository;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr18, objArr19);
            }
        });
        f97466n = 8;
    }

    private ApplicationRepository() {
    }

    private final ApplicationDao e() {
        return (ApplicationDao) f97457d.getValue();
    }

    private final ApplicationProfileRelationDao f() {
        return (ApplicationProfileRelationDao) f97456c.getValue();
    }

    private final CoreDataStore g() {
        return (CoreDataStore) f97461i.getValue();
    }

    private final CoreMultiProcessDataStore h() {
        return (CoreMultiProcessDataStore) f97462j.getValue();
    }

    private final DevDataStore i() {
        return (DevDataStore) f97465m.getValue();
    }

    private final EventDataStore j() {
        return (EventDataStore) f97464l.getValue();
    }

    private final PremiumRepositoryV2 k() {
        return (PremiumRepositoryV2) f97459g.getValue();
    }

    private final ProfileDao l() {
        return (ProfileDao) f97458f.getValue();
    }

    private final StrictModeDataStore m() {
        return (StrictModeDataStore) f97463k.getValue();
    }

    private final StrictModeRepository n() {
        return (StrictModeRepository) f97460h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x016b, code lost:
    
        if (r0.g0(r22, r4) == r6) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x019b, code lost:
    
        if (r0.O(r22, r4) == r6) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01e0, code lost:
    
        if (r12.j(r0, r4) == r6) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01e2, code lost:
    
        return r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(java.util.Collection r22, java.util.Collection r23, android.content.pm.PackageManager r24, boolean r25, java.util.List r26, kotlin.coroutines.Continuation r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ApplicationRepository.p(java.util.Collection, java.util.Collection, android.content.pm.PackageManager, boolean, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object q(ApplicationRepository applicationRepository, Context context, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return applicationRepository.o(context, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0167, code lost:
    
        if (r1 == r4) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0279, code lost:
    
        if (r1.W1(r9, r2) != r4) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f4 A[LOOP:0: B:72:0x01f2->B:73:0x01f4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x01ce -> B:67:0x01d0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x01f2 -> B:58:0x0187). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object s(java.util.Collection r29, kotlin.coroutines.Continuation r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ApplicationRepository.s(java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0206, code lost:
    
        if (r1.W1(r8, r7) != r2) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01dd A[PHI: r0 r4 r5 r6
      0x01dd: PHI (r0v6 java.util.Map) = (r0v5 java.util.Map), (r0v16 java.util.Map) binds: [B:71:0x01da, B:18:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01dd: PHI (r4v6 java.util.List) = (r4v5 java.util.List), (r4v12 java.util.List) binds: [B:71:0x01da, B:18:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01dd: PHI (r5v4 java.util.List) = (r5v3 java.util.List), (r5v10 java.util.List) binds: [B:71:0x01da, B:18:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01dd: PHI (r6v7 java.util.List) = (r6v6 java.util.List), (r6v11 java.util.List) binds: [B:71:0x01da, B:18:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object t(java.util.List r28, kotlin.coroutines.Continuation r29) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ApplicationRepository.t(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0209, code lost:
    
        if (r0 != r3) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0304, code lost:
    
        if (r0.W1(r9, r1) == r3) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017f A[LOOP:1: B:38:0x017d->B:39:0x017f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f0 A[PHI: r1 r4 r7 r8
      0x01f0: PHI (r1v15 cz.mobilesoft.coreblock.repository.ApplicationRepository$removeUninstalledApplicationsFromProfiles$1) = 
      (r1v14 cz.mobilesoft.coreblock.repository.ApplicationRepository$removeUninstalledApplicationsFromProfiles$1)
      (r1v2 cz.mobilesoft.coreblock.repository.ApplicationRepository$removeUninstalledApplicationsFromProfiles$1)
     binds: [B:49:0x01ec, B:16:0x0096] A[DONT_GENERATE, DONT_INLINE]
      0x01f0: PHI (r4v10 boolean) = (r4v8 boolean), (r4v11 boolean) binds: [B:49:0x01ec, B:16:0x0096] A[DONT_GENERATE, DONT_INLINE]
      0x01f0: PHI (r7v11 java.util.List) = (r7v8 java.util.List), (r7v13 java.util.List) binds: [B:49:0x01ec, B:16:0x0096] A[DONT_GENERATE, DONT_INLINE]
      0x01f0: PHI (r8v13 java.util.Collection) = (r8v10 java.util.Collection), (r8v15 java.util.Collection) binds: [B:49:0x01ec, B:16:0x0096] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0145 -> B:30:0x0147). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x0265 -> B:61:0x026e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object u(java.util.Collection r20, boolean r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ApplicationRepository.u(java.util.Collection, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List v(PackageManager packageManager) {
        ApplicationInfo applicationInfo;
        Set setD0 = PrefManager.f126839a.D0();
        if (setD0 == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = setD0.iterator();
        while (it.hasNext()) {
            try {
                applicationInfo = packageManager.getApplicationInfo((String) it.next(), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            } catch (PackageManager.NameNotFoundException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                arrayList.add(applicationInfo);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:220:0x0e94, code lost:
    
        if (r0.a0(r7) != r8) goto L222;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0886  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x08c6  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0933 A[LOOP:3: B:117:0x092d->B:119:0x0933, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x095a A[LOOP:4: B:121:0x0954->B:123:0x095a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0980  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x09f4  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0a21 A[LOOP:1: B:138:0x0a1f->B:139:0x0a21, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0a68  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0b94  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0ba7  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0c11  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0c15  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0c6c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0c89  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0c8d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0ca3  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0ca7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0d0e  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0d96  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0e0c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0e23  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x063f A[LOOP:7: B:50:0x0639->B:52:0x063f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x068e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0759 A[LOOP:5: B:78:0x0753->B:80:0x0759, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x07f0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x083a  */
    /* JADX WARN: Type inference failed for: r14v73, types: [cz.mobilesoft.coreblock.repository.ApplicationRepository] */
    /* JADX WARN: Type inference failed for: r14v79 */
    /* JADX WARN: Type inference failed for: r14v83 */
    /* JADX WARN: Type inference failed for: r14v95 */
    /* JADX WARN: Type inference failed for: r1v67, types: [cz.mobilesoft.coreblock.repository.ApplicationRepository] */
    /* JADX WARN: Type inference failed for: r1v69, types: [cz.mobilesoft.coreblock.repository.ApplicationRepository] */
    /* JADX WARN: Type inference failed for: r1v70, types: [cz.mobilesoft.coreblock.repository.ApplicationRepository] */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v88 */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object o(android.content.Context r31, boolean r32, kotlin.coroutines.Continuation r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.ApplicationRepository.o(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void r(Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.d(f97455b, null, null, new ApplicationRepository$insertApplicationsAsync$1(context, z2, null), 3, null);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public final Object w(PackageManager packageManager, Continuation continuation) {
        Intent data = new Intent("android.intent.action.VIEW").setData(Uri.parse("http://www.google.com"));
        Intrinsics.checkNotNullExpressionValue(data, "setData(...)");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(data, 131072);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        CoreDataStore coreDataStoreG = g();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((ResolveInfo) it.next()).activityInfo.packageName);
        }
        Object objI4 = coreDataStoreG.I4(linkedHashSet, continuation);
        return objI4 == IntrinsicsKt.f() ? objI4 : Unit.f139807a;
    }
}
