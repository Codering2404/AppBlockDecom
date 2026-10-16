package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeButtonState;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePowerConnectionEvent$1;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePowerConnectionEvent$1", f = "StrictMode3ViewModel.kt", l = {244, 246, 246}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$observePowerConnectionEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f121255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121256c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePowerConnectionEvent$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StrictMode3ViewModel f121257a;

        AnonymousClass1(StrictMode3ViewModel strictMode3ViewModel) {
            this.f121257a = strictMode3ViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final StrictMode3ViewState f(boolean z2, StrictMode3ViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return StrictMode3ViewState.b(updateState, StrictMode3ViewState.ActiveState.b(updateState.g(), null, z2 || updateState.g().e() == StrictModeState.Standby, false, false, z2 ? StrictModeButtonState.Deactivate : StrictModeButtonState.ConnectCharger, 13, null), null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, null, null, null, 0L, 2097150, null);
        }

        public final Object b(final boolean z2, Continuation continuation) {
            StrictMode3ViewState strictMode3ViewStateH1 = StrictMode3ViewModel.h1(this.f121257a);
            StrictMode3ViewModel strictMode3ViewModel = this.f121257a;
            if ((strictMode3ViewStateH1.g().e() == StrictModeState.Active || strictMode3ViewStateH1.g().e() == StrictModeState.Standby) && strictMode3ViewStateH1.e().contains(StrictModeAccessMethod.Charger)) {
                strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.q3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ViewModel$observePowerConnectionEvent$1.AnonymousClass1.f(z2, (StrictMode3ViewState) obj);
                    }
                });
            }
            return Unit.f139807a;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return b(((Boolean) obj).booleanValue(), continuation);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$observePowerConnectionEvent$1(StrictMode3ViewModel strictMode3ViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121256c = strictMode3ViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StrictMode3ViewModel$observePowerConnectionEvent$1 strictMode3ViewModel$observePowerConnectionEvent$1 = new StrictMode3ViewModel$observePowerConnectionEvent$1(this.f121256c, continuation);
        strictMode3ViewModel$observePowerConnectionEvent$1.f121255b = obj;
        return strictMode3ViewModel$observePowerConnectionEvent$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        if (((kotlinx.coroutines.flow.StateFlow) r8).collect(r2, r7) != r1) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f121255b
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r7.f121254a
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L29
            if (r2 == r5) goto L25
            if (r2 == r4) goto L21
            if (r2 == r3) goto L1d
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1d:
            kotlin.ResultKt.b(r8)
            goto L7a
        L21:
            kotlin.ResultKt.b(r8)
            goto L62
        L25:
            kotlin.ResultKt.b(r8)
            goto L49
        L29:
            kotlin.ResultKt.b(r8)
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r8 = r7.f121256c
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r8 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.m1(r8)
            cz.mobilesoft.coreblock.util.runnability.BatteryChargerHelper r2 = cz.mobilesoft.coreblock.util.runnability.BatteryChargerHelper.f129457a
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r6 = r7.f121256c
            android.content.Context r6 = r6.A0()
            boolean r2 = r2.a(r6)
            r7.f121255b = r0
            r7.f121254a = r5
            java.lang.Object r8 = r8.i2(r2, r7)
            if (r8 != r1) goto L49
            goto L79
        L49:
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r8 = r7.f121256c
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r8 = cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel.m1(r8)
            kotlinx.coroutines.flow.Flow r8 = r8.b1()
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r7.f121255b = r2
            r7.f121254a = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.g0(r8, r0, r7)
            if (r8 != r1) goto L62
            goto L79
        L62:
            kotlinx.coroutines.flow.StateFlow r8 = (kotlinx.coroutines.flow.StateFlow) r8
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePowerConnectionEvent$1$1 r2 = new cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePowerConnectionEvent$1$1
            cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel r4 = r7.f121256c
            r2.<init>(r4)
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r7.f121255b = r0
            r7.f121254a = r3
            java.lang.Object r8 = r8.collect(r2, r7)
            if (r8 != r1) goto L7a
        L79:
            return r1
        L7a:
            kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$observePowerConnectionEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$observePowerConnectionEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
