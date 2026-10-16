package androidx.compose.material3;

import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
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
final class DateVisualTransformation implements VisualTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DateInputFormat f17438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f17440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f17441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DateVisualTransformation$dateOffsetTranslator$1 f17442f = new OffsetMapping() { // from class: androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1
        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int a(int i3) {
            return i3 <= this.f17443b.f17439c + (-1) ? i3 : i3 <= this.f17443b.f17440d + (-1) ? i3 - 1 : i3 <= this.f17443b.f17441e + 1 ? i3 - 2 : this.f17443b.f17441e;
        }

        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int b(int i3) {
            return i3 < this.f17443b.f17439c ? i3 : i3 < this.f17443b.f17440d ? i3 + 1 : i3 <= this.f17443b.f17441e ? i3 + 2 : this.f17443b.f17441e + 2;
        }
    };

    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.material3.DateVisualTransformation$dateOffsetTranslator$1] */
    public DateVisualTransformation(DateInputFormat dateInputFormat) {
        this.f17438b = dateInputFormat;
        this.f17439c = StringsKt.m0(dateInputFormat.b(), dateInputFormat.a(), 0, false, 6, null);
        this.f17440d = StringsKt.t0(dateInputFormat.b(), dateInputFormat.a(), 0, false, 6, null);
        this.f17441e = dateInputFormat.c().length();
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText a(AnnotatedString annotatedString) {
        int i3 = 0;
        String strB1 = annotatedString.k().length() > this.f17441e ? StringsKt.b1(annotatedString.k(), RangesKt.B(0, this.f17441e)) : annotatedString.k();
        String str = "";
        int i4 = 0;
        while (i3 < strB1.length()) {
            int i5 = i4 + 1;
            String str2 = str + strB1.charAt(i3);
            if (i5 == this.f17439c || i4 + 2 == this.f17440d) {
                str = str2 + this.f17438b.a();
            } else {
                str = str2;
            }
            i3++;
            i4 = i5;
        }
        return new TransformedText(new AnnotatedString(str, null, null, 6, null), this.f17442f);
    }
}
