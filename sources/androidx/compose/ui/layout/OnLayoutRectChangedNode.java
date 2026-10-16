package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import kotlin.Metadata;
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
final class OnLayoutRectChangedNode extends Modifier.Node {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f27186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f27187b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function1 f27188c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DelegatableNode.RegistrationHandle f27189d;

    public OnLayoutRectChangedNode(long j3, long j4, Function1 function1) {
        this.f27186a = j3;
        this.f27187b = j4;
        this.f27188c = function1;
    }

    public final void m2() {
        DelegatableNode.RegistrationHandle registrationHandle = this.f27189d;
        if (registrationHandle != null) {
            registrationHandle.a();
        }
        this.f27189d = OnLayoutRectChangedModifierKt.a(this, this.f27186a, this.f27187b, this.f27188c);
    }

    public final void n2(Function1 function1) {
        this.f27188c = function1;
    }

    public final void o2(long j3) {
        this.f27187b = j3;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        m2();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DelegatableNode.RegistrationHandle registrationHandle = this.f27189d;
        if (registrationHandle != null) {
            registrationHandle.a();
        }
    }

    public final void p2(long j3) {
        this.f27186a = j3;
    }
}
