package androidx.compose.ui.window;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AlignmentOffsetPositionProvider implements PopupPositionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Alignment f30154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f30155b;

    public /* synthetic */ AlignmentOffsetPositionProvider(Alignment alignment, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment, j3);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
        Alignment alignment = this.f30154a;
        IntSize.Companion companion = IntSize.f29998b;
        long jA = alignment.a(companion.a(), intRect.i(), layoutDirection);
        return IntOffset.o(IntOffset.o(IntOffset.o(intRect.k(), jA), IntOffset.q(this.f30154a.a(companion.a(), j4, layoutDirection))), IntOffset.f((((long) (IntOffset.k(this.f30155b) * (layoutDirection == LayoutDirection.f30001a ? 1 : -1))) << 32) | (((long) IntOffset.l(this.f30155b)) & 4294967295L)));
    }

    private AlignmentOffsetPositionProvider(Alignment alignment, long j3) {
        this.f30154a = alignment;
        this.f30155b = j3;
    }
}
