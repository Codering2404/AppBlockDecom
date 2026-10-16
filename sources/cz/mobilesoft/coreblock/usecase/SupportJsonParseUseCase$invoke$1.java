package cz.mobilesoft.coreblock.usecase;

import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO;
import cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$invoke$1", f = "SupportJsonParseUseCase.kt", l = {70, 74, 77, 211, 212, 216, 209, 211, 212, 216, 211, 212, 216}, m = "invokeSuspend", v = 1)
final class SupportJsonParseUseCase$invoke$1 extends SuspendLambda implements Function2<ProducerScope<? super DataState<? extends Boolean>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f127348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ Object f127349d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ SupportJsonParseUseCase f127350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ SupportJsonParseUseCase.Params f127351g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$invoke$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$invoke$1$1", f = "SupportJsonParseUseCase.kt", l = {79, 124, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, 140, 143, 152, 163, 172, 185, 195, RCHTTPStatusCodes.CREATED, 202, 203, 206}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ ProducerScope A;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f127352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f127353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f127354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f127355d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f127356f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f127357g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f127358h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f127359i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f127360j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f127361k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f127362l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f127363m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f127364n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f127365o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f127366p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f127367q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        int f127368r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        int f127369s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int f127370t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        long f127371u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        long f127372v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        long f127373w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int f127374x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        final /* synthetic */ DiagnosticDTO f127375y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        final /* synthetic */ SupportJsonParseUseCase f127376z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DiagnosticDTO diagnosticDTO, SupportJsonParseUseCase supportJsonParseUseCase, ProducerScope producerScope, Continuation continuation) {
            super(1, continuation);
            this.f127375y = diagnosticDTO;
            this.f127376z = supportJsonParseUseCase;
            this.A = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f127375y, this.f127376z, this.A, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x052c  */
        /* JADX WARN: Removed duplicated region for block: B:109:0x0659  */
        /* JADX WARN: Removed duplicated region for block: B:111:0x0674  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x068d  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x06ae  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x0748  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x075a  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0810  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x081d  */
        /* JADX WARN: Removed duplicated region for block: B:160:0x08c8  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x08db  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x097d  */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0989  */
        /* JADX WARN: Removed duplicated region for block: B:185:0x0a1e  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x0a3e  */
        /* JADX WARN: Removed duplicated region for block: B:193:0x0a80  */
        /* JADX WARN: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:245:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0313 A[LOOP:8: B:35:0x030d->B:37:0x0313, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0339  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x051d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:183:0x0a13 -> B:184:0x0a16). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:185:0x0a1e -> B:39:0x0333). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r54) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 2866
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$invoke$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SupportJsonParseUseCase$invoke$1(SupportJsonParseUseCase supportJsonParseUseCase, SupportJsonParseUseCase.Params params, Continuation continuation) {
        super(2, continuation);
        this.f127350f = supportJsonParseUseCase;
        this.f127351g = params;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SupportJsonParseUseCase$invoke$1 supportJsonParseUseCase$invoke$1 = new SupportJsonParseUseCase$invoke$1(this.f127350f, this.f127351g, continuation);
        supportJsonParseUseCase$invoke$1.f127349d = obj;
        return supportJsonParseUseCase$invoke$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((SupportJsonParseUseCase$invoke$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x015a, code lost:
    
        if (cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore.K(r14, false, r13, 1, null) != r2) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01ed, code lost:
    
        if (cz.mobilesoft.coreblock.storage.datastore.QuickBlockDataStore.K(r14, false, r13, 1, null) != r2) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f6 A[PHI: r6
      0x00f6: PHI (r6v11 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO) = 
      (r6v9 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
      (r6v13 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
     binds: [B:34:0x00f2, B:20:0x0084] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0138 A[PHI: r0
      0x0138: PHI (r0v30 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO) = 
      (r0v27 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
      (r0v34 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
     binds: [B:41:0x0134, B:17:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ca A[PHI: r0
      0x01ca: PHI (r0v9 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO) = 
      (r0v8 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
      (r0v43 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
     binds: [B:54:0x01c6, B:9:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0238 A[PHI: r0 r6
      0x0238: PHI (r0v13 'th' java.lang.Throwable) = (r0v12 'th' java.lang.Throwable), (r0v47 'th' java.lang.Throwable) binds: [B:65:0x0235, B:7:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x0238: PHI (r6v6 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO) = 
      (r6v5 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
      (r6v21 cz.mobilesoft.coreblock.dto.diagnostic.DiagnosticDTO)
     binds: [B:65:0x0235, B:7:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.SupportJsonParseUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
