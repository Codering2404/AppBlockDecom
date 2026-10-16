package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
public final class RecordingApplier<N> implements Applier<N> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f24148d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24149e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableIntList f24150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableObjectList f24151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f24152c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // androidx.compose.runtime.Applier
    public void a(int i3, int i4) {
        this.f24150a.l(2);
        this.f24150a.l(i3);
        this.f24150a.l(i4);
    }

    @Override // androidx.compose.runtime.Applier
    public Object b() {
        return this.f24152c;
    }

    @Override // androidx.compose.runtime.Applier
    public void c(int i3, int i4, int i5) {
        this.f24150a.l(3);
        this.f24150a.l(i3);
        this.f24150a.l(i4);
        this.f24150a.l(i5);
    }

    @Override // androidx.compose.runtime.Applier
    public void clear() {
        this.f24150a.l(4);
    }

    @Override // androidx.compose.runtime.Applier
    public void d(Function2 function2, Object obj) {
        this.f24150a.l(7);
        this.f24151b.n(function2);
        this.f24151b.n(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void e(int i3, Object obj) {
        this.f24150a.l(6);
        this.f24150a.l(i3);
        this.f24151b.n(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void g(int i3, Object obj) {
        this.f24150a.l(5);
        this.f24150a.l(i3);
        this.f24151b.n(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void h(Object obj) {
        this.f24150a.l(1);
        this.f24151b.n(obj);
    }

    @Override // androidx.compose.runtime.Applier
    public void i() {
        this.f24150a.l(8);
    }

    @Override // androidx.compose.runtime.Applier
    public void k() {
        this.f24150a.l(0);
    }
}
