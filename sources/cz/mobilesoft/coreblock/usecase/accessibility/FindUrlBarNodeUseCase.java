package cz.mobilesoft.coreblock.usecase.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.usecase.UseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.nodefinders.FindComposeNodeByTestTagUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class FindUrlBarNodeUseCase extends UseCase<Params, AccessibilityNodeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FindComposeNodeByTestTagUseCase f127529a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements UseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AccessibilityNodeInfo f127530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BrowserViewId f127531b;

        public Params(AccessibilityNodeInfo rootNode, BrowserViewId browserConfig) {
            Intrinsics.checkNotNullParameter(rootNode, "rootNode");
            Intrinsics.checkNotNullParameter(browserConfig, "browserConfig");
            this.f127530a = rootNode;
            this.f127531b = browserConfig;
        }

        public final BrowserViewId a() {
            return this.f127531b;
        }

        public final AccessibilityNodeInfo b() {
            return this.f127530a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127530a, params.f127530a) && Intrinsics.areEqual(this.f127531b, params.f127531b);
        }

        public int hashCode() {
            return (this.f127530a.hashCode() * 31) + this.f127531b.hashCode();
        }

        public String toString() {
            return "Params(rootNode=" + this.f127530a + ", browserConfig=" + this.f127531b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f127532a;

        static {
            int[] iArr = new int[BrowserViewId.DetectionMethod.values().length];
            try {
                iArr[BrowserViewId.DetectionMethod.COMPOSE_TEST_TAG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f127532a = iArr;
        }
    }

    public FindUrlBarNodeUseCase(FindComposeNodeByTestTagUseCase findComposeNodeByTestTagUseCase) {
        Intrinsics.checkNotNullParameter(findComposeNodeByTestTagUseCase, "findComposeNodeByTestTagUseCase");
        this.f127529a = findComposeNodeByTestTagUseCase;
    }

    public AccessibilityNodeInfo a(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BrowserViewId.DetectionMethod detectionMethod = params.a().getDetectionMethod();
        if ((detectionMethod == null ? -1 : WhenMappings.f127532a[detectionMethod.ordinal()]) == 1) {
            return this.f127529a.a(new FindComposeNodeByTestTagUseCase.Params(params.b(), params.a().getViewId()));
        }
        return null;
    }
}
