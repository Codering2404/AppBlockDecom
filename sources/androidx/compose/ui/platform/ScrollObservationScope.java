package androidx.compose.ui.platform;

import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import java.util.List;
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
public final class ScrollObservationScope implements OwnerScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f28199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Float f28200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Float f28201d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ScrollAxisRange f28202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ScrollAxisRange f28203g;

    public ScrollObservationScope(int i3, List list, Float f3, Float f4, ScrollAxisRange scrollAxisRange, ScrollAxisRange scrollAxisRange2) {
        this.f28198a = i3;
        this.f28199b = list;
        this.f28200c = f3;
        this.f28201d = f4;
        this.f28202f = scrollAxisRange;
        this.f28203g = scrollAxisRange2;
    }

    public final ScrollAxisRange a() {
        return this.f28202f;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean a1() {
        return this.f28199b.contains(this);
    }

    public final Float b() {
        return this.f28200c;
    }

    public final Float c() {
        return this.f28201d;
    }

    public final int d() {
        return this.f28198a;
    }

    public final ScrollAxisRange e() {
        return this.f28203g;
    }

    public final void f(ScrollAxisRange scrollAxisRange) {
        this.f28202f = scrollAxisRange;
    }

    public final void g(Float f3) {
        this.f28200c = f3;
    }

    public final void h(Float f3) {
        this.f28201d = f3;
    }

    public final void i(ScrollAxisRange scrollAxisRange) {
        this.f28203g = scrollAxisRange;
    }
}
