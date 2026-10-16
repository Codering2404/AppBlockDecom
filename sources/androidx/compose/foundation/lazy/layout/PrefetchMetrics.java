package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
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
public final class PrefetchMetrics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Averages f8283a = new Averages();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableScatterMap f8284b = ScatterMapKt.c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f8285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Averages f8286d;

    private final Averages a(Object obj) {
        Averages averages = this.f8286d;
        if (this.f8285c == obj && averages != null) {
            return averages;
        }
        MutableScatterMap mutableScatterMap = this.f8284b;
        Object objE = mutableScatterMap.e(obj);
        if (objE == null) {
            objE = this.f8283a.b();
            mutableScatterMap.x(obj, objE);
        }
        Averages averages2 = (Averages) objE;
        this.f8285c = obj;
        this.f8286d = averages2;
        return averages2;
    }

    public final long b(Object obj) {
        return a(obj).c();
    }

    public final long c(Object obj) {
        return a(obj).d();
    }

    public final void d(Object obj, long j3) {
        this.f8283a.e(j3);
        a(obj).e(j3);
    }

    public final void e(Object obj, long j3) {
        this.f8283a.f(j3);
        a(obj).f(j3);
    }
}
