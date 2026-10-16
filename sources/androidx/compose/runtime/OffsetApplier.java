package androidx.compose.runtime;

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
public final class OffsetApplier<N> implements Applier<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Applier f23970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23972c;

    public OffsetApplier(Applier applier, int i3) {
        this.f23970a = applier;
        this.f23971b = i3;
    }

    @Override // androidx.compose.runtime.Applier
    public void a(int i3, int i4) {
        this.f23970a.a(i3 + (this.f23972c == 0 ? this.f23971b : 0), i4);
    }

    @Override // androidx.compose.runtime.Applier
    public Object b() {
        return this.f23970a.b();
    }

    @Override // androidx.compose.runtime.Applier
    public void c(int i3, int i4, int i5) {
        int i6 = this.f23972c == 0 ? this.f23971b : 0;
        this.f23970a.c(i3 + i6, i4 + i6, i5);
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        ComposerKt.t("Clear is not valid on OffsetApplier");
    }

    @Override // androidx.compose.runtime.Applier
    public void e(int i3, Object obj) {
        this.f23970a.e(i3 + (this.f23972c == 0 ? this.f23971b : 0), obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void g(int i3, Object obj) {
        this.f23970a.g(i3 + (this.f23972c == 0 ? this.f23971b : 0), obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void h(Object obj) {
        this.f23972c++;
        this.f23970a.h(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void k() {
        if (!(this.f23972c > 0)) {
            ComposerKt.t("OffsetApplier up called with no corresponding down");
        }
        this.f23972c--;
        this.f23970a.k();
    }
}
