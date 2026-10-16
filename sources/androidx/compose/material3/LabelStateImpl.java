package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class LabelStateImpl implements TooltipState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f18029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableTransitionState f18031c;

    public LabelStateImpl(boolean z2, boolean z3) {
        this.f18029a = z2;
        this.f18030b = z3;
        this.f18031c = new MutableTransitionState(Boolean.FALSE);
    }

    @Override // androidx.compose.material3.TooltipState
    public MutableTransitionState b() {
        return this.f18031c;
    }

    @Override // androidx.compose.material3.TooltipState
    public Object c(MutatePriority mutatePriority, Continuation continuation) {
        return Unit.f139807a;
    }

    @Override // androidx.compose.material3.TooltipState
    public boolean isVisible() {
        return this.f18029a;
    }

    public /* synthetic */ LabelStateImpl(boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2, (i3 & 2) != 0 ? true : z3);
    }

    @Override // androidx.compose.material3.TooltipState
    public void a() {
    }

    @Override // androidx.compose.material3.TooltipState
    public void dismiss() {
    }
}
