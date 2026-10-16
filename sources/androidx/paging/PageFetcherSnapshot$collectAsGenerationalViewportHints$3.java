package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
@DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$collectAsGenerationalViewportHints$3", f = "PageFetcherSnapshot.kt", l = {}, m = "invokeSuspend")
final class PageFetcherSnapshot$collectAsGenerationalViewportHints$3 extends SuspendLambda implements Function3<GenerationalViewportHint, GenerationalViewportHint, Continuation<? super GenerationalViewportHint>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f50120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f50121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LoadType f50122d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcherSnapshot$collectAsGenerationalViewportHints$3(LoadType loadType, Continuation continuation) {
        super(3, continuation);
        this.f50122d = loadType;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(GenerationalViewportHint generationalViewportHint, GenerationalViewportHint generationalViewportHint2, Continuation continuation) {
        PageFetcherSnapshot$collectAsGenerationalViewportHints$3 pageFetcherSnapshot$collectAsGenerationalViewportHints$3 = new PageFetcherSnapshot$collectAsGenerationalViewportHints$3(this.f50122d, continuation);
        pageFetcherSnapshot$collectAsGenerationalViewportHints$3.f50120b = generationalViewportHint;
        pageFetcherSnapshot$collectAsGenerationalViewportHints$3.f50121c = generationalViewportHint2;
        return pageFetcherSnapshot$collectAsGenerationalViewportHints$3.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f50119a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) this.f50120b;
        GenerationalViewportHint generationalViewportHint2 = (GenerationalViewportHint) this.f50121c;
        return PageFetcherSnapshotKt.a(generationalViewportHint2, generationalViewportHint, this.f50122d) ? generationalViewportHint2 : generationalViewportHint;
    }
}
