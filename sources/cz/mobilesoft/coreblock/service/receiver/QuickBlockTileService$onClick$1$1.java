package cz.mobilesoft.coreblock.service.receiver;

import android.service.quicksettings.Tile;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService$onClick$1$1", f = "QuickBlockTileService.kt", l = {81, 96, 106, 109, 112, 116, 120}, m = "invokeSuspend", v = 1)
final class QuickBlockTileService$onClick$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f123737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f123738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f123739d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f123740f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f123741g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ QuickBlockTileService f123742h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Tile f123743i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockTileService$onClick$1$1(QuickBlockTileService quickBlockTileService, Tile tile, Continuation continuation) {
        super(2, continuation);
        this.f123742h = quickBlockTileService;
        this.f123743i = tile;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new QuickBlockTileService$onClick$1$1(this.f123742h, this.f123743i, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0075, code lost:
    
        if (r3.w(r2, r18) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fd, code lost:
    
        if (r7.w(r6, r18) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x014c, code lost:
    
        if (r7.w(r6, r18) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0171, code lost:
    
        if (r7.y(true, r18) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x018b, code lost:
    
        if (r7.p(r18) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01a9, code lost:
    
        if (cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService.z(r7, false, r18, 1, null) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01d1, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r3, r4, r18) == r1) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01d3, code lost:
    
        return r1;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService$onClick$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((QuickBlockTileService$onClick$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
