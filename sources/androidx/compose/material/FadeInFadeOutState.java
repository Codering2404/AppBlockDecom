package androidx.compose.material;

import androidx.compose.runtime.RecomposeScope;
import java.util.ArrayList;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class FadeInFadeOutState<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f12947a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f12948b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RecomposeScope f12949c;

    public final Object a() {
        return this.f12947a;
    }

    public final List b() {
        return this.f12948b;
    }

    public final RecomposeScope c() {
        return this.f12949c;
    }

    public final void d(Object obj) {
        this.f12947a = obj;
    }

    public final void e(RecomposeScope recomposeScope) {
        this.f12949c = recomposeScope;
    }
}
