package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
public final class GetMissingPermissionsUseCase extends SuspendUseCase<Params, List<? extends Permission>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f122502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f122503b;

    /* JADX WARN: Multi-variable type inference failed */
    public GetMissingPermissionsUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f122502a = context;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122503b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreDataStore.class), qualifier, objArr);
            }
        });
    }

    private final CoreDataStore a() {
        return (CoreDataStore) this.f122503b.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0153 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase.Params r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instruction units count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase.b(cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetMissingPermissionsUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f122504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final StrictModeAccessMethod f122505b;

        public Params(List options, StrictModeAccessMethod strictModeAccessMethod) {
            Intrinsics.checkNotNullParameter(options, "options");
            this.f122504a = options;
            this.f122505b = strictModeAccessMethod;
        }

        public final StrictModeAccessMethod a() {
            return this.f122505b;
        }

        public final List b() {
            return this.f122504a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f122504a, params.f122504a) && this.f122505b == params.f122505b;
        }

        public int hashCode() {
            int iHashCode = this.f122504a.hashCode() * 31;
            StrictModeAccessMethod strictModeAccessMethod = this.f122505b;
            return iHashCode + (strictModeAccessMethod == null ? 0 : strictModeAccessMethod.hashCode());
        }

        public String toString() {
            return "Params(options=" + this.f122504a + ", accessMethod=" + this.f122505b + ")";
        }

        public /* synthetic */ Params(List list, StrictModeAccessMethod strictModeAccessMethod, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i3 & 2) != 0 ? null : strictModeAccessMethod);
        }
    }
}
