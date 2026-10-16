package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import cz.mobilesoft.coreblock.scene.more.backup.dto.ProfileDTO;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.GeoAddressDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.SubAppRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WebsiteProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.WifiNetworkDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.List;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GetBackupProfilesUseCase extends SuspendUseCase<Params, List<? extends ProfileDTO>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f106585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f106586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f106587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f106588d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f106589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f106590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f106591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Lazy f106592i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f106593a;

        public Params(boolean z2) {
            this.f106593a = z2;
        }

        public final boolean a() {
            return this.f106593a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && this.f106593a == ((Params) obj).f106593a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f106593a);
        }

        public String toString() {
            return "Params(isBackupTooLarge=" + this.f106593a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetBackupProfilesUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f106585a = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f106586b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<UsageLimitDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(UsageLimitDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f106587c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<GeoAddressDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(GeoAddressDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f106588d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f106589f = LazyKt.a(lazyThreadSafetyModeB5, new Function0<SubAppRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(SubAppRelationDao.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f106590g = LazyKt.a(lazyThreadSafetyModeB6, new Function0<IntervalDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(IntervalDao.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f106591h = LazyKt.a(lazyThreadSafetyModeB7, new Function0<WebsiteProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WebsiteProfileRelationDao.class), objArr12, objArr13);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB8 = koinPlatformTools.b();
        final Object[] objArr14 = 0 == true ? 1 : 0;
        final Object[] objArr15 = 0 == true ? 1 : 0;
        this.f106592i = LazyKt.a(lazyThreadSafetyModeB8, new Function0<WifiNetworkDao>() { // from class: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$special$$inlined$inject$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(WifiNetworkDao.class), objArr14, objArr15);
            }
        });
    }

    private final ApplicationProfileRelationDao b() {
        return (ApplicationProfileRelationDao) this.f106588d.getValue();
    }

    private final GeoAddressDao c() {
        return (GeoAddressDao) this.f106587c.getValue();
    }

    private final IntervalDao d() {
        return (IntervalDao) this.f106590g.getValue();
    }

    private final ProfileDao e() {
        return (ProfileDao) this.f106585a.getValue();
    }

    private final Object f(Continuation continuation) {
        return e().s0(false, true, continuation);
    }

    private final SubAppRelationDao g() {
        return (SubAppRelationDao) this.f106589f.getValue();
    }

    private final UsageLimitDao h() {
        return (UsageLimitDao) this.f106586b.getValue();
    }

    private final WebsiteProfileRelationDao i() {
        return (WebsiteProfileRelationDao) this.f106591h.getValue();
    }

    private final WifiNetworkDao j() {
        return (WifiNetworkDao) this.f106592i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0474 A[LOOP:1: B:98:0x046e->B:100:0x0474, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01ac A[LOOP:7: B:29:0x01a6->B:31:0x01ac, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x028f A[LOOP:6: B:57:0x028d->B:58:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02e5 A[LOOP:3: B:64:0x02df->B:66:0x02e5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x037b A[LOOP:2: B:76:0x0375->B:78:0x037b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x040f A[LOOP:0: B:94:0x0409->B:96:0x040f, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile r41, cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase.Params r42, kotlin.coroutines.Continuation r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase.l(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile, cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
    
        if (r14 == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c0 -> B:26:0x00c1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object k(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase.Params r13, kotlin.coroutines.Continuation r14) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase.k(cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
