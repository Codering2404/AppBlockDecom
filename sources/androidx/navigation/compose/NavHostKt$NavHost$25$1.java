package androidx.navigation.compose;

import androidx.activity.BackEventCompat;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$25$1", f = "NavHost.kt", l = {524, 534}, m = "invokeSuspend")
final class NavHostKt$NavHost$25$1 extends SuspendLambda implements Function2<Flow<? extends BackEventCompat>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f49094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ComposeNavigator f49095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ State f49096d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableFloatState f49097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f49098g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$25$1(ComposeNavigator composeNavigator, State state, MutableFloatState mutableFloatState, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f49095c = composeNavigator;
        this.f49096d = state;
        this.f49097f = mutableFloatState;
        this.f49098g = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        NavHostKt$NavHost$25$1 navHostKt$NavHost$25$1 = new NavHostKt$NavHost$25$1(this.f49095c, this.f49096d, this.f49097f, this.f49098g, continuation);
        navHostKt$NavHost$25$1.f49094b = obj;
        return navHostKt$NavHost$25$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Flow flow, Continuation continuation) {
        return ((NavHostKt$NavHost$25$1) create(flow, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
    
        if (r8.collect(r1, r7) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f49093a
            r2 = 1
            r3 = 0
            r4 = 2
            if (r1 == 0) goto L27
            if (r1 == r2) goto L23
            if (r1 != r4) goto L1b
            java.lang.Object r0 = r7.f49094b
            androidx.navigation.NavBackStackEntry r0 = (androidx.navigation.NavBackStackEntry) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L18
            goto L90
        L18:
            r8 = move-exception
            goto L9d
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L23:
            kotlin.ResultKt.b(r8)
            goto L45
        L27:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.f49094b
            kotlinx.coroutines.flow.Flow r8 = (kotlinx.coroutines.flow.Flow) r8
            androidx.compose.runtime.State r1 = r7.f49096d
            java.util.List r1 = androidx.navigation.compose.NavHostKt.W(r1)
            int r1 = r1.size()
            if (r1 >= r4) goto L48
            androidx.navigation.compose.NavHostKt$NavHost$25$1$1 r1 = new kotlinx.coroutines.flow.FlowCollector() { // from class: androidx.navigation.compose.NavHostKt$NavHost$25$1.1
                static {
                    /*
                        androidx.navigation.compose.NavHostKt$NavHost$25$1$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$25$1$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.navigation.compose.NavHostKt$NavHost$25$1$1) androidx.navigation.compose.NavHostKt$NavHost$25$1.1.a androidx.navigation.compose.NavHostKt$NavHost$25$1$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$25$1.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$25$1.AnonymousClass1.<init>():void");
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final java.lang.Object emit(androidx.activity.BackEventCompat r1, kotlin.coroutines.Continuation r2) {
                    /*
                        r0 = this;
                        kotlin.Unit r1 = kotlin.Unit.f139807a
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$25$1.AnonymousClass1.emit(androidx.activity.BackEventCompat, kotlin.coroutines.Continuation):java.lang.Object");
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ java.lang.Object emit(java.lang.Object r1, kotlin.coroutines.Continuation r2) {
                    /*
                        r0 = this;
                        androidx.activity.BackEventCompat r1 = (androidx.activity.BackEventCompat) r1
                        java.lang.Object r1 = r0.emit(r1, r2)
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$25$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
            r7.f49093a = r2
            java.lang.Object r8 = r8.collect(r1, r7)
            if (r8 != r0) goto L45
            goto L8e
        L45:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L48:
            androidx.compose.runtime.MutableFloatState r1 = r7.f49097f
            r2 = 0
            androidx.navigation.compose.NavHostKt.Y(r1, r2)
            androidx.compose.runtime.State r1 = r7.f49096d
            java.util.List r1 = androidx.navigation.compose.NavHostKt.W(r1)
            java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r1)
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            androidx.navigation.compose.ComposeNavigator r2 = r7.f49095c
            r2.t(r1)
            androidx.compose.runtime.State r2 = r7.f49096d
            java.util.List r2 = androidx.navigation.compose.NavHostKt.W(r2)
            androidx.compose.runtime.State r5 = r7.f49096d
            java.util.List r5 = androidx.navigation.compose.NavHostKt.W(r5)
            int r5 = r5.size()
            int r5 = r5 - r4
            java.lang.Object r2 = r2.get(r5)
            androidx.navigation.NavBackStackEntry r2 = (androidx.navigation.NavBackStackEntry) r2
            androidx.navigation.compose.ComposeNavigator r5 = r7.f49095c
            r5.t(r2)
            androidx.navigation.compose.NavHostKt$NavHost$25$1$2 r2 = new androidx.navigation.compose.NavHostKt$NavHost$25$1$2     // Catch: java.lang.Throwable -> L18
            androidx.compose.runtime.MutableState r5 = r7.f49098g     // Catch: java.lang.Throwable -> L18
            androidx.compose.runtime.MutableFloatState r6 = r7.f49097f     // Catch: java.lang.Throwable -> L18
            r2.<init>()     // Catch: java.lang.Throwable -> L18
            r7.f49094b = r1     // Catch: java.lang.Throwable -> L18
            r7.f49093a = r4     // Catch: java.lang.Throwable -> L18
            java.lang.Object r8 = r8.collect(r2, r7)     // Catch: java.lang.Throwable -> L18
            if (r8 != r0) goto L8f
        L8e:
            return r0
        L8f:
            r0 = r1
        L90:
            androidx.navigation.compose.ComposeNavigator r8 = r7.f49095c     // Catch: java.lang.Throwable -> L18
            r8.n(r0, r3)     // Catch: java.lang.Throwable -> L18
            androidx.compose.runtime.MutableState r8 = r7.f49098g
            androidx.navigation.compose.NavHostKt.a0(r8, r3)
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L9d:
            androidx.compose.runtime.MutableState r0 = r7.f49098g
            androidx.navigation.compose.NavHostKt.a0(r0, r3)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$25$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
