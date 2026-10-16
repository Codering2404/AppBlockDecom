package cz.mobilesoft.coreblock.scene.strictmode3.usecase;

import android.app.Application;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.usecase.SuspendUseCase;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
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
public final class GetTitleAndSubtitleUseCase extends SuspendUseCase<Params, Pair<? extends String, ? extends String>> implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lazy f122523a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements SuspendUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StrictModeState f122524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AccessMethodConfiguration f122525b;

        public Params(StrictModeState state, AccessMethodConfiguration accessMethodConfiguration) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(accessMethodConfiguration, "accessMethodConfiguration");
            this.f122524a = state;
            this.f122525b = accessMethodConfiguration;
        }

        public final AccessMethodConfiguration a() {
            return this.f122525b;
        }

        public final StrictModeState b() {
            return this.f122524a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return this.f122524a == params.f122524a && Intrinsics.areEqual(this.f122525b, params.f122525b);
        }

        public int hashCode() {
            return (this.f122524a.hashCode() * 31) + this.f122525b.hashCode();
        }

        public String toString() {
            return "Params(state=" + this.f122524a + ", accessMethodConfiguration=" + this.f122525b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122526a;

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
            f122526a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetTitleAndSubtitleUseCase() {
        LazyThreadSafetyMode lazyThreadSafetyModeB = KoinPlatformTools.f146106a.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f122523a = LazyKt.a(lazyThreadSafetyModeB, new Function0<Application>() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetTitleAndSubtitleUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(Application.class), qualifier, objArr);
            }
        });
    }

    private final Application a() {
        return (Application) this.f122523a.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetTitleAndSubtitleUseCase.Params r3, kotlin.coroutines.Continuation r4) {
        /*
            r2 = this;
            cz.mobilesoft.coreblock.enums.StrictModeState r4 = r3.b()
            int[] r0 = cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetTitleAndSubtitleUseCase.WhenMappings.f122526a
            int r4 = r4.ordinal()
            r4 = r0[r4]
            r0 = 1
            if (r4 == r0) goto L18
            r0 = 2
            if (r4 == r0) goto L15
            int r4 = cz.mobilesoft.coreblock.R.string.wy
            goto L1a
        L15:
            int r4 = cz.mobilesoft.coreblock.R.string.Zz
            goto L1a
        L18:
            int r4 = cz.mobilesoft.coreblock.R.string.f95863z
        L1a:
            cz.mobilesoft.coreblock.enums.StrictModeState r0 = r3.b()
            cz.mobilesoft.coreblock.enums.StrictModeState r1 = cz.mobilesoft.coreblock.enums.StrictModeState.Standby
            if (r0 != r1) goto L29
            int r3 = cz.mobilesoft.coreblock.R.string.Iz
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.d(r3)
            goto L48
        L29:
            cz.mobilesoft.coreblock.enums.StrictModeState r0 = r3.b()
            cz.mobilesoft.coreblock.enums.StrictModeState r1 = cz.mobilesoft.coreblock.enums.StrictModeState.Inactive
            if (r0 != r1) goto L38
            int r3 = cz.mobilesoft.coreblock.R.string.Pz
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.d(r3)
            goto L48
        L38:
            cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration r3 = r3.a()
            boolean r3 = r3 instanceof cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration.Schedules
            if (r3 == 0) goto L47
            int r3 = cz.mobilesoft.coreblock.R.string.zx
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.d(r3)
            goto L48
        L47:
            r3 = 0
        L48:
            if (r3 == 0) goto L58
            int r3 = r3.intValue()
            android.app.Application r0 = r2.a()
            java.lang.String r3 = r0.getString(r3)
            if (r3 != 0) goto L5a
        L58:
            java.lang.String r3 = ""
        L5a:
            android.app.Application r0 = r2.a()
            java.lang.String r4 = r0.getString(r4)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            kotlin.Pair r3 = kotlin.TuplesKt.a(r4, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetTitleAndSubtitleUseCase.b(cz.mobilesoft.coreblock.scene.strictmode3.usecase.GetTitleAndSubtitleUseCase$Params, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }
}
