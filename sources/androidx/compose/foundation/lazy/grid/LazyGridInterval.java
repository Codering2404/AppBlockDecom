package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

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
public final class LazyGridInterval implements LazyLayoutIntervalContent.Interval {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f7737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f7738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f7739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function4 f7740d;

    public LazyGridInterval(Function1 function1, Function2 function2, Function1 function12, Function4 function4) {
        this.f7737a = function1;
        this.f7738b = function2;
        this.f7739c = function12;
        this.f7740d = function4;
    }

    public final Function4 a() {
        return this.f7740d;
    }

    public final Function2 b() {
        return this.f7738b;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public Function1 getKey() {
        return this.f7737a;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval
    public Function1 getType() {
        return this.f7739c;
    }
}
