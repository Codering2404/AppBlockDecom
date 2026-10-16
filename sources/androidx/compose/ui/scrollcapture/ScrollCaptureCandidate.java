package androidx.compose.ui.scrollcapture;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class ScrollCaptureCandidate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SemanticsNode f28426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IntRect f28428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LayoutCoordinates f28429d;

    public ScrollCaptureCandidate(SemanticsNode semanticsNode, int i3, IntRect intRect, LayoutCoordinates layoutCoordinates) {
        this.f28426a = semanticsNode;
        this.f28427b = i3;
        this.f28428c = intRect;
        this.f28429d = layoutCoordinates;
    }

    public final LayoutCoordinates a() {
        return this.f28429d;
    }

    public final int b() {
        return this.f28427b;
    }

    public final SemanticsNode c() {
        return this.f28426a;
    }

    public final IntRect d() {
        return this.f28428c;
    }

    public String toString() {
        return "ScrollCaptureCandidate(node=" + this.f28426a + ", depth=" + this.f28427b + ", viewportBoundsInWindow=" + this.f28428c + ", coordinates=" + this.f28429d + ')';
    }
}
