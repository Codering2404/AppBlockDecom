package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.ui.platform.PlatformTextInputSession;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2", f = "LegacyPlatformTextInputServiceAdapter.android.kt", l = {125}, m = "invokeSuspend")
final class AndroidLegacyPlatformTextInputServiceAdapter$startInput$2 extends SuspendLambda implements Function2<PlatformTextInputSession, Continuation<?>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f10185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f10186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f10187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter f10188d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode f10189f;

    /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", l = {149}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f10191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PlatformTextInputSession f10192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f10193d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter f10194f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode f10195g;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1", f = "LegacyPlatformTextInputServiceAdapter.android.kt", l = {140, 141}, m = "invokeSuspend")
        static final class C00261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f10196a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AndroidLegacyPlatformTextInputServiceAdapter f10197b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ InputMethodManager f10198c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00261(AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, InputMethodManager inputMethodManager, Continuation continuation) {
                super(2, continuation);
                this.f10197b = androidLegacyPlatformTextInputServiceAdapter;
                this.f10198c = inputMethodManager;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Object obj, Continuation continuation) {
                return new C00261(this.f10197b, this.f10198c, continuation);
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
            
                if (r5.collect(r1, r4) == r0) goto L17;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
                /*
                    r4 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                    int r1 = r4.f10196a
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 == r2) goto L16
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L16:
                    kotlin.ResultKt.b(r5)
                    goto L44
                L1a:
                    kotlin.ResultKt.b(r5)
                    goto L2c
                L1e:
                    kotlin.ResultKt.b(r5)
                    androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1 r5 = new kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit>() { // from class: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.1
                        static {
                            /*
                                androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1 r0 = new androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1
                                r0.<init>()
                                
                                // error: 0x0005: SPUT (r0 I:androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1) androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.startInput.2.1.1.1.a androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$1
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00261.C00271.<clinit>():void");
                        }

                        {
                            /*
                                r1 = this;
                                r0 = 1
                                r1.<init>(r0)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00261.C00271.<init>():void");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ java.lang.Object invoke(java.lang.Object r3) {
                            /*
                                r2 = this;
                                java.lang.Number r3 = (java.lang.Number) r3
                                long r0 = r3.longValue()
                                r2.c(r0)
                                kotlin.Unit r3 = kotlin.Unit.f139807a
                                return r3
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00261.C00271.invoke(java.lang.Object):java.lang.Object");
                        }

                        public final void c(long r1) {
                            /*
                                r0 = this;
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00261.C00271.c(long):void");
                        }
                    }
                    r4.f10196a = r3
                    java.lang.Object r5 = androidx.compose.runtime.MonotonicFrameClockKt.b(r5, r4)
                    if (r5 != r0) goto L2c
                    goto L43
                L2c:
                    androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter r5 = r4.f10197b
                    kotlinx.coroutines.flow.MutableSharedFlow r5 = androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter.m(r5)
                    if (r5 == 0) goto L4a
                    androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$2 r1 = new androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$1$2
                    androidx.compose.foundation.text.input.internal.InputMethodManager r3 = r4.f10198c
                    r1.<init>()
                    r4.f10196a = r2
                    java.lang.Object r5 = r5.collect(r1, r4)
                    if (r5 != r0) goto L44
                L43:
                    return r0
                L44:
                    kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
                    r5.<init>()
                    throw r5
                L4a:
                    kotlin.Unit r5 = kotlin.Unit.f139807a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.AndroidLegacyPlatformTextInputServiceAdapter$startInput$2.AnonymousClass1.C00261.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((C00261) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlatformTextInputSession platformTextInputSession, Function1 function1, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, Continuation continuation) {
            super(2, continuation);
            this.f10192c = platformTextInputSession;
            this.f10193d = function1;
            this.f10194f = androidLegacyPlatformTextInputServiceAdapter;
            this.f10195g = legacyPlatformTextInputNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10192c, this.f10193d, this.f10194f, this.f10195g, continuation);
            anonymousClass1.f10191b = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f10190a;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.f10191b;
                    InputMethodManager inputMethodManager = (InputMethodManager) LegacyPlatformTextInputServiceAdapter_androidKt.c().invoke(this.f10192c.a());
                    LegacyTextInputMethodRequest legacyTextInputMethodRequest = new LegacyTextInputMethodRequest(this.f10192c.a(), new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2$1$request$1(this.f10195g), inputMethodManager);
                    if (StylusHandwriting_androidKt.a()) {
                        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new C00261(this.f10194f, inputMethodManager, null), 3, null);
                    }
                    Function1 function1 = this.f10193d;
                    if (function1 != null) {
                        function1.invoke(legacyTextInputMethodRequest);
                    }
                    this.f10194f.f10178c = legacyTextInputMethodRequest;
                    PlatformTextInputSession platformTextInputSession = this.f10192c;
                    this.f10190a = 1;
                    if (platformTextInputSession.b(legacyTextInputMethodRequest, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                throw new KotlinNothingValueException();
            } catch (Throwable th) {
                this.f10194f.f10178c = null;
                throw th;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidLegacyPlatformTextInputServiceAdapter$startInput$2(Function1 function1, AndroidLegacyPlatformTextInputServiceAdapter androidLegacyPlatformTextInputServiceAdapter, LegacyPlatformTextInputServiceAdapter.LegacyPlatformTextInputNode legacyPlatformTextInputNode, Continuation continuation) {
        super(2, continuation);
        this.f10187c = function1;
        this.f10188d = androidLegacyPlatformTextInputServiceAdapter;
        this.f10189f = legacyPlatformTextInputNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AndroidLegacyPlatformTextInputServiceAdapter$startInput$2 androidLegacyPlatformTextInputServiceAdapter$startInput$2 = new AndroidLegacyPlatformTextInputServiceAdapter$startInput$2(this.f10187c, this.f10188d, this.f10189f, continuation);
        androidLegacyPlatformTextInputServiceAdapter$startInput$2.f10186b = obj;
        return androidLegacyPlatformTextInputServiceAdapter$startInput$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PlatformTextInputSession platformTextInputSession, Continuation continuation) {
        return ((AndroidLegacyPlatformTextInputServiceAdapter$startInput$2) create(platformTextInputSession, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f10185a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1((PlatformTextInputSession) this.f10186b, this.f10187c, this.f10188d, this.f10189f, null);
            this.f10185a = 1;
            if (CoroutineScopeKt.f(anonymousClass1, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
