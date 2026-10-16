package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
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
public final class SetTimerValueUseCase extends SuspendUseCase<Params, SetTimerValueResult> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f122532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f122533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f122534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f122535d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeAccessMethod f122536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StrictModeState f122537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f122538c;

        public Params(StrictModeAccessMethod strictModeAccessMethod, StrictModeState activeState, long j3) {
            Intrinsics.checkNotNullParameter(activeState, "activeState");
            this.f122536a = strictModeAccessMethod;
            this.f122537b = activeState;
            this.f122538c = j3;
        }

        public final StrictModeAccessMethod a() {
            return this.f122536a;
        }

        public final StrictModeState b() {
            return this.f122537b;
        }

        public final long c() {
            return this.f122538c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f122536a == params.f122536a && this.f122537b == params.f122537b && this.f122538c == params.f122538c;
        }

        public int hashCode() {
            StrictModeAccessMethod strictModeAccessMethod = this.f122536a;
            return ((((strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode()) * 31) + this.f122537b.hashCode()) * 31) + Long.hashCode(this.f122538c);
        }

        public String toString() {
            return "Params(accessMethod=" + this.f122536a + ", activeState=" + this.f122537b + ", timeInMillis=" + this.f122538c + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SetTimerValueUseCase() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122532a = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$special$$inlined$inject$default$1
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
        this.f122533b = LazyKt.a(lazyThreadSafetyModeB2, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$special$$inlined$inject$default$2
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
        this.f122534c = 99;
        this.f122535d = 8553600000L;
    }

    private final ProfileDao a() {
        return (ProfileDao) this.f122533b.getValue();
    }

    private final StrictModeRepository b() {
        return (StrictModeRepository) this.f122532a.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x014e, code lost:
    
        if (r2.s(r5, r3) == r4) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c8, code lost:
    
        if (r5.p(r2, r3) == r4) goto L62;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01aa A[PHI: r1 r2 r5 r7 r8
      0x01aa: PHI (r1v14 int) = (r1v12 int), (r1v18 int) binds: [B:54:0x01a7, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r2v19 java.lang.Object) = (r2v18 java.lang.Object), (r2v1 java.lang.Object) binds: [B:54:0x01a7, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r5v26 cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao) = 
      (r5v23 cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao)
      (r5v28 cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao)
     binds: [B:54:0x01a7, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r7v14 cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params) = 
      (r7v10 cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params)
      (r7v17 cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params)
     binds: [B:54:0x01a7, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]
      0x01aa: PHI (r8v13 cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params) = 
      (r8v11 cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params)
      (r8v16 cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params)
     binds: [B:54:0x01a7, B:13:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase.Params r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase.c(cz.mobilesoft.coreblock.scene.strictmode3.usecase.SetTimerValueUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
