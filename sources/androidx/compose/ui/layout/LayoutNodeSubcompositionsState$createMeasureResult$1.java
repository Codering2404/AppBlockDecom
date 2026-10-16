package androidx.compose.ui.layout;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public final class LayoutNodeSubcompositionsState$createMeasureResult$1 implements MeasureResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ MeasureResult f27140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function0 f27141b;

    @Override // androidx.compose.ui.layout.MeasureResult
    public void A() {
        this.f27141b.invoke();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Function1 B() {
        return this.f27140a.B();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getHeight() {
        return this.f27140a.getHeight();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public int getWidth() {
        return this.f27140a.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public Map z() {
        return this.f27140a.z();
    }
}
