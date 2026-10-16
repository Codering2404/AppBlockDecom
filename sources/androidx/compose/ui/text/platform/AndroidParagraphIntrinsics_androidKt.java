package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import androidx.core.text.TextUtilsCompat;
import java.util.List;
import java.util.Locale;
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
public final class AndroidParagraphIntrinsics_androidKt {
    public static final ParagraphIntrinsics a(String str, TextStyle textStyle, List list, List list2, Density density, FontFamily.Resolver resolver) {
        return new AndroidParagraphIntrinsics(str, textStyle, list, list2, resolver, density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(TextStyle textStyle) {
        PlatformParagraphStyle platformParagraphStyleA;
        PlatformTextStyle platformTextStyleY = textStyle.y();
        return !(((platformTextStyleY == null || (platformParagraphStyleA = platformTextStyleY.a()) == null) ? null : EmojiSupportMatch.d(platformParagraphStyleA.b())) == null ? false : EmojiSupportMatch.g(r1.j(), EmojiSupportMatch.f28693b.c()));
    }

    public static final int d(int i3, LocaleList localeList) {
        Locale localeB;
        TextDirection.Companion companion = TextDirection.f29630b;
        if (TextDirection.j(i3, companion.b())) {
            return 2;
        }
        if (TextDirection.j(i3, companion.c())) {
            return 3;
        }
        if (TextDirection.j(i3, companion.d())) {
            return 0;
        }
        if (TextDirection.j(i3, companion.e())) {
            return 1;
        }
        if (!(TextDirection.j(i3, companion.a()) ? true : TextDirection.j(i3, companion.f()))) {
            throw new IllegalStateException("Invalid TextDirection.");
        }
        if (localeList == null || (localeB = localeList.d(0).b()) == null) {
            localeB = Locale.getDefault();
        }
        int iA = TextUtilsCompat.a(localeB);
        return (iA == 0 || iA != 1) ? 2 : 3;
    }
}
