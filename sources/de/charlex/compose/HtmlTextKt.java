package de.charlex.compose;

import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class HtmlTextKt {
    /* JADX WARN: Removed duplicated region for block: B:108:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:280:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r41, final androidx.compose.ui.text.AnnotatedString r42, long r43, long r45, androidx.compose.ui.text.font.FontStyle r47, androidx.compose.ui.text.font.FontWeight r48, androidx.compose.ui.text.font.FontFamily r49, long r50, androidx.compose.ui.text.style.TextDecoration r52, androidx.compose.ui.text.style.TextAlign r53, long r54, int r56, boolean r57, int r58, java.util.Map r59, kotlin.jvm.functions.Function1 r60, androidx.compose.ui.text.TextStyle r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 1261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.charlex.compose.HtmlTextKt.a(androidx.compose.ui.Modifier, androidx.compose.ui.text.AnnotatedString, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x047a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(androidx.compose.ui.Modifier r64, final int r65, androidx.compose.ui.text.SpanStyle r66, java.util.Map r67, long r68, long r70, androidx.compose.ui.text.font.FontStyle r72, androidx.compose.ui.text.font.FontWeight r73, androidx.compose.ui.text.font.FontFamily r74, long r75, androidx.compose.ui.text.style.TextDecoration r77, androidx.compose.ui.text.style.TextAlign r78, long r79, int r81, boolean r82, int r83, java.util.Map r84, kotlin.jvm.functions.Function1 r85, androidx.compose.ui.text.TextStyle r86, androidx.compose.runtime.Composer r87, final int r88, final int r89, final int r90) {
        /*
            Method dump skipped, instruction units count: 1169
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.charlex.compose.HtmlTextKt.b(androidx.compose.ui.Modifier, int, androidx.compose.ui.text.SpanStyle, java.util.Map, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0472 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(androidx.compose.ui.Modifier r64, final java.lang.String r65, androidx.compose.ui.text.SpanStyle r66, java.util.Map r67, long r68, long r70, androidx.compose.ui.text.font.FontStyle r72, androidx.compose.ui.text.font.FontWeight r73, androidx.compose.ui.text.font.FontFamily r74, long r75, androidx.compose.ui.text.style.TextDecoration r77, androidx.compose.ui.text.style.TextAlign r78, long r79, int r81, boolean r82, int r83, java.util.Map r84, kotlin.jvm.functions.Function1 r85, androidx.compose.ui.text.TextStyle r86, androidx.compose.runtime.Composer r87, final int r88, final int r89, final int r90) {
        /*
            Method dump skipped, instruction units count: 1161
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: de.charlex.compose.HtmlTextKt.c(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.text.SpanStyle, java.util.Map, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final AnnotatedString d(Spanned spanned, SpanStyle urlSpanStyle, Map colorMapping) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        Intrinsics.checkNotNullParameter(urlSpanStyle, "urlSpanStyle");
        Intrinsics.checkNotNullParameter(colorMapping, "colorMapping");
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        builder.l(spanned.toString());
        Object[] spans = spanned.getSpans(0, spanned.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(start, end, T::class.java)");
        Object[] spans2 = spanned.getSpans(0, spanned.length(), StyleSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(start, end, T::class.java)");
        StyleSpan[] styleSpanArr = (StyleSpan[]) spans2;
        Object[] spans3 = spanned.getSpans(0, spanned.length(), ForegroundColorSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans3, "getSpans(start, end, T::class.java)");
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spans3;
        Object[] spans4 = spanned.getSpans(0, spanned.length(), UnderlineSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans4, "getSpans(start, end, T::class.java)");
        Object[] objArr = (UnderlineSpan[]) spans4;
        Object[] spans5 = spanned.getSpans(0, spanned.length(), StrikethroughSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans5, "getSpans(start, end, T::class.java)");
        Object[] objArr2 = (StrikethroughSpan[]) spans5;
        for (URLSpan uRLSpan : (URLSpan[]) spans) {
            int spanStart = spanned.getSpanStart(uRLSpan);
            int spanEnd = spanned.getSpanEnd(uRLSpan);
            builder.f(urlSpanStyle, spanStart, spanEnd);
            String url = uRLSpan.getURL();
            Intrinsics.checkNotNullExpressionValue(url, "urlSpan.url");
            builder.d("url", url, spanStart, spanEnd);
        }
        for (ForegroundColorSpan foregroundColorSpan : foregroundColorSpanArr) {
            int spanStart2 = spanned.getSpanStart(foregroundColorSpan);
            int spanEnd2 = spanned.getSpanEnd(foregroundColorSpan);
            Object objN = colorMapping.get(Color.n(ColorKt.b(foregroundColorSpan.getForegroundColor())));
            if (objN == null) {
                objN = Color.n(ColorKt.b(foregroundColorSpan.getForegroundColor()));
            }
            builder.f(new SpanStyle(((Color) objN).B(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null), spanStart2, spanEnd2);
        }
        for (StyleSpan styleSpan : styleSpanArr) {
            int spanStart3 = spanned.getSpanStart(styleSpan);
            int spanEnd3 = spanned.getSpanEnd(styleSpan);
            int style = styleSpan.getStyle();
            if (style == 1) {
                builder.f(new SpanStyle(0L, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16379, (DefaultConstructorMarker) null), spanStart3, spanEnd3);
            } else if (style == 2) {
                builder.f(new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16375, (DefaultConstructorMarker) null), spanStart3, spanEnd3);
            } else if (style == 3) {
                builder.f(new SpanStyle(0L, 0L, FontWeight.f29233b.b(), FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16371, (DefaultConstructorMarker) null), spanStart3, spanEnd3);
            }
        }
        for (Object obj : objArr) {
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, 12287, (DefaultConstructorMarker) null), spanned.getSpanStart(obj), spanned.getSpanEnd(obj));
        }
        for (Object obj2 : objArr2) {
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.b(), (Shadow) null, 12287, (DefaultConstructorMarker) null), spanned.getSpanStart(obj2), spanned.getSpanEnd(obj2));
        }
        return builder.t();
    }

    public static final AnnotatedString e(CharSequence charSequence, SpanStyle urlSpanStyle, Map colorMapping) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(urlSpanStyle, "urlSpanStyle");
        Intrinsics.checkNotNullParameter(colorMapping, "colorMapping");
        if (charSequence instanceof Spanned) {
            return d((Spanned) charSequence, urlSpanStyle, colorMapping);
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        builder.l(charSequence.toString());
        return builder.t();
    }
}
