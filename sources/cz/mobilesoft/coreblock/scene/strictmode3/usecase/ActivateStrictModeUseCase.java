package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

import android.app.Application;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationProfileRelationDao;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class ActivateStrictModeUseCase extends SuspendUseCase<Params, Unit> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f122443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f122444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f122445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f122446d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f122447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f122448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f122449h;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivateStrictModeUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122443a = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f122444b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f122445c = LazyKt.a(lazyThreadSafetyModeB3, new Function0<ApplicationProfileRelationDao>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ApplicationProfileRelationDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f122446d = LazyKt.a(lazyThreadSafetyModeB4, new Function0<Application>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(Application.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f122447f = LazyKt.a(lazyThreadSafetyModeB5, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f122448g = LazyKt.a(lazyThreadSafetyModeB6, new Function0<TrialUpsellManager>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(TrialUpsellManager.class), objArr10, objArr11);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB7 = koinPlatformTools.b();
        final Object[] objArr12 = 0 == true ? 1 : 0;
        final Object[] objArr13 = 0 == true ? 1 : 0;
        this.f122449h = LazyKt.a(lazyThreadSafetyModeB7, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$special$$inlined$inject$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr12, objArr13);
            }
        });
    }

    private final Application a() {
        return (Application) this.f122446d.getValue();
    }

    private final ApplicationProfileRelationDao b() {
        return (ApplicationProfileRelationDao) this.f122445c.getValue();
    }

    private final PremiumRepositoryV2 c() {
        return (PremiumRepositoryV2) this.f122449h.getValue();
    }

    private final ProfileDao d() {
        return (ProfileDao) this.f122444b.getValue();
    }

    private final StrictModeDataStore e() {
        return (StrictModeDataStore) this.f122447f.getValue();
    }

    private final StrictModeRepository f() {
        return (StrictModeRepository) this.f122443a.getValue();
    }

    private final TrialUpsellManager g() {
        return (TrialUpsellManager) this.f122448g.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x03f6, code lost:
    
        if (r3.f().w(r3.a(), r8.d(), r1, r2) == r4) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x047a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r1, r9, r2) != r4) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01ef, code lost:
    
        if (r1 != r4) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0380 A[PHI: r0 r1 r5 r10 r11
      0x0380: PHI (r0v20 int) = (r0v18 int), (r0v21 int) binds: [B:106:0x037c, B:17:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x0380: PHI (r1v36 java.util.List) = (r1v34 java.util.List), (r1v37 java.util.List) binds: [B:106:0x037c, B:17:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x0380: PHI (r5v25 long) = (r5v23 long), (r5v26 long) binds: [B:106:0x037c, B:17:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x0380: PHI (r10v18 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params) = 
      (r10v15 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
      (r10v20 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
     binds: [B:106:0x037c, B:17:0x0089] A[DONT_GENERATE, DONT_INLINE]
      0x0380: PHI (r11v9 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params) = 
      (r11v6 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
      (r11v11 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
     binds: [B:106:0x037c, B:17:0x0089] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0085 A[PHI: r0 r1 r5 r10 r11
      0x0085: PHI (r0v22 int) = (r0v20 int), (r0v23 int) binds: [B:109:0x039b, B:15:0x0071] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r1v38 java.util.List) = (r1v36 java.util.List), (r1v39 java.util.List) binds: [B:109:0x039b, B:15:0x0071] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r5v27 long) = (r5v25 long), (r5v28 long) binds: [B:109:0x039b, B:15:0x0071] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r10v21 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params) = 
      (r10v18 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
      (r10v24 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
     binds: [B:109:0x039b, B:15:0x0071] A[DONT_GENERATE, DONT_INLINE]
      0x0085: PHI (r11v12 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params) = 
      (r11v9 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
      (r11v21 cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params)
     binds: [B:109:0x039b, B:15:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x019c A[LOOP:2: B:37:0x0196->B:39:0x019c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x032c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object h(cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase.Params r20, kotlin.coroutines.Continuation r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1180
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase.h(cz.mobilesoft.coreblock.scene.strictmode3.usecase.ActivateStrictModeUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f122450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f122451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AccessMethodConfiguration f122452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List f122453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f122454e;

        public Params(StrictModeAccessMethod strictModeAccessMethod, List accessMethodsSplit, AccessMethodConfiguration accessMethodConfiguration, List options, boolean z2) {
            Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
            Intrinsics.checkNotNullParameter(accessMethodConfiguration, "accessMethodConfiguration");
            Intrinsics.checkNotNullParameter(options, "options");
            this.f122450a = strictModeAccessMethod;
            this.f122451b = accessMethodsSplit;
            this.f122452c = accessMethodConfiguration;
            this.f122453d = options;
            this.f122454e = z2;
        }

        public final StrictModeAccessMethod a() {
            return this.f122450a;
        }

        public final AccessMethodConfiguration b() {
            return this.f122452c;
        }

        public final List c() {
            return this.f122451b;
        }

        public final List d() {
            return this.f122453d;
        }

        public final boolean e() {
            return this.f122454e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f122450a == params.f122450a && Intrinsics.areEqual(this.f122451b, params.f122451b) && Intrinsics.areEqual(this.f122452c, params.f122452c) && Intrinsics.areEqual(this.f122453d, params.f122453d) && this.f122454e == params.f122454e;
        }

        public int hashCode() {
            StrictModeAccessMethod strictModeAccessMethod = this.f122450a;
            return ((((((((strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode()) * 31) + this.f122451b.hashCode()) * 31) + this.f122452c.hashCode()) * 31) + this.f122453d.hashCode()) * 31) + Boolean.hashCode(this.f122454e);
        }

        public String toString() {
            return "Params(accessMethod=" + this.f122450a + ", accessMethodsSplit=" + this.f122451b + ", accessMethodConfiguration=" + this.f122452c + ", options=" + this.f122453d + ", isAccessMethodChange=" + this.f122454e + ")";
        }

        public /* synthetic */ Params(StrictModeAccessMethod strictModeAccessMethod, List list, AccessMethodConfiguration accessMethodConfiguration, List list2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(strictModeAccessMethod, list, accessMethodConfiguration, list2, (i3 & 16) != 0 ? false : z2);
        }
    }
}
