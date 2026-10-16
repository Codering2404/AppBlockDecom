package cz.mobilesoft.coreblock.scene.selection;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.BlockingSelectViewModel", f = "BlockingSelectViewModel.kt", l = {93, 94}, m = "tryShowBrowsersForWebAllowlistBottomSheet", v = 1)
final class BlockingSelectViewModel$tryShowBrowsersForWebAllowlistBottomSheet$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f118074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f118075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f118076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f118077d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f118078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f118079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f118080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f118081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f118082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f118083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f118084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f118085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f118086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f118087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    /* synthetic */ Object f118088p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ BlockingSelectViewModel f118089q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f118090r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockingSelectViewModel$tryShowBrowsersForWebAllowlistBottomSheet$1(BlockingSelectViewModel blockingSelectViewModel, Continuation continuation) {
        super(continuation);
        this.f118089q = blockingSelectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f118088p = obj;
        this.f118090r |= Integer.MIN_VALUE;
        return this.f118089q.a3(null, this);
    }
}
