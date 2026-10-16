package androidx.compose.ui.text;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

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
final class JvmAnnotatedString_jvmKt$transform$1 extends Lambda implements Function1<List<? extends Integer>, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f28700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function3 f28701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AnnotatedString f28702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Map f28703d;

    @Override // kotlin.jvm.functions.Function1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Integer invoke(List list) {
        int iIntValue = ((Number) list.get(0)).intValue();
        int iIntValue2 = ((Number) list.get(1)).intValue();
        this.f28700a.f140144a = ((String) this.f28700a.f140144a) + ((String) this.f28701b.invoke(this.f28702c.k(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2)));
        return (Integer) this.f28703d.put(Integer.valueOf(iIntValue2), Integer.valueOf(((String) this.f28700a.f140144a).length()));
    }
}
