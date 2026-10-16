package cz.mobilesoft.coreblock.scene.strictmode3;

import androidx.compose.runtime.MutableIntState;
import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt$AutoAdvanceVerticalSMInfoPager$2$1", f = "StrictMode3Overview.kt", l = {1052}, m = "invokeSuspend", v = 1)
final class StrictMode3OverviewKt$AutoAdvanceVerticalSMInfoPager$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f121103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableIntState f121104c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3OverviewKt$AutoAdvanceVerticalSMInfoPager$2$1(List list, MutableIntState mutableIntState, Continuation continuation) {
        super(2, continuation);
        this.f121103b = list;
        this.f121104c = mutableIntState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3OverviewKt$AutoAdvanceVerticalSMInfoPager$2$1(this.f121103b, this.f121104c, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:12:0x0025). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f121102a
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r6)
            goto L25
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.b(r6)
        L1a:
            r5.f121102a = r2
            r3 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
            if (r6 != r0) goto L25
            return r0
        L25:
            androidx.compose.runtime.MutableIntState r6 = r5.f121104c
            int r1 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt.s1(r6)
            int r1 = r1 + r2
            java.util.List r3 = r5.f121103b
            int r3 = r3.size()
            int r1 = r1 % r3
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt.t1(r6, r1)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3OverviewKt$AutoAdvanceVerticalSMInfoPager$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3OverviewKt$AutoAdvanceVerticalSMInfoPager$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
