package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class SingleSelectionLayout implements SelectionLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f11510f = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f11511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f11513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Selection f11514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SelectableInfo f11515e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SingleSelectionLayout(boolean z2, int i3, int i4, Selection selection, SelectableInfo selectableInfo) {
        this.f11511a = z2;
        this.f11512b = i3;
        this.f11513c = i4;
        this.f11514d = selection;
        this.f11515e = selectableInfo;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean a() {
        return this.f11511a;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo b() {
        return this.f11515e;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo c() {
        return this.f11515e;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int d() {
        return this.f11513c;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public CrossStatus e() {
        return l() < d() ? CrossStatus.f11213b : l() > d() ? CrossStatus.f11212a : this.f11515e.d();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public Selection g() {
        return this.f11514d;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int getSize() {
        return 1;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public LongObjectMap h(Selection selection) {
        return LongObjectMapKt.b(this.f11515e.h(), ((selection.d() || selection.e().d() <= selection.c().d()) && (!selection.d() || selection.e().d() > selection.c().d())) ? selection : Selection.b(selection, null, null, !selection.d(), 3, null));
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public boolean i(SelectionLayout selectionLayout) {
        return (g() != null && selectionLayout != null && (selectionLayout instanceof SingleSelectionLayout) && l() == selectionLayout.l() && d() == selectionLayout.d() && a() == selectionLayout.a() && !this.f11515e.n(((SingleSelectionLayout) selectionLayout).f11515e)) ? false : true;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo j() {
        return this.f11515e;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public SelectableInfo k() {
        return this.f11515e;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public int l() {
        return this.f11512b;
    }

    public String toString() {
        return "SingleSelectionLayout(isStartHandle=" + a() + ", crossed=" + e() + ", info=\n\t" + this.f11515e + ')';
    }

    @Override // androidx.compose.foundation.text.selection.SelectionLayout
    public void f(Function1 function1) {
    }
}
