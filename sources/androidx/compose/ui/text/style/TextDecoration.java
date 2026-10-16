package androidx.compose.ui.text.style;

import androidx.compose.ui.util.ListUtilsKt;
import java.util.ArrayList;
import java.util.List;
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
public final class TextDecoration {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29625b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TextDecoration f29626c = new TextDecoration(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TextDecoration f29627d = new TextDecoration(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TextDecoration f29628e = new TextDecoration(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29629a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextDecoration a(List list) {
            Integer numValueOf = 0;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                numValueOf = Integer.valueOf(numValueOf.intValue() | ((TextDecoration) list.get(i3)).e());
            }
            return new TextDecoration(numValueOf.intValue());
        }

        public final TextDecoration b() {
            return TextDecoration.f29628e;
        }

        public final TextDecoration c() {
            return TextDecoration.f29626c;
        }

        public final TextDecoration d() {
            return TextDecoration.f29627d;
        }

        private Companion() {
        }
    }

    public TextDecoration(int i3) {
        this.f29629a = i3;
    }

    public final boolean d(TextDecoration textDecoration) {
        int i3 = this.f29629a;
        return (textDecoration.f29629a | i3) == i3;
    }

    public final int e() {
        return this.f29629a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TextDecoration) && this.f29629a == ((TextDecoration) obj).f29629a;
    }

    public int hashCode() {
        return this.f29629a;
    }

    public String toString() {
        if (this.f29629a == 0) {
            return "TextDecoration.None";
        }
        ArrayList arrayList = new ArrayList();
        if ((this.f29629a & f29627d.f29629a) != 0) {
            arrayList.add("Underline");
        }
        if ((this.f29629a & f29628e.f29629a) != 0) {
            arrayList.add("LineThrough");
        }
        if (arrayList.size() == 1) {
            return "TextDecoration." + ((String) arrayList.get(0));
        }
        return "TextDecoration[" + ListUtilsKt.e(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
