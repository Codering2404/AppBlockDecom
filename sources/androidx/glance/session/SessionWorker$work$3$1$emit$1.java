package androidx.glance.session;

import androidx.glance.session.SessionWorker$work$3;
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
@DebugMetadata(c = "androidx.glance.session.SessionWorker$work$3$1", f = "SessionWorker.kt", l = {136, 143}, m = "emit")
final class SessionWorker$work$3$1$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f39652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f39653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SessionWorker$work$3.AnonymousClass1 f39654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f39655d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SessionWorker$work$3$1$emit$1(SessionWorker$work$3.AnonymousClass1 anonymousClass1, Continuation continuation) {
        super(continuation);
        this.f39654c = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f39653b = obj;
        this.f39655d |= Integer.MIN_VALUE;
        return this.f39654c.emit(null, this);
    }
}
