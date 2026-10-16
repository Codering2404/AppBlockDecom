package cz.mobilesoft.coreblock.usecase.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.usecase.UseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.ExtractUrlFromNodeUseCase;
import cz.mobilesoft.coreblock.usecase.accessibility.FindUrlBarNodeUseCase;
import cz.mobilesoft.coreblock.util.constants.UrlParsing;
import java.util.List;
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
public final class DetectBrowserUrlUseCase extends UseCase<Params, BrowserUrlDetectionResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FindUrlBarNodeUseCase f127522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExtractUrlFromNodeUseCase f127523b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements UseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AccessibilityNodeInfo f127524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f127525b;

        public Params(AccessibilityNodeInfo rootNode, List browserConfigs) {
            Intrinsics.checkNotNullParameter(rootNode, "rootNode");
            Intrinsics.checkNotNullParameter(browserConfigs, "browserConfigs");
            this.f127524a = rootNode;
            this.f127525b = browserConfigs;
        }

        public final List a() {
            return this.f127525b;
        }

        public final AccessibilityNodeInfo b() {
            return this.f127524a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127524a, params.f127524a) && Intrinsics.areEqual(this.f127525b, params.f127525b);
        }

        public int hashCode() {
            return (this.f127524a.hashCode() * 31) + this.f127525b.hashCode();
        }

        public String toString() {
            return "Params(rootNode=" + this.f127524a + ", browserConfigs=" + this.f127525b + ")";
        }
    }

    public DetectBrowserUrlUseCase(FindUrlBarNodeUseCase findUrlBarNodeUseCase, ExtractUrlFromNodeUseCase extractUrlFromNodeUseCase) {
        Intrinsics.checkNotNullParameter(findUrlBarNodeUseCase, "findUrlBarNodeUseCase");
        Intrinsics.checkNotNullParameter(extractUrlFromNodeUseCase, "extractUrlFromNodeUseCase");
        this.f127522a = findUrlBarNodeUseCase;
        this.f127523b = extractUrlFromNodeUseCase;
    }

    private final UrlDto b(String str, String str2) {
        UrlParsing urlParsing = UrlParsing.f128456a;
        String strA = urlParsing.a(str);
        if (strA == null) {
            return null;
        }
        return new UrlDto(str, strA, false, urlParsing.c(str2), 4, null);
    }

    public BrowserUrlDetectionResult a(Params params) {
        String strC;
        UrlDto urlDtoB;
        Intrinsics.checkNotNullParameter(params, "params");
        for (BrowserViewId browserViewId : params.a()) {
            AccessibilityNodeInfo accessibilityNodeInfoA = this.f127522a.a(new FindUrlBarNodeUseCase.Params(params.b(), browserViewId));
            if (accessibilityNodeInfoA != null && (strC = this.f127523b.c(new ExtractUrlFromNodeUseCase.Params(accessibilityNodeInfoA, browserViewId))) != null && (urlDtoB = b(strC, accessibilityNodeInfoA.getViewIdResourceName())) != null) {
                return new BrowserUrlDetectionResult(urlDtoB, accessibilityNodeInfoA, browserViewId);
            }
        }
        return null;
    }
}
