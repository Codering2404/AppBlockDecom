package androidx.compose.ui.input.nestedscroll;

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
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.NestedScrollNode", f = "NestedScrollNode.kt", l = {96, 97}, m = "onPreFling-QWom1Mo")
final class NestedScrollNode$onPreFling$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f26765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f26766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f26767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NestedScrollNode f26768d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f26769f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NestedScrollNode$onPreFling$1(NestedScrollNode nestedScrollNode, Continuation continuation) {
        super(continuation);
        this.f26768d = nestedScrollNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f26767c = obj;
        this.f26769f |= Integer.MIN_VALUE;
        return this.f26768d.R1(0L, this);
    }
}
