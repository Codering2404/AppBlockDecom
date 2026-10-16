package androidx.navigation.internal;

import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
public final class NavGraphImpl$iterator$1 implements Iterator<NavDestination>, KMutableIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f49378a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f49379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavGraphImpl f49380c;

    NavGraphImpl$iterator$1(NavGraphImpl navGraphImpl) {
        this.f49380c = navGraphImpl;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NavDestination next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f49379b = true;
        SparseArrayCompat sparseArrayCompatJ = this.f49380c.j();
        int i3 = this.f49378a + 1;
        this.f49378a = i3;
        return (NavDestination) sparseArrayCompatJ.r(i3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f49378a + 1 < this.f49380c.j().q();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f49379b) {
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
        SparseArrayCompat sparseArrayCompatJ = this.f49380c.j();
        ((NavDestination) sparseArrayCompatJ.r(this.f49378a)).D(null);
        sparseArrayCompatJ.o(this.f49378a);
        this.f49378a--;
        this.f49379b = false;
    }
}
