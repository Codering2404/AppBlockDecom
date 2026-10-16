package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SelectableInfo {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11251g = TextLayoutResult.f28902g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f11255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f11256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextLayoutResult f11257f;

    public SelectableInfo(long j3, int i3, int i4, int i5, int i6, TextLayoutResult textLayoutResult) {
        this.f11252a = j3;
        this.f11253b = i3;
        this.f11254c = i4;
        this.f11255d = i5;
        this.f11256e = i6;
        this.f11257f = textLayoutResult;
    }

    private final ResolvedTextDirection b() {
        return SelectionLayoutKt.b(this.f11257f, this.f11255d);
    }

    private final ResolvedTextDirection j() {
        return SelectionLayoutKt.b(this.f11257f, this.f11254c);
    }

    public final Selection.AnchorInfo a(int i3) {
        return new Selection.AnchorInfo(SelectionLayoutKt.b(this.f11257f, i3), i3, this.f11252a);
    }

    public final String c() {
        return this.f11257f.l().j().k();
    }

    public final CrossStatus d() {
        int i3 = this.f11254c;
        int i4 = this.f11255d;
        return i3 < i4 ? CrossStatus.f11213b : i3 > i4 ? CrossStatus.f11212a : CrossStatus.f11214c;
    }

    public final int e() {
        return this.f11255d;
    }

    public final int f() {
        return this.f11256e;
    }

    public final int g() {
        return this.f11254c;
    }

    public final long h() {
        return this.f11252a;
    }

    public final int i() {
        return this.f11253b;
    }

    public final TextLayoutResult k() {
        return this.f11257f;
    }

    public final int l() {
        return c().length();
    }

    public final Selection m(int i3, int i4) {
        return new Selection(a(i3), a(i4), i3 > i4);
    }

    public final boolean n(SelectableInfo selectableInfo) {
        return (this.f11252a == selectableInfo.f11252a && this.f11254c == selectableInfo.f11254c && this.f11255d == selectableInfo.f11255d) ? false : true;
    }

    public String toString() {
        return "SelectionInfo(id=" + this.f11252a + ", range=(" + this.f11254c + '-' + j() + ',' + this.f11255d + '-' + b() + "), prevOffset=" + this.f11256e + ')';
    }
}
