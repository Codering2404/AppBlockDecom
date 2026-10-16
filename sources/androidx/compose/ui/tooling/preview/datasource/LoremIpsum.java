package androidx.compose.ui.tooling.preview.datasource;

import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

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
public class LoremIpsum implements PreviewParameterProvider<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29959a;

    private final String a(int i3) {
        final Ref.IntRef intRef = new Ref.IntRef();
        final int size = LoremIpsum_androidKt.f29962a.size();
        return SequencesKt.K(SequencesKt.P(SequencesKt.i(new Function0<String>() { // from class: androidx.compose.ui.tooling.preview.datasource.LoremIpsum$generateLoremIpsum$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                List list = LoremIpsum_androidKt.f29962a;
                Ref.IntRef intRef2 = intRef;
                int i4 = intRef2.f140142a;
                intRef2.f140142a = i4 + 1;
                return (String) list.get(i4 % size);
            }
        }), i3), " ", null, null, 0, null, null, 62, null);
    }

    @Override // androidx.compose.ui.tooling.preview.PreviewParameterProvider
    public Sequence getValues() {
        return SequencesKt.m(a(this.f29959a));
    }
}
