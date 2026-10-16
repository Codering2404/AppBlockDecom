package cz.mobilesoft.coreblock.scene.password;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onContinueClicked$1", f = "BasePassCodeViewModel.kt", l = {93, 104, 105, 106, 108, 113, 114, 115, 116, 118, 123, 124, 125, 126, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD}, m = "invokeSuspend", v = 1)
final class BasePassCodeViewModel$onContinueClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f111647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f111648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BasePassCodeViewModel f111649c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f111650a;

        static {
            int[] iArr = new int[PassCodeStep.values().length];
            try {
                iArr[PassCodeStep.Create.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PassCodeStep.Confirm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PassCodeStep.Check.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PassCodeStep.Remove.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f111650a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BasePassCodeViewModel$onContinueClicked$1(BasePassCodeViewModel basePassCodeViewModel, Continuation continuation) {
        super(2, continuation);
        this.f111649c = basePassCodeViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewState y(PassCodeViewState passCodeViewState, PassCodeViewState passCodeViewState2) {
        return PassCodeViewState.b(passCodeViewState2, PassCodeStep.Confirm, "", passCodeViewState.e(), false, 0, 0L, null, 120, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewState z(PassCodeViewState passCodeViewState) {
        return PassCodeViewState.b(passCodeViewState, PassCodeStep.Create, null, null, false, 0, 0L, null, 126, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BasePassCodeViewModel$onContinueClicked$1(this.f111649c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f7, code lost:
    
        if (r10.P0(r2, r9) != r0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010b, code lost:
    
        if (cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.e1(r10, false, r9, 1, null) == r0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0168, code lost:
    
        if (r10.P0(r2, r9) != r0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x017c, code lost:
    
        if (cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.e1(r10, false, r9, 1, null) == r0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01ca, code lost:
    
        if (r10.P0(r3, r9) != r0) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01dc, code lost:
    
        if (cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.e1(r10, false, r9, 1, null) == r0) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00de A[PHI: r1
      0x00de: PHI (r1v33 cz.mobilesoft.coreblock.scene.password.PassCodeViewState) = 
      (r1v30 cz.mobilesoft.coreblock.scene.password.PassCodeViewState)
      (r1v37 cz.mobilesoft.coreblock.scene.password.PassCodeViewState)
     binds: [B:33:0x00da, B:7:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014f A[PHI: r1
      0x014f: PHI (r1v20 cz.mobilesoft.coreblock.scene.password.PassCodeViewState) = 
      (r1v17 cz.mobilesoft.coreblock.scene.password.PassCodeViewState)
      (r1v24 cz.mobilesoft.coreblock.scene.password.PassCodeViewState)
     binds: [B:52:0x014b, B:11:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b3 A[PHI: r1
      0x01b3: PHI (r1v8 cz.mobilesoft.coreblock.scene.password.PassCodeViewState) = 
      (r1v5 cz.mobilesoft.coreblock.scene.password.PassCodeViewState)
      (r1v11 cz.mobilesoft.coreblock.scene.password.PassCodeViewState)
     binds: [B:67:0x01b0, B:15:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$onContinueClicked$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BasePassCodeViewModel$onContinueClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
