package androidx.paging;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
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
@DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", l = {307, 370, 382, 388, RCHTTPStatusCodes.BAD_REQUEST, 409, 431, 440, 453, 464}, m = "onInsert")
final class SeparatorState$onInsert$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f50588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f50589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f50590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f50591d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f50592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f50593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f50594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f50595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f50596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f50597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f50598l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f50599m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f50600n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f50601o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    /* synthetic */ Object f50602p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final /* synthetic */ SeparatorState f50603q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f50604r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeparatorState$onInsert$1(SeparatorState separatorState, Continuation continuation) {
        super(continuation);
        this.f50603q = separatorState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50602p = obj;
        this.f50604r |= Integer.MIN_VALUE;
        return this.f50603q.d(null, this);
    }
}
