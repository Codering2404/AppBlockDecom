package androidx.compose.ui.text.platform;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.platform.extensions.PlaceholderExtensions_androidKt;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.emoji2.text.EmojiCompat;
import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

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
public final class AndroidParagraphHelper_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AndroidParagraphHelper_androidKt$NoopSpan$1 f29482a = new CharacterStyle() { // from class: androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1
        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.emoji2.text.EmojiCompat] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [int] */
    /* JADX WARN: Type inference failed for: r6v3 */
    public static final CharSequence a(String str, float f3, TextStyle textStyle, List list, List list2, Density density, Function4 function4, boolean z2) {
        String str2;
        CharSequence charSequenceU;
        float f4;
        Density density2;
        PlatformParagraphStyle platformParagraphStyleA;
        if (z2 && EmojiCompat.k()) {
            PlatformTextStyle platformTextStyleY = textStyle.y();
            EmojiSupportMatch emojiSupportMatchD = (platformTextStyleY == null || (platformParagraphStyleA = platformTextStyleY.a()) == null) ? null : EmojiSupportMatch.d(platformParagraphStyleA.b());
            str2 = str;
            charSequenceU = EmojiCompat.c().u(str2, 0, str.length(), Api.BaseClientBuilder.API_PRIORITY_OTHER, emojiSupportMatchD == null ? 0 : EmojiSupportMatch.g(emojiSupportMatchD.j(), EmojiSupportMatch.f28693b.a()));
            Intrinsics.checkNotNull(charSequenceU);
        } else {
            str2 = str;
            charSequenceU = str2;
        }
        if (list.isEmpty() && list2.isEmpty() && Intrinsics.areEqual(textStyle.F(), TextIndent.f29647c.a()) && TextUnit.f(textStyle.u()) == 0) {
            return charSequenceU;
        }
        Spannable spannableString = charSequenceU instanceof Spannable ? (Spannable) charSequenceU : new SpannableString(charSequenceU);
        if (Intrinsics.areEqual(textStyle.C(), TextDecoration.f29625b.d())) {
            SpannableExtensions_androidKt.w(spannableString, f29482a, 0, str2.length());
        }
        if (b(textStyle) && textStyle.v() == null) {
            SpannableExtensions_androidKt.t(spannableString, textStyle.u(), f3, density);
            f4 = f3;
            density2 = density;
        } else {
            LineHeightStyle lineHeightStyleV = textStyle.v();
            if (lineHeightStyleV == null) {
                lineHeightStyleV = LineHeightStyle.f29591d.a();
            }
            f4 = f3;
            density2 = density;
            SpannableExtensions_androidKt.s(spannableString, textStyle.u(), f4, density2, lineHeightStyleV);
        }
        SpannableExtensions_androidKt.A(spannableString, textStyle.F(), f4, density2);
        SpannableExtensions_androidKt.y(spannableString, textStyle, list, density2, function4);
        SpannableExtensions_androidKt.l(spannableString, list, f4, density2, textStyle.F());
        PlaceholderExtensions_androidKt.d(spannableString, list2, density2);
        return spannableString;
    }

    public static final boolean b(TextStyle textStyle) {
        PlatformParagraphStyle platformParagraphStyleA;
        PlatformTextStyle platformTextStyleY = textStyle.y();
        if (platformTextStyleY == null || (platformParagraphStyleA = platformTextStyleY.a()) == null) {
            return false;
        }
        return platformParagraphStyleA.c();
    }
}
