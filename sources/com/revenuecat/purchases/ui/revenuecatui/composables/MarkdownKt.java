package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MarkdownKt {
    private static final Parser parser = Parser.a().i(CollectionsKt.listOf(StrikethroughExtension.c())).g();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDBlockChildren-d8Fo1UA, reason: not valid java name */
    public static final void m893MDBlockChildrend8Fo1UA(final Node node, final long j3, final TextStyle textStyle, final long j4, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z2, final boolean z3, final boolean z4, Composer composer, final int i3) {
        int i4;
        boolean z5;
        int i5;
        Composer composerK = composer.k(2035102511);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(node) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        TextStyle textStyle2 = textStyle;
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(textStyle2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j4) ? 2048 : 1024;
        }
        FontWeight fontWeight2 = fontWeight;
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(fontWeight2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(fontFamily) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            z5 = z2;
            i4 |= composerK.b(z5) ? 8388608 : 4194304;
        } else {
            z5 = z2;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.b(z3) ? 67108864 : 33554432;
        }
        boolean z6 = z4;
        if ((i3 & 805306368) == 0) {
            i4 |= composerK.b(z6) ? 536870912 : 268435456;
        }
        if ((i4 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2035102511, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDBlockChildren (Markdown.kt:457)");
            }
            Node nodeD = node.d();
            while (nodeD != null) {
                if (nodeD instanceof BlockQuote) {
                    composerK.a0(-1935094073);
                    int i6 = i4;
                    i5 = i6;
                    m894MDBlockQuote8V94_ZQ((BlockQuote) nodeD, j3, z5, fontWeight2, null, composerK, ((i6 >> 15) & 896) | (i6 & 112) | ((i6 >> 3) & 7168), 16);
                    composerK.U();
                } else {
                    i5 = i4;
                    if (nodeD instanceof Heading) {
                        composerK.a0(-1935090826);
                        m897MDHeadingJFVkrdg((Heading) nodeD, j3, textStyle2, j4, fontWeight, fontFamily, textAlign, z2, z3, z6, null, composerK, i5 & 2147483632, 0, 1024);
                        composerK.U();
                    } else if (nodeD instanceof Paragraph) {
                        composerK.a0(-1935080104);
                        m900MDParagraphd8Fo1UA((Paragraph) nodeD, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, z4, composerK, i5 & 2147483632);
                        composerK.U();
                    } else {
                        if (nodeD instanceof FencedCodeBlock) {
                            composerK.a0(-1935069412);
                            MDFencedCodeBlock((FencedCodeBlock) nodeD, null, composerK, 0, 2);
                            composerK.U();
                        } else if (nodeD instanceof BulletList) {
                            composerK.a0(-1935067441);
                            m895MDBulletListlzeOXFE((BulletList) nodeD, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, composerK, i5 & 268435440);
                            composerK.U();
                        } else if (nodeD instanceof OrderedList) {
                            composerK.a0(-1935057904);
                            m899MDOrderedListlzeOXFE((OrderedList) nodeD, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, composerK, i5 & 268435440);
                            composerK.U();
                        } else {
                            composerK.a0(143014590);
                            composerK.U();
                        }
                        nodeD = nodeD.f();
                        textStyle2 = textStyle;
                        fontWeight2 = fontWeight;
                        z5 = z2;
                        z6 = z4;
                        i4 = i5;
                    }
                }
                nodeD = nodeD.f();
                textStyle2 = textStyle;
                fontWeight2 = fontWeight;
                z5 = z2;
                z6 = z4;
                i4 = i5;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBlockChildren$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    MarkdownKt.m893MDBlockChildrend8Fo1UA(node, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, z4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: MDBlockQuote-8V94_ZQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m894MDBlockQuote8V94_ZQ(final org.commonmark.node.BlockQuote r38, final long r39, final boolean r41, final androidx.compose.ui.text.font.FontWeight r42, androidx.compose.ui.Modifier r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.m894MDBlockQuote8V94_ZQ(org.commonmark.node.BlockQuote, long, boolean, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDBulletList-lzeOXFE, reason: not valid java name */
    public static final void m895MDBulletListlzeOXFE(final BulletList bulletList, final long j3, final TextStyle textStyle, final long j4, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z2, final boolean z3, Composer composer, final int i3) {
        BulletList bulletList2;
        int i4;
        long j5;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        boolean z4;
        Composer composerK = composer.k(1037984523);
        if ((i3 & 6) == 0) {
            bulletList2 = bulletList;
            i4 = (composerK.I(bulletList2) ? 4 : 2) | i3;
        } else {
            bulletList2 = bulletList;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            j5 = j3;
            i4 |= composerK.f(j5) ? 32 : 16;
        } else {
            j5 = j3;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(textStyle) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            fontWeight2 = fontWeight;
            i4 |= composerK.Z(fontWeight2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((196608 & i3) == 0) {
            fontFamily2 = fontFamily;
            i4 |= composerK.Z(fontFamily2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            z4 = z2;
            i4 |= composerK.b(z4) ? 8388608 : 4194304;
        } else {
            z4 = z2;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.b(z3) ? 67108864 : 33554432;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1037984523, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDBulletList (Markdown.kt:257)");
            }
            final char cR = bulletList2.r();
            final TextStyle textStyleResolveMarkdownTextStyle = resolveMarkdownTextStyle(textStyle, new TextStyle(j5, j4, fontWeight2, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.n() : TextAlign.f29616b.g(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null));
            final boolean z5 = z4;
            m898MDListItemsJFVkrdg(bulletList2, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, null, ComposableLambdaKt.e(1682895250, true, new Function3<Node, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBulletList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Node) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Node it, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (ComposerKt.M()) {
                        ComposerKt.U(1682895250, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDBulletList.<anonymous> (Markdown.kt:280)");
                    }
                    TextStyle textStyle2 = textStyleResolveMarkdownTextStyle;
                    char c3 = cR;
                    long j6 = j3;
                    boolean z6 = z5;
                    FontWeight fontWeight3 = fontWeight;
                    AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                    builder.s(textStyle2.P());
                    StringBuilder sb = new StringBuilder();
                    sb.append(c3);
                    sb.append(' ');
                    builder.l(sb.toString());
                    MarkdownKt.m911appendMarkdownChildrenXOJAsU(builder, it, j6, z6, fontWeight3);
                    builder.p();
                    MarkdownKt.MarkdownText(builder.t(), textStyleResolveMarkdownTextStyle, z3, null, composer2, 0, 8);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, i4 & 268435454, 6, 512);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDBulletList$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    MarkdownKt.m895MDBulletListlzeOXFE(bulletList, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDDocument-d8Fo1UA, reason: not valid java name */
    public static final void m896MDDocumentd8Fo1UA(final Document document, final long j3, final TextStyle textStyle, final long j4, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z2, final boolean z3, final boolean z4, Composer composer, final int i3) {
        int i4;
        TextStyle textStyle2;
        long j5;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        TextAlign textAlign2;
        boolean z5;
        boolean z6;
        boolean z7;
        Composer composerK = composer.k(-196481521);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(document) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            textStyle2 = textStyle;
            i4 |= composerK.Z(textStyle2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            textStyle2 = textStyle;
        }
        if ((i3 & 3072) == 0) {
            j5 = j4;
            i4 |= composerK.f(j5) ? 2048 : 1024;
        } else {
            j5 = j4;
        }
        if ((i3 & 24576) == 0) {
            fontWeight2 = fontWeight;
            i4 |= composerK.Z(fontWeight2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((196608 & i3) == 0) {
            fontFamily2 = fontFamily;
            i4 |= composerK.Z(fontFamily2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i3) == 0) {
            textAlign2 = textAlign;
            i4 |= composerK.Z(textAlign2) ? 1048576 : 524288;
        } else {
            textAlign2 = textAlign;
        }
        if ((12582912 & i3) == 0) {
            z5 = z2;
            i4 |= composerK.b(z5) ? 8388608 : 4194304;
        } else {
            z5 = z2;
        }
        if ((100663296 & i3) == 0) {
            z6 = z3;
            i4 |= composerK.b(z6) ? 67108864 : 33554432;
        } else {
            z6 = z3;
        }
        if ((805306368 & i3) == 0) {
            z7 = z4;
            i4 |= composerK.b(z7) ? 536870912 : 268435456;
        } else {
            z7 = z4;
        }
        if ((i4 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-196481521, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDDocument (Markdown.kt:129)");
            }
            m893MDBlockChildrend8Fo1UA(document, j3, textStyle2, j5, fontWeight2, fontFamily2, textAlign2, z5, z6, z7, composerK, i4 & 2147483646);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDDocument$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    MarkdownKt.m896MDDocumentd8Fo1UA(document, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, z4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void MDFencedCodeBlock(final org.commonmark.node.FencedCodeBlock r58, androidx.compose.ui.Modifier r59, androidx.compose.runtime.Composer r60, final int r61, final int r62) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.MDFencedCodeBlock(org.commonmark.node.FencedCodeBlock, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:182:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fa  */
    /* JADX INFO: renamed from: MDHeading-JFVkrdg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m897MDHeadingJFVkrdg(final org.commonmark.node.Heading r42, final long r43, final androidx.compose.ui.text.TextStyle r45, final long r46, final androidx.compose.ui.text.font.FontWeight r48, final androidx.compose.ui.text.font.FontFamily r49, final androidx.compose.ui.text.style.TextAlign r50, final boolean r51, final boolean r52, final boolean r53, androidx.compose.ui.Modifier r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instruction units count: 970
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.m897MDHeadingJFVkrdg(org.commonmark.node.Heading, long, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.text.style.TextAlign, boolean, boolean, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fe  */
    /* JADX INFO: renamed from: MDListItems-JFVkrdg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m898MDListItemsJFVkrdg(final org.commonmark.node.ListBlock r30, final long r31, final androidx.compose.ui.text.TextStyle r33, final long r34, final androidx.compose.ui.text.font.FontWeight r36, final androidx.compose.ui.text.font.FontFamily r37, final androidx.compose.ui.text.style.TextAlign r38, final boolean r39, final boolean r40, androidx.compose.ui.Modifier r41, final kotlin.jvm.functions.Function3<? super org.commonmark.node.Node, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, final int r44, final int r45, final int r46) {
        /*
            Method dump skipped, instruction units count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.m898MDListItemsJFVkrdg(org.commonmark.node.ListBlock, long, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.text.style.TextAlign, boolean, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDOrderedList-lzeOXFE, reason: not valid java name */
    public static final void m899MDOrderedListlzeOXFE(final OrderedList orderedList, final long j3, final TextStyle textStyle, final long j4, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z2, final boolean z3, Composer composer, final int i3) {
        OrderedList orderedList2;
        int i4;
        long j5;
        FontWeight fontWeight2;
        FontFamily fontFamily2;
        boolean z4;
        Composer composerK = composer.k(1401481105);
        if ((i3 & 6) == 0) {
            orderedList2 = orderedList;
            i4 = (composerK.I(orderedList2) ? 4 : 2) | i3;
        } else {
            orderedList2 = orderedList;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            j5 = j3;
            i4 |= composerK.f(j5) ? 32 : 16;
        } else {
            j5 = j3;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(textStyle) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            fontWeight2 = fontWeight;
            i4 |= composerK.Z(fontWeight2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            fontWeight2 = fontWeight;
        }
        if ((196608 & i3) == 0) {
            fontFamily2 = fontFamily;
            i4 |= composerK.Z(fontFamily2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            z4 = z2;
            i4 |= composerK.b(z4) ? 8388608 : 4194304;
        } else {
            z4 = z2;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.b(z3) ? 67108864 : 33554432;
        }
        if ((38347923 & i4) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1401481105, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDOrderedList (Markdown.kt:306)");
            }
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.f140142a = orderedList2.s();
            final char cR = orderedList2.r();
            final TextStyle textStyleResolveMarkdownTextStyle = resolveMarkdownTextStyle(textStyle, new TextStyle(j5, j4, fontWeight2, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.n() : TextAlign.f29616b.g(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null));
            final boolean z5 = z4;
            m898MDListItemsJFVkrdg(orderedList2, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, null, ComposableLambdaKt.e(-1609568168, true, new Function3<Node, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDOrderedList$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Node) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Node it, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1609568168, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDOrderedList.<anonymous> (Markdown.kt:330)");
                    }
                    TextStyle textStyle2 = textStyleResolveMarkdownTextStyle;
                    Ref.IntRef intRef2 = intRef;
                    char c3 = cR;
                    long j6 = j3;
                    boolean z6 = z5;
                    FontWeight fontWeight3 = fontWeight;
                    AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                    builder.s(textStyle2.P());
                    StringBuilder sb = new StringBuilder();
                    int i6 = intRef2.f140142a;
                    intRef2.f140142a = i6 + 1;
                    sb.append(i6);
                    sb.append(c3);
                    sb.append(' ');
                    builder.l(sb.toString());
                    MarkdownKt.m911appendMarkdownChildrenXOJAsU(builder, it, j6, z6, fontWeight3);
                    builder.p();
                    MarkdownKt.MarkdownText(builder.t(), textStyleResolveMarkdownTextStyle, z3, null, composer2, 0, 8);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, i4 & 268435454, 6, 512);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDOrderedList$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    MarkdownKt.m899MDOrderedListlzeOXFE(orderedList, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: MDParagraph-d8Fo1UA, reason: not valid java name */
    public static final void m900MDParagraphd8Fo1UA(final Paragraph paragraph, final long j3, final TextStyle textStyle, final long j4, final FontWeight fontWeight, final FontFamily fontFamily, final TextAlign textAlign, final boolean z2, final boolean z3, final boolean z4, Composer composer, final int i3) {
        int i4;
        FontFamily fontFamily2;
        Composer composer2;
        Composer composerK = composer.k(-581921093);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(paragraph) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(textStyle) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.f(j4) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(fontWeight) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            fontFamily2 = fontFamily;
            i4 |= composerK.Z(fontFamily2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            fontFamily2 = fontFamily;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(textAlign) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.b(z2) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.b(z3) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i4 |= composerK.b(z4) ? 536870912 : 268435456;
        }
        if ((i4 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-581921093, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.MDParagraph (Markdown.kt:220)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            int i5 = i4;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            TextStyle textStyleResolveMarkdownTextStyle = resolveMarkdownTextStyle(textStyle, new TextStyle(j3, z4 ? j4 : TextUnit.f30006b.a(), fontWeight, (FontStyle) null, (FontSynthesis) null, fontFamily2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, textAlign != null ? textAlign.n() : TextAlign.f29616b.g(), 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16744408, (DefaultConstructorMarker) null));
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            builder.s(textStyleResolveMarkdownTextStyle.P());
            Intrinsics.checkNotNull(paragraph, "null cannot be cast to non-null type org.commonmark.node.Node");
            m911appendMarkdownChildrenXOJAsU(builder, paragraph, j3, z2, fontWeight);
            builder.p();
            composer2 = composerK;
            MarkdownText(builder.t(), textStyleResolveMarkdownTextStyle, z3, null, composer2, (i5 >> 18) & 896, 8);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt$MDParagraph$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    MarkdownKt.m900MDParagraphd8Fo1UA(paragraph, j3, textStyle, j4, fontWeight, fontFamily, textAlign, z2, z3, z4, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:200:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0104  */
    /* JADX INFO: renamed from: Markdown-DkhmgE0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m901MarkdownDkhmgE0(final java.lang.String r31, androidx.compose.ui.Modifier r32, long r33, androidx.compose.ui.text.TextStyle r35, long r36, androidx.compose.ui.text.font.FontWeight r38, androidx.compose.ui.text.font.FontFamily r39, androidx.compose.ui.Alignment.Horizontal r40, androidx.compose.ui.text.style.TextAlign r41, boolean r42, boolean r43, boolean r44, androidx.compose.runtime.Composer r45, final int r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 851
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.m901MarkdownDkhmgE0(java.lang.String, androidx.compose.ui.Modifier, long, androidx.compose.ui.text.TextStyle, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.text.style.TextAlign, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void MarkdownText(final androidx.compose.ui.text.AnnotatedString r32, final androidx.compose.ui.text.TextStyle r33, final boolean r34, androidx.compose.ui.Modifier r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.MarkdownKt.MarkdownText(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.text.TextStyle, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: appendMarkdownChildren-XO-JAsU, reason: not valid java name */
    public static final void m911appendMarkdownChildrenXOJAsU(AnnotatedString.Builder builder, Node node, long j3, boolean z2, FontWeight fontWeight) {
        Node nodeD = node.d();
        while (nodeD != null) {
            if (nodeD instanceof Paragraph) {
                m911appendMarkdownChildrenXOJAsU(builder, nodeD, j3, z2, fontWeight);
            } else if (nodeD instanceof Text) {
                String strO = ((Text) nodeD).o();
                Intrinsics.checkNotNullExpressionValue(strO, "child.literal");
                builder.l(strO);
            } else if (nodeD instanceof Emphasis) {
                builder.s(new SpanStyle(0L, 0L, (FontWeight) null, FontStyle.c(FontStyle.f29211b.a()), (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65527, (DefaultConstructorMarker) null));
                m911appendMarkdownChildrenXOJAsU(builder, nodeD, j3, z2, fontWeight);
                builder.p();
            } else if (nodeD instanceof StrongEmphasis) {
                int iN = fontWeight != null ? fontWeight.n() : 0;
                FontWeight.Companion companion = FontWeight.f29233b;
                FontWeight fontWeightB = iN > companion.b().n() ? fontWeight : companion.b();
                builder.s(new SpanStyle(0L, 0L, fontWeightB, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65531, (DefaultConstructorMarker) null));
                m911appendMarkdownChildrenXOJAsU(builder, nodeD, j3, z2, fontWeightB);
                builder.p();
            } else {
                Node node2 = nodeD;
                if (node2 instanceof Code) {
                    builder.s(new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.f29155b.c(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777183, (DefaultConstructorMarker) null).P());
                    String strO2 = ((Code) node2).o();
                    Intrinsics.checkNotNullExpressionValue(strO2, "child.literal");
                    builder.l(strO2);
                    builder.p();
                } else {
                    if (node2 instanceof HardLineBreak ? true : node2 instanceof SoftLineBreak) {
                        Intrinsics.checkNotNullExpressionValue(builder.append('\n'), "append(...)");
                    } else if (!(node2 instanceof Link)) {
                        nodeD = node2;
                        if (nodeD instanceof Strikethrough) {
                            builder.s(new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.b(), (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16773119, (DefaultConstructorMarker) null).P());
                            m911appendMarkdownChildrenXOJAsU(builder, nodeD, j3, z2, fontWeight);
                            builder.p();
                        }
                    } else if (z2) {
                        SpanStyle spanStyle = new SpanStyle(j3, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61438, (DefaultConstructorMarker) null);
                        String strO3 = ((Link) node2).o();
                        Intrinsics.checkNotNullExpressionValue(strO3, "child.destination");
                        int iR = builder.r(new LinkAnnotation.Url(strO3, new TextLinkStyles(spanStyle, null, null, null, 14, null), null, 4, null));
                        nodeD = node2;
                        try {
                            m911appendMarkdownChildrenXOJAsU(builder, nodeD, j3, true, fontWeight);
                            Unit unit = Unit.f139807a;
                        } finally {
                            builder.q(iR);
                        }
                    } else {
                        nodeD = node2;
                        m911appendMarkdownChildrenXOJAsU(builder, nodeD, j3, false, fontWeight);
                    }
                }
                nodeD = node2;
            }
            nodeD = nodeD.f();
        }
    }

    private static final TextStyle resolveMarkdownTextStyle(TextStyle textStyle, TextStyle textStyle2) {
        return textStyle.L(textStyle2);
    }
}
