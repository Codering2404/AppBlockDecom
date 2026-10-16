package cz.mobilesoft.coreblock.usecase.accessibility;

import android.view.accessibility.AccessibilityNodeInfo;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BrowserViewId;
import cz.mobilesoft.coreblock.usecase.UseCase;
import cz.mobilesoft.coreblock.util.constants.UrlParsing;
import java.util.Locale;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class ExtractUrlFromNodeUseCase extends UseCase<Params, String> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements UseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AccessibilityNodeInfo f127526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BrowserViewId f127527b;

        public Params(AccessibilityNodeInfo node, BrowserViewId browserConfig) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(browserConfig, "browserConfig");
            this.f127526a = node;
            this.f127527b = browserConfig;
        }

        public final BrowserViewId a() {
            return this.f127527b;
        }

        public final AccessibilityNodeInfo b() {
            return this.f127526a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127526a, params.f127526a) && Intrinsics.areEqual(this.f127527b, params.f127527b);
        }

        public int hashCode() {
            return (this.f127526a.hashCode() * 31) + this.f127527b.hashCode();
        }

        public String toString() {
            return "Params(node=" + this.f127526a + ", browserConfig=" + this.f127527b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f127528a;

        static {
            int[] iArr = new int[BrowserViewId.ExtractionMethod.values().length];
            try {
                iArr[BrowserViewId.ExtractionMethod.CONTENT_DESC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BrowserViewId.ExtractionMethod.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f127528a = iArr;
        }
    }

    private final String a(AccessibilityNodeInfo accessibilityNodeInfo) {
        String string;
        CharSequence contentDescription = accessibilityNodeInfo.getContentDescription();
        if (contentDescription != null && (string = contentDescription.toString()) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = string.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                Matcher matcher = UrlParsing.f128456a.b().matcher(lowerCase);
                if (matcher.find()) {
                    String strGroup = matcher.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                    return StringsKt.v1(strGroup, '.');
                }
            }
        }
        return null;
    }

    private final String b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo.getText() == null) {
            return null;
        }
        String string = accessibilityNodeInfo.getText().toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public String c(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        BrowserViewId.ExtractionMethod extractionMethod = params.a().getExtractionMethod();
        int i3 = extractionMethod == null ? -1 : WhenMappings.f127528a[extractionMethod.ordinal()];
        if (i3 == 1) {
            return a(params.b());
        }
        if (i3 != 2) {
            return null;
        }
        return b(params.b());
    }
}
