package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
public final class MutableTransitionState<S> extends TransitionState<S> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4020d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f4021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f4022c;

    public MutableTransitionState(Object obj) {
        super(null);
        this.f4021b = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f4022c = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public Object a() {
        return this.f4021b.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public Object b() {
        return this.f4022c.getValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void d(Object obj) {
        this.f4021b.setValue(obj);
    }

    public void h(Object obj) {
        this.f4022c.setValue(obj);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void g() {
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void f(Transition transition) {
    }
}
