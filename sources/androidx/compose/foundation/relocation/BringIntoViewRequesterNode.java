package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class BringIntoViewRequesterNode extends Modifier.Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BringIntoViewRequester f8929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f8930b;

    public BringIntoViewRequesterNode(BringIntoViewRequester bringIntoViewRequester) {
        this.f8929a = bringIntoViewRequester;
    }

    private final void m2() {
        BringIntoViewRequester bringIntoViewRequester = this.f8929a;
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            Intrinsics.checkNotNull(bringIntoViewRequester, "null cannot be cast to non-null type androidx.compose.foundation.relocation.BringIntoViewRequesterImpl");
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).c().s(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.f8930b;
    }

    public final void n2(BringIntoViewRequester bringIntoViewRequester) {
        m2();
        if (bringIntoViewRequester instanceof BringIntoViewRequesterImpl) {
            ((BringIntoViewRequesterImpl) bringIntoViewRequester).c().b(this);
        }
        this.f8929a = bringIntoViewRequester;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        n2(this.f8929a);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        m2();
    }
}
