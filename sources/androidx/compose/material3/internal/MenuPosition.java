package androidx.compose.material3.internal;

import androidx.compose.material3.internal.AnchorAlignmentOffsetPosition;
import androidx.compose.material3.internal.WindowAlignmentMarginPosition;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
public final class MenuPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MenuPosition f22094a = new MenuPosition();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Horizontal {
        int a(IntRect intRect, long j3, int i3, LayoutDirection layoutDirection);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Vertical {
        int a(IntRect intRect, long j3, int i3);
    }

    private MenuPosition() {
    }

    public static /* synthetic */ Vertical b(MenuPosition menuPosition, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return menuPosition.a(i3);
    }

    public static /* synthetic */ Horizontal f(MenuPosition menuPosition, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return menuPosition.e(i3);
    }

    public static /* synthetic */ Horizontal h(MenuPosition menuPosition, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return menuPosition.g(i3);
    }

    public static /* synthetic */ Horizontal j(MenuPosition menuPosition, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return menuPosition.i(i3);
    }

    public static /* synthetic */ Horizontal l(MenuPosition menuPosition, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return menuPosition.k(i3);
    }

    public static /* synthetic */ Vertical n(MenuPosition menuPosition, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return menuPosition.m(i3);
    }

    public final Vertical a(int i3) {
        Alignment.Companion companion = Alignment.f25072a;
        return new AnchorAlignmentOffsetPosition.Vertical(companion.a(), companion.l(), i3);
    }

    public final Vertical c(int i3) {
        return new WindowAlignmentMarginPosition.Vertical(Alignment.f25072a.a(), i3);
    }

    public final Vertical d(int i3) {
        Alignment.Companion companion = Alignment.f25072a;
        return new AnchorAlignmentOffsetPosition.Vertical(companion.i(), companion.l(), i3);
    }

    public final Horizontal e(int i3) {
        Alignment.Companion companion = Alignment.f25072a;
        return new AnchorAlignmentOffsetPosition.Horizontal(companion.j(), companion.j(), i3);
    }

    public final Horizontal g(int i3) {
        return new WindowAlignmentMarginPosition.Horizontal(AbsoluteAlignment.f25062a.a(), i3);
    }

    public final Horizontal i(int i3) {
        return new WindowAlignmentMarginPosition.Horizontal(AbsoluteAlignment.f25062a.b(), i3);
    }

    public final Horizontal k(int i3) {
        Alignment.Companion companion = Alignment.f25072a;
        return new AnchorAlignmentOffsetPosition.Horizontal(companion.k(), companion.k(), i3);
    }

    public final Vertical m(int i3) {
        Alignment.Companion companion = Alignment.f25072a;
        return new AnchorAlignmentOffsetPosition.Vertical(companion.l(), companion.a(), i3);
    }

    public final Vertical o(int i3) {
        return new WindowAlignmentMarginPosition.Vertical(Alignment.f25072a.l(), i3);
    }
}
