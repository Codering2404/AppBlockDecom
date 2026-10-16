package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", l = {191, 197}, m = "invokeSuspend", v = 2)
final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f140057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f140058d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f140059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f140060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f140061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f140062i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f140063j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f140064k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private /* synthetic */ Object f140065l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ PathTreeWalk f140066m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PathTreeWalk$bfsIterator$1(PathTreeWalk pathTreeWalk, Continuation continuation) {
        super(2, continuation);
        this.f140066m = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PathTreeWalk$bfsIterator$1 pathTreeWalk$bfsIterator$1 = new PathTreeWalk$bfsIterator$1(this.f140066m, continuation);
        pathTreeWalk$bfsIterator$1.f140065l = obj;
        return pathTreeWalk$bfsIterator$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
    
        r2 = r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0127  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$bfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((PathTreeWalk$bfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
