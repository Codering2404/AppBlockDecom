package cz.mobilesoft.coreblock.scene.strictmode3.access;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.collections.immutable.ExtensionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$onAccessMethodClicked$1", f = "StrictModeAccessViewModel.kt", l = {72, 75, 79, 82, 85, 88}, m = "invokeSuspend", v = 1)
final class StrictModeAccessViewModel$onAccessMethodClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ StrictModeAccessMethod f121545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictModeAccessViewModel f121546c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeAccessViewModel$onAccessMethodClicked$1(StrictModeAccessMethod strictModeAccessMethod, StrictModeAccessViewModel strictModeAccessViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121545b = strictModeAccessMethod;
        this.f121546c = strictModeAccessViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictModeAccessViewState q(StrictModeAccessMethod strictModeAccessMethod, StrictModeAccessViewState strictModeAccessViewState) {
        return StrictModeAccessViewState.b(strictModeAccessViewState, strictModeAccessMethod, ExtensionsKt.a(), null, false, false, false, null, 124, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictModeAccessViewModel$onAccessMethodClicked$1(this.f121545b, this.f121546c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0045, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
    
        if (r6.P0(r2, r5) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b4, code lost:
    
        if (r6.f1(r5) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c8, code lost:
    
        if (r6.P0(r2, r5) == r0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ca, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeAccessViewModel$onAccessMethodClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictModeAccessViewModel$onAccessMethodClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
