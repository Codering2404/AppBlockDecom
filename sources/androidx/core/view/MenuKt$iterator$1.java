package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f34418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Menu f34419b;

    MenuKt$iterator$1(Menu menu) {
        this.f34419b = menu;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MenuItem next() {
        Menu menu = this.f34419b;
        int i3 = this.f34418a;
        this.f34418a = i3 + 1;
        MenuItem item = menu.getItem(i3);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f34418a < this.f34419b.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        Unit unit;
        Menu menu = this.f34419b;
        int i3 = this.f34418a - 1;
        this.f34418a = i3;
        MenuItem item = menu.getItem(i3);
        if (item != null) {
            menu.removeItem(item.getItemId());
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
