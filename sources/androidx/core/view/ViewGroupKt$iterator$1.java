package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

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
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f34462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewGroup f34463b;

    ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.f34463b = viewGroup;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public View next() {
        ViewGroup viewGroup = this.f34463b;
        int i3 = this.f34462a;
        this.f34462a = i3 + 1;
        View childAt = viewGroup.getChildAt(i3);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34462a < this.f34463b.getChildCount();
    }

    @Override // java.util.Iterator
    public void remove() {
        ViewGroup viewGroup = this.f34463b;
        int i3 = this.f34462a - 1;
        this.f34462a = i3;
        viewGroup.removeViewAt(i3);
    }
}
