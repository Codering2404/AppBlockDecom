package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
public abstract class AbstractApplier<T> implements Applier<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f23712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f23713b = Stack.c(null, 1, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f23714c;

    public AbstractApplier(Object obj) {
        this.f23712a = obj;
        this.f23714c = obj;
    }

    @Override // androidx.compose.runtime.Applier
    public Object b() {
        return this.f23714c;
    }

    @Override // androidx.compose.runtime.Applier
    public final void clear() {
        Stack.a(this.f23713b);
        p(this.f23712a);
        n();
    }

    @Override // androidx.compose.runtime.Applier
    public void h(Object obj) {
        Stack.l(this.f23713b, b());
        p(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void k() {
        p(Stack.k(this.f23713b));
    }

    public final Object l() {
        return this.f23712a;
    }

    protected final void m(List list, int i3, int i4, int i5) {
        int i6 = i3 > i4 ? i4 : i4 - i5;
        if (i5 != 1) {
            List listSubList = list.subList(i3, i5 + i3);
            List mutableList = CollectionsKt.toMutableList((Collection) listSubList);
            listSubList.clear();
            list.addAll(i6, mutableList);
            return;
        }
        if (i3 == i4 + 1 || i3 == i4 - 1) {
            list.set(i3, list.set(i4, list.get(i3)));
        } else {
            list.add(i6, list.remove(i3));
        }
    }

    protected abstract void n();

    protected final void o(List list, int i3, int i4) {
        if (i4 == 1) {
            list.remove(i3);
        } else {
            list.subList(i3, i4 + i3).clear();
        }
    }

    protected void p(Object obj) {
        this.f23714c = obj;
    }
}
