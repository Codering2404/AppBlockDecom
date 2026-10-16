package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Animation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

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
final class Utils_androidKt$createTransitionInfo$values$2 extends Lambda implements Function0<Map<Long, Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Animation f29899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f29900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f29901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Lazy f29902d;

    @Override // kotlin.jvm.functions.Function0
    public final Map invoke() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Long.valueOf(Utils_androidKt.b(this.f29902d)), this.f29899a.f(Utils_androidKt.c(Utils_androidKt.b(this.f29902d))));
        linkedHashMap.put(Long.valueOf(this.f29900b), this.f29899a.f(Utils_androidKt.c(this.f29900b)));
        long jB = Utils_androidKt.b(this.f29902d);
        while (jB <= this.f29900b) {
            linkedHashMap.put(Long.valueOf(jB), this.f29899a.f(Utils_androidKt.c(jB)));
            jB += this.f29901c;
        }
        return linkedHashMap;
    }
}
