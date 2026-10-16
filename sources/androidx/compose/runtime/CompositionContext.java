package androidx.compose.runtime;

import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

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
public abstract class CompositionContext {
    public abstract void a(ControlledComposition controlledComposition, Function2 function2);

    public abstract void b(MovableContentStateReference movableContentStateReference);

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean f();

    public PersistentCompositionLocalMap g() {
        return CompositionContextKt.f23802a;
    }

    public abstract int h();

    public abstract CoroutineContext i();

    public CompositionObserverHolder j() {
        return null;
    }

    public abstract CoroutineContext k();

    public abstract void l(MovableContentStateReference movableContentStateReference);

    public abstract void m(ControlledComposition controlledComposition);

    public abstract void n(MovableContentStateReference movableContentStateReference, MovableContentState movableContentState, Applier applier);

    public MovableContentState o(MovableContentStateReference movableContentStateReference) {
        return null;
    }

    public abstract void r(RecomposeScopeImpl recomposeScopeImpl);

    public abstract void s(ControlledComposition controlledComposition);

    public abstract void v(ControlledComposition controlledComposition);

    public void c() {
    }

    public void t() {
    }

    public void p(Set set) {
    }

    public void q(Composer composer) {
    }

    public void u(Composer composer) {
    }
}
