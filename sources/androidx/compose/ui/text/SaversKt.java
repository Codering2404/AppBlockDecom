package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class SaversKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Saver f28773a = SaverKt.a(new Function2<SaverScope, AnnotatedString, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, AnnotatedString annotatedString) {
            return CollectionsKt.arrayListOf(SaversKt.y(annotatedString.k()), SaversKt.z(annotatedString.c(), SaversKt.f28774b, saverScope));
        }
    }, new Function1<Object, AnnotatedString>() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AnnotatedString invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(1);
            Saver saver = SaversKt.f28774b;
            List list2 = ((!Intrinsics.areEqual(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? (List) saver.b(obj2) : null;
            Object obj3 = list.get(0);
            String str = obj3 != null ? (String) obj3 : null;
            Intrinsics.checkNotNull(str);
            return new AnnotatedString(list2, str);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Saver f28774b = SaverKt.a(new Function2<SaverScope, List<? extends AnnotatedString.Range<? extends Object>>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, List list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(SaversKt.z((AnnotatedString.Range) list.get(i3), SaversKt.f28775c, saverScope));
            }
            return arrayList;
        }
    }, new Function1<Object, List<? extends AnnotatedString.Range<? extends Object>>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj2 = list.get(i3);
                Saver saver = SaversKt.f28775c;
                AnnotatedString.Range range = null;
                if ((!Intrinsics.areEqual(obj2, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                    range = (AnnotatedString.Range) saver.b(obj2);
                }
                Intrinsics.checkNotNull(range);
                arrayList.add(range);
            }
            return arrayList;
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Saver f28775c = SaverKt.a(new Function2<SaverScope, AnnotatedString.Range<? extends Object>, Object>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f28801a;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.f28665a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.f28666b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.f28667c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.f28668d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.f28669f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.f28670g.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.f28671h.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f28801a = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, AnnotatedString.Range range) {
            AnnotationType annotationType;
            Object objZ;
            Object objG = range.g();
            if (objG instanceof ParagraphStyle) {
                annotationType = AnnotationType.f28665a;
            } else if (objG instanceof SpanStyle) {
                annotationType = AnnotationType.f28666b;
            } else if (objG instanceof VerbatimTtsAnnotation) {
                annotationType = AnnotationType.f28667c;
            } else if (objG instanceof UrlAnnotation) {
                annotationType = AnnotationType.f28668d;
            } else if (objG instanceof LinkAnnotation.Url) {
                annotationType = AnnotationType.f28669f;
            } else if (objG instanceof LinkAnnotation.Clickable) {
                annotationType = AnnotationType.f28670g;
            } else {
                if (!(objG instanceof StringAnnotation)) {
                    throw new UnsupportedOperationException();
                }
                annotationType = AnnotationType.f28671h;
            }
            switch (WhenMappings.f28801a[annotationType.ordinal()]) {
                case 1:
                    Object objG2 = range.g();
                    Intrinsics.checkNotNull(objG2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                    objZ = SaversKt.z((ParagraphStyle) objG2, SaversKt.i(), saverScope);
                    break;
                case 2:
                    Object objG3 = range.g();
                    Intrinsics.checkNotNull(objG3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                    objZ = SaversKt.z((SpanStyle) objG3, SaversKt.w(), saverScope);
                    break;
                case 3:
                    Object objG4 = range.g();
                    Intrinsics.checkNotNull(objG4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                    objZ = SaversKt.z((VerbatimTtsAnnotation) objG4, SaversKt.f28776d, saverScope);
                    break;
                case 4:
                    Object objG5 = range.g();
                    Intrinsics.checkNotNull(objG5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                    objZ = SaversKt.z((UrlAnnotation) objG5, SaversKt.f28777e, saverScope);
                    break;
                case 5:
                    Object objG6 = range.g();
                    Intrinsics.checkNotNull(objG6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                    objZ = SaversKt.z((LinkAnnotation.Url) objG6, SaversKt.f28778f, saverScope);
                    break;
                case 6:
                    Object objG7 = range.g();
                    Intrinsics.checkNotNull(objG7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                    objZ = SaversKt.z((LinkAnnotation.Clickable) objG7, SaversKt.f28779g, saverScope);
                    break;
                case 7:
                    Object objG8 = range.g();
                    Intrinsics.checkNotNull(objG8, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
                    objZ = SaversKt.y(((StringAnnotation) objG8).f());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return CollectionsKt.arrayListOf(SaversKt.y(annotationType), objZ, SaversKt.y(Integer.valueOf(range.h())), SaversKt.y(Integer.valueOf(range.f())), SaversKt.y(range.i()));
        }
    }, new Function1<Object, AnnotatedString.Range<? extends Object>>() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f28803a;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.f28665a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.f28666b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.f28667c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.f28668d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.f28669f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AnnotationType.f28670g.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[AnnotationType.f28671h.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                f28803a = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AnnotatedString.Range invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            ParagraphStyle paragraphStyle = null;
            clickable = null;
            LinkAnnotation.Clickable clickable = null;
            url = null;
            LinkAnnotation.Url url = null;
            urlAnnotation = null;
            UrlAnnotation urlAnnotation = null;
            verbatimTtsAnnotation = null;
            VerbatimTtsAnnotation verbatimTtsAnnotation = null;
            spanStyle = null;
            SpanStyle spanStyle = null;
            paragraphStyle = null;
            AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
            Intrinsics.checkNotNull(annotationType);
            Object obj3 = list.get(2);
            Integer num = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Object obj4 = list.get(3);
            Integer num2 = obj4 != null ? (Integer) obj4 : null;
            Intrinsics.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Object obj5 = list.get(4);
            String str = obj5 != null ? (String) obj5 : null;
            Intrinsics.checkNotNull(str);
            switch (WhenMappings.f28803a[annotationType.ordinal()]) {
                case 1:
                    Object obj6 = list.get(1);
                    Saver saverI = SaversKt.i();
                    if ((!Intrinsics.areEqual(obj6, Boolean.FALSE) || (saverI instanceof NonNullValueClassSaver)) && obj6 != null) {
                        paragraphStyle = (ParagraphStyle) saverI.b(obj6);
                    }
                    Intrinsics.checkNotNull(paragraphStyle);
                    return new AnnotatedString.Range(paragraphStyle, iIntValue, iIntValue2, str);
                case 2:
                    Object obj7 = list.get(1);
                    Saver saverW = SaversKt.w();
                    if ((!Intrinsics.areEqual(obj7, Boolean.FALSE) || (saverW instanceof NonNullValueClassSaver)) && obj7 != null) {
                        spanStyle = (SpanStyle) saverW.b(obj7);
                    }
                    Intrinsics.checkNotNull(spanStyle);
                    return new AnnotatedString.Range(spanStyle, iIntValue, iIntValue2, str);
                case 3:
                    Object obj8 = list.get(1);
                    Saver saver = SaversKt.f28776d;
                    if ((!Intrinsics.areEqual(obj8, Boolean.FALSE) || (saver instanceof NonNullValueClassSaver)) && obj8 != null) {
                        verbatimTtsAnnotation = (VerbatimTtsAnnotation) saver.b(obj8);
                    }
                    Intrinsics.checkNotNull(verbatimTtsAnnotation);
                    return new AnnotatedString.Range(verbatimTtsAnnotation, iIntValue, iIntValue2, str);
                case 4:
                    Object obj9 = list.get(1);
                    Saver saver2 = SaversKt.f28777e;
                    if ((!Intrinsics.areEqual(obj9, Boolean.FALSE) || (saver2 instanceof NonNullValueClassSaver)) && obj9 != null) {
                        urlAnnotation = (UrlAnnotation) saver2.b(obj9);
                    }
                    Intrinsics.checkNotNull(urlAnnotation);
                    return new AnnotatedString.Range(urlAnnotation, iIntValue, iIntValue2, str);
                case 5:
                    Object obj10 = list.get(1);
                    Saver saver3 = SaversKt.f28778f;
                    if ((!Intrinsics.areEqual(obj10, Boolean.FALSE) || (saver3 instanceof NonNullValueClassSaver)) && obj10 != null) {
                        url = (LinkAnnotation.Url) saver3.b(obj10);
                    }
                    Intrinsics.checkNotNull(url);
                    return new AnnotatedString.Range(url, iIntValue, iIntValue2, str);
                case 6:
                    Object obj11 = list.get(1);
                    Saver saver4 = SaversKt.f28779g;
                    if ((!Intrinsics.areEqual(obj11, Boolean.FALSE) || (saver4 instanceof NonNullValueClassSaver)) && obj11 != null) {
                        clickable = (LinkAnnotation.Clickable) saver4.b(obj11);
                    }
                    Intrinsics.checkNotNull(clickable);
                    return new AnnotatedString.Range(clickable, iIntValue, iIntValue2, str);
                case 7:
                    Object obj12 = list.get(1);
                    String str2 = obj12 != null ? (String) obj12 : null;
                    Intrinsics.checkNotNull(str2);
                    return new AnnotatedString.Range(StringAnnotation.a(StringAnnotation.b(str2)), iIntValue, iIntValue2, str);
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Saver f28776d = SaverKt.a(new Function2<SaverScope, VerbatimTtsAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
            return SaversKt.y(verbatimTtsAnnotation.a());
        }
    }, new Function1<Object, VerbatimTtsAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final VerbatimTtsAnnotation invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.checkNotNull(str);
            return new VerbatimTtsAnnotation(str);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Saver f28777e = SaverKt.a(new Function2<SaverScope, UrlAnnotation, Object>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, UrlAnnotation urlAnnotation) {
            return SaversKt.y(urlAnnotation.a());
        }
    }, new Function1<Object, UrlAnnotation>() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final UrlAnnotation invoke(Object obj) {
            String str = obj != null ? (String) obj : null;
            Intrinsics.checkNotNull(str);
            return new UrlAnnotation(str);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Saver f28778f = SaverKt.a(new Function2<SaverScope, LinkAnnotation.Url, Object>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, LinkAnnotation.Url url) {
            return CollectionsKt.arrayListOf(SaversKt.y(url.c()), SaversKt.z(url.b(), SaversKt.x(), saverScope));
        }
    }, new Function1<Object, LinkAnnotation.Url>() { // from class: androidx.compose.ui.text.SaversKt$LinkSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LinkAnnotation.Url invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextLinkStyles textLinkStyles = null;
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.checkNotNull(str);
            Object obj3 = list.get(1);
            Saver saverX = SaversKt.x();
            if ((!Intrinsics.areEqual(obj3, Boolean.FALSE) || (saverX instanceof NonNullValueClassSaver)) && obj3 != null) {
                textLinkStyles = (TextLinkStyles) saverX.b(obj3);
            }
            return new LinkAnnotation.Url(str, textLinkStyles, null, 4, null);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Saver f28779g = SaverKt.a(new Function2<SaverScope, LinkAnnotation.Clickable, Object>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, LinkAnnotation.Clickable clickable) {
            return CollectionsKt.arrayListOf(SaversKt.y(clickable.c()), SaversKt.z(clickable.b(), SaversKt.x(), saverScope));
        }
    }, new Function1<Object, LinkAnnotation.Clickable>() { // from class: androidx.compose.ui.text.SaversKt$ClickableSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LinkAnnotation.Clickable invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            String str = obj2 != null ? (String) obj2 : null;
            Intrinsics.checkNotNull(str);
            Object obj3 = list.get(1);
            Saver saverX = SaversKt.x();
            return new LinkAnnotation.Clickable(str, ((!Intrinsics.areEqual(obj3, Boolean.FALSE) || (saverX instanceof NonNullValueClassSaver)) && obj3 != null) ? (TextLinkStyles) saverX.b(obj3) : null, null);
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Saver f28780h = SaverKt.a(new Function2<SaverScope, ParagraphStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, ParagraphStyle paragraphStyle) {
            return CollectionsKt.arrayListOf(SaversKt.y(TextAlign.h(paragraphStyle.h())), SaversKt.y(TextDirection.g(paragraphStyle.i())), SaversKt.z(TextUnit.b(paragraphStyle.e()), SaversKt.v(TextUnit.f30006b), saverScope), SaversKt.z(paragraphStyle.j(), SaversKt.u(TextIndent.f29647c), saverScope), SaversKt.z(paragraphStyle.g(), Savers_androidKt.a(PlatformParagraphStyle.f28765c), saverScope), SaversKt.z(paragraphStyle.f(), SaversKt.r(LineHeightStyle.f29591d), saverScope), SaversKt.z(LineBreak.c(paragraphStyle.d()), Savers_androidKt.b(LineBreak.f29567b), saverScope), SaversKt.y(Hyphens.d(paragraphStyle.c())), SaversKt.z(paragraphStyle.k(), Savers_androidKt.c(TextMotion.f29651c), saverScope));
        }
    }, new Function1<Object, ParagraphStyle>() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final ParagraphStyle invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextMotion textMotion = null;
            TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
            Intrinsics.checkNotNull(textAlign);
            int iN = textAlign.n();
            Object obj3 = list.get(1);
            TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
            Intrinsics.checkNotNull(textDirection);
            int iM = textDirection.m();
            Object obj4 = list.get(2);
            Saver saverV = SaversKt.v(TextUnit.f30006b);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = ((!Intrinsics.areEqual(obj4, bool) || (saverV instanceof NonNullValueClassSaver)) && obj4 != null) ? (TextUnit) saverV.b(obj4) : null;
            Intrinsics.checkNotNull(textUnit);
            long jM = textUnit.m();
            Object obj5 = list.get(3);
            Saver saverU = SaversKt.u(TextIndent.f29647c);
            TextIndent textIndent = ((!Intrinsics.areEqual(obj5, bool) || (saverU instanceof NonNullValueClassSaver)) && obj5 != null) ? (TextIndent) saverU.b(obj5) : null;
            Object obj6 = list.get(4);
            Saver saverA = Savers_androidKt.a(PlatformParagraphStyle.f28765c);
            PlatformParagraphStyle platformParagraphStyle = ((!Intrinsics.areEqual(obj6, bool) || (saverA instanceof NonNullValueClassSaver)) && obj6 != null) ? (PlatformParagraphStyle) saverA.b(obj6) : null;
            Object obj7 = list.get(5);
            Saver saverR = SaversKt.r(LineHeightStyle.f29591d);
            LineHeightStyle lineHeightStyle = ((!Intrinsics.areEqual(obj7, bool) || (saverR instanceof NonNullValueClassSaver)) && obj7 != null) ? (LineHeightStyle) saverR.b(obj7) : null;
            Object obj8 = list.get(6);
            Saver saverB = Savers_androidKt.b(LineBreak.f29567b);
            LineBreak lineBreak = ((!Intrinsics.areEqual(obj8, bool) || (saverB instanceof NonNullValueClassSaver)) && obj8 != null) ? (LineBreak) saverB.b(obj8) : null;
            Intrinsics.checkNotNull(lineBreak);
            int iL = lineBreak.l();
            Object obj9 = list.get(7);
            Hyphens hyphens = obj9 != null ? (Hyphens) obj9 : null;
            Intrinsics.checkNotNull(hyphens);
            int iJ = hyphens.j();
            Object obj10 = list.get(8);
            Saver saverC = Savers_androidKt.c(TextMotion.f29651c);
            if ((!Intrinsics.areEqual(obj10, bool) || (saverC instanceof NonNullValueClassSaver)) && obj10 != null) {
                textMotion = (TextMotion) saverC.b(obj10);
            }
            return new ParagraphStyle(iN, iM, jM, textIndent, platformParagraphStyle, lineHeightStyle, iL, iJ, textMotion, null);
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Saver f28781i = SaverKt.a(new Function2<SaverScope, SpanStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, SpanStyle spanStyle) {
            Color colorN = Color.n(spanStyle.g());
            Color.Companion companion = Color.f25715b;
            Object objZ = SaversKt.z(colorN, SaversKt.k(companion), saverScope);
            TextUnit textUnitB = TextUnit.b(spanStyle.k());
            TextUnit.Companion companion2 = TextUnit.f30006b;
            return CollectionsKt.arrayListOf(objZ, SaversKt.z(textUnitB, SaversKt.v(companion2), saverScope), SaversKt.z(spanStyle.n(), SaversKt.n(FontWeight.f29233b), saverScope), SaversKt.y(spanStyle.l()), SaversKt.y(spanStyle.m()), SaversKt.y(-1), SaversKt.y(spanStyle.j()), SaversKt.z(TextUnit.b(spanStyle.o()), SaversKt.v(companion2), saverScope), SaversKt.z(spanStyle.e(), SaversKt.q(BaselineShift.f29554b), saverScope), SaversKt.z(spanStyle.u(), SaversKt.t(TextGeometricTransform.f29643c), saverScope), SaversKt.z(spanStyle.p(), SaversKt.p(LocaleList.f29471c), saverScope), SaversKt.z(Color.n(spanStyle.d()), SaversKt.k(companion), saverScope), SaversKt.z(spanStyle.s(), SaversKt.s(TextDecoration.f29625b), saverScope), SaversKt.z(spanStyle.r(), SaversKt.l(Shadow.f25903d), saverScope));
        }
    }, new Function1<Object, SpanStyle>() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 androidx.compose.ui.text.SpanStyle, still in use, count: 2, list:
              (r1v1 androidx.compose.ui.text.SpanStyle) from 0x00d8: MOVE (r16v2 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle) (LINE:217)
              (r1v1 androidx.compose.ui.text.SpanStyle) from 0x00d0: MOVE (r16v7 androidx.compose.ui.text.SpanStyle) = (r1v1 androidx.compose.ui.text.SpanStyle) (LINE:209)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
            	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
            	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
            */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final androidx.compose.ui.text.SpanStyle invoke(java.lang.Object r29) {
            /*
                Method dump skipped, instruction units count: 450
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2.invoke(java.lang.Object):androidx.compose.ui.text.SpanStyle");
        }
    });

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Saver f28782j = SaverKt.a(new Function2<SaverScope, TextLinkStyles, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, TextLinkStyles textLinkStyles) {
            return CollectionsKt.arrayListOf(SaversKt.z(textLinkStyles.d(), SaversKt.w(), saverScope), SaversKt.z(textLinkStyles.a(), SaversKt.w(), saverScope), SaversKt.z(textLinkStyles.b(), SaversKt.w(), saverScope), SaversKt.z(textLinkStyles.c(), SaversKt.w(), saverScope));
        }
    }, new Function1<Object, TextLinkStyles>() { // from class: androidx.compose.ui.text.SaversKt$TextLinkStylesSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextLinkStyles invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver saverW = SaversKt.w();
            Boolean bool = Boolean.FALSE;
            SpanStyle spanStyle = null;
            SpanStyle spanStyle2 = ((!Intrinsics.areEqual(obj2, bool) || (saverW instanceof NonNullValueClassSaver)) && obj2 != null) ? (SpanStyle) saverW.b(obj2) : null;
            Object obj3 = list.get(1);
            Saver saverW2 = SaversKt.w();
            SpanStyle spanStyle3 = ((!Intrinsics.areEqual(obj3, bool) || (saverW2 instanceof NonNullValueClassSaver)) && obj3 != null) ? (SpanStyle) saverW2.b(obj3) : null;
            Object obj4 = list.get(2);
            Saver saverW3 = SaversKt.w();
            SpanStyle spanStyle4 = ((!Intrinsics.areEqual(obj4, bool) || (saverW3 instanceof NonNullValueClassSaver)) && obj4 != null) ? (SpanStyle) saverW3.b(obj4) : null;
            Object obj5 = list.get(3);
            Saver saverW4 = SaversKt.w();
            if ((!Intrinsics.areEqual(obj5, bool) || (saverW4 instanceof NonNullValueClassSaver)) && obj5 != null) {
                spanStyle = (SpanStyle) saverW4.b(obj5);
            }
            return new TextLinkStyles(spanStyle2, spanStyle3, spanStyle4, spanStyle);
        }
    });

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Saver f28783k = SaverKt.a(new Function2<SaverScope, TextDecoration, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, TextDecoration textDecoration) {
            return Integer.valueOf(textDecoration.e());
        }
    }, new Function1<Object, TextDecoration>() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextDecoration invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new TextDecoration(((Integer) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Saver f28784l = SaverKt.a(new Function2<SaverScope, TextGeometricTransform, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
            return CollectionsKt.arrayListOf(Float.valueOf(textGeometricTransform.b()), Float.valueOf(textGeometricTransform.c()));
        }
    }, new Function1<Object, TextGeometricTransform>() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextGeometricTransform invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
            List list = (List) obj;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Saver f28785m = SaverKt.a(new Function2<SaverScope, TextIndent, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, TextIndent textIndent) {
            TextUnit textUnitB = TextUnit.b(textIndent.b());
            TextUnit.Companion companion = TextUnit.f30006b;
            return CollectionsKt.arrayListOf(SaversKt.z(textUnitB, SaversKt.v(companion), saverScope), SaversKt.z(TextUnit.b(textIndent.c()), SaversKt.v(companion), saverScope));
        }
    }, new Function1<Object, TextIndent>() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextIndent invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            TextUnit.Companion companion = TextUnit.f30006b;
            Saver saverV = SaversKt.v(companion);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = null;
            TextUnit textUnit2 = ((!Intrinsics.areEqual(obj2, bool) || (saverV instanceof NonNullValueClassSaver)) && obj2 != null) ? (TextUnit) saverV.b(obj2) : null;
            Intrinsics.checkNotNull(textUnit2);
            long jM = textUnit2.m();
            Object obj3 = list.get(1);
            Saver saverV2 = SaversKt.v(companion);
            if ((!Intrinsics.areEqual(obj3, bool) || (saverV2 instanceof NonNullValueClassSaver)) && obj3 != null) {
                textUnit = (TextUnit) saverV2.b(obj3);
            }
            Intrinsics.checkNotNull(textUnit);
            return new TextIndent(jM, textUnit.m(), null);
        }
    });

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Saver f28786n = SaverKt.a(new Function2<SaverScope, FontWeight, Object>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, FontWeight fontWeight) {
            return Integer.valueOf(fontWeight.n());
        }
    }, new Function1<Object, FontWeight>() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final FontWeight invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return new FontWeight(((Integer) obj).intValue());
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Saver f28787o = SaverKt.a(new Function2<SaverScope, BaselineShift, Object>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        public final Object c(SaverScope saverScope, float f3) {
            return Float.valueOf(f3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((SaverScope) obj, ((BaselineShift) obj2).j());
        }
    }, new Function1<Object, BaselineShift>() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final BaselineShift invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            return BaselineShift.d(BaselineShift.e(((Float) obj).floatValue()));
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Saver f28788p = SaverKt.a(new Function2<SaverScope, TextRange, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        /* JADX WARN: Multi-variable type inference failed */
        public final Object c(SaverScope saverScope, long j3) {
            return CollectionsKt.arrayListOf(SaversKt.y(Integer.valueOf(TextRange.n(j3))), SaversKt.y(Integer.valueOf(TextRange.i(j3))));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((SaverScope) obj, ((TextRange) obj2).r());
        }
    }, new Function1<Object, TextRange>() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextRange invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Integer num = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.checkNotNull(num);
            int iIntValue = num.intValue();
            Object obj3 = list.get(1);
            Integer num2 = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num2);
            return TextRange.b(TextRangeKt.b(iIntValue, num2.intValue()));
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Saver f28789q = SaverKt.a(new Function2<SaverScope, Shadow, Object>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, Shadow shadow) {
            return CollectionsKt.arrayListOf(SaversKt.z(Color.n(shadow.c()), SaversKt.k(Color.f25715b), saverScope), SaversKt.z(Offset.d(shadow.d()), SaversKt.j(Offset.f25596b), saverScope), SaversKt.y(Float.valueOf(shadow.b())));
        }
    }, new Function1<Object, Shadow>() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Shadow invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver saverK = SaversKt.k(Color.f25715b);
            Boolean bool = Boolean.FALSE;
            Color color = ((!Intrinsics.areEqual(obj2, bool) || (saverK instanceof NonNullValueClassSaver)) && obj2 != null) ? (Color) saverK.b(obj2) : null;
            Intrinsics.checkNotNull(color);
            long jB = color.B();
            Object obj3 = list.get(1);
            Saver saverJ = SaversKt.j(Offset.f25596b);
            Offset offset = ((!Intrinsics.areEqual(obj3, bool) || (saverJ instanceof NonNullValueClassSaver)) && obj3 != null) ? (Offset) saverJ.b(obj3) : null;
            Intrinsics.checkNotNull(offset);
            long jU = offset.u();
            Object obj4 = list.get(2);
            Float f3 = obj4 != null ? (Float) obj4 : null;
            Intrinsics.checkNotNull(f3);
            return new Shadow(jB, jU, f3.floatValue(), null);
        }
    });

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final NonNullValueClassSaver f28790r = a(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        public final Object c(SaverScope saverScope, long j3) {
            return j3 == 16 ? Boolean.FALSE : Integer.valueOf(ColorKt.k(j3));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((SaverScope) obj, ((Color) obj2).B());
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Color invoke(Object obj) {
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return Color.n(Color.f25715b.k());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return Color.n(ColorKt.b(((Integer) obj).intValue()));
        }
    });

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final NonNullValueClassSaver f28791s = a(new Function2<SaverScope, TextUnit, Object>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        public final Object c(SaverScope saverScope, long j3) {
            return TextUnit.e(j3, TextUnit.f30006b.a()) ? Boolean.FALSE : CollectionsKt.arrayListOf(SaversKt.y(Float.valueOf(TextUnit.h(j3))), SaversKt.y(TextUnitType.d(TextUnit.g(j3))));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((SaverScope) obj, ((TextUnit) obj2).m());
        }
    }, new Function1<Object, TextUnit>() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextUnit invoke(Object obj) {
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return TextUnit.b(TextUnit.f30006b.a());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f3 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f3);
            float fFloatValue = f3.floatValue();
            Object obj3 = list.get(1);
            TextUnitType textUnitType = obj3 != null ? (TextUnitType) obj3 : null;
            Intrinsics.checkNotNull(textUnitType);
            return TextUnit.b(TextUnitKt.a(fFloatValue, textUnitType.j()));
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final NonNullValueClassSaver f28792t = a(new Function2<SaverScope, Offset, Object>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        /* JADX WARN: Multi-variable type inference failed */
        public final Object c(SaverScope saverScope, long j3) {
            return Offset.j(j3, Offset.f25596b.b()) ? Boolean.FALSE : CollectionsKt.arrayListOf(SaversKt.y(Float.valueOf(Float.intBitsToFloat((int) (j3 >> 32)))), SaversKt.y(Float.valueOf(Float.intBitsToFloat((int) (j3 & 4294967295L)))));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return c((SaverScope) obj, ((Offset) obj2).u());
        }
    }, new Function1<Object, Offset>() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Offset invoke(Object obj) {
            if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                return Offset.d(Offset.f25596b.b());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Float f3 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f3);
            float fFloatValue = f3.floatValue();
            Object obj3 = list.get(1);
            Float f4 = obj3 != null ? (Float) obj3 : null;
            Intrinsics.checkNotNull(f4);
            return Offset.d(Offset.e((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(f4.floatValue())) & 4294967295L)));
        }
    });

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Saver f28793u = SaverKt.a(new Function2<SaverScope, LocaleList, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, LocaleList localeList) {
            List listE = localeList.e();
            ArrayList arrayList = new ArrayList(listE.size());
            int size = listE.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(SaversKt.z((Locale) listE.get(i3), SaversKt.o(Locale.f29469b), saverScope));
            }
            return arrayList;
        }
    }, new Function1<Object, LocaleList>() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LocaleList invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object obj2 = list.get(i3);
                Saver saverO = SaversKt.o(Locale.f29469b);
                Locale locale = null;
                if ((!Intrinsics.areEqual(obj2, Boolean.FALSE) || (saverO instanceof NonNullValueClassSaver)) && obj2 != null) {
                    locale = (Locale) saverO.b(obj2);
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(arrayList);
        }
    });

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Saver f28794v = SaverKt.a(new Function2<SaverScope, Locale, Object>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, Locale locale) {
            return locale.c();
        }
    }, new Function1<Object, Locale>() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Locale invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            return new Locale((String) obj);
        }
    });

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Saver f28795w = SaverKt.a(new Function2<SaverScope, LineHeightStyle, Object>() { // from class: androidx.compose.ui.text.SaversKt$LineHeightStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, LineHeightStyle lineHeightStyle) {
            return CollectionsKt.arrayListOf(SaversKt.y(LineHeightStyle.Alignment.c(lineHeightStyle.b())), SaversKt.y(LineHeightStyle.Trim.c(lineHeightStyle.d())), SaversKt.y(LineHeightStyle.Mode.c(lineHeightStyle.c())));
        }
    }, new Function1<Object, LineHeightStyle>() { // from class: androidx.compose.ui.text.SaversKt$LineHeightStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LineHeightStyle invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            LineHeightStyle.Alignment alignment = obj2 != null ? (LineHeightStyle.Alignment) obj2 : null;
            Intrinsics.checkNotNull(alignment);
            float fI = alignment.i();
            Object obj3 = list.get(1);
            LineHeightStyle.Trim trim = obj3 != null ? (LineHeightStyle.Trim) obj3 : null;
            Intrinsics.checkNotNull(trim);
            int iK = trim.k();
            Object obj4 = list.get(2);
            LineHeightStyle.Mode mode = obj4 != null ? (LineHeightStyle.Mode) obj4 : null;
            Intrinsics.checkNotNull(mode);
            return new LineHeightStyle(fI, iK, mode.i(), null);
        }
    });

    private static final NonNullValueClassSaver a(final Function2 function2, final Function1 function1) {
        return new NonNullValueClassSaver<Object, Object>() { // from class: androidx.compose.ui.text.SaversKt$NonNullValueClassSaver$1
            @Override // androidx.compose.runtime.saveable.Saver
            public Object a(SaverScope saverScope, Object obj) {
                return function2.invoke(saverScope, obj);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Object b(Object obj) {
                return function1.invoke(obj);
            }
        };
    }

    public static final Saver h() {
        return f28773a;
    }

    public static final Saver i() {
        return f28780h;
    }

    public static final Saver j(Offset.Companion companion) {
        return f28792t;
    }

    public static final Saver k(Color.Companion companion) {
        return f28790r;
    }

    public static final Saver l(Shadow.Companion companion) {
        return f28789q;
    }

    public static final Saver m(TextRange.Companion companion) {
        return f28788p;
    }

    public static final Saver n(FontWeight.Companion companion) {
        return f28786n;
    }

    public static final Saver o(Locale.Companion companion) {
        return f28794v;
    }

    public static final Saver p(LocaleList.Companion companion) {
        return f28793u;
    }

    public static final Saver q(BaselineShift.Companion companion) {
        return f28787o;
    }

    public static final Saver r(LineHeightStyle.Companion companion) {
        return f28795w;
    }

    public static final Saver s(TextDecoration.Companion companion) {
        return f28783k;
    }

    public static final Saver t(TextGeometricTransform.Companion companion) {
        return f28784l;
    }

    public static final Saver u(TextIndent.Companion companion) {
        return f28785m;
    }

    public static final Saver v(TextUnit.Companion companion) {
        return f28791s;
    }

    public static final Saver w() {
        return f28781i;
    }

    public static final Saver x() {
        return f28782j;
    }

    public static final Object z(Object obj, Saver saver, SaverScope saverScope) {
        Object objA;
        return (obj == null || (objA = saver.a(saverScope, obj)) == null) ? Boolean.FALSE : objA;
    }

    public static final Object y(Object obj) {
        return obj;
    }
}
