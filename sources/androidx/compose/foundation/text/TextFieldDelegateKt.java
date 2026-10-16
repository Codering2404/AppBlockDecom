package androidx.compose.foundation.text;

import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

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
public final class TextFieldDelegateKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9930a = StringsKt.K("H", 10);

    public static final long a(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i3) {
        Paragraph paragraphA = ParagraphKt.a(str, textStyle, ConstraintsKt.b(0, 0, 0, 0, 15, null), density, resolver, (64 & 32) != 0 ? CollectionsKt.emptyList() : CollectionsKt.emptyList(), (64 & 64) != 0 ? CollectionsKt.emptyList() : null, (64 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Integer.MAX_VALUE : i3, (64 & Function.MAX_NARGS) != 0 ? TextOverflow.f29661b.a() : TextOverflow.f29661b.a());
        return IntSize.c((((long) TextDelegateKt.a(paragraphA.e())) << 32) | (((long) TextDelegateKt.a(paragraphA.getHeight())) & 4294967295L));
    }

    public static /* synthetic */ long b(TextStyle textStyle, Density density, FontFamily.Resolver resolver, String str, int i3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            str = f9930a;
        }
        if ((i4 & 16) != 0) {
            i3 = 1;
        }
        return a(textStyle, density, resolver, str, i3);
    }

    public static final String c() {
        return f9930a;
    }
}
