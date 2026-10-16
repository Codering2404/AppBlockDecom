package androidx.compose.foundation.text.selection;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HandlePositionProvider implements PopupPositionProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Alignment f11232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OffsetProvider f11233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f11234c = Offset.f25596b.c();

    public HandlePositionProvider(Alignment alignment, OffsetProvider offsetProvider) {
        this.f11232a = alignment;
        this.f11233b = offsetProvider;
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    public long a(IntRect intRect, long j3, LayoutDirection layoutDirection, long j4) {
        long jA = this.f11233b.a();
        if ((9223372034707292159L & jA) == 9205357640488583168L) {
            jA = this.f11234c;
        }
        this.f11234c = jA;
        return IntOffset.o(IntOffset.o(intRect.k(), IntOffsetKt.d(jA)), this.f11232a.a(j4, IntSize.f29998b.a(), layoutDirection));
    }
}
