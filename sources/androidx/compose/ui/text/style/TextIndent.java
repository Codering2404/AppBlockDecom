package androidx.compose.ui.text.style;

import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class TextIndent {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f29647c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TextIndent f29648d = new TextIndent(0, 0, 3, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f29649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f29650b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextIndent a() {
            return TextIndent.f29648d;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TextIndent(long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4);
    }

    public final long b() {
        return this.f29649a;
    }

    public final long c() {
        return this.f29650b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextIndent)) {
            return false;
        }
        TextIndent textIndent = (TextIndent) obj;
        return TextUnit.e(this.f29649a, textIndent.f29649a) && TextUnit.e(this.f29650b, textIndent.f29650b);
    }

    public int hashCode() {
        return (TextUnit.i(this.f29649a) * 31) + TextUnit.i(this.f29650b);
    }

    public String toString() {
        return "TextIndent(firstLine=" + ((Object) TextUnit.l(this.f29649a)) + ", restLine=" + ((Object) TextUnit.l(this.f29650b)) + ')';
    }

    private TextIndent(long j3, long j4) {
        this.f29649a = j3;
        this.f29650b = j4;
    }

    public /* synthetic */ TextIndent(long j3, long j4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? TextUnitKt.i(0) : j3, (i3 & 2) != 0 ? TextUnitKt.i(0) : j4, null);
    }
}
