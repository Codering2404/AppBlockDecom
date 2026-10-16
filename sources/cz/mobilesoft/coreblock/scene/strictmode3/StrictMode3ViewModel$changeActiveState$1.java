package cz.mobilesoft.coreblock.scene.strictmode3;

import com.facebook.stetho.websocket.CloseCodes;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$changeActiveState$1", f = "StrictMode3ViewModel.kt", l = {996, CloseCodes.CLOSED_ABNORMALLY, 1008, 1020}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$changeActiveState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f121232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f121233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f121234c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121235d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f121236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f121237g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$changeActiveState$1(boolean z2, StrictMode3ViewModel strictMode3ViewModel, boolean z3, boolean z4, Continuation continuation) {
        super(2, continuation);
        this.f121234c = z2;
        this.f121235d = strictMode3ViewModel;
        this.f121236f = z3;
        this.f121237g = z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState q(StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2095103, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$changeActiveState$1(this.f121234c, this.f121235d, this.f121236f, this.f121237g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0083, code lost:
    
        if (r1.P0(r2, r14) == r0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00da, code lost:
    
        if (r15.f(r1, r14) == r0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f A[PHI: r15
      0x006f: PHI (r15v19 java.lang.Object) = (r15v18 java.lang.Object), (r15v0 java.lang.Object) binds: [B:20:0x006c, B:12:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$changeActiveState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$changeActiveState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
