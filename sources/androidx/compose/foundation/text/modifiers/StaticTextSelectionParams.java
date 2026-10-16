package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public class StaticTextSelectionParams {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f11085c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11086d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final StaticTextSelectionParams f11087e = new StaticTextSelectionParams(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutCoordinates f11088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextLayoutResult f11089b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StaticTextSelectionParams a() {
            return StaticTextSelectionParams.f11087e;
        }

        private Companion() {
        }
    }

    public StaticTextSelectionParams(LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult) {
        this.f11088a = layoutCoordinates;
        this.f11089b = textLayoutResult;
    }

    public static /* synthetic */ StaticTextSelectionParams c(StaticTextSelectionParams staticTextSelectionParams, LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
        }
        if ((i3 & 1) != 0) {
            layoutCoordinates = staticTextSelectionParams.f11088a;
        }
        if ((i3 & 2) != 0) {
            textLayoutResult = staticTextSelectionParams.f11089b;
        }
        return staticTextSelectionParams.b(layoutCoordinates, textLayoutResult);
    }

    public final StaticTextSelectionParams b(LayoutCoordinates layoutCoordinates, TextLayoutResult textLayoutResult) {
        return new StaticTextSelectionParams(layoutCoordinates, textLayoutResult);
    }

    public final LayoutCoordinates d() {
        return this.f11088a;
    }

    public Path e(int i3, int i4) {
        TextLayoutResult textLayoutResult = this.f11089b;
        if (textLayoutResult != null) {
            return textLayoutResult.z(i3, i4);
        }
        return null;
    }

    public boolean f() {
        TextLayoutResult textLayoutResult = this.f11089b;
        return (textLayoutResult == null || TextOverflow.h(textLayoutResult.l().f(), TextOverflow.f29661b.e()) || !textLayoutResult.i()) ? false : true;
    }

    public final TextLayoutResult g() {
        return this.f11089b;
    }
}
