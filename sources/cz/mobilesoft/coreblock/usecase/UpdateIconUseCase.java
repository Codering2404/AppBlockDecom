package cz.mobilesoft.coreblock.usecase;

import android.content.Context;
import cz.mobilesoft.coreblock.enums.AppIcon;
import cz.mobilesoft.coreblock.storage.datastore.CoreDataStore;
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
public final class UpdateIconUseCase extends SuspendUseCase<Params, Unit> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127468b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppIcon f127469a;

        public Params(AppIcon newIcon) {
            Intrinsics.checkNotNullParameter(newIcon, "newIcon");
            this.f127469a = newIcon;
        }

        public final AppIcon a() {
            return this.f127469a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && this.f127469a == ((Params) obj).f127469a;
        }

        public int hashCode() {
            return this.f127469a.hashCode();
        }

        public String toString() {
            return "Params(newIcon=" + this.f127469a + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateIconUseCase(Context applicationContext) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f127467a = applicationContext;
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127468b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.UpdateIconUseCase$special$$inlined$inject$default$1
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
        return (CoreDataStore) this.f127468b.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ea, code lost:
    
        if (r4.M4(r2, r0) == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(cz.mobilesoft.coreblock.usecase.UpdateIconUseCase.Params r12, kotlin.coroutines.Continuation r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.UpdateIconUseCase.b(cz.mobilesoft.coreblock.usecase.UpdateIconUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
