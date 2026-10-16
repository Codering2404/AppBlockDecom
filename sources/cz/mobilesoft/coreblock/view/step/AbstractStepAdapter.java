package cz.mobilesoft.coreblock.view.step;

import ernestoyaquello.com.verticalstepperform.Step;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class AbstractStepAdapter<T> extends Step<T> {
    @Override // ernestoyaquello.com.verticalstepperform.Step
    public String h() {
        return String.valueOf(g());
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step
    protected Step.IsDataValid m(Object obj) {
        return new Step.IsDataValid(obj != null);
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step
    protected void q(boolean z2) {
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step
    protected void r(boolean z2) {
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step
    protected void s(boolean z2) {
    }

    @Override // ernestoyaquello.com.verticalstepperform.Step
    protected void t(boolean z2) {
    }
}
