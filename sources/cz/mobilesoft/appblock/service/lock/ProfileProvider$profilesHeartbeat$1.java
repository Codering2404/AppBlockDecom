package cz.mobilesoft.appblock.service.lock;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.ProfileProvider$profilesHeartbeat$1", f = "ProfileProvider.kt", l = {95, 97, 98}, m = "invokeSuspend", v = 1)
final class ProfileProvider$profilesHeartbeat$1 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f94885b;

    ProfileProvider$profilesHeartbeat$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ProfileProvider$profilesHeartbeat$1 profileProvider$profilesHeartbeat$1 = new ProfileProvider$profilesHeartbeat$1(continuation);
        profileProvider$profilesHeartbeat$1.f94885b = obj;
        return profileProvider$profilesHeartbeat$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004e -> B:15:0x0036). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f94885b
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r7.f94884a
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L26
            if (r2 == r5) goto L22
            if (r2 == r4) goto L1e
            if (r2 != r3) goto L16
            goto L22
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            kotlin.ResultKt.b(r8)
            goto L44
        L22:
            kotlin.ResultKt.b(r8)
            goto L36
        L26:
            kotlin.ResultKt.b(r8)
            kotlin.Unit r8 = kotlin.Unit.f139807a
            r7.f94885b = r0
            r7.f94884a = r5
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r1) goto L36
            goto L50
        L36:
            r7.f94885b = r0
            r7.f94884a = r4
            r5 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r1) goto L44
            goto L50
        L44:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            r7.f94885b = r0
            r7.f94884a = r3
            java.lang.Object r8 = r0.emit(r8, r7)
            if (r8 != r1) goto L36
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.ProfileProvider$profilesHeartbeat$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector flowCollector, Continuation continuation) {
        return ((ProfileProvider$profilesHeartbeat$1) create(flowCollector, continuation)).invokeSuspend(Unit.f139807a);
    }
}
