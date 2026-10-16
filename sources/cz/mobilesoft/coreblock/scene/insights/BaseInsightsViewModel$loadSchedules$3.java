package cz.mobilesoft.coreblock.scene.insights;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class BaseInsightsViewModel$loadSchedules$3<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ BaseInsightsViewModel f102496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f102497b;

    BaseInsightsViewModel$loadSchedules$3(BaseInsightsViewModel baseInsightsViewModel, String str) {
        this.f102496a = baseInsightsViewModel;
        this.f102497b = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fd, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Path cross not found for [B:26:0x00e3, B:25:0x00e1], limit reached: 82 */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00c6 -> B:20:0x00ca). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x01c4 -> B:61:0x01d5). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.util.List r38, kotlin.coroutines.Continuation r39) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$loadSchedules$3.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
