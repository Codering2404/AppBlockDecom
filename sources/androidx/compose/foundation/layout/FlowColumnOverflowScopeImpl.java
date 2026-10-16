package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class FlowColumnOverflowScopeImpl implements FlowColumnScope, FlowColumnOverflowScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FlowLayoutOverflowState f6793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FlowColumnScopeInstance f6794b = FlowColumnScopeInstance.f6799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f6795c = FlowLayoutOverflowKt.b(null, new Function0<Integer>() { // from class: androidx.compose.foundation.layout.FlowColumnOverflowScopeImpl$totalItemCount$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(this.f6798a.f6793a.g());
        }
    }, 1, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f6796d;

    public FlowColumnOverflowScopeImpl(FlowLayoutOverflowState flowLayoutOverflowState) {
        this.f6793a = flowLayoutOverflowState;
        this.f6796d = FlowLayoutOverflowKt.a(flowLayoutOverflowState.k(), new Function0<Integer>() { // from class: androidx.compose.foundation.layout.FlowColumnOverflowScopeImpl$shownItemCount$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(this.f6797a.f6793a.h());
            }
        });
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier a(Modifier modifier, float f3, boolean z2) {
        return this.f6794b.a(modifier, f3, z2);
    }

    @Override // androidx.compose.foundation.layout.ColumnScope
    public Modifier c(Modifier modifier, Alignment.Horizontal horizontal) {
        return this.f6794b.c(modifier, horizontal);
    }
}
