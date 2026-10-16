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
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", l = {191, 197, 210, 216}, m = "invokeSuspend", v = 2)
final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f140067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f140068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f140069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f140070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f140071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f140072g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f140073h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f140074i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f140075j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f140076k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f140077l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f140078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f140079n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private /* synthetic */ Object f140080o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final /* synthetic */ PathTreeWalk f140081p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation continuation) {
        super(2, continuation);
        this.f140081p = pathTreeWalk;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.f140081p, continuation);
        pathTreeWalk$dfsIterator$1.f140080o = obj;
        return pathTreeWalk$dfsIterator$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x01ce, code lost:
    
        if (r1.a(r12, r17) == r2) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d4, code lost:
    
        continue;
     */
    /* JADX WARN: Path cross not found for [B:4:0x0013, B:15:0x00bf], limit reached: 84 */
    /* JADX WARN: Removed duplicated region for block: B:32:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0284  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 770
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope sequenceScope, Continuation continuation) {
        return ((PathTreeWalk$dfsIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
