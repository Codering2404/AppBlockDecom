package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState;
import cz.mobilesoft.coreblock.storage.datastore.StrictModeDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class GetActiveStateUseCase extends SuspendUseCase<Params, StrictMode3ViewState.ActiveState> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f122488a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeState f122489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f122490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f122491c;

        public Params(StrictModeState state, List accessMethodsSplit, boolean z2) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
            this.f122489a = state;
            this.f122490b = accessMethodsSplit;
            this.f122491c = z2;
        }

        public final List a() {
            return this.f122490b;
        }

        public final StrictModeState b() {
            return this.f122489a;
        }

        public final boolean c() {
            return this.f122491c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f122489a == params.f122489a && Intrinsics.areEqual(this.f122490b, params.f122490b) && this.f122491c == params.f122491c;
        }

        public int hashCode() {
            return (((this.f122489a.hashCode() * 31) + this.f122490b.hashCode()) * 31) + Boolean.hashCode(this.f122491c);
        }

        public String toString() {
            return "Params(state=" + this.f122489a + ", accessMethodsSplit=" + this.f122490b + ", isChargerConnected=" + this.f122491c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122492a;

        static {
            int[] iArr = new int[StrictModeState.values().length];
            try {
                iArr[StrictModeState.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StrictModeState.Standby.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StrictModeState.Paused.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StrictModeState.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f122492a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetActiveStateUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122488a = LazyKt.a(lazyThreadSafetyModeB, new Function0<StrictModeDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetActiveStateUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeDataStore.class), qualifier, objArr);
            }
        });
    }

    private final StrictModeDataStore c() {
        return (StrictModeDataStore) this.f122488a.getValue();
    }

    public final boolean a(List accessMethodsSplit, StrictModeState state, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == StrictModeState.Inactive || state == StrictModeState.Paused || CollectionsKt.singleOrNull(accessMethodsSplit) == StrictModeAccessMethod.Timer || accessMethodsSplit.contains(StrictModeAccessMethod.PinCode) || b(accessMethodsSplit, z3) || state == StrictModeState.Standby || accessMethodsSplit.contains(StrictModeAccessMethod.Cooldown)) {
            return true;
        }
        return accessMethodsSplit.contains(StrictModeAccessMethod.Approval) && !z2;
    }

    public final boolean b(List accessMethodsSplit, boolean z2) {
        Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
        return accessMethodsSplit.contains(StrictModeAccessMethod.Charger) && z2;
    }

    public final boolean d(List accessMethodsSplit) {
        Intrinsics.checkNotNullParameter(accessMethodsSplit, "accessMethodsSplit");
        return !accessMethodsSplit.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[EDGE_INSN: B:87:0x00a1->B:34:0x00a1 BREAK  A[LOOP:0: B:27:0x0088->B:88:?]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetActiveStateUseCase.Params r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetActiveStateUseCase.e(cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetActiveStateUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
