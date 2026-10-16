package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

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
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f28725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f28726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f28727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f28728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f28729e;

    public MultiParagraphIntrinsics(AnnotatedString annotatedString, TextStyle textStyle, List list, Density density, FontFamily.Resolver resolver) {
        this.f28725a = annotatedString;
        this.f28726b = list;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        this.f28727c = LazyKt.a(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object obj;
                ParagraphIntrinsics paragraphIntrinsicsB;
                List listF = this.f28731a.f();
                if (listF.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = listF.get(0);
                    float fE = ((ParagraphIntrinsicInfo) obj2).b().e();
                    int lastIndex = CollectionsKt.getLastIndex(listF);
                    int i3 = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            Object obj3 = listF.get(i3);
                            float fE2 = ((ParagraphIntrinsicInfo) obj3).b().e();
                            if (Float.compare(fE, fE2) < 0) {
                                obj2 = obj3;
                                fE = fE2;
                            }
                            if (i3 == lastIndex) {
                                break;
                            }
                            i3++;
                        }
                    }
                    obj = obj2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                return Float.valueOf((paragraphIntrinsicInfo == null || (paragraphIntrinsicsB = paragraphIntrinsicInfo.b()) == null) ? 0.0f : paragraphIntrinsicsB.e());
            }
        });
        this.f28728d = LazyKt.a(lazyThreadSafetyMode, new Function0<Float>() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                Object obj;
                ParagraphIntrinsics paragraphIntrinsicsB;
                List listF = this.f28730a.f();
                if (listF.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = listF.get(0);
                    float fC = ((ParagraphIntrinsicInfo) obj2).b().c();
                    int lastIndex = CollectionsKt.getLastIndex(listF);
                    int i3 = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            Object obj3 = listF.get(i3);
                            float fC2 = ((ParagraphIntrinsicInfo) obj3).b().c();
                            if (Float.compare(fC, fC2) < 0) {
                                obj2 = obj3;
                                fC = fC2;
                            }
                            if (i3 == lastIndex) {
                                break;
                            }
                            i3++;
                        }
                    }
                    obj = obj2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                return Float.valueOf((paragraphIntrinsicInfo == null || (paragraphIntrinsicsB = paragraphIntrinsicInfo.b()) == null) ? 0.0f : paragraphIntrinsicsB.c());
            }
        });
        ParagraphStyle paragraphStyleO = textStyle.O();
        List listJ = AnnotatedStringKt.j(annotatedString, paragraphStyleO);
        ArrayList arrayList = new ArrayList(listJ.size());
        int size = listJ.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) listJ.get(i3);
            AnnotatedString annotatedStringK = AnnotatedStringKt.k(annotatedString, range.h(), range.f());
            ParagraphStyle paragraphStyleH = h((ParagraphStyle) range.g(), paragraphStyleO);
            String strK = annotatedStringK.k();
            TextStyle textStyleK = textStyle.K(paragraphStyleH);
            List listC = annotatedStringK.c();
            if (listC == null) {
                listC = CollectionsKt.emptyList();
            }
            arrayList.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.a(strK, textStyleK, listC, density, resolver, MultiParagraphIntrinsicsKt.b(g(), range.h(), range.f())), range.h(), range.f()));
        }
        this.f28729e = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphStyle h(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2) {
        return !TextDirection.j(paragraphStyle.i(), TextDirection.f29630b.f()) ? paragraphStyle : ParagraphStyle.b(paragraphStyle, 0, paragraphStyle2.i(), 0L, null, null, null, 0, 0, null, 509, null);
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean a() {
        List list = this.f28729e;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((ParagraphIntrinsicInfo) list.get(i3)).b().a()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float c() {
        return ((Number) this.f28728d.getValue()).floatValue();
    }

    public final AnnotatedString d() {
        return this.f28725a;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float e() {
        return ((Number) this.f28727c.getValue()).floatValue();
    }

    public final List f() {
        return this.f28729e;
    }

    public final List g() {
        return this.f28726b;
    }
}
