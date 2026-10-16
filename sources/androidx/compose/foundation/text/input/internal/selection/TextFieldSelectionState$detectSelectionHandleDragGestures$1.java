package androidx.compose.foundation.text.input.internal.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", l = {984}, m = "detectSelectionHandleDragGestures")
final class TextFieldSelectionState$detectSelectionHandleDragGestures$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f10845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f10846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f10847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f10848d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f10849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ TextFieldSelectionState f10850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f10851h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectSelectionHandleDragGestures$1(TextFieldSelectionState textFieldSelectionState, Continuation continuation) {
        super(continuation);
        this.f10850g = textFieldSelectionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10849f = obj;
        this.f10851h |= Integer.MIN_VALUE;
        return this.f10850g.O(null, false, this);
    }
}
