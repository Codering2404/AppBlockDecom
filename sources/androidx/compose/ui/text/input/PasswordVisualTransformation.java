package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PasswordVisualTransformation implements VisualTransformation {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f29403b;

    public PasswordVisualTransformation(char c3) {
        this.f29403b = c3;
    }

    @Override // androidx.compose.ui.text.input.VisualTransformation
    public TransformedText a(AnnotatedString annotatedString) {
        return new TransformedText(new AnnotatedString(StringsKt.K(String.valueOf(this.f29403b), annotatedString.k().length()), null, 2, null), OffsetMapping.f29394a.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PasswordVisualTransformation) && this.f29403b == ((PasswordVisualTransformation) obj).f29403b;
    }

    public int hashCode() {
        return Character.hashCode(this.f29403b);
    }

    public /* synthetic */ PasswordVisualTransformation(char c3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? (char) 8226 : c3);
    }
}
