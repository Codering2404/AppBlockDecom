package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

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
public final class WordSegmentFinder implements SegmentFinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f29042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WordIterator f29043b;

    public WordSegmentFinder(CharSequence charSequence, WordIterator wordIterator) {
        this.f29042a = charSequence;
        this.f29043b = wordIterator;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int a(int i3) {
        do {
            i3 = this.f29043b.p(i3);
            if (i3 == -1 || i3 == this.f29042a.length()) {
                return -1;
            }
        } while (Character.isWhitespace(this.f29042a.charAt(i3)));
        return i3;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int b(int i3) {
        do {
            i3 = this.f29043b.q(i3);
            if (i3 == -1) {
                return -1;
            }
        } while (Character.isWhitespace(this.f29042a.charAt(i3)));
        return i3;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int c(int i3) {
        do {
            i3 = this.f29043b.p(i3);
            if (i3 == -1) {
                return -1;
            }
        } while (Character.isWhitespace(this.f29042a.charAt(i3 - 1)));
        return i3;
    }

    @Override // androidx.compose.ui.text.android.selection.SegmentFinder
    public int d(int i3) {
        do {
            i3 = this.f29043b.q(i3);
            if (i3 == -1 || i3 == 0) {
                return -1;
            }
        } while (Character.isWhitespace(this.f29042a.charAt(i3 - 1)));
        return i3;
    }
}
