package androidx.compose.ui;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
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
final class SensitiveContentNode extends Modifier.Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f25174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f25176c;

    public SensitiveContentNode(boolean z2) {
        this.f25174a = z2;
        this.f25176c = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SensitiveContentNode) && this.f25174a == ((SensitiveContentNode) obj).f25174a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.f25174a);
    }

    public final void m2(boolean z2) {
        this.f25176c = z2;
        if (z2 && !this.f25175b) {
            DelegatableNodeKt.p(this).A();
            this.f25175b = true;
        } else {
            if (z2 || !this.f25175b) {
                return;
            }
            DelegatableNodeKt.p(this).I();
            this.f25175b = false;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        if (this.f25176c) {
            if (this.f25175b) {
                InlineClassHelperKt.c("invalid sensitive content state");
            }
            DelegatableNodeKt.p(this).A();
            this.f25175b = true;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        if (this.f25175b) {
            DelegatableNodeKt.p(this).I();
            this.f25175b = false;
        }
        super.onDetach();
    }

    public String toString() {
        return "SensitiveContentNode(_isContentSensitive=" + this.f25174a + ')';
    }
}
