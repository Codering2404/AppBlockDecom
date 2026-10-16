package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
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
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextStyle f29484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f29485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f29486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FontFamily.Resolver f29487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Density f29488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AndroidTextPaint f29489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CharSequence f29490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LayoutIntrinsics f29491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TypefaceDirtyTrackerLinkedList f29492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f29493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f29494l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    public AndroidParagraphIntrinsics(String str, TextStyle textStyle, List list, List list2, FontFamily.Resolver resolver, Density density) {
        Object obj;
        ?? arrayList;
        this.f29483a = str;
        this.f29484b = textStyle;
        this.f29485c = list;
        this.f29486d = list2;
        this.f29487e = resolver;
        this.f29488f = density;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, density.getDensity());
        this.f29489g = androidTextPaint;
        this.f29493k = !AndroidParagraphIntrinsics_androidKt.c(textStyle) ? false : ((Boolean) EmojiCompatStatus.f29518a.a().getValue()).booleanValue();
        this.f29494l = AndroidParagraphIntrinsics_androidKt.d(textStyle.D(), textStyle.w());
        Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface> function4 = new Function4<FontFamily, FontWeight, FontStyle, FontSynthesis, Typeface>() { // from class: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics$resolveTypeface$1
            {
                super(4);
            }

            public final Typeface c(FontFamily fontFamily, FontWeight fontWeight, int i3, int i4) {
                State stateA = this.f29495a.g().a(fontFamily, fontWeight, i3, i4);
                if (stateA instanceof TypefaceResult.Immutable) {
                    Object value = stateA.getValue();
                    Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                    return (Typeface) value;
                }
                TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = new TypefaceDirtyTrackerLinkedList(stateA, this.f29495a.f29492j);
                this.f29495a.f29492j = typefaceDirtyTrackerLinkedList;
                return typefaceDirtyTrackerLinkedList.a();
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                return c((FontFamily) obj2, (FontWeight) obj3, ((FontStyle) obj4).i(), ((FontSynthesis) obj5).m());
            }
        };
        TextPaintExtensions_androidKt.e(androidTextPaint, textStyle.G());
        SpanStyle spanStyleP = textStyle.P();
        int size = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i3);
            if (((AnnotatedString.Range) obj).g() instanceof SpanStyle) {
                break;
            } else {
                i3++;
            }
        }
        SpanStyle spanStyleA = TextPaintExtensions_androidKt.a(androidTextPaint, spanStyleP, function4, density, obj != null);
        if (spanStyleA != null) {
            int size2 = this.f29485c.size() + 1;
            arrayList = new ArrayList(size2);
            int i4 = 0;
            while (i4 < size2) {
                arrayList.add(i4 == 0 ? new AnnotatedString.Range(spanStyleA, 0, this.f29483a.length()) : (AnnotatedString.Range) this.f29485c.get(i4 - 1));
                i4++;
            }
        } else {
            arrayList = this.f29485c;
        }
        CharSequence charSequenceA = AndroidParagraphHelper_androidKt.a(this.f29483a, this.f29489g.getTextSize(), this.f29484b, arrayList, this.f29486d, this.f29488f, function4, this.f29493k);
        this.f29490h = charSequenceA;
        this.f29491i = new LayoutIntrinsics(charSequenceA, this.f29489g, this.f29494l);
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean a() {
        TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = this.f29492j;
        if (typefaceDirtyTrackerLinkedList != null ? typefaceDirtyTrackerLinkedList.b() : false) {
            return true;
        }
        return !this.f29493k && AndroidParagraphIntrinsics_androidKt.c(this.f29484b) && ((Boolean) EmojiCompatStatus.f29518a.a().getValue()).booleanValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float c() {
        return this.f29491i.i();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float e() {
        return this.f29491i.j();
    }

    public final CharSequence f() {
        return this.f29490h;
    }

    public final FontFamily.Resolver g() {
        return this.f29487e;
    }

    public final LayoutIntrinsics h() {
        return this.f29491i;
    }

    public final TextStyle i() {
        return this.f29484b;
    }

    public final int j() {
        return this.f29494l;
    }

    public final AndroidTextPaint k() {
        return this.f29489g;
    }
}
