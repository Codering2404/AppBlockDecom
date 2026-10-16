package androidx.paging;

import androidx.paging.SingleRunner;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.SingleRunner$Holder", f = "SingleRunner.kt", l = {131}, m = "onFinish")
final class SingleRunner$Holder$onFinish$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f50668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f50669d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SingleRunner.Holder f50670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f50671g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleRunner$Holder$onFinish$1(SingleRunner.Holder holder, Continuation continuation) {
        super(continuation);
        this.f50670f = holder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50669d = obj;
        this.f50671g |= Integer.MIN_VALUE;
        return this.f50670f.a(null, this);
    }
}
