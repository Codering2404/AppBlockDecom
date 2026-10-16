package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3", f = "MouseWheelScrollable.kt", l = {253, 266, 283}, m = "invokeSuspend")
final class MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5991d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f5992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f5993g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f5994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f5995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ float f5996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ MouseWheelScrollingLogic f5997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ float f5998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ ScrollingLogic f5999m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(Ref.FloatRef floatRef, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, float f3, MouseWheelScrollingLogic mouseWheelScrollingLogic, float f4, ScrollingLogic scrollingLogic, Continuation continuation) {
        super(2, continuation);
        this.f5993g = floatRef;
        this.f5994h = objectRef;
        this.f5995i = objectRef2;
        this.f5996j = f3;
        this.f5997k = mouseWheelScrollingLogic;
        this.f5998l = f4;
        this.f5999m = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MouseWheelScrollingLogic$dispatchMouseWheelScroll$3 mouseWheelScrollingLogic$dispatchMouseWheelScroll$3 = new MouseWheelScrollingLogic$dispatchMouseWheelScroll$3(this.f5993g, this.f5994h, this.f5995i, this.f5996j, this.f5997k, this.f5998l, this.f5999m, continuation);
        mouseWheelScrollingLogic$dispatchMouseWheelScroll$3.f5992f = obj;
        return mouseWheelScrollingLogic$dispatchMouseWheelScroll$3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(NestedScrollScope nestedScrollScope, Continuation continuation) {
        return ((MouseWheelScrollingLogic$dispatchMouseWheelScroll$3) create(nestedScrollScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x018e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x014f -> B:30:0x0151). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x015d -> B:13:0x0067). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
