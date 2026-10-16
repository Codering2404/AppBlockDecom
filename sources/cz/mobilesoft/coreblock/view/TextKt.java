package cz.mobilesoft.coreblock.view;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

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
public final class TextKt {
    /* JADX WARN: Removed duplicated region for block: B:139:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(final int r42, final java.lang.Object[] r43, androidx.compose.ui.Modifier r44, androidx.compose.ui.text.TextStyle r45, long r46, androidx.compose.ui.text.style.TextAlign r48, int r49, androidx.compose.ui.text.SpanStyle r50, androidx.compose.runtime.Composer r51, final int r52, final int r53) {
        /*
            Method dump skipped, instruction units count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.TextKt.f(int, java.lang.Object[], androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.text.style.TextAlign, int, androidx.compose.ui.text.SpanStyle, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final java.lang.String r43, androidx.compose.ui.Modifier r44, androidx.compose.ui.text.TextStyle r45, long r46, androidx.compose.ui.text.style.TextAlign r48, int r49, androidx.compose.ui.text.SpanStyle r50, androidx.compose.runtime.Composer r51, final int r52, final int r53) {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.TextKt.g(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.text.style.TextAlign, int, androidx.compose.ui.text.SpanStyle, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fd  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final java.lang.String r40, androidx.compose.ui.Modifier r41, androidx.compose.ui.text.TextStyle r42, long r43, androidx.compose.ui.text.style.TextAlign r45, int r46, kotlin.jvm.functions.Function1 r47, java.util.Map r48, androidx.compose.ui.text.SpanStyle r49, final androidx.compose.ui.platform.UriHandler r50, androidx.compose.runtime.Composer r51, final int r52, final int r53) {
        /*
            Method dump skipped, instruction units count: 644
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.TextKt.h(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.text.style.TextAlign, int, kotlin.jvm.functions.Function1, java.util.Map, androidx.compose.ui.text.SpanStyle, androidx.compose.ui.platform.UriHandler, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(String str, Modifier modifier, TextStyle textStyle, long j3, TextAlign textAlign, int i3, Function1 function1, Map map, SpanStyle spanStyle, UriHandler uriHandler, int i4, int i5, Composer composer, int i6) {
        h(str, modifier, textStyle, j3, textAlign, i3, function1, map, spanStyle, uriHandler, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(int i3, Object[] objArr, Modifier modifier, TextStyle textStyle, long j3, TextAlign textAlign, int i4, SpanStyle spanStyle, int i5, int i6, Composer composer, int i7) {
        f(i3, objArr, modifier, textStyle, j3, textAlign, i4, spanStyle, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(String str, Modifier modifier, TextStyle textStyle, long j3, TextAlign textAlign, int i3, SpanStyle spanStyle, int i4, int i5, Composer composer, int i6) {
        g(str, modifier, textStyle, j3, textAlign, i3, spanStyle, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    private static final Spanned m(CharSequence charSequence, Object... objArr) {
        String string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence instanceof Spanned ? (Spanned) charSequence : new SpannableString(charSequence));
        Regex regex = new Regex("%(\\d+)\\$([-+#0 ,(]*)?(\\d+)?(?:\\.(\\d+))?([a-zA-Z])");
        String string2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        for (MatchResult matchResult : CollectionsKt.asReversed(SequencesKt.S(Regex.g(regex, string2, 0, 2, null)))) {
            int i3 = Integer.parseInt((String) matchResult.b().get(1)) - 1;
            if (i3 >= 0 && i3 < objArr.length) {
                String str = (String) matchResult.b().get(2);
                String str2 = (String) matchResult.b().get(3);
                String str3 = (String) matchResult.b().get(4);
                String str4 = (String) matchResult.b().get(5);
                StringBuilder sb = new StringBuilder();
                sb.append('%');
                sb.append(str);
                sb.append(str2);
                if (str3.length() > 0) {
                    sb.append('.');
                    sb.append(str3);
                }
                sb.append(str4);
                try {
                    string = new Formatter(Locale.getDefault()).format(sb.toString(), objArr[i3]).toString();
                } catch (Exception unused) {
                    string = objArr[i3].toString();
                }
                Intrinsics.checkNotNull(string);
                spannableStringBuilder.replace(matchResult.c().g(), matchResult.c().h() + 1, (CharSequence) string);
            }
        }
        return spannableStringBuilder;
    }

    private static final AnnotatedString n(Spanned spanned, SpanStyle spanStyle, final UriHandler uriHandler) {
        AnnotatedString.Builder builder = new AnnotatedString.Builder(spanned.toString());
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    builder.f(new SpanStyle(0L, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null), spanStart, spanEnd);
                } else if (style == 2) {
                    builder.f(new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null), spanStart, spanEnd);
                } else if (style == 3) {
                    builder.f(new SpanStyle(0L, 0L, FontWeight.f29233b.b(), FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65523, (DefaultConstructorMarker) null), spanStart, spanEnd);
                }
            } else if (obj instanceof UnderlineSpan) {
                builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), spanStart, spanEnd);
            } else if (obj instanceof SuperscriptSpan) {
                builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.d(BaselineShift.f29554b.c()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), spanStart, spanEnd);
            } else if (obj instanceof SubscriptSpan) {
                builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, BaselineShift.d(BaselineShift.f29554b.b()), (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65279, (DefaultConstructorMarker) null), spanStart, spanEnd);
            } else if (obj instanceof ForegroundColorSpan) {
                builder.f(new SpanStyle(ColorKt.b(((ForegroundColorSpan) obj).getForegroundColor()), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), spanStart, spanEnd);
            } else {
                if (obj instanceof URLSpan) {
                    builder.f(spanStyle, spanStart, spanEnd);
                    String url = ((URLSpan) obj).getURL();
                    Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
                    builder.b(new LinkAnnotation.Clickable(url, new TextLinkStyles(spanStyle, null, null, null, 14, null), new LinkInteractionListener() { // from class: cz.mobilesoft.coreblock.view.q
                        @Override // androidx.compose.ui.text.LinkInteractionListener
                        public final void a(LinkAnnotation linkAnnotation) {
                            TextKt.p(uriHandler, linkAnnotation);
                        }
                    }), spanStart, spanEnd);
                }
            }
        }
        return builder.t();
    }

    static /* synthetic */ AnnotatedString o(Spanned spanned, SpanStyle spanStyle, UriHandler uriHandler, int i3, Object obj) {
        return n(spanned, (i3 & 1) != 0 ? new SpanStyle(Color.f25715b.b(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null) : spanStyle, (i3 & 2) != 0 ? null : uriHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(UriHandler uriHandler, LinkAnnotation link) {
        Intrinsics.checkNotNullParameter(link, "link");
        LinkAnnotation.Clickable clickable = link instanceof LinkAnnotation.Clickable ? (LinkAnnotation.Clickable) link : null;
        if (clickable == null || uriHandler == null) {
            return;
        }
        uriHandler.openUri(clickable.c());
    }
}
