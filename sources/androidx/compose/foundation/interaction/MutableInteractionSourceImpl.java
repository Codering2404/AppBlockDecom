package androidx.compose.foundation.interaction;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
final class MutableInteractionSourceImpl implements MutableInteractionSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableSharedFlow f6509a = SharedFlowKt.b(0, 16, BufferOverflow.f141063b, 1, null);

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public Object a(Interaction interaction, Continuation continuation) {
        Object objEmit = c().emit(interaction, continuation);
        return objEmit == IntrinsicsKt.f() ? objEmit : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.interaction.MutableInteractionSource
    public boolean b(Interaction interaction) {
        return c().c(interaction);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public MutableSharedFlow c() {
        return this.f6509a;
    }
}
