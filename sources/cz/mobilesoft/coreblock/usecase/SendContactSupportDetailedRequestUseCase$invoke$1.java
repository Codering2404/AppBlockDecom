package cz.mobilesoft.coreblock.usecase;

import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$invoke$1", f = "SendContactSupportDetailedRequestUseCase.kt", l = {62, 66, 67, 68, 69, 78, 104, 113, 123, 124, 125, 126, 193, 199, 203}, m = "invokeSuspend", v = 1)
final class SendContactSupportDetailedRequestUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super ViewModelState>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f127281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f127282d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f127283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f127284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f127285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f127286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f127287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f127288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f127289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f127290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Object f127291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    Object f127292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    long f127293p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    long f127294q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    long f127295r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    int f127296s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f127297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private /* synthetic */ Object f127298u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ SendContactSupportDetailedRequestUseCase f127299v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final /* synthetic */ SendContactSupportDetailedRequestUseCase.Params f127300w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f127301a;

        static {
            int[] iArr = new int[ContactReason.values().length];
            try {
                iArr[ContactReason.FeatureSuggestion.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f127301a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SendContactSupportDetailedRequestUseCase$invoke$1(SendContactSupportDetailedRequestUseCase sendContactSupportDetailedRequestUseCase, SendContactSupportDetailedRequestUseCase.Params params, Continuation continuation) {
        super(2, continuation);
        this.f127299v = sendContactSupportDetailedRequestUseCase;
        this.f127300w = params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence q(long j3) {
        return String.valueOf(j3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SendContactSupportDetailedRequestUseCase$invoke$1 sendContactSupportDetailedRequestUseCase$invoke$1 = new SendContactSupportDetailedRequestUseCase$invoke$1(this.f127299v, this.f127300w, continuation);
        sendContactSupportDetailedRequestUseCase$invoke$1.f127298u = obj;
        return sendContactSupportDetailedRequestUseCase$invoke$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0766  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0875  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0923  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0998  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x09cd  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0a33  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0a38  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0a93  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0a9b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0aa0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0ab4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0ac2  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0ac8  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0b03 A[LOOP:0: B:166:0x0afd->B:168:0x0b03, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0323 A[PHI: r0
      0x0323: PHI (r0v12 long) = (r0v10 long), (r0v23 long) binds: [B:42:0x03cf, B:15:0x031e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0b50  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0c3f  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0c56  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0cd3  */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0370 A[PHI: r0
      0x0370: PHI (r0v6 long) = (r0v5 long), (r0v7 long) binds: [B:25:0x036d, B:19:0x0338] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0380 A[PHI: r0
      0x0380: PHI (r0v8 long) = (r0v6 long), (r0v9 long) binds: [B:28:0x037d, B:18:0x0332] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x039a A[PHI: r0 r2 r4
      0x039a: PHI (r0v10 long) = (r0v8 long), (r0v11 long) binds: [B:31:0x0397, B:17:0x0326] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r2v6 cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase) = 
      (r2v5 cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase)
      (r2v11 cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase)
     binds: [B:31:0x0397, B:17:0x0326] A[DONT_GENERATE, DONT_INLINE]
      0x039a: PHI (r4v6 java.lang.Object) = (r4v5 java.lang.Object), (r4v13 java.lang.Object) binds: [B:31:0x0397, B:17:0x0326] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x052b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x06d2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r43) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$invoke$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((SendContactSupportDetailedRequestUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
