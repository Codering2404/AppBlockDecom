package androidx.compose.ui.text.input;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.NonNullValueClassSaver;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextFieldValue {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f29419d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Saver f29420e = SaverKt.a(new Function2<SaverScope, TextFieldValue, Object>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SaverScope saverScope, TextFieldValue textFieldValue) {
            return CollectionsKt.arrayListOf(SaversKt.z(textFieldValue.f(), SaversKt.h(), saverScope), SaversKt.z(TextRange.b(textFieldValue.h()), SaversKt.m(TextRange.f28921b), saverScope));
        }
    }, new Function1<Object, TextFieldValue>() { // from class: androidx.compose.ui.text.input.TextFieldValue$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TextFieldValue invoke(Object obj) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            Saver saverH = SaversKt.h();
            Boolean bool = Boolean.FALSE;
            TextRange textRange = null;
            AnnotatedString annotatedString = ((!Intrinsics.areEqual(obj2, bool) || (saverH instanceof NonNullValueClassSaver)) && obj2 != null) ? (AnnotatedString) saverH.b(obj2) : null;
            Intrinsics.checkNotNull(annotatedString);
            Object obj3 = list.get(1);
            Saver saverM = SaversKt.m(TextRange.f28921b);
            if ((!Intrinsics.areEqual(obj3, bool) || (saverM instanceof NonNullValueClassSaver)) && obj3 != null) {
                textRange = (TextRange) saverM.b(obj3);
            }
            Intrinsics.checkNotNull(textRange);
            return new TextFieldValue(annotatedString, textRange.r(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnnotatedString f29421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f29422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextRange f29423c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return TextFieldValue.f29420e;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j3, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, j3, textRange);
    }

    public static /* synthetic */ TextFieldValue d(TextFieldValue textFieldValue, AnnotatedString annotatedString, long j3, TextRange textRange, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            annotatedString = textFieldValue.f29421a;
        }
        if ((i3 & 2) != 0) {
            j3 = textFieldValue.f29422b;
        }
        if ((i3 & 4) != 0) {
            textRange = textFieldValue.f29423c;
        }
        return textFieldValue.b(annotatedString, j3, textRange);
    }

    public static /* synthetic */ TextFieldValue e(TextFieldValue textFieldValue, String str, long j3, TextRange textRange, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = textFieldValue.f29422b;
        }
        if ((i3 & 4) != 0) {
            textRange = textFieldValue.f29423c;
        }
        return textFieldValue.c(str, j3, textRange);
    }

    public final TextFieldValue b(AnnotatedString annotatedString, long j3, TextRange textRange) {
        return new TextFieldValue(annotatedString, j3, textRange, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextFieldValue c(String str, long j3, TextRange textRange) {
        return new TextFieldValue(new AnnotatedString(str, null, 2, 0 == true ? 1 : 0), j3, textRange, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextFieldValue)) {
            return false;
        }
        TextFieldValue textFieldValue = (TextFieldValue) obj;
        return TextRange.g(this.f29422b, textFieldValue.f29422b) && Intrinsics.areEqual(this.f29423c, textFieldValue.f29423c) && Intrinsics.areEqual(this.f29421a, textFieldValue.f29421a);
    }

    public final AnnotatedString f() {
        return this.f29421a;
    }

    public final TextRange g() {
        return this.f29423c;
    }

    public final long h() {
        return this.f29422b;
    }

    public int hashCode() {
        int iHashCode = ((this.f29421a.hashCode() * 31) + TextRange.o(this.f29422b)) * 31;
        TextRange textRange = this.f29423c;
        return iHashCode + (textRange != null ? TextRange.o(textRange.r()) : 0);
    }

    public final String i() {
        return this.f29421a.k();
    }

    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.f29421a) + "', selection=" + ((Object) TextRange.q(this.f29422b)) + ", composition=" + this.f29423c + ')';
    }

    public /* synthetic */ TextFieldValue(String str, long j3, TextRange textRange, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, textRange);
    }

    private TextFieldValue(AnnotatedString annotatedString, long j3, TextRange textRange) {
        this.f29421a = annotatedString;
        this.f29422b = TextRangeKt.c(j3, 0, i().length());
        this.f29423c = textRange != null ? TextRange.b(TextRangeKt.c(textRange.r(), 0, i().length())) : null;
    }

    public /* synthetic */ TextFieldValue(AnnotatedString annotatedString, long j3, TextRange textRange, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, (i3 & 2) != 0 ? TextRange.f28921b.a() : j3, (i3 & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ TextFieldValue(String str, long j3, TextRange textRange, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? TextRange.f28921b.a() : j3, (i3 & 4) != 0 ? null : textRange, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TextFieldValue(String str, long j3, TextRange textRange) {
        this(new AnnotatedString(str, null, 2, 0 == true ? 1 : 0), j3, textRange, (DefaultConstructorMarker) null);
    }
}
